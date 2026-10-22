package com.obric.oui.texteffects.render;

import android.text.Layout;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\f\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u0006\u001a\f\u0010\u0007\u001a\u0004\u0018\u00010\b*\u00020\u0006¨\u0006\t"}, d2 = {"buildSpanMetrics", "Lcom/obric/oui/texteffects/render/SpanMetrics;", "widths", "", "ensureCharacterLayout", "Landroid/text/StaticLayout;", "Lcom/obric/oui/texteffects/render/TextLayoutCache;", "ensureCharacterSpannable", "Landroid/text/SpannableString;", "OUITextEffects_standardRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class o {
    public static final SpannableString a(m r14) {
        Intrinsics.checkNotNullParameter(r14, "<this>");
        int r1 = 0;
        if (r14.c().length != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return null;
    L9:
        d r2 = r14.q();
        SpannableString r3 = r2.e();
        if (r3 != null) goto L12;
    L14:
        r2.d().clear();
        com.obric.oui.texteffects.a r4 = com.obric.oui.texteffects.a.f14578a;
        if (com.obric.oui.texteffects.a.a() == false) goto L17;
        Log.d(Intrinsics.stringPlus("OTextEff/", "TextLayoutCache"), "create character SpannableString text={" + r14.b() + "}, count=" + r14.c().length);
    L17:
        SpannableString r5 = new SpannableString(r14.b());
        int r6 = r14.c().length;
    L18:
        if (r1 >= r6) goto L23;
        int r12 = r1 + 1;
        a r13 = new a(r14, r1, r14.d()[r1], r2.a()[r1], r2.b()[r1]);
        ((Collection) ZeusTransformUtils.preCheckCast(r2.d(), Collection.class, "com.obric.memorydata.plugin")).add(r13);
        com.obric.oui.texteffects.a r7 = com.obric.oui.texteffects.a.f14578a;
        if (com.obric.oui.texteffects.a.a() == false) goto L22;
        Log.d(Intrinsics.stringPlus("OTextEff/", "TextLayoutCache"), "create AnimatedCharacterSpan index=" + r1 + " width=" + r14.d()[r1] + " advance=" + r2.a()[r1] + " correction=" + r2.b()[r1]);
    L22:
        r5.setSpan(r13, r1, r12, 33);
        r1 = r12;
        goto L18
    L23:
        r2.a(r5);
        return r5;
    L12:
        if (r2.d().size() != r14.c().length) goto L14;
        return r3;
    L5:
        r0 = false;
        goto L6
    }

    public static final /* synthetic */ i a(float[] r0) {
        return b(r0);
    }

    public static final StaticLayout b(m r13) {
        Intrinsics.checkNotNullParameter(r13, "<this>");
        SpannableString r0 = a(r13);
        if (r0 != null) goto L6;
        return null;
    L6:
        d r1 = r13.q();
        StaticLayout r2 = r1.f();
        if (r2 != null) goto L9;
    L13:
        com.obric.oui.texteffects.a r3 = com.obric.oui.texteffects.a.f14578a;
        if (com.obric.oui.texteffects.a.a() == false) goto L16;
        Log.d(Intrinsics.stringPlus("OTextEff/", "TextLayoutCache"), "create character StaticLayout text={" + r13.b() + "}, width=" + RangesKt.coerceAtLeast(ArraysKt.sum(r1.a()), 1) + ", includeFontPadding=" + r13.j());
    L16:
        r1.a(new StaticLayout((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin"), r1.c(), RangesKt.coerceAtLeast(ArraysKt.sum(r1.a()), 1), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, r13.j()));
        return r1.f();
    L9:
        if (r1.e() != r0) goto L13;
        if (r1.d().size() != r13.c().length) goto L13;
        return r2;
    }

    private static final i b(float[] r9) {
        int[] r0 = new int[r9.length];
        float[] r1 = new float[r9.length];
        com.obric.oui.texteffects.a r2 = com.obric.oui.texteffects.a.f14578a;
        if (com.obric.oui.texteffects.a.a() == false) goto L5;
        Log.d(Intrinsics.stringPlus("OTextEff/", "TextLayoutCacheBuilder"), Intrinsics.stringPlus("create span metrics arrays size=", Integer.valueOf(r9.length)));
    L5:
        float r3 = 0.0f;
        int r4 = r9.length;
        int r5 = 0;
        int r6 = 0;
    L6:
        if (r5 >= r4) goto L9;
        r1[r5] = r3 - r6;
        r3 = r3 + r9[r5];
        int r8 = MathKt.roundToInt(r3);
        r0[r5] = RangesKt.coerceAtLeast(r8 - r6, 0);
        r5 = r5 + 1;
        r6 = r8;
        goto L6
    L9:
        return new i(r0, r1);
    }
}
