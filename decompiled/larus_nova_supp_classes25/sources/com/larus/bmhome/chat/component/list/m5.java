package com.larus.bmhome.chat.component.list;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import by7.a;
import com.ixigua.lib.track.TrackParams;
import com.larus.audio.AudioServiceDelegate;
import com.larus.bmhome.chat.feedback.TtsFeedbackDialogFragment;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import hq9.q3;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class m5 implements q3 {
    public final /* synthetic */ ChatListComponent a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public final void a() {
    }

    public final void c() {
    }

    public final void b(boolean r10) {
        ChatListComponent r3 = this.a;
        int r4 = ChatListComponent.W3;
        String r5 = r3.getBotId();
        String r6 = ChatListComponent.m3(this.a);
        if (r10 == false) goto L5;
        String r7 = "like";
    L6:
        JSONObject r8 = new JSONObject();
        Intrinsics.checkNotNullParameter(r8, "params");
        r8.put("reading_scene", "tts_im");     // Catch: JSONException -> L12
        if (r5 == null) goto L10;
        r8.put("bot_id", r5);     // Catch: JSONException -> L12
    L10:
        r8.put("chat_type", r6);     // Catch: JSONException -> L12
        r8.put("click_from", r7);     // Catch: JSONException -> L12
    L14:
        TrackParams r2 = new TrackParams().merge(r8);
        a r9 = new a("tts_feedback_banner_click");
        r9.a.merge(r2);
        r9.b();
        if (r10 == false) goto L18;
        AudioServiceDelegate.a.getAudioConfig().x();
        t19.s r11 = t19.s.a;
        Context r0 = AppHost.a.getApplication().getApplicationContext();
        r11.getClass();
        t19.s.o(r0, 2131910475, false);
        ChatListComponentViewModel.reportTtsFeedback$default(this.a.U5(), this.a.getBotId(), this.b, this.c, 1, 0, 16, null);
        return;
    L18:
        if (s1a.a.c(this.a).isAdded() == false) goto L31;
        FragmentManager r12 = s1a.a.c(this.a).getParentFragmentManager();
        Bundle r1 = com.larus.utils.f.c(new Pair[]{TuplesKt.to("chat_type", ChatListComponent.m3(this.a)), TuplesKt.to("bot_id", this.a.getBotId()), TuplesKt.to("message_id", this.b), TuplesKt.to("task_id", this.c)});
        Intrinsics.checkNotNullParameter(r12, "fragmentManager");
        TtsFeedbackDialogFragment r13 = new TtsFeedbackDialogFragment();
        r13.f = false;
        r13.g = r1;
        LandscapeRestrictionOperation r14 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r13, "tts_feedback", r14);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r12, r13, r14) == true) goto L32;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L25
    L23:
        r13.show(r12, "tts_feedback");
        return;
    L32:
        return;
    L31:
        return;
    L12:
        e = move-exception;
        FLogger.a.e("TtsEventHelper", "error in mobTtsFeedbackBannerClick " + e.getLocalizedMessage());
        goto L14
    L5:
        r7 = "dislike";
        goto L6
    }

    public m5(ChatListComponent r1, String r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
