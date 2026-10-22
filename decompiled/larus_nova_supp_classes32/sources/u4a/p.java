package u4a;

import com.lynx.animax.ability.BaseAbility;
import com.lynx.animax.loader.AnimaXLoaderCompletionHandler;
import com.lynx.animax.loader.AnimaXLoaderRequest;
import com.lynx.animax.loader.AnimaXLoaderResponse;
import com.lynx.animax.loader.AnimaXLoaderScheme;
import com.lynx.animax.service.IAnimaXImageService;
import com.lynx.animax.util.AnimaXLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.resourceprovider.LynxResourceRequest;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class p implements k {
    public final WeakReference<BaseAbility> a;
    public final WeakReference<LynxContext> b;
    public final boolean c;

    @Override // u4a.k
    public final AnimaXLoaderScheme getScheme() {
        return AnimaXLoaderScheme.HTTP;
    }

    public p(o4a.b r3, LynxContext r4) {
        this.a = new WeakReference(r3);
        this.b = new WeakReference(r4);
        boolean r5 = y4a.a.e(y4a.a.b("ANIMAX_USE_LEGACY_FETCHER", r3));
        this.c = r5;
        if (r5 == false) goto L5;
    L6:
        StringBuilder r0 = new StringBuilder("Generic fetcher unavailable, mUseLegacyFetcher: ");
        r0.append(r5);
        r0.append(", genericFetcher is null:");
        if (r4.getGenericResourceFetcher() != null) goto L9;
        boolean r6 = true;
    L10:
        r0.append(r6);
        AnimaXLog.b("LynxHttpAnimaXLoader", r0.toString());
        return;
    L9:
        r6 = false;
        goto L10
    L5:
        if (r4.getGenericResourceFetcher() == null) goto L6;
    }

    @Override // u4a.k
    public final void a(m r8, l r9) {
        AnimaXLoaderRequest r10 = (AnimaXLoaderRequest) r8;
        boolean r1 = false;
        Object r3 = null;
        if (r10.a() != null) goto L5;
        boolean r0 = false;
    L18:
        if (r0 == false) goto L21;
        return;
    L21:
        if (this.c == true) goto L30;
        LynxContext r2 = this.b.get();
        if (r2 != null) goto L26;
        AnimaXLog.b("LynxHttpAnimaXLoader", "Generic fetcher unavailable: context is null");
        goto L30
    L26:
        f8a.a r4 = r2.getGenericResourceFetcher();
        if (r4 == null) goto L30;
        r4.a(new LynxResourceRequest(r10.b(), LynxResourceRequest.LynxResourceType.LynxResourceTypeLottie), new n(r9));
        r1 = true;
    L30:
        if (r1 == false) goto L32;
        return;
    L32:
        LynxContext r5 = this.b.get();
        if (r5 == null) goto L35;
        r3 = r5.getLynxExtraData();
    L35:
        com.lynx.tasm.core.n.a().b(new d8a.h(r10.b(), r3), new o(r9));
        return;
    L5:
        String r6 = r10.b();
        BaseAbility r7 = this.a.get();
        if (r7 == null) goto L8;
        r6 = r7.h(r6);
    L8:
        AnimaXLoaderRequest r11 = new AnimaXLoaderRequest(r6, r10.c);
        if (r7 == null) goto L11;
        IAnimaXImageService r12 = (IAnimaXImageService) r7.c.a(IAnimaXImageService.class);
    L12:
        if (r12 != null) goto L14;
    L16:
        ((AnimaXLoaderCompletionHandler) r9).a(AnimaXLoaderResponse.b(new Throwable("Image loader service unavailable")));
    L17:
        r0 = true;
        goto L18
    L14:
        if (r12.loadImage(r11, r9) == false) goto L16;
    L11:
        r12 = null;
        goto L12
    }
}
