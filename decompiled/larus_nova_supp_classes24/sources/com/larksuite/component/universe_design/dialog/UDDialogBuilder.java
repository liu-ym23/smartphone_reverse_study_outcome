package com.larksuite.component.universe_design.dialog;

import android.content.Context;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/larksuite/component/universe_design/dialog/UDDialogBuilder;", "Lcom/larksuite/component/universe_design/dialog/UDBaseDialogBuilder;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "universe-ui-dialog_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class UDDialogBuilder extends UDBaseDialogBuilder<UDDialogBuilder> {
    public static final int $stable = 8;

    public UDDialogBuilder(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        UDBaseDialogBuilder.b r3 = UDBaseDialogBuilder.Companion;
        r3.getClass();
        setMMarginInDp$universe_ui_dialog_release(UDBaseDialogBuilder.access$getDialogMargin$cp());
        r3.getClass();
        setMMaxWidth$universe_ui_dialog_release(UDBaseDialogBuilder.access$getDialogMaxWidth$cp());
    }
}
