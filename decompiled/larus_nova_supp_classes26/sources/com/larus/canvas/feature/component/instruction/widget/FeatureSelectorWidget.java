package com.larus.canvas.feature.component.instruction.widget;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.canvas.feature.component.instruction.AbstractInstructionTabWidget;
import com.larus.canvas.feature.component.instruction.fragment.FeatureSelectorFragment;
import com.larus.canvas.impl.databinding.LarusInstructionTabItemViewBinding;
import com.larus.canvas.service.bean.FeatureOptionPanelItem;
import com.larus.canvas.service.bean.OptionItem;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import iy8.i;
import iy8.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class FeatureSelectorWidget extends AbstractInstructionTabWidget {
    public static final /* synthetic */ int j = 0;
    public FeatureSelectorFragment g;
    public Function0<String> h;
    public final FeatureSelectorWidget$featureItemSelectedCallback$1 i;

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
        if (r0 == null) goto L11;
        e1.x(r0.c);
        SimpleDraweeView r1 = r0.c;
        if (r1 == null) goto L10;
        if (r1 == null) goto L8;
        Context r2 = r1.getContext();
    L9:
        r1.setImageResource(v19.c.b(2130971978, r2, 2131242686));
        goto L10
    L8:
        r2 = null;
    L10:
        e1.x(r0.d);
        r0.d.setText(i().getTabName());
        e1.o(r0.e);
        e1.o(r0.b);
    L11:
        ArrayList r3 = new ArrayList();
        List<FeatureOptionPanelItem> r4 = i().getFeatureOptionPanelList();
        if (r4 == null) goto L26;
        Iterator<T> r5 = r4.iterator();
    L15:
        if (r5.hasNext() == false) goto L26;
        FeatureOptionPanelItem r6 = (FeatureOptionPanelItem) r5.next();
        ArrayList r7 = new ArrayList();
        List<OptionItem> r8 = r6.getOptionList();
        if (r8 == null) goto L25;
        Iterator<T> r9 = r8.iterator();
    L20:
        if (r9.hasNext() == false) goto L25;
        OptionItem r10 = (OptionItem) r9.next();
        Long r11 = Long.valueOf(r10.getId());
        String r12 = r10.getDisplayText();
        if (r12 != null) goto L24;
        r12 = "";
    L24:
        r7.add(new i(r11, r12));
    L25:
        r3.add(new j(r6.getId(), r6.getTitle(), r7));
    L26:
        FeatureSelectorFragment r13 = new FeatureSelectorFragment();
        FeatureSelectorWidget$featureItemSelectedCallback$1 r14 = this.i;
        Intrinsics.checkNotNullParameter(r3, "featureData");
        Intrinsics.checkNotNullParameter(r14, "callback");
        FLogger.a.i("FeatureSelectorFragment", "featureData Size = " + r3.size());
        r13.g = r3;
        r13.h = r14;
        this.g = r13;
    }

    @Override // com.larus.canvas.feature.component.instruction.AbstractInstructionTabWidget
    public final void n() {
        FeatureSelectorFragment r1 = this.g;     // Catch: IllegalStateException -> L25
        if (r1 == null) goto L8;
        boolean r2 = true;
        if (r1.isAdded() != true) goto L8;
    L9:
        if (r2 == true) goto L33;
        Fragment r3 = h();     // Catch: IllegalStateException -> L25
        FeatureSelectorFragment r4 = this.g;     // Catch: IllegalStateException -> L25
        if (r4 == null) goto L17;
        Function0<String> r5 = this.h;     // Catch: IllegalStateException -> L25
        if (r5 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("getCurrentPrompt");     // Catch: IllegalStateException -> L25
        r5 = null;
    L16:
        r4.k = (String) r5.invoke();     // Catch: IllegalStateException -> L25
    L17:
        FeatureSelectorFragment r6 = this.g;     // Catch: IllegalStateException -> L25
        if (r6 == null) goto L34;
        FragmentManager r7 = r3.getParentFragmentManager();     // Catch: IllegalStateException -> L25
        LandscapeRestrictionOperation r8 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;     // Catch: IllegalStateException -> L25
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r6, "FeatureSelectorWidget", r8);     // Catch: IllegalStateException -> L25
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r7, r6, r8) == true) goto L35;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L28
    L23:
        r6.show(r7, "FeatureSelectorWidget");     // Catch: IllegalStateException -> L25
        return;
    L35:
        return;
    L34:
        return;
    L33:
        return;
    L8:
        r2 = false;
    L25:
        e = move-exception;
        FLogger.a.e("FeatureSelectorWidget", "showFeatureSelectorFragment error = " + e.getMessage());
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.larus.canvas.feature.component.instruction.widget.FeatureSelectorWidget$featureItemSelectedCallback$1] */
    public FeatureSelectorWidget() {
        this.i = new FeatureSelectorWidget$featureItemSelectedCallback$1(this);
    }
}
