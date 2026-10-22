package com.larus.slides.impl;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.im.bean.InAppBannerScene;
import com.larus.nova.NovaApplication;
import com.larus.reach.api.ReachClickTarget;
import com.larus.reach.api.ReachSceneInterceptor;
import com.larus.slides.api.ISlidesService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u000e\u0010\u000f\u001a\u0004\u0018\u00010\u0005*\u00020\u000eH\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/larus/slides/impl/AiPptReachSceneInterceptor;", "Lcom/larus/reach/api/ReachSceneInterceptor;", "<init>", "()V", "pushScene", "", "getPushScene", "()Ljava/lang/String;", "canShow", "", "request", "Lcom/larus/reach/api/ReachRequest;", "handleClickAction", "click", "Lcom/larus/reach/api/ReachClickEvent;", "firstSchema", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class AiPptReachSceneInterceptor implements ReachSceneInterceptor {
    public final String a;

    public static final class a {
    }

    static {
    }

    public AiPptReachSceneInterceptor() {
        this.a = InAppBannerScene.AI_PPT.getScene();
    }

    @Override // com.larus.reach.api.ReachSceneInterceptor
    public final String a() {
        return this.a;
    }

    @Override // com.larus.reach.api.ReachSceneInterceptor
    public final boolean f(ns9.t r6) {
        Intrinsics.checkNotNullParameter(r6, "request");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L9
        gd9.i r1 = com.larus.im.b.a;     // Catch: Throwable -> L9
        Intrinsics.checkNotNull(r1);     // Catch: Throwable -> L9
        if ((r1.a().e() instanceof SlidesActivity) == true) goto L6;
        boolean r2 = true;
    L7:
        Object r3 = Result.constructor-impl(Boolean.valueOf(r2));     // Catch: Throwable -> L9
    L11:
        Throwable r4 = Result.exceptionOrNull-impl(r3);
        if (r4 == null) goto L14;
        FLogger.a.w("AiPptReachSceneInterceptor", "ai ppt reach gate failed, reject display, reachUniqueId=" + r6.a.h, r4);
    L14:
        Boolean r7 = Boolean.FALSE;
        if (Result.isFailure-impl(r3) == false) goto L18;
        r3 = r7;
    L18:
        return ((Boolean) r3).booleanValue();
    L6:
        r2 = false;
    L9:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    @Override // com.larus.reach.api.ReachSceneInterceptor
    public final boolean j(ns9.t r33, ns9.e r34) {
        Intrinsics.checkNotNullParameter(r33, "request");
        Intrinsics.checkNotNullParameter(r34, "click");
        if (r34.a == ReachClickTarget.BUTTON) goto L6;
        return false;
    L6:
        Iterator<T> r1 = r34.c.iterator();
    L7:
        String r4 = null;
        if (r1.hasNext() == false) goto L21;
        Map<String, String> r2 = ((ns9.b) r1.next()).b;
        if (r2 == null) goto L12;
        String r3 = r2.get("schema");
    L13:
        if (r3 != null) goto L16;
        r3 = "";
    L16:
        if ((!StringsKt.isBlank(r3)) == true) goto L19;
        r3 = null;
    L19:
        if (r3 == null) goto L7;
    L22:
        if (r3 == null) goto L24;
        Uri r5 = UriProtector.parse(r3);
    L25:
        if (r5 == null) goto L27;
        String r6 = UriProtector.getQueryParameter(r5, "conversation_id");
    L28:
        if (r5 == null) goto L30;
        r4 = UriProtector.getQueryParameter(r5, "msg_id");
    L30:
        String r22 = r4;
        ISlidesService r7 = (ISlidesService) ServiceManager.get().getService(ISlidesService.class);
        if (r7 != null) goto L34;
        FLogger.a.w("AiPptReachSceneInterceptor", "ai ppt reach click ignored, service unavailable, reachUniqueId=" + r33.a.h);
        return true;
    L34:
        gd9.i r0 = com.larus.im.b.a;
        Intrinsics.checkNotNull(r0);
        NovaApplication r8 = r0.getApplication();
        r8.getClass();
        r7.h(r8, new ni8.e(r6, null, null, false, false, false, 0, null, null, "inner_push", null, null, null, 0, null, r22, null, null, null, null, 0, 0, 0, 16710654));
        return true;
    L27:
        r6 = null;
        goto L28
    L24:
        r5 = null;
        goto L25
    L12:
        r3 = null;
        goto L13
    L21:
        r3 = null;
        goto L22
    }
}
