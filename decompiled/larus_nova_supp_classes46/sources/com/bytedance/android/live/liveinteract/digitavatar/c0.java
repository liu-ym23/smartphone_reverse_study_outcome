package com.bytedance.android.live.liveinteract.digitavatar;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.kmp.live.livelink.api.model.VideoShowMode;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c0 {
    public static final boolean a = false;
    public static final boolean b = false;
    public static DigitAvatarContext c;
    public static com.bytedance.android.livesdk.chatroom.o d;
    public static String e;

    static {
        a = ((Boolean) vm2.d.o0.getValue(null, vm2.d.a[64])).booleanValue();
        b = vm2.e.d();
    }

    @JvmStatic
    public static final AvatarGender b() {
        if (jc1.k.n(IMiddlewareUserService.class).user().b().getGender() == 2) goto L6;
        return AvatarGender.Male;
    L6:
        return AvatarGender.Female;
    }

    @JvmStatic
    public static final List<VideoShowMode> a(boolean r2, IRoom r3, boolean r4) {
        ArrayList r0 = new ArrayList();
        if (r2 == false) goto L7;
        r0.add(VideoShowMode.VIDEO);
        if (je0.d.X(r2, r3, r4) == false) goto L17;
        r0.add(VideoShowMode.DIGIT_AVATAR);
    L17:
        ALogger.d("KtvDigitAvatar", "getSupportedVideoShowMode " + r0.toString());
        return r0;
    L7:
        r0.add(VideoShowMode.AUDIO);
        if (us1.d.b(r2, tc0.c.h().E) == false) goto L15;
        if (((Boolean) b6.h.getValue()).booleanValue() == false) goto L15;
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.o(null) == true) goto L15;
        r0.add(VideoShowMode.VIDEO);
    L15:
        if (je0.d.X(r2, r3, r4) == false) goto L17;
        r0.add(VideoShowMode.DIGIT_AVATAR);
        goto L17
    }
}
