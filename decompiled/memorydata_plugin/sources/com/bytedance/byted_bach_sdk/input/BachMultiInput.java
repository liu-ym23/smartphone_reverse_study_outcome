package com.bytedance.byted_bach_sdk.input;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class BachMultiInput implements BachAlgorithmInput {
    public static final String SRC_ARRAY_SLOT = "src_array_0";
    public static final String SRC_DATA_SLOT = "src_data_0";
    public HashMap<String, BachAlgorithmInput> m_mapInput;

    public BachMultiInput() {
        this.m_mapInput = new HashMap();
    }

    public BachMultiInput(HashMap<String, BachAlgorithmInput> r1) {
        this.m_mapInput = r1;
    }

    public void addBachInput(String r3, BachAlgorithmInput r4) {
        BachAlgorithmInput r5 = (BachAlgorithmInput) ZeusTransformUtils.wrapperContextForParams(r4, BachAlgorithmInput.class, "com.obric.memorydata.plugin");
        this.m_mapInput.put(r3, r5);
    }

    @Override // com.bytedance.byted_bach_sdk.input.BachAlgorithmInput
    public /* bridge */ /* synthetic */ Object getInput() {
        return getInput();
    }

    @Override // com.bytedance.byted_bach_sdk.input.BachAlgorithmInput
    public HashMap getInput() {
        return this.m_mapInput;
    }

    @Override // com.bytedance.byted_bach_sdk.input.BachAlgorithmInput
    public int getInputType() {
        return 3;
    }
}
