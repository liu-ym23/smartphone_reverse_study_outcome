package l4;

import android.app.Activity;
import android.content.Context;
import androidx.core.content.ContextCompat;
import e3.d;
import e3.e;
import java.util.Arrays;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import r4.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c {
    public static final boolean a(Context r10, String[] r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "permissions");
        if (r11.length != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return true;
    L8:
        int r1 = r11.length;
        int r12 = 0;
    L9:
        if (r12 >= r1) goto L17;
        if (ContextCompat.checkSelfPermission(r10, r11[r12]) != 0) goto L13;
        boolean r13 = true;
    L14:
        if (r13 == false) goto L21;
        r12 = r12 + 1;
        goto L9
    L21:
        return false;
    L13:
        r13 = false;
        goto L14
    L17:
        return true;
    L5:
        r0 = false;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r10v0, types: [java.lang.Object, l4.a] */
    public static final void b(d r11, final String r12, String[] r13, final Function1<? super String, Unit> r14, final Function2<? super Context, ? super Activity, Unit> r15) {
        Intrinsics.checkNotNullParameter(r11, "bridgeContext");
        Intrinsics.checkNotNullParameter(r12, "bridgeName");
        Intrinsics.checkNotNullParameter(r13, "permissions");
        Intrinsics.checkNotNullParameter(r14, "onError");
        Intrinsics.checkNotNullParameter(r15, "onGranted");
        final Context r10 = e.b(r11);
        if (r10 != null) goto L6;
        r14.invoke("context is null");
        return;
    L6:
        final Activity r16 = e.a(r11);
        if (a(r10, r13) == false) goto L10;
        r15.invoke(r10, r16);
        return;
    L10:
        if (r16 != null) goto L13;
        r14.invoke("activity is null");
        return;
    L13:
        ?? r17 = new a(r15, r10, r16, r14, r12);
        Intrinsics.checkNotNullParameter(r16, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        Intrinsics.checkNotNullParameter(r11, "bridgeContext");
        Intrinsics.checkNotNullParameter(r12, "bridgeName");
        Intrinsics.checkNotNullParameter(r13, "permissions");
        Intrinsics.checkNotNullParameter(r17, "onResult");
        if (a(r16, r13) == false) goto L16;
        r17.invoke(Boolean.TRUE);
        return;
    L16:
        i r0 = r4.a.f;
        if (r0 != null) goto L19;
        r17.invoke(Boolean.FALSE);
        return;
    L19:
        r0.a(r16, r11, r12, (String[]) Arrays.copyOf(r13, r13.length), new b(r17));
    }
}
