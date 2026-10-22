package com.bytedance.android.livesdk.gamecp.impl;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.bytedance.android.livehostapi.business.depend.gamecp.IGameCpLiveService;
import java.util.HashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g implements IGameCpLiveService {
    public g() {
    }

    public final void injectPreviewData(Bundle r2) {
        Intrinsics.checkNotNullParameter(r2, "businessBundle");
    }

    public final void injectPreviewToolbarData(long r1, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "uniqueKey");
        Intrinsics.checkNotNullParameter(r4, "source");
    }

    public final void onAnchorPreRequestTransferPage() {
    }

    public final void onInteractionVisibilityChanged(boolean r1) {
    }

    public final void onWebDialogShow(String r1) {
    }

    public final void reportCardDynamicEvent(HashMap<String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
    }

    public final void sendGameCpToolbarCancelEvent(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "roomId");
        Intrinsics.checkNotNullParameter(r3, "uniqueKey");
        Intrinsics.checkNotNullParameter(r4, "source");
    }

    public final String getCurrentGameId() {
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L8;
        xr.j r1 = r0.getGameCpLiveService();
        if (r1 == null) goto L8;
        String r2 = r1.getCurrentGameId();
        if (r2 == null) goto L8;
        return r2;
    L8:
        return "";
    }

    public final Object getGameCpRoomControllerProvider() {
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L7;
        xr.j r1 = r0.getGameCpLiveService();
        if (r1 == null) goto L7;
        return r1.getGameCpRoomControllerProvider();
    L7:
        return null;
    }

    public final boolean isCardVisible() {
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L7;
        xr.j r1 = r0.getGameCpLiveService();
        if (r1 == null) goto L7;
        return r1.isCardVisible();
    L7:
        return false;
    }

    public final boolean isPOI() {
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L7;
        xr.j r1 = r0.getGameCpLiveService();
        if (r1 == null) goto L7;
        return r1.isPOI();
    L7:
        return false;
    }

    public final void onAnchorClickToolbarIcon() {
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L8;
        xr.j r1 = r0.getGameCpLiveService();
        if (r1 == null) goto L9;
        r1.onAnchorClickToolbarIcon();
        return;
    L9:
        return;
    }

    public final void isCleanModeChange(boolean r2) {
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L8;
        xr.j r1 = r0.getGameCpLiveService();
        if (r1 == null) goto L9;
        r1.isCleanModeChange(r2);
        return;
    L9:
        return;
    }

    public final void onOrientationChange(int r2) {
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L8;
        xr.j r1 = r0.getGameCpLiveService();
        if (r1 == null) goto L9;
        r1.onOrientationChange(r2);
        return;
    L9:
        return;
    }

    public final void onCardDataRaw(String r2, long r3) {
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L8;
        xr.j r1 = r0.getGameCpLiveService();
        if (r1 == null) goto L9;
        r1.onCardDataRaw(r2, r3);
        return;
    L9:
        return;
    }

    public final void onMoveToFold(boolean r2, int r3) {
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L8;
        xr.j r1 = r0.getGameCpLiveService();
        if (r1 == null) goto L9;
        r1.onMoveToFold(r2, r3);
        return;
    L9:
        return;
    }

    public final void onReplaceResult(boolean r2, int r3) {
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L8;
        xr.j r1 = r0.getGameCpLiveService();
        if (r1 == null) goto L9;
        r1.onReplaceResult(r2, r3);
        return;
    L9:
        return;
    }

    public final void setParentView(View r2, Boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "parentView");
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L8;
        xr.j r1 = r0.getGameCpLiveService();
        if (r1 == null) goto L9;
        r1.setParentView(r2, r3);
        return;
    L9:
        return;
    }

    public final void fillGameCpTrackAttrMap(Map<String, String> r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "trackAttrMap");
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L8;
        xr.j r1 = r0.getGameCpLiveService();
        if (r1 == null) goto L9;
        r1.fillGameCpTrackAttrMap(r2, r3, r4);
        return;
    L9:
        return;
    }

    public final Object getPreloadToolbarHandler(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "roomId");
        Intrinsics.checkNotNullParameter(r3, "uniqueKey");
        Intrinsics.checkNotNullParameter(r4, "source");
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L7;
        xr.j r1 = r0.getGameCpLiveService();
        if (r1 == null) goto L7;
        return r1.getPreloadToolbarHandler(r2, r3, r4);
    L7:
        return null;
    }

    public final Pair<Boolean, Boolean> isGameCpToolbarShowSuccess(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "roomId");
        Intrinsics.checkNotNullParameter(r3, "uniqueKey");
        Intrinsics.checkNotNullParameter(r4, "source");
        Boolean r5 = Boolean.FALSE;
        return new Pair(r5, r5);
    }

    public final void onAudienceClickMoreIcon(Context r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L8;
        xr.j r1 = r0.getGameCpLiveService();
        if (r1 == null) goto L9;
        r1.onAudienceClickMoreIcon(r2, r3, r4);
        return;
    L9:
        return;
    }

    public final void sendResultGameStatus(Context r2, boolean r3, String r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "mContext");
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L8;
        xr.j r1 = r0.getGameCpLiveService();
        if (r1 == null) goto L9;
        r1.sendResultGameStatus(r2, r3, r4, r5);
        return;
    L9:
        return;
    }

    public final void roomEnterGameCpForPreload(String r8, String r9, String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r8, "roomId");
        Intrinsics.checkNotNullParameter(r9, "anchorId");
        Intrinsics.checkNotNullParameter(r10, "eventParams");
        Intrinsics.checkNotNullParameter(r11, "gameId");
        Intrinsics.checkNotNullParameter(r12, "uniqueKey");
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L8;
        xr.j r1 = r0.getGameCpLiveService();
        if (r1 == null) goto L9;
        r1.roomEnterGameCpForPreload(r8, r9, r10, r11, r12);
        return;
    L9:
        return;
    }
}
