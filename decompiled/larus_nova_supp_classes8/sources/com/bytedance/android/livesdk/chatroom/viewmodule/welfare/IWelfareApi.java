package com.bytedance.android.livesdk.chatroom.viewmodule.welfare;

import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.POST;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001JF\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\u00072\b\b\u0001\u0010\f\u001a\u00020\u0007H'J<\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\u000e\u001a\u00020\u000f2\b\b\u0001\u0010\u0010\u001a\u00020\u00072\b\b\u0001\u0010\u0011\u001a\u00020\u0007H'ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0012À\u0006\u0001"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/welfare/IWelfareApi;", "", "operateWelfareProject", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/Response;", "", "opType", "", "roomId", "anchorId", "", "projectId", "showFrequency", "reportWelfareClick", "scene", "", "timeStamp", LiveEndPageData.TAG_COUNT, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IWelfareApi {
    @FormUrlEncoded
    @POST("/webcast/room/welfare_project_operate/")
    Observable<Response<Unit>> operateWelfareProject(@Field("op_type") long r1, @Field("room_id") long r3, @Field("anchor_id") String r5, @Field("project_id") long r6, @Field("show_frequency") long r8);

    @FormUrlEncoded
    @POST("/webcast/room/welfare_report/")
    Observable<Response<Unit>> reportWelfareClick(@Field("room_id") long r1, @Field("scene_type") int r3, @Field("report_time") long r4, @Field(LiveEndPageData.TAG_COUNT) long r6);
}
