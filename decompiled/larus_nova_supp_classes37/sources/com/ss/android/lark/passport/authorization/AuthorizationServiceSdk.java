package com.ss.android.lark.passport.authorization;

import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.passport.dpop.b;
import com.ss.android.lark.picker.base.view.ItemViewType;
import e0c.k;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/passport/authorization/AuthorizationServiceSdk;", "", "<init>", "()V", "getTokenValue", "", "passport-base-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class AuthorizationServiceSdk {
    public static final AuthorizationServiceSdk INSTANCE = null;

    static {
        INSTANCE = new AuthorizationServiceSdk();
    }

    private AuthorizationServiceSdk() {
    }

    @JvmStatic
    public static final byte[] getTokenValue() {
        LarkAppContext.Companion.getClass();
        return ((b) k.a(LarkAppContext.access$getInstance$cp().getContext(), b.class)).getAccessToken().getBytes(Charsets.UTF_8);
    }
}
