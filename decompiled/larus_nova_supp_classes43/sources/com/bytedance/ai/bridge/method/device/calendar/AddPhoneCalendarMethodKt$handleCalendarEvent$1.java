package com.bytedance.ai.bridge.method.device.calendar;

import android.app.Activity;
import com.byted.cast.sink.api.IServerListener;
import com.bytedance.ai.applet.app.AppletApplication;
import com.bytedance.ai.applet.permission.AppletAuthorizeHelper;
import com.bytedance.ai.applet.permission.Scope;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.timon.calendar.EventRecord;
import com.bytedance.timon.calendar.Frequency;
import com.bytedance.timon.calendar.ResultCode;
import com.bytedance.timon.calendar.impl.TimonCalendarImpl;
import f3.h;
import java.security.MessageDigest;
import java.util.Calendar;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.bridge.method.device.calendar.AddPhoneCalendarMethodKt$handleCalendarEvent$1", f = "AddPhoneCalendarMethod.kt", i = {}, l = {94, 104}, m = "invokeSuspend", n = {}, s = {})
final class AddPhoneCalendarMethodKt$handleCalendarEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ String $apiName;
    final /* synthetic */ AppletApplication $app;
    final /* synthetic */ String $appletId;
    final /* synthetic */ f $args;
    final /* synthetic */ h<Object> $callback;
    final /* synthetic */ boolean $repeat;
    final /* synthetic */ Function0<Object> $successModel;
    int label;

    public AddPhoneCalendarMethodKt$handleCalendarEvent$1(AppletApplication r1, h<Object> r10, String r11, Activity r12, f r13, String r14, boolean r15, Function0<Object> r16, Continuation<? super AddPhoneCalendarMethodKt$handleCalendarEvent$1> r17) {
        this.$app = r1;
        this.$callback = r10;
        this.$apiName = r11;
        this.$activity = r12;
        this.$args = r13;
        this.$appletId = r14;
        this.$repeat = r15;
        this.$successModel = r16;
        super(2, r17);
    }

    public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
        return new AddPhoneCalendarMethodKt$handleCalendarEvent$1(this.$app, this.$callback, this.$apiName, this.$activity, this.$args, this.$appletId, this.$repeat, this.$successModel, r12);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r33) {
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L10;
        if (r0 == 1) goto L9;
        if (r0 != 2) goto L8;
        ResultKt.throwOnFailure(r33);
        Object r1 = r33;
        AddPhoneCalendarMethodKt$handleCalendarEvent$1 r11 = this;
    L120:
        g r12 = (g) r1;
        if (r12.a == true) goto L123;
    L125:
        Objects.toString(r12.b);
        h<Object> r13 = r11.$callback;
        StringBuilder r14 = new StringBuilder();
        r14.append(r11.$apiName);
        r14.append(" failed: ");
        switch(g.a.a[r12.b.ordinal()]) {
            case 1: goto L134;
            case 2: goto L134;
            case 3: goto L133;
            case 4: goto L132;
            case 5: goto L131;
            case 6: goto L130;
            case 7: goto L129;
            case 8: goto L129;
            default: goto L128;
        };
    L129:
        String r15 = "add calendar event failed";
    L135:
        String r16 = r12.c;
        if ((!StringsKt.isBlank(r16)) == true) goto L139;
        r16 = null;
    L139:
        if (r16 == null) goto L144;
        String r17 = r15 + ": " + r16;
        if (r17 == null) goto L144;
        r15 = r17;
    L144:
        r14.append(r15);
        h.a.a(r13, r14.toString(), null, null, 14);
    L146:
        return Unit.INSTANCE;
    L130:
        r15 = "calendar store error";
        goto L135
    L131:
        r15 = "calendar event not found";
        goto L135
    L132:
        r15 = "no writable calendar account";
        goto L135
    L133:
        r15 = "invalid calendar event parameter";
        goto L135
    L134:
        r15 = "system calendar permission denied";
        goto L135
    L128:
        throw new NoWhenBranchMatchedException();
    L123:
        if (r12.b != ResultCode.Success) goto L125;
        h.a.b(r11.$callback, (ResultModel) r11.$successModel.invoke());
        goto L146
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r33);
        Object r18 = r33;
    L13:
        com.bytedance.ai.applet.permission.f r19 = (com.bytedance.ai.applet.permission.f) r18;
        if (r19.a == true) goto L20;
        h<Object> r20 = this.$callback;
        String r21 = r19.b;
        if (r21 != null) goto L18;
        r21 = this.$apiName + " authorization failed";
    L18:
        h.a.a(r20, r21, null, null, 14);
        return Unit.INSTANCE;
    L20:
        final Activity r22 = this.$activity;
        String[] r23 = d.a;
        Function1 r24 = com.bytedance.timon.calendar.c.a;
        com.bytedance.timon.calendar.c.b(r22.getApplicationContext());
        TimonCalendarImpl.d = true;
        Function1 r25 = new b(r22);
        Intrinsics.checkNotNullParameter(r25, "invoker");
        com.bytedance.timon.calendar.c.a = r25;
        f r26 = this.$args;
        String r27 = this.$appletId;
        boolean r28 = this.$repeat;
        r26.getClass();
        Intrinsics.checkNotNullParameter(r27, "appletId");
        long r29 = r26.b;
        long r30 = IServerListener.WHAT_BYTELINK_SINK_ERROR;
        long r31 = d.d(r29 * r30, r26.c);
        long r110 = r26.f * r30;
        if (r26.c == false) goto L24;
        r110 = d.d(r110, true);
    L24:
        long r111 = r26.b * r30;
        String r32 = r26.i;
        if (r32 == null) goto L34;
        String r34 = StringsKt.trim(r32).toString();
        if (r34 == null) goto L34;
        if (r34.length() <= 0) goto L31;
        boolean r112 = true;
    L32:
        if (r112 == false) goto L34;
    L35:
        RepeatInterval r35 = r26.j;
        if (r35 != null) goto L38;
        r35 = RepeatInterval.MONTH;
    L38:
        if (r28 == false) goto L56;
        long r36 = r26.b;
        Long r113 = r26.k;
        if (r113 == null) goto L56;
        r113.longValue();
        int r37 = d.a.a[r35.ordinal()];
        if (r37 != 1) goto L44;
        long r210 = 86400;
    L55:
        Integer r38 = Integer.valueOf((int) RangesKt.coerceIn(((r113.longValue() - r36) / r210) + 1, 1, 2147483647L));
    L57:
        EventRecord r39 = new EventRecord();
        String r40 = r26.a;
        long r114 = r39.m();
        RepeatInterval r115 = r35;
        Integer r211 = r38;
        long r41 = r39.e();
        StringBuilder r116 = new StringBuilder("doubao_calendar_");
        r116.append(ArraysKt.joinToString$default(MessageDigest.getInstance("SHA-256").digest((r27 + 31 + r114 + 31 + r41 + 31 + StringsKt.trim(r40).toString()).getBytes(Charsets.UTF_8)), "", null, null, 0, null, new c(), 30, null));
        r39.u(r116.toString());
        r39.D(r26.a);
        r39.C(r31);
        r39.t(r110);
        r39.q(r26.c);
        String r42 = r26.e;
        if (r42 != null) goto L60;
    L62:
        r42 = null;
    L63:
        r39.w(r42);
        String r43 = r26.d;
        if (r43 == null) goto L73;
        String r44 = StringsKt.trim(r43).toString();
        if (r44 == null) goto L73;
        if (r44.length() <= 0) goto L70;
        boolean r45 = true;
    L71:
        if (r45 == false) goto L73;
    L74:
        if (r44 != null) goto L76;
        r44 = r34;
    L79:
        r39.s(r44);
        r39.r(r34);
        r39.v(Integer.valueOf(r26.g ? 1 : 0));
        if (r26.g == false) goto L82;
        Integer r46 = Integer.valueOf((int) RangesKt.coerceAtMost(r26.h / 60, 2147483647L));
    L83:
        r39.p(r46);
        if (r28 == false) goto L117;
        r39.x(true);
        Calendar r47 = Calendar.getInstance();
        r47.setTimeInMillis(r111);
        int r48 = d.a.a[r115.ordinal()];
        if (r48 != 1) goto L88;
        String r49 = Frequency.DAILY.getValue();
    L116:
        r39.z(r49);
        r39.y(r211);
        goto L117
    L88:
        if (r48 != 2) goto L90;
        StringBuilder r50 = new StringBuilder();
        r50.append(Frequency.WEEKLY.getValue());
        r50.append(";WKST=");
        Intrinsics.checkNotNull(r47);
        int r51 = r47.get(7);
        if (r51 != 1) goto L100;
        String r52 = "SU";
    L114:
        r50.append(r52);
        r49 = r50.toString();
        goto L116
    L100:
        if (r51 != 3) goto L102;
        r52 = "TU";
        goto L114
    L102:
        if (r51 == 4) goto L111;
        if (r51 != 5) goto L105;
        r52 = "TH";
        goto L114
    L105:
        if (r51 == 6) goto L109;
        if (r51 == 7) goto L108;
        r52 = "MO";
        goto L114
    L108:
        r52 = "SA";
        goto L114
    L109:
        r52 = "FR";
        goto L114
    L111:
        r52 = "WE";
        goto L114
    L90:
        if (r48 != 3) goto L92;
        r49 = Frequency.MONTHLY.getValue() + ";BYMONTHDAY=" + r47.get(5);
        goto L116
    L92:
        if (r48 != 4) goto L95;
        r49 = Frequency.YEARLY.getValue() + ";BYMONTH=" + (r47.get(2) + 1) + ";BYMONTHDAY=" + r47.get(5);
        goto L116
    L95:
        throw new NoWhenBranchMatchedException();
    L117:
        r11 = this;
        Activity r53 = r11.$activity;
        r11.label = 2;
        r1 = BuildersKt.withContext(Dispatchers.getIO(), new AddPhoneCalendarMethodKt$insertOrUpdateCalendarEvent$2(r53, r39, null), r11);
        if (r1 != r10) goto L120;
        return r10;
    L82:
        r46 = null;
        goto L83
    L76:
        if (r34 == null) goto L79;
        r44 = r44 + '\n' + r34;
        goto L79
    L70:
        r45 = false;
    L73:
        r44 = null;
        goto L74
    L60:
        if (Boolean.valueOf(!StringsKt.isBlank(r42)).booleanValue() == false) goto L62;
    L44:
        if (r37 != 2) goto L46;
        r210 = 604800;
        goto L55
    L46:
        if (r37 != 3) goto L48;
        r210 = 2592000;
        goto L55
    L48:
        if (r37 != 4) goto L51;
        r210 = 31536000;
        goto L55
    L51:
        throw new NoWhenBranchMatchedException();
    L56:
        r38 = null;
        goto L57
    L31:
        r112 = false;
    L34:
        r34 = null;
        goto L35
    L10:
        ResultKt.throwOnFailure(r33);
        AppletAuthorizeHelper r54 = this.$app.h().a();
        String r55 = Scope.addPhoneCalendar.getValue();
        this.label = 1;
        r18 = AppletAuthorizeHelper.e(r54, r55, false, null, null, null, this, 30);
        if (r18 != r10) goto L13;
        return r10;
    }
}
