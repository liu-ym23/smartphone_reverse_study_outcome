package com.ss.android.lark.chat.cot.entry;

import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.biz.im.api.j1;
import com.ss.android.lark.chat.base.view.vo.message.CotDisplayModel;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.w;
import com.ss.android.lark.chat.cot.CotViewModel;
import com.ss.android.lark.chat.cot.detail.CotDetailSheet;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.ss.android.lark.widget.richtext.RichTextElementCreator;
import com.ss.android.lark.widget.richtext.c;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static RichText a(String r5, String r6) {
        if (r5 == null) goto L16;
        if (r5.length() <= 0) goto L6;
        boolean r0 = true;
    L7:
        if (r0 == true) goto L10;
        r5 = null;
    L10:
        if (r5 == null) goto L16;
        if (r6 != null) goto L14;
        r6 = BuildConfig.FLAVOR;
    L14:
        Map r4 = RichTextElementCreator.a;
        Intrinsics.checkNotNullParameter(BuildConfig.FLAVOR, "originChatterName");
        RichText r1 = c.b(CollectionsKt.arrayListOf(new RichTextElement[]{RichTextElementCreator.h(RichTextElementCreator.b(r5, r6, BuildConfig.FLAVOR, false, false)), RichTextElementCreator.e(" /stop")}));
        r1.setInnerText("@" + r6 + " /stop");
        return r1;
    L6:
        r0 = false;
    L16:
        return c.c("/stop");
    }

    public static void b(m2b.a r19, CotEntryView r20, y6b.a r21, CotDisplayModel r22) {
        Intrinsics.checkNotNullParameter(r19, "chatContext");
        Intrinsics.checkNotNullParameter(r20, "anchorView");
        Intrinsics.checkNotNullParameter(r21, Keys.API_RETURN_KEY_DATA);
        Intrinsics.checkNotNullParameter(r22, "display");
        int r0 = CotDetailSheet.v;
        FragmentActivity r1 = r19.getContext();
        String r4 = r21.getId();
        String r5 = r21.getChatId();
        CotViewModel r6 = r22.getDetailViewModel();
        com.ss.android.lark.chat.cot.a r7 = w.a(r19).o0();
        String r8 = r21.g();
        String r10 = BuildConfig.FLAVOR;
        if (r8 != null) goto L5;
        r8 = BuildConfig.FLAVOR;
    L5:
        Chat r11 = r19.getChat();
        if (r11 == null) goto L8;
        String r13 = r11.getId();
    L9:
        if (r13 == null) goto L13;
        r10 = r13;
    L13:
        if (r10.length() <= 0) goto L15;
        boolean r14 = true;
    L16:
        if (r14 == true) goto L19;
        r10 = null;
    L19:
        if (r10 != null) goto L41;
        r10 = r21.getChatId();
        if (r10.length() <= 0) goto L23;
        boolean r15 = true;
    L24:
        if (r15 == true) goto L27;
        r10 = null;
    L27:
        if (r10 != null) goto L41;
        String r2 = r19.getChatId();
        if (r2 != null) goto L31;
        r10 = null;
    L39:
        if (r10 != null) goto L41;
        Function0<Unit> r12 = null;
    L85:
        CotDetailSheet.a.a(r1, r20, r4, r5, r6, r7, r8, r12);
        Log.i("CotEntryNavigator", "open CotDetailSheet, cotId=" + r22.getCotId());
        return;
    L31:
        if (r2.length() <= 0) goto L33;
        boolean r16 = true;
    L34:
        if (r16 == true) goto L37;
        r2 = null;
    L37:
        r10 = r2;
        goto L39
    L33:
        r16 = false;
        goto L34
    L23:
        r15 = false;
    L41:
        if (r11 == null) goto L43;
        int r3 = r11.getLastMessagePosition();
    L44:
        String r17 = r21.M();
        if (r17 != null) goto L47;
    L50:
        boolean r18 = true;
    L52:
        if (r18 == true) goto L72;
        if (r11 != null) goto L55;
    L57:
        boolean r110 = false;
    L58:
        String r111 = r21.g();
        y6b.b r9 = r21.a();
        if (r9 == null) goto L61;
        String r23 = r9.b;
    L62:
        if (r11 != null) goto L64;
    L66:
        boolean r112 = false;
    L67:
        j1.a r113 = new j1.a();
        r113.c = r10;
        r113.e = r3;
        if (r110 == false) goto L70;
        RichText r24 = a(r111, r23);
    L71:
        r113.A = r24;
        r113.a = r17;
        r113.b = r17;
        r113.i = r17;
        r113.m = !r112;
        final j1 r25 = r113.b();
    L84:
        r12 = new CotEntryNavigator$createStopCommandSender$1(r25);
        goto L85
    L70:
        r24 = c.c("/stop");
        goto L71
    L64:
        if (r11.isThread() != true) goto L66;
        r112 = true;
        goto L67
    L61:
        r23 = null;
        goto L62
    L55:
        if (r11.isGroup() != true) goto L57;
        r110 = true;
        goto L58
    L72:
        if (r11 != null) goto L74;
    L76:
        boolean r114 = false;
    L77:
        if (r114 == false) goto L83;
        String r115 = r21.g();
        y6b.b r26 = r21.a();
        if (r26 == null) goto L81;
        String r116 = r26.b;
    L82:
        j1.a r27 = new j1.a();
        r27.c = r10;
        r27.e = r3;
        r27.A = a(r115, r116);
        r25 = r27.b();
        goto L84
    L81:
        r116 = null;
        goto L82
    L83:
        j1.a r28 = new j1.a();
        r28.c = r10;
        r28.e = r3;
        r28.A = c.c("/stop");
        r25 = r28.b();
        goto L84
    L74:
        if (r11.isGroup() != true) goto L76;
        r114 = true;
        goto L77
    L47:
        if (r17.length() == 0) goto L50;
        r18 = false;
        goto L52
    L43:
        r3 = r21.A();
        goto L44
    L15:
        r14 = false;
        goto L16
    L8:
        r13 = null;
        goto L9
    }
}
