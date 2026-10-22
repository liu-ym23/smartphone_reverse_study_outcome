package com.lynx.tasm.fontface;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.lynx.base.log.LynxLog;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.utils.n;
import com.lynx.tasm.behavior.x0;
import com.lynx.tasm.resourceprovider.LynxResourceRequest$LynxResourceType;
import com.lynx.tasm.utils.CallStackUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import ko.r;
import l9.o;
import zm.f0;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f10867a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f10868b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f10869c;

    public g() {
        this.f10867a = new HashMap();
        this.f10868b = new ArrayList();
        this.f10869c = Collections.synchronizedMap(new FontFaceManager$1());
    }

    public static void c(int r5, String r10, String r11, Exception r12, LynxContext r13) {
        LynxError r14 = new LynxError(r5, r10, "", "error");
        if (r12 == null) goto L5;
        String r15 = CallStackUtil.a(r12);
        r14.g = null;
        r14.f9999n = r15;
        LynxLog.b(4, "FontFaceManager", r12.getMessage());
    L6:
        r13.f(r11, "font", r14);
        return;
    L5:
        LynxLog.b(4, "FontFaceManager", r10 + ",src:" + r11);
        goto L6
    }

    public final Typeface a(LynxContext r14, String r15, int r16, f0 r17) {
        r14.getClass();
        String[] r5 = r15.split(",");
        int r10 = r5.length;
        int r11 = 0;
    L4:
        if (r11 >= r10) goto L28;
        String r12 = com.lynx.tasm.utils.b.h(r5[r11]);
        if (TextUtils.isEmpty(r12) == true) goto L23;
        monitor-enter(com.lynx.tasm.utils.b.class);
    L13:
        th = move-exception;
        throw th;
    L11:
        if (r14.f10146n != null) goto L15;
        r14.f10146n = new HashMap();     // Catch: Throwable -> L13
    L15:
        a r13 = (a) r14.f10146n.get(r12);     // Catch: Throwable -> L13
        if (r13 != null) goto L24;
        r13 = com.lynx.tasm.utils.b.f(r14, r12);     // Catch: Throwable -> L13
        if (r13 != null) goto L19;
        monitor-exit(com.lynx.tasm.utils.b.class);     // Catch: Throwable -> L13
        goto L23
    L19:
        r14.f10146n.put(r12, r13);     // Catch: Throwable -> L13
        monitor-exit(com.lynx.tasm.utils.b.class);     // Catch: Throwable -> L13
    L21:
        a r18 = r13;
    L29:
        if (r18 != null) goto L31;
        return null;
    L31:
        monitor-enter(this);
        i r19 = b(r18);     // Catch: Throwable -> L39
        if (r19 != null) goto L35;
    L41:
        monitor-exit(this);     // Catch: Throwable -> L39
        i r110 = r18.f10854b;
        Handler r111 = new Handler(Looper.myLooper());
        if (r110 == null) goto L48;
        if (r17 == null) goto L47;
        r111.post(new com.bytedance.ies.xelement.input.h(this, r15, r16, r17, r110, r111));
    L47:
        return r110.a(r16);
    L48:
        mn.h.i().execute(new c(this, r14, r18, r16, r17, r111));
        return null;
    L35:
        if (r19.f10874b[r16] == null) goto L41;
        Typeface r20 = r19.a(r16);     // Catch: Throwable -> L39
        monitor-exit(this);     // Catch: Throwable -> L39
        return r20;
    L39:
        th = move-exception;
        throw th;
    L24:
        monitor-exit(com.lynx.tasm.utils.b.class);     // Catch: Throwable -> L13
    L23:
        r11 = r11 + 1;     // Catch: Throwable -> L13
        goto L4
    L28:
        r18 = null;
        goto L29
    }

    public final synchronized i b(a r5) {
        monitor-enter(this);
        Iterator r10 = r5.f10853a.iterator();     // Catch: Throwable -> L8
        if (r10.hasNext() == false) goto L10;
        Pair r11 = (Pair) r10.next();     // Catch: Throwable -> L8
        i r12 = (i) this.f10867a.get(((FontFace$TYPE) r11.first).name() + ((String) r11.second));     // Catch: Throwable -> L8
        monitor-exit(this);
        return r12;
    L10:
        monitor-exit(this);
        return null;
    L8:
        th = move-exception;
        throw th;
    }

    public final void d(LynxContext r10, b r11, Iterator r12, Handler r13) {
        if (r12.hasNext() == true) goto L5;
        return;
    L5:
        Pair r5 = (Pair) r12.next();
        x0 r14 = r10.f10153v;
        r14.getClass();
        Typeface r15 = null;
        if (TextUtils.isEmpty("FONT") == false) goto L8;
        fo.h r16 = null;
    L9:
        if (r16 != null) goto L11;
    L30:
        if (r15 != null) goto L32;
        r15 = yn.c.f23314a.a(r10, (FontFace$TYPE) r5.first, (String) r5.second);
    L32:
        if (r15 != null) goto L35;
        d(r10, r11, r12, r13);
        return;
    L35:
        i r17 = new i(r15);
        monitor-enter(this);
        Iterator r18 = r11.f10856b.iterator();     // Catch: Throwable -> L41
    L39:
        if (r18.hasNext() == false) goto L43;
        a r19 = (a) r18.next();     // Catch: Throwable -> L41
        r19.f10854b = r17;     // Catch: Throwable -> L41
        f(r19, r17);     // Catch: Throwable -> L41
        goto L39
    L43:
        this.f10868b.remove(r11);     // Catch: Throwable -> L41
        monitor-exit(this);     // Catch: Throwable -> L41
        Iterator r20 = r11.f10855a.iterator();
    L47:
        if (r20.hasNext() == false) goto L49;
        r17.a(((Integer) ((Pair) r20.next()).second).intValue());
        goto L47
    L49:
        r13.post(new e(r11, r17, r13));
        return;
    L41:
        th = move-exception;
        throw th;
    L11:
        if (((String) r5.second).startsWith("data:") == true) goto L30;
        FontFace$TYPE r21 = (FontFace$TYPE) r5.first;
        String r22 = (String) r5.second;
        String[] r23 = new String[1];
        new Bundle().putString("type", r21.toString());
        r16.a(new n(r22, 0), new d(this, r23, r22, r10));
        String r24 = r23[0];
        if (r24 == null) goto L30;
        if (r24.startsWith(IIvyAIPackageResourceService.SCHEMA) == false) goto L18;
        r15 = yn.c.f23314a.a(r10, FontFace$TYPE.f10850a, r24);
        goto L30
    L18:
        if (r24.startsWith("file://") == false) goto L25;
        String r25 = r24.substring(7);
        Typeface r26 = Typeface.createFromFile(r25);     // Catch: RuntimeException -> L22
    L21:
        r15 = r26;
    L22:
        e = move-exception;
        c(30205, "Create typeface from local path failed", r25, e, r10);
        goto L30
    L25:
        if (r24.startsWith("asset:///") == false) goto L30;
        r26 = Typeface.createFromAsset(LynxEnv.inst().getAppContext().getAssets(), r24.substring(9));     // Catch: RuntimeException -> L28
    L28:
        e = move-exception;
        c(30205, "Create typeface from local asset failed", r24, e, r10);
        goto L30
    L8:
        r16 = (fo.h) ((HashMap) r14.f10812a).get("FONT");
        goto L9
    }

    public final void e(LynxContext r10, b r11, Iterator r12, Iterator r13, Handler r14) {
        if (r12.hasNext() == true) goto L6;
        LynxLog.b(3, "FontFaceManager", "load typeface with GenericLynxResourceFetcher failed, try loadTypeface.");
        d(r10, r11, r13, r14);
        return;
    L6:
        Pair r5 = (Pair) r12.next();
        String r15 = (String) r5.second;
        Typeface r16 = null;
        if (TextUtils.isEmpty(r15) == true) goto L55;
        FontFace$TYPE r17 = FontFace$TYPE.f10851b;
        if (r17 != r5.first) goto L18;
        if (r15.startsWith("file://") == false) goto L55;
        String r18 = r15.substring(7);
        Typeface r19 = Typeface.createFromFile(r18);     // Catch: RuntimeException -> L15
    L14:
        r16 = r19;
    L15:
        e = move-exception;
        c(30205, "Create typeface from local path failed", r18, e, r10);
        goto L55
    L18:
        if (r15.startsWith("data:") == false) goto L36;
        if (r15.contains("base64,") == false) goto L36;
        FontFace$TYPE r20 = (FontFace$TYPE) r5.first;
        if (TextUtils.isEmpty(r15) == true) goto L55;
        if (r20 == r17) goto L55;
        int r21 = r15.indexOf("base64,");
        if (r15.startsWith("data:") == false) goto L55;
        if (r21 == (-1)) goto L55;
        r19 = o.b(r10, Base64.decode(r15.substring(r21 + 7), 0));     // Catch: Exception -> L33
    L33:
        e = move-exception;
        c(30203, "Error when parsing base64 resource", r15, e, r10);
    L36:
        if (r15.startsWith("http") == false) goto L54;
        int r22 = 8;
        r r23 = new r(r22, r15, LynxResourceRequest$LynxResourceType.f10943b);
        wn.h r24 = r10.D;
        AtomicReference r25 = new AtomicReference();
        CountDownLatch r26 = new CountDownLatch(1);
        if (r24 == null) goto L76;
        z4.a r27 = new z4.a();
        r27.e = this;
        r27.f23389a = r25;
        r27.f23390b = r15;
        r27.f23391c = r10;
        r27.d = r26;
        r24.i(r23, r27);
    L76:
    L45:
        e = move-exception;
        Thread.currentThread().interrupt();
        c(30202, "Load font with genericResourceFetcher failed", r15, e, r10);
        goto L55
    L42:
        if (r26.await(30, TimeUnit.SECONDS) == true) goto L47;
        c(30202, "Load font with genericResourceFetcher failed:request timeout", r15, null, r10);     // Catch: InterruptedException -> L45
        goto L55
    L47:
        byte[] r28 = (byte[]) r25.get();
        if (r28 == null) goto L55;
        if (r28.length == 0) goto L55;
        r16 = o.b(r10, r28);
        goto L55
    L54:
        c(30201, "Src format is incorrect", r15, null, r10);
    L55:
        if (r16 != null) goto L58;
        e(r10, r11, r12, r13, r14);
        return;
    L58:
        LynxLog.b(2, "FontFaceManager", "Lynx load typeface with GenericLynxResourceFetcher success.");
        i r29 = new i(r16);
        monitor-enter(this);
        Iterator r110 = r11.f10856b.iterator();     // Catch: Throwable -> L64
    L62:
        if (r110.hasNext() == false) goto L66;
        a r111 = (a) r110.next();     // Catch: Throwable -> L64
        r111.f10854b = r29;     // Catch: Throwable -> L64
        f(r111, r29);     // Catch: Throwable -> L64
        goto L62
    L66:
        this.f10868b.remove(r11);     // Catch: Throwable -> L64
        monitor-exit(this);     // Catch: Throwable -> L64
        Iterator r30 = r11.f10855a.iterator();
    L70:
        if (r30.hasNext() == false) goto L72;
        r29.a(((Integer) ((Pair) r30.next()).second).intValue());
        goto L70
    L72:
        r14.post(new e(r11, r14, r29));
        return;
    L64:
        th = move-exception;
        throw th;
    }

    public final synchronized void f(a r5, i r10) {
        monitor-enter(this);
        Iterator r11 = r5.f10853a.iterator();     // Catch: Throwable -> L8
    L5:
        if (r11.hasNext() == false) goto L10;
        Pair r12 = (Pair) r11.next();     // Catch: Throwable -> L8
        this.f10867a.put(((FontFace$TYPE) r12.first).name() + ((String) r12.second), r10);     // Catch: Throwable -> L8
        goto L5
    L10:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
