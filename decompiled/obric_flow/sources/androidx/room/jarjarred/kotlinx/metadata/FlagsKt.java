package androidx.room.jarjarred.kotlinx.metadata;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a%\u0010\u0005\u001a\u00060\u0003j\u0002`\u00042\u0012\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0000\"\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006*\n\u0010\u0007\"\u00020\u00032\u00020\u0003¨\u0006\b"}, d2 = {"", "Landroidx/room/jarjarred/kotlinx/metadata/Flag;", "flags", "", "Landroidx/room/jarjarred/kotlinx/metadata/Flags;", "flagsOf", "(Ljava/lang/Object;)I", "Flags", "kotlinx-metadata"}, k = 2, mv = {1, 7, 1}, xi = 48)
@JvmName(name = "FlagsKt")
public final class FlagsKt {
    public static final int flagsOf(Flag... r5) {
        Intrinsics.checkNotNullParameter(r5, "flags");
        int r10 = r5.length;
        int r11 = 0;
        int r12 = 0;
    L3:
        if (r11 >= r10) goto L5;
        r12 = r5[r11].plus$kotlinx_metadata(r12);
        r11 = r11 + 1;
        goto L3
    L5:
        return r12;
    }
}
