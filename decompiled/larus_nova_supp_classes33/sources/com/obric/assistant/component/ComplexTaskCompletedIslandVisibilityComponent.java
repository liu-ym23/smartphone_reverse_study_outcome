package com.obric.assistant.component;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.live.island.ComplexTaskQueueingAndCompletionIslandMonitor;
import com.obric.livecard.api.entity.IslandSession;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0002J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/assistant/component/ComplexTaskCompletedIslandVisibilityComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "<init>", "()V", "messageVisibilityAbility", "Lcom/obric/assistant/ability/IObricMessageVisibilityAbility;", "getMessageVisibilityAbility", "()Lcom/obric/assistant/ability/IObricMessageVisibilityAbility;", "messageVisibilityAbility$delegate", "Lkotlin/Lazy;", "visibilitySubscription", "Lcom/obric/assistant/ability/ObricMessageVisibilitySubscription;", "onParentViewCreated", "", "onResume", "onDestroy", "ensureVisibilityObserver", "handleMessageVisibleFor", "event", "Lcom/obric/assistant/ability/ObricMessageVisibilityEvent;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ComplexTaskCompletedIslandVisibilityComponent extends ComponentFeature {
    public static final /* synthetic */ int j = 0;
    public final Lazy h;
    public laa.r i;

    public static final class a {
    }

    public static final class b implements laa.q {
        public final /* synthetic */ ComplexTaskCompletedIslandVisibilityComponent a;

        public b(ComplexTaskCompletedIslandVisibilityComponent r1) {
            this.a = r1;
        }

        public final void a(laa.p r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
        }

        public final void b(laa.p r13) {
            Intrinsics.checkNotNullParameter(r13, "event");
            ComplexTaskCompletedIslandVisibilityComponent r0 = this.a;
            int r1 = ComplexTaskCompletedIslandVisibilityComponent.j;
            r0.getClass();
            List r2 = CollectionsKt.filterNotNull(SetsKt.linkedSetOf(new String[]{r13.a.getMessageId(), r13.a.getLocalMessageId(), r13.b}));
            ArrayList r3 = new ArrayList();
            Iterator r4 = r2.iterator();
        L4:
            if (r4.hasNext() == false) goto L9;
            Object r5 = r4.next();
            if ((!StringsKt.isBlank((String) r5)) == false) goto L4;
            r3.add(r5);
            goto L4
        L9:
            if (r3.isEmpty() == true) goto L76;
            Iterator r6 = r3.iterator();
        L12:
            Object r7 = null;
            String r8 = null;
            r8 = null;
            if (r6.hasNext() == false) goto L56;
            Object r9 = r6.next();
            String r10 = (String) r9;
            ComplexTaskQueueingAndCompletionIslandMonitor.a.getClass();
            Intrinsics.checkNotNullParameter(r10, "replyMessageId");
            com.obric.assistant.live.island.g r11 = ComplexTaskQueueingAndCompletionIslandMonitor.c;
            r11.getClass();
            Intrinsics.checkNotNullParameter(r10, "replyMessageId");
            if ((!StringsKt.isBlank(r10)) == true) goto L18;
            r10 = null;
        L18:
            if (r10 == null) goto L38;
            com.obric.assistant.live.island.i r12 = r11.d;
            r12.getClass();
            Intrinsics.checkNotNullParameter(r10, "targetMessageId");
            Object r14 = r12.b;
            monitor-enter(r14);
            Iterator r15 = r12.c.iterator();     // Catch: Throwable -> L53
        L24:
            if (r15.hasNext() == false) goto L34;
            Object r16 = r15.next();     // Catch: Throwable -> L53
            IslandSession r17 = (IslandSession) r16;     // Catch: Throwable -> L53
            Intrinsics.checkNotNull(r17);     // Catch: Throwable -> L53
            JsonObject r18 = r17.getExt();     // Catch: Throwable -> L53
            if (r18 == null) goto L30;
            JsonElement r19 = r18.get("ext_target_message_id");     // Catch: Throwable -> L53
            if (r19 == null) goto L30;
            String r110 = r19.getAsString();     // Catch: Throwable -> L53
        L32:
            if (Intrinsics.areEqual(r110, r10) == false) goto L24;
        L35:
            IslandSession r20 = (IslandSession) r16;     // Catch: Throwable -> L53
            monitor-exit(r14);
            if (r20 == null) goto L38;
            JsonObject r21 = r20.getExt();
            if (r21 == null) goto L44;
            JsonElement r22 = r21.get("ext_task_id");
            if (r22 == null) goto L44;
            r8 = r22.getAsString();
        L44:
            FLogger.a.i("ComplexTaskCompletedIslandModule", "dismissCompletedCardByReplyMessageId, taskId=" + r8 + ", replyMessageId=" + r10);
            if (r8 == null) goto L47;
            r11.c(r8);
        L47:
            IslandSession r23 = r11.d.c(r8, r20);
            if (r23 == null) goto L50;
            int r24 = com.obric.assistant.live.island.j.a;
            com.obric.assistant.live.island.j.f(r23);
        L50:
            boolean r25 = true;
        L51:
            if (r25 == false) goto L12;
            r7 = r9;
        L30:
            r110 = null;
            goto L32
        L34:
            r16 = null;
        L53:
            th = move-exception;
            throw th;
        L38:
            r25 = false;
        L56:
            String r26 = (String) r7;
            if (r26 == null) goto L75;
            FLogger.a.i("CompletedIslandVisibility", "dismiss completed island after message visible, messageId=" + r26 + ", visibleDurationMs=" + r13.e);
            return;
        L75:
            return;
        }

        public final void c(laa.p r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
        }
    }

    public static final class c implements Function0<laa.g> {
        public final /* synthetic */ AttachReceiver a;

        public c(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(laa.g.class));
        }
    }

    static {
    }

    public final void F2() {
        if (this.i == null) goto L5;
        return;
    L5:
        laa.g r0 = (laa.g) this.h.getValue();
        if (r0 != null) goto L8;
        return;
    L8:
        this.i = r0.tt(new laa.o(0.1f, 1000L), new b(this));
        FLogger.a.i("CompletedIslandVisibility", "ensureVisibilityObserver, visibleDurationMs=1000, minVisibleRatio=0.1");
    }

    public final void onDestroy() {
        laa.r r0 = this.i;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.i = null;
    }

    public ComplexTaskCompletedIslandVisibilityComponent() {
        this.h = LazyKt.lazy(new c(this));
    }

    public final void B2() {
        F2();
    }

    public final void onResume() {
        F2();
    }
}
