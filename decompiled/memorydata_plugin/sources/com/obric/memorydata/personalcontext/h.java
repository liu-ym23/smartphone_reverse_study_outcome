package com.obric.memorydata.personalcontext;

import android.content.Context;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.memorydata.middleware.api.device.DeviceInfoState;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.cu;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u001a\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\r\u001a\u00020\u000eH\u0007J\u0012\u0010\u000f\u001a\u00020\t2\b\b\u0001\u0010\r\u001a\u00020\u000eH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/personalcontext/DynamicIntentRegisterManager;", "", "<init>", "()V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "isInitialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "context", "Landroid/content/Context;", "registerIntentsXmlRes", "intentsXmlResId", "", "unregisterIntentsXmlRes", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f12183a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final al f12184b = null;
    private static final AtomicBoolean c = null;

    static {
        f12183a = new h();
        f12184b = am.a(cu.a(null, 1, null).plus((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")));
        c = new AtomicBoolean(false);
    }

    private h() {
    }

    public final void a(Context r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "context");
        AtomicBoolean r0 = c;
        if (r0.getAndSet(true) == false) goto L6;
        return;
    L6:
        if (DeviceInfoState.INSTANCE.isGlobalMemoryDisabled() == true) goto L8;
        a(r7, ZeusTransformUtils.mapRes(R.xml.dynamic_intents_memory, "xml", "dynamic_intents_memory"));
    L8:
        r0.set(true);
    }

    public final void a(Context r8, int r9) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "context");
        kotlinx.coroutines.i.a(f12184b, null, null, (Function2) ZeusTransformUtils.preCheckCast(new DynamicIntentRegisterManager$registerIntentsXmlRes$1(r7, r9, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }
}
