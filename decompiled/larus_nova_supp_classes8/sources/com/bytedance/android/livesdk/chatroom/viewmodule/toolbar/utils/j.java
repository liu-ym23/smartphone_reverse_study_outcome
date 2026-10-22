package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.utils;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.config.pg;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdkapi.depend.model.live.ILiveToolbarData;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IToolbarComponentData;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class j implements ot2.f {
    public static final j a = null;

    public j() {
    }

    static {
        a = new j();
    }

    public final int a(boolean r12, DataCenter r13) {
        if (r13 != null) goto L5;
        return Integer.MAX_VALUE;
    L5:
        List r2 = null;
        IRoom r14 = (IRoom) r13.get("data_room", null);
        if (r14 != null) goto L9;
        return Integer.MAX_VALUE;
    L9:
        if (r14.getToolbarData() == null) goto L14;
        ILiveToolbarData r15 = r14.getToolbarData();
        if (r15 == null) goto L14;
        r2 = r15.getToolbarDataList();
    L14:
        if (r2 != null) goto L17;
        ALogger.e("ToolbarUtil", "getLoadIconCount toolbarComponentDataList is null");
        return Integer.MAX_VALUE;
    L17:
        int r0 = r2.size();
        int r3 = 0;
        int r4 = 0;
    L18:
        if (r3 >= r0) goto L42;
        IToolbarComponentData r5 = (IToolbarComponentData) ListProtector.get(r2, r3);
        if (r5 == null) goto L41;
        if (r12 == true) goto L24;
    L35:
        if (r12 == true) goto L41;
        if (r5.getShowType() != 3) goto L39;
    L40:
        r4 = r4 + 1;
        ALogger.i("ToolbarUtil", "getLoadIconCount isLandscape, showType: " + r5.getShowType() + ", id: " + r5.getId());
        goto L41
    L39:
        if (r5.getShowType() != 2) goto L41;
    L24:
        if (r5.getShowType() == 3) goto L34;
        boolean r9 = true;
        if (r5.getShowType() == 1) goto L34;
        int r8 = r5.getId();
        if (e5.n() == true) goto L30;
    L32:
        r9 = false;
    L33:
        if (r9 == false) goto L35;
    L30:
        if (r8 != 38) goto L32;
    L34:
        r4 = r4 + 1;
        ALogger.i("ToolbarUtil", "getLoadIconCount isPortrait, showType: " + r5.getShowType() + ", id: " + r5.getId());
    L41:
        r3 = r3 + 1;
        goto L18
    L42:
        return r4;
    }

    public final int b(boolean r2, DataCenter r3) {
        o r0 = bp1.j.b(r3);
        if (r0 == null) goto L9;
        m r1 = r0.getRoom();
        if (r1 == null) goto L9;
        IRoom r4 = (IRoom) r1.getValue();
        if (r4 == null) goto L9;
        r4.getToolbarData();
    L9:
        if (r2 == false) goto L22;
        o r5 = bp1.j.b(r3);
        if (r5 == null) goto L21;
        m r6 = r5.getRoom();
        if (r6 == null) goto L21;
        IRoom r7 = (IRoom) r6.getValue();
        if (r7 == null) goto L21;
        ILiveToolbarData r8 = r7.getToolbarData();
        if (r8 == null) goto L21;
        Integer r9 = r8.getMaxCount();
        if (r9 == null) goto L21;
        int r10 = r9.intValue();
    L32:
        int r11 = Math.max(r10, 0);
        if (v.a() == false) goto L38;
        pg r12 = pg.a;
        if (((Number) r12.getValue()).intValue() > 0) goto L37;
        return r11;
    L37:
        return ((Integer) r12.getValue()).intValue();
    L38:
        return r11;
    L21:
        r10 = 4;
        goto L32
    L22:
        o r13 = bp1.j.b(r3);
        if (r13 == null) goto L31;
        m r14 = r13.getRoom();
        if (r14 == null) goto L31;
        IRoom r15 = (IRoom) r14.getValue();
        if (r15 == null) goto L31;
        ILiveToolbarData r16 = r15.getToolbarData();
        if (r16 == null) goto L31;
        r10 = r16.getMaxCountLandscape();
    L31:
        r10 = 5;
        goto L32
    }
}
