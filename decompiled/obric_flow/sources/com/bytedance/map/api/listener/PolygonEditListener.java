package com.bytedance.map.api.listener;

import com.bytedance.map.api.model.IPolygon;

/* JADX INFO: loaded from: classes2.dex */
public interface PolygonEditListener {
    void onEdit(IPolygon r5);

    void onEditEnd(IPolygon r5);

    void onEditStart(IPolygon r5);
}
