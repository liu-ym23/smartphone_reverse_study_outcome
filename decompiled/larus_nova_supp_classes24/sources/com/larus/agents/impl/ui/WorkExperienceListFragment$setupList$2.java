package com.larus.agents.impl.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larksuite.component.blockit.sub_process.IP0SubProcess;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.agents.impl.databinding.LarusItemWorkExperienceBinding;
import com.larus.bmhome.view.menu.CreateMenu;
import com.larus.bmhome.view.screenmenu.l0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
final /* synthetic */ class WorkExperienceListFragment$setupList$2 extends FunctionReferenceImpl implements Function2<com.larus.agents.impl.experience.t, View, Unit> {
    public WorkExperienceListFragment$setupList$2(Object r8) {
        super(2, r8, WorkExperienceListFragment.class, "showActions", "showActions(Lcom/larus/agents/impl/experience/WorkExperienceSummary;Landroid/view/View;)V", 0);
    }

    public final void invoke(final com.larus.agents.impl.experience.t r99, final View r100) {
        Intrinsics.checkNotNullParameter(r99, IP0SubProcess.P0_PROCESS_NAME);
        Intrinsics.checkNotNullParameter(r100, "p1");
        final WorkExperienceListFragment r3 = (WorkExperienceListFragment) ((CallableReference) this).receiver;
        int r4 = WorkExperienceListFragment.n;
        final Context r5 = r3.requireContext();
        CreateMenu r6 = new CreateMenu(r5);
        r6.setBackgroundResource(2131239965);
        r6.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        r6.setClipToOutline(true);
        final View r7 = CreateMenu.f(r6, CollectionsKt.listOf(new l0[]{new l0(1, 2131907640, null, null, null, null, null, Integer.valueOf(v19.c.b(2130971821, r5, 2131241952)), null, false, false, null, null, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -132, 127), new l0(2, 2131902407, null, null, null, Integer.valueOf(v19.c.b(2130970996, r5, 2131102650)), null, 2131241933, null, false, false, null, null, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -164, 127)}), 0, false, null, null, new CreateMenu.a.a(0, c7.b(20), c7.b(13), c7.b(13), c7.b(20), 0, 0, 0, 0, 0, 993), null, new q(r3, r99), 380);
        r7.setBackgroundResource(2131239965);
        r7.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        r7.setClipToOutline(true);
        r7.setElevation(c7.b(12));
        LarusItemWorkExperienceBinding r8 = LarusItemWorkExperienceBinding.a(r3.getLayoutInflater(), null);
        ConstraintLayout r9 = r8.a;
        r9.setLayoutDirection(r100.getLayoutDirection());
        r9.setBackgroundResource(2131239961);
        TextView r10 = r8.c;
        String r11 = r99.b;
        if (StringsKt.isBlank(r11) == false) goto L5;
        r11 = r99.c;
    L5:
        r10.setText(r11);
        r8.b.setVisibility(8);
        r9.measure(View.MeasureSpec.makeMeasureSpec(r100.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(r100.getHeight(), 1073741824));
        r9.layout(0, 0, r100.getWidth(), r100.getHeight());
        final Bitmap r0 = Bitmap.createBitmap(r100.getWidth(), r100.getHeight(), Bitmap.Config.ARGB_8888);
        r9.draw(new Canvas(r0));
        r3.m.i(new r(r100, r5));
        r3.m.k(r100, true, new s(r5, r0), new t(r7));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((com.larus.agents.impl.experience.t) r1, (View) r2);
        return Unit.INSTANCE;
    }
}
