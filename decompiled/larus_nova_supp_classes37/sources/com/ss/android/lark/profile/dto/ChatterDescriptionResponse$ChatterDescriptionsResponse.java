package com.ss.android.lark.profile.dto;

import com.ss.android.lark.profile.entity.ChatterDescription;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class ChatterDescriptionResponse$ChatterDescriptionsResponse implements Serializable {
    public List<ChatterDescription> descriptions;
    public boolean hasMore;

    public ChatterDescriptionResponse$ChatterDescriptionsResponse(List<ChatterDescription> r1, boolean r2) {
        this.descriptions = r1;
        this.hasMore = r2;
    }
}
