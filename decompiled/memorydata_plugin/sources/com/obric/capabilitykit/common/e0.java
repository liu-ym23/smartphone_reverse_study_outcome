package com.obric.capabilitykit.common;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.Artist;
import com.obric.capabilitykit.entity.app.Cover;
import com.obric.capabilitykit.entity.app.MusicEntity;
import com.obric.capabilitykit.entity.app.Preview;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/obric/capabilitykit/entity/app/MusicEntityHashCodeGenerator;", "Lcom/obric/capabilitykit/entity/app/IEntityHashCodeGenerator;", "()V", "generatorHashCode", "", "instance", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class e0 implements b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e0 f7496a = null;

    static {
        f7496a = new e0();
    }

    private e0() {
    }

    @Override // com.obric.capabilitykit.common.b0
    public int a(AppEntity r3) {
        Intrinsics.checkNotNullParameter(r3, "instance");
        if (ZeusTransformUtils.instanceOf(r3, MusicEntity.class) == false) goto L16;
        MusicEntity r2 = (MusicEntity) ZeusTransformUtils.preCheckCast(r3, MusicEntity.class, "com.obric.memorydata.plugin");
        int r4 = r2.getName().hashCode() + 0;
        List<Artist> r0 = r2.getArtists();
        if (r0 == null) goto L7;
        r4 = (r4 * 31) + r0.hashCode();
    L7:
        Cover r1 = r2.getCover();
        if (r1 == null) goto L10;
        r4 = (r4 * 31) + r1.hashCode();
    L10:
        Preview r5 = r2.getPreview();
        if (r5 == null) goto L14;
        r4 = (r4 * 31) + r5.hashCode();
    L14:
        return (r4 * 31) + Long.hashCode(r2.getDuration());
    L16:
        throw new IllegalStateException("Check failed.".toString());
    }
}
