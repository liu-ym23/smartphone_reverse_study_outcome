package com.larus.business.debug.base.controller.advancedWhite;

import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0006H'¨\u0006\b"}, d2 = {"Lcom/larus/business/debug/base/controller/advancedWhite/AdvancedWhiteOpApi;", "", "opAdvancedSwitch", "Lio/reactivex/Observable;", "Lcom/larus/business/debug/base/controller/advancedWhite/OpAdvancedWhiteSwitchResponse;", "opType", "", "aid", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface AdvancedWhiteOpApi {
    @POST("/alice/user/op_advance")
    Observable<OpAdvancedWhiteSwitchResponse> opAdvancedSwitch(@Query("op_type") int r1, @Query("aid") int r2);
}
