package com.obric.assistant.interaction.base.interact;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/obric/assistant/interaction/base/interact/ObricCustomBarActionType;", "", "Companion", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public @interface ObricCustomBarActionType {
    public static final String ACTION_BAR_KEY_COMPLEX_TASK = "obric_omni";
    public static final String ACTION_BAR_KEY_FILE_PERCEIVE = "obric_document_perception";
    public static final String ACTION_BAR_KEY_IM_PERCEIVE = "obric_im_perception";
    public static final String ACTION_BAR_KEY_MOCK_CLICK = "obric_mock_click";
    public static final String ACTION_BAR_KEY_OAUTO = "obric_oauto";
    public static final String ACTION_BAR_KEY_PHONE_OPERATION = "obric_phone_operation";
    public static final String ACTION_BAR_KEY_PHOTO_PERCEIVE = "obric_photo_perception";
    public static final String ACTION_BAR_KEY_SCREEN_SHOT = "obric_screen_qa";
    public static final String ACTION_BAR_KEY_VIDEO_PERCEIVE = "obric_video_perception";
    public static final String ACTION_BAR_KEY_WEB_PERCEIVE = "obric_web_perception";
    public static final Companion Companion = null;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/assistant/interaction/base/interact/ObricCustomBarActionType$Companion;", "", "<init>", "()V", "ACTION_BAR_KEY_SCREEN_SHOT", "", "ACTION_BAR_KEY_FILE_PERCEIVE", "ACTION_BAR_KEY_WEB_PERCEIVE", "ACTION_BAR_KEY_VIDEO_PERCEIVE", "ACTION_BAR_KEY_PHOTO_PERCEIVE", "ACTION_BAR_KEY_IM_PERCEIVE", "ACTION_BAR_KEY_OAUTO", "ACTION_BAR_KEY_COMPLEX_TASK", "ACTION_BAR_KEY_PHONE_OPERATION", "ACTION_BAR_KEY_MOCK_CLICK", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final String ACTION_BAR_KEY_COMPLEX_TASK = "obric_omni";
        public static final String ACTION_BAR_KEY_FILE_PERCEIVE = "obric_document_perception";
        public static final String ACTION_BAR_KEY_IM_PERCEIVE = "obric_im_perception";
        public static final String ACTION_BAR_KEY_MOCK_CLICK = "obric_mock_click";
        public static final String ACTION_BAR_KEY_OAUTO = "obric_oauto";
        public static final String ACTION_BAR_KEY_PHONE_OPERATION = "obric_phone_operation";
        public static final String ACTION_BAR_KEY_PHOTO_PERCEIVE = "obric_photo_perception";
        public static final String ACTION_BAR_KEY_SCREEN_SHOT = "obric_screen_qa";
        public static final String ACTION_BAR_KEY_VIDEO_PERCEIVE = "obric_video_perception";
        public static final String ACTION_BAR_KEY_WEB_PERCEIVE = "obric_web_perception";

        static {
            $$INSTANCE = new Companion();
        }

        private Companion() {
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }
}
