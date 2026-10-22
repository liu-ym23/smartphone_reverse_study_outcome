package im.quar.autolayout.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import im.quar.autolayout.AutoLayoutInfo;
import im.quar.autolayout.utils.AutoLayoutHelper;

/* JADX INFO: loaded from: classes2.dex */
public class AutoFrameLayout extends FrameLayout {
    private final AutoLayoutHelper mHelper;

    public static class LayoutParams extends FrameLayout.LayoutParams implements AutoLayoutHelper.AutoLayoutParams {
        private AutoLayoutInfo mAutoLayoutInfo;

        public LayoutParams(int r8, int r10) {
            super(r8, r10);
        }

        @Override // im.quar.autolayout.utils.AutoLayoutHelper.AutoLayoutParams
        public AutoLayoutInfo getAutoLayoutInfo() {
            return this.mAutoLayoutInfo;
        }

        public LayoutParams(int r8, int r10, int r11) {
            super(r8, r10, r11);
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

        public LayoutParams(FrameLayout.LayoutParams r8) {
            super(r8);
            ((FrameLayout.LayoutParams) this).gravity = r8.gravity;
        }

        public LayoutParams(LayoutParams r8) {
            this(r8);
            this.mAutoLayoutInfo = r8.mAutoLayoutInfo;
        }
    }

    public AutoFrameLayout(Context r8) {
        super(r8);
        this.mHelper = new AutoLayoutHelper(this);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r8) {
        return generateLayoutParams(r8);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r8, int r10) {
        if (isInEditMode() == true) goto L5;
        this.mHelper.adjustChildren();
    L5:
        super.onMeasure(r8, r10);
        if (isInEditMode() == true) goto L9;
        this.mHelper.applyAspectRatio();
        return;
    }

    public AutoFrameLayout(Context r8, AttributeSet r10) {
        super(r8, r10);
        this.mHelper = new AutoLayoutHelper(this);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ FrameLayout.LayoutParams generateLayoutParams(AttributeSet r8) {
        return generateLayoutParams(r8);
    }

    public AutoFrameLayout(Context r8, AttributeSet r10, int r11) {
        super(r8, r10, r11);
        this.mHelper = new AutoLayoutHelper(this);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet r8) {
        return new LayoutParams(getContext(), r8);
    }
}
