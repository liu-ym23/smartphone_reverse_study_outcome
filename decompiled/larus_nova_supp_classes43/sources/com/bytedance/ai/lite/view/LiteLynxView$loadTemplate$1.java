package com.bytedance.ai.lite.view;

import com.bytedance.ai.lynx.AppletLynxViewApi;
import com.bytedance.ai.utils.f;
import com.bytedance.ai.utils.g;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.TemplateData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.lite.view.LiteLynxView$loadTemplate$1", f = "LiteLynxView.kt", i = {0}, l = {93}, m = "invokeSuspend", n = {"start"}, s = {"J$0"})
final class LiteLynxView$loadTemplate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $initData;
    final /* synthetic */ String $templateUrl;
    long J$0;
    int label;
    final /* synthetic */ a this$0;

    /* JADX INFO: renamed from: com.bytedance.ai.lite.view.LiteLynxView$loadTemplate$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.lite.view.LiteLynxView$loadTemplate$1$1", f = "LiteLynxView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $initData;
        final /* synthetic */ TemplateBundle $result;
        final /* synthetic */ String $templateUrl;
        int label;
        final /* synthetic */ a this$0;

        public AnonymousClass1(a r1, String r10, TemplateBundle r11, String r12, Continuation<? super AnonymousClass1> r13) {
            this.this$0 = r1;
            this.$templateUrl = r10;
            this.$result = r11;
            this.$initData = r12;
            super(2, r13);
        }

        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new AnonymousClass1(this.this$0, this.$templateUrl, this.$result, this.$initData, r11);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
            return invoke((CoroutineScope) r1, (Continuation) r10);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
            return create(r1, r10).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L26;
            ResultKt.throwOnFailure(r10);
            a r11 = this.this$0;
            String r0 = this.$templateUrl;
            TemplateBundle r1 = this.$result;
            String r12 = this.$initData;
            int r13 = a.g;
            r11.getClass();
            g r14 = g.a;
            StringBuilder r15 = new StringBuilder("renderTemplate ");
            r15.append(r11);
            r15.append(" bundle=");
            r15.append(r1);
            r15.append(" size=");
            if (r1 == null) goto L7;
            Integer r16 = Integer.valueOf(r1.c);
        L8:
            r15.append(r16);
            r15.append(" url=");
            r15.append(r0);
            r14.i("LiteLynxView", r15.toString());
            if (r1 != null) goto L13;
            e5.a r17 = r11.c;
            if (r17 == null) goto L24;
            r17.b(new Throwable("getTemplateBundle failed"));
        L24:
            return Unit.INSTANCE;
        L13:
            com.bytedance.ai.lynx.g r18 = r11.a;
            if (r18 == null) goto L16;
            r18.k(r0, null, null);
        L16:
            com.bytedance.ai.lynx.g r19 = r11.a;
            if (r19 == null) goto L24;
            if (f.g(r12) == false) goto L21;
            TemplateData r20 = TemplateData.fromString(r12);
        L22:
            Intrinsics.checkNotNull(r20);
            com.bytedance.ai.lynx.g.j(r19, r0, r1, r20, r11.f);
            goto L24
        L21:
            r20 = TemplateData.empty();
            goto L22
        L7:
            r16 = null;
            goto L8
        L26:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public LiteLynxView$loadTemplate$1(a r1, String r10, String r11, Continuation<? super LiteLynxView$loadTemplate$1> r12) {
        this.this$0 = r1;
        this.$templateUrl = r10;
        this.$initData = r11;
        super(2, r12);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new LiteLynxView$loadTemplate$1(this.this$0, this.$templateUrl, this.$initData, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        long r10 = this.J$0;
        ResultKt.throwOnFailure(r13);
    L12:
        TemplateBundle r11 = (TemplateBundle) r13;
        g r14 = g.a;
        int r12 = a.g;
        StringBuilder r15 = new StringBuilder("getTemplateBundle ");
        r15.append(this.this$0);
        r15.append(" bundle=");
        r15.append(r11);
        r15.append(" size=");
        if (r11 == null) goto L15;
        Integer r16 = Boxing.boxInt(r11.c);
    L16:
        r15.append(r16);
        r15.append(" cost=");
        r15.append(System.currentTimeMillis() - r10);
        r14.d("LiteLynxView", r15.toString());
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AnonymousClass1(this.this$0, this.$templateUrl, r11, this.$initData, null), 3, null);
        return Unit.INSTANCE;
    L15:
        r16 = null;
        goto L16
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        long r17 = System.currentTimeMillis();
        int r18 = AppletLynxViewApi.a;
        String r19 = this.this$0.b;
        String r20 = this.$templateUrl;
        this.J$0 = r17;
        this.label = 1;
        r13 = AppletLynxViewApi.b(r19, r20, false, null, null, this);
        if (r13 != r0) goto L11;
        return r0;
    L11:
        r10 = r17;
        goto L12
    }
}
