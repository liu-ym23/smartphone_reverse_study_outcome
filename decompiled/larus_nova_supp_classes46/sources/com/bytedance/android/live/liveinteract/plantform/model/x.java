package com.bytedance.android.live.liveinteract.plantform.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public interface x extends vh7.c<x> {
    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "ecom_view_tag")
    py.k getEcomViewTag();
}
