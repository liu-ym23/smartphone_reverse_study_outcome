package com.obric.assistant.interaction.impl.essentialtask.loading;

import android.app.Activity;
import android.content.Context;
import android.os.Process;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.essentialtask.ExecuteState;
import com.obric.assistant.interaction.api.essentialtask.ExecuteState$Executing;
import com.obric.assistant.interaction.api.essentialtask.ExecuteState$Failed;
import com.obric.assistant.interaction.api.essentialtask.ExecuteState$WaitRetry;
import com.obric.assistant.interaction.api.essentialtask.IEssentialTaskService;
import com.obric.assistant.interaction.api.essentialtask.IEssentialTaskServiceKt;
import com.obric.assistant.interaction.api.essentialtask.IObricLoadingUI;
import com.obric.assistant.interaction.impl.essentialtask.EssentialTaskManager;
import java.util.Iterator;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/assistant/interaction/impl/essentialtask/loading/EssentialTaskLoadingHandler;", "", "<init>", "()V", "TAG", "", "handleLoading", "Lkotlinx/coroutines/Job;", "context", "Landroid/content/Context;", "mainScope", "Lkotlinx/coroutines/CoroutineScope;", "loadingUI", "Lcom/obric/assistant/interaction/api/essentialtask/IObricLoadingUI;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EssentialTaskLoadingHandler {
    public static final EssentialTaskLoadingHandler INSTANCE = null;
    private static final String TAG = "EssentialTaskLoadingHandler";

    /* JADX INFO: renamed from: com.obric.assistant.interaction.impl.essentialtask.loading.EssentialTaskLoadingHandler$handleLoading$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.interaction.impl.essentialtask.loading.EssentialTaskLoadingHandler$handleLoading$1", f = "EssentialTaskLoadingHandler.kt", i = {}, l = {25}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ IObricLoadingUI $loadingUI;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: com.obric.assistant.interaction.impl.essentialtask.loading.EssentialTaskLoadingHandler$handleLoading$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        public static final class C00081<T> implements FlowCollector {
            final /* synthetic */ Context $context;
            final /* synthetic */ IObricLoadingUI $loadingUI;

            public C00081(IObricLoadingUI r1, Context r2) {
                this.$loadingUI = r1;
                this.$context = r2;
            }

            public static /* synthetic */ Unit a() {
                return emit$lambda$0();
            }

            public static /* synthetic */ Unit b() {
                return emit$lambda$2();
            }

            private static final Unit emit$lambda$0() {
                FLogger.a.i(EssentialTaskLoadingHandler.TAG, "close retry");
                EssentialTaskManager.INSTANCE.doRetry();
                return Unit.INSTANCE;
            }

            private static final Unit emit$lambda$2() {
                FLogger.a.i(EssentialTaskLoadingHandler.TAG, "close finish app");
                Iterator<T> r0 = AppHost.a.a().g().iterator();
            L4:
                if (r0.hasNext() == false) goto L6;
                ((Activity) r0.next()).finish();
                goto L4
            L6:
                Process.killProcess(Process.myPid());
                return Unit.INSTANCE;
            }

            public final Object emit(ExecuteState r8, Continuation<? super Unit> r9) {
                FLogger.a.i(EssentialTaskLoadingHandler.TAG, "state is " + r8);
                if ((r8 instanceof ExecuteState.NotStarted) == false) goto L6;
                this.$loadingUI.hideAll();
            L18:
                return Unit.INSTANCE;
            L6:
                if ((r8 instanceof ExecuteState$Executing) == false) goto L9;
                this.$loadingUI.showLoading(r8.getShowText());
                goto L18
            L9:
                if ((r8 instanceof ExecuteState$WaitRetry) == false) goto L12;
                IObricLoadingUI.DefaultImpls.showInfoWithButton$default(this.$loadingUI, r8.getShowText(), this.$context.getString(2131912392), null, new a(), 4, null);
                goto L18
            L12:
                if ((r8 instanceof ExecuteState$Failed) == false) goto L15;
                IObricLoadingUI.DefaultImpls.showInfoWithButton$default(this.$loadingUI, r8.getShowText(), this.$context.getString(2131912031), null, new b(), 4, null);
                goto L18
            L15:
                if ((r8 instanceof ExecuteState.Succeed) == false) goto L20;
                this.$loadingUI.onEssentialTaskFinish();
                goto L18
            L20:
                throw new NoWhenBranchMatchedException();
            }

            public /* bridge */ /* synthetic */ Object emit(Object r1, Continuation r2) {
                return emit((ExecuteState) r1, r2);
            }
        }

        public AnonymousClass1(IObricLoadingUI r1, Context r2, Continuation<? super AnonymousClass1> r3) {
            this.$loadingUI = r1;
            this.$context = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            AnonymousClass1 r0 = new AnonymousClass1(this.$loadingUI, this.$context, r5);
            r0.L$0 = r4;
            return r0;
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
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r6);
        L17:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            CoroutineScope r7 = (CoroutineScope) this.L$0;
            IEssentialTaskService r8 = IEssentialTaskServiceKt.getEssentialTaskServiceDelegate();
            if (r8 == null) goto L18;
            i1 r9 = r8.getExecuteState();
            if (r9 == null) goto L18;
            C00081 r2 = new C00081(this.$loadingUI, this.$context);
            this.label = 1;
            if (r9.collect(r2, this) != r0) goto L17;
            return r0;
        L18:
            FLogger.a.w(EssentialTaskLoadingHandler.TAG, "executeStateFlow is null");
            return Unit.INSTANCE;
        }
    }

    static {
        INSTANCE = new EssentialTaskLoadingHandler();
    }

    private EssentialTaskLoadingHandler() {
    }

    public final Job handleLoading(Context r8, CoroutineScope r9, IObricLoadingUI r10) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "mainScope");
        Intrinsics.checkNotNullParameter(r10, "loadingUI");
        return BuildersKt.launch$default(r9, null, null, new AnonymousClass1(r10, r8, null), 3, null);
    }
}
