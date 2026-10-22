package com.bytedance.android.live.anchormodelink.handlers;

import com.bytedance.android.live.anchormodelink.impl.AnchorModeLinkDynamicWidget;
import com.bytedance.android.live.anchormodelink.model.DynamicCenterGetType;
import com.bytedance.android.live.anchormodelink.model.DynamicCenterUpdateType;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.liveinteract.jsbridge.method.k;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import iy.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c implements iy.e {
    public final h a;

    public static final class a {
    }

    static {
    }

    @Override // iy.e
    public final void onStart() {
    }

    @Override // iy.e
    public final void onStop() {
    }

    public c(AnchorModeLinkDynamicWidget.f r2) {
        Intrinsics.checkNotNullParameter(r2, "provider");
        this.a = r2;
    }

    @Override // iy.e
    public final JsonObject C(my.b r2) {
        Intrinsics.checkNotNullParameter(r2, "getStatusData");
        Intrinsics.checkNotNullParameter(r2, "getStatusData");
        return null;
    }

    @Override // iy.e
    public final boolean a(DynamicCenterUpdateType r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        if (r2 != DynamicCenterUpdateType.videoLinkmicAction) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // iy.e
    public final boolean c(DynamicCenterGetType r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r2, "type");
        return false;
    }

    @Override // iy.e
    public final void b(my.c r7, k r8) {
        Intrinsics.checkNotNullParameter(r7, "updateStatus");
        Intrinsics.checkNotNullParameter(r8, "updateCallback");
        JsonObject r9 = r7.b;
        if (r9 == null) goto L52;
        JsonElement r11 = r9.get("method");
        if (r11 == null) goto L53;
        String r12 = r11.getAsString();
        if (r12 == null) goto L56;
        jy0.b.d("DynamicCenterLinkActionHandler", "type: " + r7.getType() + ", extraInfo=" + r7.b);
        if (r12.hashCode() == (-1170609085)) goto L13;
        return;
    L13:
        if (r12.equals("handleLinkmicError") == false) goto L54;
        JsonObject r13 = r7.b;
        if (r13 == null) goto L19;
        JsonElement r14 = r13.get("params");
        if (r14 == null) goto L19;
        JsonObject r15 = r14.getAsJsonObject();
    L20:
        if (r15 == null) goto L55;
        JsonElement r16 = r15.get("errorCode");
        boolean r0 = false;
        if (r16 == null) goto L24;
        int r17 = r16.getAsInt();
    L25:
        JsonElement r3 = r15.get("errorPrompts");
        if (r3 == null) goto L29;
        String r4 = r3.getAsString();
        if (r4 == null) goto L29;
    L31:
        if (r15.has("errorPrompts") == false) goto L42;
        JsonElement r2 = r15.get("errorPrompts");
        if (r2 == null) goto L42;
        String r5 = r2.getAsString();
        if (r5 == null) goto L42;
        if (r5.length() != 0) goto L39;
        boolean r6 = true;
    L40:
        if (r6 != true) goto L42;
        r0 = true;
        goto L42
    L39:
        r6 = false;
    L42:
        JsonElement r18 = r15.get("linkType");
        if (r18 == null) goto L45;
        int r19 = r18.getAsInt();
    L46:
        ApiServerException r21 = this.a.B4(r17, r4);
        if (r0 == false) goto L50;
        if (r21 == null) goto L50;
        r21.setBlockNotice(true);
    L50:
        jy0.b.d("DynamicCenterLinkActionHandler", "onLinkMicError errCode: " + r17 + ", errPrompts=" + r4 + " linkType=" + r19 + ", isBlockNotice=" + r0);
        DynamicCenterLinkActionHandler$onLinkMicError$1$1 r22 = DynamicCenterLinkActionHandler$onLinkMicError$1$1.INSTANCE;
        DynamicCenterLinkActionHandler$onLinkMicError$1$2 r1 = DynamicCenterLinkActionHandler$onLinkMicError$1$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r22, "onCheckSuccess");
        Intrinsics.checkNotNullParameter(r1, "onCheckFailed");
        new qh0.h(r19, r22, r1).c(r21);
        return;
    L45:
        r19 = 2;
    L29:
        r4 = "";
        goto L31
    L24:
        r17 = 0;
        goto L25
    L55:
        return;
    L19:
        r15 = null;
        goto L20
    L54:
        return;
    L56:
        return;
    L53:
        return;
    }
}
