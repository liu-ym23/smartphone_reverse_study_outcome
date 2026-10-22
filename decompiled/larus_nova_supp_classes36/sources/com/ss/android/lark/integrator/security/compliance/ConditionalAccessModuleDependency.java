package com.ss.android.lark.integrator.security.compliance;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.biz.im.api.IIMApi;
import com.ss.android.lark.chameleonv2.Chameleon;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.security.compliance.api.model.filepolicy.IMFileEntity;
import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyModel;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.lark.utils.ApiUtils;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.ExceptionsKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Singleton
public final class ConditionalAccessModuleDependency implements k8b.c {
    public static final /* synthetic */ int c = 0;
    public final ConditionalAccessModuleDependency$passportDependency$1 a;
    public final b b;

    public static final class a {
    }

    public static final class b {
        public b() {
        }

        public final void a(Context r4, Bundle r5) {
            Intrinsics.checkNotNullParameter(r4, "context");
            Intrinsics.checkNotNullParameter(r5, "bundle");
            String r6 = r5.getString("url");
            if (r6 != null) goto L5;
        L8:
            boolean r2 = true;
        L9:
            if (r2 == false) goto L12;
            ScsLogger.c("OfficeSDKCondAccessDep", "openH5Url url is null or blank, skip");
            return;
        L12:
            f.a.getClass();
            Intrinsics.checkNotNullParameter(r4, "context");
            Intrinsics.checkNotNullParameter(r6, "url");
            if (StringsKt.isBlank(r6) == false) goto L23;
            ScsLogger.c("OfficeSDKSecWebCtn", "openUrl url is blank, skip");
            return;
        L23:
        L20:
            th = move-exception;
            int r7 = ScsLogger.a;
            ScsLogger.c("OfficeSDKSecWebCtn", "openUrl Chameleon.open failed: " + ExceptionsKt.stackTraceToString(th));
            return;
        L16:
            if (f.b(r4, r6) == true) goto L26;
            Chameleon r0 = Chameleon.a;     // Catch: Throwable -> L20
            Chameleon.b(r4, f.a(r6), null);     // Catch: Throwable -> L20
            return;
        L26:
            return;
        L5:
            if (StringsKt.isBlank(r6) == true) goto L8;
            r2 = false;
            goto L9
        }
    }

    public static final class c<T> implements SingleOnSubscribe {
        public final /* synthetic */ rwb.a a;

        public static final class a implements rwb.a.a {
            public final /* synthetic */ SingleEmitter<Unit> a;

            public final void onSuccess() {
                if (this.a.isDisposed() == true) goto L6;
                this.a.onSuccess(Unit.INSTANCE);
                return;
            }

            public a(SingleEmitter<Unit> r1) {
                this.a = r1;
            }

            public final void onError(int r5, String r6) {
                if (this.a.isDisposed() == true) goto L9;
                SingleEmitter<Unit> r0 = this.a;
                StringBuilder r2 = new StringBuilder("Flow conditional access ping failed, code=");
                r2.append(r5);
                r2.append(", message=");
                if (r6 != null) goto L7;
                r6 = "";
            L7:
                r2.append(r6);
                r0.onError(new IllegalStateException(r2.toString()));
                return;
            }
        }

        public c(rwb.a r1) {
            this.a = r1;
        }

        public final void subscribe(SingleEmitter<Unit> r3) {
            Intrinsics.checkNotNullParameter(r3, "emitter");
            this.a.T0(new a(r3));
        }
    }

    static {
    }

    public final void b(Context r2, UserSession r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "userSession");
    }

    public final void i(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
    }

    public final void k(Context r2, UserSession r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "userSession");
    }

    public final void l(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
    }

    public final void m(FragmentActivity r2, UserSession r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "userSession");
    }

    public final Single<Boolean> c() {
        return Single.just(Boolean.FALSE);
    }

    public final List<PolicyModel> f() {
        IIMApi r0 = (IIMApi) ApiUtils.getApi(IIMApi.class);
        if (r0 == null) goto L5;
        List r1 = r0.getCurrentPageAuthEntities();
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator r3 = r1.iterator();
    L8:
        if (r3.hasNext() == false) goto L10;
        IMFileEntity r5 = (IMFileEntity) r3.next();
        Intrinsics.checkNotNull(r5);
        r2.add(new PolicyModel("PointKey_IM_MSG_FILE_READ", r5, null, 4, null));
        goto L8
    L10:
        return r2;
    L5:
        return CollectionsKt.emptyList();
    }

    public final Single<Unit> g() {
        rwb.a r0 = OfficeSDKManager.getHostGlobalService(rwb.a.class);
        if (r0 != null) goto L7;
        return Single.error(new IllegalStateException("External source ping service is unavailable"));
    L7:
        return Single.create(new c(r0));
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.ss.android.lark.integrator.security.compliance.ConditionalAccessModuleDependency$passportDependency$1] */
    @Inject
    public ConditionalAccessModuleDependency() {
        this.a = new ConditionalAccessModuleDependency$passportDependency$1(this);
        this.b = new b();
    }

    public final b e() {
        return this.b;
    }

    public final ConditionalAccessModuleDependency$passportDependency$1 getPassportDependency() {
        return this.a;
    }

    public final boolean n(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        if ((r2 instanceof Activity) == false) goto L5;
        Activity r3 = (Activity) r2;
    L6:
        if (r3 == null) goto L12;
        String r4 = r3.getClass().getName();
        List r0 = w4c.c.a().n0();
        if (r0 != null) goto L11;
        r0 = CollectionsKt.emptyList();
    L11:
        return r0.contains(r4);
    L12:
        return false;
    L5:
        r3 = null;
        goto L6
    }

    public final void a(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "userId");
        Toast.makeText(r2, 2131892526, 0).show();
    }

    public final Single<k8b.a> d(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "traceId");
        Intrinsics.checkNotNullParameter(r3, "type");
        return Single.just(new k8b.a());
    }

    public final Single h(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "traceId");
        Intrinsics.checkNotNullParameter(r3, "nonce");
        return Single.just(new k8b.a());
    }

    public final Single<k8b.a> j(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "traceId");
        Intrinsics.checkNotNullParameter(r3, "type");
        return Single.just(new k8b.a());
    }
}
