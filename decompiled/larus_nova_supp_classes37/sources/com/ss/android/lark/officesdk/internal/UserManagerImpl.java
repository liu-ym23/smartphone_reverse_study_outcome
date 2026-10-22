package com.ss.android.lark.officesdk.internal;

import android.os.SystemClock;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.api.ILoginCallback;
import com.ss.android.lark.officesdk.api.ILogoutCallback;
import com.ss.android.lark.officesdk.api.IOfficeSDKHostSessionProvider;
import com.ss.android.lark.officesdk.api.IOfficeSDKUserHandle;
import com.ss.android.lark.officesdk.api.IOnlineOfflineService;
import com.ss.android.lark.officesdk.api.IUserManager;
import com.ss.android.lark.officesdk.api.OfficeSDKDriveErrorCodes;
import com.ss.android.lark.officesdk.api.OfficeSDKDriveResult;
import com.ss.android.lark.officesdk.api.OfficeSDKHostSession;
import com.ss.android.lark.officesdk.api.OfficeSDKPassportUserAction;
import com.ss.android.lark.officesdk.api.OfficeSDKUserAccessException;
import com.ss.android.lark.officesdk.api.api.OfficeSDKUserApi;
import com.ss.android.lark.officesdk.api.init.IOfficeSDKLifeCycle;
import com.ss.android.lark.officesdk.api.init.IOfficeSDKTokenProvider;
import com.ss.android.lark.officesdk.api.init.IOfficeSDKUserServiceInjector;
import com.ss.android.lark.officesdk.container.OfficeSDKGlobalScope;
import com.ss.android.lark.officesdk.container.OfficeSDKUserComponent;
import com.ss.android.lark.officesdk.container.OfficeSDKUserEntryPoint;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.settings.configs.MmUploadRetryConfigSetting;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.statistics.Statistics;
import dagger.hilt.EntryPoints;
import io.reactivex.Single;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@OfficeSDKGlobalScope
public final class UserManagerImpl implements IUserManager {
    public static final /* synthetic */ int q = 0;
    public final IOnlineOfflineService a;
    public final IOfficeSDKTokenProvider b;
    public final IOfficeSDKLifeCycle c;
    public final AtomicReference<String> d;
    public final CoroutineScope e;
    public final Function1<? super Continuation<? super Unit>, ? extends Object> f;
    public final Function0<? extends OfficeSDKUserApi> g;
    public final Function0<? extends IOfficeSDKHostSessionProvider> h;
    public final Function0<? extends IOfficeSDKUserServiceInjector> i;
    public volatile OfficeSDKHostSession j;
    public final StateFlowImpl k;
    public final Object l;
    public final ArrayDeque<c> m;
    public c n;
    public final Channel<Unit> o;
    public final AtomicBoolean p;

    public static abstract class a {

        /* JADX INFO: renamed from: com.ss.android.lark.officesdk.internal.UserManagerImpl$a$a, reason: collision with other inner class name */
        public static final class C0010a extends a {
            public final Throwable a;

            public C0010a(Throwable r2) {
                Intrinsics.checkNotNullParameter(r2, "error");
                this.a = r2;
            }
        }

        public static final class b extends a {
            public b() {
            }
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.internal.UserManagerImpl$awaitUserApi$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.internal.UserManagerImpl", f = "UserManagerImpl.kt", i = {0}, l = {518}, m = "awaitUserApi", n = {"timeoutMs"}, s = {"J$0"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        long J$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ UserManagerImpl this$0;

