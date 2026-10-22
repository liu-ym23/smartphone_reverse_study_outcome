package xia;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.Cover;
import com.obric.capabilitykit.entity.app.MusicEntity;
import com.obric.capabilitykit.entity.app.Preview;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class f implements c {
    public static final f a = null;

    static {
        a = new f();
    }

    public f() {
    }

    @Override // xia.c
    public final int a(AppEntity r6) {
        Intrinsics.checkNotNullParameter(r6, "instance");
        if ((r6 instanceof MusicEntity) == false) goto L16;
        MusicEntity r7 = (MusicEntity) r6;
        int r0 = r7.getName().hashCode() + 0;
        List r1 = r7.getArtists();
        if (r1 == null) goto L7;
        r0 = (r0 * 31) + r1.hashCode();
    L7:
        Cover r2 = r7.getCover();
        if (r2 == null) goto L10;
        r0 = (r0 * 31) + r2.hashCode();
    L10:
        Preview r3 = r7.getPreview();
        if (r3 == null) goto L13;
        r0 = (r0 * 31) + r3.hashCode();
    L13:
        long r4 = r7.getDuration();
        return (r0 * 31) + ((int) (r4 ^ (r4 >>> 32)));
    L16:
        throw new IllegalStateException("Check failed.".toString());
    }
}
