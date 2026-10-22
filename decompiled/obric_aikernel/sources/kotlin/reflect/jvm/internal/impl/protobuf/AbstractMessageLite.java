package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.FilterInputStream;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractMessageLite implements MessageLite {
    protected int memoizedHashCode;

    public static abstract class Builder<BuilderType extends Builder> implements MessageLite.Builder {

        static final class LimitedInputStream extends FilterInputStream {
            private int limit;

            LimitedInputStream(InputStream r10, int r11) {
                super(r10);
                this.limit = r11;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int available() {
                return Math.min(super.available(), this.limit);
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read() {
                if (this.limit > 0) goto L6;
                return -1;
            L6:
                int r10 = super.read();
                if (r10 < 0) goto L9;
                this.limit--;
            L9:
                return r10;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read(byte[] r10, int r11, int r12) {
                int r13 = this.limit;
                if (r13 > 0) goto L6;
                return -1;
            L6:
                int r14 = super.read(r10, r11, Math.min(r12, r13));
                if (r14 < 0) goto L9;
                this.limit -= r14;
            L9:
                return r14;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public long skip(long r10) {
                long r11 = super.skip(Math.min(r10, this.limit));
                if (r11 < 0) goto L5;
                this.limit = (int) (((long) this.limit) - r11);
            L5:
                return r11;
            }
        }

        public Builder() {
        }

        protected static UninitializedMessageException newUninitializedMessageException(MessageLite r10) {
            return new UninitializedMessageException(r10);
        }

        public /* bridge */ /* synthetic */ Object clone() {
            return mo1321clone();
        }

        /* JADX INFO: renamed from: clone */
        public abstract BuilderType mo1321clone();

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        public abstract BuilderType mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11);

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
            return mergeFrom(r10, r11);
        }
    }

    public AbstractMessageLite() {
        this.memoizedHashCode = 0;
    }

    UninitializedMessageException newUninitializedMessageException() {
        return new UninitializedMessageException(this);
    }

    public void writeDelimitedTo(OutputStream r10) {
        int r11 = getSerializedSize();
        CodedOutputStream r12 = CodedOutputStream.newInstance(r10, CodedOutputStream.computePreferredBufferSize(CodedOutputStream.computeRawVarint32Size(r11) + r11));
        r12.writeRawVarint32(r11);
        writeTo(r12);
        r12.flush();
    }
}
