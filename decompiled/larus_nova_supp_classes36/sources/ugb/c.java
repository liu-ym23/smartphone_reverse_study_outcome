package ugb;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.lark.pb.basic.v1.Chatter;
import com.bytedance.lark.pb.basic.v1.StatusEffectiveInterval;
import com.bytedance.lark.pb.basic.v1.Tag;
import com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.StrangerTagType;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.chatter.ChatterCustomStatus;
import com.ss.android.lark.flow.chat.titlebar.view.CoreNavigationBar;
import com.ss.android.lark.flow.common.component.tag.FlowTagView;
import com.ss.android.lark.flow.common.utils.FlowTagBuilder;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c extends a {
    public StrangerTagType d;

    public c(CoreNavigationBar r2) {
        Intrinsics.checkNotNullParameter(r2, "rootView");
        super(r2);
    }

    @Override // ugb.e
    public final void a(Context r11, sxa.a r12) {
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "titleContext");
        FlowTagBuilder r0 = new FlowTagBuilder(r11);
        ChatChatter r13 = r12.b;
        boolean r2 = true;
        if (r13 == null) goto L28;
        Intrinsics.checkNotNullParameter(r13, "<this>");
        long r4 = cac.b.a.a.a(30000) / 1000;
        ChatterCustomStatus.a r6 = ChatterCustomStatus.Companion;
        List r14 = r13.getCustomStatus();
        r6.getClass();
        List r15 = ChatterCustomStatus.a.c(r14);
        if (r15 == null) goto L28;
        if (r15.isEmpty() == true) goto L28;
        Iterator r16 = r15.iterator();
    L11:
        if (r16.hasNext() == false) goto L28;
        Chatter.ChatterCustomStatus r7 = (Chatter.ChatterCustomStatus) r16.next();
        StatusEffectiveInterval r8 = r7.effective_interval;
        if (r8 != null) goto L16;
    L25:
        boolean r9 = false;
    L26:
        if (r9 == false) goto L11;
        boolean r17 = true;
    L29:
        r0.h = r17;
        ChatChatter r18 = r12.b;
        if (r18 == null) goto L32;
        boolean r19 = r18.isFrozen();
    L33:
        r0.f = r19;
        Chat r110 = r12.a;
        Intrinsics.checkNotNullParameter(r110, "<this>");
        if (r110.getTags() != null) goto L36;
        boolean r111 = false;
    L37:
        r0.e = r111;
        r0.i = d.a(r12.a);
        StrangerTagType r112 = this.d;
        Intrinsics.checkNotNullParameter(r12, "<this>");
        ChatChatter r1 = r12.b;
        if (r1 != null) goto L41;
    L54:
        boolean r113 = false;
    L55:
        r0.g = r113;
        ChatChatter r114 = r12.b;
        if (r114 != null) goto L58;
    L60:
        r2 = false;
    L61:
        r0.j = r2;
        FlowTagView r115 = r0.b();
        if (r115 == null) goto L64;
        r115.setTagStyle(new ahb.a(10.0f, 4.0f, 18.0f, 5.0f, 48));
    L65:
        View r116 = this.c;
        if (r116 == null) goto L70;
        ViewGroup r3 = this.b;
        if (r3 == null) goto L70;
        r3.removeView(r116);
    L70:
        this.c = r115;
        if (r115 != null) goto L75;
        ViewGroup r117 = this.b;
        if (r117 == null) goto L87;
        r117.setVisibility(8);
        return;
    L87:
        return;
    L75:
        ViewGroup r118 = this.b;
        if (r118 == null) goto L78;
        r118.addView(r115);
    L78:
        ViewGroup r119 = this.b;
        if (r119 == null) goto L89;
        r119.setVisibility(0);
        return;
    L89:
        return;
    L64:
        r115 = null;
        goto L65
    L58:
        if (r114.showAgentTag() != true) goto L60;
    L41:
        if (r12.a.isP2PChat() == false) goto L54;
        if (r1.isDimission() == true) goto L54;
        if (r1.getRegistered() == false) goto L54;
        if (r1.isFrozen() == true) goto L54;
        if (r112 != StrangerTagType.BLOCK) goto L52;
    L53:
        r113 = true;
        goto L55
    L52:
        if (r112 != StrangerTagType.TOTAL_BLOCK) goto L54;
    L36:
        r111 = r110.getTags().contains(Tag.USER_RESIGNED);
        goto L37
    L32:
        r19 = false;
        goto L33
    L16:
        if (Intrinsics.areEqual(r7.icon_key, "GeneralVacation") == false) goto L25;
        Long r10 = r8.start_time;
        if (r4 <= r8.end_time.longValue()) goto L20;
    L22:
        boolean r20 = false;
    L23:
        if (r20 == false) goto L25;
        r9 = true;
        goto L26
    L20:
        if (r10.longValue() > r4) goto L22;
        r20 = true;
    L28:
        r17 = false;
        goto L29
    }
}
