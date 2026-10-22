package com.obric.assistant.login;

import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.account.base.api.ILoginService;
import com.larus.im.FlowRuntime;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import n38.a;
import n38.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/assistant/login/ObricAccountInfoMonitorServiceImpl;", "Lcom/obric/assistant/login/IObricAccountInfoMonitorService;", "<init>", "()V", "hasInit", "", "init", "", "onAccountStatusChanged", "method", "", "event", "Lcom/larus/account/base/api/AccountStatusEvent;", "Companion", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricAccountInfoMonitorServiceImpl implements IObricAccountInfoMonitorService {
    public volatile boolean a;

    public static final class b implements j {
        public final /* synthetic */ ObricAccountInfoMonitorServiceImpl a;

        public b(ObricAccountInfoMonitorServiceImpl r1) {
            this.a = r1;
        }

        public final void a(a r3) {
            Intrinsics.checkNotNullParameter(r3, "event");
            ObricAccountInfoMonitorServiceImpl.a(this.a, "onUserDidOffline", r3);
        }

        public final void b(a r3) {
            Intrinsics.checkNotNullParameter(r3, "event");
            ObricAccountInfoMonitorServiceImpl.a(this.a, "onUserDidOnline", r3);
        }
    }

    static {
    }

    public ObricAccountInfoMonitorServiceImpl() {
    }

    public final void init() {
        if (this.a == false) goto L5;
        return;
    L5:
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L7:
        if (this.a == false) goto L11;
        monitor-exit(this);
        return;
    L11:
        this.a = true;     // Catch: Throwable -> L14
        ILoginService.a.f(new b(this), Boolean.TRUE);     // Catch: Throwable -> L14
        FLogger.a.i("ObricAccountInfoMonitor", "init");     // Catch: Throwable -> L14
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(this);
    }

    public static final void a(ObricAccountInfoMonitorServiceImpl r2, String r3, a r4) {
        r2.getClass();
        int r5 = com.obric.assistant.provider.hybrid.f.a;
        Intrinsics.checkNotNullParameter(r3, "method");
        Intrinsics.checkNotNullParameter(r4, "event");
        FlowRuntime.a().getApplication().getContentResolver().notifyChange(UriProtector.parse("content://com.obric.assistant.provider.AssistantHybridAbilityProvider/query_account_info"), null);
        FLogger.a.i("QueryAccountInfo", "onAccountStatusChanged: method = " + r3 + ", status = " + r4.a + ", secUserId = " + r4.b.b);
    }
}
