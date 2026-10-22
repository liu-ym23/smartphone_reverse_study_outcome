package ca;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.obric.oui.button.OButton;
import com.obric.oui.titlebar.optimize.OCTitleBar;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;
import u8.h;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static final OButton a(OCTitleBar r10, Context r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$createButton");
        Intrinsics.checkNotNullParameter(r11, "context");
        View r13 = LayoutInflater.from(r11).inflate(r12, r10, false);
        Objects.requireNonNull(r13, "null cannot be cast to non-null type com.obric.oui.button.OButton");
        return (OButton) r13;
    }

    public static final OButton b(OCTitleBar r10, Context r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$createTransIconButton");
        Intrinsics.checkNotNullParameter(r11, "context");
        return a(r10, r11, h.o_widget_titlebar_trans_icon_button);
    }
}
