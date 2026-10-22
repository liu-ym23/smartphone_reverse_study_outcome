package com.bytedance.ies.bullet.kit.web.jsbridge;

import android.app.Application;
import com.bytedance.forest.chain.fetchers.CDNFetcher;
import com.bytedance.ies.bullet.kit.resourceloader.g;
import com.bytedance.ies.bullet.service.base.bridge.IBridgeMethod$Access;
import com.bytedance.sdk.xbridge.cn.protocol.i;
import com.lynx.jsbridge.LynxResourceModule;
import java.io.File;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends com.bytedance.ies.bullet.core.kit.bridge.b implements i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IBridgeMethod$Access f5543b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f5544c;

    public a(rb.b r5) {
        Intrinsics.checkNotNullParameter(r5, "providerFactory");
        super(r5);
        this.f5543b = IBridgeMethod$Access.f5959a;
        this.f5544c = "bullet.cancelDownloadWeb";
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.b
    public final void a(JSONObject r12, sc.a r13) {
        Intrinsics.checkNotNullParameter(r12, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r13, "callback");
        Application r5 = g.f5452b;
        if (r5 != null) goto L5;
        Unit r11 = null;
    L27:
        if (r11 != null) goto L35;
        JSONObject r14 = new JSONObject();
        r14.put("code", 0);
        r13.a(r14);
        return;
    L35:
        return;
    L5:
        if (new File(r5.getCacheDir(), CDNFetcher.DIR_NAME).exists() == true) goto L8;
        JSONObject r15 = new JSONObject();
        r15.put("code", 0);
        r13.a(r15);
        return;
    L8:
        JSONArray r16 = r12.optJSONArray("urls");
        if (r16 != null) goto L11;
    L24:
        JSONObject r17 = new JSONObject();
        r17.put("code", 0);
        r13.a(r17);
        return;
    L11:
        if (r16.length() == 0) goto L24;
        int r10 = r16.length();
        int r18 = 0;
    L14:
        if (r18 >= r10) goto L23;
        String r19 = r16.getString(r18);
        boolean r20 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.a(2, f4.b.b(new StringBuilder(), this.f5544c, " start cancel ", r19), "XPreload");
        com.bytedance.ies.bullet.kit.web.download.b r21 = (com.bytedance.ies.bullet.kit.web.download.b) com.bytedance.ies.bullet.kit.web.download.b.d.getValue();
        r21.getClass();
        Intrinsics.checkNotNullParameter(r19, "url");
        File r22 = r21.f5498b;
        if (r22 == null) goto L22;
        String r23 = com.bytedance.ies.bullet.kit.web.download.b.a(r19);
        if (r23 == null) goto L22;
        File r110 = new File(r22, r23);
        if (r110.exists() == false) goto L22;
        com.bytedance.ies.bullet.service.base.b.a(2, "WebResourceDownloader: delete cache of url=" + r19 + " from destination=" + r110, "XPreload");
        r110.delete();
    L22:
        r18 = r18 + 1;
        goto L14
    L23:
        JSONObject r111 = new JSONObject();
        r111.put("code", 1);
        r13.a(r111);
        r11 = Unit.INSTANCE;
        goto L27
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.b
    public final IBridgeMethod$Access f() {
        return this.f5543b;
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.b
    public final String g() {
        return this.f5544c;
    }
}
