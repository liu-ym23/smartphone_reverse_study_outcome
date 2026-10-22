package com.ss.android.lark.officesdk.minutes.ui.record.speaker;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.c;
import com.ss.android.lark.officesdk.minutes.ui.foundation.mvi.MviBaseFragment;
import kotlin.jvm.internal.Intrinsics;
import qub.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b {
    public final Fragment a;
    public final FragmentManager b;
    public final e c;
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a d;
    public final String e;
    public final String f;
    public final long g;
    public final c h;
    public final a i;
    public final MmRecordingUILaunchMode j;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof b) == true) goto L8;
        return false;
    L8:
        b r9 = (b) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r9.f) == true) goto L27;
        return false;
    L27:
        if (this.g == r9.g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r9.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r9.i) == true) goto L36;
        return false;
    L36:
        if (this.j == r9.j) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31;
        long r1 = this.g;
        return ((((((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31) + this.j.hashCode();
    }

    public final String toString() {
        return "MmSpeakerMarkPanelParams(hostFragment=" + this.a + ", fragmentManager=" + this.b + ", panelProvider=" + this.c + ", mmUccApi=" + this.d + ", meetingId=" + this.e + ", clusterId=" + this.f + ", segId=" + this.g + ", oldSpeaker=" + this.h + ", callback=" + this.i + ", uiLaunchMode=" + this.j + ')';
    }

    public b(MviBaseFragment r2, FragmentManager r3, e r4, com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r5, String r6, String r7, long r8, c r10, a r11, MmRecordingUILaunchMode r12) {
        Intrinsics.checkNotNullParameter(r2, "hostFragment");
        Intrinsics.checkNotNullParameter(r3, "fragmentManager");
        Intrinsics.checkNotNullParameter(r4, "panelProvider");
        Intrinsics.checkNotNullParameter(r5, "mmUccApi");
        Intrinsics.checkNotNullParameter(r6, "meetingId");
        Intrinsics.checkNotNullParameter(r7, "clusterId");
        Intrinsics.checkNotNullParameter(r10, "oldSpeaker");
        Intrinsics.checkNotNullParameter(r11, "callback");
        Intrinsics.checkNotNullParameter(r12, "uiLaunchMode");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r10;
        this.i = r11;
        this.j = r12;
    }
}
