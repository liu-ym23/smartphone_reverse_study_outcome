package com.larus.audio.ainotes;

import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.audio.bean.RECORD_STATUS;
import com.larus.audio.call.dora.CommandStatus;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadTimer;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a$b implements p68.c {

    public static final class a extends TimerTask {
        public static void a() {
            long r0 = (System.currentTimeMillis() - com.larus.audio.ainotes.a.b) / ((long) CommandStatus.DORA_TRACE);
            FLogger.a.i("AiNoteManager", "onRecordingDurationUpdate: " + r0);
            Iterator r2 = com.larus.audio.ainotes.a.g.iterator();
        L4:
            if (r2.hasNext() == false) goto L6;
            ((p68.c) r2.next()).c((int) r0);
            goto L4
        }

        @Override // java.util.TimerTask, java.lang.Runnable
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

        public a() {
        }
    }

    public a$b() {
    }

    public final void c(int r1) {
    }

    public final void d(int r1, String r2) {
    }

    public final void a(String r7) {
        Intrinsics.checkNotNullParameter(r7, "meetingId");
        FLogger.a.i("AiNoteManager", "onRecordingStart");
        CopyOnWriteArrayList r0 = com.larus.audio.ainotes.a.g;
        if (r0 == null) goto L8;
        Iterator r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        p68.c r2 = (p68.c) r1.next();
        r2.a(r7);
        r2.c(0);
    L8:
        com.larus.audio.ainotes.a.j.setValue(RECORD_STATUS.RECORDING);
        com.larus.audio.ainotes.a.b = System.currentTimeMillis();
        Timer r8 = com.larus.audio.ainotes.a.c;
        if (r8 == null) goto L11;
        r8.cancel();
    L11:
        PthreadTimer r3 = new PthreadTimer("ai_recording_timer");
        com.larus.audio.ainotes.a.c = r3;
        r3.schedule(new a(), 1000, 1000);
    }

    public final void b(String r4) {
        Intrinsics.checkNotNullParameter(r4, "meetingId");
        FLogger.a.i("AiNoteManager", "onMeetingIdGenerated: ".concat(r4));
        CopyOnWriteArrayList r0 = com.larus.audio.ainotes.a.g;
        if (r0 == null) goto L8;
        Iterator r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        ((p68.c) r1.next()).b(r4);
        goto L6
    L10:
        return;
    }

    public final void e(String r2) {
        if (r2 == null) goto L5;
        com.larus.audio.ainotes.a.f.remove(r2);
        return;
    }

    public final void f(byte[] r8) {
        long r0 = System.currentTimeMillis();
        if ((r0 - com.larus.audio.ainotes.a.i) <= 1000) goto L23;
        com.larus.audio.ainotes.a.i = r0;
        FLogger r1 = FLogger.a;
        StringBuilder r2 = new StringBuilder("onRecordedData, size=");
        if (r8 == null) goto L7;
        Integer r3 = Integer.valueOf(r8.length);
    L8:
        r2.append(r3);
        r2.append(", isDataInvalid=");
        int r4 = j58.a.a;
        boolean r5 = false;
        if (r8 == null) goto L22;
        int r6 = r8.length;
        int r7 = 0;
    L12:
        boolean r9 = true;
        if (r7 >= r6) goto L21;
        if (r8[r7] == 0) goto L18;
        r9 = false;
    L18:
        if (r9 == false) goto L22;
        r7 = r7 + 1;
        goto L12
    L21:
        r5 = true;
    L22:
        r2.append(r5);
        r1.i("AiNoteManager", r2.toString());
        goto L23
    L7:
        r3 = null;
    L23:
        CopyOnWriteArrayList r10 = com.larus.audio.ainotes.a.g;
        if (r10 == null) goto L29;
        Iterator r11 = r10.iterator();
    L27:
        if (r11.hasNext() == false) goto L33;
        ((p68.c) r11.next()).f(r8);
        goto L27
    L33:
        return;
    }
}
