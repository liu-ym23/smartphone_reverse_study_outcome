package androidx.transition;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class Scene {
    private Context mContext;
    private Runnable mEnterAction;
    private Runnable mExitAction;
    private View mLayout;
    private int mLayoutId;
    private ViewGroup mSceneRoot;

    public Scene(ViewGroup r2) {
        this.mLayoutId = -1;
        this.mSceneRoot = r2;
    }

    private Scene(ViewGroup r3, int r4, Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        this.mLayoutId = -1;
        this.mContext = ZeusTransformUtils.wrapperContext(r6, "com.obric.memorydata.plugin");
        this.mSceneRoot = r3;
        this.mLayoutId = r4;
    }

    public Scene(ViewGroup r2, View r3) {
        this.mLayoutId = -1;
        this.mSceneRoot = r2;
        this.mLayout = r3;
    }

    public static Scene getCurrentScene(ViewGroup r3) {
        return (Scene) ZeusTransformUtils.preCheckCast(r3.getTag(ZeusTransformUtils.mapRes(R.id.transition_current_scene, OaidModel.KEY_ID, "transition_current_scene")), Scene.class, "com.obric.memorydata.plugin");
    }

    public static Scene getSceneForLayout(ViewGroup r5, int r6, Context r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        SparseArray r0 = (SparseArray) ZeusTransformUtils.preCheckCast(r5.getTag(ZeusTransformUtils.mapRes(R.id.transition_scene_layoutid_cache, OaidModel.KEY_ID, "transition_scene_layoutid_cache")), SparseArray.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        r0 = new SparseArray();
        r5.setTag(ZeusTransformUtils.mapRes(R.id.transition_scene_layoutid_cache, OaidModel.KEY_ID, "transition_scene_layoutid_cache"), r0);
    L5:
        Scene r1 = (Scene) ZeusTransformUtils.preCheckCast(r0.get(r6), Scene.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L8;
        return r1;
    L8:
        Scene r2 = new Scene(r5, r6, r8);
        r0.put(r6, r2);
        return r2;
    }

    static void setCurrentScene(ViewGroup r3, Scene r4) {
        r3.setTag(ZeusTransformUtils.mapRes(R.id.transition_current_scene, OaidModel.KEY_ID, "transition_current_scene"), r4);
    }

    public void enter() {
        if (this.mLayoutId <= 0) goto L5;
    L6:
        getSceneRoot().removeAllViews();
        if (this.mLayoutId <= 0) goto L9;
        ZeusTransformUtils.inflate(LayoutInflater.from(this.mContext), this.mLayoutId, this.mSceneRoot, "com.obric.memorydata.plugin");
    L10:
        Runnable r0 = this.mEnterAction;
        if (r0 == null) goto L13;
        r0.run();
    L13:
        setCurrentScene(this.mSceneRoot, this);
        return;
    L9:
        this.mSceneRoot.addView(this.mLayout);
        goto L10
    L5:
        if (this.mLayout == null) goto L10;
        goto L6
    }

    public void exit() {
        if (getCurrentScene(this.mSceneRoot) != this) goto L8;
        Runnable r1 = this.mExitAction;
        if (r1 == null) goto L9;
        r1.run();
        return;
    L9:
        return;
    }

    public ViewGroup getSceneRoot() {
        return this.mSceneRoot;
    }

    boolean isCreatedFromLayoutResource() {
        if (this.mLayoutId <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void setEnterAction(Runnable r3) {
        this.mEnterAction = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
    }

    public void setExitAction(Runnable r3) {
        this.mExitAction = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
    }
}
