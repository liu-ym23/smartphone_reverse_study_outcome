package com.ss.android.lark.chat.utils;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.chat.entity.wallpaper.ChatThemeInfo;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class p {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final View a(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        if (FeatureGatingModule.getFeatureGatingService().isEnable("im.message.message_background_and_padding") == true) goto L10;
        FrameLayout r0 = (FrameLayout) r2.findViewById(2131380371);
        if (r0 != null) goto L8;
        return r2;
    L8:
        return r0;
    L10:
        return r2;
    }

    @JvmStatic
    public static final int b(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return UIUtils.getColor(r1, 2131106521);
    }

    @JvmStatic
    public static final int c(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return UIUtils.getColor(r1, 2131106607);
    }

    @JvmStatic
    public static final int d(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return UIUtils.getColor(r1, 2131106616);
    }

    @JvmStatic
    public static final int e(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return UIUtils.getColor(r1, 2131106620);
    }

    @JvmStatic
    public static final boolean f(ChatThemeInfo.Scene r1) {
        if (r1 != null) goto L4;
        return false;
    L4:
        if (r1 != ChatThemeInfo.Scene.DARK) goto L10;
        return true;
    L10:
        return false;
    }

    @JvmStatic
    public static final boolean g(ChatThemeInfo.Scene r1) {
        if (r1 != null) goto L4;
        return false;
    L4:
        if (r1 == ChatThemeInfo.Scene.DEFAULT_SCENE) goto L10;
        return true;
    L10:
        return false;
    }
}
