package com.obric.memorydata.memory.ui.detail;

import android.content.Context;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.capabilitykit.entity.memory.EventScheduleMemoryEntity;
import com.obric.capabilitykit.entity.memory.EventTodoMemoryEntity;
import com.obric.capabilitykit.entity.memory.OrderFlightMemoryEntity;
import com.obric.capabilitykit.entity.memory.OrderHotelMemoryEntity;
import com.obric.capabilitykit.entity.memory.OrderMovieTicketMemoryEntity;
import com.obric.capabilitykit.entity.memory.OrderTicketMemoryEntity;
import com.obric.capabilitykit.entity.memory.OrderTrainMemoryEntity;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.utils.at;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0013¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/memory/ui/detail/MemoryDetailDateTimeUtil;", "", "<init>", "()V", "getFlightMemoryDateTimeBriefDesc", "", "memoryEntity", "Lcom/obric/capabilitykit/entity/memory/OrderFlightMemoryEntity;", "getTrainMemoryDateTimeBriefDesc", "Lcom/obric/capabilitykit/entity/memory/OrderTrainMemoryEntity;", "getHotelMemoryDateTimeBriefDesc", "Lcom/obric/capabilitykit/entity/memory/OrderHotelMemoryEntity;", "getMovieMemoryDateTimeBriefDesc", "Lcom/obric/capabilitykit/entity/memory/OrderMovieTicketMemoryEntity;", "getTicketMemoryDateTimeBriefDesc", "Lcom/obric/capabilitykit/entity/memory/OrderTicketMemoryEntity;", "getEventMemoryDateTimeBriefDesc", "Lcom/obric/capabilitykit/entity/memory/EventScheduleMemoryEntity;", "getTodoMemoryDateTimeBriefDesc", "Lcom/obric/capabilitykit/entity/memory/EventTodoMemoryEntity;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v f10881a = null;

    static {
        f10881a = new v();
    }

    private v() {
    }

    public final String a(EventScheduleMemoryEntity r10) {
        Intrinsics.checkNotNullParameter(r10, "memoryEntity");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r10.getDate(), CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L22;
        long r4 = com.obric.memorydata.utils.r.d(r10.getDate());
        if (r4 == 0) goto L24;
        String r5 = com.obric.memorydata.utils.r.a(r4, false, 2, null);
        if (at.a(r10.getEndDate()) == false) goto L21;
        if (at.a(r10.getEndTime()) == false) goto L21;
        String r6 = r10.getEndDate();
        Intrinsics.checkNotNull(r6);
        long r7 = com.obric.memorydata.utils.r.d(r6);
        v r9 = (v) ZeusTransformUtils.preCheckCast(this, v.class, "com.obric.memorydata.plugin");
        String r11 = com.obric.memorydata.utils.r.a(r7, false, 2, null);
        if (Intrinsics.areEqual(r5, r11) == true) goto L18;
        StringBuilder r12 = new StringBuilder().append(r5).append(' ').append(r10.getStartTime()).append(" - ").append(r11).append(' ');
    L23:
        return r12.append(r10.getEndTime()).toString();
    L18:
        r12 = new StringBuilder().append(r5).append(' ').append(r10.getStartTime()).append(" - ");
    L21:
        return r5 + ' ' + r10.getStartTime();
    L24:
        return "";
    L22:
        return "";
    L5:
        r0 = false;
        goto L7
    }

    public final String a(EventTodoMemoryEntity r11) {
        Intrinsics.checkNotNullParameter(r11, "memoryEntity");
        CharSequence r10 = (CharSequence) ZeusTransformUtils.preCheckCast(r11.getEndDate(), CharSequence.class, "com.obric.memorydata.plugin");
        boolean r0 = true;
        if (r10 != null) goto L5;
    L8:
        boolean r12 = true;
    L10:
        if (r12 == true) goto L26;
        String r13 = r11.getEndDate();
        Intrinsics.checkNotNull(r13);
        long r4 = com.obric.memorydata.utils.r.d(r13);
        if (r4 == 0) goto L27;
        CharSequence r14 = (CharSequence) ZeusTransformUtils.preCheckCast(r11.getEndTime(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r14 == null) goto L21;
        if (r14.length() == 0) goto L21;
        r0 = false;
    L21:
        if (r0 == true) goto L23;
        StringBuilder r15 = new StringBuilder().append(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.memory_detail_todo_time_prefix_1, TypedValues.Custom.S_STRING, "memory_detail_todo_time_prefix_1"))).append(' ').append(com.obric.memorydata.utils.r.a(r4, false, 2, null)).append(' ').append(r11.getEndTime());
    L25:
        return r15.toString();
    L23:
        r15 = new StringBuilder().append(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.memory_detail_todo_time_prefix_2, TypedValues.Custom.S_STRING, "memory_detail_todo_time_prefix_2"))).append(' ').append(com.obric.memorydata.utils.r.a(r4, false, 2, null));
        goto L25
    L27:
        return "";
    L26:
        return "";
    L5:
        if (r10.length() == 0) goto L8;
        r12 = false;
        goto L10
    }

    public final String a(OrderFlightMemoryEntity r12) {
        Intrinsics.checkNotNullParameter(r12, "memoryEntity");
        boolean r0 = true;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r12.getDepartureDate(), CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L5;
        boolean r11 = true;
    L7:
        if (r11 == false) goto L9;
    L18:
        long r1 = com.obric.memorydata.utils.r.d(r12.getDepartureDate());
        if (r1 != 0) goto L22;
        return "";
    L22:
        if (com.bytedance.common.utility.h.a(r12.getLandingDate()) == true) goto L29;
        String r13 = r12.getLandingDate();
        Intrinsics.checkNotNull(r13);
        long r9 = com.obric.memorydata.utils.r.d(r13);
        if (r9 != 0) goto L26;
    L28:
        StringBuilder r14 = new StringBuilder();
    L30:
        StringBuilder r15 = r14.append(com.obric.memorydata.utils.r.a(r1, false, 2, null)).append(' ').append(r12.getDepartureTime()).append(" - ");
    L32:
        return r15.append(r12.getLandingTime()).toString();
    L26:
        if (r9 == r1) goto L28;
        r15 = new StringBuilder().append(com.obric.memorydata.utils.r.a(r1, false, 2, null)).append(' ').append(r12.getDepartureTime()).append(" - ").append(com.obric.memorydata.utils.r.a(r9, false, 2, null)).append(' ');
        goto L32
    L29:
        r14 = new StringBuilder();
        goto L30
    L9:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r12.getDepartureTime(), CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L11;
        boolean r16 = true;
    L12:
        if (r16 == true) goto L18;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r12.getLandingTime(), CharSequence.class, "com.obric.memorydata.plugin")).length() > 0) goto L17;
        r0 = false;
    L17:
        if (r0 == true) goto L18;
        return "";
    L11:
        r16 = false;
        goto L12
    L5:
        r11 = false;
        goto L7
    }

    public final String a(OrderHotelMemoryEntity r11) {
        Intrinsics.checkNotNullParameter(r11, "memoryEntity");
        boolean r0 = true;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r11.getCheckInDate(), CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L5;
        boolean r10 = true;
    L7:
        if (r10 == false) goto L25;
        long r4 = com.obric.memorydata.utils.r.d(r11.getCheckInDate());
        if (r4 == 0) goto L27;
        CharSequence r12 = (CharSequence) ZeusTransformUtils.preCheckCast(r11.getCheckOutDate(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L18;
        if (r12.length() == 0) goto L18;
        r0 = false;
    L18:
        if (r0 == true) goto L24;
        String r13 = r11.getCheckOutDate();
        Intrinsics.checkNotNull(r13);
        long r8 = com.obric.memorydata.utils.r.d(r13);
        if (r8 != 0) goto L26;
        return "";
    L26:
        return com.obric.memorydata.utils.r.a(r4, false, 2, null) + " - " + com.obric.memorydata.utils.r.a(r8, false, 2, null);
    L24:
        return com.obric.memorydata.utils.r.a(r4, false, 2, null);
    L27:
        return "";
    L25:
        return "";
    L5:
        r10 = false;
        goto L7
    }

    public final String a(OrderMovieTicketMemoryEntity r9) {
        Intrinsics.checkNotNullParameter(r9, "memoryEntity");
        boolean r0 = true;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r9.getMovieDate(), CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L5;
        boolean r8 = true;
    L7:
        if (r8 == true) goto L9;
        return "";
    L9:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r9.getStartTime(), CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L11;
        boolean r10 = true;
    L12:
        if (r10 == false) goto L29;
        long r4 = com.obric.memorydata.utils.r.d(r9.getMovieDate());
        if (r4 == 0) goto L30;
        CharSequence r11 = (CharSequence) ZeusTransformUtils.preCheckCast(r9.getEndTime(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L23;
        if (r11.length() == 0) goto L23;
        r0 = false;
    L23:
        if (r0 == true) goto L25;
        StringBuilder r12 = new StringBuilder().append(com.obric.memorydata.utils.r.a(r4, false, 2, null)).append(' ').append(r9.getStartTime()).append(" - ");
        String r13 = r9.getEndTime();
    L27:
        return r12.append(r13).toString();
    L25:
        r12 = new StringBuilder().append(com.obric.memorydata.utils.r.a(r4, false, 2, null)).append(' ');
        r13 = r9.getStartTime();
        goto L27
    L30:
        return "";
    L29:
        return "";
    L11:
        r10 = false;
        goto L12
    L5:
        r8 = false;
        goto L7
    }

    public final String a(OrderTicketMemoryEntity r9) {
        Intrinsics.checkNotNullParameter(r9, "memoryEntity");
        boolean r0 = true;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r9.getDate(), CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L5;
        boolean r8 = true;
    L7:
        if (r8 == true) goto L9;
        return "";
    L9:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r9.getStartTime(), CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L11;
        boolean r10 = true;
    L12:
        if (r10 == false) goto L29;
        long r4 = com.obric.memorydata.utils.r.d(r9.getDate());
        if (r4 == 0) goto L30;
        CharSequence r11 = (CharSequence) ZeusTransformUtils.preCheckCast(r9.getEndTime(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L23;
        if (r11.length() == 0) goto L23;
        r0 = false;
    L23:
        if (r0 == true) goto L25;
        StringBuilder r12 = new StringBuilder().append(com.obric.memorydata.utils.r.a(r4, false, 2, null)).append(' ').append(r9.getStartTime()).append(" - ");
        String r13 = r9.getEndTime();
    L27:
        return r12.append(r13).toString();
    L25:
        r12 = new StringBuilder().append(com.obric.memorydata.utils.r.a(r4, false, 2, null)).append(' ');
        r13 = r9.getStartTime();
        goto L27
    L30:
        return "";
    L29:
        return "";
    L11:
        r10 = false;
        goto L12
    L5:
        r8 = false;
        goto L7
    }

    public final String a(OrderTrainMemoryEntity r12) {
        Intrinsics.checkNotNullParameter(r12, "memoryEntity");
        boolean r0 = true;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r12.getDepartureDate(), CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L5;
        boolean r11 = true;
    L7:
        if (r11 == false) goto L9;
    L18:
        long r1 = com.obric.memorydata.utils.r.d(r12.getDepartureDate());
        if (r1 != 0) goto L22;
        return "";
    L22:
        if (com.bytedance.common.utility.h.a(r12.getArrivalDate()) == true) goto L29;
        String r13 = r12.getArrivalDate();
        Intrinsics.checkNotNull(r13);
        long r9 = com.obric.memorydata.utils.r.d(r13);
        if (r9 != 0) goto L26;
    L28:
        StringBuilder r14 = new StringBuilder();
    L30:
        StringBuilder r15 = r14.append(com.obric.memorydata.utils.r.a(r1, false, 2, null)).append(' ').append(r12.getDepartureTime()).append(" - ");
    L32:
        return r15.append(r12.getArrivalTime()).toString();
    L26:
        if (r9 == r1) goto L28;
        r15 = new StringBuilder().append(com.obric.memorydata.utils.r.a(r1, false, 2, null)).append(' ').append(r12.getDepartureTime()).append(" - ").append(com.obric.memorydata.utils.r.a(r9, false, 2, null)).append(' ');
        goto L32
    L29:
        r14 = new StringBuilder();
        goto L30
    L9:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r12.getDepartureTime(), CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L11;
        boolean r16 = true;
    L12:
        if (r16 == true) goto L18;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r12.getArrivalTime(), CharSequence.class, "com.obric.memorydata.plugin")).length() > 0) goto L17;
        r0 = false;
    L17:
        if (r0 == true) goto L18;
        return "";
    L11:
        r16 = false;
        goto L12
    L5:
        r11 = false;
        goto L7
    }
}
