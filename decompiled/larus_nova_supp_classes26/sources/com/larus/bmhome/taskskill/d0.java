package com.larus.bmhome.taskskill;

import kotlin.text.Regex;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class d0 implements Runnable {
    public final /* synthetic */ SkillComponent a;

    public /* synthetic */ d0(SkillComponent r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SkillComponent r0 = this.a;
        Regex r1 = SkillComponent.F2;
        r0.H3();
        r0.Q3();
    }
}
