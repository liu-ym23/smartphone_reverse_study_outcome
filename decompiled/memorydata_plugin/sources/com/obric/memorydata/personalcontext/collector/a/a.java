package com.obric.memorydata.personalcontext.collector.a;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\r\u001a\u00020\u0005J\u0006\u0010\u000e\u001a\u00020\u0005J\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H'J\b\u0010\u0016\u001a\u00020\u0005H&J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H&R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\f\u0012\u0004\b\b\u0010\u0003\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/personalcontext/collector/sms/AbstractSmsSubCollector;", "", "<init>", "()V", "isInit", "", "type", "", "getType$annotations", "getType", "()Ljava/lang/String;", LocationMonitorConst.TAG, "getTag", "isInitialized", "initAndGetNeedInitDataAwareness", "getDonateEntityTypeList", "", "", "initDataAwareness", "", "donation", "Lcom/obric/contactsdk/CallSmsDataDonation;", "hasPermission", "supportDonateEntityTypeList", "obric_entity_data_collector_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f12054a;

    public a() {
    }

    public abstract String a();

    public abstract void a(com.obric.contactsdk.c r1);

    public final boolean b() {
        return this.f12054a;
    }

    public final boolean c() {
        if (e() == true) goto L7;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), a(), "permission not granted", false, 4, null);
        return false;
    L7:
        if (this.f12054a == false) goto L9;
        return false;
    L9:
        this.f12054a = true;
        return true;
    }

    public final List<Integer> d() {
        if (e() == true) goto L7;
        return null;
    L7:
        return f();
    }

    public abstract boolean e();

    public abstract List<Integer> f();

    public abstract String getType();
}
