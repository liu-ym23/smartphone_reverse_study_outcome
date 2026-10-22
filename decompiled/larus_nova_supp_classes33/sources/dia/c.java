package dia;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import com.larus.bmhome.chat.layout.item.i;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import eia.o;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class c extends o {

    public static final class a {
    }

    static {
    }

    @Override // eia.o
    public final void c(i r9) {
        Intrinsics.checkNotNullParameter(r9, "box");
        FLogger r0 = FLogger.a;
        r0.i("LandscapeMessageListStrategy", "updateMessageBoxWidth");
        View r2 = r9.getRootView();
        if (r2 == null) goto L5;
        Integer r3 = Integer.valueOf(r2.getWidth());
    L6:
        Resources r4 = r9.getResources();
        if (r4 == null) goto L11;
        DisplayMetrics r5 = WindowDisplayMetricsOverride.apply(r4, r4.getDisplayMetrics());
        if (r5 == null) goto L11;
        int r6 = r5.widthPixels;
    L12:
        if (r3 == null) goto L25;
        if (r6 <= 0) goto L27;
        int r7 = r6 - r3.intValue();
        int r8 = r9.getMaxWidth();
        r0.i("LandscapeMessageListStrategy", "currentMaxWidth: " + r8 + ", rootWidth: " + r3 + ", widthDelta: " + r7 + ", screenWidth: " + r6);
        if (r8 >= r3.intValue()) goto L18;
        int r10 = r8;
    L22:
        if (r8 == r10) goto L26;
        r9.setMaxWidth(r10);
        return;
    L26:
        return;
    L18:
        if (r8 >= r7) goto L20;
        r10 = r8;
    L21:
        r0.i("LandscapeMessageListStrategy", "targetMaxWidth: " + r10);
        goto L22
    L20:
        r10 = r8 - r7;
        goto L21
    L27:
        return;
    L25:
        return;
    L11:
        r6 = 0;
        goto L12
    L5:
        r3 = null;
        goto L6
    }

    public c(Context r2, t1a.b r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "vContext");
        super(r2, r3);
    }
}
