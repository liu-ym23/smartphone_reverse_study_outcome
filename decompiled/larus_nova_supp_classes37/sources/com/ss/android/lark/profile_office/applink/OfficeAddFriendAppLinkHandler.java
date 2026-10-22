package com.ss.android.lark.profile_office.applink;

import android.content.Context;
import com.bytedance.lark.pb.basic.v1.Chatter;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.applink.AppLink;
import com.ss.android.lark.contact.export.ContactSource;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.profile.utils.IProfileLauncherV2;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import ova.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class OfficeAddFriendAppLinkHandler extends d {
    public static final Lazy<Pattern> a = null;

    public static final class a {
    }

    public final boolean b(Context r1, AppLink r2) {
        return true;
    }

    static {
        a = LazyKt.lazy(OfficeAddFriendAppLinkHandler$Companion$CONTACT_URL_PATTERN$2.INSTANCE);
    }

    public OfficeAddFriendAppLinkHandler() {
    }

    public final boolean a(Context r13, AppLink r14) {
        boolean r0 = false;
        if (r13 != null) goto L5;
    L32:
        return false;
    L5:
        if (r14.a.length() != 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L32;
        String r2 = r14.a;
        if (((Pattern) a.getValue()).matcher(r2).matches() == false) goto L13;
    L15:
        String r3 = UriProtector.getQueryParameter(UriProtector.parse(r2), AppbrandHostConstants.Schema_RESERVED_FIELD.TOKEN);
    L16:
        String r7 = r3;
        if (r7 != null) goto L19;
    L22:
        boolean r4 = true;
    L24:
        if (r4 == false) goto L27;
        Log.w("OfficeAddFriendAppLink", "token is empty, url=" + r14.a);
        return false;
    L27:
        StringBuilder r15 = new StringBuilder("handle add friend appLink, hasToken=");
        if (r7.length() <= 0) goto L30;
        r0 = true;
    L30:
        r15.append(r0);
        Log.i("OfficeAddFriendAppLink", r15.toString());
        ContactSource r10 = new ContactSource();
        r10.setSourceType(1);
        IProfileLauncherV2.a.getClass();
        IProfileLauncherV2.Companion.a().openUserProfileV2(r13, null, null, r7, Chatter.Type.USER, "", r10, -1);
        return true;
    L19:
        if (r7.length() == 0) goto L22;
        r4 = false;
        goto L24
    L13:
        if (Intrinsics.areEqual(UriProtector.parse(r2).getPath(), "/invitation/page/add_contact/") == true) goto L15;
        r3 = null;
        goto L16
    L7:
        r1 = false;
        goto L8
    }
}
