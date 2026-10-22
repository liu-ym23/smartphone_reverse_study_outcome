package com.larus.browsertakeover.signaling;

import com.larus.im.internal.jni.bean.RoomMeta;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class j {
    public static final boolean b(RoomMeta r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        String r0 = r3.rtcAppId;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L36;
        String r2 = r3.roomId;
        if (r2 != null) goto L13;
    L16:
        boolean r4 = true;
    L17:
        if (r4 == true) goto L37;
        String r5 = r3.rtcUserId;
        if (r5 != null) goto L21;
    L24:
        boolean r6 = true;
    L25:
        if (r6 == true) goto L38;
        String r7 = r3.token;
        if (r7 != null) goto L29;
    L32:
        boolean r8 = true;
    L33:
        if (r8 == true) goto L39;
        return true;
    L39:
        return false;
    L29:
        if (StringsKt.isBlank(r7) == true) goto L32;
        r8 = false;
        goto L33
    L38:
        return false;
    L21:
        if (StringsKt.isBlank(r5) == true) goto L24;
        r6 = false;
        goto L25
    L37:
        return false;
    L13:
        if (StringsKt.isBlank(r2) == true) goto L16;
        r4 = false;
        goto L17
    L36:
        return false;
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    public static final boolean a(RoomMeta r5, RoomMeta r6) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r6, "previous");
        if (b(r5) == false) goto L26;
        String r0 = r5.sessionId;
        if (r0 != null) goto L7;
    L10:
        boolean r1 = true;
    L11:
        if (r1 == false) goto L13;
        return false;
    L13:
        if (Intrinsics.areEqual(r5.sessionId, r6.sessionId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(r5.rtcAppId, r6.rtcAppId) == true) goto L17;
        return false;
    L17:
        if (Intrinsics.areEqual(r5.roomId, r6.roomId) == true) goto L19;
        return false;
    L19:
        if (Intrinsics.areEqual(r5.rtcUserId, r6.rtcUserId) == true) goto L21;
        return false;
    L21:
        if (r5.useRtcTestDomain == r6.useRtcTestDomain) goto L23;
        return false;
    L23:
        if (r5.expireTimeMs <= r6.expireTimeMs) goto L33;
        return true;
    L33:
        return false;
    L7:
        if (StringsKt.isBlank(r0) == true) goto L10;
        r1 = false;
        goto L11
    L26:
        return false;
    }
}
