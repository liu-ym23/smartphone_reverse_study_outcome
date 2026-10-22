package com.larus.common.account.bdauth.impl;

import android.app.Activity;
import com.larus.account.bdauth.api.UserInfoRequest;
import com.larus.common.account.bdauth.api.AuthorizeApi;
import com.larus.common.baidunavi.api.bean.consts.BaiduNaviStatus;
import com.larus.login.api.IBdauthApi;
import com.larus.network.FlowHttpConnection;
import com.larus.nova.auth.AccountGroupAuthActivity;
import com.larus.nova.view.FlowBDAuthorizeActivity;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u001e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0096@¢\u0006\u0002\u0010\u0013J\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u0016H\u0096@¢\u0006\u0002\u0010\u0017R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/larus/common/account/bdauth/impl/BdauthServiceImpl;", "Lcom/larus/login/api/IBdauthApi;", "<init>", "()V", "authorizeModel", "Lcom/larus/common/account/bdauth/model/CustomBDAuthorizeModel;", "getAuthorizeModel", "()Lcom/larus/common/account/bdauth/model/CustomBDAuthorizeModel;", "authorizeModel$delegate", "Lkotlin/Lazy;", "needSaveActivityWhenFinishAll", "", "activity", "Landroid/app/Activity;", "requestUserInfo", "Lcom/larus/network/bean/HttpDataResult;", "Lcom/larus/account/bdauth/api/ProfileOverviewResponse;", "request", "Lcom/larus/account/bdauth/api/UserInfoRequest;", "(Lcom/larus/account/bdauth/api/UserInfoRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestOpenAuthCode", "Lcom/larus/account/bdauth/api/DoubaoOpenAuthCodeResult;", "Lcom/larus/account/bdauth/api/DoubaoOpenAuthCodeRequest;", "(Lcom/larus/account/bdauth/api/DoubaoOpenAuthCodeRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BdauthServiceImpl implements IBdauthApi {
    public static final /* synthetic */ int b = 0;
    public final Lazy a;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.larus.common.account.bdauth.impl.BdauthServiceImpl$requestUserInfo$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.common.account.bdauth.impl.BdauthServiceImpl", f = "BdauthServiceImpl.kt", i = {}, l = {31}, m = "requestUserInfo", n = {}, s = {})
    public static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ BdauthServiceImpl this$0;

        public AnonymousClass1(BdauthServiceImpl r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.requestUserInfo(null, this);
        }
    }

    static {
    }

    public BdauthServiceImpl() {
        this.a = LazyKt.lazy(new c());
    }

    public final boolean a(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        if ((r2 instanceof FlowBDAuthorizeActivity) == false) goto L5;
    L8:
        return true;
    L5:
        if ((r2 instanceof AccountGroupAuthActivity) == true) goto L8;
        return false;
    }

    public final Object b(t38.a r4, Continuation<? super t38.b> r5) {
        return BuildersKt.withContext(Dispatchers.getIO(), new BdauthServiceImpl$requestOpenAuthCode$2(r4, this, null), r5);
    }

    public final Object requestUserInfo(UserInfoRequest r11, Continuation<? super dm9.a<t38.c>> r12) {
        if ((r12 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        AnonymousClass1 r8 = r0;
        Object r13 = r8.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r8.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r13);
    L18:
        return (dm9.a) r13;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        AuthorizeApi.a r14 = AuthorizeApi.a;
        BdauthServiceImpl$requestUserInfo$result$1 r4 = new BdauthServiceImpl$requestUserInfo$result$1(r11, null);
        r8.label = 1;
        r14.getClass();
        FlowHttpConnection r15 = FlowHttpConnection.a;
        r13 = FlowHttpConnection.g("Basic", AuthorizeApi.class, r4, true, null, null, null, r8, BaiduNaviStatus.NO_PERMISSION);
        if (r13 != r2) goto L18;
        return r2;
    L7:
        r0 = new AnonymousClass1(this, r12);
        goto L8
    }
}
