package com.bytedance.android.live.liveinteract.plantform.widgt;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IThemeShowArea;
import com.bytedance.android.livesdkapi.depend.model.live.audio.ThemeUpLoadListener;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements com.bytedance.android.live.room.g.b {
    public final /* synthetic */ AudioSceneBasicBusinessContentWidget a;
    public final /* synthetic */ FragmentActivity b;

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.plantform.widgt.a$a, reason: collision with other inner class name */
    public static final class C0062a<T> implements Consumer {
        public final /* synthetic */ a a;

        public C0062a(a r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Long r3 = (Long) r2;
            this.a.a.l = false;
        }
    }

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
        this.a.l = false;
    }

    public a(AudioSceneBasicBusinessContentWidget r1, FragmentActivity r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void b(String r10, String r11, IThemeShowArea r12, ThemeUpLoadListener r13, int r14) {
        if (new PolarisFileWrapper(r10).exists() == true) goto L7;
        ALogger.e("AudioSceneBasicBusinessContentWidget", "ugc background don't exists in path " + r10);
        return;
    L7:
        if (r14 != (-1)) goto L9;
        return;
    L9:
        AudioSceneBasicBusinessContentWidget r15 = this.a;
        IRoom r0 = r15.e;
        if (r0 != null) goto L12;
        return;
    L12:
        if (r10 != null) goto L15;
        return;
    L15:
        if (r15.d != null) goto L17;
        return;
    L17:
        long r3 = r0.getRoomId();
        x00.c r1 = this.a.d;
        if (r1 == null) goto L20;
        r1.r(this.b, r3, r10, r12, r14, r13);
    L20:
        HashMap r16 = new HashMap();
        r16.put("event_page", "live_take_detail");
        j0.l().sendLog("livesdk_anchor_theme_upload_select_click", r16, new Object[]{IRoom.class});
        this.a.n.add(Observable.timer(1, TimeUnit.SECONDS).subscribe(new C0062a(this)));
    }
}
