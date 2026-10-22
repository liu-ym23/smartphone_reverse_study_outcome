package gc;

import android.widget.TextView;
import ge.l;
import he.j;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends j implements l<CharSequence, xd.j> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f7810a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f7811b;

    public f(i r8, a r10) {
        this.f7810a = r8;
        this.f7811b = r10;
        super(1);
    }

    @Override // ge.l
    public final xd.j invoke(CharSequence r8) {
        CharSequence r10 = r8;
        he.i.f(r10, "it");
        int r11 = a.E;
        a r12 = this.f7811b;
        r12.getClass();
        TextView r13 = r12.A;
        if (r13 == null) goto L5;
        r13.setVisibility(0);
        r13.setText(r10);
    L5:
        if (r13 == null) goto L7;
        r13.setMaxLines(Integer.MAX_VALUE);
    L7:
        this.f7810a.getClass();
        return xd.j.f13877a;
    }
}
