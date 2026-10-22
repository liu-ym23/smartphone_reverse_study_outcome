package com.larus.agents.impl.network;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.agents.impl.network.CachedWorkExperienceRepository", f = "WorkExperienceApi.kt", i = {0, 1}, l = {392, 395}, m = "create", n = {"accountId", "result"}, s = {"L$0", "L$0"})
public final class CachedWorkExperienceRepository$create$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CachedWorkExperienceRepository this$0;

    public CachedWorkExperienceRepository$create$1(CachedWorkExperienceRepository r1, Continuation<? super CachedWorkExperienceRepository$create$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= LKBaseResponseModel.DEFAULT_ERROR_CODE;
        return this.this$0.a(null, this);
    }
}
