package os1;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b.\u0010/R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u001e\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u000b\u001a\u0004\b\u001f\u0010\r\"\u0004\b \u0010\u000fR$\u0010\"\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010(\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010\u000b\u001a\u0004\b)\u0010\r\"\u0004\b*\u0010\u000fR\"\u0010+\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010\u000b\u001a\u0004\b,\u0010\r\"\u0004\b-\u0010\u000f¨\u00060"}, d2 = {"Los1/c;", "", "Los1/d;", "inRoomGestureConfig", "Los1/d;", "e", "()Los1/d;", "setInRoomGestureConfig", "(Los1/d;)V", "", "enableComponentConfig", "Z", "a", "()Z", "setEnableComponentConfig", "(Z)V", "Los1/g;", "inRoomUserLeaveConfig", "Los1/g;", "getInRoomUserLeaveConfig", "()Los1/g;", "setInRoomUserLeaveConfig", "(Los1/g;)V", "Los1/e;", "inRoomOrientationChangeConfig", "Los1/e;", "f", "()Los1/e;", "setInRoomOrientationChangeConfig", "(Los1/e;)V", "enableLongPressConfig", "d", "setEnableLongPressConfig", "Los1/f;", "inRoomServiceConfig", "Los1/f;", "g", "()Los1/f;", "setInRoomServiceConfig", "(Los1/f;)V", "enableInjectComponent", "c", "setEnableInjectComponent", "enableFloatWindowAnim", "b", "setEnableFloatWindowAnim", "<init>", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("enable_component_config")
    private boolean enableComponentConfig;

    @SerializedName("enable_float_window_anim")
    private boolean enableFloatWindowAnim;

    @SerializedName("enable_inject_component")
    private boolean enableInjectComponent;

    @SerializedName("enable_long_press_config")
    private boolean enableLongPressConfig;

    @SerializedName("in_room_gesture_config")
    private d inRoomGestureConfig;

    @SerializedName("in_room_orientation_change_config")
    private e inRoomOrientationChangeConfig;

    @SerializedName("in_room_service_config")
    private f inRoomServiceConfig;

    @SerializedName("in_room_user_leave_config")
    private g inRoomUserLeaveConfig;

    public c() {
    }

    public final boolean a() {
        return this.enableComponentConfig;
    }

    public final boolean b() {
        return this.enableFloatWindowAnim;
    }

    public final boolean c() {
        return this.enableInjectComponent;
    }

    public final boolean d() {
        return this.enableLongPressConfig;
    }

    public final d e() {
        return this.inRoomGestureConfig;
    }

    public final e f() {
        return this.inRoomOrientationChangeConfig;
    }

    public final f g() {
        return this.inRoomServiceConfig;
    }
}
