package q7;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements ActionMode.Callback {
    public a() {
    }

    @Override // android.view.ActionMode.Callback
    public final boolean onActionItemClicked(ActionMode r1, MenuItem r10) {
        return false;
    }

    @Override // android.view.ActionMode.Callback
    public final void onDestroyActionMode(ActionMode r1) {
    }

    @Override // android.view.ActionMode.Callback
    public final boolean onPrepareActionMode(ActionMode r1, Menu r10) {
        return false;
    }

    @Override // android.view.ActionMode.Callback
    public final boolean onCreateActionMode(ActionMode r1, Menu r10) {
        if (r1 == null) goto L6;
        r1.setTitle(null);
        r1.setSubtitle(null);
        r1.getMenu().clear();
        return true;
    L6:
        return true;
    }
}
