package com.ss.android.lark.picker.uitls.parse;

import com.bytedance.lark.pb.feed.v1.ForwardCommonData;
import com.ss.android.lark.parser.internal.a0;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.search.dto.Scene;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.utils.UIHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a!\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u0002H\u00012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"addCommonParams", "B", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "commonData", "Lcom/bytedance/lark/pb/feed/v1/ForwardCommonData;", "(Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;Lcom/bytedance/lark/pb/feed/v1/ForwardCommonData;)Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "picker_release"}, k = 2, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class IParseKt {
    public static final <B extends SearchBaseInfo> B addCommonParams(B r1, ForwardCommonData r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "commonData");
        r1.setId(r2.id.toString());
        r1.setTitle(r2.title);
        r1.setTagData(a0.a(r2.tag_data));
        r1.setCrossTenant(r2.is_cross_tenant.booleanValue());
        r1.setCrossWithKa(r2.is_cross_with_ka.booleanValue());
        r1.setSubTitle(r2.subTitle);
        r1.setAvatarKey(r2.avatar_key);
        r1.setHeaderId(0);
        r1.setHeaderLabel(UIHelper.getString(2131891299));
        r1.setScene(Scene.Type.TRANSMIT_MESSAGES);
        return r1;
    }
}
