package com.obric.miniapp.sheet;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001b\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010\u0005\u001a\u001b\u0010\u0006\u001a\u0004\u0018\u00010\u0007*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010\b\u001a\u0010\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000bH\u0002\u001a\u0010\u0010\f\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000bH\u0002\u001a\u0018\u0010\r\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0001H\u0002\u001a\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u0004*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001a\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0001H\u0002\u001a\u000e\u0010\u0015\u001a\u0004\u0018\u00010\u0016*\u00020\u000bH\u0002¨\u0006\u0017"}, d2 = {"intValue", "", "Lcom/google/gson/JsonObject;", "key", "", "(Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/Integer;", "booleanValue", "", "(Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/Boolean;", "screenHeightPx", "context", "Landroid/content/Context;", "navigationBarHeightPx", "dpToPx", "dp", "stringValue", "updateLayoutHeight", "", "view", "Landroid/view/View;", "height", "findActivity", "Landroid/app/Activity;", "impl_mainlandRelease"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class MiniAppSheetHostKt {
    public static DisplayMetrics INVOKEVIRTUAL_com_obric_miniapp_sheet_MiniAppSheetHostKt_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    public static final /* synthetic */ Activity access$findActivity(Context r0) {
        return findActivity(r0);
    }

    public static final /* synthetic */ int access$navigationBarHeightPx(Context r0) {
        return navigationBarHeightPx(r0);
    }

    public static final /* synthetic */ int access$screenHeightPx(Context r0) {
        return screenHeightPx(r0);
    }

    private static final Activity findActivity(Context r1) {
    L3:
        if ((r1 instanceof ContextWrapper) == false) goto L9;
        if ((r1 instanceof Activity) == true) goto L7;
        r1 = ((ContextWrapper) r1).getBaseContext();
        goto L3
    L7:
        return (Activity) r1;
    L9:
        return null;
    }

    private static final int navigationBarHeightPx(Context r4) {
        int r0 = r4.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        if (r0 > 0) goto L7;
        return 0;
    L7:
        return r4.getResources().getDimensionPixelSize(r0);
    }

    private static final int screenHeightPx(Context r0) {
        return INVOKEVIRTUAL_com_obric_miniapp_sheet_MiniAppSheetHostKt_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r0.getResources()).heightPixels;
    }

    public static final /* synthetic */ Boolean access$booleanValue(JsonObject r0, String r1) {
        return booleanValue(r0, r1);
    }

    public static final /* synthetic */ int access$dpToPx(Context r0, int r1) {
        return dpToPx(r0, r1);
    }

    public static final /* synthetic */ Integer access$intValue(JsonObject r0, String r1) {
        return intValue(r0, r1);
    }

    public static final /* synthetic */ String access$stringValue(JsonObject r0, String r1) {
        return stringValue(r0, r1);
    }

    public static final /* synthetic */ void access$updateLayoutHeight(View r0, int r1) {
        updateLayoutHeight(r0, r1);
    }

    private static final Boolean booleanValue(JsonObject r1, String r2) {
        JsonElement r3 = r1.get(r2);
        if (r3 != null) goto L6;
        return null;
    L6:
        if (r3.isJsonPrimitive() == false) goto L11;
        if (r3.getAsJsonPrimitive().isBoolean() == false) goto L11;
        return Boolean.valueOf(r3.getAsBoolean());
    L11:
        if (r3.isJsonPrimitive() == true) goto L13;
        return null;
    L13:
        if (r3.getAsJsonPrimitive().isString() == true) goto L15;
        return null;
    L15:
        return StringsKt.toBooleanStrictOrNull(r3.getAsString());
    }

    private static final int dpToPx(Context r0, int r1) {
        return (int) (r1 * INVOKEVIRTUAL_com_obric_miniapp_sheet_MiniAppSheetHostKt_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r0.getResources()).density);
    }

    private static final Integer intValue(JsonObject r1, String r2) {
        JsonElement r3 = r1.get(r2);
        if (r3 != null) goto L6;
        return null;
    L6:
        if (r3.isJsonPrimitive() == false) goto L11;
        if (r3.getAsJsonPrimitive().isNumber() == false) goto L11;
        return Integer.valueOf(r3.getAsInt());
    L11:
        if (r3.isJsonPrimitive() == true) goto L13;
        return null;
    L13:
        if (r3.getAsJsonPrimitive().isString() == true) goto L15;
        return null;
    L15:
        return StringsKt.toIntOrNull(r3.getAsString());
    }

    private static final String stringValue(JsonObject r1, String r2) {
        JsonElement r3 = r1.get(r2);
        if (r3 != null) goto L6;
        return null;
    L6:
        if (r3.isJsonPrimitive() == true) goto L8;
        return null;
    L8:
        JsonPrimitive r4 = r3.getAsJsonPrimitive();
        if (r4.isString() == false) goto L12;
        return r4.getAsString();
    L12:
        if (r4.isNumber() == true) goto L16;
        if (r4.isBoolean() == true) goto L16;
        return null;
    L16:
        return r4.toString();
    }

    private static final void updateLayoutHeight(View r2, int r3) {
        ViewGroup.LayoutParams r0 = r2.getLayoutParams();
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.height != r3) goto L8;
        return;
    L8:
        r0.height = r3;
        r2.setLayoutParams(r0);
        r2.requestLayout();
    }
}
