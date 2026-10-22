package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class AbstractMessageLite implements MessageLite {
    protected int memoizedHashCode;

    public static abstract class Builder<BuilderType extends Builder> implements MessageLite.Builder {

        public static final class LimitedInputStream extends FilterInputStream {
            private int limit;

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read() throws IOException {
                if (this.limit > 0) goto L6;
                return -1;
            L6:
                int r0 = super.read();
                if (r0 < 0) goto L9;
                this.limit--;
            L9:
                return r0;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int available() throws IOException {
                return Math.min(super.available(), this.limit);
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public long skip(long r4) throws IOException {
                long r5 = super.skip(Math.min(r4, this.limit));
                if (r5 < 0) goto L5;
                this.limit = (int) (((long) this.limit) - r5);
            L5:
                return r5;
            }

            public LimitedInputStream(InputStream r1, int r2) {
                super(r1);
                this.limit = r2;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read(byte[] r2, int r3, int r4) throws IOException {
                int r0 = this.limit;
                if (r0 > 0) goto L6;
                return -1;
            L6:
                int r5 = super.read(r2, r3, Math.min(r4, r0));
                if (r5 < 0) goto L9;
                this.limit -= r5;
            L9:
                return r5;
            }
        }

        /* JADX INFO: renamed from: clone */
        public abstract BuilderType mo381clone();

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        public abstract BuilderType mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException;

        public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
            return mo381clone();
        }

        public Builder() {
        }

        public static UninitializedMessageException newUninitializedMessageException(MessageLite r1) {
            return new UninitializedMessageException(r1);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
            return mergeFrom(r1, r2);
        }
    }

    public UninitializedMessageException newUninitializedMessageException() {
        return new UninitializedMessageException(this);
    }

    public AbstractMessageLite() {
        this.memoizedHashCode = 0;
    }

    public void writeDelimitedTo(OutputStream r3) throws IOException {
        int r0 = getSerializedSize();
        CodedOutputStream r4 = CodedOutputStream.newInstance(r3, CodedOutputStream.computePreferredBufferSize(CodedOutputStream.computeRawVarint32Size(r0) + r0));
        r4.writeRawVarint32(r0);
        writeTo(r4);
        r4.flush();
    }
}
