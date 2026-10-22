package com.obric.oui.dialog.v2.alert;

import android.content.DialogInterface;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class c implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13155a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Lambda f13156b;

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ c(Function2 r5, int r10) {
        this.f13155a = r10;
        this.f13156b = (Lambda) r5;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, kotlin.jvm.functions.Function2, kotlin.jvm.internal.Lambda] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Object, kotlin.jvm.functions.Function2, kotlin.jvm.internal.Lambda] */
    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r5, int r10) {
        switch(this.f13155a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        ?? r11 = this.f13156b;
        Intrinsics.checkNotNullParameter(r11, "$listener");
        r11.mo2invoke(r5, Integer.valueOf(r10));
        return;
    L6:
        ?? r12 = this.f13156b;
        Intrinsics.checkNotNullParameter(r12, "$listener");
        r12.mo2invoke(r5, Integer.valueOf(r10));
    }
}
