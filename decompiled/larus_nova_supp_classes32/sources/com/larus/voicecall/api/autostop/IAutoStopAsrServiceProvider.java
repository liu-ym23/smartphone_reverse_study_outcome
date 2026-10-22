package com.larus.voicecall.api.autostop;

import a3a.c;
import com.larus.asr.session.clicktalk.s;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\bg\u0018\u00002\u00020\u0001JD\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\"\b\u0002\u0010\t\u001a\u001c\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\f\u0012\u0004\u0012\u00020\r\u0018\u00010\nH&¨\u0006\u000e"}, d2 = {"Lcom/larus/voicecall/api/autostop/IAutoStopAsrServiceProvider;", NameKeys.UnloadStrategy_No_Strategy, "create", "Lcom/larus/voicecall/api/autostop/AutoStopAsrService;", "eventListener", "Lcom/larus/voicecall/api/autostop/AutoStopAsrEventListener;", "lifecycleScope", "Lkotlin/Function0;", "Lkotlinx/coroutines/CoroutineScope;", "collectBizPlugin", "Lkotlin/Function2;", "Lcom/larus/audio/call/arch/ICommonPluginContext;", "Lcom/larus/audio/call/arch/ILLMPluginRegistry;", NameKeys.UnloadStrategy_No_Strategy, "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IAutoStopAsrServiceProvider {
    c a(s r1, Function0 r2, Function2 r3);
}
