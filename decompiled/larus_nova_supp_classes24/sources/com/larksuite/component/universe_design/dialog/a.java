package com.larksuite.component.universe_design.dialog;

import android.content.Context;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a extends UDBaseDialogBuilder<a> {
    public CharSequence a;
    public UDCheckBox.c b;

    public a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.a = "";
        setMController$universe_ui_dialog_release(new b(r2));
        UDBaseDialogBuilder.b r3 = UDBaseDialogBuilder.Companion;
        r3.getClass();
        setMMarginInDp$universe_ui_dialog_release(UDBaseDialogBuilder.access$getDialogMargin$cp());
        r3.getClass();
        setMMaxWidth$universe_ui_dialog_release(UDBaseDialogBuilder.access$getDialogMaxWidth$cp());
    }
}
