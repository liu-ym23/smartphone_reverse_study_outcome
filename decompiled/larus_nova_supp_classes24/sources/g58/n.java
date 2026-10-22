package g58;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.media.MediaResourceManager;
import com.larus.utils.l0;
import com.larus.utils.logger.FLogger;
import com.mammon.audiosdk.enums.SAMICoreCallBackEventType;
import com.mammon.audiosdk.enums.SAMICoreDataType;
import com.mammon.audiosdk.structures.SAMICoreWebSocketConnectionEvent;
import kotlin.Lazy;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class n implements r78.b {
    public final /* synthetic */ h a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ String c;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[SAMICoreCallBackEventType.values().length];
            r0[SAMICoreCallBackEventType.TaskStarted.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r0[SAMICoreCallBackEventType.SessionStarted.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r0[SAMICoreCallBackEventType.TaskFailed.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[SAMICoreCallBackEventType.SessionFailed.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[SAMICoreCallBackEventType.ASRInfo.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r0[SAMICoreCallBackEventType.WebSocketStateChanged.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r0[SAMICoreCallBackEventType.ASREnded.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            a = r0;
        }
    }

    @Override // r78.b
    public final void a(int r9, final r78.a r10) {
        Intrinsics.checkNotNullParameter(r10, "data");
        SAMICoreCallBackEventType r11 = SAMICoreCallBackEventType.fromInt(r9);
        int r0 = -1;
        if (r11 != null) goto L5;
        int r1 = -1;
    L6:
        boolean r3 = false;
        switch(r1) {
            case 1: goto L55;
            case 2: goto L38;
            case 3: goto L33;
            case 4: goto L33;
            case 5: goto L32;
            case 6: goto L11;
            case 7: goto L9;
            default: goto L68;
        };
    L9:
        FLogger.a.i("AiAsrManager", "ASREnded, data: " + g2a.d.c(GsonProtectorUtils.toJson(new Gson(), ArraysKt.firstOrNull(r10.c))));
        h.b(this.a, this.c);
        return;
    L32:
        int r12 = l0.a;
        final h r13 = this.a;
        l0.b(new k(r10, r13));
        return;
    L33:
        FLogger.a.i("AiAsrManager", r11 + ", data: " + g2a.d.c(GsonProtectorUtils.toJson(new Gson(), ArraysKt.firstOrNull(r10.c))));
        h r2 = this.a;
        if (r11 == SAMICoreCallBackEventType.TaskFailed) goto L37;
        r0 = -2;
    L37:
        r2.j = r0;
        r2.k = g2a.d.c(GsonProtectorUtils.toJson(new Gson(), ArraysKt.firstOrNull(r10.c)));
        h.a(this.a);
        com.larus.audio.ainotes.a.a.a("sami task failed");
        h.b(this.a, this.c);
        return;
    L38:
        FLogger r14 = FLogger.a;
        r14.i("AiAsrManager", "SessionStarted, isSessionValid: " + this.a.r + ", hasCalledEndAsr: " + this.a.s);
        h r15 = this.a;
        if (r15.f == true) goto L42;
        r15.f = true;
    L42:
        if (r15.r == false) goto L44;
        return;
    L44:
        if (r15.s == true) goto L64;
        r15.r = true;
        r15.o = System.currentTimeMillis();
        i58.e r16 = this.a.c();
        String r4 = this.a.h;
        r16.getClass();
        String r5 = "";
        l0.b(new i58.a(r4, 0, ""));
        if (this.b == true) goto L48;
        Lazy r17 = MediaResourceManager.a;
        final h r19 = this.a;
        MediaResourceManager.l(r19.y, r19.x, new i(r19), new j(r19), 48);
        return;
    L48:
        r14.i("AiAsrManager", "record in DoraG, not requestMedia");
        h r110 = this.a;
        r110.getClass();
        r14.i("AiAsrManager", "startTimeLimitTimer");
        q r20 = new q();
        r110.w = r20;
        r20.d();
        h r21 = this.a;
        p68.c r111 = r21.t;
        if (r111 == null) goto L66;
        String r22 = r21.i;
        if (r22 == null) goto L54;
        r5 = r22;
    L54:
        r111.a(r5);
        return;
    L66:
        return;
    L64:
        return;
    L55:
        FLogger.a.i("AiAsrManager", "TaskStarted, isSessionValid: " + this.a.r + ", hasCalledEndAsr: " + this.a.s);
        return;
    L68:
        return;
    L11:
        if (r10.a != SAMICoreDataType.SAMICoreDataType_WebSocket_Connection_Event.getValue()) goto L58;
        Object r23 = ArraysKt.firstOrNull(r10.c);
        Integer r6 = null;
        if ((r23 instanceof SAMICoreWebSocketConnectionEvent) == false) goto L15;
        SAMICoreWebSocketConnectionEvent r24 = (SAMICoreWebSocketConnectionEvent) r23;
    L16:
        FLogger r7 = FLogger.a;
        StringBuilder r8 = new StringBuilder("WebSocketStateChanged, state=");
        if (r24 == null) goto L19;
        r6 = Integer.valueOf(r24.state);
    L19:
        r8.append(r6);
        r8.append(", data: ");
        r8.append(g2a.d.c(GsonProtectorUtils.toJson(new Gson(), ArraysKt.firstOrNull(r10.c))));
        r7.i("AiAsrManager", r8.toString());
        if (r24 != null) goto L22;
    L24:
        boolean r25 = false;
    L25:
        if (r25 == true) goto L31;
        if (r24 != null) goto L28;
    L30:
        if (r3 == true) goto L31;
        return;
    L28:
        if (r24.state != 3) goto L30;
        r3 = true;
    L31:
        h r26 = this.a;
        r26.j = -3;
        r26.k = g2a.d.c(GsonProtectorUtils.toJson(new Gson(), ArraysKt.firstOrNull(r10.c)));
        h.a(this.a);
        com.larus.audio.ainotes.a.a.a("WebSocket connect exception");
        h.b(this.a, this.c);
        return;
    L22:
        if (r24.state != 2) goto L24;
        r25 = true;
        goto L25
    L15:
        r24 = null;
        goto L16
    L58:
        return;
    L5:
        r1 = a.a[r11.ordinal()];
        goto L6
    }

    public n(h r1, boolean r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
