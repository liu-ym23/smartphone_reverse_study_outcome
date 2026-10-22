package com.bytedance.byted_bach_sdk.input;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class BachBitmapInput implements BachAlgorithmInput {
    private Bitmap m_bitmap;

    @Override // com.bytedance.byted_bach_sdk.input.BachAlgorithmInput
    public int getInputType() {
        return 1;
    }

    @Override // com.bytedance.byted_bach_sdk.input.BachAlgorithmInput
    public /* bridge */ /* synthetic */ Object getInput() {
        return getInput();
    }

    @Override // com.bytedance.byted_bach_sdk.input.BachAlgorithmInput
    public Bitmap getInput() {
        return this.m_bitmap;
    }

    public BachBitmapInput(Bitmap r1) {
        this.m_bitmap = r1;
    }
}
