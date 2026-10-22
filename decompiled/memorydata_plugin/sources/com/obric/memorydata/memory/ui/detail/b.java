package com.obric.memorydata.memory.ui.detail;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.style.CharacterStyle;
import android.util.TypedValue;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\u001c\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0017\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0005H\u0002¢\u0006\u0002\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/memory/ui/detail/BaseTagHandler;", "Lio/noties/markwon/html/TagHandler;", "<init>", "()V", "extractValue", "", LocationMonitorConst.TAG, "Lio/noties/markwon/html/HtmlTag;", "getClickHandler", "Lcom/obric/memorydata/markdown/custom/LinkClickHandler;", "extractExtra", "", "handle", "", "visitor", "Lio/noties/markwon/MarkwonVisitor;", "renderer", "Lio/noties/markwon/html/MarkwonHtmlRenderer;", "parseColor", "", "s", "(Ljava/lang/String;)Ljava/lang/Integer;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class b extends io.noties.markwon.html.u {
    public b() {
    }

    private final Integer a(String r1) {
        return Integer.valueOf(Color.parseColor(r1));
    L4:
        return null;
    }

    public abstract String a(io.noties.markwon.html.j r1);

    @Override // io.noties.markwon.html.u
    public void a(io.noties.markwon.n r12, io.noties.markwon.html.o r13, io.noties.markwon.html.j r14) {
        io.noties.markwon.n r15 = (io.noties.markwon.n) ZeusTransformUtils.wrapperContextForParams(r12, io.noties.markwon.n.class, "com.obric.memorydata.plugin");
        io.noties.markwon.html.j r16 = (io.noties.markwon.html.j) ZeusTransformUtils.wrapperContextForParams(r14, io.noties.markwon.html.j.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r15, "visitor");
        Intrinsics.checkNotNullParameter(r13, "renderer");
        Intrinsics.checkNotNullParameter(r16, LocationMonitorConst.TAG);
        String r3 = a(r16);
        Map<String, String> r17 = r16.e();
        Intrinsics.checkNotNullExpressionValue(r17, "attributes(...)");
        String r2 = (String) ZeusTransformUtils.preCheckCast(r17.get(TypedValues.Custom.S_COLOR), String.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L7;
        Integer r4 = a(r2);
        if (r4 == null) goto L7;
        int r0 = r4.intValue();
    L8:
        String r5 = (String) ZeusTransformUtils.preCheckCast(r17.get("weight"), String.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L12;
        r5 = (String) ZeusTransformUtils.preCheckCast(r17.get("tweight"), String.class, "com.obric.memorydata.plugin");
    L12:
        if (r5 == null) goto L23;
        String r6 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        Locale r7 = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(r7, "ROOT");
        String r8 = r6.toLowerCase(r7);
        Intrinsics.checkNotNullExpressionValue(r8, "toLowerCase(...)");
        if (Intrinsics.areEqual(r8, "bold") == false) goto L16;
    L15:
        boolean r9 = true;
    L22:
        boolean r10 = r9;
    L24:
        String r11 = (String) ZeusTransformUtils.preCheckCast(r17.get("ucolor"), String.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L27;
        Integer r18 = a(r11);
    L28:
        String r19 = (String) ZeusTransformUtils.preCheckCast(r17.get("ugap"), String.class, "com.obric.memorydata.plugin");
        if (r19 == null) goto L33;
        Integer r20 = StringsKt.toIntOrNull(r19);
        if (r20 == null) goto L33;
        int r21 = r20.intValue();
    L34:
        String r110 = (String) ZeusTransformUtils.preCheckCast(r17.get("uthickness"), String.class, "com.obric.memorydata.plugin");
        if (r110 == null) goto L39;
        Integer r111 = StringsKt.toIntOrNull(r110);
        if (r111 == null) goto L39;
        int r112 = r111.intValue();
    L40:
        com.obric.memorydata.markdown.custom.l r1 = new com.obric.memorydata.markdown.custom.l(r18, r112, r21);
        io.noties.markwon.x.a(r15.c(), new CharacterStyle[]{new com.obric.memorydata.markdown.custom.b(r3, Integer.valueOf(r0), r10, r1, b(r16), d()), r1}, r16.b(), r16.c());
        return;
    L39:
        r112 = MathKt.roundToInt(TypedValue.applyDimension(1, 1, Resources.getSystem().getDisplayMetrics()));
    L33:
        r21 = MathKt.roundToInt(TypedValue.applyDimension(1, 1, Resources.getSystem().getDisplayMetrics()));
        goto L34
    L27:
        r18 = null;
        goto L28
    L16:
        Integer r22 = StringsKt.toIntOrNull(r8);
        if (r22 != null) goto L19;
    L21:
        r9 = false;
        goto L22
    L19:
        if (((Number) ZeusTransformUtils.preCheckCast(r22, Number.class, "com.obric.memorydata.plugin")).intValue() < 600) goto L21;
    L23:
        r10 = false;
    L7:
        r0 = ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.oui_basic_text_1, TypedValues.Custom.S_COLOR, "oui_basic_text_1"));
        goto L8
    }

    public Map<String, String> b(io.noties.markwon.html.j r2) {
        Intrinsics.checkNotNullParameter((io.noties.markwon.html.j) ZeusTransformUtils.wrapperContextForParams(r2, io.noties.markwon.html.j.class, "com.obric.memorydata.plugin"), LocationMonitorConst.TAG);
        return MapsKt.emptyMap();
    }

    public abstract com.obric.memorydata.markdown.custom.d d();
}
