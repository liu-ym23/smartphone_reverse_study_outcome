package com.bytedance.android.livesdk.interactivity.api.anchorsetting;

import com.bytedance.android.live.network.response.Response;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.POST;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J>\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\b2\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u000bH'¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/anchorsetting/AudioCommentApi;", BuildConfig.FLAVOR, "updateAudioChatSwitch", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/Response;", "roomId", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "switch", "extra", BuildConfig.FLAVOR, "interactivity-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface AudioCommentApi {

    public static final class a {
        public static /* synthetic */ Observable a(AudioCommentApi r6, long r7, int r9, int r10) {
            return r6.updateAudioChatSwitch(r7, r9, r10, null);
        }
    }

    @FormUrlEncoded
    @POST("/webcast/room/audio_chat_setting_set/")
    Observable<Response<Object>> updateAudioChatSwitch(@Field("room_id") long r1, @Field("action") int r3, @Field("chat_switch") int r4, @Field("extra") String r5);
}
