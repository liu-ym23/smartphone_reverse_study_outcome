package foc;

import android.content.Context;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dimension.UDDimension;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a extends UDBaseDialogBuilder<a> {
    public String a;
    public final List<goc.b.l> b;
    public e c;
    public final int d;

    public a(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        marginInDp(36);
        maxWidth(new UDDimension.Dp(303));
        messageGravity(8388611);
        controller(new c(r3));
        this.b = new ArrayList();
        this.d = UDColorUtils.getColor(r3, 2131106616);
    }
}
