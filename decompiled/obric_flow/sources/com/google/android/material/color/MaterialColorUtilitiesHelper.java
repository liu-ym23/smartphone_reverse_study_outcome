package com.google.android.material.color;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.google.android.material.R;
import com.google.android.material.color.utilities.DynamicColor;
import com.google.android.material.color.utilities.DynamicScheme;
import com.google.android.material.color.utilities.MaterialDynamicColors;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class MaterialColorUtilitiesHelper {
    private static final Map<Integer, DynamicColor> colorResourceIdToColorValue = null;
    private static final MaterialDynamicColors dynamicColors = null;

    static {
        MaterialDynamicColors r5 = new MaterialDynamicColors();
        dynamicColors = r5;
        HashMap r10 = new HashMap();
        r10.put(Integer.valueOf(R.color.material_personalized_color_primary), r5.primary());
        r10.put(Integer.valueOf(R.color.material_personalized_color_on_primary), r5.onPrimary());
        r10.put(Integer.valueOf(R.color.material_personalized_color_primary_inverse), r5.inversePrimary());
        r10.put(Integer.valueOf(R.color.material_personalized_color_primary_container), r5.primaryContainer());
        r10.put(Integer.valueOf(R.color.material_personalized_color_on_primary_container), r5.onPrimaryContainer());
        r10.put(Integer.valueOf(R.color.material_personalized_color_secondary), r5.secondary());
        r10.put(Integer.valueOf(R.color.material_personalized_color_on_secondary), r5.onSecondary());
        r10.put(Integer.valueOf(R.color.material_personalized_color_secondary_container), r5.secondaryContainer());
        r10.put(Integer.valueOf(R.color.material_personalized_color_on_secondary_container), r5.onSecondaryContainer());
        r10.put(Integer.valueOf(R.color.material_personalized_color_tertiary), r5.tertiary());
        r10.put(Integer.valueOf(R.color.material_personalized_color_on_tertiary), r5.onTertiary());
        r10.put(Integer.valueOf(R.color.material_personalized_color_tertiary_container), r5.tertiaryContainer());
        r10.put(Integer.valueOf(R.color.material_personalized_color_on_tertiary_container), r5.onTertiaryContainer());
        r10.put(Integer.valueOf(R.color.material_personalized_color_background), r5.background());
        r10.put(Integer.valueOf(R.color.material_personalized_color_on_background), r5.onBackground());
        r10.put(Integer.valueOf(R.color.material_personalized_color_surface), r5.surface());
        r10.put(Integer.valueOf(R.color.material_personalized_color_on_surface), r5.onSurface());
        r10.put(Integer.valueOf(R.color.material_personalized_color_surface_variant), r5.surfaceVariant());
        r10.put(Integer.valueOf(R.color.material_personalized_color_on_surface_variant), r5.onSurfaceVariant());
        r10.put(Integer.valueOf(R.color.material_personalized_color_surface_inverse), r5.inverseSurface());
        r10.put(Integer.valueOf(R.color.material_personalized_color_on_surface_inverse), r5.inverseOnSurface());
        r10.put(Integer.valueOf(R.color.material_personalized_color_surface_bright), r5.surfaceBright());
        r10.put(Integer.valueOf(R.color.material_personalized_color_surface_dim), r5.surfaceDim());
        r10.put(Integer.valueOf(R.color.material_personalized_color_surface_container), r5.surfaceContainer());
        r10.put(Integer.valueOf(R.color.material_personalized_color_surface_container_low), r5.surfaceContainerLow());
        r10.put(Integer.valueOf(R.color.material_personalized_color_surface_container_high), r5.surfaceContainerHigh());
        r10.put(Integer.valueOf(R.color.material_personalized_color_surface_container_lowest), r5.surfaceContainerLowest());
        r10.put(Integer.valueOf(R.color.material_personalized_color_surface_container_highest), r5.surfaceContainerHighest());
        r10.put(Integer.valueOf(R.color.material_personalized_color_outline), r5.outline());
        r10.put(Integer.valueOf(R.color.material_personalized_color_outline_variant), r5.outlineVariant());
        r10.put(Integer.valueOf(R.color.material_personalized_color_error), r5.error());
        r10.put(Integer.valueOf(R.color.material_personalized_color_on_error), r5.onError());
        r10.put(Integer.valueOf(R.color.material_personalized_color_error_container), r5.errorContainer());
        r10.put(Integer.valueOf(R.color.material_personalized_color_on_error_container), r5.onErrorContainer());
        r10.put(Integer.valueOf(R.color.material_personalized_color_control_activated), r5.controlActivated());
        r10.put(Integer.valueOf(R.color.material_personalized_color_control_normal), r5.controlNormal());
        r10.put(Integer.valueOf(R.color.material_personalized_color_control_highlight), r5.controlHighlight());
        r10.put(Integer.valueOf(R.color.material_personalized_color_text_primary_inverse), r5.textPrimaryInverse());
        r10.put(Integer.valueOf(R.color.material_personalized_color_text_secondary_and_tertiary_inverse), r5.textSecondaryAndTertiaryInverse());
        r10.put(Integer.valueOf(R.color.material_personalized_color_text_secondary_and_tertiary_inverse_disabled), r5.textSecondaryAndTertiaryInverseDisabled());
        r10.put(Integer.valueOf(R.color.material_personalized_color_text_primary_inverse_disable_only), r5.textPrimaryInverseDisableOnly());
        r10.put(Integer.valueOf(R.color.material_personalized_color_text_hint_foreground_inverse), r5.textHintInverse());
        colorResourceIdToColorValue = Collections.unmodifiableMap(r10);
    }

    private MaterialColorUtilitiesHelper() {
    }

    @NonNull
    public static Map<Integer, Integer> createColorResourcesIdsToColorValues(@NonNull DynamicScheme r5) {
        HashMap r10 = new HashMap();
        Iterator<Map.Entry<Integer, DynamicColor>> r11 = colorResourceIdToColorValue.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L7;
        Map.Entry<Integer, DynamicColor> r12 = r11.next();
        r10.put(r12.getKey(), Integer.valueOf(r12.getValue().getArgb(r5)));
        goto L4
    L7:
        return Collections.unmodifiableMap(r10);
    }
}
