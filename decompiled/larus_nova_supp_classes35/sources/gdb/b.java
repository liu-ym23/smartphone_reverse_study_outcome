package gdb;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.larkconfig.export.handler.AbstractBaseSettingHandler;
import com.ss.android.lark.log.Log;
import dagger.hilt.EntryPoints;
import dagger.hilt.dwarf.spi.DwarfSPIEntryPoint;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import jdb.e;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b extends AbstractBaseSettingHandler.b {
    public jdb.b<Set<String>> i;
    public jdb.b<Set<String>> j;
    public jdb.b<Map<String, Boolean>> k;

    public static class a implements npb.a {
        public a() {
        }

        public final void a() {
        }

        public final String getTag() {
            return "FeatureGatingHandler";
        }

        public final Collection<AbstractBaseSettingHandler> b() {
            return new HashSet(Collections.singletonList(C0227b.a));
        }
    }

    /* JADX INFO: renamed from: gdb.b$b, reason: collision with other inner class name */
    public static class C0227b {
        public static final b a = null;

        static {
            a = new b();
        }
    }

    public final String a() {
        return "lark_features";
    }

    public final String d() {
        return "cache_setting_feature_gating";
    }

    public final String f() {
        return "FeatureGatingHandler";
    }

    public b() {
        AbstractBaseSettingHandler.a r0 = ((AbstractBaseSettingHandler) this).d;
        Function3 r1 = new gdb.a(this);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "strategy");
        r0.a(r0.e, r1);
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        ((AbstractBaseSettingHandler) this).f = r0;
    }

    public static void j() {
        ((e) ((DwarfSPIEntryPoint) EntryPoints.get(FeatureGatingModule.getDependency().getContext(), DwarfSPIEntryPoint.class)).dwarfSPI().get(e.class)).init();
    }

    public static Set k(String r5) {
    L16:
        Log.w("FeatureGatingHandler", "parse feature gating json failed");
        return null;
    L4:
        if (TextUtils.isEmpty(r5) == false) goto L6;
        return null;
    L6:
        HashSet r3 = new HashSet();     // Catch: Exception -> L16
        JSONArray r6 = JSON.parseObject(r5).getJSONArray("online");     // Catch: Exception -> L16
        if (r6 != null) goto L10;
        Log.w("FeatureGatingHandler", "parse feature gating json failed");     // Catch: Exception -> L16
        return null;
    L10:
        Iterator r7 = r6.iterator();     // Catch: Exception -> L16
    L12:
        if (r7.hasNext() == false) goto L15;
        r3.add(r7.next().toString());     // Catch: Exception -> L16
        goto L12
    L15:
        return r3;
    }
}
