package com.larus.reach.impl;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import com.larus.common_ui.presentation.UiPresentationChannel;
import com.larus.platform.model.video.sdkwrapper.feed.CustomFeedPlayerEvent;
import com.larus.reach.api.ReachBannerHost;
import com.larus.reach.api.ReachCloseReason;
import com.larus.reach.api.ReachPageScope;
import com.larus.reach.api.ReachPosition;
import com.larus.reach.api.ReachRejectReason;
import com.larus.reach.api.ReachType;
import com.tencent.open.log.TraceLevel;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import ns9.h;
import ns9.i;
import ns9.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\tH\u0016J\u001e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\t2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016J \u0010\u0013\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J0\u0010\u0019\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0018\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/larus/reach/impl/ReachGlobalTopHost;", "Lcom/larus/reach/api/ReachBannerHost;", "<init>", "()V", "controller", "Lcom/larus/reach/impl/ReachTopHostController;", "canHandle", "", "request", "Lcom/larus/reach/api/ReachRequest;", "evaluate", "Lcom/larus/reach/api/ReachHostDecision;", "renderContext", "Landroid/content/Context;", "resolveDisplayDecision", "Lcom/larus/reach/api/ReachHostDisplayDecision;", "currentEntries", "", "Lcom/larus/reach/api/ReachHostDisplayEntry;", "show", "", "session", "Lcom/larus/reach/api/ReachDisplaySession;", "content", "Lcom/larus/reach/api/ReachBannerRenderContent;", "replace", "replacedReachUniqueId", "", CustomFeedPlayerEvent.EXTRA_KEY_REASON, "Lcom/larus/reach/api/ReachCloseReason;", "dismiss", "reachUniqueId", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ReachGlobalTopHost implements ReachBannerHost {
    public final c0 a;

    public ReachGlobalTopHost() {
        this.a = new c0();
    }

    @Override // com.larus.reach.api.ReachBannerHost
    public final h d(ns9.t r8) {
        Intrinsics.checkNotNullParameter(r8, "request");
        c0 r0 = this.a;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r8, "request");
        r0.i();
        if (r8.b.a() != ReachPageScope.Global) goto L66;
        n19.a r1 = n19.a.a;
        UiPresentationChannel r2 = UiPresentationChannel.LEGACY_ACTIVITY_NOTIFICATION;
        boolean r4 = true;
        if (r1.d(r2) == false) goto L27;
        r0.j = true;
        Intrinsics.checkNotNullParameter(r2, "channel");
        monitor-enter(r1);
        Map r9 = (Map) ((LinkedHashMap) n19.a.c).get(r2);     // Catch: Throwable -> L23
        if (r9 != null) goto L12;
        r9 = MapsKt.emptyMap();     // Catch: Throwable -> L23
    L12:
        List r10 = CollectionsKt.toList(r9.values());     // Catch: Throwable -> L23
        monitor-exit(r1);
        Iterator r11 = r10.iterator();
    L16:
        if (r11.hasNext() == false) goto L67;
        Function0 r3 = (Function0) r11.next();
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L20
        Result.constructor-impl(r3.invoke());     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    L67:
        return new h.c("legacy_activity_dialog_dismissing");
    L23:
        th = move-exception;
        throw th;
    L27:
        if (r1.d(UiPresentationChannel.REACH) == true) goto L68;
        boolean r7 = r0.h.containsKey(r8.a.h);
        Activity r12 = r0.b();
        if (r12 == null) goto L52;
        if (r12.isFinishing() == false) goto L34;
    L36:
        boolean r13 = false;
    L37:
        Activity r14 = null;
        if (r13 == true) goto L41;
        r12 = null;
    L41:
        if (r12 == null) goto L52;
        if (r7 == false) goto L44;
    L47:
        if (r4 == false) goto L49;
        r14 = r12;
    L49:
        if (r14 == null) goto L52;
        return h.a.a;
    L44:
        if (r0.k(r12) == true) goto L47;
        r4 = false;
        goto L47
    L34:
        if (r12.isDestroyed() == true) goto L36;
        r13 = true;
    L52:
        if (c0.p(r8) == false) goto L57;
        if (c0.q() == null) goto L57;
        return h.a.a;
    L57:
        return new h.c("activity_unavailable");
    L68:
        return new h.c("ui_presentation_blocked");
    L66:
        return new h.b(ReachRejectReason.INVALID_PROTOCOL);
    }

    @Override // com.larus.reach.api.ReachBannerHost
    public final Context e(ns9.t r2) {
        Intrinsics.checkNotNullParameter(r2, "request");
        return com.larus.reach.runtime.t.b();
    }

    @Override // com.larus.reach.api.ReachBannerHost
    public final boolean f(ns9.t r3) {
        Intrinsics.checkNotNullParameter(r3, "request");
        if (r3.getType() != ReachType.BANNER) goto L9;
        ns9.v r4 = r3.b;
        if ((r4 instanceof ns9.a) == false) goto L9;
        if (r4.b() != ReachPosition.TOP) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.larus.reach.api.ReachBannerHost
    public final h b(ns9.t r2, ns9.c r3) {
        Intrinsics.checkNotNullParameter(r2, "request");
        Intrinsics.checkNotNullParameter(r3, "content");
        return d(r2);
    }

    @Override // com.larus.reach.api.ReachBannerHost
    public final i c(ns9.t r8, List<j> r9) {
        Intrinsics.checkNotNullParameter(r8, "request");
        Intrinsics.checkNotNullParameter(r9, "currentEntries");
        this.a.getClass();
        Intrinsics.checkNotNullParameter(r9, "currentEntries");
        Iterator<T> r10 = r9.iterator();
        if (r10.hasNext() == true) goto L5;
        Object r11 = null;
    L14:
        j r12 = (j) r11;
        if (r12 == null) goto L19;
        boolean r1 = true;
        if (r12.e != true) goto L19;
    L20:
        if (r1 == true) goto L37;
        if (r12 != null) goto L25;
        return i.b.a;
    L25:
        if (r12.c <= 0) goto L39;
        long r0 = RangesKt.coerceAtLeast(500 - (SystemClock.uptimeMillis() - r12.c), 0);
        if (r0 <= 0) goto L31;
        return new i.c(Long.valueOf(r0));
    L31:
        if (r12.d == false) goto L34;
        return i.b.a;
    L34:
        return new i.a(r12.a.a.h, ReachCloseReason.NEWER_ARRIVED);
    L39:
        return new i.c(null);
    L37:
        return new i.c(null);
    L19:
        r1 = false;
        goto L20
    L5:
        r11 = r10.next();
        if (r10.hasNext() == false) goto L14;
        long r2 = ((j) r11).b;
    L9:
        Object r3 = r10.next();
        long r4 = ((j) r3).b;
        if (r2 >= r4) goto L13;
        r11 = r3;
        r2 = r4;
    L13:
        if (r10.hasNext() == true) goto L9;
        goto L14
    }

    @Override // com.larus.reach.api.ReachBannerHost
    public final void g(String r2, ReachCloseReason r3) {
        Intrinsics.checkNotNullParameter(r2, "reachUniqueId");
        Intrinsics.checkNotNullParameter(r3, CustomFeedPlayerEvent.EXTRA_KEY_REASON);
        this.a.e(r2, r3);
    }

    @Override // com.larus.reach.api.ReachBannerHost
    public final void a(ns9.t r11, ns9.g r12, ns9.c r13) {
        Intrinsics.checkNotNullParameter(r11, "request");
        Intrinsics.checkNotNullParameter(r12, "session");
        Intrinsics.checkNotNullParameter(r13, "content");
        c0 r9 = this.a;
        r9.getClass();
        Intrinsics.checkNotNullParameter(r11, "request");
        Intrinsics.checkNotNullParameter(r12, "session");
        Intrinsics.checkNotNullParameter(r13, "content");
        r9.r(new a0(r9, r11, r12, null, r13));
    }

    @Override // com.larus.reach.api.ReachBannerHost
    public final void h(ns9.t r13, ns9.g r14, ns9.c r15, String r16, ReachCloseReason r17) {
        Intrinsics.checkNotNullParameter(r13, "request");
        Intrinsics.checkNotNullParameter(r14, "session");
        Intrinsics.checkNotNullParameter(r15, "content");
        Intrinsics.checkNotNullParameter(r16, "replacedReachUniqueId");
        Intrinsics.checkNotNullParameter(r17, CustomFeedPlayerEvent.EXTRA_KEY_REASON);
        c0 r11 = this.a;
        r11.getClass();
        Intrinsics.checkNotNullParameter(r13, "request");
        Intrinsics.checkNotNullParameter(r14, "session");
        Intrinsics.checkNotNullParameter(r15, "content");
        Intrinsics.checkNotNullParameter(r16, "replacedReachUniqueId");
        Intrinsics.checkNotNullParameter(r17, CustomFeedPlayerEvent.EXTRA_KEY_REASON);
        r11.r(new a0(r11, r13, r14, new c0.b(r16, r17), r15));
    }
}
