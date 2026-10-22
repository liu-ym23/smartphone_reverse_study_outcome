package io.noties.markwon.html;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B#\u0012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\"\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lio/noties/markwon/html/LinkWithCssHandler;", "Lio/noties/markwon/html/tag/LinkHandler;", "htmlCssStyleMap", "", "", "Lcom/larus/business/markdown/api/extplugin/html/HtmlCssStyle;", "darkMode", "", "(Ljava/util/Map;Z)V", "getSpans", "", "configuration", "Lio/noties/markwon/MarkwonConfiguration;", "renderProps", "Lio/noties/markwon/RenderProps;", LocationMonitorConst.TAG, "Lio/noties/markwon/html/HtmlTag;", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class l extends io.noties.markwon.html.tag.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, com.larus.business.markdown.api.extplugin.b.a> f16596a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f16597b;

    public l(Map<String, com.larus.business.markdown.api.extplugin.b.a> r3, boolean r4) {
        this.f16596a = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        this.f16597b = r4;
    }

    @Override // io.noties.markwon.html.tag.g, io.noties.markwon.html.tag.i
    public Object a(io.noties.markwon.i r3, io.noties.markwon.t r4, j r5) {
        io.noties.markwon.t r6 = (io.noties.markwon.t) ZeusTransformUtils.wrapperContextForParams(r4, io.noties.markwon.t.class, "com.obric.memorydata.plugin");
        j r7 = (j) ZeusTransformUtils.wrapperContextForParams(r5, j.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "configuration");
        Intrinsics.checkNotNullParameter(r6, "renderProps");
        Intrinsics.checkNotNullParameter(r7, LocationMonitorConst.TAG);
        Object r8 = super.a(r3, r6, r7);
        Object[] r2 = b.f16558a.a(r7, this.f16596a, this.f16597b);
        return b.f16558a.a(r8, r2);
    }
}
