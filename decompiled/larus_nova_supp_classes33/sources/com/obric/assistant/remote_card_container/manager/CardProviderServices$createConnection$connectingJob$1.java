package com.obric.assistant.remote_card_container.manager;

import android.app.Application;
import android.net.Uri;
import com.obric.aiagent.assistant_card.provider_core.ICardProviderService;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/obric/aiagent/assistant_card/provider_core/ICardProviderService;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.remote_card_container.manager.CardProviderServices$createConnection$connectingJob$1", f = "CardProviderServices.kt", i = {0}, l = {81, 90}, m = "invokeSuspend", n = {"it"}, s = {"L$0"})
final class CardProviderServices$createConnection$connectingJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ICardProviderService>, Object> {
    final /* synthetic */ Application $application;
    final /* synthetic */ Uri $cardUri;
    final /* synthetic */ Deferred<ICardProviderService> $preLastJob;
    final /* synthetic */ String $providerPkgName;
    Object L$0;
    int label;

    /* JADX INFO: renamed from: com.obric.assistant.remote_card_container.manager.CardProviderServices$createConnection$connectingJob$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/obric/aiagent/assistant_card/provider_core/ICardProviderService;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.remote_card_container.manager.CardProviderServices$createConnection$connectingJob$1$2", f = "CardProviderServices.kt", i = {}, l = {251}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ICardProviderService>, Object> {
        final /* synthetic */ Application $application;
        final /* synthetic */ Uri $cardUri;
        final /* synthetic */ String $providerPkgName;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;

        public AnonymousClass2(String r1, Application r2, Uri r3, Continuation<? super AnonymousClass2> r4) {
            this.$providerPkgName = r1;
            this.$application = r2;
            this.$cardUri = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass2(this.$providerPkgName, this.$application, this.$cardUri, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super ICardProviderService> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r14) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            Uri r2 = (Uri) this.L$2;
            Application r3 = (Application) this.L$1;
            String r4 = (String) this.L$0;
            ResultKt.throwOnFailure(r14);
            return r14;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r14);
            final String r5 = this.$providerPkgName;
            final Application r6 = this.$application;
            Uri r7 = this.$cardUri;
            this.L$0 = r5;
            this.L$1 = r6;
            this.L$2 = r7;
            this.label = 1;
            final j r8 = new j(IntrinsicsKt.intercepted(this), 1);
            r8.C();
            final Ref.ObjectRef r9 = new Ref.ObjectRef();
            r9.element = new CardProviderServices$createConnection$connectingJob$1$2$1$1(r5, r9, r8, r6);
            BuildersKt.launch$default(CardProviderServices.d, null, null, new CardProviderServices$createConnection$connectingJob$1$2$1$2(r7, r5, r6, r9, r8, null), 3, null);
            Object r10 = r8.B();
            if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L11;
            DebugProbesKt.probeCoroutineSuspended(this);
        L11:
            if (r10 != r0) goto L14;
            return r0;
        L14:
            return r10;
        }
    }

    public CardProviderServices$createConnection$connectingJob$1(Deferred<? extends ICardProviderService> r1, String r2, Application r3, Uri r4, Continuation<? super CardProviderServices$createConnection$connectingJob$1> r5) {
        this.$preLastJob = r1;
        this.$providerPkgName = r2;
        this.$application = r3;
        this.$cardUri = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new CardProviderServices$createConnection$connectingJob$1(this.$preLastJob, this.$providerPkgName, this.$application, this.$cardUri, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super ICardProviderService> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r7);
    L27:
        return r7;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        Deferred<ICardProviderService> r2 = (Deferred) this.L$0;
        ResultKt.throwOnFailure(r7);
    L17:
        p9a.e r8 = p9a.b.a;
        p9a.b.a("CardProviderServices", "finish wait last job " + r2);
    L18:
        p9a.e r9 = p9a.b.a;
        p9a.b.a("CardProviderServices", "start connect " + this.$providerPkgName);
        Pair r10 = (Pair) ((LinkedHashMap) CardProviderServices.b).get(this.$providerPkgName);
        if (r10 != null) goto L21;
    L24:
        AnonymousClass2 r11 = new AnonymousClass2(this.$providerPkgName, this.$application, this.$cardUri, null);
        this.L$0 = null;
        this.label = 2;
        r7 = TimeoutKt.c(5000, r11, this);
        if (r7 != r0) goto L27;
        return r0;
    L21:
        if (((CardProviderServices.a) r10.getSecond()).a.get() == false) goto L24;
        return r10.getFirst();
    L10:
        ResultKt.throwOnFailure(r7);
        r2 = this.$preLastJob;
        if (r2 == null) goto L18;
        if (r2.isActive() == false) goto L18;
        p9a.e r12 = p9a.b.a;
        p9a.b.a("CardProviderServices", "start wait wait last job " + r2);
        this.L$0 = r2;
        this.label = 1;
        if (r2.join(this) != r0) goto L17;
        return r0;
    }
}
