package com.obric.memorydata.personalcontext.external.e;

import android.content.Context;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.memorydata.personalcontext.external.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\n\u001a\u00020\u0005J\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012J\u0018\u0010\u0014\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0015\u001a\u00020\u0005H&J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H&R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/personalcontext/external/sms/AbstractExternalSmsSubCollector;", "", "<init>", "()V", "isInit", "", LocationMonitorConst.TAG, "", "getTag", "()Ljava/lang/String;", "isInitialized", "initAndGetFetcherIfNeed", "Lcom/obric/memorydata/personalcontext/external/sms/IExternalSmsInitFetcher;", "context", "Landroid/content/Context;", "indexUpdater", "Lcom/obric/memorydata/personalcontext/external/ExternalEntityIndexUpdater;", "getDonateEntityTypeList", "", "", "createObserver", "hasPermission", "supportDonateEntityTypeList", "obric_entity_data_collector_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f12123a;

    public a() {
    }

    public final d a(Context r3, i r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r4, "indexUpdater");
        if (d() == true) goto L7;
        com.obric.memorydata.personalcontext.external.c.f12108a.b(a(), "permission not granted");
        return null;
    L7:
        if (this.f12123a == false) goto L9;
        return null;
    L9:
        this.f12123a = true;
        return b(r5, r4);
    }

    public abstract String a();

    public abstract d b(Context r1, i r2);

    public final boolean b() {
        return this.f12123a;
    }

    public final List<Integer> c() {
        if (d() == true) goto L7;
        return null;
    L7:
        return e();
    }

    public abstract boolean d();

    public abstract List<Integer> e();
}
