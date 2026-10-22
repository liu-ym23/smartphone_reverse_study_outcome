package org.ehcache.core;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public final enum CacheConfigurationProperty extends Enum<CacheConfigurationProperty> {
    private static final /* synthetic */ CacheConfigurationProperty[] $VALUES = null;
    public static final CacheConfigurationProperty ADD_LISTENER = null;
    public static final CacheConfigurationProperty REMOVE_LISTENER = null;
    public static final CacheConfigurationProperty UPDATE_SIZE = null;

    static {
        CacheConfigurationProperty r0 = new CacheConfigurationProperty("UPDATE_SIZE", 0);
        UPDATE_SIZE = r0;
        CacheConfigurationProperty r1 = new CacheConfigurationProperty("ADD_LISTENER", 1);
        ADD_LISTENER = r1;
        CacheConfigurationProperty r3 = new CacheConfigurationProperty("REMOVE_LISTENER", 2);
        REMOVE_LISTENER = r3;
        $VALUES = new CacheConfigurationProperty[]{r0, r1, r3};
    }

    private CacheConfigurationProperty(String r1, int r2) {
        super(r1, r2);
    }

    public static CacheConfigurationProperty valueOf(String r2) {
        return (CacheConfigurationProperty) ZeusTransformUtils.preCheckCast(Enum.valueOf(CacheConfigurationProperty.class, r2), CacheConfigurationProperty.class, "com.obric.memorydata.plugin");
    }

    public static CacheConfigurationProperty[] values() {
        return (CacheConfigurationProperty[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), CacheConfigurationProperty[].class, "com.obric.memorydata.plugin");
    }
}
