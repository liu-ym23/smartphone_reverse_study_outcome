package vf8;

import com.larus.bmhome.chat.list.cell.loading.LoadingType;
import com.larus.bmhome.social.userchat.model.b0;
import com.larus.im.bean.message.Message;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class i {
    public static final LoadingType a(Message r7) {
        Intrinsics.checkNotNullParameter(r7, "message");
        if (b0.h(r7) == true) goto L54;
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Map r1 = r7.getBusinessExt();
        if (r1 == null) goto L8;
        String r2 = (String) r1.get("is_mock_text");
    L10:
        if (Intrinsics.areEqual(r2, "1") == false) goto L13;
    L55:
        return null;
    L13:
        if (com.larus.bmhome.chat.bean.d.S(r7) == true) goto L56;
        Intrinsics.checkNotNullParameter(r7, "<this>");
        if (r7.getSourceFromAsr() == true) goto L18;
    L26:
        boolean r0 = false;
    L27:
        if (r0 == false) goto L30;
        return LoadingType.OUT;
    L30:
        if (com.larus.im.bean.message.a.b0(r7) == true) goto L32;
        String r3 = r7.getContent();
        if (r3 != null) goto L38;
    L39:
        boolean r4 = true;
    L40:
        if (r4 == false) goto L55;
        if (CollectionsKt.listOf(new Integer[]{1, 9999}).contains(Integer.valueOf(r7.getContentType())) == false) goto L55;
        int r8 = r7.getMessageStatusLocal();
        if (r8 == 10) goto L53;
        if (r8 == 12) goto L53;
        if (r8 == 20) goto L58;
        if (r8 != 22) goto L55;
    L58:
        return LoadingType.IN;
    L53:
        return LoadingType.OUT;
    L38:
        if (r3.length() == 0) goto L39;
    L34:
        r4 = false;
        goto L40
    L32:
        if (com.larus.im.bean.message.a.e(r7).length() != 0) goto L34;
    L18:
        if (r7.getMessageStatusLocal() != 12) goto L26;
        Map r5 = r7.getBusinessExt();
        if (r5 == null) goto L22;
        String r6 = (String) r5.get("is_real_audio_text");
    L24:
        if (Intrinsics.areEqual(r6, "1") == true) goto L26;
        r0 = true;
        goto L27
    L22:
        r6 = null;
        goto L24
    L56:
        return LoadingType.OUT;
    L8:
        r2 = null;
        goto L10
    L54:
        return LoadingType.IN;
    }
}
