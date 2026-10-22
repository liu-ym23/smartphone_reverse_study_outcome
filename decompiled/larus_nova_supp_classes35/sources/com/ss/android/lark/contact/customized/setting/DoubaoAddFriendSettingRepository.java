package com.ss.android.lark.contact.customized.setting;

import com.bytedance.lark.pb.settings.v1.WayToAddFriendItem;
import com.ss.android.lark.officesdk.contact.api.model.DoubaoAddFriendSettingType;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class DoubaoAddFriendSettingRepository {
    public static final Lazy a = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[WayToAddFriendItem.values().length];
            r0[WayToAddFriendItem.WAY_TO_ADD_FRIEND_ITEM_CHAT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L29:
            r0[WayToAddFriendItem.WAY_TO_ADD_FRIEND_ITEM_CONTACT_TOKEN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L39:
            r0[WayToAddFriendItem.WAY_TO_ADD_FRIEND_ITEM_NAME_CARD.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L31:
            r0[WayToAddFriendItem.WAY_TO_ADD_FRIEND_ITEM_DOCS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L20
        L10:
            a = r0;
            int[] r1 = new int[DoubaoAddFriendSettingType.values().length];
            r1[DoubaoAddFriendSettingType.GROUP_CHAT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L35:
            r1[DoubaoAddFriendSettingType.QR_CODE_AND_LINK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L25:
            r1[DoubaoAddFriendSettingType.NAME_CARD.ordinal()] = 3;     // Catch: NoSuchFieldError -> L23
        L33:
            r1[DoubaoAddFriendSettingType.DOCUMENT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L24
        L15:
            b = r1;
        }
    }

    static {
        a = LazyKt.lazy(DoubaoAddFriendSettingRepository$listeners$2.INSTANCE);
    }
}
