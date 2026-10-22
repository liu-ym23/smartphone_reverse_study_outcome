package com.larus.canvas.feature.component.logic;

import com.larus.bmhome.view.ChatConstraintLayout$b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class g0 implements ChatConstraintLayout$b {
    public final /* synthetic */ GenImageInitComponent a;

    @Override // com.larus.bmhome.view.ChatConstraintLayout$b
    public final void onUpdate(int r1) {
    }

    @Override // com.larus.bmhome.view.ChatConstraintLayout$b
    public final void a() {
        final boolean r0 = com.larus.utils.e1.s(this.a.F2());
        com.larus.canvas.feature.component.title.k r1 = (com.larus.canvas.feature.component.title.k) this.a.m.getValue();
        if (r1 == null) goto L6;
        final GenImageInitComponent r2 = this.a;
        r1.N50(new e0(r0, r2));
        return;
    }

    @Override // com.larus.bmhome.view.ChatConstraintLayout$b
    public final void b() {
        final boolean r0 = com.larus.utils.e1.s(this.a.F2());
        com.larus.canvas.feature.component.title.k r1 = (com.larus.canvas.feature.component.title.k) this.a.m.getValue();
        if (r1 == null) goto L6;
        final GenImageInitComponent r2 = this.a;
        r1.N50(new f0(r0, r2));
        return;
    }

    public g0(GenImageInitComponent r1) {
        this.a = r1;
    }
}
