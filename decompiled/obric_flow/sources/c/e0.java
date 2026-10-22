package c;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e0 implements OnApplyWindowInsetsListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1040a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f1041b;

    public /* synthetic */ e0(int r5, int r10) {
        this.f1040a = r10;
        this.f1041b = r5;
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public final WindowInsetsCompat onApplyWindowInsets(View r5, WindowInsetsCompat r10) {
        int r11 = this.f1041b;
        switch(this.f1040a) {
            case 0: goto L12;
            default: goto L4;
        };
    L4:
        List r12 = (List) h3.e.f17278a.get(Integer.valueOf(r11));
        if (r12 == null) goto L15;
        Iterator r13 = r12.iterator();
        WindowInsetsCompat r14 = r10;
    L8:
        if (r13.hasNext() == false) goto L11;
        r14 = ((OnApplyWindowInsetsListener) r13.next()).onApplyWindowInsets(r5, r10);
        goto L8
    L11:
        return r14;
    L15:
        return r10;
    L12:
        int r15 = n.s;
        int r16 = r10.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom;
        r5.setPadding(r5.getPaddingLeft(), r11, r5.getPaddingRight(), r16);
        return r10;
    }
}
