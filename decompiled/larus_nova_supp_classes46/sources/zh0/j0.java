package zh0;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.radio.impl.RadioWidget;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IThemeShowArea;
import com.bytedance.android.livesdkapi.depend.model.live.audio.ThemeUpLoadListener;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import io.reactivex.Observable;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j0 implements com.bytedance.android.live.room.g.b {
    public final /* synthetic */ FragmentActivity a;
    public final /* synthetic */ RadioWidget b;

    public final /* synthetic */ void c() {
    }

    public final /* synthetic */ void e(String r1, String r2, String r3) {
    }

    public final /* synthetic */ void g(String r1, int r2) {
    }

    public final /* synthetic */ void h() {
    }

    public final /* synthetic */ void onError(String r1) {
    }

    public final void onCanceled() {
        this.b.e = false;
    }

    public j0(RadioWidget r1, FragmentActivity r2) {
        this.b = r1;
        this.a = r2;
    }

    public final void b(String r10, String r11, IThemeShowArea r12, ThemeUpLoadListener r13, int r14) {
        if (new PolarisFileWrapper(r10).exists() == true) goto L7;
        int r15 = RadioWidget.H0;
        ALogger.e("RadioWidget", "ugc background don't exists in path " + r10);
        return;
    L7:
        if (r14 != (-1)) goto L9;
        return;
    L9:
        RadioWidget r16 = this.b;
        IRoom r0 = r16.b;
        if (r0 != null) goto L12;
        return;
    L12:
        x00.c r1 = r16.z;
        if (r1 != null) goto L15;
        return;
    L15:
        r1.r(this.a, r0.getRoomId(), r10, r12, r14, r13);
        HashMap r17 = new HashMap();
        r17.put("event_page", "live_take_detail");
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_anchor_theme_upload_select_click", r17, new Object[]{IRoom.class});
        this.b.J.add(Observable.timer(1, TimeUnit.SECONDS).subscribe(new i0(this)));
    }
}
