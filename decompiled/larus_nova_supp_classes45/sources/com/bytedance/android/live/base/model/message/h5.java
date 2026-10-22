package com.bytedance.android.live.base.model.message;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface h5 extends ITextPieceImage {
    @Override // com.bytedance.android.live.base.model.message.ITextPieceImage
    /* synthetic */ vh7.e castTo(Class r1);

    @Override // com.bytedance.android.live.base.model.message.ITextPieceImage
    /* synthetic */ vh7.e castToOrNull(Class r1);

    @Override // com.bytedance.android.live.base.model.message.ITextPieceImage
    /* synthetic */ ITextPieceImage doClone();

    @Override // com.bytedance.android.live.base.model.message.ITextPieceImage
    /* synthetic */ boolean getEnableTextWhenFailed();

    @Override // com.bytedance.android.live.base.model.message.ITextPieceImage
    /* synthetic */ ITextPieceImage.ExtraOpt getExtraOpt();

    @Override // com.bytedance.android.live.base.model.message.ITextPieceImage
    /* synthetic */ int getHeight();

    @Override // com.bytedance.android.live.base.model.message.ITextPieceImage
    /* synthetic */ py.k getImageModel();

    @Override // com.bytedance.android.live.base.model.message.ITextPieceImage
    /* synthetic */ int getLocalResId();

    @Override // com.bytedance.android.live.base.model.message.ITextPieceImage
    /* synthetic */ ITextPieceImage.ResourceType getResourceType();

    @Override // com.bytedance.android.live.base.model.message.ITextPieceImage
    /* synthetic */ ITextPieceImage.ScaleType getScaleType();

    @Override // com.bytedance.android.live.base.model.message.ITextPieceImage
    /* synthetic */ float getScaleX();

    @Override // com.bytedance.android.live.base.model.message.ITextPieceImage
    /* synthetic */ float getScaleY();

    @Override // com.bytedance.android.live.base.model.message.ITextPieceImage
    /* synthetic */ float getScalingRate();

    int getTextColor();

    String getTextContent();

    float getTextSizeRate();

    int getTextType();

    @Override // com.bytedance.android.live.base.model.message.ITextPieceImage
    /* synthetic */ int getWidth();

    @Override // com.bytedance.android.live.base.model.message.ITextPieceImage
    /* synthetic */ boolean isNeedExtraSpace();

    @Override // com.bytedance.android.live.base.model.message.ITextPieceImage
    /* synthetic */ void setEnableTextWhenFailed(boolean r1);

    @Override // com.bytedance.android.live.base.model.message.ITextPieceImage
    /* synthetic */ void setExtraOpt(ITextPieceImage.ExtraOpt r1);

    @Override // com.bytedance.android.live.base.model.message.ITextPieceImage
    /* synthetic */ void setHeight(int r1);

    @Override // com.bytedance.android.live.base.model.message.ITextPieceImage
    /* synthetic */ void setImageModel(py.k r1);

    @Override // com.bytedance.android.live.base.model.message.ITextPieceImage
    /* synthetic */ void setLocalResId(int r1);

    @Override // com.bytedance.android.live.base.model.message.ITextPieceImage
    /* synthetic */ void setNeedExtraSpace(boolean r1);

    @Override // com.bytedance.android.live.base.model.message.ITextPieceImage
    /* synthetic */ void setResourceType(ITextPieceImage.ResourceType r1);

    @Override // com.bytedance.android.live.base.model.message.ITextPieceImage
    /* synthetic */ void setScaleType(ITextPieceImage.ScaleType r1);

    @Override // com.bytedance.android.live.base.model.message.ITextPieceImage
    /* synthetic */ void setScaleX(float r1);

    @Override // com.bytedance.android.live.base.model.message.ITextPieceImage
    /* synthetic */ void setScaleY(float r1);

    @Override // com.bytedance.android.live.base.model.message.ITextPieceImage
    /* synthetic */ void setScalingRate(float r1);

    void setTextColor(int r1);

    void setTextContent(String r1);

    void setTextSizeRate(float r1);

    void setTextType(int r1);

    @Override // com.bytedance.android.live.base.model.message.ITextPieceImage
    /* synthetic */ void setWidth(int r1);
}
