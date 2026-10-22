package com.obric.memorydata.memory.ui;

import android.content.Context;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.capabilitykit.entity.memory.EventScheduleMemoryEntity;
import com.obric.capabilitykit.entity.memory.EventTodoMemoryEntity;
import com.obric.capabilitykit.entity.memory.OrderCommonMemoryEntity;
import com.obric.capabilitykit.entity.memory.OrderFlightMemoryEntity;
import com.obric.capabilitykit.entity.memory.OrderHotelMemoryEntity;
import com.obric.capabilitykit.entity.memory.OrderMovieTicketMemoryEntity;
import com.obric.capabilitykit.entity.memory.OrderTicketMemoryEntity;
import com.obric.capabilitykit.entity.memory.OrderTrainMemoryEntity;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.utils.Format;
import com.obric.memorydata.utils.at;
import com.obric.memorydata.utils.r;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u000bJ\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u000eJ\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0011J\u000e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0014J\u0018\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u001bJ\u0018\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u001e2\b\b\u0002\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020!R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/obric/memorydata/memory/ui/MemoryEntity2NotificationContentUtil;", "", "<init>", "()V", "TAG", "", "getFlightMemoryDateTimeDesc", "memoryEntity", "Lcom/obric/capabilitykit/entity/memory/OrderFlightMemoryEntity;", "getFlightMemorySubtitle", "getTrainMemoryDateTimeDesc", "Lcom/obric/capabilitykit/entity/memory/OrderTrainMemoryEntity;", "getTrainMemorySubtitle", "getHotelMemoryDateTimeDesc", "Lcom/obric/capabilitykit/entity/memory/OrderHotelMemoryEntity;", "getHotelMemorySubtitle", "getMovieMemoryDateTimeDesc", "Lcom/obric/capabilitykit/entity/memory/OrderMovieTicketMemoryEntity;", "getMovieMemorySubtitle", "getTicketMemoryDateTimeDesc", "Lcom/obric/capabilitykit/entity/memory/OrderTicketMemoryEntity;", "getTicketMemorySubtitle", "getDateTimeDescByOrderMemory", "Lcom/obric/capabilitykit/entity/memory/OrderCommonMemoryEntity;", "needPrefix", "", "getEventMemoryDateTimeDesc", "Lcom/obric/capabilitykit/entity/memory/EventScheduleMemoryEntity;", "getEventMemorySubtitle", "getDateTimeDescByTodoMemory", "Lcom/obric/capabilitykit/entity/memory/EventTodoMemoryEntity;", "formatDateByCurrentYear", "timestamp", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f10891a = null;

    static {
        f10891a = new e();
    }

    private e() {
    }

    private static final CharSequence a(String r7) {
        Intrinsics.checkNotNullParameter(r7, "it");
        return (CharSequence) ZeusTransformUtils.preCheckCast(StringsKt.replace$default(r7, " ", "", false, 4, null), CharSequence.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ String a(e r0, EventTodoMemoryEntity r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = true;
    L6:
        return r0.a(r1, r2);
    }

    public static /* synthetic */ String a(e r0, OrderCommonMemoryEntity r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = true;
    L6:
        return r0.a(r1, r2);
    }

    public static /* synthetic */ CharSequence lambda$j7gger6t77xqlFerGKxauGgcPVI(String r0) {
        return a(r0);
    }

    public final String a(long r1) {
        LocalDate r0 = Instant.ofEpochMilli(r1).atZone(ZoneId.systemDefault()).toLocalDate();
        int r2 = LocalDate.now().getYear();
        if (r0.getYear() != r2) goto L5;
        Format r3 = Format.MONTH_DAY_SPLIT_BY_SLASH;
    L6:
        String r4 = r0.format(DateTimeFormatter.ofPattern(r3.getValue()));
        Intrinsics.checkNotNull(r4);
        return r4;
    L5:
        r3 = Format.DATE_SPLIT_BY_SLASH;
        goto L6
    }

    public final String a(EventScheduleMemoryEntity r10) {
        Intrinsics.checkNotNullParameter(r10, "memoryEntity");
        boolean r1 = true;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r10.getDate(), CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L9;
        return "";
    L9:
        Long r2 = Long.valueOf(r.d(r10.getDate()));
        if (((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.memorydata.plugin")).longValue() != 0) goto L13;
        r1 = false;
    L13:
        if (r1 == true) goto L16;
        r2 = null;
    L16:
        if (r2 == null) goto L27;
        String r9 = a(r2.longValue());
        StringBuilder r3 = new StringBuilder();
        r3.append(r9 + ' ' + r10.getStartTime());
        if (at.a(r10.getEndDate()) == true) goto L20;
    L25:
        String r11 = r3.toString();
        Intrinsics.checkNotNullExpressionValue(r11, "toString(...)");
        return r11;
    L20:
        if (at.a(r10.getEndTime()) == false) goto L25;
        e r4 = f10891a;
        String r5 = r10.getEndDate();
        Intrinsics.checkNotNull(r5);
        String r6 = r4.a(r.d(r5));
        r3.append(" - ");
        if (Intrinsics.areEqual(r9, r6) == true) goto L24;
        r3.append(r6 + ' ');
    L24:
        r3.append(r10.getEndTime());
        goto L25
    L27:
        return "";
    L5:
        r0 = false;
        goto L7
    }

    public final String a(EventTodoMemoryEntity r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r12, "memoryEntity");
        if (r13 == false) goto L5;
        String r0 = at.a(ZeusTransformUtils.mapRes(R.string.memory_card_todo_title, TypedValues.Custom.S_STRING, "memory_card_todo_title"));
    L6:
        String r1 = r12.getEndDate();
        if (r1 != null) goto L9;
    L40:
        return r0;
    L9:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L11;
        boolean r2 = true;
    L12:
        String r6 = null;
        if (r2 == true) goto L16;
        r1 = null;
    L16:
        if (r1 == null) goto L40;
        Long r3 = Long.valueOf(r.d(r1));
        if (((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).longValue() == 0) goto L21;
        boolean r4 = true;
    L22:
        if (r4 == true) goto L25;
        r3 = null;
    L25:
        if (r3 == null) goto L40;
        long r5 = r3.longValue();
        StringBuilder r7 = new StringBuilder();
        r7.append(f10891a.a(r5));
        String r14 = r12.getEndTime();
        if (r14 != null) goto L29;
    L36:
        String r15 = r7.toString();
        Intrinsics.checkNotNullExpressionValue(r15, "toString(...)");
        if (r13 == false) goto L41;
        String r16 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.memory_todo_due_time_format, TypedValues.Custom.S_STRING, "memory_todo_due_time_format"), new Object[]{r15});
        Intrinsics.checkNotNull(r16);
        return r16;
    L41:
        return r15;
    L29:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L31;
        boolean r8 = true;
    L32:
        if (r8 == false) goto L34;
        r6 = r14;
    L34:
        if (r6 == null) goto L36;
        r7.append(' ' + r6);
        goto L36
    L31:
        r8 = false;
        goto L32
    L21:
        r4 = false;
        goto L22
    L11:
        r2 = false;
        goto L12
    L5:
        r0 = "";
        goto L6
    }

    public final String a(OrderCommonMemoryEntity r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "memoryEntity");
        if (r3 == true) goto L6;
        return "";
    L6:
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r2.getOrderDesc(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L9;
    L12:
        boolean r4 = true;
    L13:
        if (r4 == true) goto L16;
        String r5 = r2.getOrderDesc();
        Intrinsics.checkNotNull(r5);
        return r5;
    L16:
        return at.a(ZeusTransformUtils.mapRes(R.string.memory_card_order_title, TypedValues.Custom.S_STRING, "memory_card_order_title"));
    L9:
        if (r1.length() == 0) goto L12;
        r4 = false;
        goto L13
    }

    public final String a(OrderFlightMemoryEntity r12) {
        Intrinsics.checkNotNullParameter(r12, "memoryEntity");
        boolean r1 = true;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r12.getDepartureDate(), CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
    L18:
        boolean r2 = false;
    L20:
        if (r2 == false) goto L22;
        return "";
    L22:
        Long r3 = Long.valueOf(r.d(r12.getDepartureDate()));
        if (((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).longValue() == 0) goto L25;
        boolean r5 = true;
    L26:
        if (r5 == true) goto L29;
        r3 = null;
    L29:
        if (r3 == null) goto L55;
        long r4 = r3.longValue();
        String r6 = a(r4);
        String r7 = r12.getLandingDate();
        if (r7 != null) goto L33;
    L38:
        boolean r8 = false;
    L39:
        if (r8 == false) goto L48;
        String r9 = r12.getLandingDate();
        Intrinsics.checkNotNull(r9);
        long r10 = r.d(r9);
        if (r10 != 0) goto L43;
    L45:
        boolean r11 = false;
    L46:
        if (r11 == false) goto L48;
    L50:
        if (r1 == false) goto L52;
        String r13 = r12.getLandingDate();
        Intrinsics.checkNotNull(r13);
        StringBuilder r14 = new StringBuilder().append(r6).append(' ').append(r12.getDepartureTime()).append(" - ").append(a(r.d(r13))).append(' ');
    L54:
        return r14.append(r12.getLandingTime()).toString();
    L52:
        r14 = new StringBuilder().append(r6).append(' ').append(r12.getDepartureTime()).append(" - ");
        goto L54
    L43:
        if (r10 == r4) goto L45;
        r11 = true;
    L48:
        r1 = false;
        goto L50
    L33:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L35;
        boolean r15 = true;
    L36:
        if (r15 != true) goto L38;
        r8 = true;
        goto L39
    L35:
        r15 = false;
        goto L36
    L55:
        return "";
    L25:
        r5 = false;
        goto L26
    L8:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r12.getDepartureTime(), CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L10;
        boolean r16 = true;
    L11:
        if (r16 == false) goto L18;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r12.getLandingTime(), CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L15;
        boolean r17 = true;
    L16:
        if (r17 == false) goto L18;
        r2 = true;
        goto L20
    L15:
        r17 = false;
        goto L16
    L10:
        r16 = false;
        goto L11
    L5:
        r0 = false;
        goto L6
    }

    public final String a(OrderHotelMemoryEntity r10) {
        Intrinsics.checkNotNullParameter(r10, "memoryEntity");
        boolean r1 = true;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r10.getCheckInDate(), CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L9;
        return "";
    L9:
        long r5 = r.d(r10.getCheckInDate());
        if (r5 != 0) goto L12;
        return "";
    L12:
        String r2 = a(r5);
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(r10.getCheckOutDate(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L15;
    L18:
        if (r1 == true) goto L25;
        String r11 = r10.getCheckOutDate();
        Intrinsics.checkNotNull(r11);
        long r4 = r.d(r11);
        if (r4 != 0) goto L24;
        return "";
    L24:
        return r2 + " - " + a(r4);
    L25:
        return r2;
    L15:
        if (r3.length() == 0) goto L18;
        r1 = false;
        goto L18
    L5:
        r0 = false;
        goto L7
    }

    public final String a(OrderMovieTicketMemoryEntity r10) {
        Intrinsics.checkNotNullParameter(r10, "memoryEntity");
        boolean r1 = true;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r10.getMovieDate(), CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == true) goto L9;
        return "";
    L9:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r10.getStartTime(), CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L11;
        boolean r2 = true;
    L12:
        if (r2 == false) goto L29;
        long r5 = r.d(r10.getMovieDate());
        if (r5 == 0) goto L30;
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(r10.getEndTime(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L23;
        if (r3.length() == 0) goto L23;
        r1 = false;
    L23:
        if (r1 == true) goto L25;
        StringBuilder r9 = new StringBuilder().append(a(r5)).append(' ').append(r10.getStartTime()).append(" - ");
        String r11 = r10.getEndTime();
    L27:
        return r9.append(r11).toString();
    L25:
        r9 = new StringBuilder().append(a(r5)).append(' ');
        r11 = r10.getStartTime();
        goto L27
    L30:
        return "";
    L29:
        return "";
    L11:
        r2 = false;
        goto L12
    L5:
        r0 = false;
        goto L7
    }

    public final String a(OrderTicketMemoryEntity r10) {
        Intrinsics.checkNotNullParameter(r10, "memoryEntity");
        boolean r1 = true;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r10.getDate(), CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == true) goto L9;
        return "";
    L9:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r10.getStartTime(), CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L11;
        boolean r2 = true;
    L12:
        if (r2 == false) goto L29;
        long r5 = r.d(r10.getDate());
        if (r5 == 0) goto L30;
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(r10.getEndTime(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L23;
        if (r3.length() == 0) goto L23;
        r1 = false;
    L23:
        if (r1 == true) goto L25;
        StringBuilder r9 = new StringBuilder().append(a(r5)).append(' ').append(r10.getStartTime()).append(" - ");
        String r11 = r10.getEndTime();
    L27:
        return r9.append(r11).toString();
    L25:
        r9 = new StringBuilder().append(a(r5)).append(' ');
        r11 = r10.getStartTime();
        goto L27
    L30:
        return "";
    L29:
        return "";
    L11:
        r2 = false;
        goto L12
    L5:
        r0 = false;
        goto L7
    }

    public final String a(OrderTrainMemoryEntity r12) {
        Intrinsics.checkNotNullParameter(r12, "memoryEntity");
        boolean r1 = true;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r12.getDepartureDate(), CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
    L18:
        boolean r2 = false;
    L20:
        if (r2 == false) goto L22;
        return "";
    L22:
        Long r3 = Long.valueOf(r.d(r12.getDepartureDate()));
        if (((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).longValue() == 0) goto L25;
        boolean r5 = true;
    L26:
        if (r5 == true) goto L29;
        r3 = null;
    L29:
        if (r3 == null) goto L55;
        long r4 = r3.longValue();
        String r6 = a(r4);
        String r7 = r12.getArrivalDate();
        if (r7 != null) goto L33;
    L38:
        boolean r8 = false;
    L39:
        if (r8 == false) goto L48;
        String r9 = r12.getArrivalDate();
        Intrinsics.checkNotNull(r9);
        long r10 = r.d(r9);
        if (r10 != 0) goto L43;
    L45:
        boolean r11 = false;
    L46:
        if (r11 == false) goto L48;
    L50:
        if (r1 == false) goto L52;
        String r13 = r12.getArrivalDate();
        Intrinsics.checkNotNull(r13);
        StringBuilder r14 = new StringBuilder().append(r6).append(' ').append(r12.getDepartureTime()).append(" - ").append(a(r.d(r13))).append(' ');
    L54:
        return r14.append(r12.getArrivalTime()).toString();
    L52:
        r14 = new StringBuilder().append(r6).append(' ').append(r12.getDepartureTime()).append(" - ");
        goto L54
    L43:
        if (r10 == r4) goto L45;
        r11 = true;
    L48:
        r1 = false;
        goto L50
    L33:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L35;
        boolean r15 = true;
    L36:
        if (r15 != true) goto L38;
        r8 = true;
        goto L39
    L35:
        r15 = false;
        goto L36
    L55:
        return "";
    L25:
        r5 = false;
        goto L26
    L8:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r12.getDepartureTime(), CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L10;
        boolean r16 = true;
    L11:
        if (r16 == false) goto L18;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r12.getArrivalTime(), CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L15;
        boolean r17 = true;
    L16:
        if (r17 == false) goto L18;
        r2 = true;
        goto L20
    L15:
        r17 = false;
        goto L16
    L10:
        r16 = false;
        goto L11
    L5:
        r0 = false;
        goto L6
    }

    public final String b(EventScheduleMemoryEntity r6) {
        Intrinsics.checkNotNullParameter(r6, "memoryEntity");
        String r5 = a(r6);
        boolean r2 = true;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L18;
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r6.getAddress(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L11;
    L14:
        if (r2 == false) goto L17;
        return r5;
    L17:
        return r5 + ' ' + r6.getAddress();
    L11:
        if (r1.length() == 0) goto L14;
        r2 = false;
        goto L14
    L18:
        return at.a(ZeusTransformUtils.mapRes(R.string.memory_card_schedule_title, TypedValues.Custom.S_STRING, "memory_card_schedule_title"));
    L5:
        r0 = false;
        goto L6
    }

    public final String b(OrderFlightMemoryEntity r3) {
        Intrinsics.checkNotNullParameter(r3, "memoryEntity");
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(a(r3), CharSequence.class, "com.obric.memorydata.plugin");
        if (r2.length() != 0) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == false) goto L9;
        r2 = at.a(ZeusTransformUtils.mapRes(R.string.memory_card_flight_ticket_title, TypedValues.Custom.S_STRING, "memory_card_flight_ticket_title"));
    L9:
        return (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.memorydata.plugin");
    L5:
        r4 = false;
        goto L6
    }

    public final String b(OrderHotelMemoryEntity r6) {
        Intrinsics.checkNotNullParameter(r6, "memoryEntity");
        String r5 = a(r6);
        boolean r2 = true;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L18;
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r6.getHotelAddress(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L11;
    L14:
        if (r2 == false) goto L17;
        return r5;
    L17:
        return r5 + ' ' + r6.getHotelAddress();
    L11:
        if (r1.length() == 0) goto L14;
        r2 = false;
        goto L14
    L18:
        return at.a(ZeusTransformUtils.mapRes(R.string.memory_card_hotel_title, TypedValues.Custom.S_STRING, "memory_card_hotel_title"));
    L5:
        r0 = false;
        goto L6
    }

    public final String b(OrderMovieTicketMemoryEntity r6) {
        Intrinsics.checkNotNullParameter(r6, "memoryEntity");
        String r5 = a(r6);
        boolean r2 = true;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L18;
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r6.getMovieTheaterAddress(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L11;
    L14:
        if (r2 == false) goto L17;
        return r5;
    L17:
        return r5 + ' ' + r6.getMovieTheaterAddress();
    L11:
        if (r1.length() == 0) goto L14;
        r2 = false;
        goto L14
    L18:
        return at.a(ZeusTransformUtils.mapRes(R.string.memory_card_movie_title, TypedValues.Custom.S_STRING, "memory_card_movie_title"));
    L5:
        r0 = false;
        goto L6
    }

    public final String b(OrderTicketMemoryEntity r6) {
        Intrinsics.checkNotNullParameter(r6, "memoryEntity");
        String r5 = a(r6);
        boolean r2 = true;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L18;
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r6.getAuditoriumAddress(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L11;
    L14:
        if (r2 == false) goto L17;
        return r5;
    L17:
        return r5 + ' ' + r6.getAuditoriumAddress();
    L11:
        if (r1.length() == 0) goto L14;
        r2 = false;
        goto L14
    L18:
        return at.a(ZeusTransformUtils.mapRes(R.string.memory_card_ticket_title, TypedValues.Custom.S_STRING, "memory_card_ticket_title"));
    L5:
        r0 = false;
        goto L6
    }

    public final String b(OrderTrainMemoryEntity r12) {
        Intrinsics.checkNotNullParameter(r12, "memoryEntity");
        String r11 = a(r12);
        boolean r2 = true;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L18;
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(r12.getSeatNumber(), Collection.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L11;
    L14:
        if (r2 == true) goto L19;
        StringBuilder r13 = new StringBuilder().append(r11).append(' ');
        List<String> r14 = r12.getSeatNumber();
        Intrinsics.checkNotNull(r14);
        return r13.append(CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(" ", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$e$j7gger6t77xqlFerGKxauGgcPVI.INSTANCE, 30, null)).toString();
    L19:
        return r11;
    L11:
        if (r1.isEmpty() == true) goto L14;
        r2 = false;
        goto L14
    L18:
        return at.a(ZeusTransformUtils.mapRes(R.string.memory_card_train_ticket_title, TypedValues.Custom.S_STRING, "memory_card_train_ticket_title"));
    L5:
        r0 = false;
        goto L6
    }
}
