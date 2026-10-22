package xia;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.PhotoEntity;
import com.obric.capabilitykit.entity.meta.MetaLocation;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class h implements c {
    public static final h a = null;

    static {
        a = new h();
    }

    public h() {
    }

    @Override // xia.c
    public final int a(AppEntity r6) {
        Intrinsics.checkNotNullParameter(r6, "instance");
        if ((r6 instanceof PhotoEntity) == false) goto L40;
        PhotoEntity r7 = (PhotoEntity) r6;
        int r0 = (((((((((r7.getName().hashCode() + 0) * 31) + r7.getFile().hashCode()) * 31) + r7.getAssetType().name().hashCode()) * 31) + r7.getInAlbum().hashCode()) * 31) + r7.getResolution().hashCode()) * 31;
        long r1 = r7.getFileSize();
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        if (r7.isFavorite() == false) goto L7;
        int r3 = 1231;
    L8:
        int r4 = r2 + r3;
        List r5 = r7.getTags();
        if (r5 == null) goto L11;
        r4 = (r4 * 31) + r5.hashCode();
    L11:
        List r8 = r7.getFaces();
        if (r8 == null) goto L14;
        r4 = (r4 * 31) + r8.hashCode();
    L14:
        MetaLocation r9 = r7.getLocation();
        if (r9 == null) goto L17;
        r4 = (r4 * 31) + r9.hashCode();
    L17:
        String r10 = r7.getCaption();
        if (r10 == null) goto L20;
        r4 = (r4 * 31) + r10.hashCode();
    L20:
        String r11 = r7.getOcr();
        if (r11 == null) goto L23;
        r4 = (r4 * 31) + r11.hashCode();
    L23:
        String r12 = r7.getSourcePackageName();
        if (r12 == null) goto L26;
        r4 = (r4 * 31) + r12.hashCode();
    L26:
        String r13 = r7.getSourceAppName();
        if (r13 == null) goto L29;
        r4 = (r4 * 31) + r13.hashCode();
    L29:
        String r14 = r7.getSourceDevice();
        if (r14 == null) goto L32;
        r4 = (r4 * 31) + r14.hashCode();
    L32:
        List r15 = r7.getVideoFrames();
        if (r15 == null) goto L35;
        r4 = (r4 * 31) + r15.hashCode();
    L35:
        List r16 = r7.getSearchFrames();
        if (r16 != null) goto L38;
        return r4;
    L38:
        return (r4 * 31) + r16.hashCode();
    L7:
        r3 = 1237;
        goto L8
    L40:
        throw new IllegalStateException("Check failed.".toString());
    }
}
