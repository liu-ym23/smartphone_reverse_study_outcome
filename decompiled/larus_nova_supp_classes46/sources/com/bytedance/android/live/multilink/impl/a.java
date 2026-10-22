package com.bytedance.android.live.multilink.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class a implements jn0.a {
    private jn0.b inRoomService;

    public a() {
    }

    public void unregisterInRoomService() {
        this.inRoomService = null;
    }

    public String getGlobalTestString() {
        jn0.b r0 = this.inRoomService;
        if (r0 == null) goto L6;
        String r1 = r0.Ya();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "inRoomService not ready";
    }

    public tc0.b getLinkInRoomDataHolderKt() {
        jn0.b r0 = this.inRoomService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getLinkInRoomDataHolderKt();
    }

    public dn0.c getLinkSecurityService() {
        jn0.b r0 = this.inRoomService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getLinkSecurityService();
    }

    public jb6.a getLinkServiceScopeService() {
        jn0.b r0 = this.inRoomService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getLinkServiceScopeService();
    }

    public final jn0.b getInRoomService() {
        return this.inRoomService;
    }

    public void registerInRoomService(jn0.b r2) {
        Intrinsics.checkNotNullParameter(r2, "inRoomService");
        this.inRoomService = r2;
    }

    public final void setInRoomService(jn0.b r1) {
        this.inRoomService = r1;
    }
}
