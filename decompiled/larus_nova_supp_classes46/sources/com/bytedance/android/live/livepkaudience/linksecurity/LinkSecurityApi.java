package com.bytedance.android.live.livepkaudience.linksecurity;

import com.bytedance.android.live.liveinteract.linksecurity.CheckAudienceLinkersResponse;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.network.response.e;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Single;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface LinkSecurityApi {

    public static final enum AudioCaptureType extends Enum<AudioCaptureType> {
        public static final AudioCaptureType AUDIO_CAPTURE_DEVICE_ING = null;
        public static final AudioCaptureType AUDIO_CAPTURE_DEVICE_NONE = null;
        public static final AudioCaptureType AUDIO_CAPTURE_DEVICE_UNKNOWN = null;
        public static final /* synthetic */ AudioCaptureType[] a = null;

        static {
            AudioCaptureType r0 = new AudioCaptureType("AUDIO_CAPTURE_DEVICE_UNKNOWN", 0);
            AUDIO_CAPTURE_DEVICE_UNKNOWN = r0;
            AudioCaptureType r1 = new AudioCaptureType("AUDIO_CAPTURE_DEVICE_NONE", 1);
            AUDIO_CAPTURE_DEVICE_NONE = r1;
            AudioCaptureType r3 = new AudioCaptureType("AUDIO_CAPTURE_DEVICE_ING", 2);
            AUDIO_CAPTURE_DEVICE_ING = r3;
            a = new AudioCaptureType[]{r0, r1, r3};
        }

        public static AudioCaptureType[] values() {
            return (AudioCaptureType[]) a.clone();
        }

        public static AudioCaptureType valueOf(String r1) {
            return (AudioCaptureType) a.a(AudioCaptureType.class, r1);
        }

        public AudioCaptureType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final enum FilterReasonID extends Enum<FilterReasonID> {
        public static final FilterReasonID FilterHalfScreenPage = null;
        public static final FilterReasonID FilterNone = null;
        public static final /* synthetic */ FilterReasonID[] a = null;

        static {
            FilterReasonID r0 = new FilterReasonID("FilterNone", 0);
            FilterNone = r0;
            FilterReasonID r1 = new FilterReasonID("FilterHalfScreenPage", 1);
            FilterHalfScreenPage = r1;
            a = new FilterReasonID[]{r0, r1};
        }

        public static FilterReasonID[] values() {
            return (FilterReasonID[]) a.clone();
        }

        public static FilterReasonID valueOf(String r1) {
            return (FilterReasonID) a.a(FilterReasonID.class, r1);
        }

        public FilterReasonID(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final enum VideoCaptureType extends Enum<VideoCaptureType> {
        public static final VideoCaptureType VIDEO_CAPTURE_DEVICE_NONE = null;
        public static final VideoCaptureType VIDEO_CAPTURE_DEVICE_UNKNOWN = null;
        public static final VideoCaptureType VIDEO_CAPTURE_RADIO_MODE = null;
        public static final VideoCaptureType VIDEO_CAPTURE_RTC_BLACK_FRAME_MODE = null;
        public static final VideoCaptureType VIDEO_CAPTURE_VIDEO = null;
        public static final /* synthetic */ VideoCaptureType[] a = null;

        static {
            VideoCaptureType r0 = new VideoCaptureType("VIDEO_CAPTURE_DEVICE_UNKNOWN", 0);
            VIDEO_CAPTURE_DEVICE_UNKNOWN = r0;
            VideoCaptureType r1 = new VideoCaptureType("VIDEO_CAPTURE_DEVICE_NONE", 1);
            VIDEO_CAPTURE_DEVICE_NONE = r1;
            VideoCaptureType r3 = new VideoCaptureType("VIDEO_CAPTURE_VIDEO", 2);
            VIDEO_CAPTURE_VIDEO = r3;
            VideoCaptureType r5 = new VideoCaptureType("VIDEO_CAPTURE_RADIO_MODE", 3);
            VIDEO_CAPTURE_RADIO_MODE = r5;
            VideoCaptureType r7 = new VideoCaptureType("VIDEO_CAPTURE_RTC_BLACK_FRAME_MODE", 4);
            VIDEO_CAPTURE_RTC_BLACK_FRAME_MODE = r7;
            a = new VideoCaptureType[]{r0, r1, r3, r5, r7};
        }

        public static VideoCaptureType[] values() {
            return (VideoCaptureType[]) a.clone();
        }

        public static VideoCaptureType valueOf(String r1) {
            return (VideoCaptureType) a.a(VideoCaptureType.class, r1);
        }

        public VideoCaptureType(String r1, int r2) {
            super(r1, r2);
        }
    }

    @PbRequest(PbRequest.SwitchType.LINKMIC_AUDIENCE)
    @GET("/webcast/linkmic_audience/ack_message/")
    Single<com.bytedance.android.live.network.response.a> ackMessage(@Query("room_id") long r1, @Query("ack_message") String r3);

    @PbRequest(PbRequest.SwitchType.LINKMIC_AUDIENCE)
    @GET("/webcast/linkmic_audience/check_audience_linkers/")
    Single<e<CheckAudienceLinkersResponse>> checkAudienceLinkers(@Query("room_id") long r1, @Query("link_type") int r3, @Query("silence_status") int r4, @Query("video_capture_type") int r5, @Query("audio_capture_type") int r6, @Query("filter_reason_id") int r7, @Query("rtc_ext_info") String r8);

    @PbRequest(PbRequest.SwitchType.PK)
    @GET("/webcast/linkmic_audience/media_info_change_call_back/")
    Single<com.bytedance.android.live.network.response.a> guestMediaInfoChangeCallBack(@Query("room_id") long r1, @Query("linkmic_id") String r3, @Query("rtc_ext_info") String r4, @Query("mix_type") long r5, @Query("video_capture_type") int r7, @Query("request_source") String r8);
}
