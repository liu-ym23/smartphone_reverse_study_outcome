package com.obric.mcpclient.complextasksdk;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/mcpclient/complextasksdk/EmptyScheduleProxy;", "Lcom/obric/mcpclient/complextasksdk/IScheduleProxy;", "()V", "TAG", "", "executeTask", "", "taskData", "isShow", "", "callback", "Lcom/obric/mcpclient/complextasksdk/IComplexTaskCallback;", "complextasksdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class b implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f8280a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f8281b = null;

    static {
        f8280a = new b();
        f8281b = "EmptyScheduleProxy";
    }

    private b() {
    }

    @Override // com.obric.mcpclient.complextasksdk.e
    public void a(String r1, boolean r2, c r3) {
        c r0 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "taskData");
        com.obric.mcpclient.complextasksdk.b.c.f8283a.c(f8281b, "executeTask");
    }
}
