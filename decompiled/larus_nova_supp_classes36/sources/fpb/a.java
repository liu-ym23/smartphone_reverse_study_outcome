package fpb;

import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.passport.signinsdk_api.env.EnvironmentType;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kzb.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Singleton
public final class a implements b {
    public final izb.a a;

    public final kzb.a a() {
        Pair r0 = this.a.a();
        LarkAppContext.a r1 = LarkAppContext.Companion;
        r1.getClass();
        String r2 = (String) LarkAppContext.access$getInstance$cp().buildConfig().getValue("DEFAULT_UNIT");
        r1.getClass();
        String r3 = (String) LarkAppContext.access$getInstance$cp().buildConfig().getValue("DEFAULT_BRAND");
        boolean r4 = false;
        if (r2 != null) goto L5;
    L8:
        boolean r6 = true;
    L9:
        if (r6 == true) goto L16;
        if (r3 != null) goto L12;
    L13:
        r4 = true;
    L14:
        if (r4 == true) goto L16;
        Pair r5 = new Pair(r2, r3);
    L20:
        if (r0 == null) goto L22;
        r5 = new Pair(r0.getSecond(), r5.getSecond());
    L22:
        String r7 = (String) r5.getSecond();
        String r8 = (String) r5.getFirst();
        String r9 = this.a.b((String) r5.getFirst());
        if (r0 == null) goto L26;
        EnvironmentType r10 = (EnvironmentType) r0.getFirst();
        if (r10 == null) goto L26;
    L28:
        return new kzb.a(r7, r8, r9, r10);
    L26:
        r10 = EnvironmentType.RELEASE;
        goto L28
    L12:
        if (StringsKt.isBlank(r3) == false) goto L14;
    L16:
        r1.getClass();
        if (LarkAppContext.access$getInstance$cp().buildConfig().isUsPackage() == false) goto L19;
        r5 = new Pair("larksgaws", "lark");
        goto L20
    L19:
        r5 = new Pair("eu_nc", "feishu");
        goto L20
    L5:
        if (StringsKt.isBlank(r2) == true) goto L8;
        r6 = false;
        goto L9
    }

    @Inject
    public a(izb.a r2) {
        Intrinsics.checkNotNullParameter(r2, "environmentDependency");
        this.a = r2;
    }
}
