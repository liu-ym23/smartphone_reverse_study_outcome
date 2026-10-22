package org.apache.poi.ss.formula.function;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public final class FunctionMetadataRegistry {
    private static FunctionMetadataRegistry _instance;
    private static FunctionMetadataRegistry _instanceCetab;
    private final FunctionMetadata[] _functionDataByIndex;
    private final Map<String, FunctionMetadata> _functionDataByName;

    FunctionMetadataRegistry(FunctionMetadata[] r3, Map<String, FunctionMetadata> r4) {
        Map<String, FunctionMetadata> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
        FunctionMetadata[] r6 = null;
    L6:
        this._functionDataByIndex = r6;
        this._functionDataByName = r5;
        return;
    L5:
        r6 = (FunctionMetadata[]) ZeusTransformUtils.preCheckCast(r3.clone(), FunctionMetadata[].class, "com.obric.memorydata.plugin");
        goto L6
    }

    public static FunctionMetadata getCetabFunctionByIndex(int r1) {
        return getInstanceCetab().getFunctionByIndexInternal(r1);
    }

    public static FunctionMetadata getFunctionByIndex(int r1) {
        return getInstance().getFunctionByIndexInternal(r1);
    }

    private FunctionMetadata getFunctionByIndexInternal(int r1) {
        return this._functionDataByIndex[r1];
    }

    public static FunctionMetadata getFunctionByName(String r1) {
        FunctionMetadata r0 = getInstance().getFunctionByNameInternal(r1);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return getInstanceCetab().getFunctionByNameInternal(r1);
    }

    private FunctionMetadata getFunctionByNameInternal(String r2) {
        return (FunctionMetadata) ZeusTransformUtils.preCheckCast(this._functionDataByName.get(r2), FunctionMetadata.class, "com.obric.memorydata.plugin");
    }

    private static FunctionMetadataRegistry getInstance() {
        if (_instance != null) goto L6;
        _instance = FunctionMetadataReader.createRegistry();
    L6:
        return _instance;
    }

    private static FunctionMetadataRegistry getInstanceCetab() {
        if (_instanceCetab != null) goto L6;
        _instanceCetab = FunctionMetadataReader.createRegistryCetab();
    L6:
        return _instanceCetab;
    }

    public static short lookupIndexByName(String r1) {
        FunctionMetadata r0 = getInstance().getFunctionByNameInternal(r1);
        if (r0 != null) goto L9;
        r0 = getInstanceCetab().getFunctionByNameInternal(r1);
        if (r0 != null) goto L9;
        return -1;
    L9:
        return (short) r0.getIndex();
    }
}
