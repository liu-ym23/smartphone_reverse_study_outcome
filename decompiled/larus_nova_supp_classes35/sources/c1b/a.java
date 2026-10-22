package c1b;

import android.app.Application;
import com.ss.android.lark.chameleon.IChameleonHandlerContext;
import com.ss.android.lark.chameleonv2.lkapi.domain.IDomain$Internal$Property;
import com.ss.android.lark.chameleonv2.lkapi.manifest.IManifest$Ipc$EventType;
import com.ss.android.lark.chameleonv2.lkapi.manifest.IManifest$Ipc$ManifestUpdateDetail;
import com.ss.android.lark.chameleonv2.lkapi.manifest.IManifest$Ipc$ModuleType;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.utils.LarkContext;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import e0c.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jcb.b;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a extends z0b.a implements icb.a {
    public static final /* synthetic */ int c = 0;
    public IChameleonHandlerContext a;
    public String b;

    /* JADX INFO: renamed from: c1b.a$a, reason: collision with other inner class name */
    public static final class C0014a {
        public static IDomain$Internal$Property a() {
            HashMap r0 = new HashMap();
            HashMap r1 = new HashMap();
            Application r2 = LarkContext.getApplication();
            if (r2 == null) goto L19;
            q1b.a r3 = (q1b.a) k.a(r2, q1b.a.class);
            if (r3 == null) goto L19;
            m r4 = r3.r9();
            if (r4 == null) goto L19;
            User r5 = r4.getUser();
            if (r5 == null) goto L19;
            String r6 = r5.userId;
            if (r6 == null) goto L19;
            Map<String, List<String>> r7 = b.c().o0(r6);
            Intrinsics.checkNotNull(r7);
            Iterator<Map.Entry<String, List<String>>> r8 = r7.entrySet().iterator();
        L14:
            if (r8.hasNext() == false) goto L17;
            Map.Entry<String, List<String>> r9 = r8.next();
            r1.put(r9.getKey(), new ArrayList(r9.getValue()));
            goto L14
        L17:
            return new IDomain$Internal$Property(r0, r1);
        L19:
            return new IDomain$Internal$Property(r0, r1);
        }
    }

    static {
    }

    public a() {
        this.b = BuildConfig.FLAVOR;
    }

    @Override // icb.a
    public final void a(Map<String, ? extends List<String>> r7) {
        if (r7 == null) goto L7;
        IChameleonHandlerContext r8 = this.a;
        if (r8 == null) goto L8;
        r8.sendEvent(IManifest$Ipc$EventType.MANIFEST_UPDATE.getValue(), new IManifest$Ipc$ManifestUpdateDetail(C0014a.a(), IManifest$Ipc$ModuleType.InternalDomain, true, this.b));
        return;
    L8:
        return;
    }

    @Override // z0b.a
    public final void d(IChameleonHandlerContext r2) {
        this.a = r2;
        Application r3 = LarkContext.getApplication();
        if (r3 == null) goto L11;
        q1b.a r4 = (q1b.a) k.a(r3, q1b.a.class);
        if (r4 == null) goto L11;
        m r5 = r4.r9();
        if (r5 == null) goto L11;
        User r6 = r5.getUser();
        if (r6 == null) goto L11;
        String r7 = r6.userId;
    L12:
        if (r7 == null) goto L15;
        this.b = r7;
        b.c().N0(r7, this);
        return;
    L15:
        return;
    L11:
        r7 = null;
        goto L12
    }

    @Override // z0b.a
    public final void e(IChameleonHandlerContext r1) {
        b.c().M0(this);
        this.a = null;
    }
}
