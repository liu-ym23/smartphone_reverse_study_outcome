package com.bytedance.android.live.ktv.common.api;

import com.bytedance.android.live.ktv.common.model.api.a0;
import com.bytedance.android.live.ktv.common.model.api.b0;
import com.bytedance.android.live.ktv.common.model.api.f;
import com.bytedance.android.live.ktv.common.model.api.j;
import com.bytedance.android.live.ktv.common.model.api.k;
import com.bytedance.android.live.ktv.common.model.api.m;
import com.bytedance.android.live.ktv.common.model.api.o;
import com.bytedance.android.live.ktv.common.model.api.p0;
import com.bytedance.android.live.ktv.common.model.api.t0;
import com.bytedance.android.live.ktv.common.model.api.z;
import com.bytedance.android.live.ktv.common.model.bean.c;
import com.bytedance.android.live.network.response.e;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import io.reactivex.Single;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001QJ\u0014\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H'J(\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00030\u00022\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\bH'J2\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00030\u00022\b\b\u0001\u0010\r\u001a\u00020\f2\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\bH'J|\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00030\u00022\b\b\u0001\u0010\u0010\u001a\u00020\f2\b\b\u0003\u0010\u0011\u001a\u00020\u00062\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\u0013\u001a\u00020\b2\b\b\u0001\u0010\u0014\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\u0015\u001a\u00020\f2\b\b\u0001\u0010\u0016\u001a\u00020\b2\n\b\u0001\u0010\u0017\u001a\u0004\u0018\u00010\fH'J;\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u00030\u00022\b\b\u0001\u0010\u0007\u001a\u00020\u00062\n\b\u0003\u0010\u001a\u001a\u0004\u0018\u00010\b2\b\b\u0001\u0010\t\u001a\u00020\bH'¢\u0006\u0004\b\u001c\u0010\u001dJ}\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u00030\u00022\b\b\u0001\u0010\u0007\u001a\u00020\u00062\n\b\u0001\u0010\u001e\u001a\u0004\u0018\u00010\f2\b\b\u0001\u0010\u001f\u001a\u00020\b2\b\b\u0001\u0010\u0014\u001a\u00020\b2\n\b\u0003\u0010 \u001a\u0004\u0018\u00010\f2\b\b\u0001\u0010\t\u001a\u00020\b2\b\b\u0003\u0010!\u001a\u00020\u00062\n\b\u0003\u0010\"\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\fH'¢\u0006\u0004\b$\u0010%J\"\u0010)\u001a\b\u0012\u0004\u0012\u00020(0\u00022\b\b\u0001\u0010&\u001a\u00020\u00062\b\b\u0001\u0010'\u001a\u00020\bH'J\"\u0010*\u001a\b\u0012\u0004\u0012\u00020(0\u00022\b\b\u0001\u0010&\u001a\u00020\u00062\b\b\u0001\u0010'\u001a\u00020\bH'Jf\u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002000\u00030\u00022\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010+\u001a\u00020\u00062\b\b\u0001\u0010&\u001a\u00020\u00062\b\b\u0001\u0010'\u001a\u00020\b2\b\b\u0001\u0010,\u001a\u00020\f2\b\b\u0001\u0010-\u001a\u00020\f2\b\b\u0003\u0010.\u001a\u00020\f2\n\b\u0003\u0010/\u001a\u0004\u0018\u00010\fH'JJ\u00104\u001a\b\u0012\u0004\u0012\u00020(0\u00022\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010+\u001a\u00020\u00062\b\b\u0001\u0010&\u001a\u00020\u00062\b\b\u0001\u00102\u001a\u00020\u00062\b\b\u0001\u00103\u001a\u00020\f2\b\b\u0001\u0010'\u001a\u00020\bH'J^\u00108\u001a\b\u0012\u0004\u0012\u00020(0\u00022\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010+\u001a\u00020\u00062\b\b\u0001\u0010&\u001a\u00020\u00062\b\b\u0001\u00102\u001a\u00020\u00062\b\b\u0001\u00103\u001a\u00020\f2\b\b\u0001\u00106\u001a\u0002052\b\b\u0001\u0010'\u001a\u00020\b2\b\b\u0001\u00107\u001a\u00020\bH'JF\u0010>\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020=0\u00030\u00022\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u00109\u001a\u00020\f2\b\b\u0001\u0010:\u001a\u00020\u00062\b\b\u0001\u0010;\u001a\u00020\f2\b\b\u0001\u0010<\u001a\u000205H'J2\u0010C\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020B0\u00030\u00022\b\b\u0001\u0010?\u001a\u00020\f2\b\b\u0001\u0010@\u001a\u00020\u00062\b\b\u0001\u0010A\u001a\u00020\u0006H'J2\u0010F\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020E0\u00030\u00022\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010D\u001a\u00020\f2\b\b\u0001\u0010A\u001a\u00020\u0006H'JU\u0010K\u001a\b\u0012\u0004\u0012\u00020(0\u00022\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010&\u001a\u00020\f2\b\b\u0001\u0010G\u001a\u0002052\n\b\u0001\u0010H\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010I\u001a\u0004\u0018\u00010\u00062\b\b\u0001\u0010J\u001a\u00020\bH'¢\u0006\u0004\bK\u0010LJ(\u0010P\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020O0\u00030N2\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010M\u001a\u00020\fH'¨\u0006R"}, d2 = {"Lcom/bytedance/android/live/ktv/common/api/KtvCommonApi;", "", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/e;", "Lcom/bytedance/android/live/ktv/common/model/bean/c;", "getTuningInfoList", "", "roomId", "", "mode", "Lcom/bytedance/android/live/ktv/common/model/api/a0;", "getHotWords", "", "keyword", "Lcom/bytedance/android/live/ktv/common/model/api/z;", "getSearchSug", "query", "anchorId", "anchorOpenId", "page", "count", "searchId", "querySource", "requiredSongInfo", "Lcom/bytedance/android/live/ktv/common/model/api/b0;", "searchSong", "firstLevelTab", "Lcom/bytedance/android/live/ktv/common/model/api/m;", "getTabList", "(JLjava/lang/Integer;I)Lio/reactivex/Observable;", "labelName", "offset", "query_id", "inplaceSongCollectionId", "topSongId", "Lcom/bytedance/android/live/ktv/common/model/api/k;", "getSongList", "(JLjava/lang/String;IILjava/lang/String;IJLjava/lang/Long;Ljava/lang/String;)Lio/reactivex/Observable;", "songId", "songType", "Lcom/bytedance/android/live/network/response/a;", "addFavorite", "delFavorite", "linkerId", "addSongSource", "artistIds", "coldStartSongSource", "songIdList", "Lcom/bytedance/android/live/ktv/common/model/api/p0;", "addSong", "toUserId", "toOpenId", "pinSong", "", "singCompleted", "removeSource", "removeSong", "wantListenCursor", "recommendListCursor", "queryId", "isFirstCall", "Lcom/bytedance/android/live/ktv/common/model/api/f;", "getListenSongList", "musicFeature", "type", "source", "Lcom/bytedance/android/live/ktv/common/model/api/t0;", "searchFingerprint", "singingFingerprints", "Lcom/bytedance/android/live/ktv/common/model/api/j;", "getSongInfo", "needRandomMv", "sameGroupIdV3", "simGroupIdV3", "mvPlayingStatus", "roomSongChanged", "(JLjava/lang/String;ZLjava/lang/Long;Ljava/lang/Long;I)Lio/reactivex/Observable;", "toUserIds", "Lio/reactivex/Single;", "Lcom/bytedance/android/live/ktv/common/model/api/o;", "groupLiveChorusInviteFriend", "Companion", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface KtvCommonApi {
    public static final Companion a = null;

    public static final class Companion {
        public static final /* synthetic */ Companion a = null;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/ktv/common/api/KtvCommonApi$Companion$QuerySource;", "", "Unknown", "SearchHistory", "UserInput", "SugWords", "HotWords", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
        public static final enum QuerySource extends Enum<QuerySource> {
            public static final QuerySource HotWords = null;
            public static final QuerySource SearchHistory = null;
            public static final QuerySource SugWords = null;
            public static final QuerySource Unknown = null;
            public static final QuerySource UserInput = null;
            public static final /* synthetic */ QuerySource[] a = null;

            static {
                QuerySource r1 = new QuerySource("Unknown", 0);
                Unknown = r1;
                QuerySource r2 = new QuerySource("SearchHistory", 1);
                SearchHistory = r2;
                QuerySource r3 = new QuerySource("UserInput", 2);
                UserInput = r3;
                QuerySource r4 = new QuerySource("SugWords", 3);
                SugWords = r4;
                QuerySource r5 = new QuerySource("HotWords", 4);
                HotWords = r5;
                a = new QuerySource[]{r1, r2, r3, r4, r5};
            }

            public static QuerySource valueOf(String r1) {
                return (QuerySource) a.a(QuerySource.class, r1);
            }

            public static QuerySource[] values() {
                return (QuerySource[]) a.clone();
            }

            public QuerySource(String r1, int r2) {
                super(r1, r2);
            }
        }

        public Companion() {
        }

        static {
            a = new Companion();
        }
    }

    static {
        a = Companion.a;
    }

    @POST("/webcast/interact/ktv/add_favorite/")
    Observable<com.bytedance.android.live.network.response.a> addFavorite(@Query("song_id") long r1, @Query("song_type") int r3);

    @FormUrlEncoded
    @POST("/webcast/linkmic_audience/ktv/add_song/")
    Observable<e<p0>> addSong(@Field("room_id") long r1, @Field("linker_id") long r3, @Field("song_id") long r5, @Field("song_type") int r7, @Field("add_song_source") String r8, @Field("artist_ids") String r9, @Field("cold_start_song_source") String r11, @Field("song_id_list") String r12);

    @POST("/webcast/interact/ktv/del_favorite/")
    Observable<com.bytedance.android.live.network.response.a> delFavorite(@Query("song_id") long r1, @Query("song_type") int r3);

    @GET("/webcast/interact/ktv/search/recommend/")
    Observable<e<a0>> getHotWords(@Query("room_id") long r1, @Query("mode") int r3);

    @GET("/webcast/ktv/get_listen_song_list/")
    Observable<e<f>> getListenSongList(@Query("room_id") long r1, @Query("want_listen_cursor") String r3, @Query("recommend_list_cursor") long r4, @Query("query_id") String r6, @Query("is_first_call") boolean r7);

    @GET("/webcast/interact/ktv/search/sug/")
    Observable<e<z>> getSearchSug(@Query("keyword") String r1, @Query("room_id") long r2, @Query("mode") int r4);

    @FormUrlEncoded
    @POST("/webcast/ktv/get_singing_song_info/")
    Observable<e<j>> getSongInfo(@Field("room_id") long r1, @Field("singing_fingerprints") String r3, @Field("source") long r4);

    @GET("/webcast/ktv/get_song_list/")
    Observable<e<k>> getSongList(@Query("room_id") long r1, @Query("tab_name") String r3, @Query("offset") int r4, @Query("count") int r5, @Query("query_id") String r6, @Query("mode") int r7, @Query("inplace_song_collection_id") long r8, @Query("top_song_id") Long r11, @Query("required_song_info") String r12);

    @GET("/webcast/ktv/get_tab_list/")
    Observable<e<m>> getTabList(@Query("room_id") long r1, @Query("first_level_tab") Integer r3, @Query("mode") int r4);

    @GET("/webcast/interact/ktv/get_tuning_info/")
    Observable<e<c>> getTuningInfoList();

    @GET("/webcast/ktv/group_chorus_invite/")
    Single<e<o>> groupLiveChorusInviteFriend(@Query("room_id") long r1, @Query("to_user_ids") String r3);

    @FormUrlEncoded
    @POST("/webcast/linkmic_audience/ktv/pin_song/")
    Observable<com.bytedance.android.live.network.response.a> pinSong(@Field("room_id") long r1, @Field("linker_id") long r3, @Field("song_id") long r5, @Field("to_user_id") long r7, @Field("to_open_id") String r9, @Field("song_type") int r11);

    @FormUrlEncoded
    @POST("/webcast/linkmic_audience/ktv/remove_song/")
    Observable<com.bytedance.android.live.network.response.a> removeSong(@Field("room_id") long r1, @Field("linker_id") long r3, @Field("song_id") long r5, @Field("to_user_id") long r7, @Field("to_open_id") String r9, @Field("sing_completed") boolean r11, @Field("song_type") int r12, @Field("remove_song_source") int r13);

    @FormUrlEncoded
    @POST("/webcast/linkmic_audience/room_song_change/")
    Observable<com.bytedance.android.live.network.response.a> roomSongChanged(@Field("room_id") long r1, @Field("song_id") String r3, @Field("need_random_mv") boolean r4, @Field("same_group_id") Long r5, @Field("sim_group_id") Long r6, @Field("mv_playing_status") int r7);

    @FormUrlEncoded
    @POST("/webcast/ktv/search_fingerprint/")
    Observable<e<t0>> searchFingerprint(@Field("music_feature") String r1, @Field("type") long r2, @Field("source") long r4);

    @GET("/webcast/interact/ktv/search_song/")
    Observable<e<b0>> searchSong(@Query("query") String r1, @Query("anchor_id") long r2, @Query("anchor_open_id") String r4, @Query("room_id") long r5, @Query("page") int r7, @Query("count") int r8, @Query("mode") int r9, @Query("search_id") String r11, @Query("query_source") int r12, @Query("required_song_info") String r13);
}
