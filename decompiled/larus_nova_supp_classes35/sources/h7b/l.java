package h7b;

import android.text.TextUtils;
import com.ss.android.lark.biz.im.api.param.IMConstants;
import com.ss.android.lark.chameleon.container.webcontainer.plugin.core.ChameleonWebViewClient;
import com.ss.android.lark.chat.base.view.vo.message.BaseTextContentVO;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.translate.TranslateInfo;
import com.ss.android.lark.chat.utils.h0;
import java.util.ArrayList;
import w4b.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class l {
    public static final d0 a = null;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[IMConstants.NetworkLevel.values().length];
            a = r0;
            r0[IMConstants.NetworkLevel.EXCELLENT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            a[IMConstants.NetworkLevel.EVALUATING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public static String b(boolean r0, boolean r1, boolean r2) {
        if (r0 == false) goto L4;
        return "meeting";
    L4:
        if (r1 == false) goto L6;
        return "group";
    L6:
        if (r2 == false) goto L8;
        return "single_bot";
    L8:
        return "single";
    }

    static {
        a = ChatCoreModule.a().getSettingDependency();
    }

    public static int c() {
        IMConstants.NetworkLevel r0 = ChatCoreModule.a().getWschannelDependency().getCurNetWorkLevel();
        int r1 = a.a[r0.ordinal()];
        if (r1 != 1) goto L5;
        return ChameleonWebViewClient.DEFAULT_SAFE_TIME;
    L5:
        if (r1 == 2) goto L8;
        return 0;
    L8:
        return 100;
    }

    public static ArrayList<String> a(v5b.a r1) {
        if ((r1 instanceof BaseTextContentVO) == false) goto L7;
        return com.ss.android.lark.widget.richtext.d.f(((BaseTextContentVO) r1).g(), true);
    L7:
        return new ArrayList();
    }

    public static boolean d(com.ss.android.lark.chat.base.view.vo.message.f r2) {
        if (r2.f != 1) goto L6;
        return true;
    L6:
        if (r2.g != null) goto L8;
        return true;
    L8:
        if (TextUtils.isEmpty(r2.b) == false) goto L10;
        return true;
    L10:
        if (TextUtils.equals(r2.b, r2.g.b) == false) goto L16;
        return false;
    L16:
        return true;
    }

    public static void e(MessageInfo r3) {
        Message r0 = r3.getMessage();
        TranslateInfo r4 = r3.getTranslateInfo();
        if (r0.getType() == Message.Type.POST) goto L11;
        if (r0.getType() == Message.Type.TEXT) goto L11;
        if (r0.getType() == Message.Type.IMAGE) goto L11;
        if (h0.k(r0) == true) goto L11;
        return;
    L11:
        if (r0.getTranslateDisplayRule() != 2) goto L13;
    L14:
        if (r4 != null) goto L16;
    L17:
        r0.setTranslateDisplayRule(1);
        return;
    L16:
        if (r4.getMessageContentVersion() < r0.getContentVersion()) goto L17;
        return;
    L13:
        if (r0.getTranslateDisplayRule() == 3) goto L14;
    }
}
