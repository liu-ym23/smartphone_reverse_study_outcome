package com.bytedance.bmmt.video;

import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class EncodedImage {
    public final int actualHeight;
    public final int actualWidth;
    public final ByteBuffer buffer;
    public final long captureTimeMs;
    public final long captureTimeNs;
    public final boolean completeFrame;
    public final long compositionTimeUs;
    public final int encodedHeight;
    public final int encodedWidth;
    public final FrameType frameType;
    public final Integer qp;
    public final int rotation;
    public final int svcLayerNum;

    public static class Builder {
        private int actualHeight;
        private int actualWidth;
        private ByteBuffer buffer;
        private long captureTimeNs;
        private boolean completeFrame;
        private long compositionTimeUs;
        private int encodedHeight;
        private int encodedWidth;
        private FrameType frameType;
        private Integer qp;
        private int rotation;
        private int svcLayerNum;

        public /* synthetic */ Builder(int r1) {
            this();
        }

        public EncodedImage createEncodedImage() {
            return new EncodedImage(this.buffer, this.encodedWidth, this.encodedHeight, this.actualWidth, this.actualHeight, this.captureTimeNs, this.frameType, this.rotation, this.completeFrame, this.qp, this.svcLayerNum, this.compositionTimeUs, 0);
        }

        private Builder() {
            this.qp = -1;
        }

        public Builder setActualHeight(int r1) {
            this.actualHeight = r1;
            return this;
        }

        public Builder setActualWidth(int r1) {
            this.actualWidth = r1;
            return this;
        }

        public Builder setBuffer(ByteBuffer r1) {
            this.buffer = r1;
            return this;
        }

        public Builder setCaptureTimeMs(long r2) {
            this.captureTimeNs = TimeUnit.MILLISECONDS.toNanos(r2);
            return this;
        }

        public Builder setCaptureTimeNs(long r1) {
            this.captureTimeNs = r1;
            return this;
        }

        public Builder setCompleteFrame(boolean r1) {
            this.completeFrame = r1;
            return this;
        }

        public Builder setCompositionTimeUs(long r1) {
            this.compositionTimeUs = r1;
            return this;
        }

        public Builder setEncodedHeight(int r1) {
            this.encodedHeight = r1;
            return this;
        }

        public Builder setEncodedWidth(int r1) {
            this.encodedWidth = r1;
            return this;
        }

        public Builder setFrameType(FrameType r1) {
            this.frameType = r1;
            return this;
        }

        public Builder setQp(Integer r1) {
            this.qp = r1;
            return this;
        }

        public Builder setRotation(int r1) {
            this.rotation = r1;
            return this;
        }

        public Builder setSvcLayerNum(int r1) {
            this.svcLayerNum = r1;
            return this;
        }
    }

    public static final enum FrameType extends Enum<FrameType> {
        private static final /* synthetic */ FrameType[] $VALUES = null;
        public static final FrameType kBiPredicted = null;
        public static final FrameType kEmpty = null;
        public static final FrameType kIntra = null;
        public static final FrameType kLtrRecovery = null;
        public static final FrameType kPredicted = null;
        public static final FrameType kUnknow = null;
        private final int nativeIndex;

        private static /* synthetic */ FrameType[] $values() {
            return new FrameType[]{kUnknow, kIntra, kPredicted, kBiPredicted, kEmpty, kLtrRecovery};
        }

        static {
            kUnknow = new FrameType("kUnknow", 0, 0);
            kIntra = new FrameType("kIntra", 1, 1);
            kPredicted = new FrameType("kPredicted", 2, 2);
            kBiPredicted = new FrameType("kBiPredicted", 3, 3);
            kEmpty = new FrameType("kEmpty", 4, 4);
            kLtrRecovery = new FrameType("kLtrRecovery", 5, 5);
            $VALUES = $values();
        }

        public static FrameType[] values() {
            return (FrameType[]) $VALUES.clone();
        }

        public int getNative() {
            return this.nativeIndex;
        }

        public static FrameType fromNativeIndex(int r5) {
            FrameType[] r0 = values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L9;
            FrameType r3 = r0[r2];
            if (r3.getNative() == r5) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return r3;
        L9:
            throw new IllegalArgumentException("Unknown native frame type: " + r5);
        }

        public static FrameType valueOf(int r5) {
            FrameType[] r0 = values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L9;
            FrameType r3 = r0[r2];
            if (r3.nativeIndex == r5) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return r3;
        L9:
            return kUnknow;
        }

        public static FrameType valueOf(String r1) {
            return (FrameType) r27.a.a(FrameType.class, r1);
        }

        private FrameType(String r1, int r2, int r3) {
            super(r1, r2);
            this.nativeIndex = r3;
        }
    }

    public /* synthetic */ EncodedImage(ByteBuffer r1, int r2, int r3, int r4, int r5, long r6, FrameType r8, int r9, boolean r10, Integer r11, int r12, long r13, int r15) {
        this(r1, r2, r3, r4, r5, r6, r8, r9, r10, r11, r12, r13);
    }

    public static Builder builder() {
        return new Builder(0);
    }

    private int getFrameType() {
        return this.frameType.getNative();
    }

    private ByteBuffer getBuffer() {
        return this.buffer;
    }

    private long getCaptureTimeNs() {
        return this.captureTimeNs;
    }

    private boolean getCompleteFrame() {
        return this.completeFrame;
    }

    private long getCompositionTimeUs() {
        return this.compositionTimeUs;
    }

    private int getEncodedHeight() {
        return this.encodedHeight;
    }

    private int getEncodedWidth() {
        return this.encodedWidth;
    }

    private Integer getQp() {
        return this.qp;
    }

    private int getRotation() {
        return this.rotation;
    }

    private int getSvcLayerNum() {
        return this.svcLayerNum;
    }

    private EncodedImage(ByteBuffer r1, int r2, int r3, int r4, int r5, long r6, FrameType r8, int r9, boolean r10, Integer r11, int r12, long r13) {
        this.buffer = r1;
        this.encodedWidth = r2;
        this.encodedHeight = r3;
        this.actualWidth = r4;
        this.actualHeight = r5;
        this.captureTimeMs = TimeUnit.NANOSECONDS.toMillis(r6);
        this.captureTimeNs = r6;
        this.frameType = r8;
        this.rotation = r9;
        this.completeFrame = r10;
        this.qp = r11;
        this.svcLayerNum = r12;
        this.compositionTimeUs = r13;
    }
}
