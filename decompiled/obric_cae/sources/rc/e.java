package rc;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import com.sdk.bwdl.Utils.BWDLInnerConstant;
import he.i;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends d {

    public interface a {
        void onItemSelected(c r8, int r10);
    }

    public e(Context r8) {
        i.f(r8, "context");
        super(r8);
    }

    @Override // rc.d
    public final void a() {
        Context r8 = getContext();
        i.e(r8, "context");
        Resources r10 = r8.getResources();
        i.e(r10, "context.resources");
        if (r10.getConfiguration().orientation != 2) goto L5;
        boolean r11 = true;
    L7:
        if (r11 == true) goto L12;
        if (getItemViews().size() <= 7) goto L15;
        int r12 = 424;
    L14:
        Resources r13 = Resources.getSystem();
        i.e(r13, "Resources.getSystem()");
        setScrollViewHeight(l6.a.I0(TypedValue.applyDimension(1, r12, r13.getDisplayMetrics())));
        return;
    L15:
        setScrollViewHeight(-2);
        return;
    L12:
        if (getItemViews().size() <= 2) goto L15;
        r12 = BWDLInnerConstant.LINK_RECOVERY;
        goto L14
    L5:
        r11 = false;
        goto L7
    }

    @Override // rc.d
    public final void b() {
    }

    public final int getSelectedItem() {
        Iterator<T> r8 = getItemViews().iterator();
        int r10 = 0;
    L4:
        if (r8.hasNext() == false) goto L13;
        Object r11 = r8.next();
        int r12 = r10 + 1;
        if (r10 < 0) goto L11;
        if (((c) r11).s() == true) goto L9;
        r10 = r12;
        goto L4
    L9:
        return r10;
    L11:
        l6.a.T0();
        throw null;
    L13:
        return -1;
    }
}
