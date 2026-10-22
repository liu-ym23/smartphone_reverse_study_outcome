package com.bytedance.badger.z;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.badger.data.BadgerResult;
import com.bytedance.badger.data.DataString;
import com.bytedance.badger.module.BadgerModuleBase;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class n0 extends u0 {
    public n0() {
    }

    @Override // com.bytedance.badger.module.BadgerModuleBase
    public final BadgerResult a(Context r14, BadgerModuleBase.BadgerRequestData r15) {
        String r3 = "";
        boolean r4 = false;
        String r6 = Build.BRAND;     // Catch: Throwable -> L42
        if (r6 != null) goto L6;
        r6 = "";
    L6:
        String r7 = Build.MANUFACTURER;     // Catch: Throwable -> L42
        if (r7 != null) goto L9;
        r7 = "";
    L9:
        String r8 = Build.PRODUCT;     // Catch: Throwable -> L42
        if (r8 != null) goto L12;
        r8 = "";
    L12:
        String r9 = Build.DISPLAY;     // Catch: Throwable -> L42
        if (r9 != null) goto L15;
        r9 = "";
    L15:
        String r10 = Build.FINGERPRINT;     // Catch: Throwable -> L42
        if (r10 != null) goto L18;
        r10 = "";
    L18:
        String r12 = r6 + "|" + r7 + "|" + r8 + "|" + r9 + "|" + r10;     // Catch: Throwable -> L42
        Locale r13 = Locale.ENGLISH;     // Catch: Throwable -> L42
        String r16 = r12.toLowerCase(r13);     // Catch: Throwable -> L42
        if (r16.contains("vivo") == false) goto L21;
    L41:
        boolean r0 = true;
    L44:
        if (r0 == false) goto L46;
        com.bytedance.badger.e.f("vivo#", "start execute vivo id...");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L50;
        com.bytedance.badger.utils.f r1 = com.bytedance.badger.utils.f.d;
        Long r17 = Long.valueOf(r15.getToken());
        b0 r2 = new b0(this);
        r1.getClass();
        com.bytedance.badger.utils.b0 r18 = com.bytedance.badger.utils.f.b(r14, r17, r2);
        String r19 = r18.a;
        if (r19 != null) goto L56;
        r19 = "";
    L56:
        if (r19.length() <= 0) goto L58;
        r4 = true;
    L58:
        if (r4 == true) goto L60;
        Integer r5 = r18.b;
        if (r5 == null) goto L64;
        int r20 = r5.intValue();
    L65:
        String r110 = r18.c;
        if (r110 == null) goto L69;
        r3 = r110;
    L69:
        return new BadgerResult.Failure(r20, r3);
    L64:
        r20 = -1003;
        goto L65
    L60:
        return new BadgerResult.Success(new DataString(r19));
    L50:
        return new BadgerResult.Failure(BadgerResult.ERROR, "cannot be called on the main thread.");
    L46:
        return new BadgerResult.Failure(-999, "not support");
    L21:
        if (r16.contains("iqoo") == true) goto L41;
        if (r16.contains("bbk") == true) goto L41;
        String r22 = (com.bytedance.badger.utils.y.b("ro.vivo.os.build.display.id") + "|" + com.bytedance.badger.utils.y.b("ro.vivo.product.version") + "|" + com.bytedance.badger.utils.y.b("ro.vivo.os.name") + "|" + com.bytedance.badger.utils.y.b("ro.vivo.os.version")).toLowerCase(r13);     // Catch: Throwable -> L42
        if (TextUtils.isEmpty(r22) == true) goto L38;
        if (r22.contains("vivo") == true) goto L41;
        if (r22.contains("iqoo") == true) goto L41;
        if (r22.contains("funtouch") == true) goto L41;
        if (r22.contains("originos") == true) goto L41;
    L38:
        if (r16.contains("funtouch") == true) goto L41;
        if (r16.contains("originos") == true) goto L41;
    L43:
        r0 = false;
        goto L44
    }
}
