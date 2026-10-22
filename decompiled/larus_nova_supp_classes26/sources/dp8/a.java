package dp8;

import com.larus.bmhome.creative.messagecard.bean.CreationInfo;
import com.larus.bmhome.creative.messagecard.bean.CreationMsgContentData;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    static {
    }

    public static boolean a(Message r6) {
        Intrinsics.checkNotNullParameter(r6, "sourceData");
        if (r6.getContentType() != 2022) goto L30;
        CreationMsgContentData r7 = e.c(r6);
        if (r7 == null) goto L7;
        CreationInfo r8 = r7.creationInfo;
    L8:
        long r0 = AppHost.a.getUpdateVersionCode();
        if (r8 == null) goto L15;
        String r3 = r8.supportVersion;
        if (r3 == null) goto L15;
        Long r4 = StringsKt.toLongOrNull(r3);
        if (r4 == null) goto L15;
        long r5 = r4.longValue();
    L17:
        if (r0 >= r5) goto L20;
        return false;
    L20:
        if (r8 == null) goto L27;
        Integer r9 = r8.layoutType;
        if (r9 == null) goto L27;
        if (r9.intValue() != 2) goto L27;
        boolean r10 = true;
    L28:
        if (r10 == false) goto L30;
        return true;
    L27:
        r10 = false;
    L15:
        r5 = -1;
        goto L17
    L7:
        r8 = null;
    L30:
        return false;
    }

    public static boolean b(Message r6) {
        Intrinsics.checkNotNullParameter(r6, "sourceData");
        if (r6.getContentType() != 2022) goto L30;
        CreationMsgContentData r7 = e.c(r6);
        if (r7 == null) goto L7;
        CreationInfo r8 = r7.creationInfo;
    L8:
        long r0 = AppHost.a.getUpdateVersionCode();
        if (r8 == null) goto L15;
        String r3 = r8.supportVersion;
        if (r3 == null) goto L15;
        Long r4 = StringsKt.toLongOrNull(r3);
        if (r4 == null) goto L15;
        long r5 = r4.longValue();
    L17:
        if (r0 >= r5) goto L20;
        return false;
    L20:
        if (r8 == null) goto L27;
        Integer r9 = r8.layoutType;
        if (r9 == null) goto L27;
        if (r9.intValue() != 1) goto L27;
        boolean r10 = true;
    L28:
        if (r10 == false) goto L30;
        return true;
    L27:
        r10 = false;
    L15:
        r5 = -1;
        goto L17
    L7:
        r8 = null;
    L30:
        return false;
    }
}
