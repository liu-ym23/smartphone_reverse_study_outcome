package com.larus.agents.impl.network;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.agents.impl.network.NetworkWorkExperienceRepository", f = "WorkExperienceApi.kt", i = {0, 0}, l = {230}, m = "mutation", n = {"operation", "isValidData"}, s = {"L$0", "L$1"})
public final class NetworkWorkExperienceRepository$mutation$1<T> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NetworkWorkExperienceRepository this$0;

    public NetworkWorkExperienceRepository$mutation$1(NetworkWorkExperienceRepository r1, Continuation<? super NetworkWorkExperienceRepository$mutation$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r8) {
        this.result = r8;
        this.label |= LKBaseResponseModel.DEFAULT_ERROR_CODE;
        NetworkWorkExperienceRepository r0 = this.this$0;
        int r9 = NetworkWorkExperienceRepository.a;
        return r0.h(null, null, null, null, null, this);
    }
}
