package com.larus.profile.impl.info;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a {
    public static final /* synthetic */ int c = 0;
    public final boolean a;
    public final boolean b;

    /* JADX INFO: renamed from: com.larus.profile.impl.info.a$a, reason: collision with other inner class name */
    public static final class C0014a {
        public static a a(Bundle r2, FragmentActivity r3) {
            cy9.a.a.getClass();
            if (cy9.a.e(r2) == false) goto L5;
        L8:
            boolean r4 = true;
        L10:
            return new a(r4, cy9.a.h(r2));
        L5:
            if (cy9.a.d(r3) == true) goto L8;
            r4 = false;
            goto L10
        }
    }

    static {
    }

    public a(boolean r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }
}
