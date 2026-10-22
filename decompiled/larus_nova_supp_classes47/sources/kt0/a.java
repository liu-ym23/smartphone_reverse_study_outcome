package kt0;

import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfilePoiInfo;
import com.bytedance.android.live.base.model.user.ProfileTagContent;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements jt0.a {
    public a() {
    }

    @Override // jt0.a
    public final void a() {
    }

    @Override // jt0.a
    public final List<ProfileTagContent> b(List<? extends ProfileTagContent> r5, NewProfileUser r6) {
        Intrinsics.checkNotNullParameter(r6, "user");
        ProfilePoiInfo r7 = r6.baseProfileInfo.poiInfo;
        if (r7 == null) goto L5;
        long r2 = r7.getPoiId();
    L7:
        if (r2 > 0) goto L9;
        return r5;
    L9:
        if (r5 == null) goto L12;
        List<ProfileTagContent> r8 = CollectionsKt.toMutableList(r5);
        if (r8 == null) goto L12;
    L13:
        ProfileTagContent r9 = new ProfileTagContent();
        r9.tagType = ProfileTagContent.TAG_TYPE_POI;
        r9.tagName = "poi";
        Unit r0 = Unit.INSTANCE;
        ListProtector.add(r8, 0, r9);
        return r8;
    L12:
        r8 = new ArrayList();
        goto L13
    L5:
        r2 = 0;
        goto L7
    }
}
