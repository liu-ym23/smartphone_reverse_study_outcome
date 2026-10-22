package po1;

import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.livesdk.chatroom.utils.pngloader.ChunkReader;
import com.bytedance.android.livesdk.chatroom.utils.pngloader.FlexData;
import com.bytedance.mt.protector.impl.PatternProtector;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.zip.InflaterInputStream;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d implements Closeable {
    public final com.bytedance.android.livesdk.chatroom.utils.pngloader.b a;
    public InputStream b;
    public byte[] c;
    public int d;
    public int e;
    public boolean f;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        com.bytedance.android.livesdk.chatroom.utils.pngloader.b r1 = this.a;     // Catch: Exception -> L7
        if (r1 == null) goto L9;
        r1.f = true;     // Catch: Exception -> L7
    L9:
        this.f = true;
        this.c = null;
        this.d = 0;
        this.e = 0;
        InputStream r2 = this.b;
        if (r2 != null) goto L17;
    L15:
        this.b = null;
        return;
    L17:
        r2.close();     // Catch: Exception -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    }

    public final FlexData b() {
        c r0 = this.a.l;
        if (r0 != null) goto L5;
    L12:
        return null;
    L5:
        if (TextUtils.isEmpty(r0.a) == true) goto L12;
        Matcher r1 = PatternProtector.compile("<xmp:FlexData>(.*)</xmp:FlexData>").matcher(this.a.l.a);     // Catch: Exception -> L13
        if (r1.find() == false) goto L12;
        if (r1.group(1) == null) goto L12;
        String r3 = new String(Base64.decode(r1.group(1), 0));     // Catch: Exception -> L13
        return (FlexData) GsonHelper.get().fromJson(r3, FlexData.class);
    }

    static {
    }

    public d(InputStream r4) {
        this.f = false;
        this.b = r4;
        this.c = new byte[16384];
        com.bytedance.android.livesdk.chatroom.utils.pngloader.b r5 = new com.bytedance.android.livesdk.chatroom.utils.pngloader.b();
        this.a = r5;
        int r1 = 36;
    L3:
        if (r1 <= 0) goto L10;
        int r2 = a(r5, r1);     // Catch: RuntimeException -> L8
        if (r2 <= 0) goto L11;
        r1 = r1 - r2;     // Catch: RuntimeException -> L8
    L11:
        if (r2 != 36) goto L21;
    L12:
        com.bytedance.android.livesdk.chatroom.utils.pngloader.b r6 = this.a;     // Catch: RuntimeException -> L8
        if (r6.i >= 4) goto L19;
        if (a(r6, Integer.MAX_VALUE) > 0) goto L12;
        throw new RuntimeException();     // Catch: RuntimeException -> L8
    L19:
        return;
    L21:
        throw new RuntimeException();     // Catch: RuntimeException -> L8
    L8:
        e = move-exception;
        close();
        this.a.f = true;
        throw e;
    L10:
        r2 = 36;
        goto L11
    }

    public final int a(com.bytedance.android.livesdk.chatroom.utils.pngloader.b r17, int r18) {
        int r2 = r18;
        int r4 = 0;
        if (this.d <= 0) goto L5;
    L16:
        if (r2 > 0) goto L18;
    L20:
        r2 = this.d;
    L21:
        if (r2 <= 0) goto L249;
        byte[] r5 = this.c;
        int r6 = this.e;
        if (r17.f == true) goto L139;
        if (r2 == 0) goto L236;
        if (r2 < 0) goto L247;
        boolean r9 = true;
        if (r17.d == false) goto L224;
        com.bytedance.android.livesdk.chatroom.utils.pngloader.a r7 = r17.k;
        if (r7 == null) goto L145;
        int r13 = r7.d;
        if (r13 != 4) goto L35;
        boolean r14 = true;
    L36:
        if (r14 == true) goto L145;
        if (r2 == 0) goto L138;
        if (r2 < 0) goto L144;
        b r8 = r7.b;
        int r15 = r8.a;
        int r16 = r7.c;
        int r19 = r15 - r16;
        if (r19 <= r2) goto L44;
        r19 = r2;
    L44:
        if (r19 > 0) goto L46;
        if (r13 == 0) goto L46;
    L55:
        int r3 = r7.c;
        b r10 = r7.b;
        if (r3 != r10.a) goto L132;
        int r11 = r7.d;
        int r12 = 4 - r11;
        if (r12 > r2) goto L61;
        r2 = r12;
    L61:
        if (r2 <= 0) goto L130;
        int r20 = r11 + r2;
        r7.d = r20;
        if (r20 != 4) goto L130;
        com.bytedance.android.livesdk.chatroom.utils.pngloader.b r21 = r7.e;
        if (r21.g != 1) goto L72;
        if ("IHDR".equals(r10.c) == true) goto L72;
        throw new RuntimeException();
    L72:
        if (r7.b.c.equals("IEND") == false) goto L74;
        r21.e = true;
        r21.f = true;
    L74:
        ChunkReader.ChunkReaderMode r22 = r7.a;
        ChunkReader.ChunkReaderMode r23 = ChunkReader.ChunkReaderMode.BUFFER;
        if (r22 != r23) goto L81;
        String r24 = r7.b.c;
        byte[] r25 = a.a;
        if ((!Character.isUpperCase(r24.charAt(0))) == false) goto L81;
        r21.j += (long) r7.b.a;
    L81:
        if (r7.a != r23) goto L131;
        b r26 = r7.b;
        if (r26.c.equals("iTXt") == false) goto L131;
        if (r26.d == null) goto L131;
        c r27 = new c();
        r21.l = r27;
        int[] r28 = new int[3];
        int r29 = 0;
        int r110 = 0;
    L87:
        byte[] r111 = r26.d;
        if (r29 >= r111.length) goto L98;
        if (r111[r29] != 0) goto L97;
        r28[r110] = r29;
        r110 = r110 + 1;
        if (r110 != 1) goto L95;
        r29 = r29 + 2;
    L95:
        if (r110 == 3) goto L98;
    L97:
        r29 = r29 + 1;
    L98:
        if (r110 != 3) goto L129;
        int r30 = r28[0];
        byte[] r112 = a.a;
        new String(r111, 0, r30, Charset.forName("ISO-8859-1"));
        int r31 = r28[0] + 1;
        byte[] r32 = r26.d;
        if (r32[r31] == 0) goto L102;
        boolean r113 = true;
    L103:
        int r33 = r31 + 1;
        if (r113 == true) goto L106;
    L110:
        int r34 = r28[2] + 1;
        if (r113 == true) goto L260;
        r27.a = new String(r32, r34, r32.length - r34, Charset.forName("UTF-8"));
        goto L131
    L260:
        InflaterInputStream r35 = new InflaterInputStream(new ByteArrayInputStream(r32, r34, r32.length - r34));     // Catch: Exception -> L124
        ByteArrayOutputStream r36 = new ByteArrayOutputStream();     // Catch: Exception -> L124
        byte[] r37 = a.a;     // Catch: Exception -> L124
        monitor-enter(r37);     // Catch: Exception -> L124
    L257:
        byte[] r38 = a.a;     // Catch: Throwable -> L121
        int r114 = r35.read(r38);     // Catch: Throwable -> L121
        if (r114 <= 0) goto L118;
        r36.write(r38, 0, r114);     // Catch: Throwable -> L121
        goto L257
    L118:
        monitor-exit(r37);     // Catch: Throwable -> L121
        r35.close();     // Catch: Exception -> L124
        r36.close();     // Catch: Exception -> L124
        r27.a = new String(r36.toByteArray(), Charset.forName("UTF-8"));
        goto L131
    L121:
        th = move-exception;
        throw th;     // Catch: Exception -> L124
    L124:
        e = move-exception;
        throw new RuntimeException(e);
    L106:
        if (r32[r33] == 0) goto L110;
        throw new RuntimeException();
    L102:
        r113 = false;
        goto L103
    L129:
        throw new RuntimeException();
    L131:
        r4 = r2;
    L133:
        if (r19 > 0) goto L137;
        if (r4 > 0) goto L137;
        r4 = -1;
    L137:
        r4 = r4 + r19;
    L130:
        r19 = r19;
        goto L131
    L132:
        r19 = r19;
    L46:
        ChunkReader.ChunkReaderMode r115 = r7.a;
        if (r115 != ChunkReader.ChunkReaderMode.BUFFER) goto L53;
        byte[] r39 = r8.d;
        if (r39 == r5) goto L54;
        if (r19 <= 0) goto L54;
        System.arraycopy(r5, r6, r39, r16, r19);
    L54:
        r7.c += r19;
        r2 = r2 - r19;
        goto L55
    L53:
        if (r115 != ChunkReader.ChunkReaderMode.PROCESS) goto L54;
        throw new RuntimeException();
    L144:
        throw new RuntimeException();
    L138:
        if (r4 < 0) goto L139;
        r17.h += (long) r4;
        r4 = r4 + 0;
        goto L236
    L35:
        r14 = false;
    L145:
        int r40 = r17.c;
        int r41 = 8 - r40;
        if (r41 > r2) goto L149;
        r2 = r41;
    L149:
        System.arraycopy(r5, r6, r17.b, r40, r2);
        int r42 = r17.c + r2;
        r17.c = r42;
        int r43 = r2 + 0;
        r17.h += (long) r2;
        if (r42 != 8) goto L223;
        r17.g++;
        byte[] r44 = r17.b;
        byte[] r45 = a.a;
        int r46 = ((((r44[0] & 255) << 24) | ((r44[1] & 255) << 16)) | ((r44[2] & 255) << 8)) | (r44[3] & 255);
        if (r44.length >= 8) goto L154;
        String r47 = "?";
    L156:
        if ("IHDR".equals(r47) == false) goto L163;
        if (r17.i >= 0) goto L161;
        r17.i = 0;
    L259:
        if (r47.length() != 4) goto L220;
        if (a.b.matcher(r47).matches() == false) goto L220;
        if (r46 < 0) goto L218;
        long r48 = r46;
        if ((r17.h + r48) > 901001001) goto L216;
        if (Character.isUpperCase(r47.charAt(0)) == false) goto L203;
    L208:
        r9 = false;
    L210:
        if (r9 == false) goto L212;
        ChunkReader.ChunkReaderMode r49 = ChunkReader.ChunkReaderMode.SKIP;     // Catch: Exception -> L221
    L213:
        r17.k = new com.bytedance.android.livesdk.chatroom.utils.pngloader.a(r17, r46, r47, r49);     // Catch: Exception -> L221
        r17.c = 0;
        goto L223
    L212:
        r49 = ChunkReader.ChunkReaderMode.BUFFER;     // Catch: Exception -> L221
        goto L213
    L203:
        if (r48 > 2024024) goto L210;
        if (r48 <= (5024024 - r17.j)) goto L208;
    L216:
        throw new RuntimeException();     // Catch: Exception -> L221
    L218:
        throw new RuntimeException();     // Catch: Exception -> L221
    L220:
        throw new RuntimeException();     // Catch: Exception -> L221
    L222:
        throw new RuntimeException();
    L161:
        throw new RuntimeException("unexpected chunk ".concat(r47));
    L163:
        if ("PLTE".equals(r47) == false) goto L172;
        int r50 = r17.i;
        if (r50 == 0) goto L170;
        if (r50 == 1) goto L170;
        throw new RuntimeException("unexpected chunk here ".concat(r47));
    L170:
        r17.i = 2;
        goto L259
    L172:
        if ("IDAT".equals(r47) == false) goto L180;
        int r51 = r17.i;
        if (r51 < 0) goto L178;
        if (r51 > 4) goto L178;
        r17.i = 4;
    L178:
        throw new RuntimeException("unexpected chunk ".concat(r47));
    L180:
        if ("IEND".equals(r47) == true) goto L182;
        int r52 = r17.i;
        if (r52 > 1) goto L189;
        r17.i = 1;
        goto L259
    L189:
        if (r52 > 3) goto L191;
        r17.i = 3;
        goto L259
    L191:
        r17.i = 5;
        goto L259
    L182:
        if (r17.i < 4) goto L185;
        r17.i = 6;
        goto L259
    L185:
        throw new RuntimeException("unexpected chunk ".concat(r47));
    L154:
        r47 = new String(r44, 4, 4, Charset.forName("ISO-8859-1"));
    L223:
        r4 = r43;
        goto L236
    L224:
        int r53 = r17.a;
        int r54 = r17.c;
        int r55 = r53 - r54;
        if (r55 > r2) goto L228;
        r2 = r55;
    L228:
        System.arraycopy(r5, r6, r17.b, r54, r2);
        int r56 = r17.c + r2;
        r17.c = r56;
        if (r56 != r17.a) goto L235;
        byte[] r57 = r17.b;
        byte[] r58 = a.a;
        if (Arrays.equals(r57, new byte[]{-119, 80, 78, 71, 13, 10, 26, 10}) == false) goto L234;
        r17.c = 0;
        r17.d = true;
        goto L235
    L234:
        throw new RuntimeException();
    L235:
        r4 = 0 + r2;
        r17.h += (long) r2;
        goto L236
    L247:
        throw new RuntimeException();
    L236:
        if (r4 <= 0) goto L238;
        this.e += r4;
        this.d -= r4;
    L238:
        if (r4 <= 0) goto L241;
        return r4;
    L241:
        if (r17.e == false) goto L245;
        return -1;
    L245:
        throw new RuntimeException();
    L139:
        r4 = -1;
        goto L236
    L249:
        if (this.f == false) goto L255;
        if (r17.e == false) goto L266;
        return -1;
    L266:
        return 0;
    L255:
        throw new RuntimeException();
    L18:
        if (r2 >= this.d) goto L20;
    L5:
        if (this.f == true) goto L16;
        this.e = 0;     // Catch: IOException -> L13
        int r59 = this.b.read(this.c);     // Catch: IOException -> L13
        this.d = r59;     // Catch: IOException -> L13
        if (r59 == 0) goto L12;
        if (r59 >= 0) goto L16;
        close();     // Catch: IOException -> L13
        goto L16
    L12:
        throw new RuntimeException();     // Catch: IOException -> L13
    L13:
        e = move-exception;
        throw new RuntimeException(e);
    }
}
