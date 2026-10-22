package r0c;

import android.content.Context;
import android.text.TextUtils;
import com.larksuite.framework.utils.UIUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b implements d {
    public final Context a;
    public final boolean b;
    public final String c;

    @Override // r0c.d
    public final String a() {
        return UIUtils.getString(this.a, 2131891639);
    }

    @Override // r0c.d
    public final Runnable getAction() {
        return new a(this);
    }

    @Override // r0c.d
    public final boolean isValid() {
        if (this.b == true) goto L5;
    L7:
        return false;
    L5:
        if (TextUtils.isEmpty(this.c) == true) goto L7;
        return true;
    }

    public b(Context r1, boolean r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
