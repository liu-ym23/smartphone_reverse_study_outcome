package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ogc.OgcVSWebActivityBehavior;
import com.bytedance.android.livesdkapi.depend.model.live.ILiveToolbarData;
import com.bytedance.android.livesdkapi.depend.model.live.IToolbarComponentData;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSToolbarConfigData;
import com.bytedance.android.livesdkapi.room.handler.toolbar.NewToolbarButtonConstants;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b0 extends com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0 {
    public final DataCenter f;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.w j() {
        ToolbarButton r1 = ToolbarButton.VS_ACTIVITY_ONE;
        return new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.w(r1, r1, null, null);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final NewToolbarButtonConstants k() {
        return NewToolbarButtonConstants.ToolbarVSOperation.INSTANCE;
    }

    public b0(DataCenter r3) {
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        super(null, null, 7);
        this.f = r3;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b g(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r18, boolean r19, boolean r20) {
        Intrinsics.checkNotNullParameter(r18, "button");
        ILiveToolbarData r0 = com.bytedance.android.livesdk.chatroom.vs_base.util.h.e(this.f).getToolbarData();
        py.k r3 = null;
        if (r0 == null) goto L63;
        List r1 = r0.getToolbarDataList();
        if (r1 == null) goto L63;
        Iterator r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L61;
        Object r4 = r2.next();
        IToolbarComponentData r5 = (IToolbarComponentData) r4;
        if (r5.getId() != 32) goto L58;
        Intrinsics.checkNotNullParameter(r5, "config");
        Intrinsics.checkNotNullParameter(r5, "config");
        String r6 = r5.getScheme();
        boolean r7 = true;
        if (r6 != null) goto L14;
    L17:
        boolean r8 = true;
    L19:
        if (r8 == true) goto L38;
        String r9 = r5.getScheme();
        if (r9 == null) goto L25;
        List r10 = StringsKt.split$default(r9, new String[]{"?"}, false, 0, 6, null);
        if (r10 == null) goto L25;
    L27:
        if (r10.size() <= 1) goto L38;
        Iterator r11 = StringsKt.split$default((String) ListProtector.get(r10, 1), new String[]{"&"}, false, 0, 6, null).iterator();
    L30:
        if (r11.hasNext() == false) goto L38;
        List r12 = StringsKt.split$default((String) r11.next(), new String[]{"="}, false, 0, 6, null);
        if (r12.size() != 2) goto L30;
        if (Intrinsics.areEqual((String) ListProtector.get(r12, 0), "is_vote_page") == false) goto L30;
        if (Intrinsics.areEqual((String) ListProtector.get(r12, 1), "1") == false) goto L30;
        boolean r13 = true;
    L39:
        vr1.u r14 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.u(this.f, null, 2);
        if (r14 == null) goto L44;
        Boolean r15 = r14.isVSVerticalStream();
        if (r15 == null) goto L44;
        boolean r16 = r15.booleanValue();
    L45:
        if (r13 == false) goto L52;
        if (r16 == false) goto L52;
        vr1.u r17 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.u(this.f, null, 2);
        if (r17 == null) goto L52;
        com.bytedance.live.datacontext.m<Boolean> r21 = r17.y();
        if (r21 == null) goto L52;
        r21.setValue(Boolean.TRUE);
    L52:
        if (r13 == false) goto L55;
        if (r16 == true) goto L55;
        boolean r22 = true;
    L56:
        if (r22 == true) goto L58;
    L59:
        if (r7 == false) goto L8;
    L62:
        IToolbarComponentData r23 = (IToolbarComponentData) r4;
    L64:
        if (r23 == null) goto L110;
        String r24 = r23.getExtraData();
        if (r24 != null) goto L95;
    L75:
        VSToolbarConfigData r25 = null;
    L76:
        if (r19 == true) goto L78;
    L86:
        String r110 = r23.getScheme();
        py.k r111 = r23.getIcon();
        if (r25 == null) goto L89;
        Integer r112 = Integer.valueOf(r25.getToolbarType());
    L90:
        if (r25 == null) goto L92;
        r3 = r25.getDynamicIcon();
    L92:
        OgcVSWebActivityBehavior r26 = new OgcVSWebActivityBehavior(r110, r111, r112, r3, false);
    L94:
        return r26;
    L89:
        r112 = null;
        goto L90
    L78:
        if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.y().i(r20) == false) goto L86;
        String r27 = r23.getScheme();
        py.k r28 = r23.getIcon();
        if (r25 == null) goto L82;
        Integer r29 = Integer.valueOf(r25.getToolbarType());
    L83:
        if (r25 == null) goto L85;
        r3 = r25.getDynamicIcon();
    L85:
        r26 = new OgcVSWebActivityBehavior(r27, r28, r29, r3, true);
        goto L94
    L82:
        r29 = null;
        goto L83
    L95:
        JsonElement r30 = GsonHelper.parser().parse(r24);     // Catch: Throwable -> L73
        if (r30 == null) goto L70;
        JsonObject r31 = r30.getAsJsonObject();     // Catch: Throwable -> L73
    L71:
        r25 = (VSToolbarConfigData) GsonHelper.get().fromJson(r31, VSToolbarConfigData.class);     // Catch: Throwable -> L73
        goto L76
    L70:
        r31 = null;
    L73:
        th = move-exception;
        x8.a.c("Error parsing json", th, false);
        goto L75
    L110:
        return null;
    L55:
        r22 = false;
    L44:
        r16 = true;
    L25:
        r10 = CollectionsKt.emptyList();
    L38:
        r13 = false;
        goto L39
    L14:
        if (r6.length() == 0) goto L17;
        r8 = false;
    L58:
        r7 = false;
        goto L59
    L61:
        r4 = null;
    L63:
        r23 = null;
        goto L64
    }
}
