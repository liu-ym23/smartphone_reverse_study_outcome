package emb;

import cbb.d;
import com.ss.android.lark.diskmanage.Biz;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.o0;
import ebb.g;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;
import qa5.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Singleton
public final class a implements g {

    /* JADX INFO: renamed from: emb.a$a, reason: collision with other inner class name */
    public static final class C0254a {
    }

    static {
    }

    @Inject
    public a() {
    }

    public final void b() {
    }

    public final Biz getBiz() {
        return Biz.DOCS;
    }

    public final cbb.a a(d r5) {
        Intrinsics.checkNotNullParameter(r5, "remoteConfig");
        if (o0.a(LarkContext.getApplication()) == false) goto L6;
        tt5.a.h("CCMDiskCleanTask", "CCMDiskCleanTask.onRemoteClean. ");
        return new cbb.a(false, b.a.a.a.f().a(r5), 5);
    L6:
        return new cbb.a(false, 0, 7);
    }
}
