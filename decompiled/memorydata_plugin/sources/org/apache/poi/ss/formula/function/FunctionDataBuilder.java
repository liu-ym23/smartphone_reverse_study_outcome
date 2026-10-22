package org.apache.poi.ss.formula.function;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes7.dex */
final class FunctionDataBuilder {
    private final Map<Integer, FunctionMetadata> _functionDataByIndex;
    private final Map<String, FunctionMetadata> _functionDataByName;
    private int _maxFunctionIndex;
    private final Set<Integer> _mutatingFunctionIndexes;

    public FunctionDataBuilder(int r2) {
        this._maxFunctionIndex = -1;
        int r3 = (r2 * 3) / 2;
        this._functionDataByName = new HashMap(r3);
        this._functionDataByIndex = new HashMap(r3);
        this._mutatingFunctionIndexes = new HashSet();
    }

    public void add(int r9, String r10, int r11, int r12, byte r13, byte[] r14, boolean r15) {
        FunctionMetadata r7 = new FunctionMetadata(r9, r10, r11, r12, r13, r14);
        Integer r16 = Integer.valueOf(r9);
        if (r9 <= this._maxFunctionIndex) goto L5;
        this._maxFunctionIndex = r9;
    L5:
        FunctionMetadata r17 = (FunctionMetadata) ZeusTransformUtils.preCheckCast(this._functionDataByName.get(r10), FunctionMetadata.class, "com.obric.memorydata.plugin");
        if (r17 == null) goto L13;
        if (r15 == false) goto L12;
        if (this._mutatingFunctionIndexes.contains(r16) == false) goto L12;
        this._functionDataByIndex.remove(Integer.valueOf(r17.getIndex()));
    L12:
        throw new RuntimeException("Multiple entries for function name '" + r10 + "'");
    L13:
        FunctionMetadata r18 = (FunctionMetadata) ZeusTransformUtils.preCheckCast(this._functionDataByIndex.get(r16), FunctionMetadata.class, "com.obric.memorydata.plugin");
        if (r18 == null) goto L21;
        if (r15 == false) goto L20;
        if (this._mutatingFunctionIndexes.contains(r16) == false) goto L20;
        this._functionDataByName.remove(r18.getName());
    L20:
        throw new RuntimeException("Multiple entries for function index (" + r9 + ")");
    L21:
        if (r15 == false) goto L23;
        this._mutatingFunctionIndexes.add(r16);
    L23:
        this._functionDataByIndex.put(r16, r7);
        this._functionDataByName.put(r10, r7);
    }

    public FunctionMetadataRegistry build() {
        int r0 = this._functionDataByName.size();
        FunctionMetadata[] r1 = new FunctionMetadata[r0];
        this._functionDataByName.values().toArray(r1);
        FunctionMetadata[] r2 = new FunctionMetadata[this._maxFunctionIndex + 1];
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L6;
        FunctionMetadata r4 = r1[r3];
        r2[r4.getIndex()] = r4;
        r3 = r3 + 1;
        goto L3
    L6:
        return new FunctionMetadataRegistry(r2, this._functionDataByName);
    }
}
