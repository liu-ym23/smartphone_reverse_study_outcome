package com.ss.android.lark.discretescrollview.transform;

import android.view.View;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class ScaleTransformer implements DiscreteScrollItemTransformer {
    private static final String LOG_TAG = "ScaleTransformer";
    private float maxMinOpacityDiff;
    private float maxMinScaleDiff;
    private float minOpacity;
    private float minScale;
    private Pivot pivotX;
    private Pivot pivotY;

    public static class Builder {
        private float maxScale;
        protected ScaleTransformer transformer;

        public ScaleTransformer build() {
            ScaleTransformer r0 = this.transformer;
            ScaleTransformer.access$402(r0, this.maxScale - ScaleTransformer.access$000(r0));
            ScaleTransformer r1 = this.transformer;
            ScaleTransformer.access$502(r1, 1.0f - ScaleTransformer.access$300(r1));
            return this.transformer;
        }

        public Builder() {
            this.transformer = new ScaleTransformer();
            this.maxScale = 1.0f;
        }

        public Builder setMaxScale(float r1) {
            this.maxScale = r1;
            return this;
        }

        public Builder setMinOpacity(float r2) {
            ScaleTransformer.access$302(this.transformer, r2);
            return this;
        }

        public Builder setMinScale(float r2) {
            ScaleTransformer.access$002(this.transformer, r2);
            return this;
        }

        public Builder setPivotX(Pivot r2) {
            assertAxis(r2, 0);
            ScaleTransformer.access$102(this.transformer, r2);
            return this;
        }

        public Builder setPivotY(Pivot r2) {
            assertAxis(r2, 1);
            ScaleTransformer.access$202(this.transformer, r2);
            return this;
        }

        public Builder setPivotX(Pivot.X r1) {
            return setPivotX(r1.create());
        }

        public Builder setPivotY(Pivot.Y r1) {
            return setPivotY(r1.create());
        }

        private void assertAxis(Pivot r1, int r2) {
            if (r1.a == r2) goto L6;
            Log.e(ScaleTransformer.LOG_TAG, "You passed a Pivot for wrong axis.");
            return;
        }
    }

    public ScaleTransformer() {
        this.pivotX = Pivot.X.CENTER.create();
        this.pivotY = Pivot.Y.CENTER.create();
        this.minScale = 0.8f;
        this.maxMinScaleDiff = 0.2f;
        this.minOpacity = 1.0f;
    }

    public static /* synthetic */ float access$000(ScaleTransformer r0) {
        return r0.minScale;
    }

    public static /* synthetic */ float access$300(ScaleTransformer r0) {
        return r0.minOpacity;
    }

    public static /* synthetic */ float access$002(ScaleTransformer r0, float r1) {
        r0.minScale = r1;
        return r1;
    }

    public static /* synthetic */ Pivot access$102(ScaleTransformer r0, Pivot r1) {
        r0.pivotX = r1;
        return r1;
    }

    public static /* synthetic */ Pivot access$202(ScaleTransformer r0, Pivot r1) {
        r0.pivotY = r1;
        return r1;
    }

    public static /* synthetic */ float access$302(ScaleTransformer r0, float r1) {
        r0.minOpacity = r1;
        return r1;
    }

    public static /* synthetic */ float access$402(ScaleTransformer r0, float r1) {
        r0.maxMinScaleDiff = r1;
        return r1;
    }

    public static /* synthetic */ float access$502(ScaleTransformer r0, float r1) {
        r0.maxMinOpacityDiff = r1;
        return r1;
    }

    @Override // com.ss.android.lark.discretescrollview.transform.DiscreteScrollItemTransformer
    public void transformItem(View r3, float r4) {
        this.pivotX.a(r3);
        this.pivotY.a(r3);
        float r0 = 1.0f - Math.abs(r4);
        float r5 = this.minScale + (this.maxMinScaleDiff * r0);
        r3.setScaleX(r5);
        r3.setScaleY(r5);
        r3.setAlpha(this.minOpacity + (this.maxMinOpacityDiff * r0));
    }
}
