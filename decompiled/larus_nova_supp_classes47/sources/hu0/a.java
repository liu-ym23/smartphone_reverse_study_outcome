package hu0;

import android.os.Handler;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.profit.format.ProfitFormatLoaderServiceKt;
import com.bytedance.android.live.profit.format.voicechat.message.MessageType;
import com.bytedance.android.live.profit.format.voicechat.model.VoiceChatState;
import com.bytedance.android.live.profit.format.voicechat.rtc.c;
import com.bytedance.android.live.profit.format.voicechat.trace.VoiceChatTraceStep;
import com.bytedance.android.scope.m;
import com.bytedance.badger.collect.impl.constants.Constants;
import io.reactivex.disposables.Disposable;
import ju0.d;
import ju0.e;
import ju0.f;
import kotlin.ExceptionsKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import nu0.j;
import nu0.l;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public final com.bytedance.android.live.profit.format.voicechat.rtc.b a;
    public final b b;
    public e c;
    public com.bytedance.android.live.profit.format.voicechat.model.e d;
    public boolean e;
    public String f;
    public InterfaceC0249a g;
    public Disposable h;
    public boolean i;

    /* JADX INFO: renamed from: hu0.a$a, reason: collision with other inner class name */
    public interface InterfaceC0249a {
        void a(f r1);

        void b(VoiceChatState r1);

        void c(String r1);
    }

    public static final class b extends c {
        public final /* synthetic */ a a;

        public b(a r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.profit.format.voicechat.rtc.a
        public final void L(String r8) {
            long r0 = System.currentTimeMillis();
            com.bytedance.android.live.profit.format.voicechat.model.e r2 = this.a.d;
            if (r2 == null) goto L5;
            long r3 = r2.e;
        L6:
            long r1 = r0 - r3;
            j.d(this, "onFirstRemoteAudioFrame, id: " + r8, "rtcListener");
            String r9 = mu0.c.a;
            mu0.c.c(VoiceChatTraceStep.FIRST_FRAME, UtilityKotlinExtentionsKt.o(new Pair[]{TuplesKt.to(Constants.Keys.duration, String.valueOf(r1))}), null, 0, 12);
            int r10 = com.bytedance.android.live.profit.format.voicechat.log.a.c;
            com.bytedance.android.live.profit.format.voicechat.log.a.C0020a.a("format_call_first_audio_frame", MapsKt.plus(MapsKt.mapOf(TuplesKt.to(Constants.Keys.duration, String.valueOf(r1))), mu0.c.b));
            return;
        L5:
            r3 = System.currentTimeMillis();
            goto L6
        }

        @Override // com.bytedance.android.live.profit.format.voicechat.rtc.a
        public final void onUserJoined(String r4) {
            Intrinsics.checkNotNullParameter(r4, "interactId");
            j.d(this, "onUserJoined, id: " + r4, "rtcListener");
            com.bytedance.android.live.profit.format.voicechat.model.e r0 = this.a.d;
            if (r0 == null) goto L5;
            String r1 = r0.b;
        L7:
            if (Intrinsics.areEqual(r4, r1) == false) goto L12;
            a r5 = this.a;
            if (r5.i == true) goto L11;
            r5.a.f();
        L11:
            String r6 = mu0.c.a;
            mu0.c.c(VoiceChatTraceStep.JOIN_ROOM, null, null, 1, 6);
            return;
        L12:
            this.a.f = r4;
            String r2 = mu0.c.a;
            Pair[] r3 = {TuplesKt.to("ai_id", r4)};
            Intrinsics.checkNotNullParameter(r3, "params");
            MapsKt.putAll(mu0.c.b, r3);
            Disposable r7 = this.a.h;
            if (r7 == null) goto L17;
            r7.dispose();
            return;
        L17:
            return;
        L5:
            r1 = null;
            goto L7
        }

        @Override // com.bytedance.android.live.profit.format.voicechat.rtc.a
        public final void t(String r3) {
            j.d(this, "onUserLeaved, id: " + r3 + ", reason: 0", "rtcListener");
            if (Intrinsics.areEqual(this.a.f, r3) == false) goto L8;
            InterfaceC0249a r4 = this.a.g;
            if (r4 == null) goto L9;
            r4.c("aiLeave");
            return;
        L9:
            return;
        }

        @Override // com.bytedance.android.live.profit.format.voicechat.rtc.a
        public final void v(long r3) {
            j.b(this, "onError, code: " + r3, null, "rtcListener");
            InterfaceC0249a r4 = this.a.g;
            if (r4 == null) goto L6;
            r4.c("rtcError");
            return;
        }

        @Override // com.bytedance.android.live.profit.format.voicechat.rtc.a
        public final void R(long r5, Exception r7) {
            j.b(this, "onStartFailed, code: " + r5, r7, "rtcListener");
            String r0 = mu0.c.a;
            mu0.c.c(VoiceChatTraceStep.JOIN_ROOM, null, UtilityKotlinExtentionsKt.o(new Pair[]{TuplesKt.to("error_code", String.valueOf(r5)), TuplesKt.to("error_msg", ExceptionsKt.stackTraceToString(r7))}), -1, 2);
            InterfaceC0249a r6 = this.a.g;
            if (r6 == null) goto L6;
            r6.c("userJoinError");
            return;
        }

        @Override // com.bytedance.android.live.profit.format.voicechat.rtc.a
        public final void s(String r9, String r10) {
            if (r10 != null) goto L4;
            return;
        L4:
            d.a.getClass();
            Intrinsics.checkNotNullParameter(r10, Constants.OperatorKey.MSG);
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
            Object r1 = Result.constructor-impl(new JSONObject(r10));     // Catch: Throwable -> L7
        L9:
            Handler r2 = UtilityKotlinExtentionsKt.a;
            JSONObject r3 = new JSONObject();
            if (Result.isFailure-impl(r1) == false) goto L12;
            r1 = r3;
        L12:
            JSONObject r4 = (JSONObject) r1;
            MessageType.a r5 = MessageType.Companion;
            String r6 = r4.optString("type", "unknown");
            r5.getClass();
            Intrinsics.checkNotNullParameter(r6, "type");
            MessageType[] r7 = MessageType.values();
            int r8 = r7.length;
            int r12 = 0;
        L13:
            VoiceChatState r13 = null;
            if (r12 >= r8) goto L19;
            MessageType r14 = r7[r12];
            if (Intrinsics.areEqual(r14.getType(), r6) == true) goto L20;
            r12 = r12 + 1;
        L20:
            if (r14 != null) goto L63;
            r14 = MessageType.UNKNOWN;
        L63:
            Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L24
            Object r16 = Result.constructor-impl(new JSONObject(r4.optString(Constants.Keys.DATA)));     // Catch: Throwable -> L24
        L26:
            JSONObject r17 = new JSONObject();
            if (Result.isFailure-impl(r16) == false) goto L29;
            r16 = r17;
        L29:
            JSONObject r18 = (JSONObject) r16;
            int r19 = ju0.c.a[r14.ordinal()];
            if (r19 != 1) goto L32;
            ju0.b r20 = new e(r18);
        L41:
            if ((r20 instanceof e) == false) goto L57;
            a r22 = this.a;
            e r23 = (e) r20;
            r22.getClass();
            long r24 = r23.c;
            e r110 = r22.c;
            if (r110 == null) goto L45;
            long r25 = r110.c;
        L47:
            if (r24 <= r25) goto L69;
            if (r110 == null) goto L51;
            r13 = r110.b;
        L51:
            if (r13 == r23.b) goto L55;
            j.d(r22, "handleStateChangeMsg, newState: " + r23.a, "rtcManager");
            InterfaceC0249a r111 = r22.g;
            if (r111 == null) goto L55;
            r111.b(r23.b);
        L55:
            r22.c = r23;
            return;
        L69:
            return;
        L45:
            r25 = 0;
            goto L47
        L57:
            if ((r20 instanceof f) == false) goto L61;
            a r26 = this.a;
            f r27 = (f) r20;
            r26.getClass();
            j.d(r26, "handleWarmUpTopicMsg, newState: " + r27.a, "rtcManager");
            InterfaceC0249a r28 = r26.g;
            if (r28 == null) goto L71;
            r28.a(r27);
            return;
        L71:
            return;
        L61:
            j.b(this, "parseMessageFailed, uid: " + r9 + ", message: " + r10, null, "rtcListener");
            return;
        L32:
            if (r19 != 2) goto L34;
            r20 = new f(r18);
            goto L41
        L34:
            if (r19 != 3) goto L37;
            r20 = new ju0.a(r18);
            goto L41
        L37:
            throw new NoWhenBranchMatchedException();
        L24:
            th = move-exception;
            Result.Companion r29 = Result.Companion;
            r16 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L26
        L19:
            r14 = null;
        L7:
            th = move-exception;
            Result.Companion r30 = Result.Companion;
            r1 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L9
        }
    }

    public final void a() {
        StringBuilder r0 = new StringBuilder("stopRoom, roomId: ");
        com.bytedance.android.live.profit.format.voicechat.model.e r1 = this.d;
        if (r1 == null) goto L5;
        String r2 = r1.d.getRtcRoomId();
    L6:
        r0.append(r2);
        j.d(this, r0.toString(), null);
        this.d = null;
        this.g = null;
        this.f = null;
        this.c = null;
        this.e = false;
        this.i = false;
        Disposable r3 = this.h;
        if (r3 == null) goto L9;
        r3.dispose();
    L9:
        this.a.stopAndRelease();
        return;
    L5:
        r2 = null;
        goto L6
    }

    public a() {
        com.bytedance.android.live.profit.format.b r0 = (com.bytedance.android.live.profit.format.b) ProfitFormatLoaderServiceKt.a.getValue();
        Intrinsics.checkNotNullParameter(r0, "$this$rtcService");
        KClass r1 = Reflection.getOrCreateKotlinClass(com.bytedance.android.live.profit.format.voicechat.rtc.b.class);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "serviceType");
        m r2 = m.e;
        com.bytedance.android.live.profit.format.f r3 = r0.a;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("profitFormatScope");
    L5:
        com.bytedance.android.live.profit.format.d r4 = (com.bytedance.android.live.profit.format.d) r2.d(r3, JvmClassMappingKt.getJavaClass(r1));
        if (r4 == null) goto L10;
        this.a = (com.bytedance.android.live.profit.format.voicechat.rtc.b) r4;
        ((iu0.a) l.c.getValue(null, l.a[1])).getClass();
        this.b = new b(this);
        return;
    L10:
        throw new IllegalStateException(("Required service " + r1 + " not found").toString());
    }
}
