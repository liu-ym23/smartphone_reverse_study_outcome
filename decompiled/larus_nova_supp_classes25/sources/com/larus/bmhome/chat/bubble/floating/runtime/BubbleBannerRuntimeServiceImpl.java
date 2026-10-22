package com.larus.bmhome.chat.bubble.floating.runtime;

import android.content.Context;
import com.larus.bmhome.chat.bubble.floating.BubbleBannerDismissReason;
import com.larus.bmhome.chat.bubble.floating.BubbleBannerEnterTrigger;
import com.larus.bmhome.chat.bubble.floating.BubbleBannerRenderPart;
import com.larus.bmhome.chat.bubble.floating.BubbleBannerState;
import com.larus.bmhome.chat.bubble.floating.BubbleBannerTransitionType;
import com.larus.bmhome.chat.bubble.floating.report.BubbleBannerShowReporter;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.markdown.memory.MemoryActionTag;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001c\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\nH\u0016J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\nH\u0016J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\nH\u0016J\u0010\u0010\u0016\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u001a\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0018\u0010\u001d\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u001f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\"H\u0016J\u0012\u0010#\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\u0016\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00070%2\u0006\u0010\u0013\u001a\u00020\nH\u0016J\u0012\u0010&\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0013\u001a\u00020\nH\u0016J\u0010\u0010'\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\nH\u0016J\u0018\u0010(\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010)\u001a\u00020*H\u0016J\u0018\u0010+\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010)\u001a\u00020*H\u0016¨\u0006,"}, d2 = {"Lcom/larus/bmhome/chat/bubble/floating/runtime/BubbleBannerRuntimeServiceImpl;", "Lcom/larus/bmhome/chat/bubble/floating/runtime/IBubbleBannerRuntimeService;", "<init>", "()V", MemoryActionTag.MEMORY_ACTION_TAG_ADD, "", "prompt", "Lcom/larus/bmhome/chat/bubble/floating/BubbleBannerModel;", "resolveRenderPlan", "promptId", "", "anchorMessageId", "markEnterTriggerReady", "", "trigger", "Lcom/larus/bmhome/chat/bubble/floating/BubbleBannerEnterTrigger;", "onPromptShownOnScreen", "markEnterAnimationConsumed", "onPageEnter", "conversationId", "onPageLeave", "onHostUnavailable", "ensureAutoDismissScheduled", "onPromptClick", "context", "Landroid/content/Context;", "dismiss", "reason", "Lcom/larus/bmhome/chat/bubble/floating/BubbleBannerDismissReason;", "clear", "completeDismiss", "markExitPartFinished", "transitionId", "part", "Lcom/larus/bmhome/chat/bubble/floating/BubbleBannerRenderPart;", "get", "getPrompts", "", "getWinnerPrompt", "hasPrompts", "attachRefreshListener", "listener", "Lcom/larus/bmhome/chat/bubble/floating/runtime/BubbleBannerRuntime$RefreshListener;", "detachRefreshListener", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class BubbleBannerRuntimeServiceImpl implements IBubbleBannerRuntimeService {
    public BubbleBannerRuntimeServiceImpl() {
    }

    @Override // com.larus.bmhome.chat.bubble.floating.runtime.IBubbleBannerRuntimeService
    public final void a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "conversationId");
        j.a.getClass();
        Intrinsics.checkNotNullParameter(r4, "conversationId");
        l r0 = j.b;
        monitor-enter(r0);
        Intrinsics.checkNotNullParameter(r4, "conversationId");     // Catch: Throwable -> L17
        pc8.e r5 = r0.b(r4);     // Catch: Throwable -> L17
        if (r5 != null) goto L7;
    L9:
        r5 = null;
    L10:
        List r6 = CollectionsKt.listOfNotNull(r5);     // Catch: Throwable -> L17
        monitor-exit(r0);
        Iterator r7 = r6.iterator();
    L14:
        if (r7.hasNext() == false) goto L16;
        pc8.e r1 = (pc8.e) r7.next();
        j r2 = j.a;
        String r3 = r1.a;
        BubbleBannerDismissReason r8 = BubbleBannerDismissReason.PAGE_LEAVE;
        r2.getClass();
        j.c(r3, r8);
        goto L14
    L16:
        return;
    L7:
        if ((!r5.b.f.d) == false) goto L9;
    L17:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.bmhome.chat.bubble.floating.runtime.IBubbleBannerRuntimeService
    public final void b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "promptId");
        j.a.getClass();
        j.b(r2);
    }

    @Override // com.larus.bmhome.chat.bubble.floating.runtime.IBubbleBannerRuntimeService
    public final boolean c(String r3) {
        Intrinsics.checkNotNullParameter(r3, "conversationId");
        j.a.getClass();
        Intrinsics.checkNotNullParameter(r3, "conversationId");
        l r0 = j.b;
        monitor-enter(r0);
        Intrinsics.checkNotNullParameter(r3, "conversationId");     // Catch: Throwable -> L10
        if (r0.b(r3) == null) goto L7;
        boolean r4 = true;
    L8:
        monitor-exit(r0);
        return r4;
    L7:
        r4 = false;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.bmhome.chat.bubble.floating.runtime.IBubbleBannerRuntimeService
    public final void e(String r3) {
        Intrinsics.checkNotNullParameter(r3, "conversationId");
        j.a.getClass();
        Intrinsics.checkNotNullParameter(r3, "conversationId");
        if (StringsKt.isBlank(r3) == true) goto L7;
        j.a(r3, BubbleBannerDismissReason.HOST_UNAVAILABLE);
        return;
    }

    @Override // com.larus.bmhome.chat.bubble.floating.runtime.IBubbleBannerRuntimeService
    public final void f(String r4) {
        Intrinsics.checkNotNullParameter(r4, "conversationId");
        j.a.getClass();
        Intrinsics.checkNotNullParameter(r4, "conversationId");
        l r0 = j.b;
        monitor-enter(r0);
        Intrinsics.checkNotNullParameter(r4, "conversationId");     // Catch: Throwable -> L22
        pc8.e r5 = r0.b(r4);     // Catch: Throwable -> L22
        if (r5 != null) goto L7;
    L12:
        r5 = null;
    L13:
        List r6 = CollectionsKt.listOfNotNull(r5);     // Catch: Throwable -> L22
        monitor-exit(r0);
        Iterator r7 = r6.iterator();
    L17:
        if (r7.hasNext() == false) goto L21;
        pc8.e r1 = (pc8.e) r7.next();
        if (r1.h == false) goto L17;
        j r2 = j.a;
        String r3 = r1.a;
        r2.getClass();
        j.g(r3);
        goto L17
    L21:
        return;
    L7:
        if (r5.c != BubbleBannerState.VISIBLE) goto L9;
        boolean r8 = true;
    L10:
        if (r8 == false) goto L12;
    L9:
        r8 = false;
    L22:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.bmhome.chat.bubble.floating.runtime.IBubbleBannerRuntimeService
    public final pc8.e get(String r3) {
        Intrinsics.checkNotNullParameter(r3, "promptId");
        j.a.getClass();
        Intrinsics.checkNotNullParameter(r3, "promptId");
        return j.b.a(r3);
    }

    @Override // com.larus.bmhome.chat.bubble.floating.runtime.IBubbleBannerRuntimeService
    public final void i(String r17) {
        Intrinsics.checkNotNullParameter(r17, "promptId");
        j.a.getClass();
        Intrinsics.checkNotNullParameter(r17, "promptId");
        l r1 = j.b;
        monitor-enter(r1);
        Intrinsics.checkNotNullParameter(r17, "promptId");     // Catch: Throwable -> L11
        pc8.e r3 = r1.a.get(r17);     // Catch: Throwable -> L11
        if (r3 != null) goto L8;
        monitor-exit(r1);
        return;
    L8:
        r1.a.put(r17, pc8.e.a(r3, null, null, 0, false, true, false, null, null, null, null, 4031));     // Catch: Throwable -> L11
        monitor-exit(r1);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.bmhome.chat.bubble.floating.runtime.IBubbleBannerRuntimeService
    public final void n(String r2) {
        Intrinsics.checkNotNullParameter(r2, "promptId");
        j.a.getClass();
        j.g(r2);
    }

    @Override // com.larus.bmhome.chat.bubble.floating.runtime.IBubbleBannerRuntimeService
    public final void o(String r7) {
        Intrinsics.checkNotNullParameter(r7, "promptId");
        j.a.getClass();
        Intrinsics.checkNotNullParameter(r7, "promptId");
        l r0 = j.b;
        pc8.e r1 = r0.a(r7);
        if (r1 == null) goto L19;
        BubbleBannerState r2 = r1.c;
        if (r2 == BubbleBannerState.ENTERING) goto L11;
        if (r2 == BubbleBannerState.VISIBLE) goto L11;
        return;
    L11:
        if (r1.h == false) goto L13;
        j.g(r7);
        return;
    L13:
        long r3 = System.currentTimeMillis();
        r0.c(r7, j.k(r1, r3));
        pc8.e r8 = r0.a(r7);
        if (r8 == null) goto L21;
        b.b(r8);
        CoroutineScope r4 = BubbleBannerShowReporter.a;
        Intrinsics.checkNotNullParameter(r8, "prompt");
        BubbleBannerShowReporter.a(pc8.g.b(r8), r3);
        sc8.i.a.getClass();
        Intrinsics.checkNotNullParameter(r8, "prompt");
        sc8.b r9 = pc8.g.b(r8);
        Intrinsics.checkNotNullParameter(r9, "event");
        sc8.i.c(new sc8.g(sc8.i.b(r9.a), r9));
        return;
    L21:
        return;
    }

    @Override // com.larus.bmhome.chat.bubble.floating.runtime.IBubbleBannerRuntimeService
    public final boolean p(pc8.e r7) {
        Intrinsics.checkNotNullParameter(r7, "prompt");
        j.a.getClass();
        Intrinsics.checkNotNullParameter(r7, "prompt");
        l r0 = j.b;
        monitor-enter(r0);
        Intrinsics.checkNotNullParameter(r7, "prompt");     // Catch: Throwable -> L39
        boolean r2 = false;
        if (r0.a.containsKey(r7.a) == false) goto L9;
        monitor-exit(r0);
    L33:
        if (r2 == false) goto L38;
        final String r8 = r7.b.b;
        if (StringsKt.isBlank(r8) == true) goto L38;
        j.d.post(new d(r8));
    L38:
        return r2;
    L9:
        pc8.e r1 = r0.b(r7.b.b);     // Catch: Throwable -> L39
        if (r1 != null) goto L14;
        r0.a.put(r7.a, r7);     // Catch: Throwable -> L39
        r0.b.put(r7.b.b, r7.a);     // Catch: Throwable -> L39
        monitor-exit(r0);
    L32:
        r2 = true;
        goto L33
    L14:
        BubbleBannerState r4 = r1.c;     // Catch: Throwable -> L39
        if (r4 != BubbleBannerState.RECEIVED) goto L17;
    L19:
        int r5 = r7.b.f.f;     // Catch: Throwable -> L39
        int r6 = r1.b.f.f;     // Catch: Throwable -> L39
        if (r5 > r6) goto L26;
        if (r5 == r6) goto L23;
    L25:
        boolean r9 = false;
    L27:
        if (r9 == true) goto L30;
        monitor-exit(r0);
        goto L33
    L30:
        r0.a.remove(r1.a);     // Catch: Throwable -> L39
        r0.a.put(r7.a, r7);     // Catch: Throwable -> L39
        r0.b.put(r7.b.b, r7.a);     // Catch: Throwable -> L39
        monitor-exit(r0);
        goto L32
    L23:
        if (r7.a.compareTo(r1.a) >= 0) goto L25;
    L26:
        r9 = true;
        goto L27
    L17:
        if (r4 == BubbleBannerState.RESOLVED) goto L19;
    L39:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.bmhome.chat.bubble.floating.runtime.IBubbleBannerRuntimeService
    public final pc8.e q(String r3) {
        Intrinsics.checkNotNullParameter(r3, "conversationId");
        j.a.getClass();
        Intrinsics.checkNotNullParameter(r3, "conversationId");
        l r0 = j.b;
        monitor-enter(r0);
        Intrinsics.checkNotNullParameter(r3, "conversationId");     // Catch: Throwable -> L7
        pc8.e r4 = r0.b(r3);     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r4;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.bmhome.chat.bubble.floating.runtime.IBubbleBannerRuntimeService
    public final void d(String r18, BubbleBannerEnterTrigger r19) {
        Intrinsics.checkNotNullParameter(r18, "promptId");
        Intrinsics.checkNotNullParameter(r19, "trigger");
        j.a.getClass();
        Intrinsics.checkNotNullParameter(r18, "promptId");
        Intrinsics.checkNotNullParameter(r19, "trigger");
        l r2 = j.b;
        monitor-enter(r2);
        Intrinsics.checkNotNullParameter(r18, "promptId");     // Catch: Throwable -> L23
        Intrinsics.checkNotNullParameter(r19, "trigger");     // Catch: Throwable -> L23
        pc8.e r4 = r2.a.get(r18);     // Catch: Throwable -> L23
        if (r4 != null) goto L9;
        monitor-exit(r2);
        pc8.e r1 = null;
    L11:
        if (r1 == null) goto L29;
        pc8.f r3 = r1.d;
        if (r3 != null) goto L17;
        return;
    L17:
        if (r1.c == BubbleBannerState.RESOLVED) goto L19;
        return;
    L19:
        if (r1.l.containsAll(r3.b) == false) goto L31;
        r2.d(r18, j.h(r18, BubbleBannerTransitionType.ENTER));
        String r0 = r1.b.b;
        j.d.post(new e(r0));
        return;
    L31:
        return;
    L29:
        return;
    L9:
        r1 = pc8.e.a(r4, null, null, 0, false, false, false, null, null, null, SetsKt.plus(r4.l, r19), 2047);     // Catch: Throwable -> L23
        r2.a.put(r18, r1);     // Catch: Throwable -> L23
        monitor-exit(r2);
    L23:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.bmhome.chat.bubble.floating.runtime.IBubbleBannerRuntimeService
    public final pc8.e g(String r17, String r18) {
        Intrinsics.checkNotNullParameter(r17, "promptId");
        j.a.getClass();
        Intrinsics.checkNotNullParameter(r17, "promptId");
        l r1 = j.b;
        pc8.e r2 = r1.a(r17);
        if (r2 != null) goto L5;
        return r2;
    L5:
        if (r2.c != BubbleBannerState.RECEIVED) goto L26;
        int r3 = pc8.f.d;
        String r4 = pc8.g.a(r2.b);
        if (r4 != null) goto L10;
        r4 = r18;
    L10:
        pc8.f r5 = pc8.f.a.a(r4);
        monitor-enter(r1);
        Intrinsics.checkNotNullParameter(r17, "promptId");     // Catch: Throwable -> L19
        Intrinsics.checkNotNullParameter(r5, "renderPlan");     // Catch: Throwable -> L19
        pc8.e r6 = r1.a.get(r17);     // Catch: Throwable -> L19
        if (r6 != null) goto L16;
        monitor-exit(r1);
    L25:
        return r1.a(r17);
    L16:
        LinkedHashMap<String, pc8.e> r7 = r1.a;     // Catch: Throwable -> L19
        BubbleBannerState r8 = BubbleBannerState.RESOLVED;     // Catch: Throwable -> L19
        Intrinsics.checkNotNullParameter(r6, "<this>");     // Catch: Throwable -> L19
        Intrinsics.checkNotNullParameter(r5, "renderPlan");     // Catch: Throwable -> L19
        Intrinsics.checkNotNullParameter(r8, "state");     // Catch: Throwable -> L19
        r7.put(r17, pc8.e.a(r6, r8, r5, 0, false, false, false, null, null, null, null, 4083));     // Catch: Throwable -> L19
        monitor-exit(r1);
    L19:
        th = move-exception;
        throw th;
    L26:
        return r2;
    }

    @Override // com.larus.bmhome.chat.bubble.floating.runtime.IBubbleBannerRuntimeService
    public final boolean h(String r2, BubbleBannerDismissReason r3) {
        Intrinsics.checkNotNullParameter(r2, "promptId");
        Intrinsics.checkNotNullParameter(r3, "reason");
        j.a.getClass();
        return j.c(r2, r3);
    }

    @Override // com.larus.bmhome.chat.bubble.floating.runtime.IBubbleBannerRuntimeService
    public final void j(Context r18, String r19) {
        Intrinsics.checkNotNullParameter(r18, "context");
        Intrinsics.checkNotNullParameter(r19, "promptId");
        j.a.getClass();
        Intrinsics.checkNotNullParameter(r18, "context");
        Intrinsics.checkNotNullParameter(r19, "promptId");
        l r2 = j.b;
        pc8.e r1 = r2.a(r19);
        if (r1 == null) goto L55;
        BubbleBannerState r3 = r1.c;
        BubbleBannerState r4 = BubbleBannerState.VISIBLE;
        if (r3 != r4) goto L56;
        pc8.a r5 = r1.b.h;
        String r6 = null;
        if (r5 == null) goto L11;
        Integer r7 = r5.getType();
    L13:
        if (r7 != null) goto L16;
        j.i(r18, r1, r1.b.d.f, "container click");
    L30:
        int r0 = r1.b.f.e;
        if (r0 == 1) goto L34;
        if (r0 == 2) goto L48;
        j.c(r1.a, BubbleBannerDismissReason.USER_CLICK);
    L48:
        sc8.i.a.getClass();
        Intrinsics.checkNotNullParameter(r1, "prompt");
        sc8.i.a(pc8.g.b(r1));
        return;
    L34:
        String r8 = r1.a;
        pc8.e r9 = r2.a(r8);
        if (r9 == null) goto L48;
        if (r9.c != r4) goto L48;
        b.a(r8);
        monitor-enter(r2);
        Intrinsics.checkNotNullParameter(r8, "promptId");     // Catch: Throwable -> L50
        pc8.e r10 = r2.a.get(r8);     // Catch: Throwable -> L50
        if (r10 != null) goto L46;
        monitor-exit(r2);
        goto L48
    L46:
        r2.a.put(r8, pc8.e.a(r10, null, null, 0, true, false, false, null, null, null, null, 4047));     // Catch: Throwable -> L50
        monitor-exit(r2);
    L50:
        th = move-exception;
        throw th;
    L16:
        if (r7.intValue() == 0) goto L30;
        if (r7.intValue() != 1) goto L24;
        Map<String, String> r11 = r5.b;
        if (r11 == null) goto L22;
        r6 = r11.get("schema");
    L22:
        j.i(r18, r1, r6, "jump schema action");
        goto L30
    L24:
        if (r7.intValue() != 2) goto L30;
        pc8.a r12 = r1.b.h;
        if (r12 == null) goto L28;
        Map<String, String> r13 = r12.b;
    L29:
        BuildersKt.launch$default(j.c, null, null, new BubbleBannerManager$sendCommonRequest$1(r18, r1, r13, null), 3, null);
        goto L30
    L28:
        r13 = null;
        goto L29
    L11:
        r7 = null;
        goto L13
    L56:
        return;
    }

    @Override // com.larus.bmhome.chat.bubble.floating.runtime.IBubbleBannerRuntimeService
    public final void l(String r4, final k.a r5) {
        Intrinsics.checkNotNullParameter(r4, "conversationId");
        Intrinsics.checkNotNullParameter(r5, "listener");
        j.a.getClass();
        Intrinsics.checkNotNullParameter(r4, "conversationId");
        Intrinsics.checkNotNullParameter(r5, "listener");
        if (StringsKt.isBlank(r4) == true) goto L10;
        LinkedHashMap r0 = (LinkedHashMap) j.e;
        Object r1 = r0.get(r4);
        if (r1 != null) goto L8;
        r1 = new ArrayList();
        r0.put(r4, r1);
    L8:
        List r2 = (List) r1;
        CollectionsKt.removeAll(r2, new g(r5));
        r2.add(new j.a(new WeakReference(r5)));
        return;
    }

    @Override // com.larus.bmhome.chat.bubble.floating.runtime.IBubbleBannerRuntimeService
    public final void m(String r2, BubbleBannerDismissReason r3) {
        Intrinsics.checkNotNullParameter(r2, "conversationId");
        Intrinsics.checkNotNullParameter(r3, "reason");
        j.a.getClass();
        j.a(r2, r3);
    }

    @Override // com.larus.bmhome.chat.bubble.floating.runtime.IBubbleBannerRuntimeService
    public final void r(String r4, final k.a r5) {
        Intrinsics.checkNotNullParameter(r4, "conversationId");
        Intrinsics.checkNotNullParameter(r5, "listener");
        j.a.getClass();
        Intrinsics.checkNotNullParameter(r4, "conversationId");
        Intrinsics.checkNotNullParameter(r5, "listener");
        if (StringsKt.isBlank(r4) == true) goto L19;
        Map<String, List<j.a>> r0 = j.e;
        List r1 = (List) ((LinkedHashMap) r0).get(r4);
        if (r1 == null) goto L8;
        CollectionsKt.removeAll(r1, new c(r5));
    L8:
        List r2 = r1;
        if (r2 != null) goto L11;
    L14:
        boolean r6 = true;
    L15:
        if (r6 == false) goto L18;
        r0.remove(r4);
        return;
    L18:
        return;
    L11:
        if (r2.isEmpty() == true) goto L14;
        r6 = false;
        goto L15
    }

    @Override // com.larus.bmhome.chat.bubble.floating.runtime.IBubbleBannerRuntimeService
    public final void k(String r19, String r20, BubbleBannerRenderPart r21) {
        Intrinsics.checkNotNullParameter(r19, "promptId");
        Intrinsics.checkNotNullParameter(r20, "transitionId");
        Intrinsics.checkNotNullParameter(r21, "part");
        j.a.getClass();
        Intrinsics.checkNotNullParameter(r19, "promptId");
        Intrinsics.checkNotNullParameter(r20, "transitionId");
        Intrinsics.checkNotNullParameter(r21, "part");
        l r3 = j.b;
        monitor-enter(r3);
        Intrinsics.checkNotNullParameter(r19, "promptId");     // Catch: Throwable -> L36
        Intrinsics.checkNotNullParameter(r20, "transitionId");     // Catch: Throwable -> L36
        Intrinsics.checkNotNullParameter(r21, "part");     // Catch: Throwable -> L36
        pc8.e r5 = r3.a.get(r19);     // Catch: Throwable -> L36
        String r4 = null;
        if (r5 != null) goto L9;
        monitor-exit(r3);
        r5 = null;
    L23:
        if (r5 != null) goto L26;
        return;
    L26:
        if (r5.c != BubbleBannerState.EXITING) goto L41;
        pc8.b r1 = r5.k;
        if (r1 == null) goto L32;
        boolean r2 = true;
        if (r1.b.containsAll(r1.a) != true) goto L32;
    L33:
        if (r2 == false) goto L42;
        j.b(r19);
        return;
    L42:
        return;
    L32:
        r2 = false;
        goto L33
    L41:
        return;
    L9:
        pc8.i r6 = r5.j;     // Catch: Throwable -> L36
        if (r6 == null) goto L13;
        r4 = r6.a;     // Catch: Throwable -> L36
    L13:
        if (Intrinsics.areEqual(r4, r20) == true) goto L16;
        monitor-exit(r3);
        goto L23
    L16:
        pc8.b r7 = r5.k;     // Catch: Throwable -> L36
        if (r7 != null) goto L21;
        monitor-exit(r3);
        goto L23
    L21:
        Set r8 = SetsKt.plus(r7.b, r21);     // Catch: Throwable -> L36
        Set<BubbleBannerRenderPart> r9 = r7.a;     // Catch: Throwable -> L36
        Intrinsics.checkNotNullParameter(r9, "requiredParts");     // Catch: Throwable -> L36
        Intrinsics.checkNotNullParameter(r8, "finishedParts");     // Catch: Throwable -> L36
        r5 = pc8.e.a(r5, null, null, 0, false, false, false, null, null, new pc8.b(r9, r8), null, 3071);     // Catch: Throwable -> L36
        r3.a.put(r19, r5);     // Catch: Throwable -> L36
        monitor-exit(r3);
    L36:
        th = move-exception;
        throw th;
    }
}
