package androidx.appcompat.widget;

import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.view.CollapsibleActionView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.ViewCompat;
import androidx.cursoradapter.widget.CursorAdapter;
import androidx.customview.view.AbsSavedState;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import net.zetetic.database.sqlcipher.SQLiteDatabase;

/* JADX INFO: loaded from: classes.dex */
public class SearchView extends LinearLayoutCompat implements CollapsibleActionView {
    static final boolean DBG = false;
    private static final String IME_OPTION_NO_MICROPHONE = "nm";
    static final String LOG_TAG = "SearchView";
    static final PreQAutoCompleteTextViewReflector PRE_API_29_HIDDEN_METHOD_INVOKER = null;
    private Bundle mAppSearchData;
    private boolean mClearingFocus;
    final ImageView mCloseButton;
    private final ImageView mCollapsedIcon;
    private int mCollapsedImeOptions;
    private final CharSequence mDefaultQueryHint;
    private final View mDropDownAnchor;
    private boolean mExpandedInActionView;
    final ImageView mGoButton;
    private boolean mIconified;
    private boolean mIconifiedByDefault;
    private int mMaxWidth;
    private CharSequence mOldQueryText;
    private final View.OnClickListener mOnClickListener;
    private OnCloseListener mOnCloseListener;
    private final TextView.OnEditorActionListener mOnEditorActionListener;
    private final AdapterView.OnItemClickListener mOnItemClickListener;
    private final AdapterView.OnItemSelectedListener mOnItemSelectedListener;
    private OnQueryTextListener mOnQueryChangeListener;
    View.OnFocusChangeListener mOnQueryTextFocusChangeListener;
    private View.OnClickListener mOnSearchClickListener;
    private OnSuggestionListener mOnSuggestionListener;
    private final WeakHashMap<String, Drawable.ConstantState> mOutsideDrawablesCache;
    private CharSequence mQueryHint;
    private boolean mQueryRefinement;
    private Runnable mReleaseCursorRunnable;
    final ImageView mSearchButton;
    private final View mSearchEditFrame;
    private final Drawable mSearchHintIcon;
    private final View mSearchPlate;
    final SearchAutoComplete mSearchSrcTextView;
    private Rect mSearchSrcTextViewBounds;
    private Rect mSearchSrtTextViewBoundsExpanded;
    SearchableInfo mSearchable;
    private final View mSubmitArea;
    private boolean mSubmitButtonEnabled;
    private final int mSuggestionCommitIconResId;
    private final int mSuggestionRowLayout;
    CursorAdapter mSuggestionsAdapter;
    private int[] mTemp;
    private int[] mTemp2;
    View.OnKeyListener mTextKeyListener;
    private TextWatcher mTextWatcher;
    private UpdatableTouchDelegate mTouchDelegate;
    private final Runnable mUpdateDrawableStateRunnable;
    private CharSequence mUserQuery;
    private final Intent mVoiceAppSearchIntent;
    final ImageView mVoiceButton;
    private boolean mVoiceButtonEnabled;
    private final Intent mVoiceWebSearchIntent;

    static class Api29Impl {
        private Api29Impl() {
        }

        static void refreshAutoCompleteResults(AutoCompleteTextView r0) {
            r0.refreshAutoCompleteResults();
        }

        static void setInputMethodMode(SearchAutoComplete r0, int r1) {
            r0.setInputMethodMode(r1);
        }
    }

    public interface OnCloseListener {
        boolean onClose();
    }

    public interface OnQueryTextListener {
        boolean onQueryTextChange(String r1);

        boolean onQueryTextSubmit(String r1);
    }

    public interface OnSuggestionListener {
        boolean onSuggestionClick(int r1);

        boolean onSuggestionSelect(int r1);
    }

    private static class PreQAutoCompleteTextViewReflector {
        private Method mDoAfterTextChanged;
        private Method mDoBeforeTextChanged;
        private Method mEnsureImeVisible;

