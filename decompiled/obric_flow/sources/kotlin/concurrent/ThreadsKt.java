package kotlin.concurrent;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aJ\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u001a3\u0010\u000e\u001a\u0002H\u000f\"\b\b\u0000\u0010\u000f*\u00020\u0010*\b\u0012\u0004\u0012\u0002H\u000f0\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u000f0\fH\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0013\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0014"}, d2 = {"thread", "Ljava/lang/Thread;", "start", "", "isDaemon", "contextClassLoader", "Ljava/lang/ClassLoader;", "name", "", "priority", "", "block", "Lkotlin/Function0;", "", "getOrSet", ExifInterface.GPS_DIRECTION_TRUE, "", "Ljava/lang/ThreadLocal;", "default", "(Ljava/lang/ThreadLocal;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
@JvmName(name = "ThreadsKt")
@SourceDebugExtension({"SMAP\nThread.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Thread.kt\nkotlin/concurrent/ThreadsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,61:1\n1#2:62\n*E\n"})
public final class ThreadsKt {
    @InlineOnly
    private static final <T> T getOrSet(ThreadLocal<T> r5, Function0<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "default");
        T r11 = r5.get();
        if (r11 != null) goto L6;
        T r12 = r10.invoke();
        r5.set(r12);
        return r12;
    L6:
        return r11;
    }

    public static final Thread thread(boolean r5, boolean r10, ClassLoader r11, String r12, int r13, final Function0<Unit> r14) {
        Intrinsics.checkNotNullParameter(r14, "block");
        Thread r15 = new ThreadsKt$thread$thread$1(r14);
        if (r10 == false) goto L5;
        r15.setDaemon(true);
    L5:
        if (r13 <= 0) goto L7;
        r15.setPriority(r13);
    L7:
        if (r12 == null) goto L9;
        r15.setName(r12);
    L9:
        if (r11 == null) goto L11;
        r15.setContextClassLoader(r11);
    L11:
        if (r5 == false) goto L13;
        r15.start();
    L13:
        return r15;
    }

    public static /* synthetic */ Thread thread$default(boolean r10, boolean r11, ClassLoader r12, String r13, int r14, Function0 r15, int r16, Object r17) {
        if ((r16 & 1) == 0) goto L5;
        r10 = true;
    L5:
        boolean r5 = r10;
        if ((r16 & 2) == 0) goto L8;
        r11 = false;
    L8:
        boolean r18 = r11;
        if ((r16 & 4) == 0) goto L11;
        ClassLoader r19 = null;
    L13:
        if ((r16 & 8) == 0) goto L15;
        String r20 = null;
    L17:
        if ((r16 & 16) == 0) goto L20;
        r14 = -1;
    L20:
        return thread(r5, r18, r19, r20, r14, r15);
    L15:
        r20 = r13;
        goto L17
    L11:
        r19 = r12;
        goto L13
    }
}
