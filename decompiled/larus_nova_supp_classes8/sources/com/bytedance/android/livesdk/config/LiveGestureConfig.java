package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleId;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/config/LiveGestureConfig;", "", "", "enable", "Z", "b", "()Z", "d", "(Z)V", "", "adjustLongPressTimeout", "I", "a", "()I", "setAdjustLongPressTimeout", "(I)V", "", "resetLongPressTimeout", "J", "c", "()J", "setResetLongPressTimeout", "(J)V", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveGestureConfig {
    public static final Lazy a = null;
    public static final Lazy b = null;

    @SerializedName("adjust_long_press_timeout")
    private int adjustLongPressTimeout;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("reset_long_press_timeout")
    private long resetLongPressTimeout;

    public static final class a {
    }

    public final void d() {
        this.enable = true;
    }

    static {
        a = LazyKt.lazy(LiveGestureConfig$Companion$DEFAULT$2.INSTANCE);
        b = LazyKt.lazy(LiveGestureConfig$Companion$DEBUG$2.INSTANCE);
    }

    public LiveGestureConfig() {
        this.adjustLongPressTimeout = BubbleId.PadCast;
        this.resetLongPressTimeout = 2000;
    }

    public final int a() {
        return this.adjustLongPressTimeout;
    }

    public final boolean b() {
        return this.enable;
    }

    public final long c() {
        return this.resetLongPressTimeout;
    }
}
