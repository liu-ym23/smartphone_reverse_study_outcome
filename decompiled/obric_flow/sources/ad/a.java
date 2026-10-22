package ad;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.ies.bullet.service.base.b;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.lynx.jsbridge.LynxResourceModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f157a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f158b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f159c;
    public boolean d;

    public a(Uri r5) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        this.f157a = r5;
    }

    public final String a() {
        Uri r5 = this.f157a;
    L10:
        e = move-exception;
        b.g("BulletLoadUriIdentifier schema", "Monitor", e);
        String r10 = "";
    L24:
        if (TextUtils.isEmpty(r10) == true) goto L26;
        return r10;
    L26:
        return r5.toString();
    L4:
        if (b() != KitType.d) goto L15;
        if (Intrinsics.areEqual(r5.getAuthority(), LynxMonitorService.KEY_CHANNEL) == false) goto L15;
        String r11 = io.reactivex.exceptions.a.b(r5, "default_bid");     // Catch: Exception -> L10
        if (r11 == null) goto L12;
        Uri r12 = Uri.parse(r11);     // Catch: Exception -> L10
    L13:
        Intrinsics.checkNotNullParameter(r12, "<this>");     // Catch: Exception -> L10
        r10 = r12.buildUpon().clearQuery().toString();     // Catch: Exception -> L10
        goto L24
    L12:
        r12 = r5;
    L15:
        if (Intrinsics.areEqual(r5.getScheme(), "sslocal") == false) goto L17;
    L20:
        r10 = r5.toString();     // Catch: Exception -> L10
        goto L24
    L17:
        if (Intrinsics.areEqual(r5.getScheme(), "aweme") == true) goto L20;
        r10 = new Uri.Builder().scheme(r5.getScheme()).authority(r5.getAuthority()).path(r5.getPath()).build().toString();     // Catch: Exception -> L10
        goto L24
    }

    public final KitType b() {
        String r5 = this.f157a.getScheme();
        if (r5 == null) goto L27;
        int r10 = r5.hashCode();
        if (r10 == (-1772600516)) goto L22;
        if (r10 == 3213448) goto L17;
        if (r10 != 99617003) goto L27;
        if (r5.equals(IIvyAIPackageResourceService.SCHEMA) == false) goto L27;
        return KitType.f6012c;
    L17:
        if (r5.equals("http") == false) goto L27;
        return KitType.f6012c;
    L22:
        if (r5.equals("lynxview") == false) goto L27;
        return KitType.d;
    L27:
        return KitType.f6011b;
    }
}
