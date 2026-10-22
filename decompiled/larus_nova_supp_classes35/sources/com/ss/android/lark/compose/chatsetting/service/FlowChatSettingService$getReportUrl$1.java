package com.ss.android.lark.compose.chatsetting.service;

import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.compose.chatsetting.service.FlowChatSettingService", f = "FlowChatSettingService.kt", i = {}, l = {23}, m = "getReportUrl", n = {}, s = {})
public final class FlowChatSettingService$getReportUrl$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowChatSettingService this$0;

    public FlowChatSettingService$getReportUrl$1(FlowChatSettingService r1, Continuation<? super FlowChatSettingService$getReportUrl$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= PluginList.LEVEL_NOT_SET;
        return this.this$0.a(null, this);
    }
}
