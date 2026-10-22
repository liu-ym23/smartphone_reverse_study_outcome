package gz8;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import androidx.core.content.ContextCompat;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class g {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static GradientDrawable a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        GradientDrawable r0 = new GradientDrawable();
        r0.setShape(0);
        boolean r1 = v19.h.a;
        if (v19.h.b(r2) == false) goto L5;
        int r3 = 2131102541;
    L6:
        r0.setColor(ContextCompat.getColor(r2, r3));
        r0.setCornerRadius(i5.q());
        return r0;
    L5:
        r3 = 2131102540;
        goto L6
    }

    public static int b(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return v19.c.a(2130972079, r2, 2131103136);
    }

    public static int c(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return v19.c.a(2130972081, r2, 2131103143);
    }

    public static int d(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return v19.c.a(2130972086, r2, 2131103159);
    }
}
