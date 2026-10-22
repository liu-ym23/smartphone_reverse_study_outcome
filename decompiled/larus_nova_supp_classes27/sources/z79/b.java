package z79;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.larus.drive.sdk.api.file.DriveFileItem;
import com.larus.drive.sdk.api.meta.PreviewFromPage;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b {
    public final Context a;
    public final DriveFileItem b;
    public final LifecycleCoroutineScope c;
    public final List<DriveFileItem> d;
    public final PreviewFromPage e;
    public final u79.a f;
    public final View g;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        List<DriveFileItem> r1 = this.d;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((r0 + r3) * 31) + this.e.hashCode()) * 31;
        u79.a r5 = this.f;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        View r8 = this.g;
        if (r8 == null) goto L15;
        r2 = r8.hashCode();
    L15:
        return r7 + r2;
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "DriveGalleryContext(context=" + this.a + ", file=" + this.b + ", scope=" + this.c + ", mediaList=" + this.d + ", fromPage=" + this.e + ", listVmCallback=" + this.f + ", ivStartView=" + this.g + ')';
    }

    public final Context getContext() {
        return this.a;
    }

    public /* synthetic */ b(Context r9, DriveFileItem r10, LifecycleCoroutineScope r11, PreviewFromPage r12, u79.a r13, int r14) {
        if ((r14 & 16) == 0) goto L5;
        r12 = PreviewFromPage.UNKNOWN;
    L5:
        PreviewFromPage r5 = r12;
        if ((r14 & 32) == 0) goto L8;
        r13 = null;
    L8:
        this(r9, r10, r11, null, r5, r13, null);
    }

    public b(Context r2, DriveFileItem r3, LifecycleCoroutineScope r4, List<DriveFileItem> r5, PreviewFromPage r6, u79.a r7, View r8) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "file");
        Intrinsics.checkNotNullParameter(r4, "scope");
        Intrinsics.checkNotNullParameter(r6, "fromPage");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }
}
