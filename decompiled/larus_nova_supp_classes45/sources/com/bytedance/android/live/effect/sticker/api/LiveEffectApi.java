package com.bytedance.android.live.effect.sticker.api;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0002%&JB\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\n0\t0\b2\b\b\u0003\u0010\u0003\u001a\u00020\u00022\b\b\u0003\u0010\u0004\u001a\u00020\u00022\b\b\u0003\u0010\u0006\u001a\u00020\u00052\b\b\u0003\u0010\u0007\u001a\u00020\u0005H'JB\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\n0\t0\b2\b\b\u0001\u0010\f\u001a\u00020\u00022\b\b\u0001\u0010\r\u001a\u00020\u00052\b\b\u0001\u0010\u000e\u001a\u00020\u00052\b\b\u0001\u0010\u000f\u001a\u00020\u0005H'J$\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\n0\t0\b2\b\b\u0001\u0010\u0012\u001a\u00020\u0005H'J$\u0010\u0017\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\n0\t0\b2\b\b\u0001\u0010\u0015\u001a\u00020\u0005H'JB\u0010\u001b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\n0\t0\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0018\u001a\u00020\u00052\b\b\u0001\u0010\u0019\u001a\u00020\u00052\b\b\u0001\u0010\f\u001a\u00020\u0002H'JB\u0010\u001d\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\n0\t0\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0018\u001a\u00020\u00052\b\b\u0001\u0010\u0019\u001a\u00020\u00052\b\b\u0001\u0010\f\u001a\u00020\u0002H'JP\u0010$\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\n0\t0\b2\b\b\u0001\u0010\u001e\u001a\u00020\u00022\b\b\u0001\u0010\u001f\u001a\u00020\u00022\b\b\u0001\u0010 \u001a\u00020\u00022\n\b\u0001\u0010!\u001a\u0004\u0018\u00010\u00052\n\b\u0001\u0010\"\u001a\u0004\u0018\u00010\u0005H'¨\u0006'"}, d2 = {"Lcom/bytedance/android/live/effect/sticker/api/LiveEffectApi;", "", "", "roomID", "type", "", "panel", "stickerInfoMapJson", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/BaseResponse;", "Lcom/bytedance/android/live/base/model/Extra;", "updateAnchorEffectStatus", "effectID", "prompt", "modelPrompt", "modelReqKey", "Lcom/bytedance/android/live/effect/sticker/api/CommitAigcBackgroundImageGenerateTaskResponse;", "commitAigcBackgroundImageGenerateTask", "taskIDList", "Lcom/bytedance/android/live/effect/sticker/api/CheckAigcBackgroundImageGenerateTaskByTaskIDResponse;", "checkAigcBackgroundImageGenerateTaskByTaskID", "effectIDList", "Lcom/bytedance/android/live/effect/sticker/api/CheckAigcBackgroundImageGenerateTaskListByEffectIDResponse;", "checkAigcBackgroundImageGenerateTaskListByEffectID", "anchorID", "rules", "Lcom/bytedance/android/live/effect/sticker/api/NotifyInteractStickerInUseResponse;", "notifyInteractStickerInUse", "Lcom/bytedance/android/live/effect/sticker/api/GetInteractStickerInfoResponse;", "getInteractStickerInfo", "roomId", "transferType", "materialId", "layerMap", "clientPresetParam", "Lcom/bytedance/android/live/effect/sticker/api/a;", "vrTransferMaterialUpdate", "AigcTaskStatus", "UpdateAnchorEffectStatusType", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface LiveEffectApi {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/effect/sticker/api/LiveEffectApi$AigcTaskStatus;", "", "", "value", "I", "getValue", "()I", "RUNNING", "FINISH", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum AigcTaskStatus extends Enum<AigcTaskStatus> {
        public static final AigcTaskStatus FINISH = null;
        public static final AigcTaskStatus RUNNING = null;
        public static final /* synthetic */ AigcTaskStatus[] a = null;
        private final int value;

        static {
            AigcTaskStatus r2 = new AigcTaskStatus("RUNNING", 0, 1);
            RUNNING = r2;
            AigcTaskStatus r3 = new AigcTaskStatus("FINISH", 1, 2);
            FINISH = r3;
            a = new AigcTaskStatus[]{r2, r3};
        }

        public static AigcTaskStatus valueOf(String r1) {
            return (AigcTaskStatus) r27.a.a(AigcTaskStatus.class, r1);
        }

        public static AigcTaskStatus[] values() {
            return (AigcTaskStatus[]) a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public AigcTaskStatus(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\t\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/effect/sticker/api/LiveEffectApi$UpdateAnchorEffectStatusType;", "", "", "value", "J", "getValue", "()J", "UPDATE", "RESET", "OVERRIDE", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum UpdateAnchorEffectStatusType extends Enum<UpdateAnchorEffectStatusType> {
        public static final UpdateAnchorEffectStatusType OVERRIDE = null;
        public static final UpdateAnchorEffectStatusType RESET = null;
        public static final UpdateAnchorEffectStatusType UPDATE = null;
        public static final /* synthetic */ UpdateAnchorEffectStatusType[] a = null;
        private final long value;

        static {
            UpdateAnchorEffectStatusType r1 = new UpdateAnchorEffectStatusType("UPDATE", 0, 1);
            UPDATE = r1;
            UpdateAnchorEffectStatusType r2 = new UpdateAnchorEffectStatusType("RESET", 1, 2);
            RESET = r2;
            UpdateAnchorEffectStatusType r3 = new UpdateAnchorEffectStatusType("OVERRIDE", 2, 3);
            OVERRIDE = r3;
            a = new UpdateAnchorEffectStatusType[]{r1, r2, r3};
        }

        public static UpdateAnchorEffectStatusType valueOf(String r1) {
            return (UpdateAnchorEffectStatusType) r27.a.a(UpdateAnchorEffectStatusType.class, r1);
        }

        public static UpdateAnchorEffectStatusType[] values() {
            return (UpdateAnchorEffectStatusType[]) a.clone();
        }

        public final long getValue() {
            return this.value;
        }

        public UpdateAnchorEffectStatusType(String r1, int r2, long r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @POST("/webcast/room/aigc_effect_background/task/check")
    Observable<BaseResponse<CheckAigcBackgroundImageGenerateTaskByTaskIDResponse, Extra>> checkAigcBackgroundImageGenerateTaskByTaskID(@Query("task_id") String r1);

    @POST("/webcast/room/aigc_effect_background/task/list")
    Observable<BaseResponse<CheckAigcBackgroundImageGenerateTaskListByEffectIDResponse, Extra>> checkAigcBackgroundImageGenerateTaskListByEffectID(@Query("effect_id") String r1);

    @POST("/webcast/room/aigc_effect_background/task/generate")
    Observable<BaseResponse<CommitAigcBackgroundImageGenerateTaskResponse, Extra>> commitAigcBackgroundImageGenerateTask(@Query("effect_id") long r1, @Query("prompt") String r3, @Query("prompt_model") String r4, @Query("req_key") String r5);

    @POST("/webcast/room/interact_effect/query/")
    Observable<BaseResponse<GetInteractStickerInfoResponse, Extra>> getInteractStickerInfo(@Query("room_id") long r1, @Query("anchor_id") String r3, @Query("rules") String r4, @Query("effect_id") long r5);

    @POST("/webcast/room/interact_effect/init/")
    Observable<BaseResponse<NotifyInteractStickerInUseResponse, Extra>> notifyInteractStickerInUse(@Query("room_id") long r1, @Query("anchor_id") String r3, @Query("rules") String r4, @Query("effect_id") long r5);

    @POST("/webcast/room/interact_effect/update/")
    Observable<BaseResponse<Object, Extra>> updateAnchorEffectStatus(@Query("room_id") long r1, @Query("type") long r3, @Query("panel") String r5, @Query("stickers") String r6);

    @POST("/webcast/room/vrtransfer/material/update/")
    Observable<BaseResponse<a, Extra>> vrTransferMaterialUpdate(@Query("room_id") long r1, @Query("transfer_type") long r3, @Query("material_id") long r5, @Query("layer_map") String r7, @Query("client_preset_param") String r8);
}
