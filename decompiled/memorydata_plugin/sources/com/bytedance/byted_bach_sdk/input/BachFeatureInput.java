package com.bytedance.byted_bach_sdk.input;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class BachFeatureInput implements BachAlgorithmInput {
    public static final int FEATURE_TYPE_FACE_CLUSTER = 1;
    public static final int FEATURE_TYPE_SIMILARITY = 0;
    private List<byte[]> m_byte_features;
    private int m_feature_type;
    private List<float[]> m_float_features;

    public BachFeatureInput(List<?> r3, int r4) {
        List<byte[]> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.m_feature_type = 0;
        if (r4 != 1) goto L5;
        this.m_float_features = r5;
        this.m_feature_type = 1;
        return;
    L5:
        if (r4 != 0) goto L9;
        this.m_byte_features = r5;
        this.m_feature_type = 0;
        return;
    }

    @Override // com.bytedance.byted_bach_sdk.input.BachAlgorithmInput
    public /* bridge */ /* synthetic */ Object getInput() {
        return getInput();
    }

    @Override // com.bytedance.byted_bach_sdk.input.BachAlgorithmInput
    public List<byte[]> getInput() {
        return this.m_byte_features;
    }

    @Override // com.bytedance.byted_bach_sdk.input.BachAlgorithmInput
    public int getInputType() {
        return 6;
    }
}
