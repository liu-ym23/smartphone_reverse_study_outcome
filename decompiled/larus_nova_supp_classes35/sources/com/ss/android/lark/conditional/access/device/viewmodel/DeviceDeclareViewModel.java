package com.ss.android.lark.conditional.access.device.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.ss.android.lark.conditional.access.network.model.response.ApplyDeviceData;
import com.ss.android.lark.conditional.access.network.model.response.GetDeviceApplySwitchData;
import com.ss.android.lark.conditional.access.network.model.response.GetDeviceInfoData;
import com.ss.android.lark.conditional.access.network.service.ConditionalAccessNetDependency;
import com.ss.android.lark.conditional.access.utils.DisposableViewModel;
import com.ss.android.lark.http.model.http.HttpHeaders;
import com.ss.android.lark.http.model.http.HttpMethod;
import com.ss.android.lark.http.model.http.HttpParams;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import io.reactivex.Observable;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import jdb.g;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import n8b.h;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u0000 82\u00020\u0001:\u00018B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u00100\u001a\u000201J\u0006\u00102\u001a\u000201J\u0018\u00103\u001a\u0002012\u0006\u0010#\u001a\u00020$2\b\b\u0002\u00104\u001a\u00020*J\u000e\u00105\u001a\u0002012\u0006\u0010#\u001a\u00020$J\u0006\u00106\u001a\u00020 J\u0006\u00107\u001a\u000201R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0016\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0012R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u0010¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0012R\u001a\u0010#\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u000e\u0010/\u001a\u00020*X\u0082D¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/ss/android/lark/conditional/access/device/viewmodel/DeviceDeclareViewModel;", "Lcom/ss/android/lark/conditional/access/utils/DisposableViewModel;", "fgService", "Lcom/ss/android/lark/featuregatingv2/interfaces/IUserFeatureGatingService;", "<init>", "(Lcom/ss/android/lark/featuregatingv2/interfaces/IUserFeatureGatingService;)V", "networkDependency", "Lcom/ss/android/lark/conditional/access/network/service/ConditionalAccessNetDependency;", "getNetworkDependency", "()Lcom/ss/android/lark/conditional/access/network/service/ConditionalAccessNetDependency;", "setNetworkDependency", "(Lcom/ss/android/lark/conditional/access/network/service/ConditionalAccessNetDependency;)V", "_deviceInfoLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/ss/android/lark/conditional/access/network/model/response/GetDeviceInfoData;", "deviceInfoLiveData", "Landroidx/lifecycle/LiveData;", "getDeviceInfoLiveData", "()Landroidx/lifecycle/LiveData;", "_deviceApplySwitchLiveData", "Lcom/ss/android/lark/conditional/access/network/model/response/GetDeviceApplySwitchData;", "deviceApplySwitchLiveData", "getDeviceApplySwitchLiveData", "_applyDeviceLiveData", "Lcom/ss/android/lark/conditional/access/network/model/response/ApplyDeviceData;", "applyDeviceLiveData", "getApplyDeviceLiveData", "_launchReasonEditLiveData", BuildConfig.FLAVOR, "launchReasonEditLiveData", "getLaunchReasonEditLiveData", "_pinLiveData", BuildConfig.FLAVOR, "pinLiveData", "getPinLiveData", "ownership", BuildConfig.FLAVOR, "getOwnership", "()I", "setOwnership", "(I)V", "reason", BuildConfig.FLAVOR, "getReason", "()Ljava/lang/String;", "setReason", "(Ljava/lang/String;)V", "deviceApplyReasonFG", "getDeviceInfo", BuildConfig.FLAVOR, "getDeviceApplySwitchData", "applyDevice", "applyReason", "launchReasonEditPage", "deviceApplyReasonEnable", "pin", "Companion", "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DeviceDeclareViewModel extends DisposableViewModel {
    public static final a Companion = null;
    private static final String TAG = "SecurityPolicy_UserScopeDeviceDeclareViewModel";
    private final MutableLiveData<ApplyDeviceData> _applyDeviceLiveData;
    private final MutableLiveData<GetDeviceApplySwitchData> _deviceApplySwitchLiveData;
    private final MutableLiveData<GetDeviceInfoData> _deviceInfoLiveData;
    private final MutableLiveData<Object> _launchReasonEditLiveData;
    private final MutableLiveData<Boolean> _pinLiveData;
    private final LiveData<ApplyDeviceData> applyDeviceLiveData;
    private final String deviceApplyReasonFG;
    private final LiveData<GetDeviceApplySwitchData> deviceApplySwitchLiveData;
    private final LiveData<GetDeviceInfoData> deviceInfoLiveData;
    private final g fgService;
    private final LiveData<Object> launchReasonEditLiveData;

    @Inject
    public ConditionalAccessNetDependency networkDependency;
    private int ownership;
    private final LiveData<Boolean> pinLiveData;
    private String reason;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final boolean deviceApplyReasonEnable() {
        return this.fgService.isEnable(this.deviceApplyReasonFG);
    }

    public final ConditionalAccessNetDependency getNetworkDependency() {
        ConditionalAccessNetDependency r0 = this.networkDependency;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("networkDependency");
        return null;
    }

    public final void getDeviceApplySwitchData() {
        t4c.a.b(t4c.a.a(getNetworkDependency().a()), getDisposables(), new C04041(this), new C04052(this));
    }

    public final void getDeviceInfo() {
        t4c.a.b(t4c.a.a(getNetworkDependency().b()), getDisposables(), new C04061(this), new C04072(this));
    }

    public final void pin() {
        ConditionalAccessNetDependency r0 = getNetworkDependency();
        r0.getClass();
        HttpMethod r1 = HttpMethod.GET;
        HttpParams r5 = new HttpParams();
        HttpHeaders r6 = new HttpHeaders();
        LinkedHashMap r2 = new LinkedHashMap();
        HttpMethod r4 = HttpMethod.GET;
        Intrinsics.checkNotNullParameter(r4, "method");
        Intrinsics.checkNotNullParameter("/lark/scs/compliance/ping/", "path");
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
        com.ss.android.lark.security.compliance.infra.network.a r9 = new com.ss.android.lark.security.compliance.infra.network.a("/lark/scs/compliance/ping/", r4, r5, r6, new JSONObject(r2), true);
        r9.c(BuildConfig.FLAVOR);
        r0.a.i();
        t4c.a.b(t4c.a.a(Observable.create(new h(r0.b, r9)).singleOrError()), getDisposables(), new C04081(this), new C04092(this));
    }

    public final LiveData<ApplyDeviceData> getApplyDeviceLiveData() {
        return this.applyDeviceLiveData;
    }

    public final LiveData<GetDeviceApplySwitchData> getDeviceApplySwitchLiveData() {
        return this.deviceApplySwitchLiveData;
    }

    public final LiveData<GetDeviceInfoData> getDeviceInfoLiveData() {
        return this.deviceInfoLiveData;
    }

    public final LiveData<Object> getLaunchReasonEditLiveData() {
        return this.launchReasonEditLiveData;
    }

    public final int getOwnership() {
        return this.ownership;
    }

    public final LiveData<Boolean> getPinLiveData() {
        return this.pinLiveData;
    }

    public final String getReason() {
        return this.reason;
    }

    @Inject
    public DeviceDeclareViewModel(g r2) {
        Intrinsics.checkNotNullParameter(r2, "fgService");
        this.fgService = r2;
        MutableLiveData<GetDeviceInfoData> r3 = new MutableLiveData();
        this._deviceInfoLiveData = r3;
        this.deviceInfoLiveData = r3;
        MutableLiveData<GetDeviceApplySwitchData> r4 = new MutableLiveData();
        this._deviceApplySwitchLiveData = r4;
        this.deviceApplySwitchLiveData = r4;
        MutableLiveData<ApplyDeviceData> r5 = new MutableLiveData();
        this._applyDeviceLiveData = r5;
        this.applyDeviceLiveData = r5;
        MutableLiveData<Object> r6 = new MutableLiveData();
        this._launchReasonEditLiveData = r6;
        this.launchReasonEditLiveData = r6;
        MutableLiveData<Boolean> r7 = new MutableLiveData();
        this._pinLiveData = r7;
        this.pinLiveData = r7;
        this.ownership = ConditionalAccessNetDependency.DeviceOwnership.Unknown.getValue();
        this.reason = BuildConfig.FLAVOR;
        this.deviceApplyReasonFG = "lark.security.device_apply_approval";
    }

    public static final /* synthetic */ MutableLiveData access$get_applyDeviceLiveData$p(DeviceDeclareViewModel r0) {
        return r0._applyDeviceLiveData;
    }

    public static final /* synthetic */ MutableLiveData access$get_deviceApplySwitchLiveData$p(DeviceDeclareViewModel r0) {
        return r0._deviceApplySwitchLiveData;
    }

    public static final /* synthetic */ MutableLiveData access$get_deviceInfoLiveData$p(DeviceDeclareViewModel r0) {
        return r0._deviceInfoLiveData;
    }

    public static final /* synthetic */ MutableLiveData access$get_pinLiveData$p(DeviceDeclareViewModel r0) {
        return r0._pinLiveData;
    }

    public final void launchReasonEditPage(int r2) {
        this.ownership = r2;
        this._applyDeviceLiveData.setValue(null);
        this._launchReasonEditLiveData.setValue(new Object());
    }

    public final void setNetworkDependency(ConditionalAccessNetDependency r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.networkDependency = r2;
    }

    public final void setOwnership(int r1) {
        this.ownership = r1;
    }

    public final void setReason(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.reason = r2;
    }

    public final void applyDevice(int r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, "applyReason");
        p8b.a.a("declare");
        ConditionalAccessNetDependency r1 = getNetworkDependency();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r11, "applyReason");
        HttpMethod r0 = HttpMethod.GET;
        HttpParams r5 = new HttpParams();
        HttpHeaders r6 = new HttpHeaders();
        LinkedHashMap r2 = new LinkedHashMap();
        HttpMethod r4 = HttpMethod.POST;
        Intrinsics.checkNotNullParameter(r4, "method");
        Intrinsics.checkNotNullParameter("/lark/scs/compliance/device/apply", "path");
        Map r12 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("ownership", Integer.valueOf(r10)), TuplesKt.to("apply_reason", r11)});
        Intrinsics.checkNotNullParameter(r12, "body");
        r2.putAll(r12);
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
        com.ss.android.lark.security.compliance.infra.network.a r13 = new com.ss.android.lark.security.compliance.infra.network.a("/lark/scs/compliance/device/apply", r4, r5, r6, new JSONObject(r2), true);
        r13.c(BuildConfig.FLAVOR);
        t4c.a.b(t4c.a.a(Observable.create(new n8b.a(r1.b, r13)).singleOrError()), getDisposables(), new AnonymousClass1(this), new AnonymousClass2(this));
    }

    public static /* synthetic */ void applyDevice$default(DeviceDeclareViewModel r0, int r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = BuildConfig.FLAVOR;
    L5:
        r0.applyDevice(r1, r2);
    }
}
