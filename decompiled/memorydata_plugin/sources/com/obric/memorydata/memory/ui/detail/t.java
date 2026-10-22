package com.obric.memorydata.memory.ui.detail;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.obric.memorydata.database.entity.PendingMemoryCalendar;
import com.obric.memorydata.memory.databinding.ItemCalendarCardBinding;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.utils.Format;
import com.obric.memorydata.utils.at;
import com.obric.oui.button.OButton;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/memory/ui/detail/MemoryCalendarViewHolder;", "Lcom/obric/memorydata/memory/ui/data/MemoryItemViewHolder;", "binding", "Lcom/obric/memorydata/memory/databinding/ItemCalendarCardBinding;", "<init>", "(Lcom/obric/memorydata/memory/databinding/ItemCalendarCardBinding;)V", "bind", "", "memoryItem", "Lcom/obric/memorydata/memory/ui/data/MemoryItem;", "bindCalendarCard", "calendarCard", "calendarInfo", "Lcom/obric/memorydata/database/entity/PendingMemoryCalendar;", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class t extends com.obric.memorydata.memory.ui.data.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f10875a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ItemCalendarCardBinding f10876b;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/memory/ui/detail/MemoryCalendarViewHolder$Companion;", "", "<init>", "()V", "createCardViewHolder", "Lcom/obric/memorydata/memory/ui/detail/MemoryCalendarViewHolder;", "parent", "Landroid/view/ViewGroup;", "calendarTimeString", "", "calendarInfo", "Lcom/obric/memorydata/database/entity/PendingMemoryCalendar;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final t a(ViewGroup r3) {
            Intrinsics.checkNotNullParameter(r3, "parent");
            ItemCalendarCardBinding r2 = ItemCalendarCardBinding.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), r3, false);
            Intrinsics.checkNotNullExpressionValue(r2, "inflate(...)");
            return new t(r2);
        }

        /* JADX WARN: Type inference failed for: r12v18, types: [java.time.LocalDateTime] */
        /* JADX WARN: Type inference failed for: r12v22, types: [java.time.LocalDateTime] */
        /* JADX WARN: Type inference failed for: r13v8, types: [java.time.LocalDateTime] */
        public final String a(PendingMemoryCalendar r13) {
            Intrinsics.checkNotNullParameter(r13, "calendarInfo");
            Long r12 = r13.getDtstart();
            Long r0 = r13.getDtend();
            if (Intrinsics.areEqual(r13.getEventType(), PendingMemoryCalendar.TYPE_EVENT) == false) goto L12;
            if (r12 == null) goto L12;
            if (r0 == null) goto L12;
            ZoneId r14 = ZoneId.systemDefault();
            ?? r15 = Instant.ofEpochMilli(r12.longValue()).atZone(r14).toLocalDateTime();
            ?? r16 = Instant.ofEpochMilli(r0.longValue()).atZone(r14).toLocalDateTime();
            LocalDate r1 = r15.toLocalDate();
            LocalDate r2 = r16.toLocalDate();
            DateTimeFormatter r3 = DateTimeFormatter.ofPattern(Format.MINUTE_SPLIT_BY_SLASH.getValue());
            DateTimeFormatter r4 = DateTimeFormatter.ofPattern(Format.MINUTE.getValue());
            if (Intrinsics.areEqual(r1, r2) == false) goto L9;
            StringBuilder r17 = new StringBuilder().append(r15.format(r3)).append('-');
            String r18 = r16.format(r4);
        L23:
            return r17.append(r18).toString();
        L9:
            r17 = new StringBuilder().append(r15.format(r3)).append('\n');
            r18 = r16.format(r3);
        L12:
            if (Intrinsics.areEqual(r13.getEventType(), PendingMemoryCalendar.TYPE_TODO) == false) goto L20;
            if (r12 != null) goto L16;
            if (r0 != null) goto L16;
            return "";
        L16:
            if (r12 == null) goto L19;
            if (r0 == null) goto L19;
            ZoneId r19 = ZoneId.systemDefault();
            return String.valueOf(Instant.ofEpochMilli(r12.longValue()).atZone(r19).toLocalDateTime().format(DateTimeFormatter.ofPattern(Format.MINUTE_SPLIT_BY_SLASH.getValue())));
        L19:
            IRunLog r6 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
            StringBuilder r110 = new StringBuilder();
        L21:
            IRunLog.a.a(r6, "MemoryDetailItemViewHolder", r110.append("calendarInfo illegal = ").append(r13.getEventType()).append(", startTime = ").append(r13.getDtstart()).append(", endTime = ").append(r13.getDtend()).toString(), null, 4, null);
            return "";
        L20:
            r6 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
            r110 = new StringBuilder();
            goto L21
        }
    }

    static {
        f10875a = new a(null);
    }

    public t(ItemCalendarCardBinding r4) {
        Intrinsics.checkNotNullParameter(r4, "binding");
        ConstraintLayout r0 = r4.getRoot();
        Intrinsics.checkNotNullExpressionValue(r0, "getRoot(...)");
        super((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.memorydata.plugin"));
        this.f10876b = r4;
    }

    private static final Drawable a(t r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        com.obric.memorydata.memory.ui.list.e r4 = com.obric.memorydata.memory.ui.list.e.f11304a;
        Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.c.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r5, "getContext(...)");
        return r4.a(r5);
    }

    private static final Unit a(PendingMemoryCalendar r2, final OButton r3) {
        if (com.obric.memorydata.memory.calendar.b.f10085a.a(r2, true).a() == true) goto L6;
        com.obric.memorydata.utils.j.a(new $$Lambda$t$bwnFwpJ9Gf3WHL68oWxBzVR0N94(r3));
    L6:
        return Unit.INSTANCE;
    }

    private static final Unit a(OButton r1) {
        r1.setEnabled(true);
        return Unit.INSTANCE;
    }

    private final void a(ItemCalendarCardBinding r17, PendingMemoryCalendar r18) {
        com.obric.memorydata.utils.icon.b r3 = com.obric.memorydata.utils.icon.b.f13229a;
        Context r4 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.c.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r4, "getContext(...)");
        ImageView r5 = r17.ivIcon;
        Intrinsics.checkNotNullExpressionValue(r5, "ivIcon");
        com.obric.memorydata.utils.icon.b.a(r3, r4, r5, "com.obric.appletapp", null, ZeusTransformUtils.mapRes(R.drawable.ic_island_calendar, "drawable", "ic_island_calendar"), new $$Lambda$t$u4_1AjnpJs8ZA1sYf3vk0NlOXPM(this), null, null, null, false, 968, null);
        r17.tvCalendarTitle.setText((CharSequence) ZeusTransformUtils.preCheckCast(r18.getTitle(), CharSequence.class, "com.obric.memorydata.plugin"));
        OTextView r0 = r17.tvCalendarContent;
        StringBuilder r6 = new StringBuilder();
        r6.append("");
        CharSequence r7 = (CharSequence) ZeusTransformUtils.preCheckCast(r18.getLocation(), CharSequence.class, "com.obric.memorydata.plugin");
        boolean r8 = false;
        if (r7 != null) goto L5;
    L8:
        boolean r9 = true;
    L9:
        if (r9 == true) goto L11;
        String r10 = r18.getLocation() + '\n';
        final PendingMemoryCalendar r2 = r18;
    L12:
        r6.append(r10);
        String r11 = r6.toString();
        Intrinsics.checkNotNullExpressionValue(r11, "toString(...)");
        r0.setText((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, r2));
        final OButton r1 = r17.btnAction;
        if (r18.getStatus() != 0) goto L15;
        r8 = true;
    L15:
        r1.setEnabled(r8);
        if (r18.getStatus() != 0) goto L18;
        int r12 = R.string.memory_calendar_action;
        String r13 = "memory_calendar_action";
    L19:
        r1.setText((CharSequence) ZeusTransformUtils.preCheckCast(at.a(ZeusTransformUtils.mapRes(r12, TypedValues.Custom.S_STRING, r13)), CharSequence.class, "com.obric.memorydata.plugin"));
        r1.setOnClickListener(new $$Lambda$t$BRX1l6uM1_qZM5rt5KSJa_ZbS4(r1, r2));
        return;
    L18:
        r12 = R.string.memory_calendar_action_done;
        r13 = "memory_calendar_action_done";
        goto L19
    L11:
        r2 = r18;
        r10 = "" + f10875a.a(r2);
        goto L12
    L5:
        if (r7.length() == 0) goto L8;
        r9 = false;
        goto L9
    }

    private static final void a(final OButton r0, final PendingMemoryCalendar r1, View r2) {
        r0.setEnabled(false);
        com.obric.memorydata.utils.h.a(new $$Lambda$t$PeF17GN0pU3jIOFrx04G2K9QXVU(r1, r0));
    }

    /* JADX INFO: renamed from: lambda$BRX1l6uM1_qZM5rt5K-SJa_ZbS4, reason: not valid java name */
    public static /* synthetic */ void m853lambda$BRX1l6uM1_qZM5rt5KSJa_ZbS4(OButton r0, PendingMemoryCalendar r1, View r2) {
        a(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$PeF17GN0pU3jIOFrx04G2K9QXVU(PendingMemoryCalendar r0, OButton r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ Unit lambda$bwnFwpJ9Gf3WHL68oWxBzVR0N94(OButton r0) {
        return a(r0);
    }

    public static /* synthetic */ Drawable lambda$u4_1AjnpJs8ZA1sYf3vk0NlOXPM(t r0, String r1) {
        return a(r0, r1);
    }

    @Override // com.obric.memorydata.memory.ui.data.c
    public void b(com.obric.memorydata.memory.ui.data.a r4) {
        Intrinsics.checkNotNullParameter(r4, "memoryItem");
        if (ZeusTransformUtils.instanceOf(r4, com.obric.memorydata.memory.ui.data.a.c.class) == true) goto L5;
        return;
    L5:
        a(this.f10876b, ((com.obric.memorydata.memory.ui.data.a.c) ZeusTransformUtils.preCheckCast(r4, com.obric.memorydata.memory.ui.data.a.c.class, "com.obric.memorydata.plugin")).b());
    }
}
