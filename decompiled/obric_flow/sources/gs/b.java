package gs;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.obric.oui.tab.OTabLayoutBase;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements ViewPager.OnAdapterChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f17175a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OTabLayoutBase f17176b;

    public b(OTabLayoutBase r5) {
        this.f17176b = r5;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnAdapterChangeListener
    public final void onAdapterChanged(ViewPager r5, PagerAdapter r10, PagerAdapter r11) {
        OTabLayoutBase r12 = this.f17176b;
        if (r12.R != r5) goto L6;
        r12.t(r11, this.f17175a);
        return;
    }
}
