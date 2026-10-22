package com.larus.business.markdown.api.depend;

import com.larus.business.markdown.api.model.j;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\u000f\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\nJ\n\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0016J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0016\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0015H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0003H\u0016J\b\u0010\u001b\u001a\u00020\u0003H\u0016J\b\u0010\u001c\u001a\u00020\u0003H\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\tH\u0016J\b\u0010 \u001a\u00020\u0003H\u0016¨\u0006!"}, d2 = {"Lcom/larus/business/markdown/api/depend/IMarkdownSettings;", "", "clearDrawablePoolAfterRender", "", "enableCMarkParser", "enableHtmlNameEntityOptimize", "enableNewCodeStyle", "enableOptimizeWidgetCompare", "getAutoLinkMaxLimit", "", "()Ljava/lang/Integer;", "getCitationHandler", "Lcom/larus/business/markdown/api/citation/ICitationHandler;", "getCustomCodeHandler", "Lcom/larus/business/markdown/api/extplugin/code/ICustomCodeHandler;", "getCustomDataHandlers", "", "Lcom/larus/business/markdown/api/depend/ICustomDataHandler;", "getCustomImgHandler", "Lcom/larus/business/markdown/api/extplugin/image/ICustomImgHandler;", "getHtmlStyleClass", "", "", "Lcom/larus/business/markdown/api/extplugin/html/HtmlCssStyle;", "getSyntaxErrorCoverConfig", "Lcom/larus/business/markdown/api/model/SyntaxErrorCoverConfig;", "isMarkdownListBlockOptimized", "isMarkdownStreamOptimized", "isMarkdownStringStreamOptimized", "latexGlobalConfig", "Lcom/larus/business/markdown/api/model/latex/LatexGlobalConfig;", "markdownDrawableLruCacheSize", "removeSynchronized", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface h {
    com.larus.business.markdown.api.model.a.a a();

    boolean b();

    boolean c();

    boolean d();

    int e();

    List<a> f();

    com.larus.business.markdown.api.extplugin.image.a g();

    com.larus.business.markdown.api.extplugin.a.a h();

    Integer i();

    boolean j();

    com.larus.business.markdown.api.a.a k();

    boolean l();

    boolean m();

    Map<String, com.larus.business.markdown.api.extplugin.b.a> n();

    boolean o();

    j p();

    boolean q();
}
