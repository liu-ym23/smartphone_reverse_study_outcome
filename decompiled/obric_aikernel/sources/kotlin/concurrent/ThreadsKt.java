package kotlin.concurrent;

import com.bytedance.apm6.consumer.slardar.send.downgrade.DowngradeInfo;
import kotlin.Unit;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes2.dex */
@JvmName(name = "ThreadsKt")
@SourceDebugExtension({"SMAP\nThread.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Thread.kt\nkotlin/concurrent/ThreadsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,61:1\n1#2:62\n*E\n"})
public final class ThreadsKt {
    @InlineOnly
    private static final <T> T getOrSet(ThreadLocal<T> r10, Function0<? extends T> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, DowngradeInfo.SubInfo.FIELD_DEFAULT_RATE);
        T r12 = r10.get();
        if (r12 != null) goto L6;
        T r13 = r11.invoke();
        r10.set(r13);
        return r13;
    L6:
        return r12;
    }

    public static final Thread thread(boolean r10, boolean r11, ClassLoader r12, String r13, int r14, final Function0<Unit> r15) {
        Intrinsics.checkNotNullParameter(r15, "block");
        Thread r16 = new ThreadsKt$thread$thread$1(r15);
        if (r11 == false) goto L5;
        r16.setDaemon(true);
    L5:
        if (r14 <= 0) goto L7;
        r16.setPriority(r14);
    L7:
        if (r13 == null) goto L9;
        r16.setName(r13);
    L9:
        if (r12 == null) goto L11;
        r16.setContextClassLoader(r12);
    L11:
        if (r10 == false) goto L13;
        r16.start();
    L13:
        return r16;
    }

    public static /* synthetic */ Thread thread$default(boolean r10, boolean r11, ClassLoader r12, String r13, int r14, Function0 r15, int r16, Object r17) {
        if ((r16 & 1) == 0) goto L5;
        r10 = true;
    L5:
        boolean r18 = r10;
        if ((r16 & 2) == 0) goto L8;
        r11 = false;
    L8:
        boolean r19 = r11;
        if ((r16 & 4) == 0) goto L11;
        ClassLoader r20 = null;
    L13:
        if ((r16 & 8) == 0) goto L15;
        String r21 = null;
    L17:
        if ((r16 & 16) == 0) goto L20;
        r14 = -1;
    L20:
        return thread(r18, r19, r20, r21, r14, r15);
    L15:
        r21 = r13;
        goto L17
    L11:
        r20 = r12;
        goto L13
    }
}
