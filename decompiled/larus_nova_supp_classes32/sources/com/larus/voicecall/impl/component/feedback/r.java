package com.larus.voicecall.impl.component.feedback;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import com.larus.bmhome.auth.FeedbackMeta;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.api.e0;
import com.larus.bmhome.praise.IAiChatPraiseTriggerService;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.MsgFeedbackType;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import hq9.q3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class r implements q3 {
    public boolean a;
    public final /* synthetic */ RealtimeCallFeedbackComponent b;

    public final void c() {
    }

    public final void a() {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("[showRealtimeFeedbackNotification.onDialogCloseByUserMoveUp]: callId = ");
        RealtimeCallFeedbackComponent r2 = this.b;
        int r3 = RealtimeCallFeedbackComponent.u;
        r1.append(r2.m3().e);
        r0.i("RealtimeCallFeedbackComponent", r1.toString());
    }

    public r(RealtimeCallFeedbackComponent r1) {
        this.b = r1;
    }

    public final void b(boolean r14) {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("[showRealtimeFeedbackNotification.onFeedbackClick]: isLike = ");
        r1.append(r14);
        r1.append(", callId = ");
        RealtimeCallFeedbackComponent r2 = this.b;
        int r3 = RealtimeCallFeedbackComponent.u;
        r1.append(r2.m3().e);
        r1.append(", feedbackClicked = ");
        r1.append(this.a);
        r0.i("RealtimeCallFeedbackComponent", r1.toString());
        if (this.a == false) goto L5;
        return;
    L5:
        this.a = true;
        String r4 = NameKeys.UnloadStrategy_No_Strategy;
        if (r14 == false) goto L25;
        RealtimeCallFeedbackComponent r6 = this.b;
        r6.getClass();
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new RealtimeCallFeedbackComponent$onFeedbackLikeCall$1(r6, null), 2, null);
        IAiChatPraiseTriggerService r5 = (IAiChatPraiseTriggerService) ServiceManager.get().getService(IAiChatPraiseTriggerService.class);
        if (r5 != null) goto L10;
    L12:
        boolean r7 = false;
    L13:
        if (r7 == true) goto L15;
    L24:
        t19.s r8 = t19.s.a;
        Context r9 = r6.getContext();
        r8.getClass();
        t19.s.o(r9, 2131901665, false);
    L60:
        int r10 = s.a;
        FLogger.a.i("RealtimeFeedbackNotificationFrequencyManager", "[recordFeedbackInteracted]");
        u.a().storeInt("consecutive_shown_count", 0);
        u.a().storeLong("last_consecutive_shown_ts", 0);
        String r11 = this.b.m3().e;
        if (r14 == false) goto L63;
        String r15 = "like";
    L64:
        v.a(r11, r15);
        return;
    L63:
        r15 = "dislike";
        goto L64
    L15:
        if (u.a().getBoolean("shown_end_call_praise_dialog", false) == true) goto L24;
        r0.i("RealtimeCallFeedbackComponent", "[onFeedbackLikeCall]: tryShowPraiseDialog, callId = " + r6.m3().e);
        IAiChatPraiseTriggerService r12 = (IAiChatPraiseTriggerService) ServiceManager.get().getService(IAiChatPraiseTriggerService.class);
        if (r12 == null) goto L23;
        String r13 = r6.m3().e;
        if (r13 == null) goto L22;
        r4 = r13;
    L22:
        IAiChatPraiseTriggerService.a.a(r12, r4, "phone_call", 8);
    L23:
        u.a().storeBoolean("shown_end_call_praise_dialog", true);
        goto L60
    L10:
        if (r5.a() != true) goto L12;
        r7 = true;
        goto L13
    L25:
        final RealtimeCallFeedbackComponent r16 = this.b;
        r16.getClass();
        AppCompatActivity r17 = AppHost.a.a().getCurrentActivity();
        if ((r17 instanceof AppCompatActivity) == false) goto L28;
        final AppCompatActivity r18 = r17;
    L29:
        if (r18 == null) goto L60;
        if (r18.isDestroyed() == false) goto L34;
    L59:
        r0.i("RealtimeCallFeedbackComponent", "[onFeedbackDislikeCall]: topActivity is destroyed or finishing, callId = " + r16.m3().e);
        goto L60
    L34:
        if (r18.isFinishing() == true) goto L59;
        e0 r19 = (e0) AuthModelDelegate.b.e().getValue();
        if (r19 == null) goto L39;
        LaunchInfo r20 = r19.a;
    L40:
        if (r20 != null) goto L42;
        r0.i("RealtimeCallFeedbackComponent", "[onFeedbackDislikeCall]: launchInfo is null, callId = " + r16.m3().e);
        goto L60
    L42:
        ArrayList r21 = new ArrayList();
        List r22 = r20.o();
        if (r22 == null) goto L54;
        ArrayList r23 = new ArrayList();
        Iterator r24 = r22.iterator();
    L46:
        if (r24.hasNext() == false) goto L53;
        Object r110 = r24.next();
        if (((FeedbackMeta) r110).c() != MsgFeedbackType.MsgFeedbackTypeDislike.value) goto L50;
        boolean r111 = true;
    L51:
        if (r111 == false) goto L46;
        r23.add(r110);
        goto L46
    L50:
        r111 = false;
        goto L51
    L53:
        r21.addAll(r23);
    L54:
        String r25 = r20.q();
        if (r25 == null) goto L58;
        r4 = r25;
    L58:
        r16.no(r18, r18.getSupportFragmentManager(), new a(r21, r4, null), new RealtimeCallFeedbackComponent$onFeedbackDislikeCall$3(r18, r16));
        goto L60
    L39:
        r20 = null;
        goto L40
    L28:
        r18 = null;
        goto L29
    }
}
