package com.ss.android.lark.conditional.access.network.service;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.LarkError;
import com.bytedance.lark.pb.security.v1.SubmitMFATokenRequest;
import com.bytedance.lark.pb.security.v1.SubmitMFATokenResponse;
import com.bytedance.lark.pb.security.v1.UserConfirmRequest;
import com.bytedance.lark.pb.security.v1.UserConfirmResponse;
import com.bytedance.lark.rustclient.api.l;
import com.bytedance.lark.rustclient.api.p;
import com.bytedance.lark.rustclient.api.s;
import com.bytedance.lark.rustclient.api.x;
import com.ss.android.lark.chat.api.service.track.sample.BaseSampleRecorder$Scene;
import com.ss.android.lark.conditional.access.network.model.response.GetDeviceApplySwitchData;
import com.ss.android.lark.conditional.access.network.model.response.GetDeviceInfoData;
import com.ss.android.lark.conditional.access.nopermission.manager.NoPermissionModuleManager;
import com.ss.android.lark.http.model.http.HttpHeaders;
import com.ss.android.lark.http.model.http.HttpMethod;
import com.ss.android.lark.http.model.http.HttpParams;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.lark.security.compliance.infra.network.NetworkErrorResult;
import com.ss.android.lark.security.compliance.infra.network.g;
import com.ss.android.lark.security.compliance.infra.network.h;
import com.ss.android.lark.security.compliance.infra.network.service.NetworkErrorResultException;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@UserScope
public final class ConditionalAccessNetDependency {
    public final NoPermissionModuleManager a;
    public final com.ss.android.lark.security.compliance.infra.network.userscpoe.a b;
    public final l c;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/conditional/access/network/service/ConditionalAccessNetDependency$DeviceApplyStatus;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", BaseSampleRecorder$Scene.UNKNOWN, "NoApply", "Processing", "Pass", "Reject", "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum DeviceApplyStatus extends Enum<DeviceApplyStatus> {
        public static final DeviceApplyStatus NoApply = null;
        public static final DeviceApplyStatus Pass = null;
        public static final DeviceApplyStatus Processing = null;
        public static final DeviceApplyStatus Reject = null;
        public static final DeviceApplyStatus Unknown = null;
        public static final /* synthetic */ DeviceApplyStatus[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static EnumEntries<DeviceApplyStatus> getEntries() {
            return b;
        }

        static {
            DeviceApplyStatus r0 = new DeviceApplyStatus(BaseSampleRecorder$Scene.UNKNOWN, 0, 0);
            Unknown = r0;
            DeviceApplyStatus r1 = new DeviceApplyStatus("NoApply", 1, 1);
            NoApply = r1;
            DeviceApplyStatus r3 = new DeviceApplyStatus("Processing", 2, 2);
            Processing = r3;
            DeviceApplyStatus r5 = new DeviceApplyStatus("Pass", 3, 3);
            Pass = r5;
            DeviceApplyStatus r7 = new DeviceApplyStatus("Reject", 4, 4);
            Reject = r7;
            DeviceApplyStatus[] r9 = {r0, r1, r3, r5, r7};
            a = r9;
            b = EnumEntriesKt.enumEntries(r9);
        }

        public static DeviceApplyStatus[] values() {
            return (DeviceApplyStatus[]) a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static DeviceApplyStatus valueOf(String r1) {
            return (DeviceApplyStatus) r27.a.a(DeviceApplyStatus.class, r1);
        }

        public DeviceApplyStatus(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/conditional/access/network/service/ConditionalAccessNetDependency$DeviceOwnership;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", BaseSampleRecorder$Scene.UNKNOWN, "Company", "Personal", "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum DeviceOwnership extends Enum<DeviceOwnership> {
        public static final DeviceOwnership Company = null;
        public static final DeviceOwnership Personal = null;
        public static final DeviceOwnership Unknown = null;
        public static final /* synthetic */ DeviceOwnership[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static EnumEntries<DeviceOwnership> getEntries() {
            return b;
        }

        static {
            DeviceOwnership r0 = new DeviceOwnership(BaseSampleRecorder$Scene.UNKNOWN, 0, 0);
            Unknown = r0;
            DeviceOwnership r1 = new DeviceOwnership("Company", 1, 1);
            Company = r1;
            DeviceOwnership r3 = new DeviceOwnership("Personal", 2, 2);
            Personal = r3;
            DeviceOwnership[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static DeviceOwnership[] values() {
            return (DeviceOwnership[]) a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static DeviceOwnership valueOf(String r1) {
            return (DeviceOwnership) r27.a.a(DeviceOwnership.class, r1);
        }

        public DeviceOwnership(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a {
    }

    public static final class b<T> implements ObservableOnSubscribe {
        public final /* synthetic */ com.ss.android.lark.security.compliance.infra.network.userscpoe.a a;
        public final /* synthetic */ g b;

        public static final class a implements com.ss.android.lark.security.compliance.infra.network.d<T> {
            public final /* synthetic */ ObservableEmitter a;

            public final Type b() {
                return GetDeviceApplySwitchData.class;
            }

            public a(ObservableEmitter r1) {
                this.a = r1;
            }

            public final void a(NetworkErrorResult r3) {
                Intrinsics.checkNotNullParameter(r3, "networkErrorResult");
                if (this.a.isDisposed() == true) goto L6;
                this.a.onError(new NetworkErrorResultException(r3));
                return;
            }

            public final void c(h<T> r2) {
                Intrinsics.checkNotNullParameter(r2, Keys.API_RETURN_KEY_DATA);
                if (this.a.isDisposed() == true) goto L6;
                this.a.onNext(r2);
                this.a.onComplete();
                return;
            }
        }

        public b(com.ss.android.lark.security.compliance.infra.network.userscpoe.a r1, com.ss.android.lark.security.compliance.infra.network.a r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void subscribe(ObservableEmitter<h<T>> r4) {
            Intrinsics.checkNotNullParameter(r4, "it");
            this.a.a(this.b, new a(r4));
        }
    }

    public static final class c<T> implements ObservableOnSubscribe {
        public final /* synthetic */ com.ss.android.lark.security.compliance.infra.network.userscpoe.a a;
        public final /* synthetic */ g b;

        public static final class a implements com.ss.android.lark.security.compliance.infra.network.d<T> {
            public final /* synthetic */ ObservableEmitter a;

            public final Type b() {
                return GetDeviceInfoData.class;
            }

            public a(ObservableEmitter r1) {
                this.a = r1;
            }

            public final void a(NetworkErrorResult r3) {
                Intrinsics.checkNotNullParameter(r3, "networkErrorResult");
                if (this.a.isDisposed() == true) goto L6;
                this.a.onError(new NetworkErrorResultException(r3));
                return;
            }

            public final void c(h<T> r2) {
                Intrinsics.checkNotNullParameter(r2, Keys.API_RETURN_KEY_DATA);
                if (this.a.isDisposed() == true) goto L6;
                this.a.onNext(r2);
                this.a.onComplete();
                return;
            }
        }

        public c(com.ss.android.lark.security.compliance.infra.network.userscpoe.a r1, com.ss.android.lark.security.compliance.infra.network.a r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void subscribe(ObservableEmitter<h<T>> r4) {
            Intrinsics.checkNotNullParameter(r4, "it");
            this.a.a(this.b, new a(r4));
        }
    }

    public static final class d<T, R> implements Function {
        public static final d<T, R> a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final Object apply(Object r6) {
            x r7 = (s) r6;
            Intrinsics.checkNotNullParameter(r7, "it");
            if ((r7 instanceof x) == false) goto L6;
            return Single.just(r7.c);
        L6:
            if ((r7 instanceof com.bytedance.lark.rustclient.api.c) == false) goto L18;
            com.bytedance.lark.rustclient.api.c r8 = (com.bytedance.lark.rustclient.api.c) r7;
            p r0 = r8.c;
            LarkError r1 = r0.b;
            Integer r2 = null;
            if (r1 == null) goto L12;
            LarkError.ErrorDetails r3 = r1.details;
            if (r3 == null) goto L12;
            String r4 = r3.x_tt_logid;
        L13:
            if (r1 == null) goto L15;
            r2 = r1.code;
        L15:
            String r5 = r0.c();
            int r9 = ScsLogger.a;
            ScsLogger.c("ConditionalAccessNetDependency", "submitMFAToken error, logId: " + r4 + ", errorCode: " + r2 + ", error is " + r5);
            return Single.error(r8.c.b());
        L12:
            r4 = null;
            goto L13
        L18:
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class e<T, R> implements Function {
        public static final e<T, R> a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final Object apply(Object r6) {
            x r7 = (s) r6;
            Intrinsics.checkNotNullParameter(r7, "it");
            if ((r7 instanceof x) == false) goto L6;
            return Single.just(r7.c);
        L6:
            if ((r7 instanceof com.bytedance.lark.rustclient.api.c) == false) goto L18;
            com.bytedance.lark.rustclient.api.c r8 = (com.bytedance.lark.rustclient.api.c) r7;
            p r0 = r8.c;
            LarkError r1 = r0.b;
            Integer r2 = null;
            if (r1 == null) goto L12;
            LarkError.ErrorDetails r3 = r1.details;
            if (r3 == null) goto L12;
            String r4 = r3.x_tt_logid;
        L13:
            if (r1 == null) goto L15;
            r2 = r1.code;
        L15:
            String r5 = r0.c();
            int r9 = ScsLogger.a;
            ScsLogger.c("ConditionalAccessNetDependency", "userConfirm error, logId: " + r4 + ", errorCode: " + r2 + ", error is " + r5);
            return Single.error(r8.c.b());
        L12:
            r4 = null;
            goto L13
        L18:
            throw new NoWhenBranchMatchedException();
        }
    }

    static {
    }

    public final Single<h<GetDeviceApplySwitchData>> a() {
        HttpMethod r0 = HttpMethod.GET;
        HttpParams r4 = new HttpParams();
        HttpHeaders r5 = new HttpHeaders();
        LinkedHashMap r1 = new LinkedHashMap();
        HttpMethod r3 = HttpMethod.GET;
        Intrinsics.checkNotNullParameter(r3, "method");
        Intrinsics.checkNotNullParameter("/lark/scs/compliance/device/apply_switch/", "path");
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
        com.ss.android.lark.security.compliance.infra.network.a r8 = new com.ss.android.lark.security.compliance.infra.network.a("/lark/scs/compliance/device/apply_switch/", r3, r4, r5, new JSONObject(r1), true);
        r8.c(BuildConfig.FLAVOR);
        return Observable.create(new b(this.b, r8)).singleOrError();
    }

    public final Single<h<GetDeviceInfoData>> b() {
        HttpMethod r0 = HttpMethod.GET;
        HttpParams r4 = new HttpParams();
        HttpHeaders r5 = new HttpHeaders();
        LinkedHashMap r1 = new LinkedHashMap();
        HttpMethod r3 = HttpMethod.GET;
        Intrinsics.checkNotNullParameter(r3, "method");
        Intrinsics.checkNotNullParameter("/lark/scs/compliance/device/info/", "path");
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
        com.ss.android.lark.security.compliance.infra.network.a r8 = new com.ss.android.lark.security.compliance.infra.network.a("/lark/scs/compliance/device/info/", r3, r4, r5, new JSONObject(r1), true);
        r8.c(BuildConfig.FLAVOR);
        return Observable.create(new c(this.b, r8)).singleOrError();
    }

    public final Single<UserConfirmResponse> d(String r11) {
        Intrinsics.checkNotNullParameter(r11, "userConfirmParams");
        UserConfirmRequest.Builder r2 = new UserConfirmRequest.Builder().user_confirm_params(r11);
        Intrinsics.checkNotNull(r2);
        com.bytedance.lark.rustclient.api.d r12 = new com.bytedance.lark.rustclient.api.d(r2, UserConfirmResponse.ADAPTER, Command.POLICY_CENTER_USER_CONFIRM, null, null, null, null, 248);
        return this.c.h(r12).a().singleOrError().flatMap(e.a);
    }

    public final Single<SubmitMFATokenResponse> c(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "token");
        Intrinsics.checkNotNullParameter(r11, "mfaParams");
        SubmitMFATokenRequest.Builder r1 = new SubmitMFATokenRequest.Builder().mfa_token(r10).mfa_params(r11);
        Intrinsics.checkNotNull(r1);
        com.bytedance.lark.rustclient.api.d r12 = new com.bytedance.lark.rustclient.api.d(r1, SubmitMFATokenResponse.ADAPTER, Command.POLICY_CENTER_SUBMIT_MFA_TOKEN, null, null, null, null, 248);
        return this.c.h(r12).a().singleOrError().flatMap(d.a);
    }

    @Inject
    public ConditionalAccessNetDependency(NoPermissionModuleManager r2, com.ss.android.lark.security.compliance.infra.network.userscpoe.a r3, l r4) {
        Intrinsics.checkNotNullParameter(r2, "noPermissionModuleManager");
        Intrinsics.checkNotNullParameter(r3, "requestService");
        Intrinsics.checkNotNullParameter(r4, "userClient");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
