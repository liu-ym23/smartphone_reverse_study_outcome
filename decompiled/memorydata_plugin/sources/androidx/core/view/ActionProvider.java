package androidx.core.view;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public abstract class ActionProvider {
    private static final String TAG = "ActionProvider(support)";
    private final Context mContext;
    private SubUiVisibilityListener mSubUiVisibilityListener;
    private VisibilityListener mVisibilityListener;

    public interface SubUiVisibilityListener {
        void onSubUiVisibilityChanged(boolean r1);
    }

    public interface VisibilityListener {
        void onActionProviderVisibilityChanged(boolean r1);
    }

    public ActionProvider(Context r3) {
        this.mContext = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
    }

    public Context getContext() {
        return this.mContext;
    }

    public boolean hasSubMenu() {
        return false;
    }

    public boolean isVisible() {
        return true;
    }

    public abstract View onCreateActionView();

    public View onCreateActionView(MenuItem r3) {
        MenuItem r4 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r3, MenuItem.class, "com.obric.memorydata.plugin");
        return onCreateActionView();
    }

    public boolean onPerformDefaultAction() {
        return false;
    }

    public void onPrepareSubMenu(SubMenu r2) {
        SubMenu r1 = (SubMenu) ZeusTransformUtils.wrapperContextForParams(r2, SubMenu.class, "com.obric.memorydata.plugin");
    }

    public boolean overridesItemVisibility() {
        return false;
    }

    public void refreshVisibility() {
        if (this.mVisibilityListener != null) goto L5;
        return;
    L5:
        if (overridesItemVisibility() == false) goto L9;
        this.mVisibilityListener.onActionProviderVisibilityChanged(isVisible());
        return;
    }

    public void reset() {
        this.mVisibilityListener = null;
        this.mSubUiVisibilityListener = null;
    }

    public void setSubUiVisibilityListener(SubUiVisibilityListener r3) {
        this.mSubUiVisibilityListener = (SubUiVisibilityListener) ZeusTransformUtils.wrapperContextForParams(r3, SubUiVisibilityListener.class, "com.obric.memorydata.plugin");
    }

    public void setVisibilityListener(VisibilityListener r3) {
        VisibilityListener r4 = (VisibilityListener) ZeusTransformUtils.wrapperContextForParams(r3, VisibilityListener.class, "com.obric.memorydata.plugin");
        if (this.mVisibilityListener == null) goto L6;
        if (r4 == null) goto L6;
        Log.w(TAG, "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
    L6:
        this.mVisibilityListener = r4;
    }

    public void subUiVisibilityChanged(boolean r1) {
        SubUiVisibilityListener r0 = this.mSubUiVisibilityListener;
        if (r0 == null) goto L6;
        r0.onSubUiVisibilityChanged(r1);
        return;
    }
}
