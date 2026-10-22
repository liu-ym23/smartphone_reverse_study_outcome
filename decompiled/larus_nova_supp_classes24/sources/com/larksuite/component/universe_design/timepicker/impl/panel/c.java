package com.larksuite.component.universe_design.timepicker.impl.panel;

import android.content.Context;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.component.universe_design.timepicker.impl.data.PickerBuilder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c extends BaseTimePickerController {
    public final boolean a;
    public final d b;
    public final a c;

    @Override // com.larksuite.component.universe_design.timepicker.impl.panel.BaseTimePickerController
    public final List<PickerBuilder> getPickerBuilderList() {
        ArrayList r0 = new ArrayList();
        List<PickerBuilder> r1 = this.b.getPickerBuilderList();
        if ((!r1.isEmpty()) == false) goto L5;
        ((PickerBuilder) ListProtector.get(r1, 0)).getLayoutParams().a = 2.0f;
    L5:
        r0.addAll(r1);
        r0.addAll(this.c.getPickerBuilderList());
        return r0;
    }

    @Override // com.larksuite.component.universe_design.timepicker.impl.panel.BaseTimePickerController
    public final List<WheelView> getPickerViewList() {
        ArrayList r0 = new ArrayList();
        r0.addAll(this.b.getPickerViewList());
        r0.addAll(this.c.getPickerViewList());
        return r0;
    }

    @Override // com.larksuite.component.universe_design.timepicker.impl.panel.BaseTimePickerController
    public final void setCurrentDate(Calendar r2) {
        Intrinsics.checkNotNullParameter(r2, "selectedDate");
        this.b.setCurrentDate(r2);
        this.c.setCurrentDate(r2);
    }

    @Override // com.larksuite.component.universe_design.timepicker.impl.panel.BaseTimePickerController
    public final void setItemDividerVisibility(boolean r2) {
        this.b.setItemDividerVisibility(r2);
        this.c.setItemDividerVisibility(r2);
    }

    @Override // com.larksuite.component.universe_design.timepicker.impl.panel.BaseTimePickerController
    public final void setItemVisibleNum(int r2) {
        this.b.setItemVisibleNum(r2);
        this.c.setItemVisibleNum(r2);
    }

    @Override // com.larksuite.component.universe_design.timepicker.impl.panel.BaseTimePickerController
    public final void setMinuteWheelInterval(int r2) {
        this.c.setMinuteWheelInterval(r2);
    }

    @Override // com.larksuite.component.universe_design.timepicker.impl.panel.BaseTimePickerController
    public final void create(Context r3, List<PickerBuilder> r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "builderList");
        this.b.create(r3, CollectionsKt.listOf(ListProtector.get(r4, 0)));
        if (this.a == false) goto L5;
        List<PickerBuilder> r5 = r4.subList(1, 3);
    L6:
        this.c.create(r3, r5);
        return;
    L5:
        r5 = r4.subList(1, 4);
        goto L6
    }

    public c(Context r3, BaseTimePickerController.PickerPanelDependency r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "pickerPanelDependency");
        super(r3, r4);
        this.a = r5;
        int r0 = d.e;
        this.b = d.a.a(r3, r4);
        this.c = new a(r3, r4, r5, r4.getPanelStyleData().getMinuteInterval());
    }
}
