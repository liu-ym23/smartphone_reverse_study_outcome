package androidx.room.util;

import android.util.Log;
import androidx.annotation.RestrictTo;
import androidx.room.Room;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\u001a\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b\u001a\u0018\u0010\f\u001a\u0004\u0018\u00010\u00022\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000e\u001a\u0006\u0010\u000f\u001a\u00020\t\u001a\u0018\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0002\" \u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0005\u0012\u0004\b\u0003\u0010\u0004¨\u0006\u0011"}, d2 = {"EMPTY_STRING_ARRAY", "", "", "getEMPTY_STRING_ARRAY$annotations", "()V", "[Ljava/lang/String;", "appendPlaceholders", "", "builder", "Ljava/lang/StringBuilder;", "count", "", "joinIntoString", "input", "", "newStringBuilder", "splitToIntList", "room-runtime_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
@JvmName(name = "StringUtil")
public final class StringUtil {

    @JvmField
    public static final String[] EMPTY_STRING_ARRAY = null;

    static {
        EMPTY_STRING_ARRAY = new String[0];
    }

    public static final void appendPlaceholders(StringBuilder r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "builder");
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L8;
        r5.append("?");
        if (r11 >= (r10 - 1)) goto L7;
        r5.append(",");
    L7:
        r11 = r11 + 1;
        goto L3
    }

    public static /* synthetic */ void getEMPTY_STRING_ARRAY$annotations() {
    }

    public static final String joinIntoString(List<Integer> r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        return CollectionsKt.q(r10, ",", null, null, 0, null, null, 62);
    }

    public static final StringBuilder newStringBuilder() {
        return new StringBuilder();
    }

    public static final List<Integer> splitToIntList(String r5) {
        if (r5 == null) goto L25;
        List r10 = StringsKt.J(r5, new char[]{','}, 0, 6);
        if (r10 == null) goto L26;
        ArrayList r11 = new ArrayList();
        Iterator r12 = r10.iterator();
    L8:
        if (r12.hasNext() == false) goto L17;
        Integer r13 = Integer.valueOf(Integer.parseInt((String) r12.next()));     // Catch: NumberFormatException -> L12
    L14:
        if (r13 == null) goto L8;
        r11.add(r13);
    L12:
        e = move-exception;
        Log.e(Room.LOG_TAG, "Malformed integer list", e);
        r13 = null;
        goto L14
    L17:
        return r11;
    L26:
        return null;
    L25:
        return null;
    }
}
