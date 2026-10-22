package com.ss.android.lark.picker.doubao.view.pickercommon;

import com.ss.android.lark.chat.entity.Channel;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchChatInfo;
import com.ss.android.lark.search.dto.info.SearchReplyInThreadInfo;
import com.ss.android.lark.search.dto.info.SearchThreadInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\bJ\u0017\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/picker/doubao/view/pickercommon/DoubaoThreadAvatar;", "", "<init>", "()V", "mainIconRes", "", "info", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "(Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;)Ljava/lang/Integer;", "badgeIconRes", "avatarEntityId", "", "picker-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class DoubaoThreadAvatar {
    public static final DoubaoThreadAvatar INSTANCE = null;

    static {
        INSTANCE = new DoubaoThreadAvatar();
    }

    private DoubaoThreadAvatar() {
    }

    public final String avatarEntityId(SearchBaseInfo r4) {
        Intrinsics.checkNotNullParameter(r4, "info");
        if ((r4 instanceof SearchReplyInThreadInfo) == false) goto L6;
        return ((SearchReplyInThreadInfo) r4).getEntityId();
    L6:
        if ((r4 instanceof SearchThreadInfo) == false) goto L24;
        SearchThreadInfo r5 = (SearchThreadInfo) r4;
        Channel r0 = r5.getChannel();
        if (r0 == null) goto L21;
        String r1 = r0.getId();
        if (r1 == null) goto L21;
        if (r1.length() <= 0) goto L14;
        boolean r2 = true;
    L15:
        if (r2 == true) goto L18;
        r1 = null;
    L18:
        if (r1 == null) goto L21;
        return r1;
    L14:
        r2 = false;
    L21:
        String r6 = r5.getChatId();
        if (r6 == null) goto L27;
        return r6;
    L27:
        return "";
    L24:
        String r7 = r4.getId();
        if (r7 == null) goto L27;
        return r7;
    }

    public final Integer badgeIconRes(SearchBaseInfo r3) {
        Intrinsics.checkNotNullParameter(r3, "info");
        if ((r3 instanceof SearchChatInfo) == true) goto L5;
        return null;
    L5:
        if (((SearchChatInfo) r3).isThread() == true) goto L7;
        return null;
    L7:
        return 2131237912;
    }

    public final Integer mainIconRes(SearchBaseInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "info");
        if ((r2 instanceof SearchReplyInThreadInfo) == true) goto L9;
        if ((r2 instanceof SearchThreadInfo) == true) goto L9;
        return null;
    L9:
        return 2131237911;
    }
}
