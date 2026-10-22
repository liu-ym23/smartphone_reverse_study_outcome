package com.google.zxing.multi.qrcode;

import com.google.zxing.ResultMetadataType;
import com.google.zxing.b;
import com.google.zxing.qrcode.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Comparator;

/* JADX INFO: loaded from: classes3.dex */
public final class QRCodeMultiReader extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.google.zxing.a[] f5081a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final b[] f5082b = null;

    /* JADX INFO: renamed from: com.google.zxing.multi.qrcode.QRCodeMultiReader$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class SAComparator implements Serializable, Comparator<com.google.zxing.a> {
        private SAComparator() {
        }

        /* synthetic */ SAComparator(AnonymousClass1 r1) {
            this();
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(com.google.zxing.a r2, com.google.zxing.a r3) {
            return Integer.compare(((Integer) ZeusTransformUtils.preCheckCast(r2.a().get(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE), Integer.class, "com.obric.memorydata.plugin")).intValue(), ((Integer) ZeusTransformUtils.preCheckCast(r3.a().get(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE), Integer.class, "com.obric.memorydata.plugin")).intValue());
        }

        @Override // java.util.Comparator
        public /* synthetic */ int compare(com.google.zxing.a r3, com.google.zxing.a r4) {
            return compare2((com.google.zxing.a) ZeusTransformUtils.preCheckCast(r3, com.google.zxing.a.class, "com.obric.memorydata.plugin"), (com.google.zxing.a) ZeusTransformUtils.preCheckCast(r4, com.google.zxing.a.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        f5081a = new com.google.zxing.a[0];
        f5082b = new b[0];
    }
}
