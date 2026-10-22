package com.obric.assistant.card.utils;

import android.content.Context;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class j {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String f(String r13) {
        Intrinsics.checkNotNullParameter(r13, "<this>");
        String r14 = StringsKt.replace$default(r13, '-', '/', false, 4, null);
        List r3 = StringsKt.split$default(r14, new char[]{'/'}, false, 0, 6, null);
        if (r3.size() == 3) goto L5;
        return r14;
    L5:
        if (Intrinsics.areEqual(ListProtector.get(r3, 0), String.valueOf(Calendar.getInstance().get(1))) == true) goto L7;
        return r14;
    L7:
        return ((String) ListProtector.get(r3, 1)) + '/' + ((String) ListProtector.get(r3, 2));
    }

    public static String c(Context r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Calendar r4 = Calendar.getInstance();
        r4.setTimeInMillis(r3);
        Calendar r0 = Calendar.getInstance();
        Intrinsics.checkNotNull(r4);
        Intrinsics.checkNotNull(r0);
        if (d(r4, r0) == false) goto L6;
        String r5 = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date(r3));
        Intrinsics.checkNotNull(r5);
        return r5;
    L6:
        if (e(r4, r0) == false) goto L8;
        String r6 = new SimpleDateFormat("MM/dd HH:mm", Locale.getDefault()).format(new Date(r3));
        Intrinsics.checkNotNull(r6);
        return r6;
    L8:
        String r7 = new SimpleDateFormat("yyyy/MM/dd HH:mm", Locale.getDefault()).format(new Date(r3));
        Intrinsics.checkNotNull(r7);
        return r7;
    }

    public static boolean d(Calendar r3, Calendar r4) {
        if (r3.get(1) == r4.get(1)) goto L5;
    L7:
        return false;
    L5:
        if (r3.get(6) != r4.get(6)) goto L7;
        return true;
    }

    public static boolean e(Calendar r1, Calendar r2) {
        if (r1.get(1) == r2.get(1)) goto L7;
        return false;
    L7:
        return true;
    }

    public static String b(Context r8, long r9, long r11) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Calendar r10 = Calendar.getInstance();
        r10.setTimeInMillis(r9);
        Calendar r0 = Calendar.getInstance();
        r0.setTimeInMillis(r11);
        SimpleDateFormat r1 = new SimpleDateFormat("HH:mm", Locale.getDefault());
        Calendar r2 = Calendar.getInstance();
        Intrinsics.checkNotNull(r10);
        Intrinsics.checkNotNull(r0);
        if (d(r10, r0) == false) goto L12;
        String r12 = r1.format(new Date(r9)) + " - " + r1.format(new Date(r11));
        Intrinsics.checkNotNull(r2);
        if (d(r10, r2) == false) goto L8;
        return r12;
    L8:
        if (e(r10, r2) == false) goto L11;
        return new SimpleDateFormat("MM/dd", Locale.getDefault()).format(new Date(r9)) + ' ' + r12;
    L11:
        return new SimpleDateFormat("yyyy/MM/dd", Locale.getDefault()).format(new Date(r9)) + ' ' + r12;
    L12:
        StringBuilder r3 = new StringBuilder();
        Intrinsics.checkNotNull(r2);
        if (e(r10, r2) == false) goto L15;
        String r13 = new SimpleDateFormat("MM/dd", Locale.getDefault()).format(new Date(r9));
    L16:
        r3.append(r13);
        r3.append(' ');
        r3.append(r1.format(new Date(r9)));
        String r14 = r3.toString();
        StringBuilder r15 = new StringBuilder();
        if (e(r0, r2) == false) goto L19;
        String r16 = new SimpleDateFormat("MM/dd", Locale.getDefault()).format(new Date(r11));
    L20:
        r15.append(r16);
        r15.append(' ');
        r15.append(r1.format(new Date(r11)));
        return i.a(r14, r15.toString(), '-');
    L19:
        r16 = new SimpleDateFormat("yyyy/MM/dd", Locale.getDefault()).format(new Date(r11));
        goto L20
    L15:
        r13 = new SimpleDateFormat("yyyy/MM/dd", Locale.getDefault()).format(new Date(r9));
        goto L16
    }

    public static String a(String r4, String r5, String r6, String r7) {
        Intrinsics.checkNotNullParameter(r5, "startTime");
        Intrinsics.checkNotNullParameter(r7, "endTime");
        boolean r0 = true;
        if (r4 != null) goto L5;
    L8:
        boolean r2 = true;
    L10:
        if (r2 == true) goto L13;
        r5 = i.a(f(r4), r5, ' ');
    L13:
        if (r6 != null) goto L15;
    L18:
        if (r0 == true) goto L24;
        if (Intrinsics.areEqual(r6, r4) == true) goto L24;
        r7 = i.a(f(r6), r7, ' ');
    L24:
        return i.a(r5, r7, '-');
    L15:
        if (r6.length() == 0) goto L18;
        r0 = false;
        goto L18
    L5:
        if (r4.length() == 0) goto L8;
        r2 = false;
        goto L10
    }
}
