package com.facebook.imagepipeline.transcoder;

import com.facebook.common.internal.ImmutableList;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import java.util.Collections;

/* JADX INFO: loaded from: classes2.dex */
public abstract class JpegTranscoderUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ImmutableList f8446a = null;

    static {
        ImmutableList r5 = new ImmutableList(4);
        Collections.addAll(r5, new Integer[]{2, 7, 4, 5});
        f8446a = r5;
    }

    public static int a(RotationOptions r5, EncodedImage r10) {
        int r11 = 0;
        if (r5.f8055a == (-2)) goto L20;
        r10.g();
        int r12 = r10.f8179c;
        if (r12 != 90) goto L7;
    L11:
        r10.g();
        r11 = r10.f8179c;
    L12:
        int r13 = r5.f8055a;
        if (r13 != (-1)) goto L15;
        return r11;
    L15:
        if (r13 == (-1)) goto L19;
        return (r13 + r11) % 360;
    L19:
        throw new IllegalStateException("Rotation is set to use EXIF");
    L7:
        if (r12 == 180) goto L11;
        if (r12 == 270) goto L11;
    L20:
        return 0;
    }
}
