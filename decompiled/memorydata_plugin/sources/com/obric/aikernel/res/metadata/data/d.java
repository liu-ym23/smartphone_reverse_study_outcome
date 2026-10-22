package com.obric.aikernel.res.metadata.data;

import android.content.Context;
import android.net.Uri;
import android.system.Os;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.aikernel.res.PackageResourceManager;
import com.obric.aikernel.res.PrmContext;
import com.obric.aikernel.res.metadata.config.k;
import com.ss.android.ttmd5.TTMd5;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u001c\b&\u0018\u0000 j2\u00020\u0001:\u0001jB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0012\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020#H\u0016J\u0012\u0010%\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020#H\u0016J\u0010\u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020(H\u0002J\u0017\u0010)\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020#H\u0010¢\u0006\u0002\b*J\b\u0010+\u001a\u00020#H\u0002J\u0006\u0010,\u001a\u00020-J\b\u0010.\u001a\u00020#H\u0016J\b\u0010/\u001a\u00020#H\u0016J\u0006\u00100\u001a\u00020#J\n\u00101\u001a\u0004\u0018\u00010(H\u0016J\b\u00102\u001a\u0004\u0018\u000103J\b\u00104\u001a\u00020\u0003H\u0016J\n\u00105\u001a\u0004\u0018\u000106H\u0016J\u0010\u00107\u001a\u0004\u0018\u0001062\u0006\u00108\u001a\u00020\u0003J\b\u00109\u001a\u00020\u0003H&J\b\u0010:\u001a\u00020\u0003H&J\b\u0010;\u001a\u00020\u0003H\u0002J\u0006\u0010<\u001a\u00020\u0003J\u0006\u0010=\u001a\u00020#J\u0010\u0010>\u001a\u00020-2\u0006\u0010?\u001a\u00020@H\u0014J\b\u0010A\u001a\u00020#H\u0016J\u0006\u0010B\u001a\u00020#J\u0010\u0010C\u001a\u00020#2\b\u0010D\u001a\u0004\u0018\u000106J\u0012\u0010E\u001a\u00020-2\b\b\u0002\u0010F\u001a\u00020GH\u0016J\b\u0010H\u001a\u00020#H\u0016J\b\u0010I\u001a\u00020-H\u0016J\u000e\u0010J\u001a\u00020-2\u0006\u0010K\u001a\u00020\fJ\u0006\u0010L\u001a\u00020-J\u0016\u0010M\u001a\u00020-2\f\u0010N\u001a\b\u0012\u0004\u0012\u00020\f0OH\u0004J\b\u0010P\u001a\u00020-H\u0014J\b\u0010Q\u001a\u00020-H\u0014J\u0016\u0010R\u001a\u00020#2\f\u0010N\u001a\b\u0012\u0004\u0012\u00020\f0OH\u0004J\n\u0010S\u001a\u0004\u0018\u000103H\u0014J\u001e\u0010T\u001a\u00020#2\u0006\u0010?\u001a\u00020@2\u0006\u0010U\u001a\u00020#2\u0006\u0010V\u001a\u00020#J\b\u0010W\u001a\u00020-H\u0014J\u000f\u0010X\u001a\u0004\u0018\u00010\fH\u0000¢\u0006\u0002\bYJ\u0010\u0010Z\u001a\u00020-2\u0006\u0010[\u001a\u000203H\u0002J\b\u0010\\\u001a\u00020#H\u0016J\b\u0010]\u001a\u00020#H\u0016J\u0018\u0010^\u001a\u00020-2\u0006\u0010_\u001a\u0002032\b\b\u0002\u0010`\u001a\u00020#J\u0012\u0010a\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020#H\u0016J\b\u0010b\u001a\u00020\u0003H\u0016J\b\u0010c\u001a\u00020#H\u0016J\u0012\u0010d\u001a\u00020#*\u0002062\u0006\u0010e\u001a\u00020\u0003J\u0012\u0010f\u001a\u00020#*\u0002062\u0006\u0010g\u001a\u00020GJ\n\u0010h\u001a\u00020-*\u000206J\u0014\u0010i\u001a\u00020#*\u0002062\u0006\u0010_\u001a\u00020\u0006H\u0004R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\n\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000eR\u0014\u0010\u0017\u001a\u00020\fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\nR\u0014\u0010\u001a\u001a\u00020\fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u000eR\u000e\u0010\u001c\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001d\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\nR\u0014\u0010\u001f\u001a\u00020\fX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\n¨\u0006k"}, d2 = {"Lcom/obric/aikernel/res/metadata/data/BaseMetadata;", "", ActivityLifecycle.NAME, "", "version", "cfg", "Lcom/obric/aikernel/res/PackageResourceManager$PresmConfig;", "(Ljava/lang/String;Ljava/lang/String;Lcom/obric/aikernel/res/PackageResourceManager$PresmConfig;)V", "absolutePath", "getAbsolutePath", "()Ljava/lang/String;", "availFlag", "Ljava/io/File;", "getAvailFlag$resource_manager_release", "()Ljava/io/File;", "getCfg", "()Lcom/obric/aikernel/res/PackageResourceManager$PresmConfig;", "depVersion", "getDepVersion", "setDepVersion", "(Ljava/lang/String;)V", "expectedLinkTarget", "getExpectedLinkTarget$resource_manager_release", "linkFile", "getLinkFile$resource_manager_release", "getName", "reinstallFlag", "getReinstallFlag$resource_manager_release", "relativePath", "resAbsolutePath", "getResAbsolutePath", "stateDir", "getStateDir", "getVersion", "checkResource", "", "fastMode", "checkResourceFull", "checkResourceIsComplete", "checkerConfig", "Lcom/google/gson/JsonObject;", "checkShouldReinstall", "checkShouldReinstall$resource_manager_release", "clean", "deleteConfig", "", "disable", "enable", "ensureShouldReinstall", "getCheckerConfig", "getConfig", "Lcom/obric/aikernel/res/metadata/config/DistConfig;", "getExtra", "getInnerResUri", "Landroid/net/Uri;", "getResPartUri", "path", "getType", "getTypeRootPath", "getUsageFile", "getVersionForVm", "hasReinstallFlag", "install", "ctx", "Lcom/obric/aikernel/res/PrmContext;", "isAvailable", "isConfigFileExist", "isResExist", "uri", "loggerUsage", OaidModel.KEY_TIME, "", "longTimeNoUsage", "makeAvail", "markLinkFile", TypedValues.AttributesType.S_TARGET, "markReInstall", "offline", "flags", "", "onInstallFailed", "onInstallSucceed", "online", "overrideConfig", "performInstall", "override", "fastCheck", "prepareInstall", "readLinkTarget", "readLinkTarget$resource_manager_release", "repairConfig", "updating", "resourceIsAvailable", "resourceIsReady", "saveConfig", "config", "skipExist", "shouldReInstall", "toString", "uninstall", "checkMd5", "md5", "checkSize", "size", "delete", "isExist", "Companion", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class d {
    public static final a f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f6088a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f6089b;
    private final PackageResourceManager.PresmConfig c;
    private String d;
    private final String e;
    private final String g;
    private final String h;
    private final File i;
    private final File j;
    private final File k;
    private final File l;
    private final File m;

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0013J \u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0017J\"\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00192\u0006\u0010\u0016\u001a\u00020\u0017J\"\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00042\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020!0 R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/obric/aikernel/res/metadata/data/BaseMetadata$Companion;", "", "()V", "CHECKER_FILE", "", "CONFIG_FILE_NAME", "FILE_USAGE_TAG", "TAG", "TYPE_AIKERNEL_LORA", "TYPE_AIKERNEL_PKG", "TYPE_AI_PACKAGE", "TYPE_LIB", "TYPE_LORA", "TYPE_MODEL", "getConfig", "Lcom/obric/aikernel/res/metadata/config/DistConfig;", "type", ActivityLifecycle.NAME, "absolutePath", "Ljava/io/File;", "getNewestConfig", "Lcom/obric/aikernel/res/metadata/config/UpdateTaskConfig;", "config", "Lcom/obric/aikernel/res/PackageResourceManager$PresmConfig;", "parseMetadata", "", "Lcom/obric/aikernel/res/metadata/data/BaseMetadata;", "infos", "writeCheckerFile", "", "path", "checkInfo", "", "", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final com.obric.aikernel.res.metadata.config.a a(String r7, String r8, File r9) {
            Intrinsics.checkNotNullParameter(r7, "type");
            Intrinsics.checkNotNullParameter(r8, ActivityLifecycle.NAME);
            Intrinsics.checkNotNullParameter(r9, "absolutePath");
            File r1 = new File(r9, "configuration.json");
            Object r2 = null;
            if (r1.exists() == true) goto L29;
            return null;
        L29:
            Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L14
            Closeable r11 = (Closeable) ZeusTransformUtils.preCheckCast(new FileReader(r1), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
            JsonObject r3 = (JsonObject) ZeusTransformUtils.preCheckCast(new Gson().fromJson((Reader) ZeusTransformUtils.preCheckCast((FileReader) ZeusTransformUtils.preCheckCast(r11, FileReader.class, "com.obric.memorydata.plugin"), Reader.class, "com.obric.memorydata.plugin"), JsonObject.class), JsonObject.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
            CloseableKt.closeFinally(r11, null);     // Catch: Throwable -> L14
            Intrinsics.checkNotNullExpressionValue(r3, "FileReader(configFile).u…s.java)\n                }");     // Catch: Throwable -> L14
            Object r12 = Result.m1421constructorimpl(new com.obric.aikernel.res.metadata.config.a(r7, r8, r3));     // Catch: Throwable -> L14
        L16:
            Throwable r13 = Result.m1424exceptionOrNullimpl(r12);
            if (r13 == null) goto L20;
            r1.delete();
            com.obric.aikernel.runtime.utils.d.f6216a.c(PackageResourceManager.TAG, this + " getConfig delete corrupted config file! " + ExceptionsKt.stackTraceToString(r13));
        L20:
            if (Result.m1427isFailureimpl(r12) == true) goto L24;
            r2 = r12;
        L24:
            return (com.obric.aikernel.res.metadata.config.a) ZeusTransformUtils.preCheckCast(r2, com.obric.aikernel.res.metadata.config.a.class, "com.obric.memorydata.plugin");
        L9:
            th = move-exception;
            throw th;     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            CloseableKt.closeFinally(r11, th);     // Catch: Throwable -> L14
            throw th;     // Catch: Throwable -> L14
        L14:
            th = move-exception;
            Result.Companion r14 = Result.Companion;
            r12 = Result.m1421constructorimpl(ResultKt.createFailure(th));
            goto L16
        }

        /* JADX WARN: Type inference failed for: r1v2, types: [kotlin.collections.IntIterator] */
        /* JADX WARN: Type inference failed for: r1v4, types: [kotlin.collections.IntIterator] */
        public final k a(String r8, String r9, PackageResourceManager.PresmConfig r10) {
            Intrinsics.checkNotNullParameter(r8, "type");
            Intrinsics.checkNotNullParameter(r9, ActivityLifecycle.NAME);
            Intrinsics.checkNotNullParameter(r10, "config");
            Object r5 = null;
            if (Intrinsics.areEqual(r8, "package") == false) goto L30;
            String[] r7 = new File(new b(r9, "", r10).w()).list();
            if (r7 == null) goto L54;
            if (r7.length != 0) goto L9;
            boolean r11 = true;
        L10:
            if (r11 == false) goto L12;
            String r12 = null;
        L21:
            if (r12 == null) goto L54;
            String r13 = r12.toString();
            if (r13 == null) goto L54;
            com.obric.aikernel.res.metadata.config.a r14 = new b(r9, r13, r10).J();
            if (r14 == null) goto L54;
            Object r15 = new com.obric.aikernel.res.metadata.config.i(r9, r14.b(), r10);
        L27:
            r5 = r15;
            goto L54
        L12:
            r12 = r7[0];
            int r1 = ArraysKt.getLastIndex(r7);
            if (r1 == 0) goto L21;
            b.a r4 = b.e;
            Intrinsics.checkNotNullExpressionValue(r12, "it");
            int r6 = r4.a(r12);
            ?? r2 = new IntRange(1, r1).iterator();
        L17:
            if (r2.hasNext() == false) goto L21;
            String r3 = r7[r2.nextInt()];
            b.a r16 = b.e;
            Intrinsics.checkNotNullExpressionValue(r3, "it");
            int r17 = r16.a(r3);
            if (r6 >= r17) goto L17;
            r12 = r3;
            r6 = r17;
            goto L17
        L9:
            r11 = false;
        L54:
            return (k) ZeusTransformUtils.preCheckCast(r5, k.class, "com.obric.memorydata.plugin");
        L30:
            if (Intrinsics.areEqual(r8, "lora") == false) goto L65;
            String[] r18 = new File(new f(r9, "", r10).w()).list();
            if (r18 == null) goto L54;
            if (r18.length != 0) goto L36;
            boolean r19 = true;
        L37:
            if (r19 == false) goto L39;
            String r20 = null;
        L48:
            if (r20 == null) goto L54;
            String r21 = r20.toString();
            if (r21 == null) goto L54;
            com.obric.aikernel.res.metadata.config.a r22 = new f(r9, r21, r10).J();
            if (r22 == null) goto L54;
            r15 = new com.obric.aikernel.res.metadata.config.e(r9, r22.b());
            goto L27
        L39:
            r20 = r18[0];
            int r23 = ArraysKt.getLastIndex(r18);
            if (r23 == 0) goto L48;
            b.a r24 = b.e;
            Intrinsics.checkNotNullExpressionValue(r20, "it");
            int r25 = r24.a(r20);
            ?? r26 = new IntRange(1, r23).iterator();
        L44:
            if (r26.hasNext() == false) goto L48;
            String r27 = r18[r26.nextInt()];
            b.a r28 = b.e;
            Intrinsics.checkNotNullExpressionValue(r27, "it");
            int r29 = r28.a(r27);
            if (r25 >= r29) goto L44;
            r20 = r27;
            r25 = r29;
            goto L44
        L36:
            r19 = false;
            goto L37
        L65:
            return null;
        }

        public final List<d> a(List<String> r9, PackageResourceManager.PresmConfig r10) {
            List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r8, "infos");
            Intrinsics.checkNotNullParameter(r10, "config");
            Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin");
            Collection r12 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
            Iterator r13 = r11.iterator();
        L4:
            if (r13.hasNext() == false) goto L31;
            List r1 = StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r13.next(), String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin"), new String[]{"@"}, false, 0, 6, null);
            String r2 = (String) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(r1), String.class, "com.obric.memorydata.plugin");
            if (r2 != null) goto L8;
        L27:
            d r3 = null;
        L28:
            if (r3 == null) goto L4;
            r12.add(r3);
            goto L4
        L8:
            switch(r2.hashCode()) {
                case -807062458: goto L23;
                case 107141: goto L19;
                case 3327730: goto L15;
                case 104069929: goto L11;
                default: goto L27;
            };
        L11:
            if (r2.equals("model") == false) goto L27;
            Object r4 = new com.obric.aikernel.res.metadata.data.a((String) ZeusTransformUtils.preCheckCast(r1.get(1), String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r1.get(2), String.class, "com.obric.memorydata.plugin"), r10);
        L26:
            r3 = (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.memorydata.plugin");
            goto L28
        L15:
            if (r2.equals("lora") == false) goto L27;
            r4 = new f((String) ZeusTransformUtils.preCheckCast(r1.get(1), String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r1.get(2), String.class, "com.obric.memorydata.plugin"), r10);
            goto L26
        L19:
            if (r2.equals("lib") == false) goto L27;
            r4 = new i((String) ZeusTransformUtils.preCheckCast(r1.get(1), String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r1.get(2), String.class, "com.obric.memorydata.plugin"), r10);
            goto L26
        L23:
            if (r2.equals("package") == false) goto L27;
            r4 = new b((String) ZeusTransformUtils.preCheckCast(r1.get(1), String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r1.get(2), String.class, "com.obric.memorydata.plugin"), r10);
            goto L26
        L31:
            return (List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.memorydata.plugin");
        }

        public final void a(String r7, Map<String, Long> r8) {
            Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r7, "path");
            Intrinsics.checkNotNullParameter(r6, "checkInfo");
            File r9 = new File(r7, "checker_v2.json");
            com.obric.aikernel.res.utils.a r10 = com.obric.aikernel.res.utils.a.f6155a;
            JsonObject r1 = new JsonObject();
            Iterator r11 = r6.entrySet().iterator();
        L4:
            if (r11.hasNext() == false) goto L6;
            Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r11.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            String r3 = (String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.memorydata.plugin");
            long r4 = ((Number) ZeusTransformUtils.preCheckCast(r2.getValue(), Number.class, "com.obric.memorydata.plugin")).longValue();
            JsonObject r5 = new JsonObject();
            r5.addProperty("size", (Number) ZeusTransformUtils.preCheckCast(Long.valueOf(r4), Number.class, "com.obric.memorydata.plugin"));
            Unit r12 = Unit.INSTANCE;
            r1.add(r3, (JsonElement) ZeusTransformUtils.preCheckCast(r5, JsonElement.class, "com.obric.memorydata.plugin"));
            goto L4
        L6:
            Unit r13 = Unit.INSTANCE;
            String r14 = r1.toString();
            Intrinsics.checkNotNullExpressionValue(r14, "JsonObject().apply {\n   …             }.toString()");
            r10.b(r9, r14);
        }
    }

    static {
        f = new a(null);
    }

    public d(String r4, String r5, PackageResourceManager.PresmConfig r6) {
        Intrinsics.checkNotNullParameter(r4, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r5, "version");
        Intrinsics.checkNotNullParameter(r6, "cfg");
        this.f6088a = r4;
        this.f6089b = r5;
        this.c = r6;
        this.d = "0";
        String r7 = h() + '/' + r4 + '/' + r5;
        this.e = r7;
        String r0 = r6.getRootDir() + '/' + r7;
        this.g = r0;
        String r8 = r6.getResRootDir() + '/' + r7;
        this.h = r8;
        File r9 = new File(r0 + "/state");
        this.i = r9;
        this.j = new File(r9, "enable");
        this.k = new File(r9, "reinstall");
        this.l = new File(r0, "uri_link");
        this.m = new File(r8, r4);
    }

    private final void a(com.obric.aikernel.res.metadata.config.a r8) {
        com.obric.aikernel.res.metadata.config.a r0 = J();
        if (r0 == null) goto L18;
        JsonObject r1 = r0.b();
        if (r1 != null) goto L7;
        return;
    L7:
        if (Intrinsics.areEqual(r8.getType(), r0.getType()) == true) goto L9;
        return;
    L9:
        if (Intrinsics.areEqual(r8.a(), r0.a()) == true) goto L11;
        return;
    L11:
        if (Intrinsics.areEqual(r8.c(), r0.c()) == false) goto L22;
        String r2 = r1.toString();
        Intrinsics.checkNotNullExpressionValue(r2, "curCfg.toString()");
        String r3 = r8.b().toString();
        Intrinsics.checkNotNullExpressionValue(r3, "updating.json.toString()");
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L15;
        return;
    L15:
        if (Intrinsics.areEqual(r2, r3) == true) goto L24;
        com.obric.aikernel.runtime.utils.d.f6216a.f(PackageResourceManager.TAG, "repairConfig " + this + " override not consist config by update");
        com.obric.aikernel.runtime.utils.d.f6216a.d(PackageResourceManager.TAG, "repairConfig " + this + " Current: " + r2);
        com.obric.aikernel.runtime.utils.d.f6216a.d(PackageResourceManager.TAG, "repairConfig " + this + " Updating: " + r3);
        a(this, r8, false, 2, null);
        return;
    L24:
        return;
    L22:
        return;
    }

    public static /* synthetic */ void a(d r0, long r1, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 1) == 0) goto L6;
        r1 = System.currentTimeMillis();
    L6:
        r0.b(r1);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loggerUsage");
    }

    public static /* synthetic */ void a(d r0, com.obric.aikernel.res.metadata.config.a r1, boolean r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L6;
        r2 = false;
    L6:
        r0.a(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: saveConfig");
    }

    private final boolean a(JsonObject r10) {
        Uri r0 = i();
        if (r0 == null) goto L5;
        String r1 = r0.getScheme();
    L7:
        if (Intrinsics.areEqual(r1, "file") == false) goto L22;
        File r2 = new File(r0.getPath());
        Set<Map.Entry<String, JsonElement>> r11 = r10.entrySet();
        Intrinsics.checkNotNullExpressionValue(r11, "checkerConfig.entrySet()");
        Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L10:
        if (r12.hasNext() == false) goto L31;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r12.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r3, "(file, info)");
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.getKey(), String.class, "com.obric.memorydata.plugin");
        JsonElement r5 = (JsonElement) ZeusTransformUtils.preCheckCast(r3.getValue(), JsonElement.class, "com.obric.memorydata.plugin");
        File r6 = new File(r2, r4);
        if (r6.exists() == false) goto L21;
        long r7 = Os.stat(r6.getPath()).st_size;
        JsonElement r8 = r5.getAsJsonObject().get("size");
        if (r8 == null) goto L10;
        Intrinsics.checkNotNullExpressionValue(r8, "get(\"size\")");
        long r9 = r8.getAsLong();
        if (r7 == r9) goto L10;
        throw new IllegalStateException(this + ' ' + new File(r2, r4).getPath() + " corrupted: size(" + r7 + '/' + r9 + ')');
    L21:
        throw new IllegalStateException(this + ' ' + r6.getPath() + " not exist!");
    L31:
        return true;
    L22:
        return true;
    L5:
        r1 = null;
        goto L7
    }

    public static /* synthetic */ boolean a(d r0, boolean r1, int r2, Object r3) {
        if (r3 != null) goto L9;
        if ((r2 & 1) == 0) goto L7;
        r1 = true;
    L7:
        return r0.b(r1);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: checkResourceFull");
    }

    public static /* synthetic */ boolean b(d r0, boolean r1, int r2, Object r3) {
        if (r3 != null) goto L9;
        if ((r2 & 1) == 0) goto L7;
        r1 = true;
    L7:
        return r0.c(r1);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: checkResource");
    }

    private final boolean g() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r1 = Result.m1421constructorimpl(Boolean.valueOf(FilesKt.deleteRecursively(new File(((d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.memorydata.plugin")).g))));     // Catch: Throwable -> L4
    L6:
        Throwable r2 = Result.m1424exceptionOrNullimpl(r1);
        if (r2 == null) goto L10;
        com.obric.aikernel.runtime.utils.d.f6216a.f(PackageResourceManager.TAG, "clean " + this + " failed " + r2);
    L10:
        if (Result.m1427isFailureimpl(r1) == false) goto L13;
        r1 = null;
    L13:
        return Intrinsics.areEqual(r1, true);
    L4:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r1 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    private final String j() {
        return this.g + "/last_usage";
    }

    public final File A() {
        return this.l;
    }

    public final File B() {
        return this.m;
    }

    public final File C() {
        Object r1 = null;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L28
        d r3 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L28
        if (r3.l.isFile() == true) goto L6;
        File r4 = (File) ZeusTransformUtils.preCheckCast(null, File.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L28
    L26:
        Object r5 = Result.m1421constructorimpl(r4);     // Catch: Throwable -> L28
    L30:
        Throwable r6 = Result.m1424exceptionOrNullimpl(r5);
        if (r6 == null) goto L34;
        com.obric.aikernel.runtime.utils.d.f6216a.f(PackageResourceManager.TAG, "read link target " + this.l.getPath() + " failed " + r6);
    L34:
        if (Result.m1427isFailureimpl(r5) == true) goto L38;
        r1 = r5;
    L38:
        return (File) ZeusTransformUtils.preCheckCast(r1, File.class, "com.obric.memorydata.plugin");
    L6:
        boolean r7 = true;
        Uri r8 = Uri.parse(FilesKt.readText$default(r3.l, null, 1, null));     // Catch: Throwable -> L28
        if (Intrinsics.areEqual(r8.getScheme(), "file") == false) goto L17;
        CharSequence r9 = (CharSequence) ZeusTransformUtils.preCheckCast(r8.getPath(), CharSequence.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L28
        if (r9 != null) goto L11;
    L14:
        boolean r10 = true;
    L15:
        if (r10 == true) goto L17;
    L18:
        if (r7 == true) goto L21;
        r8 = null;
    L21:
        if (r8 == null) goto L25;
        String r11 = r8.getPath();     // Catch: Throwable -> L28
        if (r11 == null) goto L25;
        r4 = new File(r11);     // Catch: Throwable -> L28
    L25:
        r4 = null;
        goto L26
    L11:
        if (r9.length() == 0) goto L14;
        r10 = false;
    L17:
        r7 = false;
    L28:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r5 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L30
    }

    public JsonObject D() {
        Object r2 = null;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L10
        File r4 = new File(this.g, "checker_v2.json");     // Catch: Throwable -> L10
        if (r4.exists() == false) goto L7;
        Object r5 = ZeusTransformUtils.preCheckCast(new Gson().fromJson(FilesKt.readText$default(r4, null, 1, null), JsonObject.class), JsonObject.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
    L8:
        Object r6 = Result.m1421constructorimpl((JsonObject) r5);     // Catch: Throwable -> L10
    L12:
        Throwable r7 = Result.m1424exceptionOrNullimpl(r6);
        if (r7 == null) goto L16;
        com.obric.aikernel.runtime.utils.d.f6216a.c(PackageResourceManager.TAG, this + " checkResource delete corrupted checker file! " + ExceptionsKt.stackTraceToString(r7));
        new File(this.g, "checker_v2.json").delete();
    L16:
        if (Result.m1427isFailureimpl(r6) == true) goto L20;
        r2 = r6;
    L20:
        return (JsonObject) ZeusTransformUtils.preCheckCast(r2, JsonObject.class, "com.obric.memorydata.plugin");
    L7:
        r5 = ZeusTransformUtils.preCheckCast(null, JsonObject.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r6 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    public final boolean E() {
        return a_(false);
    }

    public final boolean F() {
        return this.k.exists();
    }

    public boolean G() {
        return com.obric.aikernel.res.task.b.f6101a.a(this.c, j());
    }

    public void H() {
        o();
    }

    public final boolean I() {
        return new File(this.g, "configuration.json").exists();
    }

    public final com.obric.aikernel.res.metadata.config.a J() {
        File r1 = new File(this.g, "configuration.json");
        Object r3 = null;
        if (r1.exists() == true) goto L25;
        return null;
    L25:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L14
        String r4 = getType();     // Catch: Throwable -> L14
        String r5 = this.f6088a;     // Catch: Throwable -> L14
        Closeable r6 = (Closeable) ZeusTransformUtils.preCheckCast(new FileReader(r1), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        JsonObject r7 = (JsonObject) ZeusTransformUtils.preCheckCast(new Gson().fromJson((Reader) ZeusTransformUtils.preCheckCast((FileReader) ZeusTransformUtils.preCheckCast(r6, FileReader.class, "com.obric.memorydata.plugin"), Reader.class, "com.obric.memorydata.plugin"), JsonObject.class), JsonObject.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        CloseableKt.closeFinally(r6, null);     // Catch: Throwable -> L14
        Intrinsics.checkNotNullExpressionValue(r7, "FileReader(configFile).u…class.java)\n            }");     // Catch: Throwable -> L14
        Object r8 = Result.m1421constructorimpl(new com.obric.aikernel.res.metadata.config.a(r4, r5, r7));     // Catch: Throwable -> L14
    L16:
        Throwable r9 = Result.m1424exceptionOrNullimpl(r8);
        if (r9 == null) goto L20;
        r1.delete();
        com.obric.aikernel.runtime.utils.d.f6216a.c(PackageResourceManager.TAG, this + " getConfig delete corrupted config file! " + ExceptionsKt.stackTraceToString(r9));
    L20:
        if (Result.m1427isFailureimpl(r8) == true) goto L24;
        r3 = r8;
    L24:
        return (com.obric.aikernel.res.metadata.config.a) ZeusTransformUtils.preCheckCast(r3, com.obric.aikernel.res.metadata.config.a.class, "com.obric.memorydata.plugin");
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        CloseableKt.closeFinally(r6, th);     // Catch: Throwable -> L14
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r8 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L16
    }

    public final void K() {
        new File(this.g, "configuration.json").delete();
    }

    public final void L() {
        if (this.k.exists() == true) goto L6;
        b(CollectionsKt.listOf(this.k));
        return;
    }

    public final String M() {
        if (Intrinsics.areEqual(this.f6089b, "debug") == false) goto L6;
        com.obric.aikernel.res.metadata.config.a r2 = J();
        Intrinsics.checkNotNull(r2);
        return com.obric.aikernel.res.metadata.config.b.a(r2.b(), "version_debug");
    L6:
        return this.f6089b;
    }

    public void a() {
    }

    public void a(PrmContext r6) {
        Intrinsics.checkNotNullParameter(r6, "ctx");
        if (a(this, false, 1, null) == true) goto L9;
        com.obric.aikernel.runtime.utils.d.f6216a.d(PackageResourceManager.TAG, "install: list absolutePath " + this.g + " files: " + com.obric.aikernel.res.utils.a.f6155a.a(new File(this.g)));
        if (Intrinsics.areEqual(this.g, this.h) == true) goto L8;
        com.obric.aikernel.runtime.utils.d.f6216a.d(PackageResourceManager.TAG, "install: list resAbsolutePath " + this.h + " files: " + com.obric.aikernel.res.utils.a.f6155a.a(new File(this.h)));
    L8:
        throw new IllegalStateException(this.f6088a + '@' + this.f6089b + " check resource failed!");
    }

    public final void a(com.obric.aikernel.res.metadata.config.a r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "config");
        File r0 = new File(this.g, "configuration.json");
        if (r4 == true) goto L5;
    L7:
        File r2 = r0.getParentFile();
        boolean r5 = false;
        if (r2 != null) goto L10;
    L12:
        if (r5 == false) goto L16;
        File r6 = r0.getParentFile();
        if (r6 == null) goto L16;
        r6.mkdirs();
    L16:
        r0.delete();
        com.obric.aikernel.res.utils.a r7 = com.obric.aikernel.res.utils.a.f6155a;
        String r8 = r3.b().toString();
        Intrinsics.checkNotNullExpressionValue(r8, "config.json.toString()");
        r7.b(r0, r8);
        return;
    L10:
        if (r2.exists() == true) goto L12;
        r5 = true;
        goto L12
    L5:
        if (r0.exists() == false) goto L7;
    }

    public final void a(File r3) {
        Intrinsics.checkNotNullParameter(r3, TypedValues.AttributesType.S_TARGET);
        if (this.l.exists() == true) goto L5;
    L7:
        File r0 = this.l.getParentFile();
        if (r0 == null) goto L10;
        r0.mkdirs();
    L10:
        com.obric.aikernel.res.utils.a r1 = com.obric.aikernel.res.utils.a.f6155a;
        File r2 = this.l;
        String r4 = Uri.fromFile(r3).toString();
        Intrinsics.checkNotNullExpressionValue(r4, "fromFile(target).toString()");
        r1.b(r2, r4);
        return;
    L5:
        if (this.l.isDirectory() == false) goto L7;
        this.l.delete();
        goto L7
    }

    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.d = r2;
    }

    public final boolean a(Uri r4) {
        boolean r1 = false;
        if (r4 == null) goto L8;
        if (a(r4, this.c) == true) goto L8;
        r1 = true;
    L8:
        return !r1;
    }

    public final boolean a(Uri r4, long r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        String r3 = r4.getScheme();
        if (r3 != null) goto L5;
        return true;
    L5:
        if (r3.hashCode() == 3143036) goto L8;
        return true;
    L8:
        if (r3.equals("file") == true) goto L10;
        return true;
    L10:
        if (Os.stat(r4.getPath()).st_size == r5) goto L17;
        return false;
    L17:
        return true;
    }

    public final boolean a(Uri r5, PackageResourceManager.PresmConfig r6) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r6, "config");
        String r4 = r5.getScheme();
        if (r4 == null) goto L44;
        int r1 = r4.hashCode();
        if (r1 == (-1408207997)) goto L29;
        if (r1 == 3143036) goto L10;
        return false;
    L10:
        if (r4.equals("file") == false) goto L51;
        File r7 = new File(r5.getPath());
        if (r7.exists() == true) goto L15;
        return false;
    L15:
        if (r7.isFile() == true) goto L47;
        File[] r8 = r7.listFiles();
        if (r8 == null) goto L25;
        Intrinsics.checkNotNullExpressionValue(r8, "listFiles()");
        if (r8.length != 0) goto L21;
        boolean r9 = true;
    L23:
        if ((!r9) != true) goto L25;
        boolean r10 = true;
    L26:
        if (r10 == true) goto L47;
        return false;
    L21:
        r9 = false;
    L25:
        r10 = false;
    L47:
        return true;
    L51:
        return false;
    L29:
        if (r4.equals("assets") == false) goto L52;
        String r11 = r5.getPath();
        if (r11 == null) goto L48;
        String[] r12 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getAssets().list(r11);
        if (r12 == null) goto L40;
        Intrinsics.checkNotNullExpressionValue(r12, "list(it)");
        if (r12.length != 0) goto L38;
        boolean r13 = true;
    L39:
        Boolean r14 = Boolean.valueOf(!r13);
    L41:
        if (r14 != null) goto L43;
        return false;
    L43:
        return r14.booleanValue();
    L38:
        r13 = false;
        goto L39
    L40:
        r14 = null;
        goto L41
    L48:
        return false;
    L52:
        return false;
    L44:
        return false;
    }

    public final boolean a(Uri r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "md5");
        String r3 = r4.getScheme();
        if (r3 != null) goto L5;
        return true;
    L5:
        if (r3.hashCode() == 3143036) goto L8;
        return true;
    L8:
        if (r3.equals("file") == true) goto L10;
        return true;
    L10:
        if (TTMd5.checkMd5(r5, new File(r4.getPath())) == 0) goto L17;
        return false;
    L17:
        return true;
    }

    public final boolean a(PrmContext r19, boolean r20, boolean r21) {
        Intrinsics.checkNotNullParameter(r19, "ctx");
        boolean r4 = e.a(r21, F());
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L20
        if (r20 == false) goto L7;
        com.obric.aikernel.runtime.utils.c.a.a((com.obric.aikernel.runtime.utils.c) ZeusTransformUtils.preCheckCast(com.obric.aikernel.runtime.utils.d.f6216a, com.obric.aikernel.runtime.utils.c.class, "com.obric.memorydata.plugin"), PackageResourceManager.TAG, "performInstall: " + this + " clean current result: " + g(), 0, 4, null);     // Catch: Throwable -> L20
    L12:
        if (a(r21) == false) goto L14;
        com.obric.aikernel.runtime.utils.d.f6216a.b(PackageResourceManager.TAG, "resource install prepare type=" + getType() + " name=" + this.f6088a + " version=" + this.f6089b + " override=" + r20 + " fastCheck=" + r21);     // Catch: Throwable -> L20
        c();     // Catch: Throwable -> L20
    L15:
        com.obric.aikernel.runtime.utils.c.a.a((com.obric.aikernel.runtime.utils.c) ZeusTransformUtils.preCheckCast(com.obric.aikernel.runtime.utils.d.f6216a, com.obric.aikernel.runtime.utils.c.class, "com.obric.memorydata.plugin"), PackageResourceManager.TAG, "performInstall: " + this + " start install", 0, 4, null);     // Catch: Throwable -> L20
        a(r19);     // Catch: Throwable -> L20
        a();     // Catch: Throwable -> L20
        if (r4 == true) goto L18;
        this.k.delete();     // Catch: Throwable -> L20
    L18:
        com.obric.aikernel.runtime.utils.d.f6216a.b(PackageResourceManager.TAG, "resource install completed type=" + getType() + " name=" + this.f6088a + " version=" + this.f6089b);     // Catch: Throwable -> L20
        Object r0 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L20
    L22:
        Throwable r2 = Result.m1424exceptionOrNullimpl(r0);
        if (r2 == null) goto L26;
        H();
        com.obric.aikernel.runtime.utils.d.f6216a.f(PackageResourceManager.TAG, "performInstall " + this.f6088a + '@' + this.f6089b + " failed by " + ExceptionsKt.stackTraceToString(r2));
    L26:
        return Result.m1428isSuccessimpl(r0);
    L14:
        com.obric.aikernel.runtime.utils.c.a.a((com.obric.aikernel.runtime.utils.c) ZeusTransformUtils.preCheckCast(com.obric.aikernel.runtime.utils.d.f6216a, com.obric.aikernel.runtime.utils.c.class, "com.obric.memorydata.plugin"), PackageResourceManager.TAG, "performInstall[override:" + r20 + "]: " + this + '@' + this.f6089b + " resource is installed.", 0, 4, null);     // Catch: Throwable -> L20
        goto L15
    L7:
        com.obric.aikernel.res.metadata.config.a r9 = b();     // Catch: Throwable -> L20
        if (r9 == null) goto L12;
        a(r9);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r0 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L22
    }

    public boolean a(boolean r2) {
        if (f() == true) goto L5;
    L8:
        return true;
    L5:
        if (a_(r2) == true) goto L8;
        return false;
    }

    public boolean a_(boolean r6) {
        boolean r0 = F();
        boolean r2 = true;
        if (b(r6) == true) goto L5;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L15
        d r3 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        if (r3.F() == true) goto L13;
        r3.b(CollectionsKt.listOf(r3.k));     // Catch: Throwable -> L15
    L13:
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L18:
        if (e.a(r6, r0, r2) == false) goto L20;
        this.k.delete();
    L20:
        return r2;
    L15:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L18
    L5:
        if (((Boolean) ZeusTransformUtils.preCheckCast(this.c.getAppConfig().getCheckPackageResource().invoke(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L7;
    L9:
        r2 = false;
        goto L18
    L7:
        if (D() != null) goto L9;
        goto L9
    }

    public final Uri b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "path");
        Uri r1 = i();
        if (r1 == null) goto L9;
        Uri.Builder r3 = r1.buildUpon();
        if (r3 == null) goto L9;
        Uri.Builder r4 = r3.appendPath(r2);
        if (r4 == null) goto L9;
        return r4.build();
    L9:
        return null;
    }

    public com.obric.aikernel.res.metadata.config.a b() {
        return null;
    }

    public void b(long r3) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L13
        File r1 = new File(((d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.memorydata.plugin")).j());     // Catch: Throwable -> L13
        File r2 = r1.getParentFile();     // Catch: Throwable -> L13
        boolean r4 = false;
        if (r2 != null) goto L5;
    L7:
        if (r4 == false) goto L11;
        File r5 = r1.getParentFile();     // Catch: Throwable -> L13
        if (r5 == null) goto L11;
        r5.mkdirs();     // Catch: Throwable -> L13
    L11:
        FilesKt.writeText$default(r1, String.valueOf(r3), null, 2, null);     // Catch: Throwable -> L13
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L13
        return;
    L5:
        if (r2.exists() == true) goto L7;
        r4 = true;
    L13:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    }

    public final boolean b(List<? extends File> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "flags");
        if (this.i.isFile() == false) goto L6;
        this.i.delete();
    L6:
        if (this.i.exists() == true) goto L8;
        this.i.mkdirs();
    L8:
        boolean r3 = true;
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L10:
        if (r6.hasNext() == false) goto L16;
        File r0 = (File) ZeusTransformUtils.preCheckCast(r6.next(), File.class, "com.obric.memorydata.plugin");
        if (r0.exists() == true) goto L10;
        if (r0.createNewFile() == true) goto L10;
        r3 = false;
        goto L10
    L16:
        return r3;
    }

    public boolean b(boolean r4) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r3 = Result.m1421constructorimpl(Boolean.valueOf(c(r4)));     // Catch: Throwable -> L4
    L6:
        Throwable r5 = Result.m1424exceptionOrNullimpl(r3);
        if (r5 == null) goto L10;
        com.obric.aikernel.runtime.utils.d.f6216a.f(PackageResourceManager.TAG, "checkResourceFull: " + r5);
    L10:
        if (Result.m1427isFailureimpl(r3) == false) goto L13;
        r3 = false;
    L13:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L4:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r3 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    public void c() {
    }

    public final void c(List<? extends File> r3) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "flags");
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        File r5 = (File) ZeusTransformUtils.preCheckCast(r4.next(), File.class, "com.obric.memorydata.plugin");
        if (r5.exists() == false) goto L4;
        r5.delete();
        goto L4
    }

    public boolean c(boolean r4) {
        if (this.i.isFile() == false) goto L5;
        this.i.delete();
        throw new IllegalStateException(this + " state d illegal");
    L5:
        if (J() == null) goto L23;
        Uri r5 = i();
        boolean r1 = false;
        if (r5 != null) goto L9;
    L11:
        if (r1 == true) goto L21;
        if (((Boolean) ZeusTransformUtils.preCheckCast(this.c.getAppConfig().getCheckPackageResource().invoke(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L19;
        JsonObject r6 = D();
        if (r6 == null) goto L18;
        a(r6);
        goto L19
    L18:
        throw new IllegalStateException("get checker_v2.json failed!");
    L19:
        return true;
    L21:
        throw new IllegalStateException(this.f6088a + '@' + this.f6089b + ' ' + i() + " missed!");
    L9:
        if (a(r5, this.c) == true) goto L11;
        r1 = true;
        goto L11
    L23:
        throw new IllegalStateException(this + " missing config file!");
    }

    public boolean d() {
        return e();
    }

    public final void delete(Uri r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        if (Intrinsics.areEqual(r4.getScheme(), "file") == false) goto L6;
        new File(r4.getPath()).delete();
        com.obric.aikernel.runtime.utils.d.f6216a.e(PackageResourceManager.TAG, "delete res file: " + this.f6088a + '@' + this.f6089b + ": " + r4.getPath());
        return;
    }

    public boolean e() {
        if (f() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.j.exists() == false) goto L7;
        return true;
    }

    public boolean f() {
        if (this.i.isDirectory() == false) goto L13;
        Uri r0 = i();
        if (r0 != null) goto L7;
    L9:
        boolean r4 = false;
    L10:
        if (r4 == true) goto L13;
        return true;
    L7:
        if (a(r0, this.c) == true) goto L9;
        r4 = true;
    L13:
        return false;
    }

    public abstract String getType();

    public abstract String h();

    public Uri i() {
        if (this.l.exists() == false) goto L6;
        return Uri.parse(FilesKt.readText$default(this.l, null, 1, null));
    L6:
        return Uri.fromFile(new File(this.g, this.f6088a));
    }

    public String l() {
        return "";
    }

    public boolean m() {
        com.obric.aikernel.runtime.utils.d.f6216a.b(PackageResourceManager.TAG, "uninstall " + this.f6088a + '@' + this.f6089b);
        File r1 = new File(this.g);
        File r2 = C();
        if (r2 == null) goto L19;
        if (e.a(r2, new File(this.c.getResRootDir())) == true) goto L32;
        com.obric.aikernel.runtime.utils.d.f6216a.b(PackageResourceManager.TAG, "uninstall: keep external link target " + r2.getPath());
        goto L19
    L32:
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L11
        d r6 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r2.exists() == false) goto L9;
        FilesKt.deleteRecursively(r2);     // Catch: Throwable -> L11
    L9:
        Object r7 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        Throwable r8 = Result.m1424exceptionOrNullimpl(r7);
        if (r8 == null) goto L16;
        com.obric.aikernel.runtime.utils.d.f6216a.c(PackageResourceManager.TAG, "uninstall: clean innerRes " + r2.getPath() + " error: " + ExceptionsKt.stackTraceToString(r8));
    L16:
        Result.m1420boximpl(r7);
    L11:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r7 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L19:
        if (r1.exists() == false) goto L36;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L22
        d r0 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        Object r4 = Result.m1421constructorimpl(Boolean.valueOf(FilesKt.deleteRecursively(r1)));     // Catch: Throwable -> L22
    L24:
        Throwable r10 = Result.m1424exceptionOrNullimpl(r4);
        if (r10 == null) goto L28;
        com.obric.aikernel.runtime.utils.d.f6216a.f(PackageResourceManager.TAG, "uninstall delete " + this + " failed " + r10);
    L28:
        if (Result.m1427isFailureimpl(r4) == false) goto L31;
        r4 = null;
    L31:
        return Intrinsics.areEqual(r4, true);
    L22:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r4 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L24
    L36:
        return true;
    }

    public boolean n() {
        if (this.j.exists() == false) goto L5;
        return true;
    L5:
        return b(CollectionsKt.listOf(this.j));
    }

    public boolean o() {
        if (this.j.exists() == true) goto L7;
        return true;
    L7:
        return this.j.delete();
    }

    public final String s() {
        return this.f6088a;
    }

    public final String t() {
        return this.f6089b;
    }

    public String toString() {
        return getType() + ':' + this.f6088a + '@' + this.f6089b + '@' + this.d;
    }

    public final PackageResourceManager.PresmConfig u() {
        return this.c;
    }

    public final String v() {
        return this.d;
    }

    public final String w() {
        return this.g;
    }

    public final String x() {
        return this.h;
    }

    public final File y() {
        return this.i;
    }

    public final File z() {
        return this.j;
    }
}
