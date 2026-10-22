package com.larus.bmhome.chat.component.feedback;

import android.content.Context;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.ixigua.lib.track.TrackParams;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import com.larus.im.bean.bot.BotModel;
import com.larus.platform.model.RecommendFrom;
import com.larus.utils.logger.FLogger;
import de8.c;
import hq9.q3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import org.json.JSONException;
import org.json.JSONObject;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class BotFeedbackComponent$b implements q3 {
    public final /* synthetic */ BotFeedbackComponent a;

    public final void c() {
    }

    public final void a() {
        FlowCommonAppCompatActivity r0 = AppHost.a.a().getCurrentActivity();
        String r2 = null;
        if ((r0 instanceof FlowCommonAppCompatActivity) == false) goto L5;
        FlowCommonAppCompatActivity r1 = r0;
    L6:
        BotModel r3 = this.a.o;
        if (r3 == null) goto L9;
        String r4 = r3.getBotId();
    L10:
        String r5 = this.a.j;
        if (r1 == null) goto L13;
        String r6 = r1.k();
    L14:
        c r7 = this.a.h;
        if (r7 == null) goto L19;
        RecommendFrom r8 = r7.d;
        if (r8 == null) goto L19;
        r2 = r8.b;
    L19:
        String r9 = BotFeedbackComponent.P2();
        JSONObject r10 = new JSONObject();
        Intrinsics.checkNotNullParameter(r10, "params");
        if (r4 != null) goto L35;
    L24:
        if (r5 == null) goto L26;
        r10.put("chat_type", r5);     // Catch: JSONException -> L22
    L26:
        if (r6 == null) goto L28;
        r10.put("current_page", r6);     // Catch: JSONException -> L22
    L28:
        if (r2 == null) goto L30;
        r10.put("req_id", r2);     // Catch: JSONException -> L22
    L30:
        r10.put("recommend_from", r9);     // Catch: JSONException -> L22
    L33:
        TrackParams r11 = new TrackParams().merge(r10);
        by7.a r12 = new by7.a("bot_feedback_banner_slide_up");
        r12.a.merge(r11);
        r12.b();
        return;
    L22:
        e = move-exception;
        FLogger.a.e("BotFeedbackHelper", "error in mobBotFeedbackBannerSlideUp " + e.getLocalizedMessage());
        goto L33
    L35:
        r10.put("bot_id", r4);     // Catch: JSONException -> L22
        goto L24
    L13:
        r6 = null;
        goto L14
    L9:
        r4 = null;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    public BotFeedbackComponent$b(BotFeedbackComponent r1) {
        this.a = r1;
    }

    public final void b(boolean r11) {
        FLogger.a.i("BotFeedbackComponent" + hashCode(), "isLike: " + r11);
        AppHost.Companion r0 = AppHost.a;
        FlowCommonAppCompatActivity r1 = r0.a().getCurrentActivity();
        if ((r1 instanceof FlowCommonAppCompatActivity) == false) goto L5;
        FlowCommonAppCompatActivity r2 = r1;
    L6:
        s r3 = s.a;
        Context r4 = r0.getApplication().getApplicationContext();
        r3.getClass();
        s.o(r4, 2131900213, false);
        BotModel r5 = this.a.o;
        if (r5 == null) goto L9;
        String r6 = r5.getBotId();
    L10:
        String r7 = this.a.j;
        if (r2 == null) goto L13;
        String r8 = r2.k();
    L14:
        if (r11 == false) goto L16;
        String r9 = "like";
    L17:
        c r10 = this.a.h;
        if (r10 == null) goto L22;
        RecommendFrom r12 = r10.d;
        if (r12 == null) goto L22;
        String r13 = r12.b;
    L23:
        String r14 = BotFeedbackComponent.P2();
        JSONObject r15 = new JSONObject();
        Intrinsics.checkNotNullParameter(r15, "params");
        if (r6 != null) goto L47;
    L28:
        if (r7 == null) goto L30;
        r15.put("chat_type", r7);     // Catch: JSONException -> L26
    L30:
        if (r8 == null) goto L32;
        r15.put("current_page", r8);     // Catch: JSONException -> L26
    L32:
        r15.put("click_from", r9);     // Catch: JSONException -> L26
        if (r13 == null) goto L35;
        r15.put("req_id", r13);     // Catch: JSONException -> L26
    L35:
        r15.put("recommend_from", r14);     // Catch: JSONException -> L26
    L38:
        TrackParams r16 = new TrackParams().merge(r15);
        by7.a r17 = new by7.a("bot_feedback_banner_click");
        r17.a.merge(r16);
        r17.b();
        BotFeedbackComponent r18 = this.a;
        r18.getClass();
        FlowCommonAppCompatActivity r19 = AppHost.a.a().getCurrentActivity();
        if ((r19 instanceof FlowCommonAppCompatActivity) == false) goto L41;
        FlowCommonAppCompatActivity r20 = r19;
    L42:
        if (r20 == null) goto L49;
        LifecycleCoroutineScope r21 = LifecycleOwnerKt.getLifecycleScope(r20);
        if (r21 == null) goto L50;
        BuildersKt.launch$default(r21, null, null, new BotFeedbackComponent$reportBotFeedbackResult$1(r18, r11, null), 3, null);
        return;
    L50:
        return;
    L49:
        return;
    L41:
        r20 = null;
    L26:
        e = move-exception;
        FLogger.a.e("BotFeedbackHelper", "error in mobBotFeedbackBannerClick " + e.getLocalizedMessage());
        goto L38
    L47:
        r15.put("bot_id", r6);     // Catch: JSONException -> L26
    L22:
        r13 = null;
        goto L23
    L16:
        r9 = "dislike";
        goto L17
    L13:
        r8 = null;
        goto L14
    L9:
        r6 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }
}
