package j7a;

import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.TemplateData;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a {
    public static final a a = null;
    public static final boolean b = false;
    public static final Charset c = null;

    /* JADX INFO: renamed from: j7a.a$a, reason: collision with other inner class name */
    public static final class C0094a extends ByteArrayOutputStream {
        public C0094a() {
        }

        public final byte[] a() {
            return ((ByteArrayOutputStream) this).buf;
        }
    }

    public a() {
    }

    static {
        a = new a();
        if (ByteOrder.nativeOrder() != ByteOrder.LITTLE_ENDIAN) goto L5;
        boolean r0 = true;
    L6:
        b = r0;
        c = Charset.forName("UTF8");
        return;
    L5:
        r0 = false;
        goto L6
    }

    public static Object a(ByteBuffer r4) {
        TraceEvent.beginSection("LepusBuffer::DecodeMessage");
        if (r4 != null) goto L18;
        TraceEvent.endSection("LepusBuffer::DecodeMessage");
        return null;
    L18:
        r4.order(ByteOrder.nativeOrder());     // Catch: IllegalArgumentException -> L12
        Object r2 = e(r4);     // Catch: IllegalArgumentException -> L12
        if (r4.hasRemaining() == true) goto L11;
        TraceEvent.endSection("LepusBuffer::DecodeMessage");     // Catch: IllegalArgumentException -> L12
        return r2;
    L11:
        throw new IllegalArgumentException("Message corrupted");     // Catch: IllegalArgumentException -> L12
    L12:
        e = move-exception;
        LynxError r3 = new LynxError(e.toString(), -3);
        if (LynxEnv.inst().getLynxViewClient() == null) goto L16;
        LynxEnv.inst().getLynxViewClient().onReceivedError(r3);
    L16:
        TraceEvent.endSection("LepusBuffer::DecodeMessage");
        return null;
    }

    public static ByteBuffer b(Object r4) {
        TraceEvent.beginSection("LepusBuffer::EncodeMessage");
        if (r4 != null) goto L6;
        TraceEvent.endSection("LepusBuffer::EncodeMessage");
        return null;
    L6:
        C0094a r2 = new C0094a();
        f(r2, r4, new LinkedList());     // Catch: IllegalArgumentException -> L10
        ByteBuffer r5 = ByteBuffer.allocateDirect(r2.size());
        r5.put(r2.a(), 0, r2.size());
        TraceEvent.endSection("LepusBuffer::EncodeMessage");
        return r5;
    L10:
        e = move-exception;
        LynxError r3 = new LynxError(e.toString(), -3);
        LynxEnv.inst().getLynxViewClient().onReceivedError(r3);
        LLog.e("LepusBuffer", r3.toString());
        TraceEvent.endSection("LepusBuffer::EncodeMessage");
        return null;
    }

    public static void c(ByteBuffer r2) {
        int r0 = r2.position() % 8;
        if (r0 == 0) goto L6;
        r2.position((r2.position() + 8) - r0);
        return;
    }

    public static int d(ByteBuffer r2) {
        if (r2.hasRemaining() == false) goto L13;
        int r0 = r2.get() & 255;
        if (r0 >= 254) goto L7;
        return r0;
    L7:
        if (r0 != 254) goto L11;
        return r2.getChar();
    L11:
        return r2.getInt();
    L13:
        throw new IllegalArgumentException("Message corrupted");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.util.HashMap] */
    public static Object e(ByteBuffer r5) {
        if (r5.hasRemaining() == false) goto L27;
        byte r0 = r5.get();
        if (r0 == 100) goto L24;
        int r2 = 0;
        switch(r0) {
            case 0: goto L24;
            case 1: goto L37;
            case 2: goto L36;
            case 3: goto L21;
            case 4: goto L20;
            case 5: goto L19;
            case 6: goto L18;
            case 7: goto L14;
            case 8: goto L11;
            case 9: goto L10;
            default: goto L9;
        };
    L10:
        byte[] r1 = new byte[d(r5)];
        r5.get(r1);
        return r1;
    L11:
        int r3 = d(r5);
        ?? r4 = new HashMap();
    L12:
        if (r2 >= r3) goto L31;
        r4.put(e(r5), e(r5));
        r2 = r2 + 1;
    L31:
        return r4;
    L14:
        int r6 = d(r5);
        r4 = new ArrayList(r6);
    L15:
        if (r2 >= r6) goto L31;
        r4.add(e(r5));
        r2 = r2 + 1;
        goto L15
    L18:
        byte[] r7 = new byte[d(r5)];
        r5.get(r7);
        return new String(r7, c);
    L19:
        c(r5);
        return Double.valueOf(r5.getDouble());
    L20:
        c(r5);
        return Long.valueOf(r5.getLong());
    L21:
        c(r5);
        return Integer.valueOf(r5.getInt());
    L9:
        throw new IllegalArgumentException("Message corrupted");
    L36:
        return Boolean.FALSE;
    L37:
        return Boolean.TRUE;
    L24:
        return null;
    L27:
        throw new IllegalArgumentException("Message corrupted");
    }

    public static boolean g(Collection<Object> r2, Object r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        Iterator<Object> r4 = r2.iterator();
    L7:
        if (r4.hasNext() == false) goto L12;
        if (r3 != r4.next()) goto L7;
        return true;
    L12:
        return false;
    }

    public static void h(C0094a r1, int r2) {
        if (b == false) goto L5;
        r1.write(r2);
        r1.write(r2 >>> 8);
        r1.write(r2 >>> 16);
        r1.write(r2 >>> 24);
        return;
    L5:
        r1.write(r2 >>> 24);
        r1.write(r2 >>> 16);
        r1.write(r2 >>> 8);
        r1.write(r2);
    }

    public static void i(C0094a r9, long r10) {
        if (b == false) goto L5;
        r9.write((byte) r10);
        r9.write((byte) (r10 >>> 8));
        r9.write((byte) (r10 >>> 16));
        r9.write((byte) (r10 >>> 24));
        r9.write((byte) (r10 >>> 32));
        r9.write((byte) (r10 >>> 40));
        r9.write((byte) (r10 >>> 48));
        r9.write((byte) (r10 >>> 56));
        return;
    L5:
        r9.write((byte) (r10 >>> 56));
        r9.write((byte) (r10 >>> 48));
        r9.write((byte) (r10 >>> 40));
        r9.write((byte) (r10 >>> 32));
        r9.write((byte) (r10 >>> 24));
        r9.write((byte) (r10 >>> 16));
        r9.write((byte) (r10 >>> 8));
        r9.write((byte) r10);
    }

    public static void j(C0094a r2, int r3) {
        if (r3 >= 254) goto L6;
        r2.write(r3);
        return;
    L6:
        if (r3 > 65535) goto L11;
        r2.write(254);
        if (b == false) goto L10;
        r2.write(r3);
        r2.write(r3 >>> 8);
        return;
    L10:
        r2.write(r3 >>> 8);
        r2.write(r3);
        return;
    L11:
        r2.write(255);
        h(r2, r3);
    }

    public static void f(C0094a r6, Object r7, LinkedList r8) {
        int r0 = 0;
        if (r7 != null) goto L5;
    L106:
        r6.write(0);
        return;
    L5:
        if (r7.equals(null) == true) goto L106;
        if ((r7 instanceof Boolean) == false) goto L15;
        if (((Boolean) r7).booleanValue() == false) goto L12;
        int r9 = 1;
    L13:
        r6.write(r9);
        return;
    L12:
        r9 = 2;
        goto L13
    L15:
        if ((r7 instanceof Number) == false) goto L41;
        if ((r7 instanceof Integer) == false) goto L19;
    L39:
        r6.write(3);
        h(r6, ((Number) r7).intValue());
        return;
    L19:
        if ((r7 instanceof Short) == true) goto L39;
        if ((r7 instanceof Byte) == true) goto L39;
        if ((r7 instanceof Long) == false) goto L27;
        r6.write(4);
        i(r6, ((Long) r7).longValue());
        return;
    L27:
        if ((r7 instanceof Float) == false) goto L29;
    L32:
        r6.write(5);
        int r10 = r6.size() % 8;
        if (r10 == 0) goto L38;
        int r1 = 0;
    L36:
        if (r1 >= (8 - r10)) goto L38;
        r6.write(0);
        r1 = r1 + 1;
    L38:
        i(r6, Double.doubleToLongBits(((Number) r7).doubleValue()));
        return;
    L29:
        if ((r7 instanceof Double) == true) goto L32;
        r6.write(0);
        LLog.e("LepusBuffer", "Unsupported Number type: " + r7.getClass() + " value: " + r7);
        return;
    L41:
        if ((r7 instanceof String) == false) goto L44;
        r6.write(6);
        byte[] r11 = ((String) r7).getBytes(c);
        j(r6, r11.length);
        r6.write(r11, 0, r11.length);
        return;
    L44:
        if ((r7 instanceof List) == false) goto L57;
        List r2 = (List) r7;
        if (r2.isEmpty() == false) goto L48;
    L51:
        r8.addLast(r7);
        r6.write(7);
        j(r6, r2.size());
        Iterator r12 = r2.iterator();
    L53:
        if (r12.hasNext() == false) goto L55;
        f(r6, r12.next(), r8);
        goto L53
    L55:
        r8.removeLast();
        return;
    L48:
        if (g(r8, r7) == false) goto L51;
        r6.write(0);
        LLog.DTHROW(new IllegalArgumentException("writeValue has cycle array!"));
        return;
    L57:
        if ((r7 instanceof Map) == false) goto L70;
        Map r3 = (Map) r7;
        if (r3.isEmpty() == false) goto L61;
    L64:
        r8.addLast(r7);
        r6.write(8);
        j(r6, r3.size());
        Iterator r13 = r3.entrySet().iterator();
    L66:
        if (r13.hasNext() == false) goto L68;
        Map.Entry r4 = (Map.Entry) r13.next();
        f(r6, r4.getKey(), r8);
        f(r6, r4.getValue(), r8);
        goto L66
    L68:
        r8.removeLast();
        return;
    L61:
        if (g(r8, r7) == false) goto L64;
        r6.write(0);
        LLog.DTHROW(new IllegalArgumentException("writeValue has cycle dict!"));
        return;
    L70:
        if ((r7 instanceof JSONObject) == false) goto L83;
        JSONObject r5 = (JSONObject) r7;
        if (r5.length() > 0) goto L74;
    L77:
        r8.addLast(r7);
        r6.write(8);
        j(r6, r5.length());
        Iterator<String> r14 = r5.keys();
    L79:
        if (r14.hasNext() == false) goto L81;
        String r15 = r14.next();
        f(r6, r15, r8);
        f(r6, r5.opt(r15), r8);
        goto L79
    L81:
        r8.removeLast();
        return;
    L74:
        if (g(r8, r7) == false) goto L77;
        r6.write(0);
        LLog.DTHROW(new IllegalArgumentException("writeValue has cycle JSONObject!"));
        return;
    L83:
        if ((r7 instanceof JSONArray) == false) goto L100;
        JSONArray r16 = (JSONArray) r7;
        if (r16.length() > 0) goto L87;
    L90:
        r8.addLast(r7);
        r6.write(7);
        j(r6, r16.length());
    L92:
        if (r0 >= r16.length()) goto L98;
        f(r6, r16.opt(r0), r8);     // Catch: Throwable -> L96
        r0 = r0 + 1;
    L96:
        th = move-exception;
        throw th;
    L98:
        r8.removeLast();
        return;
    L87:
        if (g(r8, r7) == false) goto L90;
        r6.write(0);
        LLog.DTHROW(new IllegalArgumentException("writeValue has cycle JSONArray!"));
        return;
    L100:
        if ((r7 instanceof byte[]) == false) goto L103;
        r6.write(9);
        byte[] r17 = (byte[]) r7;
        j(r6, r17.length);
        r6.write(r17, 0, r17.length);
        return;
    L103:
        if ((r7 instanceof TemplateData) == false) goto L105;
        TemplateData r18 = (TemplateData) r7;
        r18.flush();
        r6.write(10);
        i(r6, r18.getNativePtr());
        return;
    L105:
        r6.write(0);
        LLog.e("LepusBuffer", "Unsupported type: " + r7.getClass() + " value: " + r7);
    }
}
