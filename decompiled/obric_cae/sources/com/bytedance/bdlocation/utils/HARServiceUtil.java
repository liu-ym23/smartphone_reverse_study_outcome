package com.bytedance.bdlocation.utils;

import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.network.model.HARStatus;
import com.obric.cae.userAware.datacollection.AwareStateListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import rd.a;
import rd.b;

/* JADX INFO: loaded from: classes.dex */
public class HARServiceUtil {
    public HARServiceUtil() {
    }

    public static List<HARStatus> getHARStatusList() {
        ArrayList r8 = new ArrayList();
        a r10 = a.b.f11801a;
        int r11 = BDLocationConfig.getHARStatusRange();
        ArrayList r12 = r10.a(r11);
        if (r12 != null) goto L5;
    L9:
        ArrayList r13 = null;
    L10:
        if (r13 != null) goto L12;
    L17:
        return r8;
    L12:
        if (r13.size() <= 0) goto L17;
        Iterator r14 = r13.iterator();
    L15:
        if (r14.hasNext() == false) goto L17;
        b r15 = (b) r14.next();
        HARStatus r16 = new HARStatus();
        r15.getClass();
        r16.predict = null;
        r16.timestamp = 0;
        r8.add(r16);
        goto L15
    L5:
        if (r12.isEmpty() == true) goto L9;
        r13 = new ArrayList();
        int r17 = Math.min(r12.size(), r11);
        int r18 = 0;
    L7:
        if (r18 >= r17) goto L10;
        r13.add(r12.get(r18));
        r18 = r18 + 1;
        goto L7
    }

    public static int getMaxHARStatus() {
        ArrayList r8 = a.b.f11801a.a(BDLocationConfig.getHARStatusRange());
        if (r8 != null) goto L5;
        return 0;
    L5:
        if (r8.isEmpty() == true) goto L69;
        HashMap r10 = new HashMap();
        int r11 = r8.size();
        int r12 = 0;
    L7:
        if (r12 >= r11) goto L10;
        ((b) r8.get(r12)).getClass();
        r12 = r12 + 1;
        goto L7
    L10:
        if (r10.isEmpty() == true) goto L22;
        Iterator r13 = r10.entrySet().iterator();
        Map.Entry r14 = null;
    L13:
        if (r13.hasNext() == false) goto L20;
        Map.Entry r15 = (Map.Entry) r13.next();
        if (r15 == null) goto L13;
        if (r14 == null) goto L19;
        if (((Float) r14.getValue()).floatValue() >= ((Float) r15.getValue()).floatValue()) goto L13;
    L19:
        r14 = r15;
        goto L13
    L20:
        if (r14 == null) goto L22;
        String r16 = (String) r14.getKey();
    L23:
        r16.getClass();
        switch(r16.hashCode()) {
            case 49: goto L43;
            case 50: goto L39;
            case 51: goto L35;
            case 1444: goto L31;
            case 1445: goto L27;
            default: goto L25;
        };
    L25:
        byte r17 = -1;
    L46:
        switch(r17) {
            case 0: goto L53;
            case 1: goto L73;
            case 2: goto L72;
            case 3: goto L71;
            case 4: goto L48;
            default: goto L74;
        };
    L48:
        return -2;
    L74:
        return 0;
    L71:
        return -1;
    L72:
        return 3;
    L73:
        return 2;
    L53:
        return 1;
    L27:
        if (r16.equals("-2") == false) goto L63;
        r17 = 4;
        goto L46
    L63:
        r17 = -1;
        goto L46
    L31:
        if (r16.equals("-1") == false) goto L64;
        r17 = 3;
        goto L46
    L64:
        r17 = -1;
        goto L46
    L35:
        if (r16.equals(AwareStateListener.USER_INFO_FILE_BOTH_REMOTE_MODE) == false) goto L65;
        r17 = 2;
        goto L46
    L65:
        r17 = -1;
        goto L46
    L39:
        if (r16.equals(AwareStateListener.USER_INFO_FILE_REMOTE_MODE) == false) goto L66;
        r17 = 1;
        goto L46
    L66:
        r17 = -1;
        goto L46
    L43:
        if (r16.equals("1") == false) goto L67;
        r17 = 0;
        goto L46
    L67:
        r17 = -1;
    L22:
        r16 = "0";
        goto L23
    L69:
        return 0;
    }
}
