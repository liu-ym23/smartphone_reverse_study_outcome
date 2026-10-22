package wc2;

import com.bytedance.android.livesdkapi.hybridapi.BaseJsBridgeMethodFactory;
import com.bytedance.android.livesdkapi.hybridapi.IJsBridgeManager;
import com.bytedance.android.livesdkapi.jsb.ExternalJsBridgeMethodFactory;
import com.bytedance.ies.web.jsbridge2.f;
import com.bytedance.ies.web.jsbridge2.g;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a extends BaseJsBridgeMethodFactory {
    public final String a;
    public final ExternalJsBridgeMethodFactory b;

    public final Map<String, n56.c> provideLegacyMethods(IJsBridgeManager r5) {
        Intrinsics.checkNotNullParameter(r5, "manager");
        if (this.b.getPreventNamespace() == true) goto L12;
        Map r6 = this.b.provideLegacyMethods();
        LinkedHashMap r0 = new LinkedHashMap(MapsKt.mapCapacity(r6.size()));
        Iterator r7 = r6.entrySet().iterator();
    L7:
        if (r7.hasNext() == false) goto L10;
        Map.Entry r1 = (Map.Entry) r7.next();
        r0.put("ext_" + this.a + '_' + ((String) r1.getKey()), r1.getValue());
        goto L7
    L10:
        return r0;
    L12:
        return this.b.provideLegacyMethods();
    }

    public final Map<String, f.b> provideStatefulMethods(IJsBridgeManager r5) {
        Intrinsics.checkNotNullParameter(r5, "manager");
        if (this.b.getPreventNamespace() == true) goto L12;
        Map r6 = this.b.provideStatefulMethods();
        LinkedHashMap r0 = new LinkedHashMap(MapsKt.mapCapacity(r6.size()));
        Iterator r7 = r6.entrySet().iterator();
    L7:
        if (r7.hasNext() == false) goto L10;
        Map.Entry r1 = (Map.Entry) r7.next();
        r0.put("ext_" + this.a + '_' + ((String) r1.getKey()), r1.getValue());
        goto L7
    L10:
        return r0;
    L12:
        return this.b.provideStatefulMethods();
    }

    public final Map<String, g<?, ?>> provideStatelessMethods(IJsBridgeManager r5) {
        Intrinsics.checkNotNullParameter(r5, "manager");
        if (this.b.getPreventNamespace() == true) goto L12;
        Map r6 = this.b.provideStatelessMethods();
        LinkedHashMap r0 = new LinkedHashMap(MapsKt.mapCapacity(r6.size()));
        Iterator r7 = r6.entrySet().iterator();
    L7:
        if (r7.hasNext() == false) goto L10;
        Map.Entry r1 = (Map.Entry) r7.next();
        r0.put("ext_" + this.a + '_' + ((String) r1.getKey()), r1.getValue());
        goto L7
    L10:
        return r0;
    L12:
        return this.b.provideStatelessMethods();
    }

    public a(String r2, ExternalJsBridgeMethodFactory r3) {
        Intrinsics.checkNotNullParameter(r2, "namespace");
        Intrinsics.checkNotNullParameter(r3, "factory");
        this.a = r2;
        this.b = r3;
    }
}
