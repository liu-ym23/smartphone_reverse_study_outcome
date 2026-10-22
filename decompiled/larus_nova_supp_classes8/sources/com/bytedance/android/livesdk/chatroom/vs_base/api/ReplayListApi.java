package com.bytedance.android.livesdk.chatroom.vs_base.api;

import am3.g;
import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.network.response.e;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeGroup;
import com.bytedance.android.livesdkapi.depend.model.live.episode.ReplayListExtra;
import com.bytedance.android.livesdkapi.depend.model.live.episode._EpisodeGroup_ProtoDecoder;
import com.bytedance.android.livesdkapi.depend.model.live.episode._Episode_ProtoDecoder;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import com.google.gson.annotations.SerializedName;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0003\u001c\u001d\u001eJ*\u0010\b\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0018\u00010\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u0002H'J\u0087\u0001\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u00052\b\b\u0001\u0010\t\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u000b\u001a\u00020\n2\b\b\u0001\u0010\f\u001a\u00020\u00022\b\b\u0001\u0010\u000e\u001a\u00020\r2\b\b\u0001\u0010\u000f\u001a\u00020\u00022\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u00102\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\r2\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b\u0016\u0010\u0017J2\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00140\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0018\u001a\u00020\u00022\b\b\u0001\u0010\u0019\u001a\u00020\u0002H'¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vs_base/api/ReplayListApi;", "", "", "roomId", "episodeId", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/Response;", "Lcom/bytedance/android/livesdk/chatroom/vs_base/api/ReplayListApi$ReplayListData;", "getReplayList", "seasonId", "", "reverse", "cursor", "", "pageSize", "relation_type", "", "uid", "openId", "seasonType", "Lcom/bytedance/android/live/network/response/e;", "Lcom/bytedance/android/livesdk/chatroom/vs_base/api/ReplayListApi$GetMoreReplayListResponse;", "getMorePlayList", "(JJZJIJLjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;)Lio/reactivex/Observable;", "ticketId", "parentTicketId", "Lcom/bytedance/android/livesdk/chatroom/vs_base/api/ReplayListApi$a;", "getSeriesReplayList", "GetMoreReplayListResponse", "a", "ReplayListData", "vs-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ReplayListApi {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R&\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR \u0010\u001d\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vs_base/api/ReplayListApi$GetMoreReplayListResponse;", "", "()V", "cursor", "", "getCursor", "()Ljava/lang/Long;", "setCursor", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "extra", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/ReplayListExtra;", "getExtra", "()Lcom/bytedance/android/livesdkapi/depend/model/live/episode/ReplayListExtra;", "setExtra", "(Lcom/bytedance/android/livesdkapi/depend/model/live/episode/ReplayListExtra;)V", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "moreEpisodes", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/Episode;", "getMoreEpisodes", "()Ljava/util/List;", "setMoreEpisodes", "(Ljava/util/List;)V", "typeName", "", "getTypeName", "()Ljava/lang/String;", "setTypeName", "(Ljava/lang/String;)V", "vs-base_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class GetMoreReplayListResponse implements h {

        @SerializedName("cursor")
        protected Long cursor;

        @SerializedName("extra")
        protected ReplayListExtra extra;

        @SerializedName("has_more")
        protected boolean hasMore;

        @SerializedName("info_list")
        protected List<? extends Episode> moreEpisodes;

        @SerializedName("type_name")
        protected String typeName;

        public GetMoreReplayListResponse() {
            this.cursor = 0L;
        }

        public final Long getCursor() {
            return this.cursor;
        }

        public final ReplayListExtra getExtra() {
            return this.extra;
        }

        public final boolean getHasMore() {
            return this.hasMore;
        }

        public final List<Episode> getMoreEpisodes() {
            return this.moreEpisodes;
        }

        public final String getTypeName() {
            return this.typeName;
        }

        public GetMoreReplayListResponse(g r5) {
            this.moreEpisodes = new ArrayList();
            long r0 = r5.c();
        L3:
            int r2 = r5.f();
            if (r2 == (-1)) goto L21;
            if (r2 != 1) goto L8;
            this.typeName = am3.h.c(r5);
            goto L3
        L8:
            if (r2 != 2) goto L10;
            this.moreEpisodes.add(_Episode_ProtoDecoder.decodeStatic(r5));
            goto L3
        L10:
            if (r2 != 3) goto L12;
            this.hasMore = am3.h.a(r5);
            goto L3
        L12:
            if (r2 != 4) goto L14;
            this.cursor = Long.valueOf(r5.j());
            goto L3
        L14:
            if (r2 != 5) goto L15;
            this.extra = new ReplayListExtra(r5);
            goto L3
        L15:
            am3.h.e(r5);
            goto L3
        L21:
            r5.d(r0);
            if (this.cursor != null) goto L43;
            this.cursor = 0L;
            return;
        }

        public final void setCursor(Long r1) {
            this.cursor = r1;
        }

        public final void setExtra(ReplayListExtra r1) {
            this.extra = r1;
        }

        public final void setHasMore(boolean r1) {
            this.hasMore = r1;
        }

        public final void setMoreEpisodes(List<? extends Episode> r1) {
            this.moreEpisodes = r1;
        }

        public final void setTypeName(String r1) {
            this.typeName = r1;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vs_base/api/ReplayListApi$ReplayListData;", "", "()V", "allReplayGroup", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/EpisodeGroup;", "getAllReplayGroup", "()Ljava/util/List;", "setAllReplayGroup", "(Ljava/util/List;)V", "vs-base_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ReplayListData implements h {

        @SerializedName("all_replay")
        protected List<? extends EpisodeGroup> allReplayGroup;

        public ReplayListData() {
        }

        public ReplayListData(g r5) {
            this.allReplayGroup = new ArrayList();
            long r0 = r5.c();
        L3:
            int r2 = r5.f();
            if (r2 == (-1)) goto L9;
            if (r2 != 1) goto L7;
            this.allReplayGroup.add(_EpisodeGroup_ProtoDecoder.decodeStatic(r5));
            goto L3
        L7:
            am3.h.e(r5);
            goto L3
        L9:
            r5.d(r0);
        }

        public final List<EpisodeGroup> getAllReplayGroup() {
            return this.allReplayGroup;
        }

        public final void setAllReplayGroup(List<? extends EpisodeGroup> r1) {
            this.allReplayGroup = r1;
        }
    }

    @ForMain
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vs_base/api/ReplayListApi$a;", "", "", "Ln0;", "seriesReplayInfo", "Ljava/util/List;", "b", "()Ljava/util/List;", "setSeriesReplayInfo", "(Ljava/util/List;)V", "", "typeName", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setTypeName", "(Ljava/lang/String;)V", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/ReplayListExtra;", "extra", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/ReplayListExtra;", "a", "()Lcom/bytedance/android/livesdkapi/depend/model/live/episode/ReplayListExtra;", "setExtra", "(Lcom/bytedance/android/livesdkapi/depend/model/live/episode/ReplayListExtra;)V", "<init>", "()V", "vs-base_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a implements h {

        @SerializedName("extra")
        protected ReplayListExtra extra;

        @SerializedName("all_replay")
        protected List<n0> seriesReplayInfo;

        @SerializedName("type_name")
        protected String typeName;

        public a() {
            this.typeName = "";
        }

        public final ReplayListExtra a() {
            return this.extra;
        }

        public final List<n0> b() {
            return this.seriesReplayInfo;
        }

        public final String c() {
            return this.typeName;
        }

        public a(g r5) {
            this.seriesReplayInfo = new ArrayList();
            long r0 = r5.c();
        L3:
            int r2 = r5.f();
            if (r2 == (-1)) goto L15;
            if (r2 != 1) goto L8;
            this.seriesReplayInfo.add(new n0(r5));
            goto L3
        L8:
            if (r2 != 2) goto L10;
            this.typeName = am3.h.c(r5);
            goto L3
        L10:
            if (r2 != 3) goto L11;
            this.extra = new ReplayListExtra(r5);
            goto L3
        L11:
            am3.h.e(r5);
            goto L3
        L15:
            r5.d(r0);
            if (this.typeName != null) goto L31;
            this.typeName = "";
            return;
        }
    }

    @GET("/webcast/show/episode/more_replay/")
    Observable<e<GetMoreReplayListResponse>> getMorePlayList(@Query("season_id") long r1, @Query("episode_id") long r3, @Query("reverse") boolean r5, @Query("cursor") long r6, @Query("page_size") int r8, @Query("relation_type") long r9, @Query("uid") String r11, @Query("open_id") String r12, @Query("season_type") Integer r13, @Query("room_id") Long r14);

    @GET("/webcast/show/episode/replay_list/")
    Observable<Response<ReplayListData>> getReplayList(@Query("room_id") long r1, @Query("episode_id") long r3);

    @GET("/webcast/show/episode/series_replay_list/")
    Observable<e<a>> getSeriesReplayList(@Query("room_id") long r1, @Query("ticket_id") long r3, @Query("parent_ticket_id") long r5);
}
