package bjb;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements y18.a {
    public String a;
    public final /* synthetic */ Context b;

    public final String getUserAgent() {
        if (TextUtils.isEmpty(this.a) == false) goto L6;
        Context r0 = this.b;
        yob.e.a().getClass();
        int r1 = com.ss.android.lark.language.service.impl.a.f;
        com.ss.android.lark.language.service.impl.a.b.a.getLanguageSetting();
        this.a = xoc.a.a(r0);
    L6:
        return this.a;
    }

    public d(Context r1) {
        this.b = r1;
    }
}
