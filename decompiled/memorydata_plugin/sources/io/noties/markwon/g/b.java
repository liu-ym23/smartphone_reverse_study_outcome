package io.noties.markwon.g;

import android.os.Build;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lio/noties/markwon/utils/DeviceChecker;", "", "()V", "isXiaomiDevice", "", "markwon-core_release"}, k = 1, mv = {1, 1, 15})
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f16544a = null;

    static {
        f16544a = new b();
    }

    private b() {
    }

    public final boolean a() {
        String r4 = Build.MANUFACTURER;
        String r0 = Build.BRAND;
        String r1 = Build.MODEL;
        if (StringsKt.equals(r4, "Xiaomi", true) == false) goto L5;
        return true;
    L5:
        if (StringsKt.equals(r0, "Xiaomi", true) == false) goto L7;
        return true;
    L7:
        if (StringsKt.equals(r0, "Redmi", true) == true) goto L17;
        Intrinsics.checkExpressionValueIsNotNull(r1, "model");
        if (StringsKt.startsWith(r1, "Mi", true) == false) goto L11;
        return true;
    L11:
        if (StringsKt.startsWith(r1, "Redmi", true) == true) goto L19;
        return false;
    L19:
        return true;
    L17:
        return true;
    }
}
