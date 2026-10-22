package com.ss.android.lark.member_manage.export;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface JoinGroupChatWays {
    public static final int UNKNOWN_WAY = 0;
    public static final int VIA_CHAT_LINKED_PAGE = 10;
    public static final int VIA_DEPARTMENT_STRUCTURE = 5;
    public static final int VIA_INVITATION = 2;
    public static final int VIA_LINK = 6;
    public static final int VIA_QR_CODE = 3;
    public static final int VIA_SEARCH = 4;
    public static final int VIA_SHARE = 1;
    public static final int VIA_TEAM_OPEN_CHAT = 7;
}
