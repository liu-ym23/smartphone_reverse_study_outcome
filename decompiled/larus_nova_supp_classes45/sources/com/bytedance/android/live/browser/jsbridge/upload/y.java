package com.bytedance.android.live.browser.jsbridge.upload;

import androidx.fragment.app.Fragment;
import com.bytedance.android.live.browser.jsbridge.base.GetVipPanelCustomBackgroundResultModel;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.live.room.ILiveSDKService;
import com.bytedance.android.livesdk.config.mg0;
import com.bytedance.android.livesdk.utils.k2;
import com.bytedance.android.livesdk.utils.o5;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IThemeShowArea;
import com.bytedance.android.livesdkapi.depend.model.live.audio.ThemeUpLoadListener;
import com.bytedance.ies.web.jsbridge2.CallContext;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import w20.t9;
import w20.w1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class y extends w1<t9, GetVipPanelCustomBackgroundResultModel> implements com.bytedance.android.live.room.g.b {
    public com.bytedance.android.live.room.g a;
    public final Integer b;
    public final Fragment c;

    public final void b(String r1, String r2, IThemeShowArea r3, ThemeUpLoadListener r4, int r5) {
        Intrinsics.checkNotNullParameter(r1, "filePath");
        Intrinsics.checkNotNullParameter(r2, "originDate");
    }

    public final /* synthetic */ void c() {
    }

    public final /* synthetic */ void g(String r1, int r2) {
    }

    public final /* synthetic */ void h() {
    }

    public final void onCanceled() {
        GetVipPanelCustomBackgroundResultModel r0 = new GetVipPanelCustomBackgroundResultModel();
        r0.a(GetVipPanelCustomBackgroundResultModel.Code.Success);
        r0.b(new GetVipPanelCustomBackgroundResultModel.a());
        r0.c("On pick canceled.");
        Unit r1 = Unit.INSTANCE;
        finishWithResult(r0);
    }

    public y(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.c = r2;
        this.b = (Integer) mg0.a.getValue();
    }

    public final void onError(String r3) {
        Intrinsics.checkNotNullParameter(r3, "errorMsg");
        GetVipPanelCustomBackgroundResultModel r0 = new GetVipPanelCustomBackgroundResultModel();
        r0.a(GetVipPanelCustomBackgroundResultModel.Code.Success);
        r0.b(new GetVipPanelCustomBackgroundResultModel.a());
        r0.c(r3);
        Unit r4 = Unit.INSTANCE;
        finishWithResult(r0);
    }

    public final void invoke(Object r13, CallContext r14) {
        t9 r15 = (t9) r13;
        Intrinsics.checkNotNullParameter(r15, "params");
        Intrinsics.checkNotNullParameter(r14, "context");
        k2 r16 = jc1.k.n(ILiveSDKService.class).createImagePicker(null, this.c, "upload_custom_vip_panel", null, this.b.intValue(), this.b.intValue(), this.b.intValue(), this.b.intValue(), this, null, null);
        this.a = r16;
        if (r16 == null) goto L13;
        String r0 = r15.b();
        String r1 = "";
        if (r0 != null) goto L7;
        r0 = "";
    L7:
        String r17 = r15.a();
        if (r17 == null) goto L11;
        r1 = r17;
    L11:
        k2 r18 = r16;
        r18.f = String.valueOf(System.currentTimeMillis());
        r18.t = r0;
        r18.u = r1;
        com.bytedance.android.live.core.utils.q.l(r18.a, r18.c, 40010, k2.B, null);
        int r19 = o5.a;
        Intrinsics.checkNotNullParameter(r0, "requestPage");
        Intrinsics.checkNotNullParameter(r1, "coverStatus");
        Map r110 = MapsKt.mapOf(new Pair[]{TuplesKt.to("request_page", r0), TuplesKt.to("cover_status", r1)});
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_livevip_cover_set_page_upload_album_show", r110, new Object[]{Room.class});
        return;
    }

    public final void e(String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "portrait");
        Intrinsics.checkNotNullParameter(r4, KtvSubElement.BACKGROUND);
        Intrinsics.checkNotNullParameter(r5, "message");
        GetVipPanelCustomBackgroundResultModel r0 = new GetVipPanelCustomBackgroundResultModel();
        r0.a(GetVipPanelCustomBackgroundResultModel.Code.Success);
        GetVipPanelCustomBackgroundResultModel.a r1 = new GetVipPanelCustomBackgroundResultModel.a();
        r1.b(r3);
        r1.a(r4);
        Unit r6 = Unit.INSTANCE;
        r0.b(r1);
        r0.c(r5);
        finishWithResult(r0);
    }
}
