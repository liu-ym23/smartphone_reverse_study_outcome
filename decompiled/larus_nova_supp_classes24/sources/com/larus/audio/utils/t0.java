package com.larus.audio.utils;

import com.mammon.audiosdk.structures.SAMICoreServerEvent;
import com.mammon.audiosdk.structures.SAMICoreWebSocketConnectionEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class t0 {
    public static final String a(SAMICoreServerEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return " append_msg status_code=" + r2.statusCode + " status_msg=" + r2.statusText;
    }

    public static final String b(SAMICoreWebSocketConnectionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return " append_msg state=" + r2.state + " textMsg=" + r2.textMsg;
    }
}
