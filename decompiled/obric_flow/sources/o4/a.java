package o4;

import android.net.Uri;
import android.os.Bundle;
import com.bytedance.ies.bullet.secure.g;
import com.bytedance.ies.bullet.service.sdk.b;
import com.bytedance.ies.bullet.service.sdk.c;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f20409a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f20410b;

    public a(Bundle r5) {
        this.f20409a = 1;
        Intrinsics.checkNotNullParameter(r5, "bundle");
        this.f20410b = r5;
    }

    @Override // com.bytedance.ies.bullet.service.sdk.c
    public final boolean a(b r10) {
        Object r5 = this.f20410b;
        int r11 = this.f20409a;
        Intrinsics.checkNotNullParameter(r10, "schemaData");
        switch(r11) {
            case 0: goto L21;
            case 1: goto L16;
            default: goto L4;
        };
    L4:
        ArrayList r12 = new ArrayList();
        String r13 = (String) r10.f6143o.get("packages");
        ArrayList r14 = (ArrayList) r5;
        if (r13 == null) goto L14;
        Iterator r15 = StringsKt.J(r13, new char[]{','}, 0, 6).iterator();
    L8:
        if (r15.hasNext() == false) goto L14;
        String r16 = (String) r15.next();
        if (r16.length() <= 0) goto L8;
        if (r14.contains(r16) == true) goto L8;
        r12.add(r16);
    L14:
        r12.addAll(r14);
        r10.b("packages", new vd.a(r12, 6), true);
        return true;
    L16:
        Bundle r17 = (Bundle) r5;
        Intrinsics.checkNotNullParameter(r17, "bundle");
        Bundle r18 = r10.f6134b;
        if (r18 != null) goto L19;
        r10.f6134b = r17;
    L20:
        return true;
    L19:
        r18.putAll(r17);
        goto L20
    L21:
        List r19 = (List) new vd.a(r10, "append_global_props", CollectionsKt.emptyList()).f22372b;
        if (r19 != null) goto L24;
    L55:
        return true;
    L24:
        if (r19.isEmpty() == false) goto L27;
        r19 = null;
    L27:
        if (r19 == null) goto L55;
        int r20 = g.f5907a;
        Uri r21 = r10.f6135c;
        if (g.b(r21) == false) goto L55;
        ConcurrentHashMap r22 = o3.a.f20403a;
        String r23 = (String) r5;
        Intrinsics.checkNotNullParameter(r23, "bid");
        Intrinsics.checkNotNullParameter(r21, LynxResourceModule.URI_KEY);
        LinkedHashMap r24 = new LinkedHashMap();
        LinkedHashMap r25 = o3.a.m(o3.a.a(r21), r23);
        Iterator r26 = r19.iterator();
    L33:
        if (r26.hasNext() == false) goto L37;
        String r27 = (String) r26.next();
        Object r28 = r25.get(r27);
        if (r28 == null) goto L33;
        r24.put(r27, r28.toString());
        goto L33
    L37:
        Uri.Builder r29 = r21.buildUpon();
        r29.appendQueryParameter("appended_global_props", new JSONObject(r24).toString());
        Uri r30 = r29.build();
        Intrinsics.checkNotNullParameter(r30, LynxResourceModule.URI_KEY);
        String r31 = r30.toString();
        int r32 = StringsKt.q(r31, '?', 0, 6);
        if (r32 == (-1)) goto L55;
        int r33 = r32 + 1;
        int r34 = StringsKt.q(r31, '#', r33, 4);
        if (r34 != (-1)) goto L43;
        String r35 = r31.substring(r33, r31.length());
    L44:
        Iterator r36 = StringsKt.J(r35, new char[]{Typography.amp}, 0, 6).iterator();
    L46:
        if (r36.hasNext() == false) goto L55;
        List r37 = StringsKt.J((String) r36.next(), new char[]{'='}, 0, 6);
        if (r37.size() != 2) goto L46;
        String r38 = Uri.decode((String) r37.get(0));
        String r39 = Uri.decode((String) r37.get(1));
        if (r38 == null) goto L46;
        if (r39 == null) goto L46;
        LinkedHashMap r40 = r10.f6143o;
        if (r40.get(r38) != null) goto L46;
        r40.put(r38, r39);
        goto L46
    L43:
        r35 = r31.substring(r33, r34);
        goto L44
    }

    @Override // com.bytedance.ies.bullet.service.sdk.c
    public final String b() {
        switch(this.f20409a) {
            case 0: goto L8;
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        return "Packages";
    L6:
        return "Bundle";
    L8:
        return "AnnieXLiteGlobalPropsInterceptor";
    }

    public a(String r5) {
        this.f20409a = 0;
        Intrinsics.checkNotNullParameter(r5, "bid");
        this.f20410b = r5;
    }

    public a(ArrayList r5) {
        this.f20409a = 2;
        Intrinsics.checkNotNullParameter(r5, "packages");
        this.f20410b = r5;
    }
}
