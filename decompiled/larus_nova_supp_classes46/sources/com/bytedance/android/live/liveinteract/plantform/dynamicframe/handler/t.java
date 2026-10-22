package com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler;

import com.bytedance.android.live.liveinteract.hamlet.HamletAvatarContext;
import com.google.gson.JsonObject;
import io.reactivex.functions.Consumer;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class t<T> implements Consumer {
    public final /* synthetic */ v a;

    public t(v r1) {
        this.a = r1;
    }

    public final void accept(Object r6) {
        com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b.a r7 = (com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b.a) r6;
        if (r7.b != 28) goto L24;
        v r0 = this.a;
        int r8 = r7.d;
        HamletAvatarContext.a r1 = HamletAvatarContext.Companion;
        HamletAvatarContext r2 = r1.getContext();
        if (r2 == null) goto L11;
        com.bytedance.live.datacontext.m<Boolean> r3 = r2.isAvatarRending();
        if (r3 == null) goto L11;
        Boolean r4 = (Boolean) r3.getValue();
        if (r4 == null) goto L11;
        boolean r5 = r4.booleanValue();
    L12:
        r0.getClass();
        HamletAvatarContext r9 = r1.getContext();
        if (r9 == null) goto L19;
        com.bytedance.live.datacontext.m<Boolean> r10 = r9.isStreamRending();
        if (r10 == null) goto L19;
        if (((Boolean) r10.getValue()).booleanValue() != true) goto L19;
    L22:
        JsonObject r11 = new JsonObject();
        r11.addProperty("type", "render");
        JsonObject r12 = new JsonObject();
        r12.addProperty("is_render", Boolean.valueOf(r5));
        Unit r13 = Unit.INSTANCE;
        r11.add("data", r12);
        r0.z.Dk("avatar", "avatar_event", r11, false);
        return;
    L19:
        if (r8 != 1) goto L21;
        r5 = true;
        goto L22
    L21:
        r5 = false;
    L11:
        r5 = false;
        goto L12
    }
}
