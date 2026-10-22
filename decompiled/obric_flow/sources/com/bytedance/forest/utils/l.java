package com.bytedance.forest.utils;

import androidx.room.writer.DaoWriter;
import com.bytedance.forest.Forest;
import com.bytedance.keva.Keva;
import com.bytedance.keva.KevaConstants;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public abstract class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Keva f4649a = null;

    static {
        f4649a = Keva.getRepo("forest_cdn", 1);
    }

    public static void a() {
        if (Forest.Companion.getEnableKEVAOpt$forest_release() == false) goto L9;
        Keva r5 = f4649a;
        if (r5 == null) goto L47;
        r5.count();
        Map r10 = r5.buildNewMap(KevaConstants.FLAG_CURRENT_KEY_MAP);
        if (r10 == null) goto L70;
    L13:
        Iterator<String> r11 = r10.keySet().iterator();
    L15:
        if (r11.hasNext() == false) goto L73;
        String r12 = r11.next();
        if (r12 == null) goto L15;
        if (r12.length() == 0) goto L15;
        List r13 = k.f4646a;
        List r14 = StringsKt.K(r12, new String[]{DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD}, 0, 6);
        if (r14.size() != 3) goto L28;
        if (StringsKt.toIntOrNull((String) r14.get(1)) == null) goto L28;
        if (StringsKt.toLongOrNull((String) r14.get(2)) != null) goto L15;
    L28:
        Keva r15 = f4649a;
        String r16 = r15.getStringJustDisk(r12, "");
        if (r16 == null) goto L46;
        if (r16.length() == 0) goto L46;
        Iterator r17 = StringsKt.K(r16, new String[]{","}, 0, 6).iterator();
        boolean r18 = false;
    L35:
        if (r17.hasNext() == false) goto L44;
        File r19 = new File((File) com.bytedance.forest.pollyfill.b.f4507a.getValue(), (String) r17.next());
        if (r18 == false) goto L39;
    L42:
        r18 = true;
    L43:
        if (r18 == false) goto L35;
    L39:
        if (r19.exists() == true) goto L42;
        r18 = false;
    L44:
        if (r18 == true) goto L15;
        f4649a.erase(r12);
    L46:
        r15.erase(r12);
        goto L15
    L73:
        return;
    L70:
        return;
    L47:
        return;
    L9:
        Keva r20 = f4649a;
        if (r20 == null) goto L71;
        r10 = r20.getAll();
        if (r10 != null) goto L13;
        return;
    }
}
