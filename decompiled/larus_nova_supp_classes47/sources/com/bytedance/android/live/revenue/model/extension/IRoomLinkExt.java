package com.bytedance.android.live.revenue.model.extension;

import com.bytedance.android.livesdk.link.model.a9;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u00012\u00060\u0002j\u0002`\u0003R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\u000f\u001a\u00060\nj\u0002`\u000b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\b\u001a\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/revenue/model/extension/IRoomLinkExt;", "Lvh7/e;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomKt;", "Lcom/bytedance/android/livesdk/link/model/a9;", "getLinkMicInfo", "()Lcom/bytedance/android/livesdk/link/model/a9;", "getLinkMicInfo$annotations", "()V", "linkMicInfo", "", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "getMosaicStatus", "()J", "getMosaicStatus$annotations", "mosaicStatus", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IRoomLinkExt extends e<IRoom>, IRoom {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ e castTo(Class r1);

    /* synthetic */ e castToOrNull(Class r1);

    /* synthetic */ Object getFlexInstance();

    @FieldName(name = "link_mic")
    a9 getLinkMicInfo();

    @FieldName(name = "mosaic_status")
    long getMosaicStatus();
}
