package com.obric.aikernel.res.update;

import android.os.Build;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.ies.common.cpp_shared.BuildConfig;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.obric.aikernel.res.PackageResourceManager;
import com.obric.aikernel.res.PrmContext;
import com.obric.capabilitykit.common.Ext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.Grouping;
import kotlin.collections.GroupingKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 F2\u00020\u0001:\u0004FGHIB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J-\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00110\u0010H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0012J\u0011\u0010\u0013\u001a\u00020\nH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J\u0011\u0010\u0015\u001a\u00020\nH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J$\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0017H\u0002J\u001f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00170\u001c2\u0006\u0010\u001d\u001a\u00020\fH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ\u001f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00170\u001c2\u0006\u0010\u001d\u001a\u00020\fH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ\u0016\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00170\u001c2\u0006\u0010\u001d\u001a\u00020\fH\u0002JF\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020\f2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&2\u001e\u0010(\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020*0)0)H\u0002J\u001f\u0010+\u001a\b\u0012\u0004\u0012\u00020'0\u001c2\u0006\u0010,\u001a\u00020\fH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ\u0016\u0010-\u001a\b\u0012\u0004\u0012\u00020.0\u001c2\u0006\u0010/\u001a\u00020\fH\u0002J+\u00100\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u0002010\u001c0\u00102\u0006\u00102\u001a\u00020\fH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJG\u00103\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u001c0\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u00104\u001a\u000205H\u0086@ø\u0001\u0000¢\u0006\u0002\u00106J;\u00107\u001a\b\u0012\u0004\u0012\u00020\u00170\u001c2\u0006\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u00104\u001a\u000205H\u0082@ø\u0001\u0000¢\u0006\u0002\u00106J7\u00108\u001a\u0002092\u0006\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u00104\u001a\u000205H\u0080@ø\u0001\u0000¢\u0006\u0004\b:\u00106J$\u0010;\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0017H\u0002J\u001a\u0010<\u001a\b\u0012\u0004\u0012\u00020\n0=*\u00020\f2\u0006\u0010>\u001a\u00020\nH\u0002J\u001e\u0010?\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f0@0\u001c*\u00020AH\u0002J\u000e\u0010B\u001a\u00020\u000e*\u0004\u0018\u00010\u0017H\u0002J\f\u0010C\u001a\u00020\n*\u00020AH\u0002J2\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00170\u001c*\b\u0012\u0004\u0012\u00020\u00170\u001c2\u0018\u0010E\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0=0\u0010H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006J"}, d2 = {"Lcom/obric/aikernel/res/update/MetadataRequest;", "", "context", "Lcom/obric/aikernel/res/PrmContext;", "(Lcom/obric/aikernel/res/PrmContext;)V", "config", "Lcom/obric/aikernel/res/PackageResourceManager$PresmConfig;", "gson", "Lcom/google/gson/Gson;", "osVersion", "", "buildRequestBody", "Lcom/google/gson/JsonObject;", "updateAll", "", "bizMap", "", "Lcom/obric/aikernel/res/update/MetadataRequest$IPackageInfo;", "(ZLjava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buildRequestUrl", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDid", "getLocalConfig", "Lcom/obric/aikernel/res/metadata/config/UpdateTaskConfig;", "type", ActivityLifecycle.NAME, "remoteConfig", "parseBusinessDistribute", "", "data", "(Lcom/google/gson/JsonObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "parseDistributeResponse", "parseLoraDistribute", "parsePackageInfo", "", "biz", "bizData", "configs", "", "Lcom/obric/aikernel/res/metadata/config/PackageConfig;", "nativeLibraries", "", "Lcom/obric/aikernel/res/metadata/config/LibConfig;", "processBusinesses", "businesses", "processLoras", "Lcom/obric/aikernel/res/metadata/config/LoraConfig;", "loras", "pushDebugDistributeInfo", "Lcom/obric/aikernel/res/metadata/config/DistConfig;", "body", Ext.KEY_REQUEST, "adapter", "Lcom/obric/aikernel/res/legacy/Adapter;", "(ZLjava/util/Map;Lcom/obric/aikernel/res/legacy/Adapter;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestInner", "requestOutcome", "Lcom/obric/aikernel/res/update/MetadataRequestOutcome;", "requestOutcome$resource_manager_release", "resolveConfigWithLocalFallback", "getDistributeConfigNames", "", "key", "getPendingDecryptFiles", "Lkotlin/Pair;", "Lcom/obric/aikernel/res/metadata/config/ModelConfig;", "hasResolvedResources", "modelVersionName", "resolveConfigsWithLocalFallback", "remoteConfigNames", "Companion", "IPackageInfo", "RequestPackageInfo", "ValidPackageInfo", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6120a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PrmContext f6121b;
    private final PackageResourceManager.PresmConfig c;
    private final String d;
    private final Gson e;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/aikernel/res/update/MetadataRequest$Companion;", "", "()V", "TAG", "", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/obric/aikernel/res/update/MetadataRequest$IPackageInfo;", "", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface b {
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/obric/aikernel/res/update/MetadataRequest$RequestPackageInfo;", "Lcom/obric/aikernel/res/update/MetadataRequest$IPackageInfo;", "version", "", "depVersion", "(Ljava/lang/String;Ljava/lang/String;)V", "getDepVersion", "()Ljava/lang/String;", "getVersion", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class c implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("version")
        private final String f6122a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName("dep_version")
        private final String f6123b;

        /* JADX WARN: Multi-variable type inference failed */
        public c() {
            Object[] r0 = 0 == true ? 1 : 0;
            this(null, r0, 3, 0 == true ? 1 : 0);
        }

        public c(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "version");
            Intrinsics.checkNotNullParameter(r3, "depVersion");
            this.f6122a = r2;
            this.f6123b = r3;
        }

        public /* synthetic */ c(String r2, String r3, int r4, DefaultConstructorMarker r5) {
            if ((r4 & 1) == 0) goto L6;
            r2 = "0";
        L6:
            if ((r4 & 2) == 0) goto L8;
            r3 = "0";
        L8:
            this(r2, r3);
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.res.update.d$d, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/obric/aikernel/res/update/MetadataRequest$ValidPackageInfo;", "Lcom/obric/aikernel/res/update/MetadataRequest$IPackageInfo;", "version", "", "depVersion", "(Ljava/lang/String;Ljava/lang/String;)V", "getDepVersion", "()Ljava/lang/String;", "getVersion", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class C0271d implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("version")
        private final String f6124a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName("dep_version")
        private final String f6125b;

        public C0271d(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "version");
            Intrinsics.checkNotNullParameter(r3, "depVersion");
            this.f6124a = r2;
            this.f6125b = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0001J\u0015\u0010\u0002\u001a\u00028\u00012\u0006\u0010\u0003\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0016¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlin/collections/CollectionsKt___CollectionsKt$groupingBy$1", "Lkotlin/collections/Grouping;", "keyOf", "element", "(Ljava/lang/Object;)Ljava/lang/Object;", "sourceIterator", "", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class e implements Grouping<com.obric.aikernel.res.metadata.config.k, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Iterable f6126a;

        public e(Iterable r3) {
            this.f6126a = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.collections.Grouping
        public String keyOf(com.obric.aikernel.res.metadata.config.k r2) {
            return ((com.obric.aikernel.res.metadata.config.k) ZeusTransformUtils.preCheckCast(r2, com.obric.aikernel.res.metadata.config.k.class, "com.obric.memorydata.plugin")).getType();
        }

        @Override // kotlin.collections.Grouping
        public Iterator<com.obric.aikernel.res.metadata.config.k> sourceIterator() {
            return this.f6126a.iterator();
        }
    }

    static {
        f6120a = new a(null);
    }

    public d(PrmContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.f6121b = r2;
        this.c = r2.getConfig();
        this.d = String.valueOf(Build.VERSION.SDK_INT);
        this.e = new Gson();
    }

    private final com.obric.aikernel.res.metadata.config.k a(String r3, String r4, com.obric.aikernel.res.metadata.config.k r5) {
        if (a(r5) == false) goto L5;
        com.obric.aikernel.res.metadata.config.k r0 = r5;
    L6:
        if (r0 == null) goto L8;
        return r0;
    L8:
        com.obric.aikernel.res.metadata.config.k r6 = b(r3, r4, r5);
        if (r6 != null) goto L11;
        return null;
    L11:
        if (a(r6) == true) goto L14;
        r6 = null;
    L14:
        if (r6 == null) goto L18;
        com.obric.aikernel.runtime.utils.d.f6216a.b("MetadataRequest", r3 + ':' + r4 + " use local config " + r6.c() + " for distribute res");
        return r6;
    L18:
        return null;
    L5:
        r0 = null;
        goto L6
    }

    public static final /* synthetic */ Object a(d r2, JsonObject r3, Continuation r4) {
        return r2.b(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ Object a(d r2, Continuation r3) {
        return r2.a((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ Object a(d r2, boolean r3, Map r4, com.obric.aikernel.res.legacy.a r5, Continuation r6) {
        return r2.c(r3, (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin"), r5, (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ Object a(d r2, boolean r3, Map r4, Continuation r5) {
        return r2.a(r3, (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin"));
    }

    private final Object a(Continuation<? super String> r9) {
        Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r10, MetadataRequest$buildRequestUrl$1.class) == false) goto L7;
        MetadataRequest$buildRequestUrl$1 r0 = (MetadataRequest$buildRequestUrl$1) ZeusTransformUtils.preCheckCast(r10, MetadataRequest$buildRequestUrl$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        StringBuilder r8 = (StringBuilder) ZeusTransformUtils.preCheckCast(r0.L$1, StringBuilder.class, "com.obric.memorydata.plugin");
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.L$0, String.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r11);
    L18:
        StringBuilder r12 = r8.append((String) ZeusTransformUtils.preCheckCast(r11, String.class, "com.obric.memorydata.plugin")).append("&mem_size=").append(com.obric.aikernel.res.utils.b.f6158a.b());
        if (r1 == null) goto L22;
        String r13 = "&soc_model=" + r1;
        if (r13 == null) goto L22;
    L24:
        return r12.append(r13).toString();
    L22:
        r13 = "";
        goto L24
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r11);
        String r14 = this.c.getAppConfig().getAid();
        String r4 = this.c.getAppConfig().getSoc();
        StringBuilder r15 = new StringBuilder().append(this.c.getAppConfig().getUrl()).append("?aid=").append(r14).append("&device_id=");
        r0.L$0 = r4;
        r0.L$1 = r15;
        r0.label = 1;
        Object r16 = b(r0);
        if (r16 != r2) goto L17;
        return r2;
    L17:
        r1 = r4;
        r11 = r16;
        r8 = r15;
    L7:
        r0 = new MetadataRequest$buildRequestUrl$1(this, r10);
        goto L8
    }

    private final Object a(boolean r10, Map<String, ? extends b> r11, Continuation<? super JsonObject> r12) {
        Map r13 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.memorydata.plugin");
        Continuation r14 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r12, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r14, MetadataRequest$buildRequestBody$1.class) == false) goto L7;
        MetadataRequest$buildRequestBody$1 r0 = (MetadataRequest$buildRequestBody$1) ZeusTransformUtils.preCheckCast(r14, MetadataRequest$buildRequestBody$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r15 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        String r9 = (String) ZeusTransformUtils.preCheckCast(r0.L$3, String.class, "com.obric.memorydata.plugin");
        JsonObject r16 = (JsonObject) ZeusTransformUtils.preCheckCast(r0.L$2, JsonObject.class, "com.obric.memorydata.plugin");
        JsonObject r17 = (JsonObject) ZeusTransformUtils.preCheckCast(r0.L$1, JsonObject.class, "com.obric.memorydata.plugin");
        d r1 = (d) ZeusTransformUtils.preCheckCast(r0.L$0, d.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r15);
    L33:
        r16.addProperty(r9, (String) ZeusTransformUtils.preCheckCast(r15, String.class, "com.obric.memorydata.plugin"));
        r17.addProperty("app_version", r1.c.getAppConfig().getAppVersion());
        r17.addProperty("uid", r1.c.getAppConfig().getUserId());
        r17.addProperty("channel", r1.c.getAppConfig().getChannel());
        r17.addProperty("device", Build.MODEL);
        r17.addProperty("product_device", Build.DEVICE);
        String r18 = r1.c.getAppConfig().getRegion();
        if (r18 == null) goto L36;
        r17.addProperty("o_region", r18);
    L36:
        r17.addProperty("os_version", r1.d);
        r17.addProperty("mem_size", com.obric.aikernel.res.utils.b.f6158a.b());
        r17.addProperty("project_id", r1.c.getAppConfig().getProjectId());
        r17.addProperty("sem_app_version", r1.c.getAppConfig().getSemAppVersion());
        r17.addProperty(WsConstants.KEY_PLATFORM, "android");
        r17.addProperty("sdk_version", "4.0.0");
        r17.addProperty("feature_engineering_version", BuildConfig.VERSION_NAME);
        JsonObject r19 = (JsonObject) ZeusTransformUtils.preCheckCast(new Gson().fromJson("{\n    \"bridge\": \"4.0.0\",\n    \"foundation\": \"4.0.0\",\n    \"libs\": {\n      \"numpy\": \"2.0.0\"\n    },\n    \"vm\": \"" + r1.c.getPyVmVersion() + "\"\n  }", JsonObject.class), JsonObject.class, "com.obric.memorydata.plugin");
        JsonObject r110 = r19.getAsJsonObject("libs");
        Map<String, Set<String>> r111 = r1.c.getPresetLibraries();
        if (r111 == null) goto L42;
        Iterator<Map.Entry<String, Set<String>>> r112 = r111.entrySet().iterator();
    L40:
        if (r112.hasNext() == false) goto L42;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r112.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r110.addProperty((String) ZeusTransformUtils.preCheckCast(r4.getKey(), String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(CollectionsKt.first((Iterable) ZeusTransformUtils.preCheckCast(r4.getValue(), Iterable.class, "com.obric.memorydata.plugin")), String.class, "com.obric.memorydata.plugin"));
    L42:
        r17.add("py", (JsonElement) ZeusTransformUtils.preCheckCast(r19, JsonElement.class, "com.obric.memorydata.plugin"));
        r17.add("native", (JsonElement) ZeusTransformUtils.preCheckCast(new Gson().fromJson("{\n\"operation\": \"1.0.0\"\n}", JsonObject.class), JsonElement.class, "com.obric.memorydata.plugin"));
        return r17;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        JsonObject r113 = new JsonObject();
        if (r10 == false) goto L17;
        String r114 = LocationAnnotation.LightLocationType.LIGHT_LOCATION_ALL;
    L18:
        r113.addProperty(com.obric.memorydata.BuildConfig.CHANNEL, r114);
        if ((!r13.isEmpty()) == false) goto L29;
        JsonObject r115 = new JsonObject();
        Iterator r116 = r13.entrySet().iterator();
    L22:
        if (r116.hasNext() == false) goto L28;
        Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(r116.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r6 = (String) ZeusTransformUtils.preCheckCast(r5.getKey(), String.class, "com.obric.memorydata.plugin");
        b r7 = (b) ZeusTransformUtils.preCheckCast(r5.getValue(), b.class, "com.obric.memorydata.plugin");
        JsonObject r8 = new JsonObject();
        JsonElement r20 = this.e.toJsonTree(r7);
        if (ZeusTransformUtils.instanceOf(r7, C0271d.class) == false) goto L26;
        String r21 = "valid";
    L27:
        r8.add(r21, r20);
        Unit r22 = Unit.INSTANCE;
        r115.add(r6, (JsonElement) ZeusTransformUtils.preCheckCast(r8, JsonElement.class, "com.obric.memorydata.plugin"));
        goto L22
    L26:
        r21 = "expect";
        goto L27
    L28:
        Unit r117 = Unit.INSTANCE;
        r113.add("package", (JsonElement) ZeusTransformUtils.preCheckCast(r115, JsonElement.class, "com.obric.memorydata.plugin"));
    L29:
        r113.addProperty("aid", this.c.getAppConfig().getAid());
        r0.L$0 = this;
        r0.L$1 = r113;
        r0.L$2 = r113;
        r0.L$3 = "device_id";
        r0.label = 1;
        Object r118 = b(r0);
        if (r118 != r2) goto L32;
        return r2;
    L32:
        r1 = this;
        r9 = "device_id";
        r16 = r113;
        r15 = r118;
        r17 = r16;
        goto L33
    L17:
        r114 = "specific";
    L7:
        r0 = new MetadataRequest$buildRequestBody$1(this, r14);
        goto L8
    }

    private final String a(com.obric.aikernel.res.metadata.config.h r2) {
        return r2.a() + '@' + r2.c();
    }

    private final List<com.obric.aikernel.res.metadata.config.k> a(JsonObject r6) {
        JsonElement r7 = r6.get("lora");
        Set<String> r0 = null;
        if (r7 != null) goto L5;
    L12:
        if (r0 != null) goto L14;
        r0 = SetsKt.emptySet();
    L14:
        com.obric.aikernel.runtime.utils.d.f6216a.b("MetadataRequest", "parseLoraDistribute count=" + r0.size() + " names=" + r0);
        List<com.obric.aikernel.res.metadata.config.k> r1 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        boolean r2 = true;
        if (r7 != null) goto L17;
    L19:
        r2 = false;
    L20:
        if (r2 == false) goto L22;
        JsonObject r8 = r7.getAsJsonObject();
        Intrinsics.checkNotNullExpressionValue(r8, "loras.asJsonObject");
        r1.addAll((Collection) ZeusTransformUtils.preCheckCast(b(r8), Collection.class, "com.obric.memorydata.plugin"));
    L22:
        return r1;
    L17:
        if (r7.isJsonObject() != true) goto L19;
    L5:
        if (r7.isJsonObject() == false) goto L7;
        JsonElement r3 = r7;
    L8:
        if (r3 == null) goto L12;
        JsonObject r4 = r3.getAsJsonObject();
        if (r4 == null) goto L12;
        r0 = r4.keySet();
        goto L12
    L7:
        r3 = null;
        goto L8
    }

    public static final /* synthetic */ List a(d r0, JsonObject r1) {
        return r0.a(r1);
    }

    private final List<com.obric.aikernel.res.metadata.config.k> a(List<? extends com.obric.aikernel.res.metadata.config.k> r7, Map<String, ? extends Set<String>> r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.memorydata.plugin");
        Set r0 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        List<com.obric.aikernel.res.metadata.config.k> r2 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        com.obric.aikernel.res.metadata.config.k r3 = (com.obric.aikernel.res.metadata.config.k) ZeusTransformUtils.preCheckCast(r11.next(), com.obric.aikernel.res.metadata.config.k.class, "com.obric.memorydata.plugin");
        r0.add(TuplesKt.to(r3.getType(), r3.a()));
        com.obric.aikernel.res.metadata.config.k r4 = a(r3.getType(), r3.a(), r3);
        if (r4 == null) goto L4;
        r2.add(r4);
        goto L4
    L8:
        Iterator r12 = r10.entrySet().iterator();
    L10:
        if (r12.hasNext() == false) goto L19;
        Map.Entry r13 = (Map.Entry) ZeusTransformUtils.preCheckCast(r12.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r5 = (String) ZeusTransformUtils.preCheckCast(r13.getKey(), String.class, "com.obric.memorydata.plugin");
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast((Set) ZeusTransformUtils.preCheckCast(r13.getValue(), Set.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L13:
        if (r14.hasNext() == false) goto L10;
        String r6 = (String) ZeusTransformUtils.preCheckCast(r14.next(), String.class, "com.obric.memorydata.plugin");
        if (r0.contains(TuplesKt.to(r5, r6)) == true) goto L13;
        com.obric.aikernel.res.metadata.config.k r15 = a(r5, r6, null);
        if (r15 == null) goto L13;
        r2.add(r15);
        goto L13
    L19:
        return r2;
    }

    private final Set<String> a(JsonObject r2, String r3) {
        JsonElement r1 = r2.get(r3);
        boolean r4 = true;
        if (r1 != null) goto L5;
    L7:
        r4 = false;
    L8:
        if (r4 == false) goto L11;
        Set<String> r5 = r1.getAsJsonObject().keySet();
        Intrinsics.checkNotNullExpressionValue(r5, "{\n            configs.as…Object.keySet()\n        }");
        return r5;
    L11:
        return SetsKt.emptySet();
    L5:
        if (r1.isJsonObject() != true) goto L7;
        goto L7
    }

    private final void a(String r27, JsonObject r28, List<com.obric.aikernel.res.metadata.config.i> r29, Map<String, Map<String, com.obric.aikernel.res.metadata.config.d>> r30) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r29, List.class, "com.obric.memorydata.plugin");
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r30, Map.class, "com.obric.memorydata.plugin");
        List r6 = CollectionsKt.emptyList();
        JsonElement r7 = r28.get("delete");
        if (r7 != null) goto L5;
    L7:
        boolean r10 = false;
    L8:
        if (r10 == false) goto L14;
        JsonArray r8 = r7.getAsJsonArray();
        Intrinsics.checkNotNullExpressionValue(r8, "removePackage.asJsonArray");
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin");
        Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r12 = r9.iterator();
    L11:
        if (r12.hasNext() == false) goto L13;
        r11.add(((JsonElement) ZeusTransformUtils.preCheckCast(r12.next(), JsonElement.class, "com.obric.memorydata.plugin")).getAsString());
        goto L11
    L13:
        r6 = (List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.memorydata.plugin");
    L14:
        JsonElement r13 = r28.get("add");
        if (r13 == null) goto L21;
        JsonObject r14 = r13.getAsJsonObject();
        if (r14 == null) goto L21;
        JsonObject r15 = r14.getAsJsonObject("dependency");
        if (r15 == null) goto L21;
        String r16 = com.obric.aikernel.res.metadata.config.b.b(r15, "py_vm");
    L23:
        if (Intrinsics.areEqual(r16, this.c.getPyVmVersion()) == false) goto L98;
        JsonObject r17 = r13.getAsJsonObject();
        Intrinsics.checkNotNullExpressionValue(r17, "json");
        if (Intrinsics.areEqual(com.obric.aikernel.res.metadata.config.b.b(r17, "from"), "debug") == false) goto L27;
        JsonObject r18 = r17.getAsJsonObject("dependency").getAsJsonObject("handler");
        Intrinsics.checkNotNullExpressionValue(r18, "json.getAsJsonObject(\"de…etAsJsonObject(\"handler\")");
        r17.addProperty("version_debug", com.obric.aikernel.res.metadata.config.b.a(r18, "version"));
        r17.addProperty("version", "debug");
        boolean r19 = true;
    L28:
        com.obric.aikernel.res.metadata.config.i r110 = new com.obric.aikernel.res.metadata.config.i(r27, r17, this.c);
        Iterable r20 = (Iterable) ZeusTransformUtils.preCheckCast(r110.getResources(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r111 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r21 = r20.iterator();
    L30:
        if (r21.hasNext() == false) goto L40;
        Object r112 = r21.next();
        com.obric.aikernel.res.metadata.config.a r22 = (com.obric.aikernel.res.metadata.config.a) ZeusTransformUtils.preCheckCast(r112, com.obric.aikernel.res.metadata.config.a.class, "com.obric.memorydata.plugin");
        List r113 = r6;
        if (ZeusTransformUtils.instanceOf(r22, com.obric.aikernel.res.metadata.config.d.class) == true) goto L34;
    L36:
        boolean r23 = false;
    L37:
        if (r23 == false) goto L39;
        r111.add(r112);
    L39:
        r6 = r113;
        goto L30
    L34:
        if (((com.obric.aikernel.res.metadata.config.d) ZeusTransformUtils.preCheckCast(r22, com.obric.aikernel.res.metadata.config.d.class, "com.obric.memorydata.plugin")).f() == false) goto L36;
        r23 = true;
        goto L37
    L40:
        List r114 = r6;
        Iterator r24 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r111, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L42:
        if (r24.hasNext() == false) goto L68;
        com.obric.aikernel.res.metadata.config.a r25 = (com.obric.aikernel.res.metadata.config.a) ZeusTransformUtils.preCheckCast(r24.next(), com.obric.aikernel.res.metadata.config.a.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r25, com.obric.aikernel.res.metadata.config.d.class) == false) goto L46;
        com.obric.aikernel.res.metadata.config.d r115 = (com.obric.aikernel.res.metadata.config.d) ZeusTransformUtils.preCheckCast(r25, com.obric.aikernel.res.metadata.config.d.class, "com.obric.memorydata.plugin");
    L47:
        if (r115 == null) goto L66;
        Map<String, Set<String>> r116 = this.c.getPresetLibraries();
        if (r116 == null) goto L55;
        Set r26 = (Set) ZeusTransformUtils.preCheckCast(r116.get(r115.a()), Set.class, "com.obric.memorydata.plugin");
        if (r26 == null) goto L55;
        if (r26.contains(r115.c()) == true) goto L55;
        boolean r31 = true;
    L56:
        if (r31 == true) goto L57;
        if (r115.f() != true) goto L66;
        String r32 = r25.a();
        Object r117 = r5.get(r32);
        if (r117 != null) goto L65;
        r117 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        r5.put(r32, r117);
    L65:
        ((Map) ZeusTransformUtils.preCheckCast(r117, Map.class, "com.obric.memorydata.plugin")).put(r25.c(), r115);
    L67:
        r24 = r24;
        goto L42
    L57:
        com.obric.aikernel.runtime.utils.d.f6216a.f("MetadataRequest", "parsePackageInfo: ignore " + r27 + '@' + r110.c() + " depends on " + r115.a() + '@' + r115.c() + " not in preset config. " + this.c.getPresetLibraries());
        return;
    L55:
        r31 = false;
    L66:
        r24 = r24;
        goto L67
    L46:
        r115 = null;
        goto L47
    L68:
        com.obric.aikernel.res.metadata.data.d r33 = this.f6121b.getMetadataCtrl$resource_manager_release().b().a("package", r27).get(r110.c());
        if (ZeusTransformUtils.instanceOf(r33, com.obric.aikernel.res.metadata.data.b.class) == false) goto L71;
        final com.obric.aikernel.res.metadata.data.b r34 = (com.obric.aikernel.res.metadata.data.b) ZeusTransformUtils.preCheckCast(r33, com.obric.aikernel.res.metadata.data.b.class, "com.obric.memorydata.plugin");
    L72:
        if (r34 != null) goto L74;
    L96:
        com.obric.aikernel.res.metadata.data.b r35 = null;
    L97:
        d r36 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.memorydata.plugin");
        com.obric.aikernel.runtime.utils.d.f6216a.b("MetadataRequest", "Got new config " + r110.a() + '@' + r110.c() + '@' + r110.l());
        r3.add(r110);
        List r37 = CollectionsKt.emptyList();
    L99:
        Iterator r38 = ((Iterable) ZeusTransformUtils.preCheckCast(r37, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L101:
        if (r38.hasNext() == false) goto L104;
        String r39 = (String) ZeusTransformUtils.preCheckCast(r38.next(), String.class, "com.obric.memorydata.plugin");
        com.obric.aikernel.runtime.utils.d.f6216a.b("MetadataRequest", "delete pkg " + r27 + ' ' + r39);
        this.f6121b.getMetadataCtrl$resource_manager_release().c(r27, r39, false);
        goto L101
    L104:
        if (r19 == false) goto L106;
        return;
    L106:
        JsonElement r2 = r28.get("current");
        if (r2 != null) goto L109;
    L111:
        boolean r40 = false;
    L112:
        String r41 = "";
        if (r40 == false) goto L118;
        JsonObject r4 = r2.getAsJsonObject();
        Intrinsics.checkNotNullExpressionValue(r4, "it.asJsonObject");
        String r42 = com.obric.aikernel.res.metadata.config.b.b(r4, "version");
        if (r42 == null) goto L118;
        r41 = r42;
    L118:
        com.obric.aikernel.runtime.utils.d.f6216a.b("MetadataRequest", r27 + " current is " + r41);
        this.f6121b.getMetadataCtrl$resource_manager_release().a(r27, r41, true);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r41, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L121;
        boolean r43 = true;
    L122:
        if (r43 == false) goto L147;
        com.obric.aikernel.res.metadata.data.d r44 = this.f6121b.getMetadataCtrl$resource_manager_release().b().a("package", r27).get(r41);
        if (ZeusTransformUtils.instanceOf(r44, com.obric.aikernel.res.metadata.data.b.class) == false) goto L126;
        com.obric.aikernel.res.metadata.data.b r118 = (com.obric.aikernel.res.metadata.data.b) ZeusTransformUtils.preCheckCast(r44, com.obric.aikernel.res.metadata.data.b.class, "com.obric.memorydata.plugin");
    L127:
        if (r118 != null) goto L129;
    L131:
        boolean r45 = false;
    L132:
        if (r45 == false) goto L136;
        com.obric.aikernel.res.metadata.config.a r46 = r118.J();
        if (r46 == null) goto L148;
        r3.add(new com.obric.aikernel.res.metadata.config.i(r27, r46.b(), this.c));
        return;
    L148:
        return;
    L136:
        this.f6121b.getMetadataCtrl$resource_manager_release().a(r27, r41);
        return;
    L129:
        if (r118.F() != true) goto L131;
        r45 = true;
        goto L132
    L126:
        r118 = r35;
        goto L127
    L147:
        return;
    L121:
        r43 = false;
        goto L122
    L109:
        if (r2.isJsonObject() != true) goto L111;
        r40 = true;
        goto L112
    L74:
        if (r34.k() == true) goto L76;
    L80:
        boolean r47 = false;
    L81:
        if (r47 == true) goto L84;
        r34 = null;
    L84:
        if (r34 == null) goto L96;
        com.obric.aikernel.res.metadata.controller.a r119 = this.f6121b.getMetadataCtrl$resource_manager_release();
        String r120 = r34.s();
        String r121 = r34.t();
        com.obric.aikernel.res.metadata.config.a r48 = r34.J();
        if (r48 == null) goto L88;
        JsonObject r210 = r48.b();
    L89:
        com.obric.aikernel.res.metadata.controller.a.a(r119, r120, r121, r210, false, false, (Function1) ZeusTransformUtils.preCheckCast(new MetadataRequest$parsePackageInfo$5$1(r34), Function1.class, "com.obric.memorydata.plugin"), 24, null);
        if (r34.d() == false) goto L92;
        com.obric.aikernel.runtime.utils.d.f6216a.b("MetadataRequest", r34.s() + '@' + r34.t() + '@' + r34.v() + " is Avail.");
        r35 = null;
    L93:
        if (r34 == null) goto L97;
        r37 = r114;
        goto L99
    L92:
        com.obric.aikernel.runtime.utils.d.f6216a.b("MetadataRequest", r34.s() + '@' + r34.t() + '@' + r34.v() + " resourceAllReady " + r34.k() + '.');
        r35 = null;
        r34 = (com.obric.aikernel.res.metadata.data.b) ZeusTransformUtils.preCheckCast(null, com.obric.aikernel.res.metadata.data.b.class, "com.obric.memorydata.plugin");
        goto L93
    L88:
        r210 = null;
        goto L89
    L76:
        if (r34.a(r110.b()) == false) goto L80;
        if (r34.F() == true) goto L80;
        r47 = true;
        goto L81
    L71:
        r34 = null;
        goto L72
    L27:
        r19 = false;
        goto L28
    L98:
        List r122 = r6;
        r35 = null;
        r37 = r122;
        r19 = false;
    L21:
        r16 = null;
        goto L23
    L5:
        if (r7.isJsonArray() != true) goto L7;
        r10 = true;
        goto L8
    }

    private final boolean a(com.obric.aikernel.res.metadata.config.k r7) {
        if (r7 != null) goto L21;
        return false;
    L21:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L11
        if (((Collection) ZeusTransformUtils.preCheckCast(r7.m(), Collection.class, "com.obric.memorydata.plugin")).isEmpty() == true) goto L8;
        boolean r2 = true;
    L9:
        Object r3 = Result.m1421constructorimpl(Boolean.valueOf(r2));     // Catch: Throwable -> L11
    L13:
        Throwable r4 = Result.m1424exceptionOrNullimpl(r3);
        if (r4 == null) goto L17;
        com.obric.aikernel.runtime.utils.d.f6216a.c("MetadataRequest", r7.getType() + ':' + r7.a() + '@' + r7.c() + " resolve res failed: " + ExceptionsKt.stackTraceToString(r4));
    L17:
        if (Result.m1427isFailureimpl(r3) == false) goto L20;
        r3 = false;
    L20:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L8:
        r2 = false;
    L11:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r3 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    private final com.obric.aikernel.res.metadata.config.k b(String r6, String r7, com.obric.aikernel.res.metadata.config.k r8) {
        com.obric.aikernel.res.metadata.config.i r0 = null;
        if (r8 == null) goto L5;
        String r9 = r8.c();
    L6:
        if (r9 != null) goto L9;
        r9 = "";
    L9:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L11;
        boolean r1 = true;
    L13:
        if (r1 == true) goto L15;
        Object r10 = ZeusTransformUtils.preCheckCast(null, com.obric.aikernel.res.metadata.config.k.class, "com.obric.memorydata.plugin");
    L28:
        com.obric.aikernel.res.metadata.config.k r11 = (com.obric.aikernel.res.metadata.config.k) r10;
    L29:
        if (r11 != null) goto L42;
        com.obric.aikernel.res.metadata.config.k r12 = com.obric.aikernel.res.metadata.data.d.f.a(r6, r7, this.c);
        if (r12 == null) goto L33;
        return r12;
    L33:
        if (Intrinsics.areEqual(r6, "package") == false) goto L39;
        com.obric.aikernel.res.metadata.data.b r13 = this.f6121b.getMetadataCtrl$resource_manager_release().a(r7);
        if (r13 == null) goto L41;
        com.obric.aikernel.res.metadata.config.a r14 = r13.J();
        if (r14 == null) goto L41;
        r0 = new com.obric.aikernel.res.metadata.config.i(r7, r14.b(), this.c);
    L41:
        return (com.obric.aikernel.res.metadata.config.k) ZeusTransformUtils.preCheckCast(r0, com.obric.aikernel.res.metadata.config.k.class, "com.obric.memorydata.plugin");
    L39:
        r0 = (com.obric.aikernel.res.metadata.config.i) ZeusTransformUtils.preCheckCast(null, com.obric.aikernel.res.metadata.config.i.class, "com.obric.memorydata.plugin");
        goto L41
    L42:
        return r11;
    L15:
        if (Intrinsics.areEqual(r6, "package") == false) goto L22;
        com.obric.aikernel.res.metadata.config.a r15 = new com.obric.aikernel.res.metadata.data.b(r7, r9, this.c).J();
        if (r15 == null) goto L19;
        Object r2 = new com.obric.aikernel.res.metadata.config.i(r7, r15.b(), this.c);
    L20:
        r10 = ZeusTransformUtils.preCheckCast(r2, com.obric.aikernel.res.metadata.config.k.class, "com.obric.memorydata.plugin");
    L19:
        r2 = null;
        goto L20
    L22:
        if (Intrinsics.areEqual(r6, "lora") == false) goto L26;
        com.obric.aikernel.res.metadata.config.a r16 = new com.obric.aikernel.res.metadata.data.f(r7, r9, this.c).J();
        if (r16 == null) goto L19;
        r2 = new com.obric.aikernel.res.metadata.config.e(r7, r16.b());
        goto L20
    L26:
        r11 = null;
        goto L29
    L11:
        r1 = false;
        goto L13
    L5:
        r9 = null;
        goto L6
    }

    private final Object b(final JsonObject r14, Continuation<? super List<? extends com.obric.aikernel.res.metadata.config.k>> r15) {
        Continuation r16 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r15, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r16, MetadataRequest$parseDistributeResponse$1.class) == false) goto L7;
        MetadataRequest$parseDistributeResponse$1 r0 = (MetadataRequest$parseDistributeResponse$1) ZeusTransformUtils.preCheckCast(r16, MetadataRequest$parseDistributeResponse$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r17 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L20;
        if (r3 == 1) goto L19;
        if (r3 != 2) goto L18;
        List<? extends com.obric.aikernel.res.metadata.config.k> r13 = (List) ZeusTransformUtils.preCheckCast(r0.L$0, List.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r17);     // Catch: Throwable -> L15
    L38:
        Object r18 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L43:
        Throwable r19 = Result.m1424exceptionOrNullimpl(r18);
        if (r19 == null) goto L46;
        com.obric.aikernel.runtime.utils.d.f6216a.c("MetadataRequest", "updatePendingDecryptModels failed: " + ExceptionsKt.stackTraceToString(r19));
    L46:
        return r13;
    L15:
        th = th;
    L42:
        Result.Companion r110 = Result.Companion;
        r18 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L43
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        Set<String> r111 = (Set) ZeusTransformUtils.preCheckCast(r0.L$2, Set.class, "com.obric.memorydata.plugin");
        Set<String> r112 = (Set) ZeusTransformUtils.preCheckCast(r0.L$1, Set.class, "com.obric.memorydata.plugin");
        d r4 = (d) ZeusTransformUtils.preCheckCast(r0.L$0, d.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r17);
        Set<String> r5 = r111;
        final d this = r4;
    L24:
        List<? extends com.obric.aikernel.res.metadata.config.k> r113 = (List) ZeusTransformUtils.preCheckCast(r17, List.class, "com.obric.memorydata.plugin");
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L40
        List<com.obric.aikernel.res.metadata.config.k> r114 = this.a(r113, MapsKt.mapOf(new Pair[]{TuplesKt.to("package", r112), TuplesKt.to("lora", r5)}));     // Catch: Throwable -> L40
        Map<String, ? extends List<Pair<String, JsonObject>>> r6 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L40
        Iterator r115 = ((Iterable) ZeusTransformUtils.preCheckCast(r114, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L40
    L27:
        if (r115.hasNext() == false) goto L34;
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(((com.obric.aikernel.res.metadata.config.k) ZeusTransformUtils.preCheckCast(r115.next(), com.obric.aikernel.res.metadata.config.k.class, "com.obric.memorydata.plugin")).m(), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L40
    L30:
        if (r7.hasNext() == false) goto L27;
        com.obric.aikernel.res.metadata.config.a r9 = (com.obric.aikernel.res.metadata.config.a) ZeusTransformUtils.preCheckCast(r7.next(), com.obric.aikernel.res.metadata.config.a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L40
        if (ZeusTransformUtils.instanceOf(r9, com.obric.aikernel.res.metadata.config.h.class) == false) goto L30;
        r6.put(this.a((com.obric.aikernel.res.metadata.config.h) ZeusTransformUtils.preCheckCast(r9, com.obric.aikernel.res.metadata.config.h.class, "com.obric.memorydata.plugin")), this.b((com.obric.aikernel.res.metadata.config.h) ZeusTransformUtils.preCheckCast(r9, com.obric.aikernel.res.metadata.config.h.class, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L40
        goto L30
    L34:
        PackageResourceManager.PresmConfig.a r116 = this.c.getDecryptFeature();     // Catch: Throwable -> L40
        r0.L$0 = r113;     // Catch: Throwable -> L40
        r0.L$1 = null;     // Catch: Throwable -> L40
        r0.L$2 = null;     // Catch: Throwable -> L40
        r0.label = 2;     // Catch: Throwable -> L40
        if (r116.a(r6, r0) != r2) goto L37;
        return r2;
    L37:
        r13 = r113;
    L40:
        th = th;
        r13 = r113;
        goto L42
    L20:
        ResultKt.throwOnFailure(r17);
        Set<String> r117 = a(r14, "businesses");
        r5 = a(r14, "lora");
        Function1 r10 = (Function1) ZeusTransformUtils.preCheckCast(new MetadataRequest$parseDistributeResponse$dists$1(this, r14, null), Function1.class, "com.obric.memorydata.plugin");
        Function0 r118 = (Function0) ZeusTransformUtils.preCheckCast(new MetadataRequest$parseDistributeResponse$dists$2(this, r14), Function0.class, "com.obric.memorydata.plugin");
        Function1 r11 = (Function1) ZeusTransformUtils.preCheckCast(MetadataRequest$parseDistributeResponse$dists$3.INSTANCE, Function1.class, "com.obric.memorydata.plugin");
        Function1 r12 = (Function1) ZeusTransformUtils.preCheckCast(MetadataRequest$parseDistributeResponse$dists$4.INSTANCE, Function1.class, "com.obric.memorydata.plugin");
        r0.L$0 = this;
        r0.L$1 = r117;
        r0.L$2 = r5;
        r0.label = 1;
        Object r119 = com.obric.aikernel.res.update.e.a(r10, r118, r11, r12, r0);
        if (r119 != r2) goto L23;
        return r2;
    L23:
        r17 = r119;
        r112 = r117;
    L7:
        r0 = new MetadataRequest$parseDistributeResponse$1(this, r16);
        goto L8
    }

    public static final /* synthetic */ Object b(d r2, JsonObject r3, Continuation r4) {
        return r2.c(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ Object b(d r2, Continuation r3) {
        return r2.b((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    private final Object b(Continuation<? super String> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, MetadataRequest$getDid$1.class) == false) goto L7;
        MetadataRequest$getDid$1 r0 = (MetadataRequest$getDid$1) ZeusTransformUtils.preCheckCast(r7, MetadataRequest$getDid$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r8);
    L18:
        return (String) ZeusTransformUtils.preCheckCast(r8, String.class, "com.obric.memorydata.plugin");
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        Function1<Continuation<? super String>, Object> r5 = this.c.getAppConfig().getDid();
        r0.label = 1;
        r8 = r5.invoke(r0);
        if (r8 != r2) goto L18;
        return r2;
    L7:
        r0 = new MetadataRequest$getDid$1(this, r7);
        goto L8
    }

    private final List<com.obric.aikernel.res.metadata.config.e> b(JsonObject r8) {
        List<com.obric.aikernel.res.metadata.config.e> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Set<Map.Entry<String, JsonElement>> r9 = r8.entrySet();
        if (r9 == null) goto L18;
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L6:
        if (r10.hasNext() == false) goto L18;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r10.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L10
        Object r4 = r1.getKey();     // Catch: Throwable -> L10
        Intrinsics.checkNotNullExpressionValue(r4, "it.key");     // Catch: Throwable -> L10
        String r5 = (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        JsonObject r6 = ((JsonElement) ZeusTransformUtils.preCheckCast(r1.getValue(), JsonElement.class, "com.obric.memorydata.plugin")).getAsJsonObject();     // Catch: Throwable -> L10
        Intrinsics.checkNotNullExpressionValue(r6, "it.value.asJsonObject");     // Catch: Throwable -> L10
        com.obric.aikernel.res.metadata.config.e r7 = new com.obric.aikernel.res.metadata.config.e(r5, r6);     // Catch: Throwable -> L10
        com.obric.aikernel.runtime.utils.d.f6216a.b("MetadataRequest", "processLoras parsed " + r7.a() + '@' + r7.c() + " package=" + r7.h() + " minVersion=" + r7.g() + " autoDownload=" + r7.i() + " modelCount=" + r7.j().size());     // Catch: Throwable -> L10
        Object r11 = Result.m1421constructorimpl(r7);     // Catch: Throwable -> L10
    L13:
        if (Result.m1428isSuccessimpl(r11) == false) goto L15;
        r0.add((com.obric.aikernel.res.metadata.config.e) ZeusTransformUtils.preCheckCast(r11, com.obric.aikernel.res.metadata.config.e.class, "com.obric.memorydata.plugin"));
    L15:
        Throwable r12 = Result.m1424exceptionOrNullimpl(r11);
        if (r12 == null) goto L6;
        com.obric.aikernel.runtime.utils.d.f6216a.c("MetadataRequest", "processLoras ignore broken config " + ((String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.memorydata.plugin")) + ": " + ExceptionsKt.stackTraceToString(r12));
    L10:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r11 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L18:
        return r0;
    }

    private final List<Pair<String, JsonObject>> b(com.obric.aikernel.res.metadata.config.h r7) {
        String r6 = a(r7);
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r7.e(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r9 = r8.iterator();
    L4:
        if (r9.hasNext() == false) goto L12;
        com.obric.aikernel.res.metadata.config.c r2 = (com.obric.aikernel.res.metadata.config.c) ZeusTransformUtils.preCheckCast(r9.next(), com.obric.aikernel.res.metadata.config.c.class, "com.obric.memorydata.plugin");
        if (r2.q() == false) goto L8;
        com.obric.aikernel.runtime.utils.d.f6216a.b("MetadataRequest", r6 + ' ' + r2.f() + " hasDecryptKeyInfo");
        Pair r3 = new Pair(r2.f(), r2.b());
    L9:
        if (r3 == null) goto L4;
        r0.add(r3);
        goto L4
    L8:
        r3 = (Pair) ZeusTransformUtils.preCheckCast(null, Pair.class, "com.obric.memorydata.plugin");
        goto L9
    L12:
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
    }

    private final Object c(JsonObject r9, Continuation<? super List<? extends com.obric.aikernel.res.metadata.config.k>> r10) {
        Continuation r11 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r11, MetadataRequest$parseBusinessDistribute$1.class) == false) goto L7;
        MetadataRequest$parseBusinessDistribute$1 r0 = (MetadataRequest$parseBusinessDistribute$1) ZeusTransformUtils.preCheckCast(r11, MetadataRequest$parseBusinessDistribute$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        List r8 = (List) ZeusTransformUtils.preCheckCast(r0.L$0, List.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r12);
    L36:
        r8.addAll((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin"));
        return r8;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        JsonElement r13 = r9.get("businesses");
        Set<String> r14 = null;
        if (r13 != null) goto L17;
    L24:
        if (r14 != null) goto L26;
        r14 = SetsKt.emptySet();
    L26:
        com.obric.aikernel.runtime.utils.d.f6216a.b("MetadataRequest", "parseBusinessDistribute count=" + r14.size() + " names=" + r14);
        List r15 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        boolean r4 = false;
        if (r13 != null) goto L29;
    L31:
        if (r4 == false) goto L38;
        JsonObject r16 = r13.getAsJsonObject();
        Intrinsics.checkNotNullExpressionValue(r16, "businesses.asJsonObject");
        r0.L$0 = r15;
        r0.label = 1;
        Object r17 = d(r16, r0);
        if (r17 != r2) goto L35;
        return r2;
    L35:
        r12 = r17;
        r8 = r15;
        goto L36
    L38:
        return r15;
    L29:
        if (r13.isJsonObject() != true) goto L31;
        r4 = true;
        goto L31
    L17:
        if (r13.isJsonObject() == false) goto L19;
        JsonElement r5 = r13;
    L20:
        if (r5 == null) goto L24;
        JsonObject r6 = r5.getAsJsonObject();
        if (r6 == null) goto L24;
        r14 = r6.keySet();
        goto L24
    L19:
        r5 = null;
    L7:
        r0 = new MetadataRequest$parseBusinessDistribute$1(this, r11);
        goto L8
    }

    private final Object c(boolean r22, Map<String, ? extends b> r23, com.obric.aikernel.res.legacy.a r24, Continuation<? super List<? extends com.obric.aikernel.res.metadata.config.k>> r25) {
        d r0 = this;
        Map<String, ? extends b> r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r23, Map.class, "com.obric.memorydata.plugin");
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r25, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, MetadataRequest$requestInner$1.class) == false) goto L7;
        MetadataRequest$requestInner$1 r5 = (MetadataRequest$requestInner$1) ZeusTransformUtils.preCheckCast(r4, MetadataRequest$requestInner$1.class, "com.obric.memorydata.plugin");
        if ((r5.label & Integer.MIN_VALUE) == 0) goto L7;
        r5.label -= Integer.MIN_VALUE;
    L8:
        Object r6 = r5.result;
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r8 = r5.label;
        if (r8 == 0) goto L20;
        if (r8 == 1) goto L19;
        if (r8 == 2) goto L18;
        if (r8 == 3) goto L17;
        if (r8 != 4) goto L16;
        ResultKt.throwOnFailure(r6);
    L50:
        return r6;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        r0 = (d) ZeusTransformUtils.preCheckCast(r5.L$0, d.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r6);
    L36:
        String r1 = (String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L40;
    L44:
        g r3 = com.obric.aikernel.res.update.e.a(r1, r0.e);
        com.obric.aikernel.runtime.utils.d r9 = com.obric.aikernel.runtime.utils.d.f6216a;
        StringBuilder r10 = new StringBuilder().append("after request status=").append(r3.a()).append(" message=");
        String r11 = r3.b();
        if (r11 != null) goto L47;
        r11 = "";
    L47:
        r9.b("MetadataRequest", r10.append(StringsKt.take(r11, 160)).toString());
        JsonObject r12 = r3.c();
        r5.L$0 = null;
        r5.L$1 = null;
        r5.L$2 = null;
        r5.label = 4;
        r6 = r0.b(r12, r5);
        if (r6 != r7) goto L50;
        return r7;
    L40:
        throw new MetadataRequestException(MetadataRequestFailureKind.RESPONSE_PARSE_FAILED, "metadata request delegate returned empty response", null, 4, null);
    L18:
        String r13 = (String) ZeusTransformUtils.preCheckCast(r5.L$2, String.class, "com.obric.memorydata.plugin");
        com.obric.aikernel.res.legacy.a r14 = (com.obric.aikernel.res.legacy.a) ZeusTransformUtils.preCheckCast(r5.L$1, com.obric.aikernel.res.legacy.a.class, "com.obric.memorydata.plugin");
        d r15 = (d) ZeusTransformUtils.preCheckCast(r5.L$0, d.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r6);
        String r16 = r13;
        r0 = r15;
    L31:
        JsonObject r17 = (JsonObject) ZeusTransformUtils.preCheckCast(r6, JsonObject.class, "com.obric.memorydata.plugin");
        if (r0.c.getAppConfig().getNetworkRequestDelegate() == null) goto L41;
        Function2<RequestBody, Continuation<? super String>, Object> r18 = r0.c.getAppConfig().getNetworkRequestDelegate();
        MediaType r19 = MediaType.parse("application/json; charset=utf-8");
        String r20 = r17.toString();
        Intrinsics.checkNotNullExpressionValue(r20, "body.toString()");
        byte[] r21 = r20.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(r21, "this as java.lang.String).getBytes(charset)");
        RequestBody r26 = RequestBody.create(r19, r21);
        Intrinsics.checkNotNullExpressionValue(r26, "create(MediaType.parse(\"…toString().toByteArray())");
        r5.L$0 = r0;
        r5.L$1 = null;
        r5.L$2 = null;
        r5.label = 3;
        r6 = r18.invoke(r26, r5);
        if (r6 != r7) goto L36;
        return r7;
    L41:
        byte[] r27 = r14.a(r16, r17);
        if (r27 == null) goto L52;
        r1 = new String(r27, Charsets.UTF_8);
        goto L44
    L52:
        throw new MetadataRequestException(MetadataRequestFailureKind.UNKNOWN_TRANSPORT, "metadata request adapter returned empty response", null, 4, null);
    L19:
        boolean r28 = r5.Z$0;
        com.obric.aikernel.res.legacy.a r29 = (com.obric.aikernel.res.legacy.a) ZeusTransformUtils.preCheckCast(r5.L$2, com.obric.aikernel.res.legacy.a.class, "com.obric.memorydata.plugin");
        Map<String, ? extends b> r30 = (Map) ZeusTransformUtils.preCheckCast(r5.L$1, Map.class, "com.obric.memorydata.plugin");
        d r31 = (d) ZeusTransformUtils.preCheckCast(r5.L$0, d.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r6);
        boolean r32 = r28;
        r0 = r31;
        com.obric.aikernel.res.legacy.a r33 = r29;
        r2 = r30;
        Object r34 = r6;
    L27:
        r16 = (String) ZeusTransformUtils.preCheckCast(r34, String.class, "com.obric.memorydata.plugin");
        r5.L$0 = r0;
        r5.L$1 = r33;
        r5.L$2 = r16;
        r5.label = 2;
        r6 = r0.a(r32, r2, r5);
        if (r6 != r7) goto L30;
        return r7;
    L30:
        r14 = r33;
        goto L31
    L20:
        ResultKt.throwOnFailure(r6);
        if (((Boolean) ZeusTransformUtils.preCheckCast(r0.c.getAppConfig().getAllowNetworkRequest().invoke(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L24;
        com.obric.aikernel.runtime.utils.d.f6216a.b("MetadataRequest", "requestInner: not allow NetworkRequest");
        return CollectionsKt.emptyList();
    L24:
        r5.L$0 = r0;
        r5.L$1 = r2;
        r33 = r24;
        r5.L$2 = r33;
        r32 = r22;
        r5.Z$0 = r32;
        r5.label = 1;
        r34 = r0.a(r5);
        if (r34 != r7) goto L27;
        return r7;
    L7:
        r5 = new MetadataRequest$requestInner$1(r0, r4);
        goto L8
    }

    private final Object d(JsonObject r9, Continuation<? super List<com.obric.aikernel.res.metadata.config.i>> r10) {
        Continuation r11 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        List<com.obric.aikernel.res.metadata.config.i> r12 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Map<String, Map<String, com.obric.aikernel.res.metadata.config.d>> r0 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Set<String> r2 = r9.keySet();
        Intrinsics.checkNotNullExpressionValue(r2, "businesses.keySet()");
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r3.hasNext() == false) goto L13;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.memorydata.plugin");
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L8
        JsonObject r6 = r9.get(r4).getAsJsonObject();     // Catch: Throwable -> L8
        Intrinsics.checkNotNullExpressionValue(r4, "biz");     // Catch: Throwable -> L8
        Intrinsics.checkNotNullExpressionValue(r6, "bizData");     // Catch: Throwable -> L8
        a(r4, r6, r12, r0);     // Catch: Throwable -> L8
        Object r7 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r8 = Result.m1424exceptionOrNullimpl(r7);
        if (r8 == null) goto L4;
        com.obric.aikernel.runtime.utils.d.f6216a.c("MetadataRequest", "processBusinesses ignore broken biz " + r4 + ": " + ExceptionsKt.stackTraceToString(r8));
    L8:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r7 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L10
    L13:
        return r12;
    }

    public final Object a(JsonObject r6, Continuation<? super Map<String, ? extends List<? extends com.obric.aikernel.res.metadata.config.a>>> r7) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r8, MetadataRequest$pushDebugDistributeInfo$1.class) == false) goto L7;
        MetadataRequest$pushDebugDistributeInfo$1 r0 = (MetadataRequest$pushDebugDistributeInfo$1) ZeusTransformUtils.preCheckCast(r8, MetadataRequest$pushDebugDistributeInfo$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r9);
    L17:
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Map r10 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r11 = r5.iterator();
    L19:
        if (r11.hasNext() == false) goto L24;
        Object r12 = r11.next();
        String r1 = ((com.obric.aikernel.res.metadata.config.k) ZeusTransformUtils.preCheckCast(r12, com.obric.aikernel.res.metadata.config.k.class, "com.obric.memorydata.plugin")).getType();
        Object r4 = r10.get(r1);
        if (r4 != null) goto L23;
        r4 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        r10.put(r1, r4);
    L23:
        ((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin")).add(r12);
        goto L19
    L24:
        return r10;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        r0.label = 1;
        r9 = b(r6, r0);
        if (r9 != r2) goto L17;
        return r2;
    L7:
        r0 = new MetadataRequest$pushDebugDistributeInfo$1(this, r8);
        goto L8
    }

    public final Object a(boolean r6, Map<String, ? extends b> r7, com.obric.aikernel.res.legacy.a r8, Continuation<? super Map<String, ? extends List<? extends com.obric.aikernel.res.metadata.config.k>>> r9) {
        Map<String, ? extends b> r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
        Continuation r11 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r11, MetadataRequest$request$1.class) == false) goto L7;
        MetadataRequest$request$1 r0 = (MetadataRequest$request$1) ZeusTransformUtils.preCheckCast(r11, MetadataRequest$request$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r12);
    L18:
        return ((f) ZeusTransformUtils.preCheckCast(r12, f.class, "com.obric.memorydata.plugin")).a();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        r0.label = 1;
        r12 = b(r6, r10, r8, r0);
        if (r12 != r2) goto L18;
        return r2;
    L7:
        r0 = new MetadataRequest$request$1(this, r11);
        goto L8
    }

    public final Object b(boolean r11, Map<String, ? extends b> r12, com.obric.aikernel.res.legacy.a r13, Continuation<? super f> r14) {
        Map r15 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.memorydata.plugin");
        Continuation r16 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r14, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r16, MetadataRequest$requestOutcome$1.class) == false) goto L7;
        MetadataRequest$requestOutcome$1 r0 = (MetadataRequest$requestOutcome$1) ZeusTransformUtils.preCheckCast(r16, MetadataRequest$requestOutcome$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r17 = r0.result;
        Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L18;
        if (r2 != 1) goto L17;
        r11 = r0.Z$0;
        r15 = (Map) ZeusTransformUtils.preCheckCast(r0.L$0, Map.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r17);     // Catch: Throwable -> L14
    L31:
        Object r10 = Result.m1421constructorimpl((List) ZeusTransformUtils.preCheckCast(r17, List.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L14
    L34:
        Throwable r18 = Result.m1424exceptionOrNullimpl(r10);
        if (r18 != null) goto L44;
        List r19 = (List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.memorydata.plugin");
        com.obric.aikernel.runtime.utils.d.f6216a.b("MetadataRequest", "request completed updateAll=" + r11 + " bizCount=" + r15.size() + " configCount=" + r19.size() + " byType=" + GroupingKt.eachCount((Grouping) ZeusTransformUtils.preCheckCast(new e((Iterable) ZeusTransformUtils.preCheckCast(r19, Iterable.class, "com.obric.memorydata.plugin")), Grouping.class, "com.obric.memorydata.plugin")));
        f.a r110 = f.f6128a;
        Iterable r111 = (Iterable) ZeusTransformUtils.preCheckCast(r19, Iterable.class, "com.obric.memorydata.plugin");
        Map<String, ? extends List<? extends com.obric.aikernel.res.metadata.config.k>> r112 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r113 = r111.iterator();
    L38:
        if (r113.hasNext() == false) goto L51;
        Object r114 = r113.next();
        String r115 = ((com.obric.aikernel.res.metadata.config.k) ZeusTransformUtils.preCheckCast(r114, com.obric.aikernel.res.metadata.config.k.class, "com.obric.memorydata.plugin")).getType();
        List<? extends com.obric.aikernel.res.metadata.config.k> r1 = r112.get(r115);
        if (r1 != null) goto L42;
        r1 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        r112.put(r115, r1);
    L42:
        ((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin")).add(r114);
        goto L38
    L51:
        return r110.a(r112);
    L44:
        MetadataRequestException r116 = com.obric.aikernel.res.update.e.a(r18);
        com.obric.aikernel.runtime.utils.d.f6216a.c("MetadataRequest", "request final failed kind=" + r116.getKind() + " reason=" + r116.getMessage());
        return f.f6128a.a(r116);
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r17);
        if (r11 == false) goto L21;
    L24:
        Result.Companion r117 = Result.Companion;     // Catch: Throwable -> L14
        d r5 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        if (r11 == false) goto L27;
        boolean r3 = true;
    L28:
        Function2 r4 = (Function2) ZeusTransformUtils.preCheckCast(new MetadataRequest$requestOutcome$2$1(r3, r15, r5, r13, null), Function2.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        Function3 r6 = (Function3) ZeusTransformUtils.preCheckCast(MetadataRequest$requestOutcome$2$2.INSTANCE, Function3.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        r0.L$0 = r15;     // Catch: Throwable -> L14
        r0.Z$0 = r11;     // Catch: Throwable -> L14
        r0.label = 1;     // Catch: Throwable -> L14
        r17 = com.obric.aikernel.res.update.e.a(r4, null, r6, r0, 2, null);     // Catch: Throwable -> L14
        if (r17 != r8) goto L31;
        return r8;
    L27:
        r3 = false;
        goto L28
    L21:
        if (r15.isEmpty() == false) goto L24;
        return f.f6128a.a(MapsKt.emptyMap());
    L14:
        th = move-exception;
        Result.Companion r118 = Result.Companion;
        r10 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L7:
        r0 = new MetadataRequest$requestOutcome$1(this, r16);
        goto L8
    }
}
