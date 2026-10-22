package com.lynx.tasm.recording;

import android.os.SystemClock;
import android.view.Choreographer;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableMapKeySetIterator;
import com.lynx.react.bridge.ReadableType;
import com.lynx.react.bridge.mapbuffer.MapBuffer;
import com.lynx.react.bridge.mapbuffer.ReadableMapBuffer;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.behavior.s0;
import com.lynx.tasm.behavior.ui.PropBundle;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.mammon.speechaudiosdk.session.type.SpeechEvent;
import com.miui.easygo.constant.EasyGoDbTable;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class LynxFrameRecorder {
    public static final LynxFrameRecorder k = null;
    public final ExecutorService a;
    public final ConcurrentHashMap<Integer, Integer> b;
    public final ConcurrentHashMap<Integer, Integer> c;
    public final ConcurrentHashMap<Integer, Integer> d;
    public final ConcurrentHashMap<Integer, c> e;
    public final ConcurrentHashMap<Integer, d> f;
    public final ConcurrentHashMap<Integer, Float> g;
    public final Map<Integer, i> h;
    public final Map<Integer, k> i;
    public final AtomicInteger j;

    public static final enum ByteReplayMask extends Enum<ByteReplayMask> {
        public static final ByteReplayMask IGNORE = null;
        public static final ByteReplayMask NAME = null;
        public static final ByteReplayMask NONE = null;
        public static final ByteReplayMask STRICT = null;
        public static final ByteReplayMask TRUE = null;
        public static final /* synthetic */ ByteReplayMask[] a = null;

        static {
            ByteReplayMask r0 = new ByteReplayMask("NONE", 0);
            NONE = r0;
            ByteReplayMask r1 = new ByteReplayMask("TRUE", 1);
            TRUE = r1;
            ByteReplayMask r3 = new ByteReplayMask("IGNORE", 2);
            IGNORE = r3;
            ByteReplayMask r5 = new ByteReplayMask("NAME", 3);
            NAME = r5;
            ByteReplayMask r7 = new ByteReplayMask("STRICT", 4);
            STRICT = r7;
            a = new ByteReplayMask[]{r0, r1, r3, r5, r7};
        }

        public static ByteReplayMask[] values() {
            return (ByteReplayMask[]) a.clone();
        }

        public static ByteReplayMask valueOf(String r1) {
            return (ByteReplayMask) r27.a.a(ByteReplayMask.class, r1);
        }

        public ByteReplayMask(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[ByteReplayMask.values().length];
            b = r0;
            r0[ByteReplayMask.TRUE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L27
        L67:
            b[ByteReplayMask.IGNORE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L28
        L51:
            b[ByteReplayMask.NAME.ordinal()] = 3;     // Catch: NoSuchFieldError -> L29
        L63:
            b[ByteReplayMask.STRICT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L30
        L69:
            b[ByteReplayMask.NONE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L31
        L12:
            int[] r5 = new int[ReadableType.values().length];
            a = r5;
            r5[ReadableType.Null.ordinal()] = 1;     // Catch: NoSuchFieldError -> L32
        L73:
            a[ReadableType.Boolean.ordinal()] = 2;     // Catch: NoSuchFieldError -> L33
        L79:
            a[ReadableType.Int.ordinal()] = 3;     // Catch: NoSuchFieldError -> L34
        L47:
            a[ReadableType.Long.ordinal()] = 4;     // Catch: NoSuchFieldError -> L35
        L57:
            a[ReadableType.Number.ordinal()] = 5;     // Catch: NoSuchFieldError -> L36
        L77:
            a[ReadableType.String.ordinal()] = 6;     // Catch: NoSuchFieldError -> L37
        L45:
            a[ReadableType.Map.ordinal()] = 7;     // Catch: NoSuchFieldError -> L38
        L71:
            a[ReadableType.Array.ordinal()] = 8;     // Catch: NoSuchFieldError -> L39
        L75:
            a[ReadableType.ByteArray.ordinal()] = 9;     // Catch: NoSuchFieldError -> L40
        L59:
            a[ReadableType.ByteBuffer.ordinal()] = 10;     // Catch: NoSuchFieldError -> L41
        L65:
            a[ReadableType.PiperData.ordinal()] = 11;     // Catch: NoSuchFieldError -> L42
        L53:
            a[ReadableType.TemplateData.ordinal()] = 12;     // Catch: NoSuchFieldError -> L43
        L55:
            a[ReadableType.LynxObject.ordinal()] = 13;     // Catch: NoSuchFieldError -> L44
            return;
        }
    }

    public static final class b {
        public final int a;
        public final String b;
        public final Map<String, Object> c;
        public final Map<String, Object> d;

        public b() {
            throw null;
        }

        public b(int r1, String r2, Map r3, Map r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public static final class c {
        public final int a;
        public final Deque<JSONObject> b;

        public c() {
            this.b = new ArrayDeque();
            this.a = 1024;
        }

        public static void a(c r2, JSONObject r3) {
            monitor-enter(r2);
        L13:
            th = move-exception;
            throw th;
        L4:
            if (r2.a > 0) goto L8;
            monitor-exit(r2);
            return;
        L8:
            if (((ArrayDeque) r2.b).size() < r2.a) goto L10;
            ((ArrayDeque) r2.b).removeFirst();     // Catch: Throwable -> L13
        L10:
            ((ArrayDeque) r2.b).addLast(r3);     // Catch: Throwable -> L13
            monitor-exit(r2);
        }
    }

    public interface d {
        void a(JSONObject r1);
    }

    public static final class e {
        public final int a;
        public final String b;
        public final Map<String, Object> c;
        public final Map<String, Object> d;
        public final int e;
        public final int f;
        public final float g;
        public final float h;
        public final float i;
        public final float j;
        public final float[] k;
        public final float[] l;
        public final float[] m;
        public final float[] n;
        public final float[] o;
        public final float p;
        public final String q;

        public e() {
            throw null;
        }

        public e(int r3, String r4, Map r5, Map r6, int r7, int r8, float r9, float r10, float r11, float r12, float[] r13, float[] r14, float[] r15, float[] r16, float[] r17, float r18, String r19) {
            this.a = r3;
            this.b = r4;
            this.c = r5;
            this.d = r6;
            this.e = r7;
            this.f = r8;
            this.g = r9;
            this.h = r10;
            this.i = r11;
            this.j = r12;
            this.k = r13;
            this.l = r14;
            this.m = r15;
            this.n = r16;
            this.o = r17;
            this.p = r18;
            this.q = r19;
        }
    }

    public static final class f {
        public final int a;
        public final String b;
        public final Map<String, Object> c;

        public f() {
            throw null;
        }

        public f(int r1, String r2, Map r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class g {
        public String a;
        public int b;
        public final List<Integer> c;
        public ByteReplayMask d;
        public boolean e;

        public g() {
            this.b = -1;
            this.c = new ArrayList();
            this.d = ByteReplayMask.NONE;
            this.e = false;
        }
    }

    public static final class h {
        public final int a;
        public final int b;
        public final Integer c;

        public h(int r1, int r2, Integer r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class i {
        public final int a;
        public List<p> b;
        public boolean c;
        public Choreographer.FrameCallback d;

        public i(int r2) {
            this.b = new ArrayList();
            this.c = false;
            this.d = null;
            this.a = r2;
        }
    }

    public static final class j implements ThreadFactory {
        public final AtomicInteger a;

        public j() {
            this.a = new AtomicInteger(1);
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable r4) {
            PthreadThreadV2 r0 = new PthreadThreadV2(r4, "lynx-frame-recorder-" + this.a.getAndIncrement());
            ThreadMethodProxy.setPriority(r0, 4);
            return r0;
        }
    }

    public static final class k {
        public final int a;
        public final Map<Integer, g> b;

        public k(int r2) {
            this.b = new HashMap();
            this.a = r2;
        }

        public final void a(int r3) {
            Map<Integer, g> r0 = this.b;
            HashMap r1 = (HashMap) r0;
            g r2 = (g) r1.get(Integer.valueOf(r3));
            if (r2 != null) goto L5;
            return;
        L5:
            Iterator r4 = new ArrayList(r2.c).iterator();
        L7:
            if (r4.hasNext() == false) goto L9;
            a(((Integer) r4.next()).intValue());
            goto L7
        L9:
            b(r3);
            Map<Integer, g> r5 = this.b;
            HashMap r6 = (HashMap) r5;
            r6.remove(Integer.valueOf(r3));
        }

        public final void b(int r4) {
            Map<Integer, g> r0 = this.b;
            HashMap r1 = (HashMap) r0;
            g r2 = (g) r1.get(Integer.valueOf(r4));
            if (r2 == null) goto L12;
            int r3 = r2.b;
            if (r3 < 0) goto L13;
            Map<Integer, g> r5 = this.b;
            HashMap r6 = (HashMap) r5;
            g r7 = (g) r6.get(Integer.valueOf(r3));
            if (r7 == null) goto L10;
            List<Integer> r8 = r7.c;
            ArrayList r9 = (ArrayList) r8;
            r9.remove(Integer.valueOf(r4));
        L10:
            r2.b = -1;
            return;
        L13:
            return;
        }

        public final g d(int r3) {
            Map<Integer, g> r0 = this.b;
            HashMap r1 = (HashMap) r0;
            g r2 = (g) r1.get(Integer.valueOf(r3));
            if (r2 != null) goto L6;
            g r4 = new g();
            Map<Integer, g> r5 = this.b;
            HashMap r6 = (HashMap) r5;
            r6.put(Integer.valueOf(r3), r4);
            return r4;
        L6:
            return r2;
        }

        public final Integer e(int r2) {
            Map<Integer, g> r0 = this.b;
            HashMap r1 = (HashMap) r0;
            g r3 = (g) r1.get(Integer.valueOf(r2));
            if (r3 == null) goto L11;
            int r4 = r3.b;
            if (r4 >= 0) goto L7;
            return null;
        L7:
            if (g(r4) == false) goto L10;
            return null;
        L10:
            return Integer.valueOf(r3.b);
        L11:
            return null;
        }

        public final boolean f(int r7) {
            g r0 = (g) ((HashMap) this.b).get(Integer.valueOf(r7));
            if (r0 != null) goto L5;
        L9:
            boolean r1 = false;
        L10:
            if (r1 == true) goto L49;
            g r2 = (g) ((HashMap) this.b).get(Integer.valueOf(r7));
            if (r2 == null) goto L47;
            String r3 = r2.a;
            LynxFrameRecorder r4 = LynxFrameRecorder.k;
            if ("image".equals(r3) == false) goto L16;
        L25:
            boolean r5 = true;
        L26:
            if (r5 == false) goto L47;
            Integer r6 = Integer.valueOf(r7);
            int r8 = ((HashMap) this.b).size() + 1;
        L28:
            if (r6 == null) goto L42;
            int r9 = r8 - 1;
            if (r8 <= 0) goto L42;
            g r10 = (g) ((HashMap) this.b).get(r6);
            if (r10 == null) goto L42;
            if (r10.d == ByteReplayMask.STRICT) goto L36;
            int r11 = r10.b;
            if (r11 < 0) goto L40;
            r6 = Integer.valueOf(r11);
        L41:
            r8 = r9;
            goto L28
        L40:
            r6 = null;
            goto L41
        L36:
            boolean r12 = true;
        L43:
            if (r12 == false) goto L47;
            if (g(r7) == true) goto L47;
            boolean r13 = true;
        L48:
            if (r13 == true) goto L49;
            return false;
        L42:
            r12 = false;
            goto L43
        L16:
            if ("inline-image".equals(r3) == true) goto L25;
            if (LynxResourceModule.VIDEO_TYPE.equals(r3) == true) goto L25;
            if (LynxResourceModule.AUDIO_TYPE.equals(r3) == true) goto L25;
            if ("x-video-engine".equals(r3) == true) goto L25;
            r5 = false;
        L47:
            r13 = false;
        L49:
            return true;
        L5:
            if (r0.d != ByteReplayMask.IGNORE) goto L9;
            if (g(r7) == true) goto L9;
            r1 = true;
            goto L10
        }

        public final boolean g(int r6) {
            g r7 = (g) ((HashMap) this.b).get(Integer.valueOf(r6));
            if (r7 != null) goto L5;
            return false;
        L5:
            int r8 = r7.b;
            if (r8 < 0) goto L8;
            Integer r9 = Integer.valueOf(r8);
        L9:
            int r2 = ((HashMap) this.b).size() + 1;
        L10:
            if (r9 == null) goto L24;
            int r4 = r2 - 1;
            if (r2 <= 0) goto L24;
            if (f(r9.intValue()) == true) goto L15;
            g r10 = (g) ((HashMap) this.b).get(r9);
            if (r10 == null) goto L18;
            int r11 = r10.b;
            if (r11 < 0) goto L22;
            r9 = Integer.valueOf(r11);
        L23:
            r2 = r4;
            goto L10
        L22:
            r9 = null;
            goto L23
        L18:
            return false;
        L15:
            return true;
        L24:
            return false;
        L8:
            r9 = null;
            goto L9
        }

        public final boolean i(int r5) {
            g r0 = (g) ((HashMap) this.b).get(Integer.valueOf(r5));
            if (r0 != null) goto L5;
        L7:
            if (r0 != null) goto L9;
        L11:
            Integer r6 = Integer.valueOf(r5);
            int r1 = ((HashMap) this.b).size() + 1;
        L13:
            if (r6 == null) goto L29;
            int r3 = r1 - 1;
            if (r1 <= 0) goto L29;
            g r7 = (g) ((HashMap) this.b).get(r6);
            if (r7 == null) goto L29;
            ByteReplayMask r2 = r7.d;
            if (r2 == ByteReplayMask.TRUE) goto L38;
            if (r2 == ByteReplayMask.STRICT) goto L39;
            int r8 = r7.b;
            if (r8 < 0) goto L27;
            r6 = Integer.valueOf(r8);
        L28:
            r1 = r3;
            goto L13
        L27:
            r6 = null;
            goto L28
        L39:
            return true;
        L38:
            return true;
        L29:
            return false;
        L9:
            if (r0.d != ByteReplayMask.NAME) goto L11;
            return true;
        L5:
            if (r0.e == false) goto L7;
            return true;
        }

        public final Map<String, Object> c(int r10, Map<String, Object> r11) {
            Map<Integer, g> r0 = this.b;
            HashMap r1 = (HashMap) r0;
            g r12 = (g) r1.get(Integer.valueOf(r10));
            LynxFrameRecorder r2 = LynxFrameRecorder.k;
            if (r11 != null) goto L11;
            if (r12 != null) goto L6;
            ByteReplayMask r13 = ByteReplayMask.NONE;
        L7:
            String r14 = LynxFrameRecorder.f(r13);
            if (r14 != null) goto L10;
            return null;
        L10:
            LinkedHashMap r15 = new LinkedHashMap();
            r15.put("lynx-data-bytereplay-mask", r14);
            LinkedHashMap r16 = new LinkedHashMap();
            r16.put("props", Collections.unmodifiableMap(r15));
            return Collections.unmodifiableMap(r16);
        L6:
            r13 = r12.d;
            goto L7
        L11:
            LinkedHashMap r3 = new LinkedHashMap(r11);
            Map<String, Object> r17 = LynxFrameRecorder.h(r11);
            if (r17 == null) goto L51;
            LinkedHashMap r4 = new LinkedHashMap();
            Iterator<Map.Entry<String, Object>> r18 = r17.entrySet().iterator();
        L15:
            if (r18.hasNext() == false) goto L41;
            Map.Entry<String, Object> r5 = r18.next();
            String r6 = r5.getKey();
            Object r7 = r5.getValue();
            boolean r8 = true;
            if (LynxFrameRecorder.j(r6) == false) goto L19;
        L34:
            if (r8 == true) goto L36;
            r4.put(r6, r7);
            goto L15
        L36:
            if ((r7 instanceof CharSequence) == false) goto L38;
            String r9 = LynxFrameRecorder.m(String.valueOf(r7));
        L39:
            r4.put(r6, r9);
            goto L15
        L38:
            r9 = "*";
            goto L39
        L19:
            if (LynxError.LYNX_ERROR_KEY_RESOURCE_URL.equals(r6) == false) goto L21;
        L30:
            boolean r19 = true;
        L31:
            if (r19 == true) goto L34;
            r8 = false;
            goto L34
        L21:
            if ("source".equals(r6) == true) goto L30;
            if (LynxEventReporter.PROP_NAME_URL.equals(r6) == true) goto L30;
            if (LynxResourceModule.URI_KEY.equals(r6) == true) goto L30;
            if ("poster".equals(r6) == true) goto L30;
            r19 = false;
            goto L31
        L41:
            if (r12 != null) goto L43;
            ByteReplayMask r110 = ByteReplayMask.NONE;
        L44:
            String r111 = LynxFrameRecorder.f(r110);
            if (r111 != null) goto L47;
        L49:
            r3.put("props", Collections.unmodifiableMap(r4));
            goto L51
        L47:
            if (r4.containsKey("lynx-data-bytereplay-mask") == true) goto L49;
            r4.put("lynx-data-bytereplay-mask", r111);
            goto L49
        L43:
            r110 = r12.d;
        L51:
            return Collections.unmodifiableMap(r3);
        }

        public final void h(int r3, int r4) {
            g r0 = d(r3);
            b(r3);
            r0.b = r4;
            if (r4 < 0) goto L8;
            g r5 = d(r4);
            List<Integer> r1 = r5.c;
            ArrayList r2 = (ArrayList) r1;
            if (r2.contains(Integer.valueOf(r3)) == true) goto L9;
            List<Integer> r6 = r5.c;
            ArrayList r7 = (ArrayList) r6;
            r7.add(Integer.valueOf(r3));
            return;
        L9:
            return;
        }

        public static void j(g r4, Map r5, boolean r6) {
            boolean r0 = true;
            boolean r2 = false;
            if (r6 == true) goto L11;
            Map<String, Object> r3 = LynxFrameRecorder.h(r5);
            if (r3 != null) goto L7;
        L9:
            boolean r7 = false;
        L10:
            if (r7 == true) goto L11;
        L31:
            String r1 = r4.a;
            if ("input".equals(r1) == false) goto L34;
        L37:
            boolean r8 = true;
        L38:
            if (r8 == true) goto L40;
            r4.e = false;
            return;
        L40:
            if (r6 == true) goto L48;
            Map<String, Object> r9 = LynxFrameRecorder.h(r5);
            if (r9 != null) goto L44;
        L46:
            r0 = false;
        L47:
            if (r0 == true) goto L48;
            return;
        L44:
            if (r9.containsKey("type") == false) goto L46;
        L48:
            Map<String, Object> r10 = LynxFrameRecorder.h(r5);
            if (r10 == null) goto L52;
            r2 = "password".equals(r10.get("type"));
        L52:
            r4.e = r2;
            return;
        L34:
            if ("x-input".equals(r1) == true) goto L37;
            r8 = false;
            goto L38
        L7:
            if (r3.containsKey("lynx-data-bytereplay-mask") == false) goto L9;
            r7 = true;
        L11:
            Map<String, Object> r11 = LynxFrameRecorder.h(r5);
            if (r11 != null) goto L14;
            ByteReplayMask r12 = ByteReplayMask.NONE;
        L30:
            r4.d = r12;
            goto L31
        L14:
            Object r13 = r11.get("lynx-data-bytereplay-mask");
            if (r13 != null) goto L17;
            r12 = ByteReplayMask.NONE;
            goto L30
        L17:
            String r14 = String.valueOf(r13);
            if ("true".equals(r14) == false) goto L21;
            r12 = ByteReplayMask.TRUE;
            goto L30
        L21:
            if ("ignore".equals(r14) == false) goto L24;
            r12 = ByteReplayMask.IGNORE;
            goto L30
        L24:
            if (EasyGoDbTable.Server.NAME.equals(r14) == false) goto L27;
            r12 = ByteReplayMask.NAME;
            goto L30
        L27:
            if ("strict".equals(r14) == false) goto L29;
            r12 = ByteReplayMask.STRICT;
            goto L30
        L29:
            r12 = ByteReplayMask.NONE;
            goto L30
        }
    }

    public final class l implements Choreographer.FrameCallback {
        public final int a;
        public final int b;
        public final /* synthetic */ LynxFrameRecorder c;

        @Override // android.view.Choreographer.FrameCallback
        public final void doFrame(final long r3) {
            this.c.a.execute(new com.lynx.tasm.recording.j(this, r3));
        }

        public l(LynxFrameRecorder r1, int r2, int r3) {
            this.c = r1;
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class m {
        public final List<n> a;

        public m() {
            throw null;
        }

        public m(List r1) {
            this.a = r1;
        }
    }

    public static final class n {
        public final float a;
        public final float b;
        public final int c;
        public final Integer d;

        public n(float r1, float r2, int r3, Integer r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public static final class o {
        public final List<p> a;
        public final Float b;

        public o() {
            throw null;
        }

        public o(List r1, Float r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class p {
        public final int a;
        public final Object b;
        public final long c;

        public p(int r1, Object r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class q {
        public final int a;
        public final String b;
        public final String c;

        public q(int r1, String r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class r {
        public final int a;
        public final String b;
        public final int c;
        public final int d;

        public r(int r1, String r2, int r3, int r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public static final class s {
        public final int a;
        public final float b;
        public final float c;
        public final float d;
        public final float e;
        public final float[] f;
        public final float[] g;
        public final float[] h;
        public final float[] i;
        public final float[] j;
        public final float k;

        public s(int r1, float r2, float r3, float r4, float r5, float[] r6, float[] r7, float[] r8, float[] r9, float[] r10, float r11) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
            this.i = r9;
            this.j = r10;
            this.k = r11;
        }
    }

    public static final class t {
        public final int a;
        public final Boolean b;
        public final Map<String, Object> c;
        public final Map<String, Object> d;

        public t() {
            throw null;
        }

        public t(int r1, Boolean r2, Map r3, Map r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    static {
        k = new LynxFrameRecorder();
    }

    public LynxFrameRecorder() {
        j r0 = new j();
        this.b = new ConcurrentHashMap();
        this.c = new ConcurrentHashMap();
        this.d = new ConcurrentHashMap();
        this.e = new ConcurrentHashMap();
        this.f = new ConcurrentHashMap();
        this.g = new ConcurrentHashMap();
        this.h = new HashMap();
        this.i = new HashMap();
        this.j = new AtomicInteger(1);
        this.a = PThreadExecutorsUtils.newSingleThreadExecutor(r0);
    }

    public static Map<String, Object> A(Object r3) {
        if ((r3 instanceof Map) == true) goto L6;
        return null;
    L6:
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator r4 = ((Map) r3).entrySet().iterator();
    L8:
        if (r4.hasNext() == false) goto L12;
        Map.Entry r1 = (Map.Entry) r4.next();
        Object r2 = r1.getKey();
        if (r2 == null) goto L8;
        r0.put(String.valueOf(r2), r1.getValue());
        goto L8
    L12:
        return r0;
    }

    public static float[] b(float[] r0) {
        if (r0 != null) goto L5;
        return null;
    L5:
        return (float[]) r0.clone();
    }

    public static String f(ByteReplayMask r1) {
        int r2 = a.b[r1.ordinal()];
        if (r2 != 1) goto L5;
        return "true";
    L5:
        if (r2 != 2) goto L7;
        return "ignore";
    L7:
        if (r2 != 3) goto L9;
        return EasyGoDbTable.Server.NAME;
    L9:
        if (r2 == 4) goto L12;
        return null;
    L12:
        return "strict";
    }

    public static Map<String, Object> h(Map<String, Object> r1) {
        if (r1 != null) goto L5;
        return null;
    L5:
        return A(r1.get("props"));
    }

    public static boolean j(String r1) {
        if ("value".equals(r1) == false) goto L5;
    L12:
        return true;
    L5:
        if ("text".equals(r1) == true) goto L12;
        if ("default-value".equals(r1) == true) goto L12;
        if ("defaultValue".equals(r1) == true) goto L12;
        return false;
    }

    public static String m(String r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        int r1 = 0;
        int r4 = r3.codePointCount(0, r3.length());
        StringBuilder r0 = new StringBuilder(r4);
    L6:
        if (r1 >= r4) goto L9;
        r0.append("*");
        r1 = r1 + 1;
        goto L6
    L9:
        return r0.toString();
    }

    public static Map<String, Object> q(Map<String, Object> r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator<Map.Entry<String, Object>> r5 = r4.entrySet().iterator();
    L7:
        if (r5.hasNext() == false) goto L17;
        Map.Entry<String, Object> r1 = r5.next();
        String r2 = r1.getKey();
        Object r3 = r1.getValue();
        if (j(r2) == true) goto L11;
        r0.put(r2, r(r3));
        goto L7
    L11:
        if ((r3 instanceof CharSequence) == false) goto L13;
        String r6 = m(String.valueOf(r3));
    L14:
        r0.put(r2, r6);
        goto L7
    L13:
        r6 = "*";
        goto L14
    L17:
        return Collections.unmodifiableMap(r0);
    }

    public static Object r(Object r4) {
        Map<String, Object> r0 = A(r4);
        if (r0 == null) goto L7;
        return q(r0);
    L7:
        if ((r4 instanceof Iterable) == false) goto L14;
        ArrayList r1 = new ArrayList();
        Iterator r5 = ((Iterable) r4).iterator();
    L10:
        if (r5.hasNext() == false) goto L13;
        r1.add(r(r5.next()));
        goto L10
    L13:
        return Collections.unmodifiableList(r1);
    L14:
        if (r4 != null) goto L16;
        return r4;
    L16:
        if (r4.getClass().isArray() == false) goto L25;
        ArrayList r2 = new ArrayList();
        int r3 = Array.getLength(r4);
        int r6 = 0;
    L18:
        if (r6 >= r3) goto L21;
        r2.add(r(Array.get(r4, r6)));
        r6 = r6 + 1;
        goto L18
    L21:
        return Collections.unmodifiableList(r2);
    L25:
        return r4;
    }

    public static Object s(f6a.a r3) {
        if (r3 != null) goto L5;
    L30:
        return null;
    L5:
        if (r3.isNull() == true) goto L30;
        ReadableType r1 = r3.getType();
        switch(a.a[r1.ordinal()]) {
            case 1: goto L30;
            case 2: goto L29;
            case 3: goto L27;
            case 4: goto L25;
            case 5: goto L23;
            case 6: goto L21;
            case 7: goto L19;
            case 8: goto L17;
            case 9: goto L11;
            default: goto L10;
        };
    L11:
        byte[] r4 = r3.asByteArray();
        if (r4 != null) goto L15;
        return null;
    L15:
        return (byte[]) r4.clone();
    L10:
        return String.valueOf(r3);
    L17:
        return u(r3.asArray());
    L19:
        return v(r3.asMap());
    L21:
        return r3.asString();
    L23:
        return Double.valueOf(r3.asDouble());
    L25:
        return Long.valueOf(r3.asLong());
    L27:
        return Integer.valueOf(r3.asInt());
    L29:
        return Boolean.valueOf(r3.asBoolean());
    }

    public static Map<String, Object> t(PropBundle r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("props", v(r3.getProps()));
        r0.put("eventHandlers", u(r3.getEventHandlers()));
        r0.put("gestures", u(r3.getGestures()));
        return Collections.unmodifiableMap(r0);
    }

    public static List<Object> u(ReadableArray r6) {
        if (r6 != null) goto L5;
        return null;
    L5:
        ArrayList r1 = new ArrayList(r6.size());
        int r2 = r6.size();
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L25;
        switch(a.a[r6.getType(r3).ordinal()]) {
            case 1: goto L22;
            case 2: goto L21;
            case 3: goto L20;
            case 4: goto L19;
            case 5: goto L18;
            case 6: goto L17;
            case 7: goto L16;
            case 8: goto L15;
            case 9: goto L11;
            case 10: goto L9;
            case 11: goto L10;
            default: goto L9;
        };
    L9:
        Object r4 = s(r6.getDynamic(r3));
    L23:
        r1.add(r4);
        r3 = r3 + 1;
        goto L6
    L10:
        r4 = String.valueOf(r6.getPiperData(r3));
        goto L23
    L11:
        byte[] r5 = r6.getByteArray(r3);
        if (r5 == null) goto L22;
        r4 = (byte[]) r5.clone();
        goto L23
    L15:
        r4 = u(r6.getArray(r3));
        goto L23
    L16:
        r4 = v(r6.getMap(r3));
        goto L23
    L17:
        r4 = r6.getString(r3);
        goto L23
    L18:
        r4 = Double.valueOf(r6.getDouble(r3));
        goto L23
    L19:
        r4 = Long.valueOf(r6.getLong(r3));
        goto L23
    L20:
        r4 = Integer.valueOf(r6.getInt(r3));
        goto L23
    L21:
        r4 = Boolean.valueOf(r6.getBoolean(r3));
    L22:
        r4 = null;
        goto L23
    L25:
        return Collections.unmodifiableList(r1);
    }

    public static Map<String, Object> v(ReadableMap r6) {
        Object r0 = null;
        if (r6 != null) goto L5;
        return null;
    L5:
        LinkedHashMap r1 = new LinkedHashMap();
        ReadableMapKeySetIterator r2 = r6.keySetIterator();
    L7:
        if (r2.hasNextKey() == false) goto L31;
        String r3 = r2.nextKey();
        ReadableType r4 = r6.getType(r3);
        switch(a.a[r4.ordinal()]) {
            case 1: goto L29;
            case 2: goto L27;
            case 3: goto L26;
            case 4: goto L25;
            case 5: goto L24;
            case 6: goto L23;
            case 7: goto L22;
            case 8: goto L21;
            case 9: goto L17;
            case 10: goto L13;
            case 11: goto L12;
            case 12: goto L11;
            default: goto L10;
        };
    L10:
        r0 = s(r6.getDynamic(r3));
        goto L29
    L11:
        r0 = String.valueOf(r6.getTemplateData(r3));
        goto L29
    L12:
        r0 = String.valueOf(r6.getPiperData(r3));
        goto L29
    L13:
        ByteBuffer r5 = r6.getByteBuffer(r3);
        if (r5 == null) goto L29;
        ByteBuffer r7 = r5.asReadOnlyBuffer();
        byte[] r8 = new byte[r7.remaining()];
        r7.get(r8);
        r0 = r8;
        goto L29
    L17:
        byte[] r9 = r6.getByteArray(r3);
        if (r9 == null) goto L29;
        r0 = (byte[]) r9.clone();
        goto L29
    L21:
        r0 = u(r6.getArray(r3));
        goto L29
    L22:
        r0 = v(r6.getMap(r3));
        goto L29
    L23:
        r0 = r6.getString(r3);
        goto L29
    L24:
        r0 = Double.valueOf(r6.getDouble(r3));
        goto L29
    L25:
        r0 = Long.valueOf(r6.getLong(r3));
        goto L29
    L26:
        r0 = Integer.valueOf(r6.getInt(r3));
        goto L29
    L27:
        r0 = Boolean.valueOf(r6.getBoolean(r3));
    L29:
        r1.put(r3, r0);
        goto L7
    L31:
        return Collections.unmodifiableMap(r1);
    }

    public static Map<String, Object> w(ReadableMapBuffer r6) {
        if (r6 != null) goto L5;
        return null;
    L5:
        JavaOnlyMap r1 = new JavaOnlyMap();
        Iterator<MapBuffer.a> r7 = r6.iterator();
    L7:
        if (r7.hasNext() == false) goto L19;
        MapBuffer.a r2 = r7.next();
        int r3 = r2.getKey();
        MapBuffer.DataType r4 = r2.getType();
        String r5 = s0.a[r3];
        switch(com.lynx.react.bridge.mapbuffer.b.a[r4.ordinal()]) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L11;
            default: goto L7;
        };
    L11:
        r1.put(r5, null);
        goto L7
    L12:
        r1.put(r5, Double.valueOf(r2.b()));
        goto L7
    L13:
        r1.put(r5, r2.getString());
        goto L7
    L14:
        r1.put(r5, Long.valueOf(r2.c()));
        goto L7
    L15:
        r1.put(r5, Boolean.valueOf(r2.e()));
        goto L7
    L16:
        r1.put(r5, Integer.valueOf(r2.a()));
        goto L7
    L17:
        r1.put(r5, new com.lynx.react.bridge.mapbuffer.e(r2.f()));
        goto L7
    L19:
        return v(r1);
    }

    public static JSONObject y(Map<String, Object> r1) {
        if (r1 != null) goto L4;
        r1 = Collections.emptyMap();
    L4:
        Object r2 = z(r1);
        if ((r2 instanceof JSONObject) == false) goto L8;
        return (JSONObject) r2;
    L8:
        return new JSONObject();
    }

    public static Object z(Object r5) {
        if (r5 != null) goto L6;
        return JSONObject.NULL;
    L6:
        if ((r5 instanceof JSONObject) == false) goto L8;
        return r5;
    L8:
        if ((r5 instanceof JSONArray) == false) goto L10;
        return r5;
    L10:
        if (r5 != JSONObject.NULL) goto L13;
        return r5;
    L13:
        if ((r5 instanceof p) == false) goto L17;
        p r6 = (p) r5;
        JSONObject r0 = new JSONObject();
        n(r0, "eventType", Integer.valueOf(r6.a));
        n(r0, "opTime", Long.valueOf(r6.c));
        n(r0, LynxResourceModule.DATA_KEY, r6.b);
        return r0;
    L17:
        if ((r5 instanceof o) == false) goto L23;
        o r7 = (o) r5;
        JSONObject r1 = new JSONObject();
        n(r1, "operations", r7.a);
        Float r8 = r7.b;
        if (r8 == null) goto L21;
        n(r1, "screenDensity", r8);
    L21:
        return r1;
    L23:
        if ((r5 instanceof b) == false) goto L27;
        b r9 = (b) r5;
        JSONObject r2 = new JSONObject();
        n(r2, "sign", Integer.valueOf(r9.a));
        n(r2, "tagName", r9.b);
        n(r2, "bundle", r9.c);
        n(r2, "initialStyles", r9.d);
        return r2;
    L27:
        if ((r5 instanceof h) == false) goto L31;
        h r10 = (h) r5;
        JSONObject r3 = new JSONObject();
        n(r3, "parentSign", Integer.valueOf(r10.a));
        n(r3, "childSign", Integer.valueOf(r10.b));
        n(r3, "index", r10.c);
        return r3;
    L31:
        if ((r5 instanceof t) == false) goto L38;
        t r11 = (t) r5;
        JSONObject r4 = new JSONObject();
        n(r4, "sign", Integer.valueOf(r11.a));
        Boolean r12 = r11.b;
        if (r12 == null) goto L35;
        n(r4, "tendToFlatten", r12);
    L35:
        n(r4, "bundle", r11.c);
        n(r4, "styles", r11.d);
        return r4;
    L38:
        if ((r5 instanceof s) == false) goto L42;
        s r13 = (s) r5;
        JSONObject r14 = new JSONObject();
        n(r14, "sign", Integer.valueOf(r13.a));
        n(r14, "x", Float.valueOf(r13.b));
        n(r14, "y", Float.valueOf(r13.c));
        n(r14, "width", Float.valueOf(r13.d));
        n(r14, "height", Float.valueOf(r13.e));
        n(r14, "paddings", r13.f);
        n(r14, "margins", r13.g);
        n(r14, "borders", r13.h);
        n(r14, "bounds", r13.i);
        n(r14, "sticky", r13.j);
        n(r14, "maxHeight", Float.valueOf(r13.k));
        return r14;
    L42:
        if ((r5 instanceof q) == false) goto L46;
        q r15 = (q) r5;
        JSONObject r16 = new JSONObject();
        n(r16, "sign", Integer.valueOf(r15.a));
        n(r16, "type", r15.b);
        n(r16, "text", r15.c);
        return r16;
    L46:
        if ((r5 instanceof r) == false) goto L50;
        r r17 = (r) r5;
        JSONObject r18 = new JSONObject();
        n(r18, "sign", Integer.valueOf(r17.a));
        n(r18, "value", r17.b);
        n(r18, "selectionStart", Integer.valueOf(r17.c));
        n(r18, "selectionEnd", Integer.valueOf(r17.d));
        return r18;
    L50:
        if ((r5 instanceof f) == false) goto L54;
        f r19 = (f) r5;
        JSONObject r20 = new JSONObject();
        n(r20, "sign", Integer.valueOf(r19.a));
        n(r20, "method", r19.b);
        n(r20, LynxResourceModule.PARAMS_KEY, r19.c);
        return r20;
    L54:
        if ((r5 instanceof m) == false) goto L58;
        JSONObject r21 = new JSONObject();
        n(r21, "points", ((m) r5).a);
        return r21;
    L58:
        if ((r5 instanceof n) == false) goto L62;
        n r22 = (n) r5;
        JSONObject r23 = new JSONObject();
        n(r23, "x", Float.valueOf(r22.a));
        n(r23, "y", Float.valueOf(r22.b));
        n(r23, "touchId", Integer.valueOf(r22.c));
        n(r23, "targetId", r22.d);
        return r23;
    L62:
        if ((r5 instanceof PropBundle) == false) goto L66;
        return y(t((PropBundle) r5));
    L66:
        if ((r5 instanceof ReadableMap) == false) goto L70;
        return y(v((ReadableMap) r5));
    L70:
        if ((r5 instanceof ReadableArray) == false) goto L80;
        List<Object> r24 = u((ReadableArray) r5);
        if (r24 != null) goto L74;
        r24 = Collections.emptyList();
    L74:
        Object r25 = z(r24);
        if ((r25 instanceof JSONArray) == false) goto L78;
        return (JSONArray) r25;
    L78:
        return new JSONArray();
    L80:
        if ((r5 instanceof ReadableMapBuffer) == true) goto L82;
        int r26 = 0;
        if ((r5 instanceof float[]) == false) goto L92;
        float[] r27 = (float[]) r5;
        JSONArray r28 = new JSONArray();
        int r29 = r27.length;
    L86:
        if (r26 >= r29) goto L90;
        r28.put(r27[r26]);     // Catch: JSONException -> L127
    L89:
        r26 = r26 + 1;
        goto L86
    L90:
        return r28;
    L92:
        if ((r5 instanceof Map) == false) goto L102;
        JSONObject r30 = new JSONObject();
        Iterator r31 = ((Map) r5).entrySet().iterator();
    L95:
        if (r31.hasNext() == false) goto L100;
        Map.Entry r32 = (Map.Entry) r31.next();
        r30.put(String.valueOf(r32.getKey()), z(r32.getValue()));     // Catch: JSONException -> L99
        goto L95
    L100:
        return r30;
    L102:
        if ((r5 instanceof Iterable) == false) goto L109;
        JSONArray r33 = new JSONArray();
        Iterator r34 = ((Iterable) r5).iterator();
    L105:
        if (r34.hasNext() == false) goto L107;
        r33.put(z(r34.next()));
        goto L105
    L107:
        return r33;
    L109:
        if (r5.getClass().isArray() == false) goto L115;
        JSONArray r35 = new JSONArray();
        int r36 = Array.getLength(r5);
    L111:
        if (r26 >= r36) goto L113;
        r35.put(z(Array.get(r5, r26)));
        r26 = r26 + 1;
        goto L111
    L113:
        return r35;
    L115:
        if ((r5 instanceof CharSequence) == false) goto L117;
        return r5;
    L117:
        if ((r5 instanceof Boolean) == false) goto L119;
        return r5;
    L119:
        if ((r5 instanceof Number) == false) goto L122;
        return r5;
    L122:
        if ((r5 instanceof Enum) == false) goto L126;
        return ((Enum) r5).name();
    L126:
        return String.valueOf(r5);
    L82:
        return y(w((ReadableMapBuffer) r5));
    }

    public final Integer e(int r4) {
        Integer r0 = this.b.get(Integer.valueOf(r4));
        if (r0 != null) goto L5;
        return null;
    L5:
        Integer r5 = this.c.get(Integer.valueOf(r4));
        if (r5 != null) goto L8;
    L10:
        return r0;
    L8:
        if (r5.equals(r0) == false) goto L10;
        return null;
    }

    public final Float i(int r3) {
        Float r4 = this.g.get(Integer.valueOf(r3));
        if (r4 != null) goto L5;
    L7:
        return null;
    L5:
        if (r4.floatValue() <= 0.0f) goto L7;
        return r4;
    }

    public final boolean k(int r1) {
        if (r1 >= 0) goto L4;
    L6:
        return false;
    L4:
        if (e(r1) == null) goto L6;
        return true;
    }

    public final void x(final int r4) {
        if (r4 >= 0) goto L4;
        return;
    L4:
        final Integer r0 = e(r4);
        if (r0 != null) goto L8;
        this.e.remove(Integer.valueOf(r4));
        this.g.remove(Integer.valueOf(r4));
        return;
    L8:
        this.c.put(Integer.valueOf(r4), r0);
        this.a.execute(new com.lynx.tasm.recording.a(this, r4, r0));
    }

    public static float[] c(float[] r3, int r4) {
        return new float[]{r3[r4], r3[r4 + 1], r3[r4 + 2], r3[r4 + 3]};
    }

    public final k g(int r3, int r4) {
        Map<Integer, k> r0 = this.i;
        HashMap r1 = (HashMap) r0;
        k r2 = (k) r1.get(Integer.valueOf(r3));
        if (r2 != null) goto L5;
    L6:
        k r5 = new k(r4);
        Map<Integer, k> r6 = this.i;
        HashMap r7 = (HashMap) r6;
        r7.put(Integer.valueOf(r3), r5);
        return r5;
    L5:
        if (r2.a != r4) goto L6;
        return r2;
    }

    public final boolean l(int r2, int r3) {
        Integer r4 = this.b.get(Integer.valueOf(r2));
        if (r4 != null) goto L5;
    L7:
        return false;
    L5:
        if (r4.intValue() != r3) goto L7;
        return true;
    }

    public static Map a(Map r5, g r6, boolean r7) {
        if (r5 != null) goto L4;
        return null;
    L4:
        LinkedHashMap r0 = new LinkedHashMap(r5);
        Map<String, Object> r8 = h(r5);
        if (r8 == null) goto L24;
        LinkedHashMap r1 = new LinkedHashMap();
        Iterator<Map.Entry<String, Object>> r9 = r8.entrySet().iterator();
    L8:
        if (r9.hasNext() == false) goto L22;
        Map.Entry<String, Object> r2 = r9.next();
        String r3 = r2.getKey();
        Object r4 = r2.getValue();
        if (r7 == true) goto L15;
        if (r6 == null) goto L21;
        if (r6.e == true) goto L15;
    L21:
        r1.put(r3, r4);
    L15:
        if (j(r3) == false) goto L21;
        if ((r4 instanceof CharSequence) == false) goto L19;
        String r10 = m(String.valueOf(r4));
    L20:
        r1.put(r3, r10);
        goto L8
    L19:
        r10 = "*";
        goto L20
    L22:
        r0.put("props", Collections.unmodifiableMap(r1));
    L24:
        return Collections.unmodifiableMap(r0);
    }

    public static void n(JSONObject r0, String r1, Object r2) {
        r0.put(r1, z(r2));     // Catch: JSONException -> L4
        return;
    }

    public final void p(final int r11, final int r12, final Object r13, final long r14) {
        final Integer r3 = e(r11);
        if (r3 != null) goto L5;
        return;
    L5:
        this.a.execute(new com.lynx.tasm.recording.d(this, r11, r3, r12, r13, r14));
    }

    public final void d(int r3, int r4, int r5, Object r6, long r7) {
        JSONObject r0 = new JSONObject();     // Catch: JSONException -> L11
        r0.put("time", r7);     // Catch: JSONException -> L11
        r0.put("trackType", r4);     // Catch: JSONException -> L11
        JSONObject r8 = new JSONObject();     // Catch: JSONException -> L11
        r8.put("eventType", r5);     // Catch: JSONException -> L11
        r8.put(LynxResourceModule.DATA_KEY, z(r6));     // Catch: JSONException -> L11
        r0.put("event", r8);     // Catch: JSONException -> L11
        c r9 = this.e.get(Integer.valueOf(r3));     // Catch: JSONException -> L11
        if (r9 != null) goto L7;
        r9 = new c();     // Catch: JSONException -> L11
        c r10 = this.e.putIfAbsent(Integer.valueOf(r3), r9);     // Catch: JSONException -> L11
        if (r10 == null) goto L7;
        r9 = r10;
    L7:
        c.a(r9, r0);     // Catch: JSONException -> L11
        d r11 = this.f.get(Integer.valueOf(r3));     // Catch: JSONException -> L11
        if (r11 == null) goto L14;
        r11.a(r0);     // Catch: JSONException -> L11
        return;
    L14:
        return;
    }

    public final void o(int r7, int r8, String r9, int r10, int r11) {
        if (r9 != null) goto L4;
        return;
    L4:
        long r4 = SystemClock.uptimeMillis();
        p(r7, SpeechEvent.SERVER_UPLINK_EVENT_TRIGGER_BOT, new r(r8, r9, r10, r11), r4);
    }
}
