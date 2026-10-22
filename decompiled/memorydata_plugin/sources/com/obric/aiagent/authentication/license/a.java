package com.obric.aiagent.authentication.license;

import android.content.Context;
import android.content.pm.LauncherApps;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import com.bytedance.a.c;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crypto.utils.CryptoConst;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.obric.aiagent.platform.a.d;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.aikernel.sdk.ext.Params;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\nH\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\nH\u0002J\u001e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\nJ\u001a\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\nH\u0002J\u001c\u0010\u0018\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\nH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/obric/aiagent/authentication/license/AuthLicenseManager;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "fileVerifier", "Lcom/bytedance/aisecurity/PolicyFileVerifier;", "licenses", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/obric/aiagent/authentication/license/V1LicenseContent;", "gson", "Lcom/google/gson/Gson;", "getLicense", ObricMemoryConstants.KEY_PACKAGE_NAME, "loadLicense", "", "checkAuthorization", "", EventBody.KEY_CATEGORY, "action", "checkAppSignature", "expectedSignature", "checkContentSignature", Params.CONTENT, "signature", "Companion", "authentication_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f5909a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f5910b;
    private final c c;
    private final ConcurrentHashMap<String, V1LicenseContent> d;
    private final Gson e;

    /* JADX INFO: renamed from: com.obric.aiagent.authentication.license.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\t\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J1\u0010\n\u001a\u00020\u00032\u0010\u0010\u000b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0002\u0010\u000fJ1\u0010\u0010\u001a\u00020\u00032\u0010\u0010\u000b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0002\u0010\u000f¨\u0006\u0011"}, d2 = {"com/obric/aiagent/authentication/license/AuthLicenseManager$1$1", "Landroid/content/pm/LauncherApps$Callback;", "onPackageRemoved", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "", "user", "Landroid/os/UserHandle;", "onPackageChanged", "onPackageAdded", "onPackagesAvailable", "packageNames", "", "replacing", "", "([Ljava/lang/String;Landroid/os/UserHandle;Z)V", "onPackagesUnavailable", "authentication_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0229a extends LauncherApps.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f5911a;

        C0229a(a r1) {
            this.f5911a = r1;
        }

        @Override // android.content.pm.LauncherApps.Callback
        public void onPackageAdded(String r1, UserHandle r2) {
        }

        @Override // android.content.pm.LauncherApps.Callback
        public void onPackageChanged(String r1, UserHandle r2) {
            if (r1 != null) goto L4;
            return;
        L4:
            if (a.a(this.f5911a).remove(r1) == null) goto L8;
            a.a(this.f5911a, r1);
            return;
        }

        @Override // android.content.pm.LauncherApps.Callback
        public void onPackageRemoved(String r2, UserHandle r3) {
            TypeIntrinsics.asMutableMap((Map) ZeusTransformUtils.preCheckCast(a.a(this.f5911a), Map.class, "com.obric.memorydata.plugin")).remove(r2);
        }

        @Override // android.content.pm.LauncherApps.Callback
        public void onPackagesAvailable(String[] r1, UserHandle r2, boolean r3) {
        }

        @Override // android.content.pm.LauncherApps.Callback
        public void onPackagesUnavailable(String[] r1, UserHandle r2, boolean r3) {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/aiagent/authentication/license/AuthLicenseManager$Companion;", "", "<init>", "()V", "TAG", "", "LICENSE_NAME", "authentication_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f5909a = new b(null);
    }

    public a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        this.f5910b = ZeusTransformUtils.wrapperContext(r4, "com.obric.memorydata.plugin");
        this.c = new c();
        this.d = new ConcurrentHashMap();
        this.e = new Gson();
        new Handler(Looper.getMainLooper()).post(new $$Lambda$a$N1VredPSdbE7S77cx_7hv9CIow(this));
    }

    private final V1LicenseContent a(String r4) {
        V1LicenseContent r0 = (V1LicenseContent) ZeusTransformUtils.preCheckCast(this.d.get(r4), V1LicenseContent.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        return r0;
    L5:
        b(r4);
        return (V1LicenseContent) ZeusTransformUtils.preCheckCast(this.d.get(r4), V1LicenseContent.class, "com.obric.memorydata.plugin");
    }

    private static final CharSequence a(byte r3) {
        StringCompanionObject r0 = StringCompanionObject.INSTANCE;
        String r4 = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(r3)}, 1));
        Intrinsics.checkNotNullExpressionValue(r4, "format(...)");
        return (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ ConcurrentHashMap a(a r0) {
        return r0.d;
    }

    public static final /* synthetic */ void a(a r0, String r1) {
        r0.b(r1);
    }

    private final boolean a(String r12, String r13) {
        Signature[] r11 = this.f5910b.getPackageManager().getPackageInfo(r12, 64).signatures;     // Catch: PackageManager.NameNotFoundException -> L12
        MessageDigest r14 = MessageDigest.getInstance(CryptoConst.ALGORITHM_SHA256);     // Catch: PackageManager.NameNotFoundException -> L12
        Iterator r15 = ArrayIteratorKt.iterator(r11);     // Catch: PackageManager.NameNotFoundException -> L12
    L5:
        if (r15.hasNext() == false) goto L18;
        r14.update(((Signature) ZeusTransformUtils.preCheckCast(r15.next(), Signature.class, "com.obric.memorydata.plugin")).toByteArray());     // Catch: PackageManager.NameNotFoundException -> L12
        byte[] r2 = r14.digest();     // Catch: PackageManager.NameNotFoundException -> L12
        Intrinsics.checkNotNullExpressionValue(r2, "digest(...)");     // Catch: PackageManager.NameNotFoundException -> L12
        if (Intrinsics.areEqual(ArraysKt.joinToString$default(r2, (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$a$JHpLizrWDXQ7jouewNi85hJva0I.INSTANCE, 30, null), r13) == false) goto L5;
        return true;
    L18:
        return false;
    L10:
        return false;
    }

    private static final void b(a r3) {
        ((LauncherApps) ZeusTransformUtils.preCheckCast(r3.f5910b.getSystemService(LauncherApps.class), LauncherApps.class, "com.obric.memorydata.plugin")).registerCallback((LauncherApps.Callback) ZeusTransformUtils.preCheckCast(new C0229a(r3), LauncherApps.Callback.class, "com.obric.memorydata.plugin"));
    }

    private final void b(String r8) {
        Resources r1 = this.f5910b.getPackageManager().getResourcesForApplication(r8);
        Intrinsics.checkNotNullExpressionValue(r1, "getResourcesForApplication(...)");
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L20
        a r7 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        Closeable r3 = (Closeable) ZeusTransformUtils.preCheckCast(r1.getAssets().open("o_appintent_license.json"), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        InputStream r4 = (InputStream) ZeusTransformUtils.preCheckCast(r3, InputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        Gson r5 = r7.e;     // Catch: Throwable -> L15
        Intrinsics.checkNotNull(r4);     // Catch: Throwable -> L15
        License r6 = (License) ZeusTransformUtils.preCheckCast(r5.fromJson((Reader) ZeusTransformUtils.preCheckCast(new InputStreamReader(r4, Charsets.UTF_8), Reader.class, "com.obric.memorydata.plugin"), License.class), License.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        String r9 = r6.getContent().toString();     // Catch: Throwable -> L15
        Intrinsics.checkNotNullExpressionValue(r9, "toString(...)");     // Catch: Throwable -> L15
        if (r7.b(r9, r6.getSignature()) == true) goto L10;
        CloseableKt.closeFinally(r3, null);     // Catch: Throwable -> L20
        return;
    L10:
        if (r6.getVersion() != 1) goto L12;
        ((Map) ZeusTransformUtils.preCheckCast(r7.d, Map.class, "com.obric.memorydata.plugin")).put(r8, r7.e.fromJson((JsonElement) ZeusTransformUtils.preCheckCast(r6.getContent(), JsonElement.class, "com.obric.memorydata.plugin"), V1LicenseContent.class));     // Catch: Throwable -> L15
    L12:
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L15
        CloseableKt.closeFinally(r3, null);     // Catch: Throwable -> L20
        Object r11 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L20
    L22:
        Throwable r12 = Result.m1424exceptionOrNullimpl(r11);
        if (r12 == null) goto L31;
        d.f5954a.c("AuthLicenseManager", "loadLicense failed, packageName: " + r8 + ", error: " + r12);
        return;
    L31:
        return;
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        CloseableKt.closeFinally(r3, th);     // Catch: Throwable -> L20
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r11 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L22
    }

    private final boolean b(String r5, String r6) {
        if (r5 == null) goto L16;
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L7;
    L10:
        boolean r3 = true;
    L11:
        if (r3 == true) goto L17;
        c r4 = this.c;
        byte[] r7 = r5.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(r7, "getBytes(...)");
        if (r4.a(r7, com.bytedance.a.d.a(r6), 1) == 0) goto L15;
        return false;
    L15:
        return true;
    L17:
        return false;
    L7:
        if (r2.length() == 0) goto L10;
        r3 = false;
        goto L11
    L16:
        return false;
    }

    public static /* synthetic */ CharSequence lambda$JHpLizrWDXQ7jouewNi85hJva0I(byte r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$N1VredPSdbE7S-77cx_7hv9CIow, reason: not valid java name */
    public static /* synthetic */ void m146lambda$N1VredPSdbE7S77cx_7hv9CIow(a r0) {
        b(r0);
    }

    public final boolean a(String r9, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r9, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r10, EventBody.KEY_CATEGORY);
        Intrinsics.checkNotNullParameter(r11, "action");
        boolean r1 = true;
        if (Intrinsics.areEqual(r9, this.f5910b.getPackageName()) == false) goto L6;
        d.f5954a.b("AuthLicenseManager", "checkAuthorization call from self return true category: " + r10 + ", action: " + r11);
        return true;
    L6:
        V1LicenseContent r0 = a(r9);
        if (r0 == null) goto L15;
        Map<String, List<String>> r5 = r0.getActions();
        if (r5 == null) goto L15;
        List r6 = (List) ZeusTransformUtils.preCheckCast(r5.get(r10), List.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L15;
        if (r6.contains(r11) != true) goto L15;
        boolean r7 = true;
    L17:
        if (r7 == true) goto L23;
        d.b r8 = d.f5954a;
        StringBuilder r2 = new StringBuilder();
        String r3 = "checkAuthorization failed no actions in license ";
    L19:
        StringBuilder r12 = r2.append(r3).append(r9).append(' ').append(r10).append(' ').append(r11);
    L20:
        r8.c("AuthLicenseManager", r12.toString());
        return false;
    L23:
        if (Intrinsics.areEqual(r0.getPackageName(), r9) == true) goto L25;
        r8 = d.f5954a;
        r2 = new StringBuilder();
        r3 = "checkAuthorization failed license package name not match ";
        goto L19
    L25:
        String r13 = com.obric.aiagent.product.b.f5974a.b().c();
        Map r4 = (Map) ZeusTransformUtils.preCheckCast(r0.getSignatures().get(r13), Map.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L28;
        String r14 = (String) ZeusTransformUtils.preCheckCast(r4.get(Build.TAGS), String.class, "com.obric.memorydata.plugin");
    L29:
        CharSequence r15 = (CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin");
        if (r15 != null) goto L32;
    L35:
        if (r1 == false) goto L37;
        r8 = d.f5954a;
        r12 = new StringBuilder().append("checkAuthorization failed no signature found ").append(r9).append(' ').append(r10).append(' ').append(r11).append(' ').append(r13);
        goto L20
    L37:
        boolean r16 = a(r9, r14);
        if (r16 == true) goto L40;
        d.f5954a.c("AuthLicenseManager", "checkAuthorization failed app signature not match " + r9 + ' ' + r10 + ' ' + r11 + ' ' + r13);
    L40:
        return r16;
    L32:
        if (r15.length() == 0) goto L35;
        r1 = false;
        goto L35
    L28:
        r14 = null;
    L15:
        r7 = false;
        goto L17
    }
}
