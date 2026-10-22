package ke8;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import com.larus.bmhome.chat.cotdetail.list.view.UplinkTextMenuController;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class z implements ActionMode.Callback {
    public final /* synthetic */ UplinkTextMenuController a;
    public final /* synthetic */ int b;

    @Override // android.view.ActionMode.Callback
    public final void onDestroyActionMode(ActionMode r4) {
        Intrinsics.checkNotNullParameter(r4, "mode");
        final UplinkTextMenuController r0 = this.a;
        if (r0.l != r4) goto L6;
        r0.l = null;
        TextView r5 = r0.a;
        final int r1 = this.b;
        r5.post(new y(r0, r1));
        return;
    }

    public z(UplinkTextMenuController r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.ActionMode.Callback
    public final boolean onActionItemClicked(ActionMode r5, MenuItem r6) {
        Intrinsics.checkNotNullParameter(r5, "mode");
        Intrinsics.checkNotNullParameter(r6, "item");
        if (this.a.b(this.b) == true) goto L7;
        r5.finish();
        return true;
    L7:
        if (r6.getItemId() == 16908321) goto L10;
        return false;
    L10:
        int r7 = Math.min(this.a.a.getSelectionStart(), this.a.a.getSelectionEnd());
        int r0 = Math.max(this.a.a.getSelectionStart(), this.a.a.getSelectionEnd());
        if (r7 < 0) goto L22;
        if (r0 <= r7) goto L22;
        if (r0 > this.a.a.getText().length()) goto L22;
        UplinkTextMenuController r2 = this.a;
        CharSequence r3 = r2.a.getText().subSequence(r7, r0);
        if (r7 == 0) goto L18;
    L20:
        String r8 = "part";
    L21:
        r2.c(r3, r8);
        goto L22
    L18:
        if (r0 != this.a.a.getText().length()) goto L20;
        r8 = "all";
    L22:
        r5.finish();
        return true;
    }

    @Override // android.view.ActionMode.Callback
    public final boolean onCreateActionMode(ActionMode r3, Menu r4) {
        Intrinsics.checkNotNullParameter(r3, "mode");
        Intrinsics.checkNotNullParameter(r4, "menu");
        if (this.a.b(this.b) == true) goto L6;
        return false;
    L6:
        UplinkTextMenuController r0 = this.a;
        r0.l = r3;
        UplinkTextMenuController.a(r0, r4);
        return true;
    }

    @Override // android.view.ActionMode.Callback
    public final boolean onPrepareActionMode(ActionMode r3, Menu r4) {
        Intrinsics.checkNotNullParameter(r3, "mode");
        Intrinsics.checkNotNullParameter(r4, "menu");
        if (this.a.b(this.b) == true) goto L6;
        r3.finish();
        return false;
    L6:
        UplinkTextMenuController.a(this.a, r4);
        return true;
    }
}
