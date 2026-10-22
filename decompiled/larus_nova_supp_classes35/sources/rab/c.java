package rab;

import com.ss.android.lark.custom.repeat.widget.bottom.container.CustomRepeatBottomContainer;
import oab.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c implements f {
    public final /* synthetic */ CustomRepeatBottomContainer a;

    public c(CustomRepeatBottomContainer r1) {
        this.a = r1;
    }

    @Override // oab.f
    public final void onItemSelected(int r3) {
        CustomRepeatBottomContainer r0 = this.a;
        r0.f = r0.d.b(r3);
        this.a.b();
    }
}
