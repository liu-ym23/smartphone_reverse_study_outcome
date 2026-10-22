package org.apache.poi.hsmf.datatypes;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Comparator;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;

/* JADX INFO: loaded from: classes7.dex */
public class AttachmentChunks {
    private static final c LOG = null;
    private final String poifsName;

    public static class AttachmentChunksSorter implements Serializable, Comparator<AttachmentChunks> {
        public AttachmentChunksSorter() {
        }

        @Override // java.util.Comparator
        public /* synthetic */ int compare(AttachmentChunks r3, AttachmentChunks r4) {
            return compare2((AttachmentChunks) ZeusTransformUtils.preCheckCast(r3, AttachmentChunks.class, "com.obric.memorydata.plugin"), (AttachmentChunks) ZeusTransformUtils.preCheckCast(r4, AttachmentChunks.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(AttachmentChunks r1, AttachmentChunks r2) {
            return AttachmentChunks.access$000(r1).compareTo(AttachmentChunks.access$000(r2));
        }
    }

    static {
        LOG = b.a(AttachmentChunks.class);
    }

    static /* synthetic */ String access$000(AttachmentChunks r0) {
        return r0.poifsName;
    }
}
