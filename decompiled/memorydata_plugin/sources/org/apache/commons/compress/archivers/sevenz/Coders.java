package org.apache.commons.compress.archivers.sevenz;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import org.tukaani.xz.FilterOptions;

/* JADX INFO: loaded from: classes6.dex */
class Coders {
    private static final Map<SevenZMethod, CoderBase> CODER_MAP = null;

    static class BCJDecoder extends CoderBase {
        private final FilterOptions opts;

        BCJDecoder(FilterOptions r3) {
            FilterOptions r4 = (FilterOptions) ZeusTransformUtils.wrapperContextForParams(r3, FilterOptions.class, "com.obric.memorydata.plugin");
            super(new Class[0]);
            this.opts = r4;
        }
    }

    static class BZIP2Decoder extends CoderBase {
        BZIP2Decoder() {
            super(new Class[]{Number.class});
        }
    }

    static class CopyDecoder extends CoderBase {
        CopyDecoder() {
            super(new Class[0]);
        }
    }

    static class Deflate64Decoder extends CoderBase {
        Deflate64Decoder() {
            super(new Class[]{Number.class});
        }
    }

    static class DeflateDecoder extends CoderBase {
        private static final byte[] ONE_ZERO_BYTE = null;

        static {
            ONE_ZERO_BYTE = new byte[1];
        }

        DeflateDecoder() {
            super(new Class[]{Number.class});
        }
    }

    static {
        CODER_MAP = new AnonymousClass1();
    }
}
