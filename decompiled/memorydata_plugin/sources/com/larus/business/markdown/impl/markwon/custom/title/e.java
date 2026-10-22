package com.larus.business.markdown.impl.markwon.custom.title;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.noties.markwon.i;
import io.noties.markwon.t;
import io.noties.markwon.w;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u001a\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/custom/title/TableTitleSpanFactory;", "Lio/noties/markwon/SpanFactory;", "titleBgColor", "", "cornerRadius", "", "borderColor", "(IFI)V", "getSpans", "", "configuration", "Lio/noties/markwon/MarkwonConfiguration;", "props", "Lio/noties/markwon/RenderProps;", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class e implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f5238a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f5239b;
    private final int c;

    public e(int r1, float r2, int r3) {
        this.f5238a = r1;
        this.f5239b = r2;
        this.c = r3;
    }

    @Override // io.noties.markwon.w
    public Object a(i r9, t r10) {
        t r11 = (t) ZeusTransformUtils.wrapperContextForParams(r10, t.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "configuration");
        Intrinsics.checkNotNullParameter(r11, "props");
        io.noties.markwon.core.c r3 = r9.a();
        Intrinsics.checkNotNullExpressionValue(r3, "configuration.theme()");
        return new d(r3, this.f5239b, this.f5238a, (Integer) ZeusTransformUtils.preCheckCast(r11.a(f.a()), Integer.class, "com.obric.memorydata.plugin"), this.c);
    }
}
