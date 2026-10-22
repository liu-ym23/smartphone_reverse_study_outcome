package com.obric.aikernel.res.metadata.data;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.aikernel.res.PackageResourceManager;
import com.obric.aikernel.res.PrmContext;
import com.obric.aikernel.res.metadata.NativeLibVersionPolicy;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 >2\u00020\u0001:\u0001>B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\"\u001a\u00020#H\u0002J\u0015\u0010$\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\u0010H\u0010¢\u0006\u0002\b&J\b\u0010'\u001a\u00020\u0010H\u0016J\b\u0010(\u001a\u00020\u0010H\u0016J\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013J\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00010\u0013J\b\u0010+\u001a\u00020\u0003H\u0016J\b\u0010,\u001a\u00020\u0003H\u0016J\u0010\u0010-\u001a\u00020#2\u0006\u0010.\u001a\u00020/H\u0004J\b\u00100\u001a\u00020\u0010H\u0002J\b\u00101\u001a\u00020\u0010H\u0016J\b\u00102\u001a\u00020#H\u0002J\u0010\u00103\u001a\u00020#2\u0006\u00104\u001a\u00020\u0019H\u0016J\b\u00105\u001a\u00020#H\u0016J\b\u00106\u001a\u00020#H\u0014J\u0006\u00107\u001a\u00020\u0010J\b\u00108\u001a\u00020\u0010H\u0016J\u0014\u00109\u001a\u00020#2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00010\u0013J\u000e\u0010;\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020<J\b\u0010=\u001a\u00020\u0010H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\n\u001a\u0004\u0018\u00010\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00108FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u000e\u001a\u0004\b\u0015\u0010\u0016R$\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u00198F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lcom/obric/aikernel/res/metadata/data/AIPackage;", "Lcom/obric/aikernel/res/metadata/data/BaseMetadata;", ActivityLifecycle.NAME, "", "version", "config", "Lcom/obric/aikernel/res/PackageResourceManager$PresmConfig;", "(Ljava/lang/String;Ljava/lang/String;Lcom/obric/aikernel/res/PackageResourceManager$PresmConfig;)V", "allAvailFile", "Ljava/io/File;", "debugVersion", "getDebugVersion", "()Ljava/lang/String;", "debugVersion$delegate", "Lkotlin/Lazy;", "dependencyStateBroken", "", "dependsDir", "dynamicRes", "", "Lcom/obric/aikernel/res/metadata/data/dynamic/RuntimeResource;", "isTemplatePackage", "()Z", "isTemplatePackage$delegate", EventBody.KEY_VALUE, "", "lastUsageTimeMills", "getLastUsageTimeMills", "()J", "setLastUsageTimeMills", "(J)V", "lastUsageTimeMillsRef", "Ljava/util/concurrent/atomic/AtomicLong;", "subRes", "checkPackageAllAvail", "", "checkShouldReinstall", "fastMode", "checkShouldReinstall$resource_manager_release", "disable", "enable", "getRuntimeResource", "getSubResource", "getType", "getTypeRootPath", "install", "ctx", "Lcom/obric/aikernel/res/PrmContext;", "isAllAvailable", "isAvailable", "loadExtras", "loggerUsage", OaidModel.KEY_TIME, "makeAvail", "onInstallSucceed", "resourceAllReady", "resourceIsReady", "setSubResource", "subs", "shouldUpdate", "Lcom/google/gson/JsonObject;", "uninstall", "Companion", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class b extends d {
    public static final a e = null;
    private static final Lazy<Regex> k = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Lazy f6086a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final File f6087b;
    private final File c;
    private final Lazy d;
    private List<? extends d> g;
    private List<? extends com.obric.aikernel.res.metadata.data.a.d> h;
    private boolean i;
    private final AtomicLong j;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\f\u001a\u00020\r*\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/aikernel/res/metadata/data/AIPackage$Companion;", "", "()V", "TAG", "", "TEMPLATE_PATTER", "Lkotlin/text/Regex;", "getTEMPLATE_PATTER", "()Lkotlin/text/Regex;", "TEMPLATE_PATTER$delegate", "Lkotlin/Lazy;", "TYPE", "versionCode", "", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final int a(String r1) {
            Intrinsics.checkNotNullParameter(r1, "<this>");
            Integer r0 = StringsKt.toIntOrNull(r1);
            if (r0 != null) goto L7;
            return Integer.MAX_VALUE;
        L7:
            return r0.intValue();
        }

        public final Regex a() {
            return (Regex) ZeusTransformUtils.preCheckCast(b.r().getValue(), Regex.class, "com.obric.memorydata.plugin");
        }
    }

    static {
        e = new a(null);
        k = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(AIPackage$Companion$TEMPLATE_PATTER$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
    }

    public b(final String r3, final String r4, PackageResourceManager.PresmConfig r5) {
        Intrinsics.checkNotNullParameter(r3, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r4, "version");
        Intrinsics.checkNotNullParameter(r5, "config");
        super(r3, r4, r5);
        this.f6086a = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new AIPackage$debugVersion$2(r4, this), Function0.class, "com.obric.memorydata.plugin"));
        this.f6087b = new File(w(), "depends");
        this.c = new File(y(), "allAvail");
        this.d = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new AIPackage$isTemplatePackage$2(r3), Function0.class, "com.obric.memorydata.plugin"));
        this.g = CollectionsKt.emptyList();
        this.h = CollectionsKt.emptyList();
        this.j = new AtomicLong(0);
        P();
    }

    private final boolean N() {
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(this.g, Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L13;
        d r3 = (d) ZeusTransformUtils.preCheckCast(r2.next(), d.class, "com.obric.memorydata.plugin");
        boolean r4 = r3.d();
        if (r4 == true) goto L12;
        if (ZeusTransformUtils.instanceOf(r3, i.class) == false) goto L12;
        if (((i) ZeusTransformUtils.preCheckCast(r3, i.class, "com.obric.memorydata.plugin")).g() == false) goto L12;
        NativeLibVersionPolicy.INSTANCE.refreshNativeLibVersionPolicy$resource_manager_release((i) ZeusTransformUtils.preCheckCast(r3, i.class, "com.obric.memorydata.plugin"));
    L12:
        r1.add(Boolean.valueOf(r4));
        goto L4
    L13:
        List r5 = (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin");
        if (c.a(e(), this.i, (Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin")) == true) goto L29;
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.zip((Iterable) ZeusTransformUtils.preCheckCast(this.g, Iterable.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L17:
        if (r6.hasNext() == false) goto L21;
        Object r7 = r6.next();
        if ((!((Boolean) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r7, Pair.class, "com.obric.memorydata.plugin")).getSecond(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue()) == false) goto L17;
    L22:
        Pair r8 = (Pair) ZeusTransformUtils.preCheckCast(r7, Pair.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L38;
        d r9 = (d) ZeusTransformUtils.preCheckCast(r8.getFirst(), d.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L39;
        com.obric.aikernel.runtime.utils.c.a.a((com.obric.aikernel.runtime.utils.c) ZeusTransformUtils.preCheckCast(com.obric.aikernel.runtime.utils.d.f6216a, com.obric.aikernel.runtime.utils.c.class, "com.obric.memorydata.plugin"), "AIPackage", s() + '@' + t() + " subRes " + r9.s() + '@' + r9.t() + " is not avail, ready:" + r9.f() + ", avail: " + r9.e(), 0, 4, null);
        return false;
    L39:
        return false;
    L38:
        return false;
    L21:
        r7 = null;
        goto L22
    L29:
        return true;
    }

    private final void O() {
        if (N() == false) goto L5;
        b(CollectionsKt.listOf(this.c));
        return;
    L5:
        c(CollectionsKt.listOf(this.c));
    }

    private final void P() {
        List<? extends d> r1 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        List<? extends com.obric.aikernel.res.metadata.data.a.d> r2 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        String[] r4 = this.f6087b.list();
        if (r4 == null) goto L71;
        int r5 = r4.length;
        int r7 = 0;
        boolean r8 = false;
    L6:
        if (r7 >= r5) goto L54;
        String r12 = r4[r7];
        Intrinsics.checkNotNullExpressionValue(r12, ActivityLifecycle.NAME);
        List r13 = StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin"), new char[]{'@'}, false, 0, 6, null);
        if (r13.size() == 3) goto L10;
    L52:
        com.obric.aikernel.runtime.utils.d.f6216a.f(PackageResourceManager.TAG, this + " path is illegal: " + this.f6087b + '/' + r12);
        r8 = true;
    L53:
        r7 = r7 + 1;
        goto L6
    L10:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r13.get(0), CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L52;
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r13.get(1), CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L52;
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r13.get(2), CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L52;
        String r9 = (String) ZeusTransformUtils.preCheckCast(r13.get(0), String.class, "com.obric.memorydata.plugin");
        String r10 = (String) ZeusTransformUtils.preCheckCast(r13.get(1), String.class, "com.obric.memorydata.plugin");
        String r11 = (String) ZeusTransformUtils.preCheckCast(r13.get(2), String.class, "com.obric.memorydata.plugin");
        switch(r9.hashCode()) {
            case 107141: goto L41;
            case 104069929: goto L35;
            case 1164183140: goto L26;
            case 1729824090: goto L20;
            default: goto L46;
        };
    L46:
        d r14 = null;
    L48:
        if (ZeusTransformUtils.instanceOf(r14, com.obric.aikernel.res.metadata.data.a.d.class) == false) goto L50;
        r2.add(r14);
        goto L53
    L50:
        if (r14 == null) goto L53;
        r1.add(r14);
        goto L53
    L20:
        if (r9.equals("aikernel-lora") == false) goto L46;
        if (u().getUseAIKernelModel() == false) goto L32;
        Object r15 = new com.obric.aikernel.res.metadata.data.a.a(r10, u());
    L31:
        Object r16 = r15;
    L33:
        Object r17 = ZeusTransformUtils.preCheckCast(r16, d.class, "com.obric.memorydata.plugin");
    L45:
        r14 = (d) r17;
    L32:
        r16 = null;
        goto L33
    L26:
        if (r9.equals("aikernel-pkg") == false) goto L46;
        if (u().getUseAIKernelModel() == false) goto L32;
        r15 = new com.obric.aikernel.res.metadata.data.a.b(r10, u());
        goto L31
    L35:
        if (r9.equals("model") == false) goto L46;
        if (u().getUseAIKernelModel() == false) goto L39;
        Object r18 = new com.obric.aikernel.res.metadata.data.a.b(r10, u());
    L44:
        r17 = ZeusTransformUtils.preCheckCast(r18, d.class, "com.obric.memorydata.plugin");
        goto L45
    L39:
        r18 = new com.obric.aikernel.res.metadata.data.a(r10, r11, u());
        goto L44
    L41:
        if (r9.equals("lib") == false) goto L46;
        r18 = new i(r10, r11, u());
        goto L44
    L54:
        Unit r6 = Unit.INSTANCE;
        if (r8 == false) goto L57;
        com.obric.aikernel.runtime.utils.d.f6216a.f(PackageResourceManager.TAG, this + " has empty depend name! ignore loaded dep res.");
    L59:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L62;
        r2 = null;
    L62:
        if (r2 == null) goto L64;
        this.h = r2;
    L64:
        this.i = r8;
        return;
    L57:
        this.g = r1;
        goto L59
    }

    public static final /* synthetic */ Lazy r() {
        return k;
    }

    @Override // com.obric.aikernel.res.metadata.data.d
    public void a() {
        super.a();
        O();
        com.obric.aikernel.res.metadata.config.a r0 = J();
        if (r0 == null) goto L10;
        JsonObject r1 = r0.b();
        if (r1 == null) goto L11;
        String r2 = com.obric.aikernel.res.metadata.config.b.a(r1, "dep_version");
        if (r2 == null) goto L12;
        a(r2);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void a(long r1) {
        this.j.set(r1);
    }

    @Override // com.obric.aikernel.res.metadata.data.d
    public final void a(PrmContext r25) {
        Intrinsics.checkNotNullParameter(r25, "ctx");
        super.a(r25);
        List<? extends d> r14 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        List<? extends com.obric.aikernel.res.metadata.data.a.d> r15 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        com.obric.aikernel.res.metadata.config.a r0 = J();
        Intrinsics.checkNotNull(r0);
        JsonObject r11 = r0.b();
        JsonObject r1 = r11.getAsJsonObject("dependency");
        boolean r9 = true;
        if (r1 == null) goto L29;
        JsonObject r4 = r1.getAsJsonObject("bridge");
        if (r4 == null) goto L11;
        JsonElement r5 = r4.get("version");
        if (r5 == null) goto L11;
        String r6 = r5.getAsString();
        if (r6 == null) goto L11;
        Intrinsics.checkNotNullExpressionValue(r6, "asString");
        r14.add(new i("bridge", r6, u()));
    L11:
        JsonObject r3 = r1.getAsJsonObject("libs");
        if (r3 == null) goto L19;
        Map<String, JsonElement> r7 = r3.asMap();
        if (r7 == null) goto L19;
        Intrinsics.checkNotNullExpressionValue(r7, "asMap()");
        Iterator<Map.Entry<String, JsonElement>> r8 = r7.entrySet().iterator();
    L17:
        if (r8.hasNext() == false) goto L19;
        Map.Entry r10 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r12 = (String) ZeusTransformUtils.preCheckCast(r10.getKey(), String.class, "com.obric.memorydata.plugin");
        JsonElement r13 = (JsonElement) ZeusTransformUtils.preCheckCast(r10.getValue(), JsonElement.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r12, ActivityLifecycle.NAME);
        String r16 = r13.getAsJsonObject().get("version").getAsString();
        Intrinsics.checkNotNullExpressionValue(r16, "configs.asJsonObject.get(\"version\").asString");
        r14.add(new i(r12, r16, u()));
    L19:
        JsonArray r2 = r1.getAsJsonArray("model_center_name");
        if (r2 == null) goto L29;
        Intrinsics.checkNotNullExpressionValue(r2, "getAsJsonArray(\"model_center_name\")");
        Iterator r17 = ((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L23:
        if (r17.hasNext() == false) goto L29;
        String r18 = ((JsonElement) ZeusTransformUtils.preCheckCast(r17.next(), JsonElement.class, "com.obric.memorydata.plugin")).getAsString();
        Intrinsics.checkNotNullExpressionValue(r18, "it.asString");
        List r19 = StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r18, CharSequence.class, "com.obric.memorydata.plugin"), new String[]{"@"}, false, 0, 6, null);
        String r20 = (String) ZeusTransformUtils.preCheckCast(r19.get(0), String.class, "com.obric.memorydata.plugin");
        String r21 = (String) ZeusTransformUtils.preCheckCast(r19.get(1), String.class, "com.obric.memorydata.plugin");
        if (u().getUseAIKernelModel() == true) goto L26;
        r14.add(new com.obric.aikernel.res.metadata.data.a(r20, r21, u()));
        goto L23
    L26:
        r15.add(new com.obric.aikernel.res.metadata.data.a.b(r20 + '_' + r21, u()));
    L29:
        if (r11.has(WsConstants.KEY_EXTRA) == false) goto L53;
        if (u().getUseAIKernelModel() == false) goto L53;
        JsonArray r22 = r11.getAsJsonObject(WsConstants.KEY_EXTRA).getAsJsonArray("dependent_model_packages");
        if (r22 == null) goto L42;
        Iterator r23 = ((Iterable) ZeusTransformUtils.preCheckCast(r22, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L36:
        if (r23.hasNext() == false) goto L42;
        String r24 = ((JsonElement) ZeusTransformUtils.preCheckCast(r23.next(), JsonElement.class, "com.obric.memorydata.plugin")).getAsString();
        Intrinsics.checkNotNullExpressionValue(r24, "it.asString");
        com.obric.aikernel.res.metadata.data.a.b r26 = new com.obric.aikernel.res.metadata.data.a.b(r24, u());
        if (r26.d() == false) goto L41;
        r15.add(r26);
        goto L36
    L41:
        throw new IllegalStateException("check dependent aikernel model " + r26 + " not avail!");
    L42:
        JsonArray r27 = r11.getAsJsonObject(WsConstants.KEY_EXTRA).getAsJsonArray("dependent_lora_packages");
        if (r27 == null) goto L53;
        Iterator r28 = ((Iterable) ZeusTransformUtils.preCheckCast(r27, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L46:
        if (r28.hasNext() == false) goto L53;
        String r29 = ((JsonElement) ZeusTransformUtils.preCheckCast(r28.next(), JsonElement.class, "com.obric.memorydata.plugin")).getAsString();
        Intrinsics.checkNotNullExpressionValue(r29, "it.asString");
        com.obric.aikernel.res.metadata.data.a.a r30 = new com.obric.aikernel.res.metadata.data.a.a(r29, u());
        if (r30.d() == false) goto L51;
        r15.add(r30);
        goto L46
    L51:
        throw new IllegalStateException("check dependent aikernel model " + r30 + " not avail!");
    L53:
        if (this.f6087b.exists() == true) goto L55;
        this.f6087b.mkdirs();
    L55:
        List r31 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r110 = ((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L56:
        Boolean r111 = null;
        if (r110.hasNext() == false) goto L86;
        final d r32 = (d) ZeusTransformUtils.preCheckCast(r110.next(), d.class, "com.obric.memorydata.plugin");
        String r33 = r32.getType();
        if (Intrinsics.areEqual(r33, "package") == true) goto L85;
        Result.Companion r34 = Result.Companion;     // Catch: Throwable -> L69
        d r210 = r32;
        List r211 = r31;
        boolean r112 = true;
        JsonObject r113 = r11;
        Object r35 = Result.m1421constructorimpl(Boolean.valueOf(PrmContext.install$default(r25, r33, r32.s(), r32.t(), null, false, false, (Function1) ZeusTransformUtils.preCheckCast(new AIPackage$install$4$1$1$1(r32), Function1.class, "com.obric.memorydata.plugin"), 56, null)));     // Catch: Throwable -> L65
    L73:
        if (Result.m1427isFailureimpl(r35) == false) goto L75;
        r35 = null;
    L75:
        Boolean r36 = (Boolean) ZeusTransformUtils.preCheckCast(r35, Boolean.class, "com.obric.memorydata.plugin");
        if (r36 != null) goto L78;
    L82:
        d r37 = r210;
    L83:
        List r38 = r211;
        r38.add(r37);
        r31 = r38;
        r11 = r113;
        r9 = r112;
        goto L56
    L78:
        if ((!r36.booleanValue()) == false) goto L80;
        r111 = r36;
    L80:
        if (r111 == null) goto L82;
        r111.booleanValue();
        r37 = r210;
        com.obric.aikernel.runtime.utils.d.f6216a.f("AIPackage", "install " + this + " check dependence " + r37 + " is not valid!");
    L65:
        th = th;
    L71:
        Result.Companion r39 = Result.Companion;
        r35 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L67:
        th = th;
        r210 = r32;
        r211 = r31;
        r113 = r11;
        r112 = true;
    L69:
        th = th;
        r210 = r32;
        r211 = r31;
        r112 = r9;
        r113 = r11;
        goto L71
    L85:
        throw new IllegalStateException("Not allow pkg as dependence!");
    L86:
        List r40 = r31;
        boolean r114 = r9;
        JsonObject r115 = r11;
        r40.addAll((Collection) ZeusTransformUtils.preCheckCast(r14, Collection.class, "com.obric.memorydata.plugin"));
        r40.addAll((Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.memorydata.plugin"));
        Iterator r41 = ((Iterable) ZeusTransformUtils.preCheckCast(r40, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L88:
        if (r41.hasNext() == false) goto L98;
        d r42 = (d) ZeusTransformUtils.preCheckCast(r41.next(), d.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r42.s(), CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L96;
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r42.t(), CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L96;
        File r43 = new File(this.f6087b, r42.getType() + '@' + r42.s() + '@' + r42.t());
        if (r43.exists() == true) goto L88;
        r43.createNewFile();
    L96:
        this.c.delete();
        z().delete();
        K();
        FilesKt.deleteRecursively(this.f6087b);
        L();
        throw new IllegalStateException(this + " config is broken, dep tag is empty. Src: " + r115);
    L98:
        this.g = r14;
        this.h = r15;
        this.i = false;
        Set r44 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        Iterable r45 = (Iterable) ZeusTransformUtils.preCheckCast(this.g, Iterable.class, "com.obric.memorydata.plugin");
        Collection r46 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r45, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r47 = r45.iterator();
    L100:
        if (r47.hasNext() == false) goto L102;
        d r48 = (d) ZeusTransformUtils.preCheckCast(r47.next(), d.class, "com.obric.memorydata.plugin");
        r46.add(r48.getType() + '@' + r48.s() + '@' + r48.t());
        goto L100
    L102:
        r44.addAll((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r46, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin"));
        Iterable r49 = (Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin");
        Collection r50 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r49, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r51 = r49.iterator();
    L104:
        if (r51.hasNext() == false) goto L106;
        com.obric.aikernel.res.metadata.data.a.d r52 = (com.obric.aikernel.res.metadata.data.a.d) ZeusTransformUtils.preCheckCast(r51.next(), com.obric.aikernel.res.metadata.data.a.d.class, "com.obric.memorydata.plugin");
        r50.add(r52.getType() + '@' + r52.s() + '@' + r52.t());
        goto L104
    L106:
        r44.addAll((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r50, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin"));
        String[] r53 = this.f6087b.list();
        if (r53 == null) goto L118;
        Collection r54 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        int r55 = r53.length;
        int r116 = 0;
    L109:
        if (r116 >= r55) goto L114;
        String r56 = r53[r116];
        if ((!r44.contains(r56)) == false) goto L113;
        r54.add(r56);
    L113:
        r116 = r116 + 1;
        goto L109
    L114:
        Iterator r57 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r54, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L116:
        if (r57.hasNext() == false) goto L118;
        new File(this.f6087b, (String) ZeusTransformUtils.preCheckCast(r57.next(), String.class, "com.obric.memorydata.plugin")).delete();
    L118:
        Map<String, Set<String>> r58 = u().getPresetLibraries();
        if (r58 != null) goto L121;
        return;
    L121:
        if ((!r58.isEmpty()) == true) goto L124;
        r58 = null;
    L124:
        if (r58 == null) goto L178;
        Iterator r59 = ((Iterable) ZeusTransformUtils.preCheckCast(this.g, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L127:
        if (r59.hasNext() == false) goto L179;
        d r60 = (d) ZeusTransformUtils.preCheckCast(r59.next(), d.class, "com.obric.memorydata.plugin");
        Set r61 = (Set) ZeusTransformUtils.preCheckCast(r58.get(r60.s()), Set.class, "com.obric.memorydata.plugin");
        if (r61 != null) goto L131;
    L133:
        boolean r117 = false;
    L134:
        if (r117 == false) goto L127;
        m();
        throw new IllegalStateException("uninstall " + this + " depends on preset lib " + r60 + " not in preset list. " + u().getPresetLibraries());
    L131:
        if (r61.contains(r60.t()) == true) goto L133;
        r117 = r114;
        goto L134
    L179:
        return;
    }

    public final void a(List<? extends d> r3) {
        List<? extends d> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "subs");
        this.g = r4;
    }

    public final boolean a(JsonObject r10) {
        Intrinsics.checkNotNullParameter(r10, "config");
        com.obric.aikernel.res.metadata.config.a r0 = J();
        String r2 = "";
        if (r0 == null) goto L8;
        JsonObject r3 = r0.b();
        if (r3 == null) goto L8;
        String r4 = com.obric.aikernel.res.metadata.config.b.b(r3, "preset_base_origin_version");
        if (r4 == null) goto L8;
    L9:
        String r1 = com.obric.aikernel.res.metadata.config.b.b(r10, "preset_base_origin_version");
        if (r1 != null) goto L13;
        r1 = "";
    L13:
        if (r0 == null) goto L18;
        JsonObject r5 = r0.b();
        if (r5 == null) goto L18;
        String r6 = com.obric.aikernel.res.metadata.config.b.b(r5, "preset_base_dist_from");
        if (r6 == null) goto L18;
    L19:
        String r11 = com.obric.aikernel.res.metadata.config.b.b(r10, "preset_base_dist_from");
        if (r11 == null) goto L24;
        r2 = r11;
    L24:
        if (Intrinsics.areEqual(r6, r2) == true) goto L28;
        com.obric.aikernel.runtime.utils.d r12 = com.obric.aikernel.runtime.utils.d.f6216a;
        StringBuilder r9 = new StringBuilder().append("shouldUpdate ").append(this).append(" by distSrc:(").append(r6).append("->").append(r2);
    L26:
        r12.e("AIPackage", r9.append(')').toString());
        return true;
    L28:
        if (Intrinsics.areEqual(r4, r1) == true) goto L30;
        r12 = com.obric.aikernel.runtime.utils.d.f6216a;
        r9 = new StringBuilder().append("shouldUpdate ").append(this).append(" by originVersion:(").append(r4).append("->").append(r1);
        goto L26
    L30:
        return false;
    L18:
        r6 = "";
    L8:
        r4 = "";
        goto L9
    }

    @Override // com.obric.aikernel.res.metadata.data.d
    public boolean a_(boolean r5) {
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(this.g, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        if (((d) ZeusTransformUtils.preCheckCast(r0.next(), d.class, "com.obric.memorydata.plugin")).a_(r5) == false) goto L4;
        return true;
    L10:
        return super.a_(r5);
    }

    @Override // com.obric.aikernel.res.metadata.data.d
    public void b(long r4) {
        long r5 = this.j.getAndSet(0);
        if (r5 == 0) goto L8;
        super.b(r5);
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(this.g, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L6:
        if (r3.hasNext() == false) goto L10;
        ((d) ZeusTransformUtils.preCheckCast(r3.next(), d.class, "com.obric.memorydata.plugin")).b(r5);
        goto L6
    L10:
        return;
    }

    @Override // com.obric.aikernel.res.metadata.data.d
    public boolean d() {
        return this.c.exists();
    }

    @Override // com.obric.aikernel.res.metadata.data.d
    public boolean f() {
        return c.a(super.f(), this.f6087b.exists(), this.i);
    }

    public final String g() {
        return (String) ZeusTransformUtils.preCheckCast(this.f6086a.getValue(), String.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.aikernel.res.metadata.data.d
    public String getType() {
        return "package";
    }

    @Override // com.obric.aikernel.res.metadata.data.d
    public String h() {
        return "pkgs";
    }

    public final boolean j() {
        return ((Boolean) ZeusTransformUtils.preCheckCast(this.d.getValue(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    public final boolean k() {
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(this.g, Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r1.add(Boolean.valueOf(((d) ZeusTransformUtils.preCheckCast(r2.next(), d.class, "com.obric.memorydata.plugin")).d()));
        goto L4
    L6:
        List r3 = (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin");
        if (c.a(c.a(super.f(), this.f6087b.exists(), this.i), this.i, (Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.memorydata.plugin")) == true) goto L22;
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.zip((Iterable) ZeusTransformUtils.preCheckCast(this.g, Iterable.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L10:
        if (r4.hasNext() == false) goto L14;
        Object r5 = r4.next();
        if ((!((Boolean) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r5, Pair.class, "com.obric.memorydata.plugin")).getSecond(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue()) == false) goto L10;
    L15:
        Pair r6 = (Pair) ZeusTransformUtils.preCheckCast(r5, Pair.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L27;
        d r7 = (d) ZeusTransformUtils.preCheckCast(r6.getFirst(), d.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L28;
        com.obric.aikernel.runtime.utils.d.f6216a.a("AIPackage", s() + '@' + t() + " subRes " + r7.s() + '@' + r7.t() + " is not avail, ready:" + r7.f() + ", avail: " + r7.e());
        return false;
    L28:
        return false;
    L27:
        return false;
    L14:
        r5 = null;
        goto L15
    L22:
        return true;
    }

    @Override // com.obric.aikernel.res.metadata.data.d
    public boolean m() {
        boolean r0 = super.m();
        O();
        return r0;
    }

    @Override // com.obric.aikernel.res.metadata.data.d
    public boolean n() {
        boolean r0 = super.n();
        O();
        return r0;
    }

    @Override // com.obric.aikernel.res.metadata.data.d
    public boolean o() {
        if (j() == true) goto L5;
    L8:
        boolean r0 = super.o();
        O();
        return r0;
    L5:
        if (G() == true) goto L8;
        return false;
    }

    public final List<d> p() {
        return this.g;
    }

    public final List<com.obric.aikernel.res.metadata.data.a.d> q() {
        return this.h;
    }
}
