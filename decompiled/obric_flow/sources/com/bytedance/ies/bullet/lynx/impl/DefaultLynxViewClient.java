package com.bytedance.ies.bullet.lynx.impl;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import androidx.annotation.Keep;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.forest.chain.fetchers.GeckoXAdapter;
import com.bytedance.forest.model.ResourceFrom;
import com.bytedance.forest.model.Scene;
import com.bytedance.forest.model.w;
import com.bytedance.ies.bullet.lynx.init.m;
import com.bytedance.ies.bullet.service.base.ResourceType;
import com.bytedance.ies.bullet.service.base.a0;
import com.bytedance.ies.bullet.service.base.resourceloader.config.LoaderType;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.facebook.common.references.CloseableReference;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.behavior.j;
import com.lynx.tasm.l;
import com.lynx.tasm.n0;
import com.lynx.tasm.o0;
import com.lynx.tasm.resourceprovider.LynxResourceRequest$LynxResourceType;
import com.lynx.tasm.y;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import javax.xml.transform.Transformer;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0016\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0016\u0010\u0015J%\u0010\u001a\u001a\u00020\u000b2\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJE\u0010\u001f\u001a\u00020\u000b2\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00172\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u00172\b\u0010\u001e\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u001f\u0010 JM\u0010,\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020!2\b\u0010#\u001a\u0004\u0018\u00010\t2\b\u0010$\u001a\u0004\u0018\u00010\t2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020%2\b\u0010)\u001a\u0004\u0018\u00010(2\u0006\u0010+\u001a\u00020*H\u0016¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\u000bH\u0016¢\u0006\u0004\b.\u0010/J\u0019\u00102\u001a\u00020\u000b2\b\u00101\u001a\u0004\u0018\u000100H\u0016¢\u0006\u0004\b2\u00103J\u0019\u00105\u001a\u00020\u000b2\b\u00104\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b5\u0010\rJ\u000f\u00106\u001a\u00020\u000bH\u0016¢\u0006\u0004\b6\u0010/J\u000f\u00107\u001a\u00020\u000bH\u0016¢\u0006\u0004\b7\u0010/J\u000f\u00108\u001a\u00020\u000bH\u0016¢\u0006\u0004\b8\u0010/J+\u0010=\u001a\u00020\u000b2\b\u00109\u001a\u0004\u0018\u00010\t2\b\u0010:\u001a\u0004\u0018\u00010\t2\u0006\u0010<\u001a\u00020;H\u0016¢\u0006\u0004\b=\u0010>J\u0019\u0010?\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b?\u0010\u0011J\u001b\u0010@\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b@\u0010AJ\u000f\u0010B\u001a\u00020\u000bH\u0016¢\u0006\u0004\bB\u0010/J\u000f\u0010C\u001a\u00020\u000bH\u0016¢\u0006\u0004\bC\u0010/J\u000f\u0010D\u001a\u00020\u000bH\u0016¢\u0006\u0004\bD\u0010/J\u000f\u0010E\u001a\u00020\u000bH\u0016¢\u0006\u0004\bE\u0010/J\u0019\u0010G\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010FH\u0016¢\u0006\u0004\bG\u0010HJ\u001f\u0010K\u001a\u00020\u000b2\u000e\u0010J\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010IH\u0016¢\u0006\u0004\bK\u0010LJ\u001b\u0010M\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\bM\u0010AJ1\u0010Q\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010N\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010P\u001a\u0004\u0018\u00010OH\u0002¢\u0006\u0004\bQ\u0010RR(\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bS\u0010T\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR$\u0010Z\u001a\u0004\u0018\u00010Y8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\u0016\u0010\"\u001a\u0004\u0018\u00010\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010`¨\u0006a"}, d2 = {"Lcom/bytedance/ies/bullet/lynx/impl/DefaultLynxViewClient;", "Lcom/lynx/tasm/o0;", "Lcom/bytedance/ies/bullet/forest/e;", "", "initDelegates", "Lrc/f;", "token", "<init>", "(Ljava/util/List;Lrc/f;)V", "", "url", "", "onPageStart", "(Ljava/lang/String;)V", "Lcom/lynx/tasm/y;", LynxMonitorService.KEY_METRIC, "onUpdatePerfReady", "(Lcom/lynx/tasm/y;)V", "Lcom/lynx/tasm/n0;", "info", "onScrollStart", "(Lcom/lynx/tasm/n0;)V", "onScrollStop", "", "", "timingInfo", "onTimingSetup", "(Ljava/util/Map;)V", "", "updateTiming", "flag", "onTimingUpdate", "(Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;)V", "Landroid/content/Context;", "context", "cacheKey", "src", "", "width", "height", "Ljavax/xml/transform/Transformer;", "transformer", "Lcom/lynx/tasm/behavior/j;", "handler", "loadImage", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;FFLjavax/xml/transform/Transformer;Lcom/lynx/tasm/behavior/j;)V", "onRuntimeReady", "()V", "Lcom/lynx/tasm/LynxError;", "error", "onReceivedError", "(Lcom/lynx/tasm/LynxError;)V", "message", "onLoadFailed", "onPageUpdate", "onDataUpdated", "onUpdateDataWithoutChange", "module", "method", "", WsConstants.ERROR_CODE, "onModuleMethodInvoked", "(Ljava/lang/String;Ljava/lang/String;I)V", "onFirstLoadPerfReady", "shouldRedirectImageUrl", "(Ljava/lang/String;)Ljava/lang/String;", "onLoadSuccess", "onFirstScreen", "onDestroy", "onLynxViewAndJSRuntimeDestroy", "Lcom/lynx/tasm/l;", "onReportLynxConfigInfo", "(Lcom/lynx/tasm/l;)V", "", "mComponentSet", "onReportComponentInfo", "(Ljava/util/Set;)V", "redirectWithPipeline", "containerId", "Lwc/g;", "taskConfig", "fetchLynxImageFromForest", "(Ljava/lang/String;Ljava/lang/String;Lwc/g;)Ljava/lang/String;", "delegates", "Ljava/util/List;", "getDelegates", "()Ljava/util/List;", "setDelegates", "(Ljava/util/List;)V", "Landroid/net/Uri;", LynxResourceModule.URI_KEY, "Landroid/net/Uri;", "getUri", "()Landroid/net/Uri;", "setUri", "(Landroid/net/Uri;)V", "Lrc/f;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
@SourceDebugExtension({"SMAP\nDefaultLynxViewClient.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DefaultLynxViewClient.kt\ncom/bytedance/ies/bullet/lynx/impl/DefaultLynxViewClient\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,360:1\n1819#2,2:361\n1819#2,2:364\n1819#2,2:366\n1819#2,2:368\n1819#2,2:370\n1819#2,2:372\n1819#2,2:374\n1819#2,2:376\n1819#2,2:378\n1819#2,2:380\n1819#2,2:382\n1819#2,2:384\n1819#2,2:386\n1819#2,2:388\n1819#2,2:390\n1819#2,2:392\n1819#2,2:394\n1819#2,2:396\n1819#2,2:398\n1819#2,2:400\n1#3:363\n*E\n*S KotlinDebug\n*F\n+ 1 DefaultLynxViewClient.kt\ncom/bytedance/ies/bullet/lynx/impl/DefaultLynxViewClient\n*L\n43#1,2:361\n50#1,2:364\n56#1,2:366\n62#1,2:368\n68#1,2:370\n78#1,2:372\n118#1,2:374\n124#1,2:376\n130#1,2:378\n136#1,2:380\n142#1,2:382\n148#1,2:384\n154#1,2:386\n164#1,2:388\n170#1,2:390\n176#1,2:392\n222#1,2:394\n228#1,2:396\n234#1,2:398\n240#1,2:400\n*E\n"})
public final class DefaultLynxViewClient extends o0 implements com.bytedance.ies.bullet.forest.e {
    private final rc.f context;
    private List<o0> delegates;
    private Uri uri;

