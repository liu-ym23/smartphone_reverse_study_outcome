package androidx.room.util;

import android.util.Log;
import androidx.annotation.RestrictTo;
import androidx.room.Room;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
@JvmName(name = "StringUtil")
public final class StringUtil {

    @JvmField
    public static final String[] EMPTY_STRING_ARRAY = null;

    static {
        EMPTY_STRING_ARRAY = new String[0];
    }

    public static final void appendPlaceholders(StringBuilder r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "builder");
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L8;
        r10.append("?");
        if (r12 >= (r11 - 1)) goto L7;
        r10.append(",");
    L7:
        r12 = r12 + 1;
        goto L3
    }

    public static /* synthetic */ void getEMPTY_STRING_ARRAY$annotations() {
    }

    public static final String joinIntoString(List<Integer> r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        return CollectionsKt.joinToString$default(r10, ",", null, null, 0, null, null, 62, null);
    }

    public static final StringBuilder newStringBuilder() {
        return new StringBuilder();
    }

    public static final List<Integer> splitToIntList(String r10) {
        if (r10 == null) goto L25;
        List r11 = StringsKt.split$default(r10, new char[]{','}, false, 0, 6, null);
        if (r11 == null) goto L26;
        ArrayList r12 = new ArrayList();
        Iterator r13 = r11.iterator();
    L8:
        if (r13.hasNext() == false) goto L17;
        Integer r14 = Integer.valueOf(Integer.parseInt((String) r13.next()));     // Catch: NumberFormatException -> L12
    L14:
        if (r14 == null) goto L8;
        r12.add(r14);
    L12:
        e = move-exception;
        Log.e(Room.LOG_TAG, "Malformed integer list", e);
        r14 = null;
        goto L14
    L17:
        return r12;
    L26:
        return null;
    L25:
        return null;
    }
}
