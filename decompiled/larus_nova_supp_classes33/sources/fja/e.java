package fja;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.common.oea.foundation.animation.constants.RepeatMode;
import com.obric.common.oea.foundation.animation.constants.RunMode;
import java.util.List;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class e implements Runnable {
    public final /* synthetic */ d a;
    public final /* synthetic */ float b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ View d;
    public final /* synthetic */ RunMode e;
    public final /* synthetic */ float f;
    public final /* synthetic */ RepeatMode g;
    public final /* synthetic */ List h;
    public final /* synthetic */ Function3 i;
    public final /* synthetic */ Function2 j;

    public e(d r1, float r2, boolean r3, View r4, RunMode r5, float r6, RepeatMode r7, List r8, Function3 r9, Function2 r10) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.b(this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
