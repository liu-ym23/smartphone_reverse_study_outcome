package com.lynx.animax.player;

import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.lynx.animax.util.AnimaXLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class VideoAsset {
    public static final String[] e = null;
    public String a;
    public f b;
    public boolean c;
    public l d;

    public VideoAsset() {
    }

    static {
        e = new String[]{"csd-0", "csd-1", "csd-2"};
    }

    public static VideoAsset create() {
        return new VideoAsset();
    }

    public final boolean b() {
        boolean r1 = true;
        if (this.d != null) goto L62;
        AnimaXLog.b("VideoAsset", "prepareFrameBuffer");
        f r0 = this.b;
        if (r0 == null) goto L62;
        String r4 = this.a;
        int r2 = r0.f;
        if (r4 != null) goto L10;
    L46:
        l r5 = null;
    L47:
        this.d = r5;
        if (r5 == null) goto L62;
        if (r5 == null) goto L56;
        ArrayList<Integer> r3 = r5.b;
        if (r3.isEmpty() == true) goto L56;
        if (((Integer) ListProtector.get(r3, 0)).intValue() != 0) goto L56;
        boolean r6 = true;
    L57:
        if (r6 == false) goto L62;
        ArrayList<d> r7 = this.d.c;
        if (this.b.e == r7.size()) goto L62;
        AnimaXLog.a("VideoAsset", "prepareFrameBuffer: frameCount change from " + this.b.e + " to " + r7.size());
        this.b.e = r7.size();
    L56:
        r6 = false;
        goto L57
    L10:
        if (r4.isEmpty() == true) goto L46;
        if (r2 < 0) goto L46;
        r5 = new l();
        MediaExtractor r8 = new MediaExtractor();
        if (e.a(r8, r4) == true) goto L16;
        AnimaXLog.a("VideoAssetExtractor", "load fail, MediaExtractor setDataSource error");
        boolean r9 = false;
    L43:
        r8.release();
        if (r9 == false) goto L46;
    L16:
        r8.selectTrack(r2);
        int r10 = (int) new PolarisFileWrapper(r4).length();
        if (r10 > 0) goto L19;
        AnimaXLog.a("VideoAssetExtractor", "doExtractVideoRawData fail, videoSize = " + r10);
    L42:
        r9 = true;
        goto L43
    L19:
        ByteBuffer r11 = ByteBuffer.allocate(r10);
        ArrayList<Integer> r12 = r5.b;
        ArrayList<d> r13 = r5.c;
        int r14 = 0;
    L73:
        int r15 = r8.readSampleData(r11, r14);     // Catch: IllegalArgumentException -> L22
    L27:
        if (r15 <= 0) goto L36;
        if ((r8.getSampleFlags() & 1) <= 0) goto L31;
        boolean r16 = true;
    L32:
        if (r16 == false) goto L34;
        r12.add(Integer.valueOf(r13.size()));
    L34:
        int r17 = r15 + r14;
        r13.add(new d(r14, r17, r8.getSampleTime()));
        r8.advance();
        r14 = r17;
        goto L73
    L31:
        r16 = false;
        goto L32
    L36:
        if (r15 != (-1)) goto L38;
        boolean r18 = true;
    L39:
        if (r18 == false) goto L41;
        AnimaXLog.b("VideoAssetExtractor", "video size: " + r14 + " bytes, frame count: " + r13.size() + ", key frame count: " + r12.size());
        r5.a = r11;
        goto L42
    L41:
        AnimaXLog.a("VideoAssetExtractor", "doExtractVideoRawData fail");
        r12.clear();
        r13.clear();
        goto L42
    L38:
        r18 = false;
    L22:
        e = move-exception;
        String r19 = e.getMessage();
        if (r19 != null) goto L26;
        r19 = "current buffer may not have enough space to read";
    L26:
        AnimaXLog.a("VideoAssetExtractor", "readSampleData IllegalArgumentException: ".concat(r19));
        r15 = 0;
    L62:
        l r20 = this.d;
        if (r20 == null) goto L78;
        ArrayList<Integer> r21 = r20.b;
        if (r21.isEmpty() == false) goto L68;
    L70:
        r1 = false;
    L72:
        return r1;
    L68:
        if (((Integer) ListProtector.get(r21, 0)).intValue() != 0) goto L70;
    L78:
        return false;
    }

    public int getFrameCount() {
        f r0 = this.b;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.e;
    }

    public float getFrameRate() {
        f r0 = this.b;
        if (r0 != null) goto L7;
        return 0.0f;
    L7:
        return r0.d;
    }

    public int getHeight() {
        f r0 = this.b;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.c;
    }

    public ByteBuffer getVideoParameterSets() {
        MediaFormat r0 = this.b.a;
        if (r0 != null) goto L5;
        return null;
    L5:
        ArrayList r2 = new ArrayList();
        String[] r3 = e;
        int r4 = r3.length;
        int r5 = 0;
        int r6 = 0;
    L6:
        if (r5 >= r4) goto L17;
        String r7 = r3[r5];
        if (r0.containsKey(r7) == false) goto L17;
        ByteBuffer r8 = r0.getByteBuffer(r7);
        if (r8 == null) goto L15;
        if (r8.remaining() <= 0) goto L15;
        r2.add(r8);
        r6 = r6 + r8.remaining();
    L15:
        r5 = r5 + 1;
    L17:
        if (r2.isEmpty() == false) goto L19;
        return null;
    L19:
        ByteBuffer r1 = ByteBuffer.allocate(r6);
        Iterator r9 = r2.iterator();
    L21:
        if (r9.hasNext() == false) goto L23;
        r1.put(((ByteBuffer) r9.next()).duplicate());
        goto L21
    L23:
        r1.flip();
        return r1;
    }

    public int getWidth() {
        f r0 = this.b;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.b;
    }

    public boolean isHEVCFormat() {
        f r0 = this.b;
        String r1 = null;
        if (r0 == null) goto L9;
        MediaFormat r2 = r0.a;
        if (r2 == null) goto L9;
        r1 = r2.getString("mime");
    L9:
        if (r1 != null) goto L11;
    L13:
        return false;
    L11:
        if (r1.equalsIgnoreCase("video/hevc") == false) goto L13;
        return true;
    }

    public final ByteBuffer a(d r3) {
        if (r3 == null) goto L12;
        l r1 = this.d;
        if (r1 == null) goto L12;
        ByteBuffer r2 = r1.a;
        if (r2 != null) goto L10;
        return null;
    L10:
        r2.position(0);
        r2.limit(r3.b);
        r2.position(r3.a);
        return r2;
    L12:
        return null;
    }

    public ByteBuffer getFrameData(int r4) {
        l r0 = this.d;
        d r1 = null;
        if (r0 == null) goto L12;
        ArrayList<d> r2 = r0.c;
        if (r4 < 0) goto L12;
        if (r4 >= r2.size()) goto L12;
        r1 = (d) ListProtector.get(r2, r4);
    L12:
        return a(r1);
    }

    public int getPrevKeyFrame(int r2) {
        ArrayList<Integer> r0 = this.d.b;
        int r3 = Collections.binarySearch(r0, Integer.valueOf(r2));
        if (r3 >= 0) goto L6;
        r3 = (-r3) - 2;
    L6:
        return ((Integer) ListProtector.get(r0, r3)).intValue();
    }

    public boolean isSupportDecodeBySystem(boolean r4) {
        f r0 = this.b;
        String r1 = null;
        if (r0 == null) goto L9;
        MediaFormat r2 = r0.a;
        if (r2 == null) goto L9;
        r1 = r2.getString("mime");
    L9:
        if (r1 != null) goto L11;
    L23:
        return false;
    L11:
        monitor-enter(b.class);
    L20:
        th = move-exception;
        throw th;
    L13:
        if (b.c != null) goto L15;
        b.c = new b();     // Catch: Throwable -> L20
    L15:
        b r3 = b.c;     // Catch: Throwable -> L20
        monitor-exit(b.class);
        if (r3.a(r1, r4) == false) goto L23;
        return true;
    }

    public boolean loadLocal(String r14) {
        boolean r0 = false;
        if (r14 != null) goto L5;
    L87:
        AnimaXLog.a("VideoAsset", "video file path is empty");
        this.c = false;
        return false;
    L5:
        if (r14.isEmpty() == true) goto L87;
        if (r14.isEmpty() == true) goto L69;
        f r1 = new f();
        MediaExtractor r5 = new MediaExtractor();
        if (e.a(r5, r14) == true) goto L13;
        AnimaXLog.a("VideoAssetExtractor", "load fail, MediaExtractor setDataSource error");
    L28:
        boolean r6 = false;
    L66:
        r5.release();
        if (r6 == false) goto L69;
    L70:
        this.b = r1;
        if (r1 != null) goto L73;
    L81:
        this.c = r0;
        if (r0 == false) goto L84;
        this.a = r14;
        b();
    L86:
        return this.c;
    L84:
        this.b = null;
        goto L86
    L73:
        if (r1.b <= 0) goto L81;
        if (r1.c <= 0) goto L81;
        if (r1.e <= 0) goto L81;
        if (r1.d <= 0.0f) goto L81;
        r0 = true;
        goto L81
    L13:
        int r7 = r5.getTrackCount();
        int r8 = 0;
    L14:
        if (r8 >= r7) goto L26;
        MediaFormat r9 = r5.getTrackFormat(r8);
        String r10 = r9.getString("mime");     // Catch: ClassCastException -> L18
    L20:
        if (r10 == null) goto L24;
        if (r10.startsWith("video/") == false) goto L24;
        r1.f = r8;
        r1.a = r9;
    L24:
        r8 = r8 + 1;
    L18:
        e = move-exception;
        AnimaXLog.a("VideoAssetExtractor", "format doesn't has mine property: " + e.getMessage());
        r10 = null;
    L26:
        if (r1.f >= 0) goto L91;
        AnimaXLog.a("VideoAssetExtractor", "load fail, there is no video track");
        goto L28
    L91:
        r1.b = r1.a.getInteger("width");     // Catch: Throwable -> L32 NullPointerException -> L34
    L97:
        r1.c = r1.a.getInteger("height");     // Catch: Throwable -> L39 NullPointerException -> L41
    L43:
        MediaFormat r11 = r1.a;
        r1.d = r11.getInteger("frame-rate");     // Catch: ClassCastException -> L46 Throwable -> L48
    L51:
        if (0.0f != r1.d) goto L95;
        r1.d = r11.getFloat("frame-rate");     // Catch: Throwable -> L55 NullPointerException -> L57
    L55:
        e = move-exception;
        AnimaXLog.a("VideoAssetExtractor", "format doesn't has float frame-rate property: " + e.getMessage());
    L95:
        long r12 = r1.a.getLong("durationUs");     // Catch: Throwable -> L61 NullPointerException -> L63
    L65:
        r1.e = Math.round((r1.d * r12) / 1000000.0f);
        AnimaXLog.b("VideoAssetExtractor", "frame count: " + r1.e);
        r6 = true;
    L61:
        e = move-exception;
        AnimaXLog.a("VideoAssetExtractor", "format doesn't has long durationUs property: " + e.getMessage());
        r12 = 0;
    L48:
        e = move-exception;
        AnimaXLog.a("VideoAssetExtractor", "format doesn't has int frame-rate property: " + e.getMessage());
        r1.d = 0.0f;
    L39:
        e = move-exception;
        AnimaXLog.a("VideoAssetExtractor", "format doesn't has height property: " + e.getMessage());
        r1.c = 0;
    L32:
        e = move-exception;
        AnimaXLog.a("VideoAssetExtractor", "format doesn't has width property: " + e.getMessage());
        r1.b = 0;
    L69:
        r1 = null;
        goto L70
    }
}
