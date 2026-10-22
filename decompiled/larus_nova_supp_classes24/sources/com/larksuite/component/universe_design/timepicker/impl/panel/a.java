package com.larksuite.component.universe_design.timepicker.impl.panel;

import android.content.Context;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.component.universe_design.timepicker.impl.data.PickerBuilder;
import com.larksuite.component.universe_design.timepicker.impl.helper.TimePickerHelper;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a extends BaseTimePickerController {
    public final boolean a;
    public WheelView b;
    public WheelView c;
    public WheelView d;
    public final boolean e;
    public Calendar f;
    public int g;

    /* JADX INFO: renamed from: com.larksuite.component.universe_design.timepicker.impl.panel.a$a, reason: collision with other inner class name */
    public static final class C0045a {
    }

    static {
    }

    @Override // com.larksuite.component.universe_design.timepicker.impl.panel.BaseTimePickerController
    public final List<PickerBuilder> getPickerBuilderList() {
        ArrayList r0 = new ArrayList();
        int r1 = g18.c.a;
        if (this.a == false) goto L5;
        e18.a r2 = new d18.b(0, 23);
    L6:
        PickerBuilder r3 = new PickerBuilder(r2);
        r3.setShowTwoFigure(true);
        r3.setLoop(true);
        r0.add(r3);
        int r4 = g18.d.a;
        int r5 = this.g;
        PickerBuilder r6 = new PickerBuilder(new d18.b(60 - r5, r5, 0));
        r6.setShowTwoFigure(true);
        r6.setLoop(true);
        r0.add(r6);
        if (this.a == true) goto L9;
        int r7 = g18.a.a;
        Context r8 = getContext();
        Intrinsics.checkNotNullParameter(r8, "context");
        r0.add(new PickerBuilder(new d18.a(new String[]{r8.getResources().getString(2131886985), r8.getResources().getString(2131887047)})));
    L9:
        return r0;
    L5:
        r2 = new d18.f();
        goto L6
    }

    @Override // com.larksuite.component.universe_design.timepicker.impl.panel.BaseTimePickerController
    public final List<WheelView> getPickerViewList() {
        ArrayList r0 = new ArrayList();
        WheelView r1 = this.b;
        if (r1 == null) goto L5;
        r0.add(r1);
    L5:
        WheelView r2 = this.c;
        if (r2 == null) goto L9;
        r0.add(r2);
    L9:
        if (this.a == true) goto L16;
        WheelView r3 = this.d;
        if (r3 == null) goto L16;
        if (this.e == false) goto L15;
        ListProtector.add(r0, 0, r3);
        goto L16
    L15:
        r0.add(r3);
    L16:
        return r0;
    }

    @Override // com.larksuite.component.universe_design.timepicker.impl.panel.BaseTimePickerController
    public final void setCurrentDate(Calendar r4) {
        Intrinsics.checkNotNullParameter(r4, "selectedDate");
        this.f = r4;
        if (this.a == false) goto L11;
        WheelView r0 = this.b;
        if (r0 == null) goto L7;
        r0.setCurrentItem(r4.get(11));
    L7:
        WheelView r1 = this.c;
        if (r1 == null) goto L21;
        r1.setCurrentItem(r4.get(12) / this.g);
        return;
    L21:
        return;
    L11:
        WheelView r2 = this.b;
        if (r2 == null) goto L14;
        r2.setCurrentItem(r4.get(10));
    L14:
        WheelView r3 = this.c;
        if (r3 == null) goto L17;
        r3.setCurrentItem(r4.get(12) / this.g);
    L17:
        WheelView r5 = this.d;
        if (r5 == null) goto L22;
        r5.setCurrentItem(r4.get(9));
        return;
    }

    @Override // com.larksuite.component.universe_design.timepicker.impl.panel.BaseTimePickerController
    public final void setItemDividerVisibility(boolean r2) {
        if (r2 == false) goto L4;
        WheelView.DividerType r3 = WheelView.DividerType.FILL;
    L5:
        WheelView r0 = this.b;
        if (r0 == null) goto L8;
        r0.setDividerType(r3);
    L8:
        WheelView r1 = this.c;
        if (r1 == null) goto L11;
        r1.setDividerType(r3);
    L11:
        WheelView r4 = this.d;
        if (r4 == null) goto L15;
        r4.setDividerType(r3);
        return;
    L15:
        return;
    L4:
        r3 = WheelView.DividerType.NONE;
        goto L5
    }

    @Override // com.larksuite.component.universe_design.timepicker.impl.panel.BaseTimePickerController
    public final void setItemVisibleNum(int r3) {
        WheelView r0 = this.b;
        if (r0 == null) goto L5;
        r0.setItemVisible(r3 + 2);
    L5:
        WheelView r1 = this.c;
        if (r1 == null) goto L9;
        r1.setItemVisible(r3 + 2);
        return;
    }

    @Override // com.larksuite.component.universe_design.timepicker.impl.panel.BaseTimePickerController
    public final void setMinuteWheelInterval(int r5) {
        if (r5 <= 60) goto L5;
        return;
    L5:
        if ((60 % r5) != 0) goto L13;
        this.g = r5;
        WheelView r0 = this.c;
        if (r0 == null) goto L10;
        r0.setAdapter(new d18.b(60 - r5, r5, 0));
    L10:
        setCurrentDate(getPickerPanelDependency().getSelectedDate());
        return;
    }

    @Override // com.larksuite.component.universe_design.timepicker.impl.panel.BaseTimePickerController
    public final void create(Context r5, List<PickerBuilder> r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "builderList");
        Iterator<T> r7 = r6.iterator();
        int r0 = 0;
    L4:
        if (r7.hasNext() == false) goto L21;
        Object r1 = r7.next();
        int r2 = r0 + 1;
        if (r0 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        PickerBuilder r3 = (PickerBuilder) r1;
        if (r0 != 0) goto L12;
        this.b = TimePickerHelper.INSTANCE.createWheelView(r5, r3);
    L19:
        r0 = r2;
        goto L4
    L12:
        if (r0 != 1) goto L15;
        this.c = TimePickerHelper.INSTANCE.createWheelView(r5, r3);
        goto L19
    L15:
        if (r0 != 2) goto L19;
        if (this.a == true) goto L19;
        this.d = TimePickerHelper.INSTANCE.createWheelView(r5, r3);
        goto L19
    L21:
        if (this.b == null) goto L23;
    L25:
        setItemVisibleNum(getPickerPanelDependency().getPanelStyleData().getVisibleItemNum());
        setItemDividerVisibility(getPickerPanelDependency().getPanelStyleData().getItemDividerVisibility());
        b r8 = new b(this);
        WheelView r9 = this.b;
        if (r9 == null) goto L28;
        r9.setOnItemSelectedListener(r8);
    L28:
        WheelView r10 = this.c;
        if (r10 == null) goto L31;
        r10.setOnItemSelectedListener(r8);
    L31:
        WheelView r11 = this.d;
        if (r11 == null) goto L35;
        r11.setOnItemSelectedListener(r8);
    L35:
        if (this.a == true) goto L52;
        WheelView r12 = this.b;
        if (r12 == null) goto L53;
        WheelView r13 = this.d;
        if (r13 == null) goto L54;
        r12.setLoopChangeListener(new f18.a(r13));
        return;
    L54:
        return;
    L53:
        return;
    L52:
        return;
    L23:
        if (this.c != null) goto L25;
    }

    public a(Context r2, BaseTimePickerController.PickerPanelDependency r3, boolean r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "pickerPanelDependency");
        super(r2, r3);
        this.a = r4;
        this.e = TimePickerHelper.INSTANCE.isLanguageAMPMAtFront();
        this.f = r3.getSelectedDate();
        this.g = 1;
        setMinuteWheelInterval(r5);
    }
}
