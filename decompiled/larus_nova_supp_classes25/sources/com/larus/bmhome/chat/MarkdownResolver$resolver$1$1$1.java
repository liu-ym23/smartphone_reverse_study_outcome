package com.larus.bmhome.chat;

import android.view.View;
import com.bytedance.keva.Keva;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.platform.IFlowSdkDepend;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.MarkdownResolver$resolver$1$1$1", f = "MarkdownResolver.kt", i = {}, l = {287}, m = "invokeSuspend", n = {}, s = {})
public final class MarkdownResolver$resolver$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $fixedUrl;
    final /* synthetic */ boolean $isFromWiki;
    final /* synthetic */ String $link;
    final /* synthetic */ boolean $shouldInjectAuthCookie;
    final /* synthetic */ View $view;
    int label;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.MarkdownResolver$resolver$1$1$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.MarkdownResolver$resolver$1$1$1$1", f = "MarkdownResolver.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $fixedUrl;
        final /* synthetic */ boolean $isFromWiki;
        final /* synthetic */ String $link;
        final /* synthetic */ boolean $shouldInjectAuthCookie;
        final /* synthetic */ View $view;
        int label;

        public AnonymousClass1(String r1, View r2, boolean r3, String r4, boolean r5, Continuation<? super AnonymousClass1> r6) {
            this.$link = r1;
            this.$view = r2;
            this.$isFromWiki = r3;
            this.$fixedUrl = r4;
            this.$shouldInjectAuthCookie = r5;
            super(2, r6);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            return new AnonymousClass1(this.$link, this.$view, this.$isFromWiki, this.$fixedUrl, this.$shouldInjectAuthCookie, r9);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r6);
            Keva r7 = com.larus.bmhome.utils.z2.a;
            String r8 = this.$link;
            final View r0 = this.$view;
            final boolean r1 = this.$isFromWiki;
            final String r2 = this.$fixedUrl;
            final boolean r3 = this.$shouldInjectAuthCookie;
            com.larus.bmhome.utils.z2.b(r8, new a5(r0, r1, r2, r3));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public MarkdownResolver$resolver$1$1$1(boolean r1, String r2, View r3, boolean r4, String r5, Continuation<? super MarkdownResolver$resolver$1$1$1> r6) {
        this.$shouldInjectAuthCookie = r1;
        this.$link = r2;
        this.$view = r3;
        this.$isFromWiki = r4;
        this.$fixedUrl = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new MarkdownResolver$resolver$1$1$1(this.$shouldInjectAuthCookie, this.$link, this.$view, this.$isFromWiki, this.$fixedUrl, r9);
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
        ResultKt.throwOnFailure(r11);
    L17:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        if (this.$shouldInjectAuthCookie == false) goto L13;
        IFlowSdkDepend r12 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r12 == null) goto L13;
        r12.D();
        com.larus.home.impl.sdk.x1.a.p();
    L13:
        MainCoroutineDispatcher r13 = Dispatchers.getMain();
        AnonymousClass1 r2 = new AnonymousClass1(this.$link, this.$view, this.$isFromWiki, this.$fixedUrl, this.$shouldInjectAuthCookie, null);
        this.label = 1;
        if (BuildersKt.withContext(r13, r2, this) != r0) goto L17;
        return r0;
    }
}
