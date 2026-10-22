package com.larus.bmhome.chat.manager;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.ISettingRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.chat.setting.IUserSettingCacheService;
import com.larus.bmhome.chat.setting.bean.UserConfigKey;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.d1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class ExpertSwitchManager {
    public static final CoroutineScope a = null;
    public static final ISettingRepoService b = null;
    public static final Lazy c = null;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.manager.ExpertSwitchManager$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.manager.ExpertSwitchManager$1", f = "ExpertSwitchManager.kt", i = {}, l = {39}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: renamed from: com.larus.bmhome.chat.manager.ExpertSwitchManager$1$a */
        public static final class a<T> implements FlowCollector {
            public static final a<T> a = null;

            static {
                a = new a();
            }

            public a() {
            }

            public final Object emit(Object r4, Continuation r5) {
                UserConfigKey r6 = (UserConfigKey) r4;
                FLogger.a.d("ExpertSwitchManager", "init userConfigUpdatedFlow:" + r6);
                if (r6 != UserConfigKey.EXPERT_SWITCH) goto L9;
                Object r7 = BuildersKt.withContext(Dispatchers.getMain(), new ExpertSwitchManager$1$1$1(null), r5);
                if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
                return r7;
            L10:
                return Unit.INSTANCE;
            L9:
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass1(Continuation<? super AnonymousClass1> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new AnonymousClass1(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r4);
        L16:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            IUserSettingCacheService r5 = (IUserSettingCacheService) ServiceManager.get().getService(IUserSettingCacheService.class);
            if (r5 == null) goto L18;
            d1 r6 = r5.i();
            if (r6 == null) goto L18;
            FlowCollector r2 = a.a;
            this.label = 1;
            if (r6.collect(r2, this) != r0) goto L16;
            return r0;
        L18:
            return Unit.INSTANCE;
        }
    }

    public ExpertSwitchManager() {
    }

    static {
        CoroutineScope r1 = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault());
        a = r1;
        b = RepoDispatcherDelegate.b.c();
        c = LazyKt.lazy(new f0());
        BuildersKt.launch$default(r1, null, null, new AnonymousClass1(null), 3, null);
    }

    public static final void a() {
        boolean r0 = b.f0();
        Iterator r1 = ((List) c.getValue()).iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        Function1 r2 = (Function1) ((WeakReference) r1.next()).get();
        if (r2 == null) goto L4;
        r2.invoke(Boolean.valueOf(r0));
        goto L4
    }

    public static void b(boolean r6, Function1 r7) {
        BuildersKt.launch$default(a, null, null, new ExpertSwitchManager$updateExpertSwitchState$1(r6, r7, null), 3, null);
    }
}
