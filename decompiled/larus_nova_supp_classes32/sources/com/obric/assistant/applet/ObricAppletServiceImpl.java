package com.obric.assistant.applet;

import com.larus.platform.service.AccountService;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mba.a;
import mba.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u000bH\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/obric/assistant/applet/ObricAppletServiceImpl;", "Lcom/obric/assistant/applet/IObricAppletService;", "<init>", "()V", "repo", "Lcom/obric/assistant/applet/PersonalPermissionRepo;", "getRepo", "()Lcom/obric/assistant/applet/PersonalPermissionRepo;", "repo$delegate", "Lkotlin/Lazy;", "checkPersonalPermission", NameKeys.UnloadStrategy_No_Strategy, "appletId", NameKeys.UnloadStrategy_No_Strategy, CloudControlInf.PERMISSION, "updatePersonalPermission", NameKeys.UnloadStrategy_No_Strategy, "granted", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricAppletServiceImpl implements IObricAppletService {
    public final Lazy a;

    public ObricAppletServiceImpl() {
        this.a = LazyKt.lazy(new a());
    }

    @Override // com.obric.assistant.applet.IObricAppletService
    public final boolean a(String r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "appletId");
        Intrinsics.checkNotNullParameter(r7, CloudControlInf.PERMISSION);
        b r2 = (b) this.a.getValue();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r6, "appletId");
        Intrinsics.checkNotNullParameter(r7, CloudControlInf.PERMISSION);
        String r0 = AccountService.a.getUserId();
        if (r0.length() != 0) goto L5;
        boolean r1 = true;
    L7:
        if (r1 == false) goto L10;
        return r2.a.getBoolean(r6 + '_' + r7, false);
    L10:
        return r2.a.getBoolean(r6 + '_' + r0 + '_' + r7, false);
    L5:
        r1 = false;
        goto L7
    }

    @Override // com.obric.assistant.applet.IObricAppletService
    public final void b(String r5, String r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r5, "appletId");
        Intrinsics.checkNotNullParameter(r6, CloudControlInf.PERMISSION);
        b r2 = (b) this.a.getValue();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r5, "appletId");
        Intrinsics.checkNotNullParameter(r6, CloudControlInf.PERMISSION);
        String r0 = AccountService.a.getUserId();
        if (r0.length() != 0) goto L5;
        boolean r1 = true;
    L7:
        if (r1 == false) goto L9;
        r2.a.storeBoolean(r5 + '_' + r6, r7);
        return;
    L9:
        r2.a.storeBoolean(r5 + '_' + r0 + '_' + r6, r7);
        return;
    L5:
        r1 = false;
        goto L7
    }
}
