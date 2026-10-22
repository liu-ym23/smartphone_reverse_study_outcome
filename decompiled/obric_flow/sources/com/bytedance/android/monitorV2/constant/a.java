package com.bytedance.android.monitorV2.constant;

import android.app.Application;
import android.content.SharedPreferences;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import com.bytedance.android.monitorV2.h;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f3521a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static SharedPreferences f3522b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Application f3523c = null;

    static {
        f3521a = LazyKt.lazy(MonitorGlobalSp$sp$2.f3520a);
        f3523c = h.e().f3581a;
    }

    public static final long a(String r5) {
        Intrinsics.checkNotNullParameter(r5, STGroup.DICT_KEY);
        if (f3523c == null) goto L9;
        SharedPreferences r10 = (SharedPreferences) f3521a.getValue();
        if (r10 == null) goto L9;
        return r10.getLong(r5, 0);
    L9:
        return 0;
    }

    public static final String b(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, STGroup.DICT_KEY);
        Intrinsics.checkNotNullParameter(r10, "defValue");
        if (f3523c == null) goto L11;
        SharedPreferences r11 = (SharedPreferences) f3521a.getValue();
        if (r11 == null) goto L11;
        String r12 = r11.getString(r5, r10);
        if (r12 == null) goto L11;
        return r12;
    L11:
        return r10;
    }

    public static final void c(String r5, long r10) {
        Intrinsics.checkNotNullParameter(r5, STGroup.DICT_KEY);
        if (f3523c == null) goto L16;
        SharedPreferences r11 = (SharedPreferences) f3521a.getValue();
        if (r11 == null) goto L13;
        SharedPreferences.Editor r12 = r11.edit();
        if (r12 == null) goto L14;
        SharedPreferences.Editor r13 = r12.putLong(r5, r10);
        if (r13 == null) goto L15;
        r13.apply();
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    public static final void d(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, STGroup.DICT_KEY);
        Intrinsics.checkNotNullParameter(r10, "value");
        if (f3523c == null) goto L16;
        SharedPreferences r11 = (SharedPreferences) f3521a.getValue();
        if (r11 == null) goto L13;
        SharedPreferences.Editor r12 = r11.edit();
        if (r12 == null) goto L14;
        SharedPreferences.Editor r13 = r12.putString(r5, r10);
        if (r13 == null) goto L15;
        r13.apply();
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }
}
