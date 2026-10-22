package com.larus.common.app_ops.trasmitter;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010\u0018\u001a\u00020\u0000H&J\b\u0010\u0019\u001a\u00020\u0013H\u0016J\n\u0010\u001a\u001a\u0004\u0018\u00010\u0000H\u0016J\u001a\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010 \u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0000X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0000X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006!"}, d2 = {"Lcom/larus/common/app_ops/trasmitter/AsyncContext;", "Ljava/io/Serializable;", "<init>", "()V", "key", "", "(Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "setKey", "thisThreadPreNode", "getThisThreadPreNode", "()Lcom/larus/common/app_ops/trasmitter/AsyncContext;", "setThisThreadPreNode", "(Lcom/larus/common/app_ops/trasmitter/AsyncContext;)V", "otherThreadPreNode", "getOtherThreadPreNode", "setOtherThreadPreNode", "size", "", "getSize", "()I", "setSize", "(I)V", "copy", "compressTailCount", "findPreContext", "addData", "", "value", "", "remove", "getData", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AsyncContext implements Serializable {
    private String key;
    private AsyncContext otherThreadPreNode;
    private int size;
    private AsyncContext thisThreadPreNode;

    public void addData(String r1, Object r2) {
        Intrinsics.checkNotNullParameter(r1, "key");
    }

    public int compressTailCount() {
        return -1;
    }

    public abstract AsyncContext copy();

    public Object getData(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return null;
    }

    public void remove(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
    }

    public AsyncContext findPreContext() {
        AsyncContext r0 = this.otherThreadPreNode;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return this.thisThreadPreNode;
    }

    public AsyncContext() {
        this.key = "";
    }

    public final String getKey() {
        return this.key;
    }

    public final AsyncContext getOtherThreadPreNode() {
        return this.otherThreadPreNode;
    }

    public final int getSize() {
        return this.size;
    }

    public final AsyncContext getThisThreadPreNode() {
        return this.thisThreadPreNode;
    }

    public AsyncContext(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        this.key = r2;
    }

    public final void setKey(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.key = r2;
    }

    public final void setOtherThreadPreNode(AsyncContext r1) {
        this.otherThreadPreNode = r1;
    }

    public final void setSize(int r1) {
        this.size = r1;
    }

    public final void setThisThreadPreNode(AsyncContext r1) {
        this.thisThreadPreNode = r1;
    }
}
