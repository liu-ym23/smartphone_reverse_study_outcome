package com.ss.android.lark.keyboard.base;

import android.os.Handler;
import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ChatAttachmentUploadProgressStore {
    public static final ChatAttachmentUploadProgressStore a = null;
    public static final Handler b = null;
    public static final ChatAttachmentUploadProgressStore$progresses$1 c = null;
    public static final Map<String, Set<Function1<a, Unit>>> d = null;

    public static final class a {
        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof a) == true) goto L9;
            return false;
        L9:
            ((a) r3).getClass();
            return true;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return "UploadProgress(progress=0, state=null)";
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ List<Function1<a, Unit>> a;
        public final /* synthetic */ a b;

        public b(List<? extends Function1<? super a, Unit>> r1, a r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            List<Function1<a, Unit>> r0 = this.a;     // Catch: Throwable -> L7
            a r1 = this.b;     // Catch: Throwable -> L7
            Iterator<T> r2 = r0.iterator();     // Catch: Throwable -> L7
        L4:
            if (r2.hasNext() == false) goto L16;
            ((Function1) r2.next()).invoke(r1);     // Catch: Throwable -> L7
            goto L4
        L16:
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }
    }

    public ChatAttachmentUploadProgressStore() {
    }

    static {
        a = new ChatAttachmentUploadProgressStore();
        b = new Handler(Looper.getMainLooper());
        c = new ChatAttachmentUploadProgressStore$progresses$1();
        d = new LinkedHashMap();
    }

    @JvmStatic
    public static final synchronized a a(String r2) {
        monitor-enter(ChatAttachmentUploadProgressStore.class);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (r2.length() != 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == false) goto L12;
        monitor-exit(ChatAttachmentUploadProgressStore.class);
        return null;
    L12:
        a r3 = (a) c.get(r2);     // Catch: Throwable -> L15
        monitor-exit(ChatAttachmentUploadProgressStore.class);
        return r3;
    L7:
        r1 = false;
        goto L8
    }

    @JvmStatic
    public static final Function0<Unit> c(final String r3, final Function1<? super a, Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "observer");
        if (r3.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        r4.invoke(null);
        return ChatAttachmentUploadProgressStore$observe$1.INSTANCE;
    L9:
        ChatAttachmentUploadProgressStore r1 = a;
        monitor-enter(r1);
        LinkedHashMap r2 = (LinkedHashMap) d;     // Catch: Throwable -> L18
        Object r5 = r2.get(r3);     // Catch: Throwable -> L18
        if (r5 != null) goto L14;
        r5 = new LinkedHashSet();     // Catch: Throwable -> L18
        r2.put(r3, r5);     // Catch: Throwable -> L18
    L14:
        ((Set) r5).add(r4);     // Catch: Throwable -> L18
        monitor-exit(r1);
        r4.invoke(a(r3));
        return new ChatAttachmentUploadProgressStore$observe$3(r3, r4);
    L18:
        th = move-exception;
        throw th;
    L5:
        r0 = false;
        goto L6
    }

    private final synchronized void update(String r2, a r3) {
        monitor-enter(this);
        if (r2 != null) goto L19;
    L10:
        boolean r0 = true;
    L11:
        if (r0 == false) goto L14;
        monitor-exit(this);
        return;
    L14:
        c.put(r2, r3);     // Catch: Throwable -> L8
        b(r2, r3);     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    L19:
        if (r2.length() == 0) goto L10;
        r0 = false;
        goto L11
    }

    public final void b(String r3, a r4) {
        monitor-enter(this);
        Set r5 = (Set) ((LinkedHashMap) d).get(r3);     // Catch: Throwable -> L15
        if (r5 == null) goto L6;
        List r6 = CollectionsKt.toList(r5);     // Catch: Throwable -> L15
    L7:
        if (r6 != null) goto L9;
        r6 = CollectionsKt.emptyList();     // Catch: Throwable -> L15
    L9:
        monitor-exit(this);
        if (r6.isEmpty() == false) goto L13;
        return;
    L13:
        b.post(new b(r6, r4));
        return;
    L6:
        r6 = null;
    L15:
        th = move-exception;
        throw th;
    }
}
