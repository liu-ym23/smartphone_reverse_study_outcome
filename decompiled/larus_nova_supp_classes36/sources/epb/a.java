package epb;

import android.content.Context;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.passport.signinsdk_api.entity.DeviceId;
import kotlin.Deprecated;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface a {

    /* JADX INFO: renamed from: epb.a$a, reason: collision with other inner class name */
    public interface InterfaceC0257a {
    }

    String getDeviceId();

    void getDeviceId(Context r1, IGetDataCallback<DeviceId> r2);

    String getDeviceIdFromLocal();

    void getDeviceIdWithTimeout(Context r1, IGetDataCallback<DeviceId> r2, long r3);

    String getInstallId();

    @Deprecated(message = "internal use")
    void setAppLogUriRuntime();
}
