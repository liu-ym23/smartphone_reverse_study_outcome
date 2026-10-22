package io.noties.markwon.html;

import android.graphics.Color;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J9\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\rH\u0002J-\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u00012\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006¢\u0006\u0002\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lio/noties/markwon/html/CssAttributeHandler;", "", "()V", "LOG_TAG", "", "getSpans", "", LocationMonitorConst.TAG, "Lio/noties/markwon/html/HtmlTag;", "htmlCssStyleMap", "", "Lcom/larus/business/markdown/api/extplugin/html/HtmlCssStyle;", "darkMode", "", "(Lio/noties/markwon/html/HtmlTag;Ljava/util/Map;Z)[Ljava/lang/Object;", "getStyleSpan", "Landroid/text/style/StyleSpan;", "bold", "italic", "joinSpans", "spans", "cssSpans", "(Ljava/lang/Object;[Ljava/lang/Object;)[Ljava/lang/Object;", "parseCssColor", "", TypedValues.Custom.S_COLOR, "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f16558a = null;

    static {
        f16558a = new b();
    }

    private b() {
    }

    private final int a(String r5) {
        int r4 = r5.length();
        if (r4 == 7) goto L10;
        if (r4 != 9) goto L8;
        Objects.requireNonNull(r5, "null cannot be cast to non-null type java.lang.String");
        String r6 = r5.substring(1, 7);
        Intrinsics.checkNotNullExpressionValue(r6, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        Objects.requireNonNull(r5, "null cannot be cast to non-null type java.lang.String");
        String r7 = r5.substring(7, 9);
        Intrinsics.checkNotNullExpressionValue(r7, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return Color.parseColor('#' + r7 + r6);
    L8:
        throw new IllegalArgumentException("Unknown color");
    L10:
        return Color.parseColor(r5);
    }

    private final StyleSpan a(boolean r1, boolean r2) {
        if (r1 == false) goto L5;
        if (r2 == false) goto L5;
        int r0 = 3;
    L11:
        return new StyleSpan(r0);
    L5:
        if (r1 == false) goto L7;
        r0 = 1;
        goto L11
    L7:
        if (r2 == false) goto L9;
        r0 = 2;
        goto L11
    L9:
        r0 = 0;
        goto L11
    }

    public final Object[] a(j r22, Map<String, com.larus.business.markdown.api.extplugin.b.a> r23, boolean r24) {
        j r0 = (j) ZeusTransformUtils.wrapperContextForParams(r22, j.class, "com.obric.memorydata.plugin");
        Map r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r23, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r0, LocationMonitorConst.TAG);
        String r3 = (String) ZeusTransformUtils.preCheckCast(r0.e().get("style"), String.class, "com.obric.memorydata.plugin");
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.e().get("class"), String.class, "com.obric.memorydata.plugin");
        StyleSpan r4 = null;
        if (r24 == false) goto L8;
        if (r2 == null) goto L12;
        com.larus.business.markdown.api.extplugin.b.a r5 = (com.larus.business.markdown.api.extplugin.b.a) ZeusTransformUtils.preCheckCast(r2.get(r1), com.larus.business.markdown.api.extplugin.b.a.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L12;
        com.larus.business.markdown.api.extplugin.b.b r6 = r5.b();
    L13:
        CharSequence r7 = (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L16;
    L19:
        boolean r8 = true;
    L20:
        if (r8 == false) goto L23;
        if (r6 != null) goto L23;
        return null;
    L23:
        List r9 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L28;
        String r10 = r6.a();
        if (r10 == null) goto L28;
    L29:
        if (r6 == null) goto L33;
        String r11 = r6.b();
        if (r11 == null) goto L33;
    L34:
        if (r6 == null) goto L38;
        String r12 = r6.c();
        if (r12 == null) goto L38;
    L39:
        if (r6 == null) goto L43;
        String r13 = r6.d();
        if (r13 == null) goto L43;
        String r14 = r13;
    L149:
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L95
        CharSequence r16 = (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L95
        if (r16 != null) goto L47;
    L50:
        boolean r17 = true;
    L51:
        if (r17 == false) goto L53;
        String r18 = null;
        String r19 = null;
    L91:
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L93
    L99:
        if (r10 != null) goto L146;
    L110:
        if (r11 == null) goto L122;
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L113
        Object r21 = Result.m1421constructorimpl(Boolean.valueOf(r9.add(io.noties.markwon.f.a.f16541a.a(f16558a.a(r11)))));     // Catch: Throwable -> L113
    L115:
        Throwable r25 = Result.m1424exceptionOrNullimpl(r21);
        if (r25 == null) goto L120;
        com.larus.business.markdown.api.depend.f r26 = com.larus.business.markdown.api.depend.g.a();
        if (r26 == null) goto L120;
        r26.e("MD_CSS", "unsupported color: " + r25);
    L120:
        Result.m1420boximpl(r21);
    L113:
        th = move-exception;
        Result.Companion r27 = Result.Companion;
        r21 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L122:
        if (r18 == null) goto L126;
        Integer r28 = StringsKt.toIntOrNull(StringsKt.substringBefore(r18, "px", r18));
        if (r28 == null) goto L126;
        r9.add(new AbsoluteSizeSpan(r28.intValue(), true));
    L126:
        if (r12 == null) goto L130;
        boolean r29 = Intrinsics.areEqual(r12, "italic");
        StyleSpan r30 = (StyleSpan) ZeusTransformUtils.preCheckCast(null, StyleSpan.class, "com.obric.memorydata.plugin");
        r4 = f16558a.a(false, r29);
        if (r4 == null) goto L131;
        r9.add(r4);
    L131:
        if (r14 == null) goto L138;
        boolean r31 = Intrinsics.areEqual(r14, "bold");
        if (r4 == null) goto L135;
        r9.remove(r4);
    L135:
        StyleSpan r32 = f16558a.a(r31, r29);
        if (r32 == null) goto L138;
        r9.add(r32);
    L138:
        if (r19 == null) goto L144;
        Integer r33 = StringsKt.toIntOrNull(StringsKt.substringBefore(r19, "px", r19));
        if (r33 == null) goto L144;
        if (r33.intValue() <= 0) goto L144;
        r9.add(io.noties.markwon.f.a.f16541a.b(com.larus.business.markdown.impl.common.utils.e.a((Number) ZeusTransformUtils.preCheckCast(r33, Number.class, "com.obric.memorydata.plugin"))));
    L144:
        Object[] r34 = ((Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.memorydata.plugin")).toArray(new Object[0]);
        Objects.requireNonNull(r34, "null cannot be cast to non-null type kotlin.Array<T>");
        return r34;
    L130:
        r29 = false;
        goto L131
    L146:
        Result.Companion r35 = Result.Companion;     // Catch: Throwable -> L102
        Object r36 = Result.m1421constructorimpl(Boolean.valueOf(r9.add(new ForegroundColorSpan(f16558a.a(r10)))));     // Catch: Throwable -> L102
    L104:
        Throwable r37 = Result.m1424exceptionOrNullimpl(r36);
        if (r37 == null) goto L109;
        com.larus.business.markdown.api.depend.f r110 = com.larus.business.markdown.api.depend.g.a();
        if (r110 == null) goto L109;
        r110.e("MD_CSS", "unsupported color: " + r37);
    L109:
        Result.m1420boximpl(r36);
    L102:
        th = move-exception;
        Result.Companion r38 = Result.Companion;
        r36 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L104
    L53:
        Iterator<d> r39 = c.a().a(r3).iterator();     // Catch: Throwable -> L95
        r18 = null;
        r19 = null;
    L148:
    L93:
        th = th;
    L97:
        Result.Companion r111 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L99
    L56:
        if (r39.hasNext() == false) goto L91;
        d r112 = (d) ZeusTransformUtils.preCheckCast(r39.next(), d.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L93
        String r113 = r112.a();     // Catch: Throwable -> L93
        Intrinsics.checkNotNullExpressionValue(r113, "property.key()");     // Catch: Throwable -> L93
        String r114 = r112.b();     // Catch: Throwable -> L93
        Intrinsics.checkNotNullExpressionValue(r114, "property.value()");     // Catch: Throwable -> L93
        String r115 = StringsKt.replace$default(r114, "!important", "", false, 4, null);     // Catch: Throwable -> L93
        if (r115 == null) goto L90;
        String r116 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r115, CharSequence.class, "com.obric.memorydata.plugin")).toString();     // Catch: Throwable -> L93
        switch(r113.hashCode()) {
            case -1923578189: goto L86;
            case -1586082113: goto L82;
            case -1221029593: goto L78;
            case -1215680224: goto L75;
            case 94842723: goto L71;
            case 598800822: goto L67;
            case 605322756: goto L63;
            default: goto L148;
        };     // Catch: Throwable -> L93
    L63:
        if (r113.equals("background-color") == false) goto L148;
        r11 = r116;
        goto L148
    L67:
        if (r113.equals("font-weight") == false) goto L148;
        r14 = r116;
        goto L148
    L71:
        if (r113.equals(TypedValues.Custom.S_COLOR) == false) goto L148;
        r10 = r116;
        goto L148
    L75:
        if (r113.equals("line-height") == false) goto L148;
    L80:
        r19 = r116;
        goto L148
    L78:
        if (r113.equals("height") == true) goto L80;
    L82:
        if (r113.equals("font-size") == false) goto L148;
        r18 = r116;
        goto L148
    L86:
        if (r113.equals("font-style") == false) goto L148;
        r12 = r116;
        goto L148
    L90:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");     // Catch: Throwable -> L93
    L47:
        if (r16.length() == 0) goto L50;
        r17 = false;
    L95:
        th = th;
        r18 = null;
        r19 = null;
    L43:
        r14 = null;
    L38:
        r12 = null;
    L33:
        r11 = null;
    L28:
        r10 = null;
        goto L29
    L16:
        if (r7.length() == 0) goto L19;
        r8 = false;
    L12:
        r6 = null;
        goto L13
    L8:
        if (r2 == null) goto L12;
        com.larus.business.markdown.api.extplugin.b.a r40 = (com.larus.business.markdown.api.extplugin.b.a) ZeusTransformUtils.preCheckCast(r2.get(r1), com.larus.business.markdown.api.extplugin.b.a.class, "com.obric.memorydata.plugin");
        if (r40 == null) goto L12;
        r6 = r40.a();
        goto L13
    }

    public final Object[] a(Object r3, Object[] r4) {
        if (r3 != null) goto L6;
        if (r4 != null) goto L6;
        return null;
    L6:
        List r2 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L13;
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(ArraysKt.filterNotNull(r4), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L10:
        if (r5.hasNext() == false) goto L13;
        r2.add(r5.next());
    L13:
        if ((r3 instanceof Object[]) == false) goto L18;
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(ArraysKt.filterNotNull((Object[]) ZeusTransformUtils.preCheckCast(r3, Object[].class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L16:
        if (r6.hasNext() == false) goto L20;
        r2.add(r6.next());
    L20:
        Object[] r7 = ((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.memorydata.plugin")).toArray(new Object[0]);
        Objects.requireNonNull(r7, "null cannot be cast to non-null type kotlin.Array<T>");
        return r7;
    L18:
        if (r3 == null) goto L20;
        r2.add(r3);
        goto L20
    }
}
