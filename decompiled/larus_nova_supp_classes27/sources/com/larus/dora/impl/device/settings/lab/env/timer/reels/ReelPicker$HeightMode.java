package com.larus.dora.impl.device.settings.lab.env.timer.reels;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.math.MathKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/dora/impl/device/settings/lab/env/timer/reels/ReelPicker$HeightMode;", "", "heightInDp", "", "<init>", "(Ljava/lang/String;II)V", "getHeightInDp", "()I", "SEVEN_LINES", "FIVE_LINES", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ReelPicker$HeightMode extends Enum<ReelPicker$HeightMode> {
    public static final ReelPicker$HeightMode FIVE_LINES = null;
    public static final ReelPicker$HeightMode SEVEN_LINES = null;
    public static final /* synthetic */ ReelPicker$HeightMode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int heightInDp;

    public static EnumEntries<ReelPicker$HeightMode> getEntries() {
        return b;
    }

    static {
        ReelPicker$HeightMode r0 = new ReelPicker$HeightMode("SEVEN_LINES", 0, MathKt.roundToInt(TypedValue.applyDimension(1, 292, INVOKEVIRTUAL_com_larus_dora_impl_device_settings_lab_env_timer_reels_ReelPicker$HeightMode_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()))));
        SEVEN_LINES = r0;
        ReelPicker$HeightMode r1 = new ReelPicker$HeightMode("FIVE_LINES", 1, MathKt.roundToInt(TypedValue.applyDimension(1, 212, INVOKEVIRTUAL_com_larus_dora_impl_device_settings_lab_env_timer_reels_ReelPicker$HeightMode_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()))));
        FIVE_LINES = r1;
        ReelPicker$HeightMode[] r2 = {r0, r1};
        a = r2;
        b = EnumEntriesKt.enumEntries(r2);
    }

    public static ReelPicker$HeightMode[] values() {
        return (ReelPicker$HeightMode[]) a.clone();
    }

    public final int getHeightInDp() {
        return this.heightInDp;
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_larus_dora_impl_device_settings_lab_env_timer_reels_ReelPicker$HeightMode_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    public static ReelPicker$HeightMode valueOf(String r1) {
        return (ReelPicker$HeightMode) a.a(ReelPicker$HeightMode.class, r1);
    }

    public ReelPicker$HeightMode(String r1, int r2, int r3) {
        super(r1, r2);
        this.heightInDp = r3;
    }
}
