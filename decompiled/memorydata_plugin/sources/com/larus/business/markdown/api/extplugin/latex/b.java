package com.larus.business.markdown.api.extplugin.latex;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u001d\u0010\u0000\u001a\u0004\u0018\u00010\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"latexPluginDelegate", "Lcom/larus/business/markdown/api/extplugin/latex/ILatexPlugin;", "getLatexPluginDelegate", "()Lcom/larus/business/markdown/api/extplugin/latex/ILatexPlugin;", "latexPluginDelegate$delegate", "Lkotlin/Lazy;", "markdown-api_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Lazy f5154a = null;

    static {
        f5154a = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(ILatexPluginKt$latexPluginDelegate$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
    }

    public static final a a() {
        return (a) ZeusTransformUtils.preCheckCast(f5154a.getValue(), a.class, "com.obric.memorydata.plugin");
    }
}
