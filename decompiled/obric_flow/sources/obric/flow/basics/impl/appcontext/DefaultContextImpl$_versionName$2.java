package obric.flow.basics.impl.appcontext;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import iu.d;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class DefaultContextImpl$_versionName$2 extends Lambda implements Function0<String> {
    public static final DefaultContextImpl$_versionName$2 INSTANCE = null;

    static {
        INSTANCE = new DefaultContextImpl$_versionName$2();
    }

    public DefaultContextImpl$_versionName$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ String invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2() {
        org.koin.core.a r10 = su.a.f22013b;
        if (r10 == null) goto L23;
        String r11 = ((d) r10.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(d.class), null)).getPackageName();
        Intrinsics.checkNotNullParameter(r11, "pkgName");
        org.koin.core.a r5 = su.a.f22013b;     // Catch: PackageManager.NameNotFoundException -> L16
        if (r5 == null) goto L15;
        PackageInfo r12 = ((d) r5.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(d.class), null)).getContext().getPackageManager().getPackageInfo(r11, 0);     // Catch: PackageManager.NameNotFoundException -> L16
        if (r12 == null) goto L25;
        String r13 = r12.versionName;     // Catch: PackageManager.NameNotFoundException -> L16
        if (r13 != null) goto L27;
        return "";
    L27:
        return r13;
    L25:
        return "";
    L15:
        throw new IllegalStateException("KoinApplication has not been started");     // Catch: PackageManager.NameNotFoundException -> L16
    L16:
        String r14 = androidx.room.jarjarred.org.antlr.runtime.a.r("Can't get ", r11, " version name, It was not installed.", "AppUtils", "tag");
        Intrinsics.checkNotNullParameter(r14, "msg");
        org.koin.core.a r15 = su.a.f22013b;
        if (r15 == null) goto L21;
        ((ju.b) r15.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).e("AppUtils", r14);
        return "";
    L21:
        throw new IllegalStateException("KoinApplication has not been started");
    L23:
        throw new IllegalStateException("KoinApplication has not been started");
    }
}
