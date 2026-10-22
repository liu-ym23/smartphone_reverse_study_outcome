package com.larus.share.impl.util;

import android.content.Context;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import tx9.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class AigcImageMetadataOutputHelper {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public final String a;
        public final boolean b;
        public final boolean c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            String r0 = this.a;
            if (r0 != null) goto L5;
            int r1 = 0;
        L6:
            int r2 = r1 * 31;
            int r3 = 1231;
            if (this.b == false) goto L9;
            int r4 = 1231;
        L10:
            int r5 = (r2 + r4) * 31;
            if (this.c == true) goto L15;
            r3 = 1237;
        L15:
            return r5 + r3;
        L9:
            r4 = 1237;
            goto L10
        L5:
            r1 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "MetadataWriteResult(finalImagePath=" + this.a + ", success=" + this.b + ", fallbackUsed=" + this.c + ')';
        }

        public a(String r1, boolean r2, boolean r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    static {
    }

    public AigcImageMetadataOutputHelper() {
    }

    public static final a a(String r8, String r9, long r10, com.larus.bmhome.share.panel.f r12) {
        boolean r0 = z2.a.aigcMetadataConfig().getAllowShareWhenMetadataFailed();
        FLogger.a.e("AigcImageMetadataOutput", "write metadata failed: " + r9 + ", fallbackUsed=" + r0);
        h.b(false, r9, r10, r0, r12.b, r12.c);
        if (r0 == true) goto L7;
        r8 = null;
    L7:
        return new a(r8, false, r0);
    }

    public static Object b(Context r3, String r4, com.larus.bmhome.share.panel.f r5, Continuation r6) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AigcImageMetadataOutputHelper$writeMetadataIfNeeded$2(r5, r4, r3, null), r6);
    }
}
