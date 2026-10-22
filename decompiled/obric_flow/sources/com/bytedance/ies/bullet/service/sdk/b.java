package com.bytedance.ies.bullet.service.sdk;

import ai.j0;
import android.net.Uri;
import android.os.Bundle;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import com.bytedance.ies.bullet.service.schema.SchemaMonitorEvent;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements rd.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final rd.d f6133a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Bundle f6134b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Uri f6135c;
    public String d;
    public String e;
    public String f;
    public final boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map f6136h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f6137i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f6138j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final LinkedHashMap f6139k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final LinkedHashMap f6140l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final LinkedHashMap f6141m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final LinkedHashMap f6142n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final LinkedHashMap f6143o;

    public b(Uri r5, rd.d r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        Intrinsics.checkNotNullParameter(r10, "schemaMonitor");
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        Intrinsics.checkNotNullParameter(r10, "schemaMonitor");
        this.f6133a = r10;
        this.f6135c = r5;
        this.f6136h = MapsKt.mapOf(TuplesKt.to("schema", r5.toString()));
        this.f6139k = new LinkedHashMap();
        this.f6140l = new LinkedHashMap();
        this.f6141m = new LinkedHashMap();
        this.f6142n = new LinkedHashMap();
        this.f6143o = new LinkedHashMap();
        this.g = r11;
    }

    public final String a() {
        String r5 = this.e;
        if (r5 == null) goto L9;
        int r10 = StringsKt.r("/", 0, 6, r5);
        if (r10 != (-1)) goto L8;
        return r5;
    L8:
        return r5.substring(0, r10);
    L9:
        return null;
    }

    public final void b(String r5, um.a r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r5, STGroup.DICT_KEY);
        Intrinsics.checkNotNullParameter(r10, "value");
        LinkedHashMap r12 = this.f6143o;
        if (r11 == false) goto L5;
    L8:
        r12.put(r5, r10.i());
        return;
    L5:
        if (r12.get(r5) == null) goto L8;
    }

    public final Uri c() {
        String r5 = this.d;
        if (r5 == null) goto L18;
        StringBuilder r10 = j0.w(r5, "://");
        r10.append(this.e);
        LinkedHashMap r11 = this.f6143o;
        if (r11.isEmpty() == true) goto L14;
        r10.append('?');
        Iterator r12 = r11.entrySet().iterator();
        boolean r13 = true;
    L8:
        if (r12.hasNext() == false) goto L14;
        Map.Entry r14 = (Map.Entry) r12.next();
        if (r13 == false) goto L12;
        r13 = false;
    L13:
        r10.append((String) r14.getKey());
        r10.append('=');
        r10.append(Uri.encode((String) r14.getValue()));
        goto L8
    L12:
        r10.append(Typography.amp);
    L14:
        String r15 = this.f;
        if (r15 == null) goto L17;
        r10.append('#');
        r10.append(r15);
    L17:
        Uri r16 = Uri.parse(r10.toString());
    L19:
        if (r16 == null) goto L21;
        return r16;
    L21:
        return Uri.EMPTY;
    L18:
        r16 = null;
        goto L19
    }

    public final void d() {
        this.f6138j = System.currentTimeMillis();
        LinkedHashMap r5 = this.f6140l;
        if (r5.isEmpty() == false) goto L6;
        Map r10 = null;
    L5:
        Map r11 = r10;
        SchemaMonitorEvent r12 = SchemaMonitorEvent.f6129a;
        LinkedHashMap r13 = this.f6139k;
        this.f6133a.g(r12, this, this.f6136h, r11, r13);
        r5.clear();
        r13.clear();
        return;
    L6:
        StringBuilder r14 = new StringBuilder();
        StringBuilder r15 = new StringBuilder();
        Iterator r16 = r5.entrySet().iterator();
    L8:
        if (r16.hasNext() == false) goto L10;
        Map.Entry r17 = (Map.Entry) r16.next();
        r14.append((String) r17.getKey());
        r14.append(',');
        r15.append((String) r17.getValue());
        r15.append(',');
        goto L8
    L10:
        r10 = MapsKt.mapOf(new Pair[]{TuplesKt.to("error_converter_names", r14.toString()), TuplesKt.to("error_converter_msg", r15.toString())});
        goto L5
    }
}
