package lib;

import android.app.Activity;
import android.content.DialogInterface;
import com.ss.android.lark.keyboard.edittext2.KeyboardFunctionEditText;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class n implements DialogInterface.OnClickListener {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ Activity b;
    public final /* synthetic */ KeyboardFunctionEditText c;
    public final /* synthetic */ q d;

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(final DialogInterface r7, int r8) {
        final boolean r2 = this.a;
        final Activity r3 = this.b;
        final KeyboardFunctionEditText r4 = this.c;
        final q r5 = this.d;
        qqb.c.c(new m(r7, r2, r3, r4, r5));
    }

    public n(boolean r1, Activity r2, KeyboardFunctionEditText r3, com.ss.android.lark.forwardv2.impl.view.h r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
