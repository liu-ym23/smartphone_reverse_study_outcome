package io.noties.markwon.html;

import com.bytedance.apm6.consumer.slardar.Constants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B9\b\u0000\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007H\u0014¨\u0006\u0012"}, d2 = {"Lio/noties/markwon/html/CustomHtmlPlugin;", "Lio/noties/markwon/html/HtmlPlugin3;", "handlerList", "", "Lcom/larus/business/markdown/api/depend/ICustomDataHandler;", "htmlCssStyleMap", "", "", "Lcom/larus/business/markdown/api/extplugin/html/HtmlCssStyle;", "darkMode", "", "(Ljava/util/List;Ljava/util/Map;Z)V", "visitHtml", "", "visitor", "Lio/noties/markwon/MarkwonVisitor;", "html", "Companion", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class e extends i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f16564a = null;
    private static boolean h;

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\t\u001a\u00020\n2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eJ2\u0010\t\u001a\u00020\n2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00112\u0006\u0010\u0014\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0015"}, d2 = {"Lio/noties/markwon/html/CustomHtmlPlugin$Companion;", "", "()V", "sHasHtml", "", "getSHasHtml", "()Z", "setSHasHtml", "(Z)V", "create", "Lio/noties/markwon/html/HtmlPlugin;", "configure", "Lio/noties/markwon/html/HtmlPlugin$HtmlConfigure;", Constants.KEY_LIST, "", "Lcom/larus/business/markdown/api/depend/ICustomDataHandler;", "htmlCssStyleMap", "", "", "Lcom/larus/business/markdown/api/extplugin/html/HtmlCssStyle;", "darkMode", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final h a(List<? extends com.larus.business.markdown.api.depend.a> r2, Map<String, com.larus.business.markdown.api.extplugin.b.a> r3, boolean r4) {
            List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
            Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "htmlCssStyleMap");
            return (h) ZeusTransformUtils.preCheckCast(new e(r1, r5, r4), h.class, "com.obric.memorydata.plugin");
        }

        public final void a(boolean r1) {
            e.a(r1);
        }

        public final boolean a() {
            return e.a();
        }
    }

    static {
        f16564a = new a(null);
    }

    public e(List<? extends com.larus.business.markdown.api.depend.a> r4, Map<String, com.larus.business.markdown.api.extplugin.b.a> r5, boolean r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        a((u) ZeusTransformUtils.preCheckCast(new s(r8, r6), u.class, "com.obric.memorydata.plugin"));
        a((u) ZeusTransformUtils.preCheckCast(new f(r8, r6), u.class, "com.obric.memorydata.plugin"));
        a((u) ZeusTransformUtils.preCheckCast(new l(r8, r6), u.class, "com.obric.memorydata.plugin"));
        a((u) ZeusTransformUtils.preCheckCast(new t(r8, r6), u.class, "com.obric.memorydata.plugin"));
        a((u) ZeusTransformUtils.preCheckCast(new w(r8, r6), u.class, "com.obric.memorydata.plugin"));
        a((u) ZeusTransformUtils.preCheckCast(new com.larus.business.markdown.impl.markwon.a.b(r7), u.class, "com.obric.memorydata.plugin"));
        a(SetsKt.setOf(new String[]{"data-block", "data-block-full"}));
        b(SetsKt.setOf(new String[]{"data-inline", "data-inline-no-margin"}));
    }

    public static final /* synthetic */ void a(boolean r0) {
        h = r0;
    }

    public static final /* synthetic */ boolean a() {
        return h;
    }

    @Override // io.noties.markwon.html.h
    public void a(io.noties.markwon.n r3, String r4) {
        io.noties.markwon.n r5 = (io.noties.markwon.n) ZeusTransformUtils.wrapperContextForParams(r3, io.noties.markwon.n.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "visitor");
        if (r4 != null) goto L5;
    L17:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L9
        super.a(r5, r4);     // Catch: Throwable -> L9
        Object r2 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L11:
        Throwable r6 = Result.m1424exceptionOrNullimpl(r2);
        if (r6 == null) goto L19;
        com.larus.business.markdown.api.depend.d r7 = com.larus.business.markdown.api.depend.e.a();
        if (r7 == null) goto L20;
        r7.a(r6, String.valueOf(r6.getMessage()));
        return;
    L20:
        return;
    L19:
        return;
    L9:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r2 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L11
    L5:
        if (h == true) goto L17;
        h = true;
        goto L17
    }
}
