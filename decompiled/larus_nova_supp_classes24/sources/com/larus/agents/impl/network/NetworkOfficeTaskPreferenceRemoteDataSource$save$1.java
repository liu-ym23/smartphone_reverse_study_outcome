package com.larus.agents.impl.network;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.agents.impl.network.NetworkOfficeTaskPreferenceRemoteDataSource", f = "AgentsMdApi.kt", i = {}, l = {91}, m = "save", n = {}, s = {})
public final class NetworkOfficeTaskPreferenceRemoteDataSource$save$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NetworkOfficeTaskPreferenceRemoteDataSource this$0;

    public NetworkOfficeTaskPreferenceRemoteDataSource$save$1(NetworkOfficeTaskPreferenceRemoteDataSource r1, Continuation<? super NetworkOfficeTaskPreferenceRemoteDataSource$save$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= LKBaseResponseModel.DEFAULT_ERROR_CODE;
        return this.this$0.b(null, this);
    }
}
