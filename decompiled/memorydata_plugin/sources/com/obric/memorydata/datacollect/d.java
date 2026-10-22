package com.obric.memorydata.datacollect;

import kotlin.Metadata;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/datacollect/BatteryStateCollect;", "Lcom/obric/memorydata/datacollect/intf/ISubscribeCollect;", "Lcom/obric/memorydata/datacollect/intf/IFrequencyCollect;", "<init>", "()V", "queryParams", "Lcom/obric/memorydata/ability/AbilityParams;", "subscribeParams", "getFrequencyQueryParams", "getSubscribeParams", "data_collect_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d implements com.obric.memorydata.datacollect.a.b, com.obric.memorydata.datacollect.a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.obric.memorydata.ability.f f9685a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.memorydata.ability.f f9686b;

    public d() {
        this.f9685a = new com.obric.memorydata.ability.f(100000010, MapsKt.emptyMap());
        this.f9686b = new com.obric.memorydata.ability.f(100000010, MapsKt.emptyMap());
    }

    @Override // com.obric.memorydata.datacollect.a.d
    public com.obric.memorydata.ability.f a() {
        return this.f9686b;
    }

    @Override // com.obric.memorydata.datacollect.a.b
    public com.obric.memorydata.ability.f b() {
        return this.f9685a;
    }
}
