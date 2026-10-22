package com.larus.bmhome.chat.component.share;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.IChatAzerothService;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.chat.model.MessageShareViewModel;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.bmhome.share.panel.d;
import com.larus.flowsdk.security.api.FlowFileProtectionService;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.platform.model.ExportFileConfig;
import com.larus.platform.service.o;
import com.larus.platform.service.z2;
import com.larus.security.api.ReportDialogHelper;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import de8.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;
import t1a.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class o0 implements d {
    public final /* synthetic */ ChatShareBottomComponent a;

    public final boolean d(String r1, String r2, Boolean r3) {
        return true;
    }

    public final void f() {
    }

    public final void onDismiss() {
        ChatShareBottomComponent r0 = this.a;
        int r1 = ChatShareBottomComponent.R;
        r0.e4().exitSelectMode();
    }

    public o0(ChatShareBottomComponent r1) {
        this.a = r1;
    }

    public final void e(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
    }

    public final boolean b(Context r26, DialogFragment r27, View r28, jr9.a r29) {
        Intrinsics.checkNotNullParameter(r29, "shareItemConfig");
        if (ChatShareBottomComponent.B3(this.a, r26, r29) == false) goto L5;
        return true;
    L5:
        String r2 = r29.b();
        if (r2 == null) goto L98;
        boolean r5 = false;
        String r7 = null;
        switch(r2.hashCode()) {
            case -2095199449: goto L32;
            case -1335458389: goto L28;
            case -934521548: goto L15;
            case 1505669047: goto L11;
            default: goto L98;
        };
    L11:
        if (r2.equals("copy_text") == false) goto L98;
        ChatShareBottomComponent r1 = this.a;
        List<Message> r3 = r1.e4().getSelectedMessages();
        r1.e4().exitSelectMode();
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r1), Dispatchers.getIO(), null, new ChatShareBottomComponent$handleCopyText$1(r1, r3, null), 2, null);
    L102:
        return true;
    L15:
        if (r2.equals("report") == false) goto L98;
        final ChatShareBottomComponent r4 = this.a;
        final List<Message> r9 = r4.e4().getSelectedMessages();
        r4.e4().exitSelectMode();
        List<Message> r6 = r9;
        if (r6 != null) goto L20;
    L21:
        r5 = true;
    L22:
        if (r5 == false) goto L24;
        FLogger.a.d("ChatShareBottomComponent", "report selected null! return");
        goto L102
    L24:
        Intrinsics.checkNotNullParameter(r4, "<this>");
        FragmentActivity r8 = com.larus.ui.arch.component.internal.attach.a.b(r4, r4).getActivity();
        if (r8 == null) goto L102;
        ReportDialogHelper.d(ReportDialogHelper.a, r8, r9, null, null, new b0(r4, r9), 12);
        goto L102
    L20:
        if (r6.isEmpty() == false) goto L22;
    L28:
        if (r2.equals("delete") == false) goto L98;
        this.a.h4(null);
        goto L102
    L32:
        if (r2.equals("export_file") == false) goto L98;
        final MessageShareViewModel r10 = this.a.e4();
        ChatShareBottomComponent r11 = this.a;
        Intrinsics.checkNotNullParameter(r10, "viewModel");
        Intrinsics.checkNotNullParameter(r11, "component");
        Intrinsics.checkNotNullParameter(r11, "<this>");
        Fragment r12 = com.larus.ui.arch.component.internal.attach.a.b(r11, r11);
        FlowFileProtectionService r13 = (FlowFileProtectionService) ServiceManager.get().getService(FlowFileProtectionService.class);
        if (r13 != null) goto L37;
    L39:
        boolean r14 = false;
    L40:
        if (r14 == false) goto L49;
        o r15 = o.a;
        JSONObject r16 = new JSONObject();
        r16.put("action", "export_conversation");
        r16.put("entry", "chat_export");
        r16.put("content_type", "file");
        Unit r17 = Unit.INSTANCE;
        r15.reportEvent("flow_enterprise_file_egress_block", r16);
        String r18 = r13.H0();
        if (r18 == null) goto L102;
        if ((!StringsKt.isBlank(r18)) == false) goto L46;
        String r19 = r18;
    L47:
        if (r19 == null) goto L102;
        t19.s.j(t19.s.a, r12.getContext(), r19, null, false, 28);
        goto L102
    L46:
        r19 = null;
        goto L47
    L49:
        b r20 = s1a.a.g(r12);
        com.larus.bmhome.chat.component.cvs.y r21 = r20.getAbility(com.larus.bmhome.chat.component.cvs.y.class);
        if (r21 == null) goto L102;
        c r22 = (c) r20.f(c.class);
        ExportFileConfig r23 = z2.a.exportFileConfig();
        Integer r24 = (Integer) r10.getShareMegNum().getValue();
        if (r24 == null) goto L55;
        int r25 = r24.intValue();
    L57:
        if (r25 <= r23.getExportMsgLimit()) goto L59;
        boolean r110 = true;
    L60:
        if (r110 == false) goto L66;
        FLogger.a.w("ExportFileShareElement", "msg report reach limit, cur num: " + r25 + ", limit: " + r23.getExportMsgLimit());
        Context r30 = r12.getContext();
        if (r30 == null) goto L66;
        String r31 = r30.getString(2131905594, new Object[]{Integer.valueOf(r23.getExportMsgLimit())});
        if (r31 == null) goto L66;
        t19.s r32 = t19.s.a;
        Context r111 = r12.getContext();
        r32.getClass();
        t19.s.t(r111, r31);
    L66:
        if (r110 == true) goto L102;
        List<Message> r33 = r10.getSelectedMessages();
        ArrayList r112 = new ArrayList();
        Iterator<T> r34 = r33.iterator();
    L70:
        if (r34.hasNext() == false) goto L72;
        Message r35 = (Message) r34.next();
        r112.add(new v0(r35.getMessageId(), Integer.valueOf(r35.getContentType())));
        goto L70
    L72:
        String r36 = UUID.randomUUID().toString();
        int r37 = FileExportTypeChooseDialog.w;
        String r38 = r21.Y1();
        BotModel r113 = r21.j0();
        if (r113 == null) goto L75;
        String r114 = r113.getName();
    L77:
        if (r114 != null) goto L79;
        String r115 = "";
    L80:
        BotModel r39 = r21.j0();
        if (r39 == null) goto L83;
        r7 = r39.getBotId();
    L83:
        if (r7 != null) goto L85;
        r7 = "";
    L85:
        long r40 = r22.n;
        List<Message> r116 = r10.getSelectedMessages();
        if ((r116 instanceof Collection) == true) goto L88;
    L90:
        Iterator<T> r117 = r116.iterator();
    L92:
        if (r117.hasNext() == false) goto L96;
        Message r118 = (Message) r117.next();
        IChatAzerothService r119 = com.larus.bmhome.x.a();
        Intrinsics.checkNotNull(r119);
        if (r119.a(r118) == false) goto L92;
        boolean r210 = true;
    L97:
        FileExportTypeChooseDialog r41 = FileExportTypeChooseDialog.a.b(r38, r112, null, r115, r7, r36, r40, null, null, null, null, r210, null, null, 14212);
        r41.t = new s0(r10);
        int r42 = FileExportTypeChooseDialog.w;
        FileExportTypeChooseDialog.a.c(r41, r12.getChildFragmentManager());
        ChatControlTrace.b.La("share_panel", CollectionsKt.joinToString$default(r112, ",", null, null, 0, null, new t0(), 30, null), r36, r22.n);
    L96:
        r210 = false;
        goto L97
    L88:
        if (r116.isEmpty() == false) goto L90;
    L79:
        r115 = r114;
        goto L80
    L75:
        r114 = null;
        goto L77
    L59:
        r110 = false;
        goto L60
    L55:
        r25 = 0;
        goto L57
    L37:
        if (r13.I0() != true) goto L39;
        r14 = true;
    L98:
        u7 r43 = this.a.Z3();
        if (r43 == null) goto L101;
        r43.showLoading();
    L101:
        this.a.e4().shareMessageWithPreload(r29);
        goto L102
    }
}
