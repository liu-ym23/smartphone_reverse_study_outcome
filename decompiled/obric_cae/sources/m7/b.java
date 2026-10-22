package m7;

import android.text.TextUtils;
import com.bytedance.retrofit2.client.Request;
import java.util.HashSet;
import java.util.LinkedHashMap;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f9285g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9286a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9287b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashSet f9288c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashSet f9289d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HashSet f9290e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HashSet f9291f;

    public b(int r8) {
        this.f9288c = new HashSet();
        this.f9289d = new HashSet();
        this.f9290e = new HashSet();
        this.f9291f = new HashSet();
        this.f9286a = r8;
        this.f9287b = r8;
    }

    public static boolean b(HashSet r8) {
        if (r8 != null) goto L4;
        return true;
    L4:
        if (r8.isEmpty() == true) goto L10;
        return false;
    L10:
        return true;
    }

    public static void c(JSONArray r8, HashSet r10) {
        if (r8 == null) goto L12;
        if (r10 == null) goto L19;
        int r11 = 0;
    L14:
        if (r11 >= r8.length()) goto L21;
        String r12 = r8.getString(r11);     // Catch: JSONException -> L13
        if (TextUtils.isEmpty(r12) == true) goto L11;
        r10.add(r12);     // Catch: JSONException -> L13
    L11:
        r11 = r11 + 1;
        goto L14
    L21:
        return;
    L20:
        return;
    L19:
        return;
    }

    public abstract boolean a(Request r8, LinkedHashMap r10);
}
