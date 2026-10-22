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
import v19.y6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class CanvasOptionsWidget extends AbstractInstructionTabWidget {
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
        List<OptionItem> r1 = i().getOptionList();
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L12;
        View r3 = new View(h().getActivity());
        r3.setLayoutParams(new RecyclerView.LayoutParams(-1, 0));
        return r3;
    L12:
        LarusInstructionCanvasOptionCustomAreaBinding r4 = LarusInstructionCanvasOptionCustomAreaBinding.a(LayoutInflater.from(h().getContext()));
        this.g = r4;
        RecyclerView r5 = r4.b;
        if (r5 == null) goto L48;
        this.h = new CanvasOptionListAdapter();
        LinearLayoutManager r6 = new LinearLayoutManager(h().getContext());
        r6.setOrientation(0);
        r5.setLayoutManager(r6);
        r5.setAdapter(this.h);
        CanvasOptionListAdapter r7 = this.h;
        if (r7 == null) goto L44;
        ArrayList r8 = new ArrayList();
        List<OptionItem> r9 = i().getOptionList();
        if (r9 == null) goto L43;
        Iterator<T> r10 = r9.iterator();
    L20:
        if (r10.hasNext() == false) goto L43;
        OptionItem r11 = (OptionItem) r10.next();
        long r12 = r11.getId();
        String r13 = r11.getDisplayText();
        if (r13 != null) goto L24;
        r13 = "";
    L24:
        String r14 = r13;
        Icon r15 = r11.getIcon();
        Iterator<T> r16 = k().getUiOptionList().iterator();
    L26:
        if (r16.hasNext() == false) goto L33;
        Object r17 = r16.next();
        if (((UIOptionItem) r17).getId() != r11.getId()) goto L30;
        boolean r18 = true;
    L31:
        if (r18 == false) goto L26;
    L34:
        UIOptionItem r19 = (UIOptionItem) r17;
        if (r19 == null) goto L37;
        UIOptionStatus r20 = r19.getUiStatus();
    L39:
        if (r20 != UIOptionStatus.LOADING) goto L41;
        boolean r110 = true;
    L42:
        r8.add(new jy8.d(r12, r14, r15, null, r110, false, 32));
        goto L20
    L41:
        r110 = false;
        goto L42
    L37:
        r20 = null;
        goto L39
    L30:
        r18 = false;
        goto L31
    L33:
        r17 = null;
    L43:
        r7.submitList(r8);
    L44:
        CanvasOptionListAdapter r21 = this.h;
        if (r21 == null) goto L47;
        Function1<? super jy8.d, Unit> r22 = new a(this);
        Intrinsics.checkNotNullParameter(r22, "listener");
        r21.a = r22;
    L47:
        r5.addItemDecoration(new CanvasOptionsWidget$buildCustomAreaView$2$3());
        y6.f(r5, null, null, 0.0f, new b(this), 63);
    L48:
        LarusInstructionCanvasOptionCustomAreaBinding r23 = this.g;
        if (r23 != null) goto L51;
        return null;
    L51:
        return r23.a;
    L5:
        if (r1.isEmpty() == true) goto L8;
        r2 = false;
        goto L9
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

    public CanvasOptionsWidget() {
    }
}
