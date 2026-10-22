package kn;

import com.lynx.base.log.LynxLog;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.TemplateData;
import com.lynx.tasm.base.TraceEvent;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.UByte;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f18686a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Charset f18687b = null;

    static {
        if (ByteOrder.nativeOrder() != ByteOrder.LITTLE_ENDIAN) goto L5;
        boolean r5 = true;
    L6:
        f18686a = r5;
        f18687b = Charset.forName("UTF8");
        return;
    L5:
        r5 = false;
        goto L6
    }

    public static Serializable a(ByteBuffer r10) {
        TraceEvent.c("LepusBuffer::DecodeMessage");
        if (r10 != null) goto L19;
        TraceEvent.a(0, "LepusBuffer::DecodeMessage");
        return null;
    L19:
        r10.order(ByteOrder.nativeOrder());     // Catch: IllegalArgumentException -> L10
        Serializable r5 = h(r10);     // Catch: IllegalArgumentException -> L10
        if (r10.hasRemaining() == true) goto L13;
        TraceEvent.a(0, "LepusBuffer::DecodeMessage");     // Catch: IllegalArgumentException -> L10
        return r5;
    L13:
        throw new IllegalArgumentException("Message corrupted");     // Catch: IllegalArgumentException -> L10
    L10:
        e = move-exception;
        LynxError r11 = new LynxError(e.toString(), -3);
        if (LynxEnv.inst().getLynxViewClient() == null) goto L17;
        LynxEnv.inst().getLynxViewClient().onReceivedError(r11);
    L17:
        TraceEvent.a(0, "LepusBuffer::DecodeMessage");
        return null;
    }

    public static ByteBuffer b(Object r10) {
        TraceEvent.c("LepusBuffer::EncodeMessage");
        if (r10 != null) goto L6;
        TraceEvent.a(0, "LepusBuffer::EncodeMessage");
        return null;
    L6:
        a r5 = new a();
        e(r5, r10, new LinkedList());     // Catch: IllegalArgumentException -> L10
        ByteBuffer r11 = ByteBuffer.allocateDirect(r5.size());
        r11.put(r5.b(), 0, r5.size());
        TraceEvent.a(0, "LepusBuffer::EncodeMessage");
        return r11;
    L10:
        e = move-exception;
        LynxError r12 = new LynxError(e.toString(), -3);
        LynxEnv.inst().getLynxViewClient().onReceivedError(r12);
        LynxLog.b(4, "LepusBuffer", r12.toString());
        TraceEvent.a(0, "LepusBuffer::EncodeMessage");
        return null;
    }

    public static void c(a r5, int r10) {
        if (r10 >= 254) goto L6;
        r5.write(r10);
        return;
    L6:
        boolean r11 = f18686a;
        if (r10 > 65535) goto L14;
        r5.write(254);
        if (r11 == false) goto L12;
        r5.write(r10);
        r5.write(r10 >>> 8);
        return;
    L12:
        r5.write(r10 >>> 8);
        r5.write(r10);
        return;
    L14:
        r5.write(255);
        if (r11 == false) goto L18;
        r5.write(r10);
        r5.write(r10 >>> 8);
        r5.write(r10 >>> 16);
        r5.write(r10 >>> 24);
        return;
    L18:
        r5.write(r10 >>> 24);
        r5.write(r10 >>> 16);
        r5.write(r10 >>> 8);
        r5.write(r10);
    }

    public static void d(a r10, long r11) {
        if (f18686a == false) goto L6;
        r10.write((byte) r11);
        r10.write((byte) (r11 >>> 8));
        r10.write((byte) (r11 >>> 16));
        r10.write((byte) (r11 >>> 24));
        r10.write((byte) (r11 >>> 32));
        r10.write((byte) (r11 >>> 40));
        r10.write((byte) (r11 >>> 48));
        r10.write((byte) (r11 >>> 56));
        return;
    L6:
        r10.write((byte) (r11 >>> 56));
        r10.write((byte) (r11 >>> 48));
        r10.write((byte) (r11 >>> 40));
        r10.write((byte) (r11 >>> 32));
        r10.write((byte) (r11 >>> 24));
        r10.write((byte) (r11 >>> 16));
        r10.write((byte) (r11 >>> 8));
        r10.write((byte) r11);
    }

    public static void e(a r10, Object r11, LinkedList r12) {
        int r5 = 0;
        if (r11 != null) goto L5;
    L119:
        r10.write(0);
        return;
    L5:
        if (r11.equals(null) == true) goto L119;
        if ((r11 instanceof Boolean) == false) goto L16;
        if (((Boolean) r11).booleanValue() == false) goto L12;
        int r13 = 1;
    L13:
        r10.write(r13);
        return;
    L12:
        r13 = 2;
        goto L13
    L16:
        if ((r11 instanceof Number) == false) goto L50;
        if ((r11 instanceof Integer) == false) goto L20;
    L43:
        r10.write(3);
        int r14 = ((Number) r11).intValue();
        if (f18686a == false) goto L47;
        r10.write(r14);
        r10.write(r14 >>> 8);
        r10.write(r14 >>> 16);
        r10.write(r14 >>> 24);
        return;
    L47:
        r10.write(r14 >>> 24);
        r10.write(r14 >>> 16);
        r10.write(r14 >>> 8);
        r10.write(r14);
        return;
    L20:
        if ((r11 instanceof Short) == true) goto L43;
        if ((r11 instanceof Byte) == true) goto L43;
        if ((r11 instanceof Long) == false) goto L29;
        r10.write(4);
        d(r10, ((Long) r11).longValue());
        return;
    L29:
        if ((r11 instanceof Float) == false) goto L31;
    L35:
        r10.write(5);
        int r15 = r10.size() % 8;
        if (r15 == 0) goto L41;
        int r16 = 0;
    L39:
        if (r16 >= (8 - r15)) goto L41;
        r10.write(0);
        r16 = r16 + 1;
    L41:
        d(r10, Double.doubleToLongBits(((Number) r11).doubleValue()));
        return;
    L31:
        if ((r11 instanceof Double) == true) goto L35;
        r10.write(0);
        LynxLog.b(4, "LepusBuffer", "Unsupported Number type: " + r11.getClass() + " value: " + r11);
        return;
    L50:
        if ((r11 instanceof String) == false) goto L54;
        r10.write(6);
        byte[] r17 = ((String) r11).getBytes(f18687b);
        c(r10, r17.length);
        r10.write(r17, 0, r17.length);
        return;
    L54:
        if ((r11 instanceof List) == false) goto L68;
        List r18 = (List) r11;
        if (r18.isEmpty() == false) goto L58;
    L61:
        r12.addLast(r11);
        r10.write(7);
        c(r10, r18.size());
        Iterator r19 = r18.iterator();
    L63:
        if (r19.hasNext() == false) goto L65;
        e(r10, r19.next(), r12);
        goto L63
    L65:
        r12.removeLast();
        return;
    L58:
        if (f(r12, r11) == false) goto L61;
        r10.write(0);
        new IllegalArgumentException("writeValue has cycle array!");
        return;
    L68:
        if ((r11 instanceof Map) == false) goto L82;
        Map r20 = (Map) r11;
        if (r20.isEmpty() == false) goto L72;
    L75:
        r12.addLast(r11);
        r10.write(8);
        c(r10, r20.size());
        Iterator r21 = r20.entrySet().iterator();
    L77:
        if (r21.hasNext() == false) goto L79;
        Map.Entry r22 = (Map.Entry) r21.next();
        e(r10, r22.getKey(), r12);
        e(r10, r22.getValue(), r12);
        goto L77
    L79:
        r12.removeLast();
        return;
    L72:
        if (f(r12, r11) == false) goto L75;
        r10.write(0);
        new IllegalArgumentException("writeValue has cycle dict!");
        return;
    L82:
        if ((r11 instanceof JSONObject) == false) goto L96;
        JSONObject r23 = (JSONObject) r11;
        if (r23.length() > 0) goto L86;
    L89:
        r12.addLast(r11);
        r10.write(8);
        c(r10, r23.length());
        Iterator<String> r24 = r23.keys();
    L91:
        if (r24.hasNext() == false) goto L93;
        String r25 = r24.next();
        e(r10, r25, r12);
        e(r10, r23.opt(r25), r12);
        goto L91
    L93:
        r12.removeLast();
        return;
    L86:
        if (f(r12, r11) == false) goto L89;
        r10.write(0);
        new IllegalArgumentException("writeValue has cycle JSONObject!");
        return;
    L96:
        if ((r11 instanceof JSONArray) == false) goto L110;
        JSONArray r26 = (JSONArray) r11;
        if (r26.length() > 0) goto L100;
    L103:
        r12.addLast(r11);
        r10.write(7);
        c(r10, r26.length());
    L105:
        if (r5 >= r26.length()) goto L107;
        e(r10, r26.opt(r5), r12);
        r5 = r5 + 1;
        goto L105
    L107:
        r12.removeLast();
        return;
    L100:
        if (f(r12, r11) == false) goto L103;
        r10.write(0);
        new IllegalArgumentException("writeValue has cycle JSONArray!");
        return;
    L110:
        if ((r11 instanceof byte[]) == false) goto L114;
        r10.write(9);
        byte[] r27 = (byte[]) r11;
        c(r10, r27.length);
        r10.write(r27, 0, r27.length);
        return;
    L114:
        if ((r11 instanceof TemplateData) == false) goto L117;
        TemplateData r28 = (TemplateData) r11;
        r28.k();
        r10.write(10);
        d(r10, r28.f10054a);
        return;
    L117:
        r10.write(0);
        LynxLog.b(4, "LepusBuffer", "Unsupported type: " + r11.getClass() + " value: " + r11);
    }

    public static boolean f(LinkedList r5, Object r10) {
        if (r10 != null) goto L5;
        return false;
    L5:
        Iterator r11 = r5.iterator();
    L7:
        if (r11.hasNext() == false) goto L12;
        if (r10 != r11.next()) goto L7;
        return true;
    L12:
        return false;
    }

    public static int g(ByteBuffer r5) {
        if (r5.hasRemaining() == false) goto L13;
        int r10 = r5.get() & UByte.MAX_VALUE;
        if (r10 >= 254) goto L7;
        return r10;
    L7:
        if (r10 != 254) goto L11;
        return r5.getChar();
    L11:
        return r5.getInt();
    L13:
        throw new IllegalArgumentException("Message corrupted");
    }

    public static Serializable h(ByteBuffer r5) {
        if (r5.hasRemaining() == false) goto L42;
        byte r10 = r5.get();
        if (r10 == 100) goto L39;
        int r11 = 0;
        switch(r10) {
            case 0: goto L45;
            case 1: goto L38;
            case 2: goto L36;
            case 3: goto L30;
            case 4: goto L25;
            case 5: goto L20;
            case 6: goto L18;
            case 7: goto L14;
            case 8: goto L10;
            default: goto L9;
        };
    L10:
        int r12 = g(r5);
        HashMap r13 = new HashMap();
    L11:
        if (r11 >= r12) goto L13;
        r13.put(h(r5), h(r5));
        r11 = r11 + 1;
        goto L11
    L13:
        return r13;
    L14:
        int r14 = g(r5);
        ArrayList r15 = new ArrayList(r14);
    L15:
        if (r11 >= r14) goto L17;
        r15.add(h(r5));
        r11 = r11 + 1;
        goto L15
    L17:
        return r15;
    L18:
        byte[] r16 = new byte[g(r5)];
        r5.get(r16);
        return new String(r16, f18687b);
    L20:
        int r17 = r5.position() % 8;
        if (r17 == 0) goto L24;
        r5.position((r5.position() + 8) - r17);
    L24:
        return Double.valueOf(r5.getDouble());
    L25:
        int r18 = r5.position() % 8;
        if (r18 == 0) goto L29;
        r5.position((r5.position() + 8) - r18);
    L29:
        return Long.valueOf(r5.getLong());
    L30:
        int r19 = r5.position() % 8;
        if (r19 == 0) goto L34;
        r5.position((r5.position() + 8) - r19);
    L34:
        return Integer.valueOf(r5.getInt());
    L45:
        return null;
    L9:
        throw new IllegalArgumentException("Message corrupted");
    L36:
        return Boolean.FALSE;
    L38:
        return Boolean.TRUE;
    L39:
        return null;
    L42:
        throw new IllegalArgumentException("Message corrupted");
    }
}
