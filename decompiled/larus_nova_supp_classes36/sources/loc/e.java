package loc;

import android.content.Context;
import android.graphics.PorterDuff;
import android.widget.ImageView;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.ss.android.lark.image.ImageLoader;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e {
    public static joc.c a;
    public static joc.b b;

    static {
    }

    @JvmStatic
    public static final void a(ImageView r1, Context r2, String r3, Integer r4) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "url");
        ImageLoader.with(r2).load(r3).placeholder(2131255040).error(2131256306).into(r1);
        if (r4 != null) goto L5;
        return;
    L5:
        r1.setColorFilter(UDColorUtils.getColor(r2, r4.intValue()), PorterDuff.Mode.SRC_IN);
    }
}
