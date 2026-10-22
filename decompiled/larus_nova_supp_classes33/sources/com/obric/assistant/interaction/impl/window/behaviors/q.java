package com.obric.assistant.interaction.impl.window.behaviors;

import androidx.fragment.app.FragmentActivity;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class q implements Runnable {
    public final /* synthetic */ MainBotActivityResumeDestroyBehavior a;
    public final /* synthetic */ Ref.ObjectRef b;
    public final /* synthetic */ FragmentActivity c;
    public final /* synthetic */ int d;

    public /* synthetic */ q(MainBotActivityResumeDestroyBehavior r1, Ref.ObjectRef r2, FragmentActivity r3, int r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MainBotActivityResumeDestroyBehavior.a(this.a, this.b, this.c, this.d);
    }
}
