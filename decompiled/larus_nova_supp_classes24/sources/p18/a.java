package p18;

import android.app.Activity;
import android.content.Context;
import com.ss.android.lark.log.Log;
import l18.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a implements e {
    public j18.b a;
    public Context b;

    public final void b() {
        Log.i("LKBridgeContextImpl", "release");
        this.a = null;
        this.b = null;
    }

    @Override // l18.e, i18.c
    public Context getContext() {
        return this.b;
    }

    public a(j18.b r1) {
        this.a = r1;
        this.b = r1.getContext();
    }

    @Override // l18.e
    public final void a(Activity r1) {
        this.b = r1;
    }
}
