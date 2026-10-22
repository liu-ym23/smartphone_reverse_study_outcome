package io.noties.markwon.html.tag;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.style.ClickableSpan;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.noties.markwon.core.CoreProps;
import io.noties.markwon.html.o;
import io.noties.markwon.t;
import io.noties.markwon.w;
import io.noties.markwon.x;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import org.commonmark.node.Link;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 \u001b2\u00020\u0001:\u0003\u001a\u001b\u001cB-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J \u0010\u0013\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0019H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lio/noties/markwon/html/tag/ImageGridHandler;", "Lio/noties/markwon/html/tag/ImageHandler;", "context", "Landroid/content/Context;", "drawablePool", "Lio/noties/markwon/pool/ReuseDrawablePool;", "maxWidth", "", "requireLineBreak", "", "(Landroid/content/Context;Lio/noties/markwon/pool/ReuseDrawablePool;IZ)V", "addLink", "", "visitor", "Lio/noties/markwon/MarkwonVisitor;", LocationMonitorConst.TAG, "Lio/noties/markwon/html/HtmlTag;", "href", "", "handle", "renderer", "Lio/noties/markwon/html/MarkwonHtmlRenderer;", "replaceTag", "", "emptyReplacement", "Lio/noties/markwon/html/HtmlEmptyTagReplacement;", "BottomAlignDrawableSpan", "Companion", "ThumbnailDrawable", "markwon-html_release"}, k = 1, mv = {1, 1, 15})
public class d extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f16615a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f16616b;
    private final io.noties.markwon.e.a c;
    private final int d;
    private final boolean e;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ4\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016¨\u0006\u0014"}, d2 = {"Lio/noties/markwon/html/tag/ImageGridHandler$BottomAlignDrawableSpan;", "Lio/noties/markwon/image/AsyncDrawableSpan;", "theme", "Lio/noties/markwon/core/MarkwonTheme;", "drawable", "Lio/noties/markwon/image/AsyncDrawable;", "alignment", "", "replacementTextIsLink", "", "(Lio/noties/markwon/core/MarkwonTheme;Lio/noties/markwon/image/AsyncDrawable;IZ)V", "getSize", "paint", "Landroid/graphics/Paint;", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", CommonConsts.APM_INNER_EVENT_COST_START, "end", "fm", "Landroid/graphics/Paint$FontMetricsInt;", "markwon-html_release"}, k = 1, mv = {1, 1, 15})
    public static class a extends io.noties.markwon.a.d {
        public a(io.noties.markwon.core.c r2, io.noties.markwon.a.a r3, int r4, boolean r5) {
            Intrinsics.checkParameterIsNotNull(r2, "theme");
            Intrinsics.checkParameterIsNotNull(r3, "drawable");
            super(r2, r3, r4, r5);
        }

        @Override // io.noties.markwon.a.d, android.text.style.ReplacementSpan
        public int getSize(Paint r7, CharSequence r8, int r9, int r10, Paint.FontMetricsInt r11) {
            CharSequence r2 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r8, CharSequence.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r7, "paint");
            if (a().g() == false) goto L14;
            io.noties.markwon.a.a r6 = a();
            Intrinsics.checkExpressionValueIsNotNull(r6, "drawable");
            Rect r12 = r6.getBounds();
            Intrinsics.checkExpressionValueIsNotNull(r12, "drawable.bounds");
            if (r11 == null) goto L12;
            Paint.FontMetricsInt r13 = r7.getFontMetricsInt();
            int r14 = r13.descent - r13.ascent;
            if (r12.height() <= r14) goto L9;
            r11.descent = r13.descent;
            int r15 = (-r12.height()) + r11.descent;
        L10:
            r11.ascent = r15;
            r11.bottom = r11.descent;
            r11.top = r11.ascent;
            goto L12
        L9:
            float r16 = (r12.height() * 1.0f) / r14;
            r11.descent = MathKt.roundToInt(r13.descent * r16);
            r15 = MathKt.roundToInt(r13.ascent * r16);
        L12:
            return r12.width();
        L14:
            return super.getSize(r7, r2, r9, r10, r11);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lio/noties/markwon/html/tag/ImageGridHandler$Companion;", "", "()V", "Height", "", com.tom_roush.pdfbox.pdmodel.a.d.i.j, "ItemGap", "LargeImage", "SpanCount", "Src", "State", "State_PlaceHolder", "Width", "markwon-html_release"}, k = 1, mv = {1, 1, 15})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0016\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u0006¢\u0006\u0002\u0010\u000eR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0015\u0010\u0010¨\u0006\u0016"}, d2 = {"Lio/noties/markwon/html/tag/ImageGridHandler$ThumbnailDrawable;", "Lio/noties/markwon/image/AsyncGridDrawable;", "thumbnail", "", "largeImage", "width", "", "height", "loader", "Lio/noties/markwon/image/AsyncDrawableLoader;", "spanCount", "index", "margin", "maxWidth", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lio/noties/markwon/image/AsyncDrawableLoader;IIII)V", "getHeight", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getLargeImage", "()Ljava/lang/String;", "getThumbnail", "getWidth", "markwon-html_release"}, k = 1, mv = {1, 1, 15})
    public static class c extends io.noties.markwon.a.e {
        private final String g;
        private final String h;
        private final Integer i;
        private final Integer j;

        public c(String r11, String r12, Integer r13, Integer r14, io.noties.markwon.a.b r15, int r16, int r17, int r18, int r19) {
            Intrinsics.checkParameterIsNotNull(r11, "thumbnail");
            Intrinsics.checkParameterIsNotNull(r12, "largeImage");
            Intrinsics.checkParameterIsNotNull(r15, "loader");
            super(r11, r15, r16, r17, r18, r19);
            this.g = r11;
            this.h = r12;
            this.i = r13;
            this.j = r14;
        }

        public final String a() {
            return this.g;
        }
    }

    static {
        f16615a = new b(null);
    }

    private final void a(io.noties.markwon.n r7, io.noties.markwon.html.j r8, String r9) {
        io.noties.markwon.n r6 = (io.noties.markwon.n) ZeusTransformUtils.wrapperContextForParams(r7, io.noties.markwon.n.class, "com.obric.memorydata.plugin");
        io.noties.markwon.html.j r10 = (io.noties.markwon.html.j) ZeusTransformUtils.wrapperContextForParams(r8, io.noties.markwon.html.j.class, "com.obric.memorydata.plugin");
        w r11 = r6.a().f().a(Link.class);
        List<x.a> r1 = r6.c().a(r10.b(), r10.c());
        Intrinsics.checkExpressionValueIsNotNull(r1, "visitor.builder().getSpans(tag.start(), tag.end())");
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, Collection.class) == true) goto L5;
    L7:
        Iterator r3 = r2.iterator();
    L9:
        if (r3.hasNext() == false) goto L6;
        if ((!ZeusTransformUtils.instanceOf(((x.a) ZeusTransformUtils.preCheckCast(r3.next(), x.a.class, "com.obric.memorydata.plugin")).f16695a, ClickableSpan.class)) == true) goto L9;
        boolean r0 = false;
    L13:
        if (r11 == null) goto L20;
        if (r0 == false) goto L21;
        t r4 = r6.b();
        Intrinsics.checkExpressionValueIsNotNull(r4, "visitor.renderProps()");
        CoreProps.g.b(r4, r9);
        CoreProps.h.b(r4, MapsKt.mapOf(new Pair[]{TuplesKt.to("type", "image"), TuplesKt.to(CommonConsts.APM_INNER_EVENT_COST_START, String.valueOf(r10.b())), TuplesKt.to("end", String.valueOf(r10.c()))}));
        x.a(r6.c(), r11.a(r6.a(), r4), r10.b(), r10.c());
        CoreProps.h.c(r4);
        return;
    L21:
        return;
    L20:
        return;
    L6:
        r0 = true;
        goto L13
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L7;
        goto L6
    }

    public static final /* synthetic */ void b(io.noties.markwon.n r2, o r3, io.noties.markwon.html.j.a r4) {
        e.a((io.noties.markwon.n) ZeusTransformUtils.wrapperContextForParams(r2, io.noties.markwon.n.class, "com.obric.memorydata.plugin"), r3, (io.noties.markwon.html.j.a) ZeusTransformUtils.wrapperContextForParams(r4, io.noties.markwon.html.j.a.class, "com.obric.memorydata.plugin"));
    }

    @Override // io.noties.markwon.html.u
    public CharSequence a(io.noties.markwon.html.j r7, io.noties.markwon.html.g r8) {
        io.noties.markwon.html.j r9 = (io.noties.markwon.html.j) ZeusTransformUtils.wrapperContextForParams(r7, io.noties.markwon.html.j.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r9, LocationMonitorConst.TAG);
        Intrinsics.checkParameterIsNotNull(r8, "emptyReplacement");
        if (this.e == false) goto L35;
        Map<String, String> r0 = r9.e();
        Intrinsics.checkExpressionValueIsNotNull(r0, "tag.attributes()");
        String r2 = r9.f();
        Intrinsics.checkExpressionValueIsNotNull(r2, "tag.textContent()");
        String r3 = (String) ZeusTransformUtils.preCheckCast(r0.get("index"), String.class, "com.obric.memorydata.plugin");
        boolean r4 = false;
        if (r3 == null) goto L9;
        Integer r5 = StringsKt.toIntOrNull(r3);
        if (r5 == null) goto L9;
        int r6 = r5.intValue();
    L10:
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.get("maxnuminline"), String.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L15;
        Integer r10 = StringsKt.toIntOrNull(r1);
        if (r10 == null) goto L15;
        int r11 = r10.intValue();
    L16:
        if (r11 <= 0) goto L35;
        if (r6 == 0) goto L35;
        if ((r6 % r11) != 0) goto L35;
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L30;
        String r12 = r8.a(r9);
        CharSequence r13 = (CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin");
        if (r13 != null) goto L25;
    L26:
        r4 = true;
    L27:
        if (r4 == false) goto L29;
        String r14 = "\n￼";
    L33:
        return (CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin");
    L29:
        StringBuilder r15 = new StringBuilder().append('\n').append(r12);
    L31:
        r14 = r15.toString();
        goto L33
    L25:
        if (StringsKt.isBlank(r13) == false) goto L27;
    L30:
        r15 = new StringBuilder().append('\n').append(r2);
    L15:
        r11 = 0;
    L9:
        r6 = 0;
    L35:
        return super.a(r9, r8);
    }

    @Override // io.noties.markwon.html.tag.i, io.noties.markwon.html.u
    public void a(io.noties.markwon.n r20, o r21, io.noties.markwon.html.j r22) {
        io.noties.markwon.n r2 = (io.noties.markwon.n) ZeusTransformUtils.wrapperContextForParams(r20, io.noties.markwon.n.class, "com.obric.memorydata.plugin");
        io.noties.markwon.html.j r4 = (io.noties.markwon.html.j) ZeusTransformUtils.wrapperContextForParams(r22, io.noties.markwon.html.j.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r2, "visitor");
        Intrinsics.checkParameterIsNotNull(r21, "renderer");
        Intrinsics.checkParameterIsNotNull(r4, LocationMonitorConst.TAG);
        Map<String, String> r5 = r4.e();
        Intrinsics.checkExpressionValueIsNotNull(r5, "tag.attributes()");
        String r6 = (String) ZeusTransformUtils.preCheckCast(r5.get("maxnuminline"), String.class, "com.obric.memorydata.plugin");
        Integer r7 = null;
        if (r6 == null) goto L5;
        final Integer r8 = StringsKt.toIntOrNull(r6);
    L6:
        String r9 = (String) ZeusTransformUtils.preCheckCast(r5.get("src"), String.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L9;
        final String r10 = r2.a().e().a(r9);
    L10:
        if (r8 != null) goto L12;
    L49:
        super.a(r2, r21, r4);
        if (r10 == null) goto L56;
        a(r2, r4, r10);
        return;
    L56:
        return;
    L12:
        if (r8.intValue() <= 0) goto L49;
        if (r4.g() == false) goto L16;
        b(r2, r21, r4.h());
    L16:
        String r1 = (String) ZeusTransformUtils.preCheckCast(r5.get("imgurl"), String.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L19;
        String r3 = r2.a().e().a(r1);
    L20:
        String r11 = (String) ZeusTransformUtils.preCheckCast(r5.get("index"), String.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L25;
        Integer r12 = StringsKt.toIntOrNull(r11);
        if (r12 == null) goto L25;
        final int r13 = r12.intValue();
    L26:
        io.noties.markwon.g.c r14 = io.noties.markwon.g.c.a(this.f16616b);
        String r15 = (String) ZeusTransformUtils.preCheckCast(r5.get("itemgap"), String.class, "com.obric.memorydata.plugin");
        if (r15 == null) goto L31;
        Integer r16 = StringsKt.toIntOrNull(r15);
        if (r16 == null) goto L31;
        int r17 = r16.intValue();
    L32:
        int r18 = r14.a(r17);
        String r19 = (String) ZeusTransformUtils.preCheckCast(r5.get("imgwidth"), String.class, "com.obric.memorydata.plugin");
        if (r19 == null) goto L35;
        Integer r110 = StringsKt.toIntOrNull(r19);
    L36:
        String r23 = (String) ZeusTransformUtils.preCheckCast(r5.get("imgheight"), String.class, "com.obric.memorydata.plugin");
        if (r23 == null) goto L39;
        r7 = StringsKt.toIntOrNull(r23);
    L39:
        Integer r111 = r7;
        final boolean r24 = Intrinsics.areEqual((String) ZeusTransformUtils.preCheckCast(r5.get("state"), String.class, "com.obric.memorydata.plugin"), "1");
        if (r10 == null) goto L53;
        if (r3 == null) goto L54;
        io.noties.markwon.e.a r25 = this.c;
        if (r25 == null) goto L47;
        io.noties.markwon.a.a r26 = r25.a((Function1) ZeusTransformUtils.preCheckCast(new ImageGridHandler$handle$drawable$1(r10, r8, r13, r24), Function1.class, "com.obric.memorydata.plugin"));
        if (r26 == null) goto L47;
    L48:
        r26.a(r24);
        io.noties.markwon.core.c r27 = r2.a().a();
        Intrinsics.checkExpressionValueIsNotNull(r27, "visitor.configuration().theme()");
        x.a(r2.c(), new a(r27, r26, 0, r15), r4.b(), r4.c());
        a(r2, r4, r3);
        return;
    L47:
        io.noties.markwon.a.b r112 = r2.a().b();
        Intrinsics.checkExpressionValueIsNotNull(r112, "visitor.configuration().asyncDrawableLoader()");
        r26 = (io.noties.markwon.a.a) ZeusTransformUtils.preCheckCast(new c(r10, r3, r110, r111, r112, r8.intValue(), r13, r18, this.d), io.noties.markwon.a.a.class, "com.obric.memorydata.plugin");
        goto L48
    L54:
        return;
    L53:
        return;
    L35:
        r110 = null;
    L31:
        r17 = 0;
    L25:
        r13 = 0;
        goto L26
    L19:
        r3 = r10;
        goto L20
    L9:
        r10 = null;
        goto L10
    L5:
        r8 = null;
        goto L6
    }
}
