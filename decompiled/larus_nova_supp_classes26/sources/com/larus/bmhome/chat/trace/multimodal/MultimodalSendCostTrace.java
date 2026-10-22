package com.larus.bmhome.chat.trace.multimodal;

import androidx.collection.LruCache;
import com.bytedance.apm.ApmAgent;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cache.BotInfoCache;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.rc.ResourceCenter;
import com.larus.bmhome.utils.c;
import com.larus.platform.service.o;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import ic8.m0;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class MultimodalSendCostTrace {
    public static final /* synthetic */ int a = 0;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\t\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0003H\u0016¢\u0006\u0002\u0010\u001eJ\b\u0010\u001f\u001a\u00020\u0003H\u0016R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\"\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0005\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR\"\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\b\u0010\u0012\"\u0004\b\u0018\u0010\u0014R \u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\r\"\u0004\b\u001a\u0010\u000f¨\u0006 "}, d2 = {"Lcom/larus/bmhome/chat/trace/multimodal/MultimodalSendCostTrace$LoadImgStepRecord;", "Lcom/larus/bmhome/chat/trace/multimodal/MultimodalSendCostTrace$StepRecord;", "toskey", "", "messageID", "isByCache", "", "src", "isMultiImg", "extra", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getToskey", "()Ljava/lang/String;", "setToskey", "(Ljava/lang/String;)V", "getMessageID", "setMessageID", "()Ljava/lang/Integer;", "setByCache", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getSrc", "setSrc", "setMultiImg", "getExtra", "setExtra", "getDurationInterval", "", "fileIdentifier", "(Ljava/lang/String;)Ljava/lang/Long;", "getEventKey", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LoadImgStepRecord extends StepRecord {

        @SerializedName("extra")
        private String extra;

        @SerializedName("is_open_by_cache")
        private Integer isByCache;

        @SerializedName("is_multi_img")
        private Integer isMultiImg;

        @SerializedName(MusicAppletPage.KEY_MESSAGE_ID)
        private String messageID;

        @SerializedName("src")
        private String src;

        @SerializedName("toskey")
        private String toskey;

        public LoadImgStepRecord() {
            this(null, null, null, null, null, null, 63, null);
        }

        @Override // com.larus.bmhome.chat.trace.multimodal.MultimodalSendCostTrace.StepRecord
        public String getEventKey() {
            return "message_image_load_success";
        }

        public final String getExtra() {
            return this.extra;
        }

        public final String getMessageID() {
            return this.messageID;
        }

        public final String getSrc() {
            return this.src;
        }

        public final String getToskey() {
            return this.toskey;
        }

        public final Integer isByCache() {
            return this.isByCache;
        }

        public final Integer isMultiImg() {
            return this.isMultiImg;
        }

        @Override // com.larus.bmhome.chat.trace.multimodal.MultimodalSendCostTrace.StepRecord
        public Long getDurationInterval(String r3) {
            Intrinsics.checkNotNullParameter(r3, "fileIdentifier");
            return -1L;
        }

        public final void setByCache(Integer r1) {
            this.isByCache = r1;
        }

        public final void setExtra(String r1) {
            this.extra = r1;
        }

        public final void setMessageID(String r1) {
            this.messageID = r1;
        }

        public final void setMultiImg(Integer r1) {
            this.isMultiImg = r1;
        }

        public final void setSrc(String r1) {
            this.src = r1;
        }

        public final void setToskey(String r1) {
            this.toskey = r1;
        }

        public LoadImgStepRecord(String r8, String r9, Integer r10, String r11, Integer r12, String r13) {
            super(0, null, null, 7, null);
            this.toskey = r8;
            this.messageID = r9;
            this.isByCache = r10;
            this.src = r11;
            this.isMultiImg = r12;
            this.extra = r13;
        }

        public /* synthetic */ LoadImgStepRecord(String r6, String r7, Integer r8, String r9, Integer r10, String r11, int r12, DefaultConstructorMarker r13) {
            if ((r12 & 1) == 0) goto L5;
            String r14 = null;
        L7:
            if ((r12 & 2) == 0) goto L9;
            String r1 = null;
        L11:
            if ((r12 & 4) == 0) goto L13;
            Integer r2 = null;
        L15:
            if ((r12 & 8) == 0) goto L17;
            String r3 = null;
        L19:
            if ((r12 & 16) == 0) goto L21;
            Integer r4 = null;
        L23:
            if ((r12 & 32) == 0) goto L25;
            String r15 = null;
        L26:
            this(r14, r1, r2, r3, r4, r15);
            return;
        L25:
            r15 = r11;
            goto L26
        L21:
            r4 = r10;
            goto L23
        L17:
            r3 = r9;
            goto L19
        L13:
            r2 = r8;
            goto L15
        L9:
            r1 = r7;
            goto L11
        L5:
            r14 = r6;
            goto L7
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0003H\u0016¢\u0006\u0002\u0010\u0013J\b\u0010\u0014\u001a\u00020\u0003H\u0016R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/larus/bmhome/chat/trace/multimodal/MultimodalSendCostTrace$LoadVideoStepRecord;", "Lcom/larus/bmhome/chat/trace/multimodal/MultimodalSendCostTrace$StepRecord;", "messageID", "", "videoParam", "enterMethod", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMessageID", "()Ljava/lang/String;", "setMessageID", "(Ljava/lang/String;)V", "getVideoParam", "setVideoParam", "getEnterMethod", "setEnterMethod", "getDurationInterval", "", "fileIdentifier", "(Ljava/lang/String;)Ljava/lang/Long;", "getEventKey", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LoadVideoStepRecord extends StepRecord {

        @SerializedName("enter_method")
        private String enterMethod;

        @SerializedName(MusicAppletPage.KEY_MESSAGE_ID)
        private String messageID;

        @SerializedName("video_param")
        private String videoParam;

        public LoadVideoStepRecord() {
            this(null, null, null, 7, null);
        }

        @Override // com.larus.bmhome.chat.trace.multimodal.MultimodalSendCostTrace.StepRecord
        public String getEventKey() {
            return "message_video_load_success";
        }

        public final String getEnterMethod() {
            return this.enterMethod;
        }

        public final String getMessageID() {
            return this.messageID;
        }

        public final String getVideoParam() {
            return this.videoParam;
        }

        @Override // com.larus.bmhome.chat.trace.multimodal.MultimodalSendCostTrace.StepRecord
        public Long getDurationInterval(String r3) {
            Intrinsics.checkNotNullParameter(r3, "fileIdentifier");
            return -1L;
        }

        public final void setEnterMethod(String r1) {
            this.enterMethod = r1;
        }

        public final void setMessageID(String r1) {
            this.messageID = r1;
        }

        public final void setVideoParam(String r1) {
            this.videoParam = r1;
        }

        public LoadVideoStepRecord(String r8, String r9, String r10) {
            super(0, null, null, 7, null);
            this.messageID = r8;
            this.videoParam = r9;
            this.enterMethod = r10;
        }

        public /* synthetic */ LoadVideoStepRecord(String r2, String r3, String r4, int r5, DefaultConstructorMarker r6) {
            if ((r5 & 1) == 0) goto L6;
            r2 = null;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r3 = null;
        L9:
            if ((r5 & 4) == 0) goto L11;
            r4 = null;
        L11:
            this(r2, r3, r4);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0003H\u0016¢\u0006\u0002\u0010\u001aJ\b\u0010\u001b\u001a\u00020\u0003H\u0016R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\"\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u0005\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00148\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001c"}, d2 = {"Lcom/larus/bmhome/chat/trace/multimodal/MultimodalSendCostTrace$OpenFileStepRecord;", "Lcom/larus/bmhome/chat/trace/multimodal/MultimodalSendCostTrace$StepRecord;", "toskey", "", "messageID", "isByCache", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getToskey", "()Ljava/lang/String;", "setToskey", "(Ljava/lang/String;)V", "getMessageID", "setMessageID", "()Ljava/lang/Integer;", "setByCache", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "resourceCenterEnabled", "", "getResourceCenterEnabled", "()Z", "getDurationInterval", "", "fileIdentifier", "(Ljava/lang/String;)Ljava/lang/Long;", "getEventKey", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class OpenFileStepRecord extends StepRecord {

        @SerializedName("is_open_by_cache")
        private Integer isByCache;

        @SerializedName(MusicAppletPage.KEY_MESSAGE_ID)
        private String messageID;

        @SerializedName("resource_center_enabled")
        private final boolean resourceCenterEnabled;

        @SerializedName("toskey")
        private String toskey;

        public OpenFileStepRecord() {
            this(null, null, null, 7, null);
        }

        @Override // com.larus.bmhome.chat.trace.multimodal.MultimodalSendCostTrace.StepRecord
        public String getEventKey() {
            return "message_file_open_success";
        }

        public final String getMessageID() {
            return this.messageID;
        }

        public final boolean getResourceCenterEnabled() {
            return this.resourceCenterEnabled;
        }

        public final String getToskey() {
            return this.toskey;
        }

        public final Integer isByCache() {
            return this.isByCache;
        }

        @Override // com.larus.bmhome.chat.trace.multimodal.MultimodalSendCostTrace.StepRecord
        public Long getDurationInterval(String r3) {
            Intrinsics.checkNotNullParameter(r3, "fileIdentifier");
            return -1L;
        }

        public final void setByCache(Integer r1) {
            this.isByCache = r1;
        }

        public final void setMessageID(String r1) {
            this.messageID = r1;
        }

        public final void setToskey(String r1) {
            this.toskey = r1;
        }

        public OpenFileStepRecord(String r8, String r9, Integer r10) {
            super(0, null, null, 7, null);
            this.toskey = r8;
            this.messageID = r9;
            this.isByCache = r10;
        }

        public /* synthetic */ OpenFileStepRecord(String r2, String r3, Integer r4, int r5, DefaultConstructorMarker r6) {
            if ((r5 & 1) == 0) goto L6;
            r2 = null;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r3 = null;
        L9:
            if ((r5 & 4) == 0) goto L11;
            r4 = null;
        L11:
            this(r2, r3, r4);
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\u0007H\u0016¨\u0006\n"}, d2 = {"Lcom/larus/bmhome/chat/trace/multimodal/MultimodalSendCostTrace$PreProcessingStepRecord;", "Lcom/larus/bmhome/chat/trace/multimodal/MultimodalSendCostTrace$StepRecord;", "<init>", "()V", "getDurationInterval", "", "fileIdentifier", "", "(Ljava/lang/String;)Ljava/lang/Long;", "getEventKey", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class PreProcessingStepRecord extends StepRecord {
        @Override // com.larus.bmhome.chat.trace.multimodal.MultimodalSendCostTrace.StepRecord
        public String getEventKey() {
            return "im_send_multimodal_preprocess_success";
        }

        public PreProcessingStepRecord() {
            super(0, null, null, 7, null);
        }

        @Override // com.larus.bmhome.chat.trace.multimodal.MultimodalSendCostTrace.StepRecord
        public Long getDurationInterval(String r5) {
            Intrinsics.checkNotNullParameter(r5, "fileIdentifier");
            MultimodalCommonParamManager.CommonParam r6 = MultimodalCommonParamManager.a(r5);
            if (r6 == null) goto L7;
            Long r7 = r6.getStartProcessTime();
            if (r7 == null) goto L7;
            long r0 = r7.longValue();
            return Long.valueOf(getStepTime() - r0);
        L7:
            return null;
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\u0007H\u0016¨\u0006\n"}, d2 = {"Lcom/larus/bmhome/chat/trace/multimodal/MultimodalSendCostTrace$ProcessingStepRecord;", "Lcom/larus/bmhome/chat/trace/multimodal/MultimodalSendCostTrace$StepRecord;", "<init>", "()V", "getDurationInterval", "", "fileIdentifier", "", "(Ljava/lang/String;)Ljava/lang/Long;", "getEventKey", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ProcessingStepRecord extends StepRecord {
        @Override // com.larus.bmhome.chat.trace.multimodal.MultimodalSendCostTrace.StepRecord
        public String getEventKey() {
            return "im_send_multimodal_process_success";
        }

        public ProcessingStepRecord() {
            super(0, null, null, 7, null);
        }

        @Override // com.larus.bmhome.chat.trace.multimodal.MultimodalSendCostTrace.StepRecord
        public Long getDurationInterval(String r5) {
            Intrinsics.checkNotNullParameter(r5, "fileIdentifier");
            MultimodalCommonParamManager.CommonParam r0 = MultimodalCommonParamManager.a(r5);
            if (r0 == null) goto L7;
            Long r1 = r0.getPreProcessReadyTime();
            if (r1 == null) goto L7;
            long r2 = r1.longValue();
            Long r3 = Long.valueOf(RangesKt.coerceAtLeast(getStepTime() - r2, 0));
        L8:
            MultimodalCommonParamManager.CommonParam r6 = MultimodalCommonParamManager.a(r5);
            if (r6 == null) goto L11;
            r6.setLocalProcessDuration(r3);
        L11:
            return r3;
        L7:
            r3 = null;
            goto L8
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0003H\u0016¢\u0006\u0002\u0010\u001dJ\b\u0010\u001e\u001a\u00020\u0003H\u0016R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\"\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u0005\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR\u0016\u0010\u0016\u001a\u00020\u00178\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001f"}, d2 = {"Lcom/larus/bmhome/chat/trace/multimodal/MultimodalSendCostTrace$ResourceCenterOpenFileStepRecord;", "Lcom/larus/bmhome/chat/trace/multimodal/MultimodalSendCostTrace$StepRecord;", "toskey", "", "messageID", "isByCache", "", "resourceId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getToskey", "()Ljava/lang/String;", "setToskey", "(Ljava/lang/String;)V", "getMessageID", "setMessageID", "()Ljava/lang/Integer;", "setByCache", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getResourceId", "setResourceId", "resourceCenterEnabled", "", "getResourceCenterEnabled", "()Z", "getDurationInterval", "", "fileIdentifier", "(Ljava/lang/String;)Ljava/lang/Long;", "getEventKey", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ResourceCenterOpenFileStepRecord extends StepRecord {

        @SerializedName("is_open_by_cache")
        private Integer isByCache;

        @SerializedName(MusicAppletPage.KEY_MESSAGE_ID)
        private String messageID;

        @SerializedName("resource_center_enabled")
        private final boolean resourceCenterEnabled;

        @SerializedName("resource_id")
        private String resourceId;

        @SerializedName("toskey")
        private String toskey;

        public ResourceCenterOpenFileStepRecord() {
            this(null, null, null, null, 15, null);
        }

        @Override // com.larus.bmhome.chat.trace.multimodal.MultimodalSendCostTrace.StepRecord
        public String getEventKey() {
            return "message_file_open_success";
        }

        public final String getMessageID() {
            return this.messageID;
        }

        public final boolean getResourceCenterEnabled() {
            return this.resourceCenterEnabled;
        }

        public final String getResourceId() {
            return this.resourceId;
        }

        public final String getToskey() {
            return this.toskey;
        }

        public final Integer isByCache() {
            return this.isByCache;
        }

        @Override // com.larus.bmhome.chat.trace.multimodal.MultimodalSendCostTrace.StepRecord
        public Long getDurationInterval(String r3) {
            Intrinsics.checkNotNullParameter(r3, "fileIdentifier");
            return -1L;
        }

        public final void setByCache(Integer r1) {
            this.isByCache = r1;
        }

        public final void setMessageID(String r1) {
            this.messageID = r1;
        }

        public final void setResourceId(String r1) {
            this.resourceId = r1;
        }

        public final void setToskey(String r1) {
            this.toskey = r1;
        }

        public ResourceCenterOpenFileStepRecord(String r8, String r9, Integer r10, String r11) {
            super(0, null, null, 7, null);
            this.toskey = r8;
            this.messageID = r9;
            this.isByCache = r10;
            this.resourceId = r11;
            this.resourceCenterEnabled = true;
        }

        public /* synthetic */ ResourceCenterOpenFileStepRecord(String r2, String r3, Integer r4, String r5, int r6, DefaultConstructorMarker r7) {
            if ((r6 & 1) == 0) goto L6;
            r2 = null;
        L6:
            if ((r6 & 2) == 0) goto L9;
            r3 = null;
        L9:
            if ((r6 & 4) == 0) goto L12;
            r4 = null;
        L12:
            if ((r6 & 8) == 0) goto L14;
            r5 = null;
        L14:
            this(r2, r3, r4, r5);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010&\u001a\u0004\u0018\u00010\u00072\u0006\u0010'\u001a\u00020\u0003H\u0016¢\u0006\u0002\u0010(J\b\u0010)\u001a\u00020\u0003H\u0016J\u0010\u0010*\u001a\u00020+2\u0006\u0010'\u001a\u00020\u0003H\u0016R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\"\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\"\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u001b\u0010\u0015\"\u0004\b\u001c\u0010\u0017R\"\u0010\u001d\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u001e\u0010\u0015\"\u0004\b\u001f\u0010\u0017R\u001e\u0010 \u001a\u00020!8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006,"}, d2 = {"Lcom/larus/bmhome/chat/trace/multimodal/MultimodalSendCostTrace$ResourceCenterUploadStepRecord;", "Lcom/larus/bmhome/chat/trace/multimodal/MultimodalSendCostTrace$StepRecord;", "toskey", "", "resourceId", "resourceSceneId", "durationPreProcess", "", "durationProcess", "durationUpload", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)V", "getToskey", "()Ljava/lang/String;", "setToskey", "(Ljava/lang/String;)V", "getResourceId", "setResourceId", "getResourceSceneId", "setResourceSceneId", "getDurationPreProcess", "()Ljava/lang/Long;", "setDurationPreProcess", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getDurationProcess", "setDurationProcess", "getDurationUpload", "setDurationUpload", "registerDuration", "getRegisterDuration", "setRegisterDuration", "resourceCenterEnabled", "", "getResourceCenterEnabled", "()Z", "setResourceCenterEnabled", "(Z)V", "getDurationInterval", "fileIdentifier", "(Ljava/lang/String;)Ljava/lang/Long;", "getEventKey", "report", "", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ResourceCenterUploadStepRecord extends StepRecord {

        @SerializedName("duration_preprocess")
        private Long durationPreProcess;

        @SerializedName("duration_process")
        private Long durationProcess;

        @SerializedName("duration_upload")
        private Long durationUpload;

        @SerializedName("duration_register")
        private Long registerDuration;

        @SerializedName("resource_center_enabled")
        private boolean resourceCenterEnabled;

        @SerializedName("resource_id")
        private String resourceId;

        @SerializedName("resource_scene_id")
        private String resourceSceneId;

        @SerializedName("toskey")
        private String toskey;

        public ResourceCenterUploadStepRecord() {
            this(null, null, null, null, null, null, 63, null);
        }

        @Override // com.larus.bmhome.chat.trace.multimodal.MultimodalSendCostTrace.StepRecord
        public String getEventKey() {
            return "im_send_multimodal_upload_success";
        }

        public final Long getDurationPreProcess() {
            return this.durationPreProcess;
        }

        public final Long getDurationProcess() {
            return this.durationProcess;
        }

        public final Long getDurationUpload() {
            return this.durationUpload;
        }

        public final Long getRegisterDuration() {
            return this.registerDuration;
        }

        public final boolean getResourceCenterEnabled() {
            return this.resourceCenterEnabled;
        }

        public final String getResourceId() {
            return this.resourceId;
        }

        public final String getResourceSceneId() {
            return this.resourceSceneId;
        }

        public final String getToskey() {
            return this.toskey;
        }

        @Override // com.larus.bmhome.chat.trace.multimodal.MultimodalSendCostTrace.StepRecord
        public Long getDurationInterval(String r5) {
            Intrinsics.checkNotNullParameter(r5, "fileIdentifier");
            MultimodalCommonParamManager.CommonParam r6 = MultimodalCommonParamManager.a(r5);
            if (r6 == null) goto L7;
            Long r7 = r6.getPreProcessReadyTime();
            if (r7 == null) goto L7;
            long r0 = r7.longValue();
            return Long.valueOf(getStepTime() - r0);
        L7:
            return null;
        }

        @Override // com.larus.bmhome.chat.trace.multimodal.MultimodalSendCostTrace.StepRecord
        public void report(String r14) {
            Intrinsics.checkNotNullParameter(r14, "fileIdentifier");
            MultimodalCommonParamManager.CommonParam r0 = MultimodalCommonParamManager.a(r14);
            if (r0 == null) goto L28;
            long r1 = System.currentTimeMillis();
            Long r3 = r0.getPreProcessReadyTime();
            if (r3 == null) goto L7;
            long r4 = r3.longValue();
        L8:
            Long r5 = r0.getUploadedToServerTime();
            if (r5 == null) goto L11;
            long r6 = r5.longValue();
        L12:
            Long r7 = r0.getStartProcessTime();
            if (r7 == null) goto L15;
            long r8 = r7.longValue();
        L16:
            Long r9 = r0.getPreProcessReadyTime();
            if (r9 == null) goto L19;
            r1 = r9.longValue();
        L19:
            Long r2 = r0.getLocalProcessDuration();
            if (r2 == null) goto L22;
            long r11 = r2.longValue();
        L23:
            long r12 = RangesKt.coerceAtLeast(r11, 0);
            this.durationPreProcess = Long.valueOf(RangesKt.coerceAtLeast(r1 - r8, 0));
            this.durationProcess = Long.valueOf(r12);
            this.durationUpload = Long.valueOf(RangesKt.coerceAtLeast((r6 - r4) - r12, 0));
            Long r10 = getDurationInternal();
            if (r10 == null) goto L26;
            long r13 = r10.longValue();
        L27:
            this.registerDuration = Long.valueOf(RangesKt.coerceAtLeast(r13 - r6, 0));
            goto L28
        L26:
            r13 = getStepTime();
            goto L27
        L22:
            r11 = 0;
            goto L23
        L15:
            r8 = r1;
            goto L16
        L11:
            r6 = r1;
            goto L12
        L7:
            r4 = r1;
        L28:
            super.report(r14);
        }

        public final void setDurationPreProcess(Long r1) {
            this.durationPreProcess = r1;
        }

        public final void setDurationProcess(Long r1) {
            this.durationProcess = r1;
        }

        public final void setDurationUpload(Long r1) {
            this.durationUpload = r1;
        }

        public final void setRegisterDuration(Long r1) {
            this.registerDuration = r1;
        }

        public final void setResourceCenterEnabled(boolean r1) {
            this.resourceCenterEnabled = r1;
        }

        public final void setResourceId(String r1) {
            this.resourceId = r1;
        }

        public final void setResourceSceneId(String r1) {
            this.resourceSceneId = r1;
        }

        public final void setToskey(String r1) {
            this.toskey = r1;
        }

        public ResourceCenterUploadStepRecord(String r8, String r9, String r10, Long r11, Long r12, Long r13) {
            super(0, null, null, 7, null);
            this.toskey = r8;
            this.resourceId = r9;
            this.resourceSceneId = r10;
            this.durationPreProcess = r11;
            this.durationProcess = r12;
            this.durationUpload = r13;
            this.resourceCenterEnabled = true;
        }

        public /* synthetic */ ResourceCenterUploadStepRecord(String r6, String r7, String r8, Long r9, Long r10, Long r11, int r12, DefaultConstructorMarker r13) {
            if ((r12 & 1) == 0) goto L5;
            String r14 = null;
        L7:
            if ((r12 & 2) == 0) goto L9;
            String r1 = null;
        L11:
            if ((r12 & 4) == 0) goto L13;
            String r2 = null;
        L15:
            if ((r12 & 8) == 0) goto L17;
            Long r3 = null;
        L19:
            if ((r12 & 16) == 0) goto L21;
            Long r4 = null;
        L23:
            if ((r12 & 32) == 0) goto L25;
            Long r15 = null;
        L26:
            this(r14, r1, r2, r3, r4, r15);
            return;
        L25:
            r15 = r11;
            goto L26
        L21:
            r4 = r10;
            goto L23
        L17:
            r3 = r9;
            goto L19
        L13:
            r2 = r8;
            goto L15
        L9:
            r1 = r7;
            goto L11
        L5:
            r14 = r6;
            goto L7
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\u0007H\u0016¨\u0006\n"}, d2 = {"Lcom/larus/bmhome/chat/trace/multimodal/MultimodalSendCostTrace$SendStartStepRecord;", "Lcom/larus/bmhome/chat/trace/multimodal/MultimodalSendCostTrace$StepRecord;", "<init>", "()V", "getDurationInterval", "", "fileIdentifier", "", "(Ljava/lang/String;)Ljava/lang/Long;", "getEventKey", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SendStartStepRecord extends StepRecord {
        @Override // com.larus.bmhome.chat.trace.multimodal.MultimodalSendCostTrace.StepRecord
        public Long getDurationInterval(String r2) {
            Intrinsics.checkNotNullParameter(r2, "fileIdentifier");
            return null;
        }

        @Override // com.larus.bmhome.chat.trace.multimodal.MultimodalSendCostTrace.StepRecord
        public String getEventKey() {
            return "im_send_multimodal_start";
        }

        public SendStartStepRecord() {
            super(0, null, null, 7, null);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b'\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0017\u0010\f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0015\u001a\u00020\u0016H\u0002¢\u0006\u0002\u0010\u0017J\u0017\u0010\u0018\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0015\u001a\u00020\u0016H&¢\u0006\u0002\u0010\u0017J\b\u0010\u0019\u001a\u00020\u0016H&R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/larus/bmhome/chat/trace/multimodal/MultimodalSendCostTrace$StepRecord;", "", "stepTime", "", "duration", "durationInternal", "<init>", "(JLjava/lang/Long;Ljava/lang/Long;)V", "getStepTime", "()J", "setStepTime", "(J)V", "getDuration", "()Ljava/lang/Long;", "setDuration", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getDurationInternal", "setDurationInternal", "report", "", "fileIdentifier", "", "(Ljava/lang/String;)Ljava/lang/Long;", "getDurationInterval", "getEventKey", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static abstract class StepRecord {

        @SerializedName("duration")
        private Long duration;

        @SerializedName("duration_internal")
        private Long durationInternal;
        private transient long stepTime;

        public StepRecord() {
            this(0, null, null, 7, null);
        }

        public abstract Long getDurationInterval(String r1);

        public abstract String getEventKey();

        public final Long getDuration() {
            return this.duration;
        }

        public final Long getDurationInternal() {
            return this.durationInternal;
        }

        public final long getStepTime() {
            return this.stepTime;
        }

        private final Long getDuration(String r5) {
            MultimodalCommonParamManager.CommonParam r6 = MultimodalCommonParamManager.a(r5);
            if (r6 == null) goto L7;
            Long r7 = r6.getStartProcessTime();
            if (r7 == null) goto L7;
            long r0 = r7.longValue();
            return Long.valueOf(this.stepTime - r0);
        L7:
            return null;
        }

        public void report(String r10) {
            Intrinsics.checkNotNullParameter(r10, "fileIdentifier");
            Long r0 = getDuration(r10);
            boolean r1 = false;
            if (r0 != null) goto L5;
        L13:
            Long r2 = getDurationInterval(r10);
            if (r2 != null) goto L16;
        L23:
            String r3 = getEventKey();
            int r4 = com.larus.bmhome.chat.trace.appreciable.a.a;
            JSONObject r11 = com.larus.bmhome.chat.trace.appreciable.a.b(MultimodalCommonParamManager.a(r10), this);
            FLogger.a.d("MultimodalSendCostTrace", "reportEvent, event=" + r3 + ", param=" + r11);
            if (r11 == null) goto L33;
            o.a.reportEvent(r3, r11);
            JSONObject r5 = new JSONObject();
            if (r11.has("duration") == false) goto L29;
            r5.put("duration", r11.optLong("duration"));
        L29:
            if (r11.has("send_file_size") == false) goto L31;
            r5.put("send_file_size", r11.optLong("send_file_size"));
        L31:
            Lazy r6 = c.a;
            Intrinsics.checkNotNullParameter(r3, "event");
            ((Set) c.a.getValue()).contains(r3);
            ApmAgent.monitorEvent(r3, r11, r5, null);
            return;
        L33:
            return;
        L16:
            if (r2.longValue() < 0) goto L18;
            r1 = true;
        L18:
            if (r1 == true) goto L21;
            r2 = null;
        L21:
            if (r2 == null) goto L23;
            this.durationInternal = Long.valueOf(r2.longValue());
            goto L23
        L5:
            if (r0.longValue() < 0) goto L7;
            boolean r7 = true;
        L8:
            if (r7 == true) goto L11;
            r0 = null;
        L11:
            if (r0 == null) goto L13;
            this.duration = Long.valueOf(r0.longValue());
            goto L13
        L7:
            r7 = false;
            goto L8
        }

        public final void setDuration(Long r1) {
            this.duration = r1;
        }

        public final void setDurationInternal(Long r1) {
            this.durationInternal = r1;
        }

        public final void setStepTime(long r1) {
            this.stepTime = r1;
        }

        public StepRecord(long r1, Long r3, Long r4) {
            this.stepTime = r1;
            this.duration = r3;
            this.durationInternal = r4;
        }

        public /* synthetic */ StepRecord(long r2, Long r4, Long r5, int r6, DefaultConstructorMarker r7) {
            if ((r6 & 1) == 0) goto L6;
            r2 = System.currentTimeMillis();
        L6:
            if ((r6 & 2) == 0) goto L9;
            r4 = null;
        L9:
            if ((r6 & 4) == 0) goto L11;
            r5 = null;
        L11:
            this(r2, r4, r5);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0016\u001a\u00020\u0003H\u0016¢\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0003H\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u0003H\u0016R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00128\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001b"}, d2 = {"Lcom/larus/bmhome/chat/trace/multimodal/MultimodalSendCostTrace$UploadStepRecord;", "Lcom/larus/bmhome/chat/trace/multimodal/MultimodalSendCostTrace$StepRecord;", "toskey", "", "durationUpload", "", "<init>", "(Ljava/lang/String;Ljava/lang/Long;)V", "getToskey", "()Ljava/lang/String;", "setToskey", "(Ljava/lang/String;)V", "getDurationUpload", "()Ljava/lang/Long;", "setDurationUpload", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "resourceCenterEnabled", "", "getResourceCenterEnabled", "()Z", "getDurationInterval", "fileIdentifier", "(Ljava/lang/String;)Ljava/lang/Long;", "getEventKey", "report", "", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class UploadStepRecord extends StepRecord {

        @SerializedName("duration_upload")
        private Long durationUpload;

        @SerializedName("resource_center_enabled")
        private final boolean resourceCenterEnabled;

        @SerializedName("toskey")
        private String toskey;

        /* JADX WARN: Multi-variable type inference failed */
        public UploadStepRecord() {
            Object[] r0 = 0 == true ? 1 : 0;
            this(null, r0, 3, 0 == true ? 1 : 0);
        }

        @Override // com.larus.bmhome.chat.trace.multimodal.MultimodalSendCostTrace.StepRecord
        public String getEventKey() {
            return "im_send_multimodal_upload_success";
        }

        public final Long getDurationUpload() {
            return this.durationUpload;
        }

        public final boolean getResourceCenterEnabled() {
            return this.resourceCenterEnabled;
        }

        public final String getToskey() {
            return this.toskey;
        }

        @Override // com.larus.bmhome.chat.trace.multimodal.MultimodalSendCostTrace.StepRecord
        public Long getDurationInterval(String r5) {
            Intrinsics.checkNotNullParameter(r5, "fileIdentifier");
            MultimodalCommonParamManager.CommonParam r6 = MultimodalCommonParamManager.a(r5);
            if (r6 == null) goto L7;
            Long r7 = r6.getPreProcessReadyTime();
            if (r7 == null) goto L7;
            long r0 = r7.longValue();
            return Long.valueOf(getStepTime() - r0);
        L7:
            return null;
        }

        @Override // com.larus.bmhome.chat.trace.multimodal.MultimodalSendCostTrace.StepRecord
        public void report(String r2) {
            Intrinsics.checkNotNullParameter(r2, "fileIdentifier");
            this.durationUpload = getDurationInterval(r2);
            super.report(r2);
        }

        public final void setDurationUpload(Long r1) {
            this.durationUpload = r1;
        }

        public final void setToskey(String r1) {
            this.toskey = r1;
        }

        public UploadStepRecord(String r8, Long r9) {
            super(0, null, null, 7, null);
            this.toskey = r8;
            this.durationUpload = r9;
        }

        public /* synthetic */ UploadStepRecord(String r2, Long r3, int r4, DefaultConstructorMarker r5) {
            if ((r4 & 1) == 0) goto L6;
            r2 = null;
        L6:
            if ((r4 & 2) == 0) goto L8;
            r3 = null;
        L8:
            this(r2, r3);
        }
    }

    static {
    }

    public MultimodalSendCostTrace() {
    }

    public static void a(String r6, m0 r7) {
        Intrinsics.checkNotNullParameter(r6, "fileIdentifier");
        PreProcessingStepRecord r0 = new PreProcessingStepRecord();
        MultimodalCommonParamManager.CommonParam r1 = MultimodalCommonParamManager.a(r6);
        if (r1 == null) goto L23;
        r1.setPreProcessReadyTime(Long.valueOf(r0.getStepTime()));
        String r2 = null;
        if (r7 == null) goto L7;
        String r3 = r7.f;
    L8:
        r1.setFileMD5(r3);
        if (r7 == null) goto L11;
        Integer r4 = Integer.valueOf((int) r7.c);
    L12:
        r1.setFileSize(r4);
        if (r7 == null) goto L20;
        String r5 = r7.b;
        if (r5 == null) goto L20;
        String r8 = StringsKt.substringAfterLast$default(r5, '.', null, 2, null);
        if (r8 == null) goto L20;
        r2 = r8;
    L22:
        r1.setFileType(r2);
    L20:
        if (r7 == null) goto L22;
        r2 = r7.d;
        goto L22
    L11:
        r4 = null;
        goto L12
    L7:
        r3 = null;
    L23:
        r0.report(r6);
    }

    public static void d(String r11, m0 r12) {
        Intrinsics.checkNotNullParameter(r11, "fileIdentifier");
        ResourceCenter.a.getClass();
        String r1 = null;
        boolean r2 = false;
        boolean r3 = false;
        boolean r4 = false;
        if (ResourceCenter.d(r11) == false) goto L9;
        ResourceCenterUploadStepRecord r0 = new ResourceCenterUploadStepRecord(null, null, null, null, null, null, 63, null);
        if (r12 == null) goto L7;
        String r5 = r12.h;
    L8:
        r0.setToskey(r5);
        Intrinsics.checkNotNullParameter(r11, "identifier");
        r0.setResourceId(ResourceCenter.e.get(r11));
        r0.setResourceSceneId(ResourceCenter.g(r11).getTitle());
        r0.setResourceCenterEnabled(true);
        StepRecord r6 = r0;
    L14:
        MultimodalCommonParamManager.CommonParam r7 = MultimodalCommonParamManager.a(r11);
        if (r7 == null) goto L20;
        r7.setUploadReadyTime(Long.valueOf(r6.getStepTime()));
        if (r12 == null) goto L19;
        r1 = r12.f;
    L19:
        r7.setFileMD5(r1);
    L20:
        r6.report(r11);
        MultimodalCommonParamManager.b(r11);
        return;
    L7:
        r5 = null;
        goto L8
    L9:
        UploadStepRecord r8 = new UploadStepRecord(r4 ? 1 : 0, r3 ? 1 : 0, 3, r2 ? 1 : 0);
        if (r12 == null) goto L12;
        String r9 = r12.h;
    L13:
        r8.setToskey(r9);
        r6 = r8;
        goto L14
    L12:
        r9 = null;
        goto L13
    }

    public static /* synthetic */ void c(String r8, String r9, String r10, String r11, AttachmentAreaType r12) {
        b(r8, r9, r10, r11, r12, null, null, null);
    }

    public static void f(String r1, String r2, String r3, boolean r4, String r5) {
        Intrinsics.checkNotNullParameter(r1, "fileIdentifier");
        if (o0.d(r5) == false) goto L5;
        StepRecord r0 = new ResourceCenterOpenFileStepRecord(r2, r3, Integer.valueOf(r4 ? 1 : 0), r5);
    L6:
        MultimodalCommonParamManager.CommonParam r6 = MultimodalCommonParamManager.a(r1);
        if (r6 == null) goto L9;
        r6.setProcessSuccessTime(Long.valueOf(r0.getStepTime()));
    L9:
        r0.report(r1);
        MultimodalCommonParamManager.b(r1);
        return;
    L5:
        r0 = new OpenFileStepRecord(r2, r3, Integer.valueOf(r4 ? 1 : 0));
        goto L6
    }

    public static void e(String r8, String r9, String r10, String r11, boolean r12, Map r13) {
        Intrinsics.checkNotNullParameter(r8, "fileIdentifier");
        Integer r6 = Integer.valueOf(r12 ? 1 : 0);
        if (r13 == null) goto L5;
        String r14 = new JSONObject(r13).toString();
    L6:
        LoadImgStepRecord r15 = new LoadImgStepRecord(r9, r10, 0, r11, r6, r14);
        MultimodalCommonParamManager.CommonParam r16 = MultimodalCommonParamManager.a(r8);
        if (r16 == null) goto L9;
        r16.setProcessSuccessTime(Long.valueOf(r15.getStepTime()));
    L9:
        r15.report(r8);
        MultimodalCommonParamManager.b(r8);
        return;
    L5:
        r14 = null;
        goto L6
    }

    public static void b(String r26, String r27, String r28, String r29, AttachmentAreaType r30, Integer r31, String r32, String r33) {
        Intrinsics.checkNotNullParameter(r26, "fileIdentifier");
        Intrinsics.checkNotNullParameter(r30, "attachmentAreaType");
        SendStartStepRecord r3 = new SendStartStepRecord();
        LruCache<String, MultimodalCommonParamManager.CommonParam> r5 = MultimodalCommonParamManager.a;
        long r6 = r3.getStepTime();
        int r4 = r30.getValue();
        Intrinsics.checkNotNullParameter(r26, "fileIdentifier");
        MultimodalCommonParamManager.CommonParam r2 = new MultimodalCommonParamManager.CommonParam(null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, 65535, null);
        MultimodalCommonParamManager.a.put(r26, r2);
        r2.setScene(r29);
        r2.setLocalSendMsgId(r27);
        r2.setCvsId(r28);
        Integer r0 = null;
        if (r28 == null) goto L5;
        String r7 = BotInfoCache.INSTANCE.getBotId(r28);
    L6:
        r2.setBotId(r7);
        LruCache<String, e> r8 = ko8.a.a;
        if (r28 == null) goto L11;
        e r9 = (e) IAIChatControlTraceService.a.ac().get(r28);
        if (r9 == null) goto L11;
        Integer r10 = r9.v;
    L12:
        if (r28 == null) goto L14;
        r0 = BotInfoCache.INSTANCE.getBotType(r28);
    L14:
        if (r28 == null) goto L16;
        boolean r1 = BotInfoCache.INSTANCE.isOwnBot(r28);
    L17:
        r2.setChatType(ko8.a.f(r10, r0, r1));
        r2.setStartProcessTime(Long.valueOf(r6));
        r2.setFileAttachmentType(Integer.valueOf(r4));
        r2.setFileMD5(r32);
        r2.setFileSize(r31);
        r2.setFileType(r33);
        FLogger.a.d("CommonParamManager", "createAndSave, param=" + r2);
        return;
    L16:
        r1 = true;
    L11:
        r10 = null;
        goto L12
    L5:
        r7 = null;
        goto L6
    }
}
