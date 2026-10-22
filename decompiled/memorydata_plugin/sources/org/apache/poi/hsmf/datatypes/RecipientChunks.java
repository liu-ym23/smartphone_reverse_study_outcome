package org.apache.poi.hsmf.datatypes;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Comparator;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;

/* JADX INFO: loaded from: classes7.dex */
public final class RecipientChunks {
    public static final MAPIProperty DELIVERY_TYPE = null;
    private static final c LOG = null;
    public static final MAPIProperty RECIPIENT_DISPLAY_NAME = null;
    public static final MAPIProperty RECIPIENT_EMAIL_ADDRESS = null;
    public static final MAPIProperty RECIPIENT_NAME = null;
    public static final MAPIProperty RECIPIENT_SEARCH = null;
    public static final MAPIProperty RECIPIENT_SMTP_ADDRESS = null;
    private int recipientNumber;

    public static class RecipientChunksSorter implements Serializable, Comparator<RecipientChunks> {
        public RecipientChunksSorter() {
        }

        @Override // java.util.Comparator
        public /* synthetic */ int compare(RecipientChunks r3, RecipientChunks r4) {
            return compare2((RecipientChunks) ZeusTransformUtils.preCheckCast(r3, RecipientChunks.class, "com.obric.memorydata.plugin"), (RecipientChunks) ZeusTransformUtils.preCheckCast(r4, RecipientChunks.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(RecipientChunks r1, RecipientChunks r2) {
            return Integer.compare(RecipientChunks.access$000(r1), RecipientChunks.access$000(r2));
        }
    }

    static {
        LOG = b.a(RecipientChunks.class);
        RECIPIENT_NAME = MAPIProperty.DISPLAY_NAME;
        DELIVERY_TYPE = MAPIProperty.ADDRTYPE;
        RECIPIENT_EMAIL_ADDRESS = MAPIProperty.EMAIL_ADDRESS;
        RECIPIENT_SEARCH = MAPIProperty.SEARCH_KEY;
        RECIPIENT_SMTP_ADDRESS = MAPIProperty.SMTP_ADDRESS;
        RECIPIENT_DISPLAY_NAME = MAPIProperty.RECIPIENT_DISPLAY_NAME;
    }

    static /* synthetic */ int access$000(RecipientChunks r0) {
        return r0.recipientNumber;
    }
}
