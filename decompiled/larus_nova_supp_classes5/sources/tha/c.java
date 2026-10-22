package tha;

import com.obric.assistant.wakeup.bluetooth_headset.api.IBluetoothHeadSetAPI;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class c {
    public static final IBluetoothHeadSetAPI a() {
        return (IBluetoothHeadSetAPI) ServiceManager.get().getService(IBluetoothHeadSetAPI.class);
    }
}
