package com.larus.bmhome.chat.list.cell.record;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import com.bytedance.common.utility.NetworkUtils;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.chat.layout.item.RecordStatus;
import com.larus.bmhome.chat.layout.item.u3;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import ic8.p0;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class h implements p68.c {
    public final /* synthetic */ Message a;
    public final /* synthetic */ RecordCardCell b;
    public final /* synthetic */ Ref.ObjectRef<p68.c> c;

    public static final class a extends ConnectivityManager.NetworkCallback {
        public final /* synthetic */ RecordCardCell a;
        public final /* synthetic */ Message b;
        public final /* synthetic */ int c;
        public final /* synthetic */ String d;
        public final /* synthetic */ long e;

        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onAvailable(Network r8) {
            Intrinsics.checkNotNullParameter(r8, "network");
            RecordCardCell r1 = this.a;
            RecordStatus r2 = RecordStatus.RecordInterruptedFinish;
            String r9 = this.b.getMessageId();
            String r0 = "";
            if (r9 != null) goto L5;
            String r3 = "";
        L6:
            Integer r4 = Integer.valueOf(this.c);
            String r5 = this.d;
            Map r10 = RecordCardCell.m;
            r1.o(r2, r3, r4, r5, "onRecordingStop in cell onAvailable");
            RecordCardCell r11 = this.a;
            String r6 = this.b.getMessageId();
            if (r6 != null) goto L9;
            r6 = "";
        L9:
            String r7 = this.b.getConversationId();
            if (r7 == null) goto L13;
            r0 = r7;
        L13:
            r11.x("voice_note_recording_interrupted", r6, r0, new Pair[]{TuplesKt.to("error_type", "offline_end"), TuplesKt.to("error_time", Long.valueOf(this.e))});
            return;
        L5:
            r3 = r9;
            goto L6
        }

        public a(RecordCardCell r1, Message r2, int r3, String r4, long r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }
    }

    public final void c(int r1) {
    }

    public final void e(String r1) {
    }

    public final void f(byte[] r1) {
    }

    public final void a(String r10) {
        Intrinsics.checkNotNullParameter(r10, "meetingId");
        FLogger.a.d("RecordCardBox", "onRecordingStart, msgId: " + this.a.getMessageId());
        Map r0 = RecordCardCell.m;
        String r1 = this.a.getMessageId();
        String r2 = "";
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        RecordCardCell.n = r1;
        RecordCardCell r3 = this.b;
        RecordStatus r4 = RecordStatus.RECORDING;
        String r5 = this.a.getMessageId();
        if (r5 != null) goto L8;
        String r6 = "";
    L9:
        RecordCardCell.r(r3, r4, r6, r10, "onRecordingStart in cell", 4);
        q0 r11 = lf8.a.b(this.b);
        String r7 = null;
        if (r11 == null) goto L21;
        List r12 = r11.getCurrentList();
        if (r12 == null) goto L21;
        Message r8 = this.a;
        Iterator r13 = r12.iterator();
    L15:
        if (r13.hasNext() == false) goto L19;
        Object r9 = r13.next();
        if (Intrinsics.areEqual(((Message) r9).getMessageId(), r8.getReplyId()) == false) goto L15;
    L20:
        Message r14 = (Message) r9;
    L22:
        RecordCardCell r15 = this.b;
        String r16 = this.a.getMessageId();
        if (r16 != null) goto L25;
        r16 = "";
    L25:
        String r17 = this.a.getConversationId();
        if (r17 == null) goto L29;
        r2 = r17;
    L29:
        Pair[] r18 = new Pair[2];
        if (r14 == null) goto L35;
        Map r19 = r14.getExt();
        if (r19 == null) goto L35;
        r7 = (String) r19.get("action_bar_key");
    L35:
        if (Intrinsics.areEqual(r7, "coco_record") == false) goto L37;
        String r20 = "action_bar";
    L38:
        r18[0] = TuplesKt.to("sec_scene", r20);
        r18[1] = TuplesKt.to("interval", Long.valueOf(System.currentTimeMillis() - this.b.h));
        r15.x("voice_note_recording_start", r16, r2, r18);
        return;
    L37:
        r20 = "query";
        goto L38
    L19:
        r9 = null;
    L21:
        r14 = null;
        goto L22
    L8:
        r6 = r5;
        goto L9
    }

    public final void b(String r10) {
        Intrinsics.checkNotNullParameter(r10, "meetingId");
        FLogger.a.d("RecordCardBox", "received meeting_id: " + r10 + ", msgId: " + this.a.getMessageId());
        RecordStatus r4 = RecordStatus.RECORDING;
        String r0 = this.a.getMessageId();
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        String r5 = r0;
        u3 r1 = this.b.e;
        if (r1 == null) goto L8;
        int r2 = r1.getDuration();
    L9:
        this.b.o(r4, r5, Integer.valueOf(r2), r10, "onMeetingIdGenerated in cell");
        return;
    L8:
        r2 = 0;
        goto L9
    }

    public final void d(int r17, String r18) {
        FLogger r1 = FLogger.a;
        r1.d("RecordCardBox", "onRecordingStop, msgId: " + this.a.getMessageId() + " total record seconds: " + r17);
        Map r2 = RecordCardCell.m;
        String r11 = "";
        Intrinsics.checkNotNullParameter("", "<set-?>");
        RecordCardCell.n = "";
        u3 r3 = this.b.e;
        String r12 = null;
        if (r3 == null) goto L5;
        RecordStatus r4 = r3.getRecordStatus();
    L7:
        if (r4 != RecordStatus.Connecting) goto L9;
        RecordStatus r5 = RecordStatus.EarlyEndError;
    L10:
        r1.i("RecordCardBox", "user end record, update remote status to " + r5 + ", duration to " + r17 + ", meetingId to " + r18);
        RecordCardCell r6 = this.b;
        u3 r7 = r6.e;
        if (r7 == null) goto L28;
        Message r8 = this.a;
        u7 r9 = (u7) r6.l.getValue();
        if (r9 == null) goto L19;
        String r10 = r8.getMessageId();
        if (r10 != null) goto L17;
        r10 = "";
    L17:
        r9.lB(r10, new p0(r18, Integer.valueOf(r5.getType()), Integer.valueOf(r17), 3199));
    L19:
        if (NetworkUtils.isNetworkAvailable(r7.getContext()) == false) goto L47;
        String r13 = r8.getMessageId();
        if (r13 != null) goto L23;
        String r14 = "";
    L24:
        r6.o(r5, r14, Integer.valueOf(r17), r18, "onRecordingStop in cell isNetworkAvailable");
        goto L28
    L23:
        r14 = r13;
        goto L24
    L47:
        Object r15 = r7.getContext().getSystemService("connectivity");     // Catch: Exception -> L27
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type android.net.ConnectivityManager");     // Catch: Exception -> L27
        ((ConnectivityManager) r15).registerNetworkCallback(new NetworkRequest.Builder().build(), new a(r6, r8, r17, r18, System.currentTimeMillis()));     // Catch: Exception -> L27
    L27:
        FLogger.a.i("RecordCardBox", "registerNetworkCallback failed " + r18);
    L28:
        p68.c r16 = (p68.c) this.c.element;
        if (r16 == null) goto L31;
        this.b.i.k(r16);
    L31:
        RecordCardCell r19 = this.b;
        String r20 = this.a.getMessageId();
        if (r20 != null) goto L34;
        r20 = "";
    L34:
        String r21 = this.a.getConversationId();
        if (r21 == null) goto L38;
        r11 = r21;
    L38:
        Pair[] r22 = new Pair[3];
        Map r23 = this.a.getExt();
        if (r23 == null) goto L42;
        r12 = (String) r23.get("action_bar_key");
    L42:
        if (Intrinsics.areEqual(r12, "coco_record") == false) goto L44;
        String r24 = "action_bar";
    L45:
        r22[0] = TuplesKt.to("sec_scene", r24);
        r22[1] = TuplesKt.to("error_type", "none");
        r22[2] = TuplesKt.to("duration", Integer.valueOf(RangesKt.coerceAtLeast(r17, 0) * 1000));
        r19.x("voice_note_recording_end", r20, r11, r22);
        RecordCardCell.p.add(this.a.getMessageId());
        return;
    L44:
        r24 = "query";
        goto L45
    L9:
        r5 = RecordStatus.RECORD_FINISHED;
        goto L10
    L5:
        r4 = null;
        goto L7
    }

    public h(Message r1, RecordCardCell r2, Ref.ObjectRef<p68.c> r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
