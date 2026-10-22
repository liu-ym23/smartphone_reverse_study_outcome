package hda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class f1 {

    public static final class a<T> implements Comparator {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r3, T r4) {
            e1 r5 = (e1) r4;
            JSONObject r0 = f1.c(r5);
            if (r0 == null) goto L5;
            int r6 = r0.optInt("snapshotVersion", r5.q + 1);
        L6:
            Integer r7 = Integer.valueOf(r6);
            e1 r8 = (e1) r3;
            JSONObject r1 = f1.c(r8);
            if (r1 == null) goto L9;
            int r9 = r1.optInt("snapshotVersion", r8.q + 1);
        L11:
            return ComparisonsKt.compareValues(r7, Integer.valueOf(r9));
        L9:
            r9 = r8.q + 1;
            goto L11
        L5:
            r6 = r5.q + 1;
            goto L6
        }
    }

    public static final class b<T> implements Comparator {
        public final /* synthetic */ Comparator a;

        public b(a r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r6, T r7) {
            int r0 = this.a.compare(r6, r7);
            if (r0 != 0) goto L14;
            JSONObject r8 = f1.c((e1) r7);
            long r1 = 0;
            if (r8 == null) goto L8;
            long r3 = r8.optLong("snapshotTime", 0);
        L9:
            Long r9 = Long.valueOf(r3);
            JSONObject r10 = f1.c((e1) r6);
            if (r10 == null) goto L13;
            r1 = r10.optLong("snapshotTime", 0);
        L13:
            return ComparisonsKt.compareValues(r9, Long.valueOf(r1));
        L8:
            r3 = 0;
            goto L9
        L14:
            return r0;
        }
    }

    public static final class c<T> implements Comparator {
        public final /* synthetic */ Comparator a;

        public c(b r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r3, T r4) {
            int r0 = this.a.compare(r3, r4);
            if (r0 != 0) goto L15;
            long r5 = StringsKt.toLongOrNull(((e1) r4).a);
            if (r5 != null) goto L9;
            r5 = 0L;
        L9:
            long r6 = StringsKt.toLongOrNull(((e1) r3).a);
            if (r6 != null) goto L14;
            r6 = 0L;
        L14:
            return ComparisonsKt.compareValues(r5, r6);
        L15:
            return r0;
        }
    }

    public static final JSONObject c(e1 r1) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r2 = Result.constructor-impl(new JSONObject(r1.s));     // Catch: Throwable -> L4
    L7:
        if (Result.isFailure-impl(r2) == false) goto L10;
        r2 = null;
    L10:
        return (JSONObject) r2;
    L4:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public static final List<e1> d(List<e1> r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (((ArrayList) r2).size() > 1) goto L6;
        return r2;
    L6:
        return CollectionsKt.sortedWith(r2, new c(new b(new a())));
    }

    public static final String a(JSONObject r3, String... r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "keys");
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        String r2 = p0.b(r3, r4[r1]);
        if (r2 != null) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return r2;
    L8:
        return null;
    }

    public static final void b(JSONArray r3, Function1<? super JSONObject, Unit> r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "block");
        int r0 = r3.length();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        JSONObject r2 = r3.optJSONObject(r1);
        if (r2 == null) goto L7;
        r4.invoke(r2);
    L7:
        r1 = r1 + 1;
        goto L3
    }
}
