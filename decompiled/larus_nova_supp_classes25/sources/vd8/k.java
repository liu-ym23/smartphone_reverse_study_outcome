package vd8;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.bmhome.setting.SettingRepo;
import com.larus.bmhome.social.userchat.model.b0;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class k implements td8.c {
    public final td8.d a;

    public static final class a {
    }

    static {
    }

    public static boolean d() {
        RepoDispatcher.a.getClass();
        wi8.a r0 = (wi8.a) RepoDispatcher.e.c.getValue();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.b <= 0) goto L7;
        return true;
    }

    public final boolean c() {
        BotModel r0 = this.a.a();
        if (r0 == null) goto L10;
        Integer r1 = r0.getBotStatus();
        if (r1 == null) goto L10;
        if (r1.intValue() != (-10)) goto L10;
        boolean r2 = true;
    L11:
        if (r2 == true) goto L25;
        wc9.e r3 = this.a.g();
        if (r3 == null) goto L20;
        Integer r4 = r3.t;
        if (r4 == null) goto L20;
        if (r4.intValue() != 5) goto L20;
        boolean r5 = true;
    L21:
        if (r5 == true) goto L26;
        return false;
    L26:
        return true;
    L20:
        r5 = false;
        goto L21
    L25:
        return true;
    L10:
        r2 = false;
        goto L11
    }

    public k(td8.d r2) {
        Intrinsics.checkNotNullParameter(r2, "taskContext");
        this.a = r2;
    }

    @Override // td8.c
    public final boolean a(int r1, xc8.b r2, xc8.b r3, List<? extends xc8.b> r4) {
        Intrinsics.checkNotNullParameter(r3, "current");
        Intrinsics.checkNotNullParameter(r4, "input");
        if (c() == true) goto L19;
        BotModel r5 = this.a.a();
        if (r5 == null) goto L12;
        Integer r6 = r5.getBotStatus();
        if (r6 == null) goto L12;
        if (r6.intValue() != (-40)) goto L12;
        boolean r7 = true;
    L13:
        if (r7 == false) goto L15;
        return true;
    L15:
        if (d() == true) goto L21;
        return false;
    L21:
        return true;
    L12:
        r7 = false;
        goto L13
    L19:
        return true;
    }

    @Override // td8.c
    public final List<xc8.b> b(int r56, xc8.b r57, xc8.b r58, List<xc8.b> r59) {
        Intrinsics.checkNotNullParameter(r58, "current");
        Intrinsics.checkNotNullParameter(r59, "input");
        FLogger r2 = FLogger.a;
        StringBuilder r3 = new StringBuilder("start ConversationStatusDivider, start size is ");
        r3.append(r59.size());
        r3.append(", bot status is ");
        BotModel r4 = this.a.a();
        String r5 = null;
        if (r4 == null) goto L5;
        String r6 = Integer.valueOf(ni8.a.b(r4)).toString();
    L6:
        r3.append(r6);
        r3.append(", conversation status is ");
        wc9.e r7 = this.a.g();
        if (r7 == null) goto L11;
        Integer r8 = r7.t;
        if (r8 == null) goto L11;
        String r9 = r8.toString();
    L12:
        r3.append(r9);
        r3.append(", limit startTime is ");
        RepoDispatcher.a.getClass();
        SettingRepo r10 = RepoDispatcher.e;
        wi8.a r11 = (wi8.a) r10.c.getValue();
        if (r11 == null) goto L15;
        String r12 = Long.valueOf(r11.b).toString();
    L16:
        r3.append(r12);
        r3.append('}');
        r2.i("Pipeline_List_ConversationStatusDivider", r3.toString());
        wi8.a r13 = (wi8.a) r10.c.getValue();
        if (c() == false) goto L35;
        StringBuilder r14 = new StringBuilder("add disabled divider in bot status is ");
        BotModel r15 = this.a.a();
        if (r15 == null) goto L21;
        String r16 = Integer.valueOf(ni8.a.b(r15)).toString();
    L22:
        r14.append(r16);
        r14.append(", conversation status is ");
        wc9.e r17 = this.a.g();
        if (r17 == null) goto L27;
        Integer r18 = r17.t;
        if (r18 == null) goto L27;
        r5 = r18.toString();
    L27:
        r14.append(r5);
        r2.i("Pipeline_List_ConversationStatusDivider", r14.toString());
        wc9.e r19 = this.a.g();
        if (r19 == null) goto L33;
        String r20 = r19.a;
        if (r20 == null) goto L33;
        String r110 = r20;
    L34:
        r5 = new Message(r110, null, null, 0, 0, null, 1001, false, null, AppHost.a.getApplication().getString(2131901652), null, null, null, null, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -578, 31, null);
    L73:
        if (r5 == null) goto L75;
        ListProtector.add(r59, 0, new cg8.c(b0.j(r5, 2)));
    L75:
        r2.i("Pipeline_List_ConversationStatusDivider", "end ConversationStatusDivider, end size is " + r59.size());
        return r59;
    L33:
        r110 = "";
        goto L34
    L21:
        r16 = null;
        goto L22
    L35:
        BotModel r21 = this.a.a();
        if (r21 == null) goto L43;
        Integer r22 = r21.getBotStatus();
        if (r22 == null) goto L43;
        if (r22.intValue() != (-40)) goto L43;
        boolean r23 = true;
    L44:
        if (r23 == false) goto L61;
        StringBuilder r24 = new StringBuilder("add private divider in botId is ");
        BotModel r25 = this.a.a();
        if (r25 == null) goto L48;
        String r26 = r25.getBotId();
    L49:
        r24.append(r26);
        r24.append(", botName is ");
        BotModel r27 = this.a.a();
        if (r27 == null) goto L52;
        r5 = r27.getName();
    L52:
        r24.append(r5);
        r2.i("Pipeline_List_ConversationStatusDivider", r24.toString());
        wc9.e r28 = this.a.g();
        if (r28 == null) goto L58;
        String r29 = r28.a;
        if (r29 == null) goto L58;
        String r111 = r29;
    L59:
        r5 = new Message(r111, null, null, 0, 0, null, 1001, false, null, AppHost.a.getApplication().getString(2131900800), null, null, null, null, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -578, 31, null);
    L58:
        r111 = "";
        goto L59
    L48:
        r26 = null;
        goto L49
    L61:
        if (d() == false) goto L73;
        r2.i("Pipeline_List_ConversationStatusDivider", "add limit divider");
        wc9.e r30 = this.a.g();
        if (r30 == null) goto L68;
        String r31 = r30.a;
        if (r31 == null) goto L68;
        String r112 = r31;
    L70:
        if (r13 == null) goto L72;
        r5 = r13.a;
    L72:
        r5 = new Message(r112, null, null, 0, 0, null, 1001, false, null, r5, null, null, null, null, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -578, 31, null);
    L68:
        r112 = "";
    L43:
        r23 = false;
        goto L44
    L15:
        r12 = null;
    L11:
        r9 = null;
        goto L12
    L5:
        r6 = null;
        goto L6
    }
}
