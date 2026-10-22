package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/config/je1;", "", "", "precreateRoomContext", "Z", "d", "()Z", "setPrecreateRoomContext", "(Z)V", "precreateVSProgressServiceContext", "e", "setPrecreateVSProgressServiceContext", "precreateInteractionWidgetsPosContext", "c", "setPrecreateInteractionWidgetsPosContext", "precreateCastScreenConnectDataContext", "a", "setPrecreateCastScreenConnectDataContext", "precreateCastScreenViewModel", "b", "setPrecreateCastScreenViewModel", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class je1 {

    @SerializedName("cast_screen_connect_data_context")
    private boolean precreateCastScreenConnectDataContext;

    @SerializedName("cast_screen_view_model")
    private boolean precreateCastScreenViewModel;

    @SerializedName("interaction_widgets_pos_context")
    private boolean precreateInteractionWidgetsPosContext;

    @SerializedName("room_context")
    private boolean precreateRoomContext;

    @SerializedName("vs_progress_service_context")
    private boolean precreateVSProgressServiceContext;

    public je1() {
    }

    public final boolean a() {
        return this.precreateCastScreenConnectDataContext;
    }

    public final boolean b() {
        return this.precreateCastScreenViewModel;
    }

    public final boolean c() {
        return this.precreateInteractionWidgetsPosContext;
    }

    public final boolean d() {
        return this.precreateRoomContext;
    }

    public final boolean e() {
        return this.precreateVSProgressServiceContext;
    }
}
