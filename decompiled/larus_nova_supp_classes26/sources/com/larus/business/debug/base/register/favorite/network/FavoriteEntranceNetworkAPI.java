package com.larus.business.debug.base.register.favorite.network;

import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.QueryMap;
import com.bytedance.retrofit2.http.Url;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.business.debug.base.register.favorite.network.bean.FavoriteEntranceGetResponse;
import com.larus.business.debug.base.register.favorite.network.bean.FavoriteEntranceUpdateRequestBean;
import com.larus.business.debug.base.register.favorite.network.bean.FavoriteEntranceUpdateResponseBean;
import io.reactivex.Observable;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0014\b\u0001\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\bH'J&\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u000bH'¨\u0006\f"}, d2 = {"Lcom/larus/business/debug/base/register/favorite/network/FavoriteEntranceNetworkAPI;", "", "getFavoriteEntrance", "Lio/reactivex/Observable;", "Lcom/larus/business/debug/base/register/favorite/network/bean/FavoriteEntranceGetResponse;", ShareType.URL, "", "params", "", "updateFavoriteEntrance", "Lcom/larus/business/debug/base/register/favorite/network/bean/FavoriteEntranceUpdateResponseBean;", "Lcom/larus/business/debug/base/register/favorite/network/bean/FavoriteEntranceUpdateRequestBean;", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface FavoriteEntranceNetworkAPI {
    @GET
    Observable<FavoriteEntranceGetResponse> getFavoriteEntrance(@Url String r1, @QueryMap Map<String, String> r2);

    @POST
    Observable<FavoriteEntranceUpdateResponseBean> updateFavoriteEntrance(@Url String r1, @Body FavoriteEntranceUpdateRequestBean r2);
}
