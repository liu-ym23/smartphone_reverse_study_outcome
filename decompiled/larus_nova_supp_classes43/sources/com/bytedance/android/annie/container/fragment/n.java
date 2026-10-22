package com.bytedance.android.annie.container.fragment;

import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ai.bridge.service.IHostContextDepend;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class n {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final String e(String r10) {
        if (r10 == null) goto L5;
        String r11 = StringsKt.replace$default(r10, "\"", "", false, 4, null);
        if (r11 == null) goto L5;
        return r11;
    L5:
        return "";
    }

    public static String b(String r1, boolean r10) {
        if (r1 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L13;
        if (r10 == false) goto L11;
        return IHostContextDepend.SKIN_TYPE_BLACK;
    L11:
        return IHostContextDepend.SKIN_TYPE_WHITE;
    L13:
        return r1;
    L4:
        if (StringsKt.isBlank(r1) == true) goto L7;
        r0 = false;
        goto L8
    }

    @Deprecated(message = "")
    public static boolean d(String r10, Boolean r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        Iterator<String> r0 = AnnieConfigSettingKeys.LIVE_THEME_LIGHT_ALLOW_LIST.a().iterator();
    L4:
        if (r0.hasNext() == false) goto L19;
        String r1 = r0.next();
        if (StringsKt.startsWith$default(r1, "http", false, 2, null) == true) goto L8;
        r1 = "http://" + r1;
    L8:
        Uri r12 = UriProtector.parse(r1);
        if (r12 == null) goto L4;
        if (TextUtils.isEmpty(r12.getPath()) == true) goto L15;
        String r13 = r12.getPath();
        Intrinsics.checkNotNull(r13);
        if (StringsKt.contains$default(r10, r13, false, 2, null) == false) goto L4;
    L15:
        if (TextUtils.isEmpty(r12.getHost()) == true) goto L18;
        String r14 = r12.getHost();
        Intrinsics.checkNotNull(r14);
        if (StringsKt.contains$default(r10, r14, false, 2, null) == false) goto L4;
    L18:
        boolean r15 = true;
    L20:
        if (r15 == true) goto L38;
        if (r11 == null) goto L23;
        boolean r16 = r11.booleanValue();
    L24:
        if (r16 == true) goto L39;
        return false;
    L39:
        return true;
    L23:
        r16 = false;
        goto L24
    L38:
        return true;
    L19:
        r15 = false;
        goto L20
    }

    @JvmStatic
    public static final void f(FragmentActivity r1, String r10) {
        if (r1 != null) goto L5;
        return;
    L5:
        if (StringUtils.isEmpty(r10) == true) goto L17;
        com.bytedance.android.annie.util.i.d(r1.getWindow());
        com.bytedance.android.annie.util.i.c(r1);
        int r11 = Color.parseColor(r10);     // Catch: Exception -> L14
        Window r12 = r1.getWindow();     // Catch: Exception -> L14
        if (r12 != null) goto L10;
        return;
    L10:
        if (r12.getStatusBarColor() == r11) goto L19;
        r12.setStatusBarColor(r11);     // Catch: Exception -> L14
        return;
    L19:
        return;
    L20:
        return;
    }

    @JvmStatic
    public static final void g(FragmentActivity r10, String r11) {
        if (r10 == null) goto L11;
        Window r0 = r10.getWindow();
        r0.clearFlags(67108864);
        View r1 = r0.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L9;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r12 = ThreadMethodProxy.currentThread();
        if (r12 == com.larus.home.impl.utils.c.a) goto L9;
        com.larus.home.impl.utils.c.a(r12, "getDecorView");
    L9:
        r1.setSystemUiVisibility(1280);
        r0.addFlags(Integer.MIN_VALUE);
        r0.setStatusBarColor(0);
    L11:
        if (Intrinsics.areEqual(IHostContextDepend.SKIN_TYPE_WHITE, r11) == false) goto L14;
        com.bytedance.android.annie.util.i.h(r10);
        return;
    L14:
        if (Intrinsics.areEqual(IHostContextDepend.SKIN_TYPE_BLACK, r11) == false) goto L18;
        com.bytedance.android.annie.util.i.i(r10.getWindow(), Boolean.TRUE);
        return;
    }

    @JvmStatic
    public static final int a(String r10, int r11, int r12) {
        if (r11 != (-1)) goto L21;
        r11 = r12;
    L21:
        if (TextUtils.isEmpty(r10) == true) goto L19;
        if (r10 != null) goto L10;
    L16:
        return Color.parseColor(r10);
    L10:
        if (StringsKt.startsWith$default(r10, "#", false, 2, null) == true) goto L16;
        if (Intrinsics.areEqual(IHostContextDepend.SKIN_TYPE_WHITE, r10) == true) goto L16;
        if (Intrinsics.areEqual(IHostContextDepend.SKIN_TYPE_BLACK, r10) == true) goto L16;
        r10 = "#".concat(r10);     // Catch: Exception -> L20
        goto L16
    L19:
        return r11;
    L24:
        return r12;
    }

    public static ShapeDrawable c(Integer r11, int r12, int[] r13) {
        Intrinsics.checkNotNullParameter(r13, "gradientBgColorList");
        if (r12 <= 0) goto L6;
        float r14 = r12 / 100.0f;
    L10:
        if (r13.length != 2) goto L12;
        float[] r10 = {0.0f, r14};
    L14:
        if (r11 == null) goto L16;
        float r15 = r11.intValue();
    L17:
        LinearGradient r16 = new LinearGradient(0.0f, 0.0f, 0.0f, r15, r13, r10, Shader.TileMode.CLAMP);
        Paint r17 = new Paint();
        r17.setShader(r16);
        ShapeDrawable r18 = new ShapeDrawable();
        r18.getPaint().set(r17);
        return r18;
    L16:
        r15 = 0.0f;
        goto L17
    L12:
        r10 = new float[]{0.0f, r14, 1.0f};
        goto L14
    L6:
        if (r13.length != 2) goto L8;
        r14 = 0.5f;
        goto L10
    L8:
        r14 = 0.34f;
        goto L10
    }
}
