package cp0;

import android.os.Bundle;
import android.view.Surface;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.business.IHostLiveOpenPlatform;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e<T> implements ObservableOnSubscribe {
    public final /* synthetic */ String a;
    public final /* synthetic */ Surface b;

    public e(String r1, Surface r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void subscribe(ObservableEmitter<Object> r5) {
        Intrinsics.checkNotNullParameter(r5, "it");
        IHostLiveOpenPlatform r6 = TTLiveSDK.hostService().hostOpenPlatform();
        String r0 = this.a;
        Bundle r1 = new Bundle();
        r1.putParcelable("key_surface", this.b);
        Unit r2 = Unit.INSTANCE;
        r6.dispatchStaticCommand(r0, "command_update_live_cast_surface", r1);
    }
}
