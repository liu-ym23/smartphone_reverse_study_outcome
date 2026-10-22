package com.bytedance.byted_bach_sdk.input;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class BachByteBufferInput implements BachAlgorithmInput {
    private ByteBuffer data;
    private int format;
    private int height;
    private int width;

    public BachByteBufferInput(ByteBuffer r2, int r3, int r4) {
        this(r2, r3, r4, 0);
    }

    public BachByteBufferInput(ByteBuffer r1, int r2, int r3, int r4) {
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
    public ByteBuffer getInput() {
        return this.data;
    }

    @Override // com.bytedance.byted_bach_sdk.input.BachAlgorithmInput
    public int getInputType() {
        return 2;
    }
}
