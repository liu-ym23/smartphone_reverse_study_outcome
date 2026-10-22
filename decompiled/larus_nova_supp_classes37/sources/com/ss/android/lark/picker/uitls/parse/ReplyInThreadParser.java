package com.ss.android.lark.picker.uitls.parse;

import com.bytedance.lark.pb.feed.v1.ForwardCommonData;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchReplyInThreadInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/picker/uitls/parse/ReplyInThreadParser;", "Lcom/ss/android/lark/picker/uitls/parse/IParse;", "Lcom/bytedance/lark/pb/feed/v1/ForwardCommonData$ReplyInThreadInfo;", "<init>", "()V", "parse", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "commonData", "Lcom/bytedance/lark/pb/feed/v1/ForwardCommonData;", "info", "Companion", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class ReplyInThreadParser implements IParse<ForwardCommonData.ReplyInThreadInfo> {
    private static final Companion Companion = null;
    private static final String TAG = "ReplyInThreadParser";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/picker/uitls/parse/ReplyInThreadParser$Companion;", "", "<init>", "()V", "TAG", "", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
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

    public ReplyInThreadParser() {
    }

    /* JADX INFO: renamed from: parse, reason: avoid collision after fix types in other method */
    public SearchBaseInfo parse2(ForwardCommonData r7, ForwardCommonData.ReplyInThreadInfo r8) {
        Intrinsics.checkNotNullParameter(r7, "commonData");
        if (r8 != null) goto L5;
        Log.e(TAG, "ForwardCommonData id is: " + r7.id + ", ForwardCommonData type is: " + r7.item_type);
        Unit r0 = Unit.INSTANCE;
    L5:
        if (r8 == null) goto L25;
        SearchReplyInThreadInfo r1 = IParseKt.addCommonParams(new SearchReplyInThreadInfo(), r7);
        Long r2 = r8.p2p_chatter_id;
        if (r2 != null) goto L10;
    L11:
        Chat.Type r3 = Chat.Type.P2P;
    L13:
        r1.setChatType(r3);
        Long r9 = r7.chat_id;
        String r4 = "";
        if (r9 == null) goto L17;
        String r10 = r9.toString();
        if (r10 == null) goto L17;
    L18:
        r1.setChatId(r10);
        Long r11 = r8.p2p_chatter_id;
        if (r11 == null) goto L24;
        String r12 = r11.toString();
        if (r12 == null) goto L24;
        r4 = r12;
    L24:
        r1.setP2pChatterId(r4);
        return r1;
    L17:
        r10 = "";
        goto L18
    L10:
        if (r2.longValue() != 0) goto L11;
        r3 = Chat.Type.UNKNOWN;
        goto L13
    L25:
        return null;
    }

    @Override // com.ss.android.lark.picker.uitls.parse.IParse
    public /* bridge */ /* synthetic */ SearchBaseInfo parse(ForwardCommonData r1, ForwardCommonData.ReplyInThreadInfo r2) {
        return parse2(r1, r2);
    }
}
