package com.ss.android.lark.passport;

import android.util.Base64;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.active.user.api.IGlobalActiveUserManager;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.api.IOnlineOfflineService;
import com.ss.android.lark.officesdk.api.OfficeSDKPassportUserAction;
import com.ss.android.lark.passport.assemble.PassportUserApi;
import com.ss.android.lark.passport.assemble.f;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.passport.signinsdk_api.entity.EnvConst$UNIT;
import com.ss.android.lark.passport.signinsdk_api.feature.context.OfficeSDKLogoutContext;
import com.ss.android.lark.passport.signinsdk_api.feature.listener.logout.LogoutReason;
import com.ss.android.lark.passport_user.api.IUserListService;
import com.ss.android.lark.passportc.api.ReturnType;
import com.ss.android.lark.passportc.api.Scene;
import com.ss.android.lark.passportc.entity.UserState;
import com.ss.android.lark.passportc.internal.r;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.LarkContext;
import dagger.Lazy;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt__LimitKt$take$;
import kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Singleton
public final class OnlineOfflineService implements IOnlineOfflineService {
    public static final Companion g = null;
    public final Lazy<IGlobalActiveUserManager> a;
    public final IUserListService b;
    public final com.ss.android.lark.passport.dpop.b c;
    public final d d;
    public final StateFlowImpl e;
    public final CoroutineScope f;

    public static final class Companion {
        public Companion() {
        }

