package com.obric.memorydata.middleware.impl.app;

import android.content.Context;
import android.database.ContentObserver;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.entity.EventBody;
import com.obric.aiagent.sharedstate.SharedState;
import com.obric.aiagent.sharedstate.model.SharedValue;
import com.obric.cae.userAware.WifiScanSceneType;
import com.obric.memorydata.middleware.api.app.IUserSettings;
import com.obric.memorydata.middleware.api.app.d;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.utils.j;
import com.obric.memorydata.utils.q;
import com.obric.memorydata.utils.y;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bx;
import kotlinx.coroutines.flow.ae;
import kotlinx.coroutines.flow.at;
import kotlinx.coroutines.flow.k;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\bÆ\u0002\u0018\u00002\u00020\u0001:\u000289B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001b\u001a\u00020\u0000H\u0007J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\u001fH\u0002J\f\u0010!\u001a\u00020\u0010*\u00020\u0005H\u0002J\b\u0010\"\u001a\u00020\u001fH\u0002J\b\u0010#\u001a\u00020\u001dH\u0002J\b\u0010$\u001a\u00020\u001dH\u0002J\b\u0010%\u001a\u00020\u0010H\u0016J\b\u0010&\u001a\u00020\u0010H\u0016J\u0010\u0010'\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020\bH\u0016J\u0010\u0010)\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020\bH\u0016J\u0010\u0010*\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020\nH\u0016J\u0010\u0010+\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020\nH\u0016J\b\u0010,\u001a\u00020\u0010H\u0016J\u0010\u0010-\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020\fH\u0016J\u0010\u0010.\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020\fH\u0016J\u0012\u0010/\u001a\u00020\u001d2\b\u0010(\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u00100\u001a\u00020\u001d2\u0006\u00101\u001a\u00020\u0010H\u0016J\u0010\u00102\u001a\u00020\u001d2\u0006\u00103\u001a\u00020\u0010H\u0016J\b\u00104\u001a\u00020\u0005H\u0016J\b\u00105\u001a\u00020\u0005H\u0016J\b\u00106\u001a\u00020\u0005H\u0016J\u001a\u00107\u001a\u0014\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00050\u0012H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00050\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/obric/memorydata/middleware/impl/app/UserSettingsImpl;", "Lcom/obric/memorydata/middleware/api/app/IUserSettings;", "<init>", "()V", "TAG", "", "agreeListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/obric/memorydata/middleware/api/app/AgreePrivacyListener;", "loginStateListeners", "Lcom/obric/memorydata/middleware/api/app/LoginStateListener;", "enterpriseAccountListeners", "Lcom/obric/memorydata/middleware/api/app/EnterpriseAccountListener;", "loginStateDispatchedListener", "Lcom/obric/memorydata/middleware/api/app/LoginStateDispatchedListener;", "isInHostAsPlugin", "", "initValue", "Lkotlin/Triple;", "agreePrivacyState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "isLoginState", "loginUserIdState", "isEnterpriseState", "enterpriseAccountObserver", "Landroid/database/ContentObserver;", "hasInitializedEnterpriseState", "getInst", "initListener", "", "observerAgreePrivacyChange", "Lkotlinx/coroutines/Job;", "observerLoginState", "isValid", "observerEnterpriseAccountChange", "initEnterpriseAccountState", "refreshEnterpriseAccountState", "hasAgreePrivacy", "hasAgreePrivacyAndLogin", "registerAgreePrivacyListener", "listener", "unregisterAgreePrivacyListener", "registerLoginStateListener", "unregisterLoginStateListener", "isEnterpriseAccount", "registerEnterpriseAccountListener", "unregisterEnterpriseAccountListener", "setLoginStateDispatchedListener", "updateIsLogin", "isLogin", "updateAgreePrivacy", "agreePrivacy", "getAgreePrivacyUrl", "getGlobalMemoryPrivacyUrl", "getUserId", "getInitValue", "LoginState", "Accumulator", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class UserSettingsImpl implements IUserSettings {
    public static final UserSettingsImpl INSTANCE = null;
    private static final String TAG = "MeD_UserSettingsImpl";
    private static final CopyOnWriteArrayList<com.obric.memorydata.middleware.api.app.a> agreeListeners = null;
    private static final ae<Boolean> agreePrivacyState = null;
    private static final CopyOnWriteArrayList<com.obric.memorydata.middleware.api.app.b> enterpriseAccountListeners = null;
    private static ContentObserver enterpriseAccountObserver;
    private static boolean hasInitializedEnterpriseState;
    private static final Triple<Boolean, Boolean, String> initValue = null;
    private static final ae<Boolean> isEnterpriseState = null;
    private static final boolean isInHostAsPlugin = false;
    private static final ae<Boolean> isLoginState = null;
    private static volatile com.obric.memorydata.middleware.api.app.c loginStateDispatchedListener;
    private static final CopyOnWriteArrayList<d> loginStateListeners = null;
    private static final ae<String> loginUserIdState = null;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/middleware/impl/app/UserSettingsImpl$Accumulator;", "", "prev", "Lcom/obric/memorydata/middleware/impl/app/UserSettingsImpl$LoginState;", "current", "lastValidId", "", "<init>", "(Lcom/obric/memorydata/middleware/impl/app/UserSettingsImpl$LoginState;Lcom/obric/memorydata/middleware/impl/app/UserSettingsImpl$LoginState;Ljava/lang/String;)V", "getPrev", "()Lcom/obric/memorydata/middleware/impl/app/UserSettingsImpl$LoginState;", "getCurrent", "getLastValidId", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final b f11687a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final b f11688b;
        private final String c;

        public a() {
            this(null, null, null, 7, null);
        }

        public a(b r1, b r2, String r3) {
            this.f11687a = r1;
            this.f11688b = r2;
            this.c = r3;
        }

        public /* synthetic */ a(b r2, b r3, String r4, int r5, DefaultConstructorMarker r6) {
            if ((r5 & 1) == 0) goto L6;
            r2 = null;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r3 = null;
        L9:
            if ((r5 & 4) == 0) goto L11;
            r4 = null;
        L11:
            this(r2, r3, r4);
        }

        public final b a() {
            return this.f11687a;
        }

        public final b b() {
            return this.f11688b;
        }

        public final String c() {
            return this.c;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f11687a, r6.f11687a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f11688b, r6.f11688b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            b r0 = this.f11687a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            b r4 = this.f11688b;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.c;
            if (r7 == null) goto L15;
            r1 = r7.hashCode();
        L15:
            return r6 + r1;
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "Accumulator(prev=" + this.f11687a + ", current=" + this.f11688b + ", lastValidId=" + this.c + ')';
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/middleware/impl/app/UserSettingsImpl$LoginState;", "", "isLogin", "", OaidModel.KEY_ID, "", "<init>", "(ZLjava/lang/String;)V", "()Z", "getId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f11689a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f11690b;

        public b(boolean r2, String r3) {
            Intrinsics.checkNotNullParameter(r3, OaidModel.KEY_ID);
            this.f11689a = r2;
            this.f11690b = r3;
        }

        public final boolean a() {
            return this.f11689a;
        }

        public final String b() {
            return this.f11690b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
            if (this.f11689a == r6.f11689a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f11690b, r6.f11690b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Boolean.hashCode(this.f11689a) * 31) + this.f11690b.hashCode();
        }

        public String toString() {
            return "LoginState(isLogin=" + this.f11689a + ", id=" + this.f11690b + ')';
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class c implements Function0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f11691a = null;

        static {
            f11691a = new c();
        }

        c() {
        }

        public final Void a() {
            throw new IllegalStateException("Only ONE LoginStateDispatchedListener is allowed");
        }

        @Override // kotlin.jvm.functions.Function0
        public /* synthetic */ Object invoke() {
            return a();
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.middleware.impl.app.UserSettingsImpl$initEnterpriseAccountState$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.middleware.impl.app.UserSettingsImpl$initEnterpriseAccountState$1", f = "UserSettingsImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> r3) {
            super(2, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
        }

        private static final Unit invokeSuspend$lambda$0() {
            i.a(j.a(), null, null, (Function2) ZeusTransformUtils.preCheckCast(new UserSettingsImpl$initEnterpriseAccountState$1$1$1(null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
            return Unit.INSTANCE;
        }

        public static /* synthetic */ Unit lambda$gYbDAvt73xbHEp_kKlQH8af42js() {
            return invokeSuspend$lambda$0();
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1((Continuation) ZeusTransformUtils.wrapperContextForParams(r2, Continuation.class, "com.obric.memorydata.plugin")), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r1) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r1);
            UserSettingsImpl r0 = UserSettingsImpl.INSTANCE;
            UserSettingsImpl.access$setEnterpriseAccountObserver$p(com.obric.memorydata.middleware.impl.app.a.f11697a.a($$Lambda$UserSettingsImpl$initEnterpriseAccountState$1$gYbDAvt73xbHEp_kKlQH8af42js.INSTANCE));
            UserSettingsImpl.access$refreshEnterpriseAccountState(UserSettingsImpl.INSTANCE);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.middleware.impl.app.UserSettingsImpl$initListener$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.middleware.impl.app.UserSettingsImpl$initListener$1", f = "UserSettingsImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C12131 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;

        C12131(Continuation<? super C12131> r3) {
            super(2, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        private static final void invokeSuspend$lambda$3(String r10, SharedValue r11) {
            SharedValue r12 = (SharedValue) ZeusTransformUtils.wrapperContextForParams(r11, SharedValue.class, "com.obric.memorydata.plugin");
            int r0 = r10.hashCode();
            String r3 = null;
            Boolean r4 = null;
            Boolean r5 = null;
            if (r0 == 1320673029) goto L34;
            if (r0 == 1456851000) goto L22;
            if (r0 == 2111726594) goto L10;
            return;
        L10:
            if (r10.equals("doubao_login_state") == false) goto L51;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), UserSettingsImpl.TAG, "update doubao state, login:" + r12.getValue(), false, 4, null);
            Object r13 = r12.getValue();
            if (ZeusTransformUtils.instanceOf(r13, Boolean.class) == false) goto L15;
            r4 = (Boolean) ZeusTransformUtils.preCheckCast(r13, Boolean.class, "com.obric.memorydata.plugin");
        L15:
            if (r4 == null) goto L20;
            boolean r14 = r4.booleanValue();
            ae r15 = UserSettingsImpl.access$isLoginState$p();
        L17:
            Object r1 = r15.c();
            ((Boolean) ZeusTransformUtils.preCheckCast(r1, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
            if (r15.a(r1, Boolean.valueOf(r14)) == false) goto L17;
            return;
        L20:
            return;
        L51:
            return;
        L22:
            if (r10.equals("doubao_privacy_allowed") == false) goto L52;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), UserSettingsImpl.TAG, "update doubao state, agree privacy:" + r12.getValue(), false, 4, null);
            Object r16 = r12.getValue();
            if (ZeusTransformUtils.instanceOf(r16, Boolean.class) == false) goto L27;
            r5 = (Boolean) ZeusTransformUtils.preCheckCast(r16, Boolean.class, "com.obric.memorydata.plugin");
        L27:
            if (r5 == null) goto L32;
            boolean r17 = r5.booleanValue();
            ae r18 = UserSettingsImpl.access$getAgreePrivacyState$p();
        L29:
            Object r2 = r18.c();
            ((Boolean) ZeusTransformUtils.preCheckCast(r2, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
            if (r18.a(r2, Boolean.valueOf(r17)) == false) goto L29;
            return;
        L32:
            return;
        L52:
            return;
        L34:
            if (r10.equals("doubao_account_uid") == false) goto L53;
            Object r19 = r12.getValue();
            if (ZeusTransformUtils.instanceOf(r19, String.class) == false) goto L39;
            r3 = (String) ZeusTransformUtils.preCheckCast(r19, String.class, "com.obric.memorydata.plugin");
        L39:
            if (r3 != null) goto L41;
            return;
        L41:
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), UserSettingsImpl.TAG, "update doubao state, uid:" + q.f13259a.b(r3), false, 4, null);
            ae r110 = UserSettingsImpl.access$getLoginUserIdState$p();
        L42:
            Object r111 = r110.c();
            String r6 = (String) ZeusTransformUtils.preCheckCast(r111, String.class, "com.obric.memorydata.plugin");
            if (r110.a(r111, r3) == false) goto L42;
            return;
        }

        public static /* synthetic */ void lambda$AfsA9f6typETs8lDub4ZAGR3qBY(String r0, SharedValue r1) {
            invokeSuspend$lambda$3(r0, r1);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return (Continuation) ZeusTransformUtils.preCheckCast(new C12131((Continuation) ZeusTransformUtils.wrapperContextForParams(r2, Continuation.class, "com.obric.memorydata.plugin")), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C12131) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C12131.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r7) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r7);
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), UserSettingsImpl.TAG, "registerDoubaoState listener", false, 4, null);
            $$Lambda$UserSettingsImpl$initListener$1$AfsA9f6typETs8lDub4ZAGR3qBY r6 = $$Lambda$UserSettingsImpl$initListener$1$AfsA9f6typETs8lDub4ZAGR3qBY.INSTANCE;
            SharedState.INSTANCE.registerObserver(CollectionsKt.listOf(new String[]{"doubao_account_uid", "doubao_login_state", "doubao_privacy_allowed"}), r6);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.middleware.impl.app.UserSettingsImpl$observerAgreePrivacyChange$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.middleware.impl.app.UserSettingsImpl$observerAgreePrivacyChange$1", f = "UserSettingsImpl.kt", i = {}, l = {109}, m = "invokeSuspend", n = {}, s = {})
    static final class C12141 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;

        C12141(Continuation<? super C12141> r3) {
            super(2, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return (Continuation) ZeusTransformUtils.preCheckCast(new C12141((Continuation) ZeusTransformUtils.wrapperContextForParams(r2, Continuation.class, "com.obric.memorydata.plugin")), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C12141) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C12141.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            kotlinx.coroutines.flow.i r7 = k.a((kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(UserSettingsImpl.access$getAgreePrivacyState$p(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), 1);
            kotlinx.coroutines.flow.j r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(C06241.f11692a, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.collect(r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.middleware.impl.app.UserSettingsImpl$observerEnterpriseAccountChange$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.middleware.impl.app.UserSettingsImpl$observerEnterpriseAccountChange$1", f = "UserSettingsImpl.kt", i = {}, l = {WifiScanSceneType.HAR_END}, m = "invokeSuspend", n = {}, s = {})
    static final class C12151 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;

        C12151(Continuation<? super C12151> r3) {
            super(2, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return (Continuation) ZeusTransformUtils.preCheckCast(new C12151((Continuation) ZeusTransformUtils.wrapperContextForParams(r2, Continuation.class, "com.obric.memorydata.plugin")), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C12151) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C12151.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            kotlinx.coroutines.flow.i r7 = k.b(k.c((kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(UserSettingsImpl.access$isEnterpriseState$p(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin")));
            kotlinx.coroutines.flow.j r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(C06261.f11693a, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.collect(r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.middleware.impl.app.UserSettingsImpl$observerLoginState$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.middleware.impl.app.UserSettingsImpl$observerLoginState$1", f = "UserSettingsImpl.kt", i = {}, l = {154}, m = "invokeSuspend", n = {}, s = {})
    static final class C12161 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: renamed from: com.obric.memorydata.middleware.impl.app.UserSettingsImpl$observerLoginState$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "Lcom/obric/memorydata/middleware/impl/app/UserSettingsImpl$LoginState;", "isLogin", "", OaidModel.KEY_ID, ""}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.memorydata.middleware.impl.app.UserSettingsImpl$observerLoginState$1$1", f = "UserSettingsImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C06281 extends SuspendLambda implements Function3<Boolean, String, Continuation<? super b>, Object> {
            /* synthetic */ Object L$0;
            /* synthetic */ boolean Z$0;
            int label;

            C06281(Continuation<? super C06281> r3) {
                super(3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
            }

            @Override // kotlin.jvm.functions.Function3
            public /* synthetic */ Object invoke(Boolean r3, String r4, Continuation<? super b> r5) {
                return invoke(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.memorydata.plugin")).booleanValue(), (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r5, Continuation.class, "com.obric.memorydata.plugin"));
            }

            public final Object invoke(boolean r2, String r3, Continuation<? super b> r4) {
                C06281 r5 = new C06281((Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
                r5.Z$0 = r2;
                r5.L$0 = r3;
                return r5.invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r4) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r4);
                boolean r5 = this.Z$0;
                String r3 = (String) ZeusTransformUtils.preCheckCast(this.L$0, String.class, "com.obric.memorydata.plugin");
                RunLog.INSTANCE.debug(UserSettingsImpl.TAG, "observerLoginState, combine:isLogin=" + r5 + ",id=" + q.f13259a.b(r3));
                return new b(r5, r3);
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.obric.memorydata.middleware.impl.app.UserSettingsImpl$observerLoginState$1$2, reason: invalid class name */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/obric/memorydata/middleware/impl/app/UserSettingsImpl$Accumulator;", "acc", "current", "Lcom/obric/memorydata/middleware/impl/app/UserSettingsImpl$LoginState;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.memorydata.middleware.impl.app.UserSettingsImpl$observerLoginState$1$2", f = "UserSettingsImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass2 extends SuspendLambda implements Function3<a, b, Continuation<? super a>, Object> {
            /* synthetic */ Object L$0;
            /* synthetic */ Object L$1;
            int label;

            AnonymousClass2(Continuation<? super AnonymousClass2> r3) {
                super(3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(a r2, b r3, Continuation<? super a> r4) {
                AnonymousClass2 r5 = new AnonymousClass2((Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
                r5.L$0 = r2;
                r5.L$1 = r3;
                return r5.invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* synthetic */ Object invoke(a r3, b r4, Continuation<? super a> r5) {
                return invoke2((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.memorydata.plugin"), (b) ZeusTransformUtils.preCheckCast(r4, b.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r5, Continuation.class, "com.obric.memorydata.plugin"));
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r5) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L13;
                ResultKt.throwOnFailure(r5);
                a r6 = (a) ZeusTransformUtils.preCheckCast(this.L$0, a.class, "com.obric.memorydata.plugin");
                b r4 = (b) ZeusTransformUtils.preCheckCast(this.L$1, b.class, "com.obric.memorydata.plugin");
                b r1 = r6.b();
                if (r4.a() == true) goto L7;
            L9:
                String r7 = r6.c();
            L11:
                return new a(r1, r4, r7);
            L7:
                if (UserSettingsImpl.access$isValid(UserSettingsImpl.INSTANCE, r4.b()) == false) goto L9;
                r7 = r4.b();
                goto L11
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.obric.memorydata.middleware.impl.app.UserSettingsImpl$observerLoginState$1$a */
        @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class a implements kotlinx.coroutines.flow.i<b> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.i f11695a;

            /* JADX INFO: renamed from: com.obric.memorydata.middleware.impl.app.UserSettingsImpl$observerLoginState$1$a$1, reason: invalid class name and collision with other inner class name */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", EventBody.KEY_VALUE, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
            public static final class C06291<T> implements kotlinx.coroutines.flow.j {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ kotlinx.coroutines.flow.j f11696a;

                public C06291(kotlinx.coroutines.flow.j r3) {
                    this.f11696a = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
                }

                @Override // kotlinx.coroutines.flow.j
                public final Object emit(Object r10, Continuation r11) {
                    Continuation r12 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
                    if (ZeusTransformUtils.instanceOf(r12, UserSettingsImpl$observerLoginState$1$invokeSuspend$$inlined$mapNotNull$1$2$1.class) == false) goto L7;
                    UserSettingsImpl$observerLoginState$1$invokeSuspend$$inlined$mapNotNull$1$2$1 r0 = (UserSettingsImpl$observerLoginState$1$invokeSuspend$$inlined$mapNotNull$1$2$1) ZeusTransformUtils.preCheckCast(r12, UserSettingsImpl$observerLoginState$1$invokeSuspend$$inlined$mapNotNull$1$2$1.class, "com.obric.memorydata.plugin");
                    if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
                    r0.label -= Integer.MIN_VALUE;
                L8:
                    Object r13 = r0.result;
                    Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int r3 = r0.label;
                    if (r3 == 0) goto L14;
                    if (r3 != 1) goto L13;
                    ResultKt.throwOnFailure(r13);
                L47:
                    return Unit.INSTANCE;
                L13:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                L14:
                    ResultKt.throwOnFailure(r13);
                    kotlinx.coroutines.flow.j r9 = this.f11696a;
                    Continuation r14 = (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
                    a r15 = (a) ZeusTransformUtils.preCheckCast(r10, a.class, "com.obric.memorydata.plugin");
                    b r16 = r15.a();
                    b r1 = null;
                    if (r16 == null) goto L42;
                    b r4 = r15.b();
                    if (r4 == null) goto L42;
                    if (r16.a() == true) goto L23;
                L25:
                    boolean r5 = false;
                L27:
                    if (r4.a() == true) goto L29;
                L31:
                    boolean r7 = false;
                L32:
                    if (r5 == true) goto L36;
                    if (r7 == false) goto L36;
                    r1 = new b(true, r4.b());
                L36:
                    if (r16.a() == false) goto L42;
                    if (r4.a() == true) goto L42;
                    if (r15.c() == null) goto L42;
                    r1 = new b(false, r15.c());
                    goto L42
                L29:
                    if (UserSettingsImpl.access$isValid(UserSettingsImpl.INSTANCE, r4.b()) == false) goto L31;
                    r7 = true;
                    goto L32
                L23:
                    if (UserSettingsImpl.access$isValid(UserSettingsImpl.INSTANCE, r16.b()) == false) goto L25;
                    r5 = true;
                L42:
                    if (r1 == null) goto L47;
                    r0.label = 1;
                    if (r9.emit(r1, r0) != r2) goto L47;
                    return r2;
                L7:
                    r0 = new UserSettingsImpl$observerLoginState$1$invokeSuspend$$inlined$mapNotNull$1$2$1(this, r12);
                    goto L8
                }
            }

            public a(kotlinx.coroutines.flow.i r3) {
                this.f11695a = (kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
            }

            @Override // kotlinx.coroutines.flow.i
            public Object collect(kotlinx.coroutines.flow.j<? super b> r3, Continuation r4) {
                kotlinx.coroutines.flow.j r5 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
                Continuation<? super Unit> r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                Object r2 = this.f11695a.collect((kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new C06291(r5), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin"), r6);
                if (r2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
                return r2;
            L6:
                return Unit.INSTANCE;
            }
        }

        C12161(Continuation<? super C12161> r3) {
            super(2, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return (Continuation) ZeusTransformUtils.preCheckCast(new C12161((Continuation) ZeusTransformUtils.wrapperContextForParams(r2, Continuation.class, "com.obric.memorydata.plugin")), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C12161) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C12161.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r13) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r13);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r13);
            kotlinx.coroutines.flow.i r14 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(new a(k.a(k.b(k.b((kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(UserSettingsImpl.access$isLoginState$p(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(UserSettingsImpl.access$getLoginUserIdState$p(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), (Function3) ZeusTransformUtils.preCheckCast(new C06281(null), Function3.class, "com.obric.memorydata.plugin"))), new a(null, null, null, 7, null), (Function3) ZeusTransformUtils.preCheckCast(new AnonymousClass2(null), Function3.class, "com.obric.memorydata.plugin"))), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
            kotlinx.coroutines.flow.j r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(AnonymousClass3.f11694a, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r14.collect(r2, r3) != r0) goto L12;
            return r0;
        }
    }

    static {
        UserSettingsImpl r0 = new UserSettingsImpl();
        INSTANCE = r0;
        agreeListeners = new CopyOnWriteArrayList();
        loginStateListeners = new CopyOnWriteArrayList();
        enterpriseAccountListeners = new CopyOnWriteArrayList();
        isInHostAsPlugin = Intrinsics.areEqual(AppContext.INSTANCE.getPackageName(), "com.larus.nova");
        Triple<Boolean, Boolean, String> r1 = r0.getInitValue();
        initValue = r1;
        agreePrivacyState = at.a(r1.getFirst());
        isLoginState = at.a(r1.getSecond());
        loginUserIdState = at.a(r1.getThird());
        isEnterpriseState = at.a(null);
    }

    private UserSettingsImpl() {
    }

    public static final /* synthetic */ CopyOnWriteArrayList access$getAgreeListeners$p() {
        return agreeListeners;
    }

    public static final /* synthetic */ ae access$getAgreePrivacyState$p() {
        return agreePrivacyState;
    }

    public static final /* synthetic */ CopyOnWriteArrayList access$getEnterpriseAccountListeners$p() {
        return enterpriseAccountListeners;
    }

    public static final /* synthetic */ boolean access$getHasInitializedEnterpriseState$p() {
        return hasInitializedEnterpriseState;
    }

    public static final /* synthetic */ com.obric.memorydata.middleware.api.app.c access$getLoginStateDispatchedListener$p() {
        return loginStateDispatchedListener;
    }

    public static final /* synthetic */ CopyOnWriteArrayList access$getLoginStateListeners$p() {
        return loginStateListeners;
    }

    public static final /* synthetic */ ae access$getLoginUserIdState$p() {
        return loginUserIdState;
    }

    public static final /* synthetic */ ae access$isEnterpriseState$p() {
        return isEnterpriseState;
    }

    public static final /* synthetic */ ae access$isLoginState$p() {
        return isLoginState;
    }

    public static final /* synthetic */ boolean access$isValid(UserSettingsImpl r0, String r1) {
        return r0.isValid(r1);
    }

    public static final /* synthetic */ void access$refreshEnterpriseAccountState(UserSettingsImpl r0) {
        r0.refreshEnterpriseAccountState();
    }

    public static final /* synthetic */ void access$setEnterpriseAccountObserver$p(ContentObserver r0) {
        enterpriseAccountObserver = r0;
    }

    public static final /* synthetic */ void access$setHasInitializedEnterpriseState$p(boolean r0) {
        hasInitializedEnterpriseState = r0;
    }

    private final Triple<Boolean, Boolean, String> getInitValue() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "getInitValue start", false, 4, null);
        if (isInHostAsPlugin == false) goto L5;
        boolean r10 = SharedState.INSTANCE.getBoolean("doubao_privacy_allowed", false);
        boolean r2 = SharedState.INSTANCE.getBoolean("doubao_login_state", false);
        Triple<Boolean, Boolean, String> r3 = new Triple(Boolean.valueOf(r10), Boolean.valueOf(r2), SharedState.INSTANCE.getString("doubao_account_uid", ""));
    L6:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "getInitValue end: agreePrivacy=" + ((Boolean) ZeusTransformUtils.preCheckCast(r3.getFirst(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() + ", isLogin=" + ((Boolean) ZeusTransformUtils.preCheckCast(r3.getSecond(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() + ",loginId=" + q.f13259a.b((String) ZeusTransformUtils.preCheckCast(r3.getThird(), String.class, "com.obric.memorydata.plugin")), false, 4, null);
        return r3;
    L5:
        r3 = new Triple(false, false, "");
        goto L6
    }

    @JvmStatic
    public static final UserSettingsImpl getInst() {
        UserSettingsImpl r0 = INSTANCE;
        r0.observerAgreePrivacyChange();
        r0.observerLoginState();
        r0.observerEnterpriseAccountChange();
        if (isInHostAsPlugin == false) goto L5;
        r0.initListener();
    L5:
        r0.initEnterpriseAccountState();
        return r0;
    }

    private final void initEnterpriseAccountState() {
        i.a(j.a(), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private final void initListener() {
        i.a(am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C12131(null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private final boolean isValid(String r5) {
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == false) goto L14;
        Long r6 = StringsKt.toLongOrNull(r5);
        if (r6 != null) goto L11;
        return true;
    L11:
        if (r6.longValue() == 0) goto L14;
        return true;
    L14:
        return false;
    L5:
        r4 = false;
        goto L6
    }

    private final bx observerAgreePrivacyChange() {
        return i.a(am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C12141(null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private final bx observerEnterpriseAccountChange() {
        return i.a(am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C12151(null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private final bx observerLoginState() {
        return i.a(am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C12161(null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private final void refreshEnterpriseAccountState() {
        Boolean r6 = com.obric.memorydata.middleware.impl.app.a.f11697a.a();
        if (r6 != null) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "refreshEnterpriseAccountState provider unavailable, keep previous state", null, 4, null);
        return;
    L6:
        ae<Boolean> r1 = isEnterpriseState;
    L7:
        Boolean r2 = r1.c();
        Boolean r3 = (Boolean) ZeusTransformUtils.preCheckCast(r2, Boolean.class, "com.obric.memorydata.plugin");
        if (r1.a(r2, r6) == false) goto L7;
    }

    @Override // com.obric.memorydata.middleware.api.app.IUserSettings
    public String getAgreePrivacyUrl() {
        if (isInHostAsPlugin == true) goto L5;
        return "";
    L5:
        return SharedState.INSTANCE.getString("doubao_privacy_url", "");
    }

    @Override // com.obric.memorydata.middleware.api.app.IUserSettings
    public String getGlobalMemoryPrivacyUrl() {
        String r3 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.global_memory_privacy_url, TypedValues.Custom.S_STRING, "global_memory_privacy_url"));
        Intrinsics.checkNotNullExpressionValue(r3, "getString(...)");
        return r3;
    }

    @Override // com.obric.memorydata.middleware.api.app.IUserSettings
    public String getUserId() {
        return (String) ZeusTransformUtils.preCheckCast(loginUserIdState.c(), String.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.middleware.api.app.IUserSettings
    public boolean hasAgreePrivacy() {
        return ((Boolean) ZeusTransformUtils.preCheckCast(agreePrivacyState.c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    @Override // com.obric.memorydata.middleware.api.app.IUserSettings
    public boolean hasAgreePrivacyAndLogin() {
        if (((Boolean) ZeusTransformUtils.preCheckCast(agreePrivacyState.c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L5;
    L7:
        return false;
    L5:
        if (((Boolean) ZeusTransformUtils.preCheckCast(isLoginState.c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L7;
        return true;
    }

    @Override // com.obric.memorydata.middleware.api.app.IUserSettings
    @Deprecated(message = "only for algorithm package", replaceWith = @ReplaceWith(expression = "hasAgreePrivacy()", imports = {}))
    public boolean isDataServiceEnabled() {
        return IUserSettings.a.a(this);
    }

    @Override // com.obric.memorydata.middleware.api.app.IUserSettings
    public boolean isEnterpriseAccount() {
        return Intrinsics.areEqual(isEnterpriseState.c(), true);
    }

    @Override // com.obric.memorydata.middleware.api.app.IUserSettings
    public void registerAgreePrivacyListener(com.obric.memorydata.middleware.api.app.a r2) {
        com.obric.memorydata.middleware.api.app.a r1 = (com.obric.memorydata.middleware.api.app.a) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.memorydata.middleware.api.app.a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "listener");
        CopyOnWriteArrayList<com.obric.memorydata.middleware.api.app.a> r3 = agreeListeners;
        if (r3.contains(r1) == false) goto L5;
        return;
    L5:
        r3.add(r1);
    }

    @Override // com.obric.memorydata.middleware.api.app.IUserSettings
    public void registerEnterpriseAccountListener(com.obric.memorydata.middleware.api.app.b r2) {
        com.obric.memorydata.middleware.api.app.b r1 = (com.obric.memorydata.middleware.api.app.b) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.memorydata.middleware.api.app.b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "listener");
        CopyOnWriteArrayList<com.obric.memorydata.middleware.api.app.b> r3 = enterpriseAccountListeners;
        if (r3.contains(r1) == false) goto L5;
        return;
    L5:
        r3.add(r1);
    }

    @Override // com.obric.memorydata.middleware.api.app.IUserSettings
    public void registerLoginStateListener(d r2) {
        d r1 = (d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "listener");
        CopyOnWriteArrayList<d> r3 = loginStateListeners;
        if (r3.contains(r1) == false) goto L5;
        return;
    L5:
        r3.add(r1);
    }

    @Override // com.obric.memorydata.middleware.api.app.IUserSettings
    public void setLoginStateDispatchedListener(com.obric.memorydata.middleware.api.app.c r3) {
        com.obric.memorydata.middleware.api.app.c r2 = (com.obric.memorydata.middleware.api.app.c) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.memorydata.middleware.api.app.c.class, "com.obric.memorydata.plugin");
        if (loginStateDispatchedListener != null) goto L5;
    L7:
        loginStateDispatchedListener = r2;
        return;
    L5:
        if (Intrinsics.areEqual(loginStateDispatchedListener, r2) == true) goto L7;
        y.a(null, (Function0) ZeusTransformUtils.preCheckCast(c.f11691a, Function0.class, "com.obric.memorydata.plugin"), 1, null);
        goto L7
    }

    @Override // com.obric.memorydata.middleware.api.app.IUserSettings
    public void unregisterAgreePrivacyListener(com.obric.memorydata.middleware.api.app.a r2) {
        com.obric.memorydata.middleware.api.app.a r1 = (com.obric.memorydata.middleware.api.app.a) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.memorydata.middleware.api.app.a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "listener");
        agreeListeners.remove(r1);
    }

    @Override // com.obric.memorydata.middleware.api.app.IUserSettings
    public void unregisterEnterpriseAccountListener(com.obric.memorydata.middleware.api.app.b r2) {
        com.obric.memorydata.middleware.api.app.b r1 = (com.obric.memorydata.middleware.api.app.b) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.memorydata.middleware.api.app.b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "listener");
        enterpriseAccountListeners.remove(r1);
    }

    @Override // com.obric.memorydata.middleware.api.app.IUserSettings
    public void unregisterLoginStateListener(d r2) {
        d r1 = (d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "listener");
        loginStateListeners.remove(r1);
    }

    @Override // com.obric.memorydata.middleware.api.app.IUserSettings
    public void updateAgreePrivacy(boolean r4) {
        ae<Boolean> r3 = agreePrivacyState;
    L3:
        Boolean r0 = r3.c();
        ((Boolean) ZeusTransformUtils.preCheckCast(r0, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        if (r3.a(r0, Boolean.valueOf(r4)) == false) goto L3;
    }

    @Override // com.obric.memorydata.middleware.api.app.IUserSettings
    public void updateIsLogin(boolean r4) {
        ae<Boolean> r3 = isLoginState;
    L3:
        Boolean r0 = r3.c();
        ((Boolean) ZeusTransformUtils.preCheckCast(r0, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        if (r3.a(r0, Boolean.valueOf(r4)) == false) goto L3;
    }
}
