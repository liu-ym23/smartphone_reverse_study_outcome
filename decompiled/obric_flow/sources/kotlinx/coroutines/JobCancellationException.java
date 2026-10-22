package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00000\u0003B!\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0011\u0010\u000e\u001a\u0004\u0018\u00010\u0000H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003H\u0096\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\t\u001a\u00020\b8\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0019¨\u0006\u001a"}, d2 = {"Lkotlinx/coroutines/JobCancellationException;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "", "", "message", "", "cause", "Lkotlinx/coroutines/Job;", "job", "<init>", "(Ljava/lang/String;Ljava/lang/Throwable;Lkotlinx/coroutines/Job;)V", "fillInStackTrace", "()Ljava/lang/Throwable;", "createCopy", "()Lkotlinx/coroutines/JobCancellationException;", "toString", "()Ljava/lang/String;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Lkotlinx/coroutines/Job;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class JobCancellationException extends CancellationException {

    @JvmField
    public final transient Job job;

    public JobCancellationException(String r5, Throwable r10, Job r11) {
        super(r5);
        this.job = r11;
        if (r10 == null) goto L6;
        initCause(r10);
        return;
    }

    /* JADX INFO: renamed from: createCopy, reason: collision with other method in class */
    public JobCancellationException m1628createCopy() {
        return null;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L4;
    L13:
        return true;
    L4:
        if ((r5 instanceof JobCancellationException) == false) goto L12;
        JobCancellationException r10 = (JobCancellationException) r5;
        if (Intrinsics.areEqual(r10.getMessage(), getMessage()) == false) goto L12;
        if (Intrinsics.areEqual(r10.job, this.job) == false) goto L12;
        if (Intrinsics.areEqual(r10.getCause(), getCause()) == true) goto L13;
    L12:
        return false;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public int hashCode() {
        String r5 = getMessage();
        Intrinsics.checkNotNull(r5);
        int r10 = r5.hashCode() * 31;
        int r11 = (this.job.hashCode() + r10) * 31;
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

    public /* bridge */ /* synthetic */ Throwable createCopy() {
        return m1628createCopy();
    }
}
