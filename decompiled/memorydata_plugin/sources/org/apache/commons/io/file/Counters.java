package org.apache.commons.io.file;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;

/* JADX INFO: loaded from: classes6.dex */
public class Counters {

    /* JADX INFO: renamed from: org.apache.commons.io.file.Counters$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class AbstractPathCounters implements PathCounters {
        private final Counter byteCounter;
        private final Counter directoryCounter;
        private final Counter fileCounter;

        public AbstractPathCounters(Counter r3, Counter r4, Counter r5) {
            Counter r6 = (Counter) ZeusTransformUtils.wrapperContextForParams(r3, Counter.class, "com.obric.memorydata.plugin");
            Counter r7 = (Counter) ZeusTransformUtils.wrapperContextForParams(r4, Counter.class, "com.obric.memorydata.plugin");
            Counter r8 = (Counter) ZeusTransformUtils.wrapperContextForParams(r5, Counter.class, "com.obric.memorydata.plugin");
            this.byteCounter = r6;
            this.directoryCounter = r7;
            this.fileCounter = r8;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, AbstractPathCounters.class) == true) goto L8;
            return false;
        L8:
            AbstractPathCounters r6 = (AbstractPathCounters) ZeusTransformUtils.preCheckCast(r5, AbstractPathCounters.class, "com.obric.memorydata.plugin");
            if (Objects.equals(this.byteCounter, r6.byteCounter) == false) goto L16;
            if (Objects.equals(this.directoryCounter, r6.directoryCounter) == false) goto L16;
            if (Objects.equals(this.fileCounter, r6.fileCounter) == false) goto L16;
            return true;
        L16:
            return false;
        }

        @Override // org.apache.commons.io.file.Counters.PathCounters
        public Counter getByteCounter() {
            return this.byteCounter;
        }

        @Override // org.apache.commons.io.file.Counters.PathCounters
        public Counter getDirectoryCounter() {
            return this.directoryCounter;
        }

        @Override // org.apache.commons.io.file.Counters.PathCounters
        public Counter getFileCounter() {
            return this.fileCounter;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.byteCounter, this.directoryCounter, this.fileCounter});
        }

        public String toString() {
            return String.format("%,d files, %,d directories, %,d bytes", new Object[]{Long.valueOf(this.fileCounter.get()), Long.valueOf(this.directoryCounter.get()), Long.valueOf(this.byteCounter.get())});
        }
    }

    public interface Counter {
        void add(long r1);

        long get();

        void increment();
    }

    private static final class LongCounter implements Counter {
        private long value;

        private LongCounter() {
        }

        /* synthetic */ LongCounter(AnonymousClass1 r1) {
            this();
        }

        @Override // org.apache.commons.io.file.Counters.Counter
        public void add(long r3) {
            this.value += r3;
        }

        public boolean equals(Object r6) {
            if (this != r6) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r6, Counter.class) == true) goto L8;
            return false;
        L8:
            Counter r7 = (Counter) ZeusTransformUtils.preCheckCast(r6, Counter.class, "com.obric.memorydata.plugin");
            if (this.value != r7.get()) goto L12;
            return true;
        L12:
            return false;
        }

        @Override // org.apache.commons.io.file.Counters.Counter
        public long get() {
            return this.value;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{Long.valueOf(this.value)});
        }

        @Override // org.apache.commons.io.file.Counters.Counter
        public void increment() {
            this.value++;
        }

        public String toString() {
            return Long.toString(this.value);
        }
    }

    private static final class LongPathCounters extends AbstractPathCounters {
        public LongPathCounters() {
            super(Counters.longCounter(), Counters.longCounter(), Counters.longCounter());
        }
    }

    public interface PathCounters {
        Counter getByteCounter();

        Counter getDirectoryCounter();

        Counter getFileCounter();
    }

    public static Counter longCounter() {
        return new LongCounter(null);
    }

    public static PathCounters longPathCounters() {
        return new LongPathCounters();
    }
}
