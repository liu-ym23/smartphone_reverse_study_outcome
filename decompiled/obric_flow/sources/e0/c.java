package e0;

import android.net.Uri;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import d0.g;
import d0.q;
import d0.r;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class c implements r {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set f16726b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f16727a;

    static {
        f16726b = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"http", IIvyAIPackageResourceService.SCHEMA})));
    }

    public c(r r5) {
        this.f16727a = r5;
    }

    @Override // d0.r
    public final boolean a(Object r5) {
        return f16726b.contains(((Uri) r5).getScheme());
    }

    @Override // d0.r
    public final q b(Object r5, int r10, int r11, z.f r12) {
        g r13 = new g(((Uri) r5).toString());
        return this.f16727a.b(r13, r10, r11, r12);
    }
}
