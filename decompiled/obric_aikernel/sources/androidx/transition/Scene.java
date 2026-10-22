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

    public Scene(@NonNull ViewGroup r10) {
        this.mLayoutId = -1;
        this.mSceneRoot = r10;
    }

    private Scene(ViewGroup r10, int r11, Context r12) {
        this.mLayoutId = -1;
        this.mContext = r12;
        this.mSceneRoot = r10;
        this.mLayoutId = r11;
    }

    public Scene(@NonNull ViewGroup r10, @NonNull View r11) {
        this.mLayoutId = -1;
        this.mSceneRoot = r10;
        this.mLayout = r11;
    }

    @Nullable
    public static Scene getCurrentScene(@NonNull ViewGroup r10) {
        return (Scene) r10.getTag(R.id.transition_current_scene);
    }

    @NonNull
    public static Scene getSceneForLayout(@NonNull ViewGroup r10, @LayoutRes int r11, @NonNull Context r12) {
        int r13 = R.id.transition_scene_layoutid_cache;
        SparseArray r14 = (SparseArray) r10.getTag(r13);
        if (r14 != null) goto L5;
        r14 = new SparseArray();
        r10.setTag(r13, r14);
    L5:
        Scene r15 = (Scene) r14.get(r11);
        if (r15 == null) goto L8;
        return r15;
    L8:
        Scene r16 = new Scene(r10, r11, r12);
        r14.put(r11, r16);
        return r16;
    }

    static void setCurrentScene(@NonNull ViewGroup r10, @Nullable Scene r11) {
        r10.setTag(R.id.transition_current_scene, r11);
    }

    public void enter() {
        if (this.mLayoutId <= 0) goto L5;
    L6:
        getSceneRoot().removeAllViews();
        if (this.mLayoutId <= 0) goto L9;
        LayoutInflater.from(this.mContext).inflate(this.mLayoutId, this.mSceneRoot);
    L10:
        Runnable r10 = this.mEnterAction;
        if (r10 == null) goto L13;
        r10.run();
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
        Runnable r10 = this.mExitAction;
        if (r10 == null) goto L9;
        r10.run();
        return;
    L9:
        return;
    }

    @NonNull
    public ViewGroup getSceneRoot() {
        return this.mSceneRoot;
    }

    boolean isCreatedFromLayoutResource() {
        if (this.mLayoutId <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void setEnterAction(@Nullable Runnable r10) {
        this.mEnterAction = r10;
    }

    public void setExitAction(@Nullable Runnable r10) {
        this.mExitAction = r10;
    }
}
