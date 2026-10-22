package g7b;

import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.larksuite.framework.ui.BasePopupWindow;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildPopupWindowBoundsAdapter;
import com.ss.android.lark.chat.base.view.vo.message.BaseTextContentVO;
import com.ss.android.lark.chat.base.view.vo.message.PostContentVO;
import com.ss.android.lark.chat.chatwindow.chat.menu.handler.h;
import com.ss.android.lark.chat.chatwindow.chat.menu.handler.q;
import com.ss.android.lark.chat.chatwindow.chat.menu.handler.v;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public static final /* synthetic */ int f = 0;
    public final View a;
    public final m2b.a b;
    public final y6b.a<BaseTextContentVO<?>> c;
    public final h<BaseTextContentVO<?>> d;
    public BasePopupWindow e;

    /* JADX INFO: renamed from: g7b.a$a, reason: collision with other inner class name */
    public static final class C0224a {
    }

    static {
    }

    public final void a() {
        View r0 = LayoutInflater.from(this.a.getContext()).inflate(2131559287, null);
        View r1 = r0.findViewById(2131367949);
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.widget.TextView");
        TextView r2 = (TextView) r1;
        BasePopupWindow r8 = new BasePopupWindow(r0, -2, -2, true);
        r8.setTouchable(true);
        r8.setOutsideTouchable(true);
        r8.setFocusable(false);
        r8.setBackgroundDrawable(new BitmapDrawable());
        r0.measure(0, 0);
        int[] r3 = this.b.J8();
        if (r3 != null) goto L5;
        return;
    L5:
        View r10 = this.a;
        int r11 = r3[2];
        int r4 = r3[0] - r0.getMeasuredHeight();
        if (PopupWindowLancet.hasSubWindowToken(r10) == false) goto L9;
    L15:
        r2.setOnClickListener(new b(this, r8));
        r8.setOnDismissListener(c.a);
        this.e = r8;
        return;
    L9:
        if (LandscapeChildPopupWindowBoundsAdapter.isShowAtLocationBypassTarget(r8) == false) goto L11;
        r8.showAtLocation(r10, 0, r11, r4);
        goto L15
    L11:
        OverlaySource r12 = PopupWindowLancet.resolveSource(r10);
        if (PopupWindowLancet.rewriteDirectShowAtLocationIfNeeded(r8, r10, r12, 0, r11, r4) == true) goto L15;
        r8.showAtLocation(r10, 0, r11, r4);
        PopupWindowLancet.trackAfterShow(r8, r12, r10);
        goto L15
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(View r1, m2b.a r2, y6b.a r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        if ((((BaseTextContentVO) r3.b()) instanceof PostContentVO) == false) goto L5;
        h<BaseTextContentVO<?>> r4 = new q(r1.getContext());
    L6:
        this.d = r4;
        return;
    L5:
        r4 = new v(r1.getContext());
        goto L6
    }
}
