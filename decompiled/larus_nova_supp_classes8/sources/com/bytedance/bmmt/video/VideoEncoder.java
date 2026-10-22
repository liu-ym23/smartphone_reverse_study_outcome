package com.bytedance.bmmt.video;

import com.bytedance.bmmt.video.memory.BmmtVideoFrameInterface;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface VideoEncoder {

    public static final enum BitrateMode extends Enum<BitrateMode> {
        private static final /* synthetic */ BitrateMode[] $VALUES = null;
        public static final BitrateMode AUTO = null;
        public static final BitrateMode CBR = null;
        public static final BitrateMode VBR = null;
        private int value;

        private static /* synthetic */ BitrateMode[] $values() {
            return new BitrateMode[]{AUTO, VBR, CBR};
        }

        static {
            AUTO = new BitrateMode("AUTO", 0, 0);
            VBR = new BitrateMode("VBR", 1, 1);
            CBR = new BitrateMode("CBR", 2, 2);
            $VALUES = $values();
        }

        public static BitrateMode[] values() {
            return (BitrateMode[]) $VALUES.clone();
        }

        public static BitrateMode fromValue(int r1) {
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L10;
            return AUTO;
        L10:
            return CBR;
        L12:
            return VBR;
        L14:
            return AUTO;
        }

        public static BitrateMode valueOf(String r1) {
            return (BitrateMode) r27.a.a(BitrateMode.class, r1);
        }

        private BitrateMode(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public interface Callback {
        void onEncodedEvent(EncodeEvent r1);

        void onEncodedFrame(EncodedImage r1, CodecSpecificInfo r2, ByteBuffer r3);
    }

    public static class CodecSpecificInfo {
        public BmmtVideoCodecStandard codec_standard;

        public CodecSpecificInfo(BmmtVideoCodecStandard r1) {
            this.codec_standard = r1;
        }
    }

    public static final enum EncodeEvent extends Enum<EncodeEvent> {
        private static final /* synthetic */ EncodeEvent[] $VALUES = null;
        public static final EncodeEvent RESET = null;
        public static final EncodeEvent UNKNOWN = null;
        private int value;

        private static /* synthetic */ EncodeEvent[] $values() {
            return new EncodeEvent[]{UNKNOWN, RESET};
        }

        static {
            UNKNOWN = new EncodeEvent("UNKNOWN", 0, 0);
            RESET = new EncodeEvent("RESET", 1, 1);
            $VALUES = $values();
        }

        public static EncodeEvent[] values() {
            return (EncodeEvent[]) $VALUES.clone();
        }

        public int getEventValue() {
            return this.value;
        }

        public static EncodeEvent fromValue(int r1) {
            if (r1 == 1) goto L7;
            return UNKNOWN;
        L7:
            return RESET;
        }

        public static EncodeEvent valueOf(String r1) {
            return (EncodeEvent) r27.a.a(EncodeEvent.class, r1);
        }

        private EncodeEvent(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final enum EncodeMode extends Enum<EncodeMode> {
        private static final /* synthetic */ EncodeMode[] $VALUES = null;
        public static final EncodeMode CLOUD_GAME = null;
        public static final EncodeMode COMMON = null;
        public static final EncodeMode CONFERENCE = null;
        public static final EncodeMode LIVE = null;
        private int value;

        private static /* synthetic */ EncodeMode[] $values() {
            return new EncodeMode[]{COMMON, CLOUD_GAME, CONFERENCE, LIVE};
        }

        static {
            COMMON = new EncodeMode("COMMON", 0, 0);
            CLOUD_GAME = new EncodeMode("CLOUD_GAME", 1, 1);
            CONFERENCE = new EncodeMode("CONFERENCE", 2, 2);
            LIVE = new EncodeMode("LIVE", 3, 3);
            $VALUES = $values();
        }

        public static EncodeMode[] values() {
            return (EncodeMode[]) $VALUES.clone();
        }

        public static EncodeMode fromValue(int r1) {
            if (r1 == 1) goto L15;
            if (r1 == 2) goto L13;
            if (r1 == 3) goto L11;
            return COMMON;
        L11:
            return LIVE;
        L13:
            return CONFERENCE;
        L15:
            return CLOUD_GAME;
        }

        public static EncodeMode valueOf(String r1) {
            return (EncodeMode) r27.a.a(EncodeMode.class, r1);
        }

        private EncodeMode(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final enum ScaleMode extends Enum<ScaleMode> {
        private static final /* synthetic */ ScaleMode[] $VALUES = null;
        public static final ScaleMode AUTO = null;
        public static final ScaleMode FIT_WITH_CROPPING = null;
        public static final ScaleMode FIT_WITH_FILLING = null;
        public static final ScaleMode STRETCH = null;
        private int value;

        private static /* synthetic */ ScaleMode[] $values() {
            return new ScaleMode[]{AUTO, STRETCH, FIT_WITH_CROPPING, FIT_WITH_FILLING};
        }

        static {
            AUTO = new ScaleMode("AUTO", 0, 0);
            STRETCH = new ScaleMode("STRETCH", 1, 1);
            FIT_WITH_CROPPING = new ScaleMode("FIT_WITH_CROPPING", 2, 2);
            FIT_WITH_FILLING = new ScaleMode("FIT_WITH_FILLING", 3, 3);
            $VALUES = $values();
        }

        public static ScaleMode[] values() {
            return (ScaleMode[]) $VALUES.clone();
        }

        public static ScaleMode fromValue(int r1) {
            if (r1 == 0) goto L18;
            if (r1 == 1) goto L16;
            if (r1 == 2) goto L14;
            if (r1 == 3) goto L12;
            return AUTO;
        L12:
            return FIT_WITH_FILLING;
        L14:
            return FIT_WITH_CROPPING;
        L16:
            return STRETCH;
        L18:
            return AUTO;
        }

        public static ScaleMode valueOf(String r1) {
            return (ScaleMode) r27.a.a(ScaleMode.class, r1);
        }

        private ScaleMode(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static class ScalingSettings {
        public static final ScalingSettings OFF = null;
        public final Integer high;
        public final Integer low;
        public final boolean on;

        static {
            OFF = new ScalingSettings();
        }

        public String toString() {
            if (this.on == true) goto L7;
            return "OFF";
        L7:
            return "[ " + this.low + ", " + this.high + " ]";
        }

        private ScalingSettings() {
            this.on = false;
            this.low = null;
            this.high = null;
        }

        public ScalingSettings(boolean r1) {
            this.on = r1;
            this.low = null;
            this.high = null;
        }

        public ScalingSettings(int r2, int r3) {
            this.on = true;
            this.low = Integer.valueOf(r2);
            this.high = Integer.valueOf(r3);
        }

        public ScalingSettings(boolean r1, int r2, int r3) {
            this.on = r1;
            this.low = Integer.valueOf(r2);
            this.high = Integer.valueOf(r3);
        }
    }

    public static class Settings {
        public final int bFrameNum;
        public final BitrateMode bitrateMode;
        public final boolean closeSetProfile;
        public final boolean enableAlignment;
        public final boolean enableAsyncMode;
        public final boolean enableColorSpaceSetting;
        public final boolean enableQpSetting;
        public final EncodeMode encodeMode;
        public final int height;
        public final boolean isStatisticsEnabled;
        public final int matrixId;
        public final int maxIQp;
        public final int maxQp;
        public final int minIQp;
        public final int minQp;
        public final int primaryId;
        public final int rangeId;
        public final ScaleMode scaleMode;
        public final EglBase14.Context sharedContext;
        public int targetBps;
        public final int targetFps;
        public final int targetKeyFrameIntervalMs;
        public final int temporalLayerNum;
        public final int transferId;
        public final boolean useSurfaceMode;
        public final int width;

        public Settings(int r4, int r5, int r6, int r7, int r8, int r9, int r10, int r11, int r12, int r13, int r14, int r15, int r16, boolean r17, int r18, int r19, int r20, boolean r21, boolean r22, boolean r23, int r24, int r25, EglBase.Context r26, boolean r27, boolean r28, boolean r29) {
            this.width = r4;
            this.height = r5;
            this.scaleMode = ScaleMode.fromValue(r6);
            this.targetBps = r7;
            this.targetFps = r8;
            this.primaryId = r9;
            this.transferId = r10;
            this.matrixId = r11;
            this.rangeId = r12;
            this.maxQp = r13;
            this.minQp = r14;
            this.temporalLayerNum = r18;
            this.bitrateMode = BitrateMode.fromValue(r19);
            this.targetKeyFrameIntervalMs = r20;
            this.closeSetProfile = r21;
            this.useSurfaceMode = r22;
            this.enableAlignment = r23;
            this.maxIQp = r15;
            this.minIQp = r16;
            this.bFrameNum = r25;
            this.enableQpSetting = r17;
            this.encodeMode = EncodeMode.fromValue(r24);
            if ((r26 instanceof EglBase14.Context) == false) goto L5;
            this.sharedContext = (EglBase14.Context) r26;
        L6:
            this.enableAsyncMode = r27;
            this.isStatisticsEnabled = r28;
            this.enableColorSpaceSetting = r29;
            return;
        L5:
            this.sharedContext = null;
            goto L6
        }
    }

    VideoCodecStatus encode(BmmtVideoFrameInterface r1, boolean r2);

    VideoCodecStatus initEncode(Settings r1, Callback r2);

    VideoCodecStatus release();

    VideoCodecStatus requestKeyFrame();

    VideoCodecStatus setPrivateParam(String r1, String r2);

    VideoCodecStatus setRateAllocation(int r1, int r2);
}
