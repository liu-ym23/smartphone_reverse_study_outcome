package bjb;

import android.content.Context;
import dagger.hilt.android.qualifiers.ApplicationContext;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Singleton
public final class f implements e28.c {
    public final Context a;
    public String b;

    public final String getUserAgent() {
        String r0 = this.b;
        if (r0 != null) goto L6;
        Context r1 = this.a;
        yob.e.a().getClass();
        int r2 = com.ss.android.lark.language.service.impl.a.f;
        com.ss.android.lark.language.service.impl.a.b.a.getLanguageSetting();
        String r3 = xoc.a.a(r1);
        this.b = r3;
        return r3;
    L6:
        return r0;
    }

    @Inject
    public f(@ApplicationContext Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
    }
}
