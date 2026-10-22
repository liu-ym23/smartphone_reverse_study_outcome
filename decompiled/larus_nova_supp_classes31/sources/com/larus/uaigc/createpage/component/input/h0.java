package com.larus.uaigc.createpage.component.input;

import com.larus.bmhome.view.ChatConstraintLayout;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class h0 implements ChatConstraintLayout.b {
    public final /* synthetic */ CreationInputComponent a;

    public final void a() {
        Iterator<T> r0 = this.a.z.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((ChatConstraintLayout.b) r0.next()).a();
        goto L4
    }

    public final void b() {
        Iterator<T> r0 = this.a.z.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((ChatConstraintLayout.b) r0.next()).b();
        goto L4
    }

    public h0(CreationInputComponent r1) {
        this.a = r1;
    }

    public final void onUpdate(int r3) {
        Iterator<T> r0 = this.a.z.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((ChatConstraintLayout.b) r0.next()).onUpdate(r3);
        goto L4
    }
}
