package com.obric.assistant.security;

import com.larus.utils.logger.FLogger;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/assistant/security/CertificateCheckServiceImpl;", "Lcom/obric/assistant/security/ICertificateCheckService;", "<init>", "()V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "isChecking", "Ljava/util/concurrent/atomic/AtomicBoolean;", "checkState", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CertificateCheckServiceImpl implements ICertificateCheckService {
    public final CoroutineScope a;
    public final AtomicBoolean b;

    static {
    }

    public final void a() {
        if (this.b.compareAndSet(false, true) == true) goto L6;
        FLogger.a.d("CertificateCheckServiceImpl", "checkState() already running, skip");
        return;
    L6:
        BuildersKt.launch$default(this.a, null, null, new CertificateCheckServiceImpl$checkState$1(this, null), 3, null);
    }

    public CertificateCheckServiceImpl() {
        this.a = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        this.b = new AtomicBoolean(false);
    }
}
