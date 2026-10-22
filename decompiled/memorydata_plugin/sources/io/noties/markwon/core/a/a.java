package io.noties.markwon.core.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.noties.markwon.core.CoreProps;
import io.noties.markwon.core.spans.o;
import io.noties.markwon.core.spans.p;
import io.noties.markwon.t;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u0011"}, d2 = {"Lio/noties/markwon/core/factory/BgListItemSpanFactory;", "Lio/noties/markwon/core/factory/ListItemSpanFactory;", "bgColor", "", "bgMargin", "bgRadius", "", "leading", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "Ljava/lang/Float;", "getSpans", "", "configuration", "Lio/noties/markwon/MarkwonConfiguration;", "props", "Lio/noties/markwon/RenderProps;", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class a extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Integer f16413a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Integer f16414b;
    private final Float c;
    private final Integer d;

    public a(Integer r1, Integer r2, Float r3, Integer r4) {
        this.f16413a = r1;
        this.f16414b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // io.noties.markwon.core.a.j, io.noties.markwon.w
    public Object a(io.noties.markwon.i r10, t r11) {
        t r12 = (t) ZeusTransformUtils.wrapperContextForParams(r11, t.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "configuration");
        Intrinsics.checkNotNullParameter(r12, "props");
        if (CoreProps.ListItemType.BULLET != CoreProps.f16408a.b(r12)) goto L6;
        return super.a(r10, r12);
    L6:
        if (this.f16413a != null) goto L8;
    L10:
        Object r9 = ZeusTransformUtils.preCheckCast(new p(r10.a(), null, ((Number) ZeusTransformUtils.preCheckCast(CoreProps.d.b(r12), Number.class, "com.obric.memorydata.plugin")).intValue() + ". ", 0, true), o.class, "com.obric.memorydata.plugin");
    L12:
        return (o) r9;
    L8:
        if (this.f16414b == null) goto L10;
        String r4 = new StringBuilder().append(((Number) ZeusTransformUtils.preCheckCast(CoreProps.d.b(r12), Number.class, "com.obric.memorydata.plugin")).intValue()).append(Typography.nbsp).toString();
        io.noties.markwon.core.c r3 = r10.a();
        Intrinsics.checkNotNullExpressionValue(r3, "configuration.theme()");
        r9 = ZeusTransformUtils.preCheckCast(new io.noties.markwon.core.spans.a(r3, r4, this.f16413a.intValue(), this.f16414b.intValue(), this.c, this.d), o.class, "com.obric.memorydata.plugin");
        goto L12
    }
}
