package com.ss.android.lark.chameleon.pluginsystem.plugin;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import com.ss.android.lark.chameleon.widget.titlebar.CommonTitleBar;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface TitleBar {

    /* JADX INFO: renamed from: com.ss.android.lark.chameleon.pluginsystem.plugin.TitleBar$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$setLeftClickListener(TitleBar r0, View.OnClickListener r1) {
        }

        public static void $default$setTitleSize(TitleBar r0, int r1) {
        }
    }

    public static final enum MenuType extends Enum<MenuType> {
        private static final /* synthetic */ MenuType[] $VALUES = null;
        public static final MenuType Left = null;
        public static final MenuType Right = null;

        static {
            MenuType r0 = new MenuType("Left", 0);
            Left = r0;
            MenuType r1 = new MenuType("Right", 1);
            Right = r1;
            $VALUES = new MenuType[]{r0, r1};
        }

        public static MenuType[] values() {
            return (MenuType[]) $VALUES.clone();
        }

        public static MenuType valueOf(String r1) {
            return (MenuType) r27.a.a(MenuType.class, r1);
        }

        private MenuType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public interface OnTitleBarStateChangedListener {
        void onTitleBarStateChanged(DeviceInfo r1);
    }

    public interface SpaceTagInfoChangeListener {
        void onExternalTagChanged(boolean r1);

        void onTemplateTagChanged(boolean r1);
    }

    public static final enum TitleGravity extends Enum<TitleGravity> {
        private static final /* synthetic */ TitleGravity[] $VALUES = null;
        public static final TitleGravity Center = null;
        public static final TitleGravity Left = null;

        static {
            TitleGravity r0 = new TitleGravity("Left", 0);
            Left = r0;
            TitleGravity r1 = new TitleGravity("Center", 1);
            Center = r1;
            $VALUES = new TitleGravity[]{r0, r1};
        }

        public static TitleGravity[] values() {
            return (TitleGravity[]) $VALUES.clone();
        }

        public static TitleGravity valueOf(String r1) {
            return (TitleGravity) r27.a.a(TitleGravity.class, r1);
        }

        private TitleGravity(String r1, int r2) {
            super(r1, r2);
        }
    }

    void addCustomSecondRightView(View r1, ViewGroup.LayoutParams r2);

    void addTitleBarStateChangedListener(OnTitleBarStateChangedListener r1);

    void clearMenus();

    void enableTitleBarAlwaysShowing(boolean r1);

    View findMenuView(String r1);

    DeviceInfo getDeviceInfo();

    List<MenuItem> getMenus(MenuType r1);

    CharSequence getTitle();

    CommonTitleBar getTitleBarLayout();

    void hide(boolean r1);

    void invalidate();

    boolean isLeftIconVisible();

    void removeTitleBarStateChangedListener(OnTitleBarStateChangedListener r1);

    void setBackground(int r1);

    void setDividerVisible(boolean r1);

    void setExternalTagEnabled(boolean r1);

    void setHiddenMenus(List<MenuItem> r1);

    void setLeftClickListener(View.OnClickListener r1);

    void setLeftIconTint(int r1);

    void setLeftIconVisibility(boolean r1);

    void setLeftVisible(boolean r1);

    void setMenuIconTint(int r1);

    void setMenus(List<MenuItem> r1, MenuType r2);

    void setRightVisible(boolean r1);

    void setRiskFlag(boolean r1);

    void setSecondTitle(CharSequence r1);

    void setSecondTitleLeftDrawable(Drawable r1);

    void setSecondTitleVisibility(boolean r1);

    void setSpaceTagTitleBarEnabled(SpaceTagInfoChangeListener r1);

    void setSpaceTagTitleBarEnabled(boolean r1);

    void setStatusBarTransparent(boolean r1);

    void setSubTitle(CharSequence r1);

    void setSubTitleSuffix(CharSequence r1);

    void setTitle(CharSequence r1);

    void setTitleGravity(TitleGravity r1);

    void setTitleSize(int r1);

    void setTitleTextColor(int r1);

    void setTitleVisibility(boolean r1);

    void setTransparent(boolean r1);

    void show(boolean r1);
}
