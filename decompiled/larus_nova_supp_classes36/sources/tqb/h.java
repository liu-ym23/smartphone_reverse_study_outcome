package tqb;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.lynxkit.host.ILarkLynxPageHolder;
import com.ss.android.lark.lynxkit.host.LarkLynxCloseSource;
import com.ss.android.lark.lynxkit.host.LarkLynxHostOptions;
import com.ss.android.lark.lynxkit.host.LarkLynxHostParams;
import com.ss.android.lark.lynxkit.host.LarkLynxPageActivity;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class h extends a implements ILarkLynxPageHolder {
    public final Context g;
    public String h;

    @Override // tqb.a, tqb.g
    public final void d() {
        this.h = null;
    }

    @Override // com.ss.android.lark.lynxkit.host.ILarkLynxPageHolder
    public final void close() {
        LarkLynxCloseSource r0 = LarkLynxCloseSource.PROGRAMMATIC;
        Intrinsics.checkNotNullParameter(r0, "source");
        c r1 = this.f;
        if (r1 == null) goto L6;
        r1.K40(r0);
        return;
    }

    @Override // tqb.a, com.ss.android.lark.lynxkit.host.ILarkLynxHostHolder
    public final void destroy() {
        super.destroy();
        ConcurrentHashMap<String, d> r0 = f.a;
        f.c(this.h);
        this.h = null;
    }

    @Override // com.ss.android.lark.lynxkit.host.ILarkLynxPageHolder
    public final boolean open() {
        if (isDestroyed() == false) goto L5;
        return false;
    L5:
        int r0 = b.a;
        if (b.b(this.a) == true) goto L10;
        Log.e("LynxHostHolder", "open failed, templateUrl and templatePath are empty");
        return false;
    L10:
        if (this.h == null) goto L12;
    L23:
        return true;
    L12:
        if (this.e != null) goto L23;
        this.d = true;
        ConcurrentHashMap<String, d> r1 = f.a;
        String r2 = f.b(this.a, this.b, false, this);
        this.h = r2;
        Intent r4 = new Intent(this.g, LarkLynxPageActivity.class).putExtra("extra_lynx_host_id", r2);     // Catch: Throwable -> L20
        if ((this.g instanceof Activity) == true) goto L18;
        r4.addFlags(268435456);     // Catch: Throwable -> L20
    L18:
        this.g.startActivity(r4);     // Catch: Throwable -> L20
        return true;
    L20:
        th = move-exception;
        ConcurrentHashMap<String, d> r5 = f.a;
        f.c(r2);
        this.h = null;
        Log.e("LynxHostHolder", "open failed", th);
        return false;
    }

    public h(Context r2, LarkLynxHostParams r3, LarkLynxHostOptions r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r4, "options");
        super(r3, r4);
        this.g = r2;
    }
}
