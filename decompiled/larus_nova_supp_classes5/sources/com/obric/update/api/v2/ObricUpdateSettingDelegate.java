package com.obric.update.api.v2;

import coa.b;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/obric/update/api/v2/ObricUpdateSettingDelegate;", "Lcom/obric/update/api/v2/IObricUpdateSettingService;", "<init>", "()V", "service", "getService", "()Lcom/obric/update/api/v2/IObricUpdateSettingService;", "service$delegate", "Lkotlin/Lazy;", "isWiFiUpdateEnable", "", "setWifiUpdateEnable", "", "enable", "getLastCheckDate", "", "setLastCheckDate", "date", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricUpdateSettingDelegate implements IObricUpdateSettingService {
    public static final ObricUpdateSettingDelegate a = null;
    public static final Lazy b = null;

    private ObricUpdateSettingDelegate() {
    }

    static {
        a = new ObricUpdateSettingDelegate();
        b = LazyKt.lazy(new b());
    }

    @Override // com.obric.update.api.v2.IObricUpdateSettingService
    public final boolean a() {
        IObricUpdateSettingService r0 = (IObricUpdateSettingService) b.getValue();
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L9:
        return !r1;
    L5:
        if (r0.a() == true) goto L7;
        r1 = true;
        goto L9
    }

    @Override // com.obric.update.api.v2.IObricUpdateSettingService
    public final String c() {
        IObricUpdateSettingService r0 = (IObricUpdateSettingService) b.getValue();
        if (r0 == null) goto L6;
        String r1 = r0.c();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    @Override // com.obric.update.api.v2.IObricUpdateSettingService
    public final void b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "date");
        IObricUpdateSettingService r0 = (IObricUpdateSettingService) b.getValue();
        if (r0 == null) goto L6;
        r0.b(r2);
        return;
    }

    @Override // com.obric.update.api.v2.IObricUpdateSettingService
    public final void d(boolean r2) {
        IObricUpdateSettingService r0 = (IObricUpdateSettingService) b.getValue();
        if (r0 == null) goto L6;
        r0.d(r2);
        return;
    }
}
