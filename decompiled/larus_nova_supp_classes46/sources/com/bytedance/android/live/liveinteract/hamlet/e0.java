package com.bytedance.android.live.liveinteract.hamlet;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import io.reactivex.functions.Consumer;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e0<T> implements Consumer {
    public final /* synthetic */ HamletAvatarWidget a;

    public e0(HamletAvatarWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r7) {
        Long r8 = (Long) r7;
        HamletAvatarContext r9 = this.a.f;
        if (r9 == null) goto L12;
        String r10 = r9.getHamletSeiAvatarList();
        if (r10 == null) goto L13;
        this.a.getClass();
        com.bytedance.android.live.liveinteract.hamlet.model.m r0 = new com.bytedance.android.live.liveinteract.hamlet.model.m();
        r0.c(r10);
        JSONObject r2 = new JSONObject(GsonProtectorUtils.toJson(GsonHelper.get(), r0));
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        com.bytedance.android.live.liveinteract.voicechat.d r11 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r11 == null) goto L14;
        com.bytedance.android.live.pushstream.d r1 = r11.Ri();
        if (r1 == null) goto L15;
        r1.c1("hamlet_avatar_sei", r2, 1, false, false);
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }
}
