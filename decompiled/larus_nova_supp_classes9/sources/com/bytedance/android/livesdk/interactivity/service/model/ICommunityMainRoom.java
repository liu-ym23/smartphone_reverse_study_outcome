package com.bytedance.android.livesdk.interactivity.service.model;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.android.livesdkapi.depend.model.live.ClientComponent;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomGameData;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomPlatformComponentsData;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0001\u0014R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\u001c\u0010\r\u001a\u0004\u0018\u00010\t8&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0007\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u000e8&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0007\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/service/model/ICommunityMainRoom;", "Lvh7/e;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomPlatformComponentsData;", "getRoomPlatformComponentsData", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomPlatformComponentsData;", "getRoomPlatformComponentsData$annotations", "()V", "roomPlatformComponentsData", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomGameData;", "getRoomGameData", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomGameData;", "getRoomGameData$annotations", "roomGameData", "Lcom/bytedance/android/livesdkapi/depend/model/live/ClientComponent;", "getClientComponentData", "()Lcom/bytedance/android/livesdkapi/depend/model/live/ClientComponent;", "getClientComponentData$annotations", "clientComponentData", "Companion", "a", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
@ForMain
public interface ICommunityMainRoom extends vh7.e<IRoom>, IRoom {
    public static final a Companion = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class b {
    }

    static {
        Companion = a.a;
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "client_component_data")
    ClientComponent getClientComponentData();

    /* synthetic */ Object getFlexInstance();

    @FieldName(name = "game_data")
    IRoomGameData getRoomGameData();

    @FieldName(name = "platform_components_data")
    IRoomPlatformComponentsData getRoomPlatformComponentsData();
}
