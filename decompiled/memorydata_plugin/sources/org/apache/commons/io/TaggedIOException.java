package org.apache.commons.io;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class TaggedIOException extends IOExceptionWithCause {
    private static final long serialVersionUID = -6994123481142850163L;
    private final Serializable tag;

    public TaggedIOException(IOException r3, Serializable r4) {
        Serializable r5 = (Serializable) ZeusTransformUtils.wrapperContextForParams(r4, Serializable.class, "com.obric.memorydata.plugin");
        super(r3.getMessage(), r3);
        this.tag = r5;
    }

    public static boolean isTaggedWith(Throwable r2, Object r3) {
        if (r3 != null) goto L5;
    L9:
        return false;
    L5:
        if (ZeusTransformUtils.instanceOf(r2, TaggedIOException.class) == false) goto L9;
        if (r3.equals(((TaggedIOException) ZeusTransformUtils.preCheckCast(r2, TaggedIOException.class, "com.obric.memorydata.plugin")).tag) == false) goto L9;
        return true;
    }

    public static void throwCauseIfTaggedWith(Throwable r1, Object r2) {
        if (isTaggedWith(r1, r2) == true) goto L6;
        return;
    L6:
        throw ((TaggedIOException) ZeusTransformUtils.preCheckCast(r1, TaggedIOException.class, "com.obric.memorydata.plugin")).getCause();
    }

    @Override // java.lang.Throwable
    public synchronized IOException getCause() {
        monitor-enter(this);
        IOException r0 = (IOException) ZeusTransformUtils.preCheckCast(super.getCause(), IOException.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.lang.Throwable
    public /* bridge */ /* synthetic */ Throwable getCause() {
        return getCause();
    }

    public Serializable getTag() {
        return this.tag;
    }
}
