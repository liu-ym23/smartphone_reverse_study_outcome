package com.bytedance.android.live.liveinteract.utils;

import com.bytedance.android.live.core.setting.c3;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class w0 {
    public static final /* synthetic */ int a = 0;

    public static boolean a() {
        if (b() == true) goto L5;
    L7:
        return false;
    L5:
        if (vm2.h.i().asyncLoadLynx() == false) goto L7;
        return true;
    }

    public static boolean b() {
        boolean r0 = MultiLinkLoadWidgetUtils.l();
        boolean r1 = vm2.h.i().isTotalEnable();
        boolean r2 = Intrinsics.areEqual(com.bytedance.android.live.liveinteract.api.utils.m.i().isAnchor(), Boolean.TRUE);
        com.bytedance.live.datacontext.m r3 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r3 == null) goto L7;
        IRoom r4 = (IRoom) r3.getValue();
        if (r4 == null) goto L7;
        LiveMode r5 = r4.getStreamType();
    L8:
        if (r0 == false) goto L14;
        if (r1 == false) goto L14;
        if (r2 == true) goto L14;
        if (r5 == LiveMode.THIRD_PARTY) goto L14;
        return true;
    L14:
        return false;
    L7:
        r5 = null;
        goto L8
    }

    public static boolean e() {
        return vm2.h.i().slowFunctionOpt();
    }

    static {
    }

    public static boolean c(IRoom r1) {
        if (r1 != null) goto L8;
        com.bytedance.live.datacontext.m r2 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r2 == null) goto L6;
        r1 = (IRoom) r2.getValue();
        goto L8
    L6:
        r1 = null;
    L8:
        if (((Boolean) com.bytedance.android.live.core.setting.o0.a.getValue()).booleanValue() == false) goto L13;
        if (r1 == null) goto L13;
        if (r1.isLiveTypeAudio() != true) goto L13;
        return true;
    L13:
        return false;
    }

    public static boolean d(IRoom r0) {
        if (c(r0) == true) goto L5;
    L7:
        return false;
    L5:
        if (((Boolean) c3.a.getValue()).booleanValue() == false) goto L7;
        return true;
    }
}
