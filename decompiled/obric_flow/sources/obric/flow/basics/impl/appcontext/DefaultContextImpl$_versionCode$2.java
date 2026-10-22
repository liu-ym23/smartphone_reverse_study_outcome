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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class DefaultContextImpl$_versionCode$2 extends Lambda implements Function0<Integer> {
    public static final DefaultContextImpl$_versionCode$2 INSTANCE = null;

    static {
        INSTANCE = new DefaultContextImpl$_versionCode$2();
    }

    public DefaultContextImpl$_versionCode$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Integer invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Integer invoke() {
        org.koin.core.a r10 = su.a.f22013b;
        if (r10 == null) goto L21;
        String r11 = ((d) r10.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(d.class), null)).getPackageName();
        Intrinsics.checkNotNullParameter(r11, "pkgName");
        long r5 = -1;
        org.koin.core.a r12 = su.a.f22013b;     // Catch: PackageManager.NameNotFoundException -> L13
        if (r12 == null) goto L12;
        PackageInfo r13 = ((d) r12.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(d.class), null)).getContext().getPackageManager().getPackageInfo(r11, 0);     // Catch: PackageManager.NameNotFoundException -> L13
        if (r13 == null) goto L17;
        r5 = r13.getLongVersionCode();     // Catch: PackageManager.NameNotFoundException -> L13
    L17:
        return Integer.valueOf((int) r5);
    L12:
        throw new IllegalStateException("KoinApplication has not been started");     // Catch: PackageManager.NameNotFoundException -> L13
    L13:
        String r14 = androidx.room.jarjarred.org.antlr.runtime.a.r("Can't get ", r11, " version code, It was not installed.", "AppUtils", "tag");
        Intrinsics.checkNotNullParameter(r14, "msg");
        org.koin.core.a r15 = su.a.f22013b;
        if (r15 == null) goto L19;
        ((ju.b) r15.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).e("AppUtils", r14);
        goto L17
    L19:
        throw new IllegalStateException("KoinApplication has not been started");
    L21:
        throw new IllegalStateException("KoinApplication has not been started");
    }
}
