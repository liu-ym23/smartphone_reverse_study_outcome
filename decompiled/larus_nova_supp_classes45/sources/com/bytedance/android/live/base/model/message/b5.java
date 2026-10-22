package com.bytedance.android.live.base.model.message;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public interface b5 extends vh7.c<b5> {
    public static final int BOLD = 700;

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    boolean enableColorMapping();

    String getColor();

    int getFontSize();

    /* synthetic */ boolean getIgnoreColorMapping();

    /* synthetic */ boolean getItalic();

    /* synthetic */ boolean getUseHeighLight();

    /* synthetic */ boolean getUseRemoteColor();

    int getWeight();

    boolean isItalic();

    boolean isUseHeighLight();

    boolean isUseRemoteColor();

    void setColor(String r1);

    void setFontSize(int r1);

    void setUseRemoteColor(boolean r1);

    void setWeight(int r1);
}
