package y8b;

import android.os.Handler;
import com.ss.android.lark.contact.base.common_ui.SearchEditText;
import com.ss.android.lark.utils.a1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements SearchEditText.b {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    @Override // com.ss.android.lark.contact.base.common_ui.SearchEditText.b
    public final void h(String r3) {
        boolean r0 = a1.f;
        Handler r1 = a1.a.a.a;
        r1.sendMessage(r1.obtainMessage(2131361936, r3));
    }
}
