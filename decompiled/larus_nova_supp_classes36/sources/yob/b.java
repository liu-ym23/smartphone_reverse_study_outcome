package yob;

import android.app.Application;
import com.ss.android.lark.language.api.LocaleWatchScene;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements zob.b {
    public final /* synthetic */ Application a;
    public final /* synthetic */ d b;

    public b(d r1, Application r2) {
        this.b = r1;
        this.a = r2;
    }

    @Override // zob.b
    public final void a(Locale r4, Locale r5) {
        int r0 = com.ss.android.lark.language.service.impl.a.f;
        com.ss.android.lark.language.service.impl.a.b.a.l(this.a);
        this.b.getClass();
        Application r1 = this.a;
        Intrinsics.checkNotNullParameter(LocaleWatchScene.CHANGE_LOCALE_DONE, "localeScene");
        Intrinsics.checkNotNullParameter(r1, "application");
        int r2 = cpb.c.a;
        cpb.c.a.a(LocaleWatchScene.CHANGE_LOCALE_DONE, r1, r5, r4);
    }
}
