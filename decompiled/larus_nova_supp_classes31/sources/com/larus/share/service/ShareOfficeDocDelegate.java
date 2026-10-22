package com.larus.share.service;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\u0019\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0096\u0001JD\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\f0\u0010H\u0096\u0001J#\u0010\u0014\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0018H\u0096\u0001¨\u0006\u0019"}, d2 = {"Lcom/larus/share/service/ShareOfficeDocDelegate;", "Lcom/larus/share/service/IShareOfficeDocService;", "<init>", "()V", "isAvailable", "", "isDocPublic", "docType", "Lcom/larus/share/service/ShareDocType;", "token", "", "observeDocPermission", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onChanged", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isPublic", "openPermissionSetting", "context", "Landroid/content/Context;", "params", "Lcom/larus/share/service/ShareDocPermissionParams;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ShareOfficeDocDelegate implements IShareOfficeDocService {
    public static final ShareOfficeDocDelegate b = null;
    public final /* synthetic */ IShareOfficeDocService a;

    static {
        b = new ShareOfficeDocDelegate();
    }

    @Override // com.larus.share.service.IShareOfficeDocService
    public final boolean a(ShareDocType r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "docType");
        Intrinsics.checkNotNullParameter(r3, "token");
        return this.a.a(r2, r3);
    }

    @Override // com.larus.share.service.IShareOfficeDocService
    public final void b(ShareDocType r2, String r3, LifecycleOwner r4, Function1<? super Boolean, Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "docType");
        Intrinsics.checkNotNullParameter(r3, "token");
        Intrinsics.checkNotNullParameter(r4, "owner");
        Intrinsics.checkNotNullParameter(r5, "onChanged");
        this.a.b(r2, r3, r4, r5);
    }

    @Override // com.larus.share.service.IShareOfficeDocService
    public final void c(Context r2, ShareDocType r3, i r4) {
        Intrinsics.checkNotNullParameter(r3, "docType");
        Intrinsics.checkNotNullParameter(r4, "params");
        this.a.c(r2, r3, r4);
    }

    private ShareOfficeDocDelegate() {
        IShareOfficeDocService r0 = (IShareOfficeDocService) ServiceManager.get().getService(IShareOfficeDocService.class);
        if (r0 != null) goto L5;
        r0 = new DefaultShareOfficeDocService();
    L5:
        this.a = r0;
    }
}
