package com.obric.memorydata.datacollect;

import com.bytedance.bdlocation.annotation.LocationAnnotation;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/datacollect/SettingsChangedCollect;", "Lcom/obric/memorydata/datacollect/intf/ISubscribeCollect;", "<init>", "()V", "subscribeParams", "Lcom/obric/memorydata/ability/AbilityParams;", "getSubscribeParams", "data_collect_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class m implements com.obric.memorydata.datacollect.a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.obric.memorydata.ability.f f9695a;

    public m() {
        this.f9695a = new com.obric.memorydata.ability.f(100001007, MapsKt.mapOf(TuplesKt.to("mode", LocationAnnotation.LightLocationType.LIGHT_LOCATION_ALL)));
    }

    @Override // com.obric.memorydata.datacollect.a.d
    public com.obric.memorydata.ability.f a() {
        return this.f9695a;
    }
}
