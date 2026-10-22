package com.obric.assistant.card.layout.viewholder;

import android.view.ViewGroup;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.card.layout.viewholder.style.AbsCardItemScheduleStyle;
import com.obric.capabilitykit.entity.app.ScheduleEntity;
import com.obric.capabilitykit.entity.enums.CalendarTypeEnum;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0002J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0002¨\u0006\u000f"}, d2 = {"Lcom/obric/assistant/card/layout/viewholder/ScheduleViewHolder;", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemScheduleStyle;", "Lcom/obric/capabilitykit/entity/app/ScheduleEntity;", "parent", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "generateStyleData", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemScheduleStyle$StyleData;", "entity", "position", NameKeys.UnloadStrategy_No_Strategy, "generateStyleDataForOldSchedule", "generateStyleDataForMiniApp", "Companion", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ScheduleViewHolder extends AbsCardItemScheduleStyle<ScheduleEntity> {
    public static final /* synthetic */ int l = 0;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[CalendarTypeEnum.values().length];
            r0[CalendarTypeEnum.CALENDAR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[CalendarTypeEnum.TODO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
    }

    public ScheduleViewHolder(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        super(r2);
    }

    @Override // com.obric.assistant.card.layout.viewholder.style.AbsCardItemScheduleStyle
    public final AbsCardItemScheduleStyle.a a4(Object r21) {
        ScheduleEntity r1 = (ScheduleEntity) r21;
        Intrinsics.checkNotNullParameter(r1, "entity");
        FLogger r0 = FLogger.a;
        r0.i("ScheduleViewHolder", "generateStyleData: calendarType is " + r1.getCalendarType());
        CalendarTypeEnum r2 = r1.getCalendarType();
        int r4 = -1;
        if (r2 != null) goto L5;
        int r3 = -1;
    L6:
        int r5 = 2131244445;
        boolean r8 = false;
        if (r3 == (-1)) goto L59;
        if (r3 == 1) goto L13;
        if (r3 == 2) goto L13;
        throw new NoWhenBranchMatchedException();
    L13:
        r0.i("ScheduleViewHolder", "generateStyleDataForMiniApp");
        String r6 = com.obric.assistant.card.utils.i.a(r1.getTimeDescription(), r1.getRruleDescription(), ' ');
        int r7 = lca.a.d;
        CalendarTypeEnum r9 = r1.getCalendarType();
        if (r9 != null) goto L16;
        int r10 = -1;
    L17:
        if (r10 == (-1)) goto L23;
        if (r10 == 1) goto L23;
        if (r10 != 2) goto L22;
        int r11 = 2131244452;
    L24:
        lca.a r12 = lca.a.C0099a.a(Integer.valueOf(r11));
        int r13 = com.obric.assistant.card.utils.d.a;
        String r14 = r1.getPackageName();
        if (r14 != null) goto L27;
    L30:
        boolean r15 = true;
    L31:
        if (r15 == false) goto L34;
        int r16 = 0;
    L38:
        String r17 = r1.getName();
        if (r6 != null) goto L41;
    L42:
        r8 = true;
    L43:
        if (r8 == false) goto L53;
        CalendarTypeEnum r18 = r1.getCalendarType();
        if (r18 == null) goto L48;
        r4 = b.a[r18.ordinal()];
    L48:
        if (r4 == 1) goto L52;
        if (r4 == 2) goto L51;
        String r19 = NameKeys.UnloadStrategy_No_Strategy;
    L54:
        Intrinsics.checkNotNull(r19);
        String r20 = r1.getAddress();
        if (r20 != null) goto L57;
        String r110 = NameKeys.UnloadStrategy_No_Strategy;
    L108:
        return new AbsCardItemScheduleStyle.a(r12, r16, r17, r19, r110);
    L57:
        r110 = r20;
        goto L108
    L51:
        r6 = getContext().getString(2131912191);
        goto L53
    L52:
        r6 = getContext().getString(2131912189);
    L53:
        r19 = r6;
        goto L54
    L41:
        if (r6.length() != 0) goto L43;
    L34:
        if (Intrinsics.areEqual(r14, "com.ss.android.lark") == true) goto L37;
        r5 = 0;
    L37:
        r16 = r5;
        goto L38
    L27:
        if (r14.length() == 0) goto L30;
        r15 = false;
        goto L31
    L22:
        throw new NoWhenBranchMatchedException();
    L23:
        r11 = 2131244451;
        goto L24
    L16:
        r10 = b.a[r9.ordinal()];
        goto L17
    L59:
        r0.i("ScheduleViewHolder", "generateStyleDataForOldSchedule");
        Long r111 = r1.getStartTimestamp();
        Long r112 = r1.getEndTimestamp();
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L67
        if (r111 == null) goto L64;
        if (r112 == null) goto L64;
        int r22 = com.obric.assistant.card.utils.j.a;     // Catch: Throwable -> L67
        String r23 = com.obric.assistant.card.utils.j.b(getContext(), r111.longValue(), r112.longValue());     // Catch: Throwable -> L67
    L65:
        Object r24 = Result.constructor-impl(r23);     // Catch: Throwable -> L67
    L69:
        Throwable r25 = Result.exceptionOrNull-impl(r24);
        if (r25 == null) goto L73;
        FLogger.a.w("ScheduleViewHolder", "format time failed: " + r25.getMessage(), r25);
    L73:
        if (Result.isFailure-impl(r24) == false) goto L75;
        r24 = NameKeys.UnloadStrategy_No_Strategy;
    L75:
        String r26 = (String) r24;
        List r27 = r1.getAttendees();
        if (r27 != null) goto L79;
        r27 = CollectionsKt.emptyList();
    L79:
        if (r27.size() < 3) goto L81;
        String r28 = getContext().getString(2131911993, new Object[]{CollectionsKt.joinToString$default(r27.subList(0, 2), "、", null, null, 0, null, new p(), 30, null)});
    L82:
        int r29 = lca.a.d;
        if (Intrinsics.areEqual(r1.getPackageName(), "com.ss.android.lark") == false) goto L85;
        int r30 = 2131244478;
    L86:
        lca.a r114 = lca.a.C0099a.a(Integer.valueOf(r30));
        int r31 = com.obric.assistant.card.utils.d.a;
        String r32 = r1.getPackageName();
        if (r32 != null) goto L89;
    L92:
        boolean r115 = true;
    L93:
        if (r115 == false) goto L96;
        int r116 = 0;
    L100:
        String r117 = r1.getName();
        int r33 = com.obric.assistant.card.utils.e.a;
        CharSequence r118 = com.obric.assistant.card.utils.e.a(getContext(), CollectionsKt.listOf(new String[]{r26, r28}));
        String r34 = r1.getAddress();
        if (r34 != null) goto L103;
        String r119 = NameKeys.UnloadStrategy_No_Strategy;
    L105:
        return new AbsCardItemScheduleStyle.a(r114, r116, r117, r118, r119);
    L103:
        r119 = r34;
        goto L105
    L96:
        if (Intrinsics.areEqual(r32, "com.ss.android.lark") == true) goto L99;
        r5 = 0;
    L99:
        r116 = r5;
        goto L100
    L89:
        if (r32.length() == 0) goto L92;
        r115 = false;
        goto L93
    L85:
        r30 = 2131244477;
        goto L86
    L81:
        r28 = CollectionsKt.joinToString$default(r27, "、", null, null, 0, null, new q(), 30, null);
    L64:
        r0.w("ScheduleViewHolder", "startTimestamp is " + r111);     // Catch: Throwable -> L67
        r0.w("ScheduleViewHolder", "endTimestamp is " + r112);     // Catch: Throwable -> L67
        r23 = NameKeys.UnloadStrategy_No_Strategy;
    L67:
        th = move-exception;
        Result.Companion r35 = Result.Companion;
        r24 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L69
    L5:
        r3 = b.a[r2.ordinal()];
        goto L6
    }
}
