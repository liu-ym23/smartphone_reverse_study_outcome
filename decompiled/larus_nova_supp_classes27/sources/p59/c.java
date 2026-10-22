package p59;

import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.larus.common_ui.dialog.p0;
import com.larus.dora.impl.nl.n;
import com.larus.dora.impl.nl.permission.NLPermissionSettingResultActivity;
import com.larus.permission.api.IPermissionX;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class c implements p0 {
    public final /* synthetic */ IPermissionX.c a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ Fragment c;

    @Override // com.larus.common_ui.dialog.p0
    public final void confirm() {
        if (this.a == null) goto L5;
        Intent r0 = new Intent(this.b, NLPermissionSettingResultActivity.class);
        int r2 = (int) System.currentTimeMillis();
        r0.putExtra("request_code", r2);
        ConcurrentHashMap<Integer, IPermissionX.c> r1 = a.a;
        IPermissionX.c r3 = this.a;
        Intrinsics.checkNotNullParameter(r3, "callback");
        Integer r4 = Integer.valueOf(r2);
        a.a.put(r4, r3);
        this.c.startActivity(r0);
        return;
    L5:
        n.e(this.b);
    }

    public c(b.C0136b r1, Context r2, Fragment r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
