package com.larus.canvas.feature.component.instruction;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.canvas.feature.component.instruction.model.UIInstructionTab;
import com.larus.canvas.feature.component.instruction.model.UIOptionItem;
import com.larus.canvas.feature.component.instruction.model.UIOptionStatus;
import com.larus.canvas.impl.databinding.LarusInstructionTabItemViewBinding;
import com.larus.canvas.service.bean.InstructionTab;
import com.larus.canvas.service.bean.OptionItem;
import com.larus.uaigc.service.IUgcAIGCService;
import com.larus.utils.j0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public abstract class AbstractInstructionTabWidget implements b {
    public InstructionTab a;
    public UIInstructionTab b;
    public Fragment c;
    public Map<String, String> d;
    public LarusInstructionTabItemViewBinding e;
    public boolean f;

    public AbstractInstructionTabWidget() {
    }

    @Override // com.larus.canvas.feature.component.instruction.b
    public String a() {
        return null;
    }

    @Override // com.larus.canvas.feature.component.instruction.b
    public View b() {
        return null;
    }

    public abstract void g();

    public abstract boolean m();

    public abstract void n();

    public final JSONObject e() {
        JSONObject r0 = new JSONObject();
        String r1 = j().get("pic_source_message_id");
        boolean r2 = true;
        String r4 = null;
        if (r1 != null) goto L5;
    L10:
        r1 = null;
    L11:
        r0.putOpt(MusicAppletPage.KEY_MESSAGE_ID, r1);
        String r3 = j().get("source_creation_task_id");
        if (r3 != null) goto L14;
    L19:
        r0.putOpt("creation_task_id", r4);
        return r0;
    L14:
        if (r3.length() > 0) goto L17;
        r2 = false;
    L17:
        if (r2 == false) goto L19;
        r4 = r3;
        goto L19
    L5:
        if (r1.length() <= 0) goto L7;
        boolean r5 = true;
    L8:
        if (r5 == false) goto L10;
    L7:
        r5 = false;
        goto L8
    }

    public final void f() {
        LarusInstructionTabItemViewBinding r0 = this.e;
        if (r0 == null) goto L11;
        LinearLayout r1 = r0.a;
        if (r1 == null) goto L11;
        if (r0 == null) goto L9;
        if (r1 == null) goto L9;
        Context r2 = r1.getContext();
    L10:
        r1.setBackgroundResource(v19.c.b(2130970874, r2, 2131239867));
    L9:
        r2 = null;
    L11:
        Context r3 = h().getContext();
        if (r3 == null) goto L19;
        LarusInstructionTabItemViewBinding r4 = this.e;
        if (r4 == null) goto L20;
        AppCompatTextView r5 = r4.d;
        if (r5 == null) goto L21;
        r5.setTextColor(ContextCompat.getColor(r3, v19.c.b(2130972079, r3, 2131103136)));
        return;
    L21:
        return;
    L20:
        return;
    }

    public final Fragment h() {
        Fragment r0 = this.c;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("fragment");
        return null;
    }

    public final InstructionTab i() {
        InstructionTab r0 = this.a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("instructionTab");
        return null;
    }

    public final Map<String, String> j() {
        Map<String, String> r0 = this.d;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("traceMap");
        return null;
    }

    public final UIInstructionTab k() {
        UIInstructionTab r0 = this.b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("uiInstructionTab");
        return null;
    }

    public void o() {
        hy9.d r1 = IUgcAIGCService.a.j();
        String r7 = j().get("bot_id");
        String r9 = j().get("action_bar_template_id");
        String r13 = j().get("ai_create_show_mode");
        String r2 = i().getTabName();
        OptionItem r0 = i().getSingleOption();
        if (r0 == null) goto L5;
        String r3 = Long.valueOf(r0.getId()).toString();
    L6:
        String r4 = r3;
        String r20 = j().get("current_page");
        String r8 = j().get("enter_method");
        String r11 = j().get("previous_page");
        hy9.d.a.a(r1, r2, null, r4, j().get("show_from"), "single_function", r7, r8, r9, null, r11, null, r13, null, null, null, null, "no_tab", null, r20, null, e(), 2815232);
        return;
    L5:
        r3 = null;
        goto L6
    }

    public void p() {
        hy9.d r1 = IUgcAIGCService.a.j();
        String r7 = j().get("bot_id");
        String r9 = j().get("action_bar_template_id");
        String r2 = i().getTabName();
        OptionItem r0 = i().getSingleOption();
        if (r0 == null) goto L5;
        String r3 = Long.valueOf(r0.getId()).toString();
    L6:
        String r4 = r3;
        String r15 = j().get("current_page");
        String r8 = j().get("enter_method");
        String r11 = j().get("previous_page");
        hy9.d.a.b(r1, r2, null, r4, j().get("show_from"), "single_function", r7, r8, r9, null, r11, null, null, "no_tab", r15, null, null, null, null, 1035520);
        return;
    L5:
        r3 = null;
        goto L6
    }

    @Override // com.larus.canvas.feature.component.instruction.b
    public final UIInstructionTab c() {
        return UIInstructionTab.copy$default(k(), null, null, null, null, 15, null);
    }

    @Override // com.larus.canvas.feature.component.instruction.b
    public final View d() {
        boolean r3 = false;
        View r0 = LayoutInflater.from(h().getContext()).inflate(2131562466, null, false);
        int r1 = 2131374727;
        AppCompatImageView r7 = ViewBindings.findChildViewById(r0, 2131374727);
        if (r7 == null) goto L22;
        r1 = 2131388022;
        SimpleDraweeView r4 = ViewBindings.findChildViewById(r0, 2131388022);
        if (r4 == null) goto L22;
        r1 = 2131390840;
        AppCompatTextView r11 = ViewBindings.findChildViewById(r0, 2131390840);
        if (r11 == null) goto L22;
        r1 = 2131391380;
        AppCompatTextView r10 = ViewBindings.findChildViewById(r0, 2131391380);
        if (r10 == null) goto L22;
        LinearLayout r2 = (LinearLayout) r0;
        this.e = new LarusInstructionTabItemViewBinding(r2, r7, r4, r11, r10);
        g();
        p();
        if (r4.getVisibility() != 0) goto L13;
        r3 = true;
    L13:
        if (r3 == false) goto L19;
        ViewGroup.LayoutParams r5 = r11.getLayoutParams();
        if (r5 == null) goto L18;
        ViewGroup.MarginLayoutParams r6 = (ViewGroup.MarginLayoutParams) r5;
        int r8 = j0.a;
        r6.setMarginStart(j0.b(v19.c.b(2130971480, null, 2131167331)));
        r11.setLayoutParams(r6);
        goto L19
    L18:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L19:
        r2.setOnClickListener(new a(this));
        return r2;
    L22:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r1)));
    }

    public final void l(InstructionTab r13, Fragment r14, Map<String, String> r15) {
        Intrinsics.checkNotNullParameter(r13, "instructionTab");
        Intrinsics.checkNotNullParameter(r14, "fragment");
        Intrinsics.checkNotNullParameter(r15, "traceMap");
        Intrinsics.checkNotNullParameter(r15, "<set-?>");
        this.d = r15;
        Intrinsics.checkNotNullParameter(r13, "<set-?>");
        this.a = r13;
        ArrayList r16 = new ArrayList();
        List<OptionItem> r1 = r13.getOptionList();
        if (r1 == null) goto L8;
        Iterator<T> r2 = r1.iterator();
    L6:
        if (r2.hasNext() == false) goto L8;
        OptionItem r3 = (OptionItem) r2.next();
        r16.add(new UIOptionItem(r3.getId(), r3.getDisplayText(), false, UIOptionStatus.NORMAL, 4, null));
    L8:
        String r4 = r13.getTabLabel();
        if (r4 != null) goto L11;
        r4 = "";
    L11:
        String r17 = r13.getTabName();
        if (r17 != null) goto L14;
        r17 = "";
    L14:
        UIInstructionTab r5 = new UIInstructionTab(r4, r17, "", r16);
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.b = r5;
        Intrinsics.checkNotNullParameter(r14, "<set-?>");
        this.c = r14;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r14), null, null, new AbstractInstructionTabWidget$init$2(this, null), 3, null);
    }
}
