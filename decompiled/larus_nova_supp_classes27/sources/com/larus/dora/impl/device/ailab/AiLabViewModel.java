package com.larus.dora.impl.device.ailab;

import android.app.Application;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.dora.annotation.ProductNameType;
import com.bytedance.dora.device.DoraDevice;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.IDoraService;
import com.larus.dora.api.config.IDoraPageConfig;
import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.core.DoraUserManager;
import com.larus.dora.impl.core.o0;
import com.larus.dora.impl.core.x0;
import com.larus.dora.impl.device.ailab.keywords.DoraWakeupKeyword;
import com.larus.dora.impl.device.ailab.keywords.DoraWakeupKeywordsHandler;
import com.larus.dora.impl.network.DoraNetworkApi;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.dora.impl.util.b0;
import com.larus.dora.impl.util.t0;
import com.larus.utils.j0;
import com.mammon.audiosdk.SAMICore;
import com.mammon.audiosdk.enums.SAMICorePropertyId;
import com.mammon.audiosdk.structures.SAMICoreProperty;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.c1;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.g1;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0087\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t*\u0001,\u0018\u0000 R2\u00020\u0001:\u0001RB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u00102\u001a\u000203H\u0014J\u0016\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u00107J\u0006\u00108\u001a\u000203J\u0006\u00109\u001a\u00020\u0013J\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00130;J\u000e\u0010<\u001a\u0002032\u0006\u00106\u001a\u00020\u0013J\u0010\u0010=\u001a\u0002032\b\u0010>\u001a\u0004\u0018\u00010$J\u000e\u0010?\u001a\u0002032\u0006\u0010@\u001a\u00020\u0013J\u000e\u0010A\u001a\u0002032\u0006\u0010@\u001a\u00020\u0013J\u000e\u0010B\u001a\u0002032\u0006\u0010@\u001a\u00020\u0013J\b\u0010C\u001a\u000203H\u0002J\u001e\u0010D\u001a\u00020\u00132\u0006\u0010E\u001a\u00020$2\u0006\u0010F\u001a\u00020GH\u0082@¢\u0006\u0002\u0010HJ\f\u0010I\u001a\u000200*\u00020JH\u0002J\u0016\u0010K\u001a\u0002032\u0006\u0010L\u001a\u00020$2\u0006\u0010M\u001a\u00020\u0013J\u0016\u0010N\u001a\u0002052\u0006\u0010O\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u00107J\u001e\u0010P\u001a\u00020\u00132\u0006\u0010L\u001a\u00020$2\u0006\u0010M\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u0010QR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0017R\u0016\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\nR\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00130\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00130\b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\nR\u0011\u0010\u001f\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0011\u0010!\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b!\u0010 R\u0011\u0010\"\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\"\u0010 R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010%\u001a\u0004\u0018\u00010&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b'\u0010(R\u0010\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0004\n\u0002\u0010-R\u001d\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002000/0\b¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\n¨\u0006S"}, d2 = {"Lcom/larus/dora/impl/device/ailab/AiLabViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_deviceStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/larus/dora/impl/device/ailab/AiLabState;", "deviceStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getDeviceStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "_aiLabActionSharedFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/larus/dora/impl/device/ailab/AiLabAction;", "aiLabActionSharedFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "getAiLabActionSharedFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "_updateMultiUserModeFlow", "", "updateMultiUserModeFlow", "getUpdateMultiUserModeFlow", "_isSupportGestureWakeupContinuousDialogue", "Ljava/lang/Boolean;", "_abilityStateFlow", "Lcom/larus/dora/impl/device/ailab/AiLabAbility;", "abilityStateFlow", "getAbilityStateFlow", "_budsQuickContinuousConversationSwitchStateFlow", "budsQuickContinuousConversationSwitchStateFlow", "getBudsQuickContinuousConversationSwitchStateFlow", "isDoreE", "()Z", "isDoraG", "isDoraLite", "mCurrentDoraDeviceMac", "", "doraPageConfig", "Lcom/larus/dora/api/config/IDoraPageConfig;", "getDoraPageConfig", "()Lcom/larus/dora/api/config/IDoraPageConfig;", "doraPageConfig$delegate", "Lkotlin/Lazy;", "doraLinkCallback", "com/larus/dora/impl/device/ailab/AiLabViewModel$doraLinkCallback$1", "Lcom/larus/dora/impl/device/ailab/AiLabViewModel$doraLinkCallback$1;", "keywordsStateFlow", "", "Lcom/larus/dora/impl/device/ailab/AiLabKeyword;", "getKeywordsStateFlow", "onCleared", "", "setVoiceWakeEnable", "", "enable", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "isMultiUserModeEnabled", "getMultiUserModeStateFlow", "Lkotlinx/coroutines/flow/Flow;", "updateMultiUserModeState", "updateCurrentDoraDeviceMac", "mac", "updatePrecaptureUploadEnable", "isChecked", "updateConvVisualIntentSoundEnable", "updateConvStartEndSoundEnable", "fetchDeviceInfo", "requestDeviceSyncInfo", "key", "value", "", "(Ljava/lang/String;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toAiLabKeyword", "Lcom/larus/dora/impl/device/ailab/keywords/DoraWakeupKeyword;", "updateKeyword", "keyword", "isSelected", "updateNaturalWakeupEnabled", "enabled", "selectKeywordWakeup", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AiLabViewModel extends ViewModel {
    public static final a Companion = null;
    private static final String TAG = "AiLabViewModel";
    private z0<com.larus.dora.impl.device.ailab.a> _abilityStateFlow;
    private final MutableSharedFlow<com.larus.dora.impl.device.ailab.b> _aiLabActionSharedFlow;
    private final z0<Boolean> _budsQuickContinuousConversationSwitchStateFlow;
    private final z0<u> _deviceStateFlow;
    private Boolean _isSupportGestureWakeupContinuousDialogue;
    private final MutableSharedFlow<Boolean> _updateMultiUserModeFlow;
    private final i1<com.larus.dora.impl.device.ailab.a> abilityStateFlow;
    private final d1<com.larus.dora.impl.device.ailab.b> aiLabActionSharedFlow;
    private final i1<Boolean> budsQuickContinuousConversationSwitchStateFlow;
    private final i1<u> deviceStateFlow;
    private final b doraLinkCallback;
    private final Lazy doraPageConfig$delegate;
    private final i1<List<t>> keywordsStateFlow;
    private volatile String mCurrentDoraDeviceMac;
    private final d1<Boolean> updateMultiUserModeFlow;

    public static final class a {
        public a() {
        }
    }

    public static final class b extends t0 {
        public final /* synthetic */ AiLabViewModel a;

        public b(AiLabViewModel r1) {
            this.a = r1;
        }

        public final void onDoraLinkStateChanged(DoraDevice r1, int r2, int r3) {
            super.onDoraLinkStateChanged(r1, r2, r3);
            if (r1 != null) goto L6;
            return;
        L6:
            if (r3 != 2) goto L9;
            this.a.load();
            return;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.ailab.AiLabViewModel$fetchDeviceInfo$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.ailab.AiLabViewModel$fetchDeviceInfo$1", f = "AiLabViewModel.kt", i = {}, l = {296, 314}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;
        final /* synthetic */ AiLabViewModel this$0;

        public AnonymousClass1(AiLabViewModel r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r20) {
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r3 = this.label;
            if (r3 == 0) goto L13;
            if (r3 == 1) goto L12;
            if (r3 != 2) goto L11;
            ResultKt.throwOnFailure(r20);     // Catch: Throwable -> L8
        L48:
            Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L8
        L49:
            Object r0 = Result.constructor-impl(r8);     // Catch: Throwable -> L8
        L54:
            if (Result.exceptionOrNull-impl(r0) == null) goto L58;
            g49.d.d(AiLabViewModel.TAG, "fetch device info failed");
            r0 = Unit.INSTANCE;
        L58:
            if (((Unit) r0) != null) goto L61;
        L59:
            g49.d.d(AiLabViewModel.TAG, "fetch device info failed, device is null");
        L61:
            return Unit.INSTANCE;
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            AiLabViewModel r4 = (AiLabViewModel) this.L$0;
            ResultKt.throwOnFailure(r20);
            Object r7 = ((Result) r20).unbox-impl();
        L20:
            if (Result.isSuccess-impl(r7) == false) goto L52;
            com.larus.dora.impl.network.h r9 = (com.larus.dora.impl.network.h) r7;     // Catch: Throwable -> L8
            g49.d.d(AiLabViewModel.TAG, "fetch device info: " + r9);     // Catch: Throwable -> L8
            IDoraPageConfig r1 = AiLabViewModel.access$getDoraPageConfig(r4);     // Catch: Throwable -> L8
            r8 = null;
            if (r1 == null) goto L49;
            com.larus.dora.impl.network.g r10 = r9.a();     // Catch: Throwable -> L8
            if (r10 == null) goto L48;
            String r11 = r10.g();     // Catch: Throwable -> L8
            if (r11 == null) goto L36;
            Integer r12 = StringsKt.toIntOrNull(r11);     // Catch: Throwable -> L8
            if (r12 == null) goto L36;
            if (r12.intValue() != 1) goto L33;
            boolean r13 = true;
        L34:
            r1.a("dora_g_config_key_precapture_upload_enable", r13);     // Catch: Throwable -> L8
            goto L36
        L33:
            r13 = false;
        L36:
            if ((AiLabViewModel.access$get_deviceStateFlow$p(r4).getValue() instanceof u.b) == false) goto L48;
            String r5 = r10.g();     // Catch: Throwable -> L8
            if (r5 == null) goto L48;
            Integer r6 = StringsKt.toIntOrNull(r5);     // Catch: Throwable -> L8
            if (r6 == null) goto L48;
            int r14 = r6.intValue();     // Catch: Throwable -> L8
            Object r15 = AiLabViewModel.access$get_deviceStateFlow$p(r4).getValue();     // Catch: Throwable -> L8
            Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type com.larus.dora.impl.device.ailab.AiLabState.V1");     // Catch: Throwable -> L8
            u.b r16 = (u.b) r15;     // Catch: Throwable -> L8
            z0 r17 = AiLabViewModel.access$get_deviceStateFlow$p(r4);     // Catch: Throwable -> L8
            if (r14 != 1) goto L44;
            boolean r18 = true;
        L45:
            u.b r21 = u.b.a(r16, false, r18, false, false, 55);     // Catch: Throwable -> L8
            this.L$0 = null;     // Catch: Throwable -> L8
            this.label = 2;     // Catch: Throwable -> L8
            if (r17.emit(r21, this) != r2) goto L48;
            return r2;
        L44:
            r18 = false;
            goto L45
        L52:
            r0 = Result.constructor-impl(r7);
            goto L54
        L13:
            ResultKt.throwOnFailure(r20);
            DoraDevice r22 = kj4.a.g().c();
            if (r22 == null) goto L59;
            AiLabViewModel r23 = this.this$0;
            DoraNetworkApi r24 = DoraNetworkApi.a;
            List<String> r25 = CollectionsKt.listOf("quick_chat_switch");
            this.L$0 = r23;
            this.label = 1;
            Object r26 = r24.x(r22, r25, this);
            if (r26 != r2) goto L18;
            return r2;
        L18:
            r7 = r26;
            r4 = r23;
        L8:
            th = move-exception;
            Result.Companion r27 = Result.Companion;
            r0 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L54
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.ailab.AiLabViewModel$getMultiUserModeStateFlow$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.ailab.AiLabViewModel$getMultiUserModeStateFlow$1", f = "AiLabViewModel.kt", i = {0, 1}, l = {219, 220, 222}, m = "invokeSuspend", n = {"$this$flow", "$this$flow"}, s = {"L$0", "L$0"})
    public static final class C01921 extends SuspendLambda implements Function2<FlowCollector<? super Boolean>, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public C01921(Continuation<? super C01921> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            C01921 r0 = new C01921(r3);
            r0.L$0 = r2;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((FlowCollector) r1, (Continuation) r2);
        }

        public final Object invoke(FlowCollector<? super Boolean> r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L10;
            if (r1 != 3) goto L9;
            ResultKt.throwOnFailure(r6);
        L25:
            return Unit.INSTANCE;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            FlowCollector r2 = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(r6);
        L19:
            Pair r7 = (Pair) r6;
            boolean r3 = ((Boolean) r7.component1()).booleanValue();
            boolean r8 = ((Boolean) r7.component2()).booleanValue();
            if (r3 == false) goto L25;
            Boolean r9 = Boxing.boxBoolean(r8);
            this.L$0 = null;
            this.label = 3;
            if (r2.emit(r9, this) != r0) goto L25;
            return r0;
        L11:
            r2 = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(r6);
        L16:
            DoraUserManager r10 = DoraUserManager.a;
            this.L$0 = r2;
            this.label = 2;
            r6 = r10.c(this);
            if (r6 != r0) goto L19;
            return r0;
        L12:
            ResultKt.throwOnFailure(r6);
            FlowCollector r11 = (FlowCollector) this.L$0;
            DoraUserManager r4 = DoraUserManager.a;
            Boolean r5 = Boxing.boxBoolean(DoraUserManager.b());
            this.L$0 = r11;
            this.label = 1;
            if (r11.emit(r5, this) != r0) goto L15;
            return r0;
        L15:
            r2 = r11;
            goto L16
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.ailab.AiLabViewModel$load$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.ailab.AiLabViewModel$load$1", f = "AiLabViewModel.kt", i = {0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 4, 4, 4, 4, 5, 5, 5, 5, 5, 6}, l = {141, 148, 160, 172, 175, 193, 197, 201}, m = "invokeSuspend", n = {"$this$launch", "device", "$this$launch", "device", "isSupportWakeupGestureUnify", "isSupportWakeupAndVisualSound", "isSupportVisualIntentSound", "isSupportMultiUserModel", "isSupportNaturalWakeup", "voiceWakeEnable", "$this$launch", "device", "voiceWakeEnable", "isSupportDecouplingWakeup", "device", "precaptureUploadEnable", "startEndSoundEnable", "isSupportDecouplingWakeup", "visualIntentSoundEnable", "visualIntentSoundEnable"}, s = {"L$0", "L$1", "L$0", "L$1", "Z$0", "Z$1", "Z$2", "I$0", "I$1", "L$0", "L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "Z$0", "I$0", "I$0"})
    public static final class C01931 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int I$0;
        int I$1;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        boolean Z$0;
        boolean Z$1;
        boolean Z$2;
        int label;
        final /* synthetic */ AiLabViewModel this$0;

        public C01931(AiLabViewModel r1, Continuation<? super C01931> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            C01931 r0 = new C01931(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r21v1 */
        /* JADX WARN: Type inference failed for: r3v20 */
        /* JADX WARN: Type inference failed for: r3v21, types: [int] */
        /* JADX WARN: Type inference failed for: r3v31 */
        public final Object invokeSuspend(Object r23) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            boolean r5 = true;
            switch(this.label) {
                case 0: goto L15;
                case 1: goto L13;
                case 2: goto L12;
                case 3: goto L11;
                case 4: goto L10;
                case 5: goto L9;
                case 6: goto L8;
                case 7: goto L7;
                case 8: goto L6;
                default: goto L5;
            };
        L6:
            ResultKt.throwOnFailure(r23);
        L115:
            AiLabViewModel.access$fetchDeviceInfo(this.this$0);
        L118:
            return Unit.INSTANCE;
        L7:
            boolean r2 = this.Z$2;
            boolean r3 = this.Z$1;
            int r4 = this.I$1;
            boolean r7 = this.Z$0;
            int r8 = this.I$0;
            ResultKt.throwOnFailure(r23);
            boolean r14 = r2;
            boolean r13 = r3;
            int r12 = r4;
            boolean r11 = r7;
            Object r9 = r23;
        L107:
            boolean r15 = ((Boolean) r9).booleanValue();
            if (r8 == 0) goto L110;
            boolean r16 = true;
        L111:
            Object r6 = new u.b(r11, r12, r13, r14, r15, r16);
        L112:
            z0 r10 = AiLabViewModel.access$get_deviceStateFlow$p(this.this$0);
            this.label = 8;
            if (r10.emit(r6, this) != r1) goto L115;
            return r1;
        L110:
            r16 = false;
            goto L111
        L8:
            int r17 = this.I$0;
            boolean r18 = this.Z$0;
            Deferred r20 = (Deferred) this.L$2;
            Boolean r21 = (Boolean) this.L$1;
            DoraDevice r22 = (DoraDevice) this.L$0;
            ResultKt.throwOnFailure(r23);
            Object r24 = r23;
        L103:
            boolean r25 = ((Boolean) r24).booleanValue();
            int r26 = r22.sku;
            boolean r27 = Intrinsics.areEqual(r21, Boxing.boxBoolean(true));
            this.L$0 = null;
            this.L$1 = null;
            this.L$2 = null;
            this.I$0 = r17;
            this.Z$0 = r25;
            this.I$1 = r26;
            this.Z$1 = r18;
            this.Z$2 = r27;
            this.label = 7;
            r9 = r20.await(this);
            if (r9 != r1) goto L106;
            return r1;
        L106:
            r13 = r18;
            r11 = r25;
            r12 = r26;
            r14 = r27;
            r8 = r17;
            goto L107
        L9:
            boolean r28 = this.Z$0;
            Deferred r30 = (Deferred) this.L$2;
            DoraDevice r31 = (DoraDevice) this.L$1;
            CoroutineScope r32 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r23);
            CoroutineScope r110 = r32;
            r22 = r31;
        L91:
            AiLabViewModel r33 = this.this$0;
            Intrinsics.checkNotNullParameter(r22, "<this>");
            AiLabViewModel.access$set_isSupportGestureWakeupContinuousDialogue$p(r33, Boxing.boxBoolean(o59.a.y(r22, "1.1.0.0")));
            IDoraPageConfig r34 = AiLabViewModel.access$getDoraPageConfig(this.this$0);
            if (r34 == null) goto L94;
            boolean r35 = false;
            r21 = Boxing.boxBoolean(r34.d("dora_g_config_key_precapture_upload_enable", false));
        L95:
            IDoraPageConfig r36 = AiLabViewModel.access$getDoraPageConfig(this.this$0);
            if (r36 == null) goto L98;
            ?? r37 = r36.b(r35);
        L99:
            Deferred r38 = BuildersKt.async$default(r110, null, null, new AiLabViewModel$load$1$state$startEndSoundEnable$1(null), 3, null);
            this.L$0 = r22;
            this.L$1 = r21;
            this.L$2 = r38;
            this.Z$0 = r28;
            this.I$0 = r37;
            this.label = 6;
            r24 = r30.await(this);
            if (r24 != r1) goto L102;
            return r1;
        L102:
            r20 = r38;
            ?? r210 = r37;
            r18 = r28;
            r17 = r210 == true ? 1 : 0;
            goto L103
        L98:
            r37 = 0;
            goto L99
        L94:
            r35 = false;
            r21 = null;
            goto L95
        L10:
            ResultKt.throwOnFailure(r23);
            Object r40 = r23;
        L79:
            r6 = new u.c(((Boolean) r40).booleanValue());
            goto L112
        L11:
            Deferred r41 = (Deferred) this.L$0;
            ResultKt.throwOnFailure(r23);
        L64:
            Lazy r42 = DoraWakeupKeywordsHandler.a;
            SAMICoreProperty r43 = new SAMICoreProperty();
            int r44 = ((SAMICore) DoraWakeupKeywordsHandler.a.getValue()).SAMICoreGetPropertyById(SAMICorePropertyId.SAMICorePropertyId_AIS_Ability, r43);
            if (r44 == 0) goto L69;
            r5 = false;
        L69:
            if (r5 == true) goto L71;
            g49.d.b("DoraWakeupKeywordsHandler", "loadKeywords: Fail to get keywords, ret=" + r44);
        L76:
            this.L$0 = null;
            this.label = 4;
            r40 = r41.await(this);
            if (r40 != r1) goto L79;
            return r1;
        L71:
            Object r45 = r43.dataObjectArray[0];
            if ((r45 instanceof String) == false) goto L74;
            String r46 = (String) r45;
        L75:
            g49.d.d("DoraWakeupKeywordsHandler", "loadKeywords: json: " + r46);
            DoraWakeupKeywordsHandler.a(r46, false);
            goto L76
        L74:
            r46 = null;
            goto L75
        L12:
            int r47 = this.I$1;
            int r48 = this.I$0;
            boolean r50 = this.Z$2;
            boolean r51 = this.Z$1;
            boolean r111 = this.Z$0;
            DoraDevice r112 = (DoraDevice) this.L$1;
            CoroutineScope r113 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r23);
            boolean r114 = r50;
            boolean r211 = r51;
        L50:
            Deferred r115 = BuildersKt.async$default(r113, null, null, new AiLabViewModel$load$1$voiceWakeEnable$1(null), 3, null);
            if (r111 == false) goto L80;
            z0 r52 = AiLabViewModel.access$get_abilityStateFlow$p(this.this$0);
            if (r48 == 0) goto L55;
            boolean r116 = true;
        L57:
            if (r47 == 0) goto L59;
            boolean r53 = true;
        L60:
            com.larus.dora.impl.device.ailab.a r117 = new com.larus.dora.impl.device.ailab.a(true, r116, true, r211, r114, r53);
            this.L$0 = r115;
            this.L$1 = null;
            this.label = 3;
            if (r52.emit(r117, this) != r1) goto L63;
            return r1;
        L63:
            r41 = r115;
            goto L64
        L59:
            r53 = false;
            goto L60
        L55:
            r116 = false;
            goto L57
        L80:
            Intrinsics.checkNotNullParameter(r112, "<this>");
            boolean r118 = o59.a.y(r112, "1.2.0.147");
            z0 r119 = AiLabViewModel.access$get_abilityStateFlow$p(this.this$0);
            if (r48 == 0) goto L83;
            boolean r54 = true;
        L84:
            if (r47 == 0) goto L86;
            boolean r55 = true;
        L87:
            boolean r120 = r54;
            DoraDevice r56 = r112;
            CoroutineScope r57 = r113;
            com.larus.dora.impl.device.ailab.a r58 = new com.larus.dora.impl.device.ailab.a(false, r120, r118, r211, r114, r55);
            this.L$0 = r57;
            this.L$1 = r56;
            this.L$2 = r115;
            this.Z$0 = r118;
            this.label = 5;
            if (r119.emit(r58, this) != r1) goto L90;
            return r1;
        L90:
            r28 = r118;
            r110 = r57;
            r22 = r56;
            r30 = r115;
            goto L91
        L86:
            r55 = false;
            goto L87
        L83:
            r54 = false;
            goto L84
        L13:
            DoraDevice r60 = (DoraDevice) this.L$1;
            CoroutineScope r61 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r23);
            Object r62 = r23;
        L14:
            r112 = r60;
            r111 = ((Boolean) r62).booleanValue();
            sk4.e r63 = o0.a;
            boolean r64 = o0.c("soundOpt");
            boolean r65 = o59.a.l(r112);
            if (o59.a.q(r112) == false) goto L23;
        L26:
            int r66 = 1;
        L27:
            IDoraService r121 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
            if (r121 == null) goto L34;
            DeviceService r122 = r121.device();
            if (r122 == null) goto L34;
            if (r122.a() != true) goto L34;
            boolean r123 = true;
        L35:
            if (r123 == true) goto L37;
        L41:
            int r124 = 0;
        L42:
            z0 r125 = AiLabViewModel.access$get_budsQuickContinuousConversationSwitchStateFlow$p(this.this$0);
            if (r124 == 0) goto L45;
            b0.a.getClass();
            boolean r126 = b0.w();
        L46:
            Boolean r127 = Boxing.boxBoolean(r126);
            this.L$0 = r61;
            this.L$1 = r112;
            this.Z$0 = r111;
            this.Z$1 = r64;
            this.Z$2 = r65;
            this.I$0 = r66;
            this.I$1 = r124;
            this.label = 2;
            if (r125.emit(r127, this) != r1) goto L49;
            return r1;
        L49:
            r114 = r65;
            r211 = r64;
            CoroutineScope r212 = r61;
            r48 = r66;
            r47 = r124;
            r113 = r212;
            goto L50
        L45:
            r126 = false;
            goto L46
        L37:
            if (o0.b(r112) == true) goto L41;
            if (o0.c("natural_wakup") == false) goto L41;
            r124 = 1;
        L34:
            r123 = false;
            goto L35
        L23:
            if (o59.a.l(r112) == true) goto L26;
            r66 = 0;
            goto L27
        L15:
            ResultKt.throwOnFailure(r23);
            r61 = (CoroutineScope) this.L$0;
            r60 = DoraAdapterExtKt.h(kj4.a.g());
            if (r60 == null) goto L116;
            sk4.e r67 = o0.a;
            this.L$0 = r61;
            this.L$1 = r60;
            this.label = 1;
            r62 = o0.g();
            if (r62 != r1) goto L14;
            return r1;
        L116:
            g49.d.b(AiLabViewModel.TAG, "load...device is null, ensure not reach here");
            goto L118
        L5:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.ailab.AiLabViewModel$requestDeviceSyncInfo$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.ailab.AiLabViewModel", f = "AiLabViewModel.kt", i = {}, l = {327}, m = "requestDeviceSyncInfo", n = {}, s = {})
    public static final class C01941 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ AiLabViewModel this$0;

        public C01941(AiLabViewModel r1, Continuation<? super C01941> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return AiLabViewModel.access$requestDeviceSyncInfo(this.this$0, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.ailab.AiLabViewModel$selectKeywordWakeup$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.ailab.AiLabViewModel", f = "AiLabViewModel.kt", i = {}, l = {397}, m = "selectKeywordWakeup", n = {}, s = {})
    public static final class C01951 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ AiLabViewModel this$0;

        public C01951(AiLabViewModel r1, Continuation<? super C01951> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.selectKeywordWakeup(null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.ailab.AiLabViewModel$setVoiceWakeEnable$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.ailab.AiLabViewModel", f = "AiLabViewModel.kt", i = {0}, l = {132}, m = "setVoiceWakeEnable", n = {"ret"}, s = {"I$0"})
    public static final class C01961 extends ContinuationImpl {
        int I$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ AiLabViewModel this$0;

        public C01961(AiLabViewModel r1, Continuation<? super C01961> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.setVoiceWakeEnable(false, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.ailab.AiLabViewModel$updateConvStartEndSoundEnable$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.ailab.AiLabViewModel$updateConvStartEndSoundEnable$1", f = "AiLabViewModel.kt", i = {}, l = {284, 286}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01971 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isChecked;
        int label;
        final /* synthetic */ AiLabViewModel this$0;

        public C01971(boolean r1, AiLabViewModel r2, Continuation<? super C01971> r3) {
            this.$isChecked = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01971(this.$isChecked, this.this$0, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r11) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 == 2) goto L9;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r11);
        L33:
            return Unit.INSTANCE;
        L10:
            ResultKt.throwOnFailure(r11);
            kj4.a r12 = kj4.a.g();
            if (this.$isChecked == false) goto L13;
            int r2 = 2;
        L14:
            mj4.f r13 = r12.c;
            int r4 = r13.d.i(1, 4, new byte[]{27, 1, (byte) r2});
            if (r4 != 0) goto L17;
            r13.u = r2;
        L17:
            if (r4 != 0) goto L29;
            Object r14 = AiLabViewModel.access$get_deviceStateFlow$p(this.this$0).getValue();
            if ((r14 instanceof u.b) == false) goto L21;
            u.b r15 = (u.b) r14;
        L22:
            u.b r5 = r15;
            if (r5 == null) goto L25;
            u.b r16 = u.b.a(r5, false, false, this.$isChecked, false, 47);
            z0 r3 = AiLabViewModel.access$get_deviceStateFlow$p(this.this$0);
            this.label = 1;
            if (r3.emit(r16, this) != r0) goto L33;
            return r0;
        L25:
            return Unit.INSTANCE;
        L21:
            r15 = null;
            goto L22
        L29:
            MutableSharedFlow r17 = AiLabViewModel.access$get_aiLabActionSharedFlow$p(this.this$0);
            com.larus.dora.impl.device.ailab.b.C0032b r6 = new com.larus.dora.impl.device.ailab.b.C0032b();
            this.label = 2;
            if (r17.emit(r6, this) != r0) goto L33;
            return r0;
        L13:
            r2 = 1;
            goto L14
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.ailab.AiLabViewModel$updateConvVisualIntentSoundEnable$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.ailab.AiLabViewModel$updateConvVisualIntentSoundEnable$1", f = "AiLabViewModel.kt", i = {}, l = {274}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01981 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isChecked;
        int label;
        final /* synthetic */ AiLabViewModel this$0;

        public C01981(AiLabViewModel r1, boolean r2, Continuation<? super C01981> r3) {
            this.this$0 = r1;
            this.$isChecked = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01981(this.this$0, this.$isChecked, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r10);
        L23:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            IDoraPageConfig r11 = AiLabViewModel.access$getDoraPageConfig(this.this$0);
            if (r11 == null) goto L11;
            r11.i(this.$isChecked);
        L11:
            Object r12 = AiLabViewModel.access$get_deviceStateFlow$p(this.this$0).getValue();
            if ((r12 instanceof u.b) == false) goto L14;
            u.b r13 = (u.b) r12;
        L15:
            u.b r3 = r13;
            if (r3 == null) goto L18;
            u.b r14 = u.b.a(r3, false, false, false, this.$isChecked, 31);
            z0 r2 = AiLabViewModel.access$get_deviceStateFlow$p(this.this$0);
            this.label = 1;
            if (r2.emit(r14, this) != r0) goto L23;
            return r0;
        L18:
            return Unit.INSTANCE;
        L14:
            r13 = null;
            goto L15
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.ailab.AiLabViewModel$updateKeyword$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.ailab.AiLabViewModel$updateKeyword$1", f = "AiLabViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01991 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isSelected;
        final /* synthetic */ String $keyword;
        int label;

        public C01991(String r1, boolean r2, Continuation<? super C01991> r3) {
            this.$keyword = r1;
            this.$isSelected = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01991(this.$keyword, this.$isSelected, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r3);
            Lazy r4 = DoraWakeupKeywordsHandler.a;
            if (DoraWakeupKeywordsHandler.d(this.$keyword, this.$isSelected) == true) goto L8;
            t19.s r5 = t19.s.a;
            Application r0 = AppHost.a.getApplication();
            r5.getClass();
            t19.s.b(r0, 2131904037, false);
        L8:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.ailab.AiLabViewModel$updateMultiUserModeState$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.ailab.AiLabViewModel$updateMultiUserModeState$1", f = "AiLabViewModel.kt", i = {}, l = {233, 234}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02001 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $enable;
        int label;
        final /* synthetic */ AiLabViewModel this$0;

        public C02001(boolean r1, AiLabViewModel r2, Continuation<? super C02001> r3) {
            this.$enable = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C02001(this.$enable, this.this$0, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r5);
        L21:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r5);
        L17:
            boolean r6 = ((Boolean) r5).booleanValue();
            MutableSharedFlow r2 = AiLabViewModel.access$get_updateMultiUserModeFlow$p(this.this$0);
            Boolean r7 = Boxing.boxBoolean(r6);
            this.label = 2;
            if (r2.emit(r7, this) != r0) goto L21;
            return r0;
        L10:
            ResultKt.throwOnFailure(r5);
            DoraUserManager r8 = DoraUserManager.a;
            boolean r9 = DoraUserManager.b();
            boolean r3 = this.$enable;
            if (r9 != r3) goto L14;
            g49.d.d(AiLabViewModel.TAG, "updateMultiUserModeState: enable already " + this.$enable);
            return Unit.INSTANCE;
        L14:
            this.label = 1;
            r5 = DoraUserManager.e(r3, this);
            if (r5 != r0) goto L17;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.ailab.AiLabViewModel$updateNaturalWakeupEnabled$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.ailab.AiLabViewModel", f = "AiLabViewModel.kt", i = {0, 0}, l = {386}, m = "updateNaturalWakeupEnabled", n = {"enabled", "ret"}, s = {"Z$0", "I$0"})
    public static final class C02011 extends ContinuationImpl {
        int I$0;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ AiLabViewModel this$0;

        public C02011(AiLabViewModel r1, Continuation<? super C02011> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.updateNaturalWakeupEnabled(false, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.ailab.AiLabViewModel$updatePrecaptureUploadEnable$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.ailab.AiLabViewModel$updatePrecaptureUploadEnable$1", f = "AiLabViewModel.kt", i = {}, l = {250, 259, 262}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02021 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isChecked;
        int label;
        final /* synthetic */ AiLabViewModel this$0;

        public C02021(AiLabViewModel r1, boolean r2, Continuation<? super C02021> r3) {
            this.this$0 = r1;
            this.$isChecked = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C02021(this.this$0, this.$isChecked, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r13) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L10;
            if (r1 == 3) goto L10;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r13);
        L35:
            return Unit.INSTANCE;
        L11:
            ResultKt.throwOnFailure(r13);
        L23:
            boolean r14 = ((Boolean) r13).booleanValue();
            Object r2 = AiLabViewModel.access$get_deviceStateFlow$p(this.this$0).getValue();
            Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.larus.dora.impl.device.ailab.AiLabState.V1");
            u.b r6 = (u.b) r2;
            if (r14 == false) goto L31;
            g49.d.d(AiLabViewModel.TAG, "updatePrecaptureUploadEnable, success");
            IDoraPageConfig r15 = AiLabViewModel.access$getDoraPageConfig(this.this$0);
            if (r15 == null) goto L28;
            r15.a("dora_g_config_key_precapture_upload_enable", this.$isChecked);
        L28:
            u.b r16 = u.b.a(r6, false, this.$isChecked, false, false, 55);
            z0 r3 = AiLabViewModel.access$get_deviceStateFlow$p(this.this$0);
            this.label = 2;
            if (r3.emit(r16, this) != r0) goto L35;
            return r0;
        L31:
            g49.d.b(AiLabViewModel.TAG, "updatePrecaptureUploadEnable failed");
            MutableSharedFlow r17 = AiLabViewModel.access$get_aiLabActionSharedFlow$p(this.this$0);
            com.larus.dora.impl.device.ailab.b.a r4 = new com.larus.dora.impl.device.ailab.b.a();
            this.label = 3;
            if (r17.emit(r4, this) != r0) goto L35;
            return r0;
        L12:
            ResultKt.throwOnFailure(r13);
            if ((AiLabViewModel.access$get_deviceStateFlow$p(this.this$0).getValue() instanceof u.b) == true) goto L16;
            g49.d.d(AiLabViewModel.TAG, "updatePrecaptureUploadEnable, not V2 state");
            return Unit.INSTANCE;
        L16:
            AiLabViewModel r18 = this.this$0;
            if (this.$isChecked == false) goto L19;
            String r5 = "1";
        L20:
            this.label = 1;
            r13 = AiLabViewModel.access$requestDeviceSyncInfo(r18, "quick_chat_switch", r5, this);
            if (r13 != r0) goto L23;
            return r0;
        L19:
            r5 = "0";
            goto L20
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ IDoraPageConfig yo() {
        return doraPageConfig_delegate$lambda$0();
    }

    private static final IDoraPageConfig doraPageConfig_delegate$lambda$0() {
        return (IDoraPageConfig) ServiceManager.get().getService(IDoraPageConfig.class);
    }

    private final IDoraPageConfig getDoraPageConfig() {
        return (IDoraPageConfig) this.doraPageConfig$delegate.getValue();
    }

    public final Flow<Boolean> getMultiUserModeStateFlow() {
        return kotlinx.coroutines.flow.e.w(new c1(new C01921(null)), Dispatchers.getIO());
    }

    public final boolean isMultiUserModeEnabled() {
        DoraUserManager r0 = DoraUserManager.a;
        return DoraUserManager.b();
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.larus.dora.impl.device.ailab.AiLabViewModel$special$$inlined$filter$1] */
    public AiLabViewModel() {
        StateFlowImpl r0 = j1.a(u.a.a);
        this._deviceStateFlow = r0;
        this.deviceStateFlow = r0;
        MutableSharedFlow<com.larus.dora.impl.device.ailab.b> r3 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._aiLabActionSharedFlow = r3;
        this.aiLabActionSharedFlow = r3;
        MutableSharedFlow<Boolean> r1 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._updateMultiUserModeFlow = r1;
        this.updateMultiUserModeFlow = r1;
        StateFlowImpl r2 = j1.a(null);
        this._abilityStateFlow = r2;
        this.abilityStateFlow = r2;
        StateFlowImpl r4 = j1.a(Boolean.FALSE);
        this._budsQuickContinuousConversationSwitchStateFlow = r4;
        this.budsQuickContinuousConversationSwitchStateFlow = r4;
        this.doraPageConfig$delegate = LazyKt.lazy(new v());
        b r5 = new b(this);
        this.doraLinkCallback = r5;
        final StateFlowImpl r6 = DoraWakeupKeywordsHandler.e;
        final ?? r7 = new AiLabViewModel$special$$inlined$filter$1(r6);
        this.keywordsStateFlow = kotlinx.coroutines.flow.e.F(new AiLabViewModel$special$$inlined$map$1(r7, this), ViewModelKt.getViewModelScope(this), g1.a.a(g1.a, 0, 3), CollectionsKt.emptyList());
        g49.d.d(TAG, "AiLabViewModel init " + hashCode());
        kj4.a.g().registerDoraLinkCallback(r5);
        load();
    }

    private final void fetchDeviceInfo() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(this, null), 2, null);
    }

    public final boolean isDoraG() {
        return o59.a.l(kj4.a.g().c());
    }

    public final boolean isDoraLite() {
        DoraDevice r0 = kj4.a.g().c();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.productId != ProductNameType.DORA_LITE.id) goto L9;
        return true;
    L9:
        return false;
    }

    public final boolean isDoreE() {
        DoraDevice r0 = kj4.a.g().c();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.productId != ProductNameType.DORA_E.id) goto L9;
        return true;
    L9:
        return false;
    }

    public final void load() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C01931(this, null), 2, null);
    }

    public void onCleared() {
        super.onCleared();
        g49.d.d(TAG, "AiLabViewModel onCleared " + hashCode());
        kj4.a.g().unregisterDoraLinkCallback(this.doraLinkCallback);
    }

    public final i1<com.larus.dora.impl.device.ailab.a> getAbilityStateFlow() {
        return this.abilityStateFlow;
    }

    public final d1<com.larus.dora.impl.device.ailab.b> getAiLabActionSharedFlow() {
        return this.aiLabActionSharedFlow;
    }

    public final i1<Boolean> getBudsQuickContinuousConversationSwitchStateFlow() {
        return this.budsQuickContinuousConversationSwitchStateFlow;
    }

    public final i1<u> getDeviceStateFlow() {
        return this.deviceStateFlow;
    }

    public final i1<List<t>> getKeywordsStateFlow() {
        return this.keywordsStateFlow;
    }

    public final d1<Boolean> getUpdateMultiUserModeFlow() {
        return this.updateMultiUserModeFlow;
    }

    public static final /* synthetic */ void access$fetchDeviceInfo(AiLabViewModel r0) {
        r0.fetchDeviceInfo();
    }

    public static final /* synthetic */ IDoraPageConfig access$getDoraPageConfig(AiLabViewModel r0) {
        return r0.getDoraPageConfig();
    }

    public static final /* synthetic */ z0 access$get_abilityStateFlow$p(AiLabViewModel r0) {
        return r0._abilityStateFlow;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_aiLabActionSharedFlow$p(AiLabViewModel r0) {
        return r0._aiLabActionSharedFlow;
    }

    public static final /* synthetic */ z0 access$get_budsQuickContinuousConversationSwitchStateFlow$p(AiLabViewModel r0) {
        return r0._budsQuickContinuousConversationSwitchStateFlow;
    }

    public static final /* synthetic */ z0 access$get_deviceStateFlow$p(AiLabViewModel r0) {
        return r0._deviceStateFlow;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_updateMultiUserModeFlow$p(AiLabViewModel r0) {
        return r0._updateMultiUserModeFlow;
    }

    private final t toAiLabKeyword(DoraWakeupKeyword r13) {
        String r0 = r13.getKeyword();
        Lazy<String> r1 = t.h;
        if (Intrinsics.areEqual(r0, t.a.b()) == false) goto L12;
        int r2 = j0.a;
        String r6 = j0.d(2131902077);
        String r7 = j0.d(2131902076);
        String r8 = t.a.b();
        Integer r14 = r13.getStatus();
        if (r14 != null) goto L8;
    L10:
        boolean r10 = false;
    L34:
        return new t(2131240389, r6, r7, r8, true, r10, true);
    L8:
        if (r14.intValue() != 1) goto L10;
        r10 = true;
        goto L34
    L12:
        Lazy<String> r3 = t.j;
        if (Intrinsics.areEqual(r0, (String) r3.getValue()) == false) goto L22;
        int r4 = j0.a;
        String r9 = j0.d(2131902073);
        String r11 = j0.d(2131902071);
        String r12 = (String) r3.getValue();
        Integer r15 = r13.getStatus();
        if (r15 != null) goto L18;
    L20:
        boolean r16 = false;
    L35:
        return new t(2131240387, r9, r11, r12, false, r16, true);
    L18:
        if (r15.intValue() != 1) goto L20;
        r16 = true;
        goto L35
    L22:
        String r5 = r13.getKeyword();
        if (r5 != null) goto L25;
        r5 = "";
    L25:
        String r17 = r5;
        Integer r18 = r13.getStatus();
        if (r18 != null) goto L29;
    L31:
        boolean r110 = false;
    L33:
        return new t(0, "", "", r17, true, r110, false);
    L29:
        if (r18.intValue() != 1) goto L31;
        r110 = true;
        goto L33
    }

    public final void updateConvStartEndSoundEnable(boolean r7) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C01971(r7, this, null), 2, null);
    }

    public final void updateConvVisualIntentSoundEnable(boolean r7) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C01981(this, r7, null), 2, null);
    }

    public final void updateCurrentDoraDeviceMac(String r1) {
        this.mCurrentDoraDeviceMac = r1;
    }

    public final void updateMultiUserModeState(boolean r7) {
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new C02001(r7, this, null), 3, null);
    }

    public final void updatePrecaptureUploadEnable(boolean r9) {
        g49.d.d(TAG, "updatePrecaptureUploadEnable, isChecked: " + r9);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C02021(this, r9, null), 2, null);
    }

    public static final /* synthetic */ void access$set_isSupportGestureWakeupContinuousDialogue$p(AiLabViewModel r0, Boolean r1) {
        r0._isSupportGestureWakeupContinuousDialogue = r1;
    }

    public static final /* synthetic */ t access$toAiLabKeyword(AiLabViewModel r0, DoraWakeupKeyword r1) {
        return r0.toAiLabKeyword(r1);
    }

    public final Object setVoiceWakeEnable(boolean r12, Continuation<? super Integer> r13) {
        if ((r13 instanceof C01961) == false) goto L7;
        C01961 r0 = (C01961) r13;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        int r15 = r0.I$0;
        ResultKt.throwOnFailure(r14);
    L26:
        int r16 = r15;
    L28:
        return Boxing.boxInt(r16);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        r16 = DoraAdapterExtKt.M(kj4.a.g(), r12);
        if (r16 != 0) goto L28;
        Object r4 = (u) this._deviceStateFlow.getValue();
        if ((r4 instanceof u.b) == false) goto L20;
        r4 = u.b.a((u.b) r4, r12, false, false, false, 62);
    L22:
        z0<u> r17 = this._deviceStateFlow;
        r0.I$0 = r16;
        r0.label = 1;
        if (r17.emit(r4, r0) != r2) goto L25;
        return r2;
    L25:
        r15 = r16;
        goto L26
    L20:
        if ((r4 instanceof u.c) == false) goto L22;
        ((u.c) r4).getClass();
        r4 = new u.c(r12);
    L7:
        r0 = new C01961(this, r13);
        goto L8
    }

    public final void updateKeyword(String r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r9, "keyword");
        g49.d.d(TAG, "updateKeyword: start: keyword=" + r9 + ", isSelected=" + r10);
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new C01991(r9, r10, null), 2, null);
    }

    public final Object updateNaturalWakeupEnabled(boolean r6, Continuation<? super Integer> r7) {
        if ((r7 instanceof C02011) == false) goto L7;
        C02011 r0 = (C02011) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        int r9 = r0.I$0;
        boolean r4 = r0.Z$0;
        ResultKt.throwOnFailure(r8);
        int r10 = r9;
        r6 = r4;
    L19:
        DoraBuryPointManager.J(DoraBuryPointManager.a, "dora_natural_wakeup_settings_change", x0.a(r6), false, 12);
    L21:
        return Boxing.boxInt(r10);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        r10 = kj4.a.g().v(r6);
        if (r10 != 0) goto L21;
        b0.a.getClass();
        b0.M(r6);
        z0<Boolean> r5 = this._budsQuickContinuousConversationSwitchStateFlow;
        Boolean r11 = Boxing.boxBoolean(r6);
        r0.Z$0 = r6;
        r0.I$0 = r10;
        r0.label = 1;
        if (r5.emit(r11, r0) != r2) goto L19;
        return r2;
    L7:
        r0 = new C02011(this, r7);
        goto L8
    }

    private final Object requestDeviceSyncInfo(String r8, Object r9, Continuation<? super Boolean> r10) {
        if ((r10 instanceof C01941) == false) goto L7;
        C01941 r0 = (C01941) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = true;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r11);
        Object r12 = ((Result) r11).unbox-impl();
    L29:
        if (Result.isSuccess-impl(r12) == false) goto L42;
        Long r13 = ((com.larus.dora.impl.network.i) r12).b();     // Catch: Throwable -> L39
        if (r13 != null) goto L34;
    L36:
        r4 = false;
    L37:
        return Boxing.boxBoolean(r4);
    L34:
        if (r13.longValue() != 0) goto L36;
    L39:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r12 = ResultKt.createFailure(th);
    L42:
        if (Result.exceptionOrNull-impl(Result.constructor-impl(r12)) == null) goto L46;
        return Boxing.boxBoolean(false);
    L46:
        throw new KotlinNothingValueException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r11);
        Iterator r15 = kj4.a.g().getDoraBindList().iterator();
    L16:
        if (r15.hasNext() == false) goto L20;
        Object r5 = r15.next();
        if (Intrinsics.areEqual(((DoraDevice) r5).mac, this.mCurrentDoraDeviceMac) == false) goto L16;
    L21:
        DoraDevice r6 = (DoraDevice) r5;
        if (r6 == null) goto L24;
        DoraNetworkApi r16 = DoraNetworkApi.a;
        List<? extends Pair<String, ? extends Object>> r17 = CollectionsKt.listOf(new Pair(r8, r9));
        r0.label = 1;
        r12 = r16.y(r6, r17, r0);
        if (r12 != r2) goto L29;
        return r2;
    L24:
        return Boxing.boxBoolean(false);
    L20:
        r5 = null;
    L7:
        r0 = new C01941(this, r10);
        goto L8
    }

    public final Object selectKeywordWakeup(String r6, boolean r7, Continuation<? super Boolean> r8) {
        if ((r8 instanceof C01951) == false) goto L7;
        C01951 r0 = (C01951) r8;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = false;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r9);
    L25:
        if (((Number) r9).intValue() != 0) goto L28;
        r4 = true;
    L28:
        return Boxing.boxBoolean(r4);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        com.larus.dora.impl.device.ailab.a r10 = (com.larus.dora.impl.device.ailab.a) this.abilityStateFlow.getValue();
        if (r10 != null) goto L17;
    L19:
        boolean r11 = false;
    L20:
        if (r11 == false) goto L30;
        r0.label = 1;
        r9 = updateNaturalWakeupEnabled(false, r0);
        if (r9 != r2) goto L25;
        return r2;
    L30:
        return Boxing.boxBoolean(DoraWakeupKeywordsHandler.d(r6, r7));
    L17:
        if (r10.f != true) goto L19;
        r11 = true;
    L7:
        r0 = new C01951(this, r8);
        goto L8
    }

    public static final /* synthetic */ Object access$requestDeviceSyncInfo(AiLabViewModel r0, String r1, Object r2, Continuation r3) {
        return r0.requestDeviceSyncInfo(r1, r2, r3);
    }
}
