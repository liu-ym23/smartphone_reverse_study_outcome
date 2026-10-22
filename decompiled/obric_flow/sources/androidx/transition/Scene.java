package androidx.transition;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class Scene {
    private Context mContext;
    private Runnable mEnterAction;
    private Runnable mExitAction;
    private View mLayout;
    private int mLayoutId;
    private ViewGroup mSceneRoot;

    public Scene(@NonNull ViewGroup r5) {
        this.mLayoutId = -1;
        this.mSceneRoot = r5;
    }

    @Nullable
    public static Scene getCurrentScene(@NonNull ViewGroup r5) {
        return (Scene) r5.getTag(R.id.transition_current_scene);
    }

    @NonNull
    public static Scene getSceneForLayout(@NonNull ViewGroup r5, @LayoutRes int r10, @NonNull Context r11) {
        SparseArray r12 = (SparseArray) r5.getTag(R.id.transition_scene_layoutid_cache);
        if (r12 != null) goto L5;
        r12 = new SparseArray();
        r5.setTag(R.id.transition_scene_layoutid_cache, r12);
    L5:
        Scene r13 = (Scene) r12.get(r10);
        if (r13 == null) goto L8;
        return r13;
    L8:
        Scene r14 = new Scene(r5, r10, r11);
        r12.put(r10, r14);
        return r14;
    }

    public static void setCurrentScene(@NonNull ViewGroup r5, @Nullable Scene r10) {
        r5.setTag(R.id.transition_current_scene, r10);
    }

    public void enter() {
        if (this.mLayoutId <= 0) goto L5;
    L6:
        getSceneRoot().removeAllViews();
        if (this.mLayoutId <= 0) goto L9;
        LayoutInflater.from(this.mContext).inflate(this.mLayoutId, this.mSceneRoot);
    L10:
        Runnable r5 = this.mEnterAction;
        if (r5 == null) goto L13;
        r5.run();
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
        Runnable r5 = this.mExitAction;
        if (r5 == null) goto L9;
        r5.run();
        return;
    L9:
        return;
    }

    @NonNull
    public ViewGroup getSceneRoot() {
        return this.mSceneRoot;
    }

    public boolean isCreatedFromLayoutResource() {
        if (this.mLayoutId <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void setEnterAction(@Nullable Runnable r5) {
        this.mEnterAction = r5;
    }

    public void setExitAction(@Nullable Runnable r5) {
        this.mExitAction = r5;
    }

    private Scene(ViewGroup r5, int r10, Context r11) {
        this.mContext = r11;
        this.mSceneRoot = r5;
        this.mLayoutId = r10;
    }

    public Scene(@NonNull ViewGroup r5, @NonNull View r10) {
        this.mLayoutId = -1;
        this.mSceneRoot = r5;
        this.mLayout = r10;
    }
}