        public AnonymousClass1(UserManagerImpl r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.awaitUserApi(0, this);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.internal.UserManagerImpl$awaitUserApi$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/officesdk/api/api/OfficeSDKUserApi;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.internal.UserManagerImpl$awaitUserApi$2", f = "UserManagerImpl.kt", i = {}, l = {525}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super OfficeSDKUserApi>, Object> {
        int label;
        final /* synthetic */ UserManagerImpl this$0;

        public AnonymousClass2(UserManagerImpl r1, Continuation<? super AnonymousClass2> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass2(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super OfficeSDKUserApi> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r7);
        L29:
            a r8 = (a) r7;
            if ((r8 instanceof a.b) == false) goto L37;
            OfficeSDKUserApi r9 = (OfficeSDKUserApi) this.this$0.g.invoke();
            if (r9 == null) goto L35;
            return r9;
        L35:
            throw new OfficeSDKUserAccessException(OfficeSDKDriveErrorCodes.LOGIN_FAILED, "userApi unavailable after login", null, 4, null);
        L37:
            if ((r8 instanceof a.C0010a) == false) goto L44;
            a.C0010a r10 = (a.C0010a) r8;
            String r2 = r10.a.getMessage();
            if (r2 != null) goto L42;
            r2 = "login failed";
        L42:
            throw new OfficeSDKUserAccessException(OfficeSDKDriveErrorCodes.LOGIN_FAILED, r2, r10.a);
        L44:
            throw new NoWhenBranchMatchedException();
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            UserManagerImpl r11 = this.this$0;
            Object r3 = r11.l;
            monitor-enter(r3);
        L45:
            th = move-exception;
            throw th;
        L11:
            if (r11.m.isEmpty() == false) goto L15;
            if (r11.n != null) goto L15;
            boolean r4 = true;
        L16:
            monitor-exit(r3);
            if (r4 == true) goto L20;
        L23:
            OfficeSDKUserApi r12 = null;
        L24:
            if (r12 == null) goto L26;
            return r12;
        L26:
            CompletableDeferred<a> r13 = this.this$0.g(null, null).a;
            this.label = 1;
            r7 = r13.await(this);
            if (r7 != r0) goto L29;
            return r0;
        L20:
            if (r11.d.get() == null) goto L23;
            r12 = (OfficeSDKUserApi) r11.g.invoke();
        L15:
            r4 = false;
            goto L16
        }
    }

    public static final class b {
    }

    public static abstract class c {
        public final CompletableDeferred<a> a;
        public boolean b;

        public static final class a extends c {
            public volatile OfficeSDKHostSession c;
            public final CopyOnWriteArrayList<ILoginCallback> d;

            public a(ILoginCallback r1, OfficeSDKHostSession r2) {
                this.c = r2;
                CopyOnWriteArrayList<ILoginCallback> r3 = new CopyOnWriteArrayList();
                this.d = r3;
                if (r1 == null) goto L6;
                r3.add(r1);
                return;
            }
        }

        public static final class b extends c {
            public final OfficeSDKPassportUserAction c;
            public final OfficeSDKHostSession d;
            public final CopyOnWriteArrayList<ILogoutCallback> e;

            public b(ILogoutCallback r2, OfficeSDKPassportUserAction r3, OfficeSDKHostSession r4) {
                Intrinsics.checkNotNullParameter(r3, "action");
                this.c = r3;
                this.d = r4;
                CopyOnWriteArrayList<ILogoutCallback> r5 = new CopyOnWriteArrayList();
                this.e = r5;
                if (r2 == null) goto L6;
                r5.add(r2);
                return;
            }
        }

        public c() {
            this.a = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        }
    }

    static {
    }

    public final void f() {
        StateFlowImpl r0 = this.k;
        r0.setValue(Integer.valueOf(((Number) r0.getValue()).intValue() + 1));
    }

    @Override // com.ss.android.lark.officesdk.api.IUserManager
    public final i1<IOnlineOfflineService.State> loginState() {
        return this.a.getState();
    }

    public static OfficeSDKUserApi i() {
        OfficeSDKUserComponent r0 = OfficeSDKManager.getOfficeSDKUserComponent();     // Catch: Exception -> L6
        if (r0 == null) goto L8;
        return ((OfficeSDKUserEntryPoint) EntryPoints.get(r0, OfficeSDKUserEntryPoint.class)).getOfficeSDKUserApi();
    L8:
        return null;
    L6:
        e = move-exception;
        Log.e("UserManagerImpl", "getOfficeSDKUserApi failed", e);
        goto L8
    }

    @Override // com.ss.android.lark.officesdk.api.IUserManager
    public final OfficeSDKUserApi getUserApi() {
        return i();
    }

