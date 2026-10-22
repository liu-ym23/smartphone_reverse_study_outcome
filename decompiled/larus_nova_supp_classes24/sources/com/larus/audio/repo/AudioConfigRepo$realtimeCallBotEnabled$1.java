package com.larus.audio.repo;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.audio.repo.AudioConfigRepo", f = "AudioConfigRepo.kt", i = {}, l = {575}, m = "realtimeCallBotEnabled", n = {}, s = {})
public final class AudioConfigRepo$realtimeCallBotEnabled$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AudioConfigRepo this$0;

    public AudioConfigRepo$realtimeCallBotEnabled$1(AudioConfigRepo r1, Continuation<? super AudioConfigRepo$realtimeCallBotEnabled$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= LKBaseResponseModel.DEFAULT_ERROR_CODE;
        return this.this$0.u(null, this);
    }
}
