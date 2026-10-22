package com.bytedance.crash;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
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

    public static void addCustomHeaderService(ICustomHeaderService r2) {
        ICustomHeaderService r3 = (ICustomHeaderService) ZeusTransformUtils.wrapperContextForParams(r2, ICustomHeaderService.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
        return;
    L5:
        sList.add(r3);
    }

    public static Map<String, String> getCustomHeaders() {
        if (sList.isEmpty() == false) goto L6;
        return null;
    L6:
        ArrayList r0 = new ArrayList(sList);
        HashMap r1 = new HashMap();
        Iterator r2 = r0.iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        r1.putAll(((ICustomHeaderService) ZeusTransformUtils.preCheckCast(r2.next(), ICustomHeaderService.class, "com.obric.memorydata.plugin")).getCustomHeader());
        goto L8
    L10:
        return r1;
    }

    public static void removeCustomHeaderService(ICustomHeaderService r2) {
        ICustomHeaderService r3 = (ICustomHeaderService) ZeusTransformUtils.wrapperContextForParams(r2, ICustomHeaderService.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
        return;
    L5:
        sList.remove(r3);
    }
}