    @Override // com.ss.android.lark.officesdk.api.IUserManager
    public final IOfficeSDKUserHandle createUserHandle(OfficeSDKHostSession r2) {
        Intrinsics.checkNotNullParameter(r2, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        return new i(r2, this);
    }

    public final OfficeSDKUserApi j(OfficeSDKHostSession r2) {
        Intrinsics.checkNotNullParameter(r2, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        if (this.d.get() != null) goto L5;
        return null;
    L5:
        if (Intrinsics.areEqual(this.j, r2) == true) goto L8;
        return null;
    L8:
        return (OfficeSDKUserApi) this.g.invoke();
    }

    public final void l(c r3) {
        Object r0 = this.l;
        monitor-enter(r0);
        r3.b = true;     // Catch: Throwable -> L8
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(r0);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.lark.officesdk.api.IUserManager
    public final void login(ILoginCallback r5) {
        Log.i("UserManagerImpl", "login called");
        if (OfficeSDKManager.isEmbeddedLarkHost() == false) goto L22;
        String r1 = OfficeSDKManager.getEmbeddedLarkCurrentUserId();
        if (r1 != null) goto L9;
        IllegalStateException r2 = new IllegalStateException("No embedded Feishu current user");
        Log.w("UserManagerImpl", "embedded feishu login skipped, no current user");
        if (r5 == null) goto L24;
        r5.onLoginError(r2);
        return;
    L24:
        return;
    L9:
        String r3 = this.d.getAndSet(r1);
        if (r3 != null) goto L12;
    L14:
        OfficeSDKManager.setCurrentUid$officesdk_core_release(r1);
        OfficeSDKUserApi r4 = i();
        if (r4 == null) goto L17;
        this.c.onLoginSuccess(r4);
        HashMap<String, com.ss.android.lark.officesdk.internal.b> r6 = g.a;
        Statistics.sendEvent("officesdk_login");
    L18:
        if (r5 == null) goto L20;
        r5.onLoginSuccess(r1);
    L20:
        Log.i("UserManagerImpl", "embedded feishu login success, uid=".concat(r1));
        return;
    L17:
        Log.e("UserManagerImpl", "embedded feishu login success but userApi is null");
        goto L18
    L12:
        if (Intrinsics.areEqual(r3, r1) == true) goto L14;
        OfficeSDKManager.clearCurrentUid$officesdk_core_release(r3);
        OfficeSDKManager.unregisterOfficeSDKUserComponent(r3);
        OfficeSDKManager.clearUserServices$officesdk_core_release(r3);
        this.c.onLogoutSuccess(r3);
        HashMap<String, com.ss.android.lark.officesdk.internal.b> r7 = g.a;
        Statistics.sendEvent("officesdk_logout");
        goto L14
    L22:
        g(r5, null);
    }

    @Override // com.ss.android.lark.officesdk.api.IUserManager
    public final Single<OfficeSDKDriveResult> loginRx(final OfficeSDKHostSession r8) {
        Intrinsics.checkNotNullParameter(r8, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        return Single.create(new UserManagerImpl$driveRx$1(this, new C02131(this, r8), MmUploadRetryConfigSetting.MAX_INTERVAL_MS, OfficeSDKDriveErrorCodes.LOGIN_FAILED));
    }

    @Override // com.ss.android.lark.officesdk.api.IUserManager
    public final Single<OfficeSDKDriveResult> logoutRx(final OfficeSDKHostSession r8) {
        Intrinsics.checkNotNullParameter(r8, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        return Single.create(new UserManagerImpl$driveRx$1(this, new C02141(this, r8), 5000, OfficeSDKDriveErrorCodes.LOGOUT_FAILED));
    }

    @Override // com.ss.android.lark.officesdk.api.IUserManager
    public final Object awaitUserApi(long r7, Continuation<? super OfficeSDKUserApi> r9) {
        if ((r9 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r9;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r7 = r0.J$0;
        ResultKt.throwOnFailure(r10);
    L24:
        OfficeSDKUserApi r11 = (OfficeSDKUserApi) r10;
        if (r11 == null) goto L28;
        return r11;
    L28:
        throw new OfficeSDKUserAccessException(OfficeSDKDriveErrorCodes.TIMEOUT, "awaitUserApi timed out after " + r7 + "ms", null, 4, null);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
        if (OfficeSDKManager.isEmbeddedLarkHost() == false) goto L21;
        OfficeSDKUserApi r8 = i();
        if (r8 == null) goto L20;
        return r8;
    L20:
        throw new OfficeSDKUserAccessException(OfficeSDKDriveErrorCodes.NOT_SUPPORTED, "awaitUserApi does not drive login for embedded host", null, 4, null);
    L21:
        AnonymousClass2 r12 = new AnonymousClass2(this, null);
        r0.J$0 = r7;
        r0.label = 1;
        r10 = TimeoutKt.c(r7, r12, r0);
        if (r10 != r2) goto L24;
        return r2;
    L7:
        r0 = new AnonymousClass1(this, r9);
        goto L8
    }

    public final c.a g(ILoginCallback r9, OfficeSDKHostSession r10) {
        Object r0 = this.l;
        monitor-enter(r0);
        c r1 = (c) this.m.lastOrNull();     // Catch: Throwable -> L37
        if (r1 != null) goto L8;
        r1 = this.n;     // Catch: Throwable -> L37
    L8:
        if ((r1 instanceof c.a) == true) goto L10;
    L29:
        c.a r2 = new c.a(r9, r10);     // Catch: Throwable -> L37
        this.m.add(r2);     // Catch: Throwable -> L37
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L37
        monitor-exit(r0);
        if (this.p.compareAndSet(false, true) == false) goto L35;
        BuildersKt.launch$default(this.e, null, null, new UserManagerImpl$startWorker$1(this, null), 3, null);
    L35:
        this.o.trySend-JP2dKIU(Unit.INSTANCE);
        return r2;
    L10:
        if (((c.a) r1).b == true) goto L29;
        OfficeSDKHostSession r3 = ((c.a) r1).c;     // Catch: Throwable -> L37
        if (r3 == null) goto L18;
        if (r10 == null) goto L18;
        if (Intrinsics.areEqual(r3, r10) == true) goto L18;
        boolean r4 = false;
    L19:
        if (r4 == false) goto L29;
        if (r9 == null) goto L23;
        ((c.a) r1).d.add(r9);     // Catch: Throwable -> L37
    L23:
        if (((c.a) r1).c != null) goto L26;
        if (r10 == null) goto L26;
        ((c.a) r1).c = r10;     // Catch: Throwable -> L37
    L26:
        Log.i("UserManagerImpl", "login joined in-flight command");     // Catch: Throwable -> L37
        c.a r5 = (c.a) r1;     // Catch: Throwable -> L37
        monitor-exit(r0);
        return r5;
    L18:
        r4 = true;
    L37:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.lark.officesdk.api.IUserManager
    public final void logout(ILogoutCallback r6, OfficeSDKPassportUserAction r7) {
        Intrinsics.checkNotNullParameter(r7, "action");
        String r0 = this.d.get();
        Log.i("UserManagerImpl", "logout called, currentUid=" + r0 + ", action=" + r7);
        if (OfficeSDKManager.isEmbeddedLarkHost() == false) goto L14;
        String r8 = this.d.getAndSet(null);
        if (r8 != null) goto L9;
        Log.w("UserManagerImpl", "embedded feishu logout, no user logged in");
        if (r6 == null) goto L21;
        r6.onLogoutError(new IllegalStateException("No user logged in"));
        return;
    L21:
        return;
    L9:
        OfficeSDKManager.clearCurrentUid$officesdk_core_release(r8);
        OfficeSDKManager.unregisterOfficeSDKUserComponent(r8);
        OfficeSDKManager.clearUserServices$officesdk_core_release(r8);
        if (r6 == null) goto L12;
        r6.onLogoutSuccess(r8);
    L12:
        this.c.onLogoutSuccess(r8);
        HashMap<String, com.ss.android.lark.officesdk.internal.b> r9 = g.a;
        Statistics.sendEvent("officesdk_logout");
        Log.i("UserManagerImpl", "embedded feishu logout success, uid=".concat(r8));
        return;
    L14:
        if (r0 != null) goto L19;
        Log.w("UserManagerImpl", "logout, no user logged in");
        if (r6 == null) goto L23;
        r6.onLogoutError(new IllegalStateException("No user logged in"));
        return;
    L23:
        return;
    L19:
        h(r6, r7, null);
    }

    @Inject
    public UserManagerImpl(IOnlineOfflineService r2, IOfficeSDKTokenProvider r3, IOfficeSDKLifeCycle r4) {
        Intrinsics.checkNotNullParameter(r2, "onlineOfflineService");
        Intrinsics.checkNotNullParameter(r3, "tokenProvider");
        Intrinsics.checkNotNullParameter(r4, "officeSDKLifeCycle");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = new AtomicReference(null);
        this.e = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
        this.f = new UserManagerImpl$sdkInitAwaiter$1(null);
        this.g = new UserManagerImpl$userApiProvider$1(this);
        this.h = UserManagerImpl$hostSessionProviderResolver$1.INSTANCE;
        this.i = UserManagerImpl$userServiceInjectorResolver$1.INSTANCE;
        this.k = j1.a(0);
        this.l = new Object();
        this.m = new ArrayDeque();
        this.o = ChannelKt.Channel$default(-1, null, null, 6, null);
        this.p = new AtomicBoolean(false);
    }

    public static final Object b(UserManagerImpl r13, c.a r14, Continuation r15) {
        r13.getClass();
        if ((r15 instanceof UserManagerImpl$executeLogin$1) == false) goto L7;
        UserManagerImpl$executeLogin$1 r0 = (UserManagerImpl$executeLogin$1) r15;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r16 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L18;
        if (r3 == 1) goto L17;
        if (r3 == 2) goto L16;
        if (r3 != 3) goto L15;
        long r4 = r0.J$0;
        r14 = (c.a) r0.L$0;
        ResultKt.throwOnFailure(r16);
    L52:
        Object r17 = ((Result) r16).unbox-impl();
        if (Result.isSuccess-impl(r17) == false) goto L78;
        long r5 = SystemClock.elapsedRealtime() - r4;
        Log.i("UserManagerImpl", "OfficeSDK_Login_Online_End: " + r5 + "ms");
        String r6 = ((IOnlineOfflineService.OnlineResult) r17).getUser().userId;
        r13.d.set(r6);
        r13.j = r14.c;
        OfficeSDKManager.setCurrentUid$officesdk_core_release(r6);
        OfficeSDKUserApi r7 = (OfficeSDKUserApi) r13.g.invoke();
        if (r7 == null) goto L66;
        IOfficeSDKUserServiceInjector r8 = (IOfficeSDKUserServiceInjector) r13.i.invoke();
        if (r8 == null) goto L66;
        r8.onUserLogin(r7);     // Catch: Throwable -> L60
        Object r9 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L60
    L62:
        Throwable r10 = Result.exceptionOrNull-impl(r9);
        if (r10 == null) goto L65;
        Log.e("UserManagerImpl", "userServiceInjector.onUserLogin failed", r10);
    L65:
        Result.box-impl(r9);
    L60:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
    L66:
        r13.l(r14);
        r13.f();
        r14.a.complete(new a.b());
        long r12 = SystemClock.elapsedRealtime();
        if (r7 == null) goto L69;
        r13.c.onLoginSuccess(r7);
        long r18 = SystemClock.elapsedRealtime() - r12;
        Log.i("UserManagerImpl", "OfficeSDK_Login_Lifecycle_End: " + r18 + "ms");
        HashMap<String, com.ss.android.lark.officesdk.internal.b> r19 = g.a;
        Statistics.sendEvent("officesdk_login");
    L70:
        long r20 = SystemClock.elapsedRealtime();
        Iterator<ILoginCallback> r110 = r14.d.iterator();
    L72:
        if (r110.hasNext() == false) goto L74;
        ILoginCallback r111 = r110.next();
        Intrinsics.checkNotNull(r6);
        r111.onLoginSuccess(r6);
        goto L72
    L74:
        long r112 = SystemClock.elapsedRealtime() - r20;
        Log.i("UserManagerImpl", "OfficeSDK_Login_Callback_End: " + r112 + "ms");
        if (r7 == null) goto L77;
        HashMap<String, com.ss.android.lark.officesdk.internal.b> r21 = g.a;
        JSONObject r22 = new JSONObject();
        r22.put("online_cost", r5);
        r22.put("lifecycle_cost", r18);
        r22.put("callback_cost", r112);
    L77:
        Log.i("UserManagerImpl", "login success, uid=" + r6);
        goto L78
    L69:
        Log.e("UserManagerImpl", "login success but userApi is null");
        r18 = 0;
    L78:
        Throwable r113 = Result.exceptionOrNull-impl(r17);
        if (r113 == null) goto L85;
        Log.e("UserManagerImpl", "login failed", r113);
        r13.l(r14);
        r14.a.complete(new a.C0010a(r113));
        Iterator<ILoginCallback> r114 = r14.d.iterator();
    L82:
        if (r114.hasNext() == false) goto L85;
        r114.next().onLoginError(r113);
    L85:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r14 = (c.a) r0.L$0;
        ResultKt.throwOnFailure(r16);
    L48:
        long r23 = SystemClock.elapsedRealtime();
        Flow<Result<IOnlineOfflineService.OnlineResult>> r115 = r13.a.online(new IOnlineOfflineService.OnlineParams(false, 1, null));
        r0.L$0 = r14;
        r0.J$0 = r23;
        r0.label = 3;
        r16 = kotlinx.coroutines.flow.e.s(r115, r0);
        if (r16 == r2) goto L94;
        r4 = r23;
        goto L52
    L94:
        return r2;
    L17:
        String r116 = (String) r0.L$1;
        c.a r24 = (c.a) r0.L$0;
        ResultKt.throwOnFailure(r16);
        Object r117 = ((Result) r16).unbox-impl();
    L31:
        if (Result.isSuccess-impl(r117) == false) goto L33;
        IOnlineOfflineService.OfflineResult r25 = (IOnlineOfflineService.OfflineResult) r117;
        r13.c.onLogoutSuccess(r116);
        HashMap<String, com.ss.android.lark.officesdk.internal.b> r118 = g.a;
        Statistics.sendEvent("officesdk_logout");
    L33:
        Throwable r119 = Result.exceptionOrNull-impl(r117);
        if (r119 == null) goto L36;
        Log.w("UserManagerImpl", "implicit drain failed, converging to offline anyway", r119);
    L36:
        r14 = r24;
    L45:
        Function1<? super Continuation<? super Unit>, ? extends Object> r120 = r13.f;
        r0.L$0 = r14;
        r0.L$1 = null;
        r0.label = 2;
        if (r120.invoke(r0) != r2) goto L48;
        return r2;
    L18:
        ResultKt.throwOnFailure(r16);
        String r121 = r13.d.get();
        if (r121 == null) goto L45;
        OfficeSDKHostSession r26 = r14.c;
        OfficeSDKHostSession r27 = r13.j;
        if (r26 == null) goto L37;
        if (r27 == null) goto L37;
        if (Intrinsics.areEqual(r26, r27) == true) goto L37;
        Log.i("UserManagerImpl", "login converging via implicit drain, switching host session");
        OfficeSDKPassportUserAction r28 = OfficeSDKPassportUserAction.SWITCH;
        r0.L$0 = r14;
        r0.L$1 = r121;
        r0.label = 1;
        Object r29 = r13.k(r121, r28, r0);
        if (r29 == r2) goto L92;
        r24 = r14;
        r116 = r121;
        r117 = r29;
        goto L31
    L92:
        return r2;
    L37:
        if (r26 == null) goto L40;
        if (r27 != null) goto L40;
        r13.j = r26;
        r13.f();
    L40:
        Log.i("UserManagerImpl", "login converged, already online");
        r13.l(r14);
        r14.a.complete(new a.b());
        Iterator<ILoginCallback> r122 = r14.d.iterator();
    L42:
        if (r122.hasNext() == false) goto L91;
        r122.next().onLoginSuccess(r121);
        goto L42
    L91:
        return Unit.INSTANCE;
    L7:
        r0 = new UserManagerImpl$executeLogin$1(r13, r15);
        goto L8
    }

    public static final Object c(UserManagerImpl r8, c.b r9, Continuation r10) {
        r8.getClass();
        if ((r10 instanceof UserManagerImpl$executeLogout$1) == false) goto L7;
        UserManagerImpl$executeLogout$1 r0 = (UserManagerImpl$executeLogout$1) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        String r12 = (String) r0.L$1;
        c.b r4 = (c.b) r0.L$0;
        ResultKt.throwOnFailure(r11);
        Object r13 = ((Result) r11).unbox-impl();
        String r14 = r12;
        r9 = r4;
        Object r5 = r13;
    L35:
        if (Result.isSuccess-impl(r5) == false) goto L41;
        IOnlineOfflineService.OfflineResult r6 = (IOnlineOfflineService.OfflineResult) r5;
        r8.l(r9);
        r9.a.complete(new a.b());
        Iterator<ILogoutCallback> r7 = r9.e.iterator();
    L38:
        if (r7.hasNext() == false) goto L40;
        r7.next().onLogoutSuccess(r14);
        goto L38
    L40:
        r8.c.onLogoutSuccess(r14);
        HashMap<String, com.ss.android.lark.officesdk.internal.b> r15 = g.a;
        Statistics.sendEvent("officesdk_logout");
        Log.i("UserManagerImpl", "logout success, uid=" + r14);
    L41:
        Throwable r16 = Result.exceptionOrNull-impl(r5);
        if (r16 == null) goto L48;
        Log.e("UserManagerImpl", "logout failed", r16);
        r8.l(r9);
        r9.a.complete(new a.C0010a(r16));
        Iterator<ILogoutCallback> r17 = r9.e.iterator();
    L45:
        if (r17.hasNext() == false) goto L48;
        r17.next().onLogoutError(r16);
    L48:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r11);
        r14 = r8.d.get();
        if (r14 != null) goto L21;
        Log.i("UserManagerImpl", "logout converged, no user online");
        r8.l(r9);
        r9.a.complete(new a.b());
        Iterator<ILogoutCallback> r18 = r9.e.iterator();
    L18:
        if (r18.hasNext() == false) goto L53;
        r18.next().onLogoutSuccess("");
        goto L18
    L53:
        return Unit.INSTANCE;
    L21:
        OfficeSDKHostSession r19 = r9.d;
        OfficeSDKHostSession r20 = r8.j;
        if (r19 == null) goto L31;
        if (r20 == null) goto L31;
        if (Intrinsics.areEqual(r19, r20) == true) goto L31;
        Log.i("UserManagerImpl", "logout converged, stale host session");
        r8.l(r9);
        r9.a.complete(new a.b());
        Iterator<ILogoutCallback> r21 = r9.e.iterator();
    L28:
        if (r21.hasNext() == false) goto L54;
        r21.next().onLogoutSuccess("");
        goto L28
    L54:
        return Unit.INSTANCE;
    L31:
        OfficeSDKPassportUserAction r22 = r9.c;
        r0.L$0 = r9;
        r0.L$1 = r14;
        r0.label = 1;
        r5 = r8.k(r14, r22, r0);
        if (r5 != r2) goto L35;
        return r2;
    L7:
        r0 = new UserManagerImpl$executeLogout$1(r8, r10);
        goto L8
    }

    public static final void d(UserManagerImpl r2, c r3, Throwable r4) {
        Object r5 = r2.l;
        monitor-enter(r5);
        boolean r0 = r3.b;     // Catch: Throwable -> L24
        r3.b = true;     // Catch: Throwable -> L24
        monitor-exit(r5);
        r3.a.complete(new a.C0010a(r4));
        if (r0 == false) goto L10;
        return;
    L10:
        if ((r3 instanceof c.a) == false) goto L16;
        Iterator<ILoginCallback> r6 = ((c.a) r3).d.iterator();
    L13:
        if (r6.hasNext() == false) goto L31;
        r6.next().onLoginError(r4);
        goto L13
    L31:
        return;
    L16:
        if ((r3 instanceof c.b) == false) goto L23;
        Iterator<ILogoutCallback> r7 = ((c.b) r3).e.iterator();
    L19:
        if (r7.hasNext() == false) goto L32;
        r7.next().onLogoutError(r4);
        goto L19
    L32:
        return;
    L23:
        throw new NoWhenBranchMatchedException();
    L24:
        th = move-exception;
        throw th;
    }

    public final Object e(OfficeSDKHostSession r17, long r18, Continuation<? super OfficeSDKUserApi> r20) {
        long r1 = r18;
        if ((r20 instanceof UserManagerImpl$awaitUserApiForSession$1) == false) goto L7;
        UserManagerImpl$awaitUserApiForSession$1 r4 = (UserManagerImpl$awaitUserApiForSession$1) r20;
        int r5 = r4.label;
        if ((r5 & Integer.MIN_VALUE) == 0) goto L7;
        r4.label = r5 - Integer.MIN_VALUE;
    L8:
        Object r3 = r4.result;
        Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r4.label;
        if (r7 == 0) goto L14;
        if (r7 != 1) goto L13;
        r1 = r4.J$0;
        ResultKt.throwOnFailure(r3);
    L19:
        OfficeSDKUserApi r8 = (OfficeSDKUserApi) r3;
        if (r8 == null) goto L23;
        return r8;
    L23:
        throw new OfficeSDKUserAccessException(OfficeSDKDriveErrorCodes.TIMEOUT, "awaitUserApi timed out after " + r1 + "ms", null, 4, null);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r3);
        IOfficeSDKHostSessionProvider r9 = (IOfficeSDKHostSessionProvider) this.h.invoke();
        if (r9 == null) goto L25;
        UserManagerImpl$awaitUserApiForSession$2 r10 = new UserManagerImpl$awaitUserApiForSession$2(this, r17, r9, null);
        r4.J$0 = r1;
        r4.label = 1;
        r3 = TimeoutKt.c(r1, r10, r4);
        if (r3 != r6) goto L19;
        return r6;
    L25:
        throw new OfficeSDKUserAccessException(OfficeSDKDriveErrorCodes.HOST_CAPABILITY_NOT_CONFIGURED, "hostSessionProvider not configured in OfficeSDKInitConfig", null, 4, null);
    L7:
        r4 = new UserManagerImpl$awaitUserApiForSession$1(this, r20);
        goto L8
    }

    public final c.b h(ILogoutCallback r9, OfficeSDKPassportUserAction r10, OfficeSDKHostSession r11) {
        Object r0 = this.l;
        monitor-enter(r0);
        c r1 = (c) this.m.lastOrNull();     // Catch: Throwable -> L33
        if (r1 != null) goto L8;
        r1 = this.n;     // Catch: Throwable -> L33
    L8:
        if ((r1 instanceof c.b) == true) goto L10;
    L25:
        c.b r2 = new c.b(r9, r10, r11);     // Catch: Throwable -> L33
        this.m.add(r2);     // Catch: Throwable -> L33
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L33
        monitor-exit(r0);
        if (this.p.compareAndSet(false, true) == false) goto L31;
        BuildersKt.launch$default(this.e, null, null, new UserManagerImpl$startWorker$1(this, null), 3, null);
    L31:
        this.o.trySend-JP2dKIU(Unit.INSTANCE);
        return r2;
    L10:
        if (((c.b) r1).b == true) goto L25;
        OfficeSDKHostSession r3 = ((c.b) r1).d;     // Catch: Throwable -> L33
        if (r3 == null) goto L18;
        if (r11 == null) goto L18;
        if (Intrinsics.areEqual(r3, r11) == true) goto L18;
        boolean r4 = false;
    L19:
        if (r4 == false) goto L25;
        if (r9 == null) goto L22;
        ((c.b) r1).e.add(r9);     // Catch: Throwable -> L33
    L22:
        Log.i("UserManagerImpl", "logout joined in-flight command");     // Catch: Throwable -> L33
        c.b r5 = (c.b) r1;     // Catch: Throwable -> L33
        monitor-exit(r0);
        return r5;
    L18:
        r4 = true;
    L33:
        th = move-exception;
        throw th;
    }

    public final Object k(String r5, OfficeSDKPassportUserAction r6, Continuation<? super Result<IOnlineOfflineService.OfflineResult>> r7) {
        if ((r7 instanceof UserManagerImpl$performDrain$1) == false) goto L7;
        UserManagerImpl$performDrain$1 r0 = (UserManagerImpl$performDrain$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r5 = (String) r0.L$0;
        ResultKt.throwOnFailure(r8);
    L17:
        Result r9 = (Result) r8;
        r9.unbox-impl();
        OfficeSDKManager.unregisterOfficeSDKUserComponent(r5);
        OfficeSDKManager.clearUserServices$officesdk_core_release(r5);
        return r9.unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        this.d.set(null);
        this.j = null;
        OfficeSDKManager.clearCurrentUid$officesdk_core_release(r5);
        f();
        Flow<Result<IOnlineOfflineService.OfflineResult>> r10 = this.a.offline(new IOnlineOfflineService.OfflineParams(r6));
        r0.L$0 = r5;
        r0.label = 1;
        r8 = kotlinx.coroutines.flow.e.s(r10, r0);
        if (r8 != r2) goto L17;
        return r2;
    L7:
        r0 = new UserManagerImpl$performDrain$1(this, r7);
        goto L8
    }

    public static final Object a(UserManagerImpl r16, OfficeSDKHostSession r17, IOfficeSDKHostSessionProvider r18, Continuation r19) {
        r16.getClass();
        if ((r19 instanceof UserManagerImpl$awaitReadyUserApi$1) == false) goto L7;
        UserManagerImpl$awaitReadyUserApi$1 r2 = (UserManagerImpl$awaitReadyUserApi$1) r19;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        IOfficeSDKHostSessionProvider r6 = (IOfficeSDKHostSessionProvider) r2.L$1;
        OfficeSDKHostSession r7 = (OfficeSDKHostSession) r2.L$0;
        ResultKt.throwOnFailure(r1);
    L15:
        int r8 = ((Number) r16.k.getValue()).intValue();
        OfficeSDKUserApi r9 = r16.j(r7);
        if (r9 != null) goto L24;
        if (r6.currentHostSession() == null) goto L28;
        if (r6.isCurrentHostSession(r7) == false) goto L26;
        StateFlowImpl r10 = r16.k;
        UserManagerImpl$awaitReadyUserApi$3 r11 = new UserManagerImpl$awaitReadyUserApi$3(r8, null);
        r2.L$0 = r7;
        r2.L$1 = r6;
        r2.label = 1;
        if (kotlinx.coroutines.flow.e.t(r10, r11, r2) != r4) goto L15;
        return r4;
    L26:
        throw new OfficeSDKUserAccessException(OfficeSDKDriveErrorCodes.HOST_USER_CHANGED, "host session changed while awaiting userApi", null, 4, null);
    L28:
        throw new OfficeSDKUserAccessException(OfficeSDKDriveErrorCodes.HOST_USER_OFFLINE, "no host user online", null, 4, null);
    L24:
        return r9;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        r7 = r17;
        r6 = r18;
    L7:
        r2 = new UserManagerImpl$awaitReadyUserApi$1(r16, r19);
        goto L8
    }
}
