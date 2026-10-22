package com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler;

import android.content.Context;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.PointOrNumberDeserializer;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class AudioLayoutDynamicHandler extends lh0.b {
    public boolean d;
    public Function0<Unit> e;

    public AudioLayoutDynamicHandler(Context r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        super(r2, r3);
    }

    public final void f(ih0.f r9, ih0.h r10) {
        Intrinsics.checkNotNullParameter(r9, "updateStatus");
        Intrinsics.checkNotNullParameter(r10, "updateCallback");
        JsonObject r1 = r9.d;
        if (r1 != null) goto L5;
        return;
    L5:
        int r2 = c.a[r9.getType().ordinal()];
        if (r2 != 1) goto L8;
        ALogger.i("MultiLinkDynamicWidget", "SEAT_ANIMATE " + r9.d);
        GsonBuilder r0 = new GsonBuilder();
        r0.registerTypeAdapter(Object.class, new PointOrNumberDeserializer());
        this.c.put("data_dynamic_island_layout_animte", (tf0.u) GsonProtectorUtils.fromJson(r0.create(), r9.d, tf0.u.class));
    L46:
        a(r10, null);
        return;
    L8:
        if (r2 != 2) goto L46;
        if (com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.j(null, 0, 7) == false) goto L46;
        JsonElement r11 = r1.get("type");
        if (r11 == null) goto L15;
        String r12 = r11.getAsString();
    L16:
        JsonElement r6 = r1.get("key");
        if (r6 == null) goto L19;
        final String r7 = r6.getAsString();
    L20:
        JsonElement r3 = r1.get("is_change_center");
        if (r3 == null) goto L24;
        r3.getAsString();
    L24:
        if (Intrinsics.areEqual(r12, "start") == false) goto L41;
        JsonObject r13 = new JsonObject();
        com.bytedance.android.live.liveinteract.animation.universalwidget.a.f0.getClass();
        com.bytedance.android.live.liveinteract.animation.universalwidget.a r4 = com.bytedance.android.live.liveinteract.animation.universalwidget.a.C0014a.a();
        if (r4 != null) goto L28;
    L33:
        ALogger.i("MultiLinkDynamicWidget", "Lynx-3d兼容-开始执行动画灵活布局动画");
        IInteractService r5 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r5 == null) goto L38;
        tf0.h r8 = r5.getInteractAnimationService();
        if (r8 == null) goto L38;
        r8.b(4);
    L38:
        this.d = true;
        r13.addProperty("is_playing", Boolean.FALSE);
        Intrinsics.checkNotNullParameter(r10, "updateCallback");
        lh0.c.a.a(r10, r13);
        return;
    L28:
        if (com.bytedance.android.live.liveinteract.animation.universalwidget.a.b.a(r4) != true) goto L33;
        final Ref.ObjectRef r14 = new Ref.ObjectRef();
        r14.element = null;
        r14.element = new AudioLayoutDynamicHandler$updateLinkMicStatus$1(this, r7, r14);
        com.bytedance.android.live.liveinteract.animation.universalwidget.a r15 = com.bytedance.android.live.liveinteract.animation.universalwidget.a.C0014a.a();
        if (r15 == null) goto L32;
        r15.zn((Function0) r14.element);
    L32:
        ALogger.i("MultiLinkDynamicWidget", "Lynx-3d兼容-灵活布局动画到来，但3d动画播放中，等待3d动画播完... layoutManager=" + this);
        r13.addProperty("is_playing", Boolean.TRUE);
        Intrinsics.checkNotNullParameter(r10, "updateCallback");
        lh0.c.a.a(r10, r13);
        return;
    L41:
        if (Intrinsics.areEqual(r12, "stop") == false) goto L46;
        this.d = false;
        ALogger.i("MultiLinkDynamicWidget", "灵活布局动画执行完毕");
        Function0<Unit> r16 = this.e;
        if (r16 == null) goto L46;
        ALogger.i("MultiLinkDynamicWidget", "3d兼容-灵活布局动画队列为空，通知3d动画继续播放");
        r16.invoke();
        goto L46
    L19:
        r7 = null;
        goto L20
    L15:
        r12 = null;
        goto L16
    }
}
