package com.bytedance.applog.priority.original;

import com.bytedance.crypto.utils.CryptoConst;
import java.security.SecureRandom;
import javax.crypto.KeyGenerator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0012\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0000\u001a\u0016\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005H\u0000\u001a\u001c\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00012\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0000¨\u0006\n"}, d2 = {"byte2String", "", "b", "", "genRandomKeyAndIv", "Lkotlin/Pair;", "isValidKeyIv", "", "keyStr", "ivStr", "priority_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class h {
    public static final String a(byte[] r5) {
        StringBuilder r0 = new StringBuilder();
        int r1 = 0;
    L3:
        if (r5 == null) goto L10;
        if (r1 >= r5.length) goto L10;
        String r2 = Integer.toHexString(r5[r1] & 255);
        if (r2.length() != 1) goto L9;
        r0.append('0');
    L9:
        r0.append(r2);
        r1 = r1 + 1;
    L10:
        String r6 = r0.toString();
        Intrinsics.checkNotNullExpressionValue(r6, "hs.toString()");
        return r6;
    }

    public static final Pair<String, String> a() {
        KeyGenerator r0 = KeyGenerator.getInstance(CryptoConst.ALGORITHM_AES);     // Catch: Throwable -> L8
        SecureRandom r1 = new SecureRandom();     // Catch: Throwable -> L8
        r0.init(128, r1);     // Catch: Throwable -> L8
        String r2 = a(r0.generateKey().getEncoded());     // Catch: Throwable -> L8
        byte[] r3 = new byte[8];     // Catch: Throwable -> L8
        r1.nextBytes(r3);     // Catch: Throwable -> L8
        String r4 = a(r3);     // Catch: Throwable -> L8
        if (a(r2, r4) == false) goto L6;
        return TuplesKt.to(r2, r4);
    L6:
        return null;
    L11:
        return null;
    }

    public static final boolean a(String r1, String r2) {
        if (r1 == null) goto L9;
        if (r2 == null) goto L9;
        if (r1.length() != 32) goto L9;
        if (r2.length() != 16) goto L9;
        return true;
    L9:
        return false;
    }
}
