package com.larus.voicecall.api;

import androidx.fragment.app.FragmentManager;
import b3a.b;
import b3a.c;
import com.larus.im.bean.bot.BotModel;
import com.larus.platform.model.EditPos;
import com.larus.voicecall.api.bean.SpeechAecDownloadResult;
import com.obric.aivoice.core.data.NameKeys;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import z2a.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J*\u0010\u000e\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0016J\"\u0010\u000e\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0007H\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0016J\b\u0010\u0015\u001a\u00020\u000bH\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u0017\u001a\u00020\u0007H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0017\u0010\u001c\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0002\u0010\u001eJ\u0018\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0007H\u0016J \u0010#\u001a\u00020\u00052\u0006\u0010 \u001a\u00020!2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u000bH\u0016J(\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020)2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010*J*\u0010'\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0016J!\u0010+\u001a\u00020\u00072\b\u0010,\u001a\u0004\u0018\u00010\u000b2\b\u0010-\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0002\u0010.J\b\u0010/\u001a\u000200H\u0016J\b\u00101\u001a\u00020\u0007H\u0016J\b\u00102\u001a\u00020\u0007H\u0016J\u0010\u00103\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u0007H\u0016J\u0010\u00105\u001a\u00020\u00052\u0006\u00106\u001a\u00020\u000bH\u0016J \u00107\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u000b2\u0006\u00108\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020\u0007H\u0016J \u00109\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u000b2\u0006\u00108\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020\u0007H\u0016J.\u0010:\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u000b0;2\u0006\u0010&\u001a\u00020\u000b2\u0006\u00108\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020\u0007H\u0016J\u0010\u0010<\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020\u0007H\u0016J\u0018\u0010=\u001a\u00020\u00052\u000e\u0010>\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010?H\u0016J\u001e\u0010@\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010A2\u0006\u0010&\u001a\u00020\u000bH\u0016J\b\u0010B\u001a\u00020\u0007H\u0016J\u0010\u0010C\u001a\u00020\u00052\u0006\u0010D\u001a\u00020\u0007H\u0016J\b\u0010E\u001a\u00020\u0007H\u0016J\"\u0010F\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010G\u001a\u00020\u000b2\b\u0010H\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010I\u001a\u00020\u00052\b\u0010J\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010K\u001a\u00020\u00052\b\u0010J\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010L\u001a\u00020\u00052\b\u0010J\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010M\u001a\u00020\u00052\u0006\u0010N\u001a\u00020OH\u0016J\u0010\u0010P\u001a\u00020\u00052\u0006\u0010N\u001a\u00020OH\u0016J\u0010\u0010Q\u001a\u00020\u00052\u0006\u0010R\u001a\u00020SH\u0016J\u0018\u0010T\u001a\u00020\u00052\u0006\u0010U\u001a\u00020\u000b2\u0006\u0010V\u001a\u00020WH\u0016¨\u0006X"}, d2 = {"Lcom/larus/voicecall/api/VoiceCallServiceNoop;", "Lcom/larus/voicecall/api/IVoiceCallService;", "<init>", "()V", "initAVKit", NameKeys.UnloadStrategy_No_Strategy, "isInRealtimeCall", NameKeys.UnloadStrategy_No_Strategy, "isTopRealtimeCallActivity", "getTranslucentPages", NameKeys.UnloadStrategy_No_Strategy, NameKeys.UnloadStrategy_No_Strategy, "buildConnectionConfig", "Lcom/larus/voicecall/api/bean/PreConnectConfig;", "isRealtimeCallEnable", "botModel", "Lcom/larus/im/bean/bot/BotModel;", "conversationId", "enableSilence", "isEditable", "curPlayingConversationId", "curPlayingBotId", "currentSceneKey", "isSupportNoSpeakingHangup", "getNoSpeakingHangupDuration", NameKeys.UnloadStrategy_No_Strategy, "getLocationPermissionState", NameKeys.UnloadStrategy_No_Strategy, "isRealtimeCallDowngradeOut", "botType", "(Ljava/lang/Integer;)Z", "startRealtimeCallNewOut", "bean", "Lcom/larus/voicecall/api/bean/StartCallPayLoadBean;", "hasReportClickCall", "startRealtimeCallWithJudgeOut", "manager", "Landroidx/fragment/app/FragmentManager;", "scene", "isRealtimeCallEnabledOut", "editPos", "Lcom/larus/platform/model/EditPos;", "(Lcom/larus/platform/model/EditPos;Lcom/larus/im/bean/bot/BotModel;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isMainBot", "botConversationId", "botConversationType", "(Ljava/lang/String;Ljava/lang/Integer;)Z", "getRtcNotificationService", "Lcom/larus/voicecall/api/IRtcNotificationService;", "getIsRealtimeUseCallModeAtStart", "isRealtimeSkipBtConnPermission", "autoStartFromNextRoundFrame", "silent", "requestRealtimeCallDegradeConfig", "callFrom", "realtimeCallDowngradeHookShow", "entrance", "realtimeCallDowngradeHookClick", "realtimeCallDowngradeHookClickV2", "Lkotlin/Pair;", "getRealtimeCallTtsConfig", "setOnRealtimeConfigChangeCallback", "callback", "Lkotlin/Function0;", "getDowngradeExtra", NameKeys.UnloadStrategy_No_Strategy, "isPseudoConnectEnabled", "changeFullScreenCallSwitch", "isFullScreen", "isFullScreenCall", "isUseContinueTalk", "botId", "bot", "handleMuseumInAppNotification", "rawNotify", "trackMuseumExtensionGeneralNotificationShow", "pickMuseumExtensionFromNotification", "registerMuseumInAppNotificationListener", "listener", "Lcom/larus/voicecall/api/MuseumInAppNotificationListener;", "unregisterMuseumInAppNotificationListener", "setAecModelMeta", "meta", "Lcom/larus/voicecall/api/bean/SpeechAecModelMeta;", "setAecDownloadResult", "collectionName", "result", "Lcom/larus/voicecall/api/bean/SpeechAecDownloadResult;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VoiceCallServiceNoop implements IVoiceCallService {

    public static final class a implements IRtcNotificationService {
        public final MutableSharedFlow a;

        public a() {
            this.a = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 6, null);
        }

        @Override // com.larus.voicecall.api.IRtcNotificationService
        public final MutableSharedFlow a() {
            return this.a;
        }
    }

    public VoiceCallServiceNoop() {
    }

    public final void B(String r1) {
    }

    public final void C() {
    }

    public final boolean D() {
        return false;
    }

    public final boolean E(String r1, Integer r2) {
        return true;
    }

    public final boolean F() {
        return false;
    }

    public final long G() {
        return 0;
    }

    public final String H() {
        return NameKeys.UnloadStrategy_No_Strategy;
    }

    public final String I() {
        return NameKeys.UnloadStrategy_No_Strategy;
    }

    public final void J(c r2, FragmentManager r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "bean");
        Intrinsics.checkNotNullParameter(r3, "manager");
        Intrinsics.checkNotNullParameter(r4, "scene");
    }

    public final void L(d r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
    }

    public final void M(com.larus.audio.tts.a r1) {
    }

    public final int N() {
        return 0;
    }

    public final boolean b(boolean r1) {
        return false;
    }

    public final Map c() {
        Intrinsics.checkNotNullParameter("avsdk", "scene");
        return null;
    }

    public final boolean d() {
        return false;
    }

    public final boolean e() {
        return false;
    }

    public final void g(String r1) {
    }

    public final void h(String r1) {
    }

    public final boolean i() {
        return false;
    }

    public final void j(d r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
    }

    public final String k(boolean r1) {
        return NameKeys.UnloadStrategy_No_Strategy;
    }

    public final boolean l() {
        return false;
    }

    public final void m(String r2, SpeechAecDownloadResult r3) {
        Intrinsics.checkNotNullParameter(r2, "collectionName");
        Intrinsics.checkNotNullParameter(r3, "result");
    }

    public final void n(b r2) {
        Intrinsics.checkNotNullParameter(r2, "meta");
    }

    public final boolean o(String r1, String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "scene");
        Intrinsics.checkNotNullParameter(r2, "entrance");
        return false;
    }

    public final boolean p() {
        return false;
    }

    public final boolean q(String r1, String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "scene");
        Intrinsics.checkNotNullParameter(r2, "entrance");
        return false;
    }

    public final boolean r(BotModel r1, String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "conversationId");
        return false;
    }

    public final String s() {
        return null;
    }

    public final void t(c r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "bean");
    }

    public final boolean u(String r1, String r2, BotModel r3) {
        Intrinsics.checkNotNullParameter(r1, "conversationId");
        Intrinsics.checkNotNullParameter(r2, "botId");
        return false;
    }

    public final void w(String r2) {
        Intrinsics.checkNotNullParameter(r2, "callFrom");
    }

    public final boolean x(BotModel r1, String r2, boolean r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "conversationId");
        return false;
    }

    public final void y(boolean r1) {
    }

    public final boolean z(Integer r1) {
        return false;
    }

    public final IRtcNotificationService K() {
        return new a();
    }

    public final b3a.a v() {
        return new b3a.a(null, null, 0);
    }

    public final List<String> a() {
        return CollectionsKt.emptyList();
    }

    public final Pair A(String r3) {
        Intrinsics.checkNotNullParameter(r3, "scene");
        Intrinsics.checkNotNullParameter("other", "entrance");
        return new Pair(Boolean.FALSE, null);
    }

    public final Object f(EditPos r1, BotModel r2, String r3, Continuation<? super Boolean> r4) {
        return Boxing.boxBoolean(false);
    }
}
