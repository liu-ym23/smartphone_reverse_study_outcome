package com.bytedance.apm;

import android.content.Context;
import com.bytedance.apm.util.JsonUtils;
import com.bytedance.apm.util.u;
import com.bytedance.apm6.commonevent.CommonEventDeliverer;
import com.bytedance.crash.dumper.ProcInfo;
import com.bytedance.rpc.internal.RpcUtils;
import com.obric.aiproactive.impl.livecard.ProactiveLiveCardDisplayTool;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f1046a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f1047b = false;
    static AtomicLong c = null;
    private static File d = null;
    private static long e = -1;
    private static MappedByteBuffer f;

    /* JADX INFO: renamed from: com.bytedance.apm.a$a, reason: collision with other inner class name */
    public interface InterfaceC0079a {
        void a(float r1, float r2, String r3);
    }

    static {
        c = new AtomicLong(0);
    }

    public a() {
    }

    private static JSONObject a(JSONObject r3) {
        if (r3 != null) goto L5;
        r3 = new JSONObject();
    L5:
        if (r3.isNull("timestamp") == true) goto L11;
    L10:
        return r3;
    L11:
        r3.put("timestamp", System.currentTimeMillis());     // Catch: JSONException -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }

    static /* synthetic */ JSONObject a(JSONObject r0, boolean r1) {
        return b(r0, r1);
    }

    private static void a() {
        if (b.f() == true) goto L6;
        return;
    L6:
        if (d.exists() == true) goto L8;
        return;
    L8:
        File[] r0 = d.listFiles();
        Arrays.sort(r0, new AnonymousClass13());
        int r2 = 60;
        if (r0.length > 60) goto L12;
        r2 = r0.length;
    L12:
        int r1 = 0;
    L13:
        if (r1 >= r2) goto L15;
        r0[r1].delete();
        r1 = r1 + 1;
        goto L13
    }

    public static void a(final long r13, final long r15, final String r17, final String r18, final String r19, final int r20, JSONObject r21) {
        final JSONObject r10 = d(r21);
        com.bytedance.apm.l.b.a().a(new AnonymousClass1(r13, r15, r17, r18, r19, r20, r10));
        if (b.l() == false) goto L6;
        com.bytedance.apm.l.c.a().a(new AnonymousClass8(r13, r15, r17, r18, r19, r20, r10));
        return;
    }

    public static void a(Context r0, long r1, long r3, boolean r5) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r0, Context.class, "com.obric.memorydata.plugin");
    }

    public static void a(final com.bytedance.apm.config.d r5) {
        if (r5 != null) goto L5;
        return;
    L5:
        if (CommonEventDeliverer.needSkip(r5.a(), true) == false) goto L8;
        c(r5.a(), null);
        return;
    L8:
        final JSONObject r0 = a(r5.e());
        c(r0);
        com.bytedance.apm.l.b.a().a(new AnonymousClass2(r5, r0));
        if (b.l() == false) goto L12;
        final JSONObject r2 = b(r5.b(), true);
        final JSONObject r3 = b(r5.c(), true);
        final JSONObject r1 = b(r0, true);
        com.bytedance.apm.l.c.a().a(new AnonymousClass3(r5, r2, r3, r1));
        return;
    }

    public static void a(final String r2, final int r3, JSONObject r4) {
        if (CommonEventDeliverer.needSkip(r2, true) == false) goto L6;
        c(r2, r4);
        return;
    L6:
        JSONObject r5 = b(r4);
        c(r5);
        CommonEventDeliverer.monitorStatusRate(r2, r3, r5);
        if (b.l() == false) goto L10;
        final JSONObject r6 = b(r5, true);
        com.bytedance.apm.l.c.a().a(new AnonymousClass4(r2, r3, r6));
        return;
    }

    @Deprecated
    public static void a(final String r4, final int r5, JSONObject r6, JSONObject r7) {
        if (CommonEventDeliverer.needSkip(r4, true) == false) goto L6;
        c(r4, r6);
        return;
    L6:
        JSONObject r1 = d(r7);
        c(r1);
        CommonEventDeliverer.monitorStatusAndDuration(r4, r5, b(r6, true), b(r1, false));
        if (b.l() == false) goto L10;
        final JSONObject r8 = b(r6, true);
        final JSONObject r9 = b(r7, true);
        com.bytedance.apm.l.c.a().a(new AnonymousClass6(r4, r5, r8, r9));
        return;
    }

    public static void a(String r18, String r19) {
        monitor-enter(a.class);     // Catch: Throwable -> L40
        String r0 = b.e();     // Catch: Throwable -> L36
        long r2 = Thread.currentThread().getId();     // Catch: Throwable -> L36
        long r4 = System.currentTimeMillis();     // Catch: Throwable -> L36
        String r6 = u.a();     // Catch: Throwable -> L36
        StringBuffer r7 = new StringBuffer();     // Catch: Throwable -> L36
        r7.append(r18).append("#").append(r2).append("#").append(r4).append("#").append(r6).append("\n").append(r19).append("\n");     // Catch: Throwable -> L36
        byte[] r3 = r7.toString().getBytes(RpcUtils.CHARSET_UTF8);     // Catch: Throwable -> L36
        String r5 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(b.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getExternalFilesDir(null).getAbsolutePath();     // Catch: Throwable -> L36
        if (f != null) goto L18;
        File r8 = new File(r5 + "/logs");     // Catch: Throwable -> L36
        d = new File(r5 + "/logs/proc: " + r0);     // Catch: Throwable -> L36
        File r9 = new File(r5 + "/logs/proc: " + r0 + "/" + r6);     // Catch: Throwable -> L36
        if (r8.exists() == true) goto L10;
        r8.mkdirs();     // Catch: Throwable -> L36
    L10:
        if (d.exists() == true) goto L12;
        d.mkdirs();     // Catch: Throwable -> L36
    L12:
        r9.createNewFile();     // Catch: Throwable -> L36
        FileChannel r12 = new RandomAccessFile(r9, "rw").getChannel();     // Catch: Throwable -> L36
        FileChannel.MapMode r13 = FileChannel.MapMode.READ_WRITE;     // Catch: Throwable -> L36
        if (b.f() == false) goto L15;
        long r16 = 2097152;
    L16:
        f = r12.map(r13, 0, r16);     // Catch: Throwable -> L36
        goto L18
    L15:
        r16 = 262144;
    L18:
        if (f.remaining() >= r3.length) goto L24;
        f.force();     // Catch: Throwable -> L36
        FileChannel r11 = new RandomAccessFile(new File(r5 + "/logs/proc: " + r0 + "/" + r6), "rw").getChannel();     // Catch: Throwable -> L36
        FileChannel.MapMode r14 = FileChannel.MapMode.READ_WRITE;     // Catch: Throwable -> L36
        if (b.f() == false) goto L22;
        long r15 = 2097152;
    L23:
        f = r11.map(r14, 0, r15);     // Catch: Throwable -> L36
        goto L24
    L22:
        r15 = 262144;
    L24:
        f.put(r3);     // Catch: Throwable -> L36
        if (e == (-1)) goto L29;
        if ((System.currentTimeMillis() - e) > ProactiveLiveCardDisplayTool.DEFAULT_AUTO_DISMISS_DURATION_MS) goto L29;
    L34:
        monitor-exit(a.class);     // Catch: Throwable -> L36
        goto L45
    L39:
        return;
    L29:
        if (com.bytedance.apm.util.f.a(d) <= ProcInfo.GB) goto L31;
    L32:
        a();     // Catch: Throwable -> L36
    L33:
        e = System.currentTimeMillis();     // Catch: Throwable -> L36
        goto L34
    L31:
        if (com.bytedance.apm.util.f.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(b.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getFreeSpace() >= ProcInfo.GB) goto L33;
    L36:
        th = move-exception;
        throw th;     // Catch: Throwable -> L40
    }

    public static void a(String r1, JSONObject r2) {
        a(r1, r2, false);
    }

    @Deprecated
    public static void a(final String r2, JSONObject r3, JSONObject r4) {
        if (CommonEventDeliverer.needSkip(r2, true) == false) goto L6;
        c(r2, r3);
        return;
    L6:
        JSONObject r5 = b(r4);
        c(r5);
        if (f1047b == false) goto L9;
        JSONObject r1 = JsonUtils.d(r3);
    L10:
        CommonEventDeliverer.monitorDuration(r2, r1, r5);
        if (b.l() == false) goto L14;
        final JSONObject r6 = b(r3, true);
        final JSONObject r7 = b(r5, true);
        com.bytedance.apm.l.c.a().a(new AnonymousClass5(r2, r6, r7));
        return;
    L14:
        return;
    L9:
        r1 = r3;
        goto L10
    }

    public static void a(final String r3, JSONObject r4, JSONObject r5, JSONObject r6) {
        if (CommonEventDeliverer.needSkip(r3, true) == false) goto L6;
        c(r3, r4);
        return;
    L6:
        JSONObject r7 = b(r6);
        c(r7);
        CommonEventDeliverer.monitorEvent(r3, b(r4, true), b(r5, true), r7);
        if (b.l() == false) goto L10;
        final JSONObject r8 = b(r4, true);
        final JSONObject r9 = b(r5, true);
        final JSONObject r10 = b(r7, true);
        com.bytedance.apm.l.c.a().a(new AnonymousClass15(r3, r8, r9, r10));
        return;
    }

    public static void a(final String r2, JSONObject r3, final boolean r4) {
        if (CommonEventDeliverer.needSkip(r2, false) == false) goto L6;
        c(r2, r3);
        return;
    L6:
        final JSONObject r5 = b(r3);
        c(r5);
        com.bytedance.apm.l.b.a().a(new AnonymousClass10(r2, r5));
        if (b.l() == false) goto L10;
        final JSONObject r6 = b(r5, true);
        com.bytedance.apm.l.c.a().a(new AnonymousClass11(r2, r6, r4));
        return;
    }

    private static JSONObject b(JSONObject r3) {
        if (r3 != null) goto L6;
        r3 = new JSONObject();     // Catch: Exception -> L9
    L8:
        return r3;
    L6:
        if (r3.isNull("timestamp") == false) goto L8;
        r3.put("timestamp", System.currentTimeMillis());     // Catch: Exception -> L9
        goto L8
    }

    private static JSONObject b(JSONObject r1, boolean r2) {
        if (f1046a == false) goto L8;
        if (r2 == true) goto L7;
        return r1;
    L7:
        return JsonUtils.e(r1);
    L8:
        return JsonUtils.c(r1);
    }

    public static void b(final long r13, final long r15, final String r17, final String r18, final String r19, final int r20, JSONObject r21) {
        final JSONObject r10 = d(r21);
        com.bytedance.apm.l.b.a().a(new AnonymousClass12(r13, r15, r17, r18, r19, r20, r10));
        if (b.l() == false) goto L6;
        com.bytedance.apm.l.c.a().a(new AnonymousClass14(r13, r15, r17, r18, r19, r20, r10));
        return;
    }

    public static void b(final String r2, JSONObject r3) {
        final JSONObject r4 = b(r3);
        com.bytedance.apm.l.b.a().a(new AnonymousClass7(r2, r4));
        if (b.l() == false) goto L6;
        com.bytedance.apm.l.c.a().a(new AnonymousClass9(r2, r4));
        return;
    }

    private static void c(String r1, JSONObject r2) {
        if (b.k() == false) goto L8;
        if (r2 != null) goto L6;
        r2 = new JSONObject();
    L6:
        com.bytedance.apm.doctor.a.a(r1, r2, false);
        return;
    }

    private static void c(JSONObject r6) {
        if (r6 != null) goto L7;
        return;
    L7:
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L6
        r0.put("_debug_uuid", b.i() + "_" + c.getAndAdd(1));     // Catch: Exception -> L6
        r6.put("_debug_self", r0);     // Catch: Exception -> L6
        return;
    }

    private static JSONObject d(JSONObject r1) {
        if (f1046a == false) goto L6;
        return JsonUtils.e(r1);
    L6:
        return b(r1);
    }
}
