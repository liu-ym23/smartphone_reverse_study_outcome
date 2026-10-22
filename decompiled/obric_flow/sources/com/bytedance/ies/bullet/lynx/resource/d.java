package com.bytedance.ies.bullet.lynx.resource;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.forest.chain.fetchers.GeckoXAdapter;
import com.bytedance.forest.model.ResourceFrom;
import com.bytedance.forest.model.Scene;
import com.bytedance.forest.model.w;
import com.bytedance.ies.bullet.service.base.ResourceType;
import com.bytedance.ies.bullet.service.base.a0;
import com.bytedance.ies.bullet.service.base.resourceloader.config.LoaderType;
import com.facebook.common.references.CloseableReference;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.lynx.tasm.resourceprovider.media.OptionalBool;
import com.lynx.tasm.ui.image.x;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import ko.r;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends com.bytedance.ies.bullet.base.utils.b implements com.bytedance.ies.bullet.forest.e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakReference f5725b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f5726c;

    public d(com.bytedance.ies.bullet.ui.common.loader.c r5) {
        Intrinsics.checkNotNullParameter(r5, "token");
        this.f5725b = new WeakReference(r5);
        this.f5726c = u8.a.t(this, r5);
    }

    @Override // com.bytedance.ies.bullet.base.utils.b
    public final OptionalBool b(String r5) {
        if (r5 == null) goto L21;
        if (r5.length() == 0) goto L21;
        if (StringsKt.P(r5, "http://") == false) goto L9;
    L11:
        GeckoXAdapter.Companion r10 = GeckoXAdapter.Companion;
        if (r10.isCDNMultiVersionResource(r5) == true) goto L19;
        if (r10.canParsed(r5) == true) goto L19;
        return OptionalBool.f10951b;
    L19:
        return OptionalBool.f10950a;
    L9:
        if (StringsKt.P(r5, "https://") == true) goto L11;
    L21:
        return OptionalBool.f10951b;
    }

    @Override // com.bytedance.ies.bullet.base.utils.b
    public final String d(r r15) {
        Uri r5 = Uri.parse((String) r15.f18728b);
        String r10 = null;
        if (this.f5726c == true) goto L15;
        WeakReference r11 = this.f5725b;
        if (r11 == null) goto L7;
        rc.f r12 = (rc.f) r11.get();
    L8:
        String r13 = mh.e.d(r5, r12);
        if (r13 != null) goto L11;
    L12:
        r13 = null;
    L13:
        if (r13 == null) goto L15;
        return r13;
    L11:
        if (r13.length() != 0) goto L13;
    L7:
        r12 = null;
    L15:
        String r14 = (String) r15.f18728b;
        if (TextUtils.isEmpty(r14) == false) goto L20;
        r14 = null;
    L20:
        if (r14 == null) goto L142;
        long r16 = System.currentTimeMillis();
        StringBuilder r17 = com.lynx.tasm.utils.e.b("redirectWithPipeline URL:", r14, ",defaultCache:");
        boolean r18 = com.bytedance.ies.bullet.preloadv2.redirect.a.f5885a;
        r17.append(com.bytedance.ies.bullet.preloadv2.redirect.a.f5886b);
        com.bytedance.ies.bullet.base.utils.b.m(r17.toString());
        if (r14.length() != 0) goto L25;
    L135:
        String r19 = r14;
    L136:
        if (r19 == null) goto L142;
        if (equals(r14) == true) goto L140;
        r10 = r19;
    L140:
        if (r10 == null) goto L142;
        return r10;
    L25:
        if (StringsKt.P(r14, "file://") == true) goto L135;
        if (StringsKt.P(r14, "data:") == true) goto L135;
        WeakReference r20 = this.f5725b;
        if (r20 == null) goto L32;
        rc.f r21 = (rc.f) r20.get();
    L33:
        String r22 = u8.a.p(this, r21);
        if (this.f5726c == false) goto L40;
        zm.c r23 = com.bytedance.ies.bullet.forest.f.f5397a;
        Intrinsics.checkNotNullParameter(r14, "url");
        Intrinsics.checkNotNullParameter(r14, "url");
        if (GeckoXAdapter.Companion.canParsed(r14) == false) goto L40;
        int r24 = StringsKt.r("?", 0, 6, r14);
        if (r24 == (-1)) goto L40;
        String r25 = r14.substring(0, r24);
    L41:
        r19 = com.bytedance.ies.bullet.preloadv2.redirect.a.a(r25);
        if (r19 == null) goto L51;
        WeakReference r26 = this.f5725b;
        if (r26 == null) goto L49;
        rc.f r27 = (rc.f) r26.get();
        if (r27 == null) goto L49;
        String r28 = r27.getBid();
        if (r28 == null) goto L49;
    L50:
        com.bytedance.ies.bullet.preloadv2.redirect.a.d(r28, r14, r19, true, System.currentTimeMillis() - r16);
    L49:
        r28 = "default_bid";
        goto L50
    L51:
        wc.g r29 = new wc.g("");
        WeakReference r30 = this.f5725b;
        if (r30 == null) goto L56;
        rc.f r31 = (rc.f) r30.get();
        if (r31 == null) goto L56;
        Map r32 = r31.getAllDependency();
    L57:
        r29.f22846o = com.bytedance.ies.bullet.base.utils.b.e(r32);
        WeakReference r33 = this.f5725b;
        if (r33 == null) goto L62;
        rc.f r34 = (rc.f) r33.get();
        if (r34 == null) goto L62;
        wc.a r35 = (wc.a) r34.b(wc.a.class);
    L63:
        wc.a r36 = cl.a.i(r35);
        if (r36 != null) goto L66;
        r36 = new wc.a(true);
    L66:
        WeakReference r110 = this.f5725b;
        if (r110 == null) goto L74;
        rc.f r111 = (rc.f) r110.get();
        if (r111 == null) goto L74;
        wc.d r112 = (wc.d) r111.b(wc.d.class);
        if (r112 == null) goto L74;
        List r113 = r112.f22825a;
        if (r113 == null) goto L74;
    L75:
        Intrinsics.checkNotNullParameter(r113, "<set-?>");
        r29.f22847p = r113;
        List r114 = CollectionsKt.mutableListOf(new LoaderType[]{LoaderType.f5993a, LoaderType.f5994b});
        Intrinsics.checkNotNullParameter(r114, "<set-?>");
        r36.f22822b = r114;
        Intrinsics.checkNotNullParameter(r36, "<set-?>");
        r29.f22837b = r36;
        WeakReference r37 = this.f5725b;
        if (r37 == null) goto L81;
        rc.f r38 = (rc.f) r37.get();
        if (r38 == null) goto L81;
        String r39 = r38.getBid();
        if (r39 == null) goto L81;
    L82:
        Intrinsics.checkNotNullParameter(r39, "<set-?>");
        r29.f22838c = r39;
        Intrinsics.checkNotNullParameter("sub_resource", "<set-?>");
        r29.f22840i = "sub_resource";
        if (this.f5726c == true) goto L85;
    L87:
        ConcurrentHashMap r40 = com.bytedance.ies.bullet.kit.resourceloader.g.f5451a;
        WeakReference r41 = this.f5725b;
        if (r41 == null) goto L92;
        rc.f r42 = (rc.f) r41.get();
        if (r42 == null) goto L92;
        String r43 = r42.getBid();
    L93:
        a0 r44 = com.bytedance.ies.bullet.kit.resourceloader.g.a(r43).c(r14, r29);
        if (r44 == null) goto L114;
        String r45 = r44.f5933b;
        if (r45 != null) goto L98;
    L100:
        r44 = null;
    L101:
        if (r44 == null) goto L114;
        String r46 = r44.f5933b;
        Intrinsics.checkNotNull(r46);
        ResourceType r47 = r44.f5934c;
        Intrinsics.checkNotNullParameter(r46, "rawFilePath");
        if (r47 != ResourceType.f5929b) goto L106;
        String r48 = new Uri.Builder().scheme("asset").authority("").path(r46).build().toString();
    L112:
        if (r48 == null) goto L114;
    L115:
        if (r48 != null) goto L117;
    L121:
        GeckoXAdapter.Companion r49 = GeckoXAdapter.Companion;
        if (r49.isCDNMultiVersionResource(r14) == false) goto L124;
        r48 = r49.addCommonParamsForCDNMultiVersionURL(r14);
    L124:
        r19 = r48;
        if (com.bytedance.ies.bullet.preloadv2.redirect.a.f5886b == false) goto L127;
        StringBuilder r50 = com.lynx.tasm.base.a.e("redirectWithPipeline putRedirectPath URL:", r14, ",redirectUrl:", r19, ", useForest=");
        r50.append(this.f5726c);
        com.bytedance.ies.bullet.base.utils.b.m(r50.toString());
        com.bytedance.ies.bullet.preloadv2.redirect.a.c(r14, r19);
    L127:
        WeakReference r51 = this.f5725b;
        if (r51 == null) goto L133;
        rc.f r52 = (rc.f) r51.get();
        if (r52 == null) goto L133;
        String r53 = r52.getBid();
        if (r53 == null) goto L133;
    L134:
        com.bytedance.ies.bullet.preloadv2.redirect.a.d(r53, r14, r19, false, System.currentTimeMillis() - r16);
    L133:
        r53 = "default_bid";
        goto L134
    L117:
        if (r48.length() == 0) goto L121;
        if (Intrinsics.areEqual(r48, r14) == false) goto L124;
    L106:
        if (r47 == ResourceType.f5928a) goto L108;
        r48 = null;
        goto L112
    L108:
        if (StringsKt.g(r46, "@") == true) goto L110;
        r48 = Uri.fromFile(new File(r46)).toString();
        goto L112
    L110:
        r48 = td.d.b("file:///", r46);
        goto L112
    L98:
        if ((!StringsKt.isBlank(r45)) != true) goto L100;
    L114:
        r48 = r14;
    L92:
        r43 = null;
        goto L93
    L85:
        if (StringsKt.P(r14, "base64:") == true) goto L87;
        r48 = u(r14, r22, r29);
    L81:
        r39 = "";
    L74:
        r113 = CollectionsKt.emptyList();
    L62:
        r35 = null;
    L56:
        r32 = null;
    L40:
        r25 = r14;
        goto L41
    L32:
        r21 = null;
    L142:
        String r115 = (String) r15.f18728b;
        if (r115 != null) goto L145;
    L161:
        return "";
    L145:
        if (r115.length() == 0) goto L161;
        List r116 = CollectionsKt.listOf(new String[]{"http", IIvyAIPackageResourceService.SCHEMA, "file", "content", "res", "data"});
        String r54 = r5.getScheme();
        if (r54 != null) goto L151;
        r54 = "";
    L151:
        if (r116.contains(r54) == false) goto L157;
        String r117 = (String) r15.f18728b;
        if (r117 != null) goto L155;
        return "";
    L155:
        return r117;
    L157:
        if (Intrinsics.areEqual(r5.getScheme(), "bundle") == false) goto L159;
    L160:
        r5.getPath();
        goto L161
    L159:
        if (Intrinsics.areEqual(r5.getScheme(), "relative") == false) goto L161;
        goto L160
    }

    @Override // com.bytedance.ies.bullet.forest.e
    public final String forestDownloadEngine(com.bytedance.ies.bullet.core.e r5) {
        return u8.a.c(r5);
    }

    @Override // com.bytedance.ies.bullet.forest.e
    public final boolean hasGeckoModelInfo(com.bytedance.ies.bullet.core.e r5) {
        return u8.a.n(r5);
    }

    @Override // com.bytedance.ies.bullet.base.utils.b
    public final void i(r r10, go.a r11) {
        if (this.f5726c == false) goto L31;
        String r12 = (String) r10.f18728b;
        if (r12 != null) goto L7;
    L9:
        WeakReference r5 = this.f5725b;
        if (r5 == null) goto L12;
        rc.f r13 = (rc.f) r5.get();
    L13:
        String r14 = u8.a.p(this, r13);
        if (r12 == null) goto L22;
        zm.c r15 = com.bytedance.ies.bullet.forest.f.f5397a;
        Intrinsics.checkNotNullParameter(r12, "imgPath");
        zm.c r16 = com.bytedance.ies.bullet.forest.f.f5398b;
        w r17 = (w) r16.e(r12, r14);
        if (r17 == null) goto L19;
        CloseableReference r18 = r17.h();
        if (r18 == null) goto L19;
    L23:
        int r19 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        StringBuilder r20 = new StringBuilder("Forest preload image ");
        if (r18 != null) goto L26;
        String r21 = MessageIndication.STATUS_FAILED;
    L27:
        r20.append(r21);
        r20.append(" for ");
        com.bytedance.ies.bullet.base.utils.logger.a.g("DefaultMediaResourceProvider", f4.b.b(r20, r12, " on ", r14), null, 12);
        if (r18 == null) goto L32;
        ((x) r11).f(com.google.common.reflect.w.a(r18));
        return;
    L32:
        return;
    L26:
        r21 = "success";
    L19:
        u(r12, r14, null);
        Intrinsics.checkNotNullParameter(r12, "imgPath");
        w r22 = (w) r16.e(r12, r14);
        if (r22 == null) goto L22;
        r18 = r22.h();
    L22:
        r18 = null;
        goto L23
    L12:
        r13 = null;
        goto L13
    L7:
        if (StringsKt.P(r12, "base64:") != true) goto L9;
        return;
    }

    @Override // com.bytedance.ies.bullet.forest.e
    public final String sessionID(com.bytedance.ies.bullet.core.e r5) {
        if (r5 != null) goto L4;
        return null;
    L4:
        return r5.getSessionId();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final String u(String r12, String r13, wc.g r14) {
        zm.c r5 = com.bytedance.ies.bullet.forest.f.f5397a;
        Intrinsics.checkNotNullParameter(r12, "imgPath");
        zm.c r10 = com.bytedance.ies.bullet.forest.f.f5398b;
        w r11 = (w) r10.e(r12, r13);
        String r15 = null;
        ResourceFrom r16 = null;
        r15 = null;
        r15 = null;
        if (r11 != null) goto L9;
        WeakReference r17 = this.f5725b;
        if (r17 == null) goto L7;
        rc.f r18 = (rc.f) r17.get();
    L8:
        r11 = com.bytedance.ies.bullet.forest.f.b(r12, u8.a.e(this, r18), Scene.f, r13, r14, DefaultMediaResourceProvider$fetchLynxImageFromForest$response$1.f5702a, 1);
        goto L9
    L7:
        r18 = null;
    L9:
        if (r11 == null) goto L23;
        String r19 = r11.f4443t;
        if (r19 == null) goto L23;
        if (StringsKt.isBlank(r19) == false) goto L16;
        r19 = null;
    L16:
        if (r19 == null) goto L23;
        boolean r110 = com.bytedance.ies.bullet.preloadv2.redirect.a.f5885a;
        ResourceFrom r111 = r11.f4444u;
        if (r111 == ResourceFrom.d) goto L20;
        r16 = r111;
    L20:
        if (r16 != null) goto L22;
        r16 = r11.f4445v;
    L22:
        r15 = com.bytedance.ies.bullet.preloadv2.redirect.a.b(r19, r16);
    L23:
        if (r11 == null) goto L28;
        if (r15 == null) goto L27;
        r12 = r15;
    L27:
        Intrinsics.checkNotNullParameter(r12, "imgPath");
        Intrinsics.checkNotNullParameter(r11, "response");
        r10.l(r13, r12, r11);
    L28:
        return r15;
    }

    @Override // com.bytedance.ies.bullet.forest.e
    public final boolean useForest(com.bytedance.ies.bullet.core.e r5) {
        return u8.a.q(r5);
    }
}
