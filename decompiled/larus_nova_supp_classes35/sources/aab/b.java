package aab;

import android.text.Layout;
import android.view.View;
import com.ss.android.lark.coremd.base.parse.z;
import com.ss.android.lark.widget.light.LKUILightTextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements z<LKUILightTextView> {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    @Override // com.ss.android.lark.coremd.base.parse.z
    public final Class<LKUILightTextView> b() {
        return LKUILightTextView.class;
    }

    @Override // com.ss.android.lark.coremd.base.parse.z
    public final Layout a(View r2) {
        LKUILightTextView r3 = (LKUILightTextView) r2;
        Intrinsics.checkNotNullParameter(r3, "view");
        return r3.getLayout();
    }

    @Override // com.ss.android.lark.coremd.base.parse.z
    public final CharSequence c(View r2) {
        LKUILightTextView r3 = (LKUILightTextView) r2;
        Intrinsics.checkNotNullParameter(r3, "view");
        return r3.getContentText();
    }
}
