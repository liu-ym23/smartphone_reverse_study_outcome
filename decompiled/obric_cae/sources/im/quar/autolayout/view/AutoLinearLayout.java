package im.quar.autolayout.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import im.quar.autolayout.AutoLayoutInfo;
import im.quar.autolayout.utils.AutoLayoutHelper;

/* JADX INFO: loaded from: classes2.dex */
public class AutoLinearLayout extends LinearLayout {
    private AutoLayoutHelper mHelper;

    public static class LayoutParams extends LinearLayout.LayoutParams implements AutoLayoutHelper.AutoLayoutParams {
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

    public AutoLinearLayout(Context r8, AttributeSet r10) {
        super(r8, r10);
        this.mHelper = new AutoLayoutHelper(this);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r8) {
        return generateLayoutParams(r8);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int r8, int r10) {
        if (isInEditMode() == true) goto L5;
        this.mHelper.adjustChildren();
    L5:
        super.onMeasure(r8, r10);
        if (isInEditMode() == true) goto L9;
        this.mHelper.applyAspectRatio();
        return;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ LinearLayout.LayoutParams generateLayoutParams(AttributeSet r8) {
        return generateLayoutParams(r8);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet r8) {
        return new LayoutParams(getContext(), r8);
    }
}
