package com.bytedance.android.live.liveinteract.multianchor.model;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public class MicDress extends FlexModelBase<kd1.b> implements kd1.b {

    @SerializedName("badge")
    public LinkmicBadge badge;

    @SerializedName("customized_random_emoji")
    public a linkmicCustomizedRandomEmoji;

    @SerializedName("voice_wave")
    public VoiceWave voiceWave;

    @JsonAdapter(FlexModelJsonAdapter.class)
    public static class LinkmicBadge extends FlexModelBase<kd1.a> implements kd1.a {

        @SerializedName("dress_id")
        public String dressId;

        @SerializedName("show_type")
        public int showType;

        public static final enum LinkmicBadgeShowType extends Enum<LinkmicBadgeShowType> {
            public static final LinkmicBadgeShowType DisplayFirst = null;
            public static final LinkmicBadgeShowType NormalDisplay = null;
            public static final /* synthetic */ LinkmicBadgeShowType[] a = null;
            private final int value;

            static {
                LinkmicBadgeShowType r0 = new LinkmicBadgeShowType("NormalDisplay", 0, 0);
                NormalDisplay = r0;
                LinkmicBadgeShowType r1 = new LinkmicBadgeShowType("DisplayFirst", 1, 1);
                DisplayFirst = r1;
                a = new LinkmicBadgeShowType[]{r0, r1};
            }

            public static LinkmicBadgeShowType[] values() {
                return (LinkmicBadgeShowType[]) a.clone();
            }

            public static /* synthetic */ int access$000(LinkmicBadgeShowType r0) {
                return r0.value;
            }

            public static LinkmicBadgeShowType valueOf(String r1) {
                return (LinkmicBadgeShowType) r27.a.a(LinkmicBadgeShowType.class, r1);
            }

            public LinkmicBadgeShowType(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public LinkmicBadge() {
            super(kd1.a.class);
            this.showType = LinkmicBadgeShowType.access$000(LinkmicBadgeShowType.NormalDisplay);
        }

        public String getDressId() {
            return this.dressId;
        }

        public int getShowType() {
            return this.showType;
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    public static class VoiceWave extends FlexModelBase<kd1.c> implements kd1.c {

        @SerializedName("dress_id")
        public String dressId;

        @SerializedName("high_img")
        public py.k highImg;

        @SerializedName("low_img")
        public py.k lowImg;

        @SerializedName("medium_img")
        public py.k mediumImg;

        public VoiceWave() {
            super(kd1.c.class);
        }

        public String getDressId() {
            return this.dressId;
        }

        public py.k getHighImg() {
            return this.highImg;
        }

        public py.k getLowImg() {
            return this.lowImg;
        }

        public py.k getMediumImg() {
            return this.mediumImg;
        }

        public py.k getAnimByState(int r2) {
            if (r2 != 1) goto L7;
            return this.lowImg;
        L7:
            if (r2 != 2) goto L11;
            return this.mediumImg;
        L11:
            return this.highImg;
        }

        public String getAnimUrlByState(int r3) {
            if (r3 != 1) goto L11;
            py.k r4 = this.lowImg;
            if (r4 != null) goto L7;
            return null;
        L7:
            if (r4.getUrls().isEmpty() == false) goto L9;
            return null;
        L9:
            return (String) ListProtector.get(this.lowImg.getUrls(), 0);
        L11:
            if (r3 != 2) goto L18;
            py.k r5 = this.mediumImg;
            if (r5 != null) goto L15;
            return null;
        L15:
            if (r5.getUrls().isEmpty() == false) goto L17;
            return null;
        L17:
            return (String) ListProtector.get(this.mediumImg.getUrls(), 0);
        L18:
            py.k r6 = this.highImg;
            if (r6 != null) goto L21;
            return null;
        L21:
            if (r6.getUrls().isEmpty() == false) goto L23;
            return null;
        L23:
            return (String) ListProtector.get(this.highImg.getUrls(), 0);
        }
    }

    public static class a {

        @SerializedName("emoji_displayd_dynamic_image")
        public py.k dynamicImage;

        @SerializedName("random_num")
        public long randomNum;

        @SerializedName("status")
        public int status;

        @SerializedName("emoji_status_image")
        public py.k statusImage;

        @SerializedName("trigger_reason")
        public String triggerReason;

        @SerializedName("refresh_timestamp")
        public long ts;

        @SerializedName("type")
        public int type;

        public a() {
        }
    }

    public MicDress() {
        super(kd1.b.class);
    }

    public kd1.a getBadge() {
        return this.badge;
    }

    public kd1.c getVoiceWave() {
        return this.voiceWave;
    }

    public boolean isEqual(MicDress r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        VoiceWave r1 = this.voiceWave;
        if (r1 == null) goto L11;
        VoiceWave r4 = r3.voiceWave;
        if (r4 == null) goto L11;
        return TextUtils.equals(r1.dressId, r4.dressId);
    L11:
        return false;
    }
}
