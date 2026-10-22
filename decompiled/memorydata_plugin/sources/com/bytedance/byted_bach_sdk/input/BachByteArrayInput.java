package com.bytedance.byted_bach_sdk.input;

/* JADX INFO: loaded from: classes.dex */
public class BachByteArrayInput implements BachAlgorithmInput {
    private byte[] data;
    private int format;
    private int height;
    private int width;

    public BachByteArrayInput(byte[] r2, int r3, int r4) {
        this(r2, r3, r4, 0);
    }

    public BachByteArrayInput(byte[] r1, int r2, int r3, int r4) {
        this.data = r1;
        this.width = r2;
        this.height = r3;
        this.format = r4;
    }

    @Override // com.bytedance.byted_bach_sdk.input.BachAlgorithmInput
    public /* bridge */ /* synthetic */ Object getInput() {
        return getInput();
    }

    @Override // com.bytedance.byted_bach_sdk.input.BachAlgorithmInput
    public byte[] getInput() {
        return this.data;
    }

    @Override // com.bytedance.byted_bach_sdk.input.BachAlgorithmInput
    public int getInputType() {
        return 4;
    }
}
