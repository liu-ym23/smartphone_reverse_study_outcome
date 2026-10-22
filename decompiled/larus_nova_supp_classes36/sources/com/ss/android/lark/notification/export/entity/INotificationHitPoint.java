package com.ss.android.lark.notification.export.entity;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface INotificationHitPoint {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/notification/export/entity/INotificationHitPoint$ChatType;", "", "Companion", "notification-export_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface ChatType {
        public static final String CHAT_TYPE_DOC = "doc";
        public static final String CHAT_TYPE_GROUP = "group";
        public static final String CHAT_TYPE_GROUP_TOPIC = "group_topic";
        public static final String CHAT_TYPE_MEETING = "group_meeting";
        public static final String CHAT_TYPE_SINGLE = "single";
        public static final String CHAT_TYPE_SINGLE_BOT = "single_bot";
        public static final a Companion = null;

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

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/notification/export/entity/INotificationHitPoint$NoticeType;", "", "Companion", "notification-export_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface NoticeType {
        public static final String AT = "at";
        public static final String BUZZ = "buzz";
        public static final a Companion = null;
        public static final String DOC = "doc";
        public static final String MESSAGE = "message";
        public static final String OTHER = "other";
        public static final String REACTION = "reaction";

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
}
