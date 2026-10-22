package com.larksuite.component.universe_design.dialog;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c extends UDBaseDialogBuilder<c> {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final int i;
    public CharSequence j;
    public CharSequence k;
    public boolean l;
    public boolean m;
    public a n;

    public interface a {
        void onTextChanged(CharSequence r1);
    }

    public c(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.a = -1;
        this.b = -1;
        this.c = -1;
        this.d = -1;
        this.e = -1;
        this.f = -1;
        this.g = -1;
        this.h = -1;
        this.i = -1;
        this.k = "";
        setMController$universe_ui_dialog_release(new d(r2));
        UDBaseDialogBuilder.b r3 = UDBaseDialogBuilder.Companion;
        r3.getClass();
        setMMarginInDp$universe_ui_dialog_release(UDBaseDialogBuilder.access$getDialogMargin$cp());
        r3.getClass();
        setMMaxWidth$universe_ui_dialog_release(UDBaseDialogBuilder.access$getDialogMaxWidth$cp());
    }
}
