package com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.compose.foundation.widget.FlowSwitchStyle;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.ui.foundation.widget.MmNormalHintSwitchView;
import com.ss.android.lark.officesdk.minutes.ui.foundation.widget.h;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmStandaloneAIInterpretationLanguagePanelView extends FrameLayout {
    public final MmStandaloneAIInterpretationViewModel a;
    public final Function0<Unit> b;
    public final FrameLayout c;
    public final TextView d;
    public final TextView e;
    public final MmNormalHintSwitchView f;
    public final MmStandaloneAIInterpretationLanguageAdapter g;
    public final com.ss.android.lark.officesdk.minutes.ui.style.contract.d h;
    public CoroutineScope i;
    public MmStandaloneAIInterpretationLanguageSide j;
    public List<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c> k;
    public List<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c> l;
    public com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c m;
    public com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c n;
    public Map<String, ? extends MmStandaloneAIInterpretationLanguageDisabledReason> o;
    public Map<String, ? extends MmStandaloneAIInterpretationLanguageDisabledReason> p;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MmStandaloneAIInterpretationLanguageSide.values().length];
            r0[MmStandaloneAIInterpretationLanguageSide.SPOKEN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[MmStandaloneAIInterpretationLanguageSide.TARGET.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation.MmStandaloneAIInterpretationLanguagePanelView$onAttachedToWindow$10, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "side", "Lcom/ss/android/lark/officesdk/minutes/ui/record/standaloneinterpretation/MmStandaloneAIInterpretationLanguageSide;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation.MmStandaloneAIInterpretationLanguagePanelView$onAttachedToWindow$10", f = "MmStandaloneAIInterpretationLanguagePanelView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass10 extends SuspendLambda implements Function2<MmStandaloneAIInterpretationLanguageSide, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ MmStandaloneAIInterpretationLanguagePanelView this$0;

        public AnonymousClass10(MmStandaloneAIInterpretationLanguagePanelView r1, Continuation<? super AnonymousClass10> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass10 r0 = new AnonymousClass10(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public final Object invoke(MmStandaloneAIInterpretationLanguageSide r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((MmStandaloneAIInterpretationLanguageSide) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            MmStandaloneAIInterpretationLanguageSide r3 = (MmStandaloneAIInterpretationLanguageSide) this.L$0;
            MmStandaloneAIInterpretationLanguagePanelView r0 = this.this$0;
            r0.j = r3;
            MmStandaloneAIInterpretationLanguagePanelView.a(r0);
            MmStandaloneAIInterpretationLanguagePanelView.b(this.this$0);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation.MmStandaloneAIInterpretationLanguagePanelView$onAttachedToWindow$12, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "isBilingual", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation.MmStandaloneAIInterpretationLanguagePanelView$onAttachedToWindow$12", f = "MmStandaloneAIInterpretationLanguagePanelView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass12 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
        /* synthetic */ boolean Z$0;
        int label;
        final /* synthetic */ MmStandaloneAIInterpretationLanguagePanelView this$0;

        public AnonymousClass12(MmStandaloneAIInterpretationLanguagePanelView r1, Continuation<? super AnonymousClass12> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass12 r0 = new AnonymousClass12(this.this$0, r4);
            r0.Z$0 = ((Boolean) r3).booleanValue();
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke(((Boolean) r1).booleanValue(), (Continuation) r2);
        }

        public final Object invoke(boolean r1, Continuation<? super Unit> r2) {
            return create(Boolean.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            boolean r3 = this.Z$0;
            this.this$0.f.S5(r3);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation.MmStandaloneAIInterpretationLanguagePanelView$onAttachedToWindow$5, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\n"}, d2 = {"<anonymous>", "", "spokenList", "", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/standaloneinterpretation/MmStandaloneAIInterpretationLanguage;", "targetList", "selectedSpoken", "selectedTarget"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation.MmStandaloneAIInterpretationLanguagePanelView$onAttachedToWindow$5", f = "MmStandaloneAIInterpretationLanguagePanelView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02915 extends SuspendLambda implements Function5<List<? extends com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c>, List<? extends com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c>, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        /* synthetic */ Object L$2;
        /* synthetic */ Object L$3;
        int label;
        final /* synthetic */ MmStandaloneAIInterpretationLanguagePanelView this$0;

        public C02915(MmStandaloneAIInterpretationLanguagePanelView r1, Continuation<? super C02915> r2) {
            this.this$0 = r1;
            super(5, r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3, Object r4, Object r5) {
            return invoke((List) r1, (List) r2, (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c) r3, (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c) r4, (Continuation) r5);
        }

        public final Object invoke(List<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c> r3, List<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c> r4, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r5, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r6, Continuation<? super Unit> r7) {
            C02915 r0 = new C02915(this.this$0, r7);
            r0.L$0 = r3;
            r0.L$1 = r4;
            r0.L$2 = r5;
            r0.L$3 = r6;
            return r0.invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r5);
            List<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c> r6 = (List) this.L$0;
            List<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c> r0 = (List) this.L$1;
            com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r1 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c) this.L$2;
            com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r2 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c) this.L$3;
            MmStandaloneAIInterpretationLanguagePanelView r3 = this.this$0;
            r3.k = r6;
            r3.l = r0;
            r3.m = r1;
            r3.n = r2;
            MmStandaloneAIInterpretationLanguagePanelView.a(r3);
            MmStandaloneAIInterpretationLanguagePanelView.b(this.this$0);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation.MmStandaloneAIInterpretationLanguagePanelView$onAttachedToWindow$8, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\n"}, d2 = {"<anonymous>", "", "spokenReasons", "", "", "Lcom/ss/android/lark/officesdk/minutes/ui/record/standaloneinterpretation/MmStandaloneAIInterpretationLanguageDisabledReason;", "targetReasons"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation.MmStandaloneAIInterpretationLanguagePanelView$onAttachedToWindow$8", f = "MmStandaloneAIInterpretationLanguagePanelView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass8 extends SuspendLambda implements Function3<Map<String, ? extends MmStandaloneAIInterpretationLanguageDisabledReason>, Map<String, ? extends MmStandaloneAIInterpretationLanguageDisabledReason>, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;
        final /* synthetic */ MmStandaloneAIInterpretationLanguagePanelView this$0;

        public AnonymousClass8(MmStandaloneAIInterpretationLanguagePanelView r1, Continuation<? super AnonymousClass8> r2) {
            this.this$0 = r1;
            super(3, r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
            return invoke((Map) r1, (Map) r2, (Continuation) r3);
        }

        public final Object invoke(Map<String, ? extends MmStandaloneAIInterpretationLanguageDisabledReason> r3, Map<String, ? extends MmStandaloneAIInterpretationLanguageDisabledReason> r4, Continuation<? super Unit> r5) {
            AnonymousClass8 r0 = new AnonymousClass8(this.this$0, r5);
            r0.L$0 = r3;
            r0.L$1 = r4;
            return r0.invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r3);
            Map<String, ? extends MmStandaloneAIInterpretationLanguageDisabledReason> r4 = (Map) this.L$0;
            Map<String, ? extends MmStandaloneAIInterpretationLanguageDisabledReason> r0 = (Map) this.L$1;
            MmStandaloneAIInterpretationLanguagePanelView r1 = this.this$0;
            r1.o = r4;
            r1.p = r0;
            MmStandaloneAIInterpretationLanguagePanelView.b(r1);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        CoroutineScope r0 = this.i;
        if (r0 == null) goto L5;
        CoroutineScopeKt.cancel$default(r0, null, 1, null);
    L5:
        this.i = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        CoroutineScope r7 = CoroutineScopeKt.MainScope();
        CoroutineScope r0 = this.i;
        if (r0 == null) goto L5;
        CoroutineScopeKt.cancel$default(r0, null, 1, null);
    L5:
        this.i = r7;
        this.a.selectSubscribe(r7, C02871.INSTANCE, C02882.INSTANCE, C02893.INSTANCE, C02904.INSTANCE, new C02915(this, null));
        this.a.selectSubscribe(r7, AnonymousClass6.INSTANCE, AnonymousClass7.INSTANCE, new AnonymousClass8(this, null));
        this.a.selectSubscribe(r7, AnonymousClass9.INSTANCE, new AnonymousClass10(this, null));
        this.a.selectSubscribe(r7, AnonymousClass11.INSTANCE, new AnonymousClass12(this, null));
    }

    public static final void a(MmStandaloneAIInterpretationLanguagePanelView r6) {
        String r0 = r6.getContext().getString(2131894007);
        boolean r3 = true;
        String r5 = null;
        if (com.ss.android.lark.officesdk.minutes.ui.style.c.a(r6.getContext()) != MmRecordingUILaunchMode.WITH_DOUBAO_UI) goto L11;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r1 = r6.n;
        if (r1 == null) goto L7;
        String r2 = r1.a;
    L9:
        if (com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation.b.a(r2) == false) goto L11;
        boolean r4 = true;
    L12:
        if (r4 == true) goto L15;
        r0 = null;
    L15:
        TextView r7 = r6.d;
        if (r0 == null) goto L18;
        String r8 = r0;
    L24:
        r7.setText(r8);
        TextView r9 = r6.e;
        if (r0 != null) goto L37;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r10 = r6.n;
        if (r10 == null) goto L30;
        r0 = c(r10);
    L31:
        if (r0 != null) goto L37;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r11 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c) CollectionsKt.firstOrNull(r6.l);
        if (r11 == null) goto L36;
        r5 = c(r11);
    L36:
        r0 = r5;
        goto L37
    L30:
        r0 = null;
    L37:
        r9.setText(r0);
        TextView r12 = r6.d;
        if (r6.j != MmStandaloneAIInterpretationLanguageSide.SPOKEN) goto L40;
        boolean r13 = true;
    L41:
        r6.f(r12, r13);
        TextView r14 = r6.e;
        if (r6.j == MmStandaloneAIInterpretationLanguageSide.TARGET) goto L45;
        r3 = false;
    L45:
        r6.f(r14, r3);
        return;
    L40:
        r13 = false;
        goto L41
    L18:
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r15 = r6.m;
        if (r15 != null) goto L21;
        r15 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c) CollectionsKt.firstOrNull(r6.k);
    L21:
        if (r15 == null) goto L23;
        r8 = c(r15);
        goto L24
    L23:
        r8 = null;
        goto L24
    L7:
        r2 = null;
    L11:
        r4 = false;
        goto L12
    }

    public static final void b(MmStandaloneAIInterpretationLanguagePanelView r7) {
        int r0 = b.a[r7.j.ordinal()];
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r4 = null;
        if (r0 != 1) goto L5;
        MmStandaloneAIInterpretationLanguageAdapter r1 = r7.g;
        List<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c> r3 = r7.k;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r5 = r7.m;
        if (r5 == null) goto L21;
        if (e(r5, r3) == true) goto L18;
        r5 = null;
    L18:
        if (r5 == null) goto L21;
        r4 = r5;
    L24:
        Map<String, ? extends MmStandaloneAIInterpretationLanguageDisabledReason> r8 = r7.o;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "languages");
        Intrinsics.checkNotNullParameter(r8, "reasons");
        r1.e = r3;
        r1.f = r4;
        r1.g = r8;
        r1.notifyDataSetChanged();
        return;
    L21:
        if (r7.m != null) goto L24;
        r4 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c) CollectionsKt.firstOrNull(r7.k);
        goto L24
    L5:
        if (r0 != 2) goto L11;
        MmStandaloneAIInterpretationLanguageAdapter r2 = r7.g;
        List<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c> r6 = r7.l;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r9 = r7.n;
        if (e(r9, r6) == false) goto L9;
        r4 = r9;
    L9:
        Map<String, ? extends MmStandaloneAIInterpretationLanguageDisabledReason> r10 = r7.p;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r6, "languages");
        Intrinsics.checkNotNullParameter(r10, "reasons");
        r2.e = r6;
        r2.f = r4;
        r2.g = r10;
        r2.notifyDataSetChanged();
        return;
    L11:
        throw new NoWhenBranchMatchedException();
    }

    public static String c(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r2) {
        String r0 = r2.b;
        if ((!StringsKt.isBlank(r0)) == true) goto L6;
        r0 = null;
    L6:
        if (r0 == null) goto L8;
        return r0;
    L8:
        return r2.a;
    }

    public final int d(float r2) {
        return UIUtils.dp2px(getContext(), r2);
    }

    public static boolean e(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r4, List r5) {
        if (r4 == null) goto L22;
        List r6 = r5;
        if ((r6 instanceof Collection) == true) goto L7;
    L9:
        Iterator r7 = r6.iterator();
    L11:
        if (r7.hasNext() == false) goto L15;
        if (Intrinsics.areEqual(((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c) r7.next()).a, r4.a) == false) goto L11;
        boolean r8 = true;
    L16:
        if (r8 == false) goto L23;
        return true;
    L23:
        return false;
    L15:
        r8 = false;
        goto L16
    L7:
        if (r6.isEmpty() == false) goto L9;
    L22:
        return false;
    }

    public final void f(TextView r6, boolean r7) {
        int r0 = h18.e.a;
        r6.setTypeface(h18.e.a(r6.getContext()));
        Context r1 = r6.getContext();
        if (r7 == false) goto L5;
        int r2 = this.h.l();
    L6:
        int r3 = UDColorUtils.getColor(r1, r2);
        Context r4 = r6.getContext();
        if (r7 == false) goto L9;
        int r8 = this.h.c();
    L10:
        int r9 = UDColorUtils.getColor(r4, r8);
        r6.setTextColor(r3);
        Iterator r5 = ArraysKt.filterNotNull(r6.getCompoundDrawablesRelative()).iterator();
    L12:
        if (r5.hasNext() == false) goto L14;
        Drawable r10 = (Drawable) r5.next();
        r10.setBounds(0, 0, d(8.0f), d(8.0f));
        r10.mutate().setTint(r9);
        goto L12
    L14:
        r6.setBackground(null);
        return;
    L9:
        r8 = this.h.n();
        goto L10
    L5:
        r2 = this.h.o();
        goto L6
    }

    /* JADX WARN: Type inference failed for: r5v2, types: [android.view.ViewGroup, com.ss.android.lark.officesdk.minutes.ui.foundation.widget.MmNormalHintSwitchView] */
    public MmStandaloneAIInterpretationLanguagePanelView(Context r9, MmStandaloneAIInterpretationViewModel r10, Function0 r11) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "viewModel");
        super(r9, null);
        this.a = r10;
        this.b = r11;
        com.ss.android.lark.officesdk.minutes.ui.style.contract.d r12 = com.ss.android.lark.officesdk.minutes.ui.style.a.a(r9);
        this.h = r12;
        this.j = MmStandaloneAIInterpretationLanguageSide.TARGET;
        this.k = CollectionsKt.emptyList();
        this.l = CollectionsKt.emptyList();
        this.o = MapsKt.emptyMap();
        this.p = MapsKt.emptyMap();
        LayoutInflater.from(r9).inflate(2131564107, this, true);
        FrameLayout r13 = (FrameLayout) findViewById(2131366974);
        this.c = r13;
        AppCompatImageView r0 = findViewById(2131366975);
        TextView r1 = (TextView) findViewById(2131387010);
        this.d = r1;
        TextView r2 = (TextView) findViewById(2131388188);
        this.e = r2;
        AppCompatImageView r3 = findViewById(2131363237);
        RecyclerView r4 = findViewById(2131377143);
        ?? r5 = (MmNormalHintSwitchView) findViewById(2131364168);
        this.f = r5;
        MmStandaloneAIInterpretationLanguageAdapter r6 = new MmStandaloneAIInterpretationLanguageAdapter(r9, new AnonymousClass1(this));
        this.g = r6;
        r4.setLayoutManager(new LinearLayoutManager(r9));
        r4.setAdapter(r6);
        r3.setImageTintList(ColorStateList.valueOf(UDColorUtils.getColor(r9, r12.n())));
        r5.setBackground(com.ss.android.lark.officesdk.minutes.ui.style.b.a(r9).k(r9));
        r4.setBackground(com.ss.android.lark.officesdk.minutes.ui.style.b.a(r9).k(r9));
        if (com.ss.android.lark.officesdk.minutes.ui.style.c.a(r9) != MmRecordingUILaunchMode.WITH_DOUBAO_UI) goto L5;
        r5.findViewById(2131386000).setStyle(FlowSwitchStyle.SMALL);
        ViewGroup.LayoutParams r14 = r5.getLayoutParams();
        r14.height = d(56.0f);
        r5.setLayoutParams(r14);
        ViewGroup.LayoutParams r15 = r13.getLayoutParams();
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r16 = (ConstraintLayout.LayoutParams) r15;
        ((ViewGroup.MarginLayoutParams) r16).width = d(30.0f);
        ((ViewGroup.MarginLayoutParams) r16).height = d(30.0f);
        r16.startToStart = -1;
        r16.endToEnd = 0;
        r16.setMarginStart(0);
        r16.setMarginEnd(d(13.0f));
        ((ViewGroup.MarginLayoutParams) r16).topMargin = d(13.0f);
        ((ViewGroup.MarginLayoutParams) r16).bottomMargin = d(13.0f);
        r13.setLayoutParams(r16);
        r13.setBackground(com.ss.android.lark.officesdk.minutes.ui.style.b.a(r13.getContext()).y(r13.getContext()));
        ViewGroup.LayoutParams r17 = r0.getLayoutParams();
        r17.width = d(18.0f);
        r17.height = d(18.0f);
        r0.setLayoutParams(r17);
        r0.setImageTintList(ColorStateList.valueOf(UDColorUtils.getColor(r0.getContext(), 2131102043)));
        ViewGroup.LayoutParams r18 = r4.getLayoutParams();
        r18.height = -1;
        r4.setLayoutParams(r18);
        r4.setBackground(com.ss.android.lark.officesdk.minutes.ui.style.b.a(getContext()).r(getContext()).getCurrent());
    L5:
        h.a(r13, new AnonymousClass2(this));
        h.a(r1, new AnonymousClass3(this));
        h.a(r2, new AnonymousClass4(this));
        r5.setOnCheckedChangeListener(new AnonymousClass5(this));
    }
}
