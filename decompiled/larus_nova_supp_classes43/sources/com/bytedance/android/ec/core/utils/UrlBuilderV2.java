package com.bytedance.android.ec.core.utils;

import android.net.Uri;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.mt.protector.impl.UriProtector;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b$\u0010%B\u0011\b\u0016\u0012\u0006\u0010&\u001a\u00020\u001a¢\u0006\u0004\b$\u0010'J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002J\u0010\u0010\u000b\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0002J\b\u0010\f\u001a\u0004\u0018\u00010\u0002J\u0016\u0010\u0010\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eJ\u0016\u0010\u0010\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0011J\u001a\u0010\u0010\u001a\u00020\b2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0012J\u0016\u0010\u0010\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0014J\u0016\u0010\u0010\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0002J\u0016\u0010\u0010\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0002J\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0017J\u0006\u0010\u0019\u001a\u00020\u0002J\u0006\u0010\u001b\u001a\u00020\u001aJ\b\u0010\u001c\u001a\u00020\u0002H\u0016R%\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00178\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0016\u0010\u0007\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010!R\u0018\u0010\"\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010!R\u0018\u0010#\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010!¨\u0006("}, d2 = {"Lcom/bytedance/android/ec/core/utils/UrlBuilderV2;", "Ljava/io/Serializable;", "", "getHost", "key", "getQuery", "getEncoding", "mEncoding", "", "setEncoding", com.bytedance.android.ec.core.event.a.KEY_URL, "setUrl", "getUrl", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, "", com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE, "addOrReplaceParam", "", "", "map", "", "Lorg/json/JSONObject;", "removeParam", "", "queryMap", "build", "Landroid/net/Uri;", "buildUri", "toString", "mMap", "Ljava/util/Map;", "getMMap", "()Ljava/util/Map;", "Ljava/lang/String;", "mHost", "mUrl", "<init>", "(Ljava/lang/String;)V", "uri", "(Landroid/net/Uri;)V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UrlBuilderV2 implements Serializable {
    private String mEncoding;
    private String mHost;
    private final Map<String, String> mMap;
    private String mUrl;

    public UrlBuilderV2() {
        String r0 = null;
        this(r0, 1, r0);
    }

    public final void a() {
        String r0 = this.mUrl;
        if (r0 == null) goto L22;
        Uri r1 = UriProtector.parse(r0);     // Catch: Exception -> L12
        Iterator r10 = UriProtector.getQueryParameterNames(r1).iterator();     // Catch: Exception -> L12
    L6:
        if (r10.hasNext() == false) goto L10;
        String r11 = (String) r10.next();     // Catch: Exception -> L12
        String r12 = UriProtector.getQueryParameter(r1, r11);     // Catch: Exception -> L12
        if (r12 == null) goto L6;
        this.mMap.put(r11, r12);     // Catch: Exception -> L12
        goto L6
    L10:
        this.mUrl = r1.buildUpon().clearQuery().toString();     // Catch: Exception -> L12
        this.mHost = r1.getHost();     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return;
    }

    public final String build() {
        Map<String, String> r0 = this.mMap;
        ArrayList r1 = new ArrayList(r0.size());
        Iterator<Map.Entry<String, String>> r10 = r0.entrySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L7;
        Map.Entry<String, String> r11 = r10.next();
        r1.add(new i(r11.getKey(), r11.getValue()));
        goto L4
    L7:
        if (r1.isEmpty() == false) goto L12;
        String r12 = this.mUrl;
        if (r12 != null) goto L26;
        return "";
    L26:
        return r12;
    L12:
        String r13 = e2.b(r1, this.mEncoding);
        String r14 = this.mUrl;
        if (r14 != null) goto L15;
        return r13;
    L15:
        if (r14.length() != 0) goto L17;
        boolean r15 = true;
    L18:
        if (r15 == false) goto L21;
        return r13;
    L21:
        if (StringsKt.indexOf$default(r14, '?', 0, false, 6, null) < 0) goto L24;
        return this.mUrl + '&' + r13;
    L24:
        return this.mUrl + '?' + r13;
    L17:
        r15 = false;
        goto L18
    }

    public final Uri buildUri() {
        String r0 = this.mUrl;
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        Uri.Builder r1 = UriProtector.parse(r0).buildUpon();
        Iterator<Map.Entry<String, String>> r10 = this.mMap.entrySet().iterator();
    L7:
        if (r10.hasNext() == false) goto L10;
        Map.Entry<String, String> r11 = r10.next();
        r1.appendQueryParameter(r11.getKey(), r11.getValue());
        goto L7
    L10:
        return r1.build();
    }

    public String toString() {
        return build();
    }

    public final String getEncoding() {
        return this.mEncoding;
    }

    public final String getHost() {
        return this.mHost;
    }

    public final Map<String, String> getMMap() {
        return this.mMap;
    }

    public final String getUrl() {
        return this.mUrl;
    }

    public final Map<String, String> queryMap() {
        return this.mMap;
    }

    public UrlBuilderV2(Uri r10) {
        Intrinsics.checkNotNullParameter(r10, "uri");
        String r0 = null;
        this(r0, 1, r0);
        Iterator r1 = UriProtector.getQueryParameterNames(r10).iterator();     // Catch: Exception -> L11
    L5:
        if (r1.hasNext() == false) goto L9;
        String r11 = (String) r1.next();     // Catch: Exception -> L11
        String r12 = UriProtector.getQueryParameter(r10, r11);     // Catch: Exception -> L11
        if (r12 == null) goto L5;
        this.mMap.put(r11, r12);     // Catch: Exception -> L11
        goto L5
    L9:
        this.mUrl = r10.buildUpon().clearQuery().toString();     // Catch: Exception -> L11
        this.mHost = r10.getHost();     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        ECExceptionMonitor.e(e);
    }

    public final void addOrReplaceParam(Map<String, String> r10) {
        Intrinsics.checkNotNullParameter(r10, "map");
        this.mMap.putAll(r10);
    }

    public final String getQuery(String r10) {
        Intrinsics.checkNotNullParameter(r10, "key");
        return this.mMap.get(r10);
    }

    public final void removeParam(String r10) {
        Intrinsics.checkNotNullParameter(r10, "key");
        this.mMap.remove(r10);
    }

    public final void setEncoding(String r10) {
        Intrinsics.checkNotNullParameter(r10, "mEncoding");
        this.mEncoding = r10;
    }

    public final void setUrl(String r1) {
        this.mUrl = r1;
        a();
    }

    public UrlBuilderV2(String r1) {
        this.mUrl = r1;
        this.mMap = new ConcurrentHashMap();
        this.mEncoding = "UTF-8";
        a();
    }

    public final void addOrReplaceParam(String r10, JSONObject r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
        String r0 = this.mMap.get(r10);
        if (r0 == null) goto L5;
        JSONObject r1 = z1.g(r0);
    L6:
        if (r1 == null) goto L12;
        Iterator<String> r12 = r11.keys();
    L9:
        if (r12.hasNext() == false) goto L11;
        String r13 = r12.next();
        r1.put(r13, r11.opt(r13));
        goto L9
    L11:
        r11 = r1;
    L12:
        addOrReplaceParam(r10, r11.toString());
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void addOrReplaceParam(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
        this.mMap.put(r10, r11);
    }

    public final void addOrReplaceParam(String r10, double r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
        this.mMap.put(r10, String.valueOf(r11));
    }

    public final void addOrReplaceParam(String r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
        this.mMap.put(r10, String.valueOf(r11));
    }

    public final void addOrReplaceParam(String r10, long r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
        this.mMap.put(r10, String.valueOf(r11));
    }

    public /* synthetic */ UrlBuilderV2(String r1, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }
}
