package g7a;

import com.lynx.tasm.behavior.ui.scroll.base.LynxBaseScrollView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class f implements g {
    public final /* synthetic */ LynxBaseScrollView a;

    @Override // g7a.g
    public final int getScrollX() {
        LynxBaseScrollView r0 = this.a;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.getScrollOffsetHorizontally();
    }

    @Override // g7a.g
    public final int getScrollY() {
        LynxBaseScrollView r0 = this.a;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.getScrollOffsetVertically();
    }

    public f(LynxBaseScrollView r1) {
        this.a = r1;
    }

    @Override // g7a.g
    public final void scrollTo(int r4, int r5) {
        LynxBaseScrollView r0 = this.a;
        if (r0 == null) goto L6;
        r0.f(new int[]{r4, r5});
        return;
    }
}
