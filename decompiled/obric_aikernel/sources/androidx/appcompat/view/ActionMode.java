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
        boolean onActionItemClicked(ActionMode r10, MenuItem r11);

        boolean onCreateActionMode(ActionMode r10, Menu r11);

        void onDestroyActionMode(ActionMode r10);

        boolean onPrepareActionMode(ActionMode r10, Menu r11);
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

    public abstract void setCustomView(View r10);

    public abstract void setSubtitle(int r10);

    public abstract void setSubtitle(CharSequence r10);

    public void setTag(Object r10) {
        this.mTag = r10;
    }

    public abstract void setTitle(int r10);

    public abstract void setTitle(CharSequence r10);

    public void setTitleOptionalHint(boolean r10) {
        this.mTitleOptionalHint = r10;
    }
}
