package com.bytedance.lego.init;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J#\u0010\b\u001a\u0004\u0018\u0001H\t\"\u0004\b\u0000\u0010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u000bH\u0016¢\u0006\u0002\u0010\fR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0001X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/bytedance/lego/init/ServiceManagerProxy;", "Lcom/bytedance/lego/init/IServiceManagerProxy;", "()V", "proxy", "getProxy$initscheduler_release", "()Lcom/bytedance/lego/init/IServiceManagerProxy;", "setProxy$initscheduler_release", "(Lcom/bytedance/lego/init/IServiceManagerProxy;)V", "getService", ExifInterface.GPS_DIRECTION_TRUE, "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "initscheduler_release"}, k = 1, mv = {1, 1, 13})
public final class l implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f2777a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static c f2778b;

    static {
        f2777a = new l();
    }

    private l() {
    }

    @Override // com.bytedance.lego.init.c
    public <T> T a(Class<T> r1) {
        Intrinsics.checkParameterIsNotNull(r1, "clazz");
        c r0 = f2778b;
        if (r0 == null) goto L9;
        if (r0 != null) goto L10;
        return null;
    L10:
        return (T) r0.a(r1);
    L9:
        return (T) com.bytedance.news.common.service.manager.d.a(r1);
    }

    public final void a(c r2) {
        f2778b = (c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.memorydata.plugin");
    }
}
