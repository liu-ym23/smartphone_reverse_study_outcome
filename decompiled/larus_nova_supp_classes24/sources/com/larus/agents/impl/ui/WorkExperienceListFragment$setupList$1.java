package com.larus.agents.impl.ui;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import com.larksuite.component.blockit.sub_process.IP0SubProcess;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
final /* synthetic */ class WorkExperienceListFragment$setupList$1 extends FunctionReferenceImpl implements Function1<com.larus.agents.impl.experience.t, Unit> {
    public WorkExperienceListFragment$setupList$1(Object r8) {
        super(1, r8, WorkExperienceListFragment.class, "openDetail", "openDetail(Lcom/larus/agents/impl/experience/WorkExperienceSummary;)V", 0);
    }

    public final void invoke(com.larus.agents.impl.experience.t r5) {
        Intrinsics.checkNotNullParameter(r5, IP0SubProcess.P0_PROCESS_NAME);
        WorkExperienceListFragment r0 = (WorkExperienceListFragment) ((CallableReference) this).receiver;
        int r1 = WorkExperienceListFragment.n;
        r0.getClass();
        int r2 = WorkExperienceDetailFragment.k;
        String r6 = r5.a;
        Intrinsics.checkNotNullParameter(r6, "experienceId");
        WorkExperienceDetailFragment r3 = new WorkExperienceDetailFragment();
        Bundle r4 = new Bundle();
        r4.putString("experience_id", r6);
        r3.setArguments(r4);
        FragmentManager r7 = r0.getChildFragmentManager();
        LandscapeRestrictionOperation r8 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r3, "WorkExperienceDetailFragment", r8);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r7, r3, r8) == true) goto L11;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r3.show(r7, "WorkExperienceDetailFragment");
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((com.larus.agents.impl.experience.t) r1);
        return Unit.INSTANCE;
    }
}
