package o9;

import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;

/* JADX INFO: loaded from: classes2.dex */
public interface b {
    boolean decideIsNeedUpdatePressedForegroundBySelf();

    int getRadius();

    float getShadowAlpha();

    int getShadowColor();

    int getShadowElevation();

    boolean hasBorder();

    boolean hasBottomSeparator();

    boolean hasLeftSeparator();

    boolean hasRightSeparator();

    boolean hasTopSeparator();

    void onPressAlphaChange(int r10);

    void onlyShowBottomDivider(int r10, int r11, int r12, int r13);

    void onlyShowLeftDivider(int r10, int r11, int r12, int r13);

    void onlyShowRightDivider(int r10, int r11, int r12, int r13);

    void onlyShowTopDivider(int r10, int r11, int r12, int r13);

    void setBorderColor(@ColorInt int r10);

    void setBorderWidth(int r10);

    void setBottomDividerAlpha(int r10);

    boolean setHeightLimit(int r10);

    void setLeftDividerAlpha(int r10);

    void setOuterNormalColor(int r10);

    void setOutlineExcludePadding(boolean r10);

    void setOutlineInset(int r10, int r11, int r12, int r13);

    void setRadius(int r10);

    void setRadius(int r10, int r11, int r12, int r13);

    void setRadiusAndShadow(int r10, int r11, float r12);

    void setRadiusAndShadow(int r10, int r11, int r12, float r13);

    void setRightDividerAlpha(int r10);

    void setShadow(@Nullable p r10, @Nullable p r11);

    void setShadowAlpha(float r10);

    void setShadowColor(int r10);

    void setShadowCornerRadius(int r10);

    void setShadowElevation(int r10);

    void setShadowInsets(int r10, int r11);

    void setShadowStyle(@StyleRes int r10);

    void setShowBorderOnlyBeforeL(boolean r10);

    void setTopDividerAlpha(int r10);

    void setUseThemeGeneralShadowElevation();

    boolean setWidthLimit(int r10);

    void setWidthMin(int r10);

    boolean shouldUpdateDividerColorOnPress();

    void updateBottomDivider(int r10, int r11, int r12, int r13);

    void updateBottomSeparatorColor(int r10);

    void updateDividerColorStrength(float r10);

    void updateLeftDivider(int r10, int r11, int r12, int r13);

    void updateLeftSeparatorColor(int r10);

    void updateRightDivider(int r10, int r11, int r12, int r13);

    void updateRightSeparatorColor(int r10);

    void updateTopDivider(int r10, int r11, int r12, int r13);

    void updateTopSeparatorColor(int r10);
}
