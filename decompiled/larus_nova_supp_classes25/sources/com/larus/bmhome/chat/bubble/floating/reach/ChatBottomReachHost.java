package com.larus.bmhome.chat.bubble.floating.reach;

import android.content.Context;
import android.widget.FrameLayout;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.reach.api.ReachBannerHost;
import com.larus.reach.api.ReachCloseReason;
import com.larus.reach.api.ReachPosition;
import com.larus.reach.api.ReachRejectReason;
import com.larus.reach.api.ReachType;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ns9.c;
import ns9.g;
import ns9.h;
import ns9.i;
import ns9.j;
import ns9.t;
import ns9.w;
import tc8.b;
import tc8.m;
import tc8.r;
import tc8.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0007\u0018\u0000 72\u00020\u0001:\u00017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\u0010\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J$\u0010\u0013\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\r0\u0015H\u0002J \u0010\u0017\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001eH\u0016JA\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\t0&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00180&H\u0000¢\u0006\u0002\b(J\u0015\u0010)\u001a\u00020\u00182\u0006\u0010!\u001a\u00020$H\u0000¢\u0006\u0002\b*J\u0017\u0010+\u001a\u00020\u00182\b\u0010 \u001a\u0004\u0018\u00010\u0016H\u0000¢\u0006\u0002\b,J\u0017\u0010-\u001a\u00020\u00182\b\u0010 \u001a\u0004\u0018\u00010\u0016H\u0000¢\u0006\u0002\b.J\u0017\u0010/\u001a\u00020\u00182\b\u0010 \u001a\u0004\u0018\u00010\u0016H\u0000¢\u0006\u0002\b0J\u0017\u00101\u001a\u00020\u00182\b\u0010 \u001a\u0004\u0018\u00010\u0016H\u0000¢\u0006\u0002\b2J\r\u00103\u001a\u00020\u0018H\u0000¢\u0006\u0002\b4J\r\u00105\u001a\u00020\u0018H\u0000¢\u0006\u0002\b6R\u0014\u0010\u0004\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u00068"}, d2 = {"Lcom/larus/bmhome/chat/bubble/floating/reach/ChatBottomReachHost;", "Lcom/larus/reach/api/ReachBannerHost;", "<init>", "()V", "controller", "Lcom/larus/bmhome/chat/bubble/floating/reach/ChatBottomReachHostController;", "getController", "()Lcom/larus/bmhome/chat/bubble/floating/reach/ChatBottomReachHostController;", "canHandle", "", "request", "Lcom/larus/reach/api/ReachRequest;", "evaluate", "Lcom/larus/reach/api/ReachHostDecision;", "renderContext", "Landroid/content/Context;", "prepare", "content", "Lcom/larus/reach/api/ReachBannerRenderContent;", "evaluateTarget", "onTargetReady", "Lkotlin/Function1;", "", "show", "", "session", "Lcom/larus/reach/api/ReachDisplaySession;", "dismiss", "reachUniqueId", "reason", "Lcom/larus/reach/api/ReachCloseReason;", "registerPageHost", "conversationId", "overlay", "Landroid/widget/FrameLayout;", "anchorRoot", "Landroid/view/ViewGroup;", "canHostBanner", "Lkotlin/Function0;", "refreshList", "registerPageHost$impl_mainlandRelease", "unregisterPageHost", "unregisterPageHost$impl_mainlandRelease", "onChatPageResumed", "onChatPageResumed$impl_mainlandRelease", "onChatPagePaused", "onChatPagePaused$impl_mainlandRelease", "onChatPageDestroyed", "onChatPageDestroyed$impl_mainlandRelease", "onChatConversationChanged", "onChatConversationChanged$impl_mainlandRelease", "onChatHostLayoutChanged", "onChatHostLayoutChanged$impl_mainlandRelease", "onChatHostUnavailable", "onChatHostUnavailable$impl_mainlandRelease", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ChatBottomReachHost implements ReachBannerHost {
    public static final /* synthetic */ int a = 0;

    public static final class a {
    }

    static {
    }

    public ChatBottomReachHost() {
    }

    public final h d(final t r2) {
        Intrinsics.checkNotNullParameter(r2, "request");
        return i(r2, new b(this, r2));
    }

    public final Context e(t r4) {
        Intrinsics.checkNotNullParameter(r4, "request");
        r r1 = r.a;
        Intrinsics.checkNotNullParameter(r4, "request");
        String r5 = (String) ((LinkedHashMap) r.n).get(r4.a.h);
        r.d r0 = r.f;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (Intrinsics.areEqual(r0.a, r5) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L14;
        FrameLayout r6 = r0.b();
        if (r6 != null) goto L12;
        return null;
    L12:
        return r6.getContext();
    L14:
        return null;
    }

    public final boolean f(t r4) {
        Intrinsics.checkNotNullParameter(r4, "request");
        w r0 = r4.b;
        if ((r0 instanceof w) == false) goto L5;
        w r1 = r0;
    L7:
        if (r1 != null) goto L10;
        return false;
    L10:
        if (r4.getType() == ReachType.BANNER) goto L12;
        return false;
    L12:
        if (r1.a == ReachPosition.BOTTOM) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(r1.b.get("page_id"), "conversation") == false) goto L19;
        return true;
    L19:
        return false;
    L5:
        r1 = null;
        goto L7
    }

    public static h i(t r2, Function1 r3) {
        r r0 = r.a;
        String r1 = r2.a.h;
        Intrinsics.checkNotNullParameter(r1, "reachUniqueId");
        ReachRejectReason r4 = r.c.remove(r1);
        if (r4 != null) goto L5;
        w r5 = r2.b;
        if ((r5 instanceof w) == false) goto L9;
        w r6 = r5;
    L10:
        if (r6 == null) goto L12;
        u r7 = u.a;
        String r8 = (String) r6.b.get("conversation_id");
        r7.getClass();
        String r9 = u.a(r8);
        String r10 = u.b();
        if (r10 == null) goto L16;
        if (r9 == null) goto L23;
        if (Intrinsics.areEqual(r10, r9) == true) goto L23;
        return new h.c("target_conversation_not_matched");
    L23:
        return (h) r3.invoke(r10);
    L16:
        return new h.c("target_conversation_host_not_ready");
    L12:
        return new h.b(ReachRejectReason.NOT_TARGET_PAGE);
    L9:
        r6 = null;
        goto L10
    L5:
        return new h.b(r4);
    }

    public final h b(final t r2, final c r3) {
        Intrinsics.checkNotNullParameter(r2, "request");
        Intrinsics.checkNotNullParameter(r3, "content");
        return i(r2, new tc8.a(this, r2, r3));
    }

    public final i c(t r2, List<j> r3) {
        Intrinsics.checkNotNullParameter(r2, "request");
        Intrinsics.checkNotNullParameter(r3, "currentEntries");
        return i.b.a;
    }

    public final void g(String r2, ReachCloseReason r3) {
        Intrinsics.checkNotNullParameter(r2, "reachUniqueId");
        Intrinsics.checkNotNullParameter(r3, "reason");
        r.a.n(r2, r3);
    }

    public final void a(final t r5, final g r6, final c r7) {
        Intrinsics.checkNotNullParameter(r5, "request");
        Intrinsics.checkNotNullParameter(r6, "session");
        Intrinsics.checkNotNullParameter(r7, "content");
        r r3 = r.a;
        Intrinsics.checkNotNullParameter(r5, "request");
        Intrinsics.checkNotNullParameter(r6, "session");
        Intrinsics.checkNotNullParameter(r7, "content");
        r3.C(new m(r5, r6, r7));
    }

    public final void h(t r2, g r3, c r4, String r5, ReachCloseReason r6) {
        Intrinsics.checkNotNullParameter(r2, "request");
        Intrinsics.checkNotNullParameter(r3, "session");
        Intrinsics.checkNotNullParameter(r4, "content");
        Intrinsics.checkNotNullParameter(r5, "replacedReachUniqueId");
        Intrinsics.checkNotNullParameter(r6, "reason");
        a(r2, r3, r4);
        g(r5, r6);
    }
}
