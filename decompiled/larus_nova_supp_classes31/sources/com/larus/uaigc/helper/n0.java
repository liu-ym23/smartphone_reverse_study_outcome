package com.larus.uaigc.helper;

import com.bytedance.keva.Keva;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class n0 {
    public static final n0 a = null;
    public static final Lazy b = null;
    public static final Keva c = null;
    public static final Lazy d = null;

    public static final class a {
        public final String a;
        public final long b;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof a) == true) goto L8;
            return false;
        L8:
            a r9 = (a) r8;
            if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r9.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            long r1 = this.b;
            return r0 + ((int) (r1 ^ (r1 >>> 32)));
        }

        public final String toString() {
            return "DuplicateEntry(fileHash=" + this.a + ", timestamp=" + this.b + ')';
        }

        public a(String r2, long r3) {
            Intrinsics.checkNotNullParameter(r2, "fileHash");
            this.a = r2;
            this.b = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/larus/uaigc/helper/UploadDuplicateStatStore$getEntriesInternal$1$1", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/larus/uaigc/helper/UploadDuplicateStatStore$DuplicateEntry;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final class b extends TypeToken<List<? extends a>> {
        public b() {
        }
    }

    public n0() {
    }

    static {
        a = new n0();
        b = LazyKt.lazy(new k0());
        c = Keva.getRepo("upload_duplicate_stat_store", 0);
        d = LazyKt.lazy(new l0());
    }

    public static List a() {
        String r0 = c.getString("key_duplicate_entries", null);
        if (r0 == null) goto L5;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L8
        Object r2 = Result.constructor-impl((List) ((Gson) d.getValue()).fromJson(r0, new b().getType()));     // Catch: Throwable -> L8
    L11:
        if (Result.exceptionOrNull-impl(r2) == null) goto L15;
        r2 = CollectionsKt.emptyList();
    L15:
        return (List) r2;
    L8:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    L5:
        return CollectionsKt.emptyList();
    }
}
