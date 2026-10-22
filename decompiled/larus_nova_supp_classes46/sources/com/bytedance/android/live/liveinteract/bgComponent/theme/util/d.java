package com.bytedance.android.live.liveinteract.bgComponent.theme.util;

import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.utils.w;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.interact.model.d0;
import com.bytedance.android.livesdk.chatroom.viewmodel.f;
import com.bytedance.android.livesdk.chatroom.viewmodel.i;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.audio.GetLatestBGResponse;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.j;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ c a;

    public d(c r1) {
        this.a = r1;
    }

    public final void accept(Object r10) {
        IVoiceLiveTheme r11 = ((GetLatestBGResponse) ((Response) r10).data).latestOfficeTheme;
        c.a r0 = this.a.h;
        int r1 = 5;
        if (r0 == null) goto L5;
        int r2 = r0.getBgType();
    L7:
        if (r11 == null) goto L9;
        String r3 = r11.getImageUri();
    L10:
        boolean r4 = com.bytedance.android.live.liveinteract.theme.a.c(r2, r3);
        c r5 = this.a;
        r5.a = r4;
        DataCenter r6 = r5.b;
        if (r6 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("dataCenter");
    L13:
        LinkedHashMap r7 = new LinkedHashMap();
        r7.put("anchor_id", k.n(IMiddlewareUserService.class).user().n());
        r7.put("event_page", "live_take_detail");
        j r8 = m.d().s();
        if (r8 == null) goto L20;
        f r9 = (f) r8.getValue();
        if (r9 == null) goto L20;
        i r12 = r9.t();
        if (r12 == null) goto L20;
        Integer r13 = Integer.valueOf(r12.a);
    L21:
        IRoom r14 = (IRoom) r6.get("data_room", null);
        if (r14 == null) goto L44;
        r7.put("room_id", r14.getIdStr());
        if (r13 != null) goto L27;
    L34:
        if (r13 != null) goto L37;
    L39:
        if (r13 == null) goto L44;
        if (r13.intValue() != 0) goto L44;
        r7.put("function_type", "live");
        goto L44
    L37:
        if (r13.intValue() != 9) goto L39;
        r7.put("function_type", "ktv");
        goto L44
    L27:
        if (r13.intValue() != 5) goto L34;
        if (r14.getLinkInitResult() != null) goto L31;
        r7.put("function_type", "live");
        goto L44
    L31:
        r7.put("function_type", "radio");
        if (d0.h(r14) == false) goto L44;
        r7.put("function_type", "party");
    L44:
        c.a(r5, r7);
        r7.put("play_mode", w.a());
        if (r5.a == false) goto L47;
        String r15 = "1";
    L48:
        r7.put("if_dot", r15);
        String r16 = ((IInteractService) k.n(IInteractService.class)).getFunctionType2();
        if (r16 != null) goto L51;
        r16 = "";
    L51:
        r7.put("function_type2", r16);
        j0.l().sendLog("livesdk_anchor_theme_entrance_show", r7, new Object[]{IRoom.class});
        if (r11 == null) goto L64;
        if (r4 == false) goto L64;
        c r17 = this.a;
        r17.a = true;
        r17.f = r11;
        FrameLayout r18 = r17.c;
        if (r18 == null) goto L66;
        r18.removeAllViews();
        HSImageView r19 = new HSImageView(r18.getContext());
        r18.addView(r19, new FrameLayout.LayoutParams(-1, -1, 17));
        View r20 = r17.d;
        if (r20 == null) goto L60;
        UtilityKotlinExtentionsKt.z(r20, true);
    L60:
        ImageLoader.bindImage(r19, r11.getStaticBackground(), 2131253119);
        c.a r21 = r17.h;
        if (r21 == null) goto L63;
        r1 = r21.getBgType();
    L63:
        com.bytedance.android.live.liveinteract.theme.a.b(r1, r11.getImageUri(), 1.0d);
        return;
    L66:
        return;
    L64:
        this.a.a = false;
        return;
    L47:
        r15 = "0";
    L20:
        r13 = null;
        goto L21
    L9:
        r3 = null;
        goto L10
    L5:
        r2 = 5;
        goto L7
    }
}
