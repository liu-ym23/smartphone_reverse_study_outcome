package com.bytedance.android.livesdk.config.setting;

import com.bytedance.android.livesdk.config.c6;
import com.bytedance.android.livesdk.l5;
import com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IStreamUrlExtra;
import com.bytedance.android.livesdkapi.depend.model.live.LiveRoomMode;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d {
    public static final c6 a = null;

    static {
        a = (c6) l5.a.getValue();
    }

    @JvmStatic
    public static final boolean a(IRoom r8, String r9) {
        Intrinsics.checkNotNullParameter(r9, "widget");
        boolean r0 = false;
        if (r8 != null) goto L5;
    L63:
        return r0;
    L5:
        if (r8.isVsRoom() == true) goto L63;
        if (r8.isMergeVSRoom() == true) goto L63;
        if (r8.isMediaRoom() == true) goto L63;
        c6 r1 = a;
        if (r1.b() == false) goto L63;
        if (r1.b() == true) goto L16;
    L22:
        boolean r2 = false;
    L23:
        if (r2 == false) goto L25;
    L58:
        r0 = true;
    L59:
        if (r0 == false) goto L63;
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L63;
        goto L63
    L25:
        if (r1.b() == true) goto L27;
    L56:
        boolean r10 = false;
    L57:
        if (r10 == false) goto L59;
    L27:
        if (r8.isGameRoom() != 1) goto L56;
        List<String> r3 = r1.c();
        if (r3 == null) goto L56;
        if (r3.contains(r9) != true) goto L56;
        IBaseStreamUrl r11 = r8.getStreamUrl();
        if (r11 == null) goto L56;
        String r12 = r11.getRtmpPullUrl();
        if (r12 == null) goto L56;
        if (StringsKt.contains$default(r12, "/thirdgame/", false, 2, null) != true) goto L56;
        IBaseStreamUrl r13 = r8.getStreamUrl();
        if (r13 == null) goto L56;
        if (r13.getStreamOrientation() != 2) goto L56;
        IBaseStreamUrl r14 = r8.getStreamUrl();
        if (r14 == null) goto L47;
        IStreamUrlExtra r15 = r14.getExtra();
        if (r15 == null) goto L47;
        int r16 = r15.getWidth();
    L48:
        IBaseStreamUrl r17 = r8.getStreamUrl();
        if (r17 == null) goto L53;
        IStreamUrlExtra r18 = r17.getExtra();
        if (r18 == null) goto L53;
        int r19 = r18.getHeight();
    L54:
        if (r16 <= r19) goto L56;
        r10 = true;
    L53:
        r19 = 0;
    L47:
        r16 = 0;
        goto L48
    L16:
        if (r8.getLiveRoomMode() != LiveRoomMode.Screenshot.getValue()) goto L22;
        List<String> r4 = r1.d();
        if (r4 == null) goto L22;
        if (r4.contains(r9) != true) goto L22;
        r2 = true;
        goto L23
    }
}
