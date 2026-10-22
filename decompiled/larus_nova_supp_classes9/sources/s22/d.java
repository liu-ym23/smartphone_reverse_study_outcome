package s22;

import com.bytedance.android.livesdk.interactivity.service.wrds.RoomDataSyncModel;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.functions.Function0;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public interface d extends id0.a {
    Disposable a(int r1, l r2);

    void c(long r1, int r3, com.bytedance.android.livesdk.interactivity.chatchannel.manager.c r4);

    <T extends RoomDataSyncModel> T d(long r1, Function0<? extends T> r3);

    void e(long r1, com.bytedance.android.livesdk.interactivity.chatchannel.manager.c r3);

    void removeMessageListener(l r1);
}
