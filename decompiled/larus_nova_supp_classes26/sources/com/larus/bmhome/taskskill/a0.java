package com.larus.bmhome.taskskill;

import android.os.Bundle;
import androidx.fragment.app.FragmentResultListener;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class a0 implements FragmentResultListener {
    public final /* synthetic */ SkillComponent a;

    public /* synthetic */ a0(SkillComponent r1) {
        this.a = r1;
    }

    public final void onFragmentResult(String r3, Bundle r4) {
        SkillComponent r0 = this.a;
        Regex r1 = SkillComponent.F2;
        Intrinsics.checkNotNullParameter(r3, "<unused var>");
        Intrinsics.checkNotNullParameter(r4, "result");
        r0.getClass();
        if (r4.getBoolean("clear_selection") == false) goto L11;
        Job r5 = r0.T;
        if (r5 == null) goto L7;
        Job.DefaultImpls.cancel$default(r5, null, 1, null);
    L7:
        r0.T = null;
        if (r0.G1 == null) goto L10;
        r0.L1 = true;
    L10:
        r0.G1 = null;
        r0.H1 = null;
        r0.U5("");
        r0.KY();
        r0.T4(false);
        return;
    L11:
        r0.z3(r4.getString("project_id"), r4.getString("project_name"));
    }
}
