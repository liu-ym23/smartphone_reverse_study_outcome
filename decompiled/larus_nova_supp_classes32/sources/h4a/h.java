package h4a;

import android.app.Activity;
import android.content.Context;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.larus.platform.service.i2;
import com.monitor.cloudmessage.consts.CloudControlInf;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class h implements hx7.e {
    public h() {
    }

    public final boolean isPermissionAllGranted(Context r6, String... r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, CloudControlInf.PERMISSION);
        int r0 = r7.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        if ((-1) == ContextCompat.checkSelfPermission(r6, r7[r2])) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    public final void a(Activity r3, String[] r4, final hx7.i r5) {
        Intrinsics.checkNotNullParameter(r3, "activity");
        Intrinsics.checkNotNullParameter(r4, "permissionName");
        Intrinsics.checkNotNullParameter(r5, "callback");
        i2.b.m((FragmentActivity) r3, ArraysKt.toList(r4), new g(r5));
    }
}
