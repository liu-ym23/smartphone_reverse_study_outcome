package com.larksuite.component.dynamicresources;

import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class DynamicResourcesManager {
    public static volatile DynamicResourcesManager a;

    public static class DynamicResourcesRefLeakException extends RuntimeException {
        public DynamicResourcesRefLeakException(String r1) {
            super(r1);
        }
    }

    static {
        new HashSet(Arrays.asList(new Class[]{String.class, Integer.class, Long.class, Short.class, Character.class, Byte.class, Float.class, Double.class}));
    }

    public DynamicResourcesManager() {
        new WeakHashMap();
        new WeakHashMap();
        new ArrayList();
        new WeakHashMap();
        new CopyOnWriteArrayList();
        Log.i("DynamicResourcesManager", "DynamicResourcesManager <init>");
    }
}
