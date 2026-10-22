package com.larus.slides.sdk.impl.proxy;

import ax9.c;
import com.larus.office.base.plugins.toast.ToastPluginV2;
import com.larus.office.base.service.b;
import com.larus.office.base.service.m;
import com.larus.office.base.service.n;
import com.larus.slides.impl.e0;
import com.larus.slides.impl.v;
import com.larus.slides.impl.w;
import com.larus.slides.impl.x;
import com.larus.slides.sdk.api.ISlidesSdkProxyService;
import com.tencent.open.log.TraceLevel;
import ex9.a;
import ex9.e;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.Metadata;
import vm9.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\f\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0010\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u0014\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0005H\u0016J\b\u0010\u001a\u001a\u00020\u0005H\u0016J\b\u0010\u001b\u001a\u00020\u0005H\u0016¨\u0006\u001c"}, d2 = {"Lcom/larus/slides/sdk/impl/proxy/SlidesSdkProxyServiceImpl;", "Lcom/larus/slides/sdk/api/ISlidesSdkProxyService;", "<init>", "()V", "addChatService", "", "chatService", "Lcom/larus/slides/sdk/api/IChatService;", "removeChatService", "addTitleBarService", "titleBarService", "Lcom/larus/office/base/service/ITitleBarService;", "removeTitleBarService", "addSelectionChangeService", "selectionChangeService", "Lcom/larus/slides/sdk/api/ISelectionChangeService;", "removeSelectionChangeService", "addLoadingService", "service", "Lcom/larus/office/base/page/ILoadingService;", "removeLoadingService", "getTitleStageChangeListener", "Lcom/larus/office/base/service/ITitleStateChangeListener;", "getNavigationListener", "Lcom/larus/office/base/page/INavigationListener;", "notifyClearToast", "clearReference", "notifyCloseActionMode", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class SlidesSdkProxyServiceImpl implements ISlidesSdkProxyService {
    public SlidesSdkProxyServiceImpl() {
    }

    @Override // com.larus.slides.sdk.api.ISlidesSdkProxyService
    public final void a() {
        c r0 = e.a;
        c r1 = e.a;
        if (r1 == null) goto L6;
        r1.notifyCloseCustomMenu();
        return;
    }

    @Override // com.larus.slides.sdk.api.ISlidesSdkProxyService
    public final com.larus.office.base.service.c b() {
        return m.e("default_doc_logic_key");
    }

    @Override // com.larus.slides.sdk.api.ISlidesSdkProxyService
    public final void clearReference() {
        c r0 = e.a;
        c r1 = e.a;
        if (r1 == null) goto L6;
        r1.onClearReference();
        return;
    }

    @Override // com.larus.slides.sdk.api.ISlidesSdkProxyService
    public final void h() {
        Lazy r0 = m.a;
        WeakReference r1 = m.f;
        if (r1 == null) goto L5;
        ToastPluginV2 r2 = (ToastPluginV2) r1.get();
    L6:
        if (r2 == null) goto L9;
        r2.clearToast();
        return;
    L9:
        return;
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.larus.slides.sdk.api.ISlidesSdkProxyService
    public final d c() {
        return m.b();
    }

    @Override // com.larus.slides.sdk.api.ISlidesSdkProxyService
    public final void addLoadingService(vm9.c r2) {
        c r0 = e.a;
        if (r2 == null) goto L6;
        e.e.add(r2);
        return;
    }

    @Override // com.larus.slides.sdk.api.ISlidesSdkProxyService
    public final void addTitleBarService(b r2) {
        c r0 = e.a;
        Lazy r1 = m.a;
        n r3 = (n) m.a.getValue();
        if (r2 == null) goto L5;
        r3.a.add(r2);
        return;
    L5:
        r3.getClass();
    }

    @Override // com.larus.slides.sdk.api.ISlidesSdkProxyService
    public final void d(v r2) {
        a r0 = e.a();
        if (r2 == null) goto L5;
        r0.a.remove(r2);
        return;
    L5:
        r0.getClass();
    }

    @Override // com.larus.slides.sdk.api.ISlidesSdkProxyService
    public final void e(ax9.a r2) {
        a r0 = e.a();
        if (r2 == null) goto L5;
        r0.a.add(r2);
        return;
    L5:
        r0.getClass();
    }

    @Override // com.larus.slides.sdk.api.ISlidesSdkProxyService
    public final void f(ax9.d r2) {
        ex9.b r0 = (ex9.b) e.d.getValue();
        if (r2 == null) goto L5;
        r0.a.add(r2);
        return;
    L5:
        r0.getClass();
    }

    @Override // com.larus.slides.sdk.api.ISlidesSdkProxyService
    public final void g(w r2) {
        e.e.remove(r2);
    }

    @Override // com.larus.slides.sdk.api.ISlidesSdkProxyService
    public final void i(x r2) {
        ex9.b r0 = (ex9.b) e.d.getValue();
        if (r2 == null) goto L5;
        r0.a.remove(r2);
        return;
    L5:
        r0.getClass();
    }

    @Override // com.larus.slides.sdk.api.ISlidesSdkProxyService
    public final void j(e0 r2) {
        c r0 = e.a;
        Lazy r1 = m.a;
        n r3 = (n) m.a.getValue();
        if (r2 == null) goto L5;
        r3.a.remove(r2);
        return;
    L5:
        r3.getClass();
    }
}
