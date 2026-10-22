package com.larus.drive.biz.impl.viewmodel;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class r implements Function1 {
    public final /* synthetic */ AbsDriveListViewModel a;
    public final /* synthetic */ Fragment b;

    public /* synthetic */ r(AbsDriveListViewModel r1, Fragment r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r4) {
        AbsDriveListViewModel r0 = this.a;
        Fragment r1 = this.b;
        String r5 = (String) r4;
        Intrinsics.checkNotNullParameter(r5, "error");
        AbsDriveListViewModel.access$setFileRenameCanceller$p(r0, null);
        if (Intrinsics.areEqual(r5, "error_message_drive_update") == false) goto L5;
        int r6 = 2131905388;
    L6:
        t19.s r2 = t19.s.a;
        FragmentActivity r3 = r1.getActivity();
        String r7 = r1.getString(r6);
        r2.getClass();
        t19.s.t(r3, r7);
        return Unit.INSTANCE;
    L5:
        r6 = 2131905570;
        goto L6
    }
}
