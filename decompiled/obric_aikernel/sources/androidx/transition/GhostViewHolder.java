package androidx.transition;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"ViewConstructor"})
class GhostViewHolder extends FrameLayout {
    private boolean mAttached;

    @NonNull
    private ViewGroup mParent;

    GhostViewHolder(ViewGroup r10) {
        super(r10.getContext());
        setClipChildren(false);
        this.mParent = r10;
        r10.setTag(R.id.ghost_view_holder, this);
        ViewGroupUtils.getOverlay(this.mParent).add(this);
        this.mAttached = true;
    }

    static GhostViewHolder getHolder(@NonNull ViewGroup r10) {
        return (GhostViewHolder) r10.getTag(R.id.ghost_view_holder);
    }

    private int getInsertIndex(ArrayList<View> r10) {
        ArrayList r11 = new ArrayList();
        int r12 = getChildCount() - 1;
        int r13 = 0;
    L3:
        if (r13 > r12) goto L9;
        int r14 = (r13 + r12) / 2;
        getParents(((GhostViewPort) getChildAt(r14)).mView, r11);
        if (isOnTop(r10, r11) == false) goto L7;
        r13 = r14 + 1;
    L8:
        r11.clear();
        goto L3
    L7:
        r12 = r14 - 1;
        goto L8
    L9:
        return r13;
    }

    private static void getParents(View r10, ArrayList<View> r11) {
        Object r12 = r10.getParent();
        if ((r12 instanceof ViewGroup) == false) goto L5;
        getParents((View) r12, r11);
    L5:
        r11.add(r10);
    }

    private static boolean isOnTop(View r10, View r11) {
        ViewGroup r12 = (ViewGroup) r10.getParent();
        int r13 = r12.getChildCount();
        if (Build.VERSION.SDK_INT >= 21) goto L5;
    L10:
        int r14 = 0;
    L11:
        if (r14 >= r13) goto L19;
        View r15 = r12.getChildAt(ViewGroupUtils.getChildDrawingOrder(r12, r14));
        if (r15 == r10) goto L24;
        if (r15 == r11) goto L19;
        r14 = r14 + 1;
        goto L11
    L24:
        return false;
    L19:
        return true;
    L5:
        if (r10.getZ() == r11.getZ()) goto L10;
        if (r10.getZ() > r11.getZ()) goto L9;
        return false;
    L9:
        return true;
    }

    private static boolean isOnTop(ArrayList<View> r10, ArrayList<View> r11) {
        if (r10.isEmpty() == false) goto L5;
        return true;
    L5:
        if (r11.isEmpty() == false) goto L7;
        return true;
    L7:
        if (r10.get(0) != r11.get(0)) goto L25;
        int r12 = Math.min(r10.size(), r11.size());
        int r13 = 1;
    L10:
        if (r13 >= r12) goto L17;
        View r14 = r10.get(r13);
        View r15 = r11.get(r13);
        if (r14 != r15) goto L14;
        r13 = r13 + 1;
        goto L10
    L14:
        return isOnTop(r14, r15);
    L17:
        if (r11.size() != r12) goto L20;
        return true;
    L20:
        return false;
    L25:
        return true;
    }

    void addGhostView(GhostViewPort r10) {
        ArrayList<View> r11 = new ArrayList();
        getParents(r10.mView, r11);
        int r12 = getInsertIndex(r11);
        if (r12 >= 0) goto L5;
    L8:
        addView(r10);
        return;
    L5:
        if (r12 >= getChildCount()) goto L8;
        addView(r10, r12);
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View r10) {
        if (this.mAttached == false) goto L7;
        super.onViewAdded(r10);
        return;
    L7:
        throw new IllegalStateException("This GhostViewHolder is detached!");
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View r10) {
        super.onViewRemoved(r10);
        if (getChildCount() != 1) goto L7;
        if (getChildAt(0) != r10) goto L7;
    L8:
        this.mParent.setTag(R.id.ghost_view_holder, null);
        ViewGroupUtils.getOverlay(this.mParent).remove(this);
        this.mAttached = false;
        return;
    L7:
        if (getChildCount() == 0) goto L8;
    }

    void popToOverlayTop() {
        if (this.mAttached == false) goto L7;
        ViewGroupUtils.getOverlay(this.mParent).remove(this);
        ViewGroupUtils.getOverlay(this.mParent).add(this);
        return;
    L7:
        throw new IllegalStateException("This GhostViewHolder is detached!");
    }
}
