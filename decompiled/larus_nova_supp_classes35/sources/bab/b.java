package bab;

import android.widget.TextView;
import com.ss.android.lark.widget.light.LKUILightTextView;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b {
    static {
    }

    @JvmStatic
    public static final void a(TextView r3) {
        Intrinsics.checkNotNullParameter(r3, "textView");
        Object r1 = r3.getTag(2131388123);
        if ((r1 instanceof c) == false) goto L5;
        c r2 = (c) r1;
    L6:
        if (r2 != null) goto L8;
        r2 = new c(r3);
        r3.setTag(2131388123, r2);
    L8:
        r3.removeTextChangedListener(r2);
        r3.addTextChangedListener(r2);
        return;
    L5:
        r2 = null;
        goto L6
    }

    @JvmStatic
    public static final void b(LKUILightTextView r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        Object r1 = r3.getTag(2131388123);
        if ((r1 instanceof a) == false) goto L5;
        a r2 = (a) r1;
    L6:
        if (r2 != null) goto L8;
        r2 = new a(r3);
        r3.setTag(2131388123, r2);
    L8:
        Intrinsics.checkNotNullParameter(r2, "listener");
        r3.b1.remove(r2);
        Intrinsics.checkNotNullParameter(r2, "listener");
        r3.b1.add(r2);
        return;
    L5:
        r2 = null;
        goto L6
    }
}
