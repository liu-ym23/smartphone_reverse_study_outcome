package androidx.appcompat.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
public abstract class ActionMode {
    private Object mTag;
    private boolean mTitleOptionalHint;

    public interface Callback {
        boolean onActionItemClicked(ActionMode r5, MenuItem r10);

        boolean onCreateActionMode(ActionMode r5, Menu r10);

        void onDestroyActionMode(ActionMode r5);

        boolean onPrepareActionMode(ActionMode r5, Menu r10);
    }

    public ActionMode() {
    }

    public abstract void finish();

    public abstract View getCustomView();

    public abstract Menu getMenu();

    public abstract MenuInflater getMenuInflater();

    public abstract CharSequence getSubtitle();

    public Object getTag() {
        return this.mTag;
    }

    public abstract CharSequence getTitle();

    public boolean getTitleOptionalHint() {
        return this.mTitleOptionalHint;
    }

    public abstract void invalidate();

    public boolean isTitleOptional() {
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean isUiFocusable() {
        return true;
    }

    public abstract void setCustomView(View r5);

    public abstract void setSubtitle(int r5);

    public abstract void setSubtitle(CharSequence r5);

    public void setTag(Object r5) {
        this.mTag = r5;
    }

    public abstract void setTitle(int r5);

    public abstract void setTitle(CharSequence r5);

    public void setTitleOptionalHint(boolean r5) {
        this.mTitleOptionalHint = r5;
    }
}
