package com.larus.canvas.feature.component.instruction.widget;

import android.view.LayoutInflater;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.canvas.feature.component.instruction.AbstractInstructionTabWidget;
import com.larus.canvas.feature.component.instruction.model.UIOptionItem;
import com.larus.canvas.feature.component.instruction.model.UIOptionStatus;
import com.larus.canvas.feature.component.instruction.ui.CanvasOptionListAdapter;
import com.larus.canvas.impl.databinding.LarusInstructionCanvasOptionCustomAreaBinding;
import com.larus.canvas.impl.databinding.LarusInstructionTabItemViewBinding;
import com.larus.canvas.service.bean.Icon;
import com.larus.canvas.service.bean.OptionItem;
import com.larus.utils.e1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import v19.h;
import v19.y6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class ToolsWidget extends AbstractInstructionTabWidget {
    public LarusInstructionCanvasOptionCustomAreaBinding g;
    public CanvasOptionListAdapter h;

    @Override // com.larus.canvas.feature.component.instruction.AbstractInstructionTabWidget
    public final boolean m() {
        return true;
    }

    @Override // com.larus.canvas.feature.component.instruction.AbstractInstructionTabWidget
    public final void n() {
    }

    @Override // com.larus.canvas.feature.component.instruction.AbstractInstructionTabWidget, com.larus.canvas.feature.component.instruction.b
    public final View b() {
        LarusInstructionCanvasOptionCustomAreaBinding r1 = LarusInstructionCanvasOptionCustomAreaBinding.a(LayoutInflater.from(h().getContext()));
        this.g = r1;
        RecyclerView r2 = r1.b;
        if (r2 == null) goto L42;
        this.h = new CanvasOptionListAdapter();
        LinearLayoutManager r3 = new LinearLayoutManager(h().getContext());
        r3.setOrientation(0);
        r2.setLayoutManager(r3);
        r2.setAdapter(this.h);
        CanvasOptionListAdapter r4 = this.h;
        if (r4 == null) goto L38;
        ArrayList r5 = new ArrayList();
        List<OptionItem> r6 = i().getOptionList();
        if (r6 == null) goto L37;
        Iterator<T> r7 = r6.iterator();
    L10:
        if (r7.hasNext() == false) goto L37;
        OptionItem r8 = (OptionItem) r7.next();
        long r9 = r8.getId();
        String r10 = r8.getDisplayText();
        if (r10 != null) goto L14;
        r10 = "";
    L14:
        String r11 = r10;
        boolean r12 = h.a;
        if (h.a(null) == false) goto L17;
        Icon r13 = r8.getDarkModeIcon();
    L18:
        Icon r14 = r13;
        Iterator<T> r15 = k().getUiOptionList().iterator();
    L20:
        if (r15.hasNext() == false) goto L27;
        Object r16 = r15.next();
        if (((UIOptionItem) r16).getId() != r8.getId()) goto L24;
        boolean r17 = true;
    L25:
        if (r17 == false) goto L20;
    L28:
        UIOptionItem r18 = (UIOptionItem) r16;
        if (r18 == null) goto L31;
        UIOptionStatus r19 = r18.getUiStatus();
    L33:
        if (r19 != UIOptionStatus.LOADING) goto L35;
        boolean r110 = true;
    L36:
        r5.add(new jy8.d(r9, r11, null, r14, false, r110, 16));
        goto L10
    L35:
        r110 = false;
        goto L36
    L31:
        r19 = null;
        goto L33
    L24:
        r17 = false;
        goto L25
    L27:
        r16 = null;
        goto L28
    L17:
        r13 = r8.getIcon();
    L37:
        r4.submitList(r5);
    L38:
        CanvasOptionListAdapter r20 = this.h;
        if (r20 == null) goto L41;
        Function1<? super jy8.d, Unit> r21 = new f(this);
        Intrinsics.checkNotNullParameter(r21, "listener");
        r20.a = r21;
    L41:
        r2.addItemDecoration(new ToolsWidget$buildCustomAreaView$1$3());
        y6.f(r2, null, null, 0.0f, new g(this), 63);
    L42:
        LarusInstructionCanvasOptionCustomAreaBinding r22 = this.g;
        if (r22 != null) goto L45;
        return null;
    L45:
        return r22.a;
    }

    @Override // com.larus.canvas.feature.component.instruction.AbstractInstructionTabWidget
    public final void g() {
        LarusInstructionTabItemViewBinding r0 = this.e;
        if (r0 == null) goto L6;
        e1.o(r0.c);
        e1.x(r0.d);
        r0.d.setText(i().getTabName());
        e1.o(r0.e);
        e1.o(r0.b);
        return;
    }

    public ToolsWidget() {
    }
}
