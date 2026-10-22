package com.ss.android.lark.picker.uitls.parse;

import com.bytedance.lark.pb.feed.v1.ForwardCommonData;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchChatterInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/picker/uitls/parse/ChatterParser;", "Lcom/ss/android/lark/picker/uitls/parse/IParse;", "Lcom/bytedance/lark/pb/feed/v1/ForwardCommonData$ChatterInfo;", "<init>", "()V", "parse", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "commonData", "Lcom/bytedance/lark/pb/feed/v1/ForwardCommonData;", "info", "Companion", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class ChatterParser implements IParse<ForwardCommonData.ChatterInfo> {
    private static final Companion Companion = null;
    private static final String TAG = "ChatterParser";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/picker/uitls/parse/ChatterParser$Companion;", "", "<init>", "()V", "TAG", "", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
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

    public ChatterParser() {
    }

    /* JADX INFO: renamed from: parse, reason: avoid collision after fix types in other method */
    public SearchBaseInfo parse2(ForwardCommonData r4, ForwardCommonData.ChatterInfo r5) {
        Intrinsics.checkNotNullParameter(r4, "commonData");
        if (r5 != null) goto L5;
        Log.e(TAG, "ForwardCommonData id is: " + r4.id + ", ForwardCommonData type is: " + r4.item_type);
        Unit r0 = Unit.INSTANCE;
    L5:
        if (r5 == null) goto L18;
        SearchChatterInfo r1 = IParseKt.addCommonParams(new SearchChatterInfo(), r4);
        Long r2 = r5.chatter_id;
        String r3 = "";
        if (r2 == null) goto L10;
        String r6 = r2.toString();
        if (r6 == null) goto L10;
    L11:
        r1.setId(r6);
        Long r7 = r4.chat_id;
        if (r7 == null) goto L17;
        String r8 = r7.toString();
        if (r8 == null) goto L17;
        r3 = r8;
    L17:
        r1.setP2pChatId(r3);
        r1.setType(1);
        r1.setStatusList(r5.customStatus);
        r1.setZenModeEndTime(r5.doNotDisturbEndTime.longValue());
        r1.setChatterType(Chatter.ChatterType.forNumber(r5.chatter_type.getValue()));
        return r1;
    L10:
        r6 = "";
        goto L11
    L18:
        return null;
    }

    @Override // com.ss.android.lark.picker.uitls.parse.IParse
    public /* bridge */ /* synthetic */ SearchBaseInfo parse(ForwardCommonData r1, ForwardCommonData.ChatterInfo r2) {
        return parse2(r1, r2);
    }
}
