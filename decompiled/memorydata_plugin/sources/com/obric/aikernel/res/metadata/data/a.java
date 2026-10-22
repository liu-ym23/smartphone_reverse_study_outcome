package com.obric.aikernel.res.metadata.data;

import android.net.Uri;
import android.os.SystemClock;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.aikernel.res.PackageResourceManager;
import com.obric.aikernel.res.update.m;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 :2\u00020\u0001:\u0001:B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0012\u0010\u0016\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u0012H\u0016J\u0010\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u0012H\u0016J\u0015\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0012H\u0000¢\u0006\u0002\b\u001eJ\u0006\u0010\u001f\u001a\u00020 J\b\u0010!\u001a\u00020\u0003H\u0016J\n\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0018\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00030%2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0017H\u0002J\b\u0010&\u001a\u00020\u0003H\u0016J\b\u0010'\u001a\u00020\u0003H\u0016J\r\u0010(\u001a\u00020\u0012H\u0000¢\u0006\u0002\b)J\b\u0010*\u001a\u00020\u0012H\u0002J\b\u0010+\u001a\u00020\u0012H\u0002J\r\u0010,\u001a\u00020 H\u0000¢\u0006\u0002\b-J\b\u0010.\u001a\u00020 H\u0014J\u0012\u0010/\u001a\u00020\u00172\b\u00100\u001a\u0004\u0018\u00010\u0003H\u0002J\b\u00101\u001a\u00020\u0012H\u0016J\b\u00102\u001a\u00020\u0012H\u0016J\u001d\u00103\u001a\u00020 2\u0006\u00104\u001a\u00020\n2\u0006\u00105\u001a\u000206H\u0000¢\u0006\u0002\b7J\u001d\u00108\u001a\u00020 2\u0006\u00105\u001a\u0002062\u0006\u0010\u001d\u001a\u00020\u0012H\u0000¢\u0006\u0002\b9R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u0014\u0010\u000f\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\fR\u001b\u0010\u0011\u001a\u00020\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0011\u0010\u0013¨\u0006;"}, d2 = {"Lcom/obric/aikernel/res/metadata/data/AIModel;", "Lcom/obric/aikernel/res/metadata/data/BaseMetadata;", ActivityLifecycle.NAME, "", "version", "config", "Lcom/obric/aikernel/res/PackageResourceManager$PresmConfig;", "(Ljava/lang/String;Ljava/lang/String;Lcom/obric/aikernel/res/PackageResourceManager$PresmConfig;)V", WsConstants.KEY_EXTRA, "installInFlightFlag", "Ljava/io/File;", "getInstallInFlightFlag", "()Ljava/io/File;", "integrityRepairFlag", "getIntegrityRepairFlag", "integritySealFlag", "getIntegritySealFlag", "isEncryptedPreset", "", "()Z", "isEncryptedPreset$delegate", "Lkotlin/Lazy;", "buildModelExtra", "Lcom/google/gson/JsonObject;", "checkResource", "fastMode", "checkResourceFull", "createPayloadInstallSession", "Lcom/obric/aikernel/res/update/ModelPayloadInstallSession;", "useResRoot", "createPayloadInstallSession$resource_manager_release", "deleteBrokenFiles", "", "getExtra", "getInnerResUri", "Landroid/net/Uri;", "getRuntimeEncryptedFiles", "", "getType", "getTypeRootPath", "hasIntegritySeal", "hasIntegritySeal$resource_manager_release", "isPlatformIntegrityModelPath", "isResourceManagerOwnedModelPath", "markIntegritySealed", "markIntegritySealed$resource_manager_release", "onInstallSucceed", "parseHyperParamAsJsonObject", "rawExtra", "resourceIsAvailable", "resourceIsReady", "sealStagedPayload", "root", "modelConfig", "Lcom/obric/aikernel/res/metadata/config/ModelConfig;", "sealStagedPayload$resource_manager_release", "writeDurableInstallMetadata", "writeDurableInstallMetadata$resource_manager_release", "Companion", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class a extends d {
    public static final C0264a c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Lazy f6081a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile String f6082b;

    /* JADX INFO: renamed from: com.obric.aikernel.res.metadata.data.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/aikernel/res/metadata/data/AIModel$Companion;", "", "()V", "INSTALL_IN_FLIGHT_FILE", "", "INTEGRITY_REPAIR_FILE", "INTEGRITY_SEAL_FILE", "INTEGRITY_SEAL_VERSION", "TYPE", "getTemplateModelExtra", "config", "Lcom/google/gson/JsonObject;", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class C0264a {
        private C0264a() {
        }

        public /* synthetic */ C0264a(DefaultConstructorMarker r1) {
            this();
        }

        public final String a(JsonObject r6) {
            if (r6 == null) goto L16;
            JsonObject r5 = new JsonObject();
            JsonElement r0 = r6.get("hyper_param");
            if (r0 == null) goto L9;
            Intrinsics.checkNotNullExpressionValue(r0, "get(\"hyper_param\")");
            Set<Map.Entry<String, JsonElement>> r1 = ((JsonObject) ZeusTransformUtils.preCheckCast(new Gson().fromJson(r0.getAsString(), JsonObject.class), JsonObject.class, "com.obric.memorydata.plugin")).getAsJsonObject().entrySet();
            Intrinsics.checkNotNullExpressionValue(r1, "Gson().fromJson(arg.asSt…).asJsonObject.entrySet()");
            Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L7:
            if (r2.hasNext() == false) goto L9;
            Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            r5.add((String) ZeusTransformUtils.preCheckCast(r3.getKey(), String.class, "com.obric.memorydata.plugin"), (JsonElement) ZeusTransformUtils.preCheckCast(r3.getValue(), JsonElement.class, "com.obric.memorydata.plugin"));
        L9:
            JsonElement r4 = r6.get("weight_files");
            if (r4 == null) goto L12;
            Intrinsics.checkNotNullExpressionValue(r4, "get(\"weight_files\")");
            r5.add("_weight_files", r4);
        L12:
            JsonElement r7 = r6.get("tokenizer_file");
            if (r7 == null) goto L15;
            Intrinsics.checkNotNullExpressionValue(r7, "get(\"tokenizer_file\")");
            r5.add("_tokenizer_file", r7);
        L15:
            String r8 = r5.toString();
        L17:
            if (r8 != null) goto L21;
            return "";
        L21:
            return r8;
        L16:
            r8 = null;
            goto L17
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6083a = null;

        static {
            int[] r0 = new int[SealedFileAction.values().length];
            r0[SealedFileAction.HEALTHY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[SealedFileAction.DEFER_FULL_VERIFY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[SealedFileAction.VERIFY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[SealedFileAction.VERIFY_AND_RESEAL.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[SealedFileAction.NEEDS_DOWNLOAD.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f6083a = r0;
        }
    }

    static {
        c = new C0264a(null);
    }

    public a(final String r2, final String r3, final PackageResourceManager.PresmConfig r4) {
        Intrinsics.checkNotNullParameter(r2, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r3, "version");
        Intrinsics.checkNotNullParameter(r4, "config");
        super(r2, r3, r4);
        this.f6081a = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new AIModel$isEncryptedPreset$2(r4, r2, r3), Function0.class, "com.obric.memorydata.plugin"));
    }

    private final File N() {
        return new File(y(), "integrity_repair");
    }

    private final File O() {
        return new File(y(), "publish_inflight");
    }

    private final String a(JsonObject r5) {
        String r4 = null;
        if (r5 == null) goto L17;
        JsonElement r1 = r5.get("hyper_param");
        boolean r2 = true;
        if (r1 != null) goto L7;
    L9:
        r2 = false;
    L10:
        if (r2 == true) goto L13;
        r5 = null;
    L13:
        if (r5 == null) goto L17;
        JsonElement r6 = r5.get("hyper_param");
        if (r6 == null) goto L17;
        r4 = r6.getAsString();
        goto L17
    L7:
        if (r1.isJsonPrimitive() != true) goto L9;
    L17:
        if (r4 != null) goto L20;
        return "";
    L20:
        return r4;
    }

    private static final void a(long r7, a r9, Uri r10, String r11, String r12, String r13) {
        if (r7 > 0) goto L5;
        com.obric.aikernel.runtime.utils.d.f6216a.f(PackageResourceManager.TAG, "[Model] try checkResource " + r9 + " but leak size " + r7 + '.');
        return;
    L5:
        long r2 = SystemClock.elapsedRealtime();
        if (r9.a(r10, r7) != true) goto L9;
        com.obric.aikernel.runtime.utils.d.f6216a.d(PackageResourceManager.TAG, "[Model] check size pass (" + r13 + "): " + r9.s() + '@' + r9.t() + ": " + r10.getPath() + ' ' + r7 + ", cost " + (SystemClock.elapsedRealtime() - r2) + "ms");
        return;
    L9:
        g.f6092a.a(r11, r12, r7);
        throw new IllegalStateException(r9.s() + '@' + r9.t() + ": " + r10.getPath() + " size not match");
    }

    private final boolean p() {
        if (g() == false) goto L5;
        return false;
    L5:
        Uri r0 = i();
        if (r0 != null) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(r0.getScheme(), "file") == true) goto L11;
        r0 = null;
    L11:
        if (r0 == null) goto L25;
        String r1 = r0.getPath();
        if (r1 == null) goto L26;
        File r2 = new File(r1);
        Iterator r6 = SequencesKt.map(SequencesKt.filter(CollectionsKt.asSequence((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(new String[]{u().getRootDir(), u().getResRootDir()}), Iterable.class, "com.obric.memorydata.plugin")), (Function1) ZeusTransformUtils.preCheckCast(AIModel$isResourceManagerOwnedModelPath$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin")), (Function1) ZeusTransformUtils.preCheckCast(AIModel$isResourceManagerOwnedModelPath$2.INSTANCE, Function1.class, "com.obric.memorydata.plugin")).iterator();
    L16:
        if (r6.hasNext() == false) goto L27;
        if (com.obric.aikernel.res.integrity.a.f6050a.a(r2, (File) ZeusTransformUtils.preCheckCast(r6.next(), File.class, "com.obric.memorydata.plugin")) == false) goto L16;
        return true;
    L27:
        return false;
    L26:
        return false;
    L25:
        return false;
    }

    private final boolean q() {
        Uri r0 = i();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (Intrinsics.areEqual(r0.getScheme(), "file") == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L22;
        String r1 = r0.getPath();
        if (r1 == null) goto L23;
        File r2 = new File(r1);
        Iterator r6 = SequencesKt.filter(CollectionsKt.asSequence((Iterable) ZeusTransformUtils.preCheckCast(u().getPlatformIntegrityModelRoots(), Iterable.class, "com.obric.memorydata.plugin")), (Function1) ZeusTransformUtils.preCheckCast(AIModel$isPlatformIntegrityModelPath$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin")).iterator();
    L13:
        if (r6.hasNext() == false) goto L24;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.memorydata.plugin");
        if (com.obric.aikernel.res.integrity.a.f6050a.a(r2, new File(r3)) == false) goto L13;
        return true;
    L24:
        return false;
    L23:
        return false;
    L22:
        return false;
    }

    private final File r() {
        return new File(y(), "integrity_seal_v1");
    }

    @Override // com.obric.aikernel.res.metadata.data.d
    public void a() {
        super.a();
        l();
    }

    public final void a(com.obric.aikernel.res.metadata.config.h r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r9, "modelConfig");
        File r0 = new File(w());
        if (r0.exists() == false) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L20;
        com.obric.aikernel.res.integrity.a r2 = com.obric.aikernel.res.integrity.a.f6050a;
        File r3 = new File(r0, "configuration.json");
        String r4 = r9.b().toString();
        Intrinsics.checkNotNullExpressionValue(r4, "modelConfig.json.toString()");
        r2.c(r3, r4);
        JsonObject r5 = new JsonObject();
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r9.a(u().getDecryptFeature()), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L12:
        if (r11.hasNext() == false) goto L14;
        com.obric.aikernel.res.metadata.config.f r6 = (com.obric.aikernel.res.metadata.config.f) ZeusTransformUtils.preCheckCast(r11.next(), com.obric.aikernel.res.metadata.config.f.class, "com.obric.memorydata.plugin");
        String r7 = r6.a();
        JsonObject r8 = new JsonObject();
        r8.addProperty("size", (Number) ZeusTransformUtils.preCheckCast(Long.valueOf(r6.c()), Number.class, "com.obric.memorydata.plugin"));
        Unit r12 = Unit.INSTANCE;
        r5.add(r7, (JsonElement) ZeusTransformUtils.preCheckCast(r8, JsonElement.class, "com.obric.memorydata.plugin"));
        goto L12
    L14:
        com.obric.aikernel.res.integrity.a r13 = com.obric.aikernel.res.integrity.a.f6050a;
        File r14 = new File(r0, "checker_v2.json");
        String r15 = r5.toString();
        Intrinsics.checkNotNullExpressionValue(r15, "checker.toString()");
        r13.c(r14, r15);
        com.obric.aikernel.res.integrity.a r16 = com.obric.aikernel.res.integrity.a.f6050a;
        if (r10 == false) goto L17;
        File r17 = A();
        String r18 = Uri.fromFile(B()).toString();
        Intrinsics.checkNotNullExpressionValue(r18, "fromFile(expectedLinkTarget).toString()");
        r16.c(r17, r18);
        return;
    L17:
        r16.b(A());
        return;
    L20:
        throw new IllegalArgumentException(("cannot create model metadata root: " + r0).toString());
    L5:
        if (r0.mkdirs() == true) goto L8;
        r1 = false;
        goto L9
    }

    public final void a(File r2, com.obric.aikernel.res.metadata.config.h r3) {
        Intrinsics.checkNotNullParameter(r2, "root");
        Intrinsics.checkNotNullParameter(r3, "modelConfig");
        com.obric.aikernel.res.integrity.a.f6050a.a(r2, r3.a(u().getDecryptFeature()));
    }

    @Override // com.obric.aikernel.res.metadata.data.d
    public boolean b(boolean r4) {
        if (g() == false) goto L9;
        if (u().getDecryptFeature().c(s(), t()) == true) goto L9;
        return true;
    L9:
        return super.b(r4);
    }

    @Override // com.obric.aikernel.res.metadata.data.d
    public boolean c(boolean r42) {
        if (((Boolean) ZeusTransformUtils.preCheckCast(u().getAppConfig().getCheckPackageResource().invoke(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L5;
        return true;
    L5:
        super.c(r42);
        com.obric.aikernel.res.metadata.config.a r0 = J();
        Intrinsics.checkNotNull(r0);
        List<com.obric.aikernel.res.metadata.config.f> r1 = new com.obric.aikernel.res.metadata.config.h(r0.a(), r0.b()).a(u().getDecryptFeature());
        boolean r2 = q();
        boolean r3 = r().exists();
        if (r2 == false) goto L8;
    L10:
        boolean r4 = false;
    L11:
        long r14 = 0;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L35;
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, Collection.class) == true) goto L16;
    L18:
        Iterator r6 = r5.iterator();
    L20:
        if (r6.hasNext() == false) goto L17;
        com.obric.aikernel.res.metadata.config.f r7 = (com.obric.aikernel.res.metadata.config.f) ZeusTransformUtils.preCheckCast(r6.next(), com.obric.aikernel.res.metadata.config.f.class, "com.obric.memorydata.plugin");
        if (r7.c() > 0) goto L147;
    L30:
        boolean r8 = false;
    L31:
        if (r8 == true) goto L20;
        boolean r9 = false;
    L33:
        if (r9 == false) goto L35;
        boolean r10 = true;
    L36:
        boolean r11 = h.a(r4, r3, r42, r10);
        if (N().exists() == false) goto L39;
    L43:
        boolean r12 = true;
    L44:
        String r13 = " not exist";
        String r15 = "pathUri?.path\n          …d resource uri $pathUri\")";
        String r16 = ": invalid resource uri ";
        String r17 = PackageResourceManager.TAG;
        String r18 = ": ";
        if (r2 == true) goto L96;
        if (r3 == true) goto L96;
        if (r11 == true) goto L96;
        Iterator r19 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L51:
        if (r19.hasNext() == false) goto L94;
        com.obric.aikernel.res.metadata.config.f r20 = (com.obric.aikernel.res.metadata.config.f) ZeusTransformUtils.preCheckCast(r19.next(), com.obric.aikernel.res.metadata.config.f.class, "com.obric.memorydata.plugin");
        Uri r21 = b(r20.a());
        if (a(r21) == false) goto L54;
        final long r25 = r20.c();
        String r22 = r20.b();
        if (r21 == null) goto L93;
        String r23 = r21.getPath();
        if (r23 == null) goto L93;
        Intrinsics.checkNotNullExpressionValue(r23, r15);
        if (r42 == true) goto L72;
        if (r12 == true) goto L72;
        if (r25 <= r14) goto L72;
        if (g.a(g.f6092a, r23, r22, r25, 0, 8, null) == false) goto L72;
        boolean r110 = true;
    L73:
        if (r42 == true) goto L85;
        if (r110 == true) goto L85;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r22, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L79;
        boolean r111 = true;
    L80:
        if (r111 == false) goto L82;
        com.obric.aikernel.runtime.utils.d.f6216a.f(r17, "[Model] try checkResource " + this + " but leak md5.");
        String r27 = r17;
        String r28 = r16;
        String r29 = r15;
        String r30 = r13;
        boolean r31 = r12;
    L91:
        r17 = r27;
        r16 = r28;
        r15 = r29;
        r13 = r30;
        r12 = r31;
        r14 = 0;
        goto L51
    L82:
        final String r24 = r22;
        final boolean r26 = r12;
        final Uri r210 = r21;
        r27 = r17;
        r28 = r16;
        final String r32 = r23;
        r29 = r15;
        r30 = r13;
        r31 = r12;
        if (((Boolean) ZeusTransformUtils.preCheckCast(g.f6092a.a(r32, (Function0) ZeusTransformUtils.preCheckCast(new AIModel$checkResource$2$verifiedByCache$1(r26, r25, r32, r24, this, r210), Function0.class, "com.obric.memorydata.plugin")), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L91;
        String r33 = "cached md5";
    L90:
        a(r25, this, r210, r32, r24, r33);
        goto L91
    L79:
        r111 = false;
    L85:
        r24 = r22;
        r210 = r21;
        r27 = r17;
        r28 = r16;
        r29 = r15;
        r30 = r13;
        r31 = r12;
        r32 = r23;
        if (r110 == false) goto L88;
        String r34 = "cached md5";
    L89:
        r33 = r34;
        goto L90
    L88:
        r34 = "fast mode";
    L72:
        r110 = false;
    L93:
        throw new IllegalStateException(new StringBuilder().append(s()).append('@').append(t()).append(r16).append(r21).toString());
    L54:
        StringBuilder r35 = new StringBuilder().append(s()).append('@').append(t()).append(": ");
        if (r21 == null) goto L57;
        String r36 = r21.getPath();
    L59:
        throw new IllegalStateException(r35.append(r36).append(r13).toString());
    L57:
        r36 = null;
        goto L59
    L94:
        return true;
    L96:
        String r211 = PackageResourceManager.TAG;
        String r212 = "pathUri?.path\n          …d resource uri $pathUri\")";
        String r37 = " not exist";
        boolean r38 = r12;
        Iterator r39 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L98:
        if (r39.hasNext() == false) goto L141;
        final com.obric.aikernel.res.metadata.config.f r40 = (com.obric.aikernel.res.metadata.config.f) ZeusTransformUtils.preCheckCast(r39.next(), com.obric.aikernel.res.metadata.config.f.class, "com.obric.memorydata.plugin");
        Uri r41 = b(r40.a());
        if (r41 == null) goto L140;
        final String r43 = r41.getPath();
        if (r43 == null) goto L140;
        String r44 = r212;
        Intrinsics.checkNotNullExpressionValue(r43, r44);
        final File r45 = new File(r43);
        boolean r112 = a(r41);
        if (r112 == true) goto L106;
    L110:
        String r113 = r18;
    L111:
        boolean r46 = false;
    L112:
        if (r2 == false) goto L123;
        if (r112 == false) goto L122;
        if (r40.c() <= 0) goto L120;
        if (r46 == true) goto L120;
        throw new IllegalStateException(s() + '@' + t() + r113 + r43 + " size not match");
    L120:
        String r114 = r113;
        Iterator r115 = r39;
        r211 = r211;
        String r116 = r37;
        boolean r47 = r38;
    L138:
        r38 = r47;
        r212 = r44;
        r37 = r116;
        r211 = r211;
        r39 = r115;
        r18 = r114;
        goto L98
    L122:
        throw new IllegalStateException(new StringBuilder().append(s()).append('@').append(t()).append(r113).append(r43).append(r37).toString());
    L123:
        r114 = r113;
        r116 = r37;
        r115 = r39;
        r47 = r38;
        int r48 = b.f6083a[h.a(r112, r46, com.obric.aikernel.res.integrity.a.f6050a.a(r45), r42, r47).ordinal()];
        if (r48 != 2) goto L126;
        com.obric.aikernel.res.integrity.a.f6050a.b(N(), "1");
        com.obric.aikernel.runtime.utils.d r49 = com.obric.aikernel.runtime.utils.d.f6216a;
        String r50 = "[Model] defer model integrity verification: " + r43;
    L137:
        r49.f(r211, r50);
        goto L138
    L126:
        if (r48 != 3) goto L128;
        r211 = r211;
        g.f6092a.a(r43, (Function0) ZeusTransformUtils.preCheckCast(new AIModel$checkResource$1$1(r45, r40, r43), Function0.class, "com.obric.memorydata.plugin"));
        goto L138
    L128:
        if (r48 != 4) goto L130;
        com.obric.aikernel.res.integrity.a.f6050a.a(r45, r40);
        g.b(g.f6092a, r43, r40.b(), r40.c(), 0, 8, null);
        r49 = com.obric.aikernel.runtime.utils.d.f6216a;
        r50 = "[Model] resealed writable model file after md5 verification: " + r43;
        goto L137
    L130:
        if (r48 == 5) goto L132;
        r211 = r211;
        goto L138
    L132:
        g.f6092a.a(r43, r40.b(), r40.c());
        throw new IllegalStateException(s() + '@' + t() + r114 + r43 + " missing or size mismatch");
    L106:
        if (r40.c() <= 0) goto L110;
        r113 = r18;
        if (a(r41, r40.c()) == false) goto L111;
        r46 = true;
    L140:
        throw new IllegalStateException(s() + '@' + t() + ": invalid resource uri " + r41);
    L141:
        if (r42 == true) goto L143;
        N().delete();
    L143:
        if (r11 == false) goto L171;
        j();
        return true;
    L171:
        return true;
    L39:
        if (F() == true) goto L43;
        if (r11 == true) goto L43;
        r12 = false;
        goto L44
    L147:
        Result.Companion r51 = Result.Companion;     // Catch: Throwable -> L25
        a r52 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25
        Object r53 = Result.m1421constructorimpl(com.obric.aikernel.res.integrity.a.f6050a.a(r7.b(), r7.a()));     // Catch: Throwable -> L25
    L28:
        if (Result.m1428isSuccessimpl(r53) == false) goto L30;
        r8 = true;
    L25:
        th = move-exception;
        Result.Companion r54 = Result.Companion;
        r53 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L17:
        r9 = true;
        goto L33
    L16:
        if (((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L18;
    L35:
        r10 = false;
        goto L36
    L8:
        if (p() == false) goto L10;
        r4 = true;
        goto L11
    }

    public final m d(boolean r18) {
        if (r18 == false) goto L5;
        String r0 = x();
    L6:
        File r1 = new File(r0);
        return new m(r1, new File(r1, s()), new File(r1, '.' + s() + ".installing"), new File(r1, '.' + s() + ".backup"), O(), r(), N(), z(), "1", null, null, null, 3584, null);
    L5:
        r0 = w();
        goto L6
    }

    @Override // com.obric.aikernel.res.metadata.data.d
    public boolean e() {
        if (O().exists() == false) goto L5;
    L7:
        return false;
    L5:
        if (super.e() == false) goto L7;
        return true;
    }

    @Override // com.obric.aikernel.res.metadata.data.d
    public boolean f() {
        if (g() == false) goto L11;
        if (I() == true) goto L7;
    L9:
        return false;
    L7:
        if (y().exists() == false) goto L9;
        return true;
    L11:
        return super.f();
    }

    public final boolean g() {
        return ((Boolean) ZeusTransformUtils.preCheckCast(this.f6081a.getValue(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    @Override // com.obric.aikernel.res.metadata.data.d
    public String getType() {
        return "model";
    }

    @Override // com.obric.aikernel.res.metadata.data.d
    public String h() {
        return "models";
    }

    @Override // com.obric.aikernel.res.metadata.data.d
    public Uri i() {
        if (g() == false) goto L6;
        return Uri.fromFile(new File(u().getDecryptFeature().b(s(), t())));
    L6:
        return super.i();
    }

    public final void j() {
        com.obric.aikernel.res.integrity.a.f6050a.b(r(), "1");
        N().delete();
    }

    public final boolean k() {
        return r().exists();
    }

    @Override // com.obric.aikernel.res.metadata.data.d
    public String l() {
        if (this.f6082b != null) goto L18;
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L6:
        if (this.f6082b != null) goto L12;
        com.obric.aikernel.res.metadata.config.a r0 = J();     // Catch: Throwable -> L15
        if (r0 == null) goto L10;
        JsonObject r1 = r0.b();     // Catch: Throwable -> L15
    L11:
        this.f6082b = a(r1);     // Catch: Throwable -> L15
        goto L12
    L10:
        r1 = null;
    L12:
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L15
        monitor-exit(this);
    L18:
        String r3 = this.f6082b;
        if (r3 != null) goto L24;
        return "{}";
    L24:
        return r3;
    }
}
