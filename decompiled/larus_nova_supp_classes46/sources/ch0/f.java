package ch0;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.n;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f {
    @Deprecated(message = "即将废弃，声波状态需要从单独的Observable中获取,LinkUserDataMergeCenterV2#linkUserTalkingObservable")
    public static final boolean a(e r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$isTalking");
        h r0 = r4.b;
        if (r0 == null) goto L11;
        if (r0 == null) goto L11;
        if (r0.g != 1) goto L11;
        if (r0 != null) goto L9;
        return false;
    L9:
        if (r0.e != true) goto L19;
    L16:
        return true;
    L19:
        return false;
    L11:
        j r5 = r4.c;
        if (r5 == null) goto L20;
        if (r5 != null) goto L15;
        return false;
    L15:
        if (r5.b == true) goto L16;
        return false;
    L20:
        return false;
    }

    public static final boolean b(e r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$isVideoOrAvatar");
        if (d(r1) == true) goto L5;
    L7:
        return false;
    L5:
        if (c(r1) == false) goto L7;
        return true;
    }

    public static final boolean c(e r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$linkTypeIsVideoOrAvatar");
        ILinkPlayerInfoBridge r0 = r2.a;
        if (r0 != null) goto L5;
    L6:
        ILinkPlayerInfoBridge r3 = r2.a;
        if (r3 != null) goto L9;
    L11:
        return false;
    L9:
        if (r3.getLinkType() != 3) goto L11;
        return true;
    L5:
        if (r0.getLinkType() != 1) goto L6;
        return true;
    }

    public static final boolean d(e r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$mediaTypeIsVideoOrAvatar");
        h r0 = r4.b;
        if (r0 == null) goto L11;
        if (r0 == null) goto L11;
        if (r0.g != 1) goto L11;
        if (r0 != null) goto L9;
        return false;
    L9:
        if (r0.c == true) goto L27;
    L24:
        return true;
    L27:
        return false;
    L11:
        j r5 = r4.c;
        if (r5 == null) goto L28;
        if (r5 == null) goto L15;
        Integer r6 = Integer.valueOf(r5.c);
    L16:
        if (r6 != null) goto L19;
    L20:
        if (r6 != null) goto L23;
        return false;
    L23:
        if (r6.intValue() == 3) goto L24;
        return false;
    L19:
        if (r6.intValue() == 1) goto L24;
    L15:
        r6 = null;
        goto L16
    L28:
        return false;
    }

    public static final String e(e r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$toPriorityInfoStr");
        StringBuilder r0 = new StringBuilder("{uid: ");
        IBaseUser r1 = r3.a.getUser();
        Long r2 = null;
        if (r1 == null) goto L5;
        String r4 = r1.getIdString();
    L6:
        r0.append(r4);
        r0.append(", nickName:");
        IBaseUser r5 = r3.a.getUser();
        if (r5 == null) goto L9;
        String r6 = r5.getNickName();
    L10:
        r0.append(r6);
        r0.append(", isUnSilence: ");
        r0.append(n.i(r3.a));
        r0.append(", isTalking: ");
        h r7 = r3.b;
        if (r7 == null) goto L13;
        Boolean r8 = Boolean.valueOf(r7.e);
    L14:
        r0.append(r8);
        r0.append(", lastTalkingTime: ");
        h r9 = r3.b;
        if (r9 == null) goto L17;
        r2 = Long.valueOf(r9.f);
    L17:
        r0.append(r2);
        r0.append(", joinChannelTime: ");
        r0.append(r3.a.getJoinChannelTime());
        r0.append('}');
        return r0.toString();
    L13:
        r8 = null;
        goto L14
    L9:
        r6 = null;
        goto L10
    L5:
        r4 = null;
        goto L6
    }
}
