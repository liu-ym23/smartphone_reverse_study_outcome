package com.obric.aee.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J!\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\fJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/aee/utils/ThreadDumpUtils;", "", "()V", "AEE_THREAD_PREFIX", "", "PYTHON_MAIN_THREAD_NAME", "formatThreadTrace", "thread", "Ljava/lang/Thread;", "stackTrace", "", "Ljava/lang/StackTraceElement;", "(Ljava/lang/Thread;[Ljava/lang/StackTraceElement;)Ljava/lang/String;", "isRelevantThread", "", "Aee_cryptLiteRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f5900a = null;

    static {
        f5900a = new d();
    }

    private d() {
    }

    public final String a(Thread r5, StackTraceElement[] r6) {
        Intrinsics.checkNotNullParameter(r5, "thread");
        Intrinsics.checkNotNullParameter(r6, "stackTrace");
        StringBuilder r4 = new StringBuilder();
        r4.append("Thread[");
        r4.append(r5.getName());
        r4.append("], id=");
        r4.append(r5.getId());
        r4.append(", state=");
        r4.append(r5.getState());
        r4.append(", daemon=");
        r4.append(r5.isDaemon());
        r4.append(", priority=");
        r4.append(r5.getPriority());
        int r0 = 0;
        if (r6.length != 0) goto L5;
        boolean r7 = true;
    L7:
        if (r7 == false) goto L9;
        r4.append('\n');
        r4.append("    <no stack trace available>");
    L12:
        String r8 = r4.toString();
        Intrinsics.checkNotNullExpressionValue(r8, "StringBuilder().apply(builderAction).toString()");
        return r8;
    L9:
        int r9 = r6.length;
    L10:
        if (r0 >= r9) goto L12;
        StackTraceElement r2 = r6[r0];
        r4.append('\n');
        r4.append("    at ");
        r4.append(r2);
        r0 = r0 + 1;
        goto L10
    L5:
        r7 = false;
        goto L7
    }

    public final boolean a(Thread r4) {
        Intrinsics.checkNotNullParameter(r4, "thread");
        if (Intrinsics.areEqual(r4.getName(), "PapLooper") == true) goto L6;
        String r3 = r4.getName();
        Intrinsics.checkNotNullExpressionValue(r3, "thread.name");
        if (StringsKt.startsWith$default(r3, "Aee-", false, 2, null) == true) goto L6;
        return false;
    L6:
        return true;
    }
}
