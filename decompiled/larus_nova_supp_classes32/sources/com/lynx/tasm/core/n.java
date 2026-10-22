package com.lynx.tasm.core;

import android.content.Context;
import android.text.TextUtils;
import android.util.LruCache;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.base.LLog;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class n {
    public static n b;
    public final LruCache<String, Integer> a;

    public class a implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ d8a.h b;
        public final /* synthetic */ d8a.g c;
        public final /* synthetic */ d8a.i d;
        public final /* synthetic */ n e;

        public final void a() {
            boolean r1 = true;
            if (this.a.startsWith("http://") == true) goto L7;
            if (this.a.startsWith("https://") == true) goto L7;
        L16:
            Integer r4 = null;
            r4 = null;
            r4 = null;
            r4 = null;
            InputStream r5 = null;
            r5 = null;
            r4 = null;
            if (this.a.startsWith("asset:///") == false) goto L38;
            if (this.a.length() <= 9) goto L38;
            n r0 = this.e;
            String r2 = this.a;
            d8a.g r6 = this.c;
            r0.getClass();
            d8a.i r3 = new d8a.i();
            r5 = LynxEnv.inst().getAppContext().getAssets().open(r2.substring(9));     // Catch: Throwable -> L27 IOException -> L29
            StringBuilder r7 = new StringBuilder(r5.available());     // Catch: Throwable -> L27 IOException -> L29
            byte[] r8 = new byte[1024];     // Catch: Throwable -> L27 IOException -> L29
        L22:
            int r9 = r5.read(r8);     // Catch: Throwable -> L27 IOException -> L29
            if (r9 == (-1)) goto L25;
            r7.append(new String(r8, 0, r9));     // Catch: Throwable -> L27 IOException -> L29
            goto L22
        L25:
            ByteArrayInputStream r10 = new ByteArrayInputStream(r7.toString().getBytes());     // Catch: Throwable -> L27 IOException -> L29
            r3.d = r10;     // Catch: Throwable -> L27 IOException -> L29
            r6.onSuccess(r3);     // Catch: Throwable -> L27 IOException -> L29
            r10.close();     // Catch: Throwable -> L27 IOException -> L29
        L32:
            r5.close();     // Catch: IOException -> L98
        L106:
            return;
        L29:
            e = move-exception;
            r3.b = e.toString();     // Catch: Throwable -> L27
            r6.onFailed(r3);     // Catch: Throwable -> L27
            if (r5 != null) goto L32;
            return;
        L27:
            th = move-exception;
            if (r5 != null) goto L109;
        L36:
            throw th;
        L109:
            r5.close();     // Catch: IOException -> L99
        L38:
            if (this.a.startsWith("res:///") == false) goto L81;
            if (this.a.length() <= 7) goto L81;
            n r11 = this.e;
            String r12 = this.a;
            d8a.g r13 = this.c;
            r11.getClass();
            Context r14 = LynxEnv.inst().getAppContext();
            String r15 = r12.substring(7);
            if (r15 != null) goto L44;
        L74:
            d8a.i r16 = new d8a.i();
            if (r4 == null) goto L79;
            InputStream r17 = LynxEnv.inst().getAppContext().getResources().openRawResource(r4.intValue());
            r16.d = r17;
            r13.onSuccess(r16);
            r17.close();     // Catch: IOException -> L98
            goto L106
        L79:
            r16.b = "resource not found!";
            r13.onFailed(r16);
            return;
        L44:
            if (r15.isEmpty() == true) goto L74;
            r4 = Integer.valueOf(CastIntegerProtector.parseInt(r15));     // Catch: NumberFormatException -> L48
        L48:
            String r18 = r15.toLowerCase().replace("-", "_");
            Integer r19 = r11.a.get(r18);
            if (r19 == null) goto L51;
            r4 = r19;
            goto L74
        L51:
            int r20 = r18.indexOf(47);
            if (r20 <= 0) goto L74;
            if (r20 == (r18.length() - 1)) goto L74;
            String r21 = r18.substring(0, r20);
            String r22 = r18.substring(r20 + 1);
            int r23 = r22.lastIndexOf(46);
            if (r23 <= 0) goto L59;
            r22 = r22.substring(0, r23);
        L59:
            monitor-enter(r11);
            Integer r24 = r11.a.get(r18);     // Catch: Throwable -> L71
            if (r24 != null) goto L63;
            int r25 = r14.getResources().getIdentifier(r22, r21, r14.getPackageName());     // Catch: Throwable -> L71
            if (r25 == 0) goto L102;
            r11.a.put(r18, Integer.valueOf(r25));     // Catch: Throwable -> L71
            r4 = Integer.valueOf(r25);     // Catch: Throwable -> L71
        L102:
            goto L74
        L63:
            r4 = r24;
        L71:
            th = move-exception;
            throw th;
        L81:
            if (this.a.startsWith("file://") == false) goto L89;
            if (this.a.length() <= 7) goto L89;
            n r26 = this.e;
            String r27 = this.a;
            d8a.g r28 = this.c;
            r26.getClass();
            d8a.i r29 = new d8a.i();
            byte[] r30 = e8a.b.b(LynxEnv.inst().getAppContext(), r27);
            if (r30 == null) goto L87;
            r29.d = new ByteArrayInputStream(r30);
            r28.onSuccess(r29);
            return;
        L87:
            r29.b = "file not found!";
            r28.onFailed(r29);
            return;
        L89:
            if (this.a.startsWith("content://") == true) goto L91;
        L96:
            LLog.DTHROW(new RuntimeException("illegal url:" + this.a));
            this.d.b = "url is illegal:" + this.a;
            this.c.onFailed(this.d);
            return;
        L91:
            if (this.a.length() <= 10) goto L96;
            n r31 = this.e;
            String r32 = this.a;
            d8a.g r33 = this.c;
            r31.getClass();
            d8a.i r34 = new d8a.i();
            byte[] r35 = e8a.b.a(LynxEnv.inst().getAppContext(), r32);
            if (r35 == null) goto L95;
            r34.d = new ByteArrayInputStream(r35);
            r33.onSuccess(r34);
            return;
        L95:
            r34.b = "content provider resource not found!";
            r33.onFailed(r34);
            return;
        L123:
            return;
        L7:
            if (this.a.length() <= 8) goto L16;
            n r36 = this.e;
            d8a.h r37 = this.b;
            d8a.g r38 = this.c;
            r36.getClass();
            d8a.l r39 = LynxEnv.inst().getResProvider();
            if (r39 != null) goto L12;
            r1 = false;
        L12:
            LLog.DCHECK(r1);
            if (r39 != null) goto L15;
            d8a.i r40 = new d8a.i();
            r40.b = "don't have ResProvider.Can't Get Resource.";
            r38.onFailed(r40);
            return;
        L15:
            r39.a(r37, r38);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(n r1, String r2, d8a.h r3, d8a.g r4, d8a.i r5) {
            this.e = r1;
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public static n a() {
        if (b != null) goto L15;
        monitor-enter(n.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (b != null) goto L9;
        b = new n();     // Catch: Throwable -> L11
    L9:
        monitor-exit(n.class);     // Catch: Throwable -> L11
    L15:
        return b;
    }

    public n() {
        this.a = new LruCache(100);
    }

    public final void b(d8a.h r9, d8a.g r10) {
        d8a.i r5 = new d8a.i();
        String r2 = r9.a;
        if (TextUtils.isEmpty(r2) == false) goto L6;
        r5.b = "url is empty!";
        r10.onFailed(r5);
        LLog.w("lynx_ResManager", "url:" + r2 + " is empty!");
        return;
    L6:
        LynxThreadPool.b().execute(new a(this, r2, r9, r10, r5));
    }
}
