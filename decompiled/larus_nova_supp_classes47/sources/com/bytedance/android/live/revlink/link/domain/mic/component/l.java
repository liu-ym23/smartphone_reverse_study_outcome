package com.bytedance.android.live.revlink.link.domain.mic.component;

import com.bytedance.android.live.revlink.impl.plantform.AnchorLinkUserCenterV2;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class l implements f, s51.a {
    public final CompositeDisposable a;
    public final NextLiveData<Boolean> b;
    public final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d c;
    public final String d;
    public final String e;
    public final AnchorLinkUserCenterV2 f;
    public final com.bytedance.android.live.revenuelink.rtc.i g;

    @Override // s51.a
    public final void attach() {
    }

    @Override // com.bytedance.android.live.revlink.link.domain.mic.component.f
    public final NextLiveData<Boolean> b() {
        throw null;
    }

    @Override // s51.a
    public final void detach() {
        this.a.clear();
    }

    public final void g(String r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "linkMicId");
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r0 = this.c.Ig();
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == true) goto L10;
        return;
    L10:
        JSONObject r2 = new JSONObject();
        JSONObject r3 = new JSONObject();
        r3.put("rtc_uid", r5);
        r3.put("use_audio", !r6);
        r2.put("action", "update_audio");
        r2.put(Constants.Keys.DATA, r3);
        com.bytedance.android.live.revenuelink.rtc.i r7 = this.g;
        if (r7 == null) goto L14;
        r7.A("director_view_stream_x_" + this.c.Ab(), r2.toString());
        return;
    L14:
        return;
    L5:
        if (r0.getCloudCollaboratePanelType() != IBattleConfigSetting.BattleCloudCollaboratePanelType.BattleCloudCollaboratePanelType_ThroneFight.ordinal()) goto L7;
        r1 = true;
        goto L8
    }

    public l(com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d r2, String r3, String r4, AnchorLinkUserCenterV2 r5, com.bytedance.android.live.revenuelink.rtc.i r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r5, "userCenter");
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = r5;
        this.g = r6;
        this.a = new CompositeDisposable();
        NextLiveData<Boolean> r7 = new NextLiveData();
        r7.setValue(Boolean.FALSE);
        Unit r8 = Unit.INSTANCE;
        this.b = r7;
    }
}
