package sz7;

import android.content.Context;
import com.larksuite.component.ui.avatar.ImageKeyType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class f implements b<g> {
    public final Context a;

    public final Context getContext() {
        return this.a;
    }

    public f(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
    }

    @Override // sz7.b
    public final void a(Context r2, g r3, a r4, c r5, x r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "model");
        Intrinsics.checkNotNullParameter(r4, "avatarVO");
        Intrinsics.checkNotNullParameter(r5, "badgeVO");
        Intrinsics.checkNotNullParameter(r6, "miniIconVO");
        String r7 = r3.a;
        if (r7 != null) goto L5;
    L7:
        r4.e = null;
        return;
    L5:
        if (r3.b != ImageKeyType.IMAGE) goto L7;
        r4.b = r7;
        r4.c = null;
        r4.f = r3.c;
        r4.g = r3.d;
        goto L7
    }
}
