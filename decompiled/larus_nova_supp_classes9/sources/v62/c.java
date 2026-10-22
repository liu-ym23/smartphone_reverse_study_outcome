package v62;

import android.text.Editable;
import com.bytedance.android.live.core.utils.d2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c extends d2 {
    public final /* synthetic */ jf2.a a;

    public c(jf2.a r1) {
        this.a = r1;
    }

    public final void afterTextChanged(Editable r2) {
        jf2.a r0 = this.a;
        if (r2 == null) goto L5;
        String r3 = r2.toString();
    L6:
        r0.a(r3);
        return;
    L5:
        r3 = null;
        goto L6
    }
}
