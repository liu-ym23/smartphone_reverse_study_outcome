package uc2;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.test.CarnivalAutoTestUtil;
import com.bytedance.android.livesdk.interactivity.zdanmaku.attributes.DanmakuType;
import com.bytedance.live.artist.render.RenderEntity;
import com.bytedance.live.zdanmaku.data.Danmaku;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f {
    public final ArrayList<b> a;
    public final ArrayList<Integer> b;
    public q72.a c;

    public f(q72.a r7) {
        Intrinsics.checkNotNullParameter(r7, "initialConfig");
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.c = r7;
        int r8 = r7.a;
        int r1 = 0;
    L3:
        if (r1 >= r8) goto L5;
        this.a.add(new h(r1, true, false, null));
        r1 = r1 + 1;
        goto L3
    }

    public final ArrayList<Integer> a(Comparator<Integer> r9) {
        Intrinsics.checkNotNullParameter(r9, "comparator");
        this.b.clear();
        int r0 = this.c.b;
        int r2 = 0;
    L4:
        if (r2 >= this.c.a) goto L24;
        com.bytedance.android.livesdk.interactivity.zdanmaku.i r3 = c(r2);
        if (((b) ListProtector.get(this.a, r2)).f == true) goto L4;
        if (r3 != null) goto L9;
        this.b.add(Integer.valueOf(r2));
    L23:
        r2 = r2 + 1;
        goto L4
    L9:
        float r5 = 0.0f;
        if (this.c.g == false) goto L17;
        float r4 = b(r2);
        float r6 = r3.i;
        com.bytedance.android.livesdk.interactivity.zdanmaku.g r7 = r3.h;
        if (r7 == null) goto L15;
        r5 = r7.a(r3);
    L15:
        if ((r4 - (r6 + r5)) <= 0) goto L23;
        this.b.add(Integer.valueOf(r2));
        goto L23
    L17:
        float r8 = b(r2);
        float r10 = r3.i;
        com.bytedance.android.livesdk.interactivity.zdanmaku.g r11 = r3.h;
        if (r11 == null) goto L21;
        r5 = r11.a(r3);
    L21:
        if ((r8 + (r10 + r5)) >= r0) goto L23;
        this.b.add(Integer.valueOf(r2));
        goto L23
    L24:
        Collections.sort(this.b, r9);
        return this.b;
    }

    public final float b(int r3) {
        if (r3 >= this.a.size()) goto L7;
        if (r3 < 0) goto L7;
        boolean r0 = false;
    L9:
        if (r0 == false) goto L12;
        return 0.0f;
    L12:
        if (this.c.g == false) goto L16;
        com.bytedance.android.livesdk.interactivity.zdanmaku.i r4 = c(r3);
        if (r4 != null) goto L21;
        return 0.0f;
    L21:
        return r4.a();
    L16:
        com.bytedance.android.livesdk.interactivity.zdanmaku.i r5 = c(r3);
        if (r5 != null) goto L19;
        return 0.0f;
    L19:
        return r5.c();
    L7:
        r0 = true;
        goto L9
    }

    public final com.bytedance.android.livesdk.interactivity.zdanmaku.i c(int r2) {
        if (r2 >= this.a.size()) goto L7;
        if (r2 < 0) goto L7;
        boolean r0 = false;
    L8:
        if (r0 == false) goto L12;
        return null;
    L12:
        return ((b) ListProtector.get(this.a, r2)).c;
    L7:
        r0 = true;
        goto L8
    }

    public final void e(q72.a r7) {
        Intrinsics.checkNotNullParameter(r7, "newDanmakuConfig");
        int r0 = r7.a;
        this.c = r7;
        this.a.clear();
        int r1 = 0;
    L4:
        if (r1 >= r0) goto L6;
        this.a.add(new h(r1, true, false, null));
        r1 = r1 + 1;
        goto L4
    L6:
        this.a.add(new h(r0 + 1, true, true, null));
        if (v.a() == true) goto L9;
        return;
    L9:
        if (CarnivalAutoTestUtil.a == true) goto L11;
        return;
    L11:
        if (CarnivalAutoTestUtil.a() != null) goto L13;
        return;
    L13:
        if (this.c.g == false) goto L15;
        String r8 = "left";
    L16:
        Intrinsics.checkNotNullParameter(r8, "<set-?>");
        return;
    L15:
        r8 = "right";
        goto L16
    }

    public final void d(int r9, com.bytedance.android.livesdk.interactivity.zdanmaku.i r10) {
        Intrinsics.checkNotNullParameter(r10, "danmaku");
        tc2.f r0 = (tc2.f) r10.b().e(tc2.f.class);
        Boolean r1 = null;
        if (r0 == null) goto L5;
        Boolean r2 = r0.c;
    L6:
        Boolean r3 = Boolean.TRUE;
        boolean r4 = Intrinsics.areEqual(r2, r3);
        float r5 = this.c.d;
        RenderEntity r6 = ((Danmaku) r10).c;
        if (r6 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("renderEntity");
    L9:
        float r7 = (r5 - r6.c.b) / 2;
        int r8 = 0;
        if (r10.getType() != DanmakuType.CarnivalEgg) goto L17;
        tc2.f r11 = (tc2.f) r10.b().e(tc2.f.class);
        if (r11 == null) goto L15;
        r1 = r11.c;
    L15:
        if (Intrinsics.areEqual(r1, r3) == false) goto L17;
        int r13 = 0;
    L24:
        if (r9 != 0) goto L27;
        r13 = Math.abs(r13);
    L27:
        if (r9 != (this.c.a - 1)) goto L29;
        r13 = -Math.abs(r13);
    L29:
        q72.a r14 = this.c;
        float r15 = (r7 + ((r14.d + r14.e) * r9)) + r13;
        if (r14.g == false) goto L37;
        if (r4 == false) goto L36;
        float r16 = -r10.b().c.a;
        float r17 = this.c.c / 2.0f;
        RenderEntity r18 = ((Danmaku) r10).c;
        if (r18 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("renderEntity");
    L35:
        com.bytedance.live.artist.render.b r19 = r18.e;
        r19.a = r16;
        r19.b = r17;
        com.bytedance.live.artist.render.f r20 = r18.c;
        float r21 = r16 - (r20.a / 2.0f);
        float r23 = r17 - (r20.b / 2.0f);
        com.bytedance.live.artist.render.b r24 = r18.d;
        r24.a = r21;
        r24.b = r23;
    L43:
        r10.f = r9;
        r10.e = (b) ListProtector.get(this.a, r9);
        sk6.b r25 = r10.b().e(sk6.b.class);
        if (r25 == null) goto L47;
        r8 = r25.a;
    L47:
        if (r8 <= 80) goto L50;
        float r26 = 0.8f;
    L55:
        q72.a r27 = this.c;
        r10.d = (r27.b / r27.f) * r26;
        r10.g = ((b) ListProtector.get(this.a, r9)).a();
        f(r9, r10);
        if (v.a() == true) goto L58;
        return;
    L58:
        if (CarnivalAutoTestUtil.a == false) goto L62;
        CarnivalAutoTestUtil.a();
        return;
    L62:
        return;
    L50:
        if (40 > r8) goto L54;
        if (80 < r8) goto L54;
        r26 = 1.0f;
    L54:
        r26 = 1.2f;
        goto L55
    L36:
        r10.e(-r10.b().c.a, r15);
        goto L43
    L37:
        if (r4 == false) goto L42;
        float r28 = r14.b;
        float r29 = r14.c / 2.0f;
        RenderEntity r30 = ((Danmaku) r10).c;
        if (r30 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("renderEntity");
    L41:
        com.bytedance.live.artist.render.b r31 = r30.e;
        r31.a = r28;
        r31.b = r29;
        com.bytedance.live.artist.render.f r33 = r30.c;
        float r34 = r28 - (r33.a / 2.0f);
        float r35 = r29 - (r33.b / 2.0f);
        com.bytedance.live.artist.render.b r36 = r30.d;
        r36.a = r34;
        r36.b = r35;
        goto L43
    L42:
        r10.e(r14.b, r15);
    L17:
        tc2.f r37 = (tc2.f) r10.b().e(tc2.f.class);
        if (r37 == null) goto L22;
        Integer r38 = r37.b;
        if (r38 == null) goto L22;
        int r39 = r38.intValue();
    L23:
        r13 = UtilityKotlinExtentionsKt.i(RangesKt.random(new IntRange(-r39, r39), Random.Default));
    L22:
        r39 = 0;
        goto L23
    L5:
        r2 = null;
        goto L6
    }

    public final void f(int r3, com.bytedance.android.livesdk.interactivity.zdanmaku.i r4) {
        Intrinsics.checkNotNullParameter(r4, "danmaku");
        if (r3 >= this.a.size()) goto L7;
        if (r3 < 0) goto L7;
        boolean r0 = false;
    L8:
        if (r0 == false) goto L11;
        return;
    L11:
        if (this.c.g == false) goto L16;
        if (r4.a() >= b(r3)) goto L19;
        ((b) ListProtector.get(this.a, r3)).c = r4;
        return;
    L19:
        return;
    L16:
        if (r4.c() <= b(r3)) goto L21;
        ((b) ListProtector.get(this.a, r3)).c = r4;
        return;
    L21:
        return;
    L7:
        r0 = true;
        goto L8
    }
}
