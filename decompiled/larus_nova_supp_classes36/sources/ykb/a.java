package ykb;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.image.entity.LoadParams;
import com.ss.android.lark.image.uploader.entity.ImageUploadTask;
import com.ss.android.lark.image.uploader.utils.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public static final /* synthetic */ int b = 0;
    public final ImageUploadTask a;

    /* JADX INFO: renamed from: ykb.a$a, reason: collision with other inner class name */
    public static final class C0347a {
        @JvmStatic
        public static a a(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            return new a(new ImageUploadTask(r2));
        }
    }

    static {
    }

    public final void c() {
        ArrayList<com.ss.android.lark.image.uploader.entity.b> r0 = this.a.b;
        boolean r4 = false;
        if (r0.isEmpty() == false) goto L5;
        c.b("ImageUploader", "uploadImage is empty", null, false);
    L15:
        if (r4 == true) goto L20;
        dlb.a r1 = this.a.f;
        if (r1 == null) goto L29;
        r1.d();
        return;
    L29:
        return;
    L20:
        ExecutorService r2 = elb.b.a;
        ImageUploadTask r3 = this.a;
        Intrinsics.checkNotNullParameter(r3, "uploadTask");
        if (r3.h == false) goto L23;
        elb.b.a.execute(new elb.a(r3));
        return;
    L23:
        elb.b.a(r3);
        return;
    L5:
        Iterator<com.ss.android.lark.image.uploader.entity.b> r5 = r0.iterator();
    L7:
        if (r5.hasNext() == false) goto L14;
        String r6 = r5.next().a;
        if (TextUtils.isEmpty(r6) == true) goto L10;
        if (new PolarisFileWrapper(r6).exists() == true) goto L7;
        c.b("ImageUploader", "filePath is not exist", null, false);
        goto L15
    L10:
        c.b("ImageUploader", "filePath is empty", null, false);
        goto L15
    L14:
        r4 = true;
        goto L15
    }

    public a(ImageUploadTask r2) {
        Intrinsics.checkNotNullParameter(r2, "task");
        this.a = r2;
    }

    public final void a(dlb.b r3) {
        ImageUploadTask r0 = this.a;
        r0.getClass();
        r0.f = new dlb.a(r3);
    }

    public final void b(com.ss.android.lark.image.uploader.entity.b r3) {
        Intrinsics.checkNotNullParameter(r3, LoadParams.ImageFormat.IMAGE);
        ImageUploadTask r1 = this.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, LoadParams.ImageFormat.IMAGE);
        r1.b.add(r3);
    }
}
