package dc;

import android.widget.TextView;

/* JADX INFO: loaded from: classes2.dex */
public final class j extends he.j implements ge.l<CharSequence, xd.j> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f7057a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f7058b;

    public j(k r8, e r10) {
        this.f7057a = r8;
        this.f7058b = r10;
        super(1);
    }

    @Override // ge.l
    public final xd.j invoke(CharSequence r8) {
        CharSequence r10 = r8;
        he.i.f(r10, "it");
        int r11 = e.D;
        e r12 = this.f7058b;
        r12.getClass();
        TextView r13 = r12.f7049y;
        if (r13 == null) goto L5;
        r13.setVisibility(0);
        r13.setText(r10);
    L5:
        if (r13 == null) goto L7;
        r13.setMaxLines(Integer.MAX_VALUE);
    L7:
        this.f7057a.getClass();
        return xd.j.f13877a;
    }
}
