package gc;

import android.content.res.Resources;
import android.util.TypedValue;
import android.widget.TextView;
import ge.l;
import he.j;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends j implements l<CharSequence, xd.j> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f7808a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f7809b;

    public e(i r8, a r10) {
        this.f7808a = r8;
        this.f7809b = r10;
        super(1);
    }

    @Override // ge.l
    public final xd.j invoke(CharSequence r8) {
        CharSequence r10 = r8;
        he.i.f(r10, "it");
        boolean r11 = this.f7808a.f7816i;
        a r12 = this.f7809b;
        r12.getClass();
        TextView r13 = r12.f7803z;
        if (r11 == false) goto L6;
        if (r13 == null) goto L9;
        r13.setVisibility(0);
        r13.setText(r10);
        float r14 = 19;
        int r15 = android.aimedia.a.a("Resources.getSystem()", 1, r14);
        Resources r16 = Resources.getSystem();
        he.i.e(r16, "Resources.getSystem()");
        r13.setPadding(0, r15, 0, l6.a.I0(TypedValue.applyDimension(1, r14, r16.getDisplayMetrics())));
    L9:
        return xd.j.f13877a;
    L6:
        if (r13 == null) goto L9;
        r13.setVisibility(0);
        r13.setText(r10);
        r13.setPadding(0, 0, 0, 0);
        goto L9
    }
}
