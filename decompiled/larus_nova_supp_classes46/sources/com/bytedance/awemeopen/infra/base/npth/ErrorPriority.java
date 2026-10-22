package com.bytedance.awemeopen.infra.base.npth;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/awemeopen/infra/base/npth/ErrorPriority;", "", "", "priorityNum", "I", "getPriorityNum", "()I", "p0", "p1", "p2", "p3", "ao_base_core_release"}, k = 1, mv = {1, 7, 1})
public final enum ErrorPriority extends Enum<ErrorPriority> {
    public static final /* synthetic */ ErrorPriority[] a = null;
    public static final ErrorPriority p0 = null;
    public static final ErrorPriority p1 = null;
    public static final ErrorPriority p2 = null;
    public static final ErrorPriority p3 = null;
    private final int priorityNum;

    public static ErrorPriority valueOf(String r1) {
        return (ErrorPriority) a.a(ErrorPriority.class, r1);
    }

    public static ErrorPriority[] values() {
        return (ErrorPriority[]) a.clone();
    }

    static {
        ErrorPriority r0 = new ErrorPriority("p0", 0, 0);
        p0 = r0;
        ErrorPriority r1 = new ErrorPriority("p1", 1, 1);
        p1 = r1;
        ErrorPriority r3 = new ErrorPriority("p2", 2, 2);
        p2 = r3;
        ErrorPriority r5 = new ErrorPriority("p3", 3, 3);
        p3 = r5;
        a = new ErrorPriority[]{r0, r1, r3, r5};
    }

    public final int getPriorityNum() {
        return this.priorityNum;
    }

    public ErrorPriority(String r1, int r2, int r3) {
        super(r1, r2);
        this.priorityNum = r3;
    }
}
