package com.larus.agents.impl.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBindings;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.agents.impl.databinding.LarusFragmentOfficeTaskSettingsBinding;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.platform.service.p1;
import hq9.o3;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u001a\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0017\u001a\u00020\u0015H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u001d"}, d2 = {"Lcom/larus/agents/impl/ui/OfficeTaskSettingsFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "binding", "Lcom/larus/agents/impl/databinding/LarusFragmentOfficeTaskSettingsBinding;", "displayConfig", "Lcom/larus/platform/model/OfficeTaskSettingsDisplayConfig;", "getDisplayConfig", "()Lcom/larus/platform/model/OfficeTaskSettingsDisplayConfig;", "displayConfig$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onDestroyView", "isItemAllowed", "", "semanticId", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class OfficeTaskSettingsFragment extends Fragment {
    public static final /* synthetic */ int f = 0;
    public LarusFragmentOfficeTaskSettingsBinding d;
    public final Lazy e;

    public static final class a {
    }

    static {
    }

    public final void onDestroyView() {
        this.d = null;
        super.onDestroyView();
    }

    public OfficeTaskSettingsFragment() {
        this.e = LazyKt.lazy(new e());
    }

    public final void onViewCreated(View r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r9, "view");
        super.onViewCreated(r9, r10);
        LarusFragmentOfficeTaskSettingsBinding r11 = this.d;
        if (r11 != null) goto L5;
        return;
    L5:
        Context r12 = requireContext();
        NovaTitleBarEx r7 = r11.d;
        NovaTitleBarEx.Y5(r7, getString(2131901730), null, null, 6);
        int r1 = v19.c.b(2130971749, r12, 2131241477);
        int r13 = 0;
        NovaTitleBarEx.b6(r7, r1, false, null, getString(2131898805), new f(this), 6);
        r7.R5();
        p1 r0 = p1.a;
        boolean r2 = true;
        int r3 = 0;
        if (r0.b() == true) goto L8;
    L16:
        boolean r4 = false;
    L18:
        if (r0.m() == true) goto L20;
    L28:
        boolean r5 = false;
    L29:
        ItemGroup r6 = r11.c;
        if (r4 == true) goto L35;
        if (r5 == true) goto L35;
        r2 = false;
    L35:
        if (r2 == false) goto L37;
        int r8 = 0;
    L38:
        r6.setVisibility(r8);
        ItemTextArrow r14 = r11.b;
        if (r4 == true) goto L42;
        r3 = 8;
    L42:
        r14.setVisibility(r3);
        ItemTextArrow r15 = r11.e;
        if (r5 == true) goto L46;
        r13 = 8;
    L46:
        r15.setVisibility(r13);
        r11.b.setOnClickListener(new g(this));
        r11.e.setOnClickListener(new h(this));
        return;
    L37:
        r8 = 8;
        goto L38
    L20:
        if (((o3) this.e.getValue()).a == true) goto L22;
    L25:
        boolean r16 = true;
    L26:
        if (r16 == false) goto L28;
        r5 = true;
        goto L29
    L22:
        if (((o3) this.e.getValue()).b.contains("office_task_settings.item.work_experience") == true) goto L25;
        r16 = false;
        goto L26
    L8:
        if (((o3) this.e.getValue()).a == true) goto L10;
    L13:
        boolean r17 = true;
    L14:
        if (r17 == false) goto L16;
        r4 = true;
        goto L18
    L10:
        if (((o3) this.e.getValue()).b.contains("office_task_settings.item.preference_instruction") == true) goto L13;
        r17 = false;
        goto L14
    }

    public final View onCreateView(LayoutInflater r7, ViewGroup r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r7, "inflater");
        View r10 = r7.inflate(2131562419, r8, false);
        int r11 = 2131381399;
        ItemTextArrow r2 = ViewBindings.findChildViewById(r10, 2131381399);
        if (r2 == null) goto L13;
        r11 = 2131381402;
        ItemGroup r3 = ViewBindings.findChildViewById(r10, 2131381402);
        if (r3 == null) goto L13;
        r11 = 2131381403;
        NovaTitleBarEx r4 = ViewBindings.findChildViewById(r10, 2131381403);
        if (r4 == null) goto L13;
        r11 = 2131393317;
        ItemTextArrow r5 = ViewBindings.findChildViewById(r10, 2131393317);
        if (r5 == null) goto L13;
        LinearLayout r12 = (LinearLayout) r10;
        this.d = new LarusFragmentOfficeTaskSettingsBinding(r12, r2, r3, r4, r5);
        return r12;
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }
}
