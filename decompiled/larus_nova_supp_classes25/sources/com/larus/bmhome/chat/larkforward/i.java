package com.larus.bmhome.chat.larkforward;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.Observer;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BotIconImage;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.conversation.IconImage;
import com.larus.im.bean.message.ImageObj;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.platform.service.AccountService;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Function;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class i {
    public static final Handler a = null;
    public static final WeakHashMap<LayerDrawable, Drawable> b = null;
    public static String c;
    public static int d;
    public static volatile String e;
    public static volatile String f;
    public static volatile Drawable g;
    public static volatile String h;
    public static volatile String i;
    public static volatile String j;
    public static k k;

    public static final class a implements com.larus.platform.api.b {
        public a() {
        }

        public final void a(com.larus.platform.api.c r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
            Handler r3 = i.a;
            i.f(new h());
        }

        public final void b(com.larus.platform.api.c r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
            Handler r3 = i.a;
            i.f(new g());
        }
    }

    public static final class b implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public b(com.larus.bmhome.chat.larkforward.b r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        public final boolean equals(Object r3) {
            if ((r3 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r3 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
        }

        public final Function<?> getFunctionDelegate() {
            return this.a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object r2) {
            this.a.invoke(r2);
        }
    }

    public i() {
    }

    static {
        a = new Handler(Looper.getMainLooper());
        b = new WeakHashMap();
        c = "";
        k = new k(d);
        f(new com.larus.bmhome.chat.larkforward.a());
    }

    public static String b() {
        AccountService r0 = AccountService.a;
        if (r0.isLogin().booleanValue() == true) goto L7;
        return "";
    L7:
        return r0.getUserId() + ':' + r0.getSecUserId();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void g() {
        String r0 = j;
        String r1 = null;
        boolean r2 = true;
        if (r0 != null) goto L5;
    L11:
        LaunchInfo r3 = j();
        if (r3 == null) goto L50;
        String r4 = r3.Y();
        if (r4 == null) goto L50;
        if ((!StringsKt.isBlank(r4)) == true) goto L19;
        r4 = null;
    L19:
        if (r4 == null) goto L50;
        AuthModelDelegate r5 = AuthModelDelegate.b;
        Iterator r6 = CollectionsKt.listOf(new wc9.e[]{r5.y().getValue(), r5.u().getValue()}).iterator();
    L22:
        if (r6.hasNext() == false) goto L50;
        wc9.e r7 = (wc9.e) r6.next();
        if (r7 != null) goto L26;
    L47:
        String r8 = null;
    L48:
        if (r8 == null) goto L22;
    L51:
        if (r8 == null) goto L53;
        e(r8);
    L53:
        LaunchInfo r9 = j();
        if (r9 == null) goto L56;
        r1 = r9.W();
    L56:
        String r10 = r1;
        if (r10 != null) goto L59;
    L62:
        if (r2 == false) goto L64;
        return;
    L64:
        if (Intrinsics.areEqual(h, r10) == true) goto L75;
        h = r10;
        com.larus.im.service.o.a.a(com.larus.im.d.a(), r10, false, null, new n(d), 12);
        return;
    L75:
        return;
    L59:
        if (StringsKt.isBlank(r10) == true) goto L62;
        r2 = false;
        goto L62
    L26:
        if (Intrinsics.areEqual(r7.a, r4) == false) goto L47;
        IconImage r11 = r7.b;
        if (r11 == null) goto L39;
        ImageObj r12 = r11.imageThumb;
        if (r12 == null) goto L39;
        r8 = r12.url;
        if (r8 == null) goto L39;
        if ((!StringsKt.isBlank(r8)) == true) goto L38;
        r8 = null;
    L38:
        if (r8 != null) goto L48;
    L39:
        if (r11 == null) goto L47;
        ImageObj r13 = r11.imageOri;
        if (r13 == null) goto L47;
        r8 = r13.url;
        if (r8 == null) goto L47;
        if ((!StringsKt.isBlank(r8)) == false) goto L47;
    L50:
        r8 = null;
        goto L51
    L5:
        if ((!StringsKt.isBlank(r0)) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L11;
        e(r0);
    }

    public static void i() {
        boolean r1 = true;
        d++;
        c = b();
        String r0 = i;
        if (r0 == null) goto L5;
        com.larus.im.d.a().unregisterBotChangeListener(r0, k);
    L5:
        i = null;
        h = null;
        j = null;
        e = null;
        f = null;
        g = null;
        k(null);
        if ((!b.isEmpty()) == true) goto L8;
        return;
    L8:
        if (c.length() > 0) goto L11;
        r1 = false;
    L11:
        if (r1 == false) goto L15;
        h();
        g();
        return;
    }

    public static LaunchInfo j() {
        AccountService r0 = AccountService.a;
        if (r0.isLogin().booleanValue() == true) goto L5;
        return null;
    L5:
        String r1 = r0.getSecUserId();
        if ((!StringsKt.isBlank(r1)) == true) goto L9;
        r1 = null;
    L9:
        if (r1 != null) goto L11;
        return null;
    L11:
        AuthModelDelegate r2 = AuthModelDelegate.b;
        com.larus.bmhome.chat.api.e0 r3 = (com.larus.bmhome.chat.api.e0) r2.e().getValue();
        if (r3 == null) goto L21;
        LaunchInfo r4 = r3.a;
        if (r4 == null) goto L21;
        if (Intrinsics.areEqual(r4.A1(), r1) == true) goto L19;
        r4 = null;
    L19:
        if (r4 == null) goto L21;
        return r4;
    L21:
        LaunchInfo r5 = (LaunchInfo) r2.x().getValue();
        if (r5 != null) goto L24;
        return null;
    L24:
        if (Intrinsics.areEqual(r5.A1(), r1) == true) goto L26;
        return null;
    L26:
        return r5;
    }

    public static void h() {
        LaunchInfo r0 = j();
        if (r0 == null) goto L5;
        String r1 = r0.W();
    L6:
        if (r1 != null) goto L8;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == false) goto L14;
        return;
    L14:
        if (Intrinsics.areEqual(i, r1) == true) goto L22;
        String r3 = i;
        if (r3 == null) goto L19;
        com.larus.im.d.a().unregisterBotChangeListener(r3, k);
    L19:
        i = r1;
        k = new k(d);
        com.larus.im.d.a().registerBotChangeListener(r1, k);
        return;
    L22:
        return;
    L8:
        if (StringsKt.isBlank(r1) == true) goto L11;
        r2 = false;
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    public static final String a(BotModel r6) {
        String[] r0 = new String[4];
        BotIconImage r1 = r6.getIconImage();
        Object r2 = null;
        if (r1 == null) goto L5;
        String r3 = r1.getOriginUrl();
    L6:
        r0[0] = r3;
        BotIconImage r4 = r6.getIconImage();
        if (r4 == null) goto L9;
        String r5 = r4.getThumbnailUrl();
    L10:
        r0[1] = r5;
        BotIconImage r7 = r6.getIconImage();
        if (r7 == null) goto L13;
        String r8 = r7.getImg720();
    L14:
        r0[2] = r8;
        BotIconImage r9 = r6.getIconImage();
        if (r9 == null) goto L17;
        String r10 = r9.getTinyUrl();
    L18:
        r0[3] = r10;
        Iterator r11 = CollectionsKt.listOf(r0).iterator();
    L20:
        if (r11.hasNext() == false) goto L32;
        Object r12 = r11.next();
        String r13 = (String) r12;
        if (r13 != null) goto L24;
    L27:
        boolean r14 = true;
    L29:
        if ((!r14) == false) goto L20;
        r2 = r12;
        goto L32
    L24:
        if (StringsKt.isBlank(r13) == true) goto L27;
        r14 = false;
    L32:
        return (String) r2;
    L17:
        r10 = null;
        goto L18
    L13:
        r8 = null;
        goto L14
    L9:
        r5 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    public static Drawable c(Drawable r2) {
        Drawable.ConstantState r0 = r2.getConstantState();
        if (r0 == null) goto L11;
        Drawable r1 = r0.newDrawable(AppHost.a.getApplication().getResources());
        if (r1 == null) goto L12;
        Drawable r3 = r1.mutate();
        if (r3 != null) goto L10;
        return r2;
    L10:
        return r3;
    L12:
        return r2;
    L11:
        return r2;
    }

    public static boolean d(int r3) {
        if (Intrinsics.areEqual(c, b()) == true) goto L6;
        i();
    L6:
        if (c.length() <= 0) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == true) goto L11;
        return false;
    L11:
        if (r3 != d) goto L15;
        return true;
    L15:
        return false;
    L8:
        r0 = false;
        goto L9
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [com.larus.bmhome.chat.larkforward.f] */
    public static void e(final String r8) {
        if (Intrinsics.areEqual(e, r8) == false) goto L8;
        if (g == null) goto L8;
        return;
    L8:
        if (Intrinsics.areEqual(f, r8) == false) goto L10;
        return;
    L10:
        f = r8;
        final int r0 = d;
        Resources r2 = AppHost.a.getApplication().getResources();
        final int r1 = RangesKt.coerceAtLeast(MathKt.roundToInt(56 * WindowDisplayMetricsOverride.apply(r2, r2.getDisplayMetrics()).density), 1);
        ImageLoaderKt.o(r8, "share_general_bot_avatar", null, new e(r0, r8), new f(r1), 52);
    }

    public static void f(final Function0 r2) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        r2.invoke();
        return;
    L5:
        a.post(new d(r2));
    }

    public static void k(Drawable r4) {
        Iterator<Map.Entry<LayerDrawable, Drawable>> r0 = b.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        Map.Entry<LayerDrawable, Drawable> r1 = r0.next();
        LayerDrawable r2 = r1.getKey();
        Drawable r3 = r1.getValue();
        if (r4 == null) goto L8;
        r3 = c(r4);
    L8:
        r2.setDrawable(0, r3);
        r2.invalidateSelf();
        goto L4
    }
}
