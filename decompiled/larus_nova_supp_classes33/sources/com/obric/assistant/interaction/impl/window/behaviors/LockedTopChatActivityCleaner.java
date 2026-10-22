package com.obric.assistant.interaction.impl.window.behaviors;

import android.app.Activity;
import android.content.ComponentName;
import com.larus.bmhome.chat.j4;
import com.larus.home.api.main.HomeService;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.obric.assistant.chat.ObricChatContextServiceDelegate;
import com.obric.assistant.interaction.api.IKeyguardStateKt;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import com.obric.assistant.interaction.impl.LockedHelperActivity;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.system.ITaskStackService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import gd9.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\tJ\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/behaviors/LockedTopChatActivityCleaner;", "", "<init>", "()V", "TAG", "", "LOCKED_FINISH_DELAY_MS", "", "hasTopChatActivityMatchingSystemTop", "", "source", "removeIfNeeded", "", "delayFinishWhenDeviceLocked", "evaluateTopChatActivity", "Lcom/obric/assistant/interaction/impl/window/behaviors/LockedTopChatActivityCleaner$TopChatActivityEvaluation;", "isIgnoredActivity", "activity", "Landroid/app/Activity;", "TopChatActivityEvaluation", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LockedTopChatActivityCleaner {
    public static final LockedTopChatActivityCleaner INSTANCE = null;
    private static final long LOCKED_FINISH_DELAY_MS = 2000;
    private static final String TAG = "LockedTopChatActivityCleaner";

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001BQ\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\fHÆ\u0003J_\u0010\u001f\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\fHÖ\u0001R!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0013\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006&"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/behaviors/LockedTopChatActivityCleaner$TopChatActivityEvaluation;", "", "activityList", "Ljava/util/ArrayList;", "Landroid/app/Activity;", "Lkotlin/collections/ArrayList;", "candidate", "candidateComponent", "Landroid/content/ComponentName;", "candidateRuntimeComponent", "topComponent", "skipReason", "", "<init>", "(Ljava/util/ArrayList;Landroid/app/Activity;Landroid/content/ComponentName;Landroid/content/ComponentName;Landroid/content/ComponentName;Ljava/lang/String;)V", "getActivityList", "()Ljava/util/ArrayList;", "getCandidate", "()Landroid/app/Activity;", "getCandidateComponent", "()Landroid/content/ComponentName;", "getCandidateRuntimeComponent", "getTopComponent", "getSkipReason", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class TopChatActivityEvaluation {
        private final ArrayList<Activity> activityList;
        private final Activity candidate;
        private final ComponentName candidateComponent;
        private final ComponentName candidateRuntimeComponent;
        private final String skipReason;
        private final ComponentName topComponent;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ TopChatActivityEvaluation copy$default(TopChatActivityEvaluation r4, ArrayList r5, Activity r6, ComponentName r7, ComponentName r8, ComponentName r9, String r10, int r11, Object r12) {
            if ((r11 & 1) == 0) goto L6;
            r5 = r4.activityList;
        L6:
            if ((r11 & 2) == 0) goto L8;
            r6 = r4.candidate;
        L8:
            Activity r13 = r6;
            if ((r11 & 4) == 0) goto L11;
            r7 = r4.candidateComponent;
        L11:
            ComponentName r0 = r7;
            if ((r11 & 8) == 0) goto L14;
            r8 = r4.candidateRuntimeComponent;
        L14:
            ComponentName r1 = r8;
            if ((r11 & 16) == 0) goto L17;
            r9 = r4.topComponent;
        L17:
            ComponentName r2 = r9;
            if ((r11 & 32) == 0) goto L20;
            r10 = r4.skipReason;
        L20:
            ArrayList r14 = r5;
            return r4.copy(r14, r13, r0, r1, r2, r10);
        }

        public final ArrayList<Activity> component1() {
            return this.activityList;
        }

        public final Activity component2() {
            return this.candidate;
        }

        public final ComponentName component3() {
            return this.candidateComponent;
        }

        public final ComponentName component4() {
            return this.candidateRuntimeComponent;
        }

        public final ComponentName component5() {
            return this.topComponent;
        }

        public final String component6() {
            return this.skipReason;
        }

        public final TopChatActivityEvaluation copy(ArrayList<Activity> r9, Activity r10, ComponentName r11, ComponentName r12, ComponentName r13, String r14) {
            Intrinsics.checkNotNullParameter(r9, "activityList");
            return new TopChatActivityEvaluation(r9, r10, r11, r12, r13, r14);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof TopChatActivityEvaluation) == true) goto L8;
            return false;
        L8:
            TopChatActivityEvaluation r6 = (TopChatActivityEvaluation) r5;
            if (Intrinsics.areEqual(this.activityList, r6.activityList) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.candidate, r6.candidate) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.candidateComponent, r6.candidateComponent) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.candidateRuntimeComponent, r6.candidateRuntimeComponent) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.topComponent, r6.topComponent) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.skipReason, r6.skipReason) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public int hashCode() {
            int r0 = this.activityList.hashCode() * 31;
            Activity r1 = this.candidate;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            ComponentName r5 = this.candidateComponent;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            ComponentName r8 = this.candidateRuntimeComponent;
            if (r8 != null) goto L13;
            int r9 = 0;
        L14:
            int r10 = (r7 + r9) * 31;
            ComponentName r11 = this.topComponent;
            if (r11 != null) goto L17;
            int r12 = 0;
        L18:
            int r13 = (r10 + r12) * 31;
            String r14 = this.skipReason;
            if (r14 == null) goto L23;
            r2 = r14.hashCode();
        L23:
            return r13 + r2;
        L17:
            r12 = r11.hashCode();
            goto L18
        L13:
            r9 = r8.hashCode();
            goto L14
        L9:
            r6 = r5.hashCode();
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "TopChatActivityEvaluation(activityList=" + this.activityList + ", candidate=" + this.candidate + ", candidateComponent=" + this.candidateComponent + ", candidateRuntimeComponent=" + this.candidateRuntimeComponent + ", topComponent=" + this.topComponent + ", skipReason=" + this.skipReason + ')';
        }

        public final ArrayList<Activity> getActivityList() {
            return this.activityList;
        }

        public final Activity getCandidate() {
            return this.candidate;
        }

        public final ComponentName getCandidateComponent() {
            return this.candidateComponent;
        }

        public final ComponentName getCandidateRuntimeComponent() {
            return this.candidateRuntimeComponent;
        }

        public final String getSkipReason() {
            return this.skipReason;
        }

        public final ComponentName getTopComponent() {
            return this.topComponent;
        }

        public TopChatActivityEvaluation(ArrayList<Activity> r2, Activity r3, ComponentName r4, ComponentName r5, ComponentName r6, String r7) {
            Intrinsics.checkNotNullParameter(r2, "activityList");
            this.activityList = r2;
            this.candidate = r3;
            this.candidateComponent = r4;
            this.candidateRuntimeComponent = r5;
            this.topComponent = r6;
            this.skipReason = r7;
        }
    }

    static {
        INSTANCE = new LockedTopChatActivityCleaner();
    }

    private LockedTopChatActivityCleaner() {
    }

    public static /* synthetic */ Result a(List r0, String r1) {
        return removeIfNeeded$lambda$4(r0, r1);
    }

    public static /* synthetic */ void b(Function0 r0) {
        removeIfNeeded$lambda$5(r0);
    }

    private final TopChatActivityEvaluation evaluateTopChatActivity() {
        i r0 = com.larus.im.b.a;
        Intrinsics.checkNotNull(r0);
        ArrayList r1 = new ArrayList(r0.a().d());
        Iterator r2 = CollectionsKt.asReversedMutable(r1).iterator();
    L3:
        boolean r3 = true;
        if (r2.hasNext() == false) goto L8;
        Object r4 = r2.next();
        Activity r5 = (Activity) r4;
        LockedTopChatActivityCleaner r6 = INSTANCE;
        Intrinsics.checkNotNull(r5);
        if ((!r6.isIgnoredActivity(r5)) == false) goto L3;
    L9:
        Activity r7 = (Activity) r4;
        ITaskStackService r8 = (ITaskStackService) ServiceManager.get().getService(ITaskStackService.class);
        if (r8 == null) goto L12;
        ComponentName r9 = r8.e();
    L13:
        if (r7 == null) goto L15;
        ComponentName r10 = r7.getComponentName();
    L16:
        if (r7 != null) goto L18;
    L28:
        ComponentName r11 = null;
    L29:
        if (r7 != null) goto L31;
        String r12 = "candidate_null";
    L50:
        String r13 = r12;
    L53:
        return new TopChatActivityEvaluation(r1, r7, r10, r11, r9, r13);
    L31:
        if (r9 != null) goto L34;
        r12 = "top_component_null";
        goto L50
    L34:
        if (Intrinsics.areEqual(r10, r9) == true) goto L39;
        if (Intrinsics.areEqual(r11, r9) == true) goto L39;
        r12 = "candidate_not_top";
    L39:
        if (ObricChatContextServiceDelegate.b.e(r7) == true) goto L42;
        r12 = "candidate_not_chat_activity";
        goto L50
    L42:
        if (r7.isFinishing() == false) goto L45;
        r12 = "candidate_finishing";
        goto L50
    L45:
        if (r7.isDestroyed() == false) goto L48;
        r12 = "candidate_destroyed";
        goto L50
    L48:
        if (r7.getTaskId() != 0) goto L51;
        r12 = "candidate_task_id_zero";
        goto L50
    L51:
        r13 = null;
        goto L53
    L18:
        if ((r7 instanceof j4) == true) goto L20;
    L22:
        r3 = false;
    L23:
        if (r3 == false) goto L25;
        Activity r14 = r7;
    L26:
        if (r14 == null) goto L28;
        r11 = new ComponentName(r14, r14.getClass());
        goto L29
    L25:
        r14 = null;
        goto L26
    L20:
        if (HomeService.a.o() == false) goto L22;
    L15:
        r10 = null;
        goto L16
    L12:
        r9 = null;
        goto L13
    L8:
        r4 = null;
        goto L9
    }

    private final boolean isIgnoredActivity(Activity r2) {
        if ((r2 instanceof ChatWindowActivity) == false) goto L5;
    L8:
        return true;
    L5:
        if ((r2 instanceof LockedHelperActivity) == true) goto L8;
        return false;
    }

    private static final void removeIfNeeded$lambda$5(Function0 r0) {
        r0.invoke();
    }

    public final boolean hasTopChatActivityMatchingSystemTop(String r6) {
        Intrinsics.checkNotNullParameter(r6, "source");
        TopChatActivityEvaluation r0 = evaluateTopChatActivity();
        if (r0.getSkipReason() != null) goto L5;
        boolean r1 = true;
    L6:
        FLogger r2 = FLogger.a;
        StringBuilder r3 = new StringBuilder("hasTopChatActivityMatchingSystemTop, source=");
        r3.append(r6);
        r3.append(", result=");
        r3.append(r1);
        r3.append(", reason=");
        r3.append(r0.getSkipReason());
        r3.append(", stackSize=");
        r3.append(r0.getActivityList().size());
        r3.append(", candidate=");
        r3.append(r0.getCandidateComponent());
        r3.append(", candidateRuntimeComponent=");
        r3.append(r0.getCandidateRuntimeComponent());
        r3.append(", candidateTaskId=");
        Activity r7 = r0.getCandidate();
        if (r7 == null) goto L9;
        Integer r8 = Integer.valueOf(r7.getTaskId());
    L10:
        r3.append(r8);
        r3.append(", top=");
        r3.append(r0.getTopComponent());
        r2.i(TAG, r3.toString());
        return r1;
    L9:
        r8 = null;
        goto L10
    L5:
        r1 = false;
        goto L6
    }

    private static final Result removeIfNeeded$lambda$4(List r7, String r8) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
        Iterator r1 = r7.iterator();     // Catch: Throwable -> L8
    L4:
        if (r1.hasNext() == false) goto L6;
        ((Activity) r1.next()).finish();     // Catch: Throwable -> L8
        goto L4
    L6:
        Object r2 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L11:
        if (Result.isSuccess-impl(r2) == false) goto L13;
        Unit r3 = (Unit) r2;
        FLogger.a.i(TAG, "finish success, source=" + r8 + ", finishCount=" + r7.size());
    L13:
        Throwable r4 = Result.exceptionOrNull-impl(r2);
        if (r4 == null) goto L17;
        FLogger.a.e(TAG, "finish failed, source=" + r8 + ", finishCount=" + r7.size(), r4);
    L17:
        return Result.box-impl(r2);
    L8:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.obric.assistant.interaction.impl.window.behaviors.n] */
    public final void removeIfNeeded(final String r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "source");
        TopChatActivityEvaluation r0 = evaluateTopChatActivity();
        FLogger r1 = FLogger.a;
        StringBuilder r2 = new StringBuilder("removeIfNeeded, source=");
        r2.append(r10);
        r2.append(", stackSize=");
        r2.append(r0.getActivityList().size());
        r2.append(", candidate=");
        r2.append(r0.getCandidateComponent());
        r2.append(", candidateRuntimeComponent=");
        r2.append(r0.getCandidateRuntimeComponent());
        r2.append(", candidateTaskId=");
        Activity r6 = r0.getCandidate();
        Integer r7 = null;
        if (r6 == null) goto L5;
        Integer r8 = Integer.valueOf(r6.getTaskId());
    L6:
        r2.append(r8);
        r2.append(", top=");
        r2.append(r0.getTopComponent());
        r2.append(", delayFinishWhenDeviceLocked=");
        r2.append(r11);
        r1.i(TAG, r2.toString());
        if (r0.getSkipReason() == null) goto L17;
        StringBuilder r12 = new StringBuilder("skip remove, source=");
        r12.append(r10);
        r12.append(", reason=");
        r12.append(r0.getSkipReason());
        r12.append(", candidate=");
        Activity r13 = r0.getCandidate();
        if (r13 == null) goto L11;
        String r14 = r13.getClass().getName();
    L12:
        r12.append(r14);
        r12.append(", candidateComponent=");
        r12.append(r0.getCandidateComponent());
        r12.append(", candidateRuntimeComponent=");
        r12.append(r0.getCandidateRuntimeComponent());
        r12.append(", candidateTaskId=");
        Activity r15 = r0.getCandidate();
        if (r15 == null) goto L15;
        r7 = Integer.valueOf(r15.getTaskId());
    L15:
        r12.append(r7);
        r12.append(", top=");
        r12.append(r0.getTopComponent());
        r1.i(TAG, r12.toString());
        return;
    L11:
        r14 = null;
        goto L12
    L17:
        ArrayList<Activity> r3 = r0.getActivityList();
        final ArrayList r4 = new ArrayList();
        Iterator<T> r5 = r3.iterator();
    L19:
        if (r5.hasNext() == false) goto L23;
        Object r9 = r5.next();
        if (isIgnoredActivity((Activity) r9) == true) goto L19;
        r4.add(r9);
        goto L19
    L23:
        final ?? r16 = new n(r4, r10);
        if (r11 == true) goto L26;
    L28:
        r16.invoke();
        return;
    L26:
        if (IKeyguardStateKt.getKeyguardState().isDeviceLocked() == false) goto L28;
        FLogger.a.i(TAG, "delay finish, source=" + r10 + ", finishCount=" + r4.size() + ", delayMs=2000");
        t0.d(new o(r16), LOCKED_FINISH_DELAY_MS);
        return;
    L5:
        r8 = null;
        goto L6
    }
}
