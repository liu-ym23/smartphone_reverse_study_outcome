package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.clickhandler.menu;

import android.content.Context;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.framework.ui.BasePopupWindow;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.chat.message.menu.MessageActionManager;
import com.ss.android.lark.chat.message.menu.v2.NormalMessageActionListConfig;
import com.ss.android.lark.chat.message.menu.v2.adapter.binder.MessageActionAdapter;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import f4b.d;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import zya.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public d a;
    public Function0<Unit> b;

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.clickhandler.menu.a$a, reason: collision with other inner class name */
    public static final class C0071a {
    }

    static {
    }

    public final BasePopupWindow a() {
        d r0 = this.a;
        if (r0 == null) goto L29;
        List r2 = (List) FullFetchMessageActionConfig.b.getValue();
        if (r2.isEmpty() == false) goto L7;
        Log.e("FullActionPanelManager", "no actions for message " + r0.e.b.getId());
        return null;
    L7:
        final com.ss.android.lark.chat.message.menu.d r3 = MessageActionManager.a(r0, r2, new c(r0));
        Log.i("FullActionPanelManager", "action panel popup for message " + r0.e.b.getId());
        Context r1 = r0.d;
        Function0<List<? extends e>> r4 = new FullActionPanelManager$popup$1$1(r3);
        View r5 = LayoutInflater.from(r1).inflate(2131563361, null, false);
        RecyclerView r6 = r5.findViewById(2131381945);
        MessageActionAdapter r7 = new MessageActionAdapter();
        r7.z2(new b(this));
        r6.setLayoutManager(new LinearLayoutManager(r1));
        r6.setAdapter(r7);
        List r8 = (List) r4.invoke();
        r7.resetAll(r8);
        ActionPanelUIUtil r9 = new ActionPanelUIUtil(r1);
        Intrinsics.checkNotNull(r6);
        Intrinsics.checkNotNull(r5);
        ActionPanelUIUtil.a r10 = new ActionPanelUIUtil.a(r6, r5);
        Intrinsics.checkNotNullParameter(r8, "updateList");
        Intrinsics.checkNotNullParameter(r10, "uiViews");
        Iterator r11 = r8.iterator();
        float r12 = 0.0f;
    L9:
        if (r11.hasNext() == false) goto L13;
        zya.b r13 = (e) r11.next();
        if ((r13 instanceof zya.b) == false) goto L9;
        r12 = Math.max(r12, ((TextPaint) r9.b.getValue()).measureText(r13.e));
        goto L9
    L13:
        float r14 = UIHelper.dp2px(64.0f) + r12;
        int r15 = UIHelper.dp2px(136.0f);
        int r16 = UIHelper.dp2px(300.0f);
        if (r14 >= r15) goto L17;
    L20:
        int r17 = View.MeasureSpec.makeMeasureSpec(r15, 1073741824);
        ViewGroup r18 = r10.a;
        r18.measure(r17, 0);
        ViewGroup.LayoutParams r19 = r18.getLayoutParams();
        if (r19 == null) goto L28;
        r19.width = r18.getMeasuredWidth();
        r18.setLayoutParams(r19);
        ViewGroup.LayoutParams r20 = r18.getLayoutParams();
        if (r20 == null) goto L26;
        r20.height = r18.getMeasuredHeight();
        r18.setLayoutParams(r20);
        BasePopupWindow r21 = new BasePopupWindow(r5, -2, -2);
        r21.setTouchable(true);
        r21.setOutsideTouchable(false);
        r21.setFocusable(false);
        r21.setClippingEnabled(false);
        return r21;
    L26:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L28:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L17:
        if (r14 <= r16) goto L19;
        r15 = r16;
        goto L20
    L19:
        r15 = (int) r14;
        goto L20
    L29:
        return null;
    }

    public a() {
        List<String> r0 = FullFetchMessageActionConfig.a;
        if (FullFetchMessageActionConfig.a != null) goto L7;
        SettingManager.getInstance().get(NormalMessageActionListConfig.class, new FullFetchMessageActionConfig$initConfig$1());
        return;
    }
}
