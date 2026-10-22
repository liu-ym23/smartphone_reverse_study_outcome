package com.larus.voicecall.obric;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import b78.h;
import com.larus.audio.call.a;
import com.larus.audio.call.arch.c;
import com.larus.audio.call.plugins.c1;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.im.bean.message.Message;
import com.obric.aivoice.core.data.NameKeys;
import d4a.b;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u0016J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016JZ\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000f2\u000e\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u00192\u0006\u0010\u001b\u001a\u00020\u00052 \u0010\u001c\u001a\u001c\u0012\u0004\u0012\u00020\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001dH\u0016J\u0016\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\"H\u0096@¢\u0006\u0002\u0010#J\u0086\u0001\u0010$\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\u000f2\b\u0010)\u001a\u0004\u0018\u00010*2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000f0,2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u000f0,2\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0/2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u000f0,2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u000f0,2\u0006\u00102\u001a\u00020\u0007H\u0016J\u0010\u00103\u001a\u00020\u00052\u0006\u00104\u001a\u000205H\u0016J\u0010\u00106\u001a\u0002072\u0006\u0010!\u001a\u00020\u001eH\u0016J\b\u00108\u001a\u00020\u0005H\u0016J\b\u00109\u001a\u00020\u0005H\u0016J\b\u0010:\u001a\u00020;H\u0016J\b\u0010<\u001a\u00020\u0005H\u0016J\u0012\u0010=\u001a\u00020\u000f2\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J\b\u0010@\u001a\u00020\u0007H\u0016J\b\u0010A\u001a\u00020BH\u0016J\b\u0010C\u001a\u00020\u0007H\u0016J\u0010\u0010D\u001a\u00020\u000b2\u0006\u0010E\u001a\u00020FH\u0016J\u0010\u0010G\u001a\u00020\u000b2\u0006\u0010E\u001a\u00020FH\u0016J\b\u0010H\u001a\u00020\u000fH\u0016J\u0010\u0010I\u001a\u00020\u00052\u0006\u0010J\u001a\u00020KH\u0016J\b\u0010L\u001a\u00020\u0005H\u0016J\b\u0010M\u001a\u00020\u000fH\u0016J\u001c\u0010N\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0O2\u0006\u0010P\u001a\u00020QH\u0016J\u0012\u0010R\u001a\u0004\u0018\u00010Q2\u0006\u0010S\u001a\u00020TH\u0016J\u0010\u0010U\u001a\u00020\u000b2\u0006\u0010S\u001a\u00020TH\u0016¨\u0006V"}, d2 = {"Lcom/larus/voicecall/obric/ObricRealtimeCallServiceNoop;", "Lcom/larus/voicecall/obric/IObricRealtimeCallService;", "<init>", "()V", "isRealtimeCallDowngradeByCall", NameKeys.UnloadStrategy_No_Strategy, "botType", NameKeys.UnloadStrategy_No_Strategy, "(Ljava/lang/Integer;)Z", "isRtcEnabled", "setIsInCall", NameKeys.UnloadStrategy_No_Strategy, "isInCall", "bindForegroundService", "reason", NameKeys.UnloadStrategy_No_Strategy, "unBindAndDismissForegroundService", "generateRealtimeCallService", "Lcom/larus/audio/call/AbsRealtimeCallService;", "sessionCreator", "Lcom/larus/audio/call/utils/IAudioSessionCreator;", "spanWrap", "Lcom/larus/trace/tracespan/span/ITraceSpanWrap;", "spanScene", "lifecycleScope", "Lkotlin/Function0;", "Lkotlinx/coroutines/CoroutineScope;", "skipDowngradePluginForClickTalk", "collectBizPlugin", "Lkotlin/Function2;", "Lcom/larus/audio/call/arch/ICommonPluginContext;", "Lcom/larus/audio/call/arch/ILLMPluginRegistry;", "initRealtimeCallParams", "context", "Landroid/content/Context;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onRealtimeDestroy", "botId", "localConversationId", "conversationId", "localCallId", "tracer", "Lcom/larus/audio/call/tracer/IRealtimeCallTracer;", "imAsrMsgNum", "Ljava/util/concurrent/CopyOnWriteArraySet;", "imTtsMsgNum", "imTtsPreQueryMsgMap", "Ljava/util/concurrent/ConcurrentHashMap;", "vuiAsrMsgIdSet", "vuiChatRespMsgIdSet", "vuiTtsRespMsgNum", "isQuery", "msg", "Lcom/larus/im/bean/message/Message;", "getPlugin", "Lcom/larus/audio/call/plugins/IUIStatePluginProvider;", "isCurrentSessionUsingOneshot", "isAutoInterrupt", "buildConnectionConfig", "Lcom/larus/im/service/IMediaService$PreConnectConfig;", "enableSubtitleAsrSeg", "getRealtimeStyleId", "speaker", "Lcom/larus/im/bean/bot/SpeakerVoice;", "callSampleRate", "getTargetLoudness", NameKeys.UnloadStrategy_No_Strategy, "getLoudNormAlgoType", "addRealtimeCallActivityStateCallback", "callback", "Lcom/larus/voicecall/obric/IObricRealtimeCallService$IObricRealtimeCallActivityStateListener;", "removeRealtimeCallActivityStateCallback", "getRealtimeCallActivityName", "isRealtimeCallActivity", "ac", "Landroid/app/Activity;", "isScreenShareEnable", "getFlagArgumentLandingFeatureScene", "getConversationIdAndBotId", "Lkotlin/Pair;", "fragment", "Landroidx/fragment/app/Fragment;", "getRealtimeCallFragment", "activity", "Landroidx/fragment/app/FragmentActivity;", "preCloseCamera", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricRealtimeCallServiceNoop implements IObricRealtimeCallService {
    public ObricRealtimeCallServiceNoop() {
    }

    public final boolean a() {
        return false;
    }

    public final float b() {
        return 0.0f;
    }

    public final int c() {
        return 0;
    }

    public final boolean d(Integer r1) {
        return true;
    }

    public final int e() {
        return 0;
    }

    public final boolean g() {
        return false;
    }

    public final String h(SpeakerVoice r1) {
        return NameKeys.UnloadStrategy_No_Strategy;
    }

    public final boolean i(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        return false;
    }

    public final void k(FragmentActivity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
    }

    public final void l(IObricRealtimeCallService.a r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
    }

    public final void m() {
    }

    public final boolean n() {
        return false;
    }

    public final Fragment p(FragmentActivity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        return null;
    }

    public final String q() {
        return NameKeys.UnloadStrategy_No_Strategy;
    }

    public final boolean s(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "ac");
        return false;
    }

    public final void t(String r2, String r3, String r4, String r5, CopyOnWriteArraySet r6, CopyOnWriteArraySet r7, ConcurrentHashMap r8, CopyOnWriteArraySet r9, CopyOnWriteArraySet r10) {
        Intrinsics.checkNotNullParameter(r2, "botId");
        Intrinsics.checkNotNullParameter(r3, "localConversationId");
        Intrinsics.checkNotNullParameter(r4, "conversationId");
        Intrinsics.checkNotNullParameter(r5, "localCallId");
        Intrinsics.checkNotNullParameter(r6, "imAsrMsgNum");
        Intrinsics.checkNotNullParameter(r7, "imTtsMsgNum");
        Intrinsics.checkNotNullParameter(r8, "imTtsPreQueryMsgMap");
        Intrinsics.checkNotNullParameter(r9, "vuiAsrMsgIdSet");
        Intrinsics.checkNotNullParameter(r10, "vuiChatRespMsgIdSet");
    }

    public final String u() {
        return NameKeys.UnloadStrategy_No_Strategy;
    }

    public final Pair<String, String> j(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        return TuplesKt.to(NameKeys.UnloadStrategy_No_Strategy, NameKeys.UnloadStrategy_No_Strategy);
    }

    public final c1 o(c r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return b.a;
    }

    public final Object r(Context r1, Continuation<? super Unit> r2) {
        return Unit.INSTANCE;
    }

    public final a f(h r1, com.larus.trace.tracespan.span.b r2, Function0 r3, boolean r4, Function2 r5) {
        Intrinsics.checkNotNullParameter(r1, "sessionCreator");
        Intrinsics.checkNotNullParameter(r2, "spanWrap");
        Intrinsics.checkNotNullParameter("continuous_talk", "spanScene");
        Intrinsics.checkNotNullParameter(r3, "lifecycleScope");
        return new d4a.a();
    }
}
