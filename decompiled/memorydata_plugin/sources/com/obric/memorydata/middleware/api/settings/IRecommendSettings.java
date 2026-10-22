package com.obric.memorydata.middleware.api.settings;

import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\bf\u0018\u00002\u00020\u0001:\u00011R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0012\u0010\t\u001a\u00020\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0012\u0010\r\u001a\u00020\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0012\u0010\u0011\u001a\u00020\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u0012\u0010\u0013\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0012\u0010\u0016\u001a\u00020\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0010R\u0012\u0010\u0018\u001a\u00020\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0010R\u0018\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0006R\u0018\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0006R\u0018\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0006R\u0018\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0006R\u0018\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\u0006R\u0018\u0010%\u001a\b\u0012\u0004\u0012\u00020#0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u0006R\u0018\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u0006R\u0012\u0010)\u001a\u00020*X¦\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0012\u0010-\u001a\u00020\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b.\u0010\u0010R\u0012\u0010/\u001a\u00020\nX¦\u0004¢\u0006\u0006\u001a\u0004\b0\u0010\f¨\u00062"}, d2 = {"Lcom/obric/memorydata/middleware/api/settings/IRecommendSettings;", "", "profileTag", "", "", "getProfileTag", "()Ljava/util/List;", "proactiveEnableDid", "getProactiveEnableDid", "screenshotCaptureDelta", "", "getScreenshotCaptureDelta", "()J", "qualityCompressRation", "", "getQualityCompressRation", "()I", "resolutionCompressRation", "getResolutionCompressRation", "imageStyle", "getImageStyle", "()Ljava/lang/String;", "heifQuality", "getHeifQuality", "maxWaitUploadScreenshotCount", "getMaxWaitUploadScreenshotCount", "uxpEnableDid", "getUxpEnableDid", "ignorePackages", "getIgnorePackages", "blackPackages", "getBlackPackages", "autoMemoryEnableDid", "getAutoMemoryEnableDid", "autoMemoryRecommend", "Lcom/obric/memorydata/middleware/api/settings/AutoMemoryRecommendItem;", "getAutoMemoryRecommend", "autoMemoryPresetRules", "getAutoMemoryPresetRules", "collectDid", "getCollectDid", "imageFilterEnable", "", "getImageFilterEnable", "()Z", "observationCollectViewTree", "getObservationCollectViewTree", "screenshotSamplingIntervalSeconds", "getScreenshotSamplingIntervalSeconds", "ProfileTag", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IRecommendSettings {

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/middleware/api/settings/IRecommendSettings$ProfileTag;", "", "<init>", "()V", "ALL", "", "PERSONAL_INFO", "PREFERENCES", "HOBBIES_AND_INTERESTS", "HABITS_AND_ROUTINES", "FAMILY_RELATIONSHIPS", "SOCIAL_RELATIONSHIPS", "GOALS", "PAIN_POINTS", "OTHER", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class ProfileTag {
        public static final String ALL = "全部";
        public static final String FAMILY_RELATIONSHIPS = "家庭关系";
        public static final String GOALS = "中长期目标";
        public static final String HABITS_AND_ROUTINES = "习惯和规律";
        public static final String HOBBIES_AND_INTERESTS = "兴趣爱好";
        public static final ProfileTag INSTANCE = null;
        public static final String OTHER = "其他";
        public static final String PAIN_POINTS = "痛点和阻力";
        public static final String PERSONAL_INFO = "个人信息";
        public static final String PREFERENCES = "兴趣偏好";
        public static final String SOCIAL_RELATIONSHIPS = "社交关系";

        static {
            INSTANCE = new ProfileTag();
        }

        private ProfileTag() {
        }
    }

    List<String> getAutoMemoryEnableDid();

    List<AutoMemoryRecommendItem> getAutoMemoryPresetRules();

    List<AutoMemoryRecommendItem> getAutoMemoryRecommend();

    List<String> getBlackPackages();

    List<String> getCollectDid();

    int getHeifQuality();

    List<String> getIgnorePackages();

    boolean getImageFilterEnable();

    String getImageStyle();

    int getMaxWaitUploadScreenshotCount();

    int getObservationCollectViewTree();

    List<String> getProactiveEnableDid();

    List<String> getProfileTag();

    int getQualityCompressRation();

    int getResolutionCompressRation();

    long getScreenshotCaptureDelta();

    long getScreenshotSamplingIntervalSeconds();

    List<String> getUxpEnableDid();
}
