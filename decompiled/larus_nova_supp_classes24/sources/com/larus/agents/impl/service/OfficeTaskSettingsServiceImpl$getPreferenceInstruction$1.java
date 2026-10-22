package com.larus.agents.impl.service;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import com.larus.audio.call.dora.CommandStatus;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.agents.impl.service.OfficeTaskSettingsServiceImpl", f = "OfficeTaskSettingsServiceImpl.kt", i = {}, l = {CommandStatus.DORA_VISION_INTENTION}, m = "getPreferenceInstruction", n = {}, s = {})
public final class OfficeTaskSettingsServiceImpl$getPreferenceInstruction$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OfficeTaskSettingsServiceImpl this$0;

    public OfficeTaskSettingsServiceImpl$getPreferenceInstruction$1(OfficeTaskSettingsServiceImpl r1, Continuation<? super OfficeTaskSettingsServiceImpl$getPreferenceInstruction$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= LKBaseResponseModel.DEFAULT_ERROR_CODE;
        return this.this$0.c(this);
    }
}
