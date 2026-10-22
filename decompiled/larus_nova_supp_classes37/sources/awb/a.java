package awb;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.suite.lark.emm.impl.SCClipboardProvider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a implements ActionMode.Callback {
    public final /* synthetic */ c a;

    @Override // android.view.ActionMode.Callback
    public final boolean onActionItemClicked(ActionMode r2, MenuItem r3) {
        Intrinsics.checkNotNullParameter(r2, "mode");
        Intrinsics.checkNotNullParameter(r3, "item");
        return false;
    }

    @Override // android.view.ActionMode.Callback
    public final boolean onCreateActionMode(ActionMode r2, Menu r3) {
        Intrinsics.checkNotNullParameter(r2, "mode");
        Intrinsics.checkNotNullParameter(r3, "menu");
        return true;
    }

    public a(c r1) {
        this.a = r1;
    }

    @Override // android.view.ActionMode.Callback
    public final void onDestroyActionMode(ActionMode r2) {
        Intrinsics.checkNotNullParameter(r2, "mode");
        c r3 = this.a;
        r3.c.removeCallbacks(r3.f);
    }

    @Override // android.view.ActionMode.Callback
    public final boolean onPrepareActionMode(ActionMode r4, Menu r5) {
        Intrinsics.checkNotNullParameter(r4, "mode");
        Intrinsics.checkNotNullParameter(r5, "menu");
        c r6 = this.a;
        r6.c.removeCallbacks(r6.f);
        c r7 = this.a;
        r7.c.postDelayed(r7.f, 500);
        SCClipboardProvider.a().S0(r5);
        return true;
    }
}
