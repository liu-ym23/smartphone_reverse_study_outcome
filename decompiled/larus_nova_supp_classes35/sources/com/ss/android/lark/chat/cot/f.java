package com.ss.android.lark.chat.cot;

import com.ss.android.lark.chat.entity.message.CotContent;
import com.ss.android.lark.log.Log;
import kotlin.collections.CollectionsKt;
import kotlin.collections.GroupingKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f {
    static {
    }

    @JvmStatic
    public static final String d(CotContent r10) {
        StringBuilder r0 = new StringBuilder("cotId=");
        r0.append(r10.getCotId());
        r0.append(", status=");
        r0.append(r10.getStatus());
        r0.append(", events=");
        r0.append(r10.getEvents().size());
        r0.append(", incomplete=");
        r0.append(r10.getCotEventsIncomplete());
        r0.append(", types=");
        if (r10.getEvents().isEmpty() == false) goto L5;
        String r11 = "empty";
    L6:
        r0.append(r11);
        return r0.toString();
    L5:
        r11 = CollectionsKt.joinToString$default(CollectionsKt.sortedWith(GroupingKt.eachCount(new d(r10.getEvents())).entrySet(), new e()), ",", null, null, 8, "...", CotLog$eventTypeSummary$3.INSTANCE, 6, null);
        goto L6
    }

    @JvmStatic
    public static final void a(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "stage");
        Intrinsics.checkNotNullParameter(r3, "message");
        Log.d("CotChain", "[" + r2 + "] " + r3);
    }

    @JvmStatic
    public static final void c(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "stage");
        Intrinsics.checkNotNullParameter(r3, "message");
        Log.i("CotChain", "[" + r2 + "] " + r3);
    }

    @JvmStatic
    public static final void e(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "stage");
        Intrinsics.checkNotNullParameter(r3, "message");
        Log.w("CotChain", "[" + r2 + "] " + r3);
    }

    @JvmStatic
    public static final void b(String r2, String r3, Throwable r4) {
        Intrinsics.checkNotNullParameter(r2, "stage");
        Intrinsics.checkNotNullParameter(r3, "message");
        Log.e("CotChain", "[" + r2 + "] " + r3, r4);
    }
}
