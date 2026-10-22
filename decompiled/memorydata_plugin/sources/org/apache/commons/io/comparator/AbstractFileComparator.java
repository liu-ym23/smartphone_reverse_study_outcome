package org.apache.commons.io.comparator;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
abstract class AbstractFileComparator implements Comparator<File> {
    AbstractFileComparator() {
    }

    public List<File> sort(List<File> r3) {
        List<File> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L5;
        r4.sort(this);
    L5:
        return r4;
    }

    public File[] sort(File... r1) {
        if (r1 == null) goto L4;
        Arrays.sort(r1, this);
    L4:
        return r1;
    }

    public String toString() {
        return getClass().getSimpleName();
    }
}
