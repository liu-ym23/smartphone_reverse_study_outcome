package com.larus.common_ui.floatwindow.view;

import android.app.Activity;
import androidx.appcompat.app.AppCompatActivity;
import com.larus.common.apphost.AppHost;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Activity a(Activity r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        boolean r2 = false;
        if ((r5 instanceof e19.a) == false) goto L8;
    L13:
        boolean r1 = true;
    L14:
        if (r1 == true) goto L16;
        return r5;
    L16:
        Activity r3 = AppHost.a.a().a(r5, new d());
        if (r3 != null) goto L27;
        if (r5.isFinishing() == false) goto L21;
    L22:
        r2 = true;
    L23:
        if (r2 == true) goto L28;
        return r5;
    L28:
        return null;
    L21:
        if (r5.isDestroyed() == false) goto L23;
    L27:
        return r3;
    L8:
        if (r5.isFinishing() == true) goto L13;
        if (r5.isDestroyed() == true) goto L13;
        r1 = false;
        goto L14
    }

    public static Activity b(AppCompatActivity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Activity r0 = AppHost.a.a().a(r2, new d());
        if (r0 != null) goto L15;
        if (r2.isFinishing() == false) goto L7;
    L10:
        boolean r1 = true;
    L11:
        if (r1 == false) goto L17;
        return null;
    L17:
        return r2;
    L7:
        if (r2.isDestroyed() == true) goto L10;
        r1 = false;
        goto L11
    L15:
        return r0;
    }
}
