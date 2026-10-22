package r08;

import android.content.Context;
import com.larksuite.component.universe_design.dialog.UDBaseListDialogBuilder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a extends UDBaseListDialogBuilder<a> {
    public float a;

    public a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        setMController$universe_ui_dialog_release(new b(r2));
        setMWidth$universe_ui_dialog_release(1.0f);
        setMGravity$universe_ui_dialog_release(80);
        setMMarginInDp$universe_ui_dialog_release(0);
    }
}
