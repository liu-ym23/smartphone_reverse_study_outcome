package androidx.transition;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"ViewConstructor"})
class GhostViewHolder extends FrameLayout {
    private boolean mAttached;

    @NonNull
    private ViewGroup mParent;

    @RequiresApi(21)
    public static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        public static float getZ(View r5) {
            return r5.getZ();
        }
    }

    public GhostViewHolder(ViewGroup r5) {
        super(r5.getContext());
        setClipChildren(false);
        this.mParent = r5;
        r5.setTag(R.id.ghost_view_holder, this);
        this.mParent.getOverlay().add(this);
        this.mAttached = true;
    }

    public static GhostViewHolder getHolder(@NonNull ViewGroup r5) {
        return (GhostViewHolder) r5.getTag(R.id.ghost_view_holder);
    }

    private int getInsertIndex(ArrayList<View> r10) {
        ArrayList r5 = new ArrayList();
        int r11 = getChildCount() - 1;
        int r12 = 0;
    L3:
        if (r12 > r11) goto L9;
        int r13 = (r12 + r11) / 2;
        getParents(((GhostViewPort) getChildAt(r13)).mView, r5);
        if (isOnTop(r10, r5) == false) goto L7;
        r12 = r13 + 1;
    L8:
        r5.clear();
        goto L3
    L7:
        r11 = r13 - 1;
        goto L8
    L9:
        return r12;
    }

    private static void getParents(View r5, ArrayList<View> r10) {
        Object r11 = r5.getParent();
        if ((r11 instanceof ViewGroup) == false) goto L5;
        getParents((View) r11, r10);
    L5:
        r10.add(r5);
    }

    private static boolean isOnTop(ArrayList<View> r10, ArrayList<View> r11) {
        if (r10.isEmpty() == false) goto L5;
        return true;
    L5:
        if (r11.isEmpty() == false) goto L7;
        return true;
    L7:
        if (r10.get(0) != r11.get(0)) goto L25;
        int r5 = Math.min(r10.size(), r11.size());
        int r12 = 1;
    L10:
        if (r12 >= r5) goto L17;
        View r13 = r10.get(r12);
        View r14 = r11.get(r12);
        if (r13 != r14) goto L14;
        r12 = r12 + 1;
        goto L10
    L14:
        return isOnTop(r13, r14);
    L17:
        if (r11.size() != r5) goto L20;
        return true;
    L20:
        return false;
    L25:
        return true;
    }

    public void addGhostView(GhostViewPort r5) {
        ArrayList<View> r10 = new ArrayList();
        getParents(r5.mView, r10);
        int r11 = getInsertIndex(r10);
        if (r11 >= 0) goto L5;
    L8:
        addView(r5);
        return;
    L5:
        if (r11 >= getChildCount()) goto L8;
        addView(r5, r11);
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View r5) {
        if (this.mAttached == false) goto L7;
        super.onViewAdded(r5);
        return;
    L7:
        throw new IllegalStateException("This GhostViewHolder is detached!");
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View r5) {
        super.onViewRemoved(r5);
        if (getChildCount() != 1) goto L7;
        if (getChildAt(0) != r5) goto L7;
    L8:
        this.mParent.setTag(R.id.ghost_view_holder, null);
        this.mParent.getOverlay().remove(this);
        this.mAttached = false;
        return;
    L7:
        if (getChildCount() == 0) goto L8;
    }

    public void popToOverlayTop() {
        if (this.mAttached == false) goto L7;
        this.mParent.getOverlay().remove(this);
        this.mParent.getOverlay().add(this);
        return;
    L7:
        throw new IllegalStateException("This GhostViewHolder is detached!");
    }

    private static boolean isOnTop(View r10, View r11) {
        ViewGroup r5 = (ViewGroup) r10.getParent();
        int r12 = r5.getChildCount();
        if (Api21Impl.getZ(r10) != Api21Impl.getZ(r11)) goto L5;
        int r13 = 0;
    L9:
        if (r13 >= r12) goto L16;
        View r14 = r5.getChildAt(ViewGroupUtils.getChildDrawingOrder(r5, r13));
        if (r14 == r10) goto L21;
        if (r14 == r11) goto L16;
        r13 = r13 + 1;
        goto L9
    L21:
        return false;
    L16:
        return true;
    L5:
        if (Api21Impl.getZ(r10) > Api21Impl.getZ(r11)) goto L7;
        return false;
    L7:
        return true;
    }
}
