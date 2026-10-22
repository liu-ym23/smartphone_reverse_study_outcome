package com.larus.bmhome.taskskill;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.fragment.app.FragmentResultListener;
import com.larus.bmhome.taskskill.model.TaskSkill;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class z implements FragmentResultListener {
    public final /* synthetic */ SkillComponent a;

    public /* synthetic */ z(SkillComponent r1) {
        this.a = r1;
    }

    public final void onFragmentResult(String r4, Bundle r5) {
        SkillComponent r0 = this.a;
        Regex r1 = SkillComponent.F2;
        Intrinsics.checkNotNullParameter(r4, "<unused var>");
        Intrinsics.checkNotNullParameter(r5, "result");
        r0.getClass();
        Parcelable r6 = r5.getParcelable("key_skill");
        if ((r6 instanceof TaskSkill) == false) goto L5;
        TaskSkill r7 = (TaskSkill) r6;
    L6:
        if (r7 == null) goto L19;
        String r8 = r7.getName();
        if (r8 != null) goto L11;
    L14:
        boolean r2 = true;
    L15:
        if (r2 == true) goto L20;
        r0.q4();
        ConcurrentHashMap r3 = j2.a;
        j2.n(r7, r0.Z3());
        r0.d5(r8);
        r0.T4(false);
        return;
    L20:
        return;
    L11:
        if (StringsKt.isBlank(r8) == true) goto L14;
        r2 = false;
        goto L15
    L19:
        return;
    L5:
        r7 = null;
        goto L6
    }
}
