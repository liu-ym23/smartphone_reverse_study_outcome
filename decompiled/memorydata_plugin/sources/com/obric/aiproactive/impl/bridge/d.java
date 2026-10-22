package com.obric.aiproactive.impl.bridge;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdinstall.Api;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.crypto.utils.CryptoConst;
import com.obric.cae.userAware.WifiScanStateMachine;
import com.obric.capabilitykit.common.Ext;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.AtomicMoveNotSupportedException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0000\u0018\u0000 V2\u00020\u0001:\u0002UVB\u0099\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u001a\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\b0\u0006\u0012\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\n\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\n\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u00128\b\u0002\u0010\u000f\u001a2\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00150\u0010¢\u0006\u0004\b\u0016\u0010\u0017J\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010!\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\"J\u0012\u0010#\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001f\u001a\u00020\"H\u0002J0\u0010$\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\"2\u0006\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0007H\u0002J\u0018\u0010*\u001a\u0004\u0018\u00010\u00072\u0006\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u0007J\"\u0010-\u001a\u0004\u0018\u00010\u00072\u0006\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u0007H\u0002J\u0018\u0010/\u001a\u0002002\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0003H\u0002J\u001a\u00101\u001a\u0004\u0018\u00010\u00032\u0006\u0010+\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u0007H\u0002J\u001c\u00102\u001a\u00020\u001d2\u0006\u00103\u001a\u00020\u00072\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u00070\bJ\u001e\u00105\u001a\u00020\u001d2\u0006\u00103\u001a\u00020\u00072\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u00070\bH\u0002J\u0006\u00106\u001a\u00020\u001dJ\u0018\u00106\u001a\u00020\u001d2\u0006\u00107\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u0007H\u0002J\u0010\u00109\u001a\u00020\u00152\u0006\u0010:\u001a\u00020\u0003H\u0002J \u0010;\u001a\u0002002\u0006\u0010%\u001a\u00020\u00032\u0006\u0010<\u001a\u00020\u00032\u0006\u00108\u001a\u00020\u0007H\u0002J&\u0010=\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u00032\u0006\u00108\u001a\u00020\u00072\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00070\bH\u0002J\n\u0010?\u001a\u0004\u0018\u00010\u0007H\u0002J\u0018\u0010@\u001a\u00020A2\u0006\u0010+\u001a\u00020\u00072\u0006\u0010B\u001a\u00020\u0007H\u0002J \u0010C\u001a\u00020\u001d2\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u00032\u0006\u0010D\u001a\u00020\fH\u0002J\u0010\u0010E\u001a\u0002002\u0006\u0010%\u001a\u00020\u0003H\u0002J\u0012\u0010F\u001a\u0004\u0018\u00010\u00032\u0006\u0010+\u001a\u00020\u0007H\u0002J\u001e\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00070\b2\u0006\u0010H\u001a\u00020\u00032\u0006\u0010I\u001a\u00020\u0007H\u0002J\u001e\u0010J\u001a\u0002002\u0006\u0010H\u001a\u00020\u00032\f\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00070\bH\u0002J\u001a\u0010L\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010M\u001a\u00020\u0007H\u0002J$\u0010N\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0013\u001a\u00020\u00032\b\u0010O\u001a\u0004\u0018\u00010\u00072\u0006\u0010P\u001a\u00020\u0007H\u0002J\u0012\u0010Q\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0013\u001a\u00020\u0003H\u0002J\u0012\u0010R\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0013\u001a\u00020\u0003H\u0002J\u0010\u0010S\u001a\u00020\u001d2\u0006\u0010T\u001a\u00020\u0007H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R>\u0010\u000f\u001a2\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00150\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006W"}, d2 = {"Lcom/obric/aiproactive/impl/bridge/ArtifactResourceStore;", "", "exportShareRoot", "Ljava/io/File;", "externalCacheDir", "referencedLocatorsProvider", "Lkotlin/Function1;", "", "", "accountScopeProvider", "Lkotlin/Function0;", "nowMs", "", "remoteDownloader", "Lcom/obric/aiproactive/impl/bridge/RemoteArtifactDownloader;", "createHardLink", "Lkotlin/Function2;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, AILabCheckPermissionTask.KEY_SOURCE, TypedValues.AttributesType.S_TARGET, "", "<init>", "(Ljava/io/File;Ljava/io/File;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lcom/obric/aiproactive/impl/bridge/RemoteArtifactDownloader;Lkotlin/jvm/functions/Function2;)V", "managedRoot", "maintenanceLock", "lastSuccessfulSweepMsByAccount", "", "maybeSweepOrphans", "Lcom/obric/aiproactive/impl/bridge/ArtifactStoreResult;", "materialize", Ext.KEY_REQUEST, "Lcom/obric/aiproactive/impl/bridge/ArtifactMaterializeRequest;", "materializeRemote", "Lcom/obric/aiproactive/impl/bridge/RemoteArtifactMaterializeRequest;", "validateRemoteRequest", "commitRemoteArtifact", "runDir", "staging", "downloaded", "Lcom/obric/aiproactive/impl/bridge/RemoteDownloadResult;", "resolvedMime", "prepareOpenLocator", "locator", "displayName", "prepareOpenLocatorLocked", "account", "createNamedOpenFile", "", "resolveOwnedOpenSource", "finalizeRun", "runId", "committedLocators", "finalizeRunLocked", "sweepOrphans", "accountScope", "accountPrefix", "removeOpenDirectory", "directory", "pruneUnownedOpenDirectory", "file", "pruneLegacyOpenDirectories", "referenced", "currentAccountScope", "resolveShellSource", "Lcom/obric/aiproactive/impl/bridge/ArtifactResourceStore$SourceResult;", "shellTaskId", "copyBounded", "expectedSize", "ensureManagedDirectory", "fileForManagedLocator", "readCommitMarker", "marker", "runHash", "writeCommitMarker", "locators", "resolveMimeType", "declared", "resolveRemoteMimeType", "httpMime", "expectedType", "sniffMime", "sniffDocxMime", "failure", "code", "SourceResult", "Companion", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6398a = null;
    private static final byte[] k = null;
    private static final byte[] l = null;
    private static final Map<String, String> m = null;
    private static final Set<String> n = null;
    private static final Map<String, String> o = null;
    private static final Map<String, String> p = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final File f6399b;
    private final Function1<String, Set<String>> c;
    private final Function0<String> d;
    private final Function0<Long> e;
    private final h f;
    private final Function2<File, File, Unit> g;
    private final File h;
    private final Object i;
    private final Map<String, Long> j;

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\"\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\nH\u0000¢\u0006\u0002\b\u0016J\u0015\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\nH\u0000¢\u0006\u0002\b\u0019J\u0015\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\nH\u0000¢\u0006\u0002\b\u001cJ\u0018\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\nH\u0002J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\nH\u0002J\u0010\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\nH\u0002J\u0010\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\nH\u0002J\u001a\u0010&\u001a\u00020 2\b\u0010'\u001a\u0004\u0018\u00010\n2\u0006\u0010(\u001a\u00020\nH\u0002J\u0018\u0010)\u001a\u00020 2\u0006\u0010*\u001a\u00020\n2\u0006\u0010(\u001a\u00020\nH\u0002J\u0014\u0010+\u001a\u0004\u0018\u00010\n2\b\u0010!\u001a\u0004\u0018\u00010\nH\u0002J\u0018\u0010,\u001a\u00020 2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.H\u0002J\u0018\u00100\u001a\u00020 2\u0006\u00101\u001a\u00020\n2\u0006\u00102\u001a\u00020\nH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/obric/aiproactive/impl/bridge/ArtifactResourceStore$Companion;", "", "<init>", "()V", "MAX_SOURCE_LOCATOR_CHARS", "", "MAX_DISPLAY_NAME_CHARS", "MAX_DURATION_MS", "", "DOCX_MIME", "", "ZIP_HEADER", "", "PNG_HEADER", "MIME_BY_EXTENSION", "", "REMOTE_ARTIFACT_TYPES", "", "EXTENSION_BY_REMOTE_MIME", "REMOTE_DISPLAY_NAMES", "stableTaskDir", "taskId", "stableTaskDir$ai_proactive_impl_obricRelease", "hashRunId", "runId", "hashRunId$ai_proactive_impl_obricRelease", "hashAccountScope", "accountScope", "hashAccountScope$ai_proactive_impl_obricRelease", "scopedRunDir", "accountPrefix", "isSafeDisplayName", "", EventBody.KEY_VALUE, "safeExtension", ActivityLifecycle.NAME, "artifactTypeForMime", "mime", "isCompatibleArtifactType", "hint", "actual", "mimeCompatible", "declared", "normalizeRemoteMime", "isCanonicalChild", "parent", "Ljava/io/File;", "child", "isRunLocator", "locator", "runHash", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        private static final CharSequence a(byte r3) {
            String r4 = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(r3)}, 1));
            Intrinsics.checkNotNullExpressionValue(r4, "format(...)");
            return (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin");
        }

        private final String a(String r2, String r3) {
            return r2 + '-' + b(r3);
        }

        public static final /* synthetic */ boolean a(a r0, File r1, File r2) {
            return r0.a(r1, r2);
        }

        public static final /* synthetic */ boolean a(a r0, String r1) {
            return r0.d(r1);
        }

        public static final /* synthetic */ boolean a(a r0, String r1, String r2) {
            return r0.b(r1, r2);
        }

        private final boolean a(File r2, File r3) {
            Path r4 = r2.getCanonicalFile().toPath();     // Catch: Throwable -> L9
            Path r5 = r3.getCanonicalFile().toPath();     // Catch: Throwable -> L9
            if (r5.startsWith(r4) == false) goto L12;
            if (Intrinsics.areEqual(r5, r4) == true) goto L13;
            return true;
        L13:
            return false;
        L12:
            return false;
        L14:
            return false;
        }

        private static final CharSequence b(byte r3) {
            String r4 = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(r3)}, 1));
            Intrinsics.checkNotNullExpressionValue(r4, "format(...)");
            return (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin");
        }

        public static final /* synthetic */ String b(a r0, String r1) {
            return r0.f(r1);
        }

        public static final /* synthetic */ String b(a r0, String r1, String r2) {
            return r0.a(r1, r2);
        }

        private final boolean b(String r3, String r4) {
            CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin");
            if (r2 != null) goto L5;
        L8:
            boolean r5 = true;
        L9:
            if (r5 == true) goto L15;
            if (Intrinsics.areEqual(r3, r4) == true) goto L15;
            if (Intrinsics.areEqual(r3, "file") == true) goto L15;
            return false;
        L15:
            return true;
        L5:
            if (StringsKt.isBlank(r2) == true) goto L8;
            r5 = false;
            goto L9
        }

        public static final /* synthetic */ String c(a r0, String r1) {
            return r0.e(r1);
        }

        public static final /* synthetic */ boolean c(a r0, String r1, String r2) {
            return r0.d(r1, r2);
        }

        private final boolean c(String r6, String r7) {
            if (StringsKt.equals(r6, r7, true) == false) goto L5;
            return true;
        L5:
            if (StringsKt.startsWith$default(r6, "text/", false, 2, null) == false) goto L9;
            if (StringsKt.startsWith$default(r7, "text/", false, 2, null) == false) goto L9;
            return true;
        L9:
            if (Intrinsics.areEqual(r6, "application/octet-stream") == false) goto L12;
            return true;
        L12:
            return false;
        }

        public static final /* synthetic */ String d(a r0, String r1) {
            return r0.g(r1);
        }

        public static final /* synthetic */ boolean d(a r0, String r1, String r2) {
            return r0.c(r1, r2);
        }

        private final boolean d(String r7) {
            if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L28;
            if (r7.length() > 240) goto L28;
            if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"), '/', false, 2, null) == true) goto L28;
            if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"), '\\', false, 2, null) == true) goto L28;
            CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin");
            int r8 = 0;
        L12:
            if (r8 >= r6.length()) goto L24;
            char r0 = r6.charAt(r8);
            if (r0 != '\n') goto L16;
        L20:
            boolean r1 = true;
        L21:
            if (r1 == true) goto L22;
            r8 = r8 + 1;
            goto L12
        L22:
            boolean r9 = false;
        L25:
            if (r9 == false) goto L28;
            return true;
        L16:
            if (r0 == '\r') goto L20;
            if (r0 == 0) goto L20;
            r1 = false;
            goto L21
        L24:
            r9 = true;
        L28:
            return false;
        }

        private final boolean d(String r9, String r10) {
            List r11 = StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin"), new char[]{'/'}, false, 0, 6, null);
            if (r11.size() != 3) goto L37;
            if (Intrinsics.areEqual(r11.get(0), "managed") == false) goto L37;
            if (Intrinsics.areEqual(r11.get(1), r10) == false) goto L37;
            if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r11.get(2), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L37;
            if (Intrinsics.areEqual(r11.get(2), ".committed") == true) goto L37;
            if (StringsKt.startsWith$default((String) ZeusTransformUtils.preCheckCast(r11.get(2), String.class, "com.obric.memorydata.plugin"), ".staging-", false, 2, null) == true) goto L37;
            if (StringsKt.startsWith$default((String) ZeusTransformUtils.preCheckCast(r11.get(2), String.class, "com.obric.memorydata.plugin"), ".open-", false, 2, null) == true) goto L37;
            CharSequence r12 = (CharSequence) ZeusTransformUtils.preCheckCast(r11.get(2), CharSequence.class, "com.obric.memorydata.plugin");
            int r13 = 0;
        L18:
            if (r13 >= r12.length()) goto L33;
            char r0 = r12.charAt(r13);
            if (r0 != 0) goto L22;
        L29:
            boolean r1 = true;
        L30:
            if (r1 == true) goto L31;
            r13 = r13 + 1;
            goto L18
        L31:
            boolean r14 = false;
        L34:
            if (r14 == false) goto L37;
            return true;
        L22:
            if (r0 == '\n') goto L29;
            if (r0 == '\r') goto L29;
            if (r0 == '\\') goto L29;
            r1 = false;
            goto L30
        L33:
            r14 = true;
        L37:
            return false;
        }

        private final String e(String r5) {
            String r6 = StringsKt.substringAfterLast(r5, '.', "");
            Locale r1 = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(r1, "ROOT");
            String r7 = r6.toLowerCase(r1);
            Intrinsics.checkNotNullExpressionValue(r7, "toLowerCase(...)");
            if (e.c().matches((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L5;
            return "";
        L5:
            return '.' + r7;
        }

        private final String f(String r4) {
            if (StringsKt.startsWith$default(r4, "image/", false, 2, null) == false) goto L6;
            return "image";
        L6:
            if (StringsKt.startsWith$default(r4, "video/", false, 2, null) == false) goto L9;
            return "video";
        L9:
            if (StringsKt.startsWith$default(r4, "audio/", false, 2, null) == false) goto L11;
            return "audio";
        L11:
            return "file";
        }

        private final String g(String r5) {
            if (r5 == null) goto L9;
            String r6 = StringsKt.substringBefore$default(r5, ';', null, 2, null);
            if (r6 == null) goto L9;
            String r7 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")).toString();
            if (r7 == null) goto L9;
            Locale r0 = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(r0, "ROOT");
            String r8 = r7.toLowerCase(r0);
            Intrinsics.checkNotNullExpressionValue(r8, "toLowerCase(...)");
        L11:
            if (r8 != null) goto L13;
            return null;
        L13:
            switch(r8.hashCode()) {
                case -1487394660: goto L30;
                case -586683234: goto L26;
                case 187099443: goto L23;
                case 1331848029: goto L19;
                case 1505115538: goto L16;
                default: goto L37;
            };
        L37:
            return null;
        L16:
            if (r8.equals("audio/wave") == true) goto L36;
            return null;
        L36:
            return "audio/wav";
        L19:
            if (r8.equals("video/mp4") == true) goto L35;
            return null;
        L35:
            return "video/mp4";
        L23:
            if (r8.equals("audio/wav") == true) goto L36;
            return null;
        L26:
            if (r8.equals("audio/x-wav") == true) goto L36;
            return null;
        L30:
            if (r8.equals("image/jpeg") == true) goto L33;
            return null;
        L33:
            return "image/jpeg";
        L9:
            r8 = null;
            goto L11
        }

        /* JADX INFO: renamed from: lambda$4B8z0YP-rZyNqOpvEmHBz7l1-k0, reason: not valid java name */
        public static /* synthetic */ CharSequence m223lambda$4B8z0YPrZyNqOpvEmHBz7l1k0(byte r0) {
            return b(r0);
        }

        public static /* synthetic */ CharSequence lambda$JDDyBQ6d6ABTRBjZLHNApwdItEQ(byte r0) {
            return a(r0);
        }

        public final String a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "taskId");
            Base64.Encoder r1 = Base64.getUrlEncoder().withoutPadding();
            byte[] r3 = r2.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(r3, "getBytes(...)");
            String r4 = r1.encodeToString(r3);
            Intrinsics.checkNotNullExpressionValue(r4, "encodeToString(...)");
            return r4;
        }

        public final String b(String r11) {
            Intrinsics.checkNotNullParameter(r11, "runId");
            MessageDigest r10 = MessageDigest.getInstance(CryptoConst.ALGORITHM_SHA256);
            byte[] r12 = r11.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(r12, "getBytes(...)");
            byte[] r13 = r10.digest(r12);
            Intrinsics.checkNotNullExpressionValue(r13, "digest(...)");
            return CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(ArraysKt.take(r13, 12), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$d$a$JDDyBQ6d6ABTRBjZLHNApwdItEQ.INSTANCE, 30, null);
        }

        public final String c(String r11) {
            Intrinsics.checkNotNullParameter(r11, "accountScope");
            MessageDigest r10 = MessageDigest.getInstance(CryptoConst.ALGORITHM_SHA256);
            byte[] r12 = r11.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(r12, "getBytes(...)");
            byte[] r13 = r10.digest(r12);
            Intrinsics.checkNotNullExpressionValue(r13, "digest(...)");
            return CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(ArraysKt.take(r13, 12), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$d$a$4B8z0YPrZyNqOpvEmHBz7l1k0.INSTANCE, 30, null);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/obric/aiproactive/impl/bridge/ArtifactResourceStore$SourceResult;", "", "file", "Ljava/io/File;", "errorCode", "", "<init>", "(Ljava/io/File;Ljava/lang/String;)V", "getFile", "()Ljava/io/File;", "getErrorCode", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final File f6400a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f6401b;

        /* JADX WARN: Multi-variable type inference failed */
        public b() {
            Object[] r0 = 0 == true ? 1 : 0;
            this(null, r0, 3, 0 == true ? 1 : 0);
        }

        public b(File r2, String r3) {
            Intrinsics.checkNotNullParameter(r3, "errorCode");
            this.f6400a = r2;
            this.f6401b = r3;
        }

        public /* synthetic */ b(File r1, String r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = null;
        L6:
            if ((r3 & 2) == 0) goto L8;
            r2 = "";
        L8:
            this(r1, r2);
        }

        public final File a() {
            return this.f6400a;
        }

        public final String b() {
            return this.f6401b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f6400a, r6.f6400a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f6401b, r6.f6401b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            File r0 = this.f6400a;
            if (r0 != null) goto L5;
            int r1 = 0;
        L7:
            return (r1 * 31) + this.f6401b.hashCode();
        L5:
            r1 = r0.hashCode();
            goto L7
        }

        public String toString() {
            return "SourceResult(file=" + this.f6400a + ", errorCode=" + this.f6401b + ')';
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6402a = null;

        static {
            int[] r0 = new int[RemoteWaveNormalizationResult.values().length];
            r0[RemoteWaveNormalizationResult.VALID.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[RemoteWaveNormalizationResult.INVALID.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[RemoteWaveNormalizationResult.IO_FAILURE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f6402a = r0;
        }
    }

    static {
        f6398a = new a(null);
        k = new byte[]{80, 75, 3, 4};
        l = new byte[]{-119, 80, 78, 71, 13, 10, 26, 10};
        m = MapsKt.mapOf(new Pair[]{TuplesKt.to("png", "image/png"), TuplesKt.to("jpg", "image/jpeg"), TuplesKt.to("jpeg", "image/jpeg"), TuplesKt.to("gif", "image/gif"), TuplesKt.to("webp", "image/webp"), TuplesKt.to("mp4", "video/mp4"), TuplesKt.to("webm", "video/webm"), TuplesKt.to("mp3", "audio/mpeg"), TuplesKt.to("wav", "audio/wav"), TuplesKt.to("m4a", "audio/mp4"), TuplesKt.to("ogg", "audio/ogg"), TuplesKt.to("pdf", "application/pdf"), TuplesKt.to("md", "text/markdown"), TuplesKt.to("markdown", "text/markdown"), TuplesKt.to("html", "text/html"), TuplesKt.to("htm", "text/html"), TuplesKt.to("txt", "text/plain"), TuplesKt.to("json", "application/json"), TuplesKt.to("csv", "text/csv")});
        n = SetsKt.setOf(new String[]{"image", "video", "audio"});
        o = MapsKt.mapOf(new Pair[]{TuplesKt.to("image/jpeg", ".jpg"), TuplesKt.to("audio/wav", ".wav"), TuplesKt.to("video/mp4", ".mp4")});
        p = MapsKt.mapOf(new Pair[]{TuplesKt.to("image", "生成图片"), TuplesKt.to("video", "生成视频"), TuplesKt.to("audio", "生成语音")});
    }

    public d(File r3, File r4, Function1<? super String, ? extends Set<String>> r5, Function0<String> r6, Function0<Long> r7, h r8, Function2<? super File, ? super File, Unit> r9) {
        Function1<String, Set<String>> r10 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Function0<String> r11 = (Function0) ZeusTransformUtils.wrapperContextForParams(r6, Function0.class, "com.obric.memorydata.plugin");
        Function0<Long> r12 = (Function0) ZeusTransformUtils.wrapperContextForParams(r7, Function0.class, "com.obric.memorydata.plugin");
        Function2<File, File, Unit> r13 = (Function2) ZeusTransformUtils.wrapperContextForParams(r9, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "exportShareRoot");
        Intrinsics.checkNotNullParameter(r10, "referencedLocatorsProvider");
        Intrinsics.checkNotNullParameter(r11, "accountScopeProvider");
        Intrinsics.checkNotNullParameter(r12, "nowMs");
        Intrinsics.checkNotNullParameter(r8, "remoteDownloader");
        Intrinsics.checkNotNullParameter(r13, "createHardLink");
        this.f6399b = r4;
        this.c = r10;
        this.d = r11;
        this.e = r12;
        this.f = r8;
        this.g = r13;
        this.h = new File(r3, "managed");
        this.i = new Object();
        this.j = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ d(File r11, File r12, Function1 r13, Function0 r14, Function0 r15, h r16, Function2 r17, int r18, DefaultConstructorMarker r19) {
        Function1 r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r13, Function1.class, "com.obric.memorydata.plugin");
        Function0 r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r14, Function0.class, "com.obric.memorydata.plugin");
        Function0 r0 = (Function0) ZeusTransformUtils.wrapperContextForParams(r15, Function0.class, "com.obric.memorydata.plugin");
        Function2 r2 = (Function2) ZeusTransformUtils.wrapperContextForParams(r17, Function2.class, "com.obric.memorydata.plugin");
        if ((r18 & 16) == 0) goto L5;
        r0 = (Function0) ZeusTransformUtils.preCheckCast(ArtifactResourceStore$1.INSTANCE, Function0.class, "com.obric.memorydata.plugin");
    L5:
        Function0 r7 = r0;
        if ((r18 & 32) == 0) goto L8;
        m r3 = null;
        Object[] r4 = 0 == true ? 1 : 0;
        h r8 = new h(r3, r4, 3, 0 == true ? 1 : 0);
    L10:
        if ((r18 & 64) == 0) goto L12;
        Function2 r9 = $$Lambda$d$49rB83_fFYla4utKlnUoBi74Szo.INSTANCE;
    L13:
        this(r11, r12, r5, r6, r7, r8, r9);
        return;
    L12:
        r9 = r2;
        goto L13
    L8:
        r8 = r16;
        goto L10
    }

    private final f a(i r21, File r22, File r23, l r24, String r25) {
        String r3 = (String) ZeusTransformUtils.preCheckCast(o.get(r25), String.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L6;
        d r0 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.memorydata.plugin");
        r23.delete();
        return r0.b("mime_mismatch");
    L6:
        StringBuilder r4 = new StringBuilder();
        String r7 = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(r7, "toString(...)");
        File r6 = new File(r22, r4.append(StringsKt.replace$default(r7, "-", "", false, 4, null)).append(r3).toString());
        boolean r9 = true;
        Files.move(r23.toPath(), r6.toPath(), new CopyOption[]{StandardCopyOption.ATOMIC_MOVE});     // Catch: SecurityException -> L23 IOException -> L25 AtomicMoveNotSupportedException -> L27
        String r1 = "managed/" + r22.getName() + '/' + r6.getName();
        JSONObject r2 = new JSONObject();
        r2.put("artifact_id", r21.b());
        r2.put("artifact_type", r21.e());
        r2.put("state", "ready");
        r2.put(Api.KEY_DISPLAY_NAME, ((String) ZeusTransformUtils.preCheckCast(MapsKt.getValue(p, r21.e()), String.class, "com.obric.memorydata.plugin")) + r3);
        r2.put("mime_type", r25);
        r2.put("size_bytes", r24.d());
        JSONObject r5 = new JSONObject();
        r5.put(MemoryInfoSectionEditActivity.EXTRA_KIND, "exported_file");
        r5.put("locator", r1);
        Unit r8 = Unit.INSTANCE;
        r2.put("resource", r5);
        Long r10 = r21.f();
        if (r10 == null) goto L22;
        ((Number) ZeusTransformUtils.preCheckCast(r10, Number.class, "com.obric.memorydata.plugin")).longValue();
        if (Intrinsics.areEqual(r21.e(), "audio") == false) goto L13;
    L16:
        if (r9 == true) goto L19;
        r10 = null;
    L19:
        if (r10 == null) goto L22;
        r2.put("duration_ms", ((Number) ZeusTransformUtils.preCheckCast(r10, Number.class, "com.obric.memorydata.plugin")).longValue());
        goto L22
    L13:
        if (Intrinsics.areEqual(r21.e(), "video") == true) goto L16;
        r9 = false;
    L22:
        return new f(true, null, r2, 1, 2, null);
    L25:
        r23.delete();
        return b("atomic_move_failed");
    L23:
        r23.delete();
        return b("atomic_move_failed");
    L27:
        r23.delete();
        return b("atomic_move_failed");
    }

    private final f a(File r12, File r13, long r14) {
        Closeable r2 = (Closeable) ZeusTransformUtils.preCheckCast(new BufferedInputStream((InputStream) ZeusTransformUtils.preCheckCast(new FileInputStream(r12), InputStream.class, "com.obric.memorydata.plugin")), Closeable.class, "com.obric.memorydata.plugin");     // Catch: SecurityException -> L38 IOException -> L40
        BufferedInputStream r3 = (BufferedInputStream) ZeusTransformUtils.preCheckCast(r2, BufferedInputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L33
        Closeable r15 = (Closeable) ZeusTransformUtils.preCheckCast(new FileOutputStream(r13), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L33
        FileOutputStream r1 = (FileOutputStream) ZeusTransformUtils.preCheckCast(r15, FileOutputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L28
        byte[] r4 = new byte[8192];     // Catch: Throwable -> L28
        long r5 = 0;
    L6:
        int r7 = r3.read(r4);     // Catch: Throwable -> L28
        if (r7 < 0) goto L16;
        r5 = r5 + ((long) r7);     // Catch: Throwable -> L28
        if (r5 > 2147483648L) goto L10;
        r1.write(r4, 0, r7);     // Catch: Throwable -> L28
        goto L6
    L10:
        f r16 = b("size_limit_exceeded");     // Catch: Throwable -> L28
        CloseableKt.closeFinally(r15, null);     // Catch: Throwable -> L33
        CloseableKt.closeFinally(r2, null);     // Catch: SecurityException -> L38 IOException -> L40
        return r16;
    L16:
        r1.getFD().sync();     // Catch: Throwable -> L28
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L28
        CloseableKt.closeFinally(r15, null);     // Catch: Throwable -> L33
        Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L33
        CloseableKt.closeFinally(r2, null);     // Catch: SecurityException -> L38 IOException -> L40
        if (r5 != r14) goto L27;
        if (r12.length() != r14) goto L27;
        return new f(true, null, null, 0, 14, null);
    L27:
        return b("size_mismatch");
    L28:
        th = move-exception;
        throw th;     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        CloseableKt.closeFinally(r15, th);     // Catch: Throwable -> L33
        throw th;     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        throw th;     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        CloseableKt.closeFinally(r2, th);     // Catch: SecurityException -> L38 IOException -> L40
        throw th;     // Catch: SecurityException -> L38 IOException -> L40
    L41:
        return b("copy_failed");
    L39:
        return b("copy_failed");
    }

    private final File a(String r3) {
        File r0 = new File(this.h.getParentFile(), r3);
        if (a.a(f6398a, this.h, r0) == true) goto L7;
        return null;
    L7:
        return r0;
    }

    private final String a(File r3, String r4, String r5) {
        a r0 = f6398a;
        String r6 = a.d(r0, r4);
        if (r6 != null) goto L5;
        return null;
    L5:
        String r2 = c(r3);
        if (r2 != null) goto L8;
        return null;
    L8:
        String r7 = a.d(r0, r2);
        if (r7 != null) goto L12;
        return null;
    L12:
        if (Intrinsics.areEqual(a.b(r0, r6), r5) == true) goto L14;
        return null;
    L14:
        if (Intrinsics.areEqual(a.b(r0, r7), r5) == true) goto L16;
        return null;
    L16:
        if (Intrinsics.areEqual(r6, r7) == true) goto L19;
        return null;
    L19:
        if (o.containsKey(r7) == true) goto L21;
        return null;
    L21:
        return r7;
    }

    private final String a(String r8, String r9, String r10) {
        a r0 = f6398a;
        if (a.a(r0, r9) == true) goto L5;
    L51:
        return null;
    L5:
        if (Intrinsics.areEqual(r9, ".") == true) goto L51;
        if (Intrinsics.areEqual(r9, "..") == true) goto L51;
        File r1 = b(r8, r10);
        if (r1 != null) goto L13;
        return null;
    L13:
        if (Intrinsics.areEqual(r1.getName(), r9) == true) goto L50;
        byte[] r3 = r9.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(r3, "getBytes(...)");
        if (r3.length > 255) goto L54;
        File r4 = r1.getParentFile();
        if (r4 != null) goto L20;
        return null;
    L20:
        File r5 = new File(r4, ".open-" + r0.c(r10) + '-' + r1.getName());
        File r11 = new File(r5, r9);
        if (Files.isSymbolicLink(r5.toPath()) == false) goto L24;
    L49:
        return null;
    L24:
        if (a.a(r0, r4, r5) == false) goto L49;
        if (r5.isDirectory() == true) goto L32;
        if (r5.mkdir() == true) goto L32;
        return r8;
    L32:
        if (Files.isSymbolicLink(r11.toPath()) == true) goto L49;
        if (a.a(r0, r5, r11) == false) goto L49;
        if (r11.exists() == false) goto L44;
        if (r11.isFile() == true) goto L41;
    L42:
        return null;
    L41:
        if (Files.isSameFile(r1.toPath(), r11.toPath()) == false) goto L42;
    L55:
        return "managed/" + r4.getName() + '/' + r5.getName() + '/' + r9;
    L44:
        if (a(r1, r11) == true) goto L55;
        r5.delete();     // Catch: Throwable -> L52
        return r8;
    L56:
        return r8;
    L54:
        return r8;
    L50:
        return r8;
    }

    private final Set<String> a(File r5, String r6) {
        if (r5.isFile() == false) goto L19;
        if (r5.length() > 65536) goto L19;
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(FilesKt.readLines$default(r5, null, 1, null), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        Iterator r8 = r7.iterator();     // Catch: Throwable -> L16
    L10:
        if (r8.hasNext() == false) goto L14;
        Object r1 = r8.next();     // Catch: Throwable -> L16
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        if (a.c(f6398a, r2, r6) == false) goto L10;
        r0.add(r1);     // Catch: Throwable -> L16
        goto L10
    L14:
        return (Set) ZeusTransformUtils.preCheckCast(r0, Set.class, "com.obric.memorydata.plugin");
    L17:
        return SetsKt.emptySet();
    L19:
        return SetsKt.emptySet();
    }

    private final void a(File r5) {
        if (Files.isSymbolicLink(r5.toPath()) == false) goto L5;
        return;
    L5:
        if (r5.isDirectory() == true) goto L7;
        return;
    L7:
        if (a.a(f6398a, this.h, r5) == false) goto L31;
        File[] r4 = r5.listFiles();
        int r0 = 0;
        if (r4 != null) goto L12;
        r4 = new File[0];
    L12:
        int r1 = r4.length;
    L13:
        if (r0 >= r1) goto L22;
        File r2 = r4[r0];
        if (r2.isFile() == false) goto L21;
        if (Files.isSymbolicLink(r2.toPath()) == true) goto L21;
        a r3 = f6398a;
        Intrinsics.checkNotNull(r2);
        if (a.a(r3, r5, r2) == false) goto L21;
        r2.delete();
    L21:
        r0 = r0 + 1;
        goto L13
    L22:
        r5.delete();
        return;
    }

    private final void a(File r11, String r12, Set<String> r13) {
        Set r14 = (Set) ZeusTransformUtils.wrapperContextForParams(r13, Set.class, "com.obric.memorydata.plugin");
        String r15 = ".open-" + r12 + '-';
        File[] r0 = r11.listFiles();
        if (r0 != null) goto L5;
        r0 = new File[0];
    L5:
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        int r4 = r0.length;
        int r5 = 0;
    L7:
        if (r5 >= r4) goto L12;
        File r7 = r0[r5];
        String r8 = r7.getName();
        Intrinsics.checkNotNullExpressionValue(r8, "getName(...)");
        if (StringsKt.startsWith$default(r8, r15, false, 2, null) == false) goto L11;
        r3.add(r7);
    L11:
        r5 = r5 + 1;
        goto L7
    L12:
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L14:
        if (r1.hasNext() == false) goto L20;
        File r2 = (File) ZeusTransformUtils.preCheckCast(r1.next(), File.class, "com.obric.memorydata.plugin");
        String r6 = r2.getName();
        Intrinsics.checkNotNullExpressionValue(r6, "getName(...)");
        String r9 = StringsKt.removePrefix(r6, (CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.memorydata.plugin"));
        if (r14.contains("managed/" + r11.getName() + '/' + r9) == false) goto L19;
        if (new File(r11, r9).isFile() == true) goto L14;
    L19:
        Intrinsics.checkNotNull(r2);
        a(r2);
        goto L14
    }

    private final boolean a(File r2, File r3) {
        this.g.invoke(r2, r3);     // Catch: Throwable -> L6
        return true;
    L9:
        return false;
    }

    private final boolean a(File r7, File r8, String r9) {
        String r0 = r8.getName();
        Intrinsics.checkNotNullExpressionValue(r0, "getName(...)");
        if (StringsKt.startsWith$default(r0, ".open-", false, 2, null) == true) goto L5;
        return false;
    L5:
        String r10 = ".open-" + r9 + '-';
        String r1 = r8.getName();
        Intrinsics.checkNotNullExpressionValue(r1, "getName(...)");
        if (StringsKt.startsWith$default(r1, r10, false, 2, null) == false) goto L12;
        String r2 = r8.getName();
        Intrinsics.checkNotNullExpressionValue(r2, "getName(...)");
        if (new File(r7, StringsKt.removePrefix(r2, (CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin"))).isFile() == true) goto L13;
        a(r8);
        return true;
    L13:
        return true;
    L12:
        return true;
    }

    private final boolean a(File r19, Set<String> r20) {
        Set r1 = (Set) ZeusTransformUtils.wrapperContextForParams(r20, Set.class, "com.obric.memorydata.plugin");
        File r3 = new File(r19.getParentFile(), ".staging-commit-" + UUID.randomUUID());
        Closeable r6 = (Closeable) ZeusTransformUtils.preCheckCast(new FileOutputStream(r3), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        FileOutputStream r8 = (FileOutputStream) ZeusTransformUtils.preCheckCast(r6, FileOutputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
        byte[] r0 = CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.sorted((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("\n", CharSequence.class, "com.obric.memorydata.plugin"), null, (CharSequence) ZeusTransformUtils.preCheckCast("\n", CharSequence.class, "com.obric.memorydata.plugin"), 0, null, null, 58, null).getBytes(Charsets.UTF_8);     // Catch: Throwable -> L8
        Intrinsics.checkNotNullExpressionValue(r0, "getBytes(...)");     // Catch: Throwable -> L8
        r8.write(r0);     // Catch: Throwable -> L8
        r8.getFD().sync();     // Catch: Throwable -> L8
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L8
        CloseableKt.closeFinally(r6, null);     // Catch: Throwable -> L15 Throwable -> L15
        Files.move(r3.toPath(), r19.toPath(), new CopyOption[]{StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING});     // Catch: Throwable -> L15 Throwable -> L15
        return true;
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        CloseableKt.closeFinally(r6, th);     // Catch: Throwable -> L15 Throwable -> L15
        throw th;     // Catch: Throwable -> L15 Throwable -> L15
    L15:
        r3.delete();
        return false;
    }

    private final f b(String r8) {
        return new f(false, r8, null, 0, 12, null);
    }

    private final f b(String r20, Set<String> r21) {
        Set r2 = (Set) ZeusTransformUtils.wrapperContextForParams(r21, Set.class, "com.obric.memorydata.plugin");
        if (e.a().matches((CharSequence) ZeusTransformUtils.preCheckCast(r20, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L5;
        String r4 = c();
        if (r4 == null) goto L9;
        a r5 = f6398a;
        String r6 = r5.c(r4);
        String r1 = a.b(r5, r6, r20);
        File r7 = new File(this.h, r1);
        LinkedHashSet r8 = new LinkedHashSet();
        Iterator r3 = r2.iterator();
    L12:
        if (r3.hasNext() == false) goto L19;
        String r9 = (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.memorydata.plugin");
        if (a.c(f6398a, r9, r1) == false) goto L16;
        ((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.memorydata.plugin")).add(r9);
        goto L12
    L16:
        return b("invalid_commit_locator");
    L19:
        if (r7.exists() == true) goto L23;
        return new f(true, null, null, 0, 14, null);
    L23:
        if (a.a(f6398a, this.h, r7) == false) goto L72;
        if (Files.isSymbolicLink(r7.toPath()) == true) goto L72;
        File r10 = new File(r7, ".committed");
        LinkedHashSet r11 = new LinkedHashSet();
        r11.addAll((Collection) ZeusTransformUtils.preCheckCast(a(r10, r1), Collection.class, "com.obric.memorydata.plugin"));
        r11.addAll((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.memorydata.plugin"));
        File[] r12 = r7.listFiles();
        if (r12 != null) goto L30;
        r12 = new File[0];
    L30:
        int r13 = r12.length;
        int r14 = 0;
        int r16 = 0;
    L31:
        if (r14 >= r13) goto L49;
        File r15 = r12[r14];
        if (Intrinsics.areEqual(r15.getName(), ".committed") == true) goto L47;
        Intrinsics.checkNotNull(r15);
        if (a(r7, r15, r6) == true) goto L47;
        String r17 = "managed/" + r1 + '/' + r15.getName();
        String r18 = r15.getName();
        Intrinsics.checkNotNullExpressionValue(r18, "getName(...)");
        String r22 = r1;
        File[] r19 = r12;
        if (StringsKt.startsWith$default(r18, ".staging-", false, 2, null) == true) goto L41;
        if (r11.contains(r17) == false) goto L41;
    L48:
        r14 = r14 + 1;
        r1 = r22;
        r12 = r19;
    L41:
        if (Files.isSymbolicLink(r15.toPath()) == true) goto L48;
        if (r15.isFile() == false) goto L48;
        if (r15.delete() == false) goto L48;
        a(new File(r7, ".open-" + r6 + '-' + r15.getName()));
        r16 = r16 + 1;
    L47:
        r22 = r1;
        r19 = r12;
        goto L48
    L49:
        Iterable r23 = (Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin");
        Collection r24 = (Collection) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r25 = r23.iterator();
    L51:
        if (r25.hasNext() == false) goto L62;
        Object r26 = r25.next();
        File r27 = a((String) ZeusTransformUtils.preCheckCast(r26, String.class, "com.obric.memorydata.plugin"));
        if (r27 != null) goto L55;
    L59:
        boolean r28 = false;
    L60:
        if (r28 == false) goto L51;
        r24.add(r26);
        goto L51
    L55:
        if (r27.isFile() == false) goto L59;
        if (Files.isSymbolicLink(r27.toPath()) == true) goto L59;
        r28 = true;
        goto L60
    L62:
        LinkedHashSet r29 = (LinkedHashSet) ZeusTransformUtils.preCheckCast(r24, LinkedHashSet.class, "com.obric.memorydata.plugin");
        if (r29.isEmpty() == false) goto L66;
        r10.delete();
        r7.delete();
    L70:
        return new f(true, null, null, r16, 6, null);
    L66:
        if (a(r10, (Set) ZeusTransformUtils.preCheckCast(r29, Set.class, "com.obric.memorydata.plugin")) == true) goto L70;
        return b("copy_failed");
    L72:
        return b("invalid_commit_locator");
    L9:
        return b("account_scope_unavailable");
    L5:
        return b("invalid_run_id");
    }

    private final File b(String r10, String r11) {
        boolean r0 = true;
        List r2 = StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin"), new char[]{'/'}, false, 0, 6, null);
        if (r2.size() != 3) goto L40;
        a r3 = f6398a;
        if (a.c(r3, r10, (String) ZeusTransformUtils.preCheckCast(r2.get(1), String.class, "com.obric.memorydata.plugin")) == false) goto L42;
        boolean r4 = StringsKt.startsWith$default((String) ZeusTransformUtils.preCheckCast(r2.get(1), String.class, "com.obric.memorydata.plugin"), r3.c(r11) + '-', false, 2, null);
        if (new Regex("[a-f0-9]{24}").matches((CharSequence) ZeusTransformUtils.preCheckCast(r2.get(1), CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L17;
        Set r12 = (Set) ZeusTransformUtils.preCheckCast(this.c.invoke(r11), Set.class, "com.obric.memorydata.plugin");
        if (r12 != null) goto L12;
    L14:
        boolean r13 = false;
    L15:
        if (r13 == false) goto L17;
        boolean r14 = true;
    L18:
        if (r4 == true) goto L21;
        if (r14 == true) goto L21;
        return null;
    L21:
        File r15 = a(r10);
        if (r15 != null) goto L24;
        return null;
    L24:
        File r16 = r15.getParentFile();
        if (r16 != null) goto L28;
        return null;
    L28:
        if (r15.isFile() == true) goto L30;
    L36:
        r0 = false;
    L37:
        if (r0 == true) goto L39;
        return null;
    L39:
        return r15;
    L30:
        if (Files.isSymbolicLink(r15.toPath()) == true) goto L36;
        if (Files.isSymbolicLink(r16.toPath()) == true) goto L36;
        if (Files.isSymbolicLink(this.h.toPath()) == true) goto L36;
    L12:
        if (r12.contains(r10) != true) goto L14;
        r13 = true;
    L17:
        r14 = false;
        goto L18
    L42:
        return null;
    L40:
        return null;
    }

    private final String b(i r7) {
        if (e.a().matches((CharSequence) ZeusTransformUtils.preCheckCast(r7.a(), CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L6;
        return "invalid_run_id";
    L6:
        if (e.a().matches((CharSequence) ZeusTransformUtils.preCheckCast(r7.b(), CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L9;
        return "invalid_artifact_id";
    L9:
        if (n.contains(r7.e()) == false) goto L29;
        Long r6 = r7.f();
        boolean r8 = true;
        if (r6 == null) goto L22;
        long r2 = ((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.memorydata.plugin")).longValue();
        if (r2 >= 0) goto L16;
    L19:
        boolean r9 = true;
    L20:
        if (r9 != true) goto L22;
    L23:
        if (r8 == true) goto L30;
        return null;
    L30:
        return "invalid_metadata";
    L16:
        if (r2 > WifiScanStateMachine.WAKE_LOCK_TIMEOUT_1_DATE_MS) goto L19;
        r9 = false;
    L22:
        r8 = false;
        goto L23
    L29:
        return "invalid_metadata";
    }

    private final String b(File r4, String r5) {
        String r3 = c(r4);
        Map<String, String> r0 = m;
        String r6 = FilesKt.getExtension(r4);
        Locale r1 = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(r1, "ROOT");
        String r7 = r6.toLowerCase(r1);
        Intrinsics.checkNotNullExpressionValue(r7, "toLowerCase(...)");
        String r8 = (String) ZeusTransformUtils.preCheckCast(r0.get(r7), String.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L7;
        if (r8 != null) goto L6;
        String r2 = "application/octet-stream";
    L9:
        if (r3 != null) goto L11;
    L13:
        if (r3 != null) goto L18;
        if (r8 == null) goto L18;
        if (a.d(f6398a, r5, r8) == true) goto L18;
        return null;
    L18:
        return r2;
    L11:
        if (a.d(f6398a, r5, r3) == true) goto L13;
        return null;
    L6:
        r2 = r8;
        goto L9
    L7:
        r2 = r3;
        goto L9
    }

    private static final Unit b(File r1, File r2) {
        Intrinsics.checkNotNullParameter(r1, AILabCheckPermissionTask.KEY_SOURCE);
        Intrinsics.checkNotNullParameter(r2, TypedValues.AttributesType.S_TARGET);
        Files.createLink(r2.toPath(), r1.toPath());
        return Unit.INSTANCE;
    }

    private final boolean b(File r5) {
        if (this.h.exists() == false) goto L5;
    L7:
        File r0 = this.h.getParentFile();
        if (r0 != null) goto L10;
        return false;
    L10:
        a r2 = f6398a;
        if (a.a(r2, r0, this.h) == true) goto L13;
        return false;
    L13:
        if (Files.isSymbolicLink(this.h.toPath()) == false) goto L16;
        return false;
    L16:
        if (r5.exists() == true) goto L21;
        if (r5.mkdirs() == true) goto L21;
        return false;
    L21:
        if (r5.isDirectory() == true) goto L23;
        return false;
    L23:
        if (Files.isSymbolicLink(r5.toPath()) == false) goto L25;
        return false;
    L25:
        if (a.a(r2, this.h, r5) == false) goto L31;
        return true;
    L31:
        return false;
    L5:
        if (this.h.mkdirs() == true) goto L7;
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v5 */
    private final f c(String r23, String r24) {
        String r5 = "com.obric.memorydata.plugin";
        Set<String> r3 = (Set) ZeusTransformUtils.preCheckCast(this.c.invoke(r23), Set.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L7;
        return b("reference_index_unavailable");
    L7:
        if (Intrinsics.areEqual(c(), r23) == true) goto L11;
        return b("account_scope_changed");
    L11:
        if (this.h.exists() == false) goto L13;
        long r6 = ((Number) ZeusTransformUtils.preCheckCast(this.e.invoke(), Number.class, "com.obric.memorydata.plugin")).longValue() - WifiScanStateMachine.WAKE_LOCK_TIMEOUT_1_DATE_MS;
        File[] r1 = this.h.listFiles();
        int r4 = 0;
        if (r1 != null) goto L17;
        r1 = new File[0];
    L17:
        int r8 = r1.length;
        int r9 = 0;
        int r14 = 0;
    L18:
        if (r9 >= r8) goto L80;
        File r10 = r1[r9];
        if (r10.isDirectory() == true) goto L22;
    L76:
        File[] r16 = r1;
    L77:
        int r11 = r4;
        String r19 = r5;
        long r20 = r6;
        int r17 = r8;
    L78:
        r9 = r9 + 1;
        r4 = r11;
        r1 = r16;
        r8 = r17;
        r5 = r19;
        r6 = r20;
        goto L18
    L22:
        if (Files.isSymbolicLink(r10.toPath()) == true) goto L76;
        a r12 = f6398a;
        File r13 = this.h;
        Intrinsics.checkNotNull(r10);
        if (a.a(r12, r13, r10) == false) goto L76;
        String r15 = r10.getName();
        Intrinsics.checkNotNullExpressionValue(r15, "getName(...)");
        if (new Regex("[a-f0-9]{24}").matches((CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, r5)) == false) goto L29;
        a(r10, r24, r3);
        goto L76
    L29:
        String r18 = r10.getName();
        Intrinsics.checkNotNullExpressionValue(r18, "getName(...)");
        r16 = r1;
        if (StringsKt.startsWith$default(r18, r24 + '-', r4, 2, null) == false) goto L77;
        File[] r110 = r10.listFiles();
        if (r110 != null) goto L34;
        r110 = new File[r4];
    L34:
        int r111 = r110.length;
        int r2 = r4;
    L36:
        if (r2 >= r111) goto L59;
        File r112 = r110[r2];
        Intrinsics.checkNotNull(r112);
        if (a(r10, r112, r24) == false) goto L40;
    L56:
        String r113 = r5;
    L57:
        long r21 = r6;
        int r114 = r8;
        File[] r115 = r110;
        char r22 = 2;
    L58:
        r8 = r114;
        r110 = r115;
        r5 = r113;
        r6 = r21;
        r2 = r2 + 1;
        goto L36
    L40:
        if (r112.isFile() == false) goto L56;
        if (Files.isSymbolicLink(r112.toPath()) == true) goto L56;
        if (r112.lastModified() > r6) goto L56;
        r113 = r5;
        if (Intrinsics.areEqual(r112.getName(), ".committed") == true) goto L57;
        String r7 = "managed/" + r10.getName() + '/' + r112.getName();
        String r25 = r112.getName();
        Intrinsics.checkNotNullExpressionValue(r25, "getName(...)");
        r21 = r6;
        r114 = r8;
        r115 = r110;
        r22 = 2;
        if (StringsKt.startsWith$default(r25, ".staging-", false, 2, null) == true) goto L53;
        if (r3.contains(r7) == true) goto L58;
    L53:
        if (r112.delete() == false) goto L58;
        a(new File(r10, ".open-" + r24 + '-' + r112.getName()));
        r14 = r14 + 1;
        goto L58
    L59:
        r19 = r5;
        r20 = r6;
        r17 = r8;
        File r26 = new File(r10, ".committed");
        File[] r27 = r10.listFiles();
        r11 = 0;
        r11 = 0;
        if (r27 != null) goto L62;
        r27 = new File[0];
    L62:
        int r28 = r27.length;
        int r29 = 0;
    L63:
        boolean r30 = true;
        if (r29 >= r28) goto L74;
        File r116 = r27[r29];
        if (r116.isFile() == true) goto L68;
    L70:
        r30 = false;
    L71:
        if (r30 == true) goto L72;
        r29 = r29 + 1;
        goto L63
    L72:
        r30 = false;
        goto L74
    L68:
        if (Intrinsics.areEqual(r116.getName(), ".committed") == true) goto L70;
    L74:
        if (r30 == false) goto L78;
        r26.delete();
        r10.delete();
        goto L78
    L80:
        return new f(true, null, null, r14, 6, null);
    L13:
        return new f(true, null, null, 0, 14, null);
    }

    private final String c() {
        String r3 = (String) ZeusTransformUtils.preCheckCast(this.d.invoke(), String.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L13;
        String r4 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (r4 != null) goto L7;
        return null;
    L7:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == true) goto L12;
        return null;
    L12:
        return r4;
    L9:
        r1 = false;
        goto L10
    L13:
        return null;
    }

    private final String c(File r13) {
        byte[] r1 = new byte[16];
        Closeable r3 = (Closeable) ZeusTransformUtils.preCheckCast(new FileInputStream(r13), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L82
        int r0 = ((FileInputStream) ZeusTransformUtils.preCheckCast(r3, FileInputStream.class, "com.obric.memorydata.plugin")).read(r1);     // Catch: Throwable -> L77
        CloseableKt.closeFinally(r3, null);     // Catch: Throwable -> L82 Throwable -> L82
        if (r0 < 8) goto L13;
        if (Arrays.equals(ArraysKt.copyOfRange(r1, 0, 8), l) == false) goto L13;
        return "image/png";
    L13:
        if (r0 < 3) goto L23;
        if (r1[0] != (-1)) goto L23;
        if (r1[1] != (-40)) goto L23;
        if (r1[2] != (-1)) goto L23;
        return "image/jpeg";
    L23:
        if (r0 < 6) goto L35;
        String r8 = new String(r1, 0, 6, Charsets.US_ASCII);
        if (Intrinsics.areEqual(r8, "GIF87a") == false) goto L27;
    L30:
        boolean r7 = true;
    L31:
        if (r7 == false) goto L35;
        return "image/gif";
    L27:
        if (Intrinsics.areEqual(r8, "GIF89a") == true) goto L30;
        r7 = false;
    L35:
        if (r0 >= 12) goto L37;
    L42:
        if (r0 >= 12) goto L44;
    L49:
        if (r0 >= 8) goto L51;
    L54:
        if (r0 >= 4) goto L56;
    L59:
        if (r0 >= 3) goto L61;
    L64:
        if (r0 < 4) goto L70;
        if (Intrinsics.areEqual(new String(r1, 0, 4, Charsets.US_ASCII), "OggS") == false) goto L70;
        return "audio/ogg";
    L70:
        if (StringsKt.equals(FilesKt.getExtension(r13), "docx", true) == false) goto L76;
        if (r0 < 4) goto L76;
        if (Arrays.equals(ArraysKt.copyOfRange(r1, 0, 4), k) == false) goto L76;
        return d(r13);
    L76:
        return null;
    L61:
        if (Intrinsics.areEqual(new String(r1, 0, 3, Charsets.US_ASCII), "ID3") == false) goto L64;
        return "audio/mpeg";
    L56:
        if (Intrinsics.areEqual(new String(r1, 0, 4, Charsets.US_ASCII), "%PDF") == false) goto L59;
        return "application/pdf";
    L51:
        if (Intrinsics.areEqual(new String(r1, 4, 4, Charsets.US_ASCII), "ftyp") == false) goto L54;
        return "video/mp4";
    L44:
        if (Intrinsics.areEqual(new String(r1, 0, 4, Charsets.US_ASCII), "RIFF") == false) goto L49;
        if (Intrinsics.areEqual(new String(r1, 8, 4, Charsets.US_ASCII), "WAVE") == false) goto L49;
        return "audio/wav";
    L37:
        if (Intrinsics.areEqual(new String(r1, 0, 4, Charsets.US_ASCII), "RIFF") == false) goto L42;
        if (Intrinsics.areEqual(new String(r1, 8, 4, Charsets.US_ASCII), "WEBP") == false) goto L42;
        return "image/webp";
    L77:
        th = move-exception;
        throw th;     // Catch: Throwable -> L79
    L79:
        th = move-exception;
        CloseableKt.closeFinally(r3, th);     // Catch: Throwable -> L82 Throwable -> L82
        throw th;     // Catch: Throwable -> L82 Throwable -> L82
    L82:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final b d(String r9, String r10) {
        int r2 = 1;
        File r3 = null;
        Object[] r4 = 0;
        Object[] r5 = 0;
        Object[] r6 = 0;
        Object[] r7 = 0;
        Object[] r8 = 0;
        Object[] r11 = 0;
        Object[] r12 = 0;
        Object[] r13 = 0;
        Object[] r14 = 0;
        Object[] r15 = 0;
        Object[] r16 = 0;
        Object[] r17 = 0;
        Object[] r18 = 0;
        Object[] r19 = 0;
        Object[] r20 = 0;
        Object[] r21 = 0;
        Object[] r22 = 0;
        Object[] r23 = 0;
        Object[] r24 = 0;
        Object[] r25 = 0;
        Object[] r26 = 0;
        Object[] r27 = 0;
        Object[] r28 = 0;
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L5;
    L61:
        Object[] r29 = r5 == true ? 1 : 0;
        return new b(r29, "invalid_request", r2, r4 == true ? 1 : 0);
    L5:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L61;
        if (r9.length() > 4096) goto L61;
        File r30 = this.f6399b;
        String r0 = "source_unreadable";
        if (r30 == null) goto L12;
        String r1 = r30.getName();
        Intrinsics.checkNotNullExpressionValue(r1, "getName(...)");
        int r31 = 2;
        if (StringsKt.startsWith$default(r1, "zeus_", false, 2, null) == false) goto L16;
        r30 = r30.getParentFile();
    L16:
        File r32 = new File(new File(new File(r30, "zeus_com.obric.aiagent.plugin"), "omni_exports"), f6398a.a(r10));
        File r33 = new File(r9);
        String r110 = "source_out_of_scope";
        if (r33.isAbsolute() == false) goto L19;
        Path r34 = r32.getAbsoluteFile().toPath().normalize();
        Path r35 = r33.getAbsoluteFile().toPath().normalize();
        if (r35.startsWith(r34) == false) goto L60;
        if (Intrinsics.areEqual(r35, r34) == true) goto L60;
    L25:
        if (r35 != null) goto L27;
    L63:
        File r36 = r32.getCanonicalFile();     // Catch: IOException -> L57
        File r37 = r33.getCanonicalFile();     // Catch: IOException -> L55
        a r38 = f6398a;
        Intrinsics.checkNotNull(r36);
        Intrinsics.checkNotNull(r37);
        if (a.a(r38, r36, r37) == true) goto L42;
        return new b(r23 == true ? 1 : 0, r110, r2, r22 == true ? 1 : 0);
    L42:
        if (r37.exists() == true) goto L46;
        Object[] r39 = r21 == true ? 1 : 0;
        return new b(r39, "source_not_found", r2, r20 == true ? 1 : 0);
    L46:
        if (r37.isFile() == true) goto L50;
        Object[] r40 = r19 == true ? 1 : 0;
        return new b(r40, "source_not_file", r2, r18 == true ? 1 : 0);
    L50:
        if (r37.canRead() == true) goto L54;
        return new b(r17 == true ? 1 : 0, r0, r2, r16 == true ? 1 : 0);
    L54:
        return new b(r37, r15 == true ? 1 : 0, r31, r14 == true ? 1 : 0);
    L56:
        return new b(r13 == true ? 1 : 0, r0, r2, r12 == true ? 1 : 0);
    L58:
        return new b(r11 == true ? 1 : 0, r0, r2, r8 == true ? 1 : 0);
    L27:
        if (r35.startsWith(r34) == false) goto L63;
        if (Files.isSymbolicLink(r35) == true) goto L30;
        if (Intrinsics.areEqual(r35, r34) == true) goto L63;
        r35 = r35.getParent();
        goto L25
    L30:
        Object[] r41 = r25 == true ? 1 : 0;
        return new b(r41, "source_symlink", r2, r24 == true ? 1 : 0);
    L60:
        return new b(r7 == true ? 1 : 0, r110, r2, r6 == true ? 1 : 0);
    L19:
        return new b(r27 == true ? 1 : 0, r110, r2, r26 == true ? 1 : 0);
    L12:
        return new b(r3, r0, r2, r28 == true ? 1 : 0);
    }

    private final String d(File r5) {
        Closeable r6 = (Closeable) ZeusTransformUtils.preCheckCast(new ZipFile(r5), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L31
        ZipFile r4 = (ZipFile) ZeusTransformUtils.preCheckCast(r6, ZipFile.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25
        ZipEntry r1 = r4.getEntry("[Content_Types].xml");     // Catch: Throwable -> L25
        boolean r2 = true;
        if (r1 != null) goto L7;
    L9:
        boolean r3 = false;
    L10:
        if (r3 == false) goto L22;
        ZipEntry r7 = r4.getEntry("word/document.xml");     // Catch: Throwable -> L25
        if (r7 != null) goto L14;
    L16:
        r2 = false;
    L17:
        if (r2 == false) goto L22;
        if (r4.getEntry("word/vbaProject.bin") != null) goto L22;
        String r8 = "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
    L23:
        CloseableKt.closeFinally(r6, null);     // Catch: Throwable -> L31 Throwable -> L31
        return r8;
    L14:
        if (r7.isDirectory() == true) goto L16;
    L22:
        r8 = null;
        goto L23
    L7:
        if (r1.isDirectory() == true) goto L9;
        r3 = true;
    L25:
        th = move-exception;
        throw th;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        CloseableKt.closeFinally(r6, th);     // Catch: Throwable -> L31 Throwable -> L31
        throw th;     // Catch: Throwable -> L31 Throwable -> L31
    L37:
        return null;
    }

    public static /* synthetic */ Unit lambda$49rB83_fFYla4utKlnUoBi74Szo(File r0, File r1) {
        return b(r0, r1);
    }

    public final f a() {
        Object r0 = this.i;
        monitor-enter(r0);
        String r1 = c();     // Catch: Throwable -> L21
        if (r1 != null) goto L9;
        f r13 = b("account_scope_unavailable");     // Catch: Throwable -> L21
        monitor-exit(r0);
        return r13;
    L9:
        String r2 = f6398a.c(r1);     // Catch: Throwable -> L21
        long r3 = ((Number) ZeusTransformUtils.preCheckCast(this.e.invoke(), Number.class, "com.obric.memorydata.plugin")).longValue();     // Catch: Throwable -> L21
        Long r5 = (Long) ZeusTransformUtils.preCheckCast(this.j.get(r2), Long.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        if (r5 != null) goto L12;
    L16:
        f r4 = c(r1, r2);     // Catch: Throwable -> L21
        if (r4.a() == false) goto L19;
        Long r6 = Long.valueOf(r3);     // Catch: Throwable -> L21
        this.j.put(r2, r6);     // Catch: Throwable -> L21
    L19:
        monitor-exit(r0);
        return r4;
    L12:
        if ((r3 - r5.longValue()) >= WifiScanStateMachine.WAKE_LOCK_TIMEOUT_1_DATE_MS) goto L16;
        f r14 = new f(true, null, null, 0, 14, null);     // Catch: Throwable -> L21
        monitor-exit(r0);
        return r14;
    L21:
        th = move-exception;
        throw th;
    }

    public final f a(com.obric.aiproactive.impl.bridge.b r22) {
        Intrinsics.checkNotNullParameter(r22, Ext.KEY_REQUEST);
        if (e.a().matches((CharSequence) ZeusTransformUtils.preCheckCast(r22.a(), CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L7;
        return b("invalid_run_id");
    L7:
        if (e.a().matches((CharSequence) ZeusTransformUtils.preCheckCast(r22.b(), CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L9;
        a r2 = f6398a;
        if (a.a(r2, r22.e()) == false) goto L101;
        if (e.b().matches((CharSequence) ZeusTransformUtils.preCheckCast(r22.f(), CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L101;
        Long r4 = r22.g();
        boolean r5 = true;
        if (r4 == null) goto L25;
        long r12 = ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).longValue();
        if (r12 >= 0) goto L19;
    L22:
        boolean r6 = true;
    L23:
        if (r6 != true) goto L25;
        boolean r7 = true;
    L26:
        if (r7 == true) goto L101;
        Long r8 = r22.i();
        if (r8 == null) goto L38;
        long r13 = ((Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.memorydata.plugin")).longValue();
        if (r13 >= 0) goto L32;
    L35:
        boolean r9 = true;
    L36:
        if (r9 != true) goto L38;
        boolean r10 = true;
    L39:
        if (r10 == true) goto L101;
        b r11 = d(r22.c(), r22.d());
        File r14 = r11.a();
        if (r14 == null) goto L44;
        long r15 = r14.length();
        if (r15 <= 2147483648L) goto L50;
        return b("size_limit_exceeded");
    L50:
        if (r22.g() == null) goto L58;
        Long r16 = r22.g();
        if (r16 == null) goto L57;
        if (r16.longValue() == r15) goto L58;
    L57:
        return b("size_mismatch");
    L58:
        String r17 = b(r14, r22.f());
        if (r17 == null) goto L61;
        String r18 = a.b(r2, r17);
        if (a.a(r2, r22.h(), r18) == false) goto L65;
        String r19 = c();
        if (r19 == null) goto L69;
        File r110 = new File(this.h, a.b(r2, r2.c(r19), r22.a()));
        if (b(r110) == false) goto L73;
        String r20 = r14.getName();
        Intrinsics.checkNotNullExpressionValue(r20, "getName(...)");
        String r3 = a.c(r2, r20);
        StringBuilder r21 = new StringBuilder();
        String r111 = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(r111, "toString(...)");
        File r23 = new File(r110, r21.append(StringsKt.replace$default(r111, "-", "", false, 4, null)).append(r3).toString());
        File r24 = new File(r110, ".staging-" + UUID.randomUUID());
        f r25 = a(r14, r24, r15);
        if (r25.a() == true) goto L102;
        r24.delete();
        return r25;
    L102:
        Files.move(r24.toPath(), r23.toPath(), new CopyOption[]{StandardCopyOption.ATOMIC_MOVE});     // Catch: SecurityException -> L94 IOException -> L96 AtomicMoveNotSupportedException -> L98
        String r0 = "managed/" + r110.getName() + '/' + r23.getName();
        JSONObject r1 = new JSONObject();
        r1.put("artifact_id", r22.b());
        r1.put("artifact_type", r18);
        r1.put("state", "ready");
        r1.put(Api.KEY_DISPLAY_NAME, StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r22.e(), CharSequence.class, "com.obric.memorydata.plugin")).toString());
        r1.put("mime_type", r17);
        r1.put("size_bytes", r15);
        JSONObject r26 = new JSONObject();
        r26.put(MemoryInfoSectionEditActivity.EXTRA_KIND, "exported_file");
        r26.put("locator", r0);
        Unit r27 = Unit.INSTANCE;
        r1.put("resource", r26);
        Long r28 = r22.i();
        if (r28 == null) goto L93;
        ((Number) ZeusTransformUtils.preCheckCast(r28, Number.class, "com.obric.memorydata.plugin")).longValue();
        if (Intrinsics.areEqual(r18, "audio") == false) goto L84;
    L87:
        if (r5 == true) goto L90;
        r28 = null;
    L90:
        if (r28 == null) goto L93;
        r1.put("duration_ms", ((Number) ZeusTransformUtils.preCheckCast(r28, Number.class, "com.obric.memorydata.plugin")).longValue());
        goto L93
    L84:
        if (Intrinsics.areEqual(r18, "video") == true) goto L87;
        r5 = false;
    L93:
        return new f(true, null, r1, 1, 2, null);
    L94:
        r24.delete();
        return b("atomic_move_failed");
    L98:
        r24.delete();
        return b("atomic_move_failed");
    L96:
        r24.delete();
        return b("atomic_move_failed");
    L73:
        return b("copy_failed");
    L69:
        return b("account_scope_unavailable");
    L65:
        return b("mime_mismatch");
    L61:
        return b("mime_mismatch");
    L44:
        return b(r11.b());
    L32:
        if (r13 > WifiScanStateMachine.WAKE_LOCK_TIMEOUT_1_DATE_MS) goto L35;
        r9 = false;
    L38:
        r10 = false;
        goto L39
    L19:
        if (r12 > 2147483648L) goto L22;
        r6 = false;
    L25:
        r7 = false;
    L101:
        return b("invalid_metadata");
    L9:
        return b("invalid_artifact_id");
    }

    public final f a(i r15) {
        Intrinsics.checkNotNullParameter(r15, Ext.KEY_REQUEST);
        String r0 = b(r15);
        if (r0 != null) goto L5;
        String r1 = c();
        if (r1 == null) goto L9;
        a r2 = f6398a;
        File r5 = new File(this.h, a.b(r2, r2.c(r1), r15.a()));
        if (b(r5) == false) goto L13;
        File r3 = new File(r5, ".staging-" + UUID.randomUUID());
        l r7 = h.a(this.f, r15.c(), r15.d(), r3, 0, 8, null);
        if (r7.a() == true) goto L19;
        r3.delete();
        return b(r7.b());
    L19:
        if (Intrinsics.areEqual(c(), r1) == true) goto L22;
        r3.delete();
        return b("account_scope_changed");
    L22:
        String r8 = a(r3, r7.c(), r15.e());
        if (r8 != null) goto L27;
        r3.delete();
        return b("mime_mismatch");
    L27:
        if (Intrinsics.areEqual(r8, "audio/wav") == false) goto L41;
        int r4 = c.f6402a[n.f6422a.a(r3).ordinal()];
        if (r4 == 1) goto L41;
        if (r4 != 2) goto L33;
        r3.delete();
        return b("mime_mismatch");
    L33:
        if (r4 != 3) goto L37;
        r3.delete();
        return b("copy_failed");
    L37:
        throw new NoWhenBranchMatchedException();
    L41:
        return a(r15, r5, r3, r7, r8);
    L13:
        return b("copy_failed");
    L9:
        return b("account_scope_unavailable");
    L5:
        return b(r0);
    }

    public final f a(String r3, Set<String> r4) {
        Set<String> r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "runId");
        Intrinsics.checkNotNullParameter(r5, "committedLocators");
        Object r0 = this.i;
        monitor-enter(r0);
        f r2 = b(r3, r5);     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r2;
    L7:
        th = move-exception;
        throw th;
    }

    public final String a(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "locator");
        Intrinsics.checkNotNullParameter(r5, "displayName");
        Object r0 = this.i;
        monitor-enter(r0);
        String r1 = c();     // Catch: Throwable -> L14
        String r2 = null;
        if (r1 == null) goto L12;
        String r6 = a(r4, r5, r1);     // Catch: Throwable -> L14
        if (r6 == null) goto L12;
        if (Intrinsics.areEqual(c(), r1) == false) goto L12;
        r2 = r6;
    L12:
        monitor-exit(r0);
        return r2;
    L14:
        th = move-exception;
        throw th;
    }

    public final f b() {
        Object r0 = this.i;
        monitor-enter(r0);
        String r1 = c();     // Catch: Throwable -> L10
        if (r1 != null) goto L7;
        f r3 = b("account_scope_unavailable");     // Catch: Throwable -> L10
    L8:
        monitor-exit(r0);
        return r3;
    L7:
        r3 = c(r1, f6398a.c(r1));     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }
}
