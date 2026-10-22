package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import com.bytedance.crash.entity.EventBody;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002¢\u0006\u0002\u0010\u0003\u001a\u0019\u0010\u0004\u001a\u00020\u0005*\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"readBool", "", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)Ljava/lang/Boolean;", "writeBool", "", EventBody.KEY_VALUE, "(Landroid/os/Parcel;Ljava/lang/Boolean;)V", "eventstaskkit_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class k {
    public static final Boolean a(Parcel r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        int r2 = r1.readInt();
        if (r2 == (-1)) goto L7;
        if (r2 == 0) goto L10;
        return Boolean.TRUE;
    L10:
        return Boolean.FALSE;
    L7:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [android.os.Parcel, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4 */
    public static final void a(Parcel r1, Boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r2 == null) goto L5;
        ?? r3 = r2.booleanValue();
    L6:
        r1.writeInt(r3);
        return;
    L5:
        r3 = -1;
        goto L6
    }
}
