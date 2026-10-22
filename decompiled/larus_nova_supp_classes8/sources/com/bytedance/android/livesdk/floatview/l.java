package com.bytedance.android.livesdk.floatview;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import com.bytedance.android.livesdk.widget.x0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class l {
    public static final /* synthetic */ int a = 0;

    public static final class a implements DialogInterface.OnClickListener {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            r1.dismiss();
        }
    }

    static {
    }

    public static Intent a(Context r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "packageName");
        return com.bytedance.android.live.core.utils.a.a(r1, r2);
    }

    public static boolean b(Context r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "packageName");
        if (rx1.m.a(r4) == true) goto L13;
        x0.d r6 = new x0.d();
        r6.b = r4;
        r6.a = 4;
        r6.c = r6.b.getText(2131923055);
        r6.d = r6.b.getText(2131916676);
        a r7 = a.a;
        CharSequence r0 = r6.b.getText(2131920806);
        x0.c[] r1 = r6.g;
        x0.c r2 = r1[0];
        if (r2 != null) goto L7;
        r2 = new x0.c();
        r1[0] = r2;
    L7:
        r2.a = r0;
        r2.b = r7;
        x0 r8 = new x0(r6.b, r6);
        if (Build.VERSION.SDK_INT < 26) goto L10;
        r8.getWindow().setType(2038);
    L11:
        x0.b.g(r8);
        return false;
    L10:
        r8.getWindow().setType(2002);
        goto L11
    L13:
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "packageName");
        if (Intrinsics.areEqual(r4.getPackageName(), r5) == false) goto L27;
        Context r3 = r4;
    L21:
        Intent r9 = a(r4, r5);
        if (r3 == null) goto L26;
        if (r9 == null) goto L26;
        r9.putExtra("key_is_start_main_activity", true);
        r9.putExtra("key_is_move_task_to_front", true);
        r3.startActivity(r9);
        return true;
    L26:
        return false;
    L27:
        r3 = r4.createPackageContext(r5, 3);     // Catch: PackageManager.NameNotFoundException -> L19
    L19:
        e = move-exception;
        e.printStackTrace();
        r3 = null;
        goto L21
    }
}
