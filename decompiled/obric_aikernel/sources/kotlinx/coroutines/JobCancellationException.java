package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nExceptions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Exceptions.kt\nkotlinx/coroutines/JobCancellationException\n+ 2 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n*L\n1#1,76:1\n26#2:77\n*S KotlinDebug\n*F\n+ 1 Exceptions.kt\nkotlinx/coroutines/JobCancellationException\n*L\n44#1:77\n*E\n"})
public final class JobCancellationException extends CancellationException implements g0<JobCancellationException> {

    @JvmField
    public final transient v1 job;

    public JobCancellationException(String r10, Throwable r11, v1 r12) {
        super(r10);
        this.job = r12;
        if (r11 == null) goto L6;
        initCause(r11);
        return;
    }

    @Override // kotlinx.coroutines.g0
    public /* bridge */ /* synthetic */ Throwable createCopy() {
        return createCopy();
    }

    @Override // kotlinx.coroutines.g0
    public JobCancellationException createCopy() {
        if (n0.c() == false) goto L6;
        String r10 = getMessage();
        Intrinsics.checkNotNull(r10);
        return new JobCancellationException(r10, this, this.job);
    L6:
        return null;
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L4;
    L13:
        return true;
    L4:
        if ((r10 instanceof JobCancellationException) == false) goto L12;
        JobCancellationException r11 = (JobCancellationException) r10;
        if (Intrinsics.areEqual(r11.getMessage(), getMessage()) == false) goto L12;
        if (Intrinsics.areEqual(r11.job, this.job) == false) goto L12;
        if (Intrinsics.areEqual(r11.getCause(), getCause()) == true) goto L13;
    L12:
        return false;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        if (n0.c() == true) goto L5;
        setStackTrace(new StackTraceElement[0]);
        return this;
    L5:
        return super.fillInStackTrace();
    }

    public int hashCode() {
        String r10 = getMessage();
        Intrinsics.checkNotNull(r10);
        int r11 = ((r10.hashCode() * 31) + this.job.hashCode()) * 31;
        Throwable r12 = getCause();
        if (r12 == null) goto L5;
        int r13 = r12.hashCode();
    L7:
        return r11 + r13;
    L5:
        r13 = 0;
        goto L7
    }

    @Override // java.lang.Throwable
    public String toString() {
        return super.toString() + "; job=" + this.job;
    }
}
