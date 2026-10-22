package e1b;

import android.app.Application;
import com.bytedance.ee.util.io.NonProguard;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.appsetting.api.service.d;
import com.ss.android.lark.chameleon.IChameleonHandlerContext;
import com.ss.android.lark.chameleonv2.lkapi.featuregating.IFeatureGating$Internal$AllStatusesAndValues;
import com.ss.android.lark.chameleonv2.lkapi.featuregating.IFeatureGating$Internal$Property;
import com.ss.android.lark.chameleonv2.lkapi.manifest.IManifest$Ipc$EventType;
import com.ss.android.lark.chameleonv2.lkapi.manifest.IManifest$Ipc$ManifestUpdateDetail;
import com.ss.android.lark.chameleonv2.lkapi.manifest.IManifest$Ipc$ModuleType;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.utils.LarkContext;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import e0c.k;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a extends z0b.a {
    public static final /* synthetic */ int c = 0;
    public final b a;
    public IChameleonHandlerContext b;

    /* JADX INFO: renamed from: e1b.a$a, reason: collision with other inner class name */
    public static final class C0212a {
        public static IFeatureGating$Internal$Property a() {
            IFeatureGating$Internal$AllStatusesAndValues r0 = new IFeatureGating$Internal$AllStatusesAndValues(new HashMap(), new HashMap());
            IFeatureGating$Internal$AllStatusesAndValues r1 = new IFeatureGating$Internal$AllStatusesAndValues(new HashMap(), new HashMap());
            Application r2 = LarkContext.getApplication();
            if (r2 == null) goto L11;
            q1b.a r3 = (q1b.a) k.a(r2, q1b.a.class);
            if (r3 == null) goto L11;
            m r4 = r3.r9();
            if (r4 == null) goto L11;
            User r5 = r4.getUser();
            if (r5 == null) goto L11;
            String r6 = r5.userId;
        L13:
            if (r6 != null) goto L15;
        L18:
            boolean r7 = true;
        L19:
            if (r7 == true) goto L25;
            Set<String> r8 = FeatureGatingModule.getFeatureGatingService().allFg(r6);
            Intrinsics.checkNotNull(r8);
            Iterator<T> r9 = r8.iterator();
        L22:
            if (r9.hasNext() == false) goto L25;
            String r10 = (String) r9.next();
            r0.getStatuses().put(r10.toString(), Boolean.TRUE);
        L25:
            return new IFeatureGating$Internal$Property(r0, 0, r1, 0);
        L15:
            if (r6.length() == 0) goto L18;
            r7 = false;
        L11:
            r6 = null;
            goto L13
        }
    }

    public final class b implements d.b {
        public final /* synthetic */ a a;

        public final void a() {
            IChameleonHandlerContext r0 = this.a.b;
            if (r0 == null) goto L18;
            String r1 = IManifest$Ipc$EventType.MANIFEST_UPDATE.getValue();
            int r3 = a.c;
            NonProguard r4 = C0212a.a();
            IManifest$Ipc$ModuleType r5 = IManifest$Ipc$ModuleType.InternalFeatureGating;
            Application r6 = LarkContext.getApplication();
            if (r6 == null) goto L15;
            q1b.a r7 = (q1b.a) k.a(r6, q1b.a.class);
            if (r7 == null) goto L15;
            m r8 = r7.r9();
            if (r8 == null) goto L15;
            User r9 = r8.getUser();
            if (r9 == null) goto L15;
            String r10 = r9.userId;
            if (r10 == null) goto L15;
        L16:
            r0.sendEvent(r1, new IManifest$Ipc$ManifestUpdateDetail(r4, r5, true, r10));
            return;
        L15:
            r10 = BuildConfig.FLAVOR;
            goto L16
        }

        public b(a r1) {
            this.a = r1;
        }

        public final void onError(ErrorResult r2) {
            Intrinsics.checkNotNullParameter(r2, "err");
            j.b("LK_API_TAG_FeatureGating", "SettingFetcherImpl.SettingsUpdateCallback error");
        }
    }

    static {
    }

    public a() {
        this.a = new b(this);
    }

    @Override // z0b.a
    public final void d(IChameleonHandlerContext r3) {
        this.b = r3;
        d r4 = d.a.a;
        b r0 = this.a;
        if (r0 != null) goto L5;
        r4.getClass();
        return;
    L5:
        if (r4.b.contains(r0) == true) goto L9;
        r4.b.add(r0);
        return;
    }

    @Override // z0b.a
    public final void e(IChameleonHandlerContext r2) {
        d r3 = d.a.a;
        b r0 = this.a;
        r3.b.remove(r0);
        this.b = null;
    }
}
