package com.obric.aee.utils;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J-\u0010\u0003\u001a\u0004\u0018\u0001H\u0004\"\u0004\b\u0000\u0010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0007H\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/obric/aee/utils/ClassUtils;", "", "()V", "cast", ExifInterface.GPS_DIRECTION_TRUE, "obj", "clz", "Ljava/lang/Class;", "(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;", "Aee_cryptLiteRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ClassUtils {
    public static final ClassUtils INSTANCE = null;

    static {
        INSTANCE = new ClassUtils();
    }

    private ClassUtils() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> T cast(Object r1, Class<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "clz");
        if (r1 == 0) goto L11;
        if (ZeusTransformUtils.instanceOf(r2, r1) == false) goto L7;
        Object r3 = r1;
    L8:
        if (r3 == null) goto L11;
        return r1;
    L7:
        r3 = null;
    L11:
        return null;
    }
}
