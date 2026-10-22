package com.bytedance.android.livesdk.gamecp.impl;

import android.graphics.Rect;
import android.view.View;
import com.bytedance.android.livehostapi.business.depend.gamecp.IGPViewAppearObserver;
import com.bytedance.android.livehostapi.business.depend.gamecp.IGameCPTrackService;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import java.util.HashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d implements IGameCPTrackService {

    public static final class a implements IGPViewAppearObserver {
        public final xr.c a;

        public final void detachViewAppearObserver() {
            xr.c r0 = this.a;
            if (r0 == null) goto L6;
            r0.detachViewAppearObserver();
            return;
        }

        public final boolean viewIsWillDetached() {
            xr.c r0 = this.a;
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.viewIsWillDetached();
        }

        public final void attachViewAppearObserver(View r2, Function2<? super Boolean, ? super Float, Unit> r3) {
            Intrinsics.checkNotNullParameter(r3, "appearObserver");
            xr.c r0 = this.a;
            if (r0 == null) goto L6;
            r0.attachViewAppearObserver(r2, r3);
            return;
        }

        public a(long r8, boolean r10, float r11, boolean r12) {
            xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
            if (r0 == null) goto L7;
            xr.p r1 = r0.getTrackService();
            if (r1 == null) goto L7;
            com.bytedance.android.gamecp.common.track.monitor.a r9 = r1.newGPViewAppearObserver(r8, r10, r11, r12);
        L8:
            this.a = r9;
            return;
        L7:
            r9 = null;
            goto L8
        }
    }

    public d() {
    }

    public final Map<String, String> getGPCommonParams() {
        return getGPCommonParams(null, null);
    }

    public final void appendHijackInfo(Map<String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "logMap");
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L8;
        xr.p r1 = r0.getTrackService();
        if (r1 == null) goto L9;
        r1.appendHijackInfo(r2);
        return;
    L9:
        return;
    }

    public final Map<String, Object> getViewTrackData(View r2) {
        Intrinsics.checkNotNullParameter(r2, "trackView");
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L9;
        xr.p r1 = r0.getTrackService();
        if (r1 == null) goto L9;
        Map<String, Object> r3 = r1.getViewTrackData(r2);
        if (r3 == null) goto L9;
        return r3;
    L9:
        return MapsKt.emptyMap();
    }

    public final boolean viewIsWillDetached(View r2) {
        Intrinsics.checkNotNullParameter(r2, "targetView");
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L7;
        xr.p r1 = r0.getTrackService();
        if (r1 == null) goto L7;
        return r1.viewIsWillDetached(r2);
    L7:
        return false;
    }

    public final void filterRouterParams(View r2, HashMap<String, Object> r3) {
        Intrinsics.checkNotNullParameter(r2, "trackView");
        Intrinsics.checkNotNullParameter(r3, "routeParams");
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L8;
        xr.p r1 = r0.getTrackService();
        if (r1 == null) goto L9;
        r1.filterRouterParams(r2, r3);
        return;
    L9:
        return;
    }

    public final Map<String, String> getGPCommonParams(View r2, String r3) {
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L9;
        xr.p r1 = r0.getTrackService();
        if (r1 == null) goto L9;
        Map<String, String> r4 = r1.a1(r2, r3);
        if (r4 == null) goto L9;
        return r4;
    L9:
        return new HashMap();
    }

    public final void sendLog(String r2, Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        Intrinsics.checkNotNullParameter(r3, "extra");
        sendLog(null, r2, r3);
    }

    public final void setViewTrackAttrs(View r2, Map<String, ? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "attrs");
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L8;
        xr.p r1 = r0.getTrackService();
        if (r1 == null) goto L9;
        r1.setViewTrackAttrs(r2, r3);
        return;
    L9:
        return;
    }

    public final void unRegisterPageParamNode(Object r2, View r3) {
        Intrinsics.checkNotNullParameter(r3, "pageRootView");
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L8;
        xr.p r1 = r0.getTrackService();
        if (r1 == null) goto L9;
        r1.unRegisterPageParamNode(r2, r3);
        return;
    L9:
        return;
    }

    public final void updatePageParamNode(View r2, Map<String, ? extends Map<String, String>> r3) {
        Intrinsics.checkNotNullParameter(r2, "pageRootView");
        Intrinsics.checkNotNullParameter(r3, "paramsMap");
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L8;
        xr.p r1 = r0.getTrackService();
        if (r1 == null) goto L9;
        r1.updatePageParamNode(r2, r3);
        return;
    L9:
        return;
    }

    public final String getTrackEventName(View r2, int r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "trackView");
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L8;
        xr.p r1 = r0.getTrackService();
        if (r1 == null) goto L8;
        String r5 = r1.getTrackEventName(r2, r3, r4);
        if (r5 == null) goto L8;
        return r5;
    L8:
        return "";
    }

    public final void sendLog(View r2, String r3, Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r3, "eventName");
        Intrinsics.checkNotNullParameter(r4, "extra");
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L8;
        xr.p r1 = r0.getTrackService();
        if (r1 == null) goto L9;
        r1.sendLog(r2, r3, r4);
        return;
    L9:
        return;
    }

    public final void filterViewParams(View r2, HashMap<String, Object> r3, Map<String, ? extends Object> r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "trackView");
        Intrinsics.checkNotNullParameter(r3, "viewParams");
        Intrinsics.checkNotNullParameter(r4, "attrs");
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L8;
        xr.p r1 = r0.getTrackService();
        if (r1 == null) goto L9;
        r1.filterViewParams(r2, r3, r4, r5);
        return;
    L9:
        return;
    }

    public final IGPViewAppearObserver newGPViewAppearObserver(long r8, boolean r10, float r11, boolean r12) {
        return new a(r8, r10, r11, r12);
    }

    public final void registerPageParamNode(Object r8, View r9, Map<String, ? extends Map<String, String>> r10, boolean r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r9, "pageRootView");
        Intrinsics.checkNotNullParameter(r10, "paramsMap");
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L8;
        xr.p r1 = r0.getTrackService();
        if (r1 == null) goto L9;
        r1.registerPageParamNode(r8, r9, r10, r11, r12);
        return;
    L9:
        return;
    }

    public final void monitorAppear(View r9, float r10, boolean r11, boolean r12, Rect r13, Function2<? super Boolean, ? super Float, Unit> r14) {
        Intrinsics.checkNotNullParameter(r9, "targetView");
        Intrinsics.checkNotNullParameter(r14, "observer");
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L8;
        xr.p r1 = r0.getTrackService();
        if (r1 == null) goto L9;
        r1.monitorAppear(r9, r10, r11, r12, r13, r14);
        return;
    L9:
        return;
    }

    public final void sendViewTrackLog(View r9, int r10, boolean r11, Map<String, ? extends Object> r12, Map<String, ? extends Object> r13, float r14) {
        Intrinsics.checkNotNullParameter(r9, "trackView");
        Intrinsics.checkNotNullParameter(r12, "attrs");
        Intrinsics.checkNotNullParameter(r13, "tempAttrs");
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L8;
        xr.p r1 = r0.getTrackService();
        if (r1 == null) goto L9;
        r1.sendViewTrackLog(r9, r10, r11, r12, r13, r14);
        return;
    L9:
        return;
    }

    public final void setViewTrackData(View r9, String r10, int r11, Map<String, ? extends Object> r12, Map<String, ? extends Object> r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r9, "trackView");
        Intrinsics.checkNotNullParameter(r10, LiveEndPageData.TAG_NAME);
        Intrinsics.checkNotNullParameter(r12, "attrs");
        Intrinsics.checkNotNullParameter(r13, "routeData");
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L8;
        xr.p r1 = r0.getTrackService();
        if (r1 == null) goto L9;
        r1.setViewTrackData(r9, r10, r11, r12, r13, r14);
        return;
    L9:
        return;
    }
}
