package m4b;

import com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.StrangerBannerType;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.utils.ChatParamUtils;
import com.ss.android.lark.statistics.Statistics;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import s5c.d;
import z5c.g3;
import z5c.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {

    /* JADX INFO: renamed from: m4b.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0256a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[StrangerBannerType.values().length];
            r0[StrangerBannerType.TOTAL_BLOCK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[StrangerBannerType.STRANGER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[StrangerBannerType.NONE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[StrangerBannerType.UNKNOWN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    static {
    }

    @JvmStatic
    public static final void a(Chat r2, ChatChatter r3, String r4, StrangerBannerType r5) {
        Intrinsics.checkNotNullParameter(r2, "chat");
        Intrinsics.checkNotNullParameter(r5, IPortraitService.TYPE);
        s5c.a r0 = o.c.a(r2.getId());
        int r6 = C0256a.a[r5.ordinal()];
        if (r6 != 1) goto L5;
        d r7 = g3.e;
    L16:
        if (r7 == null) goto L19;
        Map<String, Object> r8 = ChatParamUtils.a(r2, r4, r3);
        Statistics.sendEvent("im_chat_main_banner_view", d.b.b(r0, r7).plus(r8).toJson());
        return;
    L19:
        return;
    L5:
        if (r6 != 2) goto L7;
        r7 = g3.c;
        goto L16
    L7:
        if (r6 != 3) goto L9;
        r7 = g3.d;
        goto L16
    L9:
        if (r6 != 4) goto L12;
        r7 = null;
        goto L16
    L12:
        throw new NoWhenBranchMatchedException();
    }
}
