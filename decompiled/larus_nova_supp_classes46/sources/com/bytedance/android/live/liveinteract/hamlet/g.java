package com.bytedance.android.live.liveinteract.hamlet;

import android.util.Log;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ HamletAvatarWidget a;

    public g(HamletAvatarWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r8) {
        sh6.b r9 = (sh6.b) r8;
        HamletAvatarWidget r10 = this.a;
        int r0 = HamletAvatarWidget.T;
        r10.getClass();
        com.bytedance.android.live.liveinteract.hamlet.model.m r1 = new com.bytedance.android.live.liveinteract.hamlet.model.m();     // Catch: Exception -> L15
        HamletAvatarContext r11 = r10.f;     // Catch: Exception -> L15
        if (r11 == null) goto L8;
        com.bytedance.live.datacontext.n<com.bytedance.android.live.liveinteract.hamlet.model.l> r12 = r11.getChestPosition();     // Catch: Exception -> L15
        if (r12 == null) goto L8;
        com.bytedance.android.live.liveinteract.hamlet.model.l r13 = (com.bytedance.android.live.liveinteract.hamlet.model.l) r12.getValue();     // Catch: Exception -> L15
    L9:
        r1.d(r13);     // Catch: Exception -> L15
        JSONObject r3 = tv5.a.a(GsonHelper.get(), r1);     // Catch: Exception -> L15
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();     // Catch: Exception -> L15
        com.bytedance.android.live.liveinteract.voicechat.d r14 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();     // Catch: Exception -> L15
        if (r14 == null) goto L20;
        com.bytedance.android.live.pushstream.d r2 = r14.Ri();     // Catch: Exception -> L15
        if (r2 == null) goto L21;
        r2.c1("hamlet_avatar_sei", r3, -1, true, true);     // Catch: Exception -> L15
        return;
    L21:
        return;
    L20:
        return;
    L8:
        r13 = null;
    L15:
        e = move-exception;
        ALogger.e("HamletAvatar", "createAndSendHamletSei excetion=" + Log.getStackTraceString(e));
    }
}
