package com.obric.assistant.settings.autogui;

import android.content.Context;
import com.obric.assistant.AutoGuiAppScopeConfig;
import com.obric.assistant.settings.ObricAppListMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/obric/assistant/settings/AutoActionAppFilterPolicy;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.settings.autogui.ObricAutoGuiSettingsImpl$getAutoActionAppFilterPolicyForRecommendation$2$1", f = "ObricAutoGuiSettingsImpl.kt", i = {0, 1}, l = {438, 439, 440}, m = "invokeSuspend", n = {"cloudPolicyDeferred", "saepResult"}, s = {"L$0", "L$0"})
public final class ObricAutoGuiSettingsImpl$getAutoActionAppFilterPolicyForRecommendation$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.obric.assistant.settings.d>, Object> {
    final /* synthetic */ Context $appContext;
    final /* synthetic */ AutoGuiAppScopeConfig $appScopeConfig;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ObricAutoGuiSettingsImpl this$0;

    /* JADX INFO: renamed from: com.obric.assistant.settings.autogui.ObricAutoGuiSettingsImpl$getAutoActionAppFilterPolicyForRecommendation$2$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/obric/assistant/settings/AutoActionAppFilterPolicy;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.settings.autogui.ObricAutoGuiSettingsImpl$getAutoActionAppFilterPolicyForRecommendation$2$1$1", f = "ObricAutoGuiSettingsImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.obric.assistant.settings.d>, Object> {
        final /* synthetic */ Context $appContext;
        final /* synthetic */ ObricAutoGuiSettingsImpl$d $cloudPolicy;
        final /* synthetic */ ObricSaepRestrictedPackageReader.a $saepResult;
        int label;
        final /* synthetic */ ObricAutoGuiSettingsImpl this$0;

