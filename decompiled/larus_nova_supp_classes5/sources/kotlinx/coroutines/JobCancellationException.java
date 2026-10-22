package kotlinx.coroutines;

import com.obric.assistant.interaction.api.service.IInteractionStateService;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00000\u0003B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\n\u0010\u000b\u001a\u0004\u0018\u00010\u0000H\u0016J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0007H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0005H\u0016R\u0010\u0010\b\u001a\u00020\t8\u0000X\u0081\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lkotlinx/coroutines/JobCancellationException;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "Lkotlinx/coroutines/CopyableThrowable;", "message", "", "cause", "", "job", "Lkotlinx/coroutines/Job;", "(Ljava/lang/String;Ljava/lang/Throwable;Lkotlinx/coroutines/Job;)V", "createCopy", "equals", "", IInteractionStateService.WAKE_UP_SOURCE_OTHER, "", "fillInStackTrace", "hashCode", "", "toString", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class JobCancellationException extends CancellationException implements x<JobCancellationException> {
    public final transient Job job;

    /* JADX INFO: renamed from: createCopy, reason: collision with other method in class */
    public JobCancellationException m526createCopy() {
        return null;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return super.toString() + "; job=" + this.job;
    }

    public /* bridge */ /* synthetic */ Throwable createCopy() {
        return m526createCopy();
    }

    public int hashCode() {
        String r0 = getMessage();
        Intrinsics.checkNotNull(r0);
        int r1 = ((r0.hashCode() * 31) + this.job.hashCode()) * 31;
        Throwable r2 = getCause();
        if (r2 == null) goto L5;
        int r3 = r2.hashCode();
    L7:
        return r1 + r3;
    L5:
        r3 = 0;
        goto L7
    }

    public boolean equals(Object r3) {
        if (r3 != this) goto L4;
    L13:
        return true;
    L4:
        if ((r3 instanceof JobCancellationException) == false) goto L12;
        JobCancellationException r4 = (JobCancellationException) r3;
        if (Intrinsics.areEqual(r4.getMessage(), getMessage()) == false) goto L12;
        if (Intrinsics.areEqual(r4.job, this.job) == false) goto L12;
        if (Intrinsics.areEqual(r4.getCause(), getCause()) == true) goto L13;
    L12:
        return false;
    }

    public JobCancellationException(String r1, Throwable r2, Job r3) {
        super(r1);
        this.job = r3;
        if (r2 == null) goto L6;
        initCause(r2);
        return;
    }
}
