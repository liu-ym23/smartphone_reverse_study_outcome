package com.obric.oui.common.style;

import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public interface b {
    default void a(k r2, k r3) {
        setShadow(r2, r3, false);
    }

    boolean decideIsNeedUpdatePressedForegroundBySelf();

    List<k> getCurrentShadows();

    int getRadius();

    float getShadowAlpha();

    int getShadowColor();

    int getShadowElevation();

    boolean hasBorder();

    boolean hasBottomSeparator();

    boolean hasLeftSeparator();

    boolean hasRightSeparator();

    boolean hasTopSeparator();

    boolean isEnableShadowWidthRadius();

    default boolean isFakePressed() {
        return false;
    }

    boolean isShadowVisible();

    void onPressAlphaChange(int r1);

    void onlyShowBottomDivider(int r1, int r2, int r3, int r4);

    void onlyShowLeftDivider(int r1, int r2, int r3, int r4);

    void onlyShowRightDivider(int r1, int r2, int r3, int r4);

    void onlyShowTopDivider(int r1, int r2, int r3, int r4);

    void setBorderColor(int r1);

    void setBorderWidth(int r1);

    void setBottomDividerAlpha(int r1);

    void setEnableShadowWidthRadius(boolean r1);

    boolean setHeightLimit(int r1);

    void setLeftDividerAlpha(int r1);

    void setOuterNormalColor(int r1);

    void setOutlineExcludePadding(boolean r1);

    void setOutlineInset(int r1, int r2, int r3, int r4);

    void setRadius(int r1);

    void setRadius(int r1, int r2, int r3, int r4);

    void setRadiusAndShadow(int r1, int r2, float r3);

    void setRadiusAndShadow(int r1, int r2, int r3, float r4);

    void setRightDividerAlpha(int r1);

    void setShadow(k r1, k r2, boolean r3);

    void setShadowAlpha(float r1);

    void setShadowColor(int r1);

    void setShadowCornerRadius(int r1);

    void setShadowElevation(int r1);

    void setShadowInsets(int r1, int r2);

    void setShadowStyle(int r1);

    void setShadowVisible(boolean r1, boolean r2);

    void setShowBorderOnlyBeforeL(boolean r1);

    void setTopDividerAlpha(int r1);

    void setUseThemeGeneralShadowElevation();

    boolean setWidthLimit(int r1);

    void setWidthMin(int r1);

    boolean shouldUpdateDividerColorOnPress();

    void updateBottomDivider(int r1, int r2, int r3, int r4);

    void updateBottomSeparatorColor(int r1);

    void updateDividerColorStrength(float r1);

    void updateLeftDivider(int r1, int r2, int r3, int r4);

    void updateLeftSeparatorColor(int r1);

    void updateRightDivider(int r1, int r2, int r3, int r4);

    void updateRightSeparatorColor(int r1);

    void updateShadows(List<k> r1);

    void updateTopDivider(int r1, int r2, int r3, int r4);

    void updateTopSeparatorColor(int r1);
}
