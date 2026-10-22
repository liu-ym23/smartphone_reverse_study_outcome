package com.larus.dora.obric.device_management.explore;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.dora.device.DoraDevice;
import com.larus.common.baidunavi.api.bean.consts.BaiduNaviStatus;
import com.larus.dora.api.protocol.FlowProtocolAbility;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 12\u00020\u0001:\u00011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u0015J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0019J\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0012J&\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u001fH\u0082@¢\u0006\u0002\u0010 J\u001e\u0010!\u001a\u00020\"2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020$H\u0082@¢\u0006\u0002\u0010%J\u001e\u0010&\u001a\u00020\u001b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020'H\u0082@¢\u0006\u0002\u0010(J\f\u0010)\u001a\u00020\u0013*\u00020\u001dH\u0002J\u0014\u0010*\u001a\u0004\u0018\u00010\u00192\b\u0010+\u001a\u0004\u0018\u00010\u0019H\u0002J\f\u0010,\u001a\u00020-*\u00020.H\u0002J\u0014\u0010/\u001a\u0004\u0018\u0001002\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u00062"}, d2 = {"Lcom/larus/dora/obric/device_management/explore/DoraObricGlassesExploreViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/larus/dora/obric/device_management/explore/DoraObricGlassesExploreUiState;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "load", "", "context", "Landroid/content/Context;", "arguments", "Landroid/os/Bundle;", "introductionPageInfos", "", "Lcom/larus/dora/obric/device_management/explore/DoraObricGlassesIntroductionPageInfo;", "sectionType", "Lcom/larus/dora/obric/device_management/explore/DoraObricGlassesExploreSectionType;", "introductionInitialIndex", "", "itemKey", "", "basicItems", "Lcom/larus/dora/obric/device_management/explore/DoraObricGlassesBasicItem;", "resolveItem", "Lcom/larus/dora/obric/device_management/explore/DoraObricGlassesExploreItem;", "itemSpec", "Lcom/larus/dora/obric/device_management/explore/DoraObricGlassesExploreItemSpec;", "(Landroid/content/Context;Lcom/larus/dora/obric/device_management/explore/DoraObricGlassesExploreSectionType;Lcom/larus/dora/obric/device_management/explore/DoraObricGlassesExploreItemSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveAction", "Lcom/larus/dora/obric/device_management/explore/DoraObricGlassesExploreAction;", "actionSpec", "Lcom/larus/dora/obric/device_management/explore/DoraObricGlassesExploreActionSpec;", "(Landroid/content/Context;Lcom/larus/dora/obric/device_management/explore/DoraObricGlassesExploreActionSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveBasicItem", "Lcom/larus/dora/obric/device_management/explore/DoraObricGlassesBasicItemSpec;", "(Landroid/content/Context;Lcom/larus/dora/obric/device_management/explore/DoraObricGlassesBasicItemSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toPageInfo", "resolveDetailButtonType", "cardContentType", "toIntroductionImage", "Lcom/larus/dora/obric/device_management/explore/DoraObricGlassesIntroductionImage;", "Lcom/larus/dora/obric/device_management/explore/DoraObricGlassesImageResource;", "resolveTargetDevice", "Lcom/bytedance/dora/device/DoraDevice;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraObricGlassesExploreViewModel extends ViewModel {
    public static final a Companion = null;
    private static final String TAG = "DoraObricGlassesExploreViewModel";
    private final kotlinx.coroutines.flow.z0<w0> _state;
    private final i1<w0> state;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.obric.device_management.explore.DoraObricGlassesExploreViewModel$load$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.device_management.explore.DoraObricGlassesExploreViewModel$load$1", f = "DoraObricGlassesExploreViewModel.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {41, 46, 54}, m = "invokeSuspend", n = {"targetDevice", "destination$iv$iv", "sectionSpec", "loadStartTime", "targetDevice", "destination$iv$iv", "sectionSpec", "destination$iv$iv", "loadStartTime"}, s = {"L$0", "L$3", "L$5", "J$0", "L$0", "L$3", "L$5", "L$9", "J$0"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $appContext;
        final /* synthetic */ Bundle $arguments;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        final /* synthetic */ DoraObricGlassesExploreViewModel this$0;

        /* JADX INFO: renamed from: com.larus.dora.obric.device_management.explore.DoraObricGlassesExploreViewModel$load$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.dora.obric.device_management.explore.DoraObricGlassesExploreViewModel$load$1$1", f = "DoraObricGlassesExploreViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C01011 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ List<u0> $sections;
            final /* synthetic */ DoraDevice $targetDevice;
            int label;
            final /* synthetic */ DoraObricGlassesExploreViewModel this$0;

            public C01011(DoraObricGlassesExploreViewModel r1, DoraDevice r2, List<u0> r3, Continuation<? super C01011> r4) {
                this.this$0 = r1;
                this.$targetDevice = r2;
                this.$sections = r3;
                super(2, r4);
            }

            public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
                return new C01011(this.this$0, this.$targetDevice, this.$sections, r5);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r5) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L13;
                ResultKt.throwOnFailure(r5);
                kotlinx.coroutines.flow.z0 r6 = DoraObricGlassesExploreViewModel.access$get_state$p(this.this$0);
                DoraDevice r1 = this.$targetDevice;
                if (r1 == null) goto L7;
                String r2 = r1.mac;
            L8:
                if (r1 == null) goto L10;
                Boxing.boxInt(r1.productId);
            L10:
                r6.setValue(new w0(false, r2, this.$sections));
                return Unit.INSTANCE;
            L7:
                r2 = null;
                goto L8
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public AnonymousClass1(DoraObricGlassesExploreViewModel r1, Bundle r2, Context r3, Continuation<? super AnonymousClass1> r4) {
            this.this$0 = r1;
            this.$arguments = r2;
            this.$appContext = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass1(this.this$0, this.$arguments, this.$appContext, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x07aa -> B:26:0x07bb). Please report as a decompilation issue!!! */
        public final Object invokeSuspend(Object r85) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L12;
            if (r2 == 1) goto L11;
            if (r2 == 2) goto L10;
            if (r2 != 3) goto L9;
            ResultKt.throwOnFailure(r85);
        L32:
            return Unit.INSTANCE;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            long r7 = this.J$0;
            Collection r3 = (Collection) this.L$12;
            Collection r9 = (Collection) this.L$11;
            Iterator r10 = (Iterator) this.L$10;
            Collection r11 = (Collection) this.L$9;
            String r12 = (String) this.L$8;
            DoraObricGlassesExploreSectionType r13 = (DoraObricGlassesExploreSectionType) this.L$7;
            String r14 = (String) this.L$6;
            v0 r15 = (v0) this.L$5;
            Iterator r4 = (Iterator) this.L$4;
            Collection r5 = (Collection) this.L$3;
            DoraObricGlassesExploreViewModel r6 = (DoraObricGlassesExploreViewModel) this.L$2;
            Context r8 = (Context) this.L$1;
            DoraDevice r16 = (DoraDevice) this.L$0;
            ResultKt.throwOnFailure(r85);
            DoraDevice r20 = r16;
            Context r17 = r8;
            String r18 = r14;
            Object r21 = r1;
            String r110 = r12;
            Collection r111 = r5;
            AnonymousClass1 r22 = this;
            Object r0 = r85;
            Iterator r23 = r4;
            DoraObricGlassesExploreSectionType r24 = r13;
            DoraObricGlassesExploreViewModel r112 = r6;
            long r25 = r7;
        L26:
            r9.add((q0) r0);
            Object r26 = r21;
            Iterator r27 = r10;
            r9 = r11;
            Collection r113 = r111;
            DoraObricGlassesExploreViewModel r114 = r112;
            String r115 = r110;
            v0 r86 = r15;
            Context r116 = r17;
            String r117 = r18;
            DoraDevice r118 = r20;
        L21:
            if (r27.hasNext() == false) goto L27;
            r0 r28 = (r0) r27.next();
            Intrinsics.checkNotNull(r116);
            Object r119 = r26;
            DoraObricGlassesExploreSectionType r30 = r86.getType();
            r22.L$0 = r118;
            r22.L$1 = r116;
            r22.L$2 = r114;
            r22.L$3 = r113;
            r22.L$4 = r23;
            Iterator r210 = r23;
            v0 r31 = r86;
            r22.L$5 = r31;
            r22.L$6 = r117;
            r22.L$7 = r24;
            r22.L$8 = r115;
            r22.L$9 = r9;
            r22.L$10 = r27;
            r22.L$11 = r9;
            r22.L$12 = r3;
            r22.J$0 = r25;
            Iterator r87 = r27;
            r22.label = 2;
            r0 = DoraObricGlassesExploreViewModel.access$resolveItem(r114, r116, r30, r28, r22);
            r21 = r119;
            if (r0 != r21) goto L25;
            return r21;
        L25:
            r17 = r116;
            r18 = r117;
            r112 = r114;
            r110 = r115;
            r11 = r9;
            r111 = r113;
            r10 = r87;
            DoraDevice r82 = r118;
            r15 = r31;
            r23 = r210;
            r20 = r82;
            goto L26
        L27:
            r3.add(new u0(r24, r117, r115, (List) r9));
            Object r32 = r26;
            long r33 = r25;
            Collection r34 = r113;
            DoraObricGlassesExploreViewModel r35 = r114;
            Context r120 = r116;
            DoraDevice r121 = r118;
        L14:
            if (r23.hasNext() == false) goto L28;
            v0 r36 = (v0) r23.next();
            DoraObricGlassesExploreSectionType r122 = r36.getType();
            String r123 = r36.b;
            t0 r124 = t0.a;
            Intrinsics.checkNotNull(r120);
            d1 r125 = r36.c;
            r22.L$0 = r121;
            r22.L$1 = r120;
            r22.L$2 = r35;
            r22.L$3 = r34;
            r22.L$4 = r23;
            r22.L$5 = r36;
            r22.L$6 = r123;
            r22.L$7 = r122;
            r22.L$8 = r34;
            r22.L$9 = null;
            r22.L$10 = null;
            r22.L$11 = null;
            r22.L$12 = null;
            r22.J$0 = r33;
            r22.label = 1;
            r124.getClass();
            Object r126 = t0.a(r120, r125);
            if (r126 != r32) goto L18;
            return r32;
        L18:
            r118 = r121;
            r114 = r35;
            Iterator r37 = r23;
            AnonymousClass1 r38 = r22;
            r116 = r120;
            r113 = r34;
            List<r0> r40 = r36.d;
            Object r88 = r32;
            long r127 = r33;
            ArrayList r41 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r40, 10));
            Iterator r42 = r40.iterator();
            r24 = r122;
            r115 = (String) r126;
            r117 = r123;
            r22 = r38;
            r27 = r42;
            r3 = r34;
            r25 = r127;
            r26 = r88;
            r86 = r36;
            r23 = r37;
            r9 = r41;
            goto L21
        L28:
            List r43 = (List) r34;
            g49.d.d(DoraObricGlassesExploreViewModel.TAG, "load explore content finished on worker, cost=" + (SystemClock.elapsedRealtime() - r33) + "ms, sectionCount=" + r43.size());
            MainCoroutineDispatcher r44 = Dispatchers.getMain();
            C01011 r45 = new C01011(r22.this$0, r121, r43, null);
            r22.L$0 = null;
            r22.L$1 = null;
            r22.L$2 = null;
            r22.L$3 = null;
            r22.L$4 = null;
            r22.L$5 = null;
            r22.L$6 = null;
            r22.L$7 = null;
            r22.L$8 = null;
            r22.L$9 = null;
            r22.L$10 = null;
            r22.L$11 = null;
            r22.L$12 = null;
            r22.label = 3;
            if (BuildersKt.withContext(r44, r45, r22) != r32) goto L32;
            return r32;
        L11:
            long r46 = this.J$0;
            Collection r47 = (Collection) this.L$8;
            DoraObricGlassesExploreSectionType r48 = (DoraObricGlassesExploreSectionType) this.L$7;
            String r50 = (String) this.L$6;
            v0 r51 = (v0) this.L$5;
            Iterator r52 = (Iterator) this.L$4;
            Collection r53 = (Collection) this.L$3;
            DoraObricGlassesExploreViewModel r54 = (DoraObricGlassesExploreViewModel) this.L$2;
            Context r128 = (Context) this.L$1;
            DoraDevice r129 = (DoraDevice) this.L$0;
            ResultKt.throwOnFailure(r85);
            r116 = r128;
            r118 = r129;
            r113 = r53;
            r114 = r54;
            List<r0> r55 = r51.d;
            ArrayList r56 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r55, 10));
            Iterator r57 = r55.iterator();
            r24 = r48;
            r115 = (String) r85;
            r117 = r50;
            r22 = this;
            r27 = r57;
            r3 = r47;
            r25 = r46;
            r26 = r1;
            r86 = r51;
            r23 = r52;
            r9 = r56;
            goto L21
        L12:
            ResultKt.throwOnFailure(r85);
            long r58 = SystemClock.elapsedRealtime();
            DoraDevice r60 = DoraObricGlassesExploreViewModel.access$resolveTargetDevice(this.this$0, this.$arguments);
            int r61 = c0.a;
            DoraObricGlassesExploreSectionType r62 = DoraObricGlassesExploreSectionType.WAKEUP;
            d1 r63 = new d1(2131903609);
            r0[] r130 = {new r0("natural_wake", null, new d1(2131903573), new d1(2131903572), c0.e("natural_wake"), c0.d("natural_wake"), null, CollectionsKt.listOf(new d1(2131903589)), CollectionsKt.listOf(new d1(2131903600)), c0.a("//flow/dora/obric_doubao_conversation_settings", 0, 2131903543, null, DoraObricGlassesExploreActionStateType.NATURAL_WAKE, 10), "natural_awaken", null, 8642), new r0("gesture_wake", null, new d1(2131903569), new d1(2131903568), c0.e("gesture_wake"), c0.d("gesture_wake"), new d1(2131903586), CollectionsKt.listOf(new d1(2131903585)), null, null, "gesture_wake", null, 11458), new r0(FlowProtocolAbility.FEATURE_CONVERSATION, null, new d1(2131903565), new d1(2131903564), c0.e(FlowProtocolAbility.FEATURE_CONVERSATION), c0.d(FlowProtocolAbility.FEATURE_CONVERSATION), new d1(2131903583), CollectionsKt.listOf(new d1(2131903582)), null, null, FlowProtocolAbility.FEATURE_CONVERSATION, null, 11458)};
            DoraObricGlassesExploreSectionType r64 = DoraObricGlassesExploreSectionType.MEMORY;
            d1 r65 = new d1(2131903607);
            d1 r66 = new d1(2131903577);
            d1 r131 = new d1(2131903576);
            x0 r67 = c0.e("note");
            x0 r68 = c0.d("note");
            List r610 = CollectionsKt.listOf(new d1(2131903591));
            d1[] r132 = {new d1(2131903599), new d1(2131903601)};
            d1 r70 = new d1(2131903579);
            d1 r71 = new d1(2131903578);
            x0 r510 = c0.e("record");
            x0 r511 = c0.d("record");
            List r512 = CollectionsKt.listOf(new d1(2131903592));
            List r513 = CollectionsKt.listOf(new d1[]{new d1(2131903602), new d1(2131903603)});
            Unit r133 = Unit.INSTANCE;
            List r72 = CollectionsKt.listOf(new v0[]{new v0(r62, "wakeup", r63, CollectionsKt.listOf(r130)), new v0(r64, "memory", r65, CollectionsKt.listOf(new r0[]{new r0("diary", null, new d1(2131903567), new d1(2131903566), c0.e("diary"), c0.d("diary"), null, CollectionsKt.listOf(new d1(2131903584)), null, c0.a("//flow/dora/obric_g_env_observe", 0, 2131903543, null, DoraObricGlassesExploreActionStateType.DIARY, 10), "diary", null, 9666), new r0("quick_note", null, r66, r131, r67, r68, null, r610, CollectionsKt.listOf(r132), null, "note", null, 10690), new r0("record_minutes", null, r70, r71, r510, r511, null, r512, r513, c0.a("//flow/dora/obric_g_gesture_settings?obric_g_gesture_target=button_double_click_options", 2131903548, null, null, null, 24), "record_minutes", null, 8642)})), new v0(DoraObricGlassesExploreSectionType.MORE, "more", new d1(2131903608), CollectionsKt.listOf(new r0[]{new r0("keep_alive", null, new d1(2131903571), new d1(2131903570), c0.e("keep_alive"), c0.d("keep_alive"), new d1(2131903588), CollectionsKt.listOf(new d1(2131903587)), CollectionsKt.listOf(new d1[]{new d1(2131903596), new d1(2131903597)}), null, "keep_alive", null, 10434), new r0("navigation", null, new d1(2131903575), new d1(2131903574), c0.e("navigation"), c0.d("navigation"), null, CollectionsKt.listOf(new d1(2131903590)), CollectionsKt.listOf(new d1[]{new d1(2131903595), new d1(2131903598)}), null, "navigation", null, 10690), new r0("translation", null, new d1(2131903581), new d1(2131903580), c0.e("translation"), c0.d("translation"), new d1(2131903594), CollectionsKt.listOf(new d1(2131903593)), CollectionsKt.listOf(new d1[]{new d1(2131903605), new d1(2131903604)}), c0.a("//flow/dora/o/simul_interpret_detail", 2131903546, null, null, null, 24), "interpretation", null, 8386)})), new v0(DoraObricGlassesExploreSectionType.BASIC, "basic", new d1(2131903606), CollectionsKt.listOf(new r0("basic_operations", DoraObricGlassesExploreDetailType.BASIC_LIST, new d1(2131903553), new d1(2131903552), c0.e("navigation"), null, null, null, null, null, "basic_operation", CollectionsKt.listOf(new z[]{c0.c("media", 2131903559, 2131903558, "media_control", CollectionsKt.listOf(new c1[]{new c1("basic_media_play_pause"), new c1("basic_media_next"), new c1("basic_media_volume")}), CollectionsKt.listOf(new x0[]{c0.b("basic_media_play_pause"), c0.b("basic_media_next"), c0.b("basic_media_volume")}), null, 400), c0.c("camera", 2131903551, 2131903550, "camera", CollectionsKt.listOf(new c1[]{new c1("basic_camera_photo"), new c1("basic_camera_record")}), CollectionsKt.listOf(new x0[]{c0.b("basic_camera_photo"), c0.b("basic_camera_record")}), null, 400), c0.c("volume", 2131903563, 2131903562, "volume", null, CollectionsKt.listOf(c0.b("basic_adaptive_volume")), null, 432), c0.c("connect", 2131903555, 2131903554, "connect_charge", CollectionsKt.listOf(new c1[]{new c1("basic_connect_pairing"), new c1("basic_connect_charge"), new c1("basic_connect_power")}), CollectionsKt.listOf(new x0[]{c0.b("basic_connect_pairing"), c0.b("basic_connect_charge"), c0.b("basic_connect_power")}), null, 400), c0.c("light", 2131903557, 2131903556, "light", CollectionsKt.listOf(new c1[]{new c1("basic_light_color_assistant"), new c1("basic_light_color_earphone"), new c1("basic_light_color_memory"), new c1("basic_light_rhythm_waiting"), new c1("basic_light_rhythm_wakeup"), new c1("basic_light_rhythm_listening"), new c1("basic_light_rhythm_thinking"), new c1("basic_light_rhythm_reply")}), CollectionsKt.listOf(new x0[]{c0.b("basic_light_color_assistant"), c0.b("basic_light_color_earphone"), c0.b("basic_light_color_memory"), c0.b("basic_light_rhythm_waiting"), c0.b("basic_light_rhythm_wakeup"), c0.b("basic_light_rhythm_listening"), c0.b("basic_light_rhythm_thinking"), c0.b("basic_light_rhythm_reply")}), null, 400), c0.c("onboarding", 2131903561, 2131903560, "onboarding", null, null, c0.a("//flow/dora/obric_onboarding", 2131903549, null, MapsKt.mapOf(new Pair[]{TuplesKt.to(DoraObricDeviceHomeViewModel.PARAM_PREVIOUS_PAGE, "explore_home"), TuplesKt.to("current_page", "onboarding"), TuplesKt.to("obric_open_env_observe_after_auth", "false"), TuplesKt.to(DoraObricDeviceHomeViewModel.PARAM_PREVIOUS_PAGE, "explore_home")}), null, 16), BaiduNaviStatus.NO_PERMISSION)}), 4064)))});
            Context r73 = this.$appContext;
            DoraObricGlassesExploreViewModel r74 = this.this$0;
            r34 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r72, 10));
            r23 = r72.iterator();
            r22 = this;
            r120 = r73;
            r35 = r74;
            r32 = r1;
            r33 = r58;
            r121 = r60;
            goto L14
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.obric.device_management.explore.DoraObricGlassesExploreViewModel$resolveAction$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.device_management.explore.DoraObricGlassesExploreViewModel", f = "DoraObricGlassesExploreViewModel.kt", i = {0, 0, 1}, l = {159, 164}, m = "resolveAction", n = {"context", "actionSpec", "actionSpec"}, s = {"L$0", "L$1", "L$0"})
    public static final class C04821 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DoraObricGlassesExploreViewModel this$0;

        public C04821(DoraObricGlassesExploreViewModel r1, Continuation<? super C04821> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return DoraObricGlassesExploreViewModel.access$resolveAction(this.this$0, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.obric.device_management.explore.DoraObricGlassesExploreViewModel$resolveBasicItem$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.device_management.explore.DoraObricGlassesExploreViewModel", f = "DoraObricGlassesExploreViewModel.kt", i = {0, 0, 1, 1, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 6}, l = {177, 181, 186, 189, 192, 195, 197}, m = "resolveBasicItem", n = {"context", "itemSpec", "context", "itemSpec", "context", "itemSpec", "context", "itemSpec", "destination$iv$iv", "context", "itemSpec", "destination$iv$iv", "context", "itemSpec", "itemSpec"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$0"})
    public static final class C04831 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DoraObricGlassesExploreViewModel this$0;

        public C04831(DoraObricGlassesExploreViewModel r1, Continuation<? super C04831> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return DoraObricGlassesExploreViewModel.access$resolveBasicItem(this.this$0, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.obric.device_management.explore.DoraObricGlassesExploreViewModel$resolveItem$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.device_management.explore.DoraObricGlassesExploreViewModel", f = "DoraObricGlassesExploreViewModel.kt", i = {0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 5, 6, 6, 7, 7, 7, 8, 8, 8, 9, 9, 10, 10}, l = {120, 124, 128, 130, 133, 136, 139, 142, 145, 147, 149}, m = "resolveItem", n = {"context", "itemSpec", "context", "itemSpec", "context", "itemSpec", "context", "itemSpec", "context", "itemSpec", "context", "itemSpec", "destination$iv$iv", "context", "itemSpec", "context", "itemSpec", "destination$iv$iv", "context", "itemSpec", "destination$iv$iv", "context", "itemSpec", "context", "destination$iv$iv"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$0", "L$1"})
    public static final class C04841 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
        Object L$15;
        Object L$16;
        Object L$17;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DoraObricGlassesExploreViewModel this$0;

        public C04841(DoraObricGlassesExploreViewModel r1, Continuation<? super C04841> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return DoraObricGlassesExploreViewModel.access$resolveItem(this.this$0, null, null, null, this);
        }
    }

    static {
        Companion = new a();
    }

    public final List<y> basicItems() {
        List<u0> r0 = ((w0) this._state.getValue()).c;
        if (r0 != null) goto L5;
        r0 = CollectionsKt.emptyList();
    L5:
        Iterator<T> r1 = r0.iterator();
    L6:
        List<q0> r2 = null;
        if (r1.hasNext() == false) goto L14;
        Object r3 = r1.next();
        if (((u0) r3).getType() != DoraObricGlassesExploreSectionType.BASIC) goto L11;
        boolean r4 = true;
    L12:
        if (r4 == false) goto L6;
    L15:
        u0 r5 = (u0) r3;
        if (r5 == null) goto L18;
        r2 = r5.c;
    L18:
        if (r2 != null) goto L20;
        r2 = CollectionsKt.emptyList();
    L20:
        ArrayList r6 = new ArrayList();
        Iterator<T> r7 = r2.iterator();
    L22:
        if (r7.hasNext() == false) goto L27;
        List<y> r8 = ((q0) r7.next()).n;
        if (r8 != null) goto L26;
        r8 = CollectionsKt.emptyList();
    L26:
        CollectionsKt.addAll(r6, r8);
        goto L22
    L27:
        return r6;
    L11:
        r4 = false;
        goto L12
    L14:
        r3 = null;
        goto L15
    }

    public DoraObricGlassesExploreViewModel() {
        StateFlowImpl r0 = j1.a(new w0(false, 15));
        this._state = r0;
        this.state = r0;
    }

    public final i1<w0> getState() {
        return this.state;
    }

    public static final /* synthetic */ kotlinx.coroutines.flow.z0 access$get_state$p(DoraObricGlassesExploreViewModel r0) {
        return r0._state;
    }

    private final String resolveDetailButtonType(String r3) {
        if (r3 != null) goto L5;
    L12:
        return null;
    L5:
        if ((!StringsKt.isBlank(r3)) == true) goto L8;
        r3 = null;
    L8:
        if (r3 == null) goto L12;
        return r3.concat("_detail");
    }

    private final DoraDevice resolveTargetDevice(Bundle r9) {
        Object r1 = null;
        if (r9 == null) goto L9;
        String r10 = r9.getString("mac");
        if (r10 == null) goto L9;
        if ((!StringsKt.isBlank(r10)) == false) goto L9;
    L10:
        List r2 = DoraAdapterExtKt.k(kj4.a.g());
        if (r10 != null) goto L13;
    L16:
        boolean r4 = true;
    L17:
        if (r4 == true) goto L33;
        Iterator r5 = r2.iterator();
    L20:
        if (r5.hasNext() == false) goto L29;
        Object r6 = r5.next();
        DoraDevice r7 = (DoraDevice) r6;
        if (Intrinsics.areEqual(r7.mac, r10) == true) goto L24;
    L26:
        boolean r8 = false;
    L27:
        if (r8 == false) goto L20;
    L30:
        DoraDevice r11 = (DoraDevice) r6;
        if (r11 == null) goto L33;
        return r11;
    L24:
        if (com.larus.dora.obric.device_management.device_home.t.a(r7) == false) goto L26;
        r8 = true;
        goto L27
    L29:
        r6 = null;
    L33:
        DoraDevice r12 = DoraAdapterExtKt.h(kj4.a.g());
        if (r12 != null) goto L36;
    L41:
        Iterator r13 = r2.iterator();
    L43:
        if (r13.hasNext() == false) goto L48;
        Object r0 = r13.next();
        if (com.larus.dora.obric.device_management.device_home.t.a((DoraDevice) r0) == false) goto L43;
        r1 = r0;
    L48:
        return (DoraDevice) r1;
    L36:
        if (com.larus.dora.obric.device_management.device_home.t.a(r12) == true) goto L39;
        r12 = null;
    L39:
        if (r12 == null) goto L41;
        return r12;
    L13:
        if (StringsKt.isBlank(r10) == true) goto L16;
        r4 = false;
    L9:
        r10 = null;
        goto L10
    }

    private final z0 toIntroductionImage(DoraObricGlassesImageResource r4) {
        if ((r4 instanceof DoraObricGlassesImageResource.RemoteUrl) == false) goto L6;
        return new z0(((DoraObricGlassesImageResource.RemoteUrl) r4).getUrl(), 0, 2);
    L6:
        if ((r4 instanceof DoraObricGlassesImageResource.Apk) == false) goto L9;
        return new z0(null, ((DoraObricGlassesImageResource.Apk) r4).getResId(), 1);
    L9:
        if ((r4 instanceof DoraObricGlassesImageResource.FileUri) == false) goto L13;
        return new z0(((DoraObricGlassesImageResource.FileUri) r4).getUri().toString(), 0, 2);
    L13:
        throw new NoWhenBranchMatchedException();
    }

    private final a1 toPageInfo(q0 r13) {
        String r0 = r13.i;
        if (r0 != null) goto L5;
        r0 = r13.d;
    L5:
        String r2 = r0;
        DoraObricGlassesImageResource r1 = r13.g;
        if (r1 != null) goto L8;
        r1 = r13.f;
    L8:
        z0 r3 = toIntroductionImage(r1);
        List<String> r4 = r13.j;
        if (r4 != null) goto L11;
    L15:
        r4 = CollectionsKt.listOf(r13.e);
    L16:
        List<String> r5 = r4;
        List<String> r6 = r13.k;
        if (r6 != null) goto L19;
    L23:
        r6 = r13.h;
        if (r6 != null) goto L26;
        r6 = CollectionsKt.emptyList();
    L26:
        List<String> r7 = r6;
        a0 r8 = r13.l;
        if (r8 == null) goto L29;
        y0 r9 = new y0(r8.b, r8.c, r8.a, r8.d, r8.e);
    L30:
        String r10 = r13.m;
        return new a1(r2, r3, r5, r7, r9, r10, resolveDetailButtonType(r10));
    L29:
        r9 = null;
        goto L30
    L19:
        if ((!r6.isEmpty()) == true) goto L22;
        r6 = null;
    L22:
        if (r6 != null) goto L26;
    L11:
        if ((!r4.isEmpty()) == true) goto L14;
        r4 = null;
    L14:
        if (r4 != null) goto L16;
        goto L15
    }

    public final List<a1> introductionPageInfos(DoraObricGlassesExploreSectionType r7) {
        Intrinsics.checkNotNullParameter(r7, "sectionType");
        List<u0> r0 = ((w0) this._state.getValue()).c;
        if (r0 != null) goto L5;
        r0 = CollectionsKt.emptyList();
    L5:
        Iterator<T> r1 = r0.iterator();
    L6:
        List<q0> r4 = null;
        if (r1.hasNext() == false) goto L14;
        Object r2 = r1.next();
        if (((u0) r2).getType() != r7) goto L11;
        boolean r5 = true;
    L12:
        if (r5 == false) goto L6;
    L15:
        u0 r3 = (u0) r2;
        if (r3 == null) goto L18;
        r4 = r3.c;
    L18:
        if (r4 != null) goto L20;
        r4 = CollectionsKt.emptyList();
    L20:
        ArrayList r8 = new ArrayList();
        Iterator<T> r6 = r4.iterator();
    L22:
        if (r6.hasNext() == false) goto L29;
        Object r9 = r6.next();
        if (((q0) r9).c != DoraObricGlassesExploreDetailType.INTRODUCTION) goto L26;
        boolean r10 = true;
    L27:
        if (r10 == false) goto L22;
        r8.add(r9);
        goto L22
    L26:
        r10 = false;
        goto L27
    L29:
        ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator r12 = r8.iterator();
    L31:
        if (r12.hasNext() == false) goto L33;
        r11.add(toPageInfo((q0) r12.next()));
        goto L31
    L33:
        return r11;
    L11:
        r5 = false;
        goto L12
    L14:
        r2 = null;
        goto L15
    }

    public static final /* synthetic */ DoraDevice access$resolveTargetDevice(DoraObricGlassesExploreViewModel r0, Bundle r1) {
        return r0.resolveTargetDevice(r1);
    }

    public final int introductionInitialIndex(DoraObricGlassesExploreSectionType r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "sectionType");
        Intrinsics.checkNotNullParameter(r8, "itemKey");
        List<u0> r0 = ((w0) this._state.getValue()).c;
        if (r0 != null) goto L5;
        r0 = CollectionsKt.emptyList();
    L5:
        Iterator<T> r1 = r0.iterator();
    L6:
        List<q0> r2 = null;
        if (r1.hasNext() == false) goto L14;
        Object r3 = r1.next();
        if (((u0) r3).getType() != r7) goto L11;
        boolean r5 = true;
    L12:
        if (r5 == false) goto L6;
    L15:
        u0 r4 = (u0) r3;
        if (r4 == null) goto L18;
        r2 = r4.c;
    L18:
        if (r2 != null) goto L20;
        r2 = CollectionsKt.emptyList();
    L20:
        ArrayList r9 = new ArrayList();
        Iterator<T> r6 = r2.iterator();
    L22:
        if (r6.hasNext() == false) goto L29;
        Object r10 = r6.next();
        if (((q0) r10).c != DoraObricGlassesExploreDetailType.INTRODUCTION) goto L26;
        boolean r11 = true;
    L27:
        if (r11 == false) goto L22;
        r9.add(r10);
        goto L22
    L26:
        r11 = false;
        goto L27
    L29:
        Iterator r12 = r9.iterator();
        int r13 = 0;
    L31:
        if (r12.hasNext() == false) goto L36;
        if (Intrinsics.areEqual(((q0) r12.next()).a, r8) == true) goto L38;
        r13 = r13 + 1;
    L38:
        return RangesKt.coerceAtLeast(r13, 0);
    L36:
        r13 = -1;
        goto L38
    L11:
        r5 = false;
        goto L12
    L14:
        r3 = null;
        goto L15
    }

    public final void load(Context r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r11, "context");
        Context r13 = r11.getApplicationContext();
        this._state.setValue(new w0(true, 14));
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getDefault(), null, new AnonymousClass1(this, r12, r13, null), 2, null);
    }

    private final Object resolveAction(Context r18, b0 r110, Continuation<? super a0> r20) {
        Context r0 = r18;
        b0 r1 = r110;
        if ((r20 instanceof C04821) == false) goto L7;
        C04821 r3 = (C04821) r20;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        if (r6 == 0) goto L16;
        if (r6 == 1) goto L15;
        if (r6 != 2) goto L14;
        String r7 = (String) r3.L$2;
        String r8 = (String) r3.L$1;
        b0 r9 = (b0) r3.L$0;
        ResultKt.throwOnFailure(r2);
    L25:
        String r12 = r7;
        String r11 = r8;
        String r13 = (String) r2;
        r1 = r9;
    L27:
        Map<String, String> r10 = r1.d;
        if ((!r10.isEmpty()) == false) goto L30;
        Map<String, String> r14 = r10;
    L32:
        return new a0(r11, r12, r13, r14, r1.e);
    L30:
        r14 = null;
        goto L32
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        String r15 = (String) r3.L$2;
        r1 = (b0) r3.L$1;
        Context r16 = (Context) r3.L$0;
        ResultKt.throwOnFailure(r2);
        String r17 = r15;
        r0 = r16;
        Object r21 = r2;
    L19:
        String r22 = (String) r21;
        d1 r111 = r1.c;
        if (r111 == null) goto L26;
        t0 r112 = t0.a;
        r3.L$0 = r1;
        r3.L$1 = r17;
        r3.L$2 = r22;
        r3.label = 2;
        r112.getClass();
        Object r23 = t0.a(r0, r111);
        if (r23 != r5) goto L24;
        return r5;
    L24:
        r9 = r1;
        r8 = r17;
        r2 = r23;
        r7 = r22;
        goto L25
    L26:
        r11 = r17;
        r12 = r22;
        r13 = null;
        goto L27
    L16:
        ResultKt.throwOnFailure(r2);
        r17 = r1.a;
        t0 r24 = t0.a;
        d1 r113 = r1.b;
        r3.L$0 = r0;
        r3.L$1 = r1;
        r3.L$2 = r17;
        r3.label = 1;
        r24.getClass();
        r21 = t0.a(r0, r113);
        if (r21 != r5) goto L19;
        return r5;
    L7:
        r3 = new C04821(this, r20);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x01ea -> B:40:0x01f3). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x0259 -> B:48:0x0263). Please report as a decompilation issue!!! */
    private final Object resolveBasicItem(Context r20, z r21, Continuation<? super y> r22) {
        Context r0 = r20;
        z r1 = r21;
        if ((r22 instanceof C04831) == false) goto L7;
        C04831 r3 = (C04831) r22;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
        DoraObricGlassesExploreViewModel r5 = this;
    L8:
        Object r2 = r3.result;
        Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(r3.label) {
            case 0: goto L19;
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L12;
            default: goto L11;
        };
    L12:
        e1 r7 = (e1) r3.L$7;
        List r8 = (List) r3.L$6;
        List r9 = (List) r3.L$5;
        b1 r10 = (b1) r3.L$4;
        String r11 = (String) r3.L$3;
        String r12 = (String) r3.L$2;
        String r13 = (String) r3.L$1;
        z r14 = (z) r3.L$0;
        ResultKt.throwOnFailure(r2);
    L56:
        List r15 = r8;
        List r16 = r9;
        a0 r17 = (a0) r2;
        z r18 = r14;
        String r110 = r11;
        String r111 = r12;
        String r112 = r13;
    L59:
        return new y(r112, r111, r110, r10, r16, r15, r17, r18.h);
    L13:
        r8 = (List) r3.L$7;
        r9 = (List) r3.L$6;
        b1 r23 = (b1) r3.L$5;
        String r24 = (String) r3.L$4;
        String r25 = (String) r3.L$3;
        r112 = (String) r3.L$2;
        z r113 = (z) r3.L$1;
        Context r114 = (Context) r3.L$0;
        ResultKt.throwOnFailure(r2);
        e1 r26 = (e1) r2;
        String r27 = r24;
        r18 = r113;
        Object r28 = r6;
        C04831 r30 = r3;
        DoraObricGlassesExploreViewModel r31 = r5;
    L50:
        b0 r115 = r18.g;
        if (r115 == null) goto L57;
        r30.L$0 = r18;
        r30.L$1 = r112;
        r30.L$2 = r25;
        r30.L$3 = r27;
        r30.L$4 = r23;
        r30.L$5 = r9;
        r30.L$6 = r8;
        r30.L$7 = r26;
        r30.L$8 = null;
        r30.L$9 = null;
        r30.label = 7;
        r2 = r31.resolveAction(r114, r115, r30);
        if (r2 != r28) goto L55;
        return r28;
    L55:
        r10 = r23;
        r11 = r27;
        r12 = r25;
        r13 = r112;
        r14 = r18;
        goto L56
    L57:
        r15 = r8;
        r16 = r9;
        r17 = null;
        r10 = r23;
        r110 = r27;
        r111 = r25;
        goto L59
    L14:
        Collection r32 = (Collection) r3.L$9;
        r9 = (List) r3.L$8;
        b1 r33 = (b1) r3.L$7;
        String r34 = (String) r3.L$6;
        r25 = (String) r3.L$5;
        r112 = (String) r3.L$4;
        Iterator r116 = (Iterator) r3.L$3;
        Collection r117 = (Collection) r3.L$2;
        r18 = (z) r3.L$1;
        Context r118 = (Context) r3.L$0;
        ResultKt.throwOnFailure(r2);
        String r35 = r34;
        b1 r36 = r33;
        Object r37 = r6;
        C04831 r38 = r3;
        DoraObricGlassesExploreViewModel r40 = r5;
    L48:
        r32.add((DoraObricGlassesImageResource) r2);
        DoraObricGlassesExploreViewModel r41 = r40;
        r3 = r38;
        r6 = r37;
        r23 = r36;
        String r42 = r35;
        r32 = r117;
        r114 = r118;
    L43:
        if (r116.hasNext() == false) goto L49;
        x0 r119 = (x0) r116.next();
        t0 r120 = t0.a;
        r3.L$0 = r114;
        r3.L$1 = r18;
        r3.L$2 = r32;
        r3.L$3 = r116;
        r3.L$4 = r112;
        r3.L$5 = r25;
        r3.L$6 = r42;
        r3.L$7 = r23;
        r3.L$8 = r9;
        r3.L$9 = r32;
        r3.label = 5;
        r120.getClass();
        List r210 = r9;
        Object r43 = BuildersKt.withContext(Dispatchers.getIO(), new DoraObricGlassesExploreResourceProvider$getImage$2(r119, null), r3);
        if (r43 != r6) goto L47;
        return r6;
    L47:
        r35 = r42;
        r118 = r114;
        r117 = r32;
        r36 = r23;
        r37 = r6;
        r38 = r3;
        r40 = r41;
        r2 = r43;
        r9 = r210;
        goto L48
    L49:
        r8 = (List) r32;
        r18.getClass();
        r27 = r42;
        r28 = r6;
        r30 = r3;
        r31 = r41;
        r26 = null;
        goto L50
    L15:
        Collection r44 = (Collection) r3.L$8;
        b1 r45 = (b1) r3.L$7;
        String r46 = (String) r3.L$6;
        r25 = (String) r3.L$5;
        r112 = (String) r3.L$4;
        Iterator r121 = (Iterator) r3.L$3;
        Collection r122 = (Collection) r3.L$2;
        r18 = (z) r3.L$1;
        Context r123 = (Context) r3.L$0;
        ResultKt.throwOnFailure(r2);
        String r47 = r46;
        Object r48 = r6;
        C04831 r50 = r3;
        DoraObricGlassesExploreViewModel r51 = r5;
    L40:
        r44.add((b1) r2);
        r41 = r51;
        r3 = r50;
        r6 = r48;
        String r52 = r47;
        r44 = r122;
    L35:
        if (r121.hasNext() == false) goto L41;
        c1 r124 = (c1) r121.next();
        t0 r125 = t0.a;
        r3.L$0 = r123;
        r3.L$1 = r18;
        r3.L$2 = r44;
        r3.L$3 = r121;
        r3.L$4 = r112;
        r3.L$5 = r25;
        r3.L$6 = r52;
        r3.L$7 = r45;
        r3.L$8 = r44;
        r3.label = 4;
        r125.getClass();
        Object r53 = BuildersKt.withContext(Dispatchers.getIO(), new DoraObricGlassesExploreResourceProvider$getLottie$2(r124, null), r3);
        if (r53 != r6) goto L39;
        return r6;
    L39:
        r122 = r44;
        C04831 r126 = r3;
        r51 = r41;
        r2 = r53;
        r47 = r52;
        r48 = r6;
        r50 = r126;
        goto L40
    L41:
        List<x0> r54 = r18.f;
        r114 = r123;
        b1 r127 = r45;
        r9 = (List) r44;
        r32 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r54, 10));
        r116 = r54.iterator();
        r42 = r52;
        r23 = r127;
        goto L43
    L16:
        String r55 = (String) r3.L$4;
        String r56 = (String) r3.L$3;
        String r57 = (String) r3.L$2;
        z r58 = (z) r3.L$1;
        Context r128 = (Context) r3.L$0;
        ResultKt.throwOnFailure(r2);
    L31:
        b1 r60 = (b1) r2;
    L33:
        List<c1> r129 = r58.e;
        ArrayList r130 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r129, 10));
        r121 = r129.iterator();
        r18 = r58;
        r123 = r128;
        r25 = r56;
        r45 = r60;
        r41 = r5;
        r112 = r57;
        r52 = r55;
        r44 = r130;
        goto L35
    L17:
        String r61 = (String) r3.L$3;
        String r62 = (String) r3.L$2;
        z r63 = (z) r3.L$1;
        Context r64 = (Context) r3.L$0;
        ResultKt.throwOnFailure(r2);
        r128 = r64;
        r58 = r63;
        r57 = r62;
        r56 = r61;
    L26:
        r55 = (String) r2;
        c1 r65 = r58.d;
        if (r65 == null) goto L32;
        t0 r131 = t0.a;
        r3.L$0 = r128;
        r3.L$1 = r58;
        r3.L$2 = r57;
        r3.L$3 = r56;
        r3.L$4 = r55;
        r3.label = 3;
        r131.getClass();
        r2 = BuildersKt.withContext(Dispatchers.getIO(), new DoraObricGlassesExploreResourceProvider$getLottie$2(r65, null), r3);
        if (r2 != r6) goto L31;
        return r6;
    L32:
        r60 = null;
        goto L33
    L18:
        String r66 = (String) r3.L$2;
        r1 = (z) r3.L$1;
        Context r67 = (Context) r3.L$0;
        ResultKt.throwOnFailure(r2);
        String r68 = r66;
        r0 = r67;
        Object r70 = r2;
    L22:
        String r71 = (String) r70;
        t0 r72 = t0.a;
        d1 r132 = r1.c;
        r3.L$0 = r0;
        r3.L$1 = r1;
        r3.L$2 = r68;
        r3.L$3 = r71;
        r3.label = 2;
        r72.getClass();
        Object r73 = t0.a(r0, r132);
        if (r73 != r6) goto L25;
        return r6;
    L25:
        r128 = r0;
        r58 = r1;
        r56 = r71;
        r57 = r68;
        r2 = r73;
        goto L26
    L19:
        ResultKt.throwOnFailure(r2);
        r68 = r1.a;
        t0 r74 = t0.a;
        d1 r75 = r1.b;
        r3.L$0 = r0;
        r3.L$1 = r1;
        r3.L$2 = r68;
        r3.label = 1;
        r74.getClass();
        r70 = t0.a(r0, r75);
        if (r70 != r6) goto L22;
        return r6;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r5 = this;
        r3 = new C04831(r5, r22);
        goto L8
    }

    public static final /* synthetic */ Object access$resolveAction(DoraObricGlassesExploreViewModel r0, Context r1, b0 r2, Continuation r3) {
        return r0.resolveAction(r1, r2, r3);
    }

    public static final /* synthetic */ Object access$resolveBasicItem(DoraObricGlassesExploreViewModel r0, Context r1, z r2, Continuation r3) {
        return r0.resolveBasicItem(r1, r2, r3);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x0400 -> B:51:0x0408). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:66:0x04c5 -> B:67:0x04d4). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:74:0x055d -> B:75:0x0564). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:90:0x0664 -> B:91:0x0677). Please report as a decompilation issue!!! */
    private final Object resolveItem(Context r28, DoraObricGlassesExploreSectionType r210, r0 r30, Continuation<? super q0> r31) {
        Context r0 = r28;
        if ((r31 instanceof C04841) == false) goto L7;
        C04841 r3 = (C04841) r31;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
        DoraObricGlassesExploreViewModel r5 = this;
    L8:
        Object r2 = r3.result;
        Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(r3.label) {
            case 0: goto L23;
            case 1: goto L22;
            case 2: goto L21;
            case 3: goto L20;
            case 4: goto L19;
            case 5: goto L18;
            case 6: goto L17;
            case 7: goto L16;
            case 8: goto L15;
            case 9: goto L14;
            case 10: goto L13;
            case 11: goto L12;
            default: goto L11;
        };
    L12:
        Collection r1 = (Collection) r3.L$17;
        String r7 = (String) r3.L$16;
        a0 r8 = (a0) r3.L$15;
        List r9 = (List) r3.L$14;
        List r10 = (List) r3.L$13;
        String r11 = (String) r3.L$12;
        List r12 = (List) r3.L$11;
        e1 r13 = (e1) r3.L$10;
        DoraObricGlassesImageResource r14 = (DoraObricGlassesImageResource) r3.L$9;
        DoraObricGlassesImageResource r15 = (DoraObricGlassesImageResource) r3.L$8;
        String r16 = (String) r3.L$7;
        String r17 = (String) r3.L$6;
        DoraObricGlassesExploreDetailType r18 = (DoraObricGlassesExploreDetailType) r3.L$5;
        DoraObricGlassesExploreSectionType r20 = (DoraObricGlassesExploreSectionType) r3.L$4;
        String r21 = (String) r3.L$3;
        Iterator r110 = (Iterator) r3.L$2;
        Collection r22 = (Collection) r3.L$1;
        Context r23 = (Context) r3.L$0;
        ResultKt.throwOnFailure(r2);
        String r24 = r7;
        DoraObricGlassesExploreViewModel r25 = r5;
        a0 r26 = r8;
        List r111 = r9;
        String r27 = r16;
        String r112 = r17;
        Collection r32 = r22;
        DoraObricGlassesExploreDetailType r33 = r18;
        String r34 = r21;
        Context r113 = r23;
        Object r114 = r6;
        Collection r35 = r1;
        DoraObricGlassesExploreSectionType r36 = r20;
        List r115 = r10;
        DoraObricGlassesImageResource r37 = r15;
        String r116 = r11;
        DoraObricGlassesImageResource r38 = r14;
    L91:
        r35.add((y) r2);
        C04841 r40 = r3;
        String r41 = r34;
        DoraObricGlassesExploreSectionType r42 = r36;
        DoraObricGlassesExploreDetailType r43 = r33;
        Iterator r44 = r110;
        Object r117 = r114;
        List r45 = r111;
    L86:
        if (r44.hasNext() == false) goto L93;
        r111 = r45;
        z r46 = (z) r44.next();
        r40.L$0 = r113;
        r40.L$1 = r32;
        r40.L$2 = r44;
        r40.L$3 = r41;
        r40.L$4 = r42;
        r40.L$5 = r43;
        r40.L$6 = r112;
        r40.L$7 = r27;
        r40.L$8 = r37;
        r40.L$9 = r38;
        r40.L$10 = r13;
        r40.L$11 = r12;
        r40.L$12 = r116;
        r40.L$13 = r115;
        Iterator r211 = r44;
        r40.L$14 = r111;
        a0 r47 = r26;
        r40.L$15 = r47;
        String r48 = r24;
        r40.L$16 = r48;
        r40.L$17 = r32;
        e1 r118 = r13;
        r40.label = 11;
        DoraObricGlassesExploreViewModel r119 = r25;
        Object r50 = r119.resolveBasicItem(r113, r46, r40);
        C04841 r212 = r40;
        Object r51 = r117;
        if (r50 != r51) goto L90;
        return r51;
    L90:
        r110 = r211;
        r24 = r48;
        r35 = r32;
        r25 = r119;
        r26 = r47;
        r13 = r118;
        r114 = r51;
        r2 = r50;
        r33 = r43;
        r36 = r42;
        r34 = r41;
        r3 = r212;
        goto L91
    L93:
        return new q0(r41, r42, r43, r112, r27, r37, r38, r12, r116, r115, r45, r26, r24, (List) r32);
    L13:
        List r52 = (List) r3.L$13;
        List r53 = (List) r3.L$12;
        String r54 = (String) r3.L$11;
        List r55 = (List) r3.L$10;
        e1 r56 = (e1) r3.L$9;
        DoraObricGlassesImageResource r120 = (DoraObricGlassesImageResource) r3.L$8;
        DoraObricGlassesImageResource r121 = (DoraObricGlassesImageResource) r3.L$7;
        String r122 = (String) r3.L$6;
        String r123 = (String) r3.L$5;
        DoraObricGlassesExploreDetailType r124 = (DoraObricGlassesExploreDetailType) r3.L$4;
        DoraObricGlassesExploreSectionType r125 = (DoraObricGlassesExploreSectionType) r3.L$3;
        String r57 = (String) r3.L$2;
        r0 r58 = (r0) r3.L$1;
        Context r60 = (Context) r3.L$0;
        ResultKt.throwOnFailure(r2);
        r0 r126 = r58;
        DoraObricGlassesExploreViewModel r213 = r5;
        DoraObricGlassesExploreSectionType r61 = r125;
        Object r127 = r2;
        List r62 = r52;
    L82:
        List r128 = r53;
        DoraObricGlassesExploreSectionType r214 = r61;
        DoraObricGlassesExploreDetailType r63 = r124;
        r0 r64 = r126;
        r112 = r123;
        String r129 = r122;
        DoraObricGlassesImageResource r130 = r121;
        DoraObricGlassesImageResource r131 = r120;
        e1 r132 = r56;
        List r65 = r55;
        a0 r66 = (a0) r127;
        r113 = r60;
    L84:
        String r67 = r64.l;
        List<z> r68 = r64.m;
        List r215 = r62;
        ArrayList r70 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r68, 10));
        Iterator r71 = r68.iterator();
        r40 = r3;
        r41 = r57;
        r26 = r66;
        r37 = r130;
        r27 = r129;
        r24 = r67;
        r115 = r128;
        r25 = r213;
        r117 = r6;
        r116 = r54;
        r45 = r215;
        r43 = r63;
        r42 = r214;
        r32 = r70;
        r44 = r71;
        e1 r216 = r132;
        r12 = r65;
        r38 = r131;
        r13 = r216;
        goto L86
    L14:
        Collection r72 = (Collection) r3.L$15;
        List r73 = (List) r3.L$14;
        r54 = (String) r3.L$13;
        List r74 = (List) r3.L$12;
        r56 = (e1) r3.L$11;
        r120 = (DoraObricGlassesImageResource) r3.L$10;
        r121 = (DoraObricGlassesImageResource) r3.L$9;
        r122 = (String) r3.L$8;
        r123 = (String) r3.L$7;
        DoraObricGlassesExploreDetailType r133 = (DoraObricGlassesExploreDetailType) r3.L$6;
        DoraObricGlassesExploreSectionType r134 = (DoraObricGlassesExploreSectionType) r3.L$5;
        String r75 = (String) r3.L$4;
        Iterator r76 = (Iterator) r3.L$3;
        Collection r77 = (Collection) r3.L$2;
        r0 r135 = (r0) r3.L$1;
        Context r78 = (Context) r3.L$0;
        ResultKt.throwOnFailure(r2);
        List r136 = r73;
        r213 = r5;
        Object r137 = r6;
        r63 = r133;
        DoraObricGlassesExploreSectionType r80 = r134;
        Iterator r81 = r76;
        Collection r138 = r77;
        Context r139 = r78;
        Collection r82 = r72;
        r55 = r74;
        r57 = r75;
    L75:
        r82.add((String) r2);
        Iterator r83 = r81;
        r0 r84 = r135;
        Object r140 = r137;
        List r85 = r136;
    L70:
        if (r83.hasNext() == false) goto L76;
        r136 = r85;
        d1 r86 = (d1) r83.next();
        t0 r141 = t0.a;
        r3.L$0 = r139;
        r3.L$1 = r84;
        r3.L$2 = r138;
        r3.L$3 = r83;
        r3.L$4 = r57;
        r3.L$5 = r80;
        r3.L$6 = r63;
        r3.L$7 = r123;
        r3.L$8 = r122;
        r3.L$9 = r121;
        r3.L$10 = r120;
        r3.L$11 = r56;
        r3.L$12 = r55;
        r3.L$13 = r54;
        Iterator r217 = r83;
        r3.L$14 = r136;
        r3.L$15 = r138;
        r3.label = 9;
        r141.getClass();
        r2 = t0.a(r139, r86);
        Object r87 = r140;
        if (r2 != r87) goto L74;
        return r87;
    L74:
        r137 = r87;
        r135 = r84;
        r82 = r138;
        r81 = r217;
        goto L75
    L76:
        r128 = r85;
        Object r88 = r140;
        r62 = (List) r138;
        b0 r142 = r84.k;
        if (r142 == null) goto L83;
        r3.L$0 = r139;
        r3.L$1 = r84;
        r3.L$2 = r57;
        r3.L$3 = r80;
        r3.L$4 = r63;
        r3.L$5 = r123;
        r3.L$6 = r122;
        r3.L$7 = r121;
        r3.L$8 = r120;
        r3.L$9 = r56;
        r3.L$10 = r55;
        r3.L$11 = r54;
        r126 = r84;
        r3.L$12 = r128;
        r3.L$13 = r62;
        r3.L$14 = null;
        r3.L$15 = null;
        r3.label = 10;
        DoraObricGlassesExploreViewModel r90 = r213;
        r127 = r90.resolveAction(r139, r142, r3);
        if (r127 != r88) goto L81;
        return r88;
    L81:
        r213 = r90;
        r53 = r128;
        DoraObricGlassesExploreSectionType r218 = r80;
        r6 = r88;
        r60 = r139;
        r124 = r63;
        r61 = r218;
        goto L82
    L83:
        r214 = r80;
        r113 = r139;
        r6 = r88;
        r112 = r123;
        r129 = r122;
        r130 = r121;
        r131 = r120;
        r132 = r56;
        r65 = r55;
        r66 = null;
        r64 = r84;
        goto L84
    L15:
        Collection r91 = (Collection) r3.L$14;
        String r92 = (String) r3.L$13;
        List r93 = (List) r3.L$12;
        e1 r94 = (e1) r3.L$11;
        DoraObricGlassesImageResource r95 = (DoraObricGlassesImageResource) r3.L$10;
        DoraObricGlassesImageResource r96 = (DoraObricGlassesImageResource) r3.L$9;
        String r143 = (String) r3.L$8;
        String r144 = (String) r3.L$7;
        DoraObricGlassesExploreDetailType r145 = (DoraObricGlassesExploreDetailType) r3.L$6;
        DoraObricGlassesExploreSectionType r146 = (DoraObricGlassesExploreSectionType) r3.L$5;
        String r147 = (String) r3.L$4;
        Iterator r148 = (Iterator) r3.L$3;
        Collection r97 = (Collection) r3.L$2;
        r0 r98 = (r0) r3.L$1;
        Context r100 = (Context) r3.L$0;
        ResultKt.throwOnFailure(r2);
        Context r149 = r100;
        DoraObricGlassesExploreViewModel r150 = r5;
        Iterator r151 = r148;
        Collection r101 = r91;
        String r152 = r92;
        C04841 r102 = r3;
        r0 r103 = r98;
        Object r104 = r2;
        Collection r105 = r97;
    L67:
        r101.add((String) r104);
        r0 r106 = r103;
        Collection r107 = r105;
        r3 = r102;
        DoraObricGlassesExploreSectionType r108 = r146;
        String r109 = r147;
        String r153 = r152;
        r139 = r149;
        Iterator r154 = r151;
        DoraObricGlassesExploreViewModel r155 = r150;
    L62:
        if (r154.hasNext() == false) goto L68;
        Object r219 = r6;
        d1 r156 = (d1) r154.next();
        t0 r157 = t0.a;
        r3.L$0 = r139;
        r3.L$1 = r106;
        r3.L$2 = r107;
        r3.L$3 = r154;
        r3.L$4 = r109;
        r3.L$5 = r108;
        r3.L$6 = r145;
        r3.L$7 = r144;
        r3.L$8 = r143;
        r3.L$9 = r96;
        r3.L$10 = r95;
        r3.L$11 = r94;
        r3.L$12 = r93;
        r3.L$13 = r153;
        r3.L$14 = r107;
        DoraObricGlassesExploreSectionType r220 = r108;
        r3.label = 8;
        r157.getClass();
        Object r158 = t0.a(r139, r156);
        r6 = r219;
        if (r158 != r6) goto L66;
        return r6;
    L66:
        r151 = r154;
        r150 = r155;
        r152 = r153;
        r149 = r139;
        r146 = r220;
        r147 = r109;
        r102 = r3;
        r104 = r158;
        r105 = r107;
        r103 = r106;
        r101 = r105;
        goto L67
    L68:
        DoraObricGlassesExploreSectionType r221 = r108;
        List<d1> r159 = r106.j;
        r0 r160 = r106;
        r138 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r159, 10));
        r83 = r159.iterator();
        r85 = (List) r107;
        r213 = r155;
        r84 = r160;
        r140 = r6;
        r80 = r221;
        e1 r222 = r94;
        r57 = r109;
        r63 = r145;
        r122 = r143;
        r120 = r95;
        r55 = r93;
        r54 = r153;
        r123 = r144;
        r121 = r96;
        r56 = r222;
        goto L70
    L16:
        List r161 = (List) r3.L$10;
        e1 r162 = (e1) r3.L$9;
        DoraObricGlassesImageResource r163 = (DoraObricGlassesImageResource) r3.L$8;
        DoraObricGlassesImageResource r164 = (DoraObricGlassesImageResource) r3.L$7;
        String r165 = (String) r3.L$6;
        String r166 = (String) r3.L$5;
        DoraObricGlassesExploreDetailType r167 = (DoraObricGlassesExploreDetailType) r3.L$4;
        DoraObricGlassesExploreSectionType r168 = (DoraObricGlassesExploreSectionType) r3.L$3;
        String r169 = (String) r3.L$2;
        r0 r170 = (r0) r3.L$1;
        r139 = (Context) r3.L$0;
        ResultKt.throwOnFailure(r2);
        DoraObricGlassesExploreViewModel r171 = r5;
    L58:
        r0 r223 = r170;
        r153 = (String) r2;
        r0 r172 = r223;
    L60:
        List<d1> r173 = r172.i;
        List r224 = r161;
        e1 r225 = r162;
        r0 r174 = r172;
        ArrayList r175 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r173, 10));
        Iterator r176 = r173.iterator();
        r108 = r168;
        r109 = r169;
        r144 = r166;
        r145 = r167;
        r96 = r164;
        r143 = r165;
        r94 = r225;
        r95 = r163;
        r93 = r224;
        r107 = r175;
        r106 = r174;
        r155 = r171;
        r154 = r176;
        goto L62
    L17:
        Collection r177 = (Collection) r3.L$12;
        r162 = (e1) r3.L$11;
        r163 = (DoraObricGlassesImageResource) r3.L$10;
        r164 = (DoraObricGlassesImageResource) r3.L$9;
        r165 = (String) r3.L$8;
        r166 = (String) r3.L$7;
        r167 = (DoraObricGlassesExploreDetailType) r3.L$6;
        r168 = (DoraObricGlassesExploreSectionType) r3.L$5;
        r169 = (String) r3.L$4;
        Iterator r178 = (Iterator) r3.L$3;
        Collection r179 = (Collection) r3.L$2;
        r0 r180 = (r0) r3.L$1;
        Context r181 = (Context) r3.L$0;
        ResultKt.throwOnFailure(r2);
        DoraObricGlassesExploreViewModel r182 = r5;
        Context r183 = r181;
        Collection r184 = r177;
    L51:
        r184.add((String) r2);
        r184 = r179;
        r172 = r180;
        r171 = r182;
        r139 = r183;
    L46:
        if (r178.hasNext() == false) goto L52;
        d1 r185 = (d1) r178.next();
        t0 r186 = t0.a;
        r3.L$0 = r139;
        r3.L$1 = r172;
        r3.L$2 = r184;
        r3.L$3 = r178;
        r3.L$4 = r169;
        r3.L$5 = r168;
        r3.L$6 = r167;
        r3.L$7 = r166;
        r3.L$8 = r165;
        r3.L$9 = r164;
        r3.L$10 = r163;
        r3.L$11 = r162;
        r3.L$12 = r184;
        Iterator r226 = r178;
        r3.label = 6;
        r186.getClass();
        Object r187 = t0.a(r139, r185);
        if (r187 != r6) goto L50;
        return r6;
    L50:
        r178 = r226;
        r182 = r171;
        r180 = r172;
        r2 = r187;
        r183 = r139;
        r179 = r184;
        goto L51
    L52:
        r161 = (List) r184;
        d1 r188 = r172.h;
        if (r188 == null) goto L59;
        t0 r189 = t0.a;
        r3.L$0 = r139;
        r3.L$1 = r172;
        r3.L$2 = r169;
        r3.L$3 = r168;
        r3.L$4 = r167;
        r3.L$5 = r166;
        r3.L$6 = r165;
        r3.L$7 = r164;
        r3.L$8 = r163;
        r3.L$9 = r162;
        r3.L$10 = r161;
        r3.L$11 = null;
        r3.L$12 = null;
        r3.label = 7;
        r189.getClass();
        Object r190 = t0.a(r139, r188);
        if (r190 != r6) goto L57;
        return r6;
    L57:
        r170 = r172;
        r2 = r190;
        r161 = r161;
        goto L58
    L59:
        r153 = null;
        goto L60
    L18:
        DoraObricGlassesImageResource r191 = (DoraObricGlassesImageResource) r3.L$8;
        DoraObricGlassesImageResource r192 = (DoraObricGlassesImageResource) r3.L$7;
        String r193 = (String) r3.L$6;
        String r194 = (String) r3.L$5;
        DoraObricGlassesExploreDetailType r195 = (DoraObricGlassesExploreDetailType) r3.L$4;
        DoraObricGlassesExploreSectionType r196 = (DoraObricGlassesExploreSectionType) r3.L$3;
        String r197 = (String) r3.L$2;
        r0 r198 = (r0) r3.L$1;
        Context r199 = (Context) r3.L$0;
        ResultKt.throwOnFailure(r2);
        e1 r200 = (e1) r2;
    L44:
        List<d1> r1100 = r198.g;
        DoraObricGlassesImageResource r227 = r191;
        ArrayList r1101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1100, 10));
        r178 = r1100.iterator();
        r171 = r5;
        r184 = r1101;
        r139 = r199;
        r169 = r197;
        r167 = r195;
        r165 = r193;
        r163 = r227;
        String r228 = r194;
        r164 = r192;
        r162 = r200;
        r172 = r198;
        r168 = r196;
        r166 = r228;
        goto L46
    L19:
        DoraObricGlassesImageResource r201 = (DoraObricGlassesImageResource) r3.L$7;
        String r202 = (String) r3.L$6;
        String r203 = (String) r3.L$5;
        DoraObricGlassesExploreDetailType r204 = (DoraObricGlassesExploreDetailType) r3.L$4;
        DoraObricGlassesExploreSectionType r205 = (DoraObricGlassesExploreSectionType) r3.L$3;
        String r206 = (String) r3.L$2;
        r0 r1102 = (r0) r3.L$1;
        Context r1103 = (Context) r3.L$0;
        ResultKt.throwOnFailure(r2);
    L40:
        DoraObricGlassesImageResource r207 = (DoraObricGlassesImageResource) r2;
        r199 = r1103;
    L41:
        r198 = r1102;
        r197 = r206;
        r196 = r205;
        r195 = r204;
        r194 = r203;
        r193 = r202;
        r192 = r201;
        r198.getClass();
        r191 = r207;
        r200 = null;
        goto L44
    L20:
        String r208 = (String) r3.L$6;
        String r209 = (String) r3.L$5;
        DoraObricGlassesExploreDetailType r229 = (DoraObricGlassesExploreDetailType) r3.L$4;
        DoraObricGlassesExploreSectionType r230 = (DoraObricGlassesExploreSectionType) r3.L$3;
        String r231 = (String) r3.L$2;
        r0 r232 = (r0) r3.L$1;
        Context r1104 = (Context) r3.L$0;
        ResultKt.throwOnFailure(r2);
        r1103 = r1104;
        r1102 = r232;
        r206 = r231;
        r205 = r230;
        r204 = r229;
        r203 = r209;
        r202 = r208;
    L35:
        r201 = (DoraObricGlassesImageResource) r2;
        x0 r233 = r1102.f;
        if (r233 == null) goto L42;
        t0 r1105 = t0.a;
        r3.L$0 = r1103;
        r3.L$1 = r1102;
        r3.L$2 = r206;
        r3.L$3 = r205;
        r3.L$4 = r204;
        r3.L$5 = r203;
        r3.L$6 = r202;
        r3.L$7 = r201;
        r3.label = 4;
        r1105.getClass();
        r2 = BuildersKt.withContext(Dispatchers.getIO(), new DoraObricGlassesExploreResourceProvider$getImage$2(r233, null), r3);
        if (r2 != r6) goto L40;
        return r6;
    L42:
        r199 = r1103;
        r207 = null;
        goto L41
    L21:
        String r234 = (String) r3.L$5;
        DoraObricGlassesExploreDetailType r235 = (DoraObricGlassesExploreDetailType) r3.L$4;
        DoraObricGlassesExploreSectionType r236 = (DoraObricGlassesExploreSectionType) r3.L$3;
        String r237 = (String) r3.L$2;
        r0 r238 = (r0) r3.L$1;
        Context r239 = (Context) r3.L$0;
        ResultKt.throwOnFailure(r2);
    L31:
        String r240 = (String) r2;
        t0 r1106 = t0.a;
        x0 r1107 = r238.e;
        r3.L$0 = r239;
        r3.L$1 = r238;
        r3.L$2 = r237;
        r3.L$3 = r236;
        r3.L$4 = r235;
        r3.L$5 = r234;
        r3.L$6 = r240;
        r3.label = 3;
        r1106.getClass();
        Object r1108 = BuildersKt.withContext(Dispatchers.getIO(), new DoraObricGlassesExploreResourceProvider$getImage$2(r1107, null), r3);
        if (r1108 != r6) goto L34;
        return r6;
    L34:
        r1103 = r239;
        r206 = r237;
        r204 = r235;
        r202 = r240;
        r2 = r1108;
        r1102 = r238;
        r205 = r236;
        r203 = r234;
        goto L35
    L22:
        DoraObricGlassesExploreDetailType r241 = (DoraObricGlassesExploreDetailType) r3.L$4;
        DoraObricGlassesExploreSectionType r242 = (DoraObricGlassesExploreSectionType) r3.L$3;
        String r243 = (String) r3.L$2;
        r0 r244 = (r0) r3.L$1;
        Context r245 = (Context) r3.L$0;
        ResultKt.throwOnFailure(r2);
        DoraObricGlassesExploreDetailType r246 = r241;
        r0 = r245;
        String r247 = r243;
    L27:
        String r248 = (String) r2;
        t0 r249 = t0.a;
        d1 r1109 = r244.d;
        r3.L$0 = r0;
        r3.L$1 = r244;
        r3.L$2 = r247;
        r3.L$3 = r242;
        r3.L$4 = r246;
        r3.L$5 = r248;
        r3.label = 2;
        r249.getClass();
        Object r250 = t0.a(r0, r1109);
        if (r250 != r6) goto L30;
        return r6;
    L30:
        r239 = r0;
        r234 = r248;
        r2 = r250;
        DoraObricGlassesExploreDetailType r251 = r246;
        r236 = r242;
        r235 = r251;
        String r252 = r247;
        r238 = r244;
        r237 = r252;
        goto L31
    L23:
        ResultKt.throwOnFailure(r2);
        String r253 = r30.a;
        r246 = r30.b;
        t0 r254 = t0.a;
        d1 r255 = r30.c;
        r3.L$0 = r0;
        r3.L$1 = r30;
        r3.L$2 = r253;
        r3.L$3 = r210;
        r3.L$4 = r246;
        r3.label = 1;
        r254.getClass();
        Object r256 = t0.a(r0, r255);
        if (r256 != r6) goto L26;
        return r6;
    L26:
        r247 = r253;
        r2 = r256;
        r244 = r30;
        r242 = r210;
        goto L27
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r5 = this;
        r3 = new C04841(r5, r31);
        goto L8
    }

    public static final /* synthetic */ Object access$resolveItem(DoraObricGlassesExploreViewModel r0, Context r1, DoraObricGlassesExploreSectionType r2, r0 r3, Continuation r4) {
        return r0.resolveItem(r1, r2, r3, r4);
    }
}
