package com.larus.bot.impl.feature.edit.feature.firstmet;

import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.logger.FLogger;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class j implements bv8.j {
    public final /* synthetic */ h a;

    @Override // bv8.j
    public final void a() {
        h r0 = this.a;
        dv8.b r1 = r0.d;
        if (r1 == null) goto L21;
        String r2 = r1.d();
        String r3 = r1.o();
        String r4 = r1.c();
        TraceFragment r5 = r0.a;
        JSONObject r6 = new JSONObject();
        Intrinsics.checkNotNullParameter(r6, "params");
        if (r3 != null) goto L19;
    L9:
        if (r2 == null) goto L11;
        r6.put("creation_id", r2);     // Catch: JSONException -> L7
    L11:
        r6.put("create_way", r4);     // Catch: JSONException -> L7
    L14:
        TrackParams r7 = new TrackParams().merge(r6);
        by7.a r8 = new by7.a("create_bot_enter_sp_content");
        if (r5 == null) goto L17;
        r8.b = r5;
    L17:
        r8.a.merge(r7);
        r8.b();
        return;
    L7:
        e = move-exception;
        FLogger.a.e("OnboardingEventHelper", "error in OnboardingEventHelper createBotEnterSpContent " + e.getLocalizedMessage());
        goto L14
    L19:
        r6.put("previous_page", r3);     // Catch: JSONException -> L7
        goto L9
    }

    public j(h r1) {
        this.a = r1;
    }

    @Override // bv8.j
    public final void b(Triple<String, String, String> r4) {
        Intrinsics.checkNotNullParameter(r4, "suggests");
        this.a.c.dispatchUIAction(new l.f(null, r4));
    }

    @Override // bv8.j
    public final void onSwitchChange(boolean r7) {
        this.a.c.dispatchUIAction(new l.f(Boolean.valueOf(r7), null));
        h r0 = this.a;
        dv8.b r1 = r0.d;
        if (r1 == null) goto L27;
        String r2 = r1.d();
        String r3 = r1.o();
        String r4 = r1.c();
        Boolean r8 = Boolean.valueOf(r7);
        TraceFragment r5 = r0.a;
        JSONObject r6 = new JSONObject();
        Intrinsics.checkNotNullParameter(r6, "params");
        if (r3 != null) goto L25;
    L9:
        if (r2 == null) goto L11;
        r6.put("creation_id", r2);     // Catch: JSONException -> L7
    L11:
        r6.put("create_way", r4);     // Catch: JSONException -> L7
        if (r8 != null) goto L14;
    L20:
        TrackParams r9 = new TrackParams().merge(r6);
        by7.a r10 = new by7.a("create_bot_sp_switch_click");
        if (r5 == null) goto L23;
        r10.b = r5;
    L23:
        r10.a.merge(r9);
        r10.b();
        return;
    L14:
        if (r8.booleanValue() == false) goto L16;
        String r11 = "1";
    L17:
        r6.put("to_status", r11);     // Catch: JSONException -> L7
    L7:
        e = move-exception;
        FLogger.a.e("OnboardingEventHelper", "error in OnboardingEventHelper createBotSpWitchClick " + e.getLocalizedMessage());
        goto L20
    L16:
        r11 = TriggerSendLoading.NO_LOADING;
        goto L17
    L25:
        r6.put("previous_page", r3);     // Catch: JSONException -> L7
        goto L9
    }
}
