package androidx.appcompat.widget;

import ai.j0;
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
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
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
    public static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        public static void refreshAutoCompleteResults(AutoCompleteTextView r5) {
            r5.refreshAutoCompleteResults();
        }

        @DoNotInline
        public static void setInputMethodMode(SearchAutoComplete r5, int r10) {
            r5.setInputMethodMode(r10);
        }
    }

    public interface OnCloseListener {
        boolean onClose();
    }

    public interface OnQueryTextListener {
        boolean onQueryTextChange(String r5);

        boolean onQueryTextSubmit(String r5);
    }

    public interface OnSuggestionListener {
        boolean onSuggestionClick(int r5);

        boolean onSuggestionSelect(int r5);
    }

    public static class PreQAutoCompleteTextViewReflector {
        private Method mDoAfterTextChanged;
        private Method mDoBeforeTextChanged;
        private Method mEnsureImeVisible;

        @SuppressLint({"DiscouragedPrivateApi", "SoonBlockedPrivateApi"})
        public PreQAutoCompleteTextViewReflector() {
            this.mDoBeforeTextChanged = null;
            this.mDoAfterTextChanged = null;
            this.mEnsureImeVisible = null;
            preApi29Check();
            Method r5 = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", null);     // Catch: NoSuchMethodException -> L7
            this.mDoBeforeTextChanged = r5;     // Catch: NoSuchMethodException -> L7
            r5.setAccessible(true);     // Catch: NoSuchMethodException -> L7
        L14:
            Method r10 = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", null);     // Catch: NoSuchMethodException -> L8
            this.mDoAfterTextChanged = r10;     // Catch: NoSuchMethodException -> L8
            r10.setAccessible(true);     // Catch: NoSuchMethodException -> L8
        L12:
            Method r11 = AutoCompleteTextView.class.getMethod("ensureImeVisible", new Class[]{Boolean.TYPE});     // Catch: NoSuchMethodException -> L9
            this.mEnsureImeVisible = r11;     // Catch: NoSuchMethodException -> L9
            r11.setAccessible(true);     // Catch: NoSuchMethodException -> L9
            return;
        }

        private static void preApi29Check() {
            throw new UnsupportedClassVersionError("This function can only be used for API Level < 29.");
        }

        public void doAfterTextChanged(AutoCompleteTextView r5) {
            preApi29Check();
            Method r10 = this.mDoAfterTextChanged;
            if (r10 != null) goto L8;
            return;
        L8:
            r10.invoke(r5, null);     // Catch: Exception -> L7
            return;
        }

        public void doBeforeTextChanged(AutoCompleteTextView r5) {
            preApi29Check();
            Method r10 = this.mDoBeforeTextChanged;
            if (r10 != null) goto L8;
            return;
        L8:
            r10.invoke(r5, null);     // Catch: Exception -> L7
            return;
        }

        public void ensureImeVisible(AutoCompleteTextView r5) {
            preApi29Check();
            Method r10 = this.mEnsureImeVisible;
            if (r10 == null) goto L9;
            r10.invoke(r5, new Object[]{Boolean.TRUE});     // Catch: Exception -> L6
            return;
        L10:
            return;
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        boolean isIconified;

        static {
            CREATOR = new AnonymousClass1();
        }

        public SavedState(Parcelable r5) {
            super(r5);
        }

        public String toString() {
            StringBuilder r5 = new StringBuilder("SearchView.SavedState{");
            r5.append(Integer.toHexString(System.identityHashCode(this)));
            r5.append(" isIconified=");
            return j0.r(r5, this.isIconified, "}");
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r5, int r10) {
            super.writeToParcel(r5, r10);
            r5.writeValue(Boolean.valueOf(this.isIconified));
        }

        public SavedState(Parcel r5, ClassLoader r10) {
            super(r5, r10);
            this.isIconified = ((Boolean) r5.readValue(null)).booleanValue();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static class SearchAutoComplete extends AppCompatAutoCompleteTextView {
        private boolean mHasPendingShowSoftInputRequest;
        final Runnable mRunShowSoftInputIfNecessary;
        private SearchView mSearchView;
        private int mThreshold;

        public SearchAutoComplete(Context r5) {
            this(r5, null);
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration r5 = getResources().getConfiguration();
            int r10 = r5.screenWidthDp;
            int r11 = r5.screenHeightDp;
            if (r10 < 960) goto L11;
            if (r11 < 720) goto L11;
            if (r5.orientation != 2) goto L11;
            return 256;
        L11:
            if (r10 < 600) goto L13;
            return 192;
        L13:
            if (r10 >= 640) goto L15;
            return 160;
        L15:
            if (r11 >= 480) goto L22;
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

        public void ensureImeVisible() {
            Api29Impl.setInputMethodMode(this, 1);
            if (enoughToFilter() == false) goto L6;
            showDropDown();
            return;
        }

        public boolean isEmpty() {
            if (TextUtils.getTrimmedLength(getText()) != 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // androidx.appcompat.widget.AppCompatAutoCompleteTextView, android.widget.TextView, android.view.View
        public InputConnection onCreateInputConnection(EditorInfo r5) {
            InputConnection r10 = super.onCreateInputConnection(r5);
            if (this.mHasPendingShowSoftInputRequest == false) goto L5;
            removeCallbacks(this.mRunShowSoftInputIfNecessary);
            post(this.mRunShowSoftInputIfNecessary);
        L5:
            return r10;
        }

        @Override // android.view.View
        public void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onFocusChanged(boolean r5, int r10, Rect r11) {
            super.onFocusChanged(r5, r10, r11);
            this.mSearchView.onTextFocusChanged();
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public boolean onKeyPreIme(int r5, KeyEvent r10) {
            if (r5 != 4) goto L24;
            if (r10.getAction() != 0) goto L13;
            if (r10.getRepeatCount() != 0) goto L13;
            KeyEvent.DispatcherState r11 = getKeyDispatcherState();
            if (r11 == null) goto L11;
            r11.startTracking(r10, this);
        L11:
            return true;
        L13:
            if (r10.getAction() != 1) goto L24;
            KeyEvent.DispatcherState r12 = getKeyDispatcherState();
            if (r12 == null) goto L18;
            r12.handleUpEvent(r10);
        L18:
            if (r10.isTracking() == false) goto L24;
            if (r10.isCanceled() == true) goto L24;
            this.mSearchView.clearFocus();
            setImeVisibility(false);
            return true;
        L24:
            return super.onKeyPreIme(r5, r10);
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onWindowFocusChanged(boolean r5) {
            super.onWindowFocusChanged(r5);
            if (r5 == true) goto L5;
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
        public void replaceText(CharSequence r5) {
        }

        public void setImeVisibility(boolean r5) {
            InputMethodManager r10 = (InputMethodManager) getContext().getSystemService("input_method");
            if (r5 == true) goto L7;
            this.mHasPendingShowSoftInputRequest = false;
            removeCallbacks(this.mRunShowSoftInputIfNecessary);
            r10.hideSoftInputFromWindow(getWindowToken(), 0);
            return;
        L7:
            if (r10.isActive(this) == false) goto L10;
            this.mHasPendingShowSoftInputRequest = false;
            removeCallbacks(this.mRunShowSoftInputIfNecessary);
            r10.showSoftInput(this, 0);
            return;
        L10:
            this.mHasPendingShowSoftInputRequest = true;
        }

        public void setSearchView(SearchView r5) {
            this.mSearchView = r5;
        }

        @Override // android.widget.AutoCompleteTextView
        public void setThreshold(int r5) {
            super.setThreshold(r5);
            this.mThreshold = r5;
        }

        public void showSoftInputIfNecessary() {
            if (this.mHasPendingShowSoftInputRequest == false) goto L6;
            ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
            this.mHasPendingShowSoftInputRequest = false;
            return;
        }

        public SearchAutoComplete(Context r5, AttributeSet r10) {
            this(r5, r10, R.attr.autoCompleteTextViewStyle);
        }

        public SearchAutoComplete(Context r5, AttributeSet r10, int r11) {
            super(r5, r10, r11);
            this.mRunShowSoftInputIfNecessary = new AnonymousClass1(this);
            this.mThreshold = getThreshold();
        }
    }

    public static class UpdatableTouchDelegate extends TouchDelegate {
        private final Rect mActualBounds;
        private boolean mDelegateTargeted;
        private final View mDelegateView;
        private final int mSlop;
        private final Rect mSlopBounds;
        private final Rect mTargetBounds;

        public UpdatableTouchDelegate(Rect r5, Rect r10, View r11) {
            super(r5, r11);
            this.mSlop = ViewConfiguration.get(r11.getContext()).getScaledTouchSlop();
            this.mTargetBounds = new Rect();
            this.mSlopBounds = new Rect();
            this.mActualBounds = new Rect();
            setBounds(r5, r10);
            this.mDelegateView = r11;
        }

        @Override // android.view.TouchDelegate
        public boolean onTouchEvent(MotionEvent r10) {
            int r5 = (int) r10.getX();
            int r11 = (int) r10.getY();
            int r12 = r10.getAction();
            boolean r13 = true;
            if (r12 == 0) goto L17;
            if (r12 == 1) goto L11;
            if (r12 == 2) goto L11;
            if (r12 != 3) goto L19;
            boolean r14 = this.mDelegateTargeted;
            this.mDelegateTargeted = false;
        L10:
            r13 = r14;
            boolean r15 = true;
        L20:
            if (r13 == false) goto L28;
            if (r15 == true) goto L23;
        L25:
            Rect r16 = this.mActualBounds;
            r10.setLocation(r5 - r16.left, r11 - r16.top);
        L27:
            return this.mDelegateView.dispatchTouchEvent(r10);
        L23:
            if (this.mActualBounds.contains(r5, r11) == true) goto L25;
            r10.setLocation(this.mDelegateView.getWidth() / 2, this.mDelegateView.getHeight() / 2);
            goto L27
        L28:
            return false;
        L19:
            r15 = true;
            r13 = false;
        L11:
            r14 = this.mDelegateTargeted;
            if (r14 == false) goto L10;
            if (this.mSlopBounds.contains(r5, r11) == true) goto L10;
            r13 = r14;
            r15 = false;
            goto L20
        L17:
            if (this.mTargetBounds.contains(r5, r11) == false) goto L19;
            this.mDelegateTargeted = true;
            r15 = true;
            goto L20
        }

        public void setBounds(Rect r5, Rect r10) {
            this.mTargetBounds.set(r5);
            this.mSlopBounds.set(r5);
            Rect r11 = this.mSlopBounds;
            int r12 = this.mSlop;
            r11.inset(-r12, -r12);
            this.mActualBounds.set(r10);
        }
    }

    static {
        PRE_API_29_HIDDEN_METHOD_INVOKER = null;
    }

    public SearchView(@NonNull Context r5) {
        this(r5, null);
    }

    private Intent createIntent(String r5, Uri r10, String r11, String r12, int r13, String r14) {
        Intent r15 = new Intent(r5);
        r15.addFlags(268435456);
        if (r10 == null) goto L5;
        r15.setData(r10);
    L5:
        r15.putExtra("user_query", this.mUserQuery);
        if (r12 == null) goto L8;
        r15.putExtra("query", r12);
    L8:
        if (r11 == null) goto L10;
        r15.putExtra("intent_extra_data_key", r11);
    L10:
        Bundle r16 = this.mAppSearchData;
        if (r16 == null) goto L13;
        r15.putExtra("app_data", r16);
    L13:
        if (r13 == 0) goto L15;
        r15.putExtra("action_key", r13);
        r15.putExtra("action_msg", r14);
    L15:
        r15.setComponent(this.mSearchable.getSearchActivity());
        return r15;
    }

    private Intent createIntentFromSuggestion(Cursor r10, int r11, String r12) {
        String r5 = SuggestionsAdapter.getColumnString(r10, "suggest_intent_action");     // Catch: RuntimeException -> L6
        if (r5 != null) goto L8;
        r5 = this.mSearchable.getSuggestIntentAction();     // Catch: RuntimeException -> L6
    L8:
        if (r5 != null) goto L10;
        r5 = "android.intent.action.SEARCH";
    L10:
        String r13 = r5;
        String r14 = SuggestionsAdapter.getColumnString(r10, "suggest_intent_data");     // Catch: RuntimeException -> L6
        if (r14 != null) goto L13;
        r14 = this.mSearchable.getSuggestIntentData();     // Catch: RuntimeException -> L6
    L13:
        if (r14 == null) goto L17;
        String r15 = SuggestionsAdapter.getColumnString(r10, "suggest_intent_data_id");     // Catch: RuntimeException -> L6
        if (r15 == null) goto L17;
        r14 = r14 + "/" + Uri.encode(r15);     // Catch: RuntimeException -> L6
    L17:
        if (r14 != null) goto L19;
        Uri r16 = null;
    L20:
        return createIntent(r13, r16, SuggestionsAdapter.getColumnString(r10, "suggest_intent_extra_data"), SuggestionsAdapter.getColumnString(r10, "suggest_intent_query"), r11, r12);
    L19:
        r16 = Uri.parse(r14);     // Catch: RuntimeException -> L6
    L6:
        e = move-exception;
        int r17 = r10.getPosition();     // Catch: RuntimeException -> L24
    L25:
        Log.w(LOG_TAG, "Search suggestions cursor at row " + r17 + " returned exception.", e);
        return null;
    L24:
        r17 = -1;
        goto L25
    }

    private Intent createVoiceAppSearchIntent(Intent r10, SearchableInfo r11) {
        ComponentName r5 = r11.getSearchActivity();
        Intent r12 = new Intent("android.intent.action.SEARCH");
        r12.setComponent(r5);
        PendingIntent r13 = PendingIntent.getActivity(getContext(), 0, r12, 1107296256);
        Bundle r14 = new Bundle();
        Bundle r15 = this.mAppSearchData;
        if (r15 == null) goto L5;
        r14.putParcelable("app_data", r15);
    L5:
        Intent r16 = new Intent(r10);
        Resources r17 = getResources();
        if (r11.getVoiceLanguageModeId() == 0) goto L8;
        String r18 = r17.getString(r11.getVoiceLanguageModeId());
    L9:
        String r19 = null;
        if (r11.getVoicePromptTextId() == 0) goto L12;
        String r20 = r17.getString(r11.getVoicePromptTextId());
    L14:
        if (r11.getVoiceLanguageId() == 0) goto L16;
        String r21 = r17.getString(r11.getVoiceLanguageId());
    L18:
        if (r11.getVoiceMaxResults() == 0) goto L20;
        int r22 = r11.getVoiceMaxResults();
    L21:
        r16.putExtra("android.speech.extra.LANGUAGE_MODEL", r18);
        r16.putExtra("android.speech.extra.PROMPT", r20);
        r16.putExtra("android.speech.extra.LANGUAGE", r21);
        r16.putExtra("android.speech.extra.MAX_RESULTS", r22);
        if (r5 == null) goto L25;
        r19 = r5.flattenToShortString();
    L25:
        r16.putExtra("calling_package", r19);
        r16.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", r13);
        r16.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", r14);
        return r16;
    L20:
        r22 = 1;
        goto L21
    L16:
        r21 = null;
        goto L18
    L12:
        r20 = null;
        goto L14
    L8:
        r18 = "free_form";
        goto L9
    }

    private Intent createVoiceWebSearchIntent(Intent r5, SearchableInfo r10) {
        Intent r11 = new Intent(r5);
        ComponentName r12 = r10.getSearchActivity();
        if (r12 != null) goto L5;
        String r13 = null;
    L6:
        r11.putExtra("calling_package", r13);
        return r11;
    L5:
        r13 = r12.flattenToShortString();
        goto L6
    }

    private void dismissSuggestions() {
        this.mSearchSrcTextView.dismissDropDown();
    }

    private void getChildBoundsWithinSearchView(View r5, Rect r10) {
        r5.getLocationInWindow(this.mTemp);
        getLocationInWindow(this.mTemp2);
        int[] r11 = this.mTemp;
        int r12 = r11[1];
        int[] r13 = this.mTemp2;
        int r14 = r12 - r13[1];
        int r15 = r11[0] - r13[0];
        r10.set(r15, r14, r5.getWidth() + r15, r5.getHeight() + r14);
    }

    private CharSequence getDecoratedHint(CharSequence r5) {
        if (this.mIconifiedByDefault == true) goto L5;
    L9:
        return r5;
    L5:
        if (this.mSearchHintIcon == null) goto L9;
        int r10 = (int) (((double) this.mSearchSrcTextView.getTextSize()) * 1.25d);
        this.mSearchHintIcon.setBounds(0, 0, r10, r10);
        SpannableStringBuilder r11 = new SpannableStringBuilder("   ");
        r11.setSpan(new ImageSpan(this.mSearchHintIcon), 1, 2, 33);
        r11.append(r5);
        return r11;
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_height);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_width);
    }

    private boolean hasVoiceSearch() {
        SearchableInfo r5 = this.mSearchable;
        if (r5 != null) goto L5;
        return false;
    L5:
        if (r5.getVoiceSearchEnabled() == true) goto L7;
        return false;
    L7:
        if (this.mSearchable.getVoiceSearchLaunchWebSearch() == false) goto L10;
        Intent r10 = this.mVoiceWebSearchIntent;
    L13:
        if (r10 != null) goto L15;
        return false;
    L15:
        if (getContext().getPackageManager().resolveActivity(r10, 65536) == null) goto L21;
        return true;
    L21:
        return false;
    L10:
        if (this.mSearchable.getVoiceSearchLaunchRecognizer() == false) goto L12;
        r10 = this.mVoiceAppSearchIntent;
        goto L13
    L12:
        r10 = null;
        goto L13
    }

    public static boolean isLandscapeMode(Context r5) {
        if (r5.getResources().getConfiguration().orientation != 2) goto L5;
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

    private void launchIntent(Intent r5) {
        if (r5 != null) goto L9;
        return;
    L9:
        getContext().startActivity(r5);     // Catch: RuntimeException -> L6
        return;
    L6:
        e = move-exception;
        Log.e(LOG_TAG, "Failed launch activity: " + r5, e);
    }

    private boolean launchSuggestion(int r5, int r10, String r11) {
        Cursor r12 = this.mSuggestionsAdapter.getCursor();
        if (r12 != null) goto L5;
        return false;
    L5:
        if (r12.moveToPosition(r5) == false) goto L10;
        launchIntent(createIntentFromSuggestion(r12, r10, r11));
        return true;
    L10:
        return false;
    }

    private void postUpdateFocusedState() {
        post(this.mUpdateDrawableStateRunnable);
    }

    private void rewriteQueryFromSuggestion(int r5) {
        Editable r10 = this.mSearchSrcTextView.getText();
        Cursor r11 = this.mSuggestionsAdapter.getCursor();
        if (r11 != null) goto L6;
        return;
    L6:
        if (r11.moveToPosition(r5) == false) goto L11;
        CharSequence r12 = this.mSuggestionsAdapter.convertToString(r11);
        if (r12 == null) goto L10;
        setQuery(r12);
        return;
    L10:
        setQuery(r10);
        return;
    L11:
        setQuery(r10);
    }

    private void updateCloseButton() {
        boolean r5 = TextUtils.isEmpty(this.mSearchSrcTextView.getText());
        int r10 = 0;
        if (r5 == true) goto L5;
    L10:
        boolean r11 = true;
    L11:
        ImageView r12 = this.mCloseButton;
        if (r11 == true) goto L15;
        r10 = 8;
    L15:
        r12.setVisibility(r10);
        Drawable r13 = this.mCloseButton.getDrawable();
        if (r13 == null) goto L22;
        if (r5 == true) goto L19;
        int[] r14 = ViewGroup.ENABLED_STATE_SET;
    L20:
        r13.setState(r14);
        return;
    L19:
        r14 = ViewGroup.EMPTY_STATE_SET;
        goto L20
    L22:
        return;
    L5:
        if (this.mIconifiedByDefault == true) goto L7;
    L9:
        r11 = false;
        goto L11
    L7:
        if (this.mExpandedInActionView == true) goto L9;
        goto L9
    }

    private void updateQueryHint() {
        CharSequence r5 = getQueryHint();
        SearchAutoComplete r10 = this.mSearchSrcTextView;
        if (r5 != null) goto L5;
        r5 = "";
    L5:
        r10.setHint(getDecoratedHint(r5));
    }

    private void updateSearchAutoComplete() {
        this.mSearchSrcTextView.setThreshold(this.mSearchable.getSuggestThreshold());
        this.mSearchSrcTextView.setImeOptions(this.mSearchable.getImeOptions());
        int r5 = this.mSearchable.getInputType();
        int r10 = 1;
        if ((r5 & 15) != 1) goto L7;
        r5 = r5 & (-65537);
        if (this.mSearchable.getSuggestAuthority() == null) goto L7;
        r5 = r5 | 589824;
    L7:
        this.mSearchSrcTextView.setInputType(r5);
        CursorAdapter r11 = this.mSuggestionsAdapter;
        if (r11 == null) goto L11;
        r11.changeCursor(null);
    L11:
        if (this.mSearchable.getSuggestAuthority() == null) goto L17;
        SuggestionsAdapter r12 = new SuggestionsAdapter(getContext(), this, this.mSearchable, this.mOutsideDrawablesCache);
        this.mSuggestionsAdapter = r12;
        this.mSearchSrcTextView.setAdapter(r12);
        SuggestionsAdapter r13 = (SuggestionsAdapter) this.mSuggestionsAdapter;
        if (this.mQueryRefinement == false) goto L15;
        r10 = 2;
    L15:
        r13.setQueryRefinement(r10);
        return;
    }

    private void updateSubmitArea() {
        if (isSubmitAreaEnabled() == true) goto L5;
    L9:
        int r5 = 8;
    L10:
        this.mSubmitArea.setVisibility(r5);
        return;
    L5:
        if (this.mGoButton.getVisibility() != 0) goto L7;
    L8:
        r5 = 0;
        goto L10
    L7:
        if (this.mVoiceButton.getVisibility() != 0) goto L9;
        goto L8
    }

    private void updateSubmitButton(boolean r5) {
        if (this.mSubmitButtonEnabled == true) goto L5;
    L12:
        int r10 = 8;
    L13:
        this.mGoButton.setVisibility(r10);
        return;
    L5:
        if (isSubmitAreaEnabled() == false) goto L12;
        if (hasFocus() == false) goto L12;
        if (r5 == false) goto L10;
    L11:
        r10 = 0;
        goto L13
    L10:
        if (this.mVoiceButtonEnabled == true) goto L12;
        goto L11
    }

    private void updateViewsVisibility(boolean r10) {
        this.mIconified = r10;
        int r5 = 8;
        if (r10 == false) goto L5;
        int r11 = 0;
    L6:
        boolean r12 = TextUtils.isEmpty(this.mSearchSrcTextView.getText());
        this.mSearchButton.setVisibility(r11);
        updateSubmitButton(!r12);
        View r13 = this.mSearchEditFrame;
        if (r10 == false) goto L9;
        int r14 = 8;
    L10:
        r13.setVisibility(r14);
        if (this.mCollapsedIcon.getDrawable() != null) goto L13;
    L16:
        this.mCollapsedIcon.setVisibility(r5);
        updateCloseButton();
        updateVoiceButton(r12);
        updateSubmitArea();
        return;
    L13:
        if (this.mIconifiedByDefault == true) goto L16;
        r5 = 0;
        goto L16
    L9:
        r14 = 0;
        goto L10
    L5:
        r11 = 8;
        goto L6
    }

    private void updateVoiceButton(boolean r5) {
        int r10 = 8;
        if (this.mVoiceButtonEnabled == true) goto L5;
    L8:
        this.mVoiceButton.setVisibility(r10);
        return;
    L5:
        if (isIconified() == true) goto L8;
        if (r5 == false) goto L8;
        this.mGoButton.setVisibility(8);
        r10 = 0;
        goto L8
    }

    public void adjustDropDownSizeAndPosition() {
        if (this.mDropDownAnchor.getWidth() <= 1) goto L14;
        Resources r5 = getContext().getResources();
        int r10 = this.mSearchPlate.getPaddingLeft();
        Rect r11 = new Rect();
        boolean r12 = ViewUtils.isLayoutRtl(this);
        if (this.mIconifiedByDefault == false) goto L7;
        int r13 = r5.getDimensionPixelSize(R.dimen.abc_dropdownitem_icon_width);
        int r14 = r5.getDimensionPixelSize(R.dimen.abc_dropdownitem_text_padding_left) + r13;
    L8:
        this.mSearchSrcTextView.getDropDownBackground().getPadding(r11);
        if (r12 == false) goto L11;
        int r15 = -r11.left;
    L12:
        this.mSearchSrcTextView.setDropDownHorizontalOffset(r15);
        int r16 = (((this.mDropDownAnchor.getWidth() + r11.left) + r11.right) + r14) - r10;
        this.mSearchSrcTextView.setDropDownWidth(r16);
        return;
    L11:
        r15 = r10 - (r11.left + r14);
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

    public void forceSuggestionQuery() {
        Api29Impl.refreshAutoCompleteResults(this.mSearchSrcTextView);
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
        CharSequence r5 = this.mQueryHint;
        if (r5 != null) goto L13;
        SearchableInfo r10 = this.mSearchable;
        if (r10 == null) goto L11;
        if (r10.getHintId() == 0) goto L11;
        return getContext().getText(this.mSearchable.getHintId());
    L11:
        return this.mDefaultQueryHint;
    L13:
        return r5;
    }

    public int getSuggestionCommitIconResId() {
        return this.mSuggestionCommitIconResId;
    }

    public int getSuggestionRowLayout() {
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

    public void launchQuerySearch(int r10, String r11, String r12) {
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
        int r5 = this.mSearchSrcTextView.getImeOptions();
        this.mCollapsedImeOptions = r5;
        this.mSearchSrcTextView.setImeOptions(r5 | 33554432);
        this.mSearchSrcTextView.setText("");
        setIconified(false);
    }

    public void onCloseClicked() {
        if (TextUtils.isEmpty(this.mSearchSrcTextView.getText()) == true) goto L5;
        this.mSearchSrcTextView.setText("");
        this.mSearchSrcTextView.requestFocus();
        this.mSearchSrcTextView.setImeVisibility(true);
        return;
    L5:
        if (this.mIconifiedByDefault == false) goto L13;
        OnCloseListener r5 = this.mOnCloseListener;
        if (r5 != null) goto L9;
    L10:
        clearFocus();
        updateViewsVisibility(true);
        return;
    L9:
        if (r5.onClose() == false) goto L10;
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.mUpdateDrawableStateRunnable);
        post(this.mReleaseCursorRunnable);
        super.onDetachedFromWindow();
    }

    public boolean onItemClicked(int r5, int r10, String r11) {
        OnSuggestionListener r12 = this.mOnSuggestionListener;
        if (r12 != null) goto L5;
    L8:
        launchSuggestion(r5, 0, null);
        this.mSearchSrcTextView.setImeVisibility(false);
        dismissSuggestions();
        return true;
    L5:
        if (r12.onSuggestionClick(r5) == false) goto L8;
        return false;
    }

    public boolean onItemSelected(int r5) {
        OnSuggestionListener r10 = this.mOnSuggestionListener;
        if (r10 != null) goto L5;
    L9:
        rewriteQueryFromSuggestion(r5);
        return true;
    L5:
        if (r10.onSuggestionSelect(r5) == false) goto L9;
        return false;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
        super.onLayout(r5, r10, r11, r12, r13);
        if (r5 == false) goto L9;
        getChildBoundsWithinSearchView(this.mSearchSrcTextView, this.mSearchSrcTextViewBounds);
        Rect r14 = this.mSearchSrtTextViewBoundsExpanded;
        Rect r15 = this.mSearchSrcTextViewBounds;
        r14.set(r15.left, 0, r15.right, r13 - r11);
        UpdatableTouchDelegate r16 = this.mTouchDelegate;
        if (r16 != null) goto L7;
        UpdatableTouchDelegate r17 = new UpdatableTouchDelegate(this.mSearchSrtTextViewBoundsExpanded, this.mSearchSrcTextViewBounds, this.mSearchSrcTextView);
        this.mTouchDelegate = r17;
        setTouchDelegate(r17);
        return;
    L7:
        r16.setBounds(this.mSearchSrtTextViewBoundsExpanded, this.mSearchSrcTextViewBounds);
        return;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public void onMeasure(int r5, int r10) {
        if (isIconified() == false) goto L6;
        super.onMeasure(r5, r10);
        return;
    L6:
        int r11 = View.MeasureSpec.getMode(r5);
        int r12 = View.MeasureSpec.getSize(r5);
        if (r11 == Integer.MIN_VALUE) goto L18;
        if (r11 == 0) goto L14;
        if (r11 != 1073741824) goto L22;
        int r13 = this.mMaxWidth;
        if (r13 <= 0) goto L22;
        r12 = Math.min(r13, r12);
    L22:
        int r14 = View.MeasureSpec.getMode(r10);
        int r15 = View.MeasureSpec.getSize(r10);
        if (r14 == Integer.MIN_VALUE) goto L27;
        if (r14 != 0) goto L28;
        r15 = getPreferredHeight();
    L28:
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(r12, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(r15, BasicMeasure.EXACTLY));
        return;
    L27:
        r15 = Math.min(getPreferredHeight(), r15);
        goto L28
    L14:
        r12 = this.mMaxWidth;
        if (r12 > 0) goto L22;
        r12 = getPreferredWidth();
        goto L22
    L18:
        int r16 = this.mMaxWidth;
        if (r16 <= 0) goto L21;
        r12 = Math.min(r16, r12);
        goto L22
    L21:
        r12 = Math.min(getPreferredWidth(), r12);
        goto L22
    }

    public void onQueryRefine(@Nullable CharSequence r5) {
        setQuery(r5);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r5) {
        if ((r5 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r5);
        return;
    L6:
        SavedState r10 = (SavedState) r5;
        super.onRestoreInstanceState(r10.getSuperState());
        updateViewsVisibility(r10.isIconified);
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r5 = new SavedState(super.onSaveInstanceState());
        r5.isIconified = isIconified();
        return r5;
    }

    public void onSearchClicked() {
        updateViewsVisibility(false);
        this.mSearchSrcTextView.requestFocus();
        this.mSearchSrcTextView.setImeVisibility(true);
        View.OnClickListener r5 = this.mOnSearchClickListener;
        if (r5 == null) goto L6;
        r5.onClick(this);
        return;
    }

    public void onSubmitQuery() {
        Editable r5 = this.mSearchSrcTextView.getText();
        if (r5 != null) goto L5;
        return;
    L5:
        if (TextUtils.getTrimmedLength(r5) <= 0) goto L16;
        OnQueryTextListener r10 = this.mOnQueryChangeListener;
        if (r10 == null) goto L11;
        if (r10.onQueryTextSubmit(r5.toString()) == false) goto L11;
        return;
    L11:
        if (this.mSearchable == null) goto L13;
        launchQuerySearch(0, null, r5.toString());
    L13:
        this.mSearchSrcTextView.setImeVisibility(false);
        dismissSuggestions();
        return;
    }

    public boolean onSuggestionsKey(View r5, int r10, KeyEvent r11) {
        if (this.mSearchable != null) goto L6;
        return false;
    L6:
        if (this.mSuggestionsAdapter != null) goto L9;
        return false;
    L9:
        if (r11.getAction() == 0) goto L11;
    L35:
        return false;
    L11:
        if (r11.hasNoModifiers() == false) goto L35;
        if (r10 == 66) goto L34;
        if (r10 == 84) goto L34;
        if (r10 == 61) goto L34;
        if (r10 != 21) goto L22;
    L28:
        if (r10 != 21) goto L30;
        int r12 = 0;
    L31:
        this.mSearchSrcTextView.setSelection(r12);
        this.mSearchSrcTextView.setListSelection(0);
        this.mSearchSrcTextView.clearListSelection();
        this.mSearchSrcTextView.ensureImeVisible();
        return true;
    L30:
        r12 = this.mSearchSrcTextView.length();
        goto L31
    L22:
        if (r10 == 22) goto L28;
        if (r10 != 19) goto L35;
        this.mSearchSrcTextView.getListSelection();
        return false;
    L34:
        return onItemClicked(this.mSearchSrcTextView.getListSelection(), 0, null);
    }

    public void onTextChanged(CharSequence r5) {
        Editable r10 = this.mSearchSrcTextView.getText();
        this.mUserQuery = r10;
        boolean r11 = TextUtils.isEmpty(r10);
        updateSubmitButton(!r11);
        updateVoiceButton(r11);
        updateCloseButton();
        updateSubmitArea();
        if (this.mOnQueryChangeListener != null) goto L5;
    L7:
        this.mOldQueryText = r5.toString();
        return;
    L5:
        if (TextUtils.equals(r5, this.mOldQueryText) == true) goto L7;
        this.mOnQueryChangeListener.onQueryTextChange(r5.toString());
        goto L7
    }

    public void onTextFocusChanged() {
        updateViewsVisibility(isIconified());
        postUpdateFocusedState();
        if (this.mSearchSrcTextView.hasFocus() == false) goto L6;
        forceSuggestionQuery();
        return;
    }

    public void onVoiceClicked() {
        SearchableInfo r5 = this.mSearchable;
        if (r5 != null) goto L15;
        return;
    L15:
    L12:
        Log.w(LOG_TAG, "Could not find voice search activity");
        return;
    L6:
        if (r5.getVoiceSearchLaunchWebSearch() == false) goto L9;
        Intent r10 = createVoiceWebSearchIntent(this.mVoiceWebSearchIntent, r5);     // Catch: ActivityNotFoundException -> L12
        getContext().startActivity(r10);     // Catch: ActivityNotFoundException -> L12
    L14:
        return;
    L9:
        if (r5.getVoiceSearchLaunchRecognizer() == false) goto L14;
        Intent r11 = createVoiceAppSearchIntent(this.mVoiceAppSearchIntent, r5);     // Catch: ActivityNotFoundException -> L12
        getContext().startActivity(r11);     // Catch: ActivityNotFoundException -> L12
        goto L14
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean r5) {
        super.onWindowFocusChanged(r5);
        postUpdateFocusedState();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int r5, Rect r10) {
        if (this.mClearingFocus == false) goto L6;
        return false;
    L6:
        if (isFocusable() == true) goto L9;
        return false;
    L9:
        if (isIconified() == true) goto L15;
        boolean r11 = this.mSearchSrcTextView.requestFocus(r5, r10);
        if (r11 == false) goto L13;
        updateViewsVisibility(false);
    L13:
        return r11;
    L15:
        return super.requestFocus(r5, r10);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setAppSearchData(Bundle r5) {
        this.mAppSearchData = r5;
    }

    public void setIconified(boolean r5) {
        if (r5 == false) goto L4;
        onCloseClicked();
        return;
    L4:
        onSearchClicked();
    }

    public void setIconifiedByDefault(boolean r5) {
        if (this.mIconifiedByDefault != r5) goto L5;
        return;
    L5:
        this.mIconifiedByDefault = r5;
        updateViewsVisibility(r5);
        updateQueryHint();
    }

    public void setImeOptions(int r5) {
        this.mSearchSrcTextView.setImeOptions(r5);
    }

    public void setInputType(int r5) {
        this.mSearchSrcTextView.setInputType(r5);
    }

    public void setMaxWidth(int r5) {
        this.mMaxWidth = r5;
        requestLayout();
    }

    public void setOnCloseListener(OnCloseListener r5) {
        this.mOnCloseListener = r5;
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener r5) {
        this.mOnQueryTextFocusChangeListener = r5;
    }

    public void setOnQueryTextListener(OnQueryTextListener r5) {
        this.mOnQueryChangeListener = r5;
    }

    public void setOnSearchClickListener(View.OnClickListener r5) {
        this.mOnSearchClickListener = r5;
    }

    public void setOnSuggestionListener(OnSuggestionListener r5) {
        this.mOnSuggestionListener = r5;
    }

    public void setQuery(CharSequence r5, boolean r10) {
        this.mSearchSrcTextView.setText(r5);
        if (r5 == null) goto L5;
        SearchAutoComplete r11 = this.mSearchSrcTextView;
        r11.setSelection(r11.length());
        this.mUserQuery = r5;
    L5:
        if (r10 == true) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r5) == true) goto L11;
        onSubmitQuery();
        return;
    }

    public void setQueryHint(@Nullable CharSequence r5) {
        this.mQueryHint = r5;
        updateQueryHint();
    }

    public void setQueryRefinementEnabled(boolean r5) {
        this.mQueryRefinement = r5;
        CursorAdapter r10 = this.mSuggestionsAdapter;
        if ((r10 instanceof SuggestionsAdapter) == false) goto L10;
        SuggestionsAdapter r11 = (SuggestionsAdapter) r10;
        if (r5 == false) goto L7;
        int r12 = 2;
    L8:
        r11.setQueryRefinement(r12);
        return;
    L7:
        r12 = 1;
        goto L8
    }

    public void setSearchableInfo(SearchableInfo r5) {
        this.mSearchable = r5;
        if (r5 == null) goto L5;
        updateSearchAutoComplete();
        updateQueryHint();
    L5:
        boolean r10 = hasVoiceSearch();
        this.mVoiceButtonEnabled = r10;
        if (r10 == false) goto L8;
        this.mSearchSrcTextView.setPrivateImeOptions(IME_OPTION_NO_MICROPHONE);
    L8:
        updateViewsVisibility(isIconified());
    }

    public void setSubmitButtonEnabled(boolean r5) {
        this.mSubmitButtonEnabled = r5;
        updateViewsVisibility(isIconified());
    }

    public void setSuggestionsAdapter(CursorAdapter r5) {
        this.mSuggestionsAdapter = r5;
        this.mSearchSrcTextView.setAdapter(r5);
    }

    public void updateFocusedState() {
        if (this.mSearchSrcTextView.hasFocus() == false) goto L5;
        int[] r5 = ViewGroup.FOCUSED_STATE_SET;
    L6:
        Drawable r10 = this.mSearchPlate.getBackground();
        if (r10 == null) goto L9;
        r10.setState(r5);
    L9:
        Drawable r11 = this.mSubmitArea.getBackground();
        if (r11 == null) goto L12;
        r11.setState(r5);
    L12:
        invalidate();
        return;
    L5:
        r5 = ViewGroup.EMPTY_STATE_SET;
        goto L6
    }

    public SearchView(@NonNull Context r5, @Nullable AttributeSet r10) {
        this(r5, r10, R.attr.searchViewStyle);
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
        TintTypedArray r14 = TintTypedArray.obtainStyledAttributes(r17, r18, R.styleable.SearchView, r19, 0);
        ViewCompat.saveAttributeDataForStyleable(this, r17, R.styleable.SearchView, r18, r14.getWrappedTypeArray(), r19, 0);
        LayoutInflater.from(r17).inflate(r14.getResourceId(R.styleable.SearchView_layout, R.layout.abc_search_view), this, true);
        SearchAutoComplete r5 = (SearchAutoComplete) findViewById(R.id.search_src_text);
        this.mSearchSrcTextView = r5;
        r5.setSearchView(this);
        this.mSearchEditFrame = findViewById(R.id.search_edit_frame);
        View r15 = findViewById(R.id.search_plate);
        this.mSearchPlate = r15;
        View r16 = findViewById(R.id.submit_area);
        this.mSubmitArea = r16;
        ImageView r20 = (ImageView) findViewById(R.id.search_button);
        this.mSearchButton = r20;
        ImageView r21 = (ImageView) findViewById(R.id.search_go_btn);
        this.mGoButton = r21;
        ImageView r22 = (ImageView) findViewById(R.id.search_close_btn);
        this.mCloseButton = r22;
        ImageView r110 = (ImageView) findViewById(R.id.search_voice_btn);
        this.mVoiceButton = r110;
        ImageView r111 = (ImageView) findViewById(R.id.search_mag_icon);
        this.mCollapsedIcon = r111;
        ViewCompat.setBackground(r15, r14.getDrawable(R.styleable.SearchView_queryBackground));
        ViewCompat.setBackground(r16, r14.getDrawable(R.styleable.SearchView_submitBackground));
        r20.setImageDrawable(r14.getDrawable(R.styleable.SearchView_searchIcon));
        r21.setImageDrawable(r14.getDrawable(R.styleable.SearchView_goIcon));
        r22.setImageDrawable(r14.getDrawable(R.styleable.SearchView_closeIcon));
        r110.setImageDrawable(r14.getDrawable(R.styleable.SearchView_voiceIcon));
        r111.setImageDrawable(r14.getDrawable(R.styleable.SearchView_searchIcon));
        this.mSearchHintIcon = r14.getDrawable(R.styleable.SearchView_searchHintIcon);
        TooltipCompat.setTooltipText(r20, getResources().getString(R.string.abc_searchview_description_search));
        this.mSuggestionRowLayout = r14.getResourceId(R.styleable.SearchView_suggestionRowLayout, R.layout.abc_search_dropdown_item_icons_2line);
        this.mSuggestionCommitIconResId = r14.getResourceId(R.styleable.SearchView_commitIcon, 0);
        r20.setOnClickListener(r10);
        r22.setOnClickListener(r10);
        r21.setOnClickListener(r10);
        r110.setOnClickListener(r10);
        r5.setOnClickListener(r10);
        r5.addTextChangedListener(this.mTextWatcher);
        r5.setOnEditorActionListener(r11);
        r5.setOnItemClickListener(r12);
        r5.setOnItemSelectedListener(r13);
        r5.setOnKeyListener(this.mTextKeyListener);
        r5.setOnFocusChangeListener(new AnonymousClass3(this));
        setIconifiedByDefault(r14.getBoolean(R.styleable.SearchView_iconifiedByDefault, true));
        int r23 = r14.getDimensionPixelSize(R.styleable.SearchView_android_maxWidth, -1);
        if (r23 == (-1)) goto L5;
        setMaxWidth(r23);
    L5:
        this.mDefaultQueryHint = r14.getText(R.styleable.SearchView_defaultQueryHint);
        this.mQueryHint = r14.getText(R.styleable.SearchView_queryHint);
        int r24 = r14.getInt(R.styleable.SearchView_android_imeOptions, -1);
        if (r24 == (-1)) goto L8;
        setImeOptions(r24);
    L8:
        int r25 = r14.getInt(R.styleable.SearchView_android_inputType, -1);
        if (r25 == (-1)) goto L11;
        setInputType(r25);
    L11:
        setFocusable(r14.getBoolean(R.styleable.SearchView_android_focusable, true));
        r14.recycle();
        Intent r26 = new Intent("android.speech.action.WEB_SEARCH");
        this.mVoiceWebSearchIntent = r26;
        r26.addFlags(268435456);
        r26.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        Intent r27 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.mVoiceAppSearchIntent = r27;
        r27.addFlags(268435456);
        View r28 = findViewById(r5.getDropDownAnchor());
        this.mDropDownAnchor = r28;
        if (r28 == null) goto L14;
        r28.addOnLayoutChangeListener(new AnonymousClass4(this));
    L14:
        updateViewsVisibility(this.mIconifiedByDefault);
        updateQueryHint();
    }

    private void setQuery(CharSequence r5) {
        this.mSearchSrcTextView.setText(r5);
        SearchAutoComplete r10 = this.mSearchSrcTextView;
        if (TextUtils.isEmpty(r5) == false) goto L5;
        int r11 = 0;
    L6:
        r10.setSelection(r11);
        return;
    L5:
        r11 = r5.length();
        goto L6
    }
}
