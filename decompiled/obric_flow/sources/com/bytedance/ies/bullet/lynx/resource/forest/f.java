package com.bytedance.ies.bullet.lynx.resource.forest;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.forest.chain.fetchers.GeckoXAdapter;
import com.bytedance.forest.model.Scene;
import com.bytedance.forest.model.w;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.lynx.tasm.resourceprovider.media.OptionalBool;
import java.util.List;
import ko.r;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends com.bytedance.ies.bullet.base.utils.b implements com.bytedance.ies.bullet.forest.e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5760b;

    public f(String r5) {
        Intrinsics.checkNotNullParameter("ttnet", "downloadEngine");
        this.f5760b = r5;
    }

    @Override // com.bytedance.ies.bullet.base.utils.b
    public final OptionalBool b(String r5) {
        if (r5 == null) goto L19;
        if (r5.length() == 0) goto L19;
        if (StringsKt.P(r5, "http") == false) goto L19;
        GeckoXAdapter.Companion r10 = GeckoXAdapter.Companion;
        if (r10.isCDNMultiVersionResource(r5) == true) goto L17;
        if (r10.canParsed(r5) == true) goto L17;
        return OptionalBool.f10951b;
    L17:
        return OptionalBool.f10950a;
    L19:
        return OptionalBool.f10951b;
    }

    @Override // com.bytedance.ies.bullet.base.utils.b
    public final String d(r r15) {
        Uri r5 = Uri.parse((String) r15.f18728b);
        String r10 = (String) r15.f18728b;
        String r11 = null;
        if (TextUtils.isEmpty(r10) == false) goto L7;
        r10 = null;
    L7:
        if (r10 == null) goto L53;
        long r12 = System.currentTimeMillis();
        StringBuilder r13 = com.lynx.tasm.utils.e.b("redirectWithPipeline URL:", r10, ",defaultCache:");
        boolean r14 = com.bytedance.ies.bullet.preloadv2.redirect.a.f5885a;
        r13.append(com.bytedance.ies.bullet.preloadv2.redirect.a.f5886b);
        com.bytedance.ies.bullet.base.utils.b.m(r13.toString());
        if (r10.length() != 0) goto L12;
    L46:
        String r16 = r10;
    L47:
        if (r16 == null) goto L53;
        if (equals(r10) == true) goto L51;
        r11 = r16;
    L51:
        if (r11 == null) goto L53;
        return r11;
    L12:
        if (StringsKt.P(r10, "file://") == true) goto L46;
        if (StringsKt.P(r10, "data:") == true) goto L46;
        r16 = com.bytedance.ies.bullet.preloadv2.redirect.a.a(r10);
        if (r16 == null) goto L20;
        com.bytedance.ies.bullet.preloadv2.redirect.a.d("default_bid", r10, r16, true, System.currentTimeMillis() - r12);
        goto L47
    L20:
        if (StringsKt.P(r10, "base64:") == true) goto L32;
        zm.c r17 = com.bytedance.ies.bullet.forest.f.f5397a;
        Scene r18 = Scene.f;
        String r19 = this.f5760b;
        wc.g r20 = new wc.g("");
        Intrinsics.checkNotNullParameter("default_bid", "<set-?>");
        r20.f22838c = "default_bid";
        Unit r21 = Unit.INSTANCE;
        w r22 = com.bytedance.ies.bullet.forest.f.b(r10, null, r18, r19, r20, ForestMediaResourceProvider$redirectWithPipeline$3.f5743a, 5);
        if (r22 == null) goto L32;
        String r23 = r22.f4443t;
        if (r23 != null) goto L26;
    L31:
        String r24 = null;
    L33:
        if (r24 != null) goto L35;
    L39:
        GeckoXAdapter.Companion r25 = GeckoXAdapter.Companion;
        if (r25.isCDNMultiVersionResource(r10) == false) goto L42;
        r24 = r25.addCommonParamsForCDNMultiVersionURL(r10);
    L42:
        r16 = r24;
        if (com.bytedance.ies.bullet.preloadv2.redirect.a.f5886b == false) goto L45;
        com.bytedance.ies.bullet.base.utils.b.m("redirectWithPipeline putRedirectPath URL:" + r10 + ",redirectUrl:" + r16);
        com.bytedance.ies.bullet.preloadv2.redirect.a.c(r10, r16);
    L45:
        com.bytedance.ies.bullet.preloadv2.redirect.a.d("default_bid", r10, r16, false, System.currentTimeMillis() - r12);
        goto L47
    L35:
        if (r24.length() == 0) goto L39;
        if (Intrinsics.areEqual(r24, r10) == false) goto L42;
    L26:
        if (StringsKt.isBlank(r23) == false) goto L29;
        r23 = null;
    L29:
        if (r23 == null) goto L31;
        r24 = "file://".concat(r23);
    L32:
        r24 = r10;
    L53:
        String r110 = (String) r15.f18728b;
        if (r110 != null) goto L56;
    L72:
        return "";
    L56:
        if (r110.length() == 0) goto L72;
        List r111 = CollectionsKt.listOf(new String[]{"http", IIvyAIPackageResourceService.SCHEMA, "file", "content", "res", "data"});
        String r26 = r5.getScheme();
        if (r26 != null) goto L62;
        r26 = "";
    L62:
        if (r111.contains(r26) == false) goto L68;
        String r112 = (String) r15.f18728b;
        if (r112 != null) goto L66;
        return "";
    L66:
        return r112;
    L68:
        if (Intrinsics.areEqual(r5.getScheme(), "bundle") == false) goto L70;
    L71:
        r5.getPath();
        goto L72
    L70:
        if (Intrinsics.areEqual(r5.getScheme(), "relative") == false) goto L72;
        goto L71
    }

    @Override // com.bytedance.ies.bullet.forest.e
    public final String forestDownloadEngine(com.bytedance.ies.bullet.core.e r5) {
        return u8.a.c(r5);
    }

    @Override // com.bytedance.ies.bullet.forest.e
    public final boolean hasGeckoModelInfo(com.bytedance.ies.bullet.core.e r5) {
        return u8.a.n(r5);
    }

    @Override // com.bytedance.ies.bullet.forest.e
    public final String sessionID(com.bytedance.ies.bullet.core.e r5) {
        if (r5 != null) goto L4;
        return null;
    L4:
        return r5.getSessionId();
    }

    @Override // com.bytedance.ies.bullet.forest.e
    public final boolean useForest(com.bytedance.ies.bullet.core.e r5) {
        return u8.a.q(r5);
    }
}
