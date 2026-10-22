package lrb;

import android.os.Build;
import android.text.TextUtils;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.chat.base.view.vo.message.f;
import com.ss.android.lark.chat.entity.message.content.CardContent;
import com.ss.android.lark.location_ui.statistics.LocationHitPoint$ResultType;
import com.ss.android.lark.message.card.CardMessageUtils;
import com.ss.android.lark.message.card.b;
import com.ss.android.lark.message.lynxcard.entity.LynxCardContentVO;
import com.ss.android.lark.message.lynxcard.settings.CardMessageUserLynxRenderSettings;
import com.ss.android.lark.message.lynxcard.settings.MessageCardMachineTypeConfig;
import com.suite.lark.platform.component.deviceperf.DevicePerfUtils;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public static final CardMessageUserLynxRenderSettings a = null;

    static {
        a = (CardMessageUserLynxRenderSettings) SettingManager.getInstance().get(CardMessageUserLynxRenderSettings.class);
    }

    public static String b(LynxCardContentVO r4) {
        int r0 = CardMessageUtils.a;
        boolean r1 = true;
        boolean r2 = !CardMessageUtils.a.b(r4);
        if (((f) r4).f != 3) goto L5;
        boolean r5 = true;
    L6:
        if (r2 == false) goto L10;
        if (r5 == true) goto L10;
        r1 = false;
    L10:
        if (r2 == false) goto L13;
        if (r5 == false) goto L13;
        return "renderOriginalWithTranslation";
    L13:
        if (r1 == false) goto L15;
        return "renderOriginal";
    L15:
        return "renderTranslation";
    L5:
        r5 = false;
        goto L6
    }

    public static String d(r5b.a r3) {
        if (r3 != null) goto L6;
        return LocationHitPoint$ResultType.DEFAULT;
    L6:
        if ((r3 instanceof m2b.a) == false) goto L14;
        m2b.a r1 = (m2b.a) r3;
        if (r1.getChat() == null) goto L14;
        if (r1.getChat().isMember() == false) goto L14;
        return "chat";
    L14:
        if (r3.m() == false) goto L18;
        return "quoteDetail";
    L18:
        if (r3.r() == false) goto L22;
        return "threadChat";
    L22:
        if (r3.q() == false) goto L26;
        return "threadDetail";
    L26:
        if (r3.Y() == false) goto L29;
        return "replyInThread";
    L29:
        return LocationHitPoint$ResultType.DEFAULT;
    }

    public static boolean a(CardContent r5, long r6) {
        if (r5 != null) goto L6;
        return false;
    L6:
        if (r6 == 0) goto L11;
        if (r6 >= a.start_time) goto L11;
        return false;
    L11:
        if (b.a().getFgValue("lynxcard.client.render.enable") == true) goto L13;
        return false;
    L13:
        if (TextUtils.isEmpty(r5.getDslJsonString()) == true) goto L37;
        MessageCardMachineTypeConfig r7 = (MessageCardMachineTypeConfig) SettingManager.getInstance().get(MessageCardMachineTypeConfig.class);
        DevicePerfUtils.a r8 = DevicePerfUtils.e();
        String r9 = Build.MODEL;
        List<String> r1 = r7.whiteList;
        if (r1 != null) goto L17;
    L19:
        boolean r2 = false;
    L20:
        if (r2 == true) goto L34;
        List<String> r3 = r7.blackList;
        if (r3 != null) goto L25;
    L27:
        boolean r10 = false;
    L28:
        if (r10 == true) goto L39;
        if (r8 == null) goto L34;
        if (r8.e >= r7.minOverallScore) goto L34;
        return false;
    L39:
        return false;
    L25:
        if (r3.contains(r9) == false) goto L27;
        r10 = true;
    L34:
        return true;
    L17:
        if (r1.contains(r9) == false) goto L19;
        r2 = true;
        goto L20
    L37:
        return false;
    }

    public static int c(boolean r0, boolean r1, boolean r2, boolean r3, boolean r4, Integer r5) {
        if (r1 == true) goto L10;
        if (r0 == true) goto L11;
        if (r3 == false) goto L9;
        return b.a().getChatThreadLynxCardMessageWidth(r5);
    L9:
        return b.a().getLynxCardMessageWidth(r4, r5);
    L11:
        return b.a().getThreadLynxCardMessageWidth(false, r5);
    L10:
        return b.a().getThreadDetailLynxCardMessageWidth(r2, r5);
    }
}
