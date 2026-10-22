package org.apache.commons.io;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class IOExceptionList extends IOException {
    private static final long serialVersionUID = 1;
    private final List<? extends Throwable> causeList;

    public IOExceptionList(String r4, List<? extends Throwable> r5) {
        List<? extends Throwable> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
    L8:
        Throwable r0 = null;
    L9:
        super(r4, r0);
        if (r6 != null) goto L12;
        r6 = Collections.emptyList();
    L12:
        this.causeList = r6;
        return;
    L5:
        if (r6.isEmpty() == true) goto L8;
        r0 = (Throwable) ZeusTransformUtils.preCheckCast(r6.get(0), Throwable.class, "com.obric.memorydata.plugin");
        goto L9
    }

    public IOExceptionList(List<? extends Throwable> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Object[] r0 = new Object[2];
        if (r5 != null) goto L5;
        int r2 = 0;
    L6:
        r0[0] = Integer.valueOf(r2);
        r0[1] = r5;
        this(String.format("%,d exceptions: %s", r0), r5);
        return;
    L5:
        r2 = r5.size();
        goto L6
    }

    public <T extends Throwable> T getCause(int r2) {
        return (T) ZeusTransformUtils.preCheckCast(this.causeList.get(r2), Throwable.class, "com.obric.memorydata.plugin");
    }

    public <T extends Throwable> T getCause(int r1, Class<T> r2) {
        return (T) ZeusTransformUtils.preCheckCast(r2.cast(this.causeList.get(r1)), Throwable.class, "com.obric.memorydata.plugin");
    }

    public <T extends Throwable> List<T> getCauseList() {
        return (List<T>) this.causeList;
    }

    public <T extends Throwable> List<T> getCauseList(Class<T> r1) {
        return (List<T>) this.causeList;
    }
}
