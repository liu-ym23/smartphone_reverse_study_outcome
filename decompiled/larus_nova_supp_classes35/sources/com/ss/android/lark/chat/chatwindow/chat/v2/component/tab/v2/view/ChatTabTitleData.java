package com.ss.android.lark.chat.chatwindow.chat.v2.component.tab.v2.view;

import com.ss.android.lark.chat.entity.chat.ChatTab;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.jvm.internal.Intrinsics;
import y28.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ChatTabTitleData implements b<ChatTabTitleData> {

    @Target({ElementType.TYPE, ElementType.PARAMETER, ElementType.TYPE_USE})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/tab/v2/view/ChatTabTitleData$TabTitleType;", BuildConfig.FLAVOR, "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS, AnnotationTarget.PROPERTY, AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.TYPE})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface TabTitleType {
        public static final int ADD = 1;
        public static final int COMMON = 0;
        public static final a Companion = null;
        public static final int MANAGER = 2;
        public static final int UNKNOWN = -1;

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

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof ChatTabTitleData) == true) goto L8;
        return false;
    L8:
        ((ChatTabTitleData) r4).getClass();
        if (Intrinsics.areEqual(null, null) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(null, null) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final ChatTab.ChatTabType getType() {
        return null;
    }

    public final int hashCode() {
        throw null;
    }

    public final String toString() {
        return "ChatTabTitleData(id=0, name=null, type=null, iconRender=null, hasBadge=false, count=0, isEnabled=false, itemType=0, isSelected=false)";
    }

    public final boolean isContentSame(b r4) {
        ChatTabTitleData r5 = (ChatTabTitleData) r4;
        if (this != r5) goto L6;
    L18:
        return true;
    L6:
        if (r5 == null) goto L8;
        Class<ChatTabTitleData> r2 = ChatTabTitleData.class;
    L10:
        if (Intrinsics.areEqual(ChatTabTitleData.class, r2) == false) goto L17;
        r5.getClass();
        if (Intrinsics.areEqual(null, null) == false) goto L17;
        if (Intrinsics.areEqual(null, null) == true) goto L18;
    L17:
        return false;
    L8:
        r2 = null;
        goto L10
    }

    public final boolean isItemSame(b r1) {
        if (((ChatTabTitleData) r1) == null) goto L5;
        return true;
    L5:
        return false;
    }
}
