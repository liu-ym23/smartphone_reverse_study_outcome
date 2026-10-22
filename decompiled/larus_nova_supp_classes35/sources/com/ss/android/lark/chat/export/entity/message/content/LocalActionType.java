package com.ss.android.lark.chat.export.entity.message.content;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Target({ElementType.PARAMETER})
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/chat/export/entity/message/content/LocalActionType;", BuildConfig.FLAVOR, "Companion", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.VALUE_PARAMETER})
@Retention(RetentionPolicy.SOURCE)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface LocalActionType {
    public static final int ACTION_URL = 0;
    public static final int CHATTER_TOOL_TIP = 3;
    public static final a Companion = null;
    public static final int INVITE_AT_CHATTERS = 2;
    public static final int LARK_COMMAND = 1;

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
