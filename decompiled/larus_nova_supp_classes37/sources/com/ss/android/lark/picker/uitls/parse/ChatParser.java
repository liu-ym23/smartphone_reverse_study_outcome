package com.ss.android.lark.picker.uitls.parse;

import com.bytedance.lark.pb.feed.v1.ForwardCommonData;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chat.ChatDisplayModeSetting;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchChatInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/picker/uitls/parse/ChatParser;", "Lcom/ss/android/lark/picker/uitls/parse/IParse;", "Lcom/bytedance/lark/pb/feed/v1/ForwardCommonData$ChatInfo;", "<init>", "()V", "parse", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "commonData", "Lcom/bytedance/lark/pb/feed/v1/ForwardCommonData;", "info", "Companion", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class ChatParser implements IParse<ForwardCommonData.ChatInfo> {
    private static final Companion Companion = null;
    private static final String TAG = "ChatParser";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/picker/uitls/parse/ChatParser$Companion;", "", "<init>", "()V", "TAG", "", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public ChatParser() {
    }

    /* JADX INFO: renamed from: parse, reason: avoid collision after fix types in other method */
    public SearchBaseInfo parse2(ForwardCommonData r3, ForwardCommonData.ChatInfo r4) {
        Intrinsics.checkNotNullParameter(r3, "commonData");
        if (r4 != null) goto L5;
        Log.e(TAG, "ForwardCommonData id is: " + r3.id + ", ForwardCommonData type is: " + r3.item_type);
        Unit r0 = Unit.INSTANCE;
    L5:
        if (r4 == null) goto L7;
        SearchChatInfo r5 = IParseKt.addCommonParams(new SearchChatInfo(), r3);
        r5.setType(2);
        r5.setOfficialOnCall(r4.is_official_oncall.booleanValue());
        r5.setShield(r4.is_shield_mode.booleanValue());
        r5.setChatMode(Chat.ChatMode.forNumber(r4.chat_type.getValue()));
        ChatDisplayModeSetting.a r1 = ChatDisplayModeSetting.Companion;
        com.bytedance.lark.pb.basic.v1.Chat.ChatDisplayModeSetting.Enum r2 = r4.chat_display_mode_setting;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "pb");
        r5.setChatDisplayModeSetting(ChatDisplayModeSetting.a.a(r2.getValue()));
        r5.setUserCount(r4.chat_user_count.intValue());
        r5.setCountLightStyle(true);
        r5.setDepartment(r4.is_department.booleanValue());
        r5.setPublic(r4.is_public.booleanValue());
        r5.setUserCountVisible(r4.is_user_count_visible.booleanValue());
        r5.setChatType(Chat.Type.GROUP);
        return r5;
    L7:
        return null;
    }

    @Override // com.ss.android.lark.picker.uitls.parse.IParse
    public /* bridge */ /* synthetic */ SearchBaseInfo parse(ForwardCommonData r1, ForwardCommonData.ChatInfo r2) {
        return parse2(r1, r2);
    }
}
