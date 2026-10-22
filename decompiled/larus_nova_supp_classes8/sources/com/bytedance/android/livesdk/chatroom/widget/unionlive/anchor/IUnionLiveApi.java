package com.bytedance.android.livesdk.chatroom.widget.unionlive.anchor;

import com.bytedance.android.live.network.response.Response;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\nJ(\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H'ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/widget/unionlive/anchor/IUnionLiveApi;", "", "", "anchorId", "", "RoomId", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/Response;", "Lcom/bytedance/android/livesdk/chatroom/widget/unionlive/anchor/a;", "getUnionLiveAccess", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IUnionLiveApi {
    public static final a a = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }
    }

    static {
        a = a.a;
    }

    @GET("/webcast/show/union_anchors/access/")
    Observable<Response<com.bytedance.android.livesdk.chatroom.widget.unionlive.anchor.a>> getUnionLiveAccess(@Query("anchor_uid") String r1, @Query("room_id") long r2);
}
