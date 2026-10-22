package org.apache.commons.compress.archivers.zip;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.Serializable;
import java.util.Comparator;
import org.apache.commons.compress.utils.FileNameUtils;
import org.apache.commons.compress.utils.MultiReadOnlySeekableByteChannel;

/* JADX INFO: loaded from: classes6.dex */
public class ZipSplitReadOnlySeekableByteChannel extends MultiReadOnlySeekableByteChannel {

    /* JADX INFO: renamed from: org.apache.commons.compress.archivers.zip.ZipSplitReadOnlySeekableByteChannel$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class ZipSplitSegmentComparator implements Serializable, Comparator<File> {
        private static final long serialVersionUID = 20200123;

        private ZipSplitSegmentComparator() {
        }

        /* synthetic */ ZipSplitSegmentComparator(AnonymousClass1 r1) {
            this();
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(File r2, File r3) {
            String r1 = FileNameUtils.getExtension(r2.getPath());
            String r4 = FileNameUtils.getExtension(r3.getPath());
            if (r1.startsWith("z") == true) goto L7;
            return -1;
        L7:
            if (r4.startsWith("z") == true) goto L10;
            return 1;
        L10:
            return Integer.valueOf(Integer.parseInt(r1.substring(1))).compareTo(Integer.valueOf(Integer.parseInt(r4.substring(1))));
        }

        @Override // java.util.Comparator
        public /* synthetic */ int compare(File r3, File r4) {
            return compare2((File) ZeusTransformUtils.preCheckCast(r3, File.class, "com.obric.memorydata.plugin"), (File) ZeusTransformUtils.preCheckCast(r4, File.class, "com.obric.memorydata.plugin"));
        }
    }
}
