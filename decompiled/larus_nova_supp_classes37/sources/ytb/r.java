package ytb;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import com.ss.android.lark.vfs.VFSPath;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Singleton
public final class r implements a4c.a, a4c.b, b4c.a, b4c.b, b4c.c {
    public final void a() {
        Intrinsics.checkNotNullParameter("lark.search.time.trouble.shoot", "key");
    }

    public final void b(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, AppbrandHostConstants.Schema_RESERVED_FIELD.QUERY);
    }

    public final void isEnable(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
    }

    public final KVRepo d() {
        return (KVRepo) t.a(KVRepo.class);
    }

    @Inject
    public r() {
        new MutableLiveData();
    }

    public final VFSPath c(com.ss.android.lark.storage.f r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "volume");
        Intrinsics.checkNotNullParameter(r3, "fileName");
        return (VFSPath) t.a(VFSPath.class);
    }
}
