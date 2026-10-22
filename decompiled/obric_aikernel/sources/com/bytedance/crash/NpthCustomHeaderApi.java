package com.bytedance.crash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class NpthCustomHeaderApi {
    private static CopyOnWriteArrayList<ICustomHeaderService> sList;

    public interface ICustomHeaderService {
        Map<String, String> getCustomHeader();
    }

    static {
        sList = new CopyOnWriteArrayList();
    }

    public NpthCustomHeaderApi() {
    }

    public static void addCustomHeaderService(ICustomHeaderService r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        sList.add(r10);
    }

    public static Map<String, String> getCustomHeaders() {
        if (sList.isEmpty() == false) goto L6;
        return null;
    L6:
        ArrayList r10 = new ArrayList(sList);
        HashMap r11 = new HashMap();
        Iterator r12 = r10.iterator();
    L8:
        if (r12.hasNext() == false) goto L10;
        r11.putAll(((ICustomHeaderService) r12.next()).getCustomHeader());
        goto L8
    L10:
        return r11;
    }

    public static void removeCustomHeaderService(ICustomHeaderService r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        sList.remove(r10);
    }
}
