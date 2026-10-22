package hi;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f17327a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Intent f17328b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f17329c;
    public Uri d;
    public String e;
    public String f;
    public String g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f17330h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f17331i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Uri f17332j;

    public static void b(Intent r5, String r10, boolean r11) {
        if (r5 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r10) == false) goto L7;
        Log.e("SmartRouter", "Slice url params but the url is null!!!");
        Map r12 = Collections.EMPTY_MAP;
    L21:
        if (r12 != null) goto L23;
        return;
    L23:
        if (r12.size() == 0) goto L49;
        Iterator r13 = r12.entrySet().iterator();
    L27:
        if (r13.hasNext() == false) goto L50;
        Map.Entry r14 = (Map.Entry) r13.next();
        if (r11 == true) goto L30;
        if (r5.hasExtra((String) r14.getKey()) == true) goto L27;
        r5.putExtra((String) r14.getKey(), (String) r14.getValue());
        goto L27
    L30:
        r5.putExtra((String) r14.getKey(), (String) r14.getValue());
        goto L27
    L50:
        return;
    L49:
        return;
    L7:
        Uri r15 = Uri.parse(r10);
        if (r15.isHierarchical() == true) goto L10;
        r12 = Collections.EMPTY_MAP;
        goto L21
    L10:
        Iterator<String> r16 = r15.getQueryParameterNames().iterator();
        HashMap r17 = new HashMap();
    L12:
        if (r16.hasNext() == false) goto L20;
        String r18 = r16.next();
        if (TextUtils.isEmpty(r18) == true) goto L12;
        String r19 = r15.getQueryParameter(r18);
        if (r19 != null) goto L19;
        r19 = "";
    L19:
        r17.put(r18, r19);
        goto L12
    L20:
        r12 = r17;
        goto L21
    }

    public final void a() {
        if (TextUtils.isEmpty(this.f17329c) == true) goto L15;
        Uri r5 = Uri.parse(this.f17329c);
        this.d = r5;
        this.f17328b.setData(r5);
        this.e = this.d.getScheme();
        this.f = this.d.getHost();
        String r10 = this.d.getPath();
        this.g = r10;
        if (this.e != null) goto L9;
        this.e = "";
    L9:
        if (this.f != null) goto L11;
        this.f = "";
    L11:
        if (r10 != null) goto L14;
        this.g = "";
        return;
    L14:
        return;
    }

    public final String toString() {
        return "RouteIntent{mOriginUrl='" + this.f17327a + "', mExtraIntent=" + this.f17328b + ", mUrl='" + this.f17329c + "', mUri=" + this.d + ", mScheme='" + this.e + "', mHost='" + this.f + "', mPath='" + this.g + "', enterAnim=" + this.f17330h + ", exitAnim=" + this.f17331i + ", mRequestCode=-2147483648, mData=" + this.f17332j + '}';
    }
}
