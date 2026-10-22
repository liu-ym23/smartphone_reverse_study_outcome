package com.larus.agents.impl.settings;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import com.larus.audio.call.dora.CommandStatus;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.agents.impl.settings.DefaultOfficeTaskPreferenceRepository", f = "OfficeTaskPreferenceRepository.kt", i = {0, 0, 1, 1, 2, 2, 5, 5, 5, 5, 6, 6, 6, 6, 7, 7}, l = {164, 45, 46, WheelView.WHEEL_ITEM_HEIGHT, CommandStatus.DORA_REVERT_NEXT_CALL_ADD_CHAT_EXTRA, 174, 56, 63}, m = "get", n = {"accountId", "$this$withLock_u24default$iv", "accountId", "$this$withLock_u24default$iv", "accountId", "cachedRevision", "accountId", "remotePreference", "$this$withLock_u24default$iv", "cachedRevision", "accountId", "remotePreference", "$this$withLock_u24default$iv", "cachedRevision", "remotePreference", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "J$0", "L$0", "L$1", "L$2", "J$0", "L$0", "L$1", "L$2", "J$0", "L$0", "L$1"})
public final class DefaultOfficeTaskPreferenceRepository$get$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DefaultOfficeTaskPreferenceRepository this$0;

    public DefaultOfficeTaskPreferenceRepository$get$1(DefaultOfficeTaskPreferenceRepository r1, Continuation<? super DefaultOfficeTaskPreferenceRepository$get$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= LKBaseResponseModel.DEFAULT_ERROR_CODE;
        return this.this$0.a(this);
    }
}
