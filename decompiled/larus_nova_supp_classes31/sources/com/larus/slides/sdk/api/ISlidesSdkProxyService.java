package com.larus.slides.sdk.api;

import ax9.a;
import com.larus.office.base.service.b;
import com.larus.slides.impl.e0;
import com.larus.slides.impl.v;
import com.larus.slides.impl.w;
import com.larus.slides.impl.x;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import vm9.c;
import vm9.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\rH&J\u0012\u0010\u000e\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\rH&J\u0012\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&J\u0012\u0010\u0012\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0014H&J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H&J\b\u0010\u0017\u001a\u00020\u0003H&J\b\u0010\u0018\u001a\u00020\u0003H&J\b\u0010\u0019\u001a\u00020\u0003H&¨\u0006\u001a"}, d2 = {"Lcom/larus/slides/sdk/api/ISlidesSdkProxyService;", "", "addChatService", "", "chatService", "Lcom/larus/slides/sdk/api/IChatService;", "removeChatService", "addTitleBarService", "titleBarService", "Lcom/larus/office/base/service/ITitleBarService;", "removeTitleBarService", "addSelectionChangeService", "selectionChangeService", "Lcom/larus/slides/sdk/api/ISelectionChangeService;", "removeSelectionChangeService", "addLoadingService", "service", "Lcom/larus/office/base/page/ILoadingService;", "removeLoadingService", "getTitleStageChangeListener", "Lcom/larus/office/base/service/ITitleStateChangeListener;", "getNavigationListener", "Lcom/larus/office/base/page/INavigationListener;", "notifyClearToast", "clearReference", "notifyCloseActionMode", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public interface ISlidesSdkProxyService {
    void a();

    void addLoadingService(c r1);

    void addTitleBarService(b r1);

    com.larus.office.base.service.c b();

    d c();

    void clearReference();

    void d(v r1);

    void e(a r1);

    void f(ax9.d r1);

    void g(w r1);

    void h();

    void i(x r1);

    void j(e0 r1);
}
