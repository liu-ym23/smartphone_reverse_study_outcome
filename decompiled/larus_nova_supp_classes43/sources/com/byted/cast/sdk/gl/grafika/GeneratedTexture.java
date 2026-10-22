package com.byted.cast.sdk.gl.grafika;

import java.nio.ByteBuffer;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class GeneratedTexture {
    private static final int BLACK = 0;
    private static final int BLUE = 16711680;
    private static final int BYTES_PER_PIXEL = 4;
    private static final int CYAN = 16776960;
    private static final int FORMAT = 6408;
    private static final int GREEN = 65280;
    private static final int[] GRID = null;
    private static final int HALF = Integer.MIN_VALUE;
    private static final int LOW = 1073741824;
    private static final int MAGENTA = 16711935;
    private static final int OPAQUE = -16777216;
    private static final int RED = 255;
    private static final int TEX_SIZE = 64;
    private static final int TRANSP = 0;
    private static final int WHITE = 16777215;
    private static final int YELLOW = 65535;
    private static final ByteBuffer sCoarseImageData = null;
    private static final ByteBuffer sFineImageData = null;

    /* JADX INFO: renamed from: com.byted.cast.sdk.gl.grafika.GeneratedTexture$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$byted$cast$sdk$gl$grafika$GeneratedTexture$Image = null;

        static {
            int[] r0 = new int[Image.values().length];
            $SwitchMap$com$byted$cast$sdk$gl$grafika$GeneratedTexture$Image = r0;
            r0[Image.COARSE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$byted$cast$sdk$gl$grafika$GeneratedTexture$Image[Image.FINE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public static final enum Image extends Enum<Image> {
        private static final /* synthetic */ Image[] $VALUES = null;
        public static final Image COARSE = null;
        public static final Image FINE = null;

        static {
            Image r0 = new Image("COARSE", 0);
            COARSE = r0;
            Image r1 = new Image("FINE", 1);
            FINE = r1;
            $VALUES = new Image[]{r0, r1};
        }

        public static Image[] values() {
            return (Image[]) $VALUES.clone();
        }

        public static Image valueOf(String r1) {
            return (Image) a.a(Image.class, r1);
        }

        private Image(String r1, int r10) {
            super(r1, r10);
        }
    }

    public GeneratedTexture() {
    }

    static {
        GRID = new int[]{-16776961, -16711681, -16711936, -65281, -1, 1073742079, 1073807104, -16711681, -65281, GREEN, -2147483393, OPAQUE, -256, -65281, -256, -65536};
        sCoarseImageData = generateCoarseData();
        sFineImageData = generateFineData();
    }

    private static ByteBuffer generateCoarseData() {
        byte[] r1 = new byte[16384];
        int r10 = 0;
    L3:
        if (r10 >= 16384) goto L11;
        int r11 = r10 / 4;
        int r12 = GRID[(((r11 / TEX_SIZE) / 16) * 4) + ((r11 % TEX_SIZE) / 16)];
        if (r10 != 0) goto L8;
    L6:
        r12 = -1;
    L10:
        int r13 = r12 & RED;
        int r14 = (r12 >> 8) & RED;
        int r15 = (r12 >> 16) & RED;
        int r16 = (r12 >> 24) & RED;
        float r17 = r16 / 255.0f;
        r1[r10] = (byte) (r13 * r17);
        r1[r10 + 1] = (byte) (r14 * r17);
        r1[r10 + 2] = (byte) (r15 * r17);
        r1[r10 + 3] = (byte) r16;
        r10 = r10 + 4;
        goto L3
    L8:
        if (r10 != 16380) goto L10;
    L11:
        ByteBuffer r0 = ByteBuffer.allocateDirect(16384);
        r0.put(r1);
        r0.position(0);
        return r0;
    }

    private static ByteBuffer generateFineData() {
        byte[] r10 = new byte[16384];
        checkerPattern(r10, 0, 0, 32, 32, -16776961, -65536, 1);
        checkerPattern(r10, 32, 32, TEX_SIZE, TEX_SIZE, -16776961, -16711936, 2);
        checkerPattern(r10, 0, 32, 32, TEX_SIZE, -65536, -16711936, 4);
        checkerPattern(r10, 32, 0, TEX_SIZE, 32, -1, OPAQUE, 8);
        ByteBuffer r0 = ByteBuffer.allocateDirect(16384);
        r0.put(r10);
        r0.position(0);
        return r0;
    }

    public static int createTestTexture(Image r10) {
        int r11 = AnonymousClass1.$SwitchMap$com$byted$cast$sdk$gl$grafika$GeneratedTexture$Image[r10.ordinal()];
        if (r11 != 1) goto L5;
        ByteBuffer r12 = sCoarseImageData;
    L11:
        return GlUtil.createImageTexture(r12, TEX_SIZE, TEX_SIZE, FORMAT);
    L5:
        if (r11 != 2) goto L8;
        r12 = sFineImageData;
        goto L11
    L8:
        throw new RuntimeException("unknown image");
    }

    private static void checkerPattern(byte[] r12, int r13, int r14, int r15, int r16, int r17, int r18, int r19) {
        int r0 = r14;
    L3:
        if (r0 >= r16) goto L12;
        int r10 = (r0 * TEX_SIZE) * 4;
        int r11 = r13;
    L5:
        if (r11 >= r15) goto L11;
        int r20 = (r11 * 4) + r10;
        if (((r0 & r19) ^ (r11 & r19)) != 0) goto L9;
        int r21 = r17;
    L10:
        int r22 = r21 & RED;
        int r23 = (r21 >> 8) & RED;
        int r24 = (r21 >> 16) & RED;
        int r25 = (r21 >> 24) & RED;
        float r110 = r25 / 255.0f;
        r12[r20] = (byte) (r22 * r110);
        r12[r20 + 1] = (byte) (r23 * r110);
        r12[r20 + 2] = (byte) (r24 * r110);
        r12[r20 + 3] = (byte) r25;
        r11 = r11 + 1;
        goto L5
    L9:
        r21 = r18;
        goto L10
    L11:
        r0 = r0 + 1;
        goto L3
    }
}
