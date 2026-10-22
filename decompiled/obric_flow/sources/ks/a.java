package ks;

import com.obric.oui.texteffects.core.BlendSpec;
import com.obric.oui.texteffects.core.Direction;
import com.obric.oui.texteffects.core.EffectProperty;
import com.obric.oui.texteffects.core.TextSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import js.c;
import js.d;
import js.e;
import js.f;
import js.g;
import js.h;
import js.j;
import js.k;
import js.l;
import js.m;
import js.n;
import js.o;
import js.p;
import js.r;
import js.s;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f19474a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final js.a f19475b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final js.a f19476c = null;

    static {
        f19474a = new a();
        f19475b = new js.a(0.42f, 0.58f, 1.0f);
        f19476c = new js.a(0.26f, 0.6f, 0.2f);
    }

    public static p a(EffectProperty r10, f4.b r11, Pair... r12) {
        ArrayList r5 = new ArrayList(r12.length);
        int r13 = r12.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L6;
        Pair r15 = r12[r14];
        r5.add(new m(((Number) r15.getFirst()).longValue(), new g(((Number) r15.getSecond()).floatValue())));
        r14 = r14 + 1;
        goto L3
    L6:
        return new p(r10, r5, r11);
    }

    public static p b(EffectProperty r10, f4.b r11, Pair... r12) {
        ArrayList r5 = new ArrayList(r12.length);
        int r13 = r12.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L6;
        Pair r15 = r12[r14];
        r5.add(new m(((Number) r15.getFirst()).longValue(), new h(((Number) r15.getSecond()).floatValue())));
        r14 = r14 + 1;
        goto L3
    L6:
        return new p(r10, r5, r11);
    }

    public static p d(a r10, Pair[] r11, Direction r12) {
        r10.getClass();
        EffectProperty r13 = EffectProperty.GradientAlphaScan;
        ArrayList r5 = new ArrayList(r11.length);
        int r14 = r11.length;
        int r15 = 0;
    L3:
        if (r15 >= r14) goto L6;
        Pair r16 = r11[r15];
        r5.add(new m(((Number) r16.getFirst()).longValue(), new h(((Number) r16.getSecond()).floatValue())));
        r15 = r15 + 1;
        goto L3
    L6:
        return new p(r13, r5, f19475b, new r(r12, r12));
    }

    public static p e(a r5, Pair[] r10) {
        js.a r11 = f19475b;
        r5.getClass();
        return b(EffectProperty.Alpha, r11, (Pair[]) Arrays.copyOf(r10, r10.length));
    }

    public static d f(String r10, TextSource r11, List r12) {
        int[] r5 = b.f19477a;
        return new d(r10, r11, new k(b.f19478b, r5), BlendSpec.SCREEN, r12);
    }

    public static c g(String r10, String r11, Direction r12, long r13, float r14, float r15) {
        j r5 = new j(r14);
        j r16 = new j(r15);
        List r17 = CollectionsKt.createListBuilder();
        r17.add(new m(0, new h(1.0f)));
        r17.add(new m(r13 - 1, new h(0.0f)));
        List r18 = CollectionsKt.build(r17);
        List r19 = CollectionsKt.createListBuilder();
        r19.add(new m(0, r5));
        r19.add(new m(r13, r16));
        List r110 = CollectionsKt.build(r19);
        return new c(r10, r11, new o(r12), CollectionsKt.listOf(new p[]{new p(EffectProperty.Visibility, r18, js.b.f18455b), new p(EffectProperty.TranslationX, r110, f19475b)}));
    }

    public static /* synthetic */ s j() {
        return f19474a.i(0.0f, true);
    }

    public static p k(a r5, Pair[] r10) {
        js.a r11 = f19475b;
        r5.getClass();
        return b(EffectProperty.Tracking, r11, (Pair[]) Arrays.copyOf(r10, r10.length));
    }

    public final s c(boolean r27) {
        long r10 = Math.max(1250, 1450);
        TextSource r5 = TextSource.Current;
        Float r11 = Float.valueOf(0.03f);
        Pair r12 = TuplesKt.to(150L, r11);
        Float r15 = Float.valueOf(0.0f);
        p r13 = k(this, new Pair[]{r12, TuplesKt.to(1250L, r15)});
        Float r14 = Float.valueOf(-0.5f);
        Pair r16 = TuplesKt.to(0L, r14);
        Float r17 = Float.valueOf(1.0f);
        Pair[] r18 = {r16, TuplesKt.to(1250L, r17)};
        Direction r19 = Direction.LeftToRight;
        List r20 = CollectionsKt.mutableListOf(new e[]{new d("generate_scan_base_text", r5, l.f18471c, BlendSpec.SRC_OVER, CollectionsKt.listOf(new p[]{r13, d(this, r18, r19)})), f("generate_scan_text", r5, CollectionsKt.listOf(new p[]{e(this, new Pair[]{TuplesKt.to(0L, Float.valueOf(0.8f)), TuplesKt.to(750L, Float.valueOf(0.8f)), TuplesKt.to(1450L, r15)}), k(this, new Pair[]{TuplesKt.to(150L, r11), TuplesKt.to(1400L, r15)}), d(this, new Pair[]{TuplesKt.to(0L, r14), TuplesKt.to(1250L, r17)}, r19)}))});
        if (r27 == false) goto L6;
        r20.add(g("enter_indicator", "enterScanIndicator", r19, 1250, -0.4f, 1.0f));
    L6:
        return new s("oui.dim_point.generate", r10, null, CollectionsKt.mutableListOf(new f[]{new f("generate_enter", r10, r20)}), 10);
    }

    public final s h() {
        n r5 = n.d;
        TextSource r10 = TextSource.Current;
        List r13 = CollectionsKt.emptyList();
        return new s("oui.dim_point.pending", 1500, r5, CollectionsKt.listOf(new f("pending_breath", 1500, CollectionsKt.listOf(new d[]{new d("base_text", r10, l.f18471c, BlendSpec.SRC_OVER, r13), f("gradient_overlay", r10, CollectionsKt.listOf(e(this, new Pair[]{TuplesKt.to(0L, Float.valueOf(0.0f)), TuplesKt.to(750L, Float.valueOf(0.8f)), TuplesKt.to(1500L, Float.valueOf(0.0f))})))}))), 2);
    }

    public final s i(float r38, boolean r39) {
        long r5 = Math.max(Math.max(1250, 1450), Math.max(600, Math.max(600, 600)));
        TextSource r10 = TextSource.Old;
        Float r14 = Float.valueOf(0.0f);
        Pair r13 = TuplesKt.to(0L, r14);
        Float r11 = Float.valueOf(16.0f);
        Pair[] r12 = {r13, TuplesKt.to(600L, r11)};
        js.a r15 = f19475b;
        EffectProperty r16 = EffectProperty.BlurRadius;
        p r17 = a(r16, r15, (Pair[]) Arrays.copyOf(r12, 2));
        Pair r18 = TuplesKt.to(0L, r14);
        Float r19 = Float.valueOf(3.0f);
        Pair[] r20 = {r18, TuplesKt.to(600L, r19)};
        EffectProperty r110 = EffectProperty.TranslationX;
        p r21 = a(r110, r15, (Pair[]) Arrays.copyOf(r20, 2));
        Float r111 = Float.valueOf(-0.4f);
        Pair r112 = TuplesKt.to(0L, r111);
        Pair r113 = TuplesKt.to(50L, r111);
        Float r22 = Float.valueOf(1.0f);
        Pair[] r23 = {r112, r113, TuplesKt.to(600L, r22)};
        Direction r114 = Direction.RightToLeft;
        List r24 = CollectionsKt.listOf(new p[]{r17, r21, d(this, r23, r114)});
        l r28 = l.f18471c;
        BlendSpec r29 = BlendSpec.SRC_OVER;
        List r25 = CollectionsKt.mutableListOf(new e[]{new d("old_text_exit", r10, r28, r29, r24)});
        if (r38 <= 0.001f) goto L5;
        Float r26 = r22;
        Direction r27 = r114;
        r25.add(f("old_gradient_exit", r10, CollectionsKt.listOf(new p[]{e(this, new Pair[]{TuplesKt.to(0L, Float.valueOf(RangesKt.coerceIn(r38, 0.0f, 0.8f))), TuplesKt.to(600L, Float.valueOf(RangesKt.coerceIn(r38, 0.0f, 0.8f)))}), a(r16, r15, (Pair[]) Arrays.copyOf(new Pair[]{TuplesKt.to(0L, r14), TuplesKt.to(600L, r11)}, 2)), a(r110, r15, (Pair[]) Arrays.copyOf(new Pair[]{TuplesKt.to(0L, r14), TuplesKt.to(600L, r19)}, 2)), d(this, new Pair[]{TuplesKt.to(0L, r111), TuplesKt.to(600L, r26)}, r27)})));
    L6:
        TextSource r30 = TextSource.New;
        p r31 = k(this, new Pair[]{TuplesKt.to(150L, Float.valueOf(0.03f)), TuplesKt.to(1400L, r14)});
        Pair[] r115 = {TuplesKt.to(0L, Float.valueOf(-0.5f)), TuplesKt.to(1250L, r26)};
        Direction r116 = Direction.LeftToRight;
        List r32 = CollectionsKt.mutableListOf(new e[]{new d("new_text_enter_base", r30, r28, r29, CollectionsKt.listOf(new p[]{r31, d(this, r115, r116)})), f("new_text_enter", r30, CollectionsKt.listOf(new p[]{e(this, new Pair[]{TuplesKt.to(0L, Float.valueOf(0.8f)), TuplesKt.to(750L, Float.valueOf(0.8f)), TuplesKt.to(1450L, r14)}), k(this, new Pair[]{TuplesKt.to(150L, Float.valueOf(0.03f)), TuplesKt.to(1400L, r14)}), d(this, new Pair[]{TuplesKt.to(0L, Float.valueOf(-0.5f)), TuplesKt.to(1250L, r26)}, r116)}))});
        if (r39 == false) goto L10;
        r25.add(g("exit_indicator", "exitScanIndicator", r27, 600, -0.7f, 1.0f));
        r32.add(g("enter_indicator", "enterScanIndicator", r116, 1250, -0.7f, 1.0f));
    L10:
        return new s("oui.dim_point.rewrite", r5, null, CollectionsKt.mutableListOf(new f[]{new f("rewrite", r5, CollectionsKt.plus(r25, r32))}), 10);
    L5:
        r26 = r22;
        r27 = r114;
        goto L6
    }
}
