package com.larus.sheet.sdk.impl.proxy;

import com.larus.office.base.service.b;
import com.larus.office.base.service.m;
import com.larus.office.base.service.n;
import com.larus.sheet.impl.SheetFragment$initTitleBarService$1;
import com.larus.sheet.impl.o;
import com.larus.sheet.impl.p;
import com.larus.sheet.sdk.api.ISheetSdkProxyService;
import com.tencent.open.log.TraceLevel;
import ew4.a;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;
import pw9.c;
import sw9.g;
import vm9.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\f\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0010\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u0014\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u0015\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010\u0017\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0016H\u0016J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\n\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\n\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\u0005H\u0016J\b\u0010\"\u001a\u00020\u0005H\u0016J\u0010\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020 H\u0016¨\u0006("}, d2 = {"Lcom/larus/sheet/sdk/impl/proxy/SheetSdkProxyServiceImpl;", "Lcom/larus/sheet/sdk/api/ISheetSdkProxyService;", "<init>", "()V", "addChatService", "", "chatService", "Lcom/larus/sheet/sdk/api/IChatService;", "removeChatService", "addTitleBarService", "titleBarService", "Lcom/larus/office/base/service/ITitleBarService;", "removeTitleBarService", "addSelectionChangeService", "selectionChangeService", "Lcom/larus/sheet/sdk/api/ISelectionChangeService;", "removeSelectionChangeService", "addLoadingService", "service", "Lcom/larus/office/base/page/ILoadingService;", "removeLoadingService", "addPermissionChangeService", "Lcom/larus/sheet/sdk/api/ISheetPermissionChangeService;", "removePermissionChangeService", "getMoreMenuItemClickListener", "Lcom/larus/sheet/sdk/api/IMoreMenuClickListener;", "getTitleStageChangeListener", "Lcom/larus/office/base/service/ITitleStateChangeListener;", "getNavigationListener", "Lcom/larus/office/base/page/INavigationListener;", "notifyClearToast", "isV2", "", "clearReference", "notifyCloseActionMode", "notifyBottomPanelHeightChanged", "height", "", "notifyAIChatListFoldStatusChanged", "isFold", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class SheetSdkProxyServiceImpl implements ISheetSdkProxyService {
    public SheetSdkProxyServiceImpl() {
    }

    @Override // com.larus.sheet.sdk.api.ISheetSdkProxyService
    public final void a() {
        c r0 = g.a;
        c r1 = g.a;
        if (r1 == null) goto L6;
        r1.notifyCloseCustomMenu();
        return;
    }

    @Override // com.larus.sheet.sdk.api.ISheetSdkProxyService
    public final com.larus.office.base.service.c b() {
        return m.e("default_doc_logic_key");
    }

    @Override // com.larus.sheet.sdk.api.ISheetSdkProxyService
    public final void clearReference() {
        c r0 = g.a;
        c r1 = g.a;
        if (r1 == null) goto L6;
        r1.onClearReference();
        return;
    }

    @Override // com.larus.sheet.sdk.api.ISheetSdkProxyService
    public final d c() {
        return m.b();
    }

    @Override // com.larus.sheet.sdk.api.ISheetSdkProxyService
    public final void k() {
        c r0 = g.a;
    }

    @Override // com.larus.sheet.sdk.api.ISheetSdkProxyService
    public final void addLoadingService(vm9.c r2) {
        c r0 = g.a;
        if (r2 == null) goto L6;
        g.j.add(r2);
        return;
    }

    @Override // com.larus.sheet.sdk.api.ISheetSdkProxyService
    public final void addTitleBarService(b r2) {
        c r0 = g.a;
        Lazy r1 = m.a;
        n r3 = (n) m.a.getValue();
        if (r2 == null) goto L5;
        r3.a.add(r2);
        return;
    L5:
        r3.getClass();
    }

    @Override // com.larus.sheet.sdk.api.ISheetSdkProxyService
    public final void d(boolean r2) {
        c r0 = g.a;
        if (g.e == r2) goto L10;
        g.e = r2;
        a r1 = g.b;
        if (r1 == null) goto L9;
        r1.b(r2);
        return;
    L9:
        return;
    }

    @Override // com.larus.sheet.sdk.api.ISheetSdkProxyService
    public final void e(com.larus.sheet.impl.n r2) {
        sw9.a r0 = g.a();
        if (r2 == null) goto L5;
        r0.a.remove(r2);
        return;
    L5:
        r0.getClass();
    }

    @Override // com.larus.sheet.sdk.api.ISheetSdkProxyService
    public final void f(pw9.a r2) {
        sw9.a r0 = g.a();
        if (r2 == null) goto L5;
        r0.a.add(r2);
        return;
    L5:
        r0.getClass();
    }

    @Override // com.larus.sheet.sdk.api.ISheetSdkProxyService
    public final void g(p r2) {
        sw9.b r0 = g.c();
        if (r2 == null) goto L5;
        r0.a.remove(r2);
        return;
    L5:
        r0.getClass();
    }

    @Override // com.larus.sheet.sdk.api.ISheetSdkProxyService
    public final void h(o r2) {
        g.j.remove(r2);
    }

    @Override // com.larus.sheet.sdk.api.ISheetSdkProxyService
    public final void i(int r2) {
        c r0 = g.a;
        int r3 = RangesKt.coerceAtLeast(r2, 0);
        if (g.d == true) goto L5;
    L7:
        g.d = true;
        g.c = r3;
        a r1 = g.b;
        if (r1 == null) goto L11;
        r1.a(r3);
        return;
    L11:
        return;
    L5:
        if (g.c != r3) goto L7;
    }

    @Override // com.larus.sheet.sdk.api.ISheetSdkProxyService
    public final void j(SheetFragment$initTitleBarService$1 r2) {
        c r0 = g.a;
        Lazy r1 = m.a;
        n r3 = (n) m.a.getValue();
        if (r2 == null) goto L5;
        r3.a.remove(r2);
        return;
    L5:
        r3.getClass();
    }

    @Override // com.larus.sheet.sdk.api.ISheetSdkProxyService
    public final void l(pw9.d r2) {
        sw9.b r0 = g.c();
        if (r2 == null) goto L5;
        r0.a.add(r2);
        return;
    L5:
        r0.getClass();
    }
}
