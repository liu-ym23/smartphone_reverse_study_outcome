package com.bytedance.android.live.liveinteract.jsbridge.method;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.browser.jsbridge.base.SearchFriendResultModel;
import com.bytedance.android.livehostapi.platform.IMiddlewareHostAction;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import w20.r5;
import w20.ud;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@XBridgeMethod(biz = "webcast", name = "searchFriend")
public final class e1 extends r5<ud, SearchFriendResultModel> {
    public e1() {
    }

    public static SearchFriendResultModel.b j(String r7, String r8) {
        boolean r0 = true;
        if (r7 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L24;
        if (StringsKt.isBlank(r8) == true) goto L14;
        r0 = false;
    L14:
        if (r0 == true) goto L24;
        if (StringsKt.contains$default(r7, r8, false, 2, null) == false) goto L24;
        int r1 = StringsKt.indexOf$default(r7, r8, 0, false, 6, null);
        int r9 = r8.length() + r1;
        if (r9 < r7.length()) goto L21;
        r9 = r7.length();
    L21:
        SearchFriendResultModel.b r10 = new SearchFriendResultModel.b();
        r10.b(Integer.valueOf(r1));
        r10.a(Integer.valueOf(r9));
        return r10;
    L24:
        return new SearchFriendResultModel.b();
    L5:
        if (StringsKt.isBlank(r7) == true) goto L8;
        r2 = false;
        goto L9
    }

    public final void invoke(Object r8, CallContext r9) {
        ud r10 = (ud) r8;
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r9, "context");
        String r11 = r10.a();
        if (r11 != null) goto L5;
        r11 = "";
    L5:
        ArrayList r0 = new ArrayList();
        jc1.k.n(IMiddlewareHostAction.class).searchIMFriend(r11, r0);
        ArrayList r1 = new ArrayList();
        Iterator r2 = r0.iterator();
    L7:
        if (r2.hasNext() == false) goto L27;
        IBaseUser r3 = (IBaseUser) r2.next();
        SearchFriendResultModel.c r4 = new SearchFriendResultModel.c();
        r4.g(Long.valueOf(d5.c(r3.getIdString())));
        String r5 = r3.getDisplayId();
        if (r5 != null) goto L11;
        r5 = "";
    L11:
        r4.a(r5);
        String r6 = r3.getNickName();
        if (r6 != null) goto L14;
        r6 = "";
    L14:
        r4.e(r6);
        String r7 = r3.getAvatarUrl();
        if (r7 != null) goto L17;
        r7 = "";
    L17:
        r4.b(r7);
        Intrinsics.checkNotNullParameter(r3, "$this$secUidExt");
        String r12 = r3.getCastSecUid();
        if (r12 != null) goto L20;
        r12 = "";
    L20:
        r4.f(r12);
        r4.d(Integer.valueOf(r3.getSearchType()));
        if (r3.getSearchType() != 1) goto L24;
        r4.d(2);
        r4.c(j(r3.getDisplayId(), r11));
    L26:
        r1.add(r4);
        goto L7
    L24:
        if (r3.getSearchType() != 3) goto L26;
        r4.d(1);
        r4.c(j(r3.getNickName(), r11));
        goto L26
    L27:
        SearchFriendResultModel r13 = new SearchFriendResultModel();
        r13.a(SearchFriendResultModel.Code.Success);
        SearchFriendResultModel.a r14 = new SearchFriendResultModel.a();
        r14.a(r1);
        r13.b(r14);
        finishWithResult(r13);
    }
}