        public final Object a(String r18, Continuation<? super Result<? extends User>> r19) {
            if ((r19 instanceof OnlineOfflineService$Companion$fetchUser$1) == false) goto L7;
            OnlineOfflineService$Companion$fetchUser$1 r1 = (OnlineOfflineService$Companion$fetchUser$1) r19;
            int r2 = r1.label;
            if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
            r1.label = r2 - Integer.MIN_VALUE;
        L8:
            Object r0 = r1.result;
            Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r4 = r1.label;
            if (r4 == 0) goto L14;
            if (r4 != 1) goto L13;
            long r5 = r1.J$0;
            Ref.ObjectRef r6 = (Ref.ObjectRef) r1.L$2;
            Ref.ObjectRef r7 = (Ref.ObjectRef) r1.L$1;
            String r8 = (String) r1.L$0;
            ResultKt.throwOnFailure(r0);
            final Ref.ObjectRef r9 = r6;
            final Ref.ObjectRef r10 = r7;
            final long r11 = r5;
            final String r12 = r8;
        L73:
            Result r13 = (Result) r0;
            final Object r14 = r13.unbox-impl();
            PassportApmEvent.a.q(new OnlineOfflineService$Companion$fetchUser$4$1(r12, r14, r11, r9, r10));
            return r13.unbox-impl();
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r0);
            Log.i("OnlineOfflineService", "fetchUser: " + r18.length());
            final String r15 = "/accounts/web/user";
            long r16 = System.currentTimeMillis();
            Ref.ObjectRef r17 = new Ref.ObjectRef();
            Ref.ObjectRef r110 = new Ref.ObjectRef();
            PassportApmEvent.a.q(new OnlineOfflineService$Companion$fetchUser$2(r15));
            gpb.a r20 = (gpb.a) ApiUtils.getApi(gpb.a.class);
            if (com.ss.android.lark.passport.a.a() == true) goto L75;
            Integer r21 = null;
        L32:
            if (r21 == null) goto L34;
            int r22 = r21.intValue();
        L35:
            String r23 = r20.getTenantBrand();
            Intrinsics.checkNotNull(r20);
            if (r22 != r20.envType()) goto L38;
            String r24 = r20.getUserUnit();
        L46:
            List r25 = jcb.b.c().p0("passport_accounts", r22, r24, r23);
            if (r25 == null) goto L49;
            String r26 = (String) CollectionsKt.firstOrNull(r25);
        L50:
            if (r26 != null) goto L53;
            r26 = "";
        L53:
            if (StringsKt.isBlank(r26) == false) goto L63;
            OnlineOfflineService.g.getClass();
            if (Intrinsics.areEqual(r23, "feishu") == true) goto L57;
            r26 = "accounts.larksuite.com";
            goto L63
        L57:
            if (r22 != 2) goto L59;
            r26 = "accounts.feishu-boe.cn";
            goto L63
        L59:
            if (r22 == 3) goto L61;
            r26 = "accounts.feishu.cn";
            goto L63
        L61:
            r26 = "accounts.feishu-pre.cn";
        L63:
            String r27 = StringsKt.trimEnd(StringsKt.trim(r26).toString(), new char[]{'/'});
            if (StringsKt.startsWith(r27, "http://", true) == false) goto L66;
        L69:
            Log.i("OnlineOfflineService", "domain:" + r27 + ", envType:" + r22 + ", userUnit:" + r24 + ", brand:" + r23);
            CoroutineDispatcher r28 = Dispatchers.getIO();
            OnlineOfflineService$Companion$fetchUser$3 r29 = new OnlineOfflineService$Companion$fetchUser$3(r27, "/accounts/web/user", r18, r17, r110, null);
            r1.L$0 = "/accounts/web/user";
            r1.L$1 = r17;
            r1.L$2 = r110;
            r1.J$0 = r16;
            r1.label = 1;
            r0 = BuildersKt.withContext(r28, r29, r1);
            if (r0 != r3) goto L72;
            return r3;
        L72:
            r10 = r17;
            r9 = r110;
            r12 = "/accounts/web/user";
            r11 = r16;
            goto L73
        L66:
            if (StringsKt.startsWith(r27, "https://", true) == true) goto L69;
            r27 = "https://" + r27;
            goto L69
        L49:
            r26 = null;
            goto L50
        L38:
            boolean r30 = !r20.isFeishuBrand();
            if (r22 != 2) goto L43;
            if (r30 == false) goto L42;
            r24 = EnvConst$UNIT.BOE_VA;
            goto L46
        L42:
            r24 = EnvConst$UNIT.BOE_CN;
            goto L46
        L43:
            if (r30 == false) goto L45;
            r24 = "larksgaws";
            goto L46
        L45:
            r24 = "eu_nc";
            goto L46
        L34:
            r22 = r20.envType();
            goto L35
        L75:
            Result.Companion r31 = Result.Companion;     // Catch: Throwable -> L26
            Integer r32 = Integer.valueOf(LarkContext.getApplication().getSharedPreferences("office_sdk_env_prefs", 0).getInt("custom_env_value", -1));     // Catch: Throwable -> L26
            if (r32.intValue() == (-1)) goto L20;
            boolean r33 = true;
        L21:
            if (r33 == true) goto L24;
            r32 = null;
        L24:
            Object r34 = Result.constructor-impl(r32);     // Catch: Throwable -> L26
        L29:
            if (Result.isFailure-impl(r34) == false) goto L31;
            r34 = null;
        L31:
            r21 = (Integer) r34;
            goto L32
        L20:
            r33 = false;
        L26:
            th = move-exception;
            Result.Companion r35 = Result.Companion;
            r34 = Result.constructor-impl(ResultKt.createFailure(th));
        L7:
            r1 = new OnlineOfflineService$Companion$fetchUser$1(this, r19);
            goto L8
        }
    }

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[OfficeSDKPassportUserAction.values().length];
            r0[OfficeSDKPassportUserAction.SWITCH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[OfficeSDKPassportUserAction.DOUBAO_CHANGE_BINDING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[OfficeSDKPassportUserAction.LOGOUT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.passport.OnlineOfflineService$offline$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.passport.OnlineOfflineService$offline$2", f = "OnlineOfflineService.kt", i = {}, l = {259}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ IOnlineOfflineService.OfflineParams $params;
        final /* synthetic */ z0<Result<IOnlineOfflineService.OfflineResult>> $resultFlow;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ OnlineOfflineService this$0;

        public AnonymousClass2(z0<Result<IOnlineOfflineService.OfflineResult>> r1, OnlineOfflineService r2, IOnlineOfflineService.OfflineParams r3, Continuation<? super AnonymousClass2> r4) {
            this.$resultFlow = r1;
            this.this$0 = r2;
            this.$params = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
            AnonymousClass2 r0 = new AnonymousClass2(this.$resultFlow, this.this$0, this.$params, r6);
            r0.L$0 = r5;
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
            if (r1 == 0) goto L12;
            if (r1 != 1) goto L11;
            z0<Result<IOnlineOfflineService.OfflineResult>> r2 = (z0) this.L$0;
            ResultKt.throwOnFailure(r11);     // Catch: Throwable -> L8
            Object r12 = ((Result) r11).unbox-impl();     // Catch: Throwable -> L8
        L31:
            ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L8
            Object r13 = Result.constructor-impl(new IOnlineOfflineService.OfflineResult());     // Catch: Throwable -> L8
        L36:
            r2.setValue(Result.box-impl(r13));
            return Unit.INSTANCE;
        L8:
            Throwable th = th;
        L35:
            Result.Companion r3 = Result.Companion;
            r13 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L36
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            ResultKt.throwOnFailure(r11);
            CoroutineScope r14 = (CoroutineScope) this.L$0;
            z0<Result<IOnlineOfflineService.OfflineResult>> r15 = this.$resultFlow;
            OnlineOfflineService r4 = this.this$0;
            IOnlineOfflineService.OfflineParams r5 = this.$params;
            Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L33
            IGlobalActiveUserManager r7 = (IGlobalActiveUserManager) r4.a.get();     // Catch: Throwable -> L33
            nua.d.a r8 = new nua.d.a();     // Catch: Throwable -> L33
            User r9 = r4.b.getForegroundUser();     // Catch: Throwable -> L33
            if (r9 == null) goto L16;
            Intrinsics.checkNotNullParameter(r9, "targetUser");     // Catch: Throwable -> L33
            r8.a = new com.ss.android.lark.passportc.impl.v2.entity.d(r9, UserState.ABSENT, false);     // Catch: Throwable -> L33
        L16:
            nua.d r10 = new nua.d(r8.a, r8.b);     // Catch: Throwable -> L33
            com.ss.android.lark.passportc.api.d r16 = new com.ss.android.lark.passportc.api.d(true, null, ReturnType.Foreground, 46);     // Catch: Throwable -> L33
            OfficeSDKPassportUserAction r17 = r5.getAction();     // Catch: Throwable -> L33
            int r18 = a.a[r17.ordinal()];     // Catch: Throwable -> L33
            if (r18 != 1) goto L19;
            OfficeSDKLogoutContext.Action r19 = OfficeSDKLogoutContext.Action.SWITCH;     // Catch: Throwable -> L33
        L27:
            OfficeSDKLogoutContext r20 = new OfficeSDKLogoutContext(r19);     // Catch: Throwable -> L33
            this.L$0 = r15;     // Catch: Throwable -> L33
            this.label = 1;     // Catch: Throwable -> L33
            Object r21 = r7.b(r10, r16, r20, this);     // Catch: Throwable -> L33
            if (r21 != r0) goto L30;
            return r0;
        L30:
            r2 = r15;
            r12 = r21;
            goto L31
        L19:
            if (r18 != 2) goto L21;
            r19 = OfficeSDKLogoutContext.Action.DOUBAO_CHANGE_BINDING;     // Catch: Throwable -> L33
            goto L27
        L21:
            if (r18 != 3) goto L24;
            r19 = OfficeSDKLogoutContext.Action.LOGOUT;     // Catch: Throwable -> L33
            goto L27
        L24:
            throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L33
        L33:
            th = move-exception;
            r2 = r15;
            th = th;
            goto L35
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.passport.OnlineOfflineService$online$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.passport.OnlineOfflineService$online$2", f = "OnlineOfflineService.kt", i = {0, 0, 1, 1, 1}, l = {208, 214}, m = "invokeSuspend", n = {"$this$invokeSuspend_u24lambda_u243", "fetching", "$this$invokeSuspend_u24lambda_u243", "fetching", "user"}, s = {"L$2", "L$3", "L$1", "L$2", "L$3"})
    public static final class C03112 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ IOnlineOfflineService.OnlineParams $params;
        final /* synthetic */ z0<Result<IOnlineOfflineService.OnlineResult>> $resultFlow;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        final /* synthetic */ OnlineOfflineService this$0;

        public C03112(OnlineOfflineService r1, z0<Result<IOnlineOfflineService.OnlineResult>> r2, IOnlineOfflineService.OnlineParams r3, Continuation<? super C03112> r4) {
            this.this$0 = r1;
            this.$resultFlow = r2;
            this.$params = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
            C03112 r0 = new C03112(this.this$0, this.$resultFlow, this.$params, r6);
            r0.L$0 = r5;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r19) {
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r3 = this.label;
            if (r3 == 0) goto L18;
            if (r3 == 1) goto L13;
            if (r3 != 2) goto L12;
            z0<Result<IOnlineOfflineService.OnlineResult>> r4 = (z0) this.L$4;
            User r0 = (User) this.L$3;
            Deferred r5 = (Deferred) this.L$2;
            CoroutineScope r6 = (CoroutineScope) this.L$1;
            OnlineOfflineService r7 = (OnlineOfflineService) this.L$0;
            ResultKt.throwOnFailure(r19);     // Catch: Throwable -> L9
            Object r8 = ((Result) r19).unbox-impl();     // Catch: Throwable -> L9
            CoroutineScope r9 = r6;
        L56:
            ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L9
            BuildersKt.launch$default(r9, Dispatchers.getIO(), null, new OnlineOfflineService$online$2$1$2(r5, r7, null), 2, null);     // Catch: Throwable -> L9
            Object r1 = Result.constructor-impl(new IOnlineOfflineService.OnlineResult(r0));     // Catch: Throwable -> L9
        L62:
            r4.setValue(Result.box-impl(r1));
            return Unit.INSTANCE;
        L9:
            th = th;
            z0<Result<IOnlineOfflineService.OnlineResult>> r10 = r4;
        L61:
            Result.Companion r11 = Result.Companion;
            r1 = Result.constructor-impl(ResultKt.createFailure(th));
            r4 = r10;
            goto L62
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L13:
            r10 = (z0) this.L$4;
            Deferred r12 = (Deferred) this.L$3;
            CoroutineScope r13 = (CoroutineScope) this.L$2;
            IOnlineOfflineService.OnlineParams r14 = (IOnlineOfflineService.OnlineParams) this.L$1;
            OnlineOfflineService r15 = (OnlineOfflineService) this.L$0;
            ResultKt.throwOnFailure(r19);     // Catch: Throwable -> L16
            CoroutineScope r16 = r13;
            Deferred r17 = r12;
            Object r18 = r19;
        L39:
            Object r20 = ((Result) r18).unbox-impl();     // Catch: Throwable -> L16
            ResultKt.throwOnFailure(r20);     // Catch: Throwable -> L16
            User r21 = (User) r20;     // Catch: Throwable -> L16
            Companion r22 = OnlineOfflineService.g;     // Catch: Throwable -> L16
            r15.getClass();     // Catch: Throwable -> L16
            String r23 = r21.userId;     // Catch: Throwable -> L16
            User r110 = r15.b.getForegroundUser();     // Catch: Throwable -> L16
            if (r110 == null) goto L42;
            String r111 = r110.userId;     // Catch: Throwable -> L16
        L44:
            if (Intrinsics.areEqual(r23, r111) == true) goto L46;
            r21.setLastUseTimestamp(System.currentTimeMillis());     // Catch: Throwable -> L16
        L46:
            r15.b.t(CollectionsKt.listOf(r21), r21.userId, IUserListService.UserLoginSource.ByLogin);     // Catch: Throwable -> L16
            r0 = (User) r20;     // Catch: Throwable -> L16
            z0<Result<IOnlineOfflineService.OnlineResult>> r112 = r10;
            CoroutineScope r24 = r16;
            r5 = r17;
            IOnlineOfflineService.OnlineParams r113 = r14;
            r7 = r15;
        L48:
            IGlobalActiveUserManager r25 = (IGlobalActiveUserManager) r7.a.get();     // Catch: Throwable -> L59
            nua.d.a r26 = new nua.d.a();     // Catch: Throwable -> L59
            UserState r27 = UserState.ONLINE;     // Catch: Throwable -> L59
            Intrinsics.checkNotNullParameter(r0, "targetUser");     // Catch: Throwable -> L59
            Intrinsics.checkNotNullParameter(r27, "targetState");     // Catch: Throwable -> L59
            com.ss.android.lark.passportc.impl.v2.entity.d r28 = new com.ss.android.lark.passportc.impl.v2.entity.d(r0, r27, true);     // Catch: Throwable -> L59
            r26.a = r28;     // Catch: Throwable -> L59
            nua.d r29 = new nua.d(r28, r26.b);     // Catch: Throwable -> L59
            ReturnType r30 = ReturnType.Foreground;     // Catch: Throwable -> L59
            if (r113.isFastOnline() == false) goto L51;
            Scene r31 = Scene.FAST_ONLINE;     // Catch: Throwable -> L59
        L52:
            com.ss.android.lark.passportc.api.d r114 = new com.ss.android.lark.passportc.api.d(true, r31, r30, 38);     // Catch: Throwable -> L59
            this.L$0 = r7;     // Catch: Throwable -> L59
            this.L$1 = r24;     // Catch: Throwable -> L59
            this.L$2 = r5;     // Catch: Throwable -> L59
            this.L$3 = r0;     // Catch: Throwable -> L59
            this.L$4 = r112;     // Catch: Throwable -> L59
            this.label = 2;     // Catch: Throwable -> L59
            r8 = r25.b(r29, r114, r.a, this);     // Catch: Throwable -> L59
            if (r8 != r2) goto L55;
            return r2;
        L55:
            r9 = r24;
            r4 = r112;
        L59:
            th = th;
            r10 = r112;
            goto L61
        L51:
            r31 = Scene.FIRST_ONLINE;     // Catch: Throwable -> L59
            goto L52
        L42:
            r111 = null;
        L16:
            th = th;
            goto L61
        L18:
            ResultKt.throwOnFailure(r19);
            CoroutineScope r32 = (CoroutineScope) this.L$0;
            String r33 = this.this$0.c.getAccessToken();
            Log.i("OnlineOfflineService", "token:" + r33.length());
            r112 = this.$resultFlow;
            OnlineOfflineService r115 = this.this$0;
            IOnlineOfflineService.OnlineParams r116 = this.$params;
            Result.Companion r34 = Result.Companion;     // Catch: Throwable -> L59
            String r35 = (String) CollectionsKt.getOrNull(StringsKt.split$default(r33, new char[]{'.'}, false, 0, 6, null), 1);     // Catch: Throwable -> L59
            if (r35 == null) goto L24;
            JSONObject r36 = JSON.parseObject(new String(Base64.decode(r35, 8), Charsets.UTF_8));     // Catch: Throwable -> L59
            if (r36 == null) goto L24;
            String r117 = r36.getString("uid");     // Catch: Throwable -> L59
        L25:
            User r118 = r115.b.getForegroundUser();     // Catch: Throwable -> L59
            r17 = BuildersKt.async$default(r32, null, null, new OnlineOfflineService$online$2$1$fetching$1(r33, null), 3, null);     // Catch: Throwable -> L59
            StringBuilder r37 = new StringBuilder("online, uidInJwt:");     // Catch: Throwable -> L59
            r37.append(r117);     // Catch: Throwable -> L59
            r37.append(", userLocal:");     // Catch: Throwable -> L59
            if (r118 == null) goto L28;
            String r119 = r118.userId;     // Catch: Throwable -> L59
        L29:
            r37.append(r119);     // Catch: Throwable -> L59
            Log.i("OnlineOfflineService", r37.toString());     // Catch: Throwable -> L59
            if (r118 != null) goto L32;
        L35:
            this.L$0 = r115;     // Catch: Throwable -> L59
            this.L$1 = r116;     // Catch: Throwable -> L59
            this.L$2 = r32;     // Catch: Throwable -> L59
            this.L$3 = r17;     // Catch: Throwable -> L59
            this.L$4 = r112;     // Catch: Throwable -> L59
            this.label = 1;     // Catch: Throwable -> L59
            r18 = r17.await(this);     // Catch: Throwable -> L59
            if (r18 != r2) goto L38;
            return r2;
        L38:
            r15 = r115;
            r14 = r116;
            r16 = r32;
            r10 = r112;
            goto L39
        L32:
            if (Intrinsics.areEqual(r118.userId, r117) == false) goto L35;
            r113 = r116;
            r0 = r118;
            r24 = r32;
            r7 = r115;
            r5 = r17;
            goto L48
        L28:
            r119 = null;
        L24:
            r117 = null;
            goto L25
        }
    }

    static {
        g = new Companion();
    }

    @Override // com.ss.android.lark.officesdk.api.IOnlineOfflineService
    public final i1<IOnlineOfflineService.State> getState() {
        return this.e;
    }

    /* JADX WARN: Type inference failed for: r8v1, types: [com.ss.android.lark.passport.OnlineOfflineService$offline$$inlined$map$1, kotlinx.coroutines.flow.Flow<kotlin.Result<com.ss.android.lark.officesdk.api.IOnlineOfflineService$OfflineResult>>] */
    @Override // com.ss.android.lark.officesdk.api.IOnlineOfflineService
    public final Flow<Result<IOnlineOfflineService.OfflineResult>> offline(IOnlineOfflineService.OfflineParams r18) {
        Intrinsics.checkNotNullParameter(r18, "params");
        Log.i("OnlineOfflineService", "offline");
        final long r2 = System.currentTimeMillis();
        final User r4 = this.b.getForegroundUser();
        PassportApmEvent.a.q(new AnonymousClass1(r4));
        StateFlowImpl r6 = j1.a(null);
        final IOnlineOfflineService.State.DoingOffline r7 = new IOnlineOfflineService.State.DoingOffline(r18);
        final FlowKt__LimitKt$take$.inlined.unsafeFlow.1 r9 = new FlowKt__LimitKt$take$.inlined.unsafeFlow.1(new FlowKt__TransformKt$filterNotNull$.inlined.unsafeTransform.1(r6));
        final ?? r8 = new OnlineOfflineService$offline$$inlined$map$1(r9, r4, r2);
        IOnlineOfflineService.State r3 = (IOnlineOfflineService.State) this.e.getValue();
        if ((r3 instanceof IOnlineOfflineService.State.Online) == true) goto L5;
    L9:
        Result.Companion r1 = Result.Companion;
        r6.setValue(Result.box-impl(Result.constructor-impl(ResultKt.createFailure(new IllegalStateException("")))));
        return r8;
    L5:
        if (this.e.compareAndSet(r3, r7) == false) goto L9;
        PassportUserApi.a r5 = PassportUserApi.Companion;
        LogoutReason r10 = LogoutReason.PlaceHolder;
        List r11 = CollectionsKt.listOfNotNull(r4);
        r5.getClass();
        Intrinsics.checkNotNullParameter(r10, "reason");
        Intrinsics.checkNotNullParameter(r11, "logoutUsers");
        CoreThreadPool.getSerialTaskHandler().post(new f(r10, r11));
        BuildersKt.launch$default(this.f, null, null, new AnonymousClass2(r6, this, r18, null), 3, null);
        return new OnlineOfflineService$offline$$inlined$map$2(r8, this, r7, r4);
    }

    /* JADX WARN: Type inference failed for: r5v1, types: [com.ss.android.lark.passport.OnlineOfflineService$online$$inlined$map$1, kotlinx.coroutines.flow.Flow<kotlin.Result<com.ss.android.lark.officesdk.api.IOnlineOfflineService$OnlineResult>>] */
    @Override // com.ss.android.lark.officesdk.api.IOnlineOfflineService
    public final Flow<Result<IOnlineOfflineService.OnlineResult>> online(final IOnlineOfflineService.OnlineParams r13) {
        Intrinsics.checkNotNullParameter(r13, "params");
        Log.i("OnlineOfflineService", "online, fast:" + r13.isFastOnline());
        final long r0 = System.currentTimeMillis();
        PassportApmEvent.a.q(C03101.INSTANCE);
        StateFlowImpl r3 = j1.a(null);
        final IOnlineOfflineService.State.DoingOnline r4 = new IOnlineOfflineService.State.DoingOnline(r13);
        final FlowKt__LimitKt$take$.inlined.unsafeFlow.1 r6 = new FlowKt__LimitKt$take$.inlined.unsafeFlow.1(new FlowKt__TransformKt$filterNotNull$.inlined.unsafeTransform.1(r3));
        final ?? r5 = new OnlineOfflineService$online$$inlined$map$1(r6, r0);
        if (this.e.compareAndSet(IOnlineOfflineService.State.Offline.INSTANCE, r4) == true) goto L6;
        Result.Companion r14 = Result.Companion;
        r3.setValue(Result.box-impl(Result.constructor-impl(ResultKt.createFailure(new IllegalStateException("")))));
        return r5;
    L6:
        BuildersKt.launch$default(this.f, null, null, new C03112(this, r3, r13, null), 3, null);
        return new OnlineOfflineService$online$$inlined$map$2(r5, this, r4, r13);
    }

    @Inject
    public OnlineOfflineService(Lazy<IGlobalActiveUserManager> r2, IUserListService r3, com.ss.android.lark.passport.dpop.b r4, d r5) {
        Intrinsics.checkNotNullParameter(r2, "globalActiveUserManager");
        Intrinsics.checkNotNullParameter(r3, "userListService");
        Intrinsics.checkNotNullParameter(r4, "tokenService");
        Intrinsics.checkNotNullParameter(r5, "userListFetcherTrigger");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = j1.a(IOnlineOfflineService.State.Offline.INSTANCE);
        this.f = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault());
    }
}
