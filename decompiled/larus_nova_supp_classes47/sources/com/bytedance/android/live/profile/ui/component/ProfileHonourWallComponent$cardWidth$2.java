package com.bytedance.android.live.profile.ui.component;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.bytedance.android.live.core.utils.s1;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class ProfileHonourWallComponent$cardWidth$2 extends Lambda implements Function0<Integer> {
    final /* synthetic */ ProfileHonourWallComponent this$0;

    public ProfileHonourWallComponent$cardWidth$2(ProfileHonourWallComponent r1) {
        this.this$0 = r1;
        super(0);
    }

    public final int invoke() {
        if (com.bytedance.android.live.profile.j.b() == false) goto L5;
        com.bytedance.android.live.profile.j.a();
    L6:
        this.this$0.getClass();
        throw null;
    L5:
        s1.y();
        goto L6
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m107invoke() {
        return Integer.valueOf(invoke());
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_bytedance_android_live_profile_ui_component_ProfileHonourWallComponent$cardWidth$2_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }
}