        public AnonymousClass1(ObricAutoGuiSettingsImpl r1, ObricAutoGuiSettingsImpl$d r2, Context r3, ObricSaepRestrictedPackageReader.a r4, Continuation<? super AnonymousClass1> r5) {
            this.this$0 = r1;
            this.$cloudPolicy = r2;
            this.$appContext = r3;
            this.$saepResult = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new AnonymousClass1(this.this$0, this.$cloudPolicy, this.$appContext, this.$saepResult, r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super com.obric.assistant.settings.d> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r15) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L68;
            ResultKt.throwOnFailure(r15);
            ObricAutoGuiSettingsImpl r16 = this.this$0;
            ObricAutoGuiSettingsImpl$d r0 = this.$cloudPolicy;
            Context r1 = this.$appContext;
            Intrinsics.checkNotNull(r1);
            Set<String> r2 = this.$saepResult.a;
            if (r2 != null) goto L7;
            r2 = SetsKt.emptySet();
        L7:
            Set<String> r3 = this.$saepResult.b;
            if (r3 != null) goto L10;
            r3 = SetsKt.emptySet();
        L10:
            Set r4 = ObricAutoGuiSettingsImpl.i;
            r16.getClass();
            ObricAppListMode r6 = r0.a;
            List<com.obric.assistant.settings.r> r5 = r0.b;
            Set r7 = null;
            if (r5 == null) goto L62;
            ArrayList r8 = new ArrayList();
            Iterator<T> r9 = r5.iterator();
        L14:
            if (r9.hasNext() == false) goto L61;
            com.obric.assistant.settings.r r10 = (com.obric.assistant.settings.r) r9.next();
            List r11 = CollectionsKt.createListBuilder();
            String r12 = r10.b();
            if (r12 == null) goto L28;
            String r13 = StringsKt.trim(r12).toString();
            if (r13 == null) goto L28;
            if (r13.length() <= 0) goto L22;
            boolean r14 = true;
        L23:
            if (r14 == true) goto L26;
            r13 = null;
        L26:
            if (r13 == null) goto L28;
            r11.add(r13);
            goto L28
        L22:
            r14 = false;
        L28:
            String r17 = r10.a();
            if (r17 == null) goto L41;
            String r18 = StringsKt.trim(r17).toString();
            if (r18 == null) goto L41;
            if (r18.length() <= 0) goto L35;
            boolean r19 = true;
        L36:
            if (r19 == true) goto L39;
            r18 = null;
        L39:
            if (r18 == null) goto L41;
            r11.add(r18);
            goto L41
        L35:
            r19 = false;
        L41:
            List<String> r20 = r10.c();
            if (r20 == null) goto L60;
            Iterator<T> r21 = r20.iterator();
        L45:
            if (r21.hasNext() == false) goto L60;
            String r110 = (String) r21.next();
            if (r110 == null) goto L56;
            String r111 = StringsKt.trim(r110).toString();
            if (r111 == null) goto L56;
            if (r111.length() <= 0) goto L53;
            boolean r112 = true;
        L54:
            if (r112 == false) goto L56;
        L57:
            if (r111 == null) goto L45;
            r11.add(r111);
            goto L45
        L53:
            r112 = false;
        L56:
            r111 = null;
        L60:
            CollectionsKt.addAll(r8, CollectionsKt.build(r11));
            goto L14
        L61:
            r7 = CollectionsKt.toSet(r8);
        L62:
            if (r7 != null) goto L64;
            Set r22 = SetsKt.emptySet();
        L66:
            return new com.obric.assistant.settings.d(r6, r22, r0.d, ObricAutoGuiSettingsImpl.u(r2, r1, "saepRestrictedPackages"), ObricAutoGuiSettingsImpl.u(r3, r1, "saepDeclaredPackages"));
        L64:
            r22 = r7;
            goto L66
        L68:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public ObricAutoGuiSettingsImpl$getAutoActionAppFilterPolicyForRecommendation$2$1(ObricAutoGuiSettingsImpl r1, AutoGuiAppScopeConfig r2, Context r3, Continuation<? super ObricAutoGuiSettingsImpl$getAutoActionAppFilterPolicyForRecommendation$2$1> r4) {
        this.this$0 = r1;
        this.$appScopeConfig = r2;
        this.$appContext = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        ObricAutoGuiSettingsImpl$getAutoActionAppFilterPolicyForRecommendation$2$1 r0 = new ObricAutoGuiSettingsImpl$getAutoActionAppFilterPolicyForRecommendation$2$1(this.this$0, this.$appScopeConfig, this.$appContext, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super com.obric.assistant.settings.d> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L10;
        if (r1 != 3) goto L9;
        ResultKt.throwOnFailure(r13);
    L22:
        return r13;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ObricSaepRestrictedPackageReader.a r2 = (ObricSaepRestrictedPackageReader.a) this.L$0;
        ResultKt.throwOnFailure(r13);
        ObricSaepRestrictedPackageReader.a r10 = r2;
    L19:
        ObricAutoGuiSettingsImpl$d r8 = (ObricAutoGuiSettingsImpl$d) r13;
        CoroutineDispatcher r14 = Dispatchers.getIO();
        AnonymousClass1 r3 = new AnonymousClass1(this.this$0, r8, this.$appContext, r10, null);
        this.L$0 = null;
        this.label = 3;
        r13 = BuildersKt.withContext(r14, r3, this);
        if (r13 != r0) goto L22;
        return r0;
    L11:
        Deferred r4 = (Deferred) this.L$0;
        ResultKt.throwOnFailure(r13);
    L15:
        ObricSaepRestrictedPackageReader.a r15 = (ObricSaepRestrictedPackageReader.a) r13;
        this.L$0 = r15;
        this.label = 2;
        Object r5 = r4.await(this);
        if (r5 != r0) goto L18;
        return r0;
    L18:
        r10 = r15;
        r13 = r5;
        goto L19
    L12:
        ResultKt.throwOnFailure(r13);
        CoroutineScope r16 = (CoroutineScope) this.L$0;
        r4 = BuildersKt.async$default(r16, Dispatchers.getIO(), null, new ObricAutoGuiSettingsImpl$getAutoActionAppFilterPolicyForRecommendation$2$1$cloudPolicyDeferred$1(this.this$0, null), 2, null);
        Deferred r17 = BuildersKt.async$default(r16, Dispatchers.getIO(), null, new ObricAutoGuiSettingsImpl$getAutoActionAppFilterPolicyForRecommendation$2$1$saepResultDeferred$1(this.$appScopeConfig, this.$appContext, null), 2, null);
        this.L$0 = r4;
        this.label = 1;
        r13 = r17.await(this);
        if (r13 != r0) goto L15;
        return r0;
    }
}
