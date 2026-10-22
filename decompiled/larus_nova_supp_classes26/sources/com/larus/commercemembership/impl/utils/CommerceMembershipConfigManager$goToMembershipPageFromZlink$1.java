package com.larus.commercemembership.impl.utils;

import android.net.Uri;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.Gson;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.x1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.larus.utils.y0;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.commercemembership.impl.utils.CommerceMembershipConfigManager$goToMembershipPageFromZlink$1", f = "CommerceMembershipConfigManager.kt", i = {}, l = {214}, m = "invokeSuspend", n = {}, s = {})
public final class CommerceMembershipConfigManager$goToMembershipPageFromZlink$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $scene;
    final /* synthetic */ String $text;
    int label;

    /* JADX INFO: renamed from: com.larus.commercemembership.impl.utils.CommerceMembershipConfigManager$goToMembershipPageFromZlink$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.commercemembership.impl.utils.CommerceMembershipConfigManager$goToMembershipPageFromZlink$1$1", f = "CommerceMembershipConfigManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $scene;
        final /* synthetic */ String $text;
        int label;

        public AnonymousClass1(String r1, String r2, Continuation<? super AnonymousClass1> r3) {
            this.$text = r1;
            this.$scene = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$text, this.$scene, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r11) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L102;
            ResultKt.throwOnFailure(r11);
            Ref.ObjectRef r12 = new Ref.ObjectRef();
            String r0 = this.$text;
            if (r0 == null) goto L39;
            String r5 = this.$scene;
            CommerceMembershipConfigManager r6 = CommerceMembershipConfigManager.a;
            Uri r7 = y0.j(r0);
            Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L13
            if (r7 == null) goto L10;
            String r9 = UriProtector.getQueryParameter(r7, "open_method");     // Catch: Throwable -> L13
        L11:
            Object r10 = Result.constructor-impl(r9);     // Catch: Throwable -> L13
        L16:
            if (Result.isFailure-impl(r10) == false) goto L18;
            r10 = null;
        L18:
            String r13 = (String) r10;
            if (r7 != null) goto L105;
            String r14 = null;
        L24:
            Object r15 = Result.constructor-impl(r14);     // Catch: Throwable -> L21
        L28:
            if (Result.isFailure-impl(r15) == false) goto L30;
            r15 = null;
        L30:
            String r16 = (String) r15;
            if (Intrinsics.areEqual(r13, "doubao_member") == true) goto L33;
        L35:
            j r17 = null;
        L36:
            if (r17 == null) goto L39;
            r12.element = r17;
            Lazy r1 = i.a;
            Intrinsics.checkNotNullParameter(r17, "info");
            ((Keva) i.b.getValue()).storeString("membership_zlink_info", GsonProtectorUtils.toJson((Gson) i.a.getValue(), r17));
            FLogger.a.i("CommerceMembershipConfigManager", "goToMembershipPageFromZlink: store zlink info scene=" + r5 + " info=" + r17.a);
            goto L39
        L33:
            if (o0.d(r16) == false) goto L35;
            r17 = new j(r0);
        L21:
            th = move-exception;
            Result.Companion r18 = Result.Companion;
            r15 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L28
        L105:
            r14 = UriProtector.getQueryParameter(r7, "target_url");     // Catch: Throwable -> L21
            goto L24
        L10:
            r9 = null;
        L13:
            th = move-exception;
            Result.Companion r19 = Result.Companion;
            r10 = Result.constructor-impl(ResultKt.createFailure(th));
        L39:
            if (AccountService.a.isLogin().booleanValue() == true) goto L43;
            FLogger.a.i("CommerceMembershipConfigManager", "goToMembershipPageFromZlink: not login scene=" + this.$scene);
            return Unit.INSTANCE;
        L43:
            if (x1.a.a() == false) goto L47;
            FLogger.a.i("CommerceMembershipConfigManager", "goToMembershipPageFromZlink: minor mode scene=" + this.$scene);
            return Unit.INSTANCE;
        L47:
            if (NetworkUtils.isNetworkAvailable(AppHost.a.getApplication()) == true) goto L50;
            FLogger.a.i("CommerceMembershipConfigManager", "goToMembershipPageFromZlink: no network scene=" + this.$scene);
            return Unit.INSTANCE;
        L50:
            j r2 = (j) r12.element;
            if (r2 == null) goto L53;
            String r3 = r2.a;
        L55:
            if (r3 != null) goto L57;
        L60:
            boolean r4 = true;
        L61:
            if (r4 == true) goto L109;
        L69:
            j r110 = (j) r12.element;
            if (r110 == null) goto L72;
            String r111 = r110.a;
        L73:
            if (r111 != null) goto L75;
        L78:
            boolean r20 = true;
        L79:
            if (r20 == false) goto L103;
            FLogger.a.i("CommerceMembershipConfigManager", "goToMembershipPageFromZlink: zlink text is empty scene=" + this.$scene);
            return Unit.INSTANCE;
        L103:
            if (CommerceMembershipConfigManager.c.compareAndSet(false, true) == true) goto L111;
            FLogger.a.i("CommerceMembershipConfigManager", "goToMembershipPageFromZlink: request already in progress, skip duplicate scene=" + this.$scene);
            return Unit.INSTANCE;
        L111:
            Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L88
            Object r112 = Result.constructor-impl(y0.j(r111));     // Catch: Throwable -> L88
        L91:
            if (Result.isFailure-impl(r112) == false) goto L94;
            r112 = null;
        L94:
            if (f.a((Uri) r112) == false) goto L96;
            Lazy r113 = i.a;     // Catch: Throwable -> L98
            j r114 = new j(null);     // Catch: Throwable -> L98
            Intrinsics.checkNotNullParameter(r114, "info");     // Catch: Throwable -> L98
            ((Keva) i.b.getValue()).storeString("membership_zlink_info", GsonProtectorUtils.toJson((Gson) i.a.getValue(), r114));     // Catch: Throwable -> L98
        L96:
            CommerceMembershipConfigManager.c.set(false);
            return Unit.INSTANCE;
        L88:
            th = move-exception;
            Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L98
            r112 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L98
        L98:
            th = move-exception;
            CommerceMembershipConfigManager.c.set(false);
            throw th;
        L75:
            if (r111.length() == 0) goto L78;
            r20 = false;
            goto L79
        L72:
            r111 = null;
            goto L73
        L109:
            j r23 = (j) ((Gson) i.a.getValue()).fromJson(((Keva) i.b.getValue()).getString("membership_zlink_info", ""), j.class);     // Catch: Exception -> L66
            if (r23 != null) goto L68;
            r23 = new j(null);     // Catch: Exception -> L66
        L68:
            r12.element = r23;
        L66:
            e = move-exception;
            FLogger.a.e("CommerceMembershipZlinkManager", "getZlinkInfo error: " + e);
            r23 = new j(null);
            goto L68
        L57:
            if (r3.length() == 0) goto L60;
            r4 = false;
            goto L61
        L53:
            r3 = null;
            goto L55
        L102:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public CommerceMembershipConfigManager$goToMembershipPageFromZlink$1(String r1, String r2, Continuation<? super CommerceMembershipConfigManager$goToMembershipPageFromZlink$1> r3) {
        this.$text = r1;
        this.$scene = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new CommerceMembershipConfigManager$goToMembershipPageFromZlink$1(this.$text, this.$scene, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        CoroutineDispatcher r8 = Dispatchers.getIO();
        AnonymousClass1 r2 = new AnonymousClass1(this.$text, this.$scene, null);
        this.label = 1;
        if (BuildersKt.withContext(r8, r2, this) != r0) goto L12;
        return r0;
    }
}
