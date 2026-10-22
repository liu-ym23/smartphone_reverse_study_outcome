package com.bytedance.ies.bullet.forest;

import ai.j0;
import android.net.Uri;
import com.bytedance.env.api.AccessKeyType;
import com.bytedance.env.api.EnvManager;
import com.bytedance.env.api.EnvManagerApi;
import com.bytedance.forest.Forest;
import com.bytedance.forest.chain.fetchers.GeckoXAdapter;
import com.bytedance.forest.model.ForestEnvData;
import com.bytedance.forest.model.ForestEnvType;
import com.bytedance.forest.model.Scene;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f5405a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5406b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f5407c;
    public final com.bytedance.forest.model.t d;
    public final boolean e;
    public final String f;
    public final String g;

    public j(Uri r5, String r10, String r11, com.bytedance.forest.model.t r12, boolean r13, String r14, String r15) {
        Intrinsics.checkNotNullParameter(r5, "srcUri");
        Intrinsics.checkNotNullParameter(r10, "srcUrl");
        Intrinsics.checkNotNullParameter(r12, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r14, "bid");
        this.f5405a = r5;
        this.f5406b = r10;
        this.f5407c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
        this.g = r15;
    }

    public final String a(Forest r10) {
        Intrinsics.checkNotNullParameter(r10, "forest");
        com.bytedance.forest.model.t r5 = this.d;
        boolean r11 = this.e;
        String r12 = this.f5407c;
        List r13 = null;
        if (r11 == false) goto L8;
        if (r12 == null) goto L8;
        if (r10.isPreloaded(r12, r5) == false) goto L8;
    L23:
        if (StringsKt.P(r12, "http://") == false) goto L25;
    L28:
        String r14 = r12;
    L29:
        boolean r15 = true;
        if (r14 == null) goto L104;
        Intrinsics.checkNotNullParameter(r14, "<this>");
        if (StringsKt.P(r14, "http://") == true) goto L36;
        if (StringsKt.P(r14, "https://") == true) goto L36;
    L57:
        if (r14 == null) goto L104;
        r12 = r14;
    L36:
        if (com.bytedance.ies.bullet.kit.resourceloader.g.f5453c == false) goto L57;
        com.bytedance.env.api.e r16 = mn.h.b();     // Catch: Throwable -> L54
        if (r16 == null) goto L41;
        AccessKeyType r17 = r16.a();     // Catch: Throwable -> L54
    L43:
        if (r17 != null) goto L45;
        int r18 = -1;
    L46:
        if (r18 == (-1)) goto L55;
        if (r18 != 1) goto L49;
        ForestEnvType r19 = ForestEnvType.PPE;     // Catch: Throwable -> L54
        EnvManager.Companion.getClass();     // Catch: Throwable -> L54
        ForestEnvData r20 = new ForestEnvData(r19, ((EnvManagerApi) EnvManager.access$getApiImpl$cp().getValue()).getGeckoConfig().b());     // Catch: Throwable -> L54
    L56:
        Forest.Companion.injectEnv(r20);
        r14 = GeckoXAdapter.Companion.addCommonParamsForCDNMultiVersionURL(r14);
        goto L57
    L49:
        if (r18 != 2) goto L55;
        ForestEnvType r21 = ForestEnvType.BOE;     // Catch: Throwable -> L54
        EnvManager.Companion.getClass();     // Catch: Throwable -> L54
        r20 = new ForestEnvData(r21, ((EnvManagerApi) EnvManager.access$getApiImpl$cp().getValue()).getGeckoConfig().b());     // Catch: Throwable -> L54
    L55:
        r20 = null;
        goto L56
    L45:
        r18 = l.f5411a[r17.ordinal()];     // Catch: Throwable -> L54
        goto L46
    L41:
        r17 = null;
    L54:
        ConcurrentHashMap r22 = com.bytedance.ies.bullet.kit.resourceloader.g.f5451a;
    L104:
        Result.Companion r23 = Result.Companion;     // Catch: Throwable -> L62
        Object r24 = Result.m124constructorimpl(Uri.parse(r12));     // Catch: Throwable -> L62
    L65:
        if (Result.m130isFailureimpl(r24) == false) goto L67;
        r24 = null;
    L67:
        Uri r25 = (Uri) r24;
        if (r25 != null) goto L70;
        return r12;
    L70:
        Uri.Builder r26 = r25.buildUpon();
        String r27 = io.reactivex.exceptions.a.h(r25, "appended_global_props");
        Uri r28 = this.f5405a;
        if (r27 != null) goto L91;
        String r29 = io.reactivex.exceptions.a.h(r28, "append_global_props");
        if (r29 != null) goto L75;
    L80:
        if (r13 == null) goto L91;
        if (r13.isEmpty() == true) goto L91;
        if (com.bytedance.ies.bullet.secure.g.b(r25) == false) goto L91;
        ConcurrentHashMap r30 = o3.a.f20403a;
        String r31 = this.g;
        if (r31 != null) goto L89;
        r31 = "";
    L89:
        r26.appendQueryParameter("appended_global_props", new JSONObject(o3.a.d(r25, this.f, r31, r13)).toString());
        goto L91
    L75:
        if (r29.length() > 0) goto L78;
        r29 = null;
    L78:
        if (r29 == null) goto L80;
        r13 = StringsKt.K(r29, new String[]{","}, 0, 6);
    L91:
        if (Intrinsics.areEqual(io.reactivex.exceptions.a.h(r25, "append_common_params"), "0") == false) goto L93;
    L99:
        r15 = false;
    L100:
        String r32 = r26.build().toString();
        if (r15 == false) goto L107;
        StringBuilder r33 = new StringBuilder(r26.build().toString());
        com.bytedance.ies.bullet.secure.g.a(r25, r33);
        return r33.toString();
    L107:
        return r32;
    L93:
        if (Intrinsics.areEqual(io.reactivex.exceptions.a.h(r28, "append_common_params"), IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST) == false) goto L99;
        String r34 = io.reactivex.exceptions.a.h(r25, "_rticket");
        if (r34 == null) goto L100;
        if (r34.length() != 0) goto L99;
    L62:
        th = move-exception;
        Result.Companion r35 = Result.Companion;
        r24 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L65
    L25:
        if (StringsKt.P(r12, "https://") == true) goto L28;
        r14 = null;
    L8:
        Scene r36 = r5.H;
        Scene r37 = Scene.f4351k;
        String r38 = this.f5406b;
        if (r36 == r37) goto L11;
    L15:
        if (r12 != null) goto L17;
    L14:
        r12 = r38;
        goto L23
    L17:
        if (com.lynx.tasm.behavior.utils.d.g(r12) == true) goto L20;
        r12 = null;
    L20:
        if (r12 != null) goto L23;
    L11:
        if (StringsKt.P(r38, "http://") == true) goto L14;
        if (StringsKt.P(r38, "https://") == false) goto L15;
        goto L14
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof j) == true) goto L8;
        return false;
    L8:
        j r10 = (j) r5;
        Uri r11 = r10.f5405a;
        if (Intrinsics.areEqual(this.f5405a, r11) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f5406b, r10.f5406b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f5407c, r10.f5407c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r10.e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r10.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r10.g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r5 = kk.a.b(this.f5406b, this.f5405a.hashCode() * 31, 31);
        int r10 = 0;
        String r11 = this.f5407c;
        if (r11 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = kk.a.b(this.f, kn.e.a((this.d.hashCode() + ((r5 + r12) * 31)) * 31, 31, this.e), 31);
        String r14 = this.g;
        if (r14 == null) goto L11;
        r10 = r14.hashCode();
    L11:
        return r13 + r10;
    L5:
        r12 = r11.hashCode();
        goto L6
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("ForestRequestInfo(srcUri=");
        r5.append(this.f5405a);
        r5.append(", srcUrl=");
        r5.append(this.f5406b);
        r5.append(", cdnUrl=");
        r5.append(this.f5407c);
        r5.append(", params=");
        r5.append(this.d);
        r5.append(", isMainResource=");
        r5.append(this.e);
        r5.append(", bid=");
        r5.append(this.f);
        r5.append(", containerId=");
        return j0.p(r5, this.g, ')');
    }
}
