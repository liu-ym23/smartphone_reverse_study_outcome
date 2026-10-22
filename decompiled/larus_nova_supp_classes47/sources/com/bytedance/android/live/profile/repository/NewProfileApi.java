package com.bytedance.android.live.profile.repository;

import com.bytedance.android.live.base.model.user.MyLiveTabData;
import com.bytedance.android.live.base.model.user.UserProfileDataResp;
import com.bytedance.android.live.base.model.user.g;
import com.bytedance.android.live.base.model.user.r0;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.network.response.e;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import com.bytedance.retrofit2.http.QueryMap;
import com.bytedance.retrofit2.http.Url;
import io.reactivex.Single;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface NewProfileApi {
    @GET("/webcast/user/setting/")
    Single<Response<g>> getSetting(@Query("sec_target_uid") String r1, @Query("room_id") long r2, @Query("anchor_id") long r4);

    @GET
    Single<BaseResponse<UserProfileDataResp, UserProfileDataResp.UserProfileExtra>> mockQuery(@Url String r1, @Query("codeID") String r2);

    @POST("/webcast/openapi/user/setting/")
    Single<Response<r0>> postOpenSetting(@Query("user_id") long r1, @Query("has_profile_style") long r3, @Query("profile_style") long r5, @Query("has_profile_style_smart_switch") long r7, @Query("profile_style_smart_switch") long r9);

    @POST("/webcast/user/setting/")
    Single<Response<r0>> postSetting(@Query("user_id") long r1, @Query("has_profile_style") long r3, @Query("profile_style") long r5, @Query("has_profile_style_smart_switch") long r7, @Query("profile_style_smart_switch") long r9);

    @FormUrlEncoded
    @POST("/webcast/user/setting/")
    Single<Response<r0>> postSetting(@Field("user_id") long r1, @Field("has_profile_style") long r3, @Field("profile_style") long r5, @Field("room_id") long r7, @Field("anchor_id") long r9, @Field("has_user_gift_switch") long r12, @Field("user_gift_switch") long r13);

    @GET("/webcast/user/setting/")
    Single<e<r0>> queryAnchorStickerStatus(@Query("sec_target_uid") String r1, @Query("anchor_id") long r2, @Query("scene") String r4);

    @GET("/webcast/user/setting/")
    Single<e<r0>> queryAnchorStickerStatusForSaas(@Query("anchor_open_id") String r1, @Query("target_open_id") String r2, @Query("scene") String r3);

    @GET("/webcast/user/my_live_tab/")
    Single<e<MyLiveTabData>> queryMoreTabsInfo(@Query("biz_name") String r1, @Query("query_index") long r2);

    @GET("/webcast/user/my_live/")
    Single<BaseResponse<UserProfileDataResp, UserProfileDataResp.UserProfileExtra>> queryMyLiveProfile(@Query("sec_target_uid") String r1, @Query("sec_anchor_id") String r2, @Query("current_room_id") long r3, @Query("target_identity") long r5, @Query("target_display_role") int r7, @Query("msg_id") long r8, @Query("user_scene") int r10, @Query("has_profile_style") long r12, @Query("profile_style") int r13, @Query("view_key") String r14, @Query("has_smart_switch") long r15, @Query("smart_switch") long r17, @Query("special_scene") long r19, @Query("shop_entrance_product_ids") String r22, @Query("optimize_identity") long r23, @Query("ecom_dsl_identity") long r24, @Query("click_source") String r26, @QueryMap Map<String, Object> r27, @Query("is_my_live") boolean r28);

    @GET("/webcast/openapi/user/profile/preload/")
    Single<BaseResponse<UserProfileDataResp, UserProfileDataResp.UserProfileExtra>> queryOpenPreloadProfile(@Query("target_uid") long r1, @Query("sec_target_uid") String r3, @Query("anchor_id") long r4, @Query("sec_anchor_id") String r6, @Query("current_room_id") long r7, @Query("user_id") long r9, @Query("target_identity") long r12, @Query("target_display_role") int r13, @Query("msg_id") long r14, @Query("user_scene") int r16, @Query("has_profile_style") long r17, @Query("profile_style") int r19, @Query("view_key") String r20, @Query("has_smart_switch") long r22, @Query("smart_switch") long r23, @Query("special_scene") long r25, @Query("shop_entrance_product_ids") String r27, @Query("optimize_identity") long r28, @Query("ecom_dsl_identity") long r30, @Query("click_source") String r32, @Query("is_my_live") boolean r33);

    @GET("/webcast/openapi/v2/user/profile/")
    Single<BaseResponse<UserProfileDataResp, UserProfileDataResp.UserProfileExtra>> queryOpenProfile(@Query("sec_target_uid") String r1, @Query("sec_anchor_id") String r2, @Query("current_room_id") long r3, @Query("target_identity") long r5, @Query("target_display_role") int r7, @Query("msg_id") long r8, @Query("user_scene") int r10, @Query("has_profile_style") long r12, @Query("profile_style") int r13, @Query("view_key") String r14, @Query("has_smart_switch") long r15, @Query("smart_switch") long r17, @Query("special_scene") long r19, @Query("shop_entrance_product_ids") String r22, @Query("optimize_identity") long r23, @Query("ecom_dsl_identity") long r24, @Query("click_source") String r26, @QueryMap Map<String, Object> r27, @Query("is_my_live") boolean r28, @Query("current_identity") long r29);

    @GET("/webcast/user/profile/preload/")
    Single<BaseResponse<UserProfileDataResp, UserProfileDataResp.UserProfileExtra>> queryPreloadProfile(@Query("target_uid") long r1, @Query("sec_target_uid") String r3, @Query("anchor_id") long r4, @Query("sec_anchor_id") String r6, @Query("current_room_id") long r7, @Query("user_id") long r9, @Query("target_identity") long r12, @Query("target_display_role") int r13, @Query("msg_id") long r14, @Query("user_scene") int r16, @Query("has_profile_style") long r17, @Query("profile_style") int r19, @Query("view_key") String r20, @Query("has_smart_switch") long r22, @Query("smart_switch") long r23, @Query("special_scene") long r25, @Query("shop_entrance_product_ids") String r27, @Query("optimize_identity") long r28, @Query("ecom_dsl_identity") long r30, @Query("click_source") String r32, @Query("is_my_live") boolean r33);

    @GET("/webcast/user/profile/")
    Single<BaseResponse<UserProfileDataResp, UserProfileDataResp.UserProfileExtra>> queryProfile(@Query("sec_target_uid") String r1, @Query("sec_anchor_id") String r2, @Query("current_room_id") long r3, @Query("target_identity") long r5, @Query("target_display_role") int r7, @Query("msg_id") long r8, @Query("user_scene") int r10, @Query("has_profile_style") long r12, @Query("profile_style") int r13, @Query("view_key") String r14, @Query("has_smart_switch") long r15, @Query("smart_switch") long r17, @Query("special_scene") long r19, @Query("shop_entrance_product_ids") String r22, @Query("optimize_identity") long r23, @Query("ecom_dsl_identity") long r24, @Query("click_source") String r26, @QueryMap Map<String, Object> r27, @Query("is_my_live") boolean r28, @Query("current_identity") long r29);

    @FormUrlEncoded
    @POST("/webcast/user/setting/")
    Single<Response<r0>> updateAnchorUserRelationSwitch(@Field("user_id") long r1, @Field("room_id") long r3, @Field("anchor_id") long r5, @Field("has_anchor_user_relation_switch") long r7, @Field("anchor_user_relation_switch") long r9);

    @POST("/webcast/user/setting/")
    Single<e<r0>> uploadAnchorStickerStatus(@Query("anchor_id") long r1, @Query("has_face_gift_switch") long r3, @Query("face_gift_switch") long r5, @Query("scene") String r7);

    @POST("/webcast/user/setting/")
    Single<e<r0>> uploadAnchorStickerStatusForSaas(@Query("anchor_open_id") String r1, @Query("has_face_gift_switch") long r2, @Query("face_gift_switch") long r4, @Query("scene") String r6);
}
