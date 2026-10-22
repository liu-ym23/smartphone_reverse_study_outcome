package com.larus.doc.sdk.impl.v2;

import com.bytedance.ee.permission.PermissionSdk;
import com.bytedance.ee.permission.define.value.TypeExternalAccess;
import com.bytedance.ee.permission.define.value.TypeLinkShare;
import com.larus.doc.sdk.api.IDocPermissionService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import n39.i;
import n39.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0016J \u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0011H\u0016J4\u0010\u0012\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000b2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00070\u0016H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/DocPermissionServiceImpl;", "Lcom/larus/doc/sdk/api/IDocPermissionService;", "<init>", "()V", "permissionSdk", "Lcom/bytedance/ee/permission/IPermissionSdk;", "initPermissionSdk", "", "sdk", "updatePermission", "token", "", "isPublic", "", "callback", "Lcom/larus/doc/sdk/api/IUpdateDocPermissionCallback;", "getPermission", "Lcom/larus/doc/sdk/api/IGetDocPermissionCallback;", "validatePermission", "type", "", "operation", "Lkotlin/Function1;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocPermissionServiceImpl implements IDocPermissionService {
    private com.bytedance.ee.permission.a permissionSdk;

    public DocPermissionServiceImpl() {
    }

    @Override // com.larus.doc.sdk.api.IDocPermissionService
    public void initPermissionSdk(com.bytedance.ee.permission.a r1) {
        this.permissionSdk = r1;
    }

    @Override // com.larus.doc.sdk.api.IDocPermissionService
    public void getPermission(String r3, final i r4) {
        Intrinsics.checkNotNullParameter(r3, "token");
        Intrinsics.checkNotNullParameter(r4, "callback");
        vt5.a r0 = new vt5.a(r3, 22);
        PermissionSdk r5 = this.permissionSdk;
        if (r5 == null) goto L8;
        com.bytedance.ee.permission.b r6 = r5.a();
        if (r6 == null) goto L9;
        r6.d(r0, new AnonymousClass1(r4));
        return;
    L9:
        return;
    }

    @Override // com.larus.doc.sdk.api.IDocPermissionService
    public void updatePermission(String r3, boolean r4, final q r5) {
        Intrinsics.checkNotNullParameter(r3, "token");
        Intrinsics.checkNotNullParameter(r5, "callback");
        vt5.c r0 = new vt5.c(r3, 22);
        if (r4 == false) goto L5;
        TypeExternalAccess r6 = TypeExternalAccess.EXTERNAL_ACCESS_OPEN;
    L6:
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        r0.d = r6;
        if (r4 == false) goto L9;
        TypeLinkShare r7 = TypeLinkShare.LINK_SHARE_ANYONE_READ;
    L10:
        Intrinsics.checkNotNullParameter(r7, "<set-?>");
        r0.e = r7;
        PermissionSdk r8 = this.permissionSdk;
        if (r8 == null) goto L16;
        com.bytedance.ee.permission.b r9 = r8.a();
        if (r9 == null) goto L17;
        r9.f(r0, new C01691(r5));
        return;
    L17:
        return;
    L16:
        return;
    L9:
        r7 = TypeLinkShare.LINK_SHARE_CLOSE;
        goto L10
    L5:
        r6 = TypeExternalAccess.EXTERNAL_ACCESS_CLOSE;
        goto L6
    }

    @Override // com.larus.doc.sdk.api.IDocPermissionService
    public void validatePermission(String r3, int r4, String r5, final Function1<? super Boolean, Unit> r6) {
        Intrinsics.checkNotNullParameter(r3, "token");
        Intrinsics.checkNotNullParameter(r5, "operation");
        Intrinsics.checkNotNullParameter(r6, "callback");
        PermissionSdk r0 = this.permissionSdk;
        if (r0 == null) goto L8;
        com.bytedance.ee.permission.b r1 = r0.a();
        if (r1 == null) goto L9;
        r1.b(r3, r4, r5, new C01701(r6));
        return;
    L9:
        return;
    }
}
