package com.obric.cae.libs.softap;

import com.obric.cae.libs.useraware.ICaeUserAwareCallback;
import com.obric.cae.userAware.UserAwareManager;
import com.obric.cae.userAware.report.CaeUserAwareReportJson;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements CaeSoftApManager.e, UserAwareManager.CallbackAction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5479a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5480b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f5481c;

    public /* synthetic */ c(int r8, Object r10, Object r11) {
        this.f5479a = r8;
        this.f5480b = r10;
        this.f5481c = r11;
    }

    @Override // com.obric.cae.libs.softap.CaeSoftApManager.e
    public final void a(ICaeSoftApManager r8) {
        int r10 = this.f5479a;
        Object r11 = this.f5481c;
        Object r12 = this.f5480b;
        switch(r10) {
            case 0: goto L5;
            default: goto L7;
        };
    L5:
        CaeSoftApManager.i((CaeSoftApManager) r12, (CaeSoftApStatusResultCallback) r11, r8);
        return;
    L7:
        CaeSoftApManager.p((CaeSoftApManager) r12, (CaeSoftApRequestCallback) r11, r8);
    }

    @Override // com.obric.cae.userAware.UserAwareManager.CallbackAction
    public final void execute(ICaeUserAwareCallback r8, Object r10) {
        CaeUserAwareReportJson.c((String) this.f5480b, (String) this.f5481c, r8, r10);
    }
}
