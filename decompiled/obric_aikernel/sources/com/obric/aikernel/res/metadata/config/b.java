package com.obric.aikernel.res.metadata.config;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.google.gson.k;
import com.obric.aikernel.res.PackageResourceManager;
import com.obric.aikernel.res.downloader.DownloadTask;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends DistConfig {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final a f5025q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final String f5026r = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f5027f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f5028g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f5029h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f5030i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final String f5031j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f5032k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final int f5033l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final boolean f5034m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final boolean f5035n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final int f5036o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final String f5037p;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final String a() {
            return b.k();
        }
    }

    static {
        f5025q = new a(null);
        f5026r = "none";
    }

    public b(String r10, k r11, int r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r11, "json");
        String r14 = "";
        super("", r10, r11);
        this.f5027f = r13;
        String r15 = com.obric.aikernel.res.metadata.config.a.d(r11, ActivityLifecycle.NAME);
        if (r15 != null) goto L7;
        r15 = com.obric.aikernel.res.metadata.config.a.d(r11, "filename");
        if (r15 != null) goto L7;
    L8:
        this.f5028g = r10;
        String r16 = com.obric.aikernel.res.metadata.config.a.d(r11, "md5");
        if (r16 != null) goto L11;
        r16 = "";
    L11:
        this.f5029h = r16;
        String r17 = com.obric.aikernel.res.metadata.config.a.d(r11, "url");
        if (r17 != null) goto L16;
        r17 = com.obric.aikernel.res.metadata.config.a.d(r11, "download_url");
        if (r17 != null) goto L16;
        r17 = "";
    L16:
        this.f5030i = r17;
        String r18 = com.obric.aikernel.res.metadata.config.a.d(r11, "origin_md5");
        if (r18 == null) goto L20;
        r14 = r18;
    L20:
        this.f5031j = r14;
        Integer r19 = com.obric.aikernel.res.metadata.config.a.b(r11, "size");
        int r20 = 0;
        if (r19 == null) goto L23;
    L22:
        int r21 = r19.intValue();
    L27:
        this.f5032k = r21;
        Integer r22 = com.obric.aikernel.res.metadata.config.a.b(r11, "origin_size_bytes");
        if (r22 == null) goto L30;
        int r23 = r22.intValue();
    L31:
        this.f5033l = r23;
        Integer r24 = com.obric.aikernel.res.metadata.config.a.b(r11, "wifi_only");
        if (r24 == null) goto L34;
        r12 = r24.intValue();
    L34:
        boolean r25 = true;
        if (r12 == 1) goto L38;
        r25 = false;
    L38:
        this.f5034m = r25;
        this.f5035n = r13;
        Integer r26 = com.obric.aikernel.res.metadata.config.a.b(r11, "download_type");
        if (r26 == null) goto L41;
        r20 = r26.intValue();
    L41:
        this.f5036o = r20;
        String r27 = com.obric.aikernel.res.metadata.config.a.d(r11, "encrypt_type");
        if (r27 != null) goto L44;
        r27 = f5026r;
    L44:
        this.f5037p = r27;
        return;
    L30:
        r23 = 0;
        goto L31
    L23:
        r19 = com.obric.aikernel.res.metadata.config.a.b(r11, "size_bytes");
        if (r19 != null) goto L22;
        r21 = 0;
    L7:
        r10 = r15;
        goto L8
    }

    public /* synthetic */ b(String r10, k r11, int r12, boolean r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 4) == 0) goto L6;
        r12 = 0;
    L6:
        if ((r14 & 8) == 0) goto L8;
        r13 = true;
    L8:
        this(r10, r11, r12, r13);
    }

    public static final /* synthetic */ String k() {
        return f5026r;
    }

    @Override // com.obric.aikernel.res.metadata.config.DistConfig
    public List<DownloadTask.b> b(String r16, String r17, int r18) {
        Intrinsics.checkNotNullParameter(r16, "savePath");
        Intrinsics.checkNotNullParameter(r17, "tmpPath");
        if (r18 < this.f5036o) goto L16;
        boolean r10 = true;
        if (this.f5030i.length() <= 0) goto L7;
        boolean r11 = true;
    L8:
        if (r11 == false) goto L16;
        if (this.f5029h.length() > 0) goto L13;
        r10 = false;
    L13:
        if (r10 == false) goto L16;
        return CollectionsKt.listOf(new DownloadTask.b(this.f5028g, this.f5029h, this.f5030i, r16, r17, this.f5032k, this.f5034m, 0, this.f5027f, false, 640, null));
    L7:
        r11 = false;
    L16:
        return CollectionsKt.emptyList();
    }

    public final boolean l() {
        return this.f5035n;
    }

    public final String m() {
        return this.f5028g + '@' + this.f5029h;
    }

    public final String n() {
        return this.f5037p;
    }

    public final String o() {
        return this.f5028g;
    }

    public final String p() {
        return this.f5029h;
    }

    public final String q() {
        return this.f5031j;
    }

    public final int r() {
        return this.f5033l;
    }

    public final int s() {
        return this.f5032k;
    }

    public final String t() {
        return this.f5030i;
    }

    public final boolean u() {
        return this.f5034m;
    }

    public final boolean v(PackageResourceManager.PresmConfig.b r10) {
        Intrinsics.checkNotNullParameter(r10, "callback");
        if (r10.b() == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(this.f5037p, f5026r) == true) goto L7;
        return true;
    }
}
