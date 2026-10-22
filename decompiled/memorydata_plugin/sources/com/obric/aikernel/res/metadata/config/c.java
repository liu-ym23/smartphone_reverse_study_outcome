package com.obric.aikernel.res.metadata.config;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.google.gson.JsonObject;
import com.obric.aikernel.res.PackageResourceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 12\u00020\u0001:\u00011B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ.\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'2\u0006\u0010)\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u0003H\u0016J\u0006\u0010,\u001a\u00020\tJ\u000e\u0010-\u001a\u00020\t2\u0006\u0010.\u001a\u00020/J\u0006\u00100\u001a\u00020\tR\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\u0016\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0011\u0010\u0018\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010R\u0011\u0010\u001a\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0010R\u0011\u0010\u001c\u001a\u00020\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010 \u001a\u00020\u001d¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001fR\u0011\u0010\"\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0010R\u0011\u0010$\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\r¨\u00062"}, d2 = {"Lcom/obric/aikernel/res/metadata/config/Downloadable;", "Lcom/obric/aikernel/res/metadata/config/DistConfig;", ActivityLifecycle.NAME, "", "json", "Lcom/google/gson/JsonObject;", "defaultWifiOnly", "", "enableBackgroundRestriction", "", "(Ljava/lang/String;Lcom/google/gson/JsonObject;IZ)V", "backgroundRestrictionEnabled", "getBackgroundRestrictionEnabled", "()Z", "dirName", "getDirName", "()Ljava/lang/String;", "downloadType", "getDownloadType", "()I", "encryptType", "getEncryptType", "fileName", "getFileName", "md5", "getMd5", "originMd5", "getOriginMd5", "originSize", "", "getOriginSize", "()J", "size", "getSize", "url", "getUrl", "wifiOnly", "getWifiOnly", "getDownloadFiles", "", "Lcom/obric/aikernel/res/downloader/DownloadTask$FileInfo;", "savePath", "tmpPath", "resourceType", "hasDecryptKeyInfo", "needDecrypt", "callback", "Lcom/obric/aikernel/res/PackageResourceManager$PresmConfig$DecryptFeature;", "shouldDecryptToStorage", "Companion", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class c extends com.obric.aikernel.res.metadata.config.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6064a = null;
    private static final Set<String> m = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f6065b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;
    private final long g;
    private final long h;
    private final boolean i;
    private final boolean j;
    private final int k;
    private final String l;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/obric/aikernel/res/metadata/config/Downloadable$Companion;", "", "()V", "ENCRYPT_NONE", "", "ENCRYPT_RUNTIME", "ENCRYPT_STORAGE_FULL", "ENCRYPT_STORAGE_PART", "NO_STORAGE_DECRYPT_TYPES", "", "getNO_STORAGE_DECRYPT_TYPES", "()Ljava/util/Set;", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f6064a = new a(null);
        m = SetsKt.setOf(new String[]{"none", "runtime"});
    }

    public c(String r5, JsonObject r6, int r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r5, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r6, "json");
        String r1 = "";
        super("", r5, r6);
        this.f6065b = r8;
        String r0 = b.b(r6, ActivityLifecycle.NAME);
        if (r0 != null) goto L7;
        r0 = b.b(r6, "filename");
        if (r0 != null) goto L7;
    L8:
        this.c = r5;
        String r9 = b.b(r6, "md5");
        if (r9 != null) goto L11;
        r9 = "";
    L11:
        this.d = r9;
        String r10 = b.b(r6, "url");
        if (r10 != null) goto L16;
        r10 = b.b(r6, "download_url");
        if (r10 != null) goto L16;
        r10 = "";
    L16:
        this.e = r10;
        String r11 = b.b(r6, "origin_md5");
        if (r11 == null) goto L20;
        r1 = r11;
    L20:
        this.f = r1;
        Long r12 = b.d(r6, "size");
        long r2 = 0;
        if (r12 == null) goto L23;
    L22:
        long r3 = r12.longValue();
    L27:
        this.g = r3;
        Long r13 = b.d(r6, "origin_size_bytes");
        if (r13 == null) goto L30;
        r2 = r13.longValue();
    L30:
        this.h = r2;
        Integer r14 = b.c(r6, "wifi_only");
        if (r14 == null) goto L33;
        r7 = r14.intValue();
    L33:
        int r15 = 0;
        boolean r4 = true;
        if (r7 == 1) goto L37;
        r4 = false;
    L37:
        this.i = r4;
        this.j = r8;
        Integer r16 = b.c(r6, "download_type");
        if (r16 == null) goto L40;
        r15 = r16.intValue();
    L40:
        this.k = r15;
        String r17 = b.b(r6, "encrypt_type");
        if (r17 != null) goto L43;
        r17 = "none";
    L43:
        this.l = r17;
        return;
    L23:
        r12 = b.d(r6, "size_bytes");
        if (r12 != null) goto L22;
        r3 = 0;
    L7:
        r5 = r0;
        goto L8
    }

    public /* synthetic */ c(String r1, JsonObject r2, int r3, boolean r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 4) == 0) goto L6;
        r3 = 0;
    L6:
        if ((r5 & 8) == 0) goto L8;
        r4 = true;
    L8:
        this(r1, r2, r3, r4);
    }

    @Override // com.obric.aikernel.res.metadata.config.a
    public List<com.obric.aikernel.res.downloader.j.b> a(String r18, String r19, int r20, String r21) {
        Intrinsics.checkNotNullParameter(r18, "savePath");
        Intrinsics.checkNotNullParameter(r19, "tmpPath");
        Intrinsics.checkNotNullParameter(r21, "resourceType");
        if (r20 < this.k) goto L16;
        boolean r2 = true;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(this.e, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == false) goto L16;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(this.d, CharSequence.class, "com.obric.memorydata.plugin")).length() > 0) goto L13;
        r2 = false;
    L13:
        if (r2 == false) goto L16;
        return CollectionsKt.listOf(new com.obric.aikernel.res.downloader.j.b(this.c, this.d, this.e, r18, r19, this.g, this.i, 0, this.f6065b, r21, false, 1152, null));
    L7:
        r1 = false;
    L16:
        return CollectionsKt.emptyList();
    }

    public final boolean a(PackageResourceManager.PresmConfig.a r3) {
        PackageResourceManager.PresmConfig.a r4 = (PackageResourceManager.PresmConfig.a) ZeusTransformUtils.wrapperContextForParams(r3, PackageResourceManager.PresmConfig.a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "callback");
        if (r4.a() == true) goto L5;
    L7:
        return false;
    L5:
        if (p() == false) goto L7;
        return true;
    }

    public final String f() {
        return this.c;
    }

    public final String g() {
        return this.d;
    }

    public final String h() {
        return this.e;
    }

    public final String i() {
        return this.f;
    }

    public final long j() {
        return this.g;
    }

    public final long k() {
        return this.h;
    }

    public final boolean l() {
        return this.i;
    }

    public final boolean m() {
        return this.j;
    }

    public final String n() {
        return this.l;
    }

    public final String o() {
        return this.c + '@' + this.d;
    }

    public final boolean p() {
        return !m.contains(this.l);
    }

    public final boolean q() {
        if (((CharSequence) ZeusTransformUtils.preCheckCast(this.l, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L11;
        if (Intrinsics.areEqual(this.l, "none") == true) goto L11;
        return true;
    L11:
        return false;
    L5:
        r0 = false;
        goto L6
    }
}
