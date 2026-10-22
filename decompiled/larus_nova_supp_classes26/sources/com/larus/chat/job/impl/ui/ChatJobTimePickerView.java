package com.larus.chat.job.impl.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import fz8.q;
import fz8.r;
import fz8.u;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 92\u00020\u0001:\u00019B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001bJ\b\u0010\u001c\u001a\u00020\u0010H\u0002J\b\u0010\u001d\u001a\u00020\u0010H\u0002J\\\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00072\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00100#2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00100#2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00100#H\u0002Je\u0010&\u001a\u00020\u001f\"\u0004\b\u0000\u0010'2\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H'0)2\u0006\u0010*\u001a\u0002H'2\u0006\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020\u00162\u0014\b\u0002\u0010.\u001a\u000e\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u00020/0#2\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u00020\u00100#H\u0002¢\u0006\u0002\u00101J\b\u00102\u001a\u00020\u001fH\u0002J\u0010\u00103\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0002J\u0018\u00104\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u0007H\u0002J\u0018\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u00072\u0006\u00108\u001a\u00020,H\u0002RL\u0010\n\u001a4\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/larus/chat/job/impl/ui/ChatJobTimePickerView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onTimeSelected", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "hourOfDay", "minute", "", "getOnTimeSelected", "()Lkotlin/jvm/functions/Function2;", "setOnTimeSelected", "(Lkotlin/jvm/functions/Function2;)V", "selectedIsPm", "", "selectedDisplayHour", "selectedMinute", "bindTime", "time", "Lcom/larus/chat/job/impl/page/edit/ChatJobEditTime;", "renderTimePicker", "syncSelectedTime", "createTimePickerColumns", "Landroid/view/View;", "isPm", "displayHour", "onPeriodSelected", "Lkotlin/Function1;", "onHourSelected", "onMinuteSelected", "createTimeColumn", "T", "values", "", "selectedValue", "weight", "", "isLooping", "valueFormatter", "", "onSelected", "(Ljava/util/List;Ljava/lang/Object;FZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Landroid/view/View;", "createTimeColumnGap", "toDisplayHour", "toHourOfDay", "createRoundedDrawable", "Landroid/graphics/drawable/GradientDrawable;", "color", "radius", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatJobTimePickerView extends FrameLayout {
    public static final int e = 0;
    public static final int f = 0;
    public static final int g = 0;
    public static final int h = 0;
    public static final int i = 0;
    public Function2<? super Integer, ? super Integer, Unit> a;
    public boolean b;
    public int c;
    public int d;

    public static final class a {
    }

    public ChatJobTimePickerView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ChatJobTimePickerView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    static {
        e = ((Number) i5.x1.getValue()).intValue() + i5.b();
        int r0 = i5.Q();
        f = r0;
        int r1 = ((Number) i5.H0.getValue()).intValue();
        g = r1;
        h = (r1 - r0) / 2;
        i = i5.C();
    }

    public final void b() {
        Function2<? super Integer, ? super Integer, Unit> r0 = this.a;
        if (r0 == null) goto L14;
        boolean r1 = this.b;
        int r2 = this.c;
        if (r1 == false) goto L8;
        if (r2 != 12) goto L8;
        r2 = 12;
    L12:
        r0.invoke(Integer.valueOf(r2), Integer.valueOf(this.d));
        return;
    L8:
        if (r1 == false) goto L10;
        r2 = r2 + 12;
        goto L12
    L10:
        if (r2 != 12) goto L12;
        r2 = 0;
        goto L12
    }

    public final Function2<Integer, Integer, Unit> getOnTimeSelected() {
        return this.a;
    }

    public final void setOnTimeSelected(Function2<? super Integer, ? super Integer, Unit> r1) {
        this.a = r1;
    }

    public ChatJobTimePickerView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.c = 1;
    }

    public /* synthetic */ ChatJobTimePickerView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public static RecyclerView a(ChatJobTimePickerView r12, List r13, Object r14, float r15, q r16, Function1 r17, int r18) {
        if ((r18 & 8) == 0) goto L5;
        boolean r5 = true;
    L7:
        if ((r18 & 16) == 0) goto L9;
        Function1 r10 = new r();
    L11:
        return u.a(r12.getContext(), r13, r14, r5, f, new LinearLayout.LayoutParams(0, -1, r15), h, i, r10, r17);
    L9:
        r10 = r16;
        goto L11
    L5:
        r5 = false;
        goto L7
    }
}
