package com.obric.aiproactive.impl.runtime;

import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.cu;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\n\u001a\u00020\u000bJ\b\u0010\f\u001a\u00020\rH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/aiproactive/impl/runtime/ProactivePrivacyLoginGate;", "", "<init>", "()V", "TAG", "", "mainScope", "Lkotlinx/coroutines/CoroutineScope;", "requestingPrivacyLogin", "Ljava/util/concurrent/atomic/AtomicBoolean;", "ensureAgreePrivacyAndLogin", "", "requestAgreePrivacyAndLoginAsync", "", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f6511a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final al f6512b = null;
    private static final AtomicBoolean c = null;

    static {
        f6511a = new d();
        f6512b = am.a(cu.a(null, 1, null).plus((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.b().a(), CoroutineContext.class, "com.obric.memorydata.plugin")));
        c = new AtomicBoolean(false);
    }

    private d() {
    }

    public static final /* synthetic */ AtomicBoolean b() {
        return c;
    }

    private final void c() {
        if (c.compareAndSet(false, true) == true) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactivePrivacyLoginGate", "requestAgreePrivacyAndLoginAsync ignored: already requesting", false, 4, null);
        return;
    L6:
        i.a(f6512b, null, null, (Function2) ZeusTransformUtils.preCheckCast(new ProactivePrivacyLoginGate$requestAgreePrivacyAndLoginAsync$1(null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    public final boolean a() {
        boolean r1 = UserSettings.INSTANCE.hasAgreePrivacyAndLogin();
        if (r1 == true) goto L5;
        f6511a.c();
    L5:
        return r1;
    }
}
