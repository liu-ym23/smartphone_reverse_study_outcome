package androidx.appcompat.widget;

import android.annotation.SuppressLint;
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
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.view.CollapsibleActionView;
import androidx.core.view.ViewCompat;
import androidx.cursoradapter.widget.CursorAdapter;
import androidx.customview.view.AbsSavedState;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

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

    @RequiresApi(29)
    static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static void refreshAutoCompleteResults(AutoCompleteTextView r10) {
            r10.refreshAutoCompleteResults();
        }

        @DoNotInline
        static void setInputMethodMode(SearchAutoComplete r10, int r11) {
            r10.setInputMethodMode(r11);
        }
    }

    public interface OnCloseListener {
        boolean onClose();
    }

    public interface OnQueryTextListener {
        boolean onQueryTextChange(String r10);

        boolean onQueryTextSubmit(String r10);
    }

    public interface OnSuggestionListener {
        boolean onSuggestionClick(int r10);

        boolean onSuggestionSelect(int r10);
    }

    private static class PreQAutoCompleteTextViewReflector {
        private Method mDoAfterTextChanged;
        private Method mDoBeforeTextChanged;
        private Method mEnsureImeVisible;

        @SuppressLint({"DiscouragedPrivateApi", "SoonBlockedPrivateApi"})
        PreQAutoCompleteTextViewReflector() {
            this.mDoBeforeTextChanged = null;
            this.mDoAfterTextChanged = null;
            this.mEnsureImeVisible = null;
            preApi29Check();
            Method r10 = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);     // Catch: NoSuchMethodException -> L7
            this.mDoBeforeTextChanged = r10;     // Catch: NoSuchMethodException -> L7
            r10.setAccessible(true);     // Catch: NoSuchMethodException -> L7
        L10:
            Method r11 = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);     // Catch: NoSuchMethodException -> L8
            this.mDoAfterTextChanged = r11;     // Catch: NoSuchMethodException -> L8
            r11.setAccessible(true);     // Catch: NoSuchMethodException -> L8
        L14:
            Method r12 = AutoCompleteTextView.class.getMethod("ensureImeVisible", new Class[]{Boolean.TYPE});     // Catch: NoSuchMethodException -> L9
            this.mEnsureImeVisible = r12;     // Catch: NoSuchMethodException -> L9
            r12.setAccessible(true);     // Catch: NoSuchMethodException -> L9
            return;
        }

        private static void preApi29Check() {
            if (Build.VERSION.SDK_INT >= 29) goto L6;
            return;
        L6:
            throw new UnsupportedClassVersionError("This function can only be used for API Level < 29.");
        }

        void doAfterTextChanged(AutoCompleteTextView r10) {
            preApi29Check();
            Method r11 = this.mDoAfterTextChanged;
            if (r11 != null) goto L8;
            return;
        L8:
            r11.invoke(r10, new Object[0]);     // Catch: Exception -> L7
            return;
        }

        void doBeforeTextChanged(AutoCompleteTextView r10) {
            preApi29Check();
            Method r11 = this.mDoBeforeTextChanged;
            if (r11 != null) goto L8;
            return;
        L8:
            r11.invoke(r10, new Object[0]);     // Catch: Exception -> L7
            return;
        }

        void ensureImeVisible(AutoCompleteTextView r10) {
            preApi29Check();
            Method r11 = this.mEnsureImeVisible;
            if (r11 != null) goto L8;
            return;
        L8:
            r11.invoke(r10, new Object[]{Boolean.TRUE});     // Catch: Exception -> L7
            return;
        }
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        boolean isIconified;

        static {
            CREATOR = new AnonymousClass1();
        }

        public SavedState(Parcel r10, ClassLoader r11) {
            super(r10, r11);
            this.isIconified = ((Boolean) r10.readValue(null)).booleanValue();
        }

        SavedState(Parcelable r10) {
            super(r10);
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.isIconified + "}";
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r10, int r11) {
            super.writeToParcel(r10, r11);
            r10.writeValue(Boolean.valueOf(this.isIconified));
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static class SearchAutoComplete extends AppCompatAutoCompleteTextView {
        private boolean mHasPendingShowSoftInputRequest;
        final Runnable mRunShowSoftInputIfNecessary;
        private SearchView mSearchView;
        private int mThreshold;

        public SearchAutoComplete(Context r10) {
            this(r10, null);
        }

        public SearchAutoComplete(Context r10, AttributeSet r11) {
            this(r10, r11, R.attr.autoCompleteTextViewStyle);
        }

        public SearchAutoComplete(Context r10, AttributeSet r11, int r12) {
            super(r10, r11, r12);
            this.mRunShowSoftInputIfNecessary = new AnonymousClass1(this);
            this.mThreshold = getThreshold();
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration r10 = getResources().getConfiguration();
            int r11 = r10.screenWidthDp;
            int r12 = r10.screenHeightDp;
            if (r11 < 960) goto L11;
            if (r12 < 720) goto L11;
            if (r10.orientation != 2) goto L11;
            return 256;
        L11:
            if (r11 < 600) goto L13;
            return 192;
        L13:
            if (r11 >= 640) goto L15;
            return 160;
        L15:
            if (r12 >= 480) goto L22;
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
        public InputConnection onCreateInputConnection(EditorInfo r10) {
            InputConnection r11 = super.onCreateInputConnection(r10);
            if (this.mHasPendingShowSoftInputRequest == false) goto L5;
            removeCallbacks(this.mRunShowSoftInputIfNecessary);
            post(this.mRunShowSoftInputIfNecessary);
        L5:
            return r11;
        }

        @Override // android.view.View
        protected void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        protected void onFocusChanged(boolean r10, int r11, Rect r12) {
            super.onFocusChanged(r10, r11, r12);
            this.mSearchView.onTextFocusChanged();
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public boolean onKeyPreIme(int r10, KeyEvent r11) {
            if (r10 != 4) goto L24;
            if (r11.getAction() != 0) goto L13;
            if (r11.getRepeatCount() != 0) goto L13;
            KeyEvent.DispatcherState r12 = getKeyDispatcherState();
            if (r12 == null) goto L11;
            r12.startTracking(r11, this);
        L11:
            return true;
        L13:
            if (r11.getAction() != 1) goto L24;
            KeyEvent.DispatcherState r13 = getKeyDispatcherState();
            if (r13 == null) goto L18;
            r13.handleUpEvent(r11);
        L18:
            if (r11.isTracking() == false) goto L24;
            if (r11.isCanceled() == true) goto L24;
            this.mSearchView.clearFocus();
            setImeVisibility(false);
            return true;
        L24:
            return super.onKeyPreIme(r10, r11);
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onWindowFocusChanged(boolean r10) {
            super.onWindowFocusChanged(r10);
            if (r10 == true) goto L5;
            return;
        L5:
            if (this.mSearchView.hasFocus() == true) goto L7;
            return;
        L7:
            if (getVisibility() != 0) goto L14;
            this.mHasPendingShowSoftInputRequest = true;
            if (SearchView.isLandscapeMode(getContext()) == false) goto L15;
            ensureImeVisible();
            return;
        L15:
            return;
        }

        @Override // android.widget.AutoCompleteTextView
        public void performCompletion() {
        }

        @Override // android.widget.AutoCompleteTextView
        protected void replaceText(CharSequence r10) {
        }

        void setImeVisibility(boolean r10) {
            InputMethodManager r11 = (InputMethodManager) getContext().getSystemService("input_method");
            if (r10 == true) goto L7;
            this.mHasPendingShowSoftInputRequest = false;
            removeCallbacks(this.mRunShowSoftInputIfNecessary);
            r11.hideSoftInputFromWindow(getWindowToken(), 0);
            return;
        L7:
            if (r11.isActive(this) == false) goto L10;
            this.mHasPendingShowSoftInputRequest = false;
            removeCallbacks(this.mRunShowSoftInputIfNecessary);
            r11.showSoftInput(this, 0);
            return;
        L10:
            this.mHasPendingShowSoftInputRequest = true;
        }

        void setSearchView(SearchView r10) {
            this.mSearchView = r10;
        }

        @Override // android.widget.AutoCompleteTextView
        public void setThreshold(int r10) {
            super.setThreshold(r10);
            this.mThreshold = r10;
        }

        void showSoftInputIfNecessary() {
            if (this.mHasPendingShowSoftInputRequest == false) goto L6;
            ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
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

        public UpdatableTouchDelegate(Rect r10, Rect r11, View r12) {
            super(r10, r12);
            this.mSlop = ViewConfiguration.get(r12.getContext()).getScaledTouchSlop();
            this.mTargetBounds = new Rect();
            this.mSlopBounds = new Rect();
            this.mActualBounds = new Rect();
            setBounds(r10, r11);
            this.mDelegateView = r12;
        }

        @Override // android.view.TouchDelegate
        public boolean onTouchEvent(MotionEvent r10) {
            int r11 = (int) r10.getX();
            int r12 = (int) r10.getY();
            int r13 = r10.getAction();
            boolean r14 = true;
            if (r13 == 0) goto L17;
            if (r13 == 1) goto L10;
            if (r13 == 2) goto L10;
            if (r13 != 3) goto L19;
            boolean r15 = this.mDelegateTargeted;
            this.mDelegateTargeted = false;
        L15:
            r14 = r15;
            boolean r16 = true;
        L20:
            if (r14 == false) goto L28;
            if (r16 == true) goto L23;
        L25:
            Rect r17 = this.mActualBounds;
            float r18 = r11 - r17.left;
            int r19 = r12 - r17.top;
        L26:
            r10.setLocation(r18, r19);
            return this.mDelegateView.dispatchTouchEvent(r10);
        L23:
            if (this.mActualBounds.contains(r11, r12) == true) goto L25;
            r18 = this.mDelegateView.getWidth() / 2;
            r19 = this.mDelegateView.getHeight() / 2;
            goto L26
        L28:
            return false;
        L19:
            r16 = true;
            r14 = false;
        L10:
            r15 = this.mDelegateTargeted;
            if (r15 == false) goto L15;
            if (this.mSlopBounds.contains(r11, r12) == true) goto L15;
            r14 = r15;
            r16 = false;
            goto L20
        L17:
            if (this.mTargetBounds.contains(r11, r12) == false) goto L19;
            this.mDelegateTargeted = true;
            r16 = true;
            goto L20
        }

        public void setBounds(Rect r10, Rect r11) {
            this.mTargetBounds.set(r10);
            this.mSlopBounds.set(r10);
            Rect r12 = this.mSlopBounds;
            int r13 = this.mSlop;
            r12.inset(-r13, -r13);
            this.mActualBounds.set(r11);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 29) goto L5;
        PreQAutoCompleteTextViewReflector r10 = new PreQAutoCompleteTextViewReflector();
    L6:
        PRE_API_29_HIDDEN_METHOD_INVOKER = r10;
        return;
    L5:
        r10 = null;
        goto L6
    }

    public SearchView(@NonNull Context r10) {
        this(r10, null);
    }

    public SearchView(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, R.attr.searchViewStyle);
    }

    public SearchView(@NonNull Context r17, @Nullable AttributeSet r18, int r19) {
        super(r17, r18, r19);
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
        int[] r14 = R.styleable.SearchView;
        TintTypedArray r15 = TintTypedArray.obtainStyledAttributes(r17, r18, r14, r19, 0);
        ViewCompat.saveAttributeDataForStyleable(this, r17, r14, r18, r15.getWrappedTypeArray(), r19, 0);
        LayoutInflater.from(r17).inflate(r15.getResourceId(R.styleable.SearchView_layout, R.layout.abc_search_view), this, true);
        SearchAutoComplete r16 = (SearchAutoComplete) findViewById(R.id.search_src_text);
        this.mSearchSrcTextView = r16;
        r16.setSearchView(this);
        this.mSearchEditFrame = findViewById(R.id.search_edit_frame);
        View r20 = findViewById(R.id.search_plate);
        this.mSearchPlate = r20;
        View r21 = findViewById(R.id.submit_area);
        this.mSubmitArea = r21;
        ImageView r22 = (ImageView) findViewById(R.id.search_button);
        this.mSearchButton = r22;
        ImageView r23 = (ImageView) findViewById(R.id.search_go_btn);
        this.mGoButton = r23;
        ImageView r24 = (ImageView) findViewById(R.id.search_close_btn);
        this.mCloseButton = r24;
        ImageView r110 = (ImageView) findViewById(R.id.search_voice_btn);
        this.mVoiceButton = r110;
        ImageView r111 = (ImageView) findViewById(R.id.search_mag_icon);
        this.mCollapsedIcon = r111;
        ViewCompat.setBackground(r20, r15.getDrawable(R.styleable.SearchView_queryBackground));
        ViewCompat.setBackground(r21, r15.getDrawable(R.styleable.SearchView_submitBackground));
        int r25 = R.styleable.SearchView_searchIcon;
        r22.setImageDrawable(r15.getDrawable(r25));
        r23.setImageDrawable(r15.getDrawable(R.styleable.SearchView_goIcon));
        r24.setImageDrawable(r15.getDrawable(R.styleable.SearchView_closeIcon));
        r110.setImageDrawable(r15.getDrawable(R.styleable.SearchView_voiceIcon));
        r111.setImageDrawable(r15.getDrawable(r25));
        this.mSearchHintIcon = r15.getDrawable(R.styleable.SearchView_searchHintIcon);
        TooltipCompat.setTooltipText(r22, getResources().getString(R.string.abc_searchview_description_search));
        this.mSuggestionRowLayout = r15.getResourceId(R.styleable.SearchView_suggestionRowLayout, R.layout.abc_search_dropdown_item_icons_2line);
        this.mSuggestionCommitIconResId = r15.getResourceId(R.styleable.SearchView_commitIcon, 0);
        r22.setOnClickListener(r10);
        r24.setOnClickListener(r10);
        r23.setOnClickListener(r10);
        r110.setOnClickListener(r10);
        r16.setOnClickListener(r10);
        r16.addTextChangedListener(this.mTextWatcher);
        r16.setOnEditorActionListener(r11);
        r16.setOnItemClickListener(r12);
        r16.setOnItemSelectedListener(r13);
        r16.setOnKeyListener(this.mTextKeyListener);
        r16.setOnFocusChangeListener(new AnonymousClass3(this));
        setIconifiedByDefault(r15.getBoolean(R.styleable.SearchView_iconifiedByDefault, true));
        int r26 = r15.getDimensionPixelSize(R.styleable.SearchView_android_maxWidth, -1);
        if (r26 == (-1)) goto L5;
        setMaxWidth(r26);
    L5:
        this.mDefaultQueryHint = r15.getText(R.styleable.SearchView_defaultQueryHint);
        this.mQueryHint = r15.getText(R.styleable.SearchView_queryHint);
        int r27 = r15.getInt(R.styleable.SearchView_android_imeOptions, -1);
        if (r27 == (-1)) goto L8;
        setImeOptions(r27);
    L8:
        int r28 = r15.getInt(R.styleable.SearchView_android_inputType, -1);
        if (r28 == (-1)) goto L11;
        setInputType(r28);
    L11:
        setFocusable(r15.getBoolean(R.styleable.SearchView_android_focusable, true));
        r15.recycle();
        Intent r29 = new Intent("android.speech.action.WEB_SEARCH");
        this.mVoiceWebSearchIntent = r29;
        r29.addFlags(268435456);
        r29.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        Intent r30 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.mVoiceAppSearchIntent = r30;
        r30.addFlags(268435456);
        View r31 = findViewById(r16.getDropDownAnchor());
        this.mDropDownAnchor = r31;
        if (r31 == null) goto L14;
        r31.addOnLayoutChangeListener(new AnonymousClass4(this));
    L14:
        updateViewsVisibility(this.mIconifiedByDefault);
        updateQueryHint();
    }

    private Intent createIntent(String r10, Uri r11, String r12, String r13, int r14, String r15) {
        Intent r16 = new Intent(r10);
        r16.addFlags(268435456);
        if (r11 == null) goto L5;
        r16.setData(r11);
    L5:
        r16.putExtra("user_query", this.mUserQuery);
        if (r13 == null) goto L8;
        r16.putExtra("query", r13);
    L8:
        if (r12 == null) goto L10;
        r16.putExtra("intent_extra_data_key", r12);
    L10:
        Bundle r17 = this.mAppSearchData;
        if (r17 == null) goto L13;
        r16.putExtra("app_data", r17);
    L13:
        if (r14 == 0) goto L15;
        r16.putExtra("action_key", r14);
        r16.putExtra("action_msg", r15);
    L15:
        r16.setComponent(this.mSearchable.getSearchActivity());
        return r16;
    }

    private Intent createIntentFromSuggestion(Cursor r10, int r11, String r12) {
        String r13 = SuggestionsAdapter.getColumnString(r10, "suggest_intent_action");     // Catch: RuntimeException -> L20
        if (r13 != null) goto L6;
        r13 = this.mSearchable.getSuggestIntentAction();     // Catch: RuntimeException -> L20
    L6:
        if (r13 != null) goto L8;
        r13 = "android.intent.action.SEARCH";
    L8:
        String r14 = r13;
        String r15 = SuggestionsAdapter.getColumnString(r10, "suggest_intent_data");     // Catch: RuntimeException -> L20
        if (r15 != null) goto L11;
        r15 = this.mSearchable.getSuggestIntentData();     // Catch: RuntimeException -> L20
    L11:
        if (r15 == null) goto L15;
        String r16 = SuggestionsAdapter.getColumnString(r10, "suggest_intent_data_id");     // Catch: RuntimeException -> L20
        if (r16 == null) goto L15;
        r15 = r15 + "/" + Uri.encode(r16);     // Catch: RuntimeException -> L20
    L15:
        if (r15 != null) goto L17;
        Uri r17 = null;
    L18:
        return createIntent(r14, r17, SuggestionsAdapter.getColumnString(r10, "suggest_intent_extra_data"), SuggestionsAdapter.getColumnString(r10, "suggest_intent_query"), r11, r12);
    L17:
        r17 = Uri.parse(r15);     // Catch: RuntimeException -> L20
    L20:
        e = move-exception;
        int r18 = r10.getPosition();     // Catch: RuntimeException -> L23
    L24:
        Log.w(LOG_TAG, "Search suggestions cursor at row " + r18 + " returned exception.", e);
        return null;
    L23:
        r18 = -1;
        goto L24
    }

    private Intent createVoiceAppSearchIntent(Intent r10, SearchableInfo r11) {
        ComponentName r12 = r11.getSearchActivity();
        Intent r13 = new Intent("android.intent.action.SEARCH");
        r13.setComponent(r12);
        PendingIntent r14 = PendingIntent.getActivity(getContext(), 0, r13, 1107296256);
        Bundle r15 = new Bundle();
        Bundle r16 = this.mAppSearchData;
        if (r16 == null) goto L5;
        r15.putParcelable("app_data", r16);
    L5:
        Intent r17 = new Intent(r10);
        int r18 = 1;
        Resources r19 = getResources();
        if (r11.getVoiceLanguageModeId() == 0) goto L8;
        String r20 = r19.getString(r11.getVoiceLanguageModeId());
    L9:
        String r21 = null;
        if (r11.getVoicePromptTextId() == 0) goto L12;
        String r22 = r19.getString(r11.getVoicePromptTextId());
    L14:
        if (r11.getVoiceLanguageId() == 0) goto L16;
        String r23 = r19.getString(r11.getVoiceLanguageId());
    L18:
        if (r11.getVoiceMaxResults() == 0) goto L20;
        r18 = r11.getVoiceMaxResults();
    L20:
        r17.putExtra("android.speech.extra.LANGUAGE_MODEL", r20);
        r17.putExtra("android.speech.extra.PROMPT", r22);
        r17.putExtra("android.speech.extra.LANGUAGE", r23);
        r17.putExtra("android.speech.extra.MAX_RESULTS", r18);
        if (r12 == null) goto L24;
        r21 = r12.flattenToShortString();
    L24:
        r17.putExtra("calling_package", r21);
        r17.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", r14);
        r17.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", r15);
        return r17;
    L16:
        r23 = null;
        goto L18
    L12:
        r22 = null;
        goto L14
    L8:
        r20 = "free_form";
        goto L9
    }

    private Intent createVoiceWebSearchIntent(Intent r10, SearchableInfo r11) {
        Intent r12 = new Intent(r10);
        ComponentName r13 = r11.getSearchActivity();
        if (r13 != null) goto L5;
        String r14 = null;
    L6:
        r12.putExtra("calling_package", r14);
        return r12;
    L5:
        r14 = r13.flattenToShortString();
        goto L6
    }

    private void dismissSuggestions() {
        this.mSearchSrcTextView.dismissDropDown();
    }

    private void getChildBoundsWithinSearchView(View r10, Rect r11) {
        r10.getLocationInWindow(this.mTemp);
        getLocationInWindow(this.mTemp2);
        int[] r12 = this.mTemp;
        int r13 = r12[1];
        int[] r14 = this.mTemp2;
        int r15 = r13 - r14[1];
        int r16 = r12[0] - r14[0];
        r11.set(r16, r15, r10.getWidth() + r16, r10.getHeight() + r15);
    }

    private CharSequence getDecoratedHint(CharSequence r10) {
        if (this.mIconifiedByDefault == true) goto L5;
    L9:
        return r10;
    L5:
        if (this.mSearchHintIcon == null) goto L9;
        int r11 = (int) (((double) this.mSearchSrcTextView.getTextSize()) * 1.25d);
        this.mSearchHintIcon.setBounds(0, 0, r11, r11);
        SpannableStringBuilder r12 = new SpannableStringBuilder("   ");
        r12.setSpan(new ImageSpan(this.mSearchHintIcon), 1, 2, 33);
        r12.append(r10);
        return r12;
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_height);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_width);
    }

    private boolean hasVoiceSearch() {
        SearchableInfo r10 = this.mSearchable;
        if (r10 != null) goto L5;
        return false;
    L5:
        if (r10.getVoiceSearchEnabled() == false) goto L18;
        Intent r11 = null;
        if (this.mSearchable.getVoiceSearchLaunchWebSearch() == false) goto L10;
        r11 = this.mVoiceWebSearchIntent;
    L12:
        if (r11 != null) goto L14;
        return false;
    L14:
        if (getContext().getPackageManager().resolveActivity(r11, 65536) == null) goto L20;
        return true;
    L20:
        return false;
    L10:
        if (this.mSearchable.getVoiceSearchLaunchRecognizer() == false) goto L12;
        r11 = this.mVoiceAppSearchIntent;
        goto L12
    L18:
        return false;
    }

    static boolean isLandscapeMode(Context r10) {
        if (r10.getResources().getConfiguration().orientation != 2) goto L5;
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

    private void launchIntent(Intent r10) {
        if (r10 != null) goto L9;
        return;
    L9:
        getContext().startActivity(r10);     // Catch: RuntimeException -> L6
        return;
    L6:
        e = move-exception;
        Log.e(LOG_TAG, "Failed launch activity: " + r10, e);
    }

    private boolean launchSuggestion(int r10, int r11, String r12) {
        Cursor r13 = this.mSuggestionsAdapter.getCursor();
        if (r13 != null) goto L5;
        return false;
    L5:
        if (r13.moveToPosition(r10) == false) goto L10;
        launchIntent(createIntentFromSuggestion(r13, r11, r12));
        return true;
    L10:
        return false;
    }

    private void postUpdateFocusedState() {
        post(this.mUpdateDrawableStateRunnable);
    }

    private void rewriteQueryFromSuggestion(int r10) {
        Editable r11 = this.mSearchSrcTextView.getText();
        Cursor r12 = this.mSuggestionsAdapter.getCursor();
        if (r12 != null) goto L6;
        return;
    L6:
        if (r12.moveToPosition(r10) == false) goto L10;
        CharSequence r13 = this.mSuggestionsAdapter.convertToString(r12);
        if (r13 == null) goto L10;
        setQuery(r13);
        return;
    L10:
        setQuery(r11);
    }

    private void setQuery(CharSequence r10) {
        this.mSearchSrcTextView.setText(r10);
        SearchAutoComplete r11 = this.mSearchSrcTextView;
        if (TextUtils.isEmpty(r10) == false) goto L5;
        int r12 = 0;
    L6:
        r11.setSelection(r12);
        return;
    L5:
        r12 = r10.length();
        goto L6
    }

    private void updateCloseButton() {
        boolean r10 = true;
        boolean r11 = !TextUtils.isEmpty(this.mSearchSrcTextView.getText());
        int r12 = 0;
        if (r11 == false) goto L5;
    L10:
        ImageView r13 = this.mCloseButton;
        if (r10 == true) goto L14;
        r12 = 8;
    L14:
        r13.setVisibility(r12);
        Drawable r14 = this.mCloseButton.getDrawable();
        if (r14 == null) goto L21;
        if (r11 == false) goto L18;
        int[] r15 = ViewGroup.ENABLED_STATE_SET;
    L19:
        r14.setState(r15);
        return;
    L18:
        r15 = ViewGroup.EMPTY_STATE_SET;
        goto L19
    L21:
        return;
    L5:
        if (this.mIconifiedByDefault == true) goto L7;
    L9:
        r10 = false;
        goto L10
    L7:
        if (this.mExpandedInActionView == true) goto L9;
        goto L9
    }

    private void updateQueryHint() {
        CharSequence r10 = getQueryHint();
        SearchAutoComplete r11 = this.mSearchSrcTextView;
        if (r10 != null) goto L5;
        r10 = "";
    L5:
        r11.setHint(getDecoratedHint(r10));
    }

    private void updateSearchAutoComplete() {
        this.mSearchSrcTextView.setThreshold(this.mSearchable.getSuggestThreshold());
        this.mSearchSrcTextView.setImeOptions(this.mSearchable.getImeOptions());
        int r10 = this.mSearchable.getInputType();
        int r11 = 1;
        if ((r10 & 15) != 1) goto L7;
        r10 = r10 & (-65537);
        if (this.mSearchable.getSuggestAuthority() == null) goto L7;
        r10 = (r10 | 65536) | 524288;
    L7:
        this.mSearchSrcTextView.setInputType(r10);
        CursorAdapter r12 = this.mSuggestionsAdapter;
        if (r12 == null) goto L11;
        r12.changeCursor(null);
    L11:
        if (this.mSearchable.getSuggestAuthority() == null) goto L17;
        SuggestionsAdapter r13 = new SuggestionsAdapter(getContext(), this, this.mSearchable, this.mOutsideDrawablesCache);
        this.mSuggestionsAdapter = r13;
        this.mSearchSrcTextView.setAdapter(r13);
        SuggestionsAdapter r14 = (SuggestionsAdapter) this.mSuggestionsAdapter;
        if (this.mQueryRefinement == false) goto L15;
        r11 = 2;
    L15:
        r14.setQueryRefinement(r11);
        return;
    }

    private void updateSubmitArea() {
        if (isSubmitAreaEnabled() == true) goto L5;
    L9:
        int r10 = 8;
    L10:
        this.mSubmitArea.setVisibility(r10);
        return;
    L5:
        if (this.mGoButton.getVisibility() != 0) goto L7;
    L8:
        r10 = 0;
        goto L10
    L7:
        if (this.mVoiceButton.getVisibility() != 0) goto L9;
        goto L8
    }

    private void updateSubmitButton(boolean r10) {
        if (this.mSubmitButtonEnabled == true) goto L5;
    L12:
        int r11 = 8;
    L13:
        this.mGoButton.setVisibility(r11);
        return;
    L5:
        if (isSubmitAreaEnabled() == false) goto L12;
        if (hasFocus() == false) goto L12;
        if (r10 == false) goto L10;
    L11:
        r11 = 0;
        goto L13
    L10:
        if (this.mVoiceButtonEnabled == true) goto L12;
        goto L11
    }

    private void updateViewsVisibility(boolean r10) {
        this.mIconified = r10;
        int r11 = 0;
        if (r10 == false) goto L5;
        int r12 = 0;
    L6:
        boolean r13 = !TextUtils.isEmpty(this.mSearchSrcTextView.getText());
        this.mSearchButton.setVisibility(r12);
        updateSubmitButton(r13);
        View r14 = this.mSearchEditFrame;
        if (r10 == false) goto L9;
        int r15 = 8;
    L10:
        r14.setVisibility(r15);
        if (this.mCollapsedIcon.getDrawable() != null) goto L13;
    L14:
        r11 = 8;
    L15:
        this.mCollapsedIcon.setVisibility(r11);
        updateCloseButton();
        updateVoiceButton(!r13);
        updateSubmitArea();
        return;
    L13:
        if (this.mIconifiedByDefault == false) goto L15;
    L9:
        r15 = 0;
        goto L10
    L5:
        r12 = 8;
        goto L6
    }

    private void updateVoiceButton(boolean r10) {
        int r11 = 8;
        if (this.mVoiceButtonEnabled == true) goto L5;
    L8:
        this.mVoiceButton.setVisibility(r11);
        return;
    L5:
        if (isIconified() == true) goto L8;
        if (r10 == false) goto L8;
        this.mGoButton.setVisibility(8);
        r11 = 0;
        goto L8
    }

    void adjustDropDownSizeAndPosition() {
        if (this.mDropDownAnchor.getWidth() <= 1) goto L14;
        Resources r10 = getContext().getResources();
        int r11 = this.mSearchPlate.getPaddingLeft();
        Rect r12 = new Rect();
        boolean r13 = ViewUtils.isLayoutRtl(this);
        if (this.mIconifiedByDefault == false) goto L7;
        int r14 = r10.getDimensionPixelSize(R.dimen.abc_dropdownitem_icon_width) + r10.getDimensionPixelSize(R.dimen.abc_dropdownitem_text_padding_left);
    L8:
        this.mSearchSrcTextView.getDropDownBackground().getPadding(r12);
        int r15 = r12.left;
        if (r13 == false) goto L11;
        int r16 = -r15;
    L12:
        this.mSearchSrcTextView.setDropDownHorizontalOffset(r16);
        int r17 = (((this.mDropDownAnchor.getWidth() + r12.left) + r12.right) + r14) - r11;
        this.mSearchSrcTextView.setDropDownWidth(r17);
        return;
    L11:
        r16 = r11 - (r15 + r14);
        goto L12
    L7:
        r14 = 0;
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
        PreQAutoCompleteTextViewReflector r10 = PRE_API_29_HIDDEN_METHOD_INVOKER;
        r10.doBeforeTextChanged(this.mSearchSrcTextView);
        r10.doAfterTextChanged(this.mSearchSrcTextView);
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

    @Nullable
    public CharSequence getQueryHint() {
        CharSequence r10 = this.mQueryHint;
        if (r10 != null) goto L13;
        SearchableInfo r11 = this.mSearchable;
        if (r11 == null) goto L11;
        if (r11.getHintId() == 0) goto L11;
        return getContext().getText(this.mSearchable.getHintId());
    L11:
        return this.mDefaultQueryHint;
    L13:
        return r10;
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

    void launchQuerySearch(int r10, String r11, String r12) {
        Intent r13 = createIntent("android.intent.action.SEARCH", null, null, r12, r10, r11);
        getContext().startActivity(r13);
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
        int r10 = this.mSearchSrcTextView.getImeOptions();
        this.mCollapsedImeOptions = r10;
        this.mSearchSrcTextView.setImeOptions(r10 | 33554432);
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
        OnCloseListener r10 = this.mOnCloseListener;
        if (r10 != null) goto L9;
    L10:
        clearFocus();
        updateViewsVisibility(true);
        return;
    L9:
        if (r10.onClose() == false) goto L10;
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.mUpdateDrawableStateRunnable);
        post(this.mReleaseCursorRunnable);
        super.onDetachedFromWindow();
    }

    boolean onItemClicked(int r10, int r11, String r12) {
        OnSuggestionListener r13 = this.mOnSuggestionListener;
        if (r13 != null) goto L5;
    L8:
        launchSuggestion(r10, 0, null);
        this.mSearchSrcTextView.setImeVisibility(false);
        dismissSuggestions();
        return true;
    L5:
        if (r13.onSuggestionClick(r10) == false) goto L8;
        return false;
    }

    boolean onItemSelected(int r10) {
        OnSuggestionListener r11 = this.mOnSuggestionListener;
        if (r11 != null) goto L5;
    L9:
        rewriteQueryFromSuggestion(r10);
        return true;
    L5:
        if (r11.onSuggestionSelect(r10) == false) goto L9;
        return false;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
        if (r10 == false) goto L9;
        getChildBoundsWithinSearchView(this.mSearchSrcTextView, this.mSearchSrcTextViewBounds);
        Rect r15 = this.mSearchSrtTextViewBoundsExpanded;
        Rect r16 = this.mSearchSrcTextViewBounds;
        r15.set(r16.left, 0, r16.right, r14 - r12);
        UpdatableTouchDelegate r17 = this.mTouchDelegate;
        if (r17 != null) goto L7;
        UpdatableTouchDelegate r18 = new UpdatableTouchDelegate(this.mSearchSrtTextViewBoundsExpanded, this.mSearchSrcTextViewBounds, this.mSearchSrcTextView);
        this.mTouchDelegate = r18;
        setTouchDelegate(r18);
        return;
    L7:
        r17.setBounds(this.mSearchSrtTextViewBoundsExpanded, this.mSearchSrcTextViewBounds);
        return;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    protected void onMeasure(int r10, int r11) {
        if (isIconified() == false) goto L6;
        super.onMeasure(r10, r11);
        return;
    L6:
        int r12 = View.MeasureSpec.getMode(r10);
        int r13 = View.MeasureSpec.getSize(r10);
        if (r12 == Integer.MIN_VALUE) goto L18;
        if (r12 == 0) goto L14;
        if (r12 != 1073741824) goto L23;
        int r14 = this.mMaxWidth;
        if (r14 <= 0) goto L23;
    L22:
        r13 = Math.min(r14, r13);
    L23:
        int r15 = View.MeasureSpec.getMode(r11);
        int r16 = View.MeasureSpec.getSize(r11);
        if (r15 == Integer.MIN_VALUE) goto L28;
        if (r15 != 0) goto L29;
        r16 = getPreferredHeight();
    L29:
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(r13, 1073741824), View.MeasureSpec.makeMeasureSpec(r16, 1073741824));
        return;
    L28:
        r16 = Math.min(getPreferredHeight(), r16);
        goto L29
    L14:
        r13 = this.mMaxWidth;
        if (r13 > 0) goto L23;
        r13 = getPreferredWidth();
        goto L23
    L18:
        r14 = this.mMaxWidth;
        if (r14 > 0) goto L22;
        r14 = getPreferredWidth();
        goto L22
    }

    protected void onQueryRefine(@Nullable CharSequence r10) {
        setQuery(r10);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable r10) {
        if ((r10 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r10);
        return;
    L6:
        SavedState r11 = (SavedState) r10;
        super.onRestoreInstanceState(r11.getSuperState());
        updateViewsVisibility(r11.isIconified);
        requestLayout();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState r10 = new SavedState(super.onSaveInstanceState());
        r10.isIconified = isIconified();
        return r10;
    }

    void onSearchClicked() {
        updateViewsVisibility(false);
        this.mSearchSrcTextView.requestFocus();
        this.mSearchSrcTextView.setImeVisibility(true);
        View.OnClickListener r10 = this.mOnSearchClickListener;
        if (r10 == null) goto L6;
        r10.onClick(this);
        return;
    }

    void onSubmitQuery() {
        Editable r10 = this.mSearchSrcTextView.getText();
        if (r10 != null) goto L5;
        return;
    L5:
        if (TextUtils.getTrimmedLength(r10) <= 0) goto L16;
        OnQueryTextListener r11 = this.mOnQueryChangeListener;
        if (r11 == null) goto L11;
        if (r11.onQueryTextSubmit(r10.toString()) == false) goto L11;
        return;
    L11:
        if (this.mSearchable == null) goto L13;
        launchQuerySearch(0, null, r10.toString());
    L13:
        this.mSearchSrcTextView.setImeVisibility(false);
        dismissSuggestions();
        return;
    }

    boolean onSuggestionsKey(View r10, int r11, KeyEvent r12) {
        if (this.mSearchable != null) goto L6;
        return false;
    L6:
        if (this.mSuggestionsAdapter != null) goto L9;
        return false;
    L9:
        if (r12.getAction() == 0) goto L11;
    L35:
        return false;
    L11:
        if (r12.hasNoModifiers() == false) goto L35;
        if (r11 == 66) goto L34;
        if (r11 == 84) goto L34;
        if (r11 == 61) goto L34;
        if (r11 != 21) goto L22;
    L28:
        if (r11 != 21) goto L30;
        int r13 = 0;
    L31:
        this.mSearchSrcTextView.setSelection(r13);
        this.mSearchSrcTextView.setListSelection(0);
        this.mSearchSrcTextView.clearListSelection();
        this.mSearchSrcTextView.ensureImeVisible();
        return true;
    L30:
        r13 = this.mSearchSrcTextView.length();
        goto L31
    L22:
        if (r11 == 22) goto L28;
        if (r11 != 19) goto L35;
        this.mSearchSrcTextView.getListSelection();
        return false;
    L34:
        return onItemClicked(this.mSearchSrcTextView.getListSelection(), 0, null);
    }

    void onTextChanged(CharSequence r10) {
        Editable r11 = this.mSearchSrcTextView.getText();
        this.mUserQuery = r11;
        boolean r12 = !TextUtils.isEmpty(r11);
        updateSubmitButton(r12);
        updateVoiceButton(!r12);
        updateCloseButton();
        updateSubmitArea();
        if (this.mOnQueryChangeListener != null) goto L5;
    L7:
        this.mOldQueryText = r10.toString();
        return;
    L5:
        if (TextUtils.equals(r10, this.mOldQueryText) == true) goto L7;
        this.mOnQueryChangeListener.onQueryTextChange(r10.toString());
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
        SearchableInfo r10 = this.mSearchable;
        if (r10 != null) goto L15;
        return;
    L15:
    L13:
        Log.w(LOG_TAG, "Could not find voice search activity");
        return;
    L6:
        if (r10.getVoiceSearchLaunchWebSearch() == false) goto L10;
        Intent r11 = createVoiceWebSearchIntent(this.mVoiceWebSearchIntent, r10);     // Catch: ActivityNotFoundException -> L13
    L8:
        getContext().startActivity(r11);     // Catch: ActivityNotFoundException -> L13
        return;
    L10:
        if (r10.getVoiceSearchLaunchRecognizer() == false) goto L18;
        r11 = createVoiceAppSearchIntent(this.mVoiceAppSearchIntent, r10);     // Catch: ActivityNotFoundException -> L13
        goto L8
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean r10) {
        super.onWindowFocusChanged(r10);
        postUpdateFocusedState();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int r10, Rect r11) {
        if (this.mClearingFocus == false) goto L6;
        return false;
    L6:
        if (isFocusable() == true) goto L9;
        return false;
    L9:
        if (isIconified() == true) goto L15;
        boolean r12 = this.mSearchSrcTextView.requestFocus(r10, r11);
        if (r12 == false) goto L13;
        updateViewsVisibility(false);
    L13:
        return r12;
    L15:
        return super.requestFocus(r10, r11);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setAppSearchData(Bundle r10) {
        this.mAppSearchData = r10;
    }

    public void setIconified(boolean r10) {
        if (r10 == false) goto L4;
        onCloseClicked();
        return;
    L4:
        onSearchClicked();
    }

    public void setIconifiedByDefault(boolean r10) {
        if (this.mIconifiedByDefault != r10) goto L5;
        return;
    L5:
        this.mIconifiedByDefault = r10;
        updateViewsVisibility(r10);
        updateQueryHint();
    }

    public void setImeOptions(int r10) {
        this.mSearchSrcTextView.setImeOptions(r10);
    }

    public void setInputType(int r10) {
        this.mSearchSrcTextView.setInputType(r10);
    }

    public void setMaxWidth(int r10) {
        this.mMaxWidth = r10;
        requestLayout();
    }

    public void setOnCloseListener(OnCloseListener r10) {
        this.mOnCloseListener = r10;
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener r10) {
        this.mOnQueryTextFocusChangeListener = r10;
    }

    public void setOnQueryTextListener(OnQueryTextListener r10) {
        this.mOnQueryChangeListener = r10;
    }

    public void setOnSearchClickListener(View.OnClickListener r10) {
        this.mOnSearchClickListener = r10;
    }

    public void setOnSuggestionListener(OnSuggestionListener r10) {
        this.mOnSuggestionListener = r10;
    }

    public void setQuery(CharSequence r10, boolean r11) {
        this.mSearchSrcTextView.setText(r10);
        if (r10 == null) goto L5;
        SearchAutoComplete r12 = this.mSearchSrcTextView;
        r12.setSelection(r12.length());
        this.mUserQuery = r10;
    L5:
        if (r11 == true) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r10) == true) goto L11;
        onSubmitQuery();
        return;
    }

    public void setQueryHint(@Nullable CharSequence r10) {
        this.mQueryHint = r10;
        updateQueryHint();
    }

    public void setQueryRefinementEnabled(boolean r10) {
        this.mQueryRefinement = r10;
        CursorAdapter r11 = this.mSuggestionsAdapter;
        if ((r11 instanceof SuggestionsAdapter) == false) goto L10;
        SuggestionsAdapter r12 = (SuggestionsAdapter) r11;
        if (r10 == false) goto L7;
        int r13 = 2;
    L8:
        r12.setQueryRefinement(r13);
        return;
    L7:
        r13 = 1;
        goto L8
    }

    public void setSearchableInfo(SearchableInfo r10) {
        this.mSearchable = r10;
        if (r10 == null) goto L5;
        updateSearchAutoComplete();
        updateQueryHint();
    L5:
        boolean r11 = hasVoiceSearch();
        this.mVoiceButtonEnabled = r11;
        if (r11 == false) goto L8;
        this.mSearchSrcTextView.setPrivateImeOptions(IME_OPTION_NO_MICROPHONE);
    L8:
        updateViewsVisibility(isIconified());
    }

    public void setSubmitButtonEnabled(boolean r10) {
        this.mSubmitButtonEnabled = r10;
        updateViewsVisibility(isIconified());
    }

    public void setSuggestionsAdapter(CursorAdapter r10) {
        this.mSuggestionsAdapter = r10;
        this.mSearchSrcTextView.setAdapter(r10);
    }

    void updateFocusedState() {
        if (this.mSearchSrcTextView.hasFocus() == false) goto L5;
        int[] r10 = ViewGroup.FOCUSED_STATE_SET;
    L6:
        Drawable r11 = this.mSearchPlate.getBackground();
        if (r11 == null) goto L9;
        r11.setState(r10);
    L9:
        Drawable r12 = this.mSubmitArea.getBackground();
        if (r12 == null) goto L12;
        r12.setState(r10);
    L12:
        invalidate();
        return;
    L5:
        r10 = ViewGroup.EMPTY_STATE_SET;
        goto L6
    }
}
