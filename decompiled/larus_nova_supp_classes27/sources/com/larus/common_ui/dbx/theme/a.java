package com.larus.common_ui.dbx.theme;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import androidx.core.content.ContextCompat;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.n0;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a {
    public static volatile Context a;

    /* JADX INFO: renamed from: com.larus.common_ui.dbx.theme.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0009a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[DbxTheme$Variant.values().length];
            r0[DbxTheme$Variant.LIGHT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[DbxTheme$Variant.DARK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final Context c(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        DbxTheme r2 = DbxTheme.a;
        ContextThemeWrapper r1 = new ContextThemeWrapper(r3, 2131952453);
        Resources.Theme r4 = r1.getTheme();
        Intrinsics.checkNotNullParameter(r4, "<this>");
        r4.applyStyle(2131952454, true);
        a(r4, Boolean.TRUE);
        return r1;
    }

    public static final void a(Resources.Theme r2, Boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        DbxTheme r0 = DbxTheme.a;
        boolean r1 = false;
        if (DbxTheme.b != null) goto L21;
    L6:
        if (r1 == true) goto L8;
        return;
    L8:
        if (r3 != null) goto L11;
        DbxTheme r4 = DbxTheme.a;
        int r5 = 2131952456;
    L16:
        r2.applyStyle(r5, true);
        return;
    L11:
        if (Intrinsics.areEqual(r3, Boolean.FALSE) == false) goto L14;
        DbxTheme r6 = DbxTheme.a;
        r5 = 2131952458;
        goto L16
    L14:
        if (Intrinsics.areEqual(r3, Boolean.TRUE) == false) goto L19;
        DbxTheme r7 = DbxTheme.a;
        r5 = 2131952457;
        goto L16
    L19:
        throw new NoWhenBranchMatchedException();
    L21:
        r1 = n0.a.b();     // Catch: Exception -> L20
        goto L6
    }

    public static final int b(Context r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Integer r5 = d(r3, r4);
        if (r5 != null) goto L5;
        Context r6 = a;
        if (r6 != null) goto L17;
        DbxTheme r7 = DbxTheme.a;
        monitor-enter(r7);
        Context r0 = a;     // Catch: Throwable -> L22
        if (r0 != null) goto L15;
        Application r1 = AppHost.a.getApplication();     // Catch: Throwable -> L22
        Intrinsics.checkNotNullParameter(r1, "<this>");     // Catch: Throwable -> L22
        ContextThemeWrapper r2 = new ContextThemeWrapper(r1, 2131952453);     // Catch: Throwable -> L22
        a(r2.getTheme(), null);     // Catch: Throwable -> L22
        a = r2;     // Catch: Throwable -> L22
        r0 = r2;
    L15:
        monitor-exit(r7);
        r6 = r0;
    L22:
        th = move-exception;
        throw th;
    L17:
        Integer r8 = d(r6, r4);
        if (r8 != null) goto L27;
        return 0;
    L27:
        return r8.intValue();
    L5:
        return r5.intValue();
    }

    public static final Integer d(Context r5, int r6) {
        TypedValue r0 = new TypedValue();
        Resources.Theme r2 = r5.getTheme();     // Catch: Exception -> L25
        boolean r3 = false;
        if (r2 != null) goto L6;
    L8:
        if (r3 == true) goto L10;
        return null;
    L10:
        int r7 = r0.resourceId;     // Catch: Exception -> L25
        if (r7 == 0) goto L14;
        Integer r8 = Integer.valueOf(ContextCompat.getColor(r5, r7));     // Catch: Exception -> L25
    L24:
        return r8;
    L14:
        int r9 = r0.type;     // Catch: Exception -> L25
        if (r9 != 28) goto L17;
    L22:
        r8 = Integer.valueOf(r0.data);     // Catch: Exception -> L25
        goto L24
    L17:
        if (r9 == 29) goto L22;
        if (r9 == 30) goto L22;
        if (r9 == 31) goto L22;
        return null;
    L6:
        if (r2.resolveAttribute(r6, r0, true) != true) goto L8;
        r3 = true;
        goto L8
    L28:
        return null;
    }
}
