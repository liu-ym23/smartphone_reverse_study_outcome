package com.obric.assistant.push;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import com.obric.assistant.spi.push.IObricPushConfigService;
import com.obric.assistant.state.ISharedStateService;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\t"}, d2 = {"Lcom/obric/assistant/push/ObricPushConfigServiceImpl;", "Lcom/obric/assistant/spi/push/IObricPushConfigService;", "<init>", "()V", "savePushToken", "", "token", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricPushConfigServiceImpl implements IObricPushConfigService {
    static {
    }

    public ObricPushConfigServiceImpl() {
    }

    public final void a(String r4) {
        if (ObricFeatureServiceDelegate.b.b() == true) goto L6;
        FLogger.a.i("ObricPushConfigServiceImpl", "savePushToken skipped: not ObricOs");
        return;
    L6:
        if (r4 != null) goto L8;
    L11:
        boolean r0 = true;
    L12:
        if (r0 == false) goto L15;
        FLogger.a.w("ObricPushConfigServiceImpl", "savePushToken skipped: token is null or empty");
        return;
    L15:
        ISharedStateService.a.getClass();
        ISharedStateService r1 = ISharedStateService.a.a();
        if (r1 == null) goto L18;
        r1.a("doubao_push_token", r4);
        FLogger.a.i("ObricPushConfigServiceImpl", "savePushToken success");
        return;
    L18:
        FLogger.a.w("ObricPushConfigServiceImpl", "savePushToken skipped: ISharedStateService instance is null");
        return;
    L8:
        if (r4.length() == 0) goto L11;
        r0 = false;
        goto L12
    }
}
