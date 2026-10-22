package com.bytedance.android.live.platformplayer.subcamera;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import com.bytedance.common.utility.Logger;
import com.bytedance.ies.sdk.widgets.DataCenter;
import ds0.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class SubCameraStateHandler {
    public es0.a a;
    public long b;
    public boolean c;
    public final SubCameraStateHandler$subStreamReadyObserver$1 d;
    public final SubCameraStateHandler$subStreamErrorObserver$1 e;
    public final ILivePlayerClient f;
    public final d g;
    public final DataCenter h;

    public static final class a {
    }

    static {
    }

    public final void a(es0.a r5) {
        Intrinsics.checkNotNullParameter(r5, "state");
        String r2 = "";
        if (Intrinsics.areEqual(r5, es0.a.c.c) == false) goto L13;
        ILivePlayerClient r0 = this.f;
        if (r0 == null) goto L11;
        IRoomEventHub r1 = r0.getEventHub();
        if (r1 == null) goto L11;
        MutableLiveData r3 = r1.getPlayerMediaError();
        if (r3 == null) goto L11;
        r3.removeObserver(this.e);
    L11:
        this.g.setSwitchingSubCamera(false);
        this.g.setCurrentSubSteamKey("");
    L38:
        Logger.d("SubCameraStateHandler", "onState=" + r5);
        this.h.put("cmd_current_sub_camera_state", r5);
        this.a = r5;
        return;
    L13:
        if ((r5 instanceof es0.a.b) == false) goto L33;
        ILivePlayerClient r4 = this.f;
        if (r4 == null) goto L21;
        IRoomEventHub r6 = r4.getEventHub();
        if (r6 == null) goto L21;
        MutableLiveData r7 = r6.getPlayerMediaError();
        if (r7 == null) goto L21;
        r7.observe(this.f.getLifecycleOwner(), this.e);
    L21:
        ILivePlayerClient r8 = this.f;
        if (r8 == null) goto L28;
        IRoomEventHub r9 = r8.getEventHub();
        if (r9 == null) goto L28;
        MutableLiveData r10 = r9.getFirstFrame();
        if (r10 == null) goto L28;
        r10.observe(this.f.getLifecycleOwner(), this.d);
    L28:
        this.g.setSwitchingSubCamera(this.c);
        d r11 = this.g;
        if (this.c == false) goto L31;
        r2 = String.valueOf(this.b);
    L31:
        r11.setCurrentSubSteamKey(r2);
        goto L38
    L33:
        if ((r5 instanceof es0.a.d) == false) goto L36;
        this.g.setSwitchingSubCamera(true);
        this.g.setCurrentSubSteamKey(String.valueOf(this.b));
        goto L38
    L36:
        if ((r5 instanceof es0.a.C0206a) == false) goto L38;
        f2.c("当前内容展示异常，已自动切换", 0);
        goto L38
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.android.live.platformplayer.subcamera.SubCameraStateHandler$subStreamReadyObserver$1] */
    /* JADX WARN: Type inference failed for: r2v3, types: [com.bytedance.android.live.platformplayer.subcamera.SubCameraStateHandler$subStreamErrorObserver$1] */
    public SubCameraStateHandler(ILivePlayerClient r2, d r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r3, "roomSession");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        this.f = r2;
        this.g = r3;
        this.h = r4;
        this.a = es0.a.c.c;
        this.d = new SubCameraStateHandler$subStreamReadyObserver$1(this);
        this.e = new SubCameraStateHandler$subStreamErrorObserver$1(this);
    }
}
