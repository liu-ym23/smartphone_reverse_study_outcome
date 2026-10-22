package wt8;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.viewpager2.widget.ViewPager2;
import com.bytedance.keva.Keva;
import com.google.android.material.tabs.TabLayout;
import com.larus.bmhome.chat.model.repo.j2;
import com.larus.bmhome.databinding.LarusPageChatDoubleTabBinding;
import com.larus.bmhome.view.title.ChatTitleTwoTab;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class y implements TabLayout.OnTabSelectedListener {
    public final /* synthetic */ LarusPageChatDoubleTabBinding a;
    public final /* synthetic */ String b;
    public final /* synthetic */ ChatTitleTwoTab c;
    public final /* synthetic */ Ref.BooleanRef d;
    public final /* synthetic */ String e;

    public final void onTabReselected(TabLayout.Tab r2) {
        Intrinsics.checkNotNullParameter(r2, "tab");
        r2.getPosition();
    }

    public final void onTabSelected(TabLayout.Tab r7) {
        Intrinsics.checkNotNullParameter(r7, "tab");
        int r0 = r7.getPosition();
        LarusPageChatDoubleTabBinding r1 = this.a;
        if (r1 == null) goto L7;
        ViewPager2 r2 = r1.f;
        if (r2 == null) goto L7;
        r2.setCurrentItem(r0);
    L7:
        Lazy r3 = j2.a;
        String r4 = this.b;
        j2.b = r0;
        if (r4 != null) goto L10;
    L13:
        boolean r5 = true;
    L14:
        if (r5 == false) goto L16;
    L19:
        View r6 = r7.getCustomView();
        if (r6 == null) goto L23;
        r6.setBackgroundResource(0);
    L23:
        if (r0 == 0) goto L43;
        if (r0 != 1) goto L54;
        View r8 = r7.getCustomView();
        if (r8 == null) goto L31;
        TextView r9 = (TextView) r8.findViewById(2131391606);
        if (r9 == null) goto L31;
        r9.setTextColor(ContextCompat.getColor(this.c.getContext(), v19.c.b(2130972079, this.c.getContext(), 2131103136)));
    L31:
        Ref.BooleanRef r10 = this.d;
        if (r10.element == false) goto L34;
        String r11 = "auto_landing";
    L35:
        r10.element = false;
        com.larus.platform.service.o r12 = com.larus.platform.service.o.a;
        JSONObject r13 = new JSONObject();
        ChatTitleTwoTab r14 = this.c;
        String r15 = this.e;
        r13.put("bot_id", r14.s);
        r13.put("click_from", r11);
        r13.put("template_type", r15);
        r13.put("chat_type", "other_default");
        Unit r16 = Unit.INSTANCE;
        r12.reportEvent("enter_template_tab", r13);
        Context r17 = this.c.getContext();
        if ((r17 instanceof Activity) == false) goto L38;
        Activity r18 = (Activity) r17;
    L39:
        if (r18 == null) goto L49;
        Window r19 = r18.getWindow();
        if (r19 == null) goto L50;
        new WindowInsetsControllerCompat(r19, this.c.getBinding().a).hide(WindowInsetsCompat.Type.ime());
        return;
    L50:
        return;
    L49:
        return;
    L38:
        r18 = null;
        goto L39
    L34:
        r11 = "template_tab";
        goto L35
    L54:
        return;
    L43:
        View r20 = r7.getCustomView();
        if (r20 == null) goto L52;
        TextView r21 = (TextView) r20.findViewById(2131391606);
        if (r21 == null) goto L53;
        r21.setTextColor(ContextCompat.getColor(this.c.getContext(), v19.c.b(2130972079, this.c.getContext(), 2131103136)));
        return;
    L53:
        return;
    L52:
        return;
    L16:
        if (Intrinsics.areEqual(j2.c, Boolean.FALSE) == false) goto L19;
        ((Keva) j2.a.getValue()).storeInt("template_tab_index_" + r4, r0);
        goto L19
    L10:
        if (r4.length() == 0) goto L13;
        r5 = false;
        goto L14
    }

    public final void onTabUnselected(TabLayout.Tab r6) {
        Intrinsics.checkNotNullParameter(r6, "tab");
        int r0 = r6.getPosition();
        if (r0 != 0) goto L5;
        View r7 = r6.getCustomView();
        if (r7 == null) goto L21;
        TextView r8 = (TextView) r7.findViewById(2131391606);
        if (r8 == null) goto L22;
        r8.setTextColor(ContextCompat.getColor(this.c.getContext(), v19.c.b(2130972081, this.c.getContext(), 2131103143)));
        return;
    L22:
        return;
    L21:
        return;
    L5:
        if (r0 != 1) goto L23;
        View r9 = r6.getCustomView();
        if (r9 == null) goto L18;
        TextView r10 = (TextView) r9.findViewById(2131391606);
        if (r10 == null) goto L19;
        r10.setTextColor(ContextCompat.getColor(this.c.getContext(), v19.c.b(2130972081, this.c.getContext(), 2131103143)));
        return;
    L19:
        return;
    L18:
        return;
    }

    public y(LarusPageChatDoubleTabBinding r1, String r2, ChatTitleTwoTab r3, Ref.BooleanRef r4, String r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
