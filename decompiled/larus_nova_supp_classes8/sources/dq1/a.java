package dq1;

import android.os.Bundle;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.liveinteract.hamlet.HamletAvatarWidget$addDataChangeObserver$;
import com.bytedance.android.livesdk.chatroom.utils.u4;
import com.bytedance.android.livesdk.chatroom.utils.v4;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSCameraInfo;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface a {

    /* JADX INFO: renamed from: dq1.a$a, reason: collision with other inner class name */
    public static final class C0379a {
        public static /* synthetic */ void a(a r2, Long r3, Bundle r4, boolean r5, String r6, Boolean r7, int r8) {
            if ((r8 & 1) == 0) goto L6;
            r3 = null;
        L6:
            if ((r8 & 2) == 0) goto L9;
            r4 = null;
        L9:
            if ((r8 & 4) == 0) goto L12;
            r5 = false;
        L12:
            if ((r8 & 8) == 0) goto L15;
            r6 = null;
        L15:
            if ((r8 & 16) == 0) goto L17;
            r7 = null;
        L17:
            r2.l4(r3, r4, r5, r6, r7);
        }
    }

    VSCameraInfo C4();

    void D4(e r1);

    void F4(v4 r1);

    int W3();

    void c4(LifecycleOwner r1, HamletAvatarWidget$addDataChangeObserver$.inlined.let.lambda.10 r2);

    void e4(DataCenter r1, u4 r2, long r3);

    void l4(Long r1, Bundle r2, boolean r3, String r4, Boolean r5);

    void o4();

    List<VSCameraInfo> p4();

    void x4(DataCenter r1);

    void z4(IRoom r1);
}
