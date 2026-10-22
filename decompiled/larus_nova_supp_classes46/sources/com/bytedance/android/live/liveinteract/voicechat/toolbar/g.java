package com.bytedance.android.live.liveinteract.voicechat.toolbar;

import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.u0;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.audio.GetLatestBGResponse;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ f a;

    public g(f r1) {
        this.a = r1;
    }

    public final void accept(Object r9) {
        IVoiceLiveTheme r10 = ((GetLatestBGResponse) ((Response) r9).data).latestOfficeTheme;
        this.a.getClass();
        if (r10 == null) goto L5;
        String r1 = r10.getImageUri();
    L6:
        boolean r2 = com.bytedance.android.live.liveinteract.theme.a.c(3, r1);
        f r3 = this.a;
        r3.f = r2;
        LinkedHashMap r4 = new LinkedHashMap();
        r4.put("anchor_id", k.n(IMiddlewareUserService.class).user().n().toString());
        r4.put("event_page", "live_take_detail");
        TalkRoomLogUtils.B0(r4, null, null, 6);
        TalkRoomLogUtils.J0(r4);
        r4.put("play_mode", u0.b());
        if (r3.f == false) goto L9;
        String r0 = "1";
    L10:
        r4.put("if_dot", r0);
        r4.put("function_type2", TalkRoomLogUtils.h);
        j0.l().sendLog("livesdk_anchor_theme_entrance_show", r4, new Object[]{IRoom.class});
        if (r10 == null) goto L21;
        if (r2 == false) goto L23;
        f r5 = this.a;
        r5.e = r10;
        FrameLayout r6 = r5.b;
        if (r6 == null) goto L22;
        r6.removeAllViews();
        HSImageView r7 = new HSImageView(r6.getContext());
        r6.addView(r7, new FrameLayout.LayoutParams(-1, -1, 17));
        View r8 = this.a.c;
        if (r8 == null) goto L19;
        UtilityKotlinExtentionsKt.z(r8, true);
    L19:
        ImageLoader.bindImage(r7, r10.getStaticBackground(), 2131253119);
        this.a.getClass();
        com.bytedance.android.live.liveinteract.theme.a.b(3, r10.getImageUri(), 1.0d);
        return;
    L22:
        return;
    L23:
        return;
    L21:
        return;
    L9:
        r0 = "0";
        goto L10
    L5:
        r1 = null;
        goto L6
    }
}
