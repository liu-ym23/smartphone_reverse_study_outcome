package y5;

import android.view.View;
import com.bytedance.ai.view.popup.params.AppletPopupSchemaParam;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d implements x5.a {
    public final AppletPopupSchemaParam a;
    public final View b;
    public final Function0<Unit> c;

    @Override // x5.a
    public final void invoke() {
        if (this.a.getDisableOutsideClickClose() == true) goto L6;
        this.b.setOnClickListener(new c(this));
        return;
    }

    public d(AppletPopupSchemaParam r10, View r11, com.bytedance.ai.view.popup.e r12) {
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r11, "view");
        this.a = r10;
        this.b = r11;
        this.c = r12;
    }
}
