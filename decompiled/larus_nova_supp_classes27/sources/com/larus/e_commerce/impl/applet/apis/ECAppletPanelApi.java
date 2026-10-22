package com.larus.e_commerce.impl.applet.apis;

import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.QueryMap;
import com.bytedance.retrofit2.http.Url;
import io.reactivex.Observable;
import java.util.Map;
import kotlin.Metadata;
import q89.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\bf\u0018\u0000 \t2\u00020\u0001:\u0001\tJ0\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0014\b\u0001\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\bH'¨\u0006\n"}, d2 = {"Lcom/larus/e_commerce/impl/applet/apis/ECAppletPanelApi;", "", "fetchPanelData", "Lio/reactivex/Observable;", "Lcom/larus/e_commerce/impl/applet/model/ECAppletPanelResponse;", "url", "", "query", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ECAppletPanelApi {
    @GET
    Observable<c> fetchPanelData(@Url String r1, @QueryMap Map<String, String> r2);
}
