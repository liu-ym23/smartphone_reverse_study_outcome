package com.ss.android.lark.chameleon.pluginsystem.plugin;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface UIContainer {

    public interface LayoutStrategy {
        ViewGroup getAllPluginsContainer();

        ViewGroup getPluginContainer(UIContainer r1, Plugin r2);

        void restoreUIState(UIState r1);

        UIState saveUIState();

        void updateLayoutStrategy(PluginList r1);
    }

    void addOrReplaceFragment(Plugin r1, Fragment r2);

    void addOrReplaceFragment(Plugin r1, Fragment r2, TransactionParams r3);

    View addView(Plugin r1, int r2);

    void addView(Plugin r1, View r2);

    void disablePluginsFitSystemWindow();

    Fragment findFragment(Plugin r1);

    View findView(int r1);

    View findView(Object r1);

    View getContentView();

    Context getContext();

    FragmentManager getFragmentManager();

    LayoutStrategy getLayoutStrategy();

    ViewGroup getPluginContainer(Plugin r1);

    TitleBar getTitleBar();

    void hideStatusBar();

    boolean isRemovingOrNotExistFragment(Plugin r1);

    void removeFragment(Plugin r1);

    void removeView(Plugin r1, View r2);

    void restoreUIState(UIState r1);

    UIState saveUIState();

    void setLayoutStrategy(LayoutStrategy r1);

    void setTitleBar(TitleBar r1);

    void showStatusBar();
}
