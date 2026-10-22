package androidx.room.preconditions;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a-\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0080\b\u0082\u0002\n\n\b\b\u0000\u001a\u0004\u0010\u0001(\u0000¢\u0006\u0002\u0010\u0004ò\u0001\u0004\n\u00028\u0000¨\u0006\u0005"}, d2 = {"checkTypeOrNull", ExifInterface.GPS_DIRECTION_TRUE, "obj", "", "(Ljava/lang/Object;)Ljava/lang/Object;", "room-compiler"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ChecksKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ <T> T checkTypeOrNull(Object r5) {
        Intrinsics.checkNotNullParameter(r5, "obj");
        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
        if (r5 != 0) goto L7;
        return null;
    L7:
        return r5;
    }
}
