package com.bytedance.android.live.saas.middleware.sec;

import android.app.Application;
import com.bytedance.android.live.saas.middleware.BDLiveSdk;
import com.bytedance.android.live.saas.middleware.BDLiveSdkSubject;
import com.bytedance.android.live.saas.middleware.IAppInfo;
import com.bytedance.android.live.saas.middleware.applog.IAppLog;
import com.bytedance.android.live.saas.middleware.base.ISdkInitTask;
import com.bytedance.mobsec.metasec.ml.MSConfig;
import com.bytedance.mobsec.metasec.ml.MSManagerUtils;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\u000bH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/sec/SecInitTask;", "Lcom/bytedance/android/live/saas/middleware/base/ISdkInitTask;", "Lcom/bytedance/android/live/saas/middleware/sec/SecConfig;", "()V", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "getCompositeDisposable", "()Lio/reactivex/disposables/CompositeDisposable;", "setCompositeDisposable", "(Lio/reactivex/disposables/CompositeDisposable;)V", "init", "", "app", "Landroid/app/Application;", "params", "unInit", "Companion", "middleware_release"}, k = 1, mv = {1, 4, 3})
public final class SecInitTask implements ISdkInitTask<SecConfig> {
    public static final Companion Companion = null;
    public static final String SEC_LICENSE = "fYOkElOR9W8vhjcet52YNqwLRLczIzh3gbVStq9vzAuLC8FDqQRMIlnSTckQQ0ITsXPdUGf914AUcfl59IhzM/Suzmj+yaCGxvU8W3P8MkJiJRQZ9GUGvh38ay/Hbepa6cnp/SgdVGka53MKxlJLLTqLvLbCTWMVXFyPHs0SOCxatgeSiSVcfNz+3qgJXrqYSetafD/JW7AvxvejLstegZkJlHlj1Vu0n1qnucEKgjoR/dQTrFXp+gx0RUELKho2s8UY17PDOuFTyjhKAth9U3/kiU2Ew/6yuanWJ9yaVsiTupmoYb+tSzOqCGKkWS3OP80QciN9+lz6bh/CkGr/LOC2M+o=";
    private static boolean sInit;
    private CompositeDisposable compositeDisposable;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/sec/SecInitTask$Companion;", "", "()V", "SEC_LICENSE", "", "sInit", "", "getSInit", "()Z", "setSInit", "(Z)V", "middleware_release"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public final boolean getSInit() {
            return SecInitTask.access$getSInit$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final void setSInit(boolean r1) {
            SecInitTask.access$setSInit$cp(r1);
        }
    }

    static {
        Companion = new Companion(null);
    }

    @Override // com.bytedance.android.live.saas.middleware.base.ISdkInitTask
    public void unInit() {
        this.compositeDisposable.clear();
    }

    public SecInitTask() {
        this.compositeDisposable = new CompositeDisposable();
    }

    public static final /* synthetic */ boolean access$getSInit$cp() {
        return sInit;
    }

    public final CompositeDisposable getCompositeDisposable() {
        return this.compositeDisposable;
    }

    public static final /* synthetic */ void access$setSInit$cp(boolean r0) {
        sInit = r0;
    }

    public final void setCompositeDisposable(CompositeDisposable r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.compositeDisposable = r2;
    }

    /* JADX INFO: renamed from: init, reason: avoid collision after fix types in other method */
    public void init2(Application r7, SecConfig r8) {
        Intrinsics.checkNotNullParameter(r7, "app");
        Intrinsics.checkNotNullParameter(r8, "params");
        final Ref.ObjectRef r0 = new Ref.ObjectRef();
        String r9 = r8.getId();
        r0.element = r9;
        boolean r1 = false;
        if (r9 != null) goto L5;
    L8:
        boolean r10 = true;
    L9:
        String r3 = null;
        if (r10 == false) goto L16;
        IAppInfo r12 = BDLiveSdk.getAppInfo();
        if (r12 == null) goto L14;
        Integer r13 = Integer.valueOf(r12.appId());
    L15:
        r0.element = String.valueOf(r13.intValue());
        goto L16
    L14:
        r13 = null;
    L16:
        MSConfig.Builder r14 = new MSConfig.Builder((String) r0.element, SEC_LICENSE);
        IAppLog r4 = BDLiveSdk.appLog();
        if (r4 == null) goto L19;
        String r5 = r4.getDid();
    L20:
        if (r5 != null) goto L22;
    L25:
        boolean r6 = true;
    L26:
        if (r6 == true) goto L28;
        r14.setBDDeviceID(r5);
    L28:
        IAppLog r15 = BDLiveSdk.appLog();
        if (r15 == null) goto L31;
        r3 = r15.getDid();
    L31:
        if (r3 != null) goto L33;
    L34:
        r1 = true;
    L35:
        if (r1 == true) goto L37;
        r14.setInstallID(r5);
    L37:
        r14.setClientType(1);
        MSManagerUtils.init(r7.getApplicationContext(), r14.build());
        this.compositeDisposable.add(BDLiveSdkSubject.INSTANCE.getIdSubject().observeOn(AndroidSchedulers.mainThread()).subscribe(new SecInitTask$init$disposable$1(r0)));
        return;
    L33:
        if (r3.length() != 0) goto L35;
    L22:
        if (r5.length() == 0) goto L25;
        r6 = false;
        goto L26
    L19:
        r5 = null;
        goto L20
    L5:
        if (r9.length() == 0) goto L8;
        r10 = false;
        goto L9
    }

    @Override // com.bytedance.android.live.saas.middleware.base.ISdkInitTask
    public /* bridge */ /* synthetic */ void init(Application r1, SecConfig r2) {
        init2(r1, r2);
    }
}
