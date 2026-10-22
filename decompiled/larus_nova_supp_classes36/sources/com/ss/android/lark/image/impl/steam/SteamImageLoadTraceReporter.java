package com.ss.android.lark.image.impl.steam;

import com.bumptech.glide.load.engine.GlideException;
import com.bytedance.lark.pb.tool.v1.SendSteamLogsRequest;
import com.larksuite.framework.utils.l0;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.ImageModule;
import com.ss.android.lark.image.a;
import com.ss.android.lark.image.entity.EncryptImage;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.maintab.export.TabAppInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\f\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002+,B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u0019\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005JE\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00052\u000e\u0010\u001d\u001a\n\u0018\u00010\u001ej\u0004\u0018\u0001`\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\"J \u0010#\u001a\u00020\u00162\u000e\u0010$\u001a\n\u0018\u00010\u001ej\u0004\u0018\u0001`\u001f2\b\u0010%\u001a\u0004\u0018\u00010\u0001J\u0012\u0010&\u001a\u0004\u0018\u00010\u00052\b\u0010%\u001a\u0004\u0018\u00010\u0001J \u0010'\u001a\u00020\u00102\u000e\u0010$\u001a\n\u0018\u00010\u001ej\u0004\u0018\u0001`\u001f2\u0006\u0010(\u001a\u00020\u0014H\u0002J\b\u0010)\u001a\u00020\u0016H\u0002J\b\u0010*\u001a\u00020\u0010H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/ss/android/lark/image/impl/steam/SteamImageLoadTraceReporter;", "", "<init>", "()V", "TAG", "", "BIZ_ID", "ACTION_AND_SUB_TAG", "ANDROID_SUB_STAGE_CODE", "IMAGE_LOAD_SUB_STAGE_CODE", "SUB_STAGE_UNKNOWN", "", "FG_STEAM_LOG", "WHICH_END_ANDROID", "TTL", "isCleaning", "", "THRESHOLD", "imageKeyDataMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/ss/android/lark/image/impl/steam/SteamImageLoadTraceReporter$ImageLoadSubStageData;", "put", "", "imageKey", "contextId", "remove", "error", "subStage", "Lcom/ss/android/lark/image/impl/steam/SteamImageLoadTraceReporter$SubStage;", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "createTime", "", "(Lcom/ss/android/lark/image/impl/steam/SteamImageLoadTraceReporter$SubStage;Ljava/lang/String;Ljava/lang/Exception;Ljava/lang/Long;Ljava/lang/String;)V", "glideError", "e", "model", "getEncryptImageKeyByModel", "parseErrorCode", "data", "cleanLongTimeData", "isFgEnable", "SubStage", "ImageLoadSubStageData", "lark-image_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class SteamImageLoadTraceReporter {
    public static final int $stable = 0;
    public static final SteamImageLoadTraceReporter INSTANCE = null;
    private static final ConcurrentHashMap<String, ImageLoadSubStageData> imageKeyDataMap = null;
    private static volatile boolean isCleaning;

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\b\t\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u00101\u001a\u00020\u00002\u0006\u00102\u001a\u00020\u00072\b\u00103\u001a\u0004\u0018\u00010\u0007J\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020605J\u0014\u00107\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u000206\u0018\u000105J\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000705J\b\u00109\u001a\u00020\u0007H\u0016J\b\u0010:\u001a\u00020)H\u0002J\u0012\u0010;\u001a\u00020\u00072\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0002J\u000e\u0010<\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003J\u0012\u0010=\u001a\u0002062\b\u0010>\u001a\u0004\u0018\u00010\u0001H\u0002R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0017\"\u0004\b \u0010\u0019R\u0011\u0010!\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017R\u000e\u0010#\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070+X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010,\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100¨\u0006?"}, d2 = {"Lcom/ss/android/lark/image/impl/steam/SteamImageLoadTraceReporter$ImageLoadSubStageData;", "", "subStage", "Lcom/ss/android/lark/image/impl/steam/SteamImageLoadTraceReporter$SubStage;", "createTime", "", "contextId", "", "errorCode", "", "fileKey", "<init>", "(Lcom/ss/android/lark/image/impl/steam/SteamImageLoadTraceReporter$SubStage;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getSubStage", "()Lcom/ss/android/lark/image/impl/steam/SteamImageLoadTraceReporter$SubStage;", "setSubStage", "(Lcom/ss/android/lark/image/impl/steam/SteamImageLoadTraceReporter$SubStage;)V", "getCreateTime", "()Ljava/lang/Long;", "setCreateTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getContextId", "()Ljava/lang/String;", "setContextId", "(Ljava/lang/String;)V", "getErrorCode", "()Ljava/lang/Integer;", "setErrorCode", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getFileKey", "setFileKey", "eventId", "getEventId", "action", "subTag", "userId", "deviceId", "whichEnd", "isFailed", "", "specialValues", "", "putTime", "getPutTime", "()J", "setPutTime", "(J)V", "putSpecialValue", TabAppInfo.IMAGE_JSON_KEY, "value", "getGeneralMap", "", "Lcom/bytedance/lark/pb/tool/v1/SendSteamLogsRequest$StringList;", "getSpecialKeys", "getSpecialValues", "toString", "isReady", "getSubStageString", "getSubStageCode", "toStringList", "field", "lark-image_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class ImageLoadSubStageData {
        private final String action;
        private String contextId;
        private Long createTime;
        private final String deviceId;
        private Integer errorCode;
        private final String eventId;
        private String fileKey;
        private final boolean isFailed;
        private long putTime;
        private final Map<String, String> specialValues;
        private SubStage subStage;
        private final String subTag;
        private final String userId;
        private final String whichEnd;

        public ImageLoadSubStageData() {
            this(null, null, null, null, null, 31, null);
        }

        public String toString() {
            return MapsKt.mapOf(new Pair[]{TuplesKt.to("contextId", this.contextId), TuplesKt.to("errorCode", this.errorCode), TuplesKt.to("USER_ID", this.userId), TuplesKt.to("DEVICE_ID", this.deviceId), TuplesKt.to("fileKey", this.fileKey)}).toString();
        }

        private final boolean isReady() {
            if (this.subStage != null) goto L5;
        L12:
            ArrayList r1 = new ArrayList();
            if (this.subStage != null) goto L16;
            r1.add("subStage");
        L16:
            if (this.createTime != null) goto L19;
            r1.add("createTime");
        L19:
            if (this.contextId != null) goto L22;
            r1.add("contextId");
        L22:
            if (this.errorCode != null) goto L24;
            r1.add("errorCode");
        L24:
            Log.e("SteamImageLinkReporter", "Empty fields are: " + CollectionsKt.joinToString$default(r1, ", ", null, null, 0, null, null, 62, null));
            return false;
        L5:
            if (this.createTime == null) goto L12;
            if (this.contextId == null) goto L12;
            if (this.errorCode == null) goto L12;
            return true;
        }

        public final Map<String, SendSteamLogsRequest.StringList> getGeneralMap() {
            return MapsKt.mapOf(TuplesKt.to("WHICH_END", toStringList(this.whichEnd)));
        }

        public final Map<String, SendSteamLogsRequest.StringList> getSpecialKeys() {
            if (isReady() == true) goto L7;
            return null;
        L7:
            return MapsKt.mapOf(new Pair[]{TuplesKt.to("subStage", toStringList(getSubStageString(this.subStage))), TuplesKt.to("createTime", toStringList(this.createTime)), TuplesKt.to("contextId", toStringList(this.contextId)), TuplesKt.to("errorCode", toStringList(this.errorCode)), TuplesKt.to("action", toStringList(this.action)), TuplesKt.to("SUB_TAG", toStringList(this.subTag)), TuplesKt.to("USER_ID", toStringList(this.userId)), TuplesKt.to("DEVICE_ID", toStringList(this.deviceId)), TuplesKt.to("isFailed", toStringList(Boolean.valueOf(this.isFailed))), TuplesKt.to("fileKey", toStringList(this.fileKey))});
        }

        public final String getContextId() {
            return this.contextId;
        }

        public final String getEventId() {
            return this.eventId;
        }

        public final long getPutTime() {
            return this.putTime;
        }

        public final Map<String, String> getSpecialValues() {
            return this.specialValues;
        }

        private final String getSubStageString(SubStage r3) {
            if (r3 == null) goto L5;
            String r4 = "103" + r3.getStage();
            if (r4 == null) goto L5;
            return r4;
        L5:
            return "103000";
        }

        private final SendSteamLogsRequest.StringList toStringList(Object r2) {
            SendSteamLogsRequest.StringList.Builder r0 = new SendSteamLogsRequest.StringList.Builder();
            if (r2 == null) goto L6;
            String r3 = r2.toString();
            if (r3 == null) goto L6;
        L8:
            return r0.value(CollectionsKt.listOf(r3)).build();
        L6:
            r3 = "";
            goto L8
        }

        public final void setContextId(String r1) {
            this.contextId = r1;
        }

        public final void setCreateTime(Long r1) {
            this.createTime = r1;
        }

        public final void setErrorCode(Integer r1) {
            this.errorCode = r1;
        }

        public final void setFileKey(String r1) {
            this.fileKey = r1;
        }

        public final void setSubStage(SubStage r1) {
            this.subStage = r1;
        }

        public ImageLoadSubStageData(SubStage r1, Long r2, String r3, Integer r4, String r5) {
            this.subStage = r1;
            this.createTime = r2;
            this.contextId = r3;
            this.errorCode = r4;
            this.fileKey = r5;
            this.eventId = l0.a().toString();
            this.action = "52";
            this.subTag = "52";
            a r6 = ImageModule.a;
            String r7 = r6.getPassPortDependency().getUserId();
            String r8 = "";
            if (r7 != null) goto L5;
            r7 = "";
        L5:
            this.userId = r7;
            String r9 = r6.getPassPortDependency().getDeviceId();
            if (r9 == null) goto L9;
            r8 = r9;
        L9:
            this.deviceId = r8;
            this.whichEnd = "Android";
            this.isFailed = true;
            this.specialValues = new LinkedHashMap();
            this.putTime = System.currentTimeMillis();
        }

        public /* synthetic */ ImageLoadSubStageData(SubStage r5, Long r6, String r7, Integer r8, String r9, int r10, DefaultConstructorMarker r11) {
            if ((r10 & 1) == 0) goto L5;
            SubStage r12 = null;
        L7:
            if ((r10 & 2) == 0) goto L9;
            Long r1 = null;
        L11:
            if ((r10 & 4) == 0) goto L13;
            String r2 = null;
        L15:
            if ((r10 & 8) == 0) goto L17;
            Integer r3 = null;
        L19:
            if ((r10 & 16) == 0) goto L21;
            String r13 = null;
        L22:
            this(r12, r1, r2, r3, r13);
            return;
        L21:
            r13 = r9;
            goto L22
        L17:
            r3 = r8;
            goto L19
        L13:
            r2 = r7;
            goto L15
        L9:
            r1 = r6;
            goto L11
        L5:
            r12 = r5;
            goto L7
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/image/impl/steam/SteamImageLoadTraceReporter$SubStage;", "", "stage", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getStage", "()Ljava/lang/String;", "SHOW_ON_SCREEN", "lark-image_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final enum SubStage extends Enum<SubStage> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ SubStage[] $VALUES = null;
        public static final SubStage SHOW_ON_SCREEN = null;
        private final String stage;

        private static final /* synthetic */ SubStage[] $values() {
            return new SubStage[]{SHOW_ON_SCREEN};
        }

        public static EnumEntries<SubStage> getEntries() {
            return $ENTRIES;
        }

        static {
            SHOW_ON_SCREEN = new SubStage("SHOW_ON_SCREEN", 0, "001");
            SubStage[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries(r0);
        }

        public static SubStage[] values() {
            return (SubStage[]) $VALUES.clone();
        }

        public final String getStage() {
            return this.stage;
        }

        public static SubStage valueOf(String r1) {
            return (SubStage) r27.a.a(SubStage.class, r1);
        }

        private SubStage(String r1, int r2, String r3) {
            super(r1, r2);
            this.stage = r3;
        }
    }

    private SteamImageLoadTraceReporter() {
    }

    private final synchronized void cleanLongTimeData() {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (isCleaning == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        isCleaning = true;     // Catch: Throwable -> L17
        long r0 = System.currentTimeMillis();     // Catch: Throwable -> L17
        Iterator<Map.Entry<String, ImageLoadSubStageData>> r2 = imageKeyDataMap.entrySet().iterator();     // Catch: Throwable -> L17
    L10:
        if (r2.hasNext() == false) goto L14;
        if ((r0 - r2.next().getValue().getPutTime()) <= 60000) goto L10;
        r2.remove();     // Catch: Throwable -> L17
        goto L10
    L14:
        isCleaning = false;     // Catch: Throwable -> L17
        monitor-exit(this);
    }

    static {
        INSTANCE = new SteamImageLoadTraceReporter();
        imageKeyDataMap = new ConcurrentHashMap();
        $stable = 8;
    }

    private final boolean isFgEnable() {
        boolean r0 = FeatureGatingModule.getFeatureGatingService().isEnable("lark-file.download.image_trace");
        if (r0 == true) goto L5;
        Log.i("SteamImageLinkReporter", "FG = lark-file.download.image_trace, is not enable");
        imageKeyDataMap.clear();
    L5:
        return r0;
    }

    public final String getEncryptImageKeyByModel(Object r3) {
        if ((r3 instanceof EncryptImage) == true) goto L7;
        return null;
    L7:
        return "image:" + ((EncryptImage) r3).getEncryptKey();
    }

    public final void remove(String r2) {
        if (r2 == null) goto L5;
        ImageLoadSubStageData r3 = imageKeyDataMap.remove(r2);
        return;
    }

    private final boolean parseErrorCode(Exception r2, ImageLoadSubStageData r3) {
        if ((r2 instanceof GlideException) == false) goto L5;
        GlideException r4 = (GlideException) r2;
    L6:
        if (r4 != null) goto L9;
        Log.i("SteamImageLinkReporter", "parseErrorCode / Exception is not GlideException");
        return false;
    L9:
        r3.setErrorCode(Integer.valueOf(r4.getErrorCode()));
        return true;
    L5:
        r4 = null;
        goto L6
    }

    public final void glideError(Exception r9, Object r10) {
        String r2 = getEncryptImageKeyByModel(r10);
        if (r2 != null) goto L5;
        return;
    L5:
        error$default(this, SubStage.SHOW_ON_SCREEN, r2, r9, null, null, 24, null);
    }

    public final void put(String r11, String r12) {
        if (isFgEnable() == true) goto L5;
        return;
    L5:
        if (r11 != null) goto L7;
        return;
    L7:
        if (r12 != null) goto L9;
        return;
    L9:
        ConcurrentHashMap<String, ImageLoadSubStageData> r0 = imageKeyDataMap;
        ImageLoadSubStageData r1 = r0.putIfAbsent(r11, new ImageLoadSubStageData(null, null, r12, null, r11, 11, null));
        if (r1 == null) goto L13;
        Log.w("SteamImageLinkReporter", "Repeated key = " + r11 + ", org context id = " + r1.getContextId() + ", new context id = " + r12);
        r1.setContextId(r12);
    L13:
        if (isCleaning == false) goto L15;
        return;
    L15:
        if (r0.size() <= 100) goto L19;
        cleanLongTimeData();
        return;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r11v0 ??, still in use, count: 1, list:
          (r11v0 ?? I:java.lang.Object) from 0x0055: INVOKE (r10v0 ?? I:java.util.Map), (r14v0 ?? I:java.lang.Object), (r11v0 ?? I:java.lang.Object) INTERFACE call: java.util.Map.put(java.lang.Object, java.lang.Object):java.lang.Object A[MD:(K, V):V (c)] (LINE:83886165)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:75)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:42)
        */
    public final void error(
    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r11v0 ??, still in use, count: 1, list:
          (r11v0 ?? I:java.lang.Object) from 0x0055: INVOKE (r10v0 ?? I:java.util.Map), (r14v0 ?? I:java.lang.Object), (r11v0 ?? I:java.lang.Object) INTERFACE call: java.util.Map.put(java.lang.Object, java.lang.Object):java.lang.Object A[MD:(K, V):V (c)] (LINE:83886165)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:75)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r13v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:215)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
        	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
        	at jadx.core.ProcessClass.process(ProcessClass.java:89)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
        	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
        	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
        */

    public static /* synthetic */ void error$default(SteamImageLoadTraceReporter r7, SubStage r8, String r9, Exception r10, Long r11, String r12, int r13, Object r14) {
        if ((r13 & 8) == 0) goto L5;
        Long r5 = null;
    L7:
        if ((r13 & 16) == 0) goto L9;
        String r6 = null;
    L10:
        r7.error(r8, r9, r10, r5, r6);
        return;
    L9:
        r6 = r12;
        goto L10
    L5:
        r5 = r11;
        goto L7
    }
}
