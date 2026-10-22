package com.bytedance.badger.z;

import android.content.Context;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.badger.BadgerCore;
import com.bytedance.badger.data.BadgerResult;
import com.bytedance.badger.data.DataJson;
import com.bytedance.badger.module.BadgerModuleBase;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d0 extends u0 {
    public d0() {
    }

    @Override // com.bytedance.badger.module.BadgerModuleBase
    public final BadgerResult a(Context r13, BadgerModuleBase.BadgerRequestData r14) {
        BadgerCore.Companion.getClass();
        com.bytedance.badger.network.z r15 = com.bytedance.badger.j.a().getPublicIpAddressInfo();
        return new BadgerResult.Success(new DataJson(com.bm.badgervi.b.f(new Pair[]{TuplesKt.to(DataType.TRUE, CollectionsKt.joinToString$default(r15.a, ";", null, null, 0, null, null, 62, null)), TuplesKt.to("2", CollectionsKt.joinToString$default(r15.b, ";", null, null, 0, null, null, 62, null))})));
    }
}
