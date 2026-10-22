package com.bytedance.ies.bullet.kit.web.jsbridge;

import android.net.Uri;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import com.bytedance.ies.bullet.core.e;
import com.bytedance.ies.bullet.service.base.bridge.IBridgeMethod$Access;
import com.bytedance.sdk.xbridge.cn.protocol.i;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.lynx.jsbridge.LynxResourceModule;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.io.File;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends com.bytedance.ies.bullet.core.kit.bridge.b implements i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f5545b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f5546c;
    public final String d;

    public b(rb.b r5, int r10) {
        this.f5545b = r10;
        switch(r10) {
            case 1: goto L8;
            case 2: goto L6;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r5, "providerFactory");
        super(r5);
        this.f5546c = IBridgeMethod$Access.f5959a;
        this.d = "bullet.downloadWebContent";
        return;
    L6:
        Intrinsics.checkNotNullParameter(r5, "providerFactory");
        super(r5);
        this.f5546c = r5;
        this.d = "getBridgeList";
        return;
    L8:
        Intrinsics.checkNotNullParameter(r5, "providerFactory");
        super(r5);
        this.f5546c = IBridgeMethod$Access.f5959a;
        this.d = "bullet.stopRecord";
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.b
    public final void a(JSONObject r17, sc.a r18) {
        int r10 = this.f5545b;
        Intrinsics.checkNotNullParameter(r17, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r18, "callback");
        switch(r10) {
            case 0: goto L28;
            case 1: goto L21;
            default: goto L4;
        };
    L4:
        e r5 = (e) ((rb.b) this.f5546c).a(e.class);
        if (r5 == null) goto L17;
        JSONArray r11 = new JSONArray();
        com.bytedance.ies.bullet.core.kit.bridge.d r12 = r5.f5301o;
        if (r12 == null) goto L16;
        LinkedHashMap r13 = r12.f();
        if (r13 == null) goto L16;
        Set r14 = r13.entrySet();
        if (r14 == null) goto L16;
        Iterator r15 = r14.iterator();
    L14:
        if (r15.hasNext() == false) goto L16;
        Map.Entry r16 = (Map.Entry) r15.next();
        JSONObject r19 = new JSONObject();
        r19.put("name", r16.getKey());
        r19.put("impl", r16.getValue().getClass().getName());
        r11.put(r19);
    L16:
        JSONObject r20 = new JSONObject();
        r20.put("list", r11);
        r18.a(r20);
        Unit r21 = Unit.INSTANCE;
    L18:
        if (r21 != null) goto L64;
        r18.onError(0, "bullet context empty");
        return;
    L64:
        return;
    L17:
        r21 = null;
        goto L18
    L21:
        String r22 = r17.optString(STGroup.DICT_KEY);
        if (r22 != null) goto L24;
        return;
    L24:
        if (dd.c.d(r22, false) == false) goto L26;
        JSONObject r23 = new JSONObject();
        r23.put("code", 1);
        r18.a(r23);
        return;
    L26:
        JSONObject r24 = new JSONObject();
        r24.put("code", 0);
        r18.a(r24);
        return;
    L28:
        JSONArray r25 = r17.optJSONArray("urls");
        if (r25 != null) goto L31;
    L55:
        JSONObject r26 = new JSONObject();
        r26.put("code", 0);
        r18.a(r26);
        return;
    L31:
        if (r25.length() == 0) goto L55;
        int r27 = r25.length();
        int r28 = 0;
    L34:
        if (r28 >= r27) goto L54;
        String r29 = r25.getString(r28);
        boolean r110 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.a(2, f4.b.b(new StringBuilder(), this.d, " start download ", r29), "XPreload");
        com.bytedance.ies.bullet.kit.web.download.b r111 = (com.bytedance.ies.bullet.kit.web.download.b) com.bytedance.ies.bullet.kit.web.download.b.d.getValue();
        r111.getClass();
        Intrinsics.checkNotNullParameter(r29, "url");
        File r112 = r111.f5498b;
        if (r112 == null) goto L53;
        String r113 = com.bytedance.ies.bullet.kit.web.download.b.a(r29);
        if (r113 == null) goto L53;
        File r114 = new File(r112, r113);
        if (r114.exists() == false) goto L42;
        r114.delete();
    L42:
        com.bytedance.ies.bullet.kit.web.download.a r115 = new com.bytedance.ies.bullet.kit.web.download.a(r111, r29);
        boolean r116 = Intrinsics.areEqual(Uri.parse(r29).getQueryParameter("cdn_negotiate"), IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST);
        boolean r30 = Intrinsics.areEqual(Uri.parse(r29).getQueryParameter("need_common_params"), IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST);
        Downloader.b(r111.f5497a);
        DownloadTask r31 = new DownloadTask();
        DownloadInfo.Builder r117 = r31.f15884k;
        r117.f15853c = r29;
        r117.f15851a = r113;
        String r32 = r112.getPath();
        DownloadInfo.Builder r118 = r31.f15884k;
        r118.d = r32;
        r118.f15869x = true;
        r118.F = r30;
        r118.D = true;
        r118.f15856j = 0;
        r31.f15895w = true;
        r118.E = AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH;
        r118.B = true;
        r118.C = r116;
        DownloadTask r33 = r31.a(r115.hashCode(), r115);
        r33.f15884k.f15871z = "XWeb";
        Result.Companion r34 = Result.Companion;     // Catch: Throwable -> L46
        Method r35 = com.bytedance.ies.bullet.kit.web.download.b.f5496c;     // Catch: Throwable -> L46
        if (r35 == null) goto L48;
        Object r36 = r35.invoke(r33, new Object[]{1209600L});     // Catch: Throwable -> L46
    L49:
        Result.m124constructorimpl(r36);     // Catch: Throwable -> L46
    L52:
        r33.b();
        goto L53
    L48:
        r36 = null;
    L46:
        th = move-exception;
        Result.Companion r37 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
    L53:
        r28 = r28 + 1;
        goto L34
    L54:
        JSONObject r38 = new JSONObject();
        r38.put("code", 1);
        r18.a(r38);
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.b
    public boolean b() {
        switch(this.f5545b) {
            case 0: goto L6;
            default: goto L5;
        };
    L6:
        return true;
    L5:
        return super.b();
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.b
    public IBridgeMethod$Access f() {
        switch(this.f5545b) {
            case 0: goto L9;
            case 1: goto L7;
            default: goto L5;
        };
    L5:
        return super.f();
    L7:
        return (IBridgeMethod$Access) this.f5546c;
    L9:
        return (IBridgeMethod$Access) this.f5546c;
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.b
    public final String g() {
        switch(this.f5545b) {
            case 0: goto L9;
            case 1: goto L7;
            default: goto L5;
        };
    L5:
        return this.d;
    L7:
        return this.d;
    L9:
        return this.d;
    }
}
