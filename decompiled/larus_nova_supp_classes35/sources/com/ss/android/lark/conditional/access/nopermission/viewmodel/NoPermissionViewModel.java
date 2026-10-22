package com.ss.android.lark.conditional.access.nopermission.viewmodel;

import android.app.Activity;
import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.security.v1.CondAccessPingRequest;
import com.bytedance.lark.pb.security.v1.CondAccessPingResponse;
import com.bytedance.lark.pb.security.v1.CustomDisplayModelRequest;
import com.bytedance.lark.pb.security.v1.CustomDisplayModelResponse;
import com.bytedance.lark.pb.security.v1.GetDeviceApplySwitchRequest;
import com.bytedance.lark.pb.security.v1.GetDeviceApplySwitchResponse;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.conditional.access.network.model.response.BindDeviceData;
import com.ss.android.lark.conditional.access.network.model.response.GetDeviceApplySwitchData;
import com.ss.android.lark.conditional.access.network.model.response.GetDeviceInfoData;
import com.ss.android.lark.conditional.access.network.service.ConditionalAccessNetDependency;
import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import com.ss.android.lark.conditional.access.utils.DisposableViewModel;
import com.ss.android.lark.http.model.http.HttpHeaders;
import com.ss.android.lark.http.model.http.HttpMethod;
import com.ss.android.lark.http.model.http.HttpParams;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import n8b.e;
import n8b.f;
import n8b.g;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000 e2\u00020\u0001:\u0001eB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020D2\b\u0010E\u001a\u0004\u0018\u00010FJ \u0010G\u001a\u00020B2\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020D2\b\u0010K\u001a\u0004\u0018\u00010DJ \u0010L\u001a\u00020B2\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020D2\b\u0010K\u001a\u0004\u0018\u00010DJ*\u0010M\u001a\u00020B2\u0006\u0010H\u001a\u00020N2\b\u0010O\u001a\u0004\u0018\u00010D2\b\u0010P\u001a\u0004\u0018\u00010Q2\u0006\u0010R\u001a\u00020DJ\u0018\u0010S\u001a\u00020B2\u0006\u0010J\u001a\u00020D2\u0006\u0010R\u001a\u00020DH\u0002J\u0006\u0010T\u001a\u00020BJ\u0006\u0010U\u001a\u00020BJ\u0006\u0010V\u001a\u00020BJ\u0006\u0010W\u001a\u00020BJ(\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020D2\u0006\u0010[\u001a\u00020D2\b\b\u0002\u0010\\\u001a\u00020.2\u0006\u0010]\u001a\u00020\u0018J\u000e\u0010^\u001a\u00020Y2\u0006\u0010Z\u001a\u00020DJ\u0016\u0010_\u001a\u00020Y2\u0006\u0010Z\u001a\u00020D2\u0006\u0010`\u001a\u00020DJ\u000e\u0010a\u001a\u00020Y2\u0006\u0010b\u001a\u00020DJ\u000e\u0010c\u001a\u00020B2\u0006\u0010d\u001a\u00020DR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001a¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001cR\u0016\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\"0\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\"0\u001a¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001cR\u0016\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010&0\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010&0\u001a¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001cR\u0016\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010*0\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010*0\u001a¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001cR\u0014\u0010-\u001a\b\u0012\u0004\u0012\u00020.0\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010/\u001a\b\u0012\u0004\u0012\u00020.0\u001a¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001cR\u0014\u00101\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u00102\u001a\b\u0012\u0004\u0012\u00020\u00180\u001a¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u001cR\u0014\u00104\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u00105\u001a\b\u0012\u0004\u0012\u00020\u00180\u001a¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u001cR\u0014\u00107\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u00108\u001a\b\u0012\u0004\u0012\u00020\u00180\u001a¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\u001cR\u0014\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00180\u001a¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\u001cR\u0016\u0010=\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010>0\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010?\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010>0\u001a¢\u0006\b\n\u0000\u001a\u0004\b@\u0010\u001c¨\u0006f"}, d2 = {"Lcom/ss/android/lark/conditional/access/nopermission/viewmodel/NoPermissionViewModel;", "Lcom/ss/android/lark/conditional/access/utils/DisposableViewModel;", "<init>", "()V", "networkDependency", "Lcom/ss/android/lark/conditional/access/network/service/ConditionalAccessNetDependency;", "getNetworkDependency", "()Lcom/ss/android/lark/conditional/access/network/service/ConditionalAccessNetDependency;", "setNetworkDependency", "(Lcom/ss/android/lark/conditional/access/network/service/ConditionalAccessNetDependency;)V", "dependency", "Lcom/ss/android/lark/conditional/access/dependency/IConditionalAccessModuleDependency;", "getDependency", "()Lcom/ss/android/lark/conditional/access/dependency/IConditionalAccessModuleDependency;", "setDependency", "(Lcom/ss/android/lark/conditional/access/dependency/IConditionalAccessModuleDependency;)V", "mfaService", "Lcom/ss/android/lark/passport/mfa/IPassportMFAService;", "getMfaService", "()Lcom/ss/android/lark/passport/mfa/IPassportMFAService;", "setMfaService", "(Lcom/ss/android/lark/passport/mfa/IPassportMFAService;)V", "_pingLiveData", "Landroidx/lifecycle/MutableLiveData;", BuildConfig.FLAVOR, "pingLiveData", "Landroidx/lifecycle/LiveData;", "getPingLiveData", "()Landroidx/lifecycle/LiveData;", "_bindDeviceLiveData", "Lcom/ss/android/lark/conditional/access/network/model/response/BindDeviceData;", "bindDeviceLiveData", "getBindDeviceLiveData", "_deviceInfoLiveData", "Lcom/ss/android/lark/conditional/access/network/model/response/GetDeviceInfoData;", "deviceInfoLiveData", "getDeviceInfoLiveData", "_deviceApplySwitchLiveData", "Lcom/ss/android/lark/conditional/access/network/model/response/GetDeviceApplySwitchData;", "deviceApplySwitchLiveData", "getDeviceApplySwitchLiveData", "_deviceApplySwitchLiveDataV2", "Lcom/bytedance/lark/pb/security/v1/GetDeviceApplySwitchResponse;", "deviceApplySwitchLiveDataV2", "getDeviceApplySwitchLiveDataV2", "_mfaStatusLiveData", BuildConfig.FLAVOR, "mfaStatusLiveData", "getMfaStatusLiveData", "_newMFAStatusLiveData", "newMFAStatusLiveData", "getNewMFAStatusLiveData", "_userConfirmLiveData", "userConfirmLiveData", "getUserConfirmLiveData", "_authLiveData", "authLiveData", "getAuthLiveData", "_certAuthLiveData", "certAuthLiveData", "getCertAuthLiveData", "_displayTemplateLiveData", "Lcom/bytedance/lark/pb/security/v1/CustomDisplayModelResponse;", "displayTemplateLiveData", "getDisplayTemplateLiveData", "ping", BuildConfig.FLAVOR, "pingSource", BuildConfig.FLAVOR, Keys.API_PARAM_KEY_ACTION, "Lcom/ss/android/lark/conditional/access/traffic/InternalSecurityAction;", "checkMfaState", "context", "Landroid/content/Context;", "token", "unit", "startMfaAuth", "startNewMfaAuth", "Landroid/app/Activity;", "scope", "customParams", "Lcom/alibaba/fastjson/JSONObject;", "mfaParams", "submitMFAToken", "getDeviceInfo", "bindDevice", "getDeviceApplySwitchData", "getDeviceApplySwitchDataV2", "startDeviceAuthenticationWithNonce", "Lio/reactivex/disposables/Disposable;", "traceId", Keys.API_RETURN_KEY_NONCE, "challengeType", "needCertVerify", "startDeviceAuthentication", "startDeviceCertAuthentication", IPortraitService.TYPE, "fetchDisplayTemplate", "displayID", "userConfirm", "userConfirmParams", "Companion", "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NoPermissionViewModel extends DisposableViewModel {
    public static final a Companion = null;
    private static final Set<String> DOUBAO_DELAYED_PING_SOURCES = null;
    private static final String TAG = "SecurityPolicy_NoPermissionViewModel";
    private static final String TYPE_NO_PERMISSION_AUTH_BUTTON = "noPermissionAuthButton";
    private final MutableLiveData<Boolean> _authLiveData;
    private final MutableLiveData<BindDeviceData> _bindDeviceLiveData;
    private final MutableLiveData<Boolean> _certAuthLiveData;
    private final MutableLiveData<GetDeviceApplySwitchData> _deviceApplySwitchLiveData;
    private final MutableLiveData<GetDeviceApplySwitchResponse> _deviceApplySwitchLiveDataV2;
    private final MutableLiveData<GetDeviceInfoData> _deviceInfoLiveData;
    private final MutableLiveData<CustomDisplayModelResponse> _displayTemplateLiveData;
    private final MutableLiveData<Integer> _mfaStatusLiveData;
    private final MutableLiveData<Boolean> _newMFAStatusLiveData;
    private final MutableLiveData<Boolean> _pingLiveData;
    private final MutableLiveData<Boolean> _userConfirmLiveData;
    private final LiveData<Boolean> authLiveData;
    private final LiveData<BindDeviceData> bindDeviceLiveData;
    private final LiveData<Boolean> certAuthLiveData;

    @Inject
    public k8b.c dependency;
    private final LiveData<GetDeviceApplySwitchData> deviceApplySwitchLiveData;
    private final LiveData<GetDeviceApplySwitchResponse> deviceApplySwitchLiveDataV2;
    private final LiveData<GetDeviceInfoData> deviceInfoLiveData;
    private final LiveData<CustomDisplayModelResponse> displayTemplateLiveData;

    @Inject
    public yyb.b mfaService;
    private final LiveData<Integer> mfaStatusLiveData;

    @Inject
    public ConditionalAccessNetDependency networkDependency;
    private final LiveData<Boolean> newMFAStatusLiveData;
    private final LiveData<Boolean> pingLiveData;
    private final LiveData<Boolean> userConfirmLiveData;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ Ref.LongRef a;
        public final /* synthetic */ NoPermissionViewModel b;

        public b(Ref.LongRef r1, NoPermissionViewModel r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            Disposable r4 = (Disposable) r3;
            Ref.LongRef r5 = this.a;
            r5.element = System.currentTimeMillis();
            this.b.getNetworkDependency().a.i();
        }
    }

    public static final class c<T, R> implements Function {
        public static final c<T, R> a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final Object apply(Object r2) {
            Intrinsics.checkNotNullParameter((CondAccessPingResponse) r2, "it");
            return Unit.INSTANCE;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ Ref.LongRef a;

        public d(Ref.LongRef r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Disposable r4 = (Disposable) r3;
            Ref.LongRef r5 = this.a;
            r5.element = System.currentTimeMillis();
        }
    }

    static {
        Companion = new a();
        DOUBAO_DELAYED_PING_SOURCES = SetsKt.setOf(new String[]{"on_start", "user_confirm", "mfa_success"});
    }

    public final k8b.c getDependency() {
        k8b.c r0 = this.dependency;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("dependency");
        return null;
    }

    public final yyb.b getMfaService() {
        yyb.b r0 = this.mfaService;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mfaService");
        return null;
    }

    public final ConditionalAccessNetDependency getNetworkDependency() {
        ConditionalAccessNetDependency r0 = this.networkDependency;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("networkDependency");
        return null;
    }

    @Inject
    public NoPermissionViewModel() {
        MutableLiveData<Boolean> r0 = new MutableLiveData();
        this._pingLiveData = r0;
        this.pingLiveData = r0;
        MutableLiveData<BindDeviceData> r1 = new MutableLiveData();
        this._bindDeviceLiveData = r1;
        this.bindDeviceLiveData = r1;
        MutableLiveData<GetDeviceInfoData> r2 = new MutableLiveData();
        this._deviceInfoLiveData = r2;
        this.deviceInfoLiveData = r2;
        MutableLiveData<GetDeviceApplySwitchData> r3 = new MutableLiveData();
        this._deviceApplySwitchLiveData = r3;
        this.deviceApplySwitchLiveData = r3;
        MutableLiveData<GetDeviceApplySwitchResponse> r4 = new MutableLiveData();
        this._deviceApplySwitchLiveDataV2 = r4;
        this.deviceApplySwitchLiveDataV2 = r4;
        MutableLiveData<Integer> r5 = new MutableLiveData();
        this._mfaStatusLiveData = r5;
        this.mfaStatusLiveData = r5;
        MutableLiveData<Boolean> r6 = new MutableLiveData();
        this._newMFAStatusLiveData = r6;
        this.newMFAStatusLiveData = r6;
        MutableLiveData<Boolean> r7 = new MutableLiveData();
        this._userConfirmLiveData = r7;
        this.userConfirmLiveData = r7;
        MutableLiveData<Boolean> r8 = new MutableLiveData();
        this._authLiveData = r8;
        this.authLiveData = r8;
        MutableLiveData<Boolean> r9 = new MutableLiveData();
        this._certAuthLiveData = r9;
        this.certAuthLiveData = r9;
        MutableLiveData<CustomDisplayModelResponse> r10 = new MutableLiveData();
        this._displayTemplateLiveData = r10;
        this.displayTemplateLiveData = r10;
    }

    public final void bindDevice() {
        ConditionalAccessNetDependency r0 = getNetworkDependency();
        r0.getClass();
        HttpMethod r1 = HttpMethod.GET;
        HttpParams r5 = new HttpParams();
        HttpHeaders r6 = new HttpHeaders();
        LinkedHashMap r2 = new LinkedHashMap();
        HttpMethod r4 = HttpMethod.POST;
        Intrinsics.checkNotNullParameter(r4, "method");
        Intrinsics.checkNotNullParameter("/lark/scs/compliance/device/bind/", "path");
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
        com.ss.android.lark.security.compliance.infra.network.a r9 = new com.ss.android.lark.security.compliance.infra.network.a("/lark/scs/compliance/device/bind/", r4, r5, r6, new JSONObject(r2), true);
        r9.c(BuildConfig.FLAVOR);
        t4c.a.b(t4c.a.a(Observable.create(new n8b.b(r0.b, r9)).singleOrError()), getDisposables(), new AnonymousClass1(this), new AnonymousClass2(this));
    }

    public final void getDeviceApplySwitchData() {
        t4c.a.b(t4c.a.a(getNetworkDependency().a()), getDisposables(), new C04131(this), new C04142(this));
    }

    public final void getDeviceApplySwitchDataV2() {
        ConditionalAccessNetDependency r0 = getNetworkDependency();
        r0.getClass();
        com.bytedance.lark.rustclient.api.d r10 = new com.bytedance.lark.rustclient.api.d(new GetDeviceApplySwitchRequest.Builder(), GetDeviceApplySwitchResponse.ADAPTER, Command.GET_DEVICE_APPLY_SWITCH, null, null, null, null, 248);
        t4c.a.b(t4c.a.a(r0.c.h(r10).a().singleOrError().flatMap(n8b.d.a)), getDisposables(), new C04151(this), new C04162(this));
    }

    public final void getDeviceInfo() {
        t4c.a.b(t4c.a.a(getNetworkDependency().b()), getDisposables(), new C04171(this), new C04182(this));
    }

    public final LiveData<Boolean> getAuthLiveData() {
        return this.authLiveData;
    }

    public final LiveData<BindDeviceData> getBindDeviceLiveData() {
        return this.bindDeviceLiveData;
    }

    public final LiveData<Boolean> getCertAuthLiveData() {
        return this.certAuthLiveData;
    }

    public final LiveData<GetDeviceApplySwitchData> getDeviceApplySwitchLiveData() {
        return this.deviceApplySwitchLiveData;
    }

    public final LiveData<GetDeviceApplySwitchResponse> getDeviceApplySwitchLiveDataV2() {
        return this.deviceApplySwitchLiveDataV2;
    }

    public final LiveData<GetDeviceInfoData> getDeviceInfoLiveData() {
        return this.deviceInfoLiveData;
    }

    public final LiveData<CustomDisplayModelResponse> getDisplayTemplateLiveData() {
        return this.displayTemplateLiveData;
    }

    public final LiveData<Integer> getMfaStatusLiveData() {
        return this.mfaStatusLiveData;
    }

    public final LiveData<Boolean> getNewMFAStatusLiveData() {
        return this.newMFAStatusLiveData;
    }

    public final LiveData<Boolean> getPingLiveData() {
        return this.pingLiveData;
    }

    public final LiveData<Boolean> getUserConfirmLiveData() {
        return this.userConfirmLiveData;
    }

    public static final /* synthetic */ MutableLiveData access$get_authLiveData$p(NoPermissionViewModel r0) {
        return r0._authLiveData;
    }

    public static final /* synthetic */ MutableLiveData access$get_bindDeviceLiveData$p(NoPermissionViewModel r0) {
        return r0._bindDeviceLiveData;
    }

    public static final /* synthetic */ MutableLiveData access$get_certAuthLiveData$p(NoPermissionViewModel r0) {
        return r0._certAuthLiveData;
    }

    public static final /* synthetic */ MutableLiveData access$get_deviceApplySwitchLiveData$p(NoPermissionViewModel r0) {
        return r0._deviceApplySwitchLiveData;
    }

    public static final /* synthetic */ MutableLiveData access$get_deviceApplySwitchLiveDataV2$p(NoPermissionViewModel r0) {
        return r0._deviceApplySwitchLiveDataV2;
    }

    public static final /* synthetic */ MutableLiveData access$get_deviceInfoLiveData$p(NoPermissionViewModel r0) {
        return r0._deviceInfoLiveData;
    }

    public static final /* synthetic */ MutableLiveData access$get_displayTemplateLiveData$p(NoPermissionViewModel r0) {
        return r0._displayTemplateLiveData;
    }

    public static final /* synthetic */ MutableLiveData access$get_mfaStatusLiveData$p(NoPermissionViewModel r0) {
        return r0._mfaStatusLiveData;
    }

    public static final /* synthetic */ MutableLiveData access$get_newMFAStatusLiveData$p(NoPermissionViewModel r0) {
        return r0._newMFAStatusLiveData;
    }

    public static final /* synthetic */ MutableLiveData access$get_pingLiveData$p(NoPermissionViewModel r0) {
        return r0._pingLiveData;
    }

    public static final /* synthetic */ MutableLiveData access$get_userConfirmLiveData$p(NoPermissionViewModel r0) {
        return r0._userConfirmLiveData;
    }

    public final Disposable fetchDisplayTemplate(String r14) {
        Intrinsics.checkNotNullParameter(r14, "displayID");
        ScsLogger.d(TAG, "fetchDisplayTemplate");
        ConditionalAccessNetDependency r0 = getNetworkDependency();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r14, "displayId");
        long r1 = System.currentTimeMillis();
        CustomDisplayModelRequest.Builder r5 = new CustomDisplayModelRequest.Builder().id(r14);
        Intrinsics.checkNotNull(r5);
        com.bytedance.lark.rustclient.api.d r15 = new com.bytedance.lark.rustclient.api.d(r5, CustomDisplayModelResponse.ADAPTER, Command.GET_POLICY_SDK_DISPLAY_CONFIG, null, null, null, null, 248);
        return t4c.a.c(t4c.a.a(r0.c.h(r15).a().singleOrError().flatMap(new e(r1))), getDisposables(), new C04111(this), new C04122(this));
    }

    public final void setDependency(k8b.c r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.dependency = r2;
    }

    public final void setMfaService(yyb.b r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mfaService = r2;
    }

    public final void setNetworkDependency(ConditionalAccessNetDependency r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.networkDependency = r2;
    }

    public final Disposable startDeviceAuthentication(String r4) {
        Intrinsics.checkNotNullParameter(r4, "traceId");
        ScsLogger.d(TAG, "startDeviceAuthentication");
        return t4c.a.c(t4c.a.a(getDependency().j(r4, TYPE_NO_PERMISSION_AUTH_BUTTON)), getDisposables(), new C04211(this), new C04222(this));
    }

    public final void userConfirm(String r4) {
        Intrinsics.checkNotNullParameter(r4, "userConfirmParams");
        ScsLogger.d(TAG, "userConfirm");
        t4c.a.b(t4c.a.a(getNetworkDependency().d(r4)), getDisposables(), new C04301(this), new C04312(this));
    }

    private final void submitMFAToken(String r3, String r4) {
        t4c.a.b(t4c.a.a(getNetworkDependency().c(r3, r4)), getDisposables(), new C04281(this), new C04292(this));
    }

    public final void ping(final String r22, final InternalSecurityAction r23) {
        Intrinsics.checkNotNullParameter(r22, "pingSource");
        final Ref.LongRef r8 = new Ref.LongRef();
        boolean r0 = false;
        if (r23 != null) goto L5;
    L7:
        boolean r9 = false;
    L8:
        final boolean r10 = o8b.a.a(r23);
        if (r10 == false) goto L11;
        Single r2 = getDependency().g().doOnSubscribe(new b(r8, this));
    L12:
        Intrinsics.checkNotNull(r2);
        LarkAppContext.Companion.getClass();
        if (LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK() == true) goto L15;
    L17:
        if (r0 == false) goto L19;
        r2 = r2.delaySubscription(RangesKt.coerceAtLeast(w4c.c.a().u(), 0), TimeUnit.MILLISECONDS);
    L19:
        Intrinsics.checkNotNull(r2);
        final boolean r3 = r9;
        t4c.a.b(t4c.a.a(r2), getDisposables(), new C04191(this, r3, r10, r23, r22, r8), new C04202(this, r3, r10, r23, r22, r8));
        return;
    L15:
        if (DOUBAO_DELAYED_PING_SOURCES.contains(r22) == false) goto L17;
        r0 = true;
        goto L17
    L11:
        ConditionalAccessNetDependency r4 = getNetworkDependency();
        r4.getClass();
        com.bytedance.lark.rustclient.api.d r5 = new com.bytedance.lark.rustclient.api.d(new CondAccessPingRequest.Builder(), CondAccessPingResponse.ADAPTER, Command.COND_ACCESS_PING, null, null, null, null, 248);
        r2 = r4.c.h(r5).a().doOnSubscribe(new f(r4)).singleOrError().flatMap(g.a).map(c.a).doOnSubscribe(new d(r8));
        goto L12
    L5:
        if (r23.getSource() != 1) goto L7;
        r9 = true;
        goto L8
    }

    public final Disposable startDeviceCertAuthentication(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "traceId");
        Intrinsics.checkNotNullParameter(r4, IPortraitService.TYPE);
        ScsLogger.d(TAG, "startDeviceCertAuthentication");
        return t4c.a.c(t4c.a.a(getDependency().j(r3, r4)), getDisposables(), new C04251(this), new C04262(this));
    }

    public static final /* synthetic */ void access$submitMFAToken(NoPermissionViewModel r0, String r1, String r2) {
        r0.submitMFAToken(r1, r2);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.ss.android.lark.conditional.access.nopermission.viewmodel.NoPermissionViewModel$checkMfaState$1] */
    public final void checkMfaState(Context r3, final String r4, final String r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "token");
        getDependency().getPassportDependency().b(r3, r4, new C04101(this, r4, r5));
    }

    public final void startMfaAuth(Context r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "token");
        int r0 = ScsLogger.a;
        ScsLogger.d(TAG, "start mfa: unit: " + r5);
        getDependency().getPassportDependency().i(r3, r4);
    }

    public final Disposable startDeviceAuthenticationWithNonce(String r1, String r2, int r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r1, "traceId");
        Intrinsics.checkNotNullParameter(r2, Keys.API_RETURN_KEY_NONCE);
        int r5 = ScsLogger.a;
        ScsLogger.d(TAG, "startDeviceAuthenticationWithNonce, nonce: " + r2);
        return t4c.a.c(t4c.a.a(getDependency().h(r1, r2)), getDisposables(), new C04231(this), new C04242(this));
    }

    public final void startNewMfaAuth(Activity r3, String r4, com.alibaba.fastjson.JSONObject r5, final String r6) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r6, "mfaParams");
        ScsLogger.d(TAG, "startNewMfaAuth");
        getMfaService().a(r3, r4, r5, new C04271(this, r6));
    }

    public static /* synthetic */ Disposable startDeviceAuthenticationWithNonce$default(NoPermissionViewModel r0, String r1, String r2, int r3, boolean r4, int r5, Object r6) {
        if ((r5 & 4) == 0) goto L6;
        r3 = 0;
    L6:
        return r0.startDeviceAuthenticationWithNonce(r1, r2, r3, r4);
    }
}
