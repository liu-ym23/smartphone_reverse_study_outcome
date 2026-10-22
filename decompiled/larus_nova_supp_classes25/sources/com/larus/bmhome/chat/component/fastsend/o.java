package com.larus.bmhome.chat.component.fastsend;

import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.multimodal.MultimodalBizScene;
import com.larus.bmhome.chat.component.bottom.multimodal.e1;
import com.larus.bmhome.chat.component.bottom.multimodal.f1;
import com.larus.bmhome.chat.component.bottom.multimodal.g;
import com.larus.bmhome.chat.component.bottom.multimodal.g1;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.platform.api.g3;
import com.larus.platform.service.k2;
import com.larus.utils.logger.FLogger;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import org.json.JSONException;
import org.json.JSONObject;
import v19.e6;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class o implements Function0 {
    public final /* synthetic */ String a;
    public final /* synthetic */ FastSendImageComponent b;

    public /* synthetic */ o(String r1, FastSendImageComponent r2) {
        this.a = r1;
        this.b = r2;
    }

    /* JADX WARN: Type inference failed for: r0v17, types: [com.larus.bmhome.chat.component.fastsend.r] */
    public final Object invoke() {
        String r0 = this.a;
        final FastSendImageComponent r1 = this.b;
        KProperty[] r2 = FastSendImageComponent.M;
        if (Intrinsics.areEqual(r0, "no_permission") == false) goto L32;
        y r3 = r1.u0();
        String r4 = null;
        if (r3 == null) goto L7;
        String r5 = r3.getBotId();
    L8:
        y r7 = r1.u0();
        if (r7 == null) goto L13;
        e r8 = r7.h();
        if (r8 == null) goto L13;
        r4 = ic8.n.f(r8);
    L13:
        JSONObject r9 = new JSONObject();
        Intrinsics.checkNotNullParameter(r9, "params");
        if (r5 != null) goto L43;
    L18:
        if (r4 == null) goto L20;
        r9.put("chat_type", r4);     // Catch: JSONException -> L16
    L20:
        r9.put("click_from", "chat_plus_guide");     // Catch: JSONException -> L16
        r9.put("previous_page", "chat");     // Catch: JSONException -> L16
        r9.put("current_page", "album");     // Catch: JSONException -> L16
    L23:
        TrackParams r6 = new TrackParams().merge(r9);
        by7.a r10 = new by7.a("click_album_authorize");
        r10.a.merge(r6);
        r10.b();
        final ?? r11 = new r(r1);
        e6.a.getClass();
        String r12 = e6.a();
        if (Intrinsics.areEqual(r12, "request_authorization") == false) goto L27;
        k2 r13 = k2.a;
        Intrinsics.checkNotNullParameter(r1, "<this>");
        g3.a.a(com.larus.ui.arch.component.internal.attach.a.b(r1, r1), null, false, null, false, new s(r11, r1), 30);
    L29:
        boolean r14 = false;
    L37:
        if (r14 == false) goto L42;
        ICoreInputAbility r15 = r1.P2();
        if (r15 == null) goto L42;
        r15.C1(false, true, "");
    L42:
        return Unit.INSTANCE;
    L27:
        if (Intrinsics.areEqual(r12, "open") == false) goto L30;
        r1.h3("guidePermissionAlreadyGranted");
        goto L29
    L30:
        k2.a.s(s1a.a.getActivity(r1), new t(r11));
    L36:
        r14 = true;
    L16:
        e = move-exception;
        FLogger.a.e("FastSendEventHelper", "error in FastSendEventHelper mobClickAlbumAuthorize " + e.getLocalizedMessage());
        goto L23
    L43:
        r9.put("bot_id", r5);     // Catch: JSONException -> L16
        goto L18
    L7:
        r5 = null;
        goto L8
    L32:
        if (Intrinsics.areEqual(r0, "no_image") == false) goto L36;
        g r16 = (g) r1.j.getValue();
        if (r16 == null) goto L36;
        f1.b r17 = f1.b.a;
        g1 r18 = new g1(true, MultimodalBizScene.ChatInputFastAlbumGuideCamera, false);
        LinkedHashMap r19 = new LinkedHashMap();
        r19.put("click_from", "chat_plus_guide");
        Unit r20 = Unit.INSTANCE;
        r16.n90(new e1(r17, r18, null, r19, 4));
        goto L36
    }
}
