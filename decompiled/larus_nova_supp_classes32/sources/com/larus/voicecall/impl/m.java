package com.larus.voicecall.impl;

import com.larus.audio.call.tracer.IRealtimeCallTracer;
import com.larus.platform.api.g1;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Result;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class m implements g1.c {
    public final /* synthetic */ i<Integer> a;
    public final /* synthetic */ l b;

    public final void onGoSettingsDialogDismiss(boolean r1) {
    }

    public final void onGoSettingsDialogShow() {
    }

    public final void onSettingPageReturn() {
    }

    public m(kotlinx.coroutines.j r1, l r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onResult(boolean r17, List<String> r18, List<String> r19, boolean r20) {
        Intrinsics.checkNotNullParameter(r18, "grantedList");
        Intrinsics.checkNotNullParameter(r19, "deniedList");
        FLogger.a.i("RealtimeCallCheckManager", "deniedList=" + CollectionsKt.joinToString$default(r19, null, null, null, 0, null, null, 63, null) + "  grantedList=" + CollectionsKt.joinToString$default(r18, null, null, null, 0, null, null, 63, null));
        if (r20 == false) goto L5;
        i<Integer> r1 = this.a;
        Result.Companion r2 = Result.Companion;
        r1.resumeWith(Result.constructor-impl(3));
        return;
    L5:
        if (r17 == false) goto L7;
    L13:
        int r3 = 0;
    L14:
        this.a.resumeWith(Result.constructor-impl(Integer.valueOf(r3)));
        return;
    L7:
        if (r18.contains("android.permission.RECORD_AUDIO") == true) goto L13;
        l r4 = this.b;
        IRealtimeCallTracer r5 = r4.b;
        if (r5 == null) goto L12;
        r5.g0(r4.c, r4.d, r4.e, r4.f);
    L12:
        r3 = 2;
        goto L14
    }
}
