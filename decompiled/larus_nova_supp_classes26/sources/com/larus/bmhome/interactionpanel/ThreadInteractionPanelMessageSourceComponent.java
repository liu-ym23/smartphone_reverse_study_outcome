package com.larus.bmhome.interactionpanel;

import android.view.View;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.thread.ThreadData;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 32\u00060\u0001j\u0002`\u0002:\u00013B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u001aH\u0016J\b\u0010!\u001a\u00020\u001aH\u0002J\b\u0010\"\u001a\u00020\u001aH\u0002J\u001e\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020\u00122\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00190\u0015H\u0002J \u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u0012H\u0002J\u0010\u0010)\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020\u0012H\u0002J8\u0010*\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\u00122\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00190\u00152\b\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010$\u001a\u00020\u0012H\u0002J6\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010'\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\u00122\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00190\u00152\b\u0010+\u001a\u0004\u0018\u00010,H\u0002J\b\u0010.\u001a\u00020\u0012H\u0002J\b\u0010/\u001a\u00020\u0012H\u0002J\u0010\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u0019H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0017\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u0015\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/larus/bmhome/interactionpanel/ThreadInteractionPanelMessageSourceComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/ContentComponent;", "manager", "Lcom/larus/bmhome/interactionpanel/IInteractionPanelQueueManager;", "<init>", "(Lcom/larus/bmhome/interactionpanel/IInteractionPanelQueueManager;)V", "cotDetailFragmentAbility", "Lcom/larus/bmhome/chat/cotdetail/ability/CotDetailFragmentAbility;", "getCotDetailFragmentAbility", "()Lcom/larus/bmhome/chat/cotdetail/ability/CotDetailFragmentAbility;", "cotDetailMessageListAbility", "Lcom/larus/bmhome/chat/cotdetail/ability/ICotDetailMessageListAbility;", "getCotDetailMessageListAbility", "()Lcom/larus/bmhome/chat/cotdetail/ability/ICotDetailMessageListAbility;", "threadData", "Lcom/larus/im/bean/thread/ThreadData;", "lastConversationId", "", "lastThreadId", "lastSyncedKeys", "", "Lcom/larus/bmhome/interactionpanel/InteractionPanelKey;", "messageSnapshotListener", "Lkotlin/Function1;", "Lcom/larus/im/bean/message/Message;", "", "sourceAdapter", "Lcom/larus/bmhome/interactionpanel/source/InteractionPanelSourceAdapter;", "onViewCreated", "view", "Landroid/view/View;", "onFragmentViewDestroyed", "installMessageSnapshotListener", "uninstallMessageSnapshotListener", "synchronize", "reason", "messages", "clearChangedScopeIfNeeded", "conversationId", "threadId", "clearLastSyncedSnapshot", "dequeueFinishedPanels", "trackContext", "Lcom/larus/bmhome/interactionpanel/InteractionTrackContext;", "resolveThreadPanelKeys", "resolveConversationId", "resolveThreadId", "shouldSyncMessage", "", "message", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ThreadInteractionPanelMessageSourceComponent extends BaseContentWidget {
    public static final /* synthetic */ int t = 0;
    public final g m;
    public ThreadData n;
    public String o;
    public String p;
    public List<o> q;
    public f1 r;
    public final lq8.b s;

    public static final class a {
    }

    static {
    }

    public ThreadInteractionPanelMessageSourceComponent() {
        this(0);
    }

    public final void A2() {
        f1 r0 = this.r;
        if (r0 == null) goto L9;
        fe8.c r2 = h3();
        if (r2 == null) goto L8;
        r2.KG(r0);
    L8:
        this.r = null;
    L9:
        String r1 = this.o;
        String r3 = this.p;
        boolean r4 = false;
        if (r1 != null) goto L12;
    L15:
        boolean r5 = true;
    L16:
        if (r5 == true) goto L23;
        if (r3 != null) goto L19;
    L20:
        r4 = true;
    L21:
        if (r4 == true) goto L23;
        this.m.i(r1, r3, CollectionsKt.emptyList(), "page_destroyed");
        goto L23
    L19:
        if (StringsKt.isBlank(r3) == false) goto L21;
    L23:
        this.o = null;
        this.p = null;
        this.q = CollectionsKt.emptyList();
        return;
    L12:
        if (StringsKt.isBlank(r1) == true) goto L15;
        r5 = false;
        goto L16
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.larus.bmhome.interactionpanel.f1] */
    public final void m3() {
        if (this.r == null) goto L5;
        return;
    L5:
        fe8.c r0 = h3();
        if (r0 != null) goto L9;
        FLogger.a.w("ThreadInteractionPanelSource", "message list ability unavailable, skip thread message source");
        return;
    L9:
        ?? r1 = new f1(this);
        r0.al(r1);
        this.r = r1;
    }

    public final fe8.a Y2() {
        return s1a.d.a(this).getAbility(fe8.a.class);
    }

    public final fe8.c h3() {
        return s1a.d.a(this).getAbility(fe8.c.class);
    }

    public ThreadInteractionPanelMessageSourceComponent(int r2) {
        g r3 = s.a();
        Intrinsics.checkNotNullParameter(r3, "manager");
        this.m = r3;
        this.q = CollectionsKt.emptyList();
        this.s = new lq8.b(new e1());
    }

    public final void onViewCreated(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r2, "view");
        F2().post(new c1(this));
        fe8.a r3 = Y2();
        if (r3 == null) goto L6;
        r3.RG(new d1(this));
        return;
    }

    public final List<o> p3(String r2, String r3, List<Message> r4, w r5) {
        List r6 = this.s.c(r2, r3, r4, r5);
        ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator r8 = ((ArrayList) r6).iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        r7.add(((lq8.d) r8.next()).a);
        goto L4
    L6:
        return r7;
    }
}
