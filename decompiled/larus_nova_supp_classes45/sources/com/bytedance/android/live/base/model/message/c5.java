package com.bytedance.android.live.base.model.message;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public interface c5 extends vh7.c<c5>, d5 {
    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    b5 getFormat();

    e5 getGiftValue();

    f5 getHeartValue();

    ITextPieceImage getImageValue();

    g5 getPatternRefValue();

    String getRefKey();

    String getSchemaKey();

    String getStringValue();

    @Override // com.bytedance.android.live.base.model.message.d5
    int getType();

    i5 getUserValue();

    boolean isNormalPiece();

    void setFormat(b5 r1);

    void setGiftValue(e5 r1);

    void setHeartValue(f5 r1);

    void setImageValue(ITextPieceImage r1);

    void setNormalPiece(boolean r1);

    void setPatternRefValue(g5 r1);

    void setRefKey(String r1);

    void setSchemaKey(String r1);

    void setStringValue(String r1);

    void setType(int r1);

    void setUserValue(i5 r1);
}
