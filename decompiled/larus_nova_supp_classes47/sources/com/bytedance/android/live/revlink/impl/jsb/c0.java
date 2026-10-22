package com.bytedance.android.live.revlink.impl.jsb;

import com.bytedance.android.live.browser.jsbridge.base.SendMultiAnchorEventResultModel;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.livesdk.link.model.ILinkerKickOutContent;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import w20.b6;
import w20.he;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c0 extends wy0.b<he, SendMultiAnchorEventResultModel> {
    public final ld.a a;
    public final Type b;
    public final com.bytedance.android.live.revlink.impl.global.c c;

    public static final class a {
    }

    static {
    }

    public final n21.a m() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.ll();
    }

    @Override // wy0.b
    public final Type k() {
        return this.b;
    }

    public c0(com.bytedance.android.live.revlink.impl.global.c r2) {
        this.c = r2;
        xq2.b r3 = (dy0.b) com.bytedance.android.live.revenue.core.util.e.c(com.bytedance.android.live.revenue.core.util.j.C0.a(), xq2.b.class);
        if (r3 == null) goto L7;
        cy0.c r4 = r3.c0();
        if (r4 == null) goto L7;
        com.bytedance.android.scope.m.e.getClass();
        ld.a r5 = (ld.a) com.bytedance.android.scope.m.b(r4).a(Reflection.getOrCreateKotlinClass(ld.a.class));
    L8:
        this.a = r5;
        this.b = TypesJVMKt.getJavaType(Reflection.typeOf(he.class));
        return;
    L7:
        r5 = null;
        goto L8
    }

    @Override // wy0.b
    public final void l(vh7.j r8, CallContext r9) {
        he r10 = (he) r8;
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r9, "callContext");
        com.bytedance.android.live.revlink.impl.multianchor.service.b r2 = null;
        Integer r3 = null;
        String r4 = null;
        String r5 = null;
        Integer r6 = null;
        Integer r7 = null;
        jy0.b.c("SendMultiAnchorEventMethod", "SendMultiAnchorEventMethod with event: " + r10.getEvent() + " and data: " + b6.a(r10), null, 4);
        if (r10.getEvent() != DynamicMultiAnchorEvent.Mute.ordinal()) goto L23;
        f31.d r12 = new f31.d();
        JSONObject r0 = b6.a(r10);
        if (r0 == null) goto L7;
        Integer r1 = Integer.valueOf(JSONObjectProtectorUtils.getInt(r0, "mute"));
    L8:
        r12.e(r1);
        JSONObject r13 = b6.a(r10);
        if (r13 == null) goto L11;
        String r14 = JSONObjectProtectorUtils.getString(r13, "uid");
    L12:
        r12.h(r14);
        JSONObject r15 = b6.a(r10);
        if (r15 == null) goto L15;
        Integer r16 = Integer.valueOf(r15.optInt("to_all", 1));
    L16:
        r12.g(r16);
        JSONObject r17 = b6.a(r10);
        if (r17 == null) goto L19;
        r3 = Integer.valueOf(r17.optInt("skip_confirm", 0));
    L19:
        r12.f(r3);
        n21.a r18 = m();
        if (r18 == null) goto L93;
        r18.handleMultiDynamicData(r12);
    L93:
        finishWithSuccess();
        return;
    L15:
        r16 = null;
        goto L16
    L11:
        r14 = null;
        goto L12
    L7:
        r1 = null;
        goto L8
    L23:
        if (r10.getEvent() != DynamicMultiAnchorEvent.InterComment.ordinal()) goto L28;
        n21.a r19 = m();
        if (r19 == null) goto L93;
        r19.handleMultiDynamicData(new f31.c());
        goto L93
    L28:
        if (r10.getEvent() != DynamicMultiAnchorEvent.NeedExtraView.ordinal()) goto L41;
        JsonObject r20 = r10.getData();
        if (r20 == null) goto L34;
        JsonElement r22 = r20.get("showAvatarView");
        if (r22 == null) goto L34;
        String r23 = r22.toString();
    L35:
        boolean r24 = !StringsKt.equals$default(r23, DataType.TRUE, false, 2, null);
        ld.a r25 = this.a;
        if (r25 == null) goto L93;
        NextLiveData r26 = r25.Y8();
        if (r26 == null) goto L93;
        r26.setValue(Boolean.valueOf(r24));
    L34:
        r23 = null;
        goto L35
    L41:
        if (r10.getEvent() != DynamicMultiAnchorEvent.MultiWindowClick.ordinal()) goto L49;
        f31.e r27 = new f31.e();
        JSONObject r28 = b6.a(r10);
        if (r28 == null) goto L45;
        r4 = JSONObjectProtectorUtils.getString(r28, "uid");
    L45:
        r27.b(r4);
        n21.a r29 = m();
        if (r29 == null) goto L93;
        r29.handleMultiDynamicData(r27);
        goto L93
    L49:
        if (r10.getEvent() != DynamicMultiAnchorEvent.MuteAiIconClick.ordinal()) goto L61;
        f31.d r30 = new f31.d();
        JSONObject r32 = b6.a(r10);
        if (r32 == null) goto L53;
        Integer r33 = Integer.valueOf(JSONObjectProtectorUtils.getInt(r32, "mute"));
    L54:
        r30.e(r33);
        JSONObject r34 = b6.a(r10);
        if (r34 == null) goto L57;
        r5 = JSONObjectProtectorUtils.getString(r34, "ai_id");
    L57:
        r30.h(r5);
        n21.a r35 = m();
        if (r35 == null) goto L93;
        r35.handleMuteAiDynamicData(r30);
        goto L93
    L53:
        r33 = null;
        goto L54
    L61:
        if (r10.getEvent() != DynamicMultiAnchorEvent.CellularEnhanced.ordinal()) goto L69;
        f31.a r36 = new f31.a();
        JSONObject r37 = b6.a(r10);
        if (r37 == null) goto L65;
        r6 = Integer.valueOf(JSONObjectProtectorUtils.getInt(r37, "cellular_open"));
    L65:
        r36.b(r6);
        n21.a r38 = m();
        if (r38 == null) goto L93;
        r38.handleMuteAiDynamicData(r36);
        goto L93
    L69:
        if (r10.getEvent() != DynamicMultiAnchorEvent.Enlarge.ordinal()) goto L81;
        n21.a r39 = m();
        if (r39 == null) goto L93;
        f31.b r40 = new f31.b();
        JSONObject r42 = b6.a(r10);
        if (r42 == null) goto L75;
        String r43 = JSONObjectProtectorUtils.getString(r42, "uid");
    L76:
        r40.d(r43);
        JSONObject r44 = b6.a(r10);
        if (r44 == null) goto L79;
        r7 = Integer.valueOf(r44.optInt("to_all", 0));
    L79:
        r40.c(r7);
        Unit r45 = Unit.INSTANCE;
        r39.handleMultiDynamicData(r40);
        goto L93
    L75:
        r43 = null;
        goto L76
    L81:
        if (r10.getEvent() != DynamicMultiAnchorEvent.KickOut.ordinal()) goto L93;
        JSONObject r46 = b6.a(r10);
        if (r46 == null) goto L92;
        String r47 = JSONObjectProtectorUtils.getString(r46, "uid");
        if (r47 == null) goto L92;
        com.bytedance.android.live.revlink.impl.global.c r48 = this.c;
        if (r48 == null) goto L90;
        r2 = r48.d6();
    L90:
        if (r2 == null) goto L93;
        r2.kickOut(r47, "MultiMicPanel", ILinkerKickOutContent.KickOutSource.FromOrganizer);
    L92:
        finishWithSuccess();
    }
}
