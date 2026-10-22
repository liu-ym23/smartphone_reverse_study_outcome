package com.larus.business.markdown.impl.markwon.a;

import android.text.Spanned;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.entity.EventBody;
import com.larus.business.markdown.impl.markwon.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.noties.markwon.core.CoreProps;
import io.noties.markwon.html.g;
import io.noties.markwon.html.j;
import io.noties.markwon.html.o;
import io.noties.markwon.html.u;
import io.noties.markwon.n;
import io.noties.markwon.x;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0003H\u0016R\u0016\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/customdata/CustomDataTagHandler;", "Lio/noties/markwon/html/TagHandler;", "handlerList", "", "Lcom/larus/business/markdown/api/depend/ICustomDataHandler;", "(Ljava/util/List;)V", "handle", "", "visitor", "Lio/noties/markwon/MarkwonVisitor;", "renderer", "Lio/noties/markwon/html/MarkwonHtmlRenderer;", LocationMonitorConst.TAG, "Lio/noties/markwon/html/HtmlTag;", "replaceTag", "", "emptyReplacement", "Lio/noties/markwon/html/HtmlEmptyTagReplacement;", "supportedTags", "", "Companion", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class b extends u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f5189a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<com.larus.business.markdown.api.depend.a> f5190b;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/customdata/CustomDataTagHandler$Companion;", "", "()V", "ALT_ATTRIBUTE", "", "EXTRA_ATTRIBUTE", "TYPE_ATTRIBUTE", "VALUE_ATTRIBUTE", "VALUE_ID_ATTRIBUTE", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f5189a = new a(null);
    }

    public b(List<? extends com.larus.business.markdown.api.depend.a> r3) {
        this.f5190b = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    }

    @Override // io.noties.markwon.html.u
    public CharSequence a(j r5, g r6) {
        j r4 = (j) ZeusTransformUtils.wrapperContextForParams(r5, j.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r6, "emptyReplacement");
        String r7 = (String) ZeusTransformUtils.preCheckCast(r4.e().get("alt"), String.class, "com.obric.memorydata.plugin");
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin");
        boolean r2 = false;
        if (r1 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == false) goto L11;
        r7 = r6.a(r4);
    L11:
        CharSequence r8 = (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L14;
    L15:
        r2 = true;
    L16:
        if (r2 == false) goto L19;
        r7 = " ";
    L19:
        return (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin");
    L14:
        if (r8.length() != 0) goto L16;
    L5:
        if (r1.length() == 0) goto L8;
        r3 = false;
        goto L9
    }

    public List<String> a() {
        return CollectionsKt.listOf(new String[]{"data-block", "data-inline", "data-inline-no-margin", "data-block-full"});
    }

    @Override // io.noties.markwon.html.u
    public void a(n r23, o r24, j r25) {
        n r1 = (n) ZeusTransformUtils.wrapperContextForParams(r23, n.class, "com.obric.memorydata.plugin");
        j r3 = (j) ZeusTransformUtils.wrapperContextForParams(r25, j.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "visitor");
        Intrinsics.checkNotNullParameter(r24, "renderer");
        Intrinsics.checkNotNullParameter(r3, LocationMonitorConst.TAG);
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.e().get("type"), String.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        String r5 = (String) ZeusTransformUtils.preCheckCast(r3.e().get(EventBody.KEY_VALUE), String.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L8;
        String r7 = "";
    L9:
        String r6 = (String) ZeusTransformUtils.preCheckCast(r3.e().get("value_id"), String.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L12;
        String r8 = "";
    L13:
        String r9 = (String) ZeusTransformUtils.preCheckCast(r3.e().get(WsConstants.KEY_EXTRA), String.class, "com.obric.memorydata.plugin");
        Integer r10 = (Integer) ZeusTransformUtils.preCheckCast(r1.b().a(f.a()), Integer.class, "com.obric.memorydata.plugin");
        if (r10 != null) goto L16;
        return;
    L16:
        int r13 = ((Number) ZeusTransformUtils.preCheckCast(r10, Number.class, "com.obric.memorydata.plugin")).intValue();
        Object r11 = r1.b().a(f.c());
        if (ZeusTransformUtils.instanceOf(r11, Map.class) == false) goto L19;
        Map<String, ? extends Object> r15 = (Map) ZeusTransformUtils.preCheckCast(r11, Map.class, "com.obric.memorydata.plugin");
    L20:
        CharSequence r12 = (CharSequence) ZeusTransformUtils.preCheckCast(r1.b().a(f.b()), CharSequence.class, "com.obric.memorydata.plugin");
        List<com.larus.business.markdown.api.depend.a> r14 = this.f5190b;
        if (r14 == null) goto L88;
        Iterator r16 = ((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L24:
        if (r16.hasNext() == false) goto L28;
        Object r17 = r16.next();
        if (((com.larus.business.markdown.api.depend.a) ZeusTransformUtils.preCheckCast(r17, com.larus.business.markdown.api.depend.a.class, "com.obric.memorydata.plugin")).a(r4) == false) goto L24;
    L29:
        com.larus.business.markdown.api.depend.a r18 = (com.larus.business.markdown.api.depend.a) ZeusTransformUtils.preCheckCast(r17, com.larus.business.markdown.api.depend.a.class, "com.obric.memorydata.plugin");
        if (r18 != null) goto L32;
        return;
    L32:
        if (ZeusTransformUtils.instanceOf(r12, Spanned.class) == false) goto L34;
        Spanned r19 = (Spanned) ZeusTransformUtils.preCheckCast(r12, Spanned.class, "com.obric.memorydata.plugin");
    L36:
        if (r19 == null) goto L66;
        com.larus.business.markdown.impl.markwon.a.a[] r20 = (com.larus.business.markdown.impl.markwon.a.a[]) ZeusTransformUtils.preCheckCast(r19.getSpans(r3.b(), r3.c(), com.larus.business.markdown.impl.markwon.a.a.class), com.larus.business.markdown.impl.markwon.a.a[].class, "com.obric.memorydata.plugin");
        if (r20 == null) goto L64;
        int r21 = r20.length;
        int r110 = 0;
    L40:
        if (r110 >= r21) goto L61;
        com.larus.business.markdown.impl.markwon.a.a r111 = r20[r110];
        if (Intrinsics.areEqual(r111.a(), r4) == true) goto L44;
    L56:
        com.larus.business.markdown.impl.markwon.a.a[] r26 = r20;
    L57:
        boolean r22 = false;
    L58:
        if (r22 == true) goto L62;
        r110 = r110 + 1;
        r20 = r26;
    L62:
        if (r111 == null) goto L64;
        r111.a(r13, r15);
        com.larus.business.markdown.impl.markwon.a.a r112 = r111;
    L65:
        if (r112 == null) goto L66;
    L74:
        x.a(r1.c(), r112, r3.b(), r3.c());
        HashMap r0 = (HashMap) ZeusTransformUtils.preCheckCast(CoreProps.j.a(r1.b()), HashMap.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L78;
        Integer r2 = (Integer) ZeusTransformUtils.preCheckCast(r0.get(r4), Integer.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L78;
    L79:
        int r27 = r2.intValue() + 1;
        if (r0 == null) goto L90;
        Integer r28 = (Integer) ZeusTransformUtils.preCheckCast(r0.put(r4, Integer.valueOf(r27)), Integer.class, "com.obric.memorydata.plugin");
        return;
    L90:
        return;
    L78:
        r2 = 0;
        goto L79
    L44:
        if (Intrinsics.areEqual(r111.b(), r7) == false) goto L56;
        if (Intrinsics.areEqual(r111.c(), r8) == false) goto L56;
        r26 = r20;
        if (r111.e() != r3.b()) goto L57;
        if (r111.f() != r3.c()) goto L57;
        if (r111.g() == true) goto L57;
        if (Intrinsics.areEqual(r111.d(), r3.a()) == false) goto L57;
        r22 = true;
        goto L58
    L61:
        r111 = null;
    L64:
        r112 = null;
    L66:
        b r29 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin");
        String r113 = r3.a();
        Intrinsics.checkNotNullExpressionValue(r113, "tag.name()");
        int r114 = r3.b();
        int r115 = r3.c();
        if (Intrinsics.areEqual(r3.a(), "data-inline-no-margin") == false) goto L69;
    L72:
        boolean r116 = true;
    L73:
        r112 = new com.larus.business.markdown.impl.markwon.a.a(r4, r7, r8, r9, r113, r114, r115, r13, r18, r15, r116, false, 2048, null);
        goto L74
    L69:
        if (Intrinsics.areEqual(r4, "creation") == true) goto L72;
        r116 = false;
        goto L73
    L34:
        r19 = null;
        goto L36
    L28:
        r17 = null;
        goto L29
    L88:
        return;
    L19:
        r15 = null;
        goto L20
    L12:
        r8 = r6;
        goto L13
    L8:
        r7 = r5;
        goto L9
    }

    @Override // io.noties.markwon.html.u
    public /* synthetic */ Collection b() {
        return (Collection) ZeusTransformUtils.preCheckCast(a(), Collection.class, "com.obric.memorydata.plugin");
    }
}
