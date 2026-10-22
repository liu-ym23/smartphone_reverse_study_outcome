package com.ss.android.lark.chameleon.container.webcontainer;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.fragment.app.Fragment;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.chameleon.api.AbsChameleonPlugin;
import com.ss.android.lark.chameleon.api.ChameleonConfig;
import com.ss.android.lark.chameleon.api.IChameleonApi;
import com.ss.android.lark.chameleon.api.ResConfig;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.chameleon.container.webcontainer.util.ChameleonContainerUtils;
import com.ss.android.lark.chameleon.container.webcontainer.view.ChameleonActivity;
import com.ss.android.lark.chameleon.container.webcontainer.view.ChameleonFragment;
import com.ss.android.lark.chameleon.idependency.DependencyInject;
import com.ss.android.lark.chameleon.idependency.IDependency;
import com.ss.android.lark.chameleon.utils.ChameleonDebugUtils;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J\u0012\u0010\r\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J6\u0010\u000e\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012H\u0002J*\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012H\u0016J\u0010\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J,\u0010\u0019\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012H\u0016J\u0012\u0010\u001a\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/ChameleonImpl;", "Lcom/ss/android/lark/chameleon/api/IChameleonApi;", "()V", "hasInit", "Ljava/util/concurrent/atomic/AtomicBoolean;", "canOpenByTest", BuildConfig.FLAVOR, "url", BuildConfig.FLAVOR, "checkInit", BuildConfig.FLAVOR, "chameleonConfig", "Lcom/ss/android/lark/chameleon/api/ChameleonConfig;", "doInit", "doOpen", "context", "Landroid/content/Context;", "bizPlugins", BuildConfig.FLAVOR, "Lcom/ss/android/lark/chameleon/api/AbsChameleonPlugin;", "getChameleonFragment", "Landroidx/fragment/app/Fragment;", "init", "iDependency", "Lcom/ss/android/lark/chameleon/idependency/IDependency;", "open", "preloadWebview", "Companion", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ChameleonImpl implements IChameleonApi {
    private static final String APP_NAME = "app_name";
    public static final Companion Companion = null;
    private static final String TAG = "CML_TAG_ChameleonImpl";
    private static final String TEST_HOST = "Chameleon.test";
    private static final String TEST_PATH = "/open";
    private static final String URL = "url";
    private final AtomicBoolean hasInit;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/ChameleonImpl$Companion;", BuildConfig.FLAVOR, "()V", "APP_NAME", BuildConfig.FLAVOR, "TAG", "TEST_HOST", "TEST_PATH", "URL", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public ChameleonImpl() {
        this.hasInit = new AtomicBoolean(false);
    }

    private final boolean canOpenByTest(String r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        Uri r5 = UriProtector.parse(r4);
        if (Intrinsics.areEqual(r5.getHost(), TEST_HOST) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(r5.getPath(), TEST_PATH) == true) goto L11;
        return false;
    L11:
        String r6 = UriProtector.getQueryParameter(r5, "url");
        if (r6 != null) goto L14;
    L17:
        boolean r7 = true;
    L18:
        if (r7 == false) goto L20;
        return false;
    L20:
        return true;
    L14:
        if (r6.length() == 0) goto L17;
        r7 = false;
        goto L18
    }

    private final void checkInit(ChameleonConfig r2) {
        if (this.hasInit.get() == false) goto L5;
        return;
    L5:
        doInit(r2);
        this.hasInit.set(true);
    }

    private final void doInit(ChameleonConfig r1) {
        if (r1 == null) goto L5;
        r1.getResInterceptConfig();
        return;
    }

    @Override // com.ss.android.lark.chameleon.api.IChameleonApi
    public void init(IDependency r2) {
        Intrinsics.checkNotNullParameter(r2, "iDependency");
        DependencyInject.INSTANCE.initDependency(r2);
    }

    @Override // com.ss.android.lark.chameleon.api.IChameleonApi
    public void preloadWebview(ChameleonConfig r14) {
        if (r14 != null) goto L4;
        ChameleonConfig r12 = new ChameleonConfig(null, null, null, null, null, null, null, null, null, 511, null);
    L5:
        String r15 = ChameleonDebugUtils.INSTANCE.getOfflineResVersion(r14);
        if (r15.length() <= 0) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == false) goto L14;
        ResConfig r1 = r12.getResConfig();
        if (r1 == null) goto L14;
        r1.setResVersion(r15);
    L14:
        ChameleonWebViewManager.INSTANCE.preload(r12);
        return;
    L8:
        r0 = false;
        goto L9
    L4:
        r12 = r14;
        goto L5
    }

    @Override // com.ss.android.lark.chameleon.api.IChameleonApi
    public Fragment getChameleonFragment(Context r18, ChameleonConfig r19, List<? extends AbsChameleonPlugin> r20) {
        Intrinsics.checkNotNullParameter(r18, "context");
        if (r19 != null) goto L5;
        ChameleonConfig r2 = new ChameleonConfig(null, null, null, null, null, null, null, null, null, 511, null);
    L6:
        String r3 = ChameleonDebugUtils.INSTANCE.getOfflineResVersion(r19);
        if (r3.length() <= 0) goto L9;
        boolean r5 = true;
    L10:
        if (r5 == false) goto L15;
        ResConfig r6 = r2.getResConfig();
        if (r6 == null) goto L15;
        r6.setResVersion(r3);
    L15:
        String r7 = ChameleonOpenTracker.INSTANCE.newSessionTracker(r2);
        if (r20 == null) goto L18;
        ChameleonContainerUtils.INSTANCE.setBizConfig(r7, r2, r20);
    L18:
        checkInit(r19);
        ChameleonFragment.Companion r4 = ChameleonFragment.Companion;
        if (r19 == null) goto L21;
        String r0 = r19.getLoadUrl();
    L22:
        if (r0 != null) goto L25;
        r0 = BuildConfig.FLAVOR;
    L25:
        return ChameleonFragment.Companion.newInstance$default(r4, r18, r0, r7, null, 8, null);
    L21:
        r0 = null;
        goto L22
    L9:
        r5 = false;
        goto L10
    L5:
        r2 = r19;
        goto L6
    }

    @Override // com.ss.android.lark.chameleon.api.IChameleonApi
    public void open(Context r2, ChameleonConfig r3, List<? extends AbsChameleonPlugin> r4) {
        if (r3 == null) goto L4;
        String r0 = r3.getLoadUrl();
    L5:
        if (r0 != null) goto L7;
        r0 = BuildConfig.FLAVOR;
    L7:
        doOpen(r2, r0, r3, r4);
        return;
    L4:
        r0 = null;
        goto L5
    }

    private final void doOpen(Context r18, String r19, ChameleonConfig r20, List<? extends AbsChameleonPlugin> r21) {
        if (r18 != null) goto L5;
        return;
    L5:
        Intent r3 = new Intent(r18, ChameleonActivity.class);
        if ((r18 instanceof Application) == false) goto L8;
        r3.addFlags(268435456);
    L8:
        r3.putExtra("url", r19);
        if (r20 != null) goto L11;
        ChameleonConfig r4 = new ChameleonConfig(null, null, null, null, null, null, null, null, null, 511, null);
    L12:
        String r5 = ChameleonDebugUtils.INSTANCE.getOfflineResVersion(r20);
        if (r5.length() <= 0) goto L15;
        boolean r6 = true;
    L16:
        if (r6 == false) goto L21;
        ResConfig r7 = r4.getResConfig();
        if (r7 == null) goto L21;
        r7.setResVersion(r5);
    L21:
        String r8 = ChameleonOpenTracker.INSTANCE.newSessionTracker(r4);
        if (r21 == null) goto L24;
        ChameleonContainerUtils.INSTANCE.setBizConfig(r8, r4, r21);
    L24:
        r3.putExtra("session_id", r8);
        r18.startActivity(r3);
        checkInit(r20);
        return;
    L15:
        r6 = false;
        goto L16
    L11:
        r4 = r20;
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void doOpen$default(ChameleonImpl r0, Context r1, String r2, ChameleonConfig r3, List r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = null;
    L5:
        r0.doOpen(r1, r2, r3, r4);
    }
}
