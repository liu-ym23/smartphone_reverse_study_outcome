package com.larus.business.markdown.api.extplugin.latex;

import android.content.Context;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.larus.business.markdown.api.b.c;
import java.util.Map;
import kotlin.Metadata;
import org.commonmark.node.Node;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001c\u0010\u0006\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\u0012\u0004\u0012\u00020\n0\u0007H&J@\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH&J\u001a\u0010\u001b\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J\u0018\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\nH&J\u0010\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006 "}, d2 = {"Lcom/larus/business/markdown/api/extplugin/latex/ILatexPlugin;", "", "addOnParseErrorListener", "", "listener", "Lcom/larus/business/markdown/api/extplugin/latex/IOnLatexParseErrorListener;", "getNodeReportMap", "", "Ljava/lang/Class;", "Lorg/commonmark/node/Node;", "", "getPlugin", "Lio/noties/markwon/AbstractMarkwonPlugin;", "context", "Landroid/content/Context;", "latexGlobalConfig", "Lcom/larus/business/markdown/api/model/latex/LatexGlobalConfig;", "latexSingleConfig", "Lcom/larus/business/markdown/api/model/latex/LatexSingleConfig;", "latexMaxWidth", "", "drawablePool", "Lcom/larus/business/markdown/api/common/ReuseDrawablePoolNew;", "drawableLruPool", "Lcom/larus/business/markdown/api/common/FlowMarkdownReuseDrawablePool;", "clearDrawablePoolAfterRender", "", CommonConsts.APM_INNER_EVENT_COST_INIT, "modifyLatexMathBlockContent", "node", "latex", "removeOnParseErrorListener", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface a {
    io.noties.markwon.a a(Context r1, com.larus.business.markdown.api.model.a.a r2, com.larus.business.markdown.api.model.a.b r3, int r4, c r5, com.larus.business.markdown.api.b.b r6, boolean r7);

    Map<Class<? extends Node>, String> a();

    void a(Context r1, com.larus.business.markdown.api.model.a.a r2);

    void a(Node r1, String r2);
}
