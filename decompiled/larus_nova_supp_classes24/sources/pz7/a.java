package pz7;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.appcompat.content.res.AppCompatResources;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {
    static {
    }

    @JvmStatic
    public static final Drawable a(Context r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r1, "context");
        Drawable r4 = AppCompatResources.getDrawable(r1, r2);
        if (r4 == null) goto L7;
        r4.mutate();
        r4.setTint(r3);
        return r4;
    L7:
        throw new Resources.NotFoundException("Resource ID #0x" + Integer.toHexString(r2));
    }
}
