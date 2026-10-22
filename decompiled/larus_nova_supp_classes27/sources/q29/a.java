package q29;

import android.content.Context;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.router.SmartRouter;
import com.google.gson.Gson;
import com.larus.platform.api.creation.UserCreation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a {
    public static /* synthetic */ void b(Context r13, UserCreation r14, zp9.g r15, boolean r16, boolean r17, Integer r18, boolean r110, int r20) {
        if ((r20 & 4) == 0) goto L5;
        zp9.g r5 = null;
    L7:
        if ((r20 & 16) == 0) goto L9;
        boolean r7 = false;
    L11:
        if ((r20 & 128) == 0) goto L13;
        boolean r10 = true;
    L15:
        if ((r20 & 256) == 0) goto L17;
        Integer r11 = null;
    L19:
        if ((r20 & 512) == 0) goto L21;
        boolean r12 = false;
    L22:
        a(r13, r14, r5, false, r7, false, false, r10, r11, r12);
        return;
    L21:
        r12 = r110;
        goto L22
    L17:
        r11 = r18;
        goto L19
    L13:
        r10 = r17;
        goto L15
    L9:
        r7 = r16;
        goto L11
    L5:
        r5 = r15;
        goto L7
    }

    public static final void a(Context r2, UserCreation r3, zp9.g r4, boolean r5, boolean r6, boolean r7, boolean r8, boolean r9, Integer r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "userCreation");
        com.bytedance.router.i r12 = SmartRouter.buildRoute(r2, "//flow/creation_detail");
        String r13 = GsonProtectorUtils.toJson(new Gson(), r3);
        r12.c.putExtra("creation", r13);
        String r14 = GsonProtectorUtils.toJson(new Gson(), r4);
        r12.c.putExtra("track_params", r14);
        r12.c.putExtra("is_show_profile", r5);
        r12.c.putExtra("show_usage_count", r6);
        r12.c.putExtra("can_show_inspiration_list", r7);
        r12.c.putExtra("ignore_tpl_info", r8);
        r12.c.putExtra("open_new_chat_page_on_send", r9);
        r12.c.putExtra("creation_dosame_landing_type", r10);
        r12.c.putExtra("is_send_from_detail", r11);
        r12.d();
    }
}
