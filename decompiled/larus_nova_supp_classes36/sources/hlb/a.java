package hlb;

import com.ss.android.lark.image.entity.LoadParams;
import com.ss.android.lark.image.uploader.entity.ImageUploadTask;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements d {

    /* JADX INFO: renamed from: hlb.a$a, reason: collision with other inner class name */
    public static final class C0275a {
    }

    static {
    }

    public a() {
    }

    @Override // hlb.d
    public final String getName() {
        return "FileDecryptTransform";
    }

    @Override // hlb.d
    public final boolean a(com.ss.android.lark.image.uploader.entity.b r2, ImageUploadTask r3) {
        Intrinsics.checkNotNullParameter(r2, LoadParams.ImageFormat.IMAGE);
        Intrinsics.checkNotNullParameter(r3, "imageUploadTask");
        return r2.c;
    }

    @Override // hlb.d
    public final String b(com.ss.android.lark.image.uploader.entity.b r3, ImageUploadTask r4) {
        Intrinsics.checkNotNullParameter(r3, LoadParams.ImageFormat.IMAGE);
        Intrinsics.checkNotNullParameter(r4, "imageUploadTask");
        File r5 = com.ss.android.lark.vfs.d.a().G(r3.a, true);
        if (r5 == null) goto L7;
        String r6 = r5.getAbsolutePath();
        if (r6 == null) goto L7;
        return r6;
    L7:
        return r3.a;
    }
}
