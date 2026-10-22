package v6;

import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c extends o6.a<b> {
    public static final c a = null;

    @Override // o6.a
    public final String getSettingsKey() {
        return "bda_atp_config";
    }

    static {
        a = new c();
    }

    @Override // o6.a
    public final o6.c obtainSettingsManager() {
        Class r0 = JvmClassMappingKt.getJavaClass(Reflection.getOrCreateKotlinClass(o6.b.class));
        t6.b r1 = t6.a.a;
        o6.b r10 = (o6.b) t6.a.C0199a.a(r0, null);
        if (r10 == null) goto L5;
        r10.a();
    L5:
        return null;
    }

    public c() {
    }

    @Override // o6.a
    public final Class<b> getSettingsModelClass() {
        return b.class;
    }
}
