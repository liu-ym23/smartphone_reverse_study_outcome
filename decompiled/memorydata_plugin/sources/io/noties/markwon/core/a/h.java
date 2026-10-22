package io.noties.markwon.core.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.noties.markwon.core.CoreProps;
import io.noties.markwon.t;
import io.noties.markwon.w;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\r"}, d2 = {"Lio/noties/markwon/core/factory/HeadingSpanFactory2;", "Lio/noties/markwon/SpanFactory;", "diffDp", "", "headingColor", "(ILjava/lang/Integer;)V", "Ljava/lang/Integer;", "getSpans", "", "configuration", "Lio/noties/markwon/MarkwonConfiguration;", "props", "Lio/noties/markwon/RenderProps;", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class h implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f16418a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Integer f16419b;

    public h(int r1, Integer r2) {
        this.f16418a = r1;
        this.f16419b = r2;
    }

    @Override // io.noties.markwon.w
    public Object a(io.noties.markwon.i r4, t r5) {
        t r6 = (t) ZeusTransformUtils.wrapperContextForParams(r5, t.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "configuration");
        Intrinsics.checkNotNullParameter(r6, "props");
        io.noties.markwon.core.c r7 = r4.a();
        Intrinsics.checkNotNullExpressionValue(r7, "configuration.theme()");
        Integer r8 = CoreProps.f.b(r6);
        Intrinsics.checkNotNullExpressionValue(r8, "HEADING_LEVEL.require(props)");
        return new io.noties.markwon.core.spans.l(r7, ((Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.memorydata.plugin")).intValue(), this.f16418a, this.f16419b);
    }
}
