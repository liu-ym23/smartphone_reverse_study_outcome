package w9b;

import android.text.Layout;
import android.view.View;
import android.widget.TextView;
import com.ss.android.lark.coremd.base.parse.z;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements z<TextView> {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
    }

    @Override // com.ss.android.lark.coremd.base.parse.z
    public final Class<TextView> b() {
        return TextView.class;
    }

    @Override // com.ss.android.lark.coremd.base.parse.z
    public final Layout a(View r2) {
        TextView r3 = (TextView) r2;
        Intrinsics.checkNotNullParameter(r3, "view");
        return r3.getLayout();
    }

    @Override // com.ss.android.lark.coremd.base.parse.z
    public final CharSequence c(View r2) {
        TextView r3 = (TextView) r2;
        Intrinsics.checkNotNullParameter(r3, "view");
        return r3.getText();
    }
}
