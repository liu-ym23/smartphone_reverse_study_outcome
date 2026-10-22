package com.ss.android.common.applog;

import android.os.Handler;
import android.os.Message;
import com.bytedance.common.utility.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile a f15108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile b f15109b;

    public interface a {
        void a(int r1);

        void a(String r1);

        void a(String r1, String r2, String r3, int r4);

        void a(String r1, String r2, String r3, boolean r4, String r5);

        void a(List<Long> r1);

        void a(boolean r1, long r2);

        void a(boolean r1, List<Long> r2);
    }

    private static class b extends Handler {
        @Override // android.os.Handler
        public void handleMessage(Message r8) {
            a r7 = x.a();     // Catch: Throwable -> L24
            switch(r8.what) {
                case 0: goto L21;
                case 1: goto L19;
                case 2: goto L17;
                case 3: goto L15;
                case 4: goto L10;
                case 5: goto L8;
                case 6: goto L6;
                default: goto L41;
            };
        L6:
            if (r7 == null) goto L29;
            r7.a((String) ZeusTransformUtils.preCheckCast(((Object[]) ZeusTransformUtils.preCheckCast((Object[]) ZeusTransformUtils.preCheckCast(r8.obj, Object[].class, "com.obric.memorydata.plugin"), Object[].class, "com.obric.memorydata.plugin"))[0], String.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L24
            return;
        L29:
            return;
        L8:
            if (r7 == null) goto L31;
            Object[] r9 = (Object[]) ZeusTransformUtils.preCheckCast((Object[]) ZeusTransformUtils.preCheckCast(r8.obj, Object[].class, "com.obric.memorydata.plugin"), Object[].class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24
            r7.a((String) ZeusTransformUtils.preCheckCast(r9[0], String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r9[1], String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r9[2], String.class, "com.obric.memorydata.plugin"), ((Integer) ZeusTransformUtils.preCheckCast(r9[3], Integer.class, "com.obric.memorydata.plugin")).intValue());     // Catch: Throwable -> L24
            return;
        L31:
            return;
        L10:
            if (r7 == null) goto L33;
            Iterator r10 = ((List) ZeusTransformUtils.preCheckCast(((Object[]) ZeusTransformUtils.preCheckCast((Object[]) ZeusTransformUtils.preCheckCast(r8.obj, Object[].class, "com.obric.memorydata.plugin"), Object[].class, "com.obric.memorydata.plugin"))[0], List.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L24
        L13:
            if (r10.hasNext() == false) goto L43;
            r7.a("terminate", (String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.memorydata.plugin"), null, false, "");     // Catch: Throwable -> L24
            goto L13
        L43:
            return;
        L33:
            return;
        L15:
            if (r7 == null) goto L34;
            r7.a((List) ZeusTransformUtils.preCheckCast(((Object[]) ZeusTransformUtils.preCheckCast((Object[]) ZeusTransformUtils.preCheckCast(r8.obj, Object[].class, "com.obric.memorydata.plugin"), Object[].class, "com.obric.memorydata.plugin"))[0], List.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L24
            return;
        L34:
            return;
        L17:
            if (r7 == null) goto L36;
            Object[] r11 = (Object[]) ZeusTransformUtils.preCheckCast((Object[]) ZeusTransformUtils.preCheckCast(r8.obj, Object[].class, "com.obric.memorydata.plugin"), Object[].class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24
            r7.a(((Boolean) ZeusTransformUtils.preCheckCast(r11[0], Boolean.class, "com.obric.memorydata.plugin")).booleanValue(), ((Long) ZeusTransformUtils.preCheckCast(r11[1], Long.class, "com.obric.memorydata.plugin")).longValue());     // Catch: Throwable -> L24
            return;
        L36:
            return;
        L19:
            if (r7 == null) goto L38;
            r7.a(r8.arg1);     // Catch: Throwable -> L24
            return;
        L38:
            return;
        L21:
            if (r7 == null) goto L40;
            Object[] r12 = (Object[]) ZeusTransformUtils.preCheckCast((Object[]) ZeusTransformUtils.preCheckCast(r8.obj, Object[].class, "com.obric.memorydata.plugin"), Object[].class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24
            r7.a(((Boolean) ZeusTransformUtils.preCheckCast(r12[0], Boolean.class, "com.obric.memorydata.plugin")).booleanValue(), (List) ZeusTransformUtils.preCheckCast(r12[1], List.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L24
            return;
        L40:
            return;
        L41:
            return;
        L24:
            th = move-exception;
            Logger.e("LogTrace", "handle log trace exception", th);
        }
    }

    static {
    }

    static /* synthetic */ a a() {
        return f15108a;
    }

    public static void a(int r1, int r2, Object[] r3) {
        b r0 = f15109b;
        if (r0 == null) goto L6;
        Message r4 = r0.obtainMessage(r1);
        r4.arg1 = r2;
        r4.obj = r3;
        r0.sendMessage(r4);
        return;
    }
}
