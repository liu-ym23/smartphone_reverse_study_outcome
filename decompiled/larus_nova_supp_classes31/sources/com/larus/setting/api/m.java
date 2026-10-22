package com.larus.setting.api;

import com.ss.android.lark.officesdk.contact.api.model.DoubaoAddFriendSettingType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class m {
    public static final /* synthetic */ int a = 0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[DoubaoAddFriendSettingType.values().length];
            r0[DoubaoAddFriendSettingType.GROUP_CHAT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[DoubaoAddFriendSettingType.QR_CODE_AND_LINK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[DoubaoAddFriendSettingType.NAME_CARD.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[DoubaoAddFriendSettingType.DOCUMENT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    static {
    }
}
