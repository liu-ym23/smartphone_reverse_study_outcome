package rub;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.api.recording.common.depend.ui.entity.MmPanelHeightConfig;
import com.ss.android.lark.officesdk.minutes.api.recording.common.depend.ui.entity.MmPanelHostMode;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d {
    public final String a;
    public final String b;
    public final Function1<Context, View> c;
    public final Bundle d;
    public final boolean e;
    public final Function0<Unit> f;
    public final Function0<Unit> g;
    public final MmPanelHeightConfig h;
    public final MmRecordingUILaunchMode i;
    public final c j;
    public final MmPanelHostMode k;
    public final boolean l;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r6 = (d) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (this.i == r6.i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(null, null) == true) goto L42;
        return false;
    L42:
        if (this.k == r6.k) goto L45;
        return false;
    L45:
        if (this.l == r6.l) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        Bundle r1 = this.d;
        if (r1 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = (r0 + r2) * 31;
        int r4 = 1231;
        if (this.e == false) goto L9;
        int r5 = 1231;
    L10:
        int r6 = (r3 + r5) * 31;
        Function0<Unit> r7 = this.f;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Function0<Unit> r10 = this.g;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        MmPanelHeightConfig r13 = this.h;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (((((((((r12 + r14) * 31) + this.i.hashCode()) * 31) + this.j.hashCode()) * 31) + 0) * 31) + this.k.hashCode()) * 31;
        if (this.l == true) goto L27;
        r4 = 1237;
    L27:
        return r15 + r4;
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = 1237;
        goto L10
    L5:
        r2 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "MmPanelConfig(tag=" + this.a + ", id=" + this.b + ", contentViewProvider=" + this.c + ", args=" + this.d + ", isCancelable=" + this.e + ", onDismiss=" + this.f + ", onShow=" + this.g + ", heightConfig=" + this.h + ", uiLaunchMode=" + this.i + ", backgroundConfig=" + this.j + ", dismissConfig=null, hostMode=" + this.k + ", drawBehindNavigationBar=" + this.l + ')';
    }

    public /* synthetic */ d(String r17, Function1 r18, MmPanelHeightConfig r19, MmRecordingUILaunchMode r20, c r21, boolean r22, int r23) {
        MmPanelHostMode r2 = null;
        if ((r23 & 2) == 0) goto L5;
        String r5 = r17;
    L7:
        if ((r23 & 16) == 0) goto L9;
        boolean r8 = true;
    L11:
        if ((r23 & 128) == 0) goto L13;
        MmPanelHeightConfig r11 = null;
    L15:
        if ((r23 & 256) == 0) goto L17;
        MmRecordingUILaunchMode r12 = MmRecordingUILaunchMode.UNKNOWN;
    L19:
        if ((r23 & 512) == 0) goto L21;
        c r13 = c.b.a;
    L23:
        if ((r23 & 2048) == 0) goto L25;
        r2 = MmPanelHostMode.DEFAULT;
    L25:
        MmPanelHostMode r14 = r2;
        if ((r23 & 4096) == 0) goto L28;
        boolean r15 = false;
    L29:
        this(r17, r5, r18, null, r8, null, null, r11, r12, r13, r14, r15);
        return;
    L28:
        r15 = r22;
        goto L29
    L21:
        r13 = r21;
        goto L23
    L17:
        r12 = r20;
        goto L19
    L13:
        r11 = r19;
        goto L15
    L9:
        r8 = false;
        goto L11
    L5:
        r5 = null;
        goto L7
    }

    public d(String r2, String r3, Function1 r4, Bundle r5, boolean r6, Function0 r7, Function0 r8, MmPanelHeightConfig r9, MmRecordingUILaunchMode r10, c r11, MmPanelHostMode r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "id");
        Intrinsics.checkNotNullParameter(r4, "contentViewProvider");
        Intrinsics.checkNotNullParameter(r10, "uiLaunchMode");
        Intrinsics.checkNotNullParameter(r11, "backgroundConfig");
        Intrinsics.checkNotNullParameter(r12, "hostMode");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = r12;
        this.l = r13;
    }
}
