package qe;

import com.bytedance.ies.xelement.banner.Banner;
import com.bytedance.ies.xelement.banner.BannerViewPager;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f21502a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Banner f21503b;

    public /* synthetic */ a(Banner r5, int r10) {
        this.f21502a = r10;
        this.f21503b = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f21502a) {
            case 0: goto L40;
            default: goto L4;
        };
    L4:
        Banner r10 = this.f21503b;
        if (r10.f6382p == false) goto L42;
        boolean r5 = r10.f6381o;
        a r11 = r10.G;
        BannerViewPager r12 = r10.A;
        if (r5 == true) goto L9;
        int r13 = r12.getCurrentItem() + 1;
        if (r13 < r12.getAdapter().getCount()) goto L38;
        r12.setCurrentItem(0, false);
        r10.postDelayed(r11, r10.e);
        return;
    L38:
        r12.setCurrentItem(r13, r10.s);
        r10.postDelayed(r11, r10.e);
        return;
    L9:
        if (r10.f6379m.equals("coverflow") == false) goto L11;
    L14:
        boolean r14 = true;
    L15:
        CopyOnWriteArrayList r15 = r10.F;
        int r16 = r15.size();
        if (r10.E == true) goto L18;
    L24:
        int r17 = 3;
    L26:
        if (r16 > 5) goto L28;
        if (r14 == false) goto L28;
        return;
    L28:
        if (r16 < r17) goto L46;
        int r18 = r12.getCurrentItem() + 1;
        int r19 = r10.f6371a;
        if (r18 < r19) goto L33;
        r12.setCurrentItem(r19 / 2, false);
    L34:
        r10.postDelayed(r11, r10.e);
        return;
    L33:
        r12.setCurrentItem(r18, r10.s);
        goto L34
    L46:
        return;
    L18:
        if (r10.f6381o == false) goto L24;
        if ("normal".equals(r10.f6379m) == false) goto L24;
        if (r15.size() != 2) goto L24;
        r17 = 2;
        goto L26
    L11:
        if (r10.f6379m.equals("flat-coverflow") == true) goto L14;
        r14 = false;
        goto L15
    L42:
        return;
    L40:
        this.f21503b.g();
    }
}
