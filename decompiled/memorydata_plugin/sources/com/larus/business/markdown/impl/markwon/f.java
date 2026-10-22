package com.larus.business.markdown.impl.markwon;

import android.content.Context;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.noties.markwon.q;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a)\u0010\f\u001a\u00020\u00022\b\b\u0001\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0002\u0010\u0012\u001a\u000e\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015\u001aA\u0010\u0016\u001a\u00020\u0017*\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u001e\u0018\u00010\n¢\u0006\u0002\u0010\u001f\u001aA\u0010 \u001a\u00020\u0017*\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u001e\u0018\u00010\n¢\u0006\u0002\u0010\u001f\"\u001f\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u001f\u0010\u0006\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00070\u00070\u0001¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0005\"/\u0010\t\u001a \u0012\u001c\u0012\u001a\u0012\u0002\b\u0003\u0012\u0002\b\u0003 \u0003*\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\n0\n0\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0005¨\u0006!"}, d2 = {"PROP_MAX_CONTENT_WIDTH", "Lio/noties/markwon/Prop;", "", "kotlin.jvm.PlatformType", "getPROP_MAX_CONTENT_WIDTH", "()Lio/noties/markwon/Prop;", "PROP_MD_REUSE_CHAR_SEQUENCE", "", "getPROP_MD_REUSE_CHAR_SEQUENCE", "PROP_PAYLOAD", "", "getPROP_PAYLOAD", "getSpecifyModeColor", TypedValues.Custom.S_COLOR, "originContext", "Landroid/content/Context;", "specifyDarkMode", "", "(ILandroid/content/Context;Ljava/lang/Boolean;)I", "isLastCharacterChinese", "input", "", "createMarkwonStruct", "Lcom/larus/business/markdown/impl/markwon/MarkwonStruct;", "markdownConfigManager", "Lcom/larus/business/markdown/impl/common/MarkdownConfigManager;", "maxContentWidth", "customMarkDownInfo", "Lcom/larus/business/markdown/api/model/CustomMarkDownInfo;", "payload", "", "(Landroid/content/Context;Lcom/larus/business/markdown/impl/common/MarkdownConfigManager;Ljava/lang/Integer;Lcom/larus/business/markdown/api/model/CustomMarkDownInfo;Ljava/util/Map;)Lcom/larus/business/markdown/impl/markwon/MarkwonStruct;", "createStreamMarkwonStruct", "markdown-impl_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final q<Integer> f5246a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final q<CharSequence> f5247b = null;
    private static final q<Map<?, ?>> c = null;

    static {
        q<Integer> r0 = q.a(Integer.TYPE, "max_content_width");
        Intrinsics.checkNotNullExpressionValue(r0, "of(Int::class.java, \"max_content_width\")");
        f5246a = r0;
        q<CharSequence> r1 = q.a(CharSequence.class, "md-reuse-char-sequence");
        Intrinsics.checkNotNullExpressionValue(r1, "of(CharSequence::class.j…\"md-reuse-char-sequence\")");
        f5247b = r1;
        q<Map<?, ?>> r2 = q.a(Map.class, "md-payload");
        Intrinsics.checkNotNullExpressionValue(r2, "of(Map::class.java, \"md-payload\")");
        c = r2;
    }

    public static final g a(Context r9, com.larus.business.markdown.impl.common.a r10, Integer r11, com.larus.business.markdown.api.model.c r12, Map<String, ? extends Object> r13) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r13, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r10, "markdownConfigManager");
        Intrinsics.checkNotNullParameter(r12, "customMarkDownInfo");
        return new g(r3, r10, false, r12, r11, r8);
    }

    public static /* synthetic */ g a(Context r1, com.larus.business.markdown.impl.common.a r2, Integer r3, com.larus.business.markdown.api.model.c r4, Map r5, int r6, Object r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.memorydata.plugin");
        Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        if ((r6 & 2) == 0) goto L6;
        r3 = null;
    L6:
        return a(r8, r2, r3, r4, r9);
    }

    public static final q<Integer> a() {
        return f5246a;
    }

    public static final boolean a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "input");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return false;
    L8:
        char r5 = StringsKt.last((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin"));
        if (19968 <= r5) goto L11;
    L13:
        boolean r1 = false;
    L14:
        if (r1 == false) goto L16;
        return true;
    L16:
        if (13312 <= r5) goto L18;
    L20:
        boolean r2 = false;
    L21:
        if (r2 == false) goto L23;
        return true;
    L23:
        if (0 <= r5) goto L25;
    L27:
        boolean r6 = false;
    L28:
        if (r6 == false) goto L31;
        return true;
    L31:
        return false;
    L25:
        if (r5 >= 42720) goto L27;
        r6 = true;
        goto L28
    L18:
        if (r5 >= 19904) goto L20;
        r2 = true;
        goto L21
    L11:
        if (r5 >= 40960) goto L13;
        r1 = true;
        goto L14
    L5:
        r0 = false;
        goto L6
    }

    public static final g b(Context r9, com.larus.business.markdown.impl.common.a r10, Integer r11, com.larus.business.markdown.api.model.c r12, Map<String, ? extends Object> r13) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r13, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r10, "markdownConfigManager");
        Intrinsics.checkNotNullParameter(r12, "customMarkDownInfo");
        return new g(r3, r10, true, r12, r11, r8);
    }

    public static final q<CharSequence> b() {
        return f5247b;
    }

    public static final q<Map<?, ?>> c() {
        return c;
    }
}
