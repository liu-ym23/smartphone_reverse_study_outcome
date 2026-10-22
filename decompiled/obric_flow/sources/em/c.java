package em;

import com.lynx.animax.ability.BaseAbility;
import com.lynx.animax.base.bridge.JavaOnlyMap;
import com.lynx.animax.loader.AnimaXLoaderCompletionHandler;
import com.lynx.animax.loader.AnimaXLoaderRequest;
import com.lynx.animax.loader.AnimaXLoaderScheme;
import com.lynx.animax.loader.FrescoUtil;
import com.lynx.animax.util.AnimaXLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.resourceprovider.LynxResourceRequest$LynxResourceType;
import fo.e;
import java.lang.ref.WeakReference;
import ko.r;
import mn.i;
import w8.f;
import wn.h;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f16835a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakReference f16836b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f16837c;

    public c(zl.a r5, LynxContext r10) {
        this.f16835a = new WeakReference(r5);
        this.f16836b = new WeakReference(r10);
        boolean r11 = jm.b.b(jm.b.a("ANIMAX_USE_LEGACY_FETCHER", r5));
        this.f16837c = r11;
        if (r11 == false) goto L5;
    L8:
        StringBuilder r12 = new StringBuilder("Generic fetcher unavailable, mUseLegacyFetcher: ");
        r12.append(r11);
        r12.append(", genericFetcher is null:");
        if (r10.D != null) goto L11;
        boolean r13 = true;
    L12:
        r12.append(r13);
        String r14 = r12.toString();
        AnimaXLog.a(AnimaXLog.LogLevel.f9713a, "LynxHttpAnimaXLoader", r14);
        return;
    L11:
        r13 = false;
        goto L12
    L5:
        if (r10.D == null) goto L8;
    }

    @Override // em.b
    public final void a(AnimaXLoaderRequest r5, AnimaXLoaderCompletionHandler r10) {
        if (b(r5, r10) == false) goto L5;
        return;
    L5:
        WeakReference r11 = this.f16836b;
        if (this.f16837c == true) goto L13;
        LynxContext r12 = (LynxContext) r11.get();
        if (r12 != null) goto L11;
        AnimaXLog.a(AnimaXLog.LogLevel.f9713a, "LynxHttpAnimaXLoader", "Generic fetcher unavailable: context is null");
        goto L13
    L11:
        h r13 = r12.D;
        if (r13 == null) goto L13;
        r13.i(new r(8, r5.a(), LynxResourceRequest$LynxResourceType.f10944c), new f(r10));
        return;
    L13:
        LynxContext r14 = (LynxContext) r11.get();
        e r15 = new e(r5.a());
        we.a r16 = new we.a(r10);
        i.d().i(r15, r16);
    }

    public final boolean b(AnimaXLoaderRequest r5, AnimaXLoaderCompletionHandler r10) {
        JavaOnlyMap r11 = r5.f9627c;
        if (r11 == null) goto L9;
        Object r12 = r11.get("image_width");
        Object r13 = r11.get("image_height");
        if ((r12 instanceof Integer) == false) goto L9;
        if ((r13 instanceof Integer) == false) goto L9;
        com.bytedance.frameworks.baselib.network.http.cronet.b r14 = new com.bytedance.frameworks.baselib.network.http.cronet.b(10);
    L10:
        if (r14 != null) goto L13;
        return false;
    L13:
        String r15 = r5.a();
        BaseAbility r16 = (BaseAbility) this.f16835a.get();
        if (r16 == null) goto L16;
        r15 = r16.m(r15);
    L16:
        FrescoUtil.tryHandleLoaderRequestWithFresco(new AnimaXLoaderRequest(r15, r11), r10);
        return true;
    L9:
        r14 = null;
        goto L10
    }

    @Override // em.b
    public final AnimaXLoaderScheme a() {
        return AnimaXLoaderScheme.f9634c;
    }
}
