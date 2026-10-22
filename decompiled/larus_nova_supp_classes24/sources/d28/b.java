package d28;

import android.content.Context;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.larksuite.framework.utils.z;
import dagger.hilt.android.qualifiers.ApplicationContext;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Singleton
public final class b implements com.larksuite.framework.http.v2.a {
    public final c a;

    @Override // com.larksuite.framework.http.v2.a
    public final c a() {
        return this.a;
    }

    @Inject
    public b(@ApplicationContext Context r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        this.a = new c(r6, new SetCookieCache(), new d(r6, a.b(r6, "CookiePersistence_" + z.b(r6)), a.b(r6, "CookiePersistence")));
    }
}
