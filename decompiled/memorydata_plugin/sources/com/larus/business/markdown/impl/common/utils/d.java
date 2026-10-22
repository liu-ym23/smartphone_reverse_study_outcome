package com.larus.business.markdown.impl.common.utils;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.larus.business.markdown.api.depend.h;
import com.larus.business.markdown.api.model.j;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\u000f\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\fJ\n\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0016\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u001d2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001J\b\u0010\u001e\u001a\u00020\u0005H\u0016J\b\u0010\u001f\u001a\u00020\u0005H\u0016J\b\u0010 \u001a\u00020\u0005H\u0016J\b\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020\u000bH\u0016J\b\u0010$\u001a\u00020\u0005H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/larus/business/markdown/impl/common/utils/MarkdownSettings;", "Lcom/larus/business/markdown/api/depend/IMarkdownSettings;", "()V", "markdownSettings", "clearDrawablePoolAfterRender", "", "enableCMarkParser", "enableHtmlNameEntityOptimize", "enableNewCodeStyle", "enableOptimizeWidgetCompare", "getAutoLinkMaxLimit", "", "()Ljava/lang/Integer;", "getCitationHandler", "Lcom/larus/business/markdown/api/citation/ICitationHandler;", "getCustomCodeHandler", "Lcom/larus/business/markdown/api/extplugin/code/ICustomCodeHandler;", "getCustomDataHandlers", "", "Lcom/larus/business/markdown/api/depend/ICustomDataHandler;", "getCustomImgHandler", "Lcom/larus/business/markdown/api/extplugin/image/ICustomImgHandler;", "getHtmlStyleClass", "", "", "Lcom/larus/business/markdown/api/extplugin/html/HtmlCssStyle;", "getSyntaxErrorCoverConfig", "Lcom/larus/business/markdown/api/model/SyntaxErrorCoverConfig;", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "isMarkdownListBlockOptimized", "isMarkdownStreamOptimized", "isMarkdownStringStreamOptimized", "latexGlobalConfig", "Lcom/larus/business/markdown/api/model/latex/LatexGlobalConfig;", "markdownDrawableLruCacheSize", "removeSynchronized", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class d implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private h f5180a;

    public d() {
    }

    @Override // com.larus.business.markdown.api.depend.h
    public com.larus.business.markdown.api.model.a.a a() {
        h r0 = this.f5180a;
        if (r0 == null) goto L7;
        com.larus.business.markdown.api.model.a.a r1 = r0.a();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new com.larus.business.markdown.api.model.a.a(0, false, null, false, false, false, null, null, false, false, false, false, 0, 8191, null);
    }

    public final void a(h r3) {
        this.f5180a = (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.memorydata.plugin");
    }

    @Override // com.larus.business.markdown.api.depend.h
    public boolean b() {
        h r0 = this.f5180a;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.b();
    }

    @Override // com.larus.business.markdown.api.depend.h
    public boolean c() {
        h r0 = this.f5180a;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.c();
    }

    @Override // com.larus.business.markdown.api.depend.h
    public boolean d() {
        h r0 = this.f5180a;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.d();
    }

    @Override // com.larus.business.markdown.api.depend.h
    public int e() {
        h r0 = this.f5180a;
        if (r0 != null) goto L7;
        return 20;
    L7:
        return r0.e();
    }

    @Override // com.larus.business.markdown.api.depend.h
    public List<com.larus.business.markdown.api.depend.a> f() {
        h r0 = this.f5180a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.f();
    }

    @Override // com.larus.business.markdown.api.depend.h
    public com.larus.business.markdown.api.extplugin.image.a g() {
        h r0 = this.f5180a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.g();
    }

    @Override // com.larus.business.markdown.api.depend.h
    public com.larus.business.markdown.api.extplugin.a.a h() {
        h r0 = this.f5180a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.h();
    }

    @Override // com.larus.business.markdown.api.depend.h
    public Integer i() {
        h r0 = this.f5180a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.i();
    }

    @Override // com.larus.business.markdown.api.depend.h
    public boolean j() {
        h r0 = this.f5180a;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.j();
    }

    @Override // com.larus.business.markdown.api.depend.h
    public com.larus.business.markdown.api.a.a k() {
        h r0 = this.f5180a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.k();
    }

    @Override // com.larus.business.markdown.api.depend.h
    public boolean l() {
        h r0 = this.f5180a;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.l();
    }

    @Override // com.larus.business.markdown.api.depend.h
    public boolean m() {
        h r0 = this.f5180a;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.m();
    }

    @Override // com.larus.business.markdown.api.depend.h
    public Map<String, com.larus.business.markdown.api.extplugin.b.a> n() {
        h r0 = this.f5180a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.n();
    }

    @Override // com.larus.business.markdown.api.depend.h
    public boolean o() {
        h r0 = this.f5180a;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.o();
    }

    @Override // com.larus.business.markdown.api.depend.h
    public j p() {
        h r3 = this.f5180a;
        if (r3 == null) goto L7;
        j r4 = r3.p();
        if (r4 == null) goto L7;
        return r4;
    L7:
        return new j(false, 1, null);
    }

    @Override // com.larus.business.markdown.api.depend.h
    public boolean q() {
        h r0 = this.f5180a;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.q();
    }
}
