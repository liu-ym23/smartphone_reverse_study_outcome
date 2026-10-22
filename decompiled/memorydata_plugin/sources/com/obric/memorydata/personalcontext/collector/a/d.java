package com.obric.memorydata.personalcontext.collector.a;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/personalcontext/collector/sms/MessageEntitySubCollector;", "Lcom/obric/memorydata/personalcontext/collector/sms/AbstractSmsSubCollector;", "<init>", "()V", "type", "", "getType", "()Ljava/lang/String;", LocationMonitorConst.TAG, "getTag", "initDataAwareness", "", "donation", "Lcom/obric/contactsdk/CallSmsDataDonation;", "hasPermission", "", "supportDonateEntityTypeList", "", "", "obric_entity_data_collector_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f12059a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f12060b;

    public d() {
        this.f12059a = "obric_sub_message";
        this.f12060b = "Sms_MessageEntityCollector";
    }

    @Override // com.obric.memorydata.personalcontext.collector.a.a
    public String a() {
        return this.f12060b;
    }

    @Override // com.obric.memorydata.personalcontext.collector.a.a
    public void a(com.obric.contactsdk.c r1) {
        Intrinsics.checkNotNullParameter(r1, "donation");
        r1.b();
    }

    @Override // com.obric.memorydata.personalcontext.collector.a.a
    public boolean e() {
        return com.obric.memorydata.personalcontext.collector.a.f12050a.a();
    }

    @Override // com.obric.memorydata.personalcontext.collector.a.a
    public List<Integer> f() {
        return CollectionsKt.listOf(101);
    }

    @Override // com.obric.memorydata.personalcontext.collector.a.a
    public String getType() {
        return this.f12059a;
    }
}
