package com.larus.dora.impl.device.settings.media;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.larus.common_ui.dialog.p0;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class v implements p0 {
    public final /* synthetic */ MediaSettingsFragment a;

    @Override // com.larus.common_ui.dialog.p0
    public final void confirm() {
        g49.d.d("MediaSettingsFragment", "record location dialog confirm: go settings");
        MediaSettingsFragment r0 = this.a;
        int r2 = MediaSettingsFragment.h;
        Context r3 = r0.getContext();
        if (r3 == null) goto L20;
        Intent r4 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        r4.setData(Uri.fromParts("package", r3.getPackageName(), null));
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L8
        r0.startActivity(r4);     // Catch: Throwable -> L8
        Object r1 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L11:
        if (Result.isSuccess-impl(r1) == false) goto L13;
        Unit r6 = (Unit) r1;
        g49.d.d("MediaSettingsFragment", "openAppSettings success");
    L13:
        Throwable r7 = Result.exceptionOrNull-impl(r1);
        if (r7 == null) goto L19;
        g49.d.c("MediaSettingsFragment", "openAppSettings failed", r7);
        return;
    L19:
        return;
    L8:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    public v(MediaSettingsFragment r1) {
        this.a = r1;
    }
}
