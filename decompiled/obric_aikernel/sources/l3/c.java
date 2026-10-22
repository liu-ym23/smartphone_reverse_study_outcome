package l3;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.apm6.util.JsonUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c {

    public interface a<A, B> {
        boolean equals(A r10, B r11);
    }

    public static boolean a(List<?> r10) {
        if (r10 != null) goto L4;
    L7:
        return true;
    L4:
        if (r10.size() == 0) goto L7;
        return false;
    }

    @Nullable
    public static List<String> b(JSONObject r10, String r11) {
        JSONArray r12 = r10.optJSONArray(r11);     // Catch: Exception -> L15
        if (r12 != null) goto L5;
        return null;
    L5:
        if (r12.length() <= 0) goto L21;
        int r13 = r12.length();     // Catch: Exception -> L15
        ArrayList r14 = new ArrayList(r13);     // Catch: Exception -> L15
        int r15 = 0;
    L7:
        if (r15 >= r13) goto L12;
        String r16 = r12.getString(r15);     // Catch: Exception -> L15
        if (TextUtils.isEmpty(r16) == true) goto L11;
        r14.add(r16);     // Catch: Exception -> L15
    L11:
        r15 = r15 + 1;
        goto L7
    L12:
        return r14;
    L21:
        return null;
    L22:
        return null;
    }

    @Nullable
    public static List<String> c(JSONObject r10, String r11) {
        JSONObject r12 = r10.optJSONObject(r11);     // Catch: Exception -> L14
        if (JsonUtils.isEmpty(r12) == false) goto L6;
        return null;
    L6:
        ArrayList r13 = new ArrayList();     // Catch: Exception -> L14
        Iterator<String> r14 = r12.keys();     // Catch: Exception -> L14
    L8:
        if (r14.hasNext() == false) goto L13;
        String r15 = r14.next();     // Catch: Exception -> L14
        if (r12.optInt(r15) != 1) goto L8;
        r13.add(r15);     // Catch: Exception -> L14
        goto L8
    L13:
        return r13;
    L14:
        return null;
    }

    @Nullable
    public static List<Pattern> d(JSONObject r10, String r11) {
        JSONObject r12 = r10.optJSONObject(r11);     // Catch: Exception -> L14
        if (JsonUtils.isEmpty(r12) == false) goto L6;
        return null;
    L6:
        ArrayList r13 = new ArrayList();     // Catch: Exception -> L14
        Iterator<String> r14 = r12.keys();     // Catch: Exception -> L14
    L8:
        if (r14.hasNext() == false) goto L13;
        String r15 = r14.next();     // Catch: Exception -> L14
        if (r12.optInt(r15) != 1) goto L8;
        r13.add(Pattern.compile(r15));     // Catch: Exception -> L14
        goto L8
    L13:
        return r13;
    L14:
        return null;
    }

    @Nullable
    public static List<Pattern> e(JSONObject r10, String r11) {
        JSONArray r12 = r10.optJSONArray(r11);     // Catch: Exception -> L15
        if (r12 != null) goto L5;
        return null;
    L5:
        if (r12.length() <= 0) goto L21;
        int r13 = r12.length();     // Catch: Exception -> L15
        ArrayList r14 = new ArrayList(r13);     // Catch: Exception -> L15
        int r15 = 0;
    L7:
        if (r15 >= r13) goto L12;
        String r16 = r12.getString(r15);     // Catch: Exception -> L15
        if (TextUtils.isEmpty(r16) == true) goto L11;
        r14.add(Pattern.compile(r16));     // Catch: Exception -> L15
    L11:
        r15 = r15 + 1;
        goto L7
    L12:
        return r14;
    L21:
        return null;
    L22:
        return null;
    }

    public static <L, O> boolean f(Collection<L> r10, O r11, a<? super L, O> r12) {
        Iterator<L> r13 = r10.iterator();
        boolean r14 = false;
    L4:
        if (r13.hasNext() == false) goto L8;
        if (r12.equals(r13.next(), r11) == false) goto L4;
        r13.remove();
        r14 = true;
        goto L4
    L8:
        return r14;
    }
}
