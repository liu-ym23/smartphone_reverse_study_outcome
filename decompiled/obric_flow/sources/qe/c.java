package qe;

import android.content.Context;
import android.widget.Scroller;
import com.bytedance.ies.xelement.banner.Banner;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends Scroller {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Banner f21505a;

    public c(Banner r5, Context r10) {
        this.f21505a = r5;
        super(r10);
    }

    @Override // android.widget.Scroller
    public final void startScroll(int r10, int r11, int r12, int r13, int r14) {
        super.startScroll(r10, r11, r12, r13, this.f21505a.f);
    }

    @Override // android.widget.Scroller
    public final void startScroll(int r10, int r11, int r12, int r13) {
        super.startScroll(r10, r11, r12, r13, this.f21505a.f);
    }
}
