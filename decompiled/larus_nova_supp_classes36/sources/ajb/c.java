package ajb;

import com.bytedance.lark.pb.feed.v1.ForwardCommonData;
import com.ss.android.lark.forwardv3.utils.ForwardDataUtils;
import com.ss.android.lark.parser.internal.a0;
import com.ss.android.lark.search.dto.Scene;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c {
    public static final void a(SearchBaseInfo r2, ForwardCommonData r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "commonData");
        r2.setId(r3.id.toString());
        r2.setTitle(r3.title);
        r2.setTagData(a0.a(r3.tag_data));
        r2.setCrossTenant(r3.is_cross_tenant.booleanValue());
        r2.setCrossWithKa(r3.is_cross_with_ka.booleanValue());
        r2.setSubTitle(r3.subTitle);
        r2.setAvatarKey(r3.avatar_key);
        r2.setHeaderId(0);
        r2.setHeaderLabel(ForwardDataUtils.d);
        r2.setScene(Scene.Type.TRANSMIT_MESSAGES);
        r2.setTimeStamp(r3.timestamp.longValue());
    }
}