    public DefaultLynxViewClient(List<o0> r5, rc.f r10) {
        Intrinsics.checkNotNullParameter(r5, "initDelegates");
        this.delegates = r5;
        this.context = r10;
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
    private final String fetchLynxImageFromForest(String r11, String r12, wc.g r13) {
        zm.c r5 = com.bytedance.ies.bullet.forest.f.f5397a;
        Intrinsics.checkNotNullParameter(r11, "imgPath");
        zm.c r10 = com.bytedance.ies.bullet.forest.f.f5398b;
        w r14 = (w) r10.e(r11, r12);
        if (r14 != null) goto L5;
        r14 = com.bytedance.ies.bullet.forest.f.b(r11, forestDownloadEngine(this.context), Scene.f, r12, r13, DefaultLynxViewClient$fetchLynxImageFromForest$response$1.f5646a, 1);
    L5:
        String r15 = null;
        ResourceFrom r16 = null;
        r15 = null;
        r15 = null;
        if (r14 == null) goto L20;
        String r17 = r14.f4443t;
        if (r17 == null) goto L20;
        if (StringsKt.isBlank(r17) == false) goto L13;
        r17 = null;
    L13:
        if (r17 == null) goto L20;
        boolean r18 = com.bytedance.ies.bullet.preloadv2.redirect.a.f5885a;
        ResourceFrom r19 = r14.f4444u;
        if (r19 == ResourceFrom.d) goto L17;
        r16 = r19;
    L17:
        if (r16 != null) goto L19;
        r16 = r14.f4445v;
    L19:
        r15 = com.bytedance.ies.bullet.preloadv2.redirect.a.b(r17, r16);
    L20:
        if (r14 == null) goto L25;
        if (r15 == null) goto L24;
        r11 = r15;
    L24:
        Intrinsics.checkNotNullParameter(r11, "imgPath");
        Intrinsics.checkNotNullParameter(r14, "response");
        r10.l(r12, r11, r14);
    L25:
        return r15;
    }

    public static /* synthetic */ String fetchLynxImageFromForest$default(DefaultLynxViewClient r5, String r10, String r11, wc.g r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L9;
        r12 = null;
    L9:
        return r5.fetchLynxImageFromForest(r10, r11, r12);
    }

    private final String redirectWithPipeline(String r14) {
        long r5 = System.currentTimeMillis();
        StringBuilder r10 = com.lynx.tasm.utils.e.b("redirectWithPipeline URL:", r14, ",defaultCache:");
        boolean r11 = com.bytedance.ies.bullet.preloadv2.redirect.a.f5885a;
        r10.append(com.bytedance.ies.bullet.preloadv2.redirect.a.f5886b);
        com.bytedance.ies.bullet.base.utils.b.m(r10.toString());
        if (r14 != null) goto L5;
    L104:
        return r14;
    L5:
        if (r14.length() == 0) goto L104;
        if (StringsKt.P(r14, "file://") == true) goto L104;
        if (StringsKt.P(r14, "data:") == true) goto L104;
        String r12 = sessionID(this.context);
        boolean r13 = useForest(this.context);
        if (r13 == false) goto L19;
        zm.c r15 = com.bytedance.ies.bullet.forest.f.f5397a;
        Intrinsics.checkNotNullParameter(r14, "url");
        Intrinsics.checkNotNullParameter(r14, "url");
        if (GeckoXAdapter.Companion.canParsed(r14) == false) goto L19;
        int r16 = StringsKt.r("?", 0, 6, r14);
        if (r16 == (-1)) goto L19;
        String r17 = r14.substring(0, r16);
    L20:
        String r18 = com.bytedance.ies.bullet.preloadv2.redirect.a.a(r17);
        String r19 = "default_bid";
        if (r18 == null) goto L30;
        rc.f r110 = this.context;
        if (r110 == null) goto L28;
        String r111 = r110.getBid();
        if (r111 == null) goto L28;
        r19 = r111;
    L28:
        com.bytedance.ies.bullet.preloadv2.redirect.a.d(r19, r14, r18, true, System.currentTimeMillis() - r5);
        return r18;
    L30:
        wc.g r20 = new wc.g("");
        rc.f r21 = this.context;
        String r22 = null;
        if (r21 == null) goto L33;
        Map r23 = r21.getAllDependency();
    L34:
        r20.f22846o = com.bytedance.ies.bullet.base.utils.b.e(r23);
        rc.f r24 = this.context;
        if (r24 == null) goto L37;
        wc.a r25 = (wc.a) r24.b(wc.a.class);
    L38:
        wc.a r26 = cl.a.i(r25);
        if (r26 != null) goto L41;
        r26 = new wc.a(true);
    L41:
        rc.f r112 = this.context;
        if (r112 == null) goto L47;
        wc.d r113 = (wc.d) r112.b(wc.d.class);
        if (r113 == null) goto L47;
        List r114 = r113.f22825a;
        if (r114 == null) goto L47;
    L48:
        Intrinsics.checkNotNullParameter(r114, "<set-?>");
        r20.f22847p = r114;
        List r115 = CollectionsKt.mutableListOf(new LoaderType[]{LoaderType.f5993a, LoaderType.f5994b});
        Intrinsics.checkNotNullParameter(r115, "<set-?>");
        r26.f22822b = r115;
        Intrinsics.checkNotNullParameter(r26, "<set-?>");
        r20.f22837b = r26;
        rc.f r27 = this.context;
        if (r27 == null) goto L52;
        String r28 = r27.getBid();
        if (r28 == null) goto L52;
    L53:
        Intrinsics.checkNotNullParameter(r28, "<set-?>");
        r20.f22838c = r28;
        Intrinsics.checkNotNullParameter("sub_resource", "<set-?>");
        r20.f22840i = "sub_resource";
        if (r13 == true) goto L56;
    L58:
        ConcurrentHashMap r29 = com.bytedance.ies.bullet.kit.resourceloader.g.f5451a;
        rc.f r30 = this.context;
        if (r30 == null) goto L61;
        String r31 = r30.getBid();
    L62:
        a0 r32 = com.bytedance.ies.bullet.kit.resourceloader.g.a(r31).c(r14, r20);
        if (r32 == null) goto L82;
        String r33 = r32.f5933b;
        if (r33 != null) goto L67;
    L69:
        r32 = null;
    L70:
        if (r32 == null) goto L82;
        String r34 = r32.f5933b;
        Intrinsics.checkNotNull(r34);
        ResourceType r35 = r32.f5934c;
        Intrinsics.checkNotNullParameter(r34, "rawFilePath");
        if (r35 != ResourceType.f5929b) goto L75;
        r22 = new Uri.Builder().scheme("asset").authority("").path(r34).build().toString();
    L80:
        if (r22 == null) goto L82;
        String r36 = r22;
    L83:
        if (r36 != null) goto L85;
    L89:
        GeckoXAdapter.Companion r37 = GeckoXAdapter.Companion;
        if (r37.isCDNMultiVersionResource(r14) == false) goto L93;
        r36 = r37.addCommonParamsForCDNMultiVersionURL(r14);
    L93:
        if (com.bytedance.ies.bullet.preloadv2.redirect.a.f5886b == false) goto L95;
        StringBuilder r38 = com.lynx.tasm.base.a.e("redirectWithPipeline putRedirectPath URL:", r14, ",redirectUrl:", r36, ", useForest=");
        r38.append(r13);
        com.bytedance.ies.bullet.base.utils.b.m(r38.toString());
        com.bytedance.ies.bullet.preloadv2.redirect.a.c(r14, r36);
    L95:
        rc.f r116 = this.context;
        if (r116 == null) goto L101;
        String r117 = r116.getBid();
        if (r117 == null) goto L101;
        String r39 = r117;
    L102:
        com.bytedance.ies.bullet.preloadv2.redirect.a.d(r39, r14, r36, false, System.currentTimeMillis() - r5);
        return r36;
    L101:
        r39 = "default_bid";
        goto L102
    L85:
        if (r36.length() == 0) goto L89;
        if (Intrinsics.areEqual(r36, r14) == false) goto L93;
    L75:
        if (r35 != ResourceType.f5928a) goto L80;
        if (StringsKt.g(r34, "@") == true) goto L79;
        r22 = Uri.fromFile(new File(r34)).toString();
        goto L80
    L79:
        r22 = td.d.b("file:///", r34);
        goto L80
    L67:
        if ((!StringsKt.isBlank(r33)) != true) goto L69;
    L82:
        r36 = r14;
        goto L83
    L61:
        r31 = null;
        goto L62
    L56:
        if (StringsKt.P(r14, "base64:") == true) goto L58;
        r36 = fetchLynxImageFromForest(r14, r12, r20);
    L52:
        r28 = "";
    L47:
        r114 = CollectionsKt.emptyList();
        goto L48
    L37:
        r25 = null;
        goto L38
    L33:
        r23 = null;
    L19:
        r17 = r14;
        goto L20
    }

    public boolean delayPreload(com.bytedance.ies.bullet.core.e r5) {
        String r10 = u8.a.d(r5, "delay_preload");
        if (r10 != null) goto L6;
        r10 = "0";
    L6:
        return Intrinsics.areEqual(r10, IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST);
    }

    public String forestDownloadEngine(Uri r5) {
        return u8.a.b(r5);
    }

    public final List<o0> getDelegates() {
        return this.delegates;
    }

    public String getResTag(LynxResourceRequest$LynxResourceType r5) {
        return u8.a.f(r5);
    }

    public Scene getSceneType(LynxResourceRequest$LynxResourceType r5) {
        return u8.a.l(r5);
    }

    public com.bytedance.forest.postprocessor.g getTemplateBundleResponse(w r5) {
        return u8.a.a(r5);
    }

    public final Uri getUri() {
        return this.uri;
    }

    @Override // com.bytedance.ies.bullet.forest.e
    public boolean hasGeckoModelInfo(com.bytedance.ies.bullet.core.e r5) {
        return u8.a.n(r5);
    }

    @Override // com.lynx.tasm.o0, com.lynx.tasm.behavior.k
    public void loadImage(Context r15, String r16, String r17, float r18, float r19, Transformer r20, j r21) {
        Intrinsics.checkNotNullParameter(r15, "context");
        Intrinsics.checkNotNullParameter(r21, "handler");
        if (useForest(this.context) == false) goto L26;
        if (r17 != null) goto L6;
    L8:
        String r10 = sessionID(this.context);
        if (r17 == null) goto L17;
        zm.c r5 = com.bytedance.ies.bullet.forest.f.f5397a;
        Intrinsics.checkNotNullParameter(r17, "imgPath");
        zm.c r13 = com.bytedance.ies.bullet.forest.f.f5398b;
        w r11 = (w) r13.e(r17, r10);
        if (r11 == null) goto L14;
        CloseableReference r12 = r11.h();
        if (r12 == null) goto L14;
    L18:
        boolean r14 = com.bytedance.ies.bullet.service.base.b.f5956a;
        StringBuilder r22 = new StringBuilder("Forest preload image ");
        if (r12 != null) goto L21;
        String r23 = MessageIndication.STATUS_FAILED;
    L22:
        f8.b.e(r22, r23, " for ", r17, " on ");
        r22.append(r10);
        com.bytedance.ies.bullet.service.base.b.a(6, r22.toString(), null);
        if (r12 == null) goto L26;
        ((com.lynx.tasm.ui.image.w) r21).a(r12);
        return;
    L21:
        r23 = "success";
    L14:
        fetchLynxImageFromForest$default(this, r17, r10, null, 4, null);
        Intrinsics.checkNotNullParameter(r17, "imgPath");
        w r24 = (w) r13.e(r17, r10);
        if (r24 == null) goto L17;
        r12 = r24.h();
    L17:
        r12 = null;
        goto L18
    L6:
        if (StringsKt.P(r17, "base64:") != true) goto L8;
    L26:
        Iterator<T> r110 = this.delegates.iterator();
    L28:
        if (r110.hasNext() == false) goto L30;
        ((o0) r110.next()).loadImage(r15, r16, r17, r18, r19, r20, r21);
        goto L28
    }

    @Override // com.lynx.tasm.o0
    public void onDataUpdated() {
        Iterator<T> r5 = this.delegates.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        ((o0) r5.next()).onDataUpdated();
        goto L4
    }

    @Override // com.lynx.tasm.o0
    public void onDestroy() {
        Iterator<T> r5 = this.delegates.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        ((o0) r5.next()).onDestroy();
        goto L4
    }

    @Override // com.lynx.tasm.o0
    public void onFirstLoadPerfReady(y r5) {
        Iterator<T> r10 = this.delegates.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        ((o0) r10.next()).onFirstLoadPerfReady(r5);
        goto L4
    }

    @Override // com.lynx.tasm.o0
    public void onFirstScreen() {
        Iterator<T> r5 = this.delegates.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        ((o0) r5.next()).onFirstScreen();
        goto L4
    }

    @Override // com.lynx.tasm.o0
    public void onLoadFailed(String r5) {
        Iterator<T> r10 = this.delegates.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        ((o0) r10.next()).onLoadFailed(r5);
        goto L4
    }

    @Override // com.lynx.tasm.o0
    public void onLoadSuccess() {
        Iterator<T> r5 = this.delegates.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        ((o0) r5.next()).onLoadSuccess();
        goto L4
    }

    @Override // com.lynx.tasm.o0
    public void onLynxViewAndJSRuntimeDestroy() {
        Iterator<T> r5 = this.delegates.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        ((o0) r5.next()).onLynxViewAndJSRuntimeDestroy();
        goto L4
    }

    @Override // com.lynx.tasm.o0, com.lynx.tasm.j
    public void onModuleMethodInvoked(String r5, String r10, int r11) {
        Iterator<T> r12 = this.delegates.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        ((o0) r12.next()).onModuleMethodInvoked(r5, r10, r11);
        goto L4
    }

    @Override // com.lynx.tasm.o0
    public void onPageStart(String r5) {
        Iterator<T> r10 = this.delegates.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        ((o0) r10.next()).onPageStart(r5);
        goto L4
    L6:
        if (r5 == null) goto L8;
        Uri r11 = Uri.parse(r5);
    L9:
        this.uri = r11;
        return;
    L8:
        r11 = null;
        goto L9
    }

    @Override // com.lynx.tasm.o0
    public void onPageUpdate() {
        Iterator<T> r5 = this.delegates.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        ((o0) r5.next()).onPageUpdate();
        goto L4
    }

    @Override // com.lynx.tasm.o0, com.lynx.tasm.j
    public void onReceivedError(LynxError r5) {
        Iterator<T> r10 = this.delegates.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        ((o0) r10.next()).onReceivedError(r5);
        goto L4
    }

    @Override // com.lynx.tasm.o0
    public void onReportComponentInfo(Set<String> r5) {
        Handler r10 = m.f5688b;
        if (r10 == null) goto L6;
        r10.post(new a6.a(r5, 19));
        return;
    }

    public void onReportLynxConfigInfo(l r5) {
        Handler r10 = m.f5688b;
        if (r10 == null) goto L6;
        r10.post(new a6.a(r5, 20));
        return;
    }

    @Override // com.lynx.tasm.o0
    public void onRuntimeReady() {
        Iterator<T> r5 = this.delegates.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        ((o0) r5.next()).onRuntimeReady();
        goto L4
    }

    @Override // com.lynx.tasm.o0
    public void onScrollStart(n0 r5) {
        Iterator<T> r10 = this.delegates.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        ((o0) r10.next()).onScrollStart(r5);
        goto L4
    }

    @Override // com.lynx.tasm.o0
    public void onScrollStop(n0 r5) {
        Iterator<T> r10 = this.delegates.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        ((o0) r10.next()).onScrollStop(r5);
        goto L4
    }

    @Override // com.lynx.tasm.o0
    public void onTimingSetup(Map<String, Object> r5) {
        Iterator<T> r10 = this.delegates.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        ((o0) r10.next()).onTimingSetup(r5);
        goto L4
    }

    @Override // com.lynx.tasm.o0
    public void onTimingUpdate(Map<String, Object> r5, Map<String, Long> r10, String r11) {
        Iterator<T> r12 = this.delegates.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        ((o0) r12.next()).onTimingUpdate(r5, r10, r11);
        goto L4
    }

    @Override // com.lynx.tasm.o0
    public void onUpdateDataWithoutChange() {
        Iterator<T> r5 = this.delegates.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        ((o0) r5.next()).onUpdateDataWithoutChange();
        goto L4
    }

    @Override // com.lynx.tasm.o0
    public void onUpdatePerfReady(y r5) {
        Iterator<T> r10 = this.delegates.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        ((o0) r10.next()).onUpdatePerfReady(r5);
        goto L4
    }

    public String preloadScope(com.bytedance.ies.bullet.core.e r5) {
        String r10 = u8.a.d(r5, "enable_preload");
        if (r10 != null) goto L6;
        return "disable";
    L6:
        return r10;
    }

    public String sessionID(rc.f r5) {
        return u8.a.p(this, r5);
    }

    public final void setDelegates(List<o0> r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.delegates = r5;
    }

    public final void setUri(Uri r5) {
        this.uri = r5;
    }

    @Override // com.lynx.tasm.o0, com.lynx.tasm.behavior.k
    public String shouldRedirectImageUrl(String r10) {
        Iterator<T> r5 = this.delegates.iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        String r11 = ((o0) r5.next()).shouldRedirectImageUrl(r10);
        if (r11 == null) goto L4;
        return r11;
    L8:
        Uri r12 = Uri.parse(r10);
        if (useForest(this.context) == true) goto L17;
        String r13 = mh.e.d(r12, this.context);
        if (r13 != null) goto L13;
    L14:
        r13 = null;
    L15:
        if (r13 == null) goto L17;
        return r13;
    L13:
        if (r13.length() != 0) goto L15;
    L17:
        String r14 = redirectWithPipeline(r10);
        if (r14 != null) goto L20;
    L25:
        if (r10 != null) goto L27;
    L40:
        return null;
    L27:
        if (r10.length() == 0) goto L40;
        List r15 = CollectionsKt.listOf(new String[]{"http", IIvyAIPackageResourceService.SCHEMA, "file", "content", "res", "data"});
        String r16 = r12.getScheme();
        if (r16 != null) goto L33;
        r16 = "";
    L33:
        if (r15.contains(r16) == false) goto L36;
        return r10;
    L36:
        if (Intrinsics.areEqual(r12.getScheme(), "bundle") == false) goto L38;
    L39:
        r12.getPath();
        goto L40
    L38:
        if (Intrinsics.areEqual(r12.getScheme(), "relative") == false) goto L40;
    L20:
        if (equals(r10) == false) goto L23;
        r14 = null;
    L23:
        if (r14 == null) goto L25;
        return r14;
    }

    public boolean useForest(Uri r5) {
        return u8.a.m(r5);
    }

    public boolean delayPreload(rd.e r5) {
        String r10 = u8.a.h(r5, "delay_preload");
        if (r10 != null) goto L6;
        r10 = "0";
    L6:
        return Intrinsics.areEqual(r10, IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST);
    }

    @Override // com.bytedance.ies.bullet.forest.e
    public String forestDownloadEngine(com.bytedance.ies.bullet.core.e r5) {
        return u8.a.c(r5);
    }

    @Override // com.bytedance.ies.bullet.forest.e
    public boolean hasGeckoModelInfo(rd.e r5) {
        return u8.a.j(r5);
    }

    @Override // com.bytedance.ies.bullet.forest.e
    public String sessionID(com.bytedance.ies.bullet.core.e r5) {
        if (r5 != null) goto L4;
        return null;
    L4:
        return r5.getSessionId();
    }

    @Override // com.bytedance.ies.bullet.forest.e
    public boolean useForest(com.bytedance.ies.bullet.core.e r5) {
        return u8.a.q(r5);
    }

    public boolean delayPreload(Uri r5) {
        Object r10 = null;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L6
        if (r5 == null) goto L8;
        String r12 = r5.getQueryParameter("delay_preload");     // Catch: Throwable -> L6
    L9:
        Object r13 = Result.m124constructorimpl(r12);     // Catch: Throwable -> L6
    L13:
        if (Result.m130isFailureimpl(r13) == true) goto L16;
        r10 = r13;
    L16:
        String r14 = (String) r10;
        if (r14 != null) goto L20;
        r14 = "0";
    L20:
        return Intrinsics.areEqual(r14, IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST);
    L8:
        r12 = null;
    L6:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r13 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    public String forestDownloadEngine(rc.f r5) {
        return u8.a.e(this, r5);
    }

    public boolean hasGeckoModelInfo(rc.f r5) {
        if (r5 == null) goto L4;
        com.bytedance.ies.bullet.core.e r10 = (com.bytedance.ies.bullet.core.e) r5.b(com.bytedance.ies.bullet.core.e.class);
    L6:
        return hasGeckoModelInfo(r10);
    L4:
        r10 = null;
        goto L6
    }

    public String preloadScope(rd.e r5) {
        String r10 = u8.a.h(r5, "enable_preload");
        if (r10 != null) goto L6;
        return "disable";
    L6:
        return r10;
    }

    public boolean useForest(rc.f r5) {
        return u8.a.t(this, r5);
    }

    public String forestDownloadEngine(rd.e r5) {
        String r10 = u8.a.h(r5, "forest_download_engine");
        if (r10 != null) goto L6;
        return "ttnet";
    L6:
        return r10;
    }

    public boolean useForest(rd.e r5) {
        return u8.a.o(r5);
    }

    public String preloadScope(Uri r5) {
        Object r10 = null;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L6
        if (r5 == null) goto L8;
        String r12 = r5.getQueryParameter("enable_preload");     // Catch: Throwable -> L6
    L9:
        Object r13 = Result.m124constructorimpl(r12);     // Catch: Throwable -> L6
    L13:
        if (Result.m130isFailureimpl(r13) == true) goto L16;
        r10 = r13;
    L16:
        String r14 = (String) r10;
        if (r14 != null) goto L22;
        return "disable";
    L22:
        return r14;
    L8:
        r12 = null;
    L6:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r13 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L13
    }
}
