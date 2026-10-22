package com.bytedance.android.live.liveinteract.voicechat.subtitle;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.browser.IBaseBrowserService;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedSubtitleMode;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g0 {
    public static final /* synthetic */ int a = 0;

    public static final class a extends b7.a {
        public a() {
        }
    }

    static {
    }

    public static boolean a(IRoom r4) {
        int r0 = c(r4);
        if (r0 != 1) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
    L15:
        return true;
    L11:
        if (c(r4) != 3) goto L13;
        boolean r5 = true;
    L14:
        if (r5 == true) goto L15;
        return false;
    L13:
        r5 = false;
        goto L14
    L5:
        if (r0 == 2) goto L8;
        r1 = false;
        goto L9
    }

    public static boolean b(IRoom r3) {
        if (vm2.c.b().getGuestCanAdjustPublicScreen() == 0) goto L9;
        if (vm2.c.b().getGuestCanAdjustPublicScreen() != 2) goto L12;
        return true;
    L12:
        return false;
    L9:
        if (c(r3) == 0) goto L13;
        return true;
    L13:
        return false;
    }

    public static int c(IRoom r2) {
        if (r2 != null) goto L12;
        com.bytedance.live.datacontext.m r3 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r3 == null) goto L18;
        IRoom r4 = (IRoom) r3.getValue();
        if (r4 == null) goto L19;
        String r5 = r4.getAnchorAbValue("audio_room_subtitle_opt");
        if (r5 != null) goto L11;
        return 0;
    L11:
        return CastIntegerProtector.parseInt(r5);
    L19:
        return 0;
    L18:
        return 0;
    L12:
        Map r6 = r2.getAnchorABMap();
        if (r6 == null) goto L21;
        String r7 = (String) r6.get("audio_room_subtitle_opt");
        if (r7 != null) goto L17;
        return 0;
    L17:
        return CastIntegerProtector.parseInt(r7);
    L21:
        return 0;
    }

    public static boolean d(String r4) {
        Intrinsics.checkNotNullParameter(r4, "json");
        if (StringsKt.contains$default(r4, "audio_subtitle", false, 2, null) == true) goto L5;
        return false;
    L5:
        if (StringsKt.contains$default(r4, "subtitles", false, 2, null) == true) goto L7;
        return false;
    L7:
        if (StringsKt.contains$default(r4, "user_id", false, 2, null) == true) goto L9;
        return false;
    L9:
        if (StringsKt.contains$default(r4, "text", false, 2, null) == true) goto L11;
        return false;
    L11:
        if (StringsKt.contains$default(r4, "definite", false, 2, null) == true) goto L13;
        return false;
    L13:
        if (StringsKt.contains$default(r4, "sequence", false, 2, null) == false) goto L21;
        return true;
    L21:
        return false;
    }

    public static void g(List r1) {
        Intrinsics.checkNotNullParameter(r1, "subtitleItemList");
        Iterator r2 = r1.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        String r0 = ((nj0.g) r2.next()).b;
        goto L4
    }

    public static List e(String r7, List r8) {
        Intrinsics.checkNotNullParameter(r7, "json");
        List r9 = GsonHelper.fromJsonArray(r7, nj0.h.class);
        ArrayList r0 = new ArrayList();
        ArrayList r1 = new ArrayList();
        Iterator r10 = r9.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        nj0.h r2 = (nj0.h) r10.next();
        String r4 = r2.d();
        String r5 = r2.c();
        LiveWrappedSubtitleMode r6 = LiveWrappedSubtitleMode.SUBTITLE_MODE_RECOGINTE;
        r0.add(new dg2.j(r4, r5, r2.b(), r2.a()));
        goto L4
    L6:
        Iterator r11 = r0.iterator();
    L8:
        if (r11.hasNext() == false) goto L23;
        nj0.g r3 = h((dg2.j) r11.next(), r8);
        int r12 = com.bytedance.android.live.liveinteract.voicechat.radio.e.a;
        if (com.bytedance.android.live.liveinteract.voicechat.radio.e.d(gh0.a.d()) == false) goto L22;
        if (je0.d.f() != 0) goto L22;
        if (r3.a != null) goto L22;
        com.bytedance.live.datacontext.m r13 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r13 == null) goto L20;
        IRoom r14 = (IRoom) r13.getValue();
        if (r14 == null) goto L20;
        IBaseUser r15 = r14.getOwner();
    L21:
        r3.a = r15;
    L20:
        r15 = null;
    L22:
        r1.add(r3);
        goto L8
    L23:
        return r1;
    }

    public static HybridCard f(Context r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        StringBuilder r0 = new StringBuilder();
        String r1 = vm2.c.b().getSubtitlePatchUrl();
        if (r1.length() != 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L8;
        r1 = "https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/lynx/audiochat_stage_douyin/pages/subtitle_patch/template.js?business_group=-1";
    L8:
        r0.append(r1);
        r0.append("&width=");
        r0.append(r4);
        r0.append("&height=");
        r0.append(LinkmicSubtitleUIWidget.u);
        Uri r5 = x6.a.d(r0.toString());
        if (vm2.c.b().getSubtitleEnableEffect() == false) goto L11;
        r5 = UriProtector.parse(r5.toString()).buildUpon().appendQueryParameter("enable_canvas", "1").build();
    L11:
        HybridCard r6 = jc1.k.n(IBaseBrowserService.class).getHybridCard(r3, r5, new a());
        if (r6 == null) goto L14;
        a7.a.a(r6, null, null, 3);
    L14:
        return r6;
    L5:
        r2 = false;
        goto L6
    }

    public static nj0.g h(dg2.j r4, List r5) {
        Intrinsics.checkNotNullParameter(r4, "subtitleMessage");
        nj0.g r1 = new nj0.g();
        Intrinsics.checkNotNullParameter(r4, "subtitleMessage");
        String r0 = r4.a;
        String r2 = "";
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        r1.b = r0;
        String r3 = r4.b;
        if (r3 == null) goto L9;
        r2 = r3;
    L9:
        r1.c = r2;
        r1.d = r4.c;
        r1.e = r4.d;
        if (r5 == null) goto L21;
        Iterator r6 = r5.iterator();
    L13:
        if (r6.hasNext() == false) goto L17;
        Object r7 = r6.next();
        if (Intrinsics.areEqual(((ILinkPlayerInfoBridge) r7).getInteractId(), r4.a) == false) goto L13;
    L18:
        ILinkPlayerInfoBridge r8 = (ILinkPlayerInfoBridge) r7;
        if (r8 == null) goto L21;
        r1.a = r8.getUser();
        goto L21
    L17:
        r7 = null;
    L21:
        return r1;
    }
}
