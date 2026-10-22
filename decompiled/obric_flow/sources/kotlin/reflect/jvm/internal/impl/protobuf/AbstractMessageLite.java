package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractMessageLite implements MessageLite {
    protected int memoizedHashCode;

    public static abstract class Builder<BuilderType extends Builder> implements MessageLite.Builder {

        public static final class LimitedInputStream extends FilterInputStream {
            private int limit;

            public LimitedInputStream(InputStream r5, int r10) {
                super(r5);
                this.limit = r10;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int available() throws IOException {
                return Math.min(super.available(), this.limit);
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read() throws IOException {
                if (this.limit > 0) goto L6;
                return -1;
            L6:
                int r5 = super.read();
                if (r5 < 0) goto L9;
                this.limit--;
            L9:
                return r5;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public long skip(long r5) throws IOException {
                long r10 = super.skip(Math.min(r5, this.limit));
                if (r10 < 0) goto L5;
                this.limit = (int) (((long) this.limit) - r10);
            L5:
                return r10;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read(byte[] r5, int r10, int r11) throws IOException {
                int r12 = this.limit;
                if (r12 > 0) goto L6;
                return -1;
            L6:
                int r13 = super.read(r5, r10, Math.min(r11, r12));
                if (r13 < 0) goto L9;
                this.limit -= r13;
            L9:
                return r13;
            }
        }

        public Builder() {
        }

        public static UninitializedMessageException newUninitializedMessageException(MessageLite r5) {
            return new UninitializedMessageException(r5);
        }

        public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
            return mo1400clone();
        }

        /* JADX INFO: renamed from: clone */
        public abstract BuilderType mo1400clone();

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        public abstract BuilderType mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException;

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
            return mergeFrom(r5, r10);
        }
    }

    public AbstractMessageLite() {
        this.memoizedHashCode = 0;
    }

    public UninitializedMessageException newUninitializedMessageException() {
        return new UninitializedMessageException(this);
    }

    public void writeDelimitedTo(OutputStream r5) throws IOException {
        int r10 = getSerializedSize();
        CodedOutputStream r11 = CodedOutputStream.newInstance(r5, CodedOutputStream.computePreferredBufferSize(CodedOutputStream.computeRawVarint32Size(r10) + r10));
        r11.writeRawVarint32(r10);
        writeTo(r11);
        r11.flush();
    }
}
