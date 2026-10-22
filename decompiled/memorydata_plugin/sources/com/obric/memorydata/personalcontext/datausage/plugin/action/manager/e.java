package com.obric.memorydata.personalcontext.datausage.plugin.action.manager;

import androidx.exifinterface.media.ExifInterface;
import com.obric.capabilitykit.common.intent.IntentParams;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u0004\b\u0001\u0010\u00032\u00020\u0004B)\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/personalcontext/datausage/plugin/action/manager/IntentExecutorData;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Empty", "", "paramsClass", "Ljava/lang/Class;", "executor", "Lcom/obric/memorydata/personalcontext/datausage/plugin/action/manager/IMemoryIntentExecutor;", "<init>", "(Ljava/lang/Class;Lcom/obric/memorydata/personalcontext/datausage/plugin/action/manager/IMemoryIntentExecutor;)V", "getParamsClass", "()Ljava/lang/Class;", "getExecutor", "()Lcom/obric/memorydata/personalcontext/datausage/plugin/action/manager/IMemoryIntentExecutor;", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e<T extends IntentParams, Empty> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class<T> f12085a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d<T, Empty> f12086b;

    public e(Class<T> r3, d<T, Empty> r4) {
        d<T, Empty> r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "paramsClass");
        Intrinsics.checkNotNullParameter(r5, "executor");
        this.f12085a = r3;
        this.f12086b = r5;
    }

    public final Class<T> a() {
        return this.f12085a;
    }

    public final d<T, Empty> b() {
        return this.f12086b;
    }
}
