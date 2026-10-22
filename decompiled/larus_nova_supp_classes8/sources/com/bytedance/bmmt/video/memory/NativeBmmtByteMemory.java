package com.bytedance.bmmt.video.memory;

import com.bytedance.bmmt.video.BmmtVideoMemoryType;
import com.bytedance.bmmt.video.PixelFormat;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class NativeBmmtByteMemory extends BmmtVideoMemory implements BmmtVideoByteMemoryInterface {
    private final int height;
    private final PixelFormat pixelFormat;
    private final ByteBuffer[] planeData;
    private final int[] planeLineSize;
    private final int width;

    /* JADX INFO: renamed from: com.bytedance.bmmt.video.memory.NativeBmmtByteMemory$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$bmmt$video$PixelFormat = null;

        static {
            int[] r0 = new int[PixelFormat.values().length];
            $SwitchMap$com$bytedance$bmmt$video$PixelFormat = r0;
            r0[PixelFormat.kArgb.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L30:
            $SwitchMap$com$bytedance$bmmt$video$PixelFormat[PixelFormat.kBgra.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
        L36:
            $SwitchMap$com$bytedance$bmmt$video$PixelFormat[PixelFormat.kI420.ordinal()] = 3;     // Catch: NoSuchFieldError -> L18
        L50:
            $SwitchMap$com$bytedance$bmmt$video$PixelFormat[PixelFormat.kIYUV.ordinal()] = 4;     // Catch: NoSuchFieldError -> L19
        L32:
            $SwitchMap$com$bytedance$bmmt$video$PixelFormat[PixelFormat.kNv12.ordinal()] = 5;     // Catch: NoSuchFieldError -> L20
        L38:
            $SwitchMap$com$bytedance$bmmt$video$PixelFormat[PixelFormat.kNv21.ordinal()] = 6;     // Catch: NoSuchFieldError -> L21
        L42:
            $SwitchMap$com$bytedance$bmmt$video$PixelFormat[PixelFormat.kRgb.ordinal()] = 7;     // Catch: NoSuchFieldError -> L22
        L46:
            $SwitchMap$com$bytedance$bmmt$video$PixelFormat[PixelFormat.kRgba.ordinal()] = 8;     // Catch: NoSuchFieldError -> L23
        L28:
            $SwitchMap$com$bytedance$bmmt$video$PixelFormat[PixelFormat.kRGB565.ordinal()] = 9;     // Catch: NoSuchFieldError -> L24
        L34:
            $SwitchMap$com$bytedance$bmmt$video$PixelFormat[PixelFormat.kUYVY.ordinal()] = 10;     // Catch: NoSuchFieldError -> L25
        L40:
            $SwitchMap$com$bytedance$bmmt$video$PixelFormat[PixelFormat.kYUY2.ordinal()] = 11;     // Catch: NoSuchFieldError -> L26
        L44:
            $SwitchMap$com$bytedance$bmmt$video$PixelFormat[PixelFormat.kYV12.ordinal()] = 12;     // Catch: NoSuchFieldError -> L27
            return;
        }
    }

    private static native NativeBmmtByteMemory nativeCreateByteMemory(int r0, int r1, PixelFormat r2, long r3);

    @Override // com.bytedance.bmmt.video.memory.BmmtVideoByteMemoryInterface
    public int getNumberOfPlanes() {
        ByteBuffer[] r0 = this.planeData;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.length;
    }

    @Override // com.bytedance.bmmt.video.memory.BmmtVideoMemoryInterface
    public int getHeight() {
        return this.height;
    }

    @Override // com.bytedance.bmmt.video.memory.BmmtVideoMemoryInterface
    public BmmtVideoMemoryType getMemoryType() {
        return BmmtVideoMemoryType.kBYTE_MEMORY;
    }

    @Override // com.bytedance.bmmt.video.memory.BmmtVideoMemoryInterface
    public PixelFormat getPixelFormat() {
        return this.pixelFormat;
    }

    public ByteBuffer[] getPlaneDataArray() {
        return this.planeData;
    }

    public int[] getPlaneLineSizeArray() {
        return this.planeLineSize;
    }

    @Override // com.bytedance.bmmt.video.memory.BmmtVideoMemoryInterface
    public int getWidth() {
        return this.width;
    }

    @Override // com.bytedance.bmmt.video.memory.BmmtVideoByteMemoryInterface
    public ByteBuffer getPlaneData(int r4) {
        ByteBuffer[] r0 = this.planeData;
        if (r0 != null) goto L6;
        return null;
    L6:
        if (r4 <= r0.length) goto L9;
        return null;
    L9:
        return r0[r4].slice();
    }

    @Override // com.bytedance.bmmt.video.memory.BmmtVideoByteMemoryInterface
    public int getPlaneLineSize(int r4) {
        int[] r0 = this.planeLineSize;
        if (r0 != null) goto L6;
        return 0;
    L6:
        if (r4 <= r0.length) goto L9;
        return 0;
    L9:
        return r0[r4];
    }

    public static NativeBmmtByteMemory createByteMemory(int r2, int r3, PixelFormat r4, long r5) {
        switch(AnonymousClass1.$SwitchMap$com$bytedance$bmmt$video$PixelFormat[r4.ordinal()]) {
            case 1: goto L7;
            case 2: goto L7;
            case 3: goto L7;
            case 4: goto L7;
            case 5: goto L7;
            case 6: goto L7;
            case 7: goto L7;
            case 8: goto L7;
            case 9: goto L7;
            case 10: goto L7;
            case 11: goto L7;
            case 12: goto L7;
            default: goto L4;
        };
    L4:
        return null;
    L7:
        return nativeCreateByteMemory(r2, r3, r4, r5);
    }

    public NativeBmmtByteMemory(int r1, int r2, long r3, ByteBuffer[] r5, int[] r6, PixelFormat r7) {
        super(r3);
        this.width = r1;
        this.height = r2;
        this.nativeHandle = r3;
        this.planeData = r5;
        this.planeLineSize = r6;
        this.pixelFormat = r7;
    }
}
