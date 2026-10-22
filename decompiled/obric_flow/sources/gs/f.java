package gs;

import android.database.DataSetObserver;
import com.bytedance.ies.xelement.viewpager.ReversingAdapter;
import com.obric.oui.tab.OTabLayoutBase;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends DataSetObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f17179a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f17180b;

    public f(ReversingAdapter r5) {
        this.f17179a = 1;
        Intrinsics.checkNotNullParameter(r5, "mParent");
        this.f17180b = r5;
    }

    @Override // android.database.DataSetObserver
    public final void onChanged() {
        switch(this.f17179a) {
            case 0: goto L8;
            default: goto L4;
        };
    L4:
        ReversingAdapter r5 = (ReversingAdapter) this.f17180b;
        if (r5 == null) goto L10;
        r5.notifyDataSetChanged();
        return;
    L10:
        return;
    L8:
        ((OTabLayoutBase) this.f17180b).r();
    }

    @Override // android.database.DataSetObserver
    public final void onInvalidated() {
        switch(this.f17179a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        onChanged();
        return;
    L6:
        ((OTabLayoutBase) this.f17180b).r();
    }

    public f(OTabLayoutBase r5) {
        this.f17179a = 0;
        this.f17180b = r5;
    }
}
