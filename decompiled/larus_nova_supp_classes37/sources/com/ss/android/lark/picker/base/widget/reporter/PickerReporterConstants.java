package com.ss.android.lark.picker.base.widget.reporter;

import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchChatInfo;
import com.ss.android.lark.search.dto.info.SearchChatterInfo;
import com.ss.android.lark.search.dto.info.SearchDepartmentInfo;
import com.ss.android.lark.search.dto.info.SearchMailContactInfo;
import com.ss.android.lark.search.dto.info.SearchSpaceInfo;
import com.ss.android.lark.search.dto.info.SearchThreadInfo;
import com.ss.android.lark.search.dto.info.SearchUserGroupInfo;
import com.ss.android.lark.search.dto.info.SearchWikiInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/picker/base/widget/reporter/PickerReporterConstants;", "", "<init>", "()V", "KEY", "VALUE", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class PickerReporterConstants {
    public static final PickerReporterConstants INSTANCE = null;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/picker/base/widget/reporter/PickerReporterConstants$KEY;", "", "<init>", "()V", "SCENE", "", "CLICK", "TARGET", "TYPE", "POSITION", "ENTITY_ID", "LIST_NUMBER", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class KEY {
        public static final String CLICK = "click";
        public static final String ENTITY_ID = "entity_id";
        public static final KEY INSTANCE = null;
        public static final String LIST_NUMBER = "list_number";
        public static final String POSITION = "list_number";
        public static final String SCENE = "scene";
        public static final String TARGET = "target";
        public static final String TYPE = "select_type";

        static {
            INSTANCE = new KEY();
        }

        private KEY() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/picker/base/widget/reporter/PickerReporterConstants$VALUE;", "", "<init>", "()V", "SCENE", "CLICK", "TYPE", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class VALUE {
        public static final VALUE INSTANCE = null;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/picker/base/widget/reporter/PickerReporterConstants$VALUE$CLICK;", "", "<init>", "()V", "BAR", "", "SELECT", "ORGANIZATION", "MAIL", "B2B", "EXTERNAL", "OWN_GROUP", "REMOVE", "PROFILE", "NAVIGATION_BAR", "NEXT_DEPARTMENT_LEVEL", "USER_GROUP", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
        public static final class CLICK {
            public static final String B2B = "associated_organizations";
            public static final String BAR = "search_bar";
            public static final String EXTERNAL = "external";
            public static final CLICK INSTANCE = null;
            public static final String MAIL = "email_member";
            public static final String NAVIGATION_BAR = "navigation_bar";
            public static final String NEXT_DEPARTMENT_LEVEL = "next_level";
            public static final String ORGANIZATION = "architecture_member";
            public static final String OWN_GROUP = "manage_group";
            public static final String PROFILE = "view_profile";
            public static final String REMOVE = "remove";
            public static final String SELECT = "select";
            public static final String USER_GROUP = "user_group";

            static {
                INSTANCE = new CLICK();
            }

            private CLICK() {
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/picker/base/widget/reporter/PickerReporterConstants$VALUE$SCENE;", "", "<init>", "()V", "OTHERS", "", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
        public static final class SCENE {
            public static final SCENE INSTANCE = null;
            public static final String OTHERS = "others";

            static {
                INSTANCE = new SCENE();
            }

            private SCENE() {
            }
        }

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0005J\u0006\u0010\u0013\u001a\u00020\u0005J\u0006\u0010\u0014\u001a\u00020\u0005J\u0006\u0010\u0015\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/picker/base/widget/reporter/PickerReporterConstants$VALUE$TYPE;", "", "<init>", "()V", "GROUP", "", "CRYPTO_GROUP", "MEMBER", "TOPIC", "DOC", "WIKI", "BOT", "DEPARTMENT", "MAIL_MEMBER", "USER_GROUP", "toType", "data", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", TYPE.MEMBER, TYPE.GROUP, "mailMember", TYPE.DEPARTMENT, "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
        public static final class TYPE {
            private static final String BOT = "bot";
            private static final String CRYPTO_GROUP = "crypto_group";
            private static final String DEPARTMENT = "department";
            private static final String DOC = "doc";
            private static final String GROUP = "group";
            public static final TYPE INSTANCE = null;
            private static final String MAIL_MEMBER = "email_member";
            private static final String MEMBER = "member";
            private static final String TOPIC = "topic";
            private static final String USER_GROUP = "user_group";
            private static final String WIKI = "wiki";

            static {
                INSTANCE = new TYPE();
            }

            private TYPE() {
            }

            public final String department() {
                return DEPARTMENT;
            }

            public final String group() {
                return GROUP;
            }

            public final String mailMember() {
                return "email_member";
            }

            public final String member() {
                return MEMBER;
            }

            public final String toType(SearchBaseInfo r3) {
                Intrinsics.checkNotNullParameter(r3, "data");
                if ((r3 instanceof SearchChatInfo) == false) goto L9;
                if (((SearchChatInfo) r3).isSecretChat() == true) goto L46;
                return GROUP;
            L46:
                return CRYPTO_GROUP;
            L9:
                if ((r3 instanceof SearchChatterInfo) == false) goto L18;
                SearchChatterInfo r4 = (SearchChatterInfo) r3;
                if (r4.isP2pCryptoChat() == false) goto L14;
                return CRYPTO_GROUP;
            L14:
                if (r4.getChatterType() != Chatter.ChatterType.BOT) goto L16;
                return "bot";
            L16:
                return MEMBER;
            L18:
                if ((r3 instanceof SearchThreadInfo) == false) goto L21;
                return TOPIC;
            L21:
                if ((r3 instanceof SearchSpaceInfo) == false) goto L24;
                return DOC;
            L24:
                if ((r3 instanceof SearchWikiInfo) == false) goto L27;
                return WIKI;
            L27:
                if ((r3 instanceof SearchDepartmentInfo) == false) goto L30;
                return DEPARTMENT;
            L30:
                if ((r3 instanceof SearchMailContactInfo) == false) goto L33;
                return "email_member";
            L33:
                if ((r3 instanceof SearchUserGroupInfo) == false) goto L35;
                return "user_group";
            L35:
                return "";
            }
        }

        static {
            INSTANCE = new VALUE();
        }

        private VALUE() {
        }
    }

    static {
        INSTANCE = new PickerReporterConstants();
    }

    private PickerReporterConstants() {
    }
}
