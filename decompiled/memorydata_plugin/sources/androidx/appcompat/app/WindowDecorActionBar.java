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
import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
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

    public class ActionModeImpl extends ActionMode implements MenuBuilder.Callback {
        private final Context mActionModeContext;
        private ActionMode.Callback mCallback;
        private WeakReference<View> mCustomView;
        private final MenuBuilder mMenu;
        final /* synthetic */ WindowDecorActionBar this$0;

        public ActionModeImpl(WindowDecorActionBar r3, Context r4, ActionMode.Callback r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
            ActionMode.Callback r7 = (ActionMode.Callback) ZeusTransformUtils.wrapperContextForParams(r5, ActionMode.Callback.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.mActionModeContext = ZeusTransformUtils.wrapperContext(r6, "com.obric.memorydata.plugin");
            this.mCallback = r7;
            MenuBuilder r8 = new MenuBuilder(r6).setDefaultShowAsAction(1);
            this.mMenu = r8;
            r8.setCallback(this);
        }

        public boolean dispatchOnCreate() {
            this.mMenu.stopDispatchingItemsChanged();
            boolean r0 = this.mCallback.onCreateActionMode(this, this.mMenu);     // Catch: Throwable -> L6
            this.mMenu.startDispatchingItemsChanged();
            return r0;
        L6:
            th = move-exception;
            this.mMenu.startDispatchingItemsChanged();
            throw th;
        }

        @Override // androidx.appcompat.view.ActionMode
        public void finish() {
            if (this.this$0.mActionMode == this) goto L6;
            return;
        L6:
            if (WindowDecorActionBar.checkShowingFlags(this.this$0.mHiddenByApp, this.this$0.mHiddenBySystem, false) == true) goto L8;
            this.this$0.mDeferredDestroyActionMode = this;
            WindowDecorActionBar r0 = this.this$0;
            r0.mDeferredModeDestroyCallback = this.mCallback;
        L9:
            this.mCallback = null;
            this.this$0.animateToMode(false);
            this.this$0.mContextView.closeMode();
            this.this$0.mOverlayLayout.setHideOnContentScrollEnabled(this.this$0.mHideOnContentScroll);
            this.this$0.mActionMode = null;
            return;
        L8:
            this.mCallback.onDestroyActionMode(this);
            goto L9
        }

        @Override // androidx.appcompat.view.ActionMode
        public View getCustomView() {
            WeakReference<View> r2 = this.mCustomView;
            if (r2 != null) goto L7;
            return null;
        L7:
            return (View) ZeusTransformUtils.preCheckCast(r2.get(), View.class, "com.obric.memorydata.plugin");
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

        public void onCloseMenu(MenuBuilder r1, boolean r2) {
        }

        public void onCloseSubMenu(SubMenuBuilder r1) {
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public boolean onMenuItemSelected(MenuBuilder r2, MenuItem r3) {
            MenuItem r4 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r3, MenuItem.class, "com.obric.memorydata.plugin");
            ActionMode.Callback r5 = this.mCallback;
            if (r5 != null) goto L5;
            return false;
        L5:
            return r5.onActionItemClicked(this, r4);
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public void onMenuModeChange(MenuBuilder r1) {
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
            new MenuPopupHelper((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.this$0.getThemedContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r5).show();
            return true;
        }

        @Override // androidx.appcompat.view.ActionMode
        public void setCustomView(View r2) {
            this.this$0.mContextView.setCustomView(r2);
            this.mCustomView = new WeakReference(r2);
        }

        @Override // androidx.appcompat.view.ActionMode
        public void setSubtitle(int r3) {
            setSubtitle(ZeusTransformUtils.getResources(this.this$0.mContext, "com.obric.memorydata.plugin").getString(r3));
        }

        @Override // androidx.appcompat.view.ActionMode
        public void setSubtitle(CharSequence r3) {
            CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
            this.this$0.mContextView.setSubtitle(r4);
        }

        @Override // androidx.appcompat.view.ActionMode
        public void setTitle(int r3) {
            setTitle(ZeusTransformUtils.getResources(this.this$0.mContext, "com.obric.memorydata.plugin").getString(r3));
        }

        @Override // androidx.appcompat.view.ActionMode
        public void setTitle(CharSequence r3) {
            CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
            this.this$0.mContextView.setTitle(r4);
        }

        @Override // androidx.appcompat.view.ActionMode
        public void setTitleOptionalHint(boolean r1) {
            super.setTitleOptionalHint(r1);
            this.this$0.mContextView.setTitleOptional(r1);
        }
    }

    public class TabImpl extends ActionBar.Tab {
        private ActionBar.TabListener mCallback;
        private CharSequence mContentDesc;
        private View mCustomView;
        private Drawable mIcon;
        private int mPosition;
        private Object mTag;
        private CharSequence mText;
        final /* synthetic */ WindowDecorActionBar this$0;

        public TabImpl(WindowDecorActionBar r1) {
            this.this$0 = r1;
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
        public ActionBar.Tab setContentDescription(int r3) {
            return setContentDescription(ZeusTransformUtils.getResources(this.this$0.mContext, "com.obric.memorydata.plugin").getText(r3));
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setContentDescription(CharSequence r3) {
            this.mContentDesc = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
            if (this.mPosition < 0) goto L5;
            this.this$0.mTabScrollView.updateTab(this.mPosition);
        L5:
            return this;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setCustomView(int r4) {
            return setCustomView(ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.this$0.getThemedContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), r4, null, "com.obric.memorydata.plugin"));
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setCustomView(View r2) {
            this.mCustomView = r2;
            if (this.mPosition < 0) goto L5;
            this.this$0.mTabScrollView.updateTab(this.mPosition);
        L5:
            return this;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setIcon(int r2) {
            return setIcon(AppCompatResources.getDrawable(this.this$0.mContext, r2));
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setIcon(Drawable r2) {
            this.mIcon = r2;
            if (this.mPosition < 0) goto L5;
            this.this$0.mTabScrollView.updateTab(this.mPosition);
        L5:
            return this;
        }

        public void setPosition(int r1) {
            this.mPosition = r1;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setTabListener(ActionBar.TabListener r3) {
            this.mCallback = (ActionBar.TabListener) ZeusTransformUtils.wrapperContextForParams(r3, ActionBar.TabListener.class, "com.obric.memorydata.plugin");
            return this;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setTag(Object r1) {
            this.mTag = r1;
            return this;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setText(int r3) {
            return setText(ZeusTransformUtils.getResources(this.this$0.mContext, "com.obric.memorydata.plugin").getText(r3));
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setText(CharSequence r3) {
            this.mText = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
            if (this.mPosition < 0) goto L5;
            this.this$0.mTabScrollView.updateTab(this.mPosition);
        L5:
            return this;
        }
    }

    static {
        sHideInterpolator = new AccelerateInterpolator();
        sShowInterpolator = new DecelerateInterpolator();
    }

    public WindowDecorActionBar(Activity r3, boolean r4) {
        Activity r5 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin");
        this.mTabs = new ArrayList();
        this.mSavedTabPosition = -1;
        this.mMenuVisibilityListeners = new ArrayList();
        this.mCurWindowVisibility = 0;
        this.mContentAnimations = true;
        this.mNowShowing = true;
        this.mHideListener = new AnonymousClass1(this);
        this.mShowListener = new AnonymousClass2(this);
        this.mUpdateListener = new AnonymousClass3(this);
        this.mActivity = ZeusTransformUtils.wrapperContext2Activity(r5, "com.obric.memorydata.plugin");
        View r6 = ZeusTransformUtils.getWindow(r5, "com.obric.memorydata.plugin").getDecorView();
        init(r6);
        if (r4 == true) goto L6;
        this.mContentView = r6.findViewById(R.id.content);
        return;
    }

    public WindowDecorActionBar(Dialog r2) {
        this.mTabs = new ArrayList();
        this.mSavedTabPosition = -1;
        this.mMenuVisibilityListeners = new ArrayList();
        this.mCurWindowVisibility = 0;
        this.mContentAnimations = true;
        this.mNowShowing = true;
        this.mHideListener = new AnonymousClass1(this);
        this.mShowListener = new AnonymousClass2(this);
        this.mUpdateListener = new AnonymousClass3(this);
        init(r2.getWindow().getDecorView());
    }

    public WindowDecorActionBar(View r2) {
        this.mTabs = new ArrayList();
        this.mSavedTabPosition = -1;
        this.mMenuVisibilityListeners = new ArrayList();
        this.mCurWindowVisibility = 0;
        this.mContentAnimations = true;
        this.mNowShowing = true;
        this.mHideListener = new AnonymousClass1(this);
        this.mShowListener = new AnonymousClass2(this);
        this.mUpdateListener = new AnonymousClass3(this);
        init(r2);
    }

    static boolean checkShowingFlags(boolean r1, boolean r2, boolean r3) {
        if (r3 == false) goto L5;
        return true;
    L5:
        if (r1 == true) goto L9;
        if (r2 == true) goto L11;
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
        ScrollingTabContainerView r0 = this.mTabScrollView;
        if (r0 == null) goto L8;
        r0.removeAllTabs();
    L8:
        this.mSavedTabPosition = -1;
    }

    private void configureTab(ActionBar.Tab r4, int r5) {
        TabImpl r6 = (TabImpl) ZeusTransformUtils.preCheckCast(r4, TabImpl.class, "com.obric.memorydata.plugin");
        if (r6.getCallback() == null) goto L10;
        r6.setPosition(r5);
        this.mTabs.add(r5, r6);
        int r7 = this.mTabs.size();
    L5:
        r5 = r5 + 1;
        if (r5 >= r7) goto L8;
        ((TabImpl) ZeusTransformUtils.preCheckCast(this.mTabs.get(r5), TabImpl.class, "com.obric.memorydata.plugin")).setPosition(r5);
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
        ScrollingTabContainerView r0 = new ScrollingTabContainerView(this.mContext);
        if (this.mHasEmbeddedTabs == false) goto L9;
        r0.setVisibility(0);
        this.mDecorToolbar.setEmbeddedTabView(r0);
    L15:
        this.mTabScrollView = r0;
        return;
    L9:
        if (getNavigationMode() != 2) goto L13;
        r0.setVisibility(0);
        ActionBarOverlayLayout r1 = this.mOverlayLayout;
        if (r1 == null) goto L14;
        ViewCompat.requestApplyInsets(r1);
    L14:
        this.mContainerView.setTabContainer(r0);
        goto L15
    L13:
        r0.setVisibility(8);
        goto L14
    }

    private DecorToolbar getDecorToolbar(View r3) {
        if (ZeusTransformUtils.instanceOf(r3, DecorToolbar.class) == false) goto L7;
        return (DecorToolbar) ZeusTransformUtils.preCheckCast(r3, DecorToolbar.class, "com.obric.memorydata.plugin");
    L7:
        if (ZeusTransformUtils.instanceOf(r3, Toolbar.class) == true) goto L9;
        StringBuilder r0 = new StringBuilder().append("Can't make a decor toolbar out of ");
        if (r3 == null) goto L13;
        String r4 = r3.getClass().getSimpleName();
    L15:
        throw new IllegalStateException(r0.append(r4).toString());
    L13:
        r4 = "null";
        goto L15
    L9:
        return ((Toolbar) ZeusTransformUtils.preCheckCast(r3, Toolbar.class, "com.obric.memorydata.plugin")).getWrapper();
    }

    private void hideForActionMode() {
        if (this.mShowingForMode == false) goto L9;
        this.mShowingForMode = false;
        ActionBarOverlayLayout r1 = this.mOverlayLayout;
        if (r1 == null) goto L7;
        r1.setShowingForActionMode(false);
    L7:
        updateVisibility(false);
        return;
    }

    private void init(View r8) {
        ActionBarOverlayLayout r0 = (ActionBarOverlayLayout) ZeusTransformUtils.preCheckCast(r8.findViewById(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.id.decor_content_parent, OaidModel.KEY_ID, "decor_content_parent")), ActionBarOverlayLayout.class, "com.obric.memorydata.plugin");
        this.mOverlayLayout = r0;
        if (r0 == null) goto L5;
        r0.setActionBarVisibilityCallback(this);
    L5:
        this.mDecorToolbar = getDecorToolbar(r8.findViewById(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.id.action_bar, OaidModel.KEY_ID, "action_bar")));
        this.mContextView = (ActionBarContextView) ZeusTransformUtils.preCheckCast(r8.findViewById(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.id.action_context_bar, OaidModel.KEY_ID, "action_context_bar")), ActionBarContextView.class, "com.obric.memorydata.plugin");
        ActionBarContainer r9 = (ActionBarContainer) ZeusTransformUtils.preCheckCast(r8.findViewById(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.id.action_bar_container, OaidModel.KEY_ID, "action_bar_container")), ActionBarContainer.class, "com.obric.memorydata.plugin");
        this.mContainerView = r9;
        DecorToolbar r1 = this.mDecorToolbar;
        if (r1 == null) goto L31;
        if (this.mContextView == null) goto L31;
        if (r9 == null) goto L31;
        this.mContext = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r1.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        if ((this.mDecorToolbar.getDisplayOptions() & 4) == 0) goto L13;
        boolean r10 = true;
    L14:
        if (r10 == false) goto L16;
        this.mDisplayHomeAsUpSet = true;
    L16:
        ActionBarPolicy r2 = ActionBarPolicy.get(this.mContext);
        if (r2.enableHomeButtonByDefault() == true) goto L21;
        if (r10 == true) goto L21;
        boolean r11 = false;
    L22:
        setHomeButtonEnabled(r11);
        setHasEmbeddedTabs(r2.hasEmbeddedTabs());
        TypedArray r12 = this.mContext.obtainStyledAttributes(null, com.obric.memorydata.plugin.R.styleable.ActionBar, ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.attr.actionBarStyle, "attr", "actionBarStyle"), 0);
        if (r12.getBoolean(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.ActionBar_hideOnContentScroll, "styleable", "ActionBar_hideOnContentScroll"), false) == false) goto L25;
        setHideOnContentScrollEnabled(true);
    L25:
        int r3 = r12.getDimensionPixelSize(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.ActionBar_elevation, "styleable", "ActionBar_elevation"), 0);
        if (r3 == 0) goto L28;
        setElevation(r3);
    L28:
        r12.recycle();
        return;
    L21:
        r11 = true;
        goto L22
    L13:
        r10 = false;
    L31:
        throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
    }

    private void setHasEmbeddedTabs(boolean r5) {
        this.mHasEmbeddedTabs = r5;
        if (r5 == true) goto L5;
        this.mDecorToolbar.setEmbeddedTabView(null);
        this.mContainerView.setTabContainer(this.mTabScrollView);
    L6:
        boolean r1 = true;
        if (getNavigationMode() != 2) goto L9;
        boolean r6 = true;
    L10:
        ScrollingTabContainerView r0 = this.mTabScrollView;
        if (r0 == null) goto L17;
        if (r6 == false) goto L16;
        r0.setVisibility(0);
        ActionBarOverlayLayout r2 = this.mOverlayLayout;
        if (r2 == null) goto L17;
        ViewCompat.requestApplyInsets(r2);
        goto L17
    L16:
        r0.setVisibility(8);
    L17:
        DecorToolbar r3 = this.mDecorToolbar;
        if (this.mHasEmbeddedTabs == true) goto L21;
        if (r6 == false) goto L21;
        boolean r4 = true;
    L22:
        r3.setCollapsible(r4);
        ActionBarOverlayLayout r7 = this.mOverlayLayout;
        if (this.mHasEmbeddedTabs == true) goto L26;
        if (r6 == false) goto L26;
    L27:
        r7.setHasNonEmbeddedTabs(r1);
        return;
    L26:
        r1 = false;
    L21:
        r4 = false;
        goto L22
    L9:
        r6 = false;
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
        ActionBarOverlayLayout r1 = this.mOverlayLayout;
        if (r1 == null) goto L7;
        r1.setShowingForActionMode(true);
    L7:
        updateVisibility(false);
        return;
    }

    private void updateVisibility(boolean r4) {
        if (checkShowingFlags(this.mHiddenByApp, this.mHiddenBySystem, this.mShowingForMode) == false) goto L8;
        if (this.mNowShowing == true) goto L11;
        this.mNowShowing = true;
        doShow(r4);
        return;
    L11:
        return;
    L8:
        if (this.mNowShowing == false) goto L13;
        this.mNowShowing = false;
        doHide(r4);
        return;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void addOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener r3) {
        ActionBar.OnMenuVisibilityListener r4 = (ActionBar.OnMenuVisibilityListener) ZeusTransformUtils.wrapperContextForParams(r3, ActionBar.OnMenuVisibilityListener.class, "com.obric.memorydata.plugin");
        this.mMenuVisibilityListeners.add(r4);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void addTab(ActionBar.Tab r2) {
        addTab(r2, this.mTabs.isEmpty());
    }

    @Override // androidx.appcompat.app.ActionBar
    public void addTab(ActionBar.Tab r2, int r3) {
        addTab(r2, r3, this.mTabs.isEmpty());
    }

    @Override // androidx.appcompat.app.ActionBar
    public void addTab(ActionBar.Tab r2, int r3, boolean r4) {
        ensureTabsExist();
        this.mTabScrollView.addTab(r2, r3, r4);
        configureTab(r2, r3);
        if (r4 == false) goto L6;
        selectTab(r2);
        return;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void addTab(ActionBar.Tab r2, boolean r3) {
        ensureTabsExist();
        this.mTabScrollView.addTab(r2, r3);
        configureTab(r2, this.mTabs.size());
        if (r3 == false) goto L6;
        selectTab(r2);
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
        ViewPropertyAnimatorCompat r9 = this.mContextView.setupAnimatorToVisibility(0, 200);
    L11:
        ViewPropertyAnimatorCompatSet r0 = new ViewPropertyAnimatorCompatSet();
        r0.playSequentially(r11, r9);
        r0.start();
        return;
    L10:
        ViewPropertyAnimatorCompat r12 = this.mDecorToolbar.setupAnimatorToVisibility(0, 200);
        r11 = this.mContextView.setupAnimatorToVisibility(8, 100);
        r9 = r12;
        goto L11
    L4:
        hideForActionMode();
        goto L6
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean collapseActionView() {
        DecorToolbar r0 = this.mDecorToolbar;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.hasExpandedActionView() == false) goto L10;
        this.mDecorToolbar.collapseActionView();
        return true;
    L10:
        return false;
    }

    void completeDeferredDestroyActionMode() {
        ActionMode.Callback r0 = this.mDeferredModeDestroyCallback;
        if (r0 == null) goto L6;
        r0.onDestroyActionMode(this.mDeferredDestroyActionMode);
        this.mDeferredDestroyActionMode = null;
        this.mDeferredModeDestroyCallback = null;
        return;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void dispatchMenuVisibilityChanged(boolean r6) {
        if (r6 != this.mLastMenuVisibility) goto L5;
        return;
    L5:
        this.mLastMenuVisibility = r6;
        int r0 = this.mMenuVisibilityListeners.size();
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L8;
        ((ActionBar.OnMenuVisibilityListener) ZeusTransformUtils.preCheckCast(this.mMenuVisibilityListeners.get(r1), ActionBar.OnMenuVisibilityListener.class, "com.obric.memorydata.plugin")).onMenuVisibilityChanged(r6);
        r1 = r1 + 1;
        goto L6
    }

    public void doHide(boolean r5) {
        ViewPropertyAnimatorCompatSet r0 = this.mCurrentShowAnim;
        if (r0 == null) goto L6;
        r0.cancel();
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
        ViewPropertyAnimatorCompatSet r1 = new ViewPropertyAnimatorCompatSet();
        float r2 = -this.mContainerView.getHeight();
        if (r5 == false) goto L13;
        int[] r6 = {0, 0};
        this.mContainerView.getLocationInWindow(r6);
        r2 = r2 - r6[1];
    L13:
        ViewPropertyAnimatorCompat r7 = ViewCompat.animate(this.mContainerView).translationY(r2);
        r7.setUpdateListener(this.mUpdateListener);
        r1.play(r7);
        if (this.mContentAnimations == false) goto L18;
        View r8 = this.mContentView;
        if (r8 == null) goto L18;
        r1.play(ViewCompat.animate(r8).translationY(r2));
    L18:
        r1.setInterpolator(sHideInterpolator);
        r1.setDuration(250);
        r1.setListener(this.mHideListener);
        this.mCurrentShowAnim = r1;
        r1.start();
    }

    public void doShow(boolean r5) {
        ViewPropertyAnimatorCompatSet r0 = this.mCurrentShowAnim;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        this.mContainerView.setVisibility(0);
        if (this.mCurWindowVisibility == 0) goto L8;
    L19:
        this.mContainerView.setAlpha(1.0f);
        this.mContainerView.setTranslationY(0.0f);
        if (this.mContentAnimations == false) goto L24;
        View r6 = this.mContentView;
        if (r6 == null) goto L24;
        r6.setTranslationY(0.0f);
    L24:
        this.mShowListener.onAnimationEnd(null);
    L25:
        ActionBarOverlayLayout r4 = this.mOverlayLayout;
        if (r4 == null) goto L29;
        ViewCompat.requestApplyInsets(r4);
        return;
    L29:
        return;
    L8:
        if (this.mShowHideAnimationEnabled == true) goto L10;
        if (r5 == false) goto L19;
    L10:
        this.mContainerView.setTranslationY(0.0f);
        float r1 = -this.mContainerView.getHeight();
        if (r5 == false) goto L13;
        int[] r7 = {0, 0};
        this.mContainerView.getLocationInWindow(r7);
        r1 = r1 - r7[1];
    L13:
        this.mContainerView.setTranslationY(r1);
        ViewPropertyAnimatorCompatSet r8 = new ViewPropertyAnimatorCompatSet();
        ViewPropertyAnimatorCompat r2 = ViewCompat.animate(this.mContainerView).translationY(0.0f);
        r2.setUpdateListener(this.mUpdateListener);
        r8.play(r2);
        if (this.mContentAnimations == false) goto L18;
        View r3 = this.mContentView;
        if (r3 == null) goto L18;
        r3.setTranslationY(r1);
        r8.play(ViewCompat.animate(this.mContentView).translationY(0.0f));
    L18:
        r8.setInterpolator(sShowInterpolator);
        r8.setDuration(250);
        r8.setListener(this.mShowListener);
        this.mCurrentShowAnim = r8;
        r8.start();
        goto L25
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void enableContentAnimations(boolean r1) {
        this.mContentAnimations = r1;
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
        int r0 = this.mDecorToolbar.getNavigationMode();
        if (r0 == 1) goto L11;
        if (r0 == 2) goto L9;
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
        int r0 = this.mDecorToolbar.getNavigationMode();
        if (r0 == 1) goto L12;
        if (r0 == 2) goto L7;
        return -1;
    L7:
        TabImpl r3 = this.mSelectedTab;
        if (r3 != null) goto L10;
        return -1;
    L10:
        return r3.getPosition();
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
    public ActionBar.Tab getTabAt(int r2) {
        return (ActionBar.Tab) ZeusTransformUtils.preCheckCast(this.mTabs.get(r2), ActionBar.Tab.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.appcompat.app.ActionBar
    public int getTabCount() {
        return this.mTabs.size();
    }

    @Override // androidx.appcompat.app.ActionBar
    public Context getThemedContext() {
        if (this.mThemedContext != null) goto L10;
        TypedValue r0 = new TypedValue();
        this.mContext.getTheme().resolveAttribute(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.attr.actionBarWidgetTheme, "attr", "actionBarWidgetTheme"), r0, true);
        int r1 = r0.resourceId;
        if (r1 == 0) goto L7;
        Context r2 = ZeusTransformUtils.wrapperContext(new ContextThemeWrapper(this.mContext, r1), "com.obric.memorydata.plugin");
    L8:
        this.mThemedContext = r2;
        goto L10
    L7:
        r2 = ZeusTransformUtils.wrapperContext(this.mContext, "com.obric.memorydata.plugin");
    L10:
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
        int r0 = getHeight();
        if (this.mNowShowing == false) goto L8;
        if (r0 != 0) goto L6;
    L7:
        return true;
    L6:
        if (getHideOffset() < r0) goto L7;
    L8:
        return false;
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean isTitleTruncated() {
        DecorToolbar r0 = this.mDecorToolbar;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isTitleTruncated() == false) goto L7;
        return true;
    }

    @Override // androidx.appcompat.app.ActionBar
    public ActionBar.Tab newTab() {
        return new TabImpl(this);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void onConfigurationChanged(Configuration r1) {
        setHasEmbeddedTabs(ActionBarPolicy.get(this.mContext).hasEmbeddedTabs());
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void onContentScrollStarted() {
        ViewPropertyAnimatorCompatSet r0 = this.mCurrentShowAnim;
        if (r0 == null) goto L6;
        r0.cancel();
        this.mCurrentShowAnim = null;
        return;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void onContentScrollStopped() {
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean onKeyShortcut(int r4, KeyEvent r5) {
        ActionModeImpl r3 = this.mActionMode;
        if (r3 != null) goto L5;
        return false;
    L5:
        Menu r6 = r3.getMenu();
        if (r6 == null) goto L16;
        if (r5 == null) goto L9;
        int r1 = r5.getDeviceId();
    L10:
        boolean r2 = true;
        if (KeyCharacterMap.load(r1).getKeyboardType() != 1) goto L14;
        r2 = false;
    L14:
        r6.setQwertyMode(r2);
        return r6.performShortcut(r4, r5, 0);
    L9:
        r1 = -1;
        goto L10
    L16:
        return false;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void onWindowVisibilityChanged(int r1) {
        this.mCurWindowVisibility = r1;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void removeAllTabs() {
        cleanupTabs();
    }

    @Override // androidx.appcompat.app.ActionBar
    public void removeOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener r3) {
        ActionBar.OnMenuVisibilityListener r4 = (ActionBar.OnMenuVisibilityListener) ZeusTransformUtils.wrapperContextForParams(r3, ActionBar.OnMenuVisibilityListener.class, "com.obric.memorydata.plugin");
        this.mMenuVisibilityListeners.remove(r4);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void removeTab(ActionBar.Tab r1) {
        removeTabAt(r1.getPosition());
    }

    @Override // androidx.appcompat.app.ActionBar
    public void removeTabAt(int r7) {
        if (this.mTabScrollView != null) goto L5;
        return;
    L5:
        TabImpl r0 = this.mSelectedTab;
        if (r0 == null) goto L8;
        int r1 = r0.getPosition();
    L9:
        this.mTabScrollView.removeTabAt(r7);
        TabImpl r2 = (TabImpl) ZeusTransformUtils.preCheckCast(this.mTabs.remove(r7), TabImpl.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L12;
        r2.setPosition(-1);
    L12:
        int r3 = this.mTabs.size();
        int r4 = r7;
    L13:
        if (r4 >= r3) goto L15;
        ((TabImpl) ZeusTransformUtils.preCheckCast(this.mTabs.get(r4), TabImpl.class, "com.obric.memorydata.plugin")).setPosition(r4);
        r4 = r4 + 1;
        goto L13
    L15:
        if (r1 == r7) goto L17;
        return;
    L17:
        if (this.mTabs.isEmpty() == false) goto L19;
        ActionBar.Tab r8 = null;
    L20:
        selectTab(r8);
        return;
    L19:
        r8 = (ActionBar.Tab) ZeusTransformUtils.preCheckCast(this.mTabs.get(Math.max(0, r7 - 1)), ActionBar.Tab.class, "com.obric.memorydata.plugin");
        goto L20
    L8:
        r1 = this.mSavedTabPosition;
        goto L9
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean requestFocus() {
        ViewGroup r1 = this.mDecorToolbar.getViewGroup();
        if (r1 != null) goto L5;
        return false;
    L5:
        if (r1.hasFocus() == true) goto L10;
        r1.requestFocus();
        return true;
    L10:
        return false;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void selectTab(ActionBar.Tab r5) {
        int r1 = -1;
        if (getNavigationMode() == 2) goto L9;
        if (r5 == null) goto L6;
        r1 = r5.getPosition();
    L6:
        this.mSavedTabPosition = r1;
        return;
    L9:
        if (ZeusTransformUtils.instanceOf(this.mActivity, FragmentActivity.class) == true) goto L11;
    L13:
        FragmentTransaction r0 = null;
    L14:
        TabImpl r3 = this.mSelectedTab;
        if (r3 != r5) goto L18;
        if (r3 == null) goto L27;
        r3.getCallback().onTabReselected(this.mSelectedTab, r0);
        this.mTabScrollView.animateToTab(r5.getPosition());
    L27:
        if (r0 != null) goto L29;
        return;
    L29:
        if (r0.isEmpty() == true) goto L33;
        r0.commit();
        return;
    L33:
        return;
    L18:
        ScrollingTabContainerView r4 = this.mTabScrollView;
        if (r5 == null) goto L21;
        r1 = r5.getPosition();
    L21:
        r4.setTabSelected(r1);
        TabImpl r2 = this.mSelectedTab;
        if (r2 == null) goto L24;
        r2.getCallback().onTabUnselected(this.mSelectedTab, r0);
    L24:
        TabImpl r6 = (TabImpl) ZeusTransformUtils.preCheckCast(r5, TabImpl.class, "com.obric.memorydata.plugin");
        this.mSelectedTab = r6;
        if (r6 == null) goto L27;
        r6.getCallback().onTabSelected(this.mSelectedTab, r0);
        goto L27
    L11:
        if (this.mDecorToolbar.getViewGroup().isInEditMode() == true) goto L13;
        r0 = ((FragmentActivity) ZeusTransformUtils.preCheckCast(this.mActivity, FragmentActivity.class, "com.obric.memorydata.plugin")).getSupportFragmentManager().beginTransaction().disallowAddToBackStack();
        goto L14
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setBackgroundDrawable(Drawable r1) {
        this.mContainerView.setPrimaryBackground(r1);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setCustomView(int r5) {
        setCustomView(ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getThemedContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), r5, this.mDecorToolbar.getViewGroup(), false, "com.obric.memorydata.plugin"));
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setCustomView(View r1) {
        this.mDecorToolbar.setCustomView(r1);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setCustomView(View r1, ActionBar.LayoutParams r2) {
        r1.setLayoutParams(r2);
        this.mDecorToolbar.setCustomView(r1);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDefaultDisplayHomeAsUpEnabled(boolean r2) {
        if (this.mDisplayHomeAsUpSet == true) goto L6;
        setDisplayHomeAsUpEnabled(r2);
        return;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayHomeAsUpEnabled(boolean r2) {
        if (r2 == false) goto L5;
        int r3 = 4;
    L6:
        setDisplayOptions(r3, 4);
        return;
    L5:
        r3 = 0;
        goto L6
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayOptions(int r2) {
        if ((r2 & 4) == 0) goto L5;
        this.mDisplayHomeAsUpSet = true;
    L5:
        this.mDecorToolbar.setDisplayOptions(r2);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayOptions(int r3, int r4) {
        int r0 = this.mDecorToolbar.getDisplayOptions();
        if ((r4 & 4) == 0) goto L5;
        this.mDisplayHomeAsUpSet = true;
    L5:
        this.mDecorToolbar.setDisplayOptions((r3 & r4) | ((~r4) & r0));
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayShowCustomEnabled(boolean r2) {
        if (r2 == false) goto L5;
        int r3 = 16;
    L6:
        setDisplayOptions(r3, 16);
        return;
    L5:
        r3 = 0;
        goto L6
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayShowHomeEnabled(boolean r2) {
        if (r2 == false) goto L5;
        int r3 = 2;
    L6:
        setDisplayOptions(r3, 2);
        return;
    L5:
        r3 = 0;
        goto L6
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayShowTitleEnabled(boolean r2) {
        if (r2 == false) goto L5;
        int r3 = 8;
    L6:
        setDisplayOptions(r3, 8);
        return;
    L5:
        r3 = 0;
        goto L6
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayUseLogoEnabled(boolean r2) {
        setDisplayOptions(r2 ? 1 : 0, 1);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setElevation(float r1) {
        ViewCompat.setElevation(this.mContainerView, r1);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHideOffset(int r2) {
        if (r2 != 0) goto L4;
    L8:
        this.mOverlayLayout.setActionBarHideOffset(r2);
        return;
    L4:
        if (this.mOverlayLayout.isInOverlayMode() == true) goto L8;
        throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to set a non-zero hide offset");
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHideOnContentScrollEnabled(boolean r2) {
        if (r2 == true) goto L4;
    L8:
        this.mHideOnContentScroll = r2;
        this.mOverlayLayout.setHideOnContentScrollEnabled(r2);
        return;
    L4:
        if (this.mOverlayLayout.isInOverlayMode() == true) goto L8;
        throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHomeActionContentDescription(int r1) {
        this.mDecorToolbar.setNavigationContentDescription(r1);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHomeActionContentDescription(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        this.mDecorToolbar.setNavigationContentDescription(r4);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHomeAsUpIndicator(int r1) {
        this.mDecorToolbar.setNavigationIcon(r1);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHomeAsUpIndicator(Drawable r1) {
        this.mDecorToolbar.setNavigationIcon(r1);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHomeButtonEnabled(boolean r1) {
        this.mDecorToolbar.setHomeButtonEnabled(r1);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setIcon(int r1) {
        this.mDecorToolbar.setIcon(r1);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setIcon(Drawable r1) {
        this.mDecorToolbar.setIcon(r1);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setListNavigationCallbacks(SpinnerAdapter r3, ActionBar.OnNavigationListener r4) {
        SpinnerAdapter r5 = (SpinnerAdapter) ZeusTransformUtils.wrapperContextForParams(r3, SpinnerAdapter.class, "com.obric.memorydata.plugin");
        ActionBar.OnNavigationListener r6 = (ActionBar.OnNavigationListener) ZeusTransformUtils.wrapperContextForParams(r4, ActionBar.OnNavigationListener.class, "com.obric.memorydata.plugin");
        this.mDecorToolbar.setDropdownParams(r5, new NavItemSelectedListener(r6));
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setLogo(int r1) {
        this.mDecorToolbar.setLogo(r1);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setLogo(Drawable r1) {
        this.mDecorToolbar.setLogo(r1);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setNavigationMode(int r6) {
        int r0 = this.mDecorToolbar.getNavigationMode();
        if (r0 != 2) goto L6;
        this.mSavedTabPosition = getSelectedNavigationIndex();
        selectTab(null);
        this.mTabScrollView.setVisibility(8);
    L6:
        if (r0 != r6) goto L8;
    L12:
        this.mDecorToolbar.setNavigationMode(r6);
        boolean r1 = false;
        if (r6 != 2) goto L18;
        ensureTabsExist();
        this.mTabScrollView.setVisibility(0);
        int r2 = this.mSavedTabPosition;
        if (r2 == (-1)) goto L18;
        setSelectedNavigationItem(r2);
        this.mSavedTabPosition = -1;
    L18:
        DecorToolbar r3 = this.mDecorToolbar;
        if (r6 == 2) goto L21;
    L23:
        boolean r4 = false;
    L24:
        r3.setCollapsible(r4);
        ActionBarOverlayLayout r5 = this.mOverlayLayout;
        if (r6 == 2) goto L27;
    L29:
        r5.setHasNonEmbeddedTabs(r1);
        return;
    L27:
        if (this.mHasEmbeddedTabs == true) goto L29;
        r1 = true;
        goto L29
    L21:
        if (this.mHasEmbeddedTabs == true) goto L23;
        r4 = true;
        goto L24
    L8:
        if (this.mHasEmbeddedTabs == true) goto L12;
        ActionBarOverlayLayout r7 = this.mOverlayLayout;
        if (r7 == null) goto L12;
        ViewCompat.requestApplyInsets(r7);
        goto L12
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setSelectedNavigationItem(int r3) {
        int r0 = this.mDecorToolbar.getNavigationMode();
        if (r0 != 1) goto L5;
        this.mDecorToolbar.setDropdownSelectedPosition(r3);
        return;
    L5:
        if (r0 != 2) goto L8;
        selectTab((ActionBar.Tab) ZeusTransformUtils.preCheckCast(this.mTabs.get(r3), ActionBar.Tab.class, "com.obric.memorydata.plugin"));
        return;
    L8:
        throw new IllegalStateException("setSelectedNavigationIndex not valid for current navigation mode");
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setShowHideAnimationEnabled(boolean r1) {
        this.mShowHideAnimationEnabled = r1;
        if (r1 == true) goto L8;
        ViewPropertyAnimatorCompatSet r0 = this.mCurrentShowAnim;
        if (r0 == null) goto L9;
        r0.cancel();
        return;
    L9:
        return;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setSplitBackgroundDrawable(Drawable r1) {
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setStackedBackgroundDrawable(Drawable r1) {
        this.mContainerView.setStackedBackground(r1);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setSubtitle(int r2) {
        setSubtitle(this.mContext.getString(r2));
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setSubtitle(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        this.mDecorToolbar.setSubtitle(r4);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setTitle(int r2) {
        setTitle(this.mContext.getString(r2));
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setTitle(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        this.mDecorToolbar.setTitle(r4);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setWindowTitle(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        this.mDecorToolbar.setWindowTitle(r4);
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
        ActionMode.Callback r6 = (ActionMode.Callback) ZeusTransformUtils.wrapperContextForParams(r5, ActionMode.Callback.class, "com.obric.memorydata.plugin");
        ActionModeImpl r0 = this.mActionMode;
        if (r0 == null) goto L5;
        r0.finish();
    L5:
        this.mOverlayLayout.setHideOnContentScrollEnabled(false);
        this.mContextView.killMode();
        ActionModeImpl r1 = new ActionModeImpl(this, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.mContextView.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r6);
        if (r1.dispatchOnCreate() == false) goto L9;
        this.mActionMode = r1;
        r1.invalidate();
        this.mContextView.initForMode(r1);
        animateToMode(true);
        return r1;
    L9:
        return null;
    }
}
