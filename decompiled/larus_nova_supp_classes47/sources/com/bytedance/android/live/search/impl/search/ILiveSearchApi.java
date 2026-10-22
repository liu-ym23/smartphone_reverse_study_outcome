package com.bytedance.android.live.search.impl.search;

import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import com.bytedance.retrofit2.http.Url;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J.\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0002H'Jj\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\n\u001a\u00020\t2\b\b\u0001\u0010\u000b\u001a\u00020\u00022\b\b\u0001\u0010\r\u001a\u00020\f2\b\b\u0001\u0010\u0005\u001a\u00020\u00022\b\b\u0001\u0010\u000e\u001a\u00020\u00022\b\b\u0001\u0010\u000f\u001a\u00020\u00022\b\b\u0001\u0010\u0010\u001a\u00020\u00022\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u0002H'¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/search/impl/search/ILiveSearchApi;", "", "", "url", "keywords", "source", "Lio/reactivex/Observable;", "Lra1/h;", "getSugList", "", "offset", "keyword", "", "count", "channel", "searchId", "needPersonalRecommend", "bcmChain", "Lra1/e;", "searchLiveList", "livesearchimpl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveSearchApi {
    @GET
    Observable<ra1.h> getSugList(@Url String r1, @Query("keyword") String r2, @Query("source") String r3);

    @GET
    Observable<ra1.e> searchLiveList(@Url String r1, @Query("offset") long r2, @Query("keyword") String r4, @Query("count") int r5, @Query("search_source") String r6, @Query("search_channel") String r7, @Query("search_id") String r8, @Query("need_personal_recommend") String r9, @Query("bcm_chain") String r10);
}
