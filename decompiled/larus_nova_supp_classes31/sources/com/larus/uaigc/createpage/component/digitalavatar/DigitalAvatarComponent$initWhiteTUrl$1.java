package com.larus.uaigc.createpage.component.digitalavatar;

import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.common_res.common_ui.databinding.LarusWidgetTitlebarExBinding;
import com.larus.common_ui.view.b0;
import com.larus.uaigc.impl.databinding.LarusLayoutAvatarGeneratingToastBinding;
import com.lynx.lottieadapter.LottieAdapterView;
import com.tencent.open.log.TraceLevel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlowImpl;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.digitalavatar.DigitalAvatarComponent$initWhiteTUrl$1", f = "DigitalAvatarComponent.kt", i = {0}, l = {689}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
final class DigitalAvatarComponent$initWhiteTUrl$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DigitalAvatarComponent this$0;

    /* JADX INFO: renamed from: com.larus.uaigc.createpage.component.digitalavatar.DigitalAvatarComponent$initWhiteTUrl$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.uaigc.createpage.component.digitalavatar.DigitalAvatarComponent$initWhiteTUrl$1$1", f = "DigitalAvatarComponent.kt", i = {}, l = {671, 686}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DigitalAvatarComponent this$0;

        public AnonymousClass1(DigitalAvatarComponent r1, Continuation<? super AnonymousClass1> r2) {
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

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r6);
        L35:
            b0 r7 = (b0) this.this$0.v.getValue();
            if (r7 == null) goto L39;
            r7.a();
        L39:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r6);
        L13:
            NovaTitleBarEx r8 = this.this$0.A;
            if (r8 == null) goto L22;
            LarusWidgetTitlebarExBinding r9 = r8.getBinding();
            if (r9 == null) goto L22;
            r9.f.setVisibility(0);
            r9.f.setImageResource(2131240887);
            ImageView r10 = r9.f;
            ViewGroup.LayoutParams r2 = r10.getLayoutParams();
            if (r2 == null) goto L21;
            ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) r2;
            int r4 = c7.b(Boxing.boxInt(28));
            r3.width = r4;
            r3.height = r4;
            r3.setMarginEnd(c7.b(Boxing.boxInt(16)));
            r10.setLayoutParams(r3);
            goto L22
        L21:
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        L22:
            b0 r11 = (b0) this.this$0.v.getValue();
            if (r11 == null) goto L25;
            LarusLayoutAvatarGeneratingToastBinding r12 = (LarusLayoutAvatarGeneratingToastBinding) r11.b();
        L25:
            b0 r13 = (b0) this.this$0.v.getValue();
            if (r13 == null) goto L32;
            LarusLayoutAvatarGeneratingToastBinding r14 = (LarusLayoutAvatarGeneratingToastBinding) r13.c;
            if (r14 == null) goto L32;
            LottieAdapterView r15 = r14.b;
            if (r15 == null) goto L32;
            r15.playAnimation();
        L32:
            this.label = 2;
            if (DelayKt.delay(2500, this) != r0) goto L35;
            return r0;
        L10:
            ResultKt.throwOnFailure(r6);
            this.label = 1;
            if (DelayKt.delay(200, this) != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.uaigc.createpage.component.digitalavatar.DigitalAvatarComponent$initWhiteTUrl$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.uaigc.createpage.component.digitalavatar.DigitalAvatarComponent$initWhiteTUrl$1$2", f = "DigitalAvatarComponent.kt", i = {}, l = {694}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DigitalAvatarComponent this$0;

        /* JADX INFO: renamed from: com.larus.uaigc.createpage.component.digitalavatar.DigitalAvatarComponent$initWhiteTUrl$1$2$1, reason: invalid class name */
        public static final class AnonymousClass1<T> implements FlowCollector {
            public final /* synthetic */ DigitalAvatarComponent a;

            public AnonymousClass1(DigitalAvatarComponent r1) {
                this.a = r1;
            }

            public final Object a(String r14, Continuation<? super Unit> r15) {
                if ((r15 instanceof DigitalAvatarComponent$initWhiteTUrl$1$2$1$emit$1) == false) goto L7;
                DigitalAvatarComponent$initWhiteTUrl$1$2$1$emit$1 r0 = (DigitalAvatarComponent$initWhiteTUrl$1$2$1$emit$1) r15;
                int r1 = r0.label;
                if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
                r0.label = r1 - Integer.MIN_VALUE;
            L8:
                Object r16 = r0.result;
                Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r3 = r0.label;
                if (r3 == 0) goto L14;
                if (r3 != 1) goto L13;
                LarusWidgetTitlebarExBinding r17 = (LarusWidgetTitlebarExBinding) r0.L$1;
                LarusWidgetTitlebarExBinding r4 = (LarusWidgetTitlebarExBinding) r0.L$0;
                ResultKt.throwOnFailure(r16);
            L44:
                Bitmap r18 = (Bitmap) r16;
                if (r18 == null) goto L51;
                r17.f.setImageBitmap(r18);
                ImageView r19 = r17.f;
                ViewGroup.LayoutParams r110 = r19.getLayoutParams();
                if (r110 == null) goto L50;
                ViewGroup.MarginLayoutParams r111 = (ViewGroup.MarginLayoutParams) r110;
                int r5 = c7.b(Boxing.boxInt(28));
                r111.width = r5;
                r111.height = r5;
                r111.setMarginEnd(c7.b(Boxing.boxInt(16)));
                r19.setLayoutParams(r111);
            L60:
                return Unit.INSTANCE;
            L50:
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            L51:
                ImageView r112 = r17.f;
                if (r112 == null) goto L54;
                r112.setImageResource(v19.c.b(2130971710, r112.getContext(), 2131241310));
            L54:
                ImageView r113 = r17.f;
                ViewGroup.LayoutParams r114 = r113.getLayoutParams();
                if (r114 == null) goto L58;
                ViewGroup.MarginLayoutParams r115 = (ViewGroup.MarginLayoutParams) r114;
                int r6 = c7.b(Boxing.boxInt(24));
                r115.width = r6;
                r115.height = r6;
                r115.setMarginEnd(c7.b(Boxing.boxInt(18)));
                r113.setLayoutParams(r115);
                goto L60
            L58:
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L14:
                ResultKt.throwOnFailure(r16);
                NovaTitleBarEx r116 = this.a.A;
                if (r116 == null) goto L17;
                LarusWidgetTitlebarExBinding r117 = r116.getBinding();
                DigitalAvatarComponent r7 = this.a;
                ImageView r9 = r117.f;
                boolean r11 = false;
                if (((Boolean) r7.n.getValue()).booleanValue() == false) goto L21;
                int r10 = 0;
            L22:
                r9.setVisibility(r10);
                b0 r12 = (b0) r7.v.getValue();
                if (r12 == null) goto L26;
                r12.a();
            L26:
                if (((Boolean) r7.n.getValue()).booleanValue() == false) goto L60;
                if (r14 != null) goto L29;
            L30:
                r11 = true;
            L31:
                if (r11 == false) goto L40;
                ImageView r118 = r117.f;
                if (r118 == null) goto L35;
                r118.setImageResource(v19.c.b(2130971710, r118.getContext(), 2131241310));
            L35:
                ImageView r119 = r117.f;
                ViewGroup.LayoutParams r120 = r119.getLayoutParams();
                if (r120 == null) goto L39;
                ViewGroup.MarginLayoutParams r121 = (ViewGroup.MarginLayoutParams) r120;
                int r8 = c7.b(Boxing.boxInt(24));
                r121.width = r8;
                r121.height = r8;
                r121.setMarginEnd(c7.b(Boxing.boxInt(18)));
                r119.setLayoutParams(r121);
                goto L60
            L39:
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            L40:
                CoroutineDispatcher r13 = Dispatchers.getIO();
                DigitalAvatarComponent$initWhiteTUrl$1$2$1$1$bitmap$1 r20 = new DigitalAvatarComponent$initWhiteTUrl$1$2$1$1$bitmap$1(r14, null);
                r0.L$0 = r117;
                r0.L$1 = r117;
                r0.label = 1;
                Object r122 = BuildersKt.withContext(r13, r20, r0);
                if (r122 != r2) goto L43;
                return r2;
            L43:
                r16 = r122;
                r17 = r117;
                goto L44
            L29:
                if (r14.length() != 0) goto L31;
            L21:
                r10 = 8;
                goto L22
            L17:
                return Unit.INSTANCE;
            L7:
                r0 = new DigitalAvatarComponent$initWhiteTUrl$1$2$1$emit$1(this, r15);
                goto L8
            }

            public final /* bridge */ /* synthetic */ Object emit(Object r1, Continuation r2) {
                return a((String) r1, r2);
            }
        }

        public AnonymousClass2(DigitalAvatarComponent r1, Continuation<? super AnonymousClass2> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass2(this.this$0, r3);
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
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r5);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            DigitalAvatarComponent r6 = this.this$0;
            StateFlowImpl r2 = r6.o;
            AnonymousClass1 r3 = new AnonymousClass1(r6);
            this.label = 1;
            if (r2.collect(r3, this) != r0) goto L12;
            return r0;
        }
    }

    public DigitalAvatarComponent$initWhiteTUrl$1(DigitalAvatarComponent r1, Continuation<? super DigitalAvatarComponent$initWhiteTUrl$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        DigitalAvatarComponent$initWhiteTUrl$1 r0 = new DigitalAvatarComponent$initWhiteTUrl$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        CoroutineScope r2 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r11);
    L22:
        Job r12 = this.this$0.p;
        if (r12 == null) goto L25;
        Job.DefaultImpls.cancel$default(r12, null, 1, null);
    L25:
        CoroutineScope r4 = r2;
    L27:
        BuildersKt.launch$default(r4, null, null, new AnonymousClass2(this.this$0, null), 3, null);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        CoroutineScope r13 = (CoroutineScope) this.L$0;
        CharSequence r3 = (CharSequence) this.this$0.o.getValue();
        if (r3 != null) goto L11;
    L14:
        boolean r5 = true;
    L15:
        if (r5 == true) goto L17;
    L26:
        r4 = r13;
        goto L27
    L17:
        if (((Boolean) this.this$0.n.getValue()).booleanValue() == false) goto L26;
        DigitalAvatarComponent r6 = this.this$0;
        r6.p = BuildersKt.launch$default(r13, null, null, new AnonymousClass1(r6, null), 3, null);
        DigitalAvatarInfoManager r7 = DigitalAvatarInfoManager.a;
        this.L$0 = r13;
        this.label = 1;
        if (DigitalAvatarInfoManager.d(r7, this) != r0) goto L21;
        return r0;
    L21:
        r2 = r13;
        goto L22
    L11:
        if (r3.length() == 0) goto L14;
        r5 = false;
        goto L15
    }
}
