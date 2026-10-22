package com.larus.bmhome.chat.model.strategy;

import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.chat.api.BotApi;
import com.larus.bmhome.chat.model.repo.BotRepo;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.BotOnBoarding;
import com.larus.network.http.f;
import com.larus.utils.logger.FLogger;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class RealtimeFirstMetStrategy {
    public final Set<String> a;

    public static final class a {
    }

    static {
    }

    public RealtimeFirstMetStrategy() {
        this.a = new LinkedHashSet();
    }

    public final void b(String r15, BotModel r16) {
        if (r15 != null) goto L5;
        return;
    L5:
        if (r16 != null) goto L8;
        return;
    L8:
        if (r16.getOnBoarding() != null) goto L10;
        c(r16, r15, null, null);
    L10:
        BotOnBoarding r4 = r16.getOnBoarding();
        if (r4 != null) goto L13;
        return;
    L13:
        Ref.ObjectRef r5 = new Ref.ObjectRef();
        boolean r6 = true;
        if (r4.getCallMode() != 1) goto L16;
    L19:
        if (r6 == true) goto L23;
        FLogger.a.d("RealtimeFirstMetStrategy", "updateLocalOnboarding called, only should fetch first met allow");
        c(r16, r15, r4, null);
        return;
    L23:
        if (this.a.contains(r15) == false) goto L25;
        return;
    L25:
        this.a.add(r15);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new RealtimeFirstMetStrategy$asyncUpdateLocalOnBoardingByRealtime$1(r15, this, r16, r4, r5, null), 3, null);
        return;
    L16:
        if (r4.getCallMode() == 2) goto L19;
        r6 = false;
        goto L19
    }

    public static final Object a(RealtimeFirstMetStrategy r6, String r7, Continuation r8) {
        r6.getClass();
        if ((r8 instanceof RealtimeFirstMetStrategy$requireLocalOnBoardingMsg$1) == false) goto L7;
        RealtimeFirstMetStrategy$requireLocalOnBoardingMsg$1 r0 = (RealtimeFirstMetStrategy$requireLocalOnBoardingMsg$1) r8;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        ResultKt.throwOnFailure(r9);
    L17:
        f r11 = (com.larus.network.http.a) r9;
        if ((r11 instanceof f) == false) goto L20;
        FLogger.a.d("RealtimeFirstMetStrategy", "requireLocalOnBoardingMsg called, fetch first met fail, reason: " + r11.d);
        return null;
    L20:
        com.larus.bmhome.chat.bean.BotOnBoarding r12 = (com.larus.bmhome.chat.bean.BotOnBoarding) ((com.larus.network.http.a) r11).b;
        if (r12 != null) goto L24;
        return r12;
    L24:
        return new BotOnBoarding(r12.d(), r12.e(), r12.b(), r12.a(), r12.c());
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        RepoDispatcher.a.getClass();
        BotRepo r13 = RepoDispatcher.g;
        r0.label = 1;
        r13.getClass();
        BotRepo.a().getClass();
        r9 = BotApi.d(r7, r0);
        if (r9 != r10) goto L17;
        return r10;
    L7:
        r0 = new RealtimeFirstMetStrategy$requireLocalOnBoardingMsg$1(r6, r8);
        goto L8
    }

    public static void c(BotModel r5, String r6, BotOnBoarding r7, BotOnBoarding r8) {
        Intrinsics.checkNotNullParameter(r5, "bot");
        int r0 = 0;
        if (r7 != null) goto L5;
        boolean r2 = true;
    L6:
        if (r7 != null) goto L8;
        boolean r3 = true;
    L9:
        if (r7 == null) goto L16;
        if (r8 != null) goto L12;
    L13:
        r2 = r7.isMessageListContentEmpty();
        r3 = com.larus.bmhome.chat.bean.d.u0(r7);
    L14:
        if (r8 == null) goto L16;
        r2 = r8.isMessageListContentEmpty();
        r3 = com.larus.bmhome.chat.bean.d.u0(r8);
        goto L16
    L12:
        if (r7.getCanUseBackUp() == false) goto L14;
    L16:
        String r9 = r5.getBotId();
        if (r7 == null) goto L19;
        Integer r10 = Integer.valueOf(r7.getCallMode());
    L20:
        Boolean r11 = Boolean.valueOf(r3);
        Boolean r4 = Boolean.valueOf(r2);
        JSONObject r12 = new JSONObject();
        Intrinsics.checkNotNullParameter(r12, "params");
        if (r9 != null) goto L40;
    L25:
        if (r6 == null) goto L27;
        r12.put("conversation_id", r6);     // Catch: JSONException -> L23
    L27:
        if (r10 == null) goto L29;
        r12.put("call_mode", r10.intValue());     // Catch: JSONException -> L23
    L29:
        if (r11 != null) goto L31;
    L34:
        if (r4 == null) goto L38;
        r12.put("content_empty", r4.booleanValue() ? 1 : 0);     // Catch: JSONException -> L23
    L23:
        e = move-exception;
        FLogger.a.e("FirstMeetEventHelper", "error in FirstMeetEventHelper showDevOnBoardingCard " + e.getLocalizedMessage());
    L38:
        TrackParams r13 = new TrackParams().merge(r12);
        by7.a r14 = new by7.a("dev_create_local_cvs_onboarding");
        r14.a.merge(r13);
        r14.b();
        return;
    L31:
        if (r11.booleanValue() == false) goto L33;
        r0 = 1;
    L33:
        r12.put("suggest_empty", r0);     // Catch: JSONException -> L23
        goto L34
    L40:
        r12.put("bot_id", r9);     // Catch: JSONException -> L23
        goto L25
    L19:
        r10 = null;
        goto L20
    L8:
        r3 = false;
        goto L9
    L5:
        r2 = false;
        goto L6
    }
}
