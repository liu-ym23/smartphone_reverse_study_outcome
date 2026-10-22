package androidx.appcompat.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.SpinnerAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.ActionBarPolicy;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.ViewPropertyAnimatorCompatSet;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.DecorToolbar;
import androidx.appcompat.widget.ScrollingTabContainerView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.ViewPropertyAnimatorUpdateListener;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class WindowDecorActionBar extends ActionBar implements ActionBarOverlayLayout.ActionBarVisibilityCallback {
    private static final long FADE_IN_DURATION_MS = 200;
    private static final long FADE_OUT_DURATION_MS = 100;
    private static final int INVALID_POSITION = -1;
    private static final String TAG = "WindowDecorActionBar";
    private static final Interpolator sHideInterpolator = null;
    private static final Interpolator sShowInterpolator = null;
    ActionModeImpl mActionMode;
    private Activity mActivity;
    ActionBarContainer mContainerView;
    boolean mContentAnimations;
    View mContentView;
    Context mContext;
    ActionBarContextView mContextView;
    private int mCurWindowVisibility;
    ViewPropertyAnimatorCompatSet mCurrentShowAnim;
    DecorToolbar mDecorToolbar;
    ActionMode mDeferredDestroyActionMode;
    ActionMode.Callback mDeferredModeDestroyCallback;
    private boolean mDisplayHomeAsUpSet;
    private boolean mHasEmbeddedTabs;
    boolean mHiddenByApp;
    boolean mHiddenBySystem;
    final ViewPropertyAnimatorListener mHideListener;
    boolean mHideOnContentScroll;
    private boolean mLastMenuVisibility;
    private ArrayList<ActionBar.OnMenuVisibilityListener> mMenuVisibilityListeners;
    private boolean mNowShowing;
    ActionBarOverlayLayout mOverlayLayout;
    private int mSavedTabPosition;
    private TabImpl mSelectedTab;
    private boolean mShowHideAnimationEnabled;
    final ViewPropertyAnimatorListener mShowListener;
    private boolean mShowingForMode;
    ScrollingTabContainerView mTabScrollView;
    private ArrayList<TabImpl> mTabs;
    private Context mThemedContext;
    final ViewPropertyAnimatorUpdateListener mUpdateListener;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public class ActionModeImpl extends ActionMode implements MenuBuilder.Callback {
        private final Context mActionModeContext;
        private ActionMode.Callback mCallback;
        private WeakReference<View> mCustomView;
        private final MenuBuilder mMenu;
        final /* synthetic */ WindowDecorActionBar this$0;

        public ActionModeImpl(WindowDecorActionBar r10, Context r11, ActionMode.Callback r12) {
            this.this$0 = r10;
            this.mActionModeContext = r11;
            this.mCallback = r12;
            MenuBuilder r13 = new MenuBuilder(r11).setDefaultShowAsAction(1);
            this.mMenu = r13;
            r13.setCallback(this);
        }

        public boolean dispatchOnCreate() {
            this.mMenu.stopDispatchingItemsChanged();
            boolean r10 = this.mCallback.onCreateActionMode(this, this.mMenu);     // Catch: Throwable -> L6
            this.mMenu.startDispatchingItemsChanged();
            return r10;
        L6:
            th = move-exception;
            this.mMenu.startDispatchingItemsChanged();
            throw th;
        }

        @Override // androidx.appcompat.view.ActionMode
        public void finish() {
            WindowDecorActionBar r10 = this.this$0;
            if (r10.mActionMode == this) goto L6;
            return;
        L6:
            if (WindowDecorActionBar.checkShowingFlags(r10.mHiddenByApp, r10.mHiddenBySystem, false) == true) goto L8;
            WindowDecorActionBar r11 = this.this$0;
            r11.mDeferredDestroyActionMode = this;
            r11.mDeferredModeDestroyCallback = this.mCallback;
        L9:
            this.mCallback = null;
            this.this$0.animateToMode(false);
            this.this$0.mContextView.closeMode();
            WindowDecorActionBar r12 = this.this$0;
            r12.mOverlayLayout.setHideOnContentScrollEnabled(r12.mHideOnContentScroll);
            this.this$0.mActionMode = null;
            return;
        L8:
            this.mCallback.onDestroyActionMode(this);
            goto L9
        }

        @Override // androidx.appcompat.view.ActionMode
        public View getCustomView() {
            WeakReference<View> r10 = this.mCustomView;
            if (r10 != null) goto L7;
            return null;
        L7:
            return r10.get();
        }

        @Override // androidx.appcompat.view.ActionMode
        public Menu getMenu() {
            return this.mMenu;
        }

        @Override // androidx.appcompat.view.ActionMode
        public MenuInflater getMenuInflater() {
            return new SupportMenuInflater(this.mActionModeContext);
        }

        @Override // androidx.appcompat.view.ActionMode
        public CharSequence getSubtitle() {
            return this.this$0.mContextView.getSubtitle();
        }

        @Override // androidx.appcompat.view.ActionMode
        public CharSequence getTitle() {
            return this.this$0.mContextView.getTitle();
        }

        @Override // androidx.appcompat.view.ActionMode
        public void invalidate() {
            if (this.this$0.mActionMode == this) goto L5;
            return;
        L5:
            this.mMenu.stopDispatchingItemsChanged();
            this.mCallback.onPrepareActionMode(this, this.mMenu);     // Catch: Throwable -> L9
            this.mMenu.startDispatchingItemsChanged();
            return;
        L9:
            th = move-exception;
            this.mMenu.startDispatchingItemsChanged();
            throw th;
        }

        @Override // androidx.appcompat.view.ActionMode
        public boolean isTitleOptional() {
            return this.this$0.mContextView.isTitleOptional();
        }

        public void onCloseMenu(MenuBuilder r10, boolean r11) {
        }

        public void onCloseSubMenu(SubMenuBuilder r10) {
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public boolean onMenuItemSelected(@NonNull MenuBuilder r10, @NonNull MenuItem r11) {
            ActionMode.Callback r12 = this.mCallback;
            if (r12 != null) goto L5;
            return false;
        L5:
            return r12.onActionItemClicked(this, r11);
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public void onMenuModeChange(@NonNull MenuBuilder r10) {
            if (this.mCallback != null) goto L5;
            return;
        L5:
            invalidate();
            this.this$0.mContextView.showOverflowMenu();
        }

        public boolean onSubMenuSelected(SubMenuBuilder r10) {
            if (this.mCallback != null) goto L7;
            return false;
        L7:
            if (r10.hasVisibleItems() == true) goto L9;
            return true;
        L9:
            new MenuPopupHelper(this.this$0.getThemedContext(), r10).show();
            return true;
        }

        @Override // androidx.appcompat.view.ActionMode
        public void setCustomView(View r10) {
            this.this$0.mContextView.setCustomView(r10);
            this.mCustomView = new WeakReference(r10);
        }

        @Override // androidx.appcompat.view.ActionMode
        public void setSubtitle(int r10) {
            setSubtitle(this.this$0.mContext.getResources().getString(r10));
        }

        @Override // androidx.appcompat.view.ActionMode
        public void setSubtitle(CharSequence r10) {
            this.this$0.mContextView.setSubtitle(r10);
        }

        @Override // androidx.appcompat.view.ActionMode
        public void setTitle(int r10) {
            setTitle(this.this$0.mContext.getResources().getString(r10));
        }

        @Override // androidx.appcompat.view.ActionMode
        public void setTitle(CharSequence r10) {
            this.this$0.mContextView.setTitle(r10);
        }

        @Override // androidx.appcompat.view.ActionMode
        public void setTitleOptionalHint(boolean r10) {
            super.setTitleOptionalHint(r10);
            this.this$0.mContextView.setTitleOptional(r10);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public class TabImpl extends ActionBar.Tab {
        private ActionBar.TabListener mCallback;
        private CharSequence mContentDesc;
        private View mCustomView;
        private Drawable mIcon;
        private int mPosition;
        private Object mTag;
        private CharSequence mText;
        final /* synthetic */ WindowDecorActionBar this$0;

        public TabImpl(WindowDecorActionBar r10) {
            this.this$0 = r10;
            this.mPosition = -1;
        }

        public ActionBar.TabListener getCallback() {
            return this.mCallback;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public CharSequence getContentDescription() {
            return this.mContentDesc;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public View getCustomView() {
            return this.mCustomView;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public Drawable getIcon() {
            return this.mIcon;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public int getPosition() {
            return this.mPosition;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public Object getTag() {
            return this.mTag;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public CharSequence getText() {
            return this.mText;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public void select() {
            this.this$0.selectTab(this);
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setContentDescription(int r10) {
            return setContentDescription(this.this$0.mContext.getResources().getText(r10));
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setContentDescription(CharSequence r10) {
            this.mContentDesc = r10;
            int r11 = this.mPosition;
            if (r11 < 0) goto L5;
            this.this$0.mTabScrollView.updateTab(r11);
        L5:
            return this;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setCustomView(int r10) {
            return setCustomView(LayoutInflater.from(this.this$0.getThemedContext()).inflate(r10, null));
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setCustomView(View r10) {
            this.mCustomView = r10;
            int r11 = this.mPosition;
            if (r11 < 0) goto L5;
            this.this$0.mTabScrollView.updateTab(r11);
        L5:
            return this;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setIcon(int r10) {
            return setIcon(AppCompatResources.getDrawable(this.this$0.mContext, r10));
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setIcon(Drawable r10) {
            this.mIcon = r10;
            int r11 = this.mPosition;
            if (r11 < 0) goto L5;
            this.this$0.mTabScrollView.updateTab(r11);
        L5:
            return this;
        }

        public void setPosition(int r10) {
            this.mPosition = r10;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setTabListener(ActionBar.TabListener r10) {
            this.mCallback = r10;
            return this;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setTag(Object r10) {
            this.mTag = r10;
            return this;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setText(int r10) {
            return setText(this.this$0.mContext.getResources().getText(r10));
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setText(CharSequence r10) {
            this.mText = r10;
            int r11 = this.mPosition;
            if (r11 < 0) goto L5;
            this.this$0.mTabScrollView.updateTab(r11);
        L5:
            return this;
        }
    }

    static {
        sHideInterpolator = new AccelerateInterpolator();
        sShowInterpolator = new DecelerateInterpolator();
    }

    public WindowDecorActionBar(Activity r10, boolean r11) {
        this.mTabs = new ArrayList();
        this.mSavedTabPosition = -1;
        this.mMenuVisibilityListeners = new ArrayList();
        this.mCurWindowVisibility = 0;
        this.mContentAnimations = true;
        this.mNowShowing = true;
        this.mHideListener = new AnonymousClass1(this);
        this.mShowListener = new AnonymousClass2(this);
        this.mUpdateListener = new AnonymousClass3(this);
        this.mActivity = r10;
        View r12 = r10.getWindow().getDecorView();
        init(r12);
        if (r11 == true) goto L6;
        this.mContentView = r12.findViewById(R.id.content);
        return;
    }

    public WindowDecorActionBar(Dialog r10) {
        this.mTabs = new ArrayList();
        this.mSavedTabPosition = -1;
        this.mMenuVisibilityListeners = new ArrayList();
        this.mCurWindowVisibility = 0;
        this.mContentAnimations = true;
        this.mNowShowing = true;
        this.mHideListener = new AnonymousClass1(this);
        this.mShowListener = new AnonymousClass2(this);
        this.mUpdateListener = new AnonymousClass3(this);
        init(r10.getWindow().getDecorView());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public WindowDecorActionBar(View r10) {
        this.mTabs = new ArrayList();
        this.mSavedTabPosition = -1;
        this.mMenuVisibilityListeners = new ArrayList();
        this.mCurWindowVisibility = 0;
        this.mContentAnimations = true;
        this.mNowShowing = true;
        this.mHideListener = new AnonymousClass1(this);
        this.mShowListener = new AnonymousClass2(this);
        this.mUpdateListener = new AnonymousClass3(this);
        init(r10);
    }

    static boolean checkShowingFlags(boolean r10, boolean r11, boolean r12) {
        if (r12 == false) goto L5;
        return true;
    L5:
        if (r10 == true) goto L9;
        if (r11 == true) goto L11;
        return true;
    L11:
        return false;
    L9:
        return false;
    }

    private void cleanupTabs() {
        if (this.mSelectedTab == null) goto L5;
        selectTab(null);
    L5:
        this.mTabs.clear();
        ScrollingTabContainerView r10 = this.mTabScrollView;
        if (r10 == null) goto L8;
        r10.removeAllTabs();
    L8:
        this.mSavedTabPosition = -1;
    }

    private void configureTab(ActionBar.Tab r10, int r11) {
        TabImpl r12 = (TabImpl) r10;
        if (r12.getCallback() == null) goto L10;
        r12.setPosition(r11);
        this.mTabs.add(r11, r12);
        int r13 = this.mTabs.size();
    L5:
        r11 = r11 + 1;
        if (r11 >= r13) goto L8;
        this.mTabs.get(r11).setPosition(r11);
        goto L5
    L8:
        return;
    L10:
        throw new IllegalStateException("Action Bar Tab must have a Callback");
    }

    private void ensureTabsExist() {
        if (this.mTabScrollView == null) goto L5;
        return;
    L5:
        ScrollingTabContainerView r10 = new ScrollingTabContainerView(this.mContext);
        if (this.mHasEmbeddedTabs == false) goto L9;
        r10.setVisibility(0);
        this.mDecorToolbar.setEmbeddedTabView(r10);
    L15:
        this.mTabScrollView = r10;
        return;
    L9:
        if (getNavigationMode() != 2) goto L13;
        r10.setVisibility(0);
        ActionBarOverlayLayout r11 = this.mOverlayLayout;
        if (r11 == null) goto L14;
        ViewCompat.requestApplyInsets(r11);
    L14:
        this.mContainerView.setTabContainer(r10);
        goto L15
    L13:
        r10.setVisibility(8);
        goto L14
    }

    /* JADX WARN: Multi-variable type inference failed */
    private DecorToolbar getDecorToolbar(View r10) {
        if ((r10 instanceof DecorToolbar) == false) goto L7;
        return (DecorToolbar) r10;
    L7:
        if ((r10 instanceof Toolbar) == true) goto L9;
        StringBuilder r11 = new StringBuilder();
        r11.append("Can't make a decor toolbar out of ");
        if (r10 == 0) goto L13;
        String r12 = r10.getClass().getSimpleName();
    L14:
        r11.append(r12);
        throw new IllegalStateException(r11.toString());
    L13:
        r12 = "null";
        goto L14
    L9:
        return ((Toolbar) r10).getWrapper();
    }

    private void hideForActionMode() {
        if (this.mShowingForMode == false) goto L9;
        this.mShowingForMode = false;
        ActionBarOverlayLayout r10 = this.mOverlayLayout;
        if (r10 == null) goto L7;
        r10.setShowingForActionMode(false);
    L7:
        updateVisibility(false);
        return;
    }

    private void init(View r10) {
        ActionBarOverlayLayout r11 = (ActionBarOverlayLayout) r10.findViewById(androidx.appcompat.R.id.decor_content_parent);
        this.mOverlayLayout = r11;
        if (r11 == null) goto L5;
        r11.setActionBarVisibilityCallback(this);
    L5:
        this.mDecorToolbar = getDecorToolbar(r10.findViewById(androidx.appcompat.R.id.action_bar));
        this.mContextView = (ActionBarContextView) r10.findViewById(androidx.appcompat.R.id.action_context_bar);
        ActionBarContainer r12 = (ActionBarContainer) r10.findViewById(androidx.appcompat.R.id.action_bar_container);
        this.mContainerView = r12;
        DecorToolbar r13 = this.mDecorToolbar;
        if (r13 == null) goto L31;
        if (this.mContextView == null) goto L31;
        if (r12 == null) goto L31;
        this.mContext = r13.getContext();
        if ((this.mDecorToolbar.getDisplayOptions() & 4) == 0) goto L13;
        boolean r14 = true;
    L14:
        if (r14 == false) goto L16;
        this.mDisplayHomeAsUpSet = true;
    L16:
        ActionBarPolicy r15 = ActionBarPolicy.get(this.mContext);
        if (r15.enableHomeButtonByDefault() == true) goto L21;
        if (r14 == true) goto L21;
        boolean r16 = false;
    L22:
        setHomeButtonEnabled(r16);
        setHasEmbeddedTabs(r15.hasEmbeddedTabs());
        TypedArray r17 = this.mContext.obtainStyledAttributes(null, androidx.appcompat.R.styleable.ActionBar, androidx.appcompat.R.attr.actionBarStyle, 0);
        if (r17.getBoolean(androidx.appcompat.R.styleable.ActionBar_hideOnContentScroll, false) == false) goto L25;
        setHideOnContentScrollEnabled(true);
    L25:
        int r18 = r17.getDimensionPixelSize(androidx.appcompat.R.styleable.ActionBar_elevation, 0);
        if (r18 == 0) goto L28;
        setElevation(r18);
    L28:
        r17.recycle();
        return;
    L21:
        r16 = true;
        goto L22
    L13:
        r14 = false;
    L31:
        throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
    }

    private void setHasEmbeddedTabs(boolean r10) {
        this.mHasEmbeddedTabs = r10;
        if (r10 == true) goto L5;
        this.mDecorToolbar.setEmbeddedTabView(null);
        this.mContainerView.setTabContainer(this.mTabScrollView);
    L6:
        boolean r11 = true;
        if (getNavigationMode() != 2) goto L9;
        boolean r12 = true;
    L10:
        ScrollingTabContainerView r13 = this.mTabScrollView;
        if (r13 == null) goto L17;
        if (r12 == false) goto L16;
        r13.setVisibility(0);
        ActionBarOverlayLayout r14 = this.mOverlayLayout;
        if (r14 == null) goto L17;
        ViewCompat.requestApplyInsets(r14);
        goto L17
    L16:
        r13.setVisibility(8);
    L17:
        DecorToolbar r15 = this.mDecorToolbar;
        if (this.mHasEmbeddedTabs == true) goto L21;
        if (r12 == false) goto L21;
        boolean r16 = true;
    L22:
        r15.setCollapsible(r16);
        ActionBarOverlayLayout r17 = this.mOverlayLayout;
        if (this.mHasEmbeddedTabs == true) goto L26;
        if (r12 == false) goto L26;
    L27:
        r17.setHasNonEmbeddedTabs(r11);
        return;
    L26:
        r11 = false;
    L21:
        r16 = false;
        goto L22
    L9:
        r12 = false;
        goto L10
    L5:
        this.mContainerView.setTabContainer(null);
        this.mDecorToolbar.setEmbeddedTabView(this.mTabScrollView);
        goto L6
    }

    private boolean shouldAnimateContextView() {
        return ViewCompat.isLaidOut(this.mContainerView);
    }

    private void showForActionMode() {
        if (this.mShowingForMode == true) goto L9;
        this.mShowingForMode = true;
        ActionBarOverlayLayout r10 = this.mOverlayLayout;
        if (r10 == null) goto L7;
        r10.setShowingForActionMode(true);
    L7:
        updateVisibility(false);
        return;
    }

    private void updateVisibility(boolean r10) {
        if (checkShowingFlags(this.mHiddenByApp, this.mHiddenBySystem, this.mShowingForMode) == false) goto L8;
        if (this.mNowShowing == true) goto L11;
        this.mNowShowing = true;
        doShow(r10);
        return;
    L11:
        return;
    L8:
        if (this.mNowShowing == false) goto L13;
        this.mNowShowing = false;
        doHide(r10);
        return;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void addOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener r10) {
        this.mMenuVisibilityListeners.add(r10);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void addTab(ActionBar.Tab r10) {
        addTab(r10, this.mTabs.isEmpty());
    }

    @Override // androidx.appcompat.app.ActionBar
    public void addTab(ActionBar.Tab r10, int r11) {
        addTab(r10, r11, this.mTabs.isEmpty());
    }

    @Override // androidx.appcompat.app.ActionBar
    public void addTab(ActionBar.Tab r10, int r11, boolean r12) {
        ensureTabsExist();
        this.mTabScrollView.addTab(r10, r11, r12);
        configureTab(r10, r11);
        if (r12 == false) goto L6;
        selectTab(r10);
        return;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void addTab(ActionBar.Tab r10, boolean r11) {
        ensureTabsExist();
        this.mTabScrollView.addTab(r10, r11);
        configureTab(r10, this.mTabs.size());
        if (r11 == false) goto L6;
        selectTab(r10);
        return;
    }

    public void animateToMode(boolean r10) {
        if (r10 == false) goto L4;
        showForActionMode();
    L6:
        if (shouldAnimateContextView() == true) goto L8;
        if (r10 == false) goto L14;
        this.mDecorToolbar.setVisibility(4);
        this.mContextView.setVisibility(0);
        return;
    L14:
        this.mDecorToolbar.setVisibility(0);
        this.mContextView.setVisibility(8);
        return;
    L8:
        if (r10 == false) goto L10;
        ViewPropertyAnimatorCompat r11 = this.mDecorToolbar.setupAnimatorToVisibility(4, 100);
        ViewPropertyAnimatorCompat r12 = this.mContextView.setupAnimatorToVisibility(0, FADE_IN_DURATION_MS);
    L11:
        ViewPropertyAnimatorCompatSet r13 = new ViewPropertyAnimatorCompatSet();
        r13.playSequentially(r11, r12);
        r13.start();
        return;
    L10:
        ViewPropertyAnimatorCompat r14 = this.mDecorToolbar.setupAnimatorToVisibility(0, FADE_IN_DURATION_MS);
        r11 = this.mContextView.setupAnimatorToVisibility(8, 100);
        r12 = r14;
        goto L11
    L4:
        hideForActionMode();
        goto L6
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean collapseActionView() {
        DecorToolbar r10 = this.mDecorToolbar;
        if (r10 != null) goto L5;
        return false;
    L5:
        if (r10.hasExpandedActionView() == false) goto L10;
        this.mDecorToolbar.collapseActionView();
        return true;
    L10:
        return false;
    }

    void completeDeferredDestroyActionMode() {
        ActionMode.Callback r10 = this.mDeferredModeDestroyCallback;
        if (r10 == null) goto L6;
        r10.onDestroyActionMode(this.mDeferredDestroyActionMode);
        this.mDeferredDestroyActionMode = null;
        this.mDeferredModeDestroyCallback = null;
        return;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void dispatchMenuVisibilityChanged(boolean r10) {
        if (r10 != this.mLastMenuVisibility) goto L5;
        return;
    L5:
        this.mLastMenuVisibility = r10;
        int r11 = this.mMenuVisibilityListeners.size();
        int r12 = 0;
    L6:
        if (r12 >= r11) goto L8;
        this.mMenuVisibilityListeners.get(r12).onMenuVisibilityChanged(r10);
        r12 = r12 + 1;
        goto L6
    }

    public void doHide(boolean r10) {
        ViewPropertyAnimatorCompatSet r11 = this.mCurrentShowAnim;
        if (r11 == null) goto L6;
        r11.cancel();
    L6:
        if (this.mCurWindowVisibility == 0) goto L8;
    L19:
        this.mHideListener.onAnimationEnd(null);
        return;
    L8:
        if (this.mShowHideAnimationEnabled == true) goto L10;
        if (r10 == false) goto L19;
    L10:
        this.mContainerView.setAlpha(1.0f);
        this.mContainerView.setTransitioning(true);
        ViewPropertyAnimatorCompatSet r12 = new ViewPropertyAnimatorCompatSet();
        float r13 = -this.mContainerView.getHeight();
        if (r10 == false) goto L13;
        int[] r14 = {0, 0};
        this.mContainerView.getLocationInWindow(r14);
        r13 = r13 - r14[1];
    L13:
        ViewPropertyAnimatorCompat r15 = ViewCompat.animate(this.mContainerView).translationY(r13);
        r15.setUpdateListener(this.mUpdateListener);
        r12.play(r15);
        if (this.mContentAnimations == false) goto L18;
        View r16 = this.mContentView;
        if (r16 == null) goto L18;
        r12.play(ViewCompat.animate(r16).translationY(r13));
    L18:
        r12.setInterpolator(sHideInterpolator);
        r12.setDuration(250);
        r12.setListener(this.mHideListener);
        this.mCurrentShowAnim = r12;
        r12.start();
    }

    public void doShow(boolean r10) {
        ViewPropertyAnimatorCompatSet r11 = this.mCurrentShowAnim;
        if (r11 == null) goto L5;
        r11.cancel();
    L5:
        this.mContainerView.setVisibility(0);
        if (this.mCurWindowVisibility == 0) goto L8;
    L19:
        this.mContainerView.setAlpha(1.0f);
        this.mContainerView.setTranslationY(0.0f);
        if (this.mContentAnimations == false) goto L24;
        View r12 = this.mContentView;
        if (r12 == null) goto L24;
        r12.setTranslationY(0.0f);
    L24:
        this.mShowListener.onAnimationEnd(null);
    L25:
        ActionBarOverlayLayout r13 = this.mOverlayLayout;
        if (r13 == null) goto L29;
        ViewCompat.requestApplyInsets(r13);
        return;
    L29:
        return;
    L8:
        if (this.mShowHideAnimationEnabled == true) goto L10;
        if (r10 == false) goto L19;
    L10:
        this.mContainerView.setTranslationY(0.0f);
        float r14 = -this.mContainerView.getHeight();
        if (r10 == false) goto L13;
        int[] r15 = {0, 0};
        this.mContainerView.getLocationInWindow(r15);
        r14 = r14 - r15[1];
    L13:
        this.mContainerView.setTranslationY(r14);
        ViewPropertyAnimatorCompatSet r16 = new ViewPropertyAnimatorCompatSet();
        ViewPropertyAnimatorCompat r17 = ViewCompat.animate(this.mContainerView).translationY(0.0f);
        r17.setUpdateListener(this.mUpdateListener);
        r16.play(r17);
        if (this.mContentAnimations == false) goto L18;
        View r18 = this.mContentView;
        if (r18 == null) goto L18;
        r18.setTranslationY(r14);
        r16.play(ViewCompat.animate(this.mContentView).translationY(0.0f));
    L18:
        r16.setInterpolator(sShowInterpolator);
        r16.setDuration(250);
        r16.setListener(this.mShowListener);
        this.mCurrentShowAnim = r16;
        r16.start();
        goto L25
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void enableContentAnimations(boolean r10) {
        this.mContentAnimations = r10;
    }

    @Override // androidx.appcompat.app.ActionBar
    public View getCustomView() {
        return this.mDecorToolbar.getCustomView();
    }

    @Override // androidx.appcompat.app.ActionBar
    public int getDisplayOptions() {
        return this.mDecorToolbar.getDisplayOptions();
    }

    @Override // androidx.appcompat.app.ActionBar
    public float getElevation() {
        return ViewCompat.getElevation(this.mContainerView);
    }

    @Override // androidx.appcompat.app.ActionBar
    public int getHeight() {
        return this.mContainerView.getHeight();
    }

    @Override // androidx.appcompat.app.ActionBar
    public int getHideOffset() {
        return this.mOverlayLayout.getActionBarHideOffset();
    }

    @Override // androidx.appcompat.app.ActionBar
    public int getNavigationItemCount() {
        int r10 = this.mDecorToolbar.getNavigationMode();
        if (r10 == 1) goto L11;
        if (r10 == 2) goto L9;
        return 0;
    L9:
        return this.mTabs.size();
    L11:
        return this.mDecorToolbar.getDropdownItemCount();
    }

    @Override // androidx.appcompat.app.ActionBar
    public int getNavigationMode() {
        return this.mDecorToolbar.getNavigationMode();
    }

    @Override // androidx.appcompat.app.ActionBar
    public int getSelectedNavigationIndex() {
        int r10 = this.mDecorToolbar.getNavigationMode();
        if (r10 == 1) goto L12;
        if (r10 == 2) goto L7;
        return -1;
    L7:
        TabImpl r11 = this.mSelectedTab;
        if (r11 != null) goto L10;
        return -1;
    L10:
        return r11.getPosition();
    L12:
        return this.mDecorToolbar.getDropdownSelectedPosition();
    }

    @Override // androidx.appcompat.app.ActionBar
    public ActionBar.Tab getSelectedTab() {
        return this.mSelectedTab;
    }

    @Override // androidx.appcompat.app.ActionBar
    public CharSequence getSubtitle() {
        return this.mDecorToolbar.getSubtitle();
    }

    @Override // androidx.appcompat.app.ActionBar
    public ActionBar.Tab getTabAt(int r10) {
        return this.mTabs.get(r10);
    }

    @Override // androidx.appcompat.app.ActionBar
    public int getTabCount() {
        return this.mTabs.size();
    }

    @Override // androidx.appcompat.app.ActionBar
    public Context getThemedContext() {
        if (this.mThemedContext != null) goto L9;
        TypedValue r10 = new TypedValue();
        this.mContext.getTheme().resolveAttribute(androidx.appcompat.R.attr.actionBarWidgetTheme, r10, true);
        int r11 = r10.resourceId;
        if (r11 == 0) goto L7;
        this.mThemedContext = new ContextThemeWrapper(this.mContext, r11);
        goto L9
    L7:
        this.mThemedContext = this.mContext;
    L9:
        return this.mThemedContext;
    }

    @Override // androidx.appcompat.app.ActionBar
    public CharSequence getTitle() {
        return this.mDecorToolbar.getTitle();
    }

    public boolean hasIcon() {
        return this.mDecorToolbar.hasIcon();
    }

    public boolean hasLogo() {
        return this.mDecorToolbar.hasLogo();
    }

    @Override // androidx.appcompat.app.ActionBar
    public void hide() {
        if (this.mHiddenByApp == true) goto L6;
        this.mHiddenByApp = true;
        updateVisibility(false);
        return;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void hideForSystem() {
        if (this.mHiddenBySystem == true) goto L6;
        this.mHiddenBySystem = true;
        updateVisibility(true);
        return;
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean isHideOnContentScrollEnabled() {
        return this.mOverlayLayout.isHideOnContentScrollEnabled();
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean isShowing() {
        int r10 = getHeight();
        if (this.mNowShowing == false) goto L8;
        if (r10 != 0) goto L6;
    L7:
        return true;
    L6:
        if (getHideOffset() < r10) goto L7;
    L8:
        return false;
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean isTitleTruncated() {
        DecorToolbar r10 = this.mDecorToolbar;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.isTitleTruncated() == false) goto L7;
        return true;
    }

    @Override // androidx.appcompat.app.ActionBar
    public ActionBar.Tab newTab() {
        return new TabImpl(this);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void onConfigurationChanged(Configuration r10) {
        setHasEmbeddedTabs(ActionBarPolicy.get(this.mContext).hasEmbeddedTabs());
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void onContentScrollStarted() {
        ViewPropertyAnimatorCompatSet r10 = this.mCurrentShowAnim;
        if (r10 == null) goto L6;
        r10.cancel();
        this.mCurrentShowAnim = null;
        return;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void onContentScrollStopped() {
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean onKeyShortcut(int r10, KeyEvent r11) {
        ActionModeImpl r12 = this.mActionMode;
        if (r12 != null) goto L5;
        return false;
    L5:
        Menu r13 = r12.getMenu();
        if (r13 == null) goto L16;
        if (r11 == null) goto L9;
        int r14 = r11.getDeviceId();
    L10:
        boolean r15 = true;
        if (KeyCharacterMap.load(r14).getKeyboardType() != 1) goto L14;
        r15 = false;
    L14:
        r13.setQwertyMode(r15);
        return r13.performShortcut(r10, r11, 0);
    L9:
        r14 = -1;
        goto L10
    L16:
        return false;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void onWindowVisibilityChanged(int r10) {
        this.mCurWindowVisibility = r10;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void removeAllTabs() {
        cleanupTabs();
    }

    @Override // androidx.appcompat.app.ActionBar
    public void removeOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener r10) {
        this.mMenuVisibilityListeners.remove(r10);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void removeTab(ActionBar.Tab r10) {
        removeTabAt(r10.getPosition());
    }

    @Override // androidx.appcompat.app.ActionBar
    public void removeTabAt(int r10) {
        if (this.mTabScrollView != null) goto L5;
        return;
    L5:
        TabImpl r11 = this.mSelectedTab;
        if (r11 == null) goto L8;
        int r12 = r11.getPosition();
    L9:
        this.mTabScrollView.removeTabAt(r10);
        TabImpl r13 = this.mTabs.remove(r10);
        if (r13 == null) goto L12;
        r13.setPosition(-1);
    L12:
        int r14 = this.mTabs.size();
        int r15 = r10;
    L13:
        if (r15 >= r14) goto L15;
        this.mTabs.get(r15).setPosition(r15);
        r15 = r15 + 1;
        goto L13
    L15:
        if (r12 == r10) goto L17;
        return;
    L17:
        if (this.mTabs.isEmpty() == false) goto L19;
        TabImpl r16 = null;
    L20:
        selectTab(r16);
        return;
    L19:
        r16 = this.mTabs.get(Math.max(0, r10 - 1));
        goto L20
    L8:
        r12 = this.mSavedTabPosition;
        goto L9
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean requestFocus() {
        ViewGroup r10 = this.mDecorToolbar.getViewGroup();
        if (r10 != null) goto L5;
        return false;
    L5:
        if (r10.hasFocus() == true) goto L10;
        r10.requestFocus();
        return true;
    L10:
        return false;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void selectTab(ActionBar.Tab r10) {
        int r11 = -1;
        if (getNavigationMode() == 2) goto L9;
        if (r10 == null) goto L6;
        r11 = r10.getPosition();
    L6:
        this.mSavedTabPosition = r11;
        return;
    L9:
        if ((this.mActivity instanceof FragmentActivity) == true) goto L11;
    L13:
        FragmentTransaction r12 = null;
    L14:
        TabImpl r13 = this.mSelectedTab;
        if (r13 != r10) goto L18;
        if (r13 == null) goto L27;
        r13.getCallback().onTabReselected(this.mSelectedTab, r12);
        this.mTabScrollView.animateToTab(r10.getPosition());
    L27:
        if (r12 != null) goto L29;
        return;
    L29:
        if (r12.isEmpty() == true) goto L33;
        r12.commit();
        return;
    L33:
        return;
    L18:
        ScrollingTabContainerView r14 = this.mTabScrollView;
        if (r10 == null) goto L21;
        r11 = r10.getPosition();
    L21:
        r14.setTabSelected(r11);
        TabImpl r15 = this.mSelectedTab;
        if (r15 == null) goto L24;
        r15.getCallback().onTabUnselected(this.mSelectedTab, r12);
    L24:
        TabImpl r16 = (TabImpl) r10;
        this.mSelectedTab = r16;
        if (r16 == null) goto L27;
        r16.getCallback().onTabSelected(this.mSelectedTab, r12);
        goto L27
    L11:
        if (this.mDecorToolbar.getViewGroup().isInEditMode() == true) goto L13;
        r12 = ((FragmentActivity) this.mActivity).getSupportFragmentManager().beginTransaction().disallowAddToBackStack();
        goto L14
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setBackgroundDrawable(Drawable r10) {
        this.mContainerView.setPrimaryBackground(r10);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setCustomView(int r10) {
        setCustomView(LayoutInflater.from(getThemedContext()).inflate(r10, this.mDecorToolbar.getViewGroup(), false));
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setCustomView(View r10) {
        this.mDecorToolbar.setCustomView(r10);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setCustomView(View r10, ActionBar.LayoutParams r11) {
        r10.setLayoutParams(r11);
        this.mDecorToolbar.setCustomView(r10);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDefaultDisplayHomeAsUpEnabled(boolean r10) {
        if (this.mDisplayHomeAsUpSet == true) goto L6;
        setDisplayHomeAsUpEnabled(r10);
        return;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayHomeAsUpEnabled(boolean r10) {
        if (r10 == false) goto L5;
        int r11 = 4;
    L6:
        setDisplayOptions(r11, 4);
        return;
    L5:
        r11 = 0;
        goto L6
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayOptions(int r10) {
        if ((r10 & 4) == 0) goto L5;
        this.mDisplayHomeAsUpSet = true;
    L5:
        this.mDecorToolbar.setDisplayOptions(r10);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayOptions(int r10, int r11) {
        int r12 = this.mDecorToolbar.getDisplayOptions();
        if ((r11 & 4) == 0) goto L5;
        this.mDisplayHomeAsUpSet = true;
    L5:
        this.mDecorToolbar.setDisplayOptions((r10 & r11) | ((~r11) & r12));
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayShowCustomEnabled(boolean r10) {
        if (r10 == false) goto L5;
        int r11 = 16;
    L6:
        setDisplayOptions(r11, 16);
        return;
    L5:
        r11 = 0;
        goto L6
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayShowHomeEnabled(boolean r10) {
        if (r10 == false) goto L5;
        int r11 = 2;
    L6:
        setDisplayOptions(r11, 2);
        return;
    L5:
        r11 = 0;
        goto L6
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayShowTitleEnabled(boolean r10) {
        if (r10 == false) goto L5;
        int r11 = 8;
    L6:
        setDisplayOptions(r11, 8);
        return;
    L5:
        r11 = 0;
        goto L6
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayUseLogoEnabled(boolean r10) {
        setDisplayOptions(r10 ? 1 : 0, 1);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setElevation(float r10) {
        ViewCompat.setElevation(this.mContainerView, r10);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHideOffset(int r10) {
        if (r10 != 0) goto L4;
    L8:
        this.mOverlayLayout.setActionBarHideOffset(r10);
        return;
    L4:
        if (this.mOverlayLayout.isInOverlayMode() == true) goto L8;
        throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to set a non-zero hide offset");
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHideOnContentScrollEnabled(boolean r10) {
        if (r10 == true) goto L4;
    L8:
        this.mHideOnContentScroll = r10;
        this.mOverlayLayout.setHideOnContentScrollEnabled(r10);
        return;
    L4:
        if (this.mOverlayLayout.isInOverlayMode() == true) goto L8;
        throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHomeActionContentDescription(int r10) {
        this.mDecorToolbar.setNavigationContentDescription(r10);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHomeActionContentDescription(CharSequence r10) {
        this.mDecorToolbar.setNavigationContentDescription(r10);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHomeAsUpIndicator(int r10) {
        this.mDecorToolbar.setNavigationIcon(r10);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHomeAsUpIndicator(Drawable r10) {
        this.mDecorToolbar.setNavigationIcon(r10);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHomeButtonEnabled(boolean r10) {
        this.mDecorToolbar.setHomeButtonEnabled(r10);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setIcon(int r10) {
        this.mDecorToolbar.setIcon(r10);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setIcon(Drawable r10) {
        this.mDecorToolbar.setIcon(r10);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setListNavigationCallbacks(SpinnerAdapter r10, ActionBar.OnNavigationListener r11) {
        this.mDecorToolbar.setDropdownParams(r10, new NavItemSelectedListener(r11));
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setLogo(int r10) {
        this.mDecorToolbar.setLogo(r10);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setLogo(Drawable r10) {
        this.mDecorToolbar.setLogo(r10);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setNavigationMode(int r10) {
        int r11 = this.mDecorToolbar.getNavigationMode();
        if (r11 != 2) goto L6;
        this.mSavedTabPosition = getSelectedNavigationIndex();
        selectTab(null);
        this.mTabScrollView.setVisibility(8);
    L6:
        if (r11 != r10) goto L8;
    L12:
        this.mDecorToolbar.setNavigationMode(r10);
        boolean r12 = false;
        if (r10 != 2) goto L18;
        ensureTabsExist();
        this.mTabScrollView.setVisibility(0);
        int r13 = this.mSavedTabPosition;
        if (r13 == (-1)) goto L18;
        setSelectedNavigationItem(r13);
        this.mSavedTabPosition = -1;
    L18:
        DecorToolbar r14 = this.mDecorToolbar;
        if (r10 == 2) goto L21;
    L23:
        boolean r15 = false;
    L24:
        r14.setCollapsible(r15);
        ActionBarOverlayLayout r16 = this.mOverlayLayout;
        if (r10 == 2) goto L27;
    L29:
        r16.setHasNonEmbeddedTabs(r12);
        return;
    L27:
        if (this.mHasEmbeddedTabs == true) goto L29;
        r12 = true;
        goto L29
    L21:
        if (this.mHasEmbeddedTabs == true) goto L23;
        r15 = true;
        goto L24
    L8:
        if (this.mHasEmbeddedTabs == true) goto L12;
        ActionBarOverlayLayout r17 = this.mOverlayLayout;
        if (r17 == null) goto L12;
        ViewCompat.requestApplyInsets(r17);
        goto L12
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setSelectedNavigationItem(int r10) {
        int r11 = this.mDecorToolbar.getNavigationMode();
        if (r11 != 1) goto L5;
        this.mDecorToolbar.setDropdownSelectedPosition(r10);
        return;
    L5:
        if (r11 != 2) goto L8;
        selectTab(this.mTabs.get(r10));
        return;
    L8:
        throw new IllegalStateException("setSelectedNavigationIndex not valid for current navigation mode");
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setShowHideAnimationEnabled(boolean r10) {
        this.mShowHideAnimationEnabled = r10;
        if (r10 == true) goto L8;
        ViewPropertyAnimatorCompatSet r11 = this.mCurrentShowAnim;
        if (r11 == null) goto L9;
        r11.cancel();
        return;
    L9:
        return;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setSplitBackgroundDrawable(Drawable r10) {
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setStackedBackgroundDrawable(Drawable r10) {
        this.mContainerView.setStackedBackground(r10);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setSubtitle(int r10) {
        setSubtitle(this.mContext.getString(r10));
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setSubtitle(CharSequence r10) {
        this.mDecorToolbar.setSubtitle(r10);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setTitle(int r10) {
        setTitle(this.mContext.getString(r10));
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setTitle(CharSequence r10) {
        this.mDecorToolbar.setTitle(r10);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setWindowTitle(CharSequence r10) {
        this.mDecorToolbar.setWindowTitle(r10);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void show() {
        if (this.mHiddenByApp == false) goto L6;
        this.mHiddenByApp = false;
        updateVisibility(false);
        return;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void showForSystem() {
        if (this.mHiddenBySystem == false) goto L6;
        this.mHiddenBySystem = false;
        updateVisibility(true);
        return;
    }

    @Override // androidx.appcompat.app.ActionBar
    public ActionMode startActionMode(ActionMode.Callback r10) {
        ActionModeImpl r11 = this.mActionMode;
        if (r11 == null) goto L5;
        r11.finish();
    L5:
        this.mOverlayLayout.setHideOnContentScrollEnabled(false);
        this.mContextView.killMode();
        ActionModeImpl r12 = new ActionModeImpl(this, this.mContextView.getContext(), r10);
        if (r12.dispatchOnCreate() == false) goto L9;
        this.mActionMode = r12;
        r12.invalidate();
        this.mContextView.initForMode(r12);
        animateToMode(true);
        return r12;
    L9:
        return null;
    }
}
