package com.obric.miniapp.alarm;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.utils.logger.FLogger;
import java.io.File;
import java.security.SecureRandom;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/obric/miniapp/alarm/Alarm;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.miniapp.alarm.AlarmManager$loadAlarmsV0$1", f = "AlarmManager.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2}, l = {91, 127, 129}, m = "invokeSuspend", n = {"$this$flow", "id", "file", "activeCount", "index", "$this$flow", "file", "activeCount", "index", "$this$flow", "activeCount", "index"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "I$0", "I$1", "L$0", "I$0", "I$1"})
final class AlarmManager$loadAlarmsV0$1 extends SuspendLambda implements Function2<FlowCollector<? super a>, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $alarmCount;
    final /* synthetic */ File $extraInfoDir;
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: renamed from: com.obric.miniapp.alarm.AlarmManager$loadAlarmsV0$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.miniapp.alarm.AlarmManager$loadAlarmsV0$1$1", f = "AlarmManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ File $file;
        int label;

        public AnonymousClass1(File r1, Continuation<? super AnonymousClass1> r2) {
            this.$file = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.$file, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r3);
            if (this.$file.delete() == true) goto L8;
            FLogger.a.w("AlarmManager", "Delete extraInfo file failed: " + this.$file.getName());
        L8:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public AlarmManager$loadAlarmsV0$1(int r1, File r2, Continuation<? super AlarmManager$loadAlarmsV0$1> r3) {
        this.$alarmCount = r1;
        this.$extraInfoDir = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        AlarmManager$loadAlarmsV0$1 r0 = new AlarmManager$loadAlarmsV0$1(this.$alarmCount, this.$extraInfoDir, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((FlowCollector) r1, (Continuation) r2);
    }

    public final Object invoke(FlowCollector<? super a> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x008d -> B:58:0x026b). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x0268 -> B:57:0x0269). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r31) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        String r3 = null;
        boolean r4 = false;
        if (r2 == 0) goto L12;
        if (r2 == 1) goto L11;
        if (r2 == 2) goto L10;
        if (r2 != 3) goto L9;
        int r5 = this.I$1;
        int r9 = this.I$0;
        FlowCollector r10 = (FlowCollector) this.L$0;
        ResultKt.throwOnFailure(r31);
        AlarmManager$loadAlarmsV0$1 r6 = this;
    L57:
        FlowCollector r12 = r10;
        AlarmManager$loadAlarmsV0$1 r11 = r6;
    L58:
        r5 = r5 + 1;
        r4 = false;
    L14:
        if (r5 >= r11.$alarmCount) goto L59;
        AlarmManager r13 = AlarmManager.a;
        r13.getClass();
        String r14 = AlarmManager.j().getString("alarm_" + r5 + "_id", r3);
        if (r14 == null) goto L58;
        boolean r7 = AlarmManager.j().getBoolean("alarm_" + r5 + "_is_active", true);
        File r15 = new PolarisFileWrapper(r11.$extraInfoDir, "extra_info_" + r14 + ".json");
        if (r7 == false) goto L51;
        Boolean r8 = Boxing.boxBoolean(AlarmManager.j().getBoolean("alarm_" + r5 + "_has_extra_info", r4));
        if (r8.booleanValue() == true) goto L24;
        r8 = null;
    L24:
        if (r8 == null) goto L33;
        r8.booleanValue();
        r11.L$0 = r12;
        r11.L$1 = r14;
        r11.L$2 = r15;
        r11.I$0 = r9;
        r11.I$1 = r5;
        r11.label = 1;
        Object r16 = AlarmManager.c(r13, r15, r11);
        if (r16 != r1) goto L28;
        return r1;
    L28:
        String r17 = r14;
    L29:
        Map r18 = (Map) r16;
        if (r18 != null) goto L32;
        r14 = r17;
        goto L33
    L32:
        String r19 = r17;
    L34:
        String r20 = (String) r18.get("notify");
        if (r20 == null) goto L37;
        boolean r28 = StringsKt.equals(r20, "alarm", true);
    L38:
        boolean r21 = w.b;
        w r22 = w.a.a();
        AlarmManager.a.getClass();
        Long r23 = Boxing.boxLong(AlarmManager.j().getLong("alarm_" + r5 + "_created_at", 0));
        if (r23.longValue() == 0) goto L41;
        boolean r110 = true;
    L42:
        if (r110 == true) goto L45;
        r23 = null;
    L45:
        if (r23 == null) goto L47;
        w r26 = w.a.b(r23.longValue());
    L48:
        String r111 = AlarmManager.j().getString("alarm_" + r5 + "_title", "");
        Intrinsics.checkNotNull(r111);
        String r112 = AlarmManager.j().getString("alarm_" + r5 + "_content", "");
        Intrinsics.checkNotNull(r112);
        Map r27 = r18;
        a r24 = new a(r19, r111, r112, w.a.b(AlarmManager.j().getLong("alarm_" + r5 + "_trigger_time", 0)), AlarmManager.j().getLong("alarm_" + r5 + "_interval_minutes", 0), AlarmManager.j().getInt("alarm_" + r5 + "_repeat_count", 0), AlarmManager.j().getInt("alarm_" + r5 + "_current_repeat_count", 0), true, r26, r27, r28, String.valueOf(((SecureRandom) AlarmManager.e.getValue()).nextLong()));
        r9 = r9 + 1;
        r11.L$0 = r12;
        r11.L$1 = r15;
        r3 = null;
        r11.L$2 = null;
        r11.I$0 = r9;
        r11.I$1 = r5;
        r11.label = 2;
        if (r12.emit(r24, r11) != r1) goto L52;
        return r1;
    L52:
        r6 = r11;
        File r113 = r15;
    L53:
        CoroutineDispatcher r114 = Dispatchers.getIO();
        AnonymousClass1 r115 = new AnonymousClass1(r113, r3);
        r6.L$0 = r12;
        r6.L$1 = r3;
        r6.I$0 = r9;
        r6.I$1 = r5;
        r6.label = 3;
        if (BuildersKt.withContext(r114, r115, r6) != r1) goto L56;
        return r1;
    L56:
        r10 = r12;
        goto L57
    L47:
        r26 = r22;
        goto L48
    L41:
        r110 = false;
        goto L42
    L37:
        r28 = false;
    L33:
        r18 = new LinkedHashMap();
        r19 = r14;
        goto L34
    L51:
        r3 = null;
        goto L52
    L59:
        FLogger r25 = FLogger.a;
        r25.i("AlarmManager", "loadAlarmsV0() finished, active alarms count: " + r9);
        if (r11.$extraInfoDir.delete() == true) goto L63;
        r25.i("AlarmManager", "Delete extraInfo dir failed; not empty?");
    L63:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        r5 = this.I$1;
        r9 = this.I$0;
        r113 = (File) this.L$1;
        FlowCollector r116 = (FlowCollector) this.L$0;
        ResultKt.throwOnFailure(r31);
        r6 = this;
        r12 = r116;
        goto L53
    L11:
        r5 = this.I$1;
        r9 = this.I$0;
        File r117 = (File) this.L$2;
        r17 = (String) this.L$1;
        r12 = (FlowCollector) this.L$0;
        ResultKt.throwOnFailure(r31);
        r16 = r31;
        r15 = r117;
        r11 = this;
        goto L29
    L12:
        ResultKt.throwOnFailure(r31);
        r11 = this;
        r12 = (FlowCollector) this.L$0;
        r5 = 0;
        r9 = 0;
        goto L14
    }
}
