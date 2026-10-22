package com.obric.memorydata.memory.ui.detail;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.database.entity.PendingMemoryCalendar;
import com.obric.memorydata.memory.databinding.ItemCalendarSelectionPanelBinding;
import com.obric.memorydata.memory.ui.selection.SelectionPanelItemView;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0018B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0002H\u0014J\u0010\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u000eH\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0019"}, d2 = {"Lcom/obric/memorydata/memory/ui/detail/CalendarSelectionPanelItemView;", "Lcom/obric/memorydata/memory/ui/selection/SelectionPanelItemView;", "Lcom/obric/memorydata/memory/ui/data/MemoryItem$Calendar;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/obric/memorydata/memory/databinding/ItemCalendarSelectionPanelBinding;", EventBody.KEY_VALUE, "", "isItemSelected", "()Z", "setItemSelected", "(Z)V", "onBind", "", "data", "updateIconVerticalConstraint", "center", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CalendarSelectionPanelItemView extends SelectionPanelItemView<com.obric.memorydata.memory.ui.data.a.c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f10795a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ItemCalendarSelectionPanelBinding f10796b;
    private boolean c;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/memory/ui/detail/CalendarSelectionPanelItemView$Companion;", "", "<init>", "()V", "TAG", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f10795a = new a(null);
    }

    public CalendarSelectionPanelItemView(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public CalendarSelectionPanelItemView(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public CalendarSelectionPanelItemView(Context r10, AttributeSet r11, int r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r13, "context");
        super(r13, r4, r12, 0, 8, null);
        ItemCalendarSelectionPanelBinding r14 = ItemCalendarSelectionPanelBinding.inflate(LayoutInflater.from(r13), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.memorydata.plugin"), true);
        Intrinsics.checkNotNullExpressionValue(r14, "inflate(...)");
        this.f10796b = r14;
    }

    public /* synthetic */ CalendarSelectionPanelItemView(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    private final void a(boolean r12) {
        ImageView r0 = this.f10796b.ivTodo;
        Intrinsics.checkNotNullExpressionValue(r0, "ivTodo");
        if (((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.memorydata.plugin")).getVisibility() != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
        ImageView r2 = this.f10796b.ivTodo;
    L9:
        Intrinsics.checkNotNull(r2);
        ViewParent r5 = r2.getParent();
        if (ZeusTransformUtils.instanceOf(r5, ConstraintLayout.class) == false) goto L12;
        ConstraintLayout r6 = (ConstraintLayout) ZeusTransformUtils.preCheckCast(r5, ConstraintLayout.class, "com.obric.memorydata.plugin");
    L13:
        if (r6 != null) goto L15;
        return;
    L15:
        ConstraintSet r7 = new ConstraintSet();
        r7.clone(r6);
        if (r12 == false) goto L18;
        r7.connect(r2.getId(), 3, 0, 3);
        r7.connect(r2.getId(), 4, 0, 4);
        r7.setMargin(r2.getId(), 3, 0);
    L25:
        r7.applyTo(r6);
        return;
    L18:
        r7.clear(r2.getId(), 3);
        r7.clear(r2.getId(), 6);
        r7.clear(r2.getId(), 4);
        r7.clear(r2.getId(), 7);
        r7.connect(r2.getId(), 3, 0, 3);
        r7.connect(r2.getId(), 6, 0, 6);
        ImageView r11 = this.f10796b.ivTodo;
        Intrinsics.checkNotNullExpressionValue(r11, "ivTodo");
        if (((View) ZeusTransformUtils.preCheckCast(r11, View.class, "com.obric.memorydata.plugin")).getVisibility() != 0) goto L21;
        boolean r13 = true;
    L22:
        if (r13 == false) goto L24;
        r7.connect(r2.getId(), 7, 0, 7);
        r7.setMargin(r2.getId(), 3, MathKt.roundToInt(TypedValue.applyDimension(1, 4, Resources.getSystem().getDisplayMetrics())));
        goto L25
    L24:
        r7.setMargin(r2.getId(), 3, MathKt.roundToInt(TypedValue.applyDimension(1, 4, Resources.getSystem().getDisplayMetrics())));
        r7.setMargin(r2.getId(), 6, MathKt.roundToInt(TypedValue.applyDimension(1, 12, Resources.getSystem().getDisplayMetrics())));
        r7.setMargin(r2.getId(), 4, MathKt.roundToInt(TypedValue.applyDimension(1, 1, Resources.getSystem().getDisplayMetrics())));
        goto L25
    L21:
        r13 = false;
        goto L22
    L12:
        r6 = null;
        goto L13
    L8:
        r2 = this.f10796b.ivEvent;
        goto L9
    L5:
        r1 = false;
        goto L6
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public void a2(com.obric.memorydata.memory.ui.data.a.c r9) {
        Intrinsics.checkNotNullParameter(r9, "data");
        this.f10796b.oCheckbox.setChecked(a());
        boolean r1 = false;
        this.f10796b.oCheckbox.setClickable(false);
        this.f10796b.tvTitle.setText((CharSequence) ZeusTransformUtils.preCheckCast(r9.b().getTitle(), CharSequence.class, "com.obric.memorydata.plugin"));
        if (Intrinsics.areEqual(r9.b().getEventType(), PendingMemoryCalendar.TYPE_EVENT) == false) goto L5;
        this.f10796b.ivTodo.setVisibility(8);
        this.f10796b.ivEvent.setVisibility(0);
    L7:
        if (r9.b().getLocation() == null) goto L9;
        boolean r0 = true;
    L10:
        OTextView r5 = this.f10796b.tvLocation;
        if (r0 == false) goto L13;
        r5.setVisibility(0);
        this.f10796b.tvLocation.setText((CharSequence) ZeusTransformUtils.preCheckCast(r9.b().getLocation(), CharSequence.class, "com.obric.memorydata.plugin"));
    L14:
        String r10 = t.f10875a.a(r9.b());
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L17;
        boolean r6 = true;
    L18:
        if (r6 == false) goto L20;
        this.f10796b.tvTime.setVisibility(0);
        this.f10796b.tvTime.setText((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin"));
    L21:
        if (r0 == true) goto L24;
        if (r6 == true) goto L24;
        r1 = true;
    L24:
        a(r1);
        return;
    L20:
        this.f10796b.tvTime.setVisibility(8);
        goto L21
    L17:
        r6 = false;
        goto L18
    L13:
        r5.setVisibility(8);
        goto L14
    L9:
        r0 = false;
        goto L10
    L5:
        this.f10796b.ivTodo.setVisibility(0);
        this.f10796b.ivEvent.setVisibility(8);
        goto L7
    }

    @Override // com.obric.memorydata.memory.ui.selection.SelectionPanelItemView
    public /* synthetic */ void a(com.obric.memorydata.memory.ui.data.a.c r3) {
        a2((com.obric.memorydata.memory.ui.data.a.c) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.memory.ui.data.a.c.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.memory.ui.selection.SelectionPanelItemView
    public boolean a() {
        return this.c;
    }

    @Override // com.obric.memorydata.memory.ui.selection.SelectionPanelItemView
    public void setItemSelected(boolean r4) {
        RunLog.INSTANCE.debug("CalendarSelectionPanelItemView", "isItemSelected = " + r4);
        this.c = r4;
        this.f10796b.oCheckbox.setChecked(r4);
    }
}
