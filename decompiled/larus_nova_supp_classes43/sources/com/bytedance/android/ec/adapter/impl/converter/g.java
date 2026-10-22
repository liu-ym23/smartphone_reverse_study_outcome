package com.bytedance.android.ec.adapter.impl.converter;

import android.util.Base64;
import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import com.bytedance.android.livesdkapi.message.IExternalMessageInject;
import com.bytedance.android.livesdkapi.room.controller.ILiveRoomController;
import com.bytedance.android.livesdkapi.room.controller.ISaasLiveRoomControllerProvider;
import com.bytedance.android.livesdkapi.room.controller.IStartLivePreviewController;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Random;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g implements ISaasLiveRoomControllerProvider {
    public final /* synthetic */ rd.b a;

    public final String businessType() {
        return this.a.businessType();
    }

    public final IStartLivePreviewController getStartLivePreviewController() {
        rd.c r0 = this.a.getStartLivePreviewController();
        Intrinsics.checkNotNullParameter(r0, "$this$convert2Live");
        return c.h.b.a(r0);
    }

    public final String getInjectionLicense() {
        long r0 = System.currentTimeMillis();
        int r10 = new Random(r0).nextInt(99999);
        String r11 = r0 + "::" + r10 + "::" + (r0 % ((long) 256));
        MessageDigest r12 = MessageDigest.getInstance("MD5");
        Charset r13 = Charsets.UTF_8;
        if (r11 == null) goto L7;
        return r0 + "::" + r10 + "::" + Base64.encodeToString(r12.digest(r11.getBytes(r13)), 0);
    L7:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public g(rd.b r1) {
        this.a = r1;
    }

    public final void onMessageInjectionAllow(IExternalMessageInject r10) {
        Intrinsics.checkNotNullParameter(r10, "injectionStub");
        HashMap r0 = new HashMap();
        r0.put("WebcastLiveShoppingMessage", ve.a.class);
        r0.put("WebcastLiveEcomGeneralMessage", com.bytedance.android.ec.adapter.impl.messagev2.a.class);
        r10.injectAllMessageClz(r0);
        r10.injectMessageDecoder(jd.a.a);
    }

    public final ILiveRoomController getController(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, BdpAwemeConstant.KEY_ROOM_ID);
        Intrinsics.checkNotNullParameter(r11, "uniqueKey");
        rd.a r12 = this.a.a(r10, "", "DEFAULT");
        Intrinsics.checkNotNullParameter(r12, "$this$convert2Live");
        return c.b.b.a(r12);
    }

    public final void onInjectFinished(boolean r1, String r10) {
        ISaasLiveRoomControllerProvider.DefaultImpls.onInjectFinished(this, r1, r10);
    }

    public final void substituteClearLiveRoomController(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, BdpAwemeConstant.KEY_ROOM_ID);
        Intrinsics.checkNotNullParameter(r11, "uniqueKey");
        this.a.substituteClearLiveRoomController(r10, r11);
    }
}
