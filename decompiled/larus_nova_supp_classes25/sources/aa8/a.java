package aa8;

import com.google.gson.Gson;
import com.larus.audio.call.arch.e;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.avlink.n1;
import com.larus.avlink.plugins.n4;
import com.larus.avlink.record.util.LarkRecordMinutesManager;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.SessionService;
import com.larus.im.internal.delegate.c0;
import com.larus.im.service.audio.z0;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.api.bean.ChatParam;
import com.larus.voicecall.api.bean.VisionModeIntention;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import pf9.p;
import pf9.q;
import zd9.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a extends com.larus.audio.call.arch.a<n4> implements e {
    public final String f;

    /* JADX INFO: renamed from: aa8.a$a, reason: collision with other inner class name */
    public static final class C0000a extends z0 {
        public final String a;
        public final /* synthetic */ a b;

        public final String g() {
            return this.a;
        }

        public C0000a(a r1) {
            this.b = r1;
            this.a = r1.f;
        }

        public final void n(z0.a r14) {
            Intrinsics.checkNotNullParameter(r14, "event");
            if ((r14 instanceof q) == false) goto L87;
            a r0 = this.b;
            r0.getClass();
            List r15 = ((q) r14).a;
            ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
            Iterator r16 = r15.iterator();
        L6:
            if (r16.hasNext() == false) goto L106;
            p r2 = (p) r16.next();
            Long r3 = r2.a;
            if (r3 == null) goto L86;
            if (((int) r3.longValue()) != 24) goto L86;
            JSONObject r4 = new JSONObject();
            Map r5 = r2.b;
            if (r5 == null) goto L90;
            Iterator r6 = r5.entrySet().iterator();
        L15:
            if (r6.hasNext() == false) goto L90;
            Map.Entry r7 = (Map.Entry) r6.next();
            r4.putOpt((String) r7.getKey(), r7.getValue());
        L90:
            Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L39
            h r9 = h.a;     // Catch: Throwable -> L39
            String r10 = r4.toString();     // Catch: Throwable -> L39
            if (r10 != null) goto L21;
        L24:
            boolean r11 = true;
        L25:
            if (r11 == false) goto L88;
        L36:
            Object r12 = null;
        L37:
            Object r13 = Result.constructor-impl((ChatParam) r12);     // Catch: Throwable -> L39
        L42:
            if (Result.isFailure-impl(r13) == false) goto L44;
            r13 = null;
        L44:
            ChatParam r17 = (ChatParam) r13;
            Gson r18 = new Gson();     // Catch: Exception -> L51
            if (r17 == null) goto L48;
            String r19 = r17.getVisionModeIntention();     // Catch: Exception -> L51
        L49:
            VisionModeIntention r20 = (VisionModeIntention) r18.fromJson(r19, VisionModeIntention.class);     // Catch: Exception -> L51
        L53:
            if (r20 == null) goto L55;
            Integer r21 = r20.getDoraSpecialMode();
        L56:
            if (r20 == null) goto L58;
            Integer r22 = r20.getVisionEventType();
        L59:
            FLogger.a.i(r0.f, "handleCommandReplyEvent: DORA_VISION_MODE_INTENTION mode:" + r21 + ", status:" + r22);
            if (r21 == null) goto L86;
            if (r21.intValue() != 6) goto L86;
            if (r17 == null) goto L67;
            String r23 = r17.getSourceMessageId();
        L68:
            if (r22 != null) goto L71;
        L80:
            if (r22 != null) goto L83;
        L85:
            n1.d(r0.f, "lark meeting ignore status:" + r22);
            goto L86
        L83:
            if (r22.intValue() != 2) goto L85;
            n1.d(r0.f, "lark meeting stop: stop record by vui");
            LarkRecordMinutesManager.a.K("command_stop");
            goto L86
        L71:
            if (r22.intValue() != 1) goto L80;
            LarkRecordMinutesManager.a.getClass();
            LarkRecordMinutesManager.C(r23);
            LarkRecordMinutesManager.a r24 = LarkRecordMinutesManager.M(99, 14, null);
            r24.getClass();
            if ((r24 instanceof LarkRecordMinutesManager.a.C0023a) == false) goto L75;
            n1.d(r0.f, "lark meeting start: trigger startVUI");
            goto L86
        L75:
            LarkRecordMinutesManager.C(null);
            IDoraService r25 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
            if (r25 == null) goto L86;
            SessionService r26 = r25.d();
            if (r26 == null) goto L86;
            r26.y(4, DoraCallStateCode.DOUBAO_STOP_RECORD_BY_EXCEPTION, false);
            goto L86
        L67:
            r23 = null;
            goto L68
        L58:
            r22 = null;
            goto L59
        L55:
            r21 = null;
            goto L56
        L48:
            r19 = null;
        L51:
            e = move-exception;
            FLogger.a.e(r0.f, "handleCommandReplyEvent: parse intention failed", e);
            r20 = null;
            goto L53
        L88:
            r9.getClass();     // Catch: Throwable -> L29
            r12 = Result.constructor-impl(h.b.fromJson(r10, new b().getType()));     // Catch: Throwable -> L29
        L31:
            Throwable r27 = Result.exceptionOrNull-impl(r12);     // Catch: Throwable -> L39
            if (r27 == null) goto L35;
            c0 r28 = c0.b;     // Catch: Throwable -> L39
            StringBuilder r110 = new StringBuilder();     // Catch: Throwable -> L39
            r110.append("fromJson failed, stack: ");     // Catch: Throwable -> L39
            Intrinsics.checkNotNullParameter(r27, "<this>");     // Catch: Throwable -> L39
            r110.append(ExceptionsKt.stackTraceToString(r27));     // Catch: Throwable -> L39
            r28.e("GsonHolder", r110.toString());     // Catch: Throwable -> L39
        L35:
            if (Result.isFailure-impl(r12) == false) goto L37;
        L29:
            th = move-exception;
            Result.Companion r29 = Result.Companion;     // Catch: Throwable -> L39
            r12 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L39
            goto L31
        L21:
            if (StringsKt.isBlank(r10) == true) goto L24;
            r11 = false;
        L39:
            th = move-exception;
            Result.Companion r30 = Result.Companion;
            r13 = Result.constructor-impl(ResultKt.createFailure(th));
        L86:
            r1.add(r2);
            goto L6
        L106:
            return;
        }
    }

    public final z0 S2() {
        return new C0000a(this);
    }

    public final String T2() {
        return this.f;
    }

    public a(n4 r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.f = "LarkMeetingRecordPlugin";
    }
}
