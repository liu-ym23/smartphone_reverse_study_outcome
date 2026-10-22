package qa;

import android.content.Context;
import java.io.File;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class o4 extends m1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f10880b;

    public o4(Context r8) {
        this.f10880b = r8;
    }

    @Override // qa.m1
    public final void a() {
        Context r8 = this.f10880b;
        Iterator<File> r10 = p4.c(p4.h(r8)).iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        p4.a(r8, r10.next().getName());
        goto L4
    L6:
        p4.d(r8);
    }
}
