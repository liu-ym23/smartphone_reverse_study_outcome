package com.larus.bmhome.bot;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/bmhome/bot/SettingsItemType;", "", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public @interface SettingsItemType {
    public static final String ABOUT_DOUBAO = "setting.about_doubao";
    public static final a Companion = null;
    public static final String DEBUG = "setting.debug";
    public static final String DEFAULT_REPLY_MODE = "setting.default_reply_mode";
    public static final String DOUBAO_WEBSITE = "setting.doubao_website";
    public static final String DRIVE_STORAGE = "setting.drive_storage";
    public static final String FORK_CONVERSATION = "setting.fork_conversation";
    public static final String INDEPENDENT_REPLY_MODE = "setting.independent_reply_mode";
    public static final String INDEPENDENT_REPLY_MODEL = "setting.independent_reply_model";
    public static final String MEMBERSHIP = "setting.membership";
    public static final String MEMORY = "setting.memory";
    public static final String OFFICE_TASK_SETTINGS = "setting.office_task_settings";
    public static final String PRIVACY_PERMISSION = "setting.privacy_permission";
    public static final String RELATED_VIDEO = "setting.related_video";
    public static final String RENEW_SECTION = "setting.new_topic";
    public static final String SAAS_ACCOUNT_BIND = "setting.saas_account_bind";
    public static final String SEARCH_SECTION = "setting.search_chat";
    public static final String STARTUP_OPEN_NEW_CHAT = "setting.startup_open_new_chat";
    public static final String TTS_SPEAKER_ITEM = "setting.tts_speaker";
    public static final String UNKNOWN = "setting.unknown";

    public static final class a {
        public static final /* synthetic */ a a = null;

        static {
            a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.a;
    }
}
