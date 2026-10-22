package i88;

import android.app.Application;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.av_call.constant.ThemeType;
import com.larus.av_call.model.RealtimePageMode;
import com.larus.av_call.service.IRealtimeCallConfigDependency;
import com.larus.av_call.util.RealtimeBottomMoreBtn;
import com.larus.common.apphost.AppHost;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.j0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import v19.h;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class e {
    public static final Application a = null;
    public static final IRealtimeCallConfigDependency b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;

    static {
        a = AppHost.a.getApplication();
        b = (IRealtimeCallConfigDependency) ServiceManager.get().getService(IRealtimeCallConfigDependency.class);
        c = LazyKt.lazy(new a());
        d = LazyKt.lazy(new b());
    }

    public static GradientDrawable n(int r2) {
        GradientDrawable r0 = new GradientDrawable();
        r0.setShape(1);
        r0.setColor(r2);
        r0.setSize(i5.q0(), i5.q0());
        return r0;
    }

    public static boolean o(ThemeType r1) {
        Intrinsics.checkNotNullParameter(r1, "themeType");
        if (r1 != ThemeType.DEFAULT) goto L5;
    L10:
        return true;
    L5:
        if (r1 == ThemeType.IMMERS_BOT) goto L10;
        boolean r2 = h.a;
        if (h.a(null) == true) goto L10;
        return false;
    }

    public static void c(RealtimeBottomMoreBtn r2, h88.b r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r3 == null) goto L7;
        boolean r0 = true;
        if (r3.r != true) goto L7;
    L8:
        if (r0 == false) goto L10;
        Pair r4 = TuplesKt.to(Integer.valueOf(ColorProtector.parseColor("#80333333")), 2131239990);
    L11:
        r2.setBackground(n(((Number) r4.getFirst()).intValue()));
        r2.setImageResource(((Number) r4.getSecond()).intValue());
        return;
    L10:
        r4 = TuplesKt.to(Integer.valueOf(a(r2.getContext(), 2130972086, 2131103159)), 2131239989);
    L7:
        r0 = false;
        goto L8
    }

    public static int a(Context r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        int r4 = v19.c.b(r2, r1, r3);
        return ContextCompat.getColor(a, r4);
    }

    public static int b(ThemeType r1, boolean r2, h88.a r3) {
        Intrinsics.checkNotNullParameter(r1, "themeType");
        if (r3 == null) goto L7;
        boolean r0 = true;
        if (r3.k0 != true) goto L7;
    L9:
        if (r0 == true) goto L11;
    L16:
        if (r2 == false) goto L18;
    L21:
        int r4 = j0.a;
        return j0.a(2131103298);
    L18:
        if (o(r1) == true) goto L21;
        return ColorProtector.parseColor("#80000000");
    L11:
        if (AppHost.a.isOversea() == false) goto L16;
        boolean r5 = h.a;
        if (h.a(null) == true) goto L16;
        return ColorProtector.parseColor("#80000000");
    L7:
        r0 = false;
        goto L9
    }

    public static void f(View r1, boolean r2, ThemeType r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r3, "themeType");
        if (r2 == false) goto L9;
        if (o(r3) == false) goto L7;
        int r4 = 2131241723;
    L12:
        r1.setBackgroundResource(r4);
        return;
    L7:
        r4 = 2131241722;
        goto L12
    L9:
        if (o(r3) == false) goto L11;
        r4 = 2131241725;
        goto L12
    L11:
        r4 = 2131241724;
        goto L12
    }

    public static void h(SimpleDraweeView r4, ThemeType r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "themeType");
        IRealtimeCallConfigDependency r0 = b;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r3 == false) goto L10;
        return;
    L10:
        if (r6 == false) goto L12;
    L15:
        int r7 = 2131241910;
    L16:
        if (r0 != null) goto L18;
    L20:
        StringBuilder r8 = new StringBuilder("res:///");
        if (r1 == false) goto L23;
        r7 = 2131241911;
    L23:
        r8.append(r7);
        ImageLoaderKt.u(r4, r8.toString(), null);
        return;
    L18:
        if (r0.o() != true) goto L20;
        r1 = true;
        goto L20
    L12:
        if (o(r5) == true) goto L15;
        r7 = 2131241909;
        goto L16
    L5:
        if (r0.r() != true) goto L7;
        r3 = true;
        goto L8
    }

    public static void d(ImageView r1, ThemeType r2, boolean r3, h88.a r4) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "themeType");
        if (r4 == null) goto L7;
        boolean r0 = true;
        if (r4.k0 != true) goto L7;
    L8:
        if (r0 == true) goto L10;
    L12:
        if (r3 == false) goto L14;
    L17:
        int r5 = 2131241884;
    L18:
        r1.setImageResource(r5);
        return;
    L14:
        if (o(r2) == true) goto L17;
        r5 = 2131241882;
        goto L18
    L10:
        if (AppHost.a.isOversea() == false) goto L12;
        r5 = 2131241883;
    L7:
        r0 = false;
        goto L8
    }

    public static void g(ImageView r2, ThemeType r3, boolean r4, h88.a r5) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "themeType");
        if (r5 == null) goto L7;
        boolean r0 = true;
        if (r5.k0 != true) goto L7;
    L9:
        if (r0 == true) goto L11;
    L16:
        if (r4 == false) goto L18;
    L21:
        r2.setImageResource(2131241895);
        return;
    L18:
        if (o(r3) == true) goto L21;
        int r6 = j0.a;
        r2.setImageDrawable(j0.f(2131241895, ColorProtector.parseColor("#80000000")));
        return;
    L11:
        if (AppHost.a.isOversea() == false) goto L16;
        boolean r1 = h.a;
        if (h.a(null) == true) goto L16;
        int r7 = j0.a;
        r2.setImageDrawable(j0.f(2131241895, ColorProtector.parseColor("#80000000")));
        return;
    L7:
        r0 = false;
        goto L9
    }

    public static void i(View r1, ThemeType r2, boolean r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "themeType");
        if (r4 == true) goto L10;
        if (r3 == true) goto L10;
        if (o(r2) == true) goto L10;
        int r5 = 2131242290;
    L11:
        r1.setBackgroundResource(r5);
        return;
    L10:
        r5 = 2131242334;
        goto L11
    }

    public static void e(View r4, ThemeType r5, boolean r6, h88.b r7, h88.a r8) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "themeType");
        boolean r0 = false;
        if (r7 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r8 != null) goto L10;
    L12:
        boolean r9 = false;
    L13:
        if (r7 == null) goto L15;
        RealtimePageMode r10 = r7.u;
    L17:
        if (r10 != RealtimePageMode.FULL_SCREEN) goto L19;
        boolean r11 = true;
    L20:
        if (r9 == false) goto L24;
        if (r2 == true) goto L38;
        if (r11 == false) goto L24;
    L38:
        int r12 = 2131241891;
    L41:
        r4.setBackgroundResource(r12);
        return;
    L24:
        if (r9 == false) goto L26;
        r12 = 2131241803;
        goto L41
    L26:
        if (r2 == false) goto L28;
        r12 = 2131242332;
        goto L41
    L28:
        if (r6 == false) goto L30;
    L40:
        r12 = 2131242288;
        goto L41
    L30:
        if (o(r5) == true) goto L40;
        IRealtimeCallConfigDependency r13 = b;
        if (r13 != null) goto L35;
    L37:
        if (r0 == true) goto L38;
        r12 = 2131241892;
        goto L41
    L35:
        if (r13.enableAudioBgSimpleColor() != true) goto L37;
        r0 = true;
        goto L37
    L19:
        r11 = false;
        goto L20
    L15:
        r10 = null;
        goto L17
    L10:
        if (r8.k0 != true) goto L12;
        r9 = true;
        goto L13
    L5:
        if (r7.r != true) goto L7;
        r2 = true;
        goto L8
    }

    public static void k(View r2, ThemeType r3, boolean r4, h88.b r5, h88.a r6) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "themeType");
        boolean r0 = false;
        if (r5 != null) goto L5;
    L7:
        boolean r7 = false;
    L8:
        if (r6 != null) goto L10;
    L12:
        boolean r8 = false;
    L13:
        if (r8 == false) goto L16;
        if (r7 == false) goto L16;
    L19:
        int r9 = 2131241903;
    L32:
        r2.setBackgroundResource(r9);
        return;
    L16:
        if (r8 == true) goto L31;
        if (r7 == true) goto L19;
        if (r4 == true) goto L31;
        if (o(r3) == true) goto L31;
        IRealtimeCallConfigDependency r10 = b;
        if (r10 != null) goto L27;
    L29:
        if (r0 == false) goto L31;
        r9 = 2131241904;
        goto L32
    L27:
        if (r10.enableAudioBgSimpleColor() != true) goto L29;
        r0 = true;
    L31:
        r9 = 2131241802;
        goto L32
    L10:
        if (r6.k0 != true) goto L12;
        r8 = true;
        goto L13
    L5:
        if (r5.r != true) goto L7;
        r7 = true;
        goto L8
    }

    public static void l(View r1, ThemeType r2, boolean r3, boolean r4, h88.a r5) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "themeType");
        if (r5 == null) goto L7;
        boolean r0 = true;
        if (r5.k0 != true) goto L7;
    L8:
        if (r4 == false) goto L10;
        int r6 = 2131242336;
    L15:
        r1.setBackgroundResource(r6);
        return;
    L10:
        if (r0 == false) goto L12;
        r6 = 2131241799;
        goto L15
    L12:
        if (r3 == true) goto L14;
        o(r2);
    L14:
        r6 = 2131242335;
    L7:
        r0 = false;
        goto L8
    }

    public static void m(View r1, ThemeType r2, boolean r3, boolean r4, h88.a r5) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "themeType");
        if (r5 == null) goto L7;
        boolean r0 = true;
        if (r5.k0 != true) goto L7;
    L8:
        if (r0 == false) goto L10;
        int r6 = 2131241811;
    L18:
        r1.setBackgroundResource(r6);
        return;
    L10:
        if (r4 == false) goto L12;
        r6 = 2131242337;
        goto L18
    L12:
        if (r3 == false) goto L14;
    L17:
        r6 = 2131242293;
        goto L18
    L14:
        if (o(r2) == true) goto L17;
        r6 = 2131242294;
    L7:
        r0 = false;
        goto L8
    }

    public static void j(AppCompatImageView r2, ThemeType r3, boolean r4, boolean r5, boolean r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "themeType");
        IRealtimeCallConfigDependency r0 = b;
        if (r0 == null) goto L7;
        boolean r1 = true;
        if (r0.m() != true) goto L7;
    L8:
        if (r1 == false) goto L42;
        if (r4 == false) goto L26;
        if (r6 == false) goto L17;
        if (r5 == false) goto L13;
    L16:
        int r8 = 2131240984;
    L71:
        r2.setImageResource(r8);
        return;
    L13:
        if (o(r3) == true) goto L16;
        r8 = 2131240985;
        goto L71
    L17:
        if (r5 == true) goto L23;
        if (o(r3) == true) goto L23;
        r8 = 2131240981;
    L23:
        if (r3 != ThemeType.MAIN_BOT) goto L25;
        r8 = 2131240978;
        goto L71
    L25:
        r8 = 2131240979;
        goto L71
    L26:
        if (r6 == false) goto L33;
        if (r5 == false) goto L29;
    L32:
        r8 = 2131240983;
        goto L71
    L29:
        if (o(r3) == true) goto L32;
        r8 = 2131240982;
        goto L71
    L33:
        if (r5 == true) goto L39;
        if (o(r3) == true) goto L39;
        r8 = 2131240976;
    L39:
        if (r3 != ThemeType.MAIN_BOT) goto L41;
        r8 = 2131240977;
        goto L71
    L41:
        r8 = 2131240980;
        goto L71
    L42:
        if (r4 == false) goto L56;
        if (r6 == false) goto L50;
        if (r5 == false) goto L46;
    L49:
        r8 = 2131243423;
        goto L71
    L46:
        if (o(r3) == true) goto L49;
        r8 = 2131243424;
        goto L71
    L50:
        if (r5 == false) goto L52;
    L55:
        r8 = 2131243433;
        goto L71
    L52:
        if (o(r3) == true) goto L55;
        r8 = 2131243436;
        goto L71
    L56:
        if (r6 == false) goto L63;
        if (r5 == false) goto L59;
    L62:
        r8 = 2131243421;
        goto L71
    L59:
        if (o(r3) == true) goto L62;
        r8 = 2131243422;
        goto L71
    L63:
        if (r7 == false) goto L65;
        r8 = 2131243427;
        goto L71
    L65:
        if (r5 == false) goto L67;
    L70:
        r8 = 2131243428;
        goto L71
    L67:
        if (o(r3) == true) goto L70;
        r8 = 2131243431;
    L7:
        r1 = false;
        goto L8
    }
}
