package com.obric.memorydata.personalcontext.external.message;

import com.obric.memorydata.middleware.api.device.DeviceInfoState;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/personalcontext/external/message/RmsProviderFactory;", "", "<init>", "()V", "instance", "Lcom/obric/memorydata/personalcontext/external/message/IRmsProvider;", "getInstance", "()Lcom/obric/memorydata/personalcontext/external/message/IRmsProvider;", "instance$delegate", "Lkotlin/Lazy;", "obric_entity_data_collector_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f12159a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy f12160b = null;

    static {
        f12159a = new f();
        f12160b = LazyKt.lazy(LazyThreadSafetyMode.NONE, $$Lambda$f$T6hywSUQpEi1OgxwCDIb54oOvg.INSTANCE);
    }

    private f() {
    }

    private static final d b() {
        if (Intrinsics.areEqual(DeviceInfoState.INSTANCE.getDeviceModel(), "Genesis-R") == true) goto L7;
        return null;
    L7:
        return new d();
    }

    /* JADX INFO: renamed from: lambda$T6hywSUQpEi1O-gxwCDIb54oOvg, reason: not valid java name */
    public static /* synthetic */ d m1077lambda$T6hywSUQpEi1OgxwCDIb54oOvg() {
        return b();
    }

    public final e a() {
        return (e) ZeusTransformUtils.preCheckCast(f12160b.getValue(), e.class, "com.obric.memorydata.plugin");
    }
}
