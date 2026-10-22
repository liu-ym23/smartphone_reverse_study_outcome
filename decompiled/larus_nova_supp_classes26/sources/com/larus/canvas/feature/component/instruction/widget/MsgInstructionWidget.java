package com.larus.canvas.feature.component.instruction.widget;

import android.content.Context;
import androidx.lifecycle.LifecycleOwnerKt;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.canvas.feature.component.instruction.AbstractInstructionTabWidget;
import com.larus.canvas.impl.databinding.LarusInstructionTabItemViewBinding;
import com.larus.canvas.service.bean.Icon;
import com.larus.canvas.service.bean.OptionItem;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.uaigc.service.IUgcAIGCService;
import com.larus.utils.e1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import v19.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class MsgInstructionWidget extends AbstractInstructionTabWidget {
    public static final /* synthetic */ int g = 0;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.canvas.feature.component.instruction.AbstractInstructionTabWidget
    public final boolean m() {
        return false;
    }

    @Override // com.larus.canvas.feature.component.instruction.AbstractInstructionTabWidget
    public final void g() {
        LarusInstructionTabItemViewBinding r0 = this.e;
        if (r0 == null) goto L26;
        Context r1 = h().getContext();
        String r2 = null;
        if (r1 == null) goto L7;
        boolean r3 = h.a;
        Boolean r4 = Boolean.valueOf(h.b(r1));
    L9:
        if (Intrinsics.areEqual(r4, Boolean.TRUE) == false) goto L15;
        OptionItem r5 = i().getSingleOption();
        if (r5 == null) goto L20;
        Icon r6 = r5.getDarkModeIcon();
        if (r6 == null) goto L20;
    L19:
        r2 = r6.getUrl();
    L20:
        SimpleDraweeView r7 = r0.c;
        if (r2 == null) goto L23;
        Intrinsics.checkNotNull(r7);
        e1.x(r7);
        ImageLoaderKt.u(r7, r2, "canvas_instruction_tab_icon");
    L24:
        e1.x(r0.d);
        r0.d.setText(i().getTabName());
        e1.o(r0.e);
        e1.o(r0.b);
        return;
    L23:
        Intrinsics.checkNotNull(r7);
        e1.o(r7);
        goto L24
    L15:
        OptionItem r8 = i().getSingleOption();
        if (r8 == null) goto L20;
        r6 = r8.getIcon();
        if (r6 == null) goto L20;
    L7:
        r4 = null;
        goto L9
    }

    @Override // com.larus.canvas.feature.component.instruction.AbstractInstructionTabWidget
    public final void o() {
        hy9.d r1 = IUgcAIGCService.a.j();
        String r7 = j().get("bot_id");
        String r9 = j().get("action_bar_template_id");
        String r13 = j().get("ai_create_show_mode");
        String r2 = i().getTabName();
        String r20 = j().get("current_page");
        String r8 = j().get("enter_method");
        OptionItem r0 = i().getSingleOption();
        if (r0 == null) goto L5;
        Long r3 = Long.valueOf(r0.getId());
    L6:
        String r4 = String.valueOf(r3);
        String r11 = j().get("previous_page");
        hy9.d.a.a(r1, r2, null, r4, j().get("show_from"), "single_function", r7, r8, r9, null, r11, null, r13, null, null, null, null, "no_tab", null, r20, null, e(), 2815232);
        return;
    L5:
        r3 = null;
        goto L6
    }

    @Override // com.larus.canvas.feature.component.instruction.AbstractInstructionTabWidget
    public final void p() {
        hy9.d r1 = IUgcAIGCService.a.j();
        String r7 = j().get("bot_id");
        String r9 = j().get("action_bar_template_id");
        String r2 = i().getTabName();
        String r15 = j().get("current_page");
        String r8 = j().get("enter_method");
        OptionItem r0 = i().getSingleOption();
        if (r0 == null) goto L5;
        Long r3 = Long.valueOf(r0.getId());
    L6:
        String r4 = String.valueOf(r3);
        String r11 = j().get("previous_page");
        hy9.d.a.b(r1, r2, null, r4, j().get("show_from"), "single_function", r7, r8, r9, null, r11, null, null, "no_tab", r15, null, null, null, null, 1035520);
        return;
    L5:
        r3 = null;
        goto L6
    }

    @Override // com.larus.canvas.feature.component.instruction.AbstractInstructionTabWidget
    public final void n() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(h()), null, null, new MsgInstructionWidget$onInstructionTabClick$1(this, null), 3, null);
    }

    public MsgInstructionWidget() {
    }
}
