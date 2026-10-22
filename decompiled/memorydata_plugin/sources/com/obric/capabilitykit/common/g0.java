package com.obric.capabilitykit.common;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.PhotoEntity;
import com.obric.capabilitykit.entity.app.PhotoFaceEntity;
import com.obric.capabilitykit.entity.app.VideoFrame;
import com.obric.capabilitykit.entity.meta.MetaLocation;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/obric/capabilitykit/entity/app/PhotoEntityHashCodeGenerator;", "Lcom/obric/capabilitykit/entity/app/IEntityHashCodeGenerator;", "()V", "generatorHashCode", "", "instance", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class g0 implements b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g0 f7502a = null;

    static {
        f7502a = new g0();
    }

    private g0() {
    }

    @Override // com.obric.capabilitykit.common.b0
    public int a(AppEntity r3) {
        Intrinsics.checkNotNullParameter(r3, "instance");
        if (ZeusTransformUtils.instanceOf(r3, PhotoEntity.class) == false) goto L36;
        PhotoEntity r2 = (PhotoEntity) ZeusTransformUtils.preCheckCast(r3, PhotoEntity.class, "com.obric.memorydata.plugin");
        int r4 = ((((((((((((r2.getName().hashCode() + 0) * 31) + r2.getFile().hashCode()) * 31) + r2.getAssetType().name().hashCode()) * 31) + r2.getInAlbum().hashCode()) * 31) + r2.getResolution().hashCode()) * 31) + Long.hashCode(r2.getFileSize())) * 31) + Boolean.hashCode(r2.isFavorite());
        List<String> r0 = r2.getTags();
        if (r0 == null) goto L7;
        r4 = (r4 * 31) + r0.hashCode();
    L7:
        List<PhotoFaceEntity> r1 = r2.getFaces();
        if (r1 == null) goto L10;
        r4 = (r4 * 31) + r1.hashCode();
    L10:
        MetaLocation r5 = r2.getLocation();
        if (r5 == null) goto L13;
        r4 = (r4 * 31) + r5.hashCode();
    L13:
        String r6 = r2.getCaption();
        if (r6 == null) goto L16;
        r4 = (r4 * 31) + r6.hashCode();
    L16:
        String r7 = r2.getOcr();
        if (r7 == null) goto L19;
        r4 = (r4 * 31) + r7.hashCode();
    L19:
        String r8 = r2.getSourcePackageName();
        if (r8 == null) goto L22;
        r4 = (r4 * 31) + r8.hashCode();
    L22:
        String r9 = r2.getSourceAppName();
        if (r9 == null) goto L25;
        r4 = (r4 * 31) + r9.hashCode();
    L25:
        String r10 = r2.getSourceDevice();
        if (r10 == null) goto L28;
        r4 = (r4 * 31) + r10.hashCode();
    L28:
        List<VideoFrame> r11 = r2.getVideoFrames();
        if (r11 == null) goto L31;
        r4 = (r4 * 31) + r11.hashCode();
    L31:
        List<VideoFrame> r12 = r2.getSearchFrames();
        if (r12 != null) goto L34;
        return r4;
    L34:
        return (r4 * 31) + r12.hashCode();
    L36:
        throw new IllegalStateException("Check failed.".toString());
    }
}
