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

        public ActionModeImpl(WindowDecorActionBar r5, Context r10, ActionMode.Callback r11) {
            this.this$0 = r5;
            this.mActionModeContext = r10;
            this.mCallback = r11;
            MenuBuilder r12 = new MenuBuilder(r10).setDefaultShowAsAction(1);
            this.mMenu = r12;
            r12.setCallback(this);
        }

        public boolean dispatchOnCreate() {
            this.mMenu.stopDispatchingItemsChanged();
            boolean r5 = this.mCallback.onCreateActionMode(this, this.mMenu);     // Catch: Throwable -> L6
            this.mMenu.startDispatchingItemsChanged();
            return r5;
        L6:
            th = move-exception;
            this.mMenu.startDispatchingItemsChanged();
            throw th;
        }

        @Override // androidx.appcompat.view.ActionMode
        public void finish() {
            WindowDecorActionBar r5 = this.this$0;
            if (r5.mActionMode == this) goto L6;
            return;
        L6:
            if (WindowDecorActionBar.checkShowingFlags(r5.mHiddenByApp, r5.mHiddenBySystem, false) == true) goto L8;
            WindowDecorActionBar r10 = this.this$0;
            r10.mDeferredDestroyActionMode = this;
            r10.mDeferredModeDestroyCallback = this.mCallback;
        L9:
            this.mCallback = null;
            this.this$0.animateToMode(false);
            this.this$0.mContextView.closeMode();
            WindowDecorActionBar r11 = this.this$0;
            r11.mOverlayLayout.setHideOnContentScrollEnabled(r11.mHideOnContentScroll);
            this.this$0.mActionMode = null;
            return;
        L8:
            this.mCallback.onDestroyActionMode(this);
            goto L9
        }

        @Override // androidx.appcompat.view.ActionMode
        public View getCustomView() {
            WeakReference<View> r5 = this.mCustomView;
            if (r5 != null) goto L7;
            return null;
        L7:
            return r5.get();
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

        public void onCloseMenu(MenuBuilder r5, boolean r10) {
        }

        public void onCloseSubMenu(SubMenuBuilder r5) {
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public boolean onMenuItemSelected(@NonNull MenuBuilder r5, @NonNull MenuItem r10) {
            ActionMode.Callback r11 = this.mCallback;
            if (r11 != null) goto L5;
            return false;
        L5:
            return r11.onActionItemClicked(this, r10);
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public void onMenuModeChange(@NonNull MenuBuilder r5) {
            if (this.mCallback != null) goto L5;
            return;
        L5:
            invalidate();
            this.this$0.mContextView.showOverflowMenu();
        }

        public boolean onSubMenuSelected(SubMenuBuilder r5) {
            if (this.mCallback != null) goto L7;
            return false;
        L7:
            if (r5.hasVisibleItems() == true) goto L9;
            return true;
        L9:
            new MenuPopupHelper(this.this$0.getThemedContext(), r5).show();
            return true;
        }

        @Override // androidx.appcompat.view.ActionMode
        public void setCustomView(View r5) {
            this.this$0.mContextView.setCustomView(r5);
            this.mCustomView = new WeakReference(r5);
        }

        @Override // androidx.appcompat.view.ActionMode
        public void setSubtitle(CharSequence r5) {
            this.this$0.mContextView.setSubtitle(r5);
        }

        @Override // androidx.appcompat.view.ActionMode
        public void setTitle(CharSequence r5) {
            this.this$0.mContextView.setTitle(r5);
        }

        @Override // androidx.appcompat.view.ActionMode
        public void setTitleOptionalHint(boolean r5) {
            super.setTitleOptionalHint(r5);
            this.this$0.mContextView.setTitleOptional(r5);
        }

        @Override // androidx.appcompat.view.ActionMode
        public void setSubtitle(int r5) {
            setSubtitle(this.this$0.mContext.getResources().getString(r5));
        }

        @Override // androidx.appcompat.view.ActionMode
        public void setTitle(int r5) {
            setTitle(this.this$0.mContext.getResources().getString(r5));
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

        public TabImpl(WindowDecorActionBar r5) {
            this.this$0 = r5;
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
        public ActionBar.Tab setContentDescription(int r5) {
            return setContentDescription(this.this$0.mContext.getResources().getText(r5));
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setCustomView(View r5) {
            this.mCustomView = r5;
            int r10 = this.mPosition;
            if (r10 < 0) goto L5;
            this.this$0.mTabScrollView.updateTab(r10);
        L5:
            return this;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setIcon(Drawable r5) {
            this.mIcon = r5;
            int r10 = this.mPosition;
            if (r10 < 0) goto L5;
            this.this$0.mTabScrollView.updateTab(r10);
        L5:
            return this;
        }

        public void setPosition(int r5) {
            this.mPosition = r5;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setTabListener(ActionBar.TabListener r5) {
            this.mCallback = r5;
            return this;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setTag(Object r5) {
            this.mTag = r5;
            return this;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setText(CharSequence r5) {
            this.mText = r5;
            int r10 = this.mPosition;
            if (r10 < 0) goto L5;
            this.this$0.mTabScrollView.updateTab(r10);
        L5:
            return this;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setContentDescription(CharSequence r5) {
            this.mContentDesc = r5;
            int r10 = this.mPosition;
            if (r10 < 0) goto L5;
            this.this$0.mTabScrollView.updateTab(r10);
        L5:
            return this;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setCustomView(int r5) {
            return setCustomView(LayoutInflater.from(this.this$0.getThemedContext()).inflate(r5, null));
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setIcon(int r5) {
            return setIcon(AppCompatResources.getDrawable(this.this$0.mContext, r5));
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setText(int r5) {
            return setText(this.this$0.mContext.getResources().getText(r5));
        }
    }

    static {
        sHideInterpolator = new AccelerateInterpolator();
        sShowInterpolator = new DecelerateInterpolator();
    }

    public WindowDecorActionBar(Activity r5, boolean r10) {
        this.mTabs = new ArrayList();
        this.mSavedTabPosition = -1;
        this.mMenuVisibilityListeners = new ArrayList();
        this.mCurWindowVisibility = 0;
        this.mContentAnimations = true;
        this.mNowShowing = true;
        this.mHideListener = new AnonymousClass1(this);
        this.mShowListener = new AnonymousClass2(this);
        this.mUpdateListener = new AnonymousClass3(this);
        this.mActivity = r5;
        View r11 = r5.getWindow().getDecorView();
        init(r11);
        if (r10 == true) goto L6;
        this.mContentView = r11.findViewById(R.id.content);
        return;
    }

    public static boolean checkShowingFlags(boolean r5, boolean r10, boolean r11) {
        if (r11 == false) goto L5;
        return true;
    L5:
        if (r5 == true) goto L9;
        if (r10 == true) goto L11;
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
        ScrollingTabContainerView r5 = this.mTabScrollView;
        if (r5 == null) goto L8;
        r5.removeAllTabs();
    L8:
        this.mSavedTabPosition = -1;
    }

    private void configureTab(ActionBar.Tab r5, int r10) {
        TabImpl r11 = (TabImpl) r5;
        if (r11.getCallback() == null) goto L10;
        r11.setPosition(r10);
        this.mTabs.add(r10, r11);
        int r12 = this.mTabs.size();
    L5:
        r10 = r10 + 1;
        if (r10 >= r12) goto L8;
        this.mTabs.get(r10).setPosition(r10);
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
        ScrollingTabContainerView r5 = new ScrollingTabContainerView(this.mContext);
        if (this.mHasEmbeddedTabs == false) goto L9;
        r5.setVisibility(0);
        this.mDecorToolbar.setEmbeddedTabView(r5);
    L15:
        this.mTabScrollView = r5;
        return;
    L9:
        if (getNavigationMode() != 2) goto L13;
        r5.setVisibility(0);
        ActionBarOverlayLayout r10 = this.mOverlayLayout;
        if (r10 == null) goto L14;
        ViewCompat.requestApplyInsets(r10);
    L14:
        this.mContainerView.setTabContainer(r5);
        goto L15
    L13:
        r5.setVisibility(8);
        goto L14
    }

    /* JADX WARN: Multi-variable type inference failed */
    private DecorToolbar getDecorToolbar(View r5) {
        if ((r5 instanceof DecorToolbar) == false) goto L7;
        return (DecorToolbar) r5;
    L7:
        if ((r5 instanceof Toolbar) == false) goto L11;
        return ((Toolbar) r5).getWrapper();
    L11:
        if (r5 == 0) goto L13;
        String r10 = r5.getClass().getSimpleName();
    L15:
        throw new IllegalStateException("Can't make a decor toolbar out of ".concat(r10));
    L13:
        r10 = "null";
        goto L15
    }

    private void hideForActionMode() {
        if (this.mShowingForMode == false) goto L9;
        this.mShowingForMode = false;
        ActionBarOverlayLayout r5 = this.mOverlayLayout;
        if (r5 == null) goto L7;
        r5.setShowingForActionMode(false);
    L7:
        updateVisibility(false);
        return;
    }

    private void init(View r10) {
        ActionBarOverlayLayout r5 = (ActionBarOverlayLayout) r10.findViewById(androidx.appcompat.R.id.decor_content_parent);
        this.mOverlayLayout = r5;
        if (r5 == null) goto L5;
        r5.setActionBarVisibilityCallback(this);
    L5:
        this.mDecorToolbar = getDecorToolbar(r10.findViewById(androidx.appcompat.R.id.action_bar));
        this.mContextView = (ActionBarContextView) r10.findViewById(androidx.appcompat.R.id.action_context_bar);
        ActionBarContainer r11 = (ActionBarContainer) r10.findViewById(androidx.appcompat.R.id.action_bar_container);
        this.mContainerView = r11;
        DecorToolbar r12 = this.mDecorToolbar;
        if (r12 == null) goto L31;
        if (this.mContextView == null) goto L31;
        if (r11 == null) goto L31;
        this.mContext = r12.getContext();
        if ((this.mDecorToolbar.getDisplayOptions() & 4) == 0) goto L13;
        boolean r13 = true;
    L14:
        if (r13 == false) goto L16;
        this.mDisplayHomeAsUpSet = true;
    L16:
        ActionBarPolicy r14 = ActionBarPolicy.get(this.mContext);
        if (r14.enableHomeButtonByDefault() == true) goto L21;
        if (r13 == true) goto L21;
        boolean r15 = false;
    L22:
        setHomeButtonEnabled(r15);
        setHasEmbeddedTabs(r14.hasEmbeddedTabs());
        TypedArray r16 = this.mContext.obtainStyledAttributes(null, androidx.appcompat.R.styleable.ActionBar, androidx.appcompat.R.attr.actionBarStyle, 0);
        if (r16.getBoolean(androidx.appcompat.R.styleable.ActionBar_hideOnContentScroll, false) == false) goto L25;
        setHideOnContentScrollEnabled(true);
    L25:
        int r17 = r16.getDimensionPixelSize(androidx.appcompat.R.styleable.ActionBar_elevation, 0);
        if (r17 == 0) goto L28;
        setElevation(r17);
    L28:
        r16.recycle();
        return;
    L21:
        r15 = true;
        goto L22
    L13:
        r13 = false;
    L31:
        throw new IllegalStateException(getClass().getSimpleName().concat(" can only be used with a compatible window decor layout"));
    }

    private void setHasEmbeddedTabs(boolean r5) {
        this.mHasEmbeddedTabs = r5;
        if (r5 == true) goto L5;
        this.mDecorToolbar.setEmbeddedTabView(null);
        this.mContainerView.setTabContainer(this.mTabScrollView);
    L6:
        boolean r10 = true;
        if (getNavigationMode() != 2) goto L9;
        boolean r11 = true;
    L10:
        ScrollingTabContainerView r12 = this.mTabScrollView;
        if (r12 == null) goto L17;
        if (r11 == false) goto L16;
        r12.setVisibility(0);
        ActionBarOverlayLayout r13 = this.mOverlayLayout;
        if (r13 == null) goto L17;
        ViewCompat.requestApplyInsets(r13);
        goto L17
    L16:
        r12.setVisibility(8);
    L17:
        DecorToolbar r14 = this.mDecorToolbar;
        if (this.mHasEmbeddedTabs == true) goto L21;
        if (r11 == false) goto L21;
        boolean r15 = true;
    L22:
        r14.setCollapsible(r15);
        ActionBarOverlayLayout r16 = this.mOverlayLayout;
        if (this.mHasEmbeddedTabs == true) goto L26;
        if (r11 == false) goto L26;
    L27:
        r16.setHasNonEmbeddedTabs(r10);
        return;
    L26:
        r10 = false;
    L21:
        r15 = false;
        goto L22
    L9:
        r11 = false;
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
        ActionBarOverlayLayout r5 = this.mOverlayLayout;
        if (r5 == null) goto L7;
        r5.setShowingForActionMode(true);
    L7:
        updateVisibility(false);
        return;
    }

    private void updateVisibility(boolean r5) {
        if (checkShowingFlags(this.mHiddenByApp, this.mHiddenBySystem, this.mShowingForMode) == false) goto L8;
        if (this.mNowShowing == true) goto L11;
        this.mNowShowing = true;
        doShow(r5);
        return;
    L11:
        return;
    L8:
        if (this.mNowShowing == false) goto L13;
        this.mNowShowing = false;
        doHide(r5);
        return;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void addOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener r5) {
        this.mMenuVisibilityListeners.add(r5);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void addTab(ActionBar.Tab r5) {
        addTab(r5, this.mTabs.isEmpty());
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
        ViewPropertyAnimatorCompat r11 = this.mDecorToolbar.setupAnimatorToVisibility(4, FADE_OUT_DURATION_MS);
        ViewPropertyAnimatorCompat r12 = this.mContextView.setupAnimatorToVisibility(0, FADE_IN_DURATION_MS);
    L11:
        ViewPropertyAnimatorCompatSet r5 = new ViewPropertyAnimatorCompatSet();
        r5.playSequentially(r11, r12);
        r5.start();
        return;
    L10:
        ViewPropertyAnimatorCompat r13 = this.mDecorToolbar.setupAnimatorToVisibility(0, FADE_IN_DURATION_MS);
        r11 = this.mContextView.setupAnimatorToVisibility(8, FADE_OUT_DURATION_MS);
        r12 = r13;
        goto L11
    L4:
        hideForActionMode();
        goto L6
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean collapseActionView() {
        DecorToolbar r5 = this.mDecorToolbar;
        if (r5 != null) goto L5;
        return false;
    L5:
        if (r5.hasExpandedActionView() == false) goto L10;
        this.mDecorToolbar.collapseActionView();
        return true;
    L10:
        return false;
    }

    public void completeDeferredDestroyActionMode() {
        ActionMode.Callback r5 = this.mDeferredModeDestroyCallback;
        if (r5 == null) goto L6;
        r5.onDestroyActionMode(this.mDeferredDestroyActionMode);
        this.mDeferredDestroyActionMode = null;
        this.mDeferredModeDestroyCallback = null;
        return;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void dispatchMenuVisibilityChanged(boolean r5) {
        if (r5 != this.mLastMenuVisibility) goto L5;
        return;
    L5:
        this.mLastMenuVisibility = r5;
        int r10 = this.mMenuVisibilityListeners.size();
        int r11 = 0;
    L6:
        if (r11 >= r10) goto L8;
        this.mMenuVisibilityListeners.get(r11).onMenuVisibilityChanged(r5);
        r11 = r11 + 1;
        goto L6
    }

    public void doHide(boolean r5) {
        ViewPropertyAnimatorCompatSet r10 = this.mCurrentShowAnim;
        if (r10 == null) goto L6;
        r10.cancel();
    L6:
        if (this.mCurWindowVisibility == 0) goto L8;
    L19:
        this.mHideListener.onAnimationEnd(null);
        return;
    L8:
        if (this.mShowHideAnimationEnabled == true) goto L10;
        if (r5 == false) goto L19;
    L10:
        this.mContainerView.setAlpha(1.0f);
        this.mContainerView.setTransitioning(true);
        ViewPropertyAnimatorCompatSet r11 = new ViewPropertyAnimatorCompatSet();
        float r12 = -this.mContainerView.getHeight();
        if (r5 == false) goto L13;
        int[] r13 = {0, 0};
        this.mContainerView.getLocationInWindow(r13);
        r12 = r12 - r13[1];
    L13:
        ViewPropertyAnimatorCompat r14 = ViewCompat.animate(this.mContainerView).translationY(r12);
        r14.setUpdateListener(this.mUpdateListener);
        r11.play(r14);
        if (this.mContentAnimations == false) goto L18;
        View r15 = this.mContentView;
        if (r15 == null) goto L18;
        r11.play(ViewCompat.animate(r15).translationY(r12));
    L18:
        r11.setInterpolator(sHideInterpolator);
        r11.setDuration(250);
        r11.setListener(this.mHideListener);
        this.mCurrentShowAnim = r11;
        r11.start();
    }

    public void doShow(boolean r5) {
        ViewPropertyAnimatorCompatSet r10 = this.mCurrentShowAnim;
        if (r10 == null) goto L5;
        r10.cancel();
    L5:
        this.mContainerView.setVisibility(0);
        if (this.mCurWindowVisibility == 0) goto L8;
    L19:
        this.mContainerView.setAlpha(1.0f);
        this.mContainerView.setTranslationY(0.0f);
        if (this.mContentAnimations == false) goto L24;
        View r11 = this.mContentView;
        if (r11 == null) goto L24;
        r11.setTranslationY(0.0f);
    L24:
        this.mShowListener.onAnimationEnd(null);
    L25:
        ActionBarOverlayLayout r12 = this.mOverlayLayout;
        if (r12 == null) goto L29;
        ViewCompat.requestApplyInsets(r12);
        return;
    L29:
        return;
    L8:
        if (this.mShowHideAnimationEnabled == true) goto L10;
        if (r5 == false) goto L19;
    L10:
        this.mContainerView.setTranslationY(0.0f);
        float r13 = -this.mContainerView.getHeight();
        if (r5 == false) goto L13;
        int[] r14 = {0, 0};
        this.mContainerView.getLocationInWindow(r14);
        r13 = r13 - r14[1];
    L13:
        this.mContainerView.setTranslationY(r13);
        ViewPropertyAnimatorCompatSet r15 = new ViewPropertyAnimatorCompatSet();
        ViewPropertyAnimatorCompat r16 = ViewCompat.animate(this.mContainerView).translationY(0.0f);
        r16.setUpdateListener(this.mUpdateListener);
        r15.play(r16);
        if (this.mContentAnimations == false) goto L18;
        View r17 = this.mContentView;
        if (r17 == null) goto L18;
        r17.setTranslationY(r13);
        r15.play(ViewCompat.animate(this.mContentView).translationY(0.0f));
    L18:
        r15.setInterpolator(sShowInterpolator);
        r15.setDuration(250);
        r15.setListener(this.mShowListener);
        this.mCurrentShowAnim = r15;
        r15.start();
        goto L25
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void enableContentAnimations(boolean r5) {
        this.mContentAnimations = r5;
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
        int r5 = this.mDecorToolbar.getNavigationMode();
        if (r5 == 1) goto L11;
        if (r5 == 2) goto L9;
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
        int r5 = this.mDecorToolbar.getNavigationMode();
        if (r5 == 1) goto L12;
        if (r5 == 2) goto L7;
        return -1;
    L7:
        TabImpl r10 = this.mSelectedTab;
        if (r10 != null) goto L10;
        return -1;
    L10:
        return r10.getPosition();
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
    public ActionBar.Tab getTabAt(int r5) {
        return this.mTabs.get(r5);
    }

    @Override // androidx.appcompat.app.ActionBar
    public int getTabCount() {
        return this.mTabs.size();
    }

    @Override // androidx.appcompat.app.ActionBar
    public Context getThemedContext() {
        if (this.mThemedContext != null) goto L9;
        TypedValue r5 = new TypedValue();
        this.mContext.getTheme().resolveAttribute(androidx.appcompat.R.attr.actionBarWidgetTheme, r5, true);
        int r10 = r5.resourceId;
        if (r10 == 0) goto L7;
        this.mThemedContext = new ContextThemeWrapper(this.mContext, r10);
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
        int r5 = getHeight();
        if (this.mNowShowing == false) goto L8;
        if (r5 != 0) goto L6;
    L7:
        return true;
    L6:
        if (getHideOffset() < r5) goto L7;
    L8:
        return false;
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean isTitleTruncated() {
        DecorToolbar r5 = this.mDecorToolbar;
        if (r5 != null) goto L5;
    L7:
        return false;
    L5:
        if (r5.isTitleTruncated() == false) goto L7;
        return true;
    }

    @Override // androidx.appcompat.app.ActionBar
    public ActionBar.Tab newTab() {
        return new TabImpl(this);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void onConfigurationChanged(Configuration r5) {
        setHasEmbeddedTabs(ActionBarPolicy.get(this.mContext).hasEmbeddedTabs());
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void onContentScrollStarted() {
        ViewPropertyAnimatorCompatSet r5 = this.mCurrentShowAnim;
        if (r5 == null) goto L6;
        r5.cancel();
        this.mCurrentShowAnim = null;
        return;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void onContentScrollStopped() {
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean onKeyShortcut(int r5, KeyEvent r10) {
        ActionModeImpl r11 = this.mActionMode;
        if (r11 != null) goto L5;
        return false;
    L5:
        Menu r12 = r11.getMenu();
        if (r12 == null) goto L16;
        if (r10 == null) goto L9;
        int r13 = r10.getDeviceId();
    L10:
        boolean r14 = true;
        if (KeyCharacterMap.load(r13).getKeyboardType() != 1) goto L14;
        r14 = false;
    L14:
        r12.setQwertyMode(r14);
        return r12.performShortcut(r5, r10, 0);
    L9:
        r13 = -1;
        goto L10
    L16:
        return false;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void onWindowVisibilityChanged(int r5) {
        this.mCurWindowVisibility = r5;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void removeAllTabs() {
        cleanupTabs();
    }

    @Override // androidx.appcompat.app.ActionBar
    public void removeOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener r5) {
        this.mMenuVisibilityListeners.remove(r5);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void removeTab(ActionBar.Tab r5) {
        removeTabAt(r5.getPosition());
    }

    @Override // androidx.appcompat.app.ActionBar
    public void removeTabAt(int r5) {
        if (this.mTabScrollView != null) goto L5;
        return;
    L5:
        TabImpl r10 = this.mSelectedTab;
        if (r10 == null) goto L8;
        int r11 = r10.getPosition();
    L9:
        this.mTabScrollView.removeTabAt(r5);
        TabImpl r12 = this.mTabs.remove(r5);
        if (r12 == null) goto L12;
        r12.setPosition(-1);
    L12:
        int r13 = this.mTabs.size();
        int r14 = r5;
    L13:
        if (r14 >= r13) goto L15;
        this.mTabs.get(r14).setPosition(r14);
        r14 = r14 + 1;
        goto L13
    L15:
        if (r11 == r5) goto L17;
        return;
    L17:
        if (this.mTabs.isEmpty() == false) goto L19;
        TabImpl r15 = null;
    L20:
        selectTab(r15);
        return;
    L19:
        r15 = this.mTabs.get(Math.max(0, r5 - 1));
        goto L20
    L8:
        r11 = this.mSavedTabPosition;
        goto L9
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean requestFocus() {
        ViewGroup r5 = this.mDecorToolbar.getViewGroup();
        if (r5 != null) goto L5;
        return false;
    L5:
        if (r5.hasFocus() == true) goto L10;
        r5.requestFocus();
        return true;
    L10:
        return false;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void selectTab(ActionBar.Tab r5) {
        int r10 = -1;
        if (getNavigationMode() == 2) goto L9;
        if (r5 == null) goto L6;
        r10 = r5.getPosition();
    L6:
        this.mSavedTabPosition = r10;
        return;
    L9:
        if ((this.mActivity instanceof FragmentActivity) == true) goto L11;
    L13:
        FragmentTransaction r11 = null;
    L14:
        TabImpl r12 = this.mSelectedTab;
        if (r12 != r5) goto L18;
        if (r12 == null) goto L27;
        r12.getCallback().onTabReselected(this.mSelectedTab, r11);
        this.mTabScrollView.animateToTab(r5.getPosition());
    L27:
        if (r11 != null) goto L29;
        return;
    L29:
        if (r11.isEmpty() == true) goto L33;
        r11.commit();
        return;
    L33:
        return;
    L18:
        ScrollingTabContainerView r13 = this.mTabScrollView;
        if (r5 == null) goto L21;
        r10 = r5.getPosition();
    L21:
        r13.setTabSelected(r10);
        TabImpl r14 = this.mSelectedTab;
        if (r14 == null) goto L24;
        r14.getCallback().onTabUnselected(this.mSelectedTab, r11);
    L24:
        TabImpl r15 = (TabImpl) r5;
        this.mSelectedTab = r15;
        if (r15 == null) goto L27;
        r15.getCallback().onTabSelected(this.mSelectedTab, r11);
        goto L27
    L11:
        if (this.mDecorToolbar.getViewGroup().isInEditMode() == true) goto L13;
        r11 = ((FragmentActivity) this.mActivity).getSupportFragmentManager().beginTransaction().disallowAddToBackStack();
        goto L14
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setBackgroundDrawable(Drawable r5) {
        this.mContainerView.setPrimaryBackground(r5);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setCustomView(int r5) {
        setCustomView(LayoutInflater.from(getThemedContext()).inflate(r5, this.mDecorToolbar.getViewGroup(), false));
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDefaultDisplayHomeAsUpEnabled(boolean r5) {
        if (this.mDisplayHomeAsUpSet == true) goto L6;
        setDisplayHomeAsUpEnabled(r5);
        return;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayHomeAsUpEnabled(boolean r5) {
        if (r5 == false) goto L5;
        int r10 = 4;
    L6:
        setDisplayOptions(r10, 4);
        return;
    L5:
        r10 = 0;
        goto L6
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayOptions(int r5) {
        if ((r5 & 4) == 0) goto L5;
        this.mDisplayHomeAsUpSet = true;
    L5:
        this.mDecorToolbar.setDisplayOptions(r5);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayShowCustomEnabled(boolean r5) {
        if (r5 == false) goto L5;
        int r10 = 16;
    L6:
        setDisplayOptions(r10, 16);
        return;
    L5:
        r10 = 0;
        goto L6
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayShowHomeEnabled(boolean r5) {
        if (r5 == false) goto L5;
        int r10 = 2;
    L6:
        setDisplayOptions(r10, 2);
        return;
    L5:
        r10 = 0;
        goto L6
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayShowTitleEnabled(boolean r5) {
        if (r5 == false) goto L5;
        int r10 = 8;
    L6:
        setDisplayOptions(r10, 8);
        return;
    L5:
        r10 = 0;
        goto L6
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayUseLogoEnabled(boolean r5) {
        setDisplayOptions(r5 ? 1 : 0, 1);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setElevation(float r5) {
        ViewCompat.setElevation(this.mContainerView, r5);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHideOffset(int r5) {
        if (r5 != 0) goto L4;
    L8:
        this.mOverlayLayout.setActionBarHideOffset(r5);
        return;
    L4:
        if (this.mOverlayLayout.isInOverlayMode() == true) goto L8;
        throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to set a non-zero hide offset");
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHideOnContentScrollEnabled(boolean r5) {
        if (r5 == true) goto L4;
    L8:
        this.mHideOnContentScroll = r5;
        this.mOverlayLayout.setHideOnContentScrollEnabled(r5);
        return;
    L4:
        if (this.mOverlayLayout.isInOverlayMode() == true) goto L8;
        throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHomeActionContentDescription(CharSequence r5) {
        this.mDecorToolbar.setNavigationContentDescription(r5);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHomeAsUpIndicator(Drawable r5) {
        this.mDecorToolbar.setNavigationIcon(r5);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHomeButtonEnabled(boolean r5) {
        this.mDecorToolbar.setHomeButtonEnabled(r5);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setIcon(int r5) {
        this.mDecorToolbar.setIcon(r5);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setListNavigationCallbacks(SpinnerAdapter r5, ActionBar.OnNavigationListener r10) {
        this.mDecorToolbar.setDropdownParams(r5, new NavItemSelectedListener(r10));
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setLogo(int r5) {
        this.mDecorToolbar.setLogo(r5);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setNavigationMode(int r10) {
        int r5 = this.mDecorToolbar.getNavigationMode();
        if (r5 != 2) goto L6;
        this.mSavedTabPosition = getSelectedNavigationIndex();
        selectTab(null);
        this.mTabScrollView.setVisibility(8);
    L6:
        if (r5 != r10) goto L8;
    L12:
        this.mDecorToolbar.setNavigationMode(r10);
        boolean r11 = false;
        if (r10 != 2) goto L18;
        ensureTabsExist();
        this.mTabScrollView.setVisibility(0);
        int r12 = this.mSavedTabPosition;
        if (r12 == (-1)) goto L18;
        setSelectedNavigationItem(r12);
        this.mSavedTabPosition = -1;
    L18:
        DecorToolbar r13 = this.mDecorToolbar;
        if (r10 == 2) goto L21;
    L23:
        boolean r14 = false;
    L24:
        r13.setCollapsible(r14);
        ActionBarOverlayLayout r15 = this.mOverlayLayout;
        if (r10 == 2) goto L27;
    L29:
        r15.setHasNonEmbeddedTabs(r11);
        return;
    L27:
        if (this.mHasEmbeddedTabs == true) goto L29;
        r11 = true;
        goto L29
    L21:
        if (this.mHasEmbeddedTabs == true) goto L23;
        r14 = true;
        goto L24
    L8:
        if (this.mHasEmbeddedTabs == true) goto L12;
        ActionBarOverlayLayout r16 = this.mOverlayLayout;
        if (r16 == null) goto L12;
        ViewCompat.requestApplyInsets(r16);
        goto L12
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setSelectedNavigationItem(int r5) {
        int r10 = this.mDecorToolbar.getNavigationMode();
        if (r10 != 1) goto L5;
        this.mDecorToolbar.setDropdownSelectedPosition(r5);
        return;
    L5:
        if (r10 != 2) goto L8;
        selectTab(this.mTabs.get(r5));
        return;
    L8:
        throw new IllegalStateException("setSelectedNavigationIndex not valid for current navigation mode");
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setShowHideAnimationEnabled(boolean r5) {
        this.mShowHideAnimationEnabled = r5;
        if (r5 == true) goto L8;
        ViewPropertyAnimatorCompatSet r10 = this.mCurrentShowAnim;
        if (r10 == null) goto L9;
        r10.cancel();
        return;
    L9:
        return;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setSplitBackgroundDrawable(Drawable r5) {
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setStackedBackgroundDrawable(Drawable r5) {
        this.mContainerView.setStackedBackground(r5);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setSubtitle(int r5) {
        setSubtitle(this.mContext.getString(r5));
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setTitle(int r5) {
        setTitle(this.mContext.getString(r5));
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setWindowTitle(CharSequence r5) {
        this.mDecorToolbar.setWindowTitle(r5);
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
    public ActionMode startActionMode(ActionMode.Callback r5) {
        ActionModeImpl r10 = this.mActionMode;
        if (r10 == null) goto L5;
        r10.finish();
    L5:
        this.mOverlayLayout.setHideOnContentScrollEnabled(false);
        this.mContextView.killMode();
        ActionModeImpl r11 = new ActionModeImpl(this, this.mContextView.getContext(), r5);
        if (r11.dispatchOnCreate() == false) goto L9;
        this.mActionMode = r11;
        r11.invalidate();
        this.mContextView.initForMode(r11);
        animateToMode(true);
        return r11;
    L9:
        return null;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void addTab(ActionBar.Tab r5, int r10) {
        addTab(r5, r10, this.mTabs.isEmpty());
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHomeActionContentDescription(int r5) {
        this.mDecorToolbar.setNavigationContentDescription(r5);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHomeAsUpIndicator(int r5) {
        this.mDecorToolbar.setNavigationIcon(r5);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setIcon(Drawable r5) {
        this.mDecorToolbar.setIcon(r5);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setLogo(Drawable r5) {
        this.mDecorToolbar.setLogo(r5);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setSubtitle(CharSequence r5) {
        this.mDecorToolbar.setSubtitle(r5);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setTitle(CharSequence r5) {
        this.mDecorToolbar.setTitle(r5);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void addTab(ActionBar.Tab r5, boolean r10) {
        ensureTabsExist();
        this.mTabScrollView.addTab(r5, r10);
        configureTab(r5, this.mTabs.size());
        if (r10 == false) goto L6;
        selectTab(r5);
        return;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayOptions(int r5, int r10) {
        int r11 = this.mDecorToolbar.getDisplayOptions();
        if ((r10 & 4) == 0) goto L5;
        this.mDisplayHomeAsUpSet = true;
    L5:
        this.mDecorToolbar.setDisplayOptions((r5 & r10) | ((~r10) & r11));
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setCustomView(View r5) {
        this.mDecorToolbar.setCustomView(r5);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setCustomView(View r5, ActionBar.LayoutParams r10) {
        r5.setLayoutParams(r10);
        this.mDecorToolbar.setCustomView(r5);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void addTab(ActionBar.Tab r5, int r10, boolean r11) {
        ensureTabsExist();
        this.mTabScrollView.addTab(r5, r10, r11);
        configureTab(r5, r10);
        if (r11 == false) goto L6;
        selectTab(r5);
        return;
    }

    public WindowDecorActionBar(Dialog r5) {
        this.mTabs = new ArrayList();
        this.mSavedTabPosition = -1;
        this.mMenuVisibilityListeners = new ArrayList();
        this.mCurWindowVisibility = 0;
        this.mContentAnimations = true;
        this.mNowShowing = true;
        this.mHideListener = new AnonymousClass1(this);
        this.mShowListener = new AnonymousClass2(this);
        this.mUpdateListener = new AnonymousClass3(this);
        init(r5.getWindow().getDecorView());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public WindowDecorActionBar(View r5) {
        this.mTabs = new ArrayList();
        this.mSavedTabPosition = -1;
        this.mMenuVisibilityListeners = new ArrayList();
        this.mCurWindowVisibility = 0;
        this.mContentAnimations = true;
        this.mNowShowing = true;
        this.mHideListener = new AnonymousClass1(this);
        this.mShowListener = new AnonymousClass2(this);
        this.mUpdateListener = new AnonymousClass3(this);
        init(r5);
    }
}
