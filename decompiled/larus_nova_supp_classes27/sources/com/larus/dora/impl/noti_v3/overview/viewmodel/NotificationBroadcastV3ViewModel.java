package com.larus.dora.impl.noti_v3.overview.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.larus.dora.api.entity.NotificationRule;
import com.larus.dora.impl.network.s;
import com.larus.dora.impl.nl.DoraUserSettingsManager;
import com.larus.dora.impl.nl.freq.NotificationFreq;
import com.larus.dora.impl.nl.notification_rule.data.DoraNotificationRuleRepo;
import com.larus.dora.impl.util.b0;
import com.larus.platform.service.AccountService;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt__ZipKt$combine$;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\f\u001a\u00020\rJ\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fJ\u0016\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/larus/dora/impl/noti_v3/overview/viewmodel/NotificationBroadcastV3ViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/larus/dora/impl/noti_v3/overview/viewmodel/NotificationBroadcastV3UiState;", "uiState", "getUiState$impl_mainlandRelease", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "ruleCountState", "", "syncSettings", "", "getEnabledServiceIds", "", "", "updateServiceConfig", "serviceId", "isEnabled", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NotificationBroadcastV3ViewModel extends ViewModel {
    private final z0<com.larus.dora.impl.noti_v3.overview.viewmodel.b> _uiState;
    private final z0<Integer> ruleCountState;
    private final z0<com.larus.dora.impl.noti_v3.overview.viewmodel.b> uiState;

    /* JADX INFO: renamed from: com.larus.dora.impl.noti_v3.overview.viewmodel.NotificationBroadcastV3ViewModel$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.noti_v3.overview.viewmodel.NotificationBroadcastV3ViewModel$1", f = "NotificationBroadcastV3ViewModel.kt", i = {}, l = {107}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ NotificationBroadcastV3ViewModel this$0;

        /* JADX INFO: renamed from: com.larus.dora.impl.noti_v3.overview.viewmodel.NotificationBroadcastV3ViewModel$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "Lcom/larus/dora/impl/noti_v3/overview/viewmodel/NotificationBroadcastV3UiState;", "v3Settings", "Lcom/larus/dora/impl/noti_v3/common/model/NotificationBroadcastV3DeviceSettings;", "legacyFreq", "", "appList", "", "Lcom/larus/dora/impl/network/NLAppInfo;", "ruleCount"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.dora.impl.noti_v3.overview.viewmodel.NotificationBroadcastV3ViewModel$1$1", f = "NotificationBroadcastV3ViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00851 extends SuspendLambda implements Function5<q59.a, Integer, List<? extends s>, Integer, Continuation<? super com.larus.dora.impl.noti_v3.overview.viewmodel.b>, Object> {
            /* synthetic */ int I$0;
            /* synthetic */ int I$1;
            /* synthetic */ Object L$0;
            /* synthetic */ Object L$1;
            int label;

            public C00851(Continuation<? super C00851> r2) {
                super(5, r2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r7, Object r8, Object r9, Object r10, Object r11) {
                return invoke((q59.a) r7, ((Number) r8).intValue(), (List) r9, ((Number) r10).intValue(), (Continuation) r11);
            }

            public final Object invoke(q59.a r2, int r3, List<s> r4, int r5, Continuation<? super com.larus.dora.impl.noti_v3.overview.viewmodel.b> r6) {
                C00851 r0 = new C00851(r6);
                r0.L$0 = r2;
                r0.I$0 = r3;
                r0.L$1 = r4;
                r0.I$1 = r5;
                return r0.invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r13) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L175;
                ResultKt.throwOnFailure(r13);
                q59.a r8 = (q59.a) this.L$0;
                int r14 = this.I$0;
                List r0 = (List) this.L$1;
                int r6 = this.I$1;
                String r1 = r8.b;
                if (r1 != null) goto L7;
                r1 = String.valueOf(r14);
            L7:
                int r15 = r1.hashCode();
                if (r15 == 48) goto L28;
                if (r15 == 51) goto L25;
                if (r15 == 1567) goto L21;
                if (r15 == 1629) goto L17;
            L29:
                NotificationFreq.a r16 = NotificationFreq.Companion;
                Integer r2 = StringsKt.toIntOrNull(r1);
                if (r2 == null) goto L32;
                int r3 = r2.intValue();
            L33:
                r16.getClass();
                NotificationFreq[] r17 = NotificationFreq.values();
                int r4 = r17.length;
                int r7 = 0;
            L35:
                if (r7 >= r4) goto L43;
                NotificationFreq r10 = r17[r7];
                if (r10.getFreq() != r3) goto L39;
                boolean r11 = true;
            L40:
                if (r11 == true) goto L44;
                r7 = r7 + 1;
            L44:
                if (r10 == null) goto L46;
                Integer r18 = Boxing.boxInt(r10.getDescResId());
            L48:
                String r5 = r8.a;
                String r9 = "1";
                if (Intrinsics.areEqual(r5, "0") == false) goto L52;
            L57:
                int r12 = 2131902263;
            L58:
                Integer r20 = Boxing.boxInt(r12);
                String r21 = r8.c;
                if (r21 != null) goto L61;
                r21 = "1";
            L61:
                String r22 = r8.d;
                if (r22 == null) goto L65;
                r9 = r22;
            L65:
                List r23 = CollectionsKt.listOf(new String[]{r21, r9, r8.e});
                if ((r23 instanceof Collection) == true) goto L68;
            L70:
                Iterator r24 = r23.iterator();
                int r25 = 0;
            L72:
                if (r24.hasNext() == false) goto L89;
                String r110 = (String) r24.next();
                if (r110 != null) goto L76;
            L79:
                boolean r111 = true;
            L80:
                if (r111 == false) goto L82;
            L84:
                boolean r112 = false;
            L85:
                if (r112 == false) goto L72;
                r25 = r25 + 1;
                if (r25 >= 0) goto L72;
                CollectionsKt.throwCountOverflow();
                goto L72
            L82:
                if (Intrinsics.areEqual(r110, "0") == true) goto L84;
                r112 = true;
                goto L85
            L76:
                if (StringsKt.isBlank(r110) == true) goto L79;
                r111 = false;
            L89:
                String r26 = r8.g;
                if (r26 != null) goto L178;
                List<com.larus.dora.impl.noti_v3.overview.viewmodel.a> r27 = e.a();
                if ((r27 instanceof Collection) == true) goto L94;
            L96:
                Iterator<T> r28 = r27.iterator();
                int r30 = 0;
            L98:
                if (r28.hasNext() == false) goto L104;
                if (((com.larus.dora.impl.noti_v3.overview.viewmodel.a) r28.next()).b() == false) goto L98;
                r30 = r30 + 1;
                if (r30 >= 0) goto L98;
                CollectionsKt.throwCountOverflow();
                goto L98
            L104:
                int r31 = r30;
            L129:
                List r32 = r0;
                if ((r32 instanceof Collection) == true) goto L132;
            L134:
                Iterator r33 = r32.iterator();
                int r34 = 0;
            L136:
                if (r33.hasNext() == false) goto L145;
                if (((s) r33.next()).e() != 2) goto L140;
                boolean r113 = true;
            L141:
                if (r113 == false) goto L136;
                r34 = r34 + 1;
                if (r34 >= 0) goto L136;
                CollectionsKt.throwCountOverflow();
                goto L136
            L140:
                r113 = false;
            L145:
                String r35 = r8.f;
                if (r35 != null) goto L176;
                int r36 = 0;
            L173:
                return new com.larus.dora.impl.noti_v3.overview.viewmodel.b(r20, r18, r25, r31, r34, r6, r36, r8);
            L176:
                Result.Companion r37 = Result.Companion;     // Catch: Throwable -> L166
                List r38 = (List) new Gson().fromJson(r35, new d().getType());     // Catch: Throwable -> L166
                if (r38 == null) goto L163;
                List r40 = r38;     // Catch: Throwable -> L166
                if ((r40 instanceof Collection) == true) goto L153;
            L155:
                Iterator r41 = r40.iterator();     // Catch: Throwable -> L166
                int r42 = 0;
            L157:
                if (r41.hasNext() == false) goto L164;
                if (Intrinsics.areEqual(((y59.a) r41.next()).e(), Boolean.TRUE) == false) goto L157;
                r42 = r42 + 1;     // Catch: Throwable -> L166
                if (r42 >= 0) goto L157;
                CollectionsKt.throwCountOverflow();     // Catch: Throwable -> L166
            L164:
                Object r43 = Result.constructor-impl(Integer.valueOf(r42));     // Catch: Throwable -> L166
            L169:
                if (Result.isFailure-impl(r43) == false) goto L171;
                r43 = 0;
            L171:
                r36 = ((Number) r43).intValue();
                goto L173
            L153:
                if (r40.isEmpty() == false) goto L155;
            L163:
                r42 = 0;
            L166:
                th = move-exception;
                Result.Companion r44 = Result.Companion;
                r43 = Result.constructor-impl(ResultKt.createFailure(th));
                goto L169
            L132:
                if (r32.isEmpty() == false) goto L134;
                r34 = 0;
                goto L145
            L94:
                if (r27.isEmpty() == false) goto L96;
                r31 = 0;
                goto L129
            L178:
                Result.Companion r45 = Result.Companion;     // Catch: Throwable -> L123
                List r46 = (List) new Gson().fromJson(r26, new c().getType());     // Catch: Throwable -> L123
                if (r46 == null) goto L120;
                List r47 = r46;     // Catch: Throwable -> L123
                if ((r47 instanceof Collection) == true) goto L110;
            L112:
                Iterator r48 = r47.iterator();     // Catch: Throwable -> L123
                int r50 = 0;
            L114:
                if (r48.hasNext() == false) goto L121;
                if (((com.larus.dora.impl.noti_v3.overview.viewmodel.a) r48.next()).b() == false) goto L114;
                r50 = r50 + 1;     // Catch: Throwable -> L123
                if (r50 >= 0) goto L114;
                CollectionsKt.throwCountOverflow();     // Catch: Throwable -> L123
            L121:
                Object r51 = Result.constructor-impl(Integer.valueOf(r50));     // Catch: Throwable -> L123
            L126:
                if (Result.isFailure-impl(r51) == false) goto L128;
                r51 = 0;
            L128:
                r31 = ((Number) r51).intValue();
                goto L129
            L110:
                if (r47.isEmpty() == false) goto L112;
            L120:
                r50 = 0;
            L123:
                th = move-exception;
                Result.Companion r52 = Result.Companion;
                r51 = Result.constructor-impl(ResultKt.createFailure(th));
                goto L126
            L68:
                if (r23.isEmpty() == false) goto L70;
                r25 = 0;
                goto L89
            L52:
                if (Intrinsics.areEqual(r5, "1") == true) goto L56;
                String r53 = AccountService.a.getUserId();
                b0.a.getClass();
                if (b0.v(r53) == false) goto L57;
            L56:
                r12 = 2131902261;
                goto L58
            L46:
                r18 = null;
                goto L48
            L39:
                r11 = false;
                goto L40
            L43:
                r10 = null;
                goto L44
            L32:
                r3 = 10;
                goto L33
            L17:
                if (r1.equals("30") == false) goto L29;
                r18 = Boxing.boxInt(2131902273);
                goto L48
            L21:
                if (r1.equals("10") == false) goto L29;
                r18 = Boxing.boxInt(2131902271);
                goto L48
            L25:
                if (r1.equals("3") == false) goto L29;
            L47:
                r18 = Boxing.boxInt(2131902269);
                goto L48
            L28:
                if (r1.equals("0") == true) goto L47;
            L175:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.larus.dora.impl.noti_v3.overview.viewmodel.NotificationBroadcastV3ViewModel$1$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ NotificationBroadcastV3ViewModel a;

            public a(NotificationBroadcastV3ViewModel r1) {
                this.a = r1;
            }

            public final Object emit(Object r1, Continuation r2) {
                z0 r3 = NotificationBroadcastV3ViewModel.access$get_uiState$p(this.a);
                r3.setValue((com.larus.dora.impl.noti_v3.overview.viewmodel.b) r1);
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass1(NotificationBroadcastV3ViewModel r1, Continuation<? super AnonymousClass1> r2) {
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

        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r8);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r8);
            FlowKt__ZipKt$combine$.inlined.combineUnsafe.FlowKt__ZipKt.2 r9 = kotlinx.coroutines.flow.e.k(DoraUserSettingsManager.m, DoraUserSettingsManager.i, DoraUserSettingsManager.k, NotificationBroadcastV3ViewModel.access$getRuleCountState$p(this.this$0), new C00851(null));
            a r2 = new a(this.this$0);
            this.label = 1;
            if (r9.collect(r2, this) != r0) goto L12;
            return r0;
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/larus/dora/impl/noti_v3/overview/viewmodel/NotificationBroadcastV3ViewModel$getEnabledServiceIds$items$1$type$1", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/larus/dora/impl/noti_v3/overview/viewmodel/DoraServiceConfigItem;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a extends TypeToken<List<? extends com.larus.dora.impl.noti_v3.overview.viewmodel.a>> {
        public a() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/larus/dora/impl/noti_v3/overview/viewmodel/NotificationBroadcastV3ViewModel$updateServiceConfig$currentItems$1$type$1", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/larus/dora/impl/noti_v3/overview/viewmodel/DoraServiceConfigItem;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b extends TypeToken<List<? extends com.larus.dora.impl.noti_v3.overview.viewmodel.a>> {
        public b() {
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.noti_v3.overview.viewmodel.NotificationBroadcastV3ViewModel$syncSettings$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.noti_v3.overview.viewmodel.NotificationBroadcastV3ViewModel$syncSettings$1", f = "NotificationBroadcastV3ViewModel.kt", i = {}, l = {117}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03661 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ NotificationBroadcastV3ViewModel this$0;

        public C03661(NotificationBroadcastV3ViewModel r1, Continuation<? super C03661> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C03661(this.this$0, r3);
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
            Object r7 = ((Result) r6).unbox-impl();
        L11:
            NotificationBroadcastV3ViewModel r2 = this.this$0;
            if (Result.isSuccess-impl(r7) == false) goto L28;
            z0 r3 = NotificationBroadcastV3ViewModel.access$getRuleCountState$p(r2);
            List r8 = (List) r7;
            int r4 = 0;
            if ((r8 instanceof Collection) == true) goto L16;
        L18:
            Iterator r9 = r8.iterator();
        L20:
            if (r9.hasNext() == false) goto L26;
            if (Intrinsics.areEqual(((NotificationRule) r9.next()).getStatus(), Boxing.boxBoolean(true)) == false) goto L20;
            r4 = r4 + 1;
            if (r4 >= 0) goto L20;
            CollectionsKt.throwCountOverflow();
        L26:
            r3.setValue(Boxing.boxInt(r4));
            goto L28
        L16:
            if (r8.isEmpty() == false) goto L18;
        L28:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            DoraNotificationRuleRepo r10 = DoraNotificationRuleRepo.a;
            this.label = 1;
            r7 = r10.e(this);
            if (r7 != r0) goto L11;
            return r0;
        }
    }

    public final List<String> getEnabledServiceIds() {
        q59.a r0 = ((com.larus.dora.impl.noti_v3.overview.viewmodel.b) this.uiState.getValue()).h;
        if (r0 == null) goto L5;
        String r1 = r0.g;
    L6:
        if (r1 != null) goto L32;
        List<com.larus.dora.impl.noti_v3.overview.viewmodel.a> r2 = e.a();
    L19:
        ArrayList r3 = new ArrayList();
        Iterator<T> r4 = r2.iterator();
    L21:
        if (r4.hasNext() == false) goto L25;
        Object r5 = r4.next();
        if (((com.larus.dora.impl.noti_v3.overview.viewmodel.a) r5).b() == false) goto L21;
        r3.add(r5);
        goto L21
    L25:
        ArrayList r6 = new ArrayList();
        Iterator r7 = r3.iterator();
    L27:
        if (r7.hasNext() == false) goto L31;
        String r8 = ((com.larus.dora.impl.noti_v3.overview.viewmodel.a) r7.next()).c();
        if (r8 == null) goto L27;
        r6.add(r8);
        goto L27
    L31:
        return r6;
    L32:
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L13
        Type r10 = new a().getType();     // Catch: Throwable -> L13
        List<com.larus.dora.impl.noti_v3.overview.viewmodel.a> r11 = (List) new Gson().fromJson(r1, r10);     // Catch: Throwable -> L13
        if (r11 != null) goto L11;
        r11 = e.a();     // Catch: Throwable -> L13
    L11:
        Object r12 = Result.constructor-impl(r11);     // Catch: Throwable -> L13
    L15:
        List<com.larus.dora.impl.noti_v3.overview.viewmodel.a> r13 = e.a();
        if (Result.isFailure-impl(r12) == false) goto L18;
        r12 = r13;
    L18:
        r2 = (List) r12;
    L13:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    L5:
        r1 = null;
        goto L6
    }

    public final void syncSettings() {
        DoraUserSettingsManager r0 = DoraUserSettingsManager.a;
        DoraUserSettingsManager.i("NotificationBroadcastV3ViewModel.syncSettings");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03661(this, null), 3, null);
    }

    public NotificationBroadcastV3ViewModel() {
        StateFlowImpl r0 = j1.a(new com.larus.dora.impl.noti_v3.overview.viewmodel.b(0));
        this._uiState = r0;
        this.uiState = r0;
        this.ruleCountState = j1.a(0);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, null), 3, null);
    }

    public final z0<com.larus.dora.impl.noti_v3.overview.viewmodel.b> getUiState$impl_mainlandRelease() {
        return this.uiState;
    }

    public static final /* synthetic */ z0 access$getRuleCountState$p(NotificationBroadcastV3ViewModel r0) {
        return r0.ruleCountState;
    }

    public static final /* synthetic */ z0 access$get_uiState$p(NotificationBroadcastV3ViewModel r0) {
        return r0._uiState;
    }

    public final void updateServiceConfig(String r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r7, "serviceId");
        q59.a r0 = ((com.larus.dora.impl.noti_v3.overview.viewmodel.b) this.uiState.getValue()).h;
        if (r0 == null) goto L5;
        String r1 = r0.g;
    L6:
        if (r1 != null) goto L32;
        List<com.larus.dora.impl.noti_v3.overview.viewmodel.a> r2 = e.a();
    L19:
        List r3 = CollectionsKt.toMutableList(r2);
        Iterator r4 = r3.iterator();
        int r5 = 0;
    L21:
        if (r4.hasNext() == false) goto L26;
        if (Intrinsics.areEqual(((com.larus.dora.impl.noti_v3.overview.viewmodel.a) r4.next()).c(), r7) == true) goto L27;
        r5 = r5 + 1;
    L27:
        if (r5 == (-1)) goto L29;
        ListProtector.set(r3, r5, com.larus.dora.impl.noti_v3.overview.viewmodel.a.a((com.larus.dora.impl.noti_v3.overview.viewmodel.a) ListProtector.get(r3, r5), r8));
    L30:
        String r9 = GsonProtectorUtils.toJson(new Gson(), r3);
        DoraUserSettingsManager r10 = DoraUserSettingsManager.a;
        Intrinsics.checkNotNull(r9);
        DoraUserSettingsManager.k("notification_service_config_list", r9, null);
        return;
    L29:
        r3.add(new com.larus.dora.impl.noti_v3.overview.viewmodel.a(r7, r8));
        goto L30
    L26:
        r5 = -1;
        goto L27
    L32:
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L13
        List<com.larus.dora.impl.noti_v3.overview.viewmodel.a> r11 = (List) new Gson().fromJson(r1, new b().getType());     // Catch: Throwable -> L13
        if (r11 != null) goto L11;
        r11 = e.a();     // Catch: Throwable -> L13
    L11:
        Object r12 = Result.constructor-impl(r11);     // Catch: Throwable -> L13
    L15:
        List<com.larus.dora.impl.noti_v3.overview.viewmodel.a> r13 = e.a();
        if (Result.isFailure-impl(r12) == false) goto L18;
        r12 = r13;
    L18:
        r2 = (List) r12;
    L13:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    L5:
        r1 = null;
        goto L6
    }
}
