package com.larus.audio;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class RtcEngineInitManager$b implements com.larus.platform.api.y {
    public final /* synthetic */ RtcEngineInitManager a;
    public final /* synthetic */ Function1<Boolean, Unit> b;
    public final /* synthetic */ cf9.a c;

    public final boolean a() {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RtcEngineInitManager$b(RtcEngineInitManager r1, Function1<? super Boolean, Unit> r2, cf9.a r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void onGetId(String r8, String r9, String r10) {
        Intrinsics.checkNotNullParameter(r8, "did");
        Intrinsics.checkNotNullParameter(r9, "iid");
        Intrinsics.checkNotNullParameter(r10, "ssid");
        this.a.getClass();
        boolean r11 = false;
        if (r8 != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L12;
    L15:
        if (r11 == true) goto L17;
        this.b.invoke(Boolean.FALSE);
        return;
    L17:
        RtcEngineInitManager r12 = this.a;
        cf9.a r13 = cf9.a.a(this.c, null, null, r8, false, 0, 27);
        Function1<Boolean, Unit> r14 = this.b;
        r12.getClass();
        RtcEngineInitManager.g(r13, r14);
        return;
    L12:
        if (Intrinsics.areEqual(r8, "0") == true) goto L15;
        r11 = true;
        goto L15
    L5:
        if (StringsKt.isBlank(r8) == true) goto L8;
        r0 = false;
        goto L9
    }
}
