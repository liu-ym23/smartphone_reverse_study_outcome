package ic8;

import android.os.Bundle;
import com.larus.bmhome.chat.bean.ChatPassThroughParams;
import com.larus.platform.service.z2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class k {
    public static final ChatPassThroughParams a(Bundle r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        ChatPassThroughParams r1 = (ChatPassThroughParams) r10.getParcelable("argChatPassThroughParams");
        boolean r5 = r10.getBoolean("argEnableForsetiPageSizeSlot", false);
        if (r10.getBoolean("enable_small_window_top_inset_adaptation", false) == true) goto L5;
        z2.a.w3();
        boolean r6 = false;
    L6:
        if (r1 != null) goto L8;
        if (r5 == true) goto L27;
        if (r6 == true) goto L27;
    L25:
        return null;
    L27:
        return new ChatPassThroughParams(null, r5, r6, null, 9, null);
    L8:
        if (r1.getEnableForsetiPageSizeSlot() == true) goto L12;
        if (r5 == true) goto L12;
        boolean r3 = false;
    L14:
        if (r1.getEnableSmallWindowTopInsetAdaptation() == true) goto L18;
        if (r6 == true) goto L18;
        boolean r4 = false;
    L19:
        ChatPassThroughParams r11 = ChatPassThroughParams.copy$default(r1, null, r3, r4, null, 9, null);
        if (r11.isNotEmpty() == false) goto L25;
        return r11;
    L18:
        r4 = true;
    L12:
        r3 = true;
        goto L14
    L5:
        r6 = true;
        goto L6
    }

    public static final void b(Bundle r1, ChatPassThroughParams r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r2 != null) goto L5;
        return;
    L5:
        if (r2.isNotEmpty() == true) goto L8;
        r2 = null;
    L8:
        if (r2 == null) goto L12;
        r1.putParcelable("argChatPassThroughParams", r2);
        return;
    }
}
