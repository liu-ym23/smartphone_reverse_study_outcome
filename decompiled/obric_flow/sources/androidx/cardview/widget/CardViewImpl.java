package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
interface CardViewImpl {
    ColorStateList getBackgroundColor(CardViewDelegate r5);

    float getElevation(CardViewDelegate r5);

    float getMaxElevation(CardViewDelegate r5);

    float getMinHeight(CardViewDelegate r5);

    float getMinWidth(CardViewDelegate r5);

    float getRadius(CardViewDelegate r5);

    void initStatic();

    void initialize(CardViewDelegate r5, Context r10, ColorStateList r11, float r12, float r13, float r14);

    void onCompatPaddingChanged(CardViewDelegate r5);

    void onPreventCornerOverlapChanged(CardViewDelegate r5);

    void setBackgroundColor(CardViewDelegate r5, @Nullable ColorStateList r10);

    void setElevation(CardViewDelegate r5, float r10);

    void setMaxElevation(CardViewDelegate r5, float r10);

    void setRadius(CardViewDelegate r5, float r10);

    void updatePadding(CardViewDelegate r5);
}
