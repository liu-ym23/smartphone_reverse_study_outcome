package com.bytedance.android.live.liveinteract.voicechat.subtitle;

import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j<T> implements Consumer {
    public final /* synthetic */ LinkmicSubtitleBusinessWidget a;

    public j(LinkmicSubtitleBusinessWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r11) {
        LinkmicSubtitleBusinessWidget r0 = this.a;
        boolean r12 = ((zg1.s) r11).a;
        int r1 = LinkmicSubtitleBusinessWidget.x;
        if (r0.isAnchor() == false) goto L10;
        LinkmicSubtitleBusinessContext r2 = r0.e;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mDataContext");
    L8:
        if (((LinkmicSubtitleStatus) r2.getStatus().getValue()) != LinkmicSubtitleStatus.OPEN) goto L10;
    L19:
        boolean r3 = true;
        if (r12 == false) goto L30;
        s r4 = t.a;
        Boolean r5 = r4.d.get("clean_screen");
        Boolean r6 = Boolean.FALSE;
        if (Intrinsics.areEqual(r5, r6) == false) goto L48;
        nj0.f r7 = LinkmicSubtitleUIContext.Companion.a();
        if (r7 == null) goto L48;
        if (r7.J9() != true) goto L48;
        if (Intrinsics.areEqual(r4.d.get("record"), r6) == false) goto L48;
        r4.d.put("clean_screen", Boolean.TRUE);
        r4.c.put("clean_screen", Long.valueOf(System.currentTimeMillis()));
    L48:
        r0.h.put("clearScreen", Boolean.valueOf(r12));
        return;
    L30:
        s r8 = t.a;
        if (Intrinsics.areEqual(r8.d.get("clean_screen"), Boolean.TRUE) == false) goto L48;
        if (t.a("clean_screen") == 0) goto L48;
        r8.d.put("clean_screen", Boolean.FALSE);
        t.f("clean_screen");
        int r9 = nd0.g.a;
        LinkmicSubtitleBusinessContext r10 = r0.e;
        if (r10 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("mDataContext");
    L38:
        if (((LinkmicSubtitleStatus) r10.getStatus().getValue()) != LinkmicSubtitleStatus.OPEN) goto L40;
        boolean r13 = true;
    L41:
        nj0.f r14 = LinkmicSubtitleUIContext.Companion.a();
        if (r14 != null) goto L44;
    L46:
        r3 = false;
    L47:
        nd0.g.b(r13, r3, String.valueOf(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - 0)), "clean_screen");
        goto L48
    L44:
        if (r14.J9() != true) goto L46;
    L40:
        r13 = false;
    L10:
        if (r0.isAnchor() == true) goto L48;
        LinkmicSubtitleBusinessContext.Companion.getClass();
        if (LinkmicSubtitleBusinessContext.a.c() == false) goto L48;
        LinkmicSubtitleBusinessContext r15 = r0.e;
        if (r15 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mDataContext");
    L17:
        if (((LinkmicSubtitleStatus) r15.getStatus().getValue()) != LinkmicSubtitleStatus.OPEN) goto L48;
        int r16 = g0.a;
        goto L19
    }
}
