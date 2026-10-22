package com.larus.slides.impl.chat.component;

import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.im.j;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import s1a.d;
import va8.a0;
import va8.z;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u001e2\u00020\u00012\u00020\u0002:\u0001\u001eB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0017H\u0016R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\u000b\u001a\u0004\u0018\u00010\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0010\u001a\u00020\u0011X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001f"}, d2 = {"Lcom/larus/slides/impl/chat/component/SlidesConvTitleComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/bmhome/ability/IConversationChangeListener;", "<init>", "()V", "floatChatTitleAbility", "Lcom/larus/bmhome/floatchat/ability/IFloatChatTitleAbility;", "getFloatChatTitleAbility", "()Lcom/larus/bmhome/floatchat/ability/IFloatChatTitleAbility;", "floatChatTitleAbility$delegate", "Lkotlin/Lazy;", "conversationCoreAbility", "Lcom/larus/bmhome/ability/IConversationCoreAbility;", "getConversationCoreAbility", "()Lcom/larus/bmhome/ability/IConversationCoreAbility;", "conversationCoreAbility$delegate", "contentViewId", "", "getContentViewId", "()I", "setContentViewId", "(I)V", "onViewCreated", "", "view", "Landroid/view/View;", "onConversationIdChanged", "convId", "", "onDestroy", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class SlidesConvTitleComponent extends BaseContentWidget implements z {
    public static final /* synthetic */ int p = 0;
    public final Lazy m;
    public final Lazy n;
    public int o;

    public static final class a {
    }

    public static final class b implements Function0<np8.a> {
        public final /* synthetic */ AttachReceiver a;

        public b(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return d.a(r0).o(Reflection.getOrCreateKotlinClass(np8.a.class));
        }
    }

    public static final class c implements Function0<a0> {
        public final /* synthetic */ AttachReceiver a;

        public c(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return d.a(r0).o(Reflection.getOrCreateKotlinClass(a0.class));
        }
    }

    /* JADX INFO: renamed from: com.larus.slides.impl.chat.component.SlidesConvTitleComponent$onViewCreated$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.slides.impl.chat.component.SlidesConvTitleComponent$onViewCreated$1", f = "SlidesConvTitleComponent.kt", i = {}, l = {39}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $convId;
        int label;
        final /* synthetic */ SlidesConvTitleComponent this$0;

        public AnonymousClass1(String r1, SlidesConvTitleComponent r2, Continuation<? super AnonymousClass1> r3) {
            this.$convId = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$convId, this.this$0, r4);
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
        L14:
            e r11 = (e) r10;
            if (r11 == null) goto L22;
            String r12 = r11.c;
            if (r12 == null) goto L22;
            SlidesConvTitleComponent r2 = this.this$0;
            FLogger.a.i("SlidesConvTitleComponent", "onViewCreated, conv name = ".concat(r12));
            int r3 = SlidesConvTitleComponent.p;
            np8.a r4 = (np8.a) r2.m.getValue();
            if (r4 == null) goto L22;
            r4.setTitle(r12);
        L22:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            IConversationRepoService r5 = RepoDispatcherDelegate.b.f();
            String r13 = this.$convId;
            if (r13 != null) goto L11;
            r13 = "";
        L11:
            this.label = 1;
            r10 = IConversationRepoService.a.c(r5, r13, false, null, this, 6);
            if (r10 != r0) goto L14;
            return r0;
        }
    }

    static {
    }

    public final void onDestroy() {
        a0 r0 = (a0) this.n.getValue();
        if (r0 == null) goto L6;
        r0.KM(this);
        return;
    }

    public SlidesConvTitleComponent() {
        this.m = LazyKt.lazy(new b(this));
        this.n = LazyKt.lazy(new c(this));
        this.o = 2131372934;
    }

    public final int U2() {
        return this.o;
    }

    public final void X2(int r1) {
        this.o = r1;
    }

    public final void k2(String r8) {
        Intrinsics.checkNotNullParameter(r8, "convId");
        FLogger.a.i("SlidesConvTitleComponent", "onConversationIdChanged, convId = " + r8);
        if (j.f(r8) == true) goto L6;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new SlidesConvTitleComponent$onConversationIdChanged$1(r8, this, null), 3, null);
        return;
    }

    public final void onViewCreated(View r9) {
        Intrinsics.checkNotNullParameter(r9, "view");
        a0 r10 = (a0) this.n.getValue();
        if (r10 == null) goto L5;
        r10.FM(this);
    L5:
        Intrinsics.checkNotNullParameter(this, "<this>");
        Bundle r11 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getArguments();
        if (r11 == null) goto L8;
        String r12 = r11.getString("argConversationId", "");
    L9:
        FLogger.a.i("SlidesConvTitleComponent", "onViewCreated, convId = " + r12);
        if (j.f(r12) == true) goto L12;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass1(r12, this, null), 3, null);
        return;
    L12:
        np8.a r13 = (np8.a) this.m.getValue();
        if (r13 == null) goto L17;
        r13.setTitle(getContext().getString(2131899583));
        return;
    L17:
        return;
    L8:
        r12 = null;
        goto L9
    }
}
