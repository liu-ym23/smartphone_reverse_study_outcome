package com.larus.business.markdown.api.depend;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u001d\u0010\u0000\u001a\u0004\u0018\u00010\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"markdownLoggerDelegate", "Lcom/larus/business/markdown/api/depend/IMarkdownLogger;", "getMarkdownLoggerDelegate", "()Lcom/larus/business/markdown/api/depend/IMarkdownLogger;", "markdownLoggerDelegate$delegate", "Lkotlin/Lazy;", "markdown-api_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Lazy f5148a = null;

    static {
        f5148a = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(IMarkdownLoggerKt$markdownLoggerDelegate$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
    }

    public static final f a() {
        return (f) ZeusTransformUtils.preCheckCast(f5148a.getValue(), f.class, "com.obric.memorydata.plugin");
    }
}
