package pc;

import android.widget.TextView;
import com.obric.cae.R;
import com.obric.oui.sectiontitlebar.OSectionSupportiveText;
import he.j;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends j implements ge.a<TextView> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OSectionSupportiveText f9989a;

    public a(OSectionSupportiveText r8) {
        this.f9989a = r8;
        super(0);
    }

    @Override // ge.a
    public final TextView f() {
        return (TextView) this.f9989a.findViewById(R.id.section_des);
    }
}
