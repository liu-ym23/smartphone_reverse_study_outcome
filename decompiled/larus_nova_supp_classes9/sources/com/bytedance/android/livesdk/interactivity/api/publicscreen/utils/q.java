package com.bytedance.android.livesdk.interactivity.api.publicscreen.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.livesdk.config.w71;
import com.bytedance.android.livesdk.interactivity.api.settings.config.j0;
import com.bytedance.android.livesdk.interactivity.api.settings.config.p0;
import com.bytedance.android.livesdk.interactivity.api.settings.config.r0;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdkapi.depend.model.live.IPublicScreenSpeedConfig;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class q {
    public static final /* synthetic */ int a = 0;

    public static int b() {
        if (FoldScreenUtils.e() == false) goto L9;
        if (e5.n() == false) goto L14;
        return s1.w();
    L14:
        return s1.y();
    L9:
        if (PadConfigUtils.c() == false) goto L12;
        return Math.min(s1.y(), s1.w());
    L12:
        return s1.y();
    }

    @JvmStatic
    public static final float i() {
        com.bytedance.android.livesdk.interactivity.api.publicscreen.l r0 = com.bytedance.android.livesdk.interactivity.api.q.i();
        if (r0 == null) goto L7;
        e52.a r1 = r0.getTextConfig();
        if (r1 == null) goto L7;
        return r1.b();
    L7:
        Context r2 = s1.getContext();
        float r3 = 1.0f;
        if (r2 == null) goto L20;
        Resources r4 = r2.getResources();
        if (r4 == null) goto L20;
        Configuration r5 = r4.getConfiguration();
        if (r5 == null) goto L20;
        float r6 = r5.fontScale;
        if (r6 > 1.0f) goto L16;
        return 1.0f;
    L16:
        r3 = 1.3f;
        if (r6 >= 1.3f) goto L20;
        return 1.15f;
    L20:
        return r3;
    }

    static {
    }

    public static float f(boolean r3) {
        if (FoldScreenUtils.f() == true) goto L5;
    L7:
        if (r3 == true) goto L9;
        return 1.0f;
    L9:
        if (PublicScreenABHelper.h().fontSizeFitResolution == true) goto L11;
        return 1.0f;
    L11:
        if (PadConfigUtils.c() == false) goto L14;
        float r4 = PublicScreenABHelper.h().padBaseResolutionWidthDp / 1.3f;
    L17:
        r0 r0 = PublicScreenABHelper.h();
        float r1 = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(s1.G(b()) / r4, r0.minResolutionFitScale), r0.maxResolutionFitScale);
        ALogger.i("PS_RESOLUTION_FIT", "screen px width:" + b() + ", dp width：" + s1.G(b()) + ", base width:" + r4 + ", scale rate：" + r1);
        return r1;
    L14:
        if (FoldScreenUtils.e() == false) goto L16;
        r4 = PublicScreenABHelper.h().phoneBaseResolutionWidthDp * 2;
        goto L17
    L16:
        r4 = PublicScreenABHelper.h().phoneBaseResolutionWidthDp;
        goto L17
    L5:
        if (PublicScreenABHelper.h().foldScreenFitResolution == true) goto L7;
        return 1.0f;
    }

    public static IPublicScreenSpeedConfig g(IRoom r5) {
        if (r5 == null) goto L16;
        IPublicScreenSpeedConfig r6 = r5.getPublicScreenSpeedConfig();
        if (r6 != null) goto L7;
        return null;
    L7:
        if (r6.getInterval() >= 0) goto L9;
        return null;
    L9:
        if (r6.getUpdateScrollSize() >= 0) goto L11;
        return null;
    L11:
        if (r6.getUpdateFoldSize() >= 0) goto L13;
        return null;
    L13:
        if (r6.getScrollSpeed() < 0) goto L22;
        return r6;
    L22:
        return null;
    L16:
        return null;
    }

    public static float c(boolean r4, boolean r5) {
        float r0 = 1.0f;
        if (r4 == false) goto L12;
        int r1 = PublicScreenStyleHelper.a();
        if (r1 != 1) goto L7;
        r0 = 1.1428572f;
    L17:
        return r0 * d(r5, r4);
    L7:
        if (r1 != 2) goto L17;
        r0 = 1.2857143f;
        goto L17
    L12:
        if (f.a().enable == false) goto L17;
        if (((Boolean) new com.bytedance.android.livesdk.sharedpref.e("audience_public_screen_setting_saved", Boolean.FALSE).getValue()).booleanValue() == false) goto L17;
        b52.a r2 = b52.a.a;
        r0 = ((Number) r2.b(r2.a().b())).floatValue() / i();
        goto L17
    }

    public static float d(boolean r1, boolean r2) {
        if (r2 == false) goto L4;
        float r3 = 1.0f;
    L6:
        return f(r1) * r3;
    L4:
        r3 = PublicScreenABHelper.h().fontSize / 14.0f;
        goto L6
    }

    @JvmStatic
    public static final int e(boolean r4, boolean r5) {
        if (PublicScreenABHelper.h().itemGapFitResolution == false) goto L12;
        if (r4 == true) goto L12;
        int r6 = y42.a.c.b().a();
        if (r6 == 1) goto L10;
        if (r6 == 2) goto L9;
        int r7 = PublicScreenStyleHelper.c;
    L29:
        if (PublicScreenABHelper.h().itemGapFitResolution == true) goto L31;
        return r7;
    L31:
        return (int) (r7 * f(r5));
    L9:
        r7 = PublicScreenStyleHelper.e;
        goto L29
    L10:
        r7 = PublicScreenStyleHelper.d;
    L12:
        if (PublicScreenStyleHelper.n == false) goto L27;
        int r8 = PublicScreenStyleHelper.q;
        if (r8 < 0) goto L18;
        if (2 < r8) goto L18;
        boolean r3 = true;
    L19:
        if (r3 == true) goto L22;
        r8 = 0;
    L22:
        if (r8 == 1) goto L26;
        if (r8 == 2) goto L25;
        r7 = PublicScreenStyleHelper.c;
        goto L29
    L25:
        r7 = PublicScreenStyleHelper.e;
        goto L29
    L26:
        r7 = PublicScreenStyleHelper.d;
    L18:
        r3 = false;
        goto L19
    L27:
        r7 = PublicScreenStyleHelper.b;
        goto L29
    }

    @JvmStatic
    public static final g52.e a(e52.a r11, boolean r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r11, "textConfig");
        Intrinsics.checkNotNullParameter(r11, "textConfig");
        if (r13 == false) goto L5;
    L7:
        n42.a r15 = r11.h();
    L8:
        float r1 = r15.a;
        int r2 = r15.c;
        Typeface r3 = r15.b;
        int r4 = s1.f(r15.d.left);
        int r5 = s1.f(r15.d.top);
        int r6 = s1.f(r15.d.right);
        int r7 = s1.f(r15.d.bottom);
        if (PublicScreenStyleHelper.n == false) goto L11;
        float r16 = PublicScreenStyleHelper.g;
    L12:
        float r8 = r16;
        tx1.b.a.getClass();
        float r17 = tx1.b.a();
        if (r14 == false) goto L18;
        if (w71.a() == false) goto L18;
        r17 = c(r14, r13);
    L18:
        return new g52.e(r1, r2, r3, r4, r5, r6, r7, r8, r17);
    L11:
        r16 = PublicScreenStyleHelper.f;
        goto L12
    L5:
        if (r11.f() == false) goto L7;
        r15 = r11.d();
        goto L8
    }

    public static com.bytedance.android.livesdk.interactivity.api.publicscreen.model.e h(j0 r6, int r7, IPublicScreenSpeedConfig r8) {
        Intrinsics.checkNotNullParameter(r6, "config");
        if (r8 == null) goto L6;
        ALogger.i("PSSpeedConfig", "use server config. " + r8);
        int r9 = com.bytedance.android.livesdk.interactivity.api.publicscreen.model.e.e;
        Intrinsics.checkNotNullParameter(r8, "serverConfig");
        return new com.bytedance.android.livesdk.interactivity.api.publicscreen.model.e(r8.getInterval(), r8.getUpdateScrollSize(), r8.getUpdateFoldSize(), r8.getScrollSpeed());
    L6:
        List<p0> r10 = r6.b();
        Object r3 = null;
        if (r10 == null) goto L22;
        Iterator<T> r11 = r10.iterator();
    L10:
        if (r11.hasNext() == false) goto L17;
        Object r4 = r11.next();
        if (((p0) r4).a() != r7) goto L14;
        boolean r5 = true;
    L15:
        if (r5 == false) goto L10;
    L18:
        p0 r13 = (p0) r4;
        if (r13 == null) goto L22;
        ALogger.i("PSSpeedConfig", "use dynamic strategy. " + r13);
        int r14 = com.bytedance.android.livesdk.interactivity.api.publicscreen.model.e.e;
        return com.bytedance.android.livesdk.interactivity.api.publicscreen.model.e.a.a(r13);
    L14:
        r5 = false;
        goto L15
    L17:
        r4 = null;
    L22:
        List<p0> r15 = r6.b();
        if (r15 == null) goto L37;
        Iterator<T> r16 = r15.iterator();
    L26:
        if (r16.hasNext() == false) goto L33;
        Object r17 = r16.next();
        if (((p0) r17).a() != r6.a()) goto L30;
        boolean r18 = true;
    L31:
        if (r18 == false) goto L26;
        r3 = r17;
        goto L33
    L30:
        r18 = false;
    L33:
        p0 r19 = (p0) r3;
        if (r19 == null) goto L37;
        ALogger.i("PSSpeedConfig", "use default level. " + r19);
        int r20 = com.bytedance.android.livesdk.interactivity.api.publicscreen.model.e.e;
        return com.bytedance.android.livesdk.interactivity.api.publicscreen.model.e.a.a(r19);
    L37:
        p0 r21 = new p0(0);
        ALogger.i("PSSpeedConfig", "use fallback config. " + r21);
        int r23 = com.bytedance.android.livesdk.interactivity.api.publicscreen.model.e.e;
        return com.bytedance.android.livesdk.interactivity.api.publicscreen.model.e.a.a(r21);
    }
}
