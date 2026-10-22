package com.obric.aiproactive.ui.entry;

import android.content.Context;
import android.widget.Toast;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.obric.oui.button.OButton;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiproactive.ui.entry.NowFeedPageFragment$setupStaticViews$7$1", f = "NowFeedPageFragment.kt", i = {}, l = {661, 672}, m = "invokeSuspend", n = {}, s = {})
final class NowFeedPageFragment$setupStaticViews$7$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ OButton $wakeButton;
    Object L$0;
    int label;
    final /* synthetic */ NowFeedPageFragment this$0;

    NowFeedPageFragment$setupStaticViews$7$1(NowFeedPageFragment r3, OButton r4, Continuation<? super NowFeedPageFragment$setupStaticViews$7$1> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        this.$wakeButton = r4;
        super(2, r6);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new NowFeedPageFragment$setupStaticViews$7$1(this.this$0, this.$wakeButton, r5), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((NowFeedPageFragment$setupStaticViews$7$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), NowFeedPageFragment$setupStaticViews$7$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L15;
        if (r1 == 1) goto L12;
        if (r1 != 2) goto L11;
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L8
    L27:
        NowFeedPageFragment.access$setEntryGate$p(this.this$0, AiProactiveEntryGate.ALLOW);     // Catch: Throwable -> L8
        this.this$0.ensurePageDataStarted();     // Catch: Throwable -> L8
        NowFeedPageFragment.access$ensureTodaySensingEventsStarted(this.this$0);     // Catch: Throwable -> L8
        NowFeedPageFragment.access$continueWakeUp(this.this$0);     // Catch: Throwable -> L8
        NowFeedPageFragment.access$setWakeUpInProgress$p(this.this$0, false);
        this.$wakeButton.setEnabled(true);
        return Unit.INSTANCE;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        String r2 = (String) ZeusTransformUtils.preCheckCast(this.L$0, String.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L8
    L20:
        if (n.a(r2, ((Boolean) ZeusTransformUtils.preCheckCast(r13, Boolean.class, "com.obric.memorydata.plugin")).booleanValue()) != WakeUpGate.BLOCK) goto L24;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), this.this$0.getLogTag(), "[WakeUp] blocked because ai proactive db is not ready", null, 4, null);     // Catch: Throwable -> L8
        Toast.makeText((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.this$0.requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(this.this$0.getString(ZeusTransformUtils.mapRes(R.string.proactive_db_preparing, TypedValues.Custom.S_STRING, "proactive_db_preparing")), CharSequence.class, "com.obric.memorydata.plugin"), 0).show();     // Catch: Throwable -> L8
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L8
        NowFeedPageFragment.access$setWakeUpInProgress$p(this.this$0, false);
        this.$wakeButton.setEnabled(true);
        return r14;
    L24:
        com.obric.aiproactive.ui.data.b r15 = this.this$0.getRepository();     // Catch: Throwable -> L8
        Continuation<? super Unit> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
        this.L$0 = null;     // Catch: Throwable -> L8
        this.label = 2;     // Catch: Throwable -> L8
        if (r15.b(r3) != r0) goto L27;
        return r0;
    L15:
        ResultKt.throwOnFailure(r13);
        r2 = AppContext.INSTANCE.getUserId();     // Catch: Throwable -> L8
        com.obric.aiproactive.ui.data.b r6 = this.this$0.getRepository();     // Catch: Throwable -> L8
        Continuation r9 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
        this.L$0 = r2;     // Catch: Throwable -> L8
        this.label = 1;     // Catch: Throwable -> L8
        r13 = com.obric.aiproactive.ui.data.b.a.a(r6, 0, r9, 1, null);     // Catch: Throwable -> L8
        if (r13 != r0) goto L20;
        return r0;
    L8:
        th = move-exception;
        NowFeedPageFragment.access$setWakeUpInProgress$p(this.this$0, false);
        this.$wakeButton.setEnabled(true);
        throw th;
    }
}
