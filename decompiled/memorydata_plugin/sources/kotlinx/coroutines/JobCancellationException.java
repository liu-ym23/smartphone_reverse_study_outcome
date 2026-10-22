package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00000\u0003B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\n\u0010\u000b\u001a\u0004\u0018\u00010\u0000H\u0016J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0007H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0005H\u0016R\u0010\u0010\b\u001a\u00020\t8\u0000X\u0081\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lkotlinx/coroutines/JobCancellationException;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "Lkotlinx/coroutines/CopyableThrowable;", "message", "", "cause", "", "job", "Lkotlinx/coroutines/Job;", "(Ljava/lang/String;Ljava/lang/Throwable;Lkotlinx/coroutines/Job;)V", "createCopy", "equals", "", "other", "", "fillInStackTrace", "hashCode", "", "toString", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class JobCancellationException extends CancellationException implements af<JobCancellationException> {
    public final transient bx job;

    public JobCancellationException(String r3, Throwable r4, bx r5) {
        bx r6 = (bx) ZeusTransformUtils.wrapperContextForParams(r5, bx.class, "com.obric.memorydata.plugin");
        super(r3);
        this.job = r6;
        if (r4 == null) goto L6;
        initCause(r4);
        return;
    }

    @Override // kotlinx.coroutines.af
    public /* synthetic */ Throwable createCopy() {
        return (Throwable) ZeusTransformUtils.preCheckCast(createCopy(), Throwable.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlinx.coroutines.af
    public JobCancellationException createCopy() {
        if (an.b() == false) goto L6;
        String r1 = getMessage();
        Intrinsics.checkNotNull(r1);
        return new JobCancellationException(r1, (Throwable) ZeusTransformUtils.preCheckCast(this, Throwable.class, "com.obric.memorydata.plugin"), this.job);
    L6:
        return null;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L5;
    L14:
        return true;
    L5:
        if (ZeusTransformUtils.instanceOf(r5, JobCancellationException.class) == true) goto L7;
    L13:
        return false;
    L7:
        if (Intrinsics.areEqual(((JobCancellationException) ZeusTransformUtils.preCheckCast(r5, JobCancellationException.class, "com.obric.memorydata.plugin")).getMessage(), getMessage()) == false) goto L13;
        if (Intrinsics.areEqual(((JobCancellationException) ZeusTransformUtils.preCheckCast(r5, JobCancellationException.class, "com.obric.memorydata.plugin")).job, this.job) == false) goto L13;
        if (Intrinsics.areEqual(((JobCancellationException) ZeusTransformUtils.preCheckCast(r5, JobCancellationException.class, "com.obric.memorydata.plugin")).getCause(), getCause()) == false) goto L13;
        goto L13
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        if (an.b() == true) goto L5;
        setStackTrace(new StackTraceElement[0]);
        return (Throwable) ZeusTransformUtils.preCheckCast(this, Throwable.class, "com.obric.memorydata.plugin");
    L5:
        return super.fillInStackTrace();
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

    @Override // java.lang.Throwable
    public String toString() {
        return super.toString() + "; job=" + this.job;
    }
}
