package com.larus.bmhome.chat.list.cell.record;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class RecordCardCell$b {
    public static void a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "msgId");
        RecordCardCell.m.put(r3, Long.valueOf(System.currentTimeMillis()));
    }
}
