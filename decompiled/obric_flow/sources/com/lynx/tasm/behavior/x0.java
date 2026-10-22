package com.lynx.tasm.behavior;

import android.net.LocalSocket;
import android.net.Uri;
import android.util.SparseArray;
import com.bytedance.monitor.util.thread.AsyncTaskType;
import com.obric.oui.calendar.CalendarDay;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import org.threeten.bp.LocalDate;

/* JADX INFO: loaded from: classes2.dex */
public final class x0 implements mt.q, de.d, com.lynx.tasm.ui.image.r, pt.p, ng.a, tr.d, yq.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f10812a;

    public /* synthetic */ x0(Object r5) {
        this.f10812a = r5;
    }

    public static void d(dk.e r10, dk.f r11) {
        String r5 = "HTTP/1.1 " + r10.f16662c + " " + r10.d;
        int r12 = r5.length();
        int r13 = 0;
    L3:
        BufferedOutputStream r14 = r11.f16664a;
        if (r13 >= r12) goto L6;
        r14.write(r5.charAt(r13));
        r13 = r13 + 1;
        goto L3
    L6:
        r14.write(dk.f.f16663b);
        ArrayList r15 = (ArrayList) r10.f16659a;
        int r16 = r15.size();
        int r17 = 0;
    L7:
        if (r17 >= r16) goto L12;
        String r18 = com.lynx.tasm.utils.k.j((String) r15.get(r17), ": ", (String) ((ArrayList) r10.f16660b).get(r17));
        int r19 = r18.length();
        int r20 = 0;
    L9:
        if (r20 >= r19) goto L11;
        r14.write(r18.charAt(r20));
        r20 = r20 + 1;
        goto L9
    L11:
        r14.write(dk.f.f16663b);
        r17 = r17 + 1;
        goto L7
    L12:
        r14.write(dk.f.f16663b);
        r14.flush();
    }

    @Override // com.lynx.tasm.ui.image.r
    public void a() {
        com.lynx.tasm.ui.image.i r10 = (com.lynx.tasm.ui.image.i) this.f10812a;
        com.lynx.tasm.ui.image.v0 r5 = r10.f11047b;
        if (r5 == null) goto L10;
        int r11 = r10.f11052k;
        if (r11 <= 0) goto L11;
        int r12 = r10.f11053l;
        if (r12 <= 0) goto L12;
        r5.b(r11, r12, 0, 0, 0, 0);
        return;
    L12:
        return;
    L11:
        return;
    }

    public void b(com.lynx.animax.player.b r14) {
        ck.b r5 = new ck.b(((ck.b) r14.f9658c).b());
        OutputStream r10 = ((LocalSocket) r14.f9657b).getOutputStream();
        com.google.common.reflect.w r11 = new com.google.common.reflect.w(r5);
        dk.f r12 = new dk.f(new BufferedOutputStream(r10));
        com.lynx.animax.player.b r13 = new com.lynx.animax.player.b(r14, r5);
        dk.d r15 = new dk.d();
        dk.e r16 = new dk.e();
    L3:
        ((ArrayList) r15.f16659a).clear();
        ((ArrayList) r15.f16660b).clear();
        dk.b r17 = null;
        r15.f16661c = null;
        String r18 = r11.c();
        boolean r19 = true;
        int r20 = 0;
        if (r18 != null) goto L6;
        dk.d r21 = null;
    L14:
        if (r21 == null) goto L49;
        ((ArrayList) r16.f16659a).clear();
        ((ArrayList) r16.f16660b).clear();
        r16.f16662c = -1;
        r16.d = null;
        r16.e = null;
        ym.p r22 = (ym.p) this.f10812a;
        String r110 = r21.f16661c.getPath();
        monitor-enter(r22);
        int r111 = ((ArrayList) r22.f23312b).size();     // Catch: Throwable -> L24
    L18:
        if (r20 >= r111) goto L27;
        if (((dk.a) ((ArrayList) r22.f23312b).get(r20)).f16658a.equals(r110) == true) goto L21;
        r20 = r20 + 1;
        goto L18
    L21:
        r17 = (dk.b) ((ArrayList) r22.f23313c).get(r20);     // Catch: Throwable -> L24
        monitor-exit(r22);     // Catch: Throwable -> L24
    L28:
        if (r17 != null) goto L59;
        r16.f16662c = 404;
        r16.d = "Not found";
        r16.e = ai.p.d("No handler found\n", "text/plain");
    L36:
        if (r19 == false) goto L77;
        ai.p r23 = r16.e;
        if (r23 == null) goto L41;
        String r24 = (String) r23.f287b;
        ((ArrayList) r16.f16659a).add("Content-Type");
        ((ArrayList) r16.f16660b).add(r24);
        String r25 = String.valueOf(((byte[]) r16.e.f288c).length);
        ((ArrayList) r16.f16659a).add("Content-Length");
        ((ArrayList) r16.f16660b).add(r25);
    L41:
        d(r16, r12);
        ai.p r26 = r16.e;
        if (r26 == null) goto L3;
        r10.write((byte[]) r26.f288c);
        goto L3
    L77:
        return;
    L59:
        r19 = r17.a(r13, r21, r16);     // Catch: RuntimeException -> L32
    L32:
        e = move-exception;
        r16.f16662c = 500;
        r16.d = "Internal Server Error";
        StringWriter r27 = new StringWriter();
        PrintWriter r28 = new PrintWriter(r27);
        e.printStackTrace(r28);     // Catch: Throwable -> L44
        r28.close();
        r16.e = ai.p.d(r27.toString(), "text/plain");
    L44:
        th = move-exception;
        r28.close();
        throw th;
    L27:
        monitor-exit(r22);
    L24:
        th = move-exception;
        throw th;
    L49:
        return;
    L6:
        String[] r29 = r18.split(" ", 3);
        if (r29.length != 3) goto L58;
        String r30 = r29[0];
        r15.f16661c = Uri.parse(r29[1]);
        String r31 = r29[2];
    L9:
        String r32 = r11.c();
        if (r32 == null) goto L56;
        if ("".equals(r32) == true) goto L13;
        String[] r112 = r32.split(": ", 2);
        if (r112.length != 2) goto L54;
        String r33 = r112[0];
        String r113 = r112[1];
        ((ArrayList) r15.f16659a).add(r33);
        ((ArrayList) r15.f16660b).add(r113);
        goto L9
    L54:
        throw new IOException("Malformed header: ".concat(r32));
    L13:
        r21 = r15;
        goto L14
    L56:
        throw new EOFException();
    L58:
        throw new IOException("Invalid request line: ".concat(r18));
    }

    @Override // yq.b
    public CharSequence c(CalendarDay r5) {
        LocalDate r10 = r5.f12167a;
        return ((org.threeten.bp.format.b) this.f10812a).a(r10);
    }

    @Override // ng.a
    public void e(long r5) {
        ((mg.b) this.f10812a).d.put(AsyncTaskType.LIGHT_WEIGHT, Long.valueOf(r5));
    }

    @Override // pt.p
    public boolean test(Object r5) {
        return io.reactivex.internal.functions.e.b(r5, this.f10812a);
    }

    public x0(int r5) {
        switch(r5) {
            case 6: goto L7;
            case 11: goto L5;
            default: goto L3;
        };
    L3:
        this.f10812a = new SparseArray();
        return;
    L5:
        org.threeten.bp.format.b r10 = org.threeten.bp.format.b.f;
        org.threeten.bp.format.s r11 = new org.threeten.bp.format.s();
        r11.g("LLLL yyyy");
        this.f10812a = r11.p();
        return;
    L7:
        this.f10812a = new HashMap();
    }

    public x0(ug.d r5) {
        Intrinsics.checkNotNullParameter(r5, "airSolutionContext");
        this.f10812a = r5;
    }
}
