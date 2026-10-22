package gi8;

import android.content.Context;
import android.graphics.Color;
import com.larus.bmhome.chat.banner.ActiveSwitchBannerIconType;
import com.larus.bmhome.chat.banner.f;
import com.larus.bmhome.chat.banner.g;
import com.larus.bmhome.chat.banner.i;
import com.larus.bmhome.chat.banner.l;
import com.larus.bmhome.chat.banner.m;
import com.larus.bmhome.chat.nestedmenu.NestedMenuRightModel;
import com.larus.bmhome.chat.nestedmenu.NestedMenuScene;
import com.larus.bmhome.chat.nestedmenu.d;
import com.larus.bmhome.chat.nestedmenu.ui.q;
import di8.b0;
import di8.c0;
import di8.d0;
import di8.f0;
import di8.g0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v19.h;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b implements ei8.c, ei8.b {
    public boolean a;

    public static final class a {
    }

    static {
    }

    @Override // ei8.c
    public final String getKey() {
        return "banner";
    }

    public b() {
    }

    public final void h(LinkedHashMap<String, List<d0>> r4) {
        if (this.a == false) goto L5;
        return;
    L5:
        this.a = true;
        List<d0> r5 = r4.get("banner");
        if (r5 != null) goto L8;
        r5 = CollectionsKt.emptyList();
    L8:
        ArrayList r0 = new ArrayList();
        Iterator<T> r6 = r5.iterator();
    L10:
        if (r6.hasNext() == false) goto L17;
        f0 r1 = ((d0) r6.next()).c();
        if ((r1 instanceof i) == false) goto L14;
        i r2 = (i) r1;
    L15:
        if (r2 == null) goto L10;
        r0.add(r2);
        goto L10
    L14:
        r2 = null;
        goto L15
    L17:
        int r7 = c.a;
        Iterator r8 = r0.iterator();
    L19:
        if (r8.hasNext() == false) goto L21;
        i r3 = (i) r8.next();
        Intrinsics.checkNotNullParameter(r3, "item");
        c.a(r3, false);
        goto L19
    }

    public static Integer f(m r2, boolean r3) {
        Object r0 = null;
        if (r3 == false) goto L14;
        if (r2 == null) goto L12;
        String r4 = r2.b();
        if (r4 == null) goto L12;
        if ((!StringsKt.isBlank(r4)) == true) goto L11;
        r4 = null;
    L11:
        if (r4 == null) goto L12;
    L17:
        if (r4 != null) goto L19;
        return null;
    L19:
        if ((!StringsKt.isBlank(r4)) == true) goto L22;
        r4 = null;
    L22:
        if (r4 == null) goto L36;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L25
        Object r6 = Result.constructor-impl(Integer.valueOf(Color.parseColor(r4)));     // Catch: Throwable -> L25
    L28:
        if (Result.isFailure-impl(r6) == true) goto L32;
        r0 = r6;
    L32:
        return (Integer) r0;
    L25:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L28
    L36:
        return null;
    L12:
        if (r2 == null) goto L16;
        r4 = r2.a();
    L16:
        r4 = null;
        goto L17
    L14:
        if (r2 == null) goto L16;
        r4 = r2.a();
        goto L17
    }

    public static String g(f r1, c0 r2) {
        boolean r0 = h.a;
        if (h.b(r2.c.getContext()) == false) goto L17;
        if (r1 == null) goto L11;
        g r3 = r1.a();
        if (r3 == null) goto L11;
        com.larus.bmhome.chat.banner.h r4 = r3.a();
        if (r4 == null) goto L11;
        String r5 = r4.a();
        if (r5 == null) goto L11;
        return r5;
    L11:
        if (r1 == null) goto L23;
        g r6 = r1.a();
        if (r6 == null) goto L23;
        com.larus.bmhome.chat.banner.h r7 = r6.b();
        if (r7 == null) goto L23;
        return r7.a();
    L23:
        return null;
    L17:
        if (r1 == null) goto L23;
        g r8 = r1.a();
        if (r8 == null) goto L23;
        com.larus.bmhome.chat.banner.h r9 = r8.b();
        if (r9 == null) goto L23;
        return r9.a();
    }

    /* JADX WARN: Type inference failed for: r9v1, types: [gi8.a] */
    @Override // ei8.a
    public final LinkedHashMap<String, List<d0>> a(LinkedHashMap<String, List<d0>> r35, c0 r36) {
        Intrinsics.checkNotNullParameter(r35, "models");
        Intrinsics.checkNotNullParameter(r36, "config");
        if (r36.a != NestedMenuScene.SETTINGS) goto L5;
        return r35;
    L5:
        t1a.b r2 = r36.m;
        if (r2 == null) goto L12;
        l r3 = r2.getAbility(l.class);
        if (r3 == null) goto L12;
        com.larus.bmhome.chat.banner.c r4 = r3.EE();
        if (r4 == null) goto L12;
        List<i> r5 = r4.a();
    L13:
        if (r5 != null) goto L15;
        r5 = CollectionsKt.emptyList();
    L15:
        ArrayList r6 = new ArrayList();
        Iterator<T> r7 = r5.iterator();
    L17:
        if (r7.hasNext() == false) goto L69;
        i r14 = (i) r7.next();
        if (r14 == null) goto L65;
        m r8 = r14.h();
        if (r8 == null) goto L23;
        String r9 = r8.c();
    L24:
        boolean r10 = false;
        if (r9 != null) goto L27;
    L30:
        boolean r11 = true;
    L31:
        if (r11 == false) goto L44;
        m r12 = r14.g();
        if (r12 == null) goto L35;
        String r13 = r12.c();
    L36:
        if (r13 != null) goto L38;
    L41:
        boolean r15 = true;
    L42:
        if (r15 == false) goto L44;
        d r19 = null;
    L64:
        d r16 = r19;
    L66:
        if (r16 == null) goto L17;
        r6.add(r16);
        goto L17
    L38:
        if (StringsKt.isBlank(r13) == true) goto L41;
        r15 = false;
        goto L42
    L35:
        r13 = null;
    L44:
        boolean r17 = h.a;
        boolean r18 = h.b(r36.c.getContext());
        final f r20 = r14.c();
        if (r20 == null) goto L52;
        Integer r21 = r20.b();
        int r110 = ActiveSwitchBannerIconType.Percent.getValue();
        if (r21 == null) goto L52;
        if (r21.intValue() != r110) goto L52;
        r10 = true;
    L52:
        if (r10 == false) goto L54;
        final Context r22 = r36.c.getContext();
        g0 r23 = new g0(null, null, null, false, new gi8.a(r22, r20), 31);
    L55:
        m r24 = r14.h();
        if (r24 == null) goto L58;
        String r25 = r24.c();
    L59:
        b0 r26 = new b0(r25, null, null, null, null, null, null, null, null, f(r14.h(), r18), 16382);
        m r27 = r14.g();
        if (r27 == null) goto L62;
        String r28 = r27.c();
    L63:
        r19 = new d(r23, r26, new NestedMenuRightModel(r28, null, g(r14.f(), r36), f(r14.g(), r18), 223), false, null, false, null, r14, false, false, false, 1912);
        goto L64
    L62:
        r28 = null;
        goto L63
    L58:
        r25 = null;
        goto L59
    L54:
        r23 = new g0(null, g(r20, r36), Integer.valueOf(i5.A()), true, null, 37);
        goto L55
    L27:
        if (StringsKt.isBlank(r9) == true) goto L30;
        r11 = false;
        goto L31
    L23:
        r9 = null;
        goto L24
    L65:
        r16 = null;
        goto L66
    L69:
        if (r6.isEmpty() == false) goto L71;
        return r35;
    L71:
        List<d0> r29 = r35.get("banner");
        if (r29 != null) goto L74;
        r29 = CollectionsKt.emptyList();
    L74:
        r35.put("banner", CollectionsKt.plus(r29, r6));
        return r35;
    L12:
        r5 = null;
        goto L13
    }

    @Override // ei8.b
    public final void b(LinkedHashMap<String, List<d0>> r2, c0 r3) {
        Intrinsics.checkNotNullParameter(r2, "models");
        Intrinsics.checkNotNullParameter(r3, "config");
        h(r2);
        t1a.b r4 = r3.m;
        if (r4 == null) goto L8;
        l r5 = r4.getAbility(l.class);
        if (r5 == null) goto L9;
        r5.iw("menu_open");
        return;
    L9:
        return;
    }

    @Override // ei8.b
    public final void c(List<? extends q> r2, c0 r3) {
        Intrinsics.checkNotNullParameter(r2, "nodes");
        Intrinsics.checkNotNullParameter(r3, "config");
    }

    @Override // ei8.b
    public final void d(LinkedHashMap<String, List<d0>> r2, c0 r3) {
        Intrinsics.checkNotNullParameter(r2, "models");
        Intrinsics.checkNotNullParameter(r3, "config");
        h(r2);
    }

    @Override // ei8.b
    public final void e(LinkedHashMap<String, List<d0>> r2, c0 r3) {
        Intrinsics.checkNotNullParameter(r2, "models");
        Intrinsics.checkNotNullParameter(r3, "config");
        this.a = false;
    }
}
