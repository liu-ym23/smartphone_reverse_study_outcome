package com.ss.android.lark.chameleon.pluginsystem.plugin;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.chameleon.container.webcontainer.util.ChameleonContainerUtils;
import com.ss.android.lark.chameleon.idependency.Log;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class SimpleUIContainer implements UIContainer {
    private final String TAG;
    protected final Map<String, WeakReference<Fragment>> addedFragments;
    private final Context context;
    private final Map<String, TransactionParams> fragmentTransactionParams;
    private final LayoutInflater inflater;
    private UIContainer.LayoutStrategy layoutStrategy;
    protected final FragmentManager pluginFragmentsContainer;
    protected final View pluginViewsContainer;
    private TitleBar titleBar;

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.UIContainer
    public void disablePluginsFitSystemWindow() {
        View r0 = new View(getContext());
        r0.setFitsSystemWindows(true);
        this.layoutStrategy.getAllPluginsContainer().addView(r0, 0);
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.UIContainer
    public TitleBar getTitleBar() {
        if (this.titleBar != null) goto L6;
        Log.w(this.TAG, new IllegalStateException("No title bar injected !").toString());
    L6:
        return this.titleBar;
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.UIContainer
    public void hideStatusBar() {
        Context r0 = this.context;
        if ((r0 instanceof Activity) == false) goto L6;
        ((Activity) r0).getWindow().addFlags(ChameleonContainerUtils.MAX_URL_LENGTH);
        return;
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.UIContainer
    public UIState saveUIState() {
        return this.layoutStrategy.saveUIState();
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.UIContainer
    public void showStatusBar() {
        Context r0 = this.context;
        if ((r0 instanceof Activity) == false) goto L6;
        ((Activity) r0).getWindow().clearFlags(ChameleonContainerUtils.MAX_URL_LENGTH);
        return;
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.UIContainer
    public View getContentView() {
        return this.pluginViewsContainer;
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.UIContainer
    public Context getContext() {
        return this.context;
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.UIContainer
    public FragmentManager getFragmentManager() {
        return this.pluginFragmentsContainer;
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.UIContainer
    public UIContainer.LayoutStrategy getLayoutStrategy() {
        return this.layoutStrategy;
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.UIContainer
    public Fragment findFragment(Plugin r2) {
        String r3 = pluginContainerTag(r2);
        Fragment r4 = this.pluginFragmentsContainer.findFragmentByTag(r3);
        if (r4 != null) goto L5;
    L7:
        return null;
    L5:
        if (r4.isAdded() == false) goto L7;
        return r4;
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.UIContainer
    public View findView(int r2) {
        return this.pluginViewsContainer.findViewById(r2);
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.UIContainer
    public ViewGroup getPluginContainer(Plugin r2) {
        return this.layoutStrategy.getPluginContainer(this, r2);
    }

    public String getString(int r2) {
        return getContext().getResources().getString(r2);
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.UIContainer
    public boolean isRemovingOrNotExistFragment(Plugin r2) {
        return !this.addedFragments.containsKey(pluginContainerTag(r2));
    }

    public String pluginContainerTag(Plugin r1) {
        return r1.getClass().getName();
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.UIContainer
    public void removeFragment(Plugin r7) {
        String r0 = pluginContainerTag(r7);
        TransactionParams r1 = this.fragmentTransactionParams.remove(r0);
        Fragment r8 = findFragment(r7);
        WeakReference<Fragment> r2 = this.addedFragments.remove(r0);
        if (r8 != null) goto L6;
        if (r2 == null) goto L6;
        r8 = r2.get();
    L6:
        if (r8 == null) goto L12;
        FragmentTransaction r3 = this.pluginFragmentsContainer.beginTransaction();
        if (r1 == null) goto L10;
        r3.setCustomAnimations(r1.enterAnimation, r1.exitAnimation, r1.popEnterAnimation, r1.popExitAnimation);
    L10:
        r3.remove(r8).commitAllowingStateLoss();
    L12:
        if (this.pluginFragmentsContainer.isStateSaved() == false) goto L15;
        Log.w(this.TAG, "Can not perform this action after onSaveInstanceState");
        return;
    L15:
        int r9 = this.pluginFragmentsContainer.getBackStackEntryCount() - 1;
    L16:
        if (r9 < 0) goto L24;
        if (r0.equals(this.pluginFragmentsContainer.getBackStackEntryAt(r9).getName()) == true) goto L19;
        r9 = r9 - 1;
        goto L16
    L19:
        this.pluginFragmentsContainer.popBackStack(r0, 1);
        return;
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.UIContainer
    public void restoreUIState(UIState r2) {
        this.layoutStrategy.restoreUIState(r2);
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.UIContainer
    public void setLayoutStrategy(UIContainer.LayoutStrategy r1) {
        this.layoutStrategy = r1;
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.UIContainer
    public void setTitleBar(TitleBar r1) {
        this.titleBar = r1;
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.UIContainer
    public View findView(Object r2) {
        return this.pluginViewsContainer.findViewWithTag(r2);
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.UIContainer
    public void addOrReplaceFragment(Plugin r2, Fragment r3) {
        addOrReplaceFragment(r2, r3, null);
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.UIContainer
    public View addView(Plugin r4, int r5) {
        ViewGroup r0 = getPluginContainer(r4);
        View r6 = this.inflater.inflate(r5, r0, false);
        addView(r4, r6);
        return r6;
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.UIContainer
    public void removeView(Plugin r1, View r2) {
        getPluginContainer(r1).removeView(r2);
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.UIContainer
    public void addView(Plugin r1, View r2) {
        getPluginContainer(r1).addView(r2);
    }

    public SimpleUIContainer(Context r2, View r3, FragmentManager r4) {
        this(r2, r3, r4, null);
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.UIContainer
    public void addOrReplaceFragment(Plugin r7, Fragment r8, TransactionParams r9) {
        String r0 = pluginContainerTag(r7);
        FragmentTransaction r1 = this.pluginFragmentsContainer.beginTransaction();
        if (r9 == null) goto L7;
        r1.setCustomAnimations(r9.enterAnimation, r9.exitAnimation, r9.popEnterAnimation, r9.popExitAnimation);
        if (r9.addToBackStack == false) goto L7;
        r1.addToBackStack(r0);
    L7:
        this.fragmentTransactionParams.put(r0, r9);
        this.addedFragments.put(r0, new WeakReference(r8));
        INVOKEVIRTUAL_com_ss_android_lark_chameleon_pluginsystem_plugin_SimpleUIContainer_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_replace(r1, getPluginContainer(r7).getId(), r8, r0);
        r1.commitAllowingStateLoss();
    }

    public SimpleUIContainer(Context r3, View r4, FragmentManager r5, TitleBar r6) {
        this.TAG = "BaseUIContainer#" + Integer.toHexString(hashCode());
        this.context = r3;
        this.pluginViewsContainer = r4;
        this.pluginFragmentsContainer = r5;
        this.titleBar = r6;
        this.inflater = LayoutInflater.from(r3);
        this.fragmentTransactionParams = new HashMap();
        this.addedFragments = new HashMap();
    }

    public static FragmentTransaction INVOKEVIRTUAL_com_ss_android_lark_chameleon_pluginsystem_plugin_SimpleUIContainer_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_replace(FragmentTransaction r1, int r2, Fragment r3, String r4) {
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r1, r3, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, r4, r2) == false) goto L6;
        return r1;
    L6:
        return r1.replace(r2, r3, r4);
    }
}
