package com.larus.ugc.feed.impl.component;

import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.community.api.tracker.CreationFeedBehaviorTracker;
import com.larus.platform.model.video.sdkwrapper.feed.CustomFeedPlayerEvent;
import com.larus.profile.api.bean.UserCreationModel;
import com.larus.ugc.feed.impl.ability.CreationFeedAbilityImpl;
import com.larus.ugc.feed.impl.adapter.CreationListAdapter;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.StateFlowImpl;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.ugc.feed.impl.component.CreationFeedComponent$initObservers$5", f = "CreationFeedComponent.kt", i = {}, l = {840}, m = "invokeSuspend", n = {}, s = {})
final class CreationFeedComponent$initObservers$5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CreationFeedComponent this$0;

    /* JADX INFO: renamed from: com.larus.ugc.feed.impl.component.CreationFeedComponent$initObservers$5$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "uiState", "Lcom/larus/ugc/feed/api/state/CreationFeedUiState;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.ugc.feed.impl.component.CreationFeedComponent$initObservers$5$1", f = "CreationFeedComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<n0a.a, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ CreationFeedComponent this$0;

        public AnonymousClass1(CreationFeedComponent r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((n0a.a) r1, (Continuation) r2);
        }

        public final Object invoke(n0a.a r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r7) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L33;
            ResultKt.throwOnFailure(r7);
            n0a.a r8 = (n0a.a) this.L$0;
            CreationFeedComponent r0 = this.this$0;
            r0.D = r8;
            n0a.b r1 = r8.d;
            if (r1 != null) goto L7;
            r1 = n0a.b.c.a;
        L7:
            final List<UserCreationModel> r2 = r0.D3().projectFromKmp(r8.a, r1);
            if ((!r8.a.isEmpty()) == false) goto L12;
            int r3 = com.larus.utils.i.d(this.this$0.getContext());
            CreationListAdapter r4 = this.this$0.s;
            if (r4 == null) goto L12;
            r4.y2(r3 - i5.e0());
        L12:
            boolean r5 = r8.c instanceof n0a.e.b;
            if (r5 == false) goto L15;
            this.this$0.E.a(CreationFeedBehaviorTracker.ExposurePauseReason.DATA_REFRESH);
        L15:
            final CreationListAdapter r6 = this.this$0.s;
            if (r6 == null) goto L23;
            if (r2 == null) goto L23;
            r6.o.clear();
            if (r6.b.isEmpty() == false) goto L22;
            r6.b.addAll(r2);
            r6.notifyDataSetChanged();
            goto L23
        L22:
            DiffUtil.DiffResult r9 = DiffUtil.calculateDiff(new CreationListAdapter.DiffCallback(r6.b, r2), false);
            r6.b.clear();
            r6.b.addAll(r2);
            r9.dispatchUpdatesTo(r6);
            w0a.a.a("CreationListAdapter", new p0a.b(r6, r2));
        L23:
            if (r5 == true) goto L28;
            CreationFeedBehaviorTracker<CreationFeedComponent.b> r10 = this.this$0.E;
            CreationFeedBehaviorTracker.ExposurePauseReason r11 = CreationFeedBehaviorTracker.ExposurePauseReason.DATA_REFRESH;
            r10.getClass();
            Intrinsics.checkNotNullParameter(r11, CustomFeedPlayerEvent.EXTRA_KEY_REASON);
            r10.h.remove(r11);
            CreationFeedComponent r12 = this.this$0;
            RecyclerView r13 = r12.o.a();
            if (r13 == null) goto L28;
            r13.post(new t(r12));
        L28:
            if ((!r8.a.isEmpty()) == false) goto L31;
            CreationFeedComponent r14 = this.this$0;
            CreationFeedComponent.Y2(r14, "uiStateChanged", r14.o.a());
        L31:
            return Unit.INSTANCE;
        L33:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public CreationFeedComponent$initObservers$5(CreationFeedComponent r1, Continuation<? super CreationFeedComponent$initObservers$5> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CreationFeedComponent$initObservers$5(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L16:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        CreationFeedComponent r7 = this.this$0;
        int r2 = CreationFeedComponent.H;
        CreationFeedAbilityImpl r8 = r7.B3();
        if (r8 == null) goto L16;
        StateFlowImpl r9 = r8.b.a;
        if (r9 == null) goto L16;
        AnonymousClass1 r3 = new AnonymousClass1(this.this$0, null);
        this.label = 1;
        if (kotlinx.coroutines.flow.e.i(r9, r3, this) != r0) goto L16;
        return r0;
    }
}
