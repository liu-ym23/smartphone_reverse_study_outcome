package com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core;

import com.ss.android.lark.officesdk.minutes.api.recording.doubao.DoubaoStatisticInfo;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b {
    public final ConcurrentHashMap<String, com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.a> a;

    public static final class a {
    }

    static {
    }

    public b() {
        this.a = new ConcurrentHashMap();
    }

    public final void a(String r3) {
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.a r0 = this.a.get(r3);
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.d == true) goto L8;
        return;
    L8:
        if (r0.e == false) goto L12;
        this.a.remove(r3);
        lvb.a.e("MmRecordingBusinessTrackContextStore", "[tryRemoveIfLifecycleFinished] remove context, sessionId=" + r3);
        return;
    }

    public final com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.a getContext(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sessionId");
        return this.a.get(r2);
    }

    public final void b(String r10, Boolean r11, Boolean r12, String r13) {
        if (StringsKt.isBlank(r10) == false) goto L6;
        lvb.a.h("MmRecordingBusinessTrackContextStore", "[" + r13 + "] skip: sessionId is blank");
        return;
    L6:
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.a r0 = this.a.get(r10);
        if (r0 != null) goto L10;
        lvb.a.h("MmRecordingBusinessTrackContextStore", "[" + r13 + "] skip: context missing, sessionId=" + r10);
        return;
    L10:
        if (r11 == null) goto L12;
        boolean r14 = r11.booleanValue();
    L13:
        boolean r7 = r14;
        if (r12 == null) goto L16;
        boolean r15 = r12.booleanValue();
    L17:
        String r4 = r0.a;
        MmRecordingCommonParam r5 = r0.b;
        DoubaoStatisticInfo r6 = r0.c;
        Intrinsics.checkNotNullParameter(r4, "sessionId");
        Intrinsics.checkNotNullParameter(r5, "commonParam");
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.a r16 = new com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.a(r4, r5, r6, r7, r15);
        this.a.put(r10, r16);
        lvb.a.e("MmRecordingBusinessTrackContextStore", "[" + r13 + "] sessionId=" + r10 + ", sessionEnded=" + r16.d + ", endWindowClosed=" + r16.e);
        a(r10);
        return;
    L16:
        r15 = r0.e;
        goto L17
    L12:
        r14 = r0.d;
        goto L13
    }
}
