package io.noties.markwon.ext.tables;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.Layout;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.LeadingMarginSpan;
import android.text.style.UpdateAppearance;
import android.text.style.UpdateLayout;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.noties.markwon.core.spans.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000È\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B3\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\u0012\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/H\u0002J \u00100\u001a\u00020-\"\b\b\u0000\u00101*\u00020/2\f\u00102\u001a\b\u0012\u0004\u0012\u0002H103H\u0016JT\u00104\u001a\u00020-2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u0002082\b\b\u0001\u00109\u001a\u00020$2\b\b\u0001\u0010:\u001a\u00020$2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020$2\u0006\u0010>\u001a\u00020$2\u0006\u0010?\u001a\u00020$2\u0006\u0010@\u001a\u00020\u001dH\u0016J(\u0010A\u001a\n\u0012\u0004\u0012\u0002H1\u0018\u00010\n\"\b\b\u0000\u00101*\u00020/2\f\u00102\u001a\b\u0012\u0004\u0012\u0002H103H\u0016J=\u0010B\u001a\n\u0012\u0004\u0012\u0002H1\u0018\u00010C\"\b\b\u0000\u00101*\u00020/2\u0006\u0010;\u001a\u00020$2\u0006\u0010>\u001a\u00020$2\f\u00102\u001a\b\u0012\u0004\u0012\u0002H103H\u0016¢\u0006\u0002\u0010DJ(\u0010E\u001a\u00020$2\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020$2\u0006\u0010I\u001a\u00020$2\u0006\u0010J\u001a\u00020$H\u0002J6\u0010K\u001a\u00020$2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u00107\u001a\u0002082\b\b\u0001\u00109\u001a\u00020$2\b\b\u0001\u0010:\u001a\u00020$2\b\u0010L\u001a\u0004\u0018\u00010MH\u0016J(\u0010N\u001a\u00020-2\u0006\u0010I\u001a\u00020$2\u0006\u00107\u001a\u0002082\u0006\u0010F\u001a\u00020G2\u0006\u0010J\u001a\u00020$H\u0002J \u0010O\u001a\u00020-2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020$2\u0006\u0010:\u001a\u00020$H\u0002J \u0010P\u001a\u00020\u001a2\u0006\u0010Q\u001a\u0002082\u0006\u0010R\u001a\u00020$2\u0006\u0010S\u001a\u00020TH\u0002J,\u0010U\u001a\u00020-2\b\u00107\u001a\u0004\u0018\u00010V2\b\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00109\u001a\u00020$2\u0006\u0010:\u001a\u00020$H\u0016J<\u0010W\u001a\u00020-2\b\u00107\u001a\u0004\u0018\u00010V2\b\u0010.\u001a\u0004\u0018\u00010/2\u0006\u0010X\u001a\u00020$2\u0006\u0010Y\u001a\u00020$2\u0006\u0010Z\u001a\u00020$2\u0006\u0010[\u001a\u00020$H\u0016J,\u0010\\\u001a\u00020-2\b\u00107\u001a\u0004\u0018\u00010V2\b\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00109\u001a\u00020$2\u0006\u0010:\u001a\u00020$H\u0016J\u0010\u0010]\u001a\u00020-2\u0006\u0010^\u001a\u00020VH\u0002J>\u0010_\u001a\u00020-\"\b\b\u0000\u0010`*\u00020/\"\b\b\u0001\u0010a*\u00020/2\f\u0010b\u001a\b\u0012\u0004\u0012\u0002H`032\u0012\u0010c\u001a\u000e\u0012\u0004\u0012\u0002H`\u0012\u0004\u0012\u0002Ha0dH\u0016R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0013X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u001a0\u0019j\b\u0012\u0004\u0012\u00020\u001a`\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\u00020$8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010(\u001a\u00020$8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b)\u0010'R\u000e\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006e"}, d2 = {"Lio/noties/markwon/ext/tables/TableRowSpan2;", "Lio/noties/markwon/ext/tables/AbsTableRowSpan;", "Lio/noties/markwon/StatusSpan;", "Landroid/text/SpanWatcher;", "Lio/noties/markwon/custom/TypingFreeSpan;", "tableTheme", "Lio/noties/markwon/ext/tables/TableTheme2;", "scrollBarTheme", "Lio/noties/markwon/scrollable/ScrollBarTheme;", "wholeTable", "", "Lio/noties/markwon/ext/tables/TablePlugin2$Row;", "row", "scrollable", "Lio/noties/markwon/scrollable/HorizontalScrollable;", "(Lio/noties/markwon/ext/tables/TableTheme2;Lio/noties/markwon/scrollable/ScrollBarTheme;Ljava/util/List;Lio/noties/markwon/ext/tables/TablePlugin2$Row;Lio/noties/markwon/scrollable/HorizontalScrollable;)V", "bgDrawable", "Landroid/graphics/drawable/GradientDrawable;", "generating", "", "getGenerating", "()Z", "setGenerating", "(Z)V", "layouts", "Ljava/util/ArrayList;", "Landroid/text/Layout;", "Lkotlin/collections/ArrayList;", "paint", "Landroid/graphics/Paint;", "reLayout", "rect", "Landroid/graphics/Rect;", "scrollBar", "shaderPaint", "startMargin", "", "tableContentWidth", "getTableContentWidth", "()I", "tableWidth", "getTableWidth", "textPaint", "Landroid/text/TextPaint;", "checkLayout", "", "what", "", "clearSpansInTable", com.tom_roush.pdfbox.pdmodel.a.d.i.F, "span", "Ljava/lang/Class;", "draw", "canvas", "Landroid/graphics/Canvas;", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", CommonConsts.APM_INNER_EVENT_COST_START, "end", "x", "", "top", "y", "bottom", "p", "findSpanInRow", "findSpanInTable", "", "(IILjava/lang/Class;)[Ljava/lang/Object;", "getCellWidth", LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL, "Lio/noties/markwon/ext/tables/TablePlugin2$Cell;", "padding", "index", "totalContentWidth", "getSize", "fm", "Landroid/graphics/Paint$FontMetricsInt;", "makeLayout", "makeNewLayouts", "newLayout", Params.CONTENT, "width", "alignment", "Landroid/text/Layout$Alignment;", "onSpanAdded", "Landroid/text/Spannable;", "onSpanChanged", "ostart", "oend", "nstart", "nend", "onSpanRemoved", "scheduleAsyncDrawables", "spannable", "setSpansInTable", "coveredSpan", "setSpan", "toCoveredSpan", "getToSetSpan", "Lkotlin/Function1;", "markwon-ext-tables_release"}, k = 1, mv = {1, 1, 15})
public class i extends io.noties.markwon.ext.tables.a implements SpanWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f16513a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayList<Layout> f16514b;
    private final TextPaint c;
    private final Rect d;
    private final Paint e;
    private final GradientDrawable f;
    private final Paint g;
    private boolean h;
    private final GradientDrawable i;
    private int j;
    private final m k;
    private final io.noties.markwon.scrollable.e l;
    private final List<h.b> m;
    private final h.b n;
    private final io.noties.markwon.scrollable.b o;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\f"}, d2 = {"io/noties/markwon/ext/tables/TableRowSpan2$scheduleAsyncDrawables$1", "Landroid/graphics/drawable/Drawable$Callback;", "invalidateDrawable", "", "who", "Landroid/graphics/drawable/Drawable;", "scheduleDrawable", "what", "Ljava/lang/Runnable;", "when", "", "unscheduleDrawable", "markwon-ext-tables_release"}, k = 1, mv = {1, 1, 15})
    public static final class a implements Drawable.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f16515a;

        a(i r1) {
            this.f16515a = r1;
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable r2) {
            Intrinsics.checkParameterIsNotNull(r2, "who");
            this.f16515a.a();
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable r1, Runnable r2, long r3) {
            Runnable r0 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r1, "who");
            Intrinsics.checkParameterIsNotNull(r0, "what");
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable r2, Runnable r3) {
            Runnable r1 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r2, "who");
            Intrinsics.checkParameterIsNotNull(r1, "what");
        }
    }

    public i(m r3, io.noties.markwon.scrollable.e r4, List<h.b> r5, h.b r6, io.noties.markwon.scrollable.b r7) {
        List<h.b> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r3, "tableTheme");
        Intrinsics.checkParameterIsNotNull(r4, "scrollBarTheme");
        Intrinsics.checkParameterIsNotNull(r8, "wholeTable");
        Intrinsics.checkParameterIsNotNull(r6, "row");
        Intrinsics.checkParameterIsNotNull(r7, "scrollable");
        this.k = r3;
        this.l = r4;
        this.m = r8;
        this.n = r6;
        this.o = r7;
        this.f16514b = new ArrayList(r6.b().size());
        TextPaint r9 = new TextPaint();
        r9.setTextSize(r3.g());
        r9.setColor(r3.j());
        this.c = r9;
        this.d = new Rect();
        this.e = new Paint(1);
        this.f = new GradientDrawable();
        Paint r10 = new Paint();
        r10.setStyle(Paint.Style.FILL);
        this.g = r10;
        GradientDrawable r11 = new GradientDrawable();
        r11.setColor(r4.d());
        r11.setBounds(0, 0, r4.a(), r4.b());
        r11.setCornerRadius(r4.b() * 0.5f);
        this.i = r11;
    }

    private final int a(h.a r2, int r3, int r4, int r5) {
        int r6 = this.n.b().size();
        int r7 = Math.min(Math.max(this.k.d(), ((int) r2.c()) + r3), this.k.e());
        if (this.k.k() == false) goto L9;
        if (r6 <= 0) goto L10;
        int r8 = d() - c();
        if (r4 == (r6 - 1)) goto L8;
        return r7;
    L8:
        return Math.max(r8, r7);
    L10:
        return r7;
    L9:
        return r7;
    }

    public static final /* synthetic */ GradientDrawable a(i r0) {
        return r0.f;
    }

    private final Layout a(CharSequence r11, int r12, Layout.Alignment r13) {
        CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r11, CharSequence.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 23) goto L5;
        StaticLayout r10 = StaticLayout.Builder.obtain(r3, 0, r3.length(), this.c, r12).setIncludePad(false).setAlignment(r13).setLineSpacing(0.0f, 1.0f).setMaxLines(Integer.MAX_VALUE).build();
        Intrinsics.checkExpressionValueIsNotNull(r10, "StaticLayout.Builder\n   …\n                .build()");
        Object r14 = ZeusTransformUtils.preCheckCast(r10, Layout.class, "com.obric.memorydata.plugin");
    L7:
        return (Layout) r14;
    L5:
        r14 = ZeusTransformUtils.preCheckCast(new StaticLayout(r3, this.c, r12, r13, 1.0f, 0.0f, false), Layout.class, "com.obric.memorydata.plugin");
        goto L7
    }

    private final void a(int r9, CharSequence r10, h.a r11, int r12) {
        CharSequence r13 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r10, CharSequence.class, "com.obric.memorydata.plugin");
        SpannableString r0 = new SpannableString(r11.e());
        if (ZeusTransformUtils.instanceOf(r13, Spanned.class) == true) goto L5;
    L14:
        int r14 = this.k.b() * 2;
        Layout r15 = a((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin"), a(r11, r14, r9, r12) - r14, b.a(r11.d()));
        s.a((Spannable) ZeusTransformUtils.preCheckCast(r0, Spannable.class, "com.obric.memorydata.plugin"), r15);
        this.f16514b.add(r9, r15);
        a((Spannable) ZeusTransformUtils.preCheckCast(r0, Spannable.class, "com.obric.memorydata.plugin"));
        return;
    L5:
        if (r11.a() <= (-1)) goto L14;
        if (r11.b() <= (-1)) goto L14;
        CharacterStyle[] r16 = (CharacterStyle[]) ZeusTransformUtils.preCheckCast(((Spanned) ZeusTransformUtils.preCheckCast(r13, Spanned.class, "com.obric.memorydata.plugin")).getSpans(r11.a(), r11.b(), CharacterStyle.class), CharacterStyle[].class, "com.obric.memorydata.plugin");
        Intrinsics.checkExpressionValueIsNotNull(r16, "extraSpans");
        int r2 = r16.length;
        int r4 = 0;
    L9:
        if (r4 >= r2) goto L14;
        CharacterStyle r5 = r16[r4];
        if (r5 == ((i) ZeusTransformUtils.preCheckCast(this, i.class, "com.obric.memorydata.plugin"))) goto L13;
        r0.setSpan(r5, 0, r0.length(), 33);
    L13:
        r4 = r4 + 1;
        goto L9
    }

    private final void a(Spannable r7) {
        Spannable r8 = (Spannable) ZeusTransformUtils.wrapperContextForParams(r7, Spannable.class, "com.obric.memorydata.plugin");
        int r3 = 0;
        io.noties.markwon.a.d[] r9 = (io.noties.markwon.a.d[]) ZeusTransformUtils.preCheckCast(r8.getSpans(0, r8.length(), io.noties.markwon.a.d.class), io.noties.markwon.a.d[].class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L5;
        return;
    L5:
        if (r9.length != 0) goto L7;
        boolean r0 = true;
    L9:
        if ((!r0) == false) goto L21;
        int r1 = r9.length;
    L11:
        if (r3 >= r1) goto L22;
        io.noties.markwon.a.d r2 = r9[r3];
        Intrinsics.checkExpressionValueIsNotNull(r2, "span");
        io.noties.markwon.a.a r4 = r2.a();
        Intrinsics.checkExpressionValueIsNotNull(r4, "span.drawable");
        if (r4.h() == true) goto L16;
        r4.a((Drawable.Callback) ZeusTransformUtils.preCheckCast(new a(this), Drawable.Callback.class, "com.obric.memorydata.plugin"));
    L16:
        r3 = r3 + 1;
        goto L11
    L22:
        return;
    L21:
        return;
    L7:
        r0 = false;
        goto L9
    }

    private final void a(CharSequence r10, int r11, int r12) {
        CharSequence r13 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r10, CharSequence.class, "com.obric.memorydata.plugin");
        int r0 = 0;
        this.j = 0;
        if (ZeusTransformUtils.instanceOf(r13, SpannableString.class) == true) goto L5;
        CharSequence r2 = null;
    L6:
        SpannableString r3 = (SpannableString) ZeusTransformUtils.preCheckCast(r2, SpannableString.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L12;
        int r4 = this.j;
        Object[] r14 = r3.getSpans(r11, r12, LeadingMarginSpan.class);
        Intrinsics.checkExpressionValueIsNotNull(r14, "sb.getSpans(start, end, …ngMarginSpan::class.java)");
        int r15 = r14.length;
        int r5 = 0;
        int r6 = 0;
    L9:
        if (r5 >= r15) goto L11;
        r6 = r6 + ((LeadingMarginSpan) ZeusTransformUtils.preCheckCast(r14[r5], LeadingMarginSpan.class, "com.obric.memorydata.plugin")).getLeadingMargin(false);
        r5 = r5 + 1;
        goto L9
    L11:
        this.j = r4 + r6;
    L12:
        this.c.setFakeBoldText(this.n.c());
        this.f16514b.clear();
        if (this.n.a() == 0) goto L18;
        h.a r16 = (h.a) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(this.n.b()), h.a.class, "com.obric.memorydata.plugin");
        if (r16 != null) goto L17;
    L35:
        Iterator r17 = ((Iterable) ZeusTransformUtils.preCheckCast(this.n.b(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r18 = 0;
    L37:
        if (r17.hasNext() == false) goto L39;
        r18 = r18 + ((int) (((h.a) ZeusTransformUtils.preCheckCast(r17.next(), h.a.class, "com.obric.memorydata.plugin")).c() + (this.k.b() * 2)));
        goto L37
    L39:
        Iterator r19 = ((Iterable) ZeusTransformUtils.preCheckCast(this.n.b(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L41:
        if (r19.hasNext() == false) goto L46;
        Object r7 = r19.next();
        int r8 = r0 + 1;
        if (r0 >= 0) goto L45;
        CollectionsKt.throwIndexOverflow();
    L45:
        a(r0, r13, (h.a) ZeusTransformUtils.preCheckCast(r7, h.a.class, "com.obric.memorydata.plugin"), r18);
        r0 = r8;
        goto L41
    L46:
        return;
    L17:
        if (r16.c() != 0.0f) goto L35;
    L18:
        h.b r110 = (h.b) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(this.m), h.b.class, "com.obric.memorydata.plugin");
        if (r110 == null) goto L23;
        List<h.a> r111 = r110.b();
        if (r111 == null) goto L23;
        int r112 = r111.size();
    L24:
        Iterator r113 = ((Iterable) ZeusTransformUtils.preCheckCast(RangesKt.until(0, r112), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L26:
        if (r113.hasNext() == false) goto L35;
        int r9 = ((IntIterator) ZeusTransformUtils.preCheckCast(r113, IntIterator.class, "com.obric.memorydata.plugin")).nextInt();
        Iterator r20 = ((Iterable) ZeusTransformUtils.preCheckCast(this.m, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        float r21 = 0.0f;
    L29:
        if (r20.hasNext() == false) goto L31;
        h.b r22 = (h.b) ZeusTransformUtils.preCheckCast(r20.next(), h.b.class, "com.obric.memorydata.plugin");
        r21 = Math.max(r21, a(((h.a) ZeusTransformUtils.preCheckCast(r22.b().get(r9), h.a.class, "com.obric.memorydata.plugin")).e(), Integer.MAX_VALUE, b.a(((h.a) ZeusTransformUtils.preCheckCast(r22.b().get(r9), h.a.class, "com.obric.memorydata.plugin")).d())).getLineWidth(0));
        goto L29
    L31:
        Iterator r23 = ((Iterable) ZeusTransformUtils.preCheckCast(this.m, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L33:
        if (r23.hasNext() == false) goto L26;
        ((h.a) ZeusTransformUtils.preCheckCast(((h.b) ZeusTransformUtils.preCheckCast(r23.next(), h.b.class, "com.obric.memorydata.plugin")).b().get(r9), h.a.class, "com.obric.memorydata.plugin")).a(r21);
    L23:
        r112 = 0;
        goto L24
    L5:
        r2 = r13;
        goto L6
    }

    private final void a(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, UpdateAppearance.class) == true) goto L5;
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(r2, UpdateLayout.class) == true) goto L9;
        this.h = true;
        return;
    }

    public static final /* synthetic */ m b(i r0) {
        return r0.k;
    }

    private final int c() {
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f16514b, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L6;
        r1 = r1 + (((Layout) ZeusTransformUtils.preCheckCast(r0.next(), Layout.class, "com.obric.memorydata.plugin")).getWidth() + (this.k.b() * 2));
        goto L4
    L6:
        return r1;
    }

    public static final /* synthetic */ Paint c(i r0) {
        return r0.g;
    }

    private final int d() {
        if (this.k.k() == false) goto L6;
        return this.k.c() - this.j;
    L6:
        return Math.min(c(), this.k.c() - this.j);
    }

    @Override // io.noties.markwon.ext.tables.a
    public <Span> Span[] a(int r8, int r9, Class<Span> r10) {
        Intrinsics.checkParameterIsNotNull(r10, "span");
        int r11 = r9 - this.k.a();
        int r12 = r8 - MathKt.roundToInt(this.o.b());
        int r0 = this.k.b();
        Iterator<Layout> r1 = this.f16514b.iterator();
    L4:
        if (r1.hasNext() == false) goto L21;
        Layout r2 = (Layout) ZeusTransformUtils.preCheckCast(r1.next(), Layout.class, "com.obric.memorydata.plugin");
        Intrinsics.checkExpressionValueIsNotNull(r2, "layout");
        int r4 = r2.getWidth() + r0;
        if (r0 > r12) goto L20;
        if (r4 < r12) goto L20;
        int r6 = r2.getHeight();
        if (r11 < 0) goto L20;
        if (r6 < r11) goto L20;
        int r7 = r2.getOffsetForHorizontal(r2.getLineForVertical(r11), r12 - r0);
        CharSequence r13 = r2.getText();
        if (ZeusTransformUtils.instanceOf(r13, Spanned.class) == true) goto L16;
        r13 = null;
    L16:
        Spanned r14 = (Spanned) ZeusTransformUtils.preCheckCast(r13, Spanned.class, "com.obric.memorydata.plugin");
        if (r14 != null) goto L19;
        return null;
    L19:
        return (Span[]) r14.getSpans(r7, r7, r10);
    L20:
        r0 = (this.k.b() * 2) + r4;
        goto L4
    L21:
        return null;
    }

    public boolean b() {
        return this.f16513a;
    }

    /* JADX WARN: Type inference failed for: r2v17, types: [io.noties.markwon.ext.tables.TableRowSpan2$draw$3] */
    @Override // android.text.style.ReplacementSpan
    public void draw(final Canvas r20, CharSequence r21, int r22, int r23, float r24, int r25, int r26, int r27, Paint r28) {
        String r9 = "com.obric.memorydata.plugin";
        CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r21, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r20, "canvas");
        Intrinsics.checkParameterIsNotNull(r8, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        Intrinsics.checkParameterIsNotNull(r28, "p");
        if (this.h == false) goto L5;
        a(r8, r22, r23);
    L5:
        Paint r10 = this.e;
        if (this.n.c() == false) goto L9;
        int r11 = this.k.f;
    L12:
        r10.setColor(r11);
        this.e.setStyle(Paint.Style.FILL);
        int r12 = this.k.a(this.e);
        final Ref.FloatRef r13 = new Ref.FloatRef();
        r13.element = this.k.i();
        final Ref.FloatRef r14 = new Ref.FloatRef();
        r14.element = this.k.h();
        d r15 = this.k.l();
        if (r15 == null) goto L15;
        Drawable r2 = r15.a(r8, r22, r23);
    L17:
        if (this.e.getColor() == 0) goto L19;
    L23:
        int r3 = r20.save();
        this.f.setStroke(r12, this.k.f16522b);     // Catch: Throwable -> L86
        int r16 = (r27 - r25) + r12;     // Catch: Throwable -> L86
        this.f.setBounds(0, 0, d(), r16);     // Catch: Throwable -> L86
        if (this.n.a() != 0) goto L27;
        float r17 = this.k.i();     // Catch: Throwable -> L86
    L28:
        r13.element = r17;     // Catch: Throwable -> L86
        if (this.n.a() != CollectionsKt.getLastIndex(this.m)) goto L31;
        float r18 = this.k.h();     // Catch: Throwable -> L86
    L32:
        r14.element = r18;     // Catch: Throwable -> L86
        if (r13.element == 0.0f) goto L35;
    L38:
        this.f.setCornerRadii(new float[]{r13.element, r13.element, r13.element, r13.element, r14.element, r14.element, r14.element, r14.element});     // Catch: Throwable -> L86
    L39:
        this.f.setColor(this.e.getColor());     // Catch: Throwable -> L86
        r20.translate(r24, r25);     // Catch: Throwable -> L86
        this.f.draw(r20);     // Catch: Throwable -> L86
        if (r2 == null) goto L42;
        r2.setBounds(0, 0, d(), r16);     // Catch: Throwable -> L86
        r2.draw(r20);     // Catch: Throwable -> L86
    L42:
        r20.restoreToCount(r3);
    L43:
        this.e.set(r28);
        this.k.b(this.e);
        int r4 = r12 / 2;
        int r5 = r27 - r25;
        String r19 = r9;
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f16514b, Iterable.class, r19)).iterator();
        int r29 = 0;
        int r110 = 0;
    L45:
        if (r7.hasNext() == false) goto L60;
        Object r111 = r7.next();
        int r112 = r29 + 1;
        if (r29 >= 0) goto L49;
        CollectionsKt.throwIndexOverflow();
    L49:
        Iterator r210 = r7;
        Layout r30 = (Layout) ZeusTransformUtils.preCheckCast(r111, Layout.class, r19);
        int r113 = r20.save();
        String r114 = r19;
        int r31 = (int) r24;
        r20.clipRect(r31, r25, r31 + d(), r27);     // Catch: Throwable -> L56
        r20.translate((r110 + r24) + this.o.b(), r25);     // Catch: Throwable -> L56
        r110 = r110 + (r30.getWidth() + (this.k.b() * 2));     // Catch: Throwable -> L56
        if (r12 <= 0) goto L54;
        if (r29 == 0) goto L54;
        this.d.set(-r4, 0, r4, r5);     // Catch: Throwable -> L56
        r20.drawRect(this.d, this.e);     // Catch: Throwable -> L56
    L54:
        r20.translate(this.k.b(), this.k.a() + r12);     // Catch: Throwable -> L56
        r30.draw(r20);     // Catch: Throwable -> L56
        r20.restoreToCount(r113);
        r7 = r210;
        r19 = r114;
        r29 = r112;
    L56:
        th = move-exception;
        r20.restoreToCount(r113);
        throw th;
    L60:
        if (this.o.d() == false) goto L73;
        if (this.k.f() == 0) goto L73;
        if (this.k.h() == 0.0f) goto L73;
        ?? r6 = new TableRowSpan2$draw$3(this, r13, r14, r20);
        int r32 = r20.save();
        r20.translate(r24, r25);
        if (Math.abs(this.o.b()) <= 0.0f) goto L69;
        r6.invoke(true);
    L69:
        if (Math.abs(this.o.b()) >= this.o.c()) goto L71;
        r6.invoke(false);
    L71:
        r20.restoreToCount(r32);
    L73:
        if (this.n.a() == CollectionsKt.getLastIndex(this.m)) goto L75;
        return;
    L75:
        if (b() == true) goto L96;
        int r33 = r20.save();
        r20.translate(((-this.o.b()) / this.o.c()) * ((this.k.c() - this.j) - this.l.a()), (r27 - this.l.b()) - this.l.c());     // Catch: Throwable -> L82
        if (this.i.getBounds().left != 0) goto L80;
        this.i.getBounds().left += this.j;     // Catch: Throwable -> L82
        this.i.getBounds().right += this.j;     // Catch: Throwable -> L82
    L80:
        this.i.draw(r20);     // Catch: Throwable -> L82
        r20.restoreToCount(r33);
        return;
    L82:
        th = move-exception;
        r20.restoreToCount(r33);
        throw th;
    L96:
        return;
    L35:
        if (r14.element != 0.0f) goto L38;
        this.f.setCornerRadius(0.0f);     // Catch: Throwable -> L86
        goto L39
    L31:
        r18 = 0.0f;
        goto L32
    L27:
        r17 = 0.0f;
    L86:
        th = move-exception;
        r20.restoreToCount(r3);
        throw th;
    L19:
        if (this.k.f16522b != 0) goto L23;
        if (r2 != null) goto L23;
        r9 = "com.obric.memorydata.plugin";
        goto L43
    L15:
        r2 = null;
        goto L17
    L9:
        if ((this.n.a() % 2) != 1) goto L11;
        r11 = this.k.d;
        goto L12
    L11:
        r11 = this.k.e;
        goto L12
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint r3, CharSequence r4, int r5, int r6, Paint.FontMetricsInt r7) {
        CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r3, "paint");
        Intrinsics.checkParameterIsNotNull(r8, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        a(r8, r5, r6);
        io.noties.markwon.scrollable.b r9 = this.o;
        r9.b(Math.max(r9.c(), c() - (this.k.c() - this.j)));
        if (this.f16514b.size() <= 0) goto L19;
        if (r7 == null) goto L19;
        if (this.n.a() != CollectionsKt.getLastIndex(this.m)) goto L8;
        int r10 = Math.max(this.k.a(), MathKt.roundToInt(this.l.b() + this.l.c()));
    L9:
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(this.f16514b, Iterable.class, "com.obric.memorydata.plugin");
        Collection r12 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r13 = r11.iterator();
    L11:
        if (r13.hasNext() == false) goto L13;
        r12.add(Integer.valueOf(((Layout) ZeusTransformUtils.preCheckCast(r13.next(), Layout.class, "com.obric.memorydata.plugin")).getHeight()));
        goto L11
    L13:
        Integer r14 = (Integer) ZeusTransformUtils.preCheckCast(CollectionsKt.max((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")), Integer.class, "com.obric.memorydata.plugin");
        if (r14 == null) goto L16;
        int r15 = r14.intValue();
    L17:
        r7.ascent = -((r15 + this.k.a()) + r10);
        r7.descent = 0;
        r7.top = r7.ascent;
        r7.bottom = 0;
        this.h = false;
        goto L19
    L16:
        r15 = 0;
        goto L17
    L8:
        r10 = this.k.a();
    L19:
        return d();
    }

    @Override // android.text.SpanWatcher
    public void onSpanAdded(Spannable r1, Object r2, int r3, int r4) {
        Spannable r5 = (Spannable) ZeusTransformUtils.wrapperContextForParams(r1, Spannable.class, "com.obric.memorydata.plugin");
        a(r2);
    }

    @Override // android.text.SpanWatcher
    public void onSpanChanged(Spannable r1, Object r2, int r3, int r4, int r5, int r6) {
        Spannable r7 = (Spannable) ZeusTransformUtils.wrapperContextForParams(r1, Spannable.class, "com.obric.memorydata.plugin");
        a(r2);
    }

    @Override // android.text.SpanWatcher
    public void onSpanRemoved(Spannable r1, Object r2, int r3, int r4) {
        Spannable r5 = (Spannable) ZeusTransformUtils.wrapperContextForParams(r1, Spannable.class, "com.obric.memorydata.plugin");
        a(r2);
    }
}
