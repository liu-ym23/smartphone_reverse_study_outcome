package com.obric.aikernel.res.metadata.data;

import android.net.Uri;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.google.gson.JsonObject;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.aikernel.res.PackageResourceManager;
import com.obric.aikernel.res.PrmContext;
import com.obric.aikernel.sdk.ext.Params;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 42\u00020\u0001:\u00014B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$H\u0016J\u0015\u0010&\u001a\u00020$2\u0006\u0010%\u001a\u00020$H\u0010¢\u0006\u0002\b'J\n\u0010(\u001a\u0004\u0018\u00010)H\u0016J\n\u0010*\u001a\u0004\u0018\u00010+H\u0016J\b\u0010,\u001a\u00020\u0003H\u0016J\b\u0010-\u001a\u00020\u0003H\u0016J\u0010\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0014J\b\u00102\u001a\u00020$H\u0016J\b\u00103\u001a\u00020$H\u0016R\u001b\u0010\b\u001a\u00020\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0014\u001a\u00020\u00158FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\f\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0019\u001a\u00020\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\f\u001a\u0004\b\u001a\u0010\nR \u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u00065"}, d2 = {"Lcom/obric/aikernel/res/metadata/data/Lora;", "Lcom/obric/aikernel/res/metadata/data/BaseMetadata;", ActivityLifecycle.NAME, "", "version", "config", "Lcom/obric/aikernel/res/PackageResourceManager$PresmConfig;", "(Ljava/lang/String;Ljava/lang/String;Lcom/obric/aikernel/res/PackageResourceManager$PresmConfig;)V", "baseModelTag", "getBaseModelTag", "()Ljava/lang/String;", "baseModelTag$delegate", "Lkotlin/Lazy;", "depDir", "Ljava/io/File;", "loraConfig", "Lcom/obric/aikernel/res/metadata/config/LoraConfig;", "getLoraConfig", "()Lcom/obric/aikernel/res/metadata/config/LoraConfig;", "loraConfig$delegate", "packageMinVersion", "", "getPackageMinVersion", "()I", "packageMinVersion$delegate", ObricMemoryConstants.KEY_PACKAGE_NAME, "getPackageName", "packageName$delegate", "res", "", "Lcom/obric/aikernel/res/metadata/data/AIModel;", "getRes", "()Ljava/util/List;", "setRes", "(Ljava/util/List;)V", "checkResource", "", "fastMode", "checkShouldReinstall", "checkShouldReinstall$resource_manager_release", "getCheckerConfig", "Lcom/google/gson/JsonObject;", "getInnerResUri", "Landroid/net/Uri;", "getType", "getTypeRootPath", "install", "", "context", "Lcom/obric/aikernel/res/PrmContext;", "isAvailable", "resourceIsReady", "Companion", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class f extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6090a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lazy f6091b;
    private final Lazy c;
    private final Lazy d;
    private final Lazy e;
    private List<? extends com.obric.aikernel.res.metadata.data.a> g;
    private final File h;

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fJ(\u0010\u0010\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u0011J(\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u0018H\u0002J\u0012\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u0018*\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/obric/aikernel/res/metadata/data/Lora$Companion;", "", "()V", "STORAGE_DIR", "", "getLora", "Lkotlin/Pair;", "Lcom/obric/aikernel/res/metadata/data/Lora;", "Lcom/obric/aikernel/res/metadata/data/AIPackage;", "pkgName", Params.LORA_TYPE, "context", "Lcom/obric/aikernel/res/PrmContext;", "getLoraPackageName", "config", "Lcom/obric/aikernel/res/PackageResourceManager$PresmConfig;", "isLoraNeedUpdate", "", "version", "fastCheck", "matchPackage", "lora", "it", "currentValidBaseModel", "", "getModelTags", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: com.obric.aikernel.res.metadata.data.f$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
        public static final class C0265a<T> implements Comparator {
            public C0265a() {
            }

            @Override // java.util.Comparator
            public final int compare(T r3, T r4) {
                String r2 = (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin");
                com.obric.aikernel.res.metadata.data.b.a r5 = com.obric.aikernel.res.metadata.data.b.e;
                Intrinsics.checkNotNullExpressionValue(r2, "it");
                Comparable r6 = (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(r5.a(r2)), Comparable.class, "com.obric.memorydata.plugin");
                String r7 = (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin");
                com.obric.aikernel.res.metadata.data.b.a r8 = com.obric.aikernel.res.metadata.data.b.e;
                Intrinsics.checkNotNullExpressionValue(r7, "it");
                return ComparisonsKt.compareValues(r6, (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(r8.a(r7)), Comparable.class, "com.obric.memorydata.plugin"));
            }
        }

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
        public static final class b<T> implements Comparator {
            public b() {
            }

            @Override // java.util.Comparator
            public final int compare(T r2, T r3) {
                d r1 = (d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.memorydata.plugin");
                Comparable r4 = (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(com.obric.aikernel.res.metadata.data.b.e.a(r1.t())), Comparable.class, "com.obric.memorydata.plugin");
                d r5 = (d) ZeusTransformUtils.preCheckCast(r2, d.class, "com.obric.memorydata.plugin");
                return ComparisonsKt.compareValues(r4, (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(com.obric.aikernel.res.metadata.data.b.e.a(r5.t())), Comparable.class, "com.obric.memorydata.plugin"));
            }
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        private final List<String> a(com.obric.aikernel.res.metadata.data.b r5) {
            Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(r5.p(), Iterable.class, "com.obric.memorydata.plugin");
            Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
            Iterator r7 = r4.iterator();
        L4:
            if (r7.hasNext() == false) goto L12;
            d r1 = (d) ZeusTransformUtils.preCheckCast(r7.next(), d.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r1, com.obric.aikernel.res.metadata.data.a.class) == false) goto L8;
            String r2 = r1.s() + '@' + r1.t();
        L9:
            if (r2 == null) goto L4;
            r6.add(r2);
            goto L4
        L8:
            r2 = (String) ZeusTransformUtils.preCheckCast(null, String.class, "com.obric.memorydata.plugin");
            goto L9
        L12:
            return (List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin");
        }

        private final boolean a(f r18, com.obric.aikernel.res.metadata.data.b r19, List<String> r20) {
            List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r20, List.class, "com.obric.memorydata.plugin");
            if (r19 != null) goto L5;
            com.obric.aikernel.runtime.utils.d r0 = com.obric.aikernel.runtime.utils.d.f6216a;
            StringBuilder r1 = new StringBuilder().append("getLora: ").append(r18).append(" try match ").append(r19);
            String r2 = " failed, type is illegal!";
        L28:
            StringBuilder r4 = r1.append(r2);
        L29:
            r0.f(PackageResourceManager.TAG, r4.toString());
        L30:
            return false;
        L5:
            if (r19.d() == true) goto L7;
            r0 = com.obric.aikernel.runtime.utils.d.f6216a;
            StringBuilder r5 = new StringBuilder().append("getLora: ").append(r18).append(" try match ").append(r19).append(" failed, pkg is not avail, res ");
            Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r19.p(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L21:
            if (r6.hasNext() == false) goto L25;
            Object r7 = r6.next();
            if (((d) ZeusTransformUtils.preCheckCast(r7, d.class, "com.obric.memorydata.plugin")).d() == false) goto L21;
        L26:
            r1 = r5.append(r7);
            r2 = " is not avail.";
            goto L28
        L25:
            r7 = null;
            goto L26
        L7:
            if (r3.contains(r18.j()) == true) goto L9;
            r0 = com.obric.aikernel.runtime.utils.d.f6216a;
            r1 = new StringBuilder().append("getLora: ").append(r18).append(" try match ").append(r19).append(" failed, ").append(r18.j()).append(" not in current valid list: ");
            r2 = CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin"), null, null, null, 0, null, null, 63, null);
            goto L28
        L9:
            if (Intrinsics.areEqual(r19.s(), r18.p()) == true) goto L11;
            r0 = com.obric.aikernel.runtime.utils.d.f6216a;
            r4 = new StringBuilder().append("getLora: ").append(r18).append(" try match ").append(r19).append(" failed, name: ").append(r19.s()).append(" : ").append(r18.p());
            goto L29
        L11:
            if (com.obric.aikernel.res.metadata.data.b.e.a(r19.t()) >= r18.k()) goto L13;
            r0 = com.obric.aikernel.runtime.utils.d.f6216a;
            r4 = new StringBuilder().append("getLora: ").append(r18).append(" try match ").append(r19).append(" failed, version:").append(com.obric.aikernel.res.metadata.data.b.e.a(r19.t())).append(" < ").append(r18.k());
            goto L29
        L13:
            if (a(r19).contains(r18.j()) == false) goto L15;
            com.obric.aikernel.runtime.utils.d.f6216a.e(PackageResourceManager.TAG, "getLora: " + r18 + " match " + r19 + " success.");
            return true;
        L15:
            com.obric.aikernel.runtime.utils.d.f6216a.f(PackageResourceManager.TAG, "getLora: " + r18 + " try match " + r19 + " failed, baseModel: " + r18.j() + " not in " + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(a(r19), Iterable.class, "com.obric.memorydata.plugin"), null, null, null, 0, null, null, 63, null));
            goto L30
        }

        public final Pair<f, com.obric.aikernel.res.metadata.data.b> a(String r23, String r24, PrmContext r25) {
            Intrinsics.checkNotNullParameter(r23, "pkgName");
            Intrinsics.checkNotNullParameter(r24, Params.LORA_TYPE);
            Intrinsics.checkNotNullParameter(r25, "context");
            String r2 = new f(r24, "", r25.getConfig()).w();
            String[] r4 = new File(r2).list();
            boolean r6 = true;
            if (r4 == null) goto L11;
            Intrinsics.checkNotNullExpressionValue(r4, "it");
            if (r4.length != 0) goto L7;
            boolean r7 = true;
        L9:
            if ((!r7) != true) goto L11;
            boolean r8 = true;
        L12:
            char r9 = ',';
            if (r8 == true) goto L16;
            com.obric.aikernel.runtime.utils.d.f6216a.f(PackageResourceManager.TAG, "getLora: " + r23 + ',' + r24 + " get empty loras from " + r2);
        L16:
            if (r4 == null) goto L86;
            List r5 = ArraysKt.sortedWith(r4, (Comparator) ZeusTransformUtils.preCheckCast(new C0265a(), Comparator.class, "com.obric.memorydata.plugin"));
            if (r5 == null) goto L86;
            Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L21:
            if (r10.hasNext() == false) goto L86;
            String r11 = (String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.memorydata.plugin");
            com.obric.aikernel.runtime.utils.d.f6216a.d(PackageResourceManager.TAG, "getLora: " + r23 + r9 + r24 + " trying version " + r11);
            Intrinsics.checkNotNullExpressionValue(r11, "version");
            f r12 = new f(r24, r11, r25.getConfig());
            if (r12.J() != null) goto L27;
            com.obric.aikernel.runtime.utils.d r13 = com.obric.aikernel.runtime.utils.d.f6216a;
            String r14 = PackageResourceManager.TAG;
            StringBuilder r15 = new StringBuilder().append("getLora: ").append(r12).append(" config is null!");
        L25:
            r13.e(r14, r15.toString());
        L85:
            r6 = true;
            r9 = ',';
            goto L21
        L27:
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r23, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L29;
            boolean r16 = r6;
        L30:
            if (r16 == false) goto L35;
            if (Intrinsics.areEqual(r12.p(), r23) == true) goto L35;
            r13 = com.obric.aikernel.runtime.utils.d.f6216a;
            r14 = PackageResourceManager.TAG;
            r15 = new StringBuilder().append("getLora: ").append(r12).append(" of pkg ").append(r12.p()).append(" not match ").append(r23);
        L35:
            if (r12.d() == false) goto L84;
            com.obric.aikernel.res.metadata.data.b r17 = com.obric.aikernel.res.metadata.c.f6058a.b();
            if (r17 != null) goto L39;
            Unit r18 = null;
        L51:
            if (r18 != null) goto L85;
            a r19 = f.f6090a;
            com.obric.aikernel.runtime.utils.d.f6216a.d(PackageResourceManager.TAG, "getLora: " + r12 + " match from VlmLocalVersionConstrict failed.");
            com.obric.aikernel.res.metadata.data.b r110 = r25.getMetadataCtrl$resource_manager_release().a(r12.p());
            if (r110 == null) goto L56;
            List<String> r111 = r19.a(r110);
            if (r111 == null) goto L56;
        L58:
            if (r19.a(r12, r110, r111) == false) goto L60;
            d r20 = (d) ZeusTransformUtils.preCheckCast(r110, d.class, "com.obric.memorydata.plugin");
        L78:
            if (r20 == null) goto L85;
            return new Pair(r12, (com.obric.aikernel.res.metadata.data.b) ZeusTransformUtils.preCheckCast(r20, com.obric.aikernel.res.metadata.data.b.class, "com.obric.memorydata.plugin"));
        L60:
            com.obric.aikernel.runtime.utils.d.f6216a.f(PackageResourceManager.TAG, "getLora: " + r12 + " match from current failed. " + r110);
            Map<String, d> r112 = r25.getMetadataCtrl$resource_manager_release().b().a("package", r12.p());
            monitor-enter(r112);
            List r113 = CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r112.values(), Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new b(), Comparator.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L81
            if (r113.isEmpty() == false) goto L65;
            com.obric.aikernel.runtime.utils.d.f6216a.f(PackageResourceManager.TAG, "getLora: " + r12 + " get empty pkgList of " + r12.p());     // Catch: Throwable -> L81
        L65:
            monitor-exit(r112);
            Iterator r21 = ((Iterable) ZeusTransformUtils.preCheckCast(r113, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L68:
            if (r21.hasNext() == false) goto L76;
            Object r114 = r21.next();
            d r115 = (d) ZeusTransformUtils.preCheckCast(r114, d.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r115, com.obric.aikernel.res.metadata.data.b.class) == false) goto L72;
            com.obric.aikernel.res.metadata.data.b r116 = (com.obric.aikernel.res.metadata.data.b) ZeusTransformUtils.preCheckCast(r115, com.obric.aikernel.res.metadata.data.b.class, "com.obric.memorydata.plugin");
        L74:
            if (r19.a(r12, r116, r111) == false) goto L68;
        L77:
            r20 = (d) ZeusTransformUtils.preCheckCast(r114, d.class, "com.obric.memorydata.plugin");
            goto L78
        L72:
            r116 = null;
            goto L74
        L76:
            r114 = null;
        L81:
            th = move-exception;
            throw th;
        L56:
            com.obric.aikernel.runtime.utils.d.f6216a.f(PackageResourceManager.TAG, "getLora: get empty modelTags form " + r110);
            r111 = CollectionsKt.emptyList();
            goto L58
        L39:
            if (Intrinsics.areEqual(r17.s(), r12.p()) == true) goto L41;
            com.obric.aikernel.runtime.utils.d r117 = com.obric.aikernel.runtime.utils.d.f6216a;
            String r118 = PackageResourceManager.TAG;
            StringBuilder r22 = new StringBuilder().append("getLora: ").append(r12).append(" match VlmLocalVersionConstrict ").append(r17).append(" failed, name: ").append(r17.s()).append(" : ").append(r12.p());
        L49:
            r117.f(r118, r22.toString());
            r18 = Unit.INSTANCE;
            goto L51
        L41:
            if (com.obric.aikernel.res.metadata.data.b.e.a(r17.t()) >= r12.k()) goto L43;
            r117 = com.obric.aikernel.runtime.utils.d.f6216a;
            r118 = PackageResourceManager.TAG;
            r22 = new StringBuilder().append("getLora: ").append(r12).append(" match VlmLocalVersionConstrict ").append(r17).append(" failed, version:").append(com.obric.aikernel.res.metadata.data.b.e.a(r17.t())).append(" < ").append(r12.k());
            goto L49
        L43:
            if (f.f6090a.a(r17).contains(r12.j()) == true) goto L44;
            r117 = com.obric.aikernel.runtime.utils.d.f6216a;
            r118 = PackageResourceManager.TAG;
            r22 = new StringBuilder().append("getLora: ").append(r12).append(" match VlmLocalVersionConstrict ").append(r17).append(" failed, baseModel: ").append(r12.j()).append(" not in ").append(CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(f.f6090a.a(r17), Iterable.class, "com.obric.memorydata.plugin"), null, null, null, 0, null, null, 63, null));
            goto L49
        L44:
            com.obric.aikernel.runtime.utils.d.f6216a.e(PackageResourceManager.TAG, "getLora: " + r12 + " match VlmLocalVersionConstrict " + r17 + " success.");
            return new Pair(r12, r17);
        L84:
            com.obric.aikernel.runtime.utils.d.f6216a.e(PackageResourceManager.TAG, "getLora: " + r12 + " is not avail. " + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r12.q(), Iterable.class, "com.obric.memorydata.plugin"), null, null, null, 0, null, (Function1) ZeusTransformUtils.preCheckCast(Lora$Companion$getLora$3$3.INSTANCE, Function1.class, "com.obric.memorydata.plugin"), 31, null));
            goto L85
        L29:
            r16 = false;
        L86:
            return null;
        L7:
            r7 = false;
        L11:
            r8 = false;
            goto L12
        }

        public final boolean a(String r1, String r2, PackageResourceManager.PresmConfig r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r1, Params.LORA_TYPE);
            Intrinsics.checkNotNullParameter(r2, "version");
            Intrinsics.checkNotNullParameter(r3, "config");
            f r0 = new f(r1, r2, r3);
            if (r0.d() == true) goto L5;
        L8:
            return true;
        L5:
            if (r0.a(r4) == true) goto L8;
            return false;
        }
    }

    static {
        f6090a = new a(null);
    }

    public f(final String r18, String r19, PackageResourceManager.PresmConfig r20) {
        Intrinsics.checkNotNullParameter(r18, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r19, "version");
        Intrinsics.checkNotNullParameter(r20, "config");
        super(r18, r19, r20);
        this.f6091b = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new Lora$loraConfig$2(r18, this), Function0.class, "com.obric.memorydata.plugin"));
        this.c = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new Lora$baseModelTag$2(this), Function0.class, "com.obric.memorydata.plugin"));
        this.d = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new Lora$packageMinVersion$2(this), Function0.class, "com.obric.memorydata.plugin"));
        this.e = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new Lora$packageName$2(this), Function0.class, "com.obric.memorydata.plugin"));
        this.g = CollectionsKt.emptyList();
        File r2 = new File(w(), "depends");
        this.h = r2;
        List<? extends com.obric.aikernel.res.metadata.data.a> r3 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        String[] r4 = r2.list();
        if (r4 == null) goto L25;
        int r5 = r4.length;
        int r7 = 0;
        boolean r8 = false;
    L6:
        if (r7 >= r5) goto L17;
        String r10 = r4[r7];
        Intrinsics.checkNotNullExpressionValue(r10, "it");
        List r11 = StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin"), new char[]{'@'}, false, 0, 6, null);
        if (r11.size() == 2) goto L10;
    L15:
        com.obric.aikernel.runtime.utils.d.f6216a.f(PackageResourceManager.TAG, this + " path is illegal: " + this.h + '/' + r18);
        r8 = true;
    L16:
        r7 = r7 + 1;
        goto L6
    L10:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r11.get(0), CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L15;
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r11.get(1), CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L15;
        r3.add(new com.obric.aikernel.res.metadata.data.a((String) ZeusTransformUtils.preCheckCast(r11.get(0), String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r11.get(1), String.class, "com.obric.memorydata.plugin"), u()));
        goto L16
    L17:
        Unit r1 = Unit.INSTANCE;
        if (r8 == false) goto L20;
        com.obric.aikernel.runtime.utils.d.f6216a.f(PackageResourceManager.TAG, this + " has empty depend name! ignore loaded dep res.");
        return;
    L20:
        this.g = r3;
        return;
    }

    @Override // com.obric.aikernel.res.metadata.data.d
    public JsonObject D() {
        return new JsonObject();
    }

    @Override // com.obric.aikernel.res.metadata.data.d
    public void a(PrmContext r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super.a(r10);
        String r0 = s();
        com.obric.aikernel.res.metadata.config.a r1 = J();
        Intrinsics.checkNotNull(r1);
        com.obric.aikernel.res.metadata.config.e r11 = new com.obric.aikernel.res.metadata.config.e(r0, r1.b());
        if (this.h.exists() == true) goto L5;
        this.h.mkdirs();
    L5:
        List<? extends com.obric.aikernel.res.metadata.data.a> r2 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(r11.m(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L7:
        if (r3.hasNext() == false) goto L18;
        com.obric.aikernel.res.metadata.config.a r4 = (com.obric.aikernel.res.metadata.config.a) ZeusTransformUtils.preCheckCast(r3.next(), com.obric.aikernel.res.metadata.config.a.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r4.a(), CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L16;
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r4.c(), CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L16;
        File r5 = new File(this.h, r4.a() + '@' + r4.c());
        if (r5.exists() == true) goto L15;
        r5.createNewFile();
    L15:
        r2.add(new com.obric.aikernel.res.metadata.data.a(r4.a(), r4.c(), u()));
    L16:
        z().delete();
        K();
        FilesKt.deleteRecursively(this.h);
        L();
        throw new IllegalStateException(this + " config is broken, dep tag is empty. Src: " + r11.b());
    L18:
        this.g = r2;
        if (r2.isEmpty() == false) goto L21;
        com.obric.aikernel.runtime.utils.d.f6216a.f(PackageResourceManager.TAG, this + " installed but res isEmpty. Src: " + r11.b());
    L21:
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(this.g, Iterable.class, "com.obric.memorydata.plugin");
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r13 = r12.iterator();
    L23:
        if (r13.hasNext() == false) goto L25;
        com.obric.aikernel.res.metadata.data.a r7 = (com.obric.aikernel.res.metadata.data.a) ZeusTransformUtils.preCheckCast(r13.next(), com.obric.aikernel.res.metadata.data.a.class, "com.obric.memorydata.plugin");
        r6.add(r7.s() + '@' + r7.t());
        goto L23
    L25:
        List r14 = (List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin");
        String[] r8 = this.h.list();
        if (r8 == null) goto L37;
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        int r15 = 0;
        int r16 = r8.length;
    L28:
        if (r15 >= r16) goto L33;
        String r17 = r8[r15];
        if ((!r14.contains(r17)) == false) goto L32;
        r9.add(r17);
    L32:
        r15 = r15 + 1;
        goto L28
    L33:
        Iterator r18 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L35:
        if (r18.hasNext() == false) goto L48;
        new File(this.h, (String) ZeusTransformUtils.preCheckCast(r18.next(), String.class, "com.obric.memorydata.plugin")).delete();
        goto L35
    L48:
        return;
    }

    @Override // com.obric.aikernel.res.metadata.data.d
    public boolean a_(boolean r5) {
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(this.g, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        if (((com.obric.aikernel.res.metadata.data.a) ZeusTransformUtils.preCheckCast(r0.next(), com.obric.aikernel.res.metadata.data.a.class, "com.obric.memorydata.plugin")).a_(r5) == false) goto L4;
        return true;
    L10:
        return super.a_(r5);
    }

    @Override // com.obric.aikernel.res.metadata.data.d
    public boolean c(boolean r2) {
        if (J() == null) goto L7;
        return true;
    L7:
        throw new IllegalStateException(this + " missing config file!");
    }

    @Override // com.obric.aikernel.res.metadata.data.d
    public boolean d() {
        if (e() == false) goto L13;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(this.g, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L13;
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(this.g, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L8:
        if (r5.hasNext() == false) goto L17;
        if (((com.obric.aikernel.res.metadata.data.a) ZeusTransformUtils.preCheckCast(r5.next(), com.obric.aikernel.res.metadata.data.a.class, "com.obric.memorydata.plugin")).d() == true) goto L8;
        return false;
    L17:
        return true;
    L13:
        return false;
    }

    @Override // com.obric.aikernel.res.metadata.data.d
    public boolean f() {
        if (J() != null) goto L5;
    L9:
        return false;
    L5:
        if (y().exists() == false) goto L9;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(this.g, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L9;
        return true;
    }

    public final com.obric.aikernel.res.metadata.config.e g() {
        return (com.obric.aikernel.res.metadata.config.e) ZeusTransformUtils.preCheckCast(this.f6091b.getValue(), com.obric.aikernel.res.metadata.config.e.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.aikernel.res.metadata.data.d
    public String getType() {
        return "lora";
    }

    @Override // com.obric.aikernel.res.metadata.data.d
    public String h() {
        return "loras";
    }

    @Override // com.obric.aikernel.res.metadata.data.d
    public Uri i() {
        return null;
    }

    public final String j() {
        return (String) ZeusTransformUtils.preCheckCast(this.c.getValue(), String.class, "com.obric.memorydata.plugin");
    }

    public final int k() {
        return ((Number) ZeusTransformUtils.preCheckCast(this.d.getValue(), Number.class, "com.obric.memorydata.plugin")).intValue();
    }

    public final String p() {
        return (String) ZeusTransformUtils.preCheckCast(this.e.getValue(), String.class, "com.obric.memorydata.plugin");
    }

    public final List<com.obric.aikernel.res.metadata.data.a> q() {
        return this.g;
    }
}
