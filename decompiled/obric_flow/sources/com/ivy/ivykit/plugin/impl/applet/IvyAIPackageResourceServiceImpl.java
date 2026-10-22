package com.ivy.ivykit.plugin.impl.applet;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import androidx.annotation.Keep;
import com.bytedance.android.monitorV2.k;
import com.bytedance.forest.Forest;
import com.bytedance.forest.chain.fetchers.GeckoXAdapter;
import com.bytedance.forest.model.ResourceFrom;
import com.bytedance.forest.model.Scene;
import com.bytedance.forest.model.w;
import com.bytedance.ies.bullet.forest.f;
import com.bytedance.ies.bullet.forest.m;
import com.bytedance.ies.bullet.service.base.ResourceType;
import com.bytedance.ies.bullet.service.base.a0;
import com.bytedance.ies.bullet.service.base.resourceloader.config.LoaderType;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.ivy.ivykit.api.plugin.h;
import com.ss.android.ugc.aweme.framework.services.annotation.ServiceImpl;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import wc.g;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@ServiceImpl
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\n\u001a\u00020\u0006*\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\r\u001a\u00020\f*\u00020\tH\u0002¢\u0006\u0004\b\r\u0010\u000eJQ\u0010\u0018\u001a\u00020\u00132\b\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00112\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00130\u00112\u0006\u0010\n\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019JQ\u0010\u001a\u001a\u00020\u00132\b\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00112\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00130\u00112\u0006\u0010\n\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001a\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u001d\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ9\u0010'\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u00062\b\u0010\"\u001a\u0004\u0018\u00010\u00062\u0006\u0010$\u001a\u00020#2\u0006\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b'\u0010(J\u0017\u0010+\u001a\u00020\u00132\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b+\u0010,J-\u0010-\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010!\u001a\u00020\u0006H\u0016¢\u0006\u0004\b-\u0010.J\u0011\u0010/\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b/\u00100R\u0018\u0010!\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u00101¨\u00062"}, d2 = {"Lcom/ivy/ivykit/plugin/impl/applet/IvyAIPackageResourceServiceImpl;", "Lcom/ivy/ivykit/api/plugin/IIvyAIPackageResourceService;", "<init>", "()V", "Lcom/bytedance/ies/bullet/forest/m;", "response", "", "readStringFromResponse", "(Lcom/bytedance/ies/bullet/forest/m;)Ljava/lang/String;", "Ljava/io/InputStream;", "transformToString", "(Ljava/io/InputStream;)Ljava/lang/String;", "", "provideByteArray", "(Ljava/io/InputStream;)[B", "sessionId", "url", "Lkotlin/Function1;", "Lcom/ivy/ivykit/api/plugin/b;", "", "resolve", "", "reject", "", "loadResourceAsync", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Z)V", "loadAIPackageResourceAsync", "closeSession", "(Ljava/lang/String;)V", "openSession", "(Ljava/lang/String;)Ljava/lang/String;", "Landroid/app/Application;", "application", "bid", "saveDir", "Lcom/ivy/ivykit/api/plugin/h;", "pluginConfig", "Lcom/ivy/ivykit/api/plugin/d;", "containerConfig", "initContainer", "(Landroid/app/Application;Ljava/lang/String;Ljava/lang/String;Lcom/ivy/ivykit/api/plugin/h;Lcom/ivy/ivykit/api/plugin/d;)V", "Landroid/content/Context;", "context", "ensureInitLynx", "(Landroid/content/Context;)V", "getImageUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "getBid", "()Ljava/lang/String;", "Ljava/lang/String;", "ivy_plugin_impl_bullet_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class IvyAIPackageResourceServiceImpl implements IIvyAIPackageResourceService {
    private String bid;

    public IvyAIPackageResourceServiceImpl() {
    }

    public static final /* synthetic */ byte[] access$provideByteArray(IvyAIPackageResourceServiceImpl r5, InputStream r10) {
        return r5.provideByteArray(r10);
    }

    public static final /* synthetic */ String access$readStringFromResponse(IvyAIPackageResourceServiceImpl r5, m r10) {
        return r5.readStringFromResponse(r10);
    }

    public static final /* synthetic */ String access$transformToString(IvyAIPackageResourceServiceImpl r5, InputStream r10) {
        return r5.transformToString(r10);
    }

    private final byte[] provideByteArray(InputStream r5) {
        ByteArrayOutputStream r10 = new ByteArrayOutputStream();
        ByteStreamsKt.copyTo$default(r5, r10, 0, 2, null);
        return r10.toByteArray();
    }

    private final String readStringFromResponse(m r5) {
        String r10 = r5.f5933b;
        if (r10 == null) goto L12;
        if (r10.length() == 0) goto L12;
        File r11 = new File(r5.f5933b);
        if (r11.exists() == false) goto L12;
        return FilesKt.a(r11);
    L12:
        if (r5.c() == null) goto L15;
        InputStream r12 = r5.c();
        Intrinsics.checkNotNull(r12);
        return transformToString(r12);
    L15:
        return "";
    }

    private final String transformToString(InputStream r5) {
        StringBuilder r10 = new StringBuilder();
        BufferedReader r11 = new BufferedReader(new InputStreamReader(r5));
        String r12 = r11.readLine();     // Catch: Throwable -> L6
    L4:
        if (r12 == null) goto L8;
        r10.append(r12);     // Catch: Throwable -> L6
        r10.append("\n");     // Catch: Throwable -> L6
        r12 = r11.readLine();     // Catch: Throwable -> L6
        goto L4
    L8:
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L6
        CloseableKt.closeFinally(r11, null);
        return r10.toString();
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        CloseableKt.closeFinally(r11, th);
        throw th;
    }

    @Override // com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService
    public void closeSession(String r5) {
        Intrinsics.checkNotNullParameter(r5, "sessionId");
        f.l(r5);
    }

    @Override // com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService
    public void ensureInitLynx(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        com.bytedance.android.anniex.assemble.a.f3108a.a(r5);
    }

    @Override // com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService
    public String getBid() {
        return this.bid;
    }

    /* JADX WARN: Multi-variable type inference failed */
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
    @Override // com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService
    public String getImageUrl(String r16, String r17, String r18) {
        Intrinsics.checkNotNullParameter(r18, "bid");
        long r10 = System.currentTimeMillis();
        StringBuilder r5 = com.lynx.tasm.utils.e.b("redirectWithPipeline URL:", r17, ",defaultCache:");
        boolean r11 = com.bytedance.ies.bullet.preloadv2.redirect.a.f5885a;
        r5.append(com.bytedance.ies.bullet.preloadv2.redirect.a.f5886b);
        com.bytedance.ies.bullet.base.utils.b.m(r5.toString());
        if (r17 != null) goto L5;
    L82:
        return r17;
    L5:
        if (r17.length() == 0) goto L82;
        if (StringsKt.P(r17, "file://") == true) goto L82;
        if (StringsKt.P(r17, "data:") == true) goto L82;
        String r12 = Uri.parse(r17).getHost();
        if (r12 != null) goto L15;
    L18:
        Object[] r13 = true;
    L19:
        if (r13 == false) goto L25;
        zm.c r14 = f.f5397a;
        Intrinsics.checkNotNullParameter(r17, "url");
        Intrinsics.checkNotNullParameter(r17, "url");
        if (GeckoXAdapter.Companion.canParsed(r17) == false) goto L25;
        int r15 = StringsKt.r("?", 0, 6, r17);
        if (r15 == (-1)) goto L25;
        String r19 = r17.substring(0, r15);
    L26:
        String r20 = com.bytedance.ies.bullet.preloadv2.redirect.a.a(r19);
        if (r20 == null) goto L30;
        com.bytedance.ies.bullet.preloadv2.redirect.a.d(r18, r17, r20, true, System.currentTimeMillis() - r10);
        return r20;
    L30:
        String r110 = null;
        ResourceFrom r111 = null;
        r110 = null;
        r110 = null;
        r110 = null;
        if (r13 == true) goto L33;
    L56:
        g r21 = new g("");
        wc.a r22 = new wc.a(true);
        r22.f22823c = CollectionsKt.mutableListOf(new Class[]{a.class});
        List r23 = CollectionsKt.mutableListOf(new LoaderType[]{LoaderType.f5993a, LoaderType.f5994b});
        Intrinsics.checkNotNullParameter(r23, "<set-?>");
        r22.f22822b = r23;
        Intrinsics.checkNotNullParameter(r22, "<set-?>");
        r21.f22837b = r22;
        Intrinsics.checkNotNullParameter(r18, "<set-?>");
        r21.f22838c = r18;
        Intrinsics.checkNotNullParameter("sub_resource", "<set-?>");
        r21.f22840i = "sub_resource";
        a0 r24 = com.bytedance.ies.bullet.kit.resourceloader.g.a(r18).c(r17, r21);
        if (r24 == null) goto L76;
        String r25 = r24.f5933b;
        if (r25 != null) goto L61;
    L63:
        r24 = null;
    L64:
        if (r24 == null) goto L76;
        String r26 = r24.f5933b;
        Intrinsics.checkNotNull(r26);
        ResourceType r27 = r24.f5934c;
        Intrinsics.checkNotNullParameter(r26, "rawFilePath");
        if (r27 != ResourceType.f5929b) goto L69;
        r110 = new Uri.Builder().scheme("asset").authority("").path(r26).build().toString();
    L74:
        if (r110 == null) goto L76;
    L78:
        if (com.bytedance.ies.bullet.preloadv2.redirect.a.f5886b == false) goto L80;
        com.bytedance.ies.bullet.base.utils.b.m("redirectWithPipeline putRedirectPath URL:" + r17 + ",redirectUrl:" + r110);
        com.bytedance.ies.bullet.preloadv2.redirect.a.c(r17, r110);
    L80:
        com.bytedance.ies.bullet.preloadv2.redirect.a.d(r18, r17, r110, false, System.currentTimeMillis() - r10);
        return r110;
    L69:
        if (r27 != ResourceType.f5928a) goto L74;
        if (StringsKt.g(r26, "@") == true) goto L73;
        r110 = Uri.fromFile(new File(r26)).toString();
        goto L74
    L73:
        r110 = td.d.b("file:///", r26);
        goto L74
    L61:
        if ((!StringsKt.isBlank(r25)) != true) goto L63;
    L76:
        r110 = r17;
        goto L78
    L33:
        if (StringsKt.P(r17, "base64:") == true) goto L56;
        zm.c r28 = f.f5397a;
        Intrinsics.checkNotNullParameter(r17, "imgPath");
        zm.c r112 = f.f5398b;
        w r29 = (w) r112.e(r17, r16);
        if (r29 != null) goto L37;
        Scene r30 = Scene.f;
        g r31 = new g("");
        Intrinsics.checkNotNullParameter(r18, "<set-?>");
        r31.f22838c = r18;
        Unit r32 = Unit.INSTANCE;
        r29 = f.b(r17, null, r30, r16, r31, IvyAIPackageResourceServiceImpl$getImageUrl$response$2.f9496a, 5);
    L37:
        if (r29 == null) goto L51;
        String r33 = r29.f4443t;
        if (r33 == null) goto L51;
        if (StringsKt.isBlank(r33) == false) goto L44;
        r33 = null;
    L44:
        if (r33 == null) goto L51;
        ResourceFrom r34 = r29.f4444u;
        if (r34 == ResourceFrom.d) goto L48;
        r111 = r34;
    L48:
        if (r111 != null) goto L50;
        r111 = r29.f4445v;
    L50:
        r110 = com.bytedance.ies.bullet.preloadv2.redirect.a.b(r33, r111);
    L51:
        if (r29 == null) goto L78;
        if (r110 != null) goto L54;
        Object r35 = r17;
    L55:
        Intrinsics.checkNotNullParameter(r35, "imgPath");
        Intrinsics.checkNotNullParameter(r29, "response");
        r112.l(r16, r35, r29);
        goto L78
    L54:
        r35 = r110;
    L25:
        r19 = r17;
        goto L26
    L15:
        if (Intrinsics.areEqual(r12, IIvyAIPackageResourceService.HOST) == false) goto L18;
        r13 = false;
        goto L19
    }

    @Override // com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService
    public void initContainer(Application r5, String r10, String r11, h r12, com.ivy.ivykit.api.plugin.d r13) {
        Intrinsics.checkNotNullParameter(r5, "application");
        Intrinsics.checkNotNullParameter(r10, "bid");
        Intrinsics.checkNotNullParameter(r12, "pluginConfig");
        Intrinsics.checkNotNullParameter(r13, "containerConfig");
        if (r11 == null) goto L5;
        int r14 = a.f9506a;
        Intrinsics.checkNotNullParameter(r11, "<set-?>");
    L5:
        this.bid = r10;
        ul.d r15 = jm.c.f18359c;
        if (r15 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("geckoConfigs");
        r15 = null;
    L9:
        com.bytedance.ies.bullet.base.c r16 = com.ivy.ivykit.plugin.impl.utils.a.a(r5, r10, r10, r15, r12);
        r16.a(com.bytedance.ies.bullet.service.webkit.c.class, new com.bytedance.ies.bullet.service.webkit.c(new ug.e(r13.f9484a, 5), 1));
        com.bytedance.ies.bullet.base.b.b(r16);
        tc.c r17 = tc.c.f22119c;
        tc.c.f22119c.c(r10, pb.a.class, new com.ivy.ivykit.plugin.impl.jsb.c(0));
        k r18 = b.f9507a;
        if (r18 != null) goto L12;
    L13:
        k r19 = b.f9507a;
        if (r19 == null) goto L16;
        r19.evictAll();
    L16:
        b.f9508b.clear();
        b.f9507a = new k(5242880, 2);
    L25:
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L19
        Object r21 = Result.m124constructorimpl(f.a());     // Catch: Throwable -> L19
    L21:
        Throwable r22 = Result.m127exceptionOrNullimpl(r21);
        if (r22 == null) goto L27;
        int r23 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.d("IvyAIPackageResourceService", "init ForestLoader error: " + r22, null, 12);
        return;
    L27:
        return;
    L19:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        r21 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L21
    L12:
        if (r18.maxSize() <= 5242880) goto L25;
        goto L13
    }

    @Override // com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService
    public void loadAIPackageResourceAsync(String r5, String r10, final Function1<? super com.ivy.ivykit.api.plugin.b, Unit> r11, final Function1<? super Throwable, Unit> r12, final boolean r13) {
        Intrinsics.checkNotNullParameter(r10, "url");
        Intrinsics.checkNotNullParameter(r11, "resolve");
        Intrinsics.checkNotNullParameter(r12, "reject");
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L6
        String r15 = Uri.parse(r10).getQueryParameter("bid");     // Catch: Throwable -> L6
        if (r15 != null) goto L8;
        r15 = "default_bid";
    L8:
        g r16 = new g("");     // Catch: Throwable -> L6
        wc.a r17 = new wc.a(true);     // Catch: Throwable -> L6
        r17.f22823c = CollectionsKt.mutableListOf(new Class[]{a.class});     // Catch: Throwable -> L6
        Intrinsics.checkNotNullParameter(r17, "<set-?>");     // Catch: Throwable -> L6
        r16.f22837b = r17;     // Catch: Throwable -> L6
        Object r18 = Result.m124constructorimpl(com.bytedance.ies.bullet.kit.resourceloader.g.a(r15).a(r10, r16, new IvyAIPackageResourceServiceImpl$loadAIPackageResourceAsync$1$1(r11, r13, this), new IvyAIPackageResourceServiceImpl$loadAIPackageResourceAsync$1$2(r12)));     // Catch: Throwable -> L6
    L11:
        Throwable r19 = Result.m127exceptionOrNullimpl(r18);
        if (r19 == null) goto L17;
        r12.invoke(r19);
        return;
    L17:
        return;
    L6:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r18 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    @Override // com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService
    public void loadResourceAsync(String r11, final String r12, final Function1<? super com.ivy.ivykit.api.plugin.b, Unit> r13, final Function1<? super Throwable, Unit> r14, final boolean r15) {
        Intrinsics.checkNotNullParameter(r12, "url");
        Intrinsics.checkNotNullParameter(r13, "resolve");
        Intrinsics.checkNotNullParameter(r14, "reject");
        if (r11 != null) goto L5;
    L8:
        String r5 = r12;
    L9:
        zm.c r10 = f.f5397a;
        f.e(r5, null, Scene.f4351k, r11, null, null, new AnonymousClass1(r12, r13, r15, this, r14), 229);
        return;
    L5:
        if (r11.length() == 0) goto L8;
        r5 = Uri.parse(r12).buildUpon().appendQueryParameter("forest_session_id", r11).build().toString();
        goto L9
    }

    @Override // com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService
    public String openSession(String r5) {
        Forest r10 = f.a();
        if (r10 == null) goto L8;
        String r11 = r10.openSession(r5);
        if (r11 == null) goto L10;
        return r11;
    L10:
        return "";
    L8:
        return "";
    }
}
