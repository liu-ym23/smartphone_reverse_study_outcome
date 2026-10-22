package im.quar.autolayout.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import im.quar.autolayout.AutoLayoutInfo;
import im.quar.autolayout.utils.AutoLayoutHelper;

/* JADX INFO: loaded from: classes2.dex */
public class AutoRecyclerView extends RecyclerView {
    private final AutoLayoutHelper mHelper;

    public static class GridLayoutParams extends GridLayoutManager.b implements AutoLayoutHelper.AutoLayoutParams {
        private AutoLayoutInfo mAutoLayoutInfo;

        public GridLayoutParams(int r8, int r10) {
            super(r8, r10);
        }

        @Override // im.quar.autolayout.utils.AutoLayoutHelper.AutoLayoutParams
        public AutoLayoutInfo getAutoLayoutInfo() {
            return this.mAutoLayoutInfo;
        }

        public GridLayoutParams(Context r8, AttributeSet r10) {
            super(r8, r10);
            AutoLayoutInfo r11 = AutoLayoutHelper.getAutoLayoutInfo(r8, r10);
            this.mAutoLayoutInfo = r11;
            r11.fillAttrs(this);
        }

        public GridLayoutParams(ViewGroup.LayoutParams r8) {
            super(r8);
        }

        public GridLayoutParams(ViewGroup.MarginLayoutParams r8) {
            super(r8);
        }

        public GridLayoutParams(RecyclerView.p r8) {
            super(r8);
        }
    }

    public static class LayoutParams extends RecyclerView.p implements AutoLayoutHelper.AutoLayoutParams {
        private AutoLayoutInfo mAutoLayoutInfo;

        public LayoutParams(int r8, int r10) {
            super(r8, r10);
        }

        @Override // im.quar.autolayout.utils.AutoLayoutHelper.AutoLayoutParams
        public AutoLayoutInfo getAutoLayoutInfo() {
            return this.mAutoLayoutInfo;
        }

        public LayoutParams(Context r8, AttributeSet r10) {
            super(r8, r10);
            AutoLayoutInfo r11 = AutoLayoutHelper.getAutoLayoutInfo(r8, r10);
            this.mAutoLayoutInfo = r11;
            r11.fillAttrs(this);
        }

        public LayoutParams(ViewGroup.LayoutParams r8) {
            super(r8);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r8) {
            super(r8);
        }
    }

    public static class StaggeredGridLayoutParams extends StaggeredGridLayoutManager.c implements AutoLayoutHelper.AutoLayoutParams {
        private AutoLayoutInfo mAutoLayoutInfo;

        public StaggeredGridLayoutParams(int r8, int r10) {
            super(r8, r10);
        }

        @Override // im.quar.autolayout.utils.AutoLayoutHelper.AutoLayoutParams
        public AutoLayoutInfo getAutoLayoutInfo() {
            return this.mAutoLayoutInfo;
        }

        public StaggeredGridLayoutParams(Context r8, AttributeSet r10) {
            super(r8, r10);
            AutoLayoutInfo r11 = AutoLayoutHelper.getAutoLayoutInfo(r8, r10);
            this.mAutoLayoutInfo = r11;
            r11.fillAttrs(this);
        }

        public StaggeredGridLayoutParams(ViewGroup.LayoutParams r8) {
            super(r8);
        }

        public StaggeredGridLayoutParams(ViewGroup.MarginLayoutParams r8) {
            super(r8);
        }

        public StaggeredGridLayoutParams(RecyclerView.p r8) {
            super(r8);
        }
    }

    public AutoRecyclerView(Context r8) {
        super(r8);
        this.mHelper = new AutoLayoutHelper(this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r8) {
        return generateLayoutParams(r8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onMeasure(int r8, int r10) {
        if (isInEditMode() == true) goto L5;
        this.mHelper.adjustChildren();
    L5:
        super.onMeasure(r8, r10);
        if (isInEditMode() == true) goto L9;
        this.mHelper.applyAspectRatio();
        return;
    }

    public AutoRecyclerView(Context r8, AttributeSet r10) {
        super(r8, r10);
        this.mHelper = new AutoLayoutHelper(this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public RecyclerView.p generateLayoutParams(AttributeSet r8) {
        RecyclerView.o r10 = getLayoutManager();
        if ((r10 instanceof GridLayoutManager) == false) goto L7;
        return new GridLayoutParams(getContext(), r8);
    L7:
        if ((r10 instanceof StaggeredGridLayoutManager) == false) goto L11;
        return new StaggeredGridLayoutParams(getContext(), r8);
    L11:
        return new LayoutParams(getContext(), r8);
    }

    public AutoRecyclerView(Context r8, AttributeSet r10, int r11) {
        super(r8, r10, r11);
        this.mHelper = new AutoLayoutHelper(this);
    }
}
