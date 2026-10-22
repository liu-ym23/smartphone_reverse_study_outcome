package com.bytedance.android.livesdk.chatroom.vs_base.base.api;

import am3.g;
import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode._Episode_ProtoDecoder;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.e;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001:\u0003\f\r\u000eJ(\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H'J2\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\n\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H'¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vs_base/base/api/ReplayInfoApi;", "", "", "roomId", "", "scene", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/Response;", "Lcom/bytedance/android/livesdk/chatroom/vs_base/base/api/ReplayInfoApi$EpisodeInfoResponseData;", "getReplayInfoByRoomId", "matchId", "getReplayInfoByRoomIdWithMatch", "EpisodeInfoResponseData", "a", "b", "vs-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ReplayInfoApi {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0015\u0010\u0016R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vs_base/base/api/ReplayInfoApi$EpisodeInfoResponseData;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/chatroom/vs_base/base/api/ReplayInfoApi$a;", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/Episode;", "episode", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/Episode;", "getEpisode", "()Lcom/bytedance/android/livesdkapi/depend/model/live/episode/Episode;", "setEpisode", "(Lcom/bytedance/android/livesdkapi/depend/model/live/episode/Episode;)V", "", "episodeList", "Ljava/util/List;", "getEpisodeList", "()Ljava/util/List;", "setEpisodeList", "(Ljava/util/List;)V", "", "getLongVideoId", "()Ljava/lang/Long;", "longVideoId", "<init>", "()V", "vs-base_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class EpisodeInfoResponseData extends FlexModelBase<a> implements a, h {

        @SerializedName("episode")
        protected Episode episode;

        @SerializedName("episodes")
        protected List<? extends Episode> episodeList;

        public EpisodeInfoResponseData() {
            super(a.class);
        }

        public EpisodeInfoResponseData(g r6) {
            super(a.class);
            this.episodeList = new ArrayList();
            setThreadSafe(false);
            long r0 = r6.c();
        L3:
            int r2 = r6.f();
            if (r2 == (-1)) goto L12;
            g.a r3 = decodeExtensionFields(r2, r6);
            if (r2 != 1) goto L8;
            this.episode = _Episode_ProtoDecoder.decodeStatic(r6);
            goto L3
        L8:
            if (r2 != 2) goto L9;
            this.episodeList.add(_Episode_ProtoDecoder.decodeStatic(r6));
            goto L3
        L9:
            am3.h.d(r3, r6);
            goto L3
        L12:
            r6.d(r0);
            setThreadSafe(true);
        }

        public final Long getLongVideoId() {
            b r0 = (b) castToOrNull(b.class);
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.getLongVideoId();
        }

        public final Episode getEpisode() {
            return this.episode;
        }

        public final List<Episode> getEpisodeList() {
            return this.episodeList;
        }

        public final void setEpisode(Episode r1) {
            this.episode = r1;
        }

        public final void setEpisodeList(List<? extends Episode> r1) {
            this.episodeList = r1;
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vs_base/base/api/ReplayInfoApi$a;", "Lvh7/c;", "vs-base_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface a extends vh7.c<a> {
        /* synthetic */ e castTo(Class r1);

        /* synthetic */ e castToOrNull(Class r1);
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002R$\u0010\n\u001a\u0004\u0018\u00010\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vs_base/base/api/ReplayInfoApi$b;", "Lvh7/e;", "Lcom/bytedance/android/livesdk/chatroom/vs_base/base/api/ReplayInfoApi$a;", "", "getLongVideoId", "()Ljava/lang/Long;", "setLongVideoId", "(Ljava/lang/Long;)V", "getLongVideoId$annotations", "()V", "longVideoId", "vs-base_saasRelease"}, k = 1, mv = {1, 4, 3})
    @ForMain
    public interface b extends e<a>, a {

        @JsonAdapter(FlexModelJsonAdapter.class)
        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
        public static final class a {
        }

        @Override // com.bytedance.android.livesdk.chatroom.vs_base.base.api.ReplayInfoApi.a
        /* synthetic */ e castTo(Class r1);

        @Override // com.bytedance.android.livesdk.chatroom.vs_base.base.api.ReplayInfoApi.a
        /* synthetic */ e castToOrNull(Class r1);

        /* synthetic */ Object getFlexInstance();

        @FieldName(name = "lvideo_item_id")
        Long getLongVideoId();

        @FieldName(name = "lvideo_item_id#setter")
        void setLongVideoId(Long r1);
    }

    @GET("/webcast/show/episode/room_to_replay/")
    Observable<Response<EpisodeInfoResponseData>> getReplayInfoByRoomId(@Query("room_id") long r1, @Query("scene") String r3);

    @GET("/webcast/show/episode/room_to_replay/")
    Observable<Response<EpisodeInfoResponseData>> getReplayInfoByRoomIdWithMatch(@Query("room_id") long r1, @Query("match_id") long r3, @Query("scene") String r5);
}
