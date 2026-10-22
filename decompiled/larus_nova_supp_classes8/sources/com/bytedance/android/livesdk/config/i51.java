package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/config/i51;", "", "", "linkDynamicWindowOpenAb", "I", "getLinkDynamicWindowOpenAb", "()I", "setLinkDynamicWindowOpenAb", "(I)V", "linkDynamicFloatSeatOpenAb", "getLinkDynamicFloatSeatOpenAb", "setLinkDynamicFloatSeatOpenAb", "linkGuestSpecialEffectEnable", "getLinkGuestSpecialEffectEnable", "setLinkGuestSpecialEffectEnable", "<init>", "()V", "a", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class i51 {

    @SerializedName("link_dynamic_float_empty_seat_open_ab")
    private int linkDynamicFloatSeatOpenAb;

    @SerializedName("link_dynamic_window_open_ab")
    private int linkDynamicWindowOpenAb;

    @SerializedName("link_guest_special_effect_enable")
    private int linkGuestSpecialEffectEnable;

    public static final class a {
    }

    static {
    }

    public i51() {
    }

    public final boolean a() {
        Intrinsics.checkNotNullParameter("link_dynamic_window_open_ab", "key");
        if (this.linkDynamicWindowOpenAb == 1) goto L7;
        return false;
    L7:
        return true;
    }
}