        PreQAutoCompleteTextViewReflector() {
            this.mDoBeforeTextChanged = null;
            this.mDoAfterTextChanged = null;
            this.mEnsureImeVisible = null;
            preApi29Check();
            Method r2 = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);     // Catch: NoSuchMethodException -> L7
            this.mDoBeforeTextChanged = r2;     // Catch: NoSuchMethodException -> L7
            r2.setAccessible(true);     // Catch: NoSuchMethodException -> L7
        L10:
            Method r3 = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);     // Catch: NoSuchMethodException -> L8
            this.mDoAfterTextChanged = r3;     // Catch: NoSuchMethodException -> L8
            r3.setAccessible(true);     // Catch: NoSuchMethodException -> L8
        L14:
            Method r0 = AutoCompleteTextView.class.getMethod("ensureImeVisible", new Class[]{Boolean.TYPE});     // Catch: NoSuchMethodException -> L9
            this.mEnsureImeVisible = r0;     // Catch: NoSuchMethodException -> L9
            r0.setAccessible(true);     // Catch: NoSuchMethodException -> L9
            return;
        }

        private static void preApi29Check() {
            if (Build.VERSION.SDK_INT >= 29) goto L6;
            return;
        L6:
            throw new UnsupportedClassVersionError("This function can only be used for API Level < 29.");
        }

        void doAfterTextChanged(AutoCompleteTextView r2) {
            preApi29Check();
            Method r1 = this.mDoAfterTextChanged;
            if (r1 != null) goto L8;
            return;
        L8:
            r1.invoke(r2, new Object[0]);     // Catch: Exception -> L7
            return;
        }

        void doBeforeTextChanged(AutoCompleteTextView r2) {
            preApi29Check();
            Method r1 = this.mDoBeforeTextChanged;
            if (r1 != null) goto L8;
            return;
        L8:
            r1.invoke(r2, new Object[0]);     // Catch: Exception -> L7
            return;
        }

        void ensureImeVisible(AutoCompleteTextView r4) {
            preApi29Check();
            Method r3 = this.mEnsureImeVisible;
            if (r3 != null) goto L8;
            return;
        L8:
            r3.invoke(r4, new Object[]{true});     // Catch: Exception -> L7
            return;
        }
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        boolean isIconified;

        static {
            CREATOR = new AnonymousClass1();
        }

        public SavedState(Parcel r2, ClassLoader r3) {
            super(r2, r3);
            this.isIconified = ((Boolean) ZeusTransformUtils.preCheckCast(r2.readValue(null), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        }

        SavedState(Parcelable r3) {
            super((Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.memorydata.plugin"));
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.isIconified + "}";
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            super.writeToParcel(r1, r2);
            r1.writeValue(Boolean.valueOf(this.isIconified));
        }
    }

    public static class SearchAutoComplete extends AppCompatAutoCompleteTextView {
        private boolean mHasPendingShowSoftInputRequest;
        final Runnable mRunShowSoftInputIfNecessary;
        private SearchView mSearchView;
        private int mThreshold;

        public SearchAutoComplete(Context r3) {
            this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), null);
        }

        public SearchAutoComplete(Context r4, AttributeSet r5) {
            this((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.attr.autoCompleteTextViewStyle, "attr", "autoCompleteTextViewStyle"));
        }

        public SearchAutoComplete(Context r3, AttributeSet r4, int r5) {
            super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"), r5);
            this.mRunShowSoftInputIfNecessary = new AnonymousClass1(this);
            this.mThreshold = getThreshold();
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration r3 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getConfiguration();
            int r0 = r3.screenWidthDp;
            int r1 = r3.screenHeightDp;
            if (r0 < 960) goto L11;
            if (r1 < 720) goto L11;
            if (r3.orientation != 2) goto L11;
            return 256;
        L11:
            if (r0 < 600) goto L13;
            return 192;
        L13:
            if (r0 >= 640) goto L15;
            return 160;
        L15:
            if (r1 >= 480) goto L22;
            return 160;
        L22:
            return 192;
        }

        @Override // android.widget.AutoCompleteTextView
        public boolean enoughToFilter() {
            if (this.mThreshold > 0) goto L5;
        L8:
            return true;
        L5:
            if (super.enoughToFilter() == true) goto L8;
            return false;
        }

        void ensureImeVisible() {
            if (Build.VERSION.SDK_INT < 29) goto L7;
            Api29Impl.setInputMethodMode(this, 1);
            if (enoughToFilter() == false) goto L9;
            showDropDown();
            return;
        L9:
            return;
        L7:
            SearchView.PRE_API_29_HIDDEN_METHOD_INVOKER.ensureImeVisible(this);
        }

        boolean isEmpty() {
            if (TextUtils.getTrimmedLength(getText()) != 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // androidx.appcompat.widget.AppCompatAutoCompleteTextView, android.widget.TextView, android.view.View
        public InputConnection onCreateInputConnection(EditorInfo r2) {
            InputConnection r3 = super.onCreateInputConnection(r2);
            if (this.mHasPendingShowSoftInputRequest == false) goto L5;
            removeCallbacks(this.mRunShowSoftInputIfNecessary);
            post(this.mRunShowSoftInputIfNecessary);
        L5:
            return r3;
        }

        @Override // android.view.View
        public void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDisplayMetrics()));
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onFocusChanged(boolean r1, int r2, Rect r3) {
            super.onFocusChanged(r1, r2, r3);
            this.mSearchView.onTextFocusChanged();
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public boolean onKeyPreIme(int r3, KeyEvent r4) {
            if (r3 != 4) goto L24;
            if (r4.getAction() != 0) goto L13;
            if (r4.getRepeatCount() != 0) goto L13;
            KeyEvent.DispatcherState r5 = getKeyDispatcherState();
            if (r5 == null) goto L11;
            r5.startTracking(r4, this);
        L11:
            return true;
        L13:
            if (r4.getAction() != 1) goto L24;
            KeyEvent.DispatcherState r0 = getKeyDispatcherState();
            if (r0 == null) goto L18;
            r0.handleUpEvent(r4);
        L18:
            if (r4.isTracking() == false) goto L24;
            if (r4.isCanceled() == true) goto L24;
            this.mSearchView.clearFocus();
            setImeVisibility(false);
            return true;
        L24:
            return super.onKeyPreIme(r3, r4);
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onWindowFocusChanged(boolean r3) {
            super.onWindowFocusChanged(r3);
            if (r3 == true) goto L5;
            return;
        L5:
            if (this.mSearchView.hasFocus() == true) goto L7;
            return;
        L7:
            if (getVisibility() != 0) goto L14;
            this.mHasPendingShowSoftInputRequest = true;
            if (SearchView.isLandscapeMode((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == false) goto L15;
            ensureImeVisible();
            return;
        L15:
            return;
        }

        @Override // android.widget.AutoCompleteTextView
        public void performCompletion() {
        }

        @Override // android.widget.AutoCompleteTextView
        public void replaceText(CharSequence r2) {
            CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        }

        void setImeVisibility(boolean r4) {
            InputMethodManager r0 = (InputMethodManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("input_method"), InputMethodManager.class, "com.obric.memorydata.plugin");
            if (r4 == true) goto L7;
            this.mHasPendingShowSoftInputRequest = false;
            removeCallbacks(this.mRunShowSoftInputIfNecessary);
            r0.hideSoftInputFromWindow(getWindowToken(), 0);
            return;
        L7:
            if (r0.isActive(this) == false) goto L10;
            this.mHasPendingShowSoftInputRequest = false;
            removeCallbacks(this.mRunShowSoftInputIfNecessary);
            r0.showSoftInput(this, 0);
            return;
        L10:
            this.mHasPendingShowSoftInputRequest = true;
        }

        void setSearchView(SearchView r1) {
            this.mSearchView = r1;
        }

        @Override // android.widget.AutoCompleteTextView
        public void setThreshold(int r1) {
            super.setThreshold(r1);
            this.mThreshold = r1;
        }

        void showSoftInputIfNecessary() {
            if (this.mHasPendingShowSoftInputRequest == false) goto L6;
            ((InputMethodManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("input_method"), InputMethodManager.class, "com.obric.memorydata.plugin")).showSoftInput(this, 0);
            this.mHasPendingShowSoftInputRequest = false;
            return;
        }
    }

    private static class UpdatableTouchDelegate extends TouchDelegate {
        private final Rect mActualBounds;
        private boolean mDelegateTargeted;
        private final View mDelegateView;
        private final int mSlop;
        private final Rect mSlopBounds;
        private final Rect mTargetBounds;

        public UpdatableTouchDelegate(Rect r4, Rect r5, View r6) {
            super(r4, r6);
            this.mSlop = ViewConfiguration.get((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getScaledTouchSlop();
            this.mTargetBounds = new Rect();
            this.mSlopBounds = new Rect();
            this.mActualBounds = new Rect();
            setBounds(r4, r5);
            this.mDelegateView = r6;
        }

        @Override // android.view.TouchDelegate
        public boolean onTouchEvent(MotionEvent r9) {
            int r0 = (int) r9.getX();
            int r1 = (int) r9.getY();
            int r2 = r9.getAction();
            boolean r4 = true;
            if (r2 == 0) goto L17;
            if (r2 == 1) goto L10;
            if (r2 == 2) goto L10;
            if (r2 != 3) goto L19;
            boolean r3 = this.mDelegateTargeted;
            this.mDelegateTargeted = false;
        L15:
            r4 = r3;
            boolean r5 = true;
        L20:
            if (r4 == false) goto L28;
            if (r5 == true) goto L23;
        L25:
            float r6 = r0 - this.mActualBounds.left;
            int r7 = r1 - this.mActualBounds.top;
        L26:
            r9.setLocation(r6, r7);
            return this.mDelegateView.dispatchTouchEvent(r9);
        L23:
            if (this.mActualBounds.contains(r0, r1) == true) goto L25;
            r6 = this.mDelegateView.getWidth() / 2;
            r7 = this.mDelegateView.getHeight() / 2;
            goto L26
        L28:
            return false;
        L19:
            r5 = true;
            r4 = false;
        L10:
            r3 = this.mDelegateTargeted;
            if (r3 == false) goto L15;
            if (this.mSlopBounds.contains(r0, r1) == true) goto L15;
            r4 = r3;
            r5 = false;
            goto L20
        L17:
            if (this.mTargetBounds.contains(r0, r1) == false) goto L19;
            this.mDelegateTargeted = true;
            r5 = true;
            goto L20
        }

        public void setBounds(Rect r3, Rect r4) {
            this.mTargetBounds.set(r3);
            this.mSlopBounds.set(r3);
            Rect r5 = this.mSlopBounds;
            int r0 = this.mSlop;
            r5.inset(-r0, -r0);
            this.mActualBounds.set(r4);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 29) goto L5;
        PreQAutoCompleteTextViewReflector r0 = new PreQAutoCompleteTextViewReflector();
    L6:
        PRE_API_29_HIDDEN_METHOD_INVOKER = r0;
        return;
    L5:
        r0 = null;
        goto L6
    }

    public SearchView(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), null);
    }

    public SearchView(Context r4, AttributeSet r5) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.attr.searchViewStyle, "attr", "searchViewStyle"));
    }

    public SearchView(Context r20, AttributeSet r21, int r22) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r20, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r3 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r21, AttributeSet.class, "com.obric.memorydata.plugin");
        super(r9, r3, r22);
        this.mSearchSrcTextViewBounds = new Rect();
        this.mSearchSrtTextViewBoundsExpanded = new Rect();
        this.mTemp = new int[2];
        this.mTemp2 = new int[2];
        this.mUpdateDrawableStateRunnable = new AnonymousClass1(this);
        this.mReleaseCursorRunnable = new AnonymousClass2(this);
        this.mOutsideDrawablesCache = new WeakHashMap();
        View.OnClickListener r10 = new AnonymousClass5(this);
        this.mOnClickListener = r10;
        this.mTextKeyListener = new AnonymousClass6(this);
        TextView.OnEditorActionListener r11 = new AnonymousClass7(this);
        this.mOnEditorActionListener = r11;
        AdapterView.OnItemClickListener r12 = new AnonymousClass8(this);
        this.mOnItemClickListener = r12;
        AdapterView.OnItemSelectedListener r13 = new AnonymousClass9(this);
        this.mOnItemSelectedListener = r13;
        this.mTextWatcher = new AnonymousClass10(this);
        TintTypedArray r15 = TintTypedArray.obtainStyledAttributes(r9, r3, R.styleable.SearchView, r22, 0);
        ViewCompat.saveAttributeDataForStyleable(this, r9, R.styleable.SearchView, r3, r15.getWrappedTypeArray(), r22, 0);
        ZeusTransformUtils.inflate(LayoutInflater.from(r9), r15.getResourceId(ZeusTransformUtils.mapRes(R.styleable.SearchView_layout, "styleable", "SearchView_layout"), ZeusTransformUtils.mapRes(R.layout.abc_search_view, "layout", "abc_search_view")), this, true, "com.obric.memorydata.plugin");
        SearchAutoComplete r0 = (SearchAutoComplete) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.search_src_text, OaidModel.KEY_ID, "search_src_text")), SearchAutoComplete.class, "com.obric.memorydata.plugin");
        this.mSearchSrcTextView = r0;
        r0.setSearchView(this);
        this.mSearchEditFrame = findViewById(ZeusTransformUtils.mapRes(R.id.search_edit_frame, OaidModel.KEY_ID, "search_edit_frame"));
        View r5 = findViewById(ZeusTransformUtils.mapRes(R.id.search_plate, OaidModel.KEY_ID, "search_plate"));
        this.mSearchPlate = r5;
        View r6 = findViewById(ZeusTransformUtils.mapRes(R.id.submit_area, OaidModel.KEY_ID, "submit_area"));
        this.mSubmitArea = r6;
        ImageView r4 = (ImageView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.search_button, OaidModel.KEY_ID, "search_button")), ImageView.class, "com.obric.memorydata.plugin");
        this.mSearchButton = r4;
        ImageView r14 = (ImageView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.search_go_btn, OaidModel.KEY_ID, "search_go_btn")), ImageView.class, "com.obric.memorydata.plugin");
        this.mGoButton = r14;
        ImageView r16 = (ImageView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.search_close_btn, OaidModel.KEY_ID, "search_close_btn")), ImageView.class, "com.obric.memorydata.plugin");
        this.mCloseButton = r16;
        ImageView r17 = (ImageView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.search_voice_btn, OaidModel.KEY_ID, "search_voice_btn")), ImageView.class, "com.obric.memorydata.plugin");
        this.mVoiceButton = r17;
        ImageView r1 = (ImageView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.search_mag_icon, OaidModel.KEY_ID, "search_mag_icon")), ImageView.class, "com.obric.memorydata.plugin");
        this.mCollapsedIcon = r1;
        ViewCompat.setBackground(r5, r15.getDrawable(ZeusTransformUtils.mapRes(R.styleable.SearchView_queryBackground, "styleable", "SearchView_queryBackground")));
        ViewCompat.setBackground(r6, r15.getDrawable(ZeusTransformUtils.mapRes(R.styleable.SearchView_submitBackground, "styleable", "SearchView_submitBackground")));
        r4.setImageDrawable(r15.getDrawable(ZeusTransformUtils.mapRes(R.styleable.SearchView_searchIcon, "styleable", "SearchView_searchIcon")));
        r14.setImageDrawable(r15.getDrawable(ZeusTransformUtils.mapRes(R.styleable.SearchView_goIcon, "styleable", "SearchView_goIcon")));
        r16.setImageDrawable(r15.getDrawable(ZeusTransformUtils.mapRes(R.styleable.SearchView_closeIcon, "styleable", "SearchView_closeIcon")));
        r17.setImageDrawable(r15.getDrawable(ZeusTransformUtils.mapRes(R.styleable.SearchView_voiceIcon, "styleable", "SearchView_voiceIcon")));
        r1.setImageDrawable(r15.getDrawable(ZeusTransformUtils.mapRes(R.styleable.SearchView_searchIcon, "styleable", "SearchView_searchIcon")));
        this.mSearchHintIcon = r15.getDrawable(ZeusTransformUtils.mapRes(R.styleable.SearchView_searchHintIcon, "styleable", "SearchView_searchHintIcon"));
        TooltipCompat.setTooltipText(r4, ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getString(ZeusTransformUtils.mapRes(R.string.abc_searchview_description_search, TypedValues.Custom.S_STRING, "abc_searchview_description_search")));
        this.mSuggestionRowLayout = r15.getResourceId(ZeusTransformUtils.mapRes(R.styleable.SearchView_suggestionRowLayout, "styleable", "SearchView_suggestionRowLayout"), ZeusTransformUtils.mapRes(R.layout.abc_search_dropdown_item_icons_2line, "layout", "abc_search_dropdown_item_icons_2line"));
        this.mSuggestionCommitIconResId = r15.getResourceId(ZeusTransformUtils.mapRes(R.styleable.SearchView_commitIcon, "styleable", "SearchView_commitIcon"), 0);
        r4.setOnClickListener(r10);
        r16.setOnClickListener(r10);
        r14.setOnClickListener(r10);
        r17.setOnClickListener(r10);
        r0.setOnClickListener(r10);
        r0.addTextChangedListener(this.mTextWatcher);
        r0.setOnEditorActionListener(r11);
        r0.setOnItemClickListener(r12);
        r0.setOnItemSelectedListener(r13);
        r0.setOnKeyListener(this.mTextKeyListener);
        r0.setOnFocusChangeListener(new AnonymousClass3(this));
        setIconifiedByDefault(r15.getBoolean(ZeusTransformUtils.mapRes(R.styleable.SearchView_iconifiedByDefault, "styleable", "SearchView_iconifiedByDefault"), true));
        int r2 = r15.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.SearchView_android_maxWidth, "styleable", "SearchView_android_maxWidth"), -1);
        if (r2 == (-1)) goto L5;
        setMaxWidth(r2);
    L5:
        this.mDefaultQueryHint = r15.getText(ZeusTransformUtils.mapRes(R.styleable.SearchView_defaultQueryHint, "styleable", "SearchView_defaultQueryHint"));
        this.mQueryHint = r15.getText(ZeusTransformUtils.mapRes(R.styleable.SearchView_queryHint, "styleable", "SearchView_queryHint"));
        int r7 = r15.getInt(ZeusTransformUtils.mapRes(R.styleable.SearchView_android_imeOptions, "styleable", "SearchView_android_imeOptions"), -1);
        if (r7 == (-1)) goto L8;
        setImeOptions(r7);
    L8:
        int r8 = r15.getInt(ZeusTransformUtils.mapRes(R.styleable.SearchView_android_inputType, "styleable", "SearchView_android_inputType"), -1);
        if (r8 == (-1)) goto L11;
        setInputType(r8);
    L11:
        setFocusable(r15.getBoolean(ZeusTransformUtils.mapRes(R.styleable.SearchView_android_focusable, "styleable", "SearchView_android_focusable"), true));
        r15.recycle();
        Intent r18 = new Intent("android.speech.action.WEB_SEARCH");
        this.mVoiceWebSearchIntent = r18;
        r18.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        r18.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        Intent r19 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.mVoiceAppSearchIntent = r19;
        r19.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        View r23 = findViewById(r0.getDropDownAnchor());
        this.mDropDownAnchor = r23;
        if (r23 == null) goto L14;
        r23.addOnLayoutChangeListener(new AnonymousClass4(this));
    L14:
        updateViewsVisibility(this.mIconifiedByDefault);
        updateQueryHint();
    }

    private Intent createIntent(String r2, Uri r3, String r4, String r5, int r6, String r7) {
        Intent r0 = new Intent(r2);
        r0.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        if (r3 == null) goto L5;
        r0.setData(r3);
    L5:
        r0.putExtra("user_query", this.mUserQuery);
        if (r5 == null) goto L8;
        r0.putExtra(ChatMessage.TYPE_QUERY, r5);
    L8:
        if (r4 == null) goto L10;
        r0.putExtra("intent_extra_data_key", r4);
    L10:
        Bundle r8 = this.mAppSearchData;
        if (r8 == null) goto L13;
        r0.putExtra("app_data", r8);
    L13:
        if (r6 == 0) goto L15;
        r0.putExtra("action_key", r6);
        r0.putExtra("action_msg", r7);
    L15:
        r0.setComponent(this.mSearchable.getSearchActivity());
        return r0;
    }

    private Intent createIntentFromSuggestion(Cursor r9, int r10, String r11) {
        Cursor r12 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r9, Cursor.class, "com.obric.memorydata.plugin");
        String r1 = SuggestionsAdapter.getColumnString(r12, "suggest_intent_action");     // Catch: RuntimeException -> L20
        if (r1 != null) goto L6;
        r1 = this.mSearchable.getSuggestIntentAction();     // Catch: RuntimeException -> L20
    L6:
        if (r1 != null) goto L8;
        r1 = "android.intent.action.SEARCH";
    L8:
        String r2 = r1;
        String r3 = SuggestionsAdapter.getColumnString(r12, "suggest_intent_data");     // Catch: RuntimeException -> L20
        if (r3 != null) goto L11;
        r3 = this.mSearchable.getSuggestIntentData();     // Catch: RuntimeException -> L20
    L11:
        if (r3 == null) goto L15;
        String r4 = SuggestionsAdapter.getColumnString(r12, "suggest_intent_data_id");     // Catch: RuntimeException -> L20
        if (r4 == null) goto L15;
        r3 = r3 + "/" + Uri.encode(r4);     // Catch: RuntimeException -> L20
    L15:
        if (r3 != null) goto L17;
        Uri r5 = null;
    L18:
        return createIntent(r2, r5, SuggestionsAdapter.getColumnString(r12, "suggest_intent_extra_data"), SuggestionsAdapter.getColumnString(r12, "suggest_intent_query"), r10, r11);
    L17:
        r5 = Uri.parse(r3);     // Catch: RuntimeException -> L20
    L20:
        e = move-exception;
        int r13 = r12.getPosition();     // Catch: RuntimeException -> L23
    L24:
        Log.w(LOG_TAG, "Search suggestions cursor at row " + r13 + " returned exception.", e);
        return null;
    L23:
        r13 = -1;
        goto L24
    }

    private Intent createVoiceAppSearchIntent(Intent r9, SearchableInfo r10) {
        ComponentName r0 = r10.getSearchActivity();
        Intent r1 = new Intent("android.intent.action.SEARCH");
        r1.setComponent(r0);
        PendingIntent r2 = PendingIntent.getActivity((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), 0, r1, 1107296256);
        Bundle r3 = new Bundle();
        Bundle r4 = this.mAppSearchData;
        if (r4 == null) goto L5;
        r3.putParcelable("app_data", r4);
    L5:
        Intent r5 = new Intent(r9);
        int r11 = 1;
        Resources r8 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin");
        if (r10.getVoiceLanguageModeId() == 0) goto L8;
        String r6 = r8.getString(r10.getVoiceLanguageModeId());
    L9:
        String r7 = null;
        if (r10.getVoicePromptTextId() == 0) goto L12;
        String r12 = r8.getString(r10.getVoicePromptTextId());
    L14:
        if (r10.getVoiceLanguageId() == 0) goto L16;
        String r13 = r8.getString(r10.getVoiceLanguageId());
    L18:
        if (r10.getVoiceMaxResults() == 0) goto L20;
        r11 = r10.getVoiceMaxResults();
    L20:
        r5.putExtra("android.speech.extra.LANGUAGE_MODEL", r6);
        r5.putExtra("android.speech.extra.PROMPT", r12);
        r5.putExtra("android.speech.extra.LANGUAGE", r13);
        r5.putExtra("android.speech.extra.MAX_RESULTS", r11);
        if (r0 == null) goto L24;
        r7 = r0.flattenToShortString();
    L24:
        r5.putExtra("calling_package", r7);
        r5.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", r2);
        r5.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", r3);
        return r5;
    L16:
        r13 = null;
        goto L18
    L12:
        r12 = null;
        goto L14
    L8:
        r6 = "free_form";
        goto L9
    }

    private Intent createVoiceWebSearchIntent(Intent r1, SearchableInfo r2) {
        Intent r0 = new Intent(r1);
        ComponentName r3 = r2.getSearchActivity();
        if (r3 != null) goto L5;
        String r4 = null;
    L6:
        r0.putExtra("calling_package", r4);
        return r0;
    L5:
        r4 = r3.flattenToShortString();
        goto L6
    }

    private void dismissSuggestions() {
        this.mSearchSrcTextView.dismissDropDown();
    }

    private void getChildBoundsWithinSearchView(View r4, Rect r5) {
        r4.getLocationInWindow(this.mTemp);
        getLocationInWindow(this.mTemp2);
        int[] r0 = this.mTemp;
        int r2 = r0[1];
        int[] r3 = this.mTemp2;
        int r6 = r2 - r3[1];
        int r1 = r0[0] - r3[0];
        r5.set(r1, r6, r4.getWidth() + r1, r4.getHeight() + r6);
    }

    private CharSequence getDecoratedHint(CharSequence r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.memorydata.plugin");
        if (this.mIconifiedByDefault == true) goto L5;
    L9:
        return r6;
    L5:
        if (this.mSearchHintIcon == null) goto L9;
        int r0 = (int) (((double) this.mSearchSrcTextView.getTextSize()) * 1.25d);
        this.mSearchHintIcon.setBounds(0, 0, r0, r0);
        SpannableStringBuilder r1 = new SpannableStringBuilder("   ");
        r1.setSpan(new ImageSpan(this.mSearchHintIcon), 1, 2, 33);
        r1.append(r6);
        return r1;
    }

    private int getPreferredHeight() {
        return ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.abc_search_view_preferred_height, "dimen", "abc_search_view_preferred_height"));
    }

    private int getPreferredWidth() {
        return ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.abc_search_view_preferred_width, "dimen", "abc_search_view_preferred_width"));
    }

    private boolean hasVoiceSearch() {
        SearchableInfo r0 = this.mSearchable;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.getVoiceSearchEnabled() == false) goto L18;
        Intent r1 = null;
        if (this.mSearchable.getVoiceSearchLaunchWebSearch() == false) goto L10;
        r1 = this.mVoiceWebSearchIntent;
    L12:
        if (r1 != null) goto L14;
        return false;
    L14:
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageManager().resolveActivity(r1, 65536) == null) goto L20;
        return true;
    L20:
        return false;
    L10:
        if (this.mSearchable.getVoiceSearchLaunchRecognizer() == false) goto L12;
        r1 = this.mVoiceAppSearchIntent;
        goto L12
    L18:
        return false;
    }

    static boolean isLandscapeMode(Context r2) {
        if (ZeusTransformUtils.getResources((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getConfiguration().orientation != 2) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isSubmitAreaEnabled() {
        if (this.mSubmitButtonEnabled == true) goto L7;
        if (this.mVoiceButtonEnabled == true) goto L7;
    L9:
        return false;
    L7:
        if (isIconified() == true) goto L9;
        return true;
    }

    private void launchIntent(Intent r3) {
        if (r3 != null) goto L10;
        return;
    L10:
        ZeusTransformUtils.startActivity((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r3, "com.obric.memorydata.plugin");     // Catch: RuntimeException -> L7
        return;
    L7:
        e = move-exception;
        Log.e(LOG_TAG, "Failed launch activity: " + r3, e);
    }

    private boolean launchSuggestion(int r2, int r3, String r4) {
        Cursor r0 = this.mSuggestionsAdapter.getCursor();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.moveToPosition(r2) == false) goto L10;
        launchIntent(createIntentFromSuggestion(r0, r3, r4));
        return true;
    L10:
        return false;
    }

    private void postUpdateFocusedState() {
        post(this.mUpdateDrawableStateRunnable);
    }

    private void rewriteQueryFromSuggestion(int r3) {
        Editable r0 = this.mSearchSrcTextView.getText();
        Cursor r1 = this.mSuggestionsAdapter.getCursor();
        if (r1 != null) goto L6;
        return;
    L6:
        if (r1.moveToPosition(r3) == false) goto L10;
        CharSequence r4 = this.mSuggestionsAdapter.convertToString(r1);
        if (r4 == null) goto L10;
        setQuery(r4);
        return;
    L10:
        setQuery(r0);
    }

    private void setQuery(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        this.mSearchSrcTextView.setText(r4);
        SearchAutoComplete r2 = this.mSearchSrcTextView;
        if (TextUtils.isEmpty(r4) == false) goto L5;
        int r5 = 0;
    L6:
        r2.setSelection(r5);
        return;
    L5:
        r5 = r4.length();
        goto L6
    }

    private void updateCloseButton() {
        boolean r1 = true;
        boolean r0 = !TextUtils.isEmpty(this.mSearchSrcTextView.getText());
        int r2 = 0;
        if (r0 == false) goto L5;
    L10:
        ImageView r3 = this.mCloseButton;
        if (r1 == true) goto L14;
        r2 = 8;
    L14:
        r3.setVisibility(r2);
        Drawable r4 = this.mCloseButton.getDrawable();
        if (r4 == null) goto L21;
        if (r0 == false) goto L18;
        int[] r5 = ENABLED_STATE_SET;
    L19:
        r4.setState(r5);
        return;
    L18:
        r5 = EMPTY_STATE_SET;
        goto L19
    L21:
        return;
    L5:
        if (this.mIconifiedByDefault == true) goto L7;
    L9:
        r1 = false;
        goto L10
    L7:
        if (this.mExpandedInActionView == true) goto L9;
        goto L9
    }

    private void updateQueryHint() {
        CharSequence r0 = getQueryHint();
        SearchAutoComplete r1 = this.mSearchSrcTextView;
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        r1.setHint(getDecoratedHint(r0));
    }

    private void updateSearchAutoComplete() {
        this.mSearchSrcTextView.setThreshold(this.mSearchable.getSuggestThreshold());
        this.mSearchSrcTextView.setImeOptions(this.mSearchable.getImeOptions());
        int r0 = this.mSearchable.getInputType();
        int r2 = 1;
        if ((r0 & 15) != 1) goto L7;
        r0 = r0 & (-65537);
        if (this.mSearchable.getSuggestAuthority() == null) goto L7;
        r0 = (r0 | 65536) | 524288;
    L7:
        this.mSearchSrcTextView.setInputType(r0);
        CursorAdapter r1 = this.mSuggestionsAdapter;
        if (r1 == null) goto L11;
        r1.changeCursor(null);
    L11:
        if (this.mSearchable.getSuggestAuthority() == null) goto L17;
        SuggestionsAdapter r3 = new SuggestionsAdapter((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), this, this.mSearchable, this.mOutsideDrawablesCache);
        this.mSuggestionsAdapter = r3;
        this.mSearchSrcTextView.setAdapter(r3);
        SuggestionsAdapter r4 = (SuggestionsAdapter) ZeusTransformUtils.preCheckCast(this.mSuggestionsAdapter, SuggestionsAdapter.class, "com.obric.memorydata.plugin");
        if (this.mQueryRefinement == false) goto L15;
        r2 = 2;
    L15:
        r4.setQueryRefinement(r2);
        return;
    }

    private void updateSubmitArea() {
        if (isSubmitAreaEnabled() == true) goto L5;
    L9:
        int r0 = 8;
    L10:
        this.mSubmitArea.setVisibility(r0);
        return;
    L5:
        if (this.mGoButton.getVisibility() != 0) goto L7;
    L8:
        r0 = 0;
        goto L10
    L7:
        if (this.mVoiceButton.getVisibility() != 0) goto L9;
        goto L8
    }

    private void updateSubmitButton(boolean r2) {
        if (this.mSubmitButtonEnabled == true) goto L5;
    L12:
        int r3 = 8;
    L13:
        this.mGoButton.setVisibility(r3);
        return;
    L5:
        if (isSubmitAreaEnabled() == false) goto L12;
        if (hasFocus() == false) goto L12;
        if (r2 == false) goto L10;
    L11:
        r3 = 0;
        goto L13
    L10:
        if (this.mVoiceButtonEnabled == true) goto L12;
        goto L11
    }

    private void updateViewsVisibility(boolean r6) {
        this.mIconified = r6;
        int r0 = 0;
        if (r6 == false) goto L5;
        int r2 = 0;
    L6:
        boolean r3 = !TextUtils.isEmpty(this.mSearchSrcTextView.getText());
        this.mSearchButton.setVisibility(r2);
        updateSubmitButton(r3);
        View r4 = this.mSearchEditFrame;
        if (r6 == false) goto L9;
        int r7 = 8;
    L10:
        r4.setVisibility(r7);
        if (this.mCollapsedIcon.getDrawable() != null) goto L13;
    L14:
        r0 = 8;
    L15:
        this.mCollapsedIcon.setVisibility(r0);
        updateCloseButton();
        updateVoiceButton(!r3);
        updateSubmitArea();
        return;
    L13:
        if (this.mIconifiedByDefault == false) goto L15;
    L9:
        r7 = 0;
        goto L10
    L5:
        r2 = 8;
        goto L6
    }

    private void updateVoiceButton(boolean r3) {
        int r1 = 8;
        if (this.mVoiceButtonEnabled == true) goto L5;
    L8:
        this.mVoiceButton.setVisibility(r1);
        return;
    L5:
        if (isIconified() == true) goto L8;
        if (r3 == false) goto L8;
        this.mGoButton.setVisibility(8);
        r1 = 0;
        goto L8
    }

    void adjustDropDownSizeAndPosition() {
        if (this.mDropDownAnchor.getWidth() <= 1) goto L14;
        Resources r0 = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        int r1 = this.mSearchPlate.getPaddingLeft();
        Rect r2 = new Rect();
        boolean r3 = ViewUtils.isLayoutRtl(this);
        if (this.mIconifiedByDefault == false) goto L7;
        int r4 = r0.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.abc_dropdownitem_icon_width, "dimen", "abc_dropdownitem_icon_width")) + r0.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.abc_dropdownitem_text_padding_left, "dimen", "abc_dropdownitem_text_padding_left"));
    L8:
        this.mSearchSrcTextView.getDropDownBackground().getPadding(r2);
        int r5 = r2.left;
        if (r3 == false) goto L11;
        int r6 = -r5;
    L12:
        this.mSearchSrcTextView.setDropDownHorizontalOffset(r6);
        int r7 = (((this.mDropDownAnchor.getWidth() + r2.left) + r2.right) + r4) - r1;
        this.mSearchSrcTextView.setDropDownWidth(r7);
        return;
    L11:
        r6 = r1 - (r5 + r4);
        goto L12
    L7:
        r4 = 0;
        goto L8
    }

    @Override // android.view.ViewGroup, android.view.View
    public void clearFocus() {
        this.mClearingFocus = true;
        super.clearFocus();
        this.mSearchSrcTextView.clearFocus();
        this.mSearchSrcTextView.setImeVisibility(false);
        this.mClearingFocus = false;
    }

    void forceSuggestionQuery() {
        if (Build.VERSION.SDK_INT < 29) goto L5;
        Api29Impl.refreshAutoCompleteResults(this.mSearchSrcTextView);
        return;
    L5:
        PreQAutoCompleteTextViewReflector r0 = PRE_API_29_HIDDEN_METHOD_INVOKER;
        r0.doBeforeTextChanged(this.mSearchSrcTextView);
        r0.doAfterTextChanged(this.mSearchSrcTextView);
    }

    public int getImeOptions() {
        return this.mSearchSrcTextView.getImeOptions();
    }

    public int getInputType() {
        return this.mSearchSrcTextView.getInputType();
    }

    public int getMaxWidth() {
        return this.mMaxWidth;
    }

    public CharSequence getQuery() {
        return this.mSearchSrcTextView.getText();
    }

    public CharSequence getQueryHint() {
        CharSequence r0 = this.mQueryHint;
        if (r0 != null) goto L13;
        SearchableInfo r1 = this.mSearchable;
        if (r1 == null) goto L11;
        if (r1.getHintId() == 0) goto L11;
        return ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getText(this.mSearchable.getHintId());
    L11:
        return this.mDefaultQueryHint;
    L13:
        return r0;
    }

    int getSuggestionCommitIconResId() {
        return this.mSuggestionCommitIconResId;
    }

    int getSuggestionRowLayout() {
        return this.mSuggestionRowLayout;
    }

    public CursorAdapter getSuggestionsAdapter() {
        return this.mSuggestionsAdapter;
    }

    public boolean isIconfiedByDefault() {
        return this.mIconifiedByDefault;
    }

    public boolean isIconified() {
        return this.mIconified;
    }

    public boolean isQueryRefinementEnabled() {
        return this.mQueryRefinement;
    }

    public boolean isSubmitButtonEnabled() {
        return this.mSubmitButtonEnabled;
    }

    void launchQuerySearch(int r8, String r9, String r10) {
        Intent r11 = createIntent("android.intent.action.SEARCH", null, null, r10, r8, r9);
        ZeusTransformUtils.startActivity((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r11, "com.obric.memorydata.plugin");
    }

    @Override // androidx.appcompat.view.CollapsibleActionView
    public void onActionViewCollapsed() {
        setQuery("", false);
        clearFocus();
        updateViewsVisibility(true);
        this.mSearchSrcTextView.setImeOptions(this.mCollapsedImeOptions);
        this.mExpandedInActionView = false;
    }

    @Override // androidx.appcompat.view.CollapsibleActionView
    public void onActionViewExpanded() {
        if (this.mExpandedInActionView == false) goto L5;
        return;
    L5:
        this.mExpandedInActionView = true;
        int r0 = this.mSearchSrcTextView.getImeOptions();
        this.mCollapsedImeOptions = r0;
        this.mSearchSrcTextView.setImeOptions(r0 | 33554432);
        this.mSearchSrcTextView.setText("");
        setIconified(false);
    }

    void onCloseClicked() {
        if (TextUtils.isEmpty(this.mSearchSrcTextView.getText()) == true) goto L5;
        this.mSearchSrcTextView.setText("");
        this.mSearchSrcTextView.requestFocus();
        this.mSearchSrcTextView.setImeVisibility(true);
        return;
    L5:
        if (this.mIconifiedByDefault == false) goto L13;
        OnCloseListener r0 = this.mOnCloseListener;
        if (r0 != null) goto L9;
    L10:
        clearFocus();
        updateViewsVisibility(true);
        return;
    L9:
        if (r0.onClose() == false) goto L10;
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.mUpdateDrawableStateRunnable);
        post(this.mReleaseCursorRunnable);
        super.onDetachedFromWindow();
    }

    boolean onItemClicked(int r1, int r2, String r3) {
        OnSuggestionListener r4 = this.mOnSuggestionListener;
        if (r4 != null) goto L5;
    L8:
        launchSuggestion(r1, 0, null);
        this.mSearchSrcTextView.setImeVisibility(false);
        dismissSuggestions();
        return true;
    L5:
        if (r4.onSuggestionClick(r1) == false) goto L8;
        return false;
    }

    boolean onItemSelected(int r2) {
        OnSuggestionListener r0 = this.mOnSuggestionListener;
        if (r0 != null) goto L5;
    L9:
        rewriteQueryFromSuggestion(r2);
        return true;
    L5:
        if (r0.onSuggestionSelect(r2) == false) goto L9;
        return false;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r2, int r3, int r4, int r5, int r6) {
        super.onLayout(r2, r3, r4, r5, r6);
        if (r2 == false) goto L9;
        getChildBoundsWithinSearchView(this.mSearchSrcTextView, this.mSearchSrcTextViewBounds);
        this.mSearchSrtTextViewBoundsExpanded.set(this.mSearchSrcTextViewBounds.left, 0, this.mSearchSrcTextViewBounds.right, r6 - r4);
        UpdatableTouchDelegate r7 = this.mTouchDelegate;
        if (r7 != null) goto L7;
        UpdatableTouchDelegate r8 = new UpdatableTouchDelegate(this.mSearchSrtTextViewBoundsExpanded, this.mSearchSrcTextViewBounds, this.mSearchSrcTextView);
        this.mTouchDelegate = r8;
        setTouchDelegate(r8);
        return;
    L7:
        r7.setBounds(this.mSearchSrtTextViewBoundsExpanded, this.mSearchSrcTextViewBounds);
        return;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public void onMeasure(int r4, int r5) {
        if (isIconified() == false) goto L6;
        super.onMeasure(r4, r5);
        return;
    L6:
        int r0 = View.MeasureSpec.getMode(r4);
        int r6 = View.MeasureSpec.getSize(r4);
        if (r0 == Integer.MIN_VALUE) goto L18;
        if (r0 == 0) goto L14;
        if (r0 != 1073741824) goto L23;
        int r1 = this.mMaxWidth;
        if (r1 <= 0) goto L23;
    L22:
        r6 = Math.min(r1, r6);
    L23:
        int r2 = View.MeasureSpec.getMode(r5);
        int r7 = View.MeasureSpec.getSize(r5);
        if (r2 == Integer.MIN_VALUE) goto L28;
        if (r2 != 0) goto L29;
        r7 = getPreferredHeight();
    L29:
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(r6, 1073741824), View.MeasureSpec.makeMeasureSpec(r7, 1073741824));
        return;
    L28:
        r7 = Math.min(getPreferredHeight(), r7);
        goto L29
    L14:
        r6 = this.mMaxWidth;
        if (r6 > 0) goto L23;
        r6 = getPreferredWidth();
        goto L23
    L18:
        r1 = this.mMaxWidth;
        if (r1 > 0) goto L22;
        r1 = getPreferredWidth();
        goto L22
    }

    public void onQueryRefine(CharSequence r3) {
        setQuery((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"));
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r3) {
        Parcelable r4 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, SavedState.class) == true) goto L6;
        super.onRestoreInstanceState(r4);
        return;
    L6:
        SavedState r5 = (SavedState) ZeusTransformUtils.preCheckCast(r4, SavedState.class, "com.obric.memorydata.plugin");
        super.onRestoreInstanceState(r5.getSuperState());
        updateViewsVisibility(r5.isIconified);
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r1 = new SavedState(super.onSaveInstanceState());
        r1.isIconified = isIconified();
        return r1;
    }

    void onSearchClicked() {
        updateViewsVisibility(false);
        this.mSearchSrcTextView.requestFocus();
        this.mSearchSrcTextView.setImeVisibility(true);
        View.OnClickListener r0 = this.mOnSearchClickListener;
        if (r0 == null) goto L6;
        r0.onClick(this);
        return;
    }

    void onSubmitQuery() {
        Editable r0 = this.mSearchSrcTextView.getText();
        if (r0 != null) goto L5;
        return;
    L5:
        if (TextUtils.getTrimmedLength(r0) <= 0) goto L16;
        OnQueryTextListener r1 = this.mOnQueryChangeListener;
        if (r1 == null) goto L11;
        if (r1.onQueryTextSubmit(r0.toString()) == false) goto L11;
        return;
    L11:
        if (this.mSearchable == null) goto L13;
        launchQuerySearch(0, null, r0.toString());
    L13:
        this.mSearchSrcTextView.setImeVisibility(false);
        dismissSuggestions();
        return;
    }

    boolean onSuggestionsKey(View r2, int r3, KeyEvent r4) {
        if (this.mSearchable != null) goto L6;
        return false;
    L6:
        if (this.mSuggestionsAdapter != null) goto L9;
        return false;
    L9:
        if (r4.getAction() == 0) goto L11;
    L36:
        return false;
    L11:
        if (r4.hasNoModifiers() == false) goto L36;
        if (r3 == 66) goto L35;
        if (r3 == 84) goto L35;
        if (r3 == 61) goto L35;
        if (r3 != 21) goto L22;
    L29:
        if (r3 != 21) goto L31;
        int r5 = 0;
    L32:
        this.mSearchSrcTextView.setSelection(r5);
        this.mSearchSrcTextView.setListSelection(0);
        this.mSearchSrcTextView.clearListSelection();
        this.mSearchSrcTextView.ensureImeVisible();
        return true;
    L31:
        r5 = this.mSearchSrcTextView.length();
        goto L32
    L22:
        if (r3 == 22) goto L29;
        if (r3 != 19) goto L36;
        if (this.mSearchSrcTextView.getListSelection() != 0) goto L36;
        return false;
    L35:
        return onItemClicked(this.mSearchSrcTextView.getListSelection(), 0, null);
    }

    void onTextChanged(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        Editable r0 = this.mSearchSrcTextView.getText();
        this.mUserQuery = r0;
        boolean r1 = !TextUtils.isEmpty(r0);
        updateSubmitButton(r1);
        updateVoiceButton(!r1);
        updateCloseButton();
        updateSubmitArea();
        if (this.mOnQueryChangeListener != null) goto L5;
    L7:
        this.mOldQueryText = r4.toString();
        return;
    L5:
        if (TextUtils.equals(r4, this.mOldQueryText) == true) goto L7;
        this.mOnQueryChangeListener.onQueryTextChange(r4.toString());
        goto L7
    }

    void onTextFocusChanged() {
        updateViewsVisibility(isIconified());
        postUpdateFocusedState();
        if (this.mSearchSrcTextView.hasFocus() == false) goto L6;
        forceSuggestionQuery();
        return;
    }

    void onVoiceClicked() {
        SearchableInfo r0 = this.mSearchable;
        if (r0 != null) goto L16;
        return;
    L16:
    L14:
        Log.w(LOG_TAG, "Could not find voice search activity");
        return;
    L7:
        if (r0.getVoiceSearchLaunchWebSearch() == false) goto L11;
        Intent r1 = createVoiceWebSearchIntent(this.mVoiceWebSearchIntent, r0);     // Catch: ActivityNotFoundException -> L14
        Object r3 = ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: ActivityNotFoundException -> L14
    L9:
        ZeusTransformUtils.startActivity((Context) r3, r1, "com.obric.memorydata.plugin");     // Catch: ActivityNotFoundException -> L14
        return;
    L11:
        if (r0.getVoiceSearchLaunchRecognizer() == false) goto L19;
        r1 = createVoiceAppSearchIntent(this.mVoiceAppSearchIntent, r0);     // Catch: ActivityNotFoundException -> L14
        r3 = ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: ActivityNotFoundException -> L14
        goto L9
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean r1) {
        super.onWindowFocusChanged(r1);
        postUpdateFocusedState();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int r3, Rect r4) {
        if (this.mClearingFocus == false) goto L6;
        return false;
    L6:
        if (isFocusable() == true) goto L9;
        return false;
    L9:
        if (isIconified() == true) goto L15;
        boolean r5 = this.mSearchSrcTextView.requestFocus(r3, r4);
        if (r5 == false) goto L13;
        updateViewsVisibility(false);
    L13:
        return r5;
    L15:
        return super.requestFocus(r3, r4);
    }

    public void setAppSearchData(Bundle r1) {
        this.mAppSearchData = r1;
    }

    public void setIconified(boolean r1) {
        if (r1 == false) goto L4;
        onCloseClicked();
        return;
    L4:
        onSearchClicked();
    }

    public void setIconifiedByDefault(boolean r2) {
        if (this.mIconifiedByDefault != r2) goto L5;
        return;
    L5:
        this.mIconifiedByDefault = r2;
        updateViewsVisibility(r2);
        updateQueryHint();
    }

    public void setImeOptions(int r1) {
        this.mSearchSrcTextView.setImeOptions(r1);
    }

    public void setInputType(int r1) {
        this.mSearchSrcTextView.setInputType(r1);
    }

    public void setMaxWidth(int r1) {
        this.mMaxWidth = r1;
        requestLayout();
    }

    public void setOnCloseListener(OnCloseListener r3) {
        this.mOnCloseListener = (OnCloseListener) ZeusTransformUtils.wrapperContextForParams(r3, OnCloseListener.class, "com.obric.memorydata.plugin");
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener r3) {
        this.mOnQueryTextFocusChangeListener = (View.OnFocusChangeListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnFocusChangeListener.class, "com.obric.memorydata.plugin");
    }

    public void setOnQueryTextListener(OnQueryTextListener r3) {
        this.mOnQueryChangeListener = (OnQueryTextListener) ZeusTransformUtils.wrapperContextForParams(r3, OnQueryTextListener.class, "com.obric.memorydata.plugin");
    }

    public void setOnSearchClickListener(View.OnClickListener r3) {
        this.mOnSearchClickListener = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnClickListener.class, "com.obric.memorydata.plugin");
    }

    public void setOnSuggestionListener(OnSuggestionListener r3) {
        this.mOnSuggestionListener = (OnSuggestionListener) ZeusTransformUtils.wrapperContextForParams(r3, OnSuggestionListener.class, "com.obric.memorydata.plugin");
    }

    public void setQuery(CharSequence r3, boolean r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        this.mSearchSrcTextView.setText(r5);
        if (r5 == null) goto L5;
        SearchAutoComplete r0 = this.mSearchSrcTextView;
        r0.setSelection(r0.length());
        this.mUserQuery = r5;
    L5:
        if (r4 == true) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r5) == true) goto L11;
        onSubmitQuery();
        return;
    }

    public void setQueryHint(CharSequence r3) {
        this.mQueryHint = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        updateQueryHint();
    }

    public void setQueryRefinementEnabled(boolean r3) {
        this.mQueryRefinement = r3;
        if (ZeusTransformUtils.instanceOf(this.mSuggestionsAdapter, SuggestionsAdapter.class) == false) goto L10;
        SuggestionsAdapter r2 = (SuggestionsAdapter) ZeusTransformUtils.preCheckCast(this.mSuggestionsAdapter, SuggestionsAdapter.class, "com.obric.memorydata.plugin");
        if (r3 == false) goto L7;
        int r4 = 2;
    L8:
        r2.setQueryRefinement(r4);
        return;
    L7:
        r4 = 1;
        goto L8
    }

    public void setSearchableInfo(SearchableInfo r2) {
        this.mSearchable = r2;
        if (r2 == null) goto L5;
        updateSearchAutoComplete();
        updateQueryHint();
    L5:
        boolean r3 = hasVoiceSearch();
        this.mVoiceButtonEnabled = r3;
        if (r3 == false) goto L8;
        this.mSearchSrcTextView.setPrivateImeOptions(IME_OPTION_NO_MICROPHONE);
    L8:
        updateViewsVisibility(isIconified());
    }

    public void setSubmitButtonEnabled(boolean r1) {
        this.mSubmitButtonEnabled = r1;
        updateViewsVisibility(isIconified());
    }

    public void setSuggestionsAdapter(CursorAdapter r1) {
        this.mSuggestionsAdapter = r1;
        this.mSearchSrcTextView.setAdapter(r1);
    }

    void updateFocusedState() {
        if (this.mSearchSrcTextView.hasFocus() == false) goto L5;
        int[] r0 = FOCUSED_STATE_SET;
    L6:
        Drawable r1 = this.mSearchPlate.getBackground();
        if (r1 == null) goto L9;
        r1.setState(r0);
    L9:
        Drawable r2 = this.mSubmitArea.getBackground();
        if (r2 == null) goto L12;
        r2.setState(r0);
    L12:
        invalidate();
        return;
    L5:
        r0 = EMPTY_STATE_SET;
        goto L6
    }
}
