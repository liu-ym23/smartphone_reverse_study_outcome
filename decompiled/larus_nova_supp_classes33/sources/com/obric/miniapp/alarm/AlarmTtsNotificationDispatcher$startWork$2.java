package com.obric.miniapp.alarm;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.utils.logger.FLogger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.miniapp.alarm.AlarmTtsNotificationDispatcher$startWork$2", f = "AlarmTtsNotificationDispatcher.kt", i = {}, l = {100}, m = "invokeSuspend", n = {}, s = {})
final class AlarmTtsNotificationDispatcher$startWork$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public static final class a<T> implements FlowCollector {
        public static final a<T> a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final Object emit(Object r21, Continuation r22) {
            f0 r0 = (f0) r21;
            Lazy r1 = AlarmTtsNotificationDispatcher.a;
            FLogger r2 = FLogger.a;
            r2.i("AlarmTtsNotification", "flush: group=" + r0);
            if (r0.b == true) goto L5;
            r2.i("AlarmTtsNotification", "flush: exit, cause bluetooth headset not connected");
        L114:
            return Unit.INSTANCE;
        L5:
            Regex r3 = l.a;
            List<e0> r4 = r0.a;
            Intrinsics.checkNotNullParameter(r4, "entries");
            r2.i("AlarmTtsNotification", "combine start: entries=" + r4);
            String r5 = "";
            l.a r6 = null;
            String r7 = null;
            r6 = null;
            if (r4.isEmpty() == true) goto L100;
            List<e0> r8 = r4;
            ArrayList r11 = new ArrayList();
            Iterator<T> r9 = r8.iterator();
        L10:
            if (r9.hasNext() == false) goto L17;
            String r10 = ((e0) r9.next()).a;
            if ((true ^ StringsKt.isBlank(r10)) == true) goto L15;
            r10 = null;
        L15:
            if (r10 == null) goto L10;
            r11.add(r10);
            goto L10
        L17:
            LinkedHashSet r12 = new LinkedHashSet();
            LinkedHashSet r13 = new LinkedHashSet();
            Iterator<T> r14 = r8.iterator();
            String r15 = null;
            boolean r16 = false;
        L19:
            if (r14.hasNext() == false) goto L73;
            q r17 = ((e0) r14.next()).b;
            String r18 = r17.a;
            if (r18 == null) goto L30;
            String r19 = StringsKt.trim(r18).toString();
            if (r19 == null) goto L30;
            if ((!StringsKt.isBlank(r19)) == true) goto L28;
            r19 = null;
        L28:
            if (r19 == null) goto L30;
            r12.add(r19);
        L30:
            if (r16 == false) goto L32;
        L35:
            r16 = true;
        L36:
            String r110 = r17.b;
            if (r110 != null) goto L39;
            r110 = "";
        L39:
            String r111 = StringsKt.trim(r110).toString();
            if (StringsKt.isBlank(r111) == true) goto L19;
            List r112 = SequencesKt.toList(SequencesKt.mapNotNull(Regex.findAll$default(l.a, r111, 0, 2, null), new k()));
            if (r112.size() < 2) goto L46;
            String r113 = StringsKt.trim((String) ListProtector.get(r112, 0)).toString();
            String r114 = StringsKt.trim((String) ListProtector.get(r112, 1)).toString();
            if (StringsKt.isBlank(r113) == true) goto L46;
            l.b r115 = new l.b(r113, r114);
        L48:
            if (r15 != null) goto L50;
        L53:
            boolean r116 = true;
        L54:
            if (r116 == false) goto L58;
            if (r115 == null) goto L57;
            r15 = r115.a;
            goto L58
        L57:
            r15 = null;
        L58:
            if (r115 == null) goto L71;
            String r117 = r115.b;
            if (r117 == null) goto L71;
            String r118 = StringsKt.trim(r117).toString();
            if (r118 == null) goto L71;
            String r119 = new Regex("[()（）]").replace(r118, "");
            if (r119 == null) goto L71;
            if ((!StringsKt.isBlank(r119)) == true) goto L69;
            r119 = null;
        L69:
            if (r119 == null) goto L71;
        L72:
            r13.add(r119);
        L71:
            r119 = "有一个日程";
            goto L72
        L50:
            if (StringsKt.isBlank(r15) == true) goto L53;
            r116 = false;
        L46:
            r115 = null;
            goto L48
        L32:
            if (r17.c == true) goto L35;
            r16 = false;
            goto L36
        L73:
            if (r15 == null) goto L115;
            if ((!StringsKt.isBlank(r15)) == true) goto L78;
            r15 = null;
        L78:
            if (r15 == null) goto L115;
        L83:
            List r20 = CollectionsKt.toList(r13);
            if (r20.isEmpty() == true) goto L100;
            StringBuilder r23 = new StringBuilder("豆包提醒你");
            if ((!StringsKt.isBlank(r15)) == false) goto L89;
            r23.append(r15);
        L89:
            Iterator<T> r24 = r20.iterator();
        L91:
            if (r24.hasNext() == false) goto L93;
            r23.append((String) r24.next());
            goto L91
        L93:
            String r25 = r23.toString();
            Iterator<T> r26 = r12.iterator();
        L95:
            if (r26.hasNext() == false) goto L99;
            T r27 = r26.next();
            if ((!StringsKt.isBlank((String) r27)) == false) goto L95;
            r7 = r27;
        L99:
            r6 = new l.a(r25, r7, r16, r4.size(), r11);
            FLogger.a.i("AlarmTtsNotification", "combine end: " + r6);
        L115:
            r15 = StringsKt.replace$default(new SimpleDateFormat("ah点m分", Locale.CHINA).format(new Date(System.currentTimeMillis())), " ", "", false, 4, null);     // Catch: Exception -> L82
        L82:
            r15 = "";
        L100:
            if (r6 == null) goto L114;
            FLogger.a.i("AlarmTtsNotification", "start tts, content: " + r6.a);
            ((r) AlarmTtsNotificationDispatcher.a.getValue()).a(r6.a);
            if (r6.c == false) goto L114;
            String r28 = r6.b;
            if (r28 == null) goto L110;
            r5 = r28;
        L110:
            if (StringsKt.isBlank(r5) == true) goto L114;
            JSONObject r29 = new JSONObject();
            r29.put("bluetooth_encrypted_id", r0.d);
            r29.put("device_product_type", r0.e);
            ((m) AlarmTtsNotificationDispatcher.b.getValue()).report(r5, r29);
            goto L114
        }
    }

    public AlarmTtsNotificationDispatcher$startWork$2(Continuation<? super AlarmTtsNotificationDispatcher$startWork$2> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new AlarmTtsNotificationDispatcher$startWork$2(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        AlarmTtsNotificationDispatcher$special$$inlined$map$1 r5 = AlarmTtsNotificationDispatcher.d;
        FlowCollector r2 = a.a;
        this.label = 1;
        if (r5.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
