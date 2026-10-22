package com.ss.android.lark.notification.export;

import atb.a;
import com.ss.android.lark.notification.export.entity.Notice;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public abstract class AbstractNotification<T extends Notice, R extends atb.a> {

    public static abstract class AbstractNotificationDisplayer<R extends atb.a> {

        @Retention(RetentionPolicy.SOURCE)
        public @interface ShowStrategy {
            public static final int IMMEDIATELY = 0;
            public static final int IN_QUEUE = 1;
        }

        public interface a<R extends atb.a> {
            void a(R r1);
        }

        public AbstractNotificationDisplayer() {
        }

        public abstract a<R> a();

        public abstract R b(Notice r1);

        public abstract boolean c(Notice r1);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ActionType {
        public static final int CANCEL = 1;
        public static final int SHOW = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface CHANNEL_TYPE {
        public static final String APP_NOTIFICATION = "app_notification";
        public static final String AT = "at_v2";
        public static final String DING = "ding_v2";
        public static final String DOC_FEED = "doc_feed";
        public static final String MM_EXTENSION = "mm_extension";
        public static final String MM_EXTENSION_NEW = "mm_extension_new";
        public static final String MM_PLAY_NOTICE = "mm_play_notice";
        public static final String MM_RECORDING = "mm_recording";
        public static final String NEW_MAIL = "newMail";
        public static final String NORMAL = "normal_v2";
        public static final String OPEN_FEED = "feed_push";
        public static final String PUSH_OPLUS_CATEGORY_CONTENT = "push_oplus_category_content";
        public static final String SCHEDULE_CAL_REMINDER = "scheduleCalReminder";
        public static final String VC_FOREGROUND = "vc_foreground";
        public static final String VC_HARDWARE = "vc_hardware";
        public static final String VC_RINGING_VOIP = "vc_ringing_voip";
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface NoticeType {
        public static final int CALENDAR_REMINDER = 10001;
        public static final int CHAT_APPLICATION = 6;
        public static final int CHAT_APPLY = 8;
        public static final int DOCFEED = 10000;
        public static final int DOC_IMAGE_REPLY = 9;
        public static final int FAILED = 10002;
        public static final int MAIL = 7;
        public static final int MEDIA_UPLOAD = 13;
        public static final int MESSAGE = 2;
        public static final int OFFLINE = 20001;
        public static final int OFFLINE_VOIP = 20002;
        public static final int OPEN_APP = 10;
        public static final int OPEN_APP_CHAT = 11;
        public static final int OPEN_APP_FEED = 14;
        public static final int REACTION = 4;
        public static final int TODO_REMINDER = 10010;
        public static final int URGENT = 3;
        public static final int URGENT_ACK = 5;
        public static final int URGENT_FAILED = 12;
        public static final int VC_CALENDAR_PROMPT = 10006;
        public static final int VIDEO_CHAT_RING = 10004;
        public static final int VOIP_MISS_CALL = 10003;
        public static final int VOIP_RING = 10005;
    }

    public interface a {
        void a(Notice r1);
    }

    public interface b<T extends Notice> {
        T a(Notice r1);

        int b(Notice r1);
    }

    public AbstractNotification() {
    }

    public b<T> a() {
        return null;
    }

    public a b() {
        return null;
    }

    public abstract AbstractNotificationDisplayer<R> c();

    public abstract int getType();
}
