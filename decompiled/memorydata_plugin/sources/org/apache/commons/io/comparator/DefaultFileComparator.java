package org.apache.commons.io.comparator;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.Serializable;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class DefaultFileComparator extends AbstractFileComparator implements Serializable {
    public static final Comparator<File> DEFAULT_COMPARATOR = null;
    public static final Comparator<File> DEFAULT_REVERSE = null;
    private static final long serialVersionUID = 3260141861365313518L;

    static {
        DefaultFileComparator r0 = new DefaultFileComparator();
        DEFAULT_COMPARATOR = r0;
        DEFAULT_REVERSE = new ReverseFileComparator(r0);
    }

    public DefaultFileComparator() {
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(File r1, File r2) {
        return r1.compareTo(r2);
    }

    @Override // java.util.Comparator
    public /* synthetic */ int compare(File r3, File r4) {
        return compare2((File) ZeusTransformUtils.preCheckCast(r3, File.class, "com.obric.memorydata.plugin"), (File) ZeusTransformUtils.preCheckCast(r4, File.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.commons.io.comparator.AbstractFileComparator
    public /* synthetic */ List sort(List r3) {
        return super.sort((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.commons.io.comparator.AbstractFileComparator
    public /* bridge */ /* synthetic */ File[] sort(File[] r1) {
        return super.sort(r1);
    }

    @Override // org.apache.commons.io.comparator.AbstractFileComparator
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }
}
