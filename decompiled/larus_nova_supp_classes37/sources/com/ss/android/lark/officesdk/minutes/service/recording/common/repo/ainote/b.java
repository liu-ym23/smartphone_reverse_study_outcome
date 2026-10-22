package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote;

import android.view.ViewGroup;
import com.ss.android.ainote.AINotes;
import com.ss.android.ainote.model.AINoteScene;
import com.ss.android.ainote.p0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b {
    public AINotes a;

    public b() {
    }

    public final boolean a() {
        if (this.a == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean b(ViewGroup r4, com.ss.android.ainote.d r5, AINoteScene r6, MmRecordingAINoteRepo.b r7) {
        Intrinsics.checkNotNullParameter(r4, "container");
        Intrinsics.checkNotNullParameter(r5, "bizIds");
        Intrinsics.checkNotNullParameter(r6, "scene");
        Intrinsics.checkNotNullParameter(r7, "delegate");
        p0 r1 = new p0();
        Intrinsics.checkNotNullParameter(r5, "ids");
        r1.a = r5;
        Intrinsics.checkNotNullParameter(r6, "scene");
        r1.b = r6;
        r1.c = r7;
        AINotes r8 = r1.a(r4);
        this.a = r8;
        if (r8 == null) goto L5;
        return true;
    L5:
        return false;
    }
}
