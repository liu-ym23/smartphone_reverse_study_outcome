package s0b;

import android.content.Context;
import com.bytedance.geckox.model.CheckRequestBodyModel;
import com.ss.android.lark.chameleon.ChameleonConfig;
import com.ss.android.lark.chameleon.GeckoConst;
import com.ss.android.lark.chameleon.ResConfig;
import com.ss.android.lark.chameleon.ResGeckoConfig;
import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.android.lark.officesdk.utils.di.m;
import com.ss.android.lark.vfs.VFSFile;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static VFSFile b() {
        VFSFile r0 = com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.c.k().subPath("gecko").toFile();
        if (r0.exists() == false) goto L5;
    L7:
        j.a("CML_TAG_ChameleonGeckoConfig", "getGeckoRootPath: " + r0.getAbsolutePath());
        return r0;
    L5:
        if (r0.mkdirs() == true) goto L7;
        j.f("CML_TAG_ChameleonGeckoConfig", "mkdir gecko Dir failed");
        goto L7
    }

    public static String a(Context r2, ResGeckoConfig r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "resGeckoConfig");
        HashMap<String, String> r4 = r3.getAccessKey();
        int r0 = m.a;
        if (m.a.a().isBoe() == false) goto L19;
        if (r4 != null) goto L6;
        return null;
    L6:
        return r4.get(GeckoConst.BOE);
    L19:
        if ((r2.getApplicationInfo().flags & 2) == 0) goto L11;
        boolean r5 = true;
    L12:
        if (r5 == false) goto L15;
        if (r4 != null) goto L23;
        return null;
    L23:
        return r4.get(GeckoConst.DEBUG);
    L15:
        if (r4 != null) goto L17;
        return null;
    L17:
        return r4.get("release");
    L11:
        r5 = false;
        goto L12
    }

    public static Map c(Context r4, ChameleonConfig r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "chameleonConfig");
        HashMap r0 = new HashMap();
        ResConfig r6 = r5.getResConfig();
        if (r6 == null) goto L5;
        ResGeckoConfig r7 = r6.getGeckoConfig();
    L6:
        if (r7 != null) goto L8;
    L20:
        return r0;
    L8:
        if (r7.getEnable() == true) goto L10;
        j.f("CML_TAG_ChameleonGeckoConfig", "!geckoConfig.enable");
    L10:
        String r8 = a(r4, r7);
        ArrayList r1 = new ArrayList();
        HashMap<String, String> r9 = r7.getChannels();
        if (r9 == null) goto L18;
        Collection<String> r10 = r9.values();
        if (r10 == null) goto L18;
        Iterator<T> r11 = r10.iterator();
    L16:
        if (r11.hasNext() == false) goto L18;
        r1.add(new CheckRequestBodyModel.TargetChannel((String) r11.next()));
    L18:
        if (r8 == null) goto L20;
        r0.put(r8, r1);
        goto L20
    L5:
        r7 = null;
        goto L6
    }
}
