package com.obric.b;

import android.os.Parcel;
import android.util.Log;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0004H\u0002J\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007J\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/obric/versionedparcelable/ParcelUtils;", "", "()V", "VAL_LIST", "", "VAL_MAP", "VAL_OBJECTARRAY", "VAL_PARCELABLE", "VAL_PARCELABLEARRAY", "VAL_SERIALIZABLE", "VAL_SPARSEARRAY", "addOrThrow", "a", "b", "isLengthPrefixed", "", "type", "readValueSafely", "parcel", "Landroid/os/Parcel;", "loader", "Ljava/lang/ClassLoader;", "skipValueSafely", "", "library"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6936a = null;

    static {
        f6936a = new a();
    }

    private a() {
    }

    private final int a(int r3, int r4) {
        if (r4 != 0) goto L4;
        return r3;
    L4:
        if (r4 > 0) goto L6;
    L9:
        if (r4 >= 0) goto L15;
        if (r3 < (Integer.MIN_VALUE - r4)) goto L15;
        return r3 + r4;
    L15:
        throw new IllegalArgumentException("Addition overflow: " + r3 + " + " + r4);
    L6:
        if (r3 > (Integer.MAX_VALUE - r4)) goto L9;
        return r3 + r4;
    }

    @JvmStatic
    public static final void a(Parcel r3, ClassLoader r4) {
        Intrinsics.checkNotNullParameter(r3, "parcel");
        int r0 = r3.dataPosition();
        int r1 = r3.readInt();
        a r2 = f6936a;
        if (r2.a(r1) == false) goto L8;
        int r5 = r3.readInt();
        if (r5 >= 0) goto L7;
        return;
    L7:
        r3.setDataPosition(r2.a(r3.dataPosition(), r5));
        return;
    L8:
        r3.setDataPosition(r0);
        r3.readValue(r4);
    }

    private final boolean a(int r1) {
        if (r1 != 2) goto L5;
    L17:
        return true;
    L5:
        if (r1 == 4) goto L17;
        if (r1 == 21) goto L17;
        if (r1 == 11) goto L17;
        if (r1 == 12) goto L17;
        if (r1 == 16) goto L17;
        if (r1 == 17) goto L17;
        return false;
    }

    @JvmStatic
    public static final Object b(Parcel r5, ClassLoader r6) {
        Intrinsics.checkNotNullParameter(r5, "parcel");
        int r0 = r5.dataPosition();
        int r1 = r5.readInt();
        a r2 = f6936a;
        if (r2.a(r1) == false) goto L7;
        int r3 = r5.readInt();
        if (r3 < 0) goto L7;
        Integer r4 = Integer.valueOf(r2.a(r5.dataPosition(), r3));
    L14:
        r5.setDataPosition(r0);     // Catch: Exception -> L10
        return r5.readValue(r6);
    L10:
        Log.w("ParcelUtils", "unsupported type");
        if (r4 == null) goto L13;
        r5.setDataPosition(r4.intValue());
    L13:
        return null;
    L7:
        r4 = null;
        goto L14
    }
}
