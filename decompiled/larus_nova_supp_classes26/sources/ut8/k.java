package ut8;

import android.graphics.Rect;
import android.text.Layout;
import android.text.TextUtils;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.larus.bmhome.chat.api.SelectionRangeType;
import com.larus.business.markdown.api.depend.IMarkdownLoggerKt;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildPopupWindowBoundsAdapter;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public class k extends b {
    public int A;
    public int B;
    public int C;
    public final TextView x;
    public int y;
    public int z;

    @Override // ut8.b
    public void j() {
    }

    @Override // ut8.b
    public final Rect f() {
        if (this.x == null) goto L19;
        int r0 = this.l;
        if (r0 < 0) goto L19;
        if (this.m <= r0) goto L19;
        Layout r1 = g();
        if (r1 != null) goto L22;
        return null;
    L22:
        int r2 = r1.getLineForOffset(this.l);     // Catch: Exception -> L21
        int r3 = r1.getLineTop(r2);     // Catch: Exception -> L21
        r1.getLineBottom(r2);     // Catch: Exception -> L21
        int r4 = r1.getLineForOffset(this.m);     // Catch: Exception -> L21
        r1.getLineTop(r4);     // Catch: Exception -> L21
        int r5 = r1.getLineBottom(r4);     // Catch: Exception -> L21
        int r6 = this.f[0] + j.b(this.x);     // Catch: Exception -> L21
        int r8 = (this.f[1] + j.c(this.x)) + r3;     // Catch: Exception -> L21
        int r7 = (this.f[0] + j.b(this.x)) + this.x.getWidth();     // Catch: Exception -> L21
        int r9 = (this.f[1] + j.c(this.x)) + r5;
        if (r2 == r4) goto L24;
    L17:
        return new Rect(r6, r8, r7, r9);
    L24:
        int r10 = (int) r1.getPrimaryHorizontal(this.l);     // Catch: Exception -> L20
        int r11 = (int) r1.getPrimaryHorizontal(this.m);     // Catch: Exception -> L20
        r6 = (this.f[0] + j.b(this.x)) + r10;     // Catch: Exception -> L20
        r7 = (this.f[0] + j.b(this.x)) + r11;
    L19:
        return null;
    }

    @Override // ut8.b
    public final Layout g() {
        TextView r0 = this.x;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getLayout();
    }

    @Override // ut8.b
    public final CharSequence h() {
        TextView r0 = this.x;
        if (r0 != null) goto L5;
        return "";
    L5:
        return r0.getText();
    }

    public k(TextView r1) {
        super(r1);
        this.x = r1;
    }

    public final boolean q(Layout r6, int r7) {
        if (r6 == null) goto L15;
        TextView r1 = this.x;
        if (r1 == null) goto L19;
        r1.getGlobalVisibleRect(this.g);
        int r8 = r6.getLineForOffset(r7);
        int r2 = (this.f[1] + j.c(this.x)) + r6.getLineTop(r8);
        int r3 = (this.f[1] + j.c(this.x)) + r6.getLineBottom(r8);
        Rect r9 = this.g;
        if (r2 >= r9.top) goto L10;
        return false;
    L10:
        if (r3 <= r9.bottom) goto L12;
        return false;
    L12:
        if (this.f[1] == 0) goto L18;
        return true;
    L18:
        return false;
    L19:
        return false;
    L15:
        return false;
    }

    @Override // ut8.b
    public final void p(boolean r3, int r4, int r5) {
        this.x.getLocationInWindow(this.f);
        int[] r0 = this.f;
        int r6 = j.a(this.x, r4 - r0[0], r5 - r0[1]);
        if (r6 >= 0) goto L5;
        return;
    L5:
        if (r3 == false) goto L7;
        this.l = r6;
    L9:
        if (this.l <= this.m) goto L18;
        i r7 = this.h;
        boolean r8 = !r7.f;
        r7.f = r8;
        if (r7.d == true) goto L13;
        r7.e = r8;
    L13:
        r7.invalidate();
        i r9 = this.j;
        boolean r10 = !r9.f;
        r9.f = r10;
        if (r9.d == true) goto L16;
        r9.e = r10;
    L16:
        r9.invalidate();
        int r11 = this.l;
        this.l = this.m;
        this.m = r11;
        return;
    L18:
        return;
    L7:
        this.m = r6;
        goto L9
    }

    @Override // ut8.b
    public final void k(Layout r17, int r18, final i r19, boolean r20) {
        if (r17 == null) goto L68;
        TextView r3 = this.x;
        if (r3 == null) goto L69;
        if (r19 == null) goto L76;
        r3.getGlobalVisibleRect(this.g);
        int r4 = r17.getLineForOffset(r18);
        float r5 = r17.getPrimaryHorizontal(r18);     // Catch: Exception -> L11
    L10:
        int r6 = (int) r5;
    L17:
        int r7 = (this.f[0] + j.b(this.x)) + r6;
        int r8 = (this.f[1] + j.c(this.x)) + r17.getLineTop(r4);
        int r9 = (this.f[1] + j.c(this.x)) + r17.getLineBottom(r4);
        int r10 = r17.getLineBottom(r4) - r17.getLineTop(r4);
        if (r20 == false) goto L20;
        this.y = r7;
        this.z = r8;
    L21:
        Rect r0 = this.g;
        if (r8 >= r0.top) goto L24;
    L29:
        r19.setOutArea(true);
    L30:
        TextView r1 = this.x;
        r19.j = r10;
        int r11 = r19.n;
        int r12 = r7 - r11;
        int r13 = (r8 + r10) - r11;
        if (r19.e == false) goto L67;
        r12 = (r7 - (r19.g * 2)) - r11;
    L67:
    L60:
        e = move-exception;
        e.printStackTrace();
        return;
    L34:
        if (r19.a != null) goto L37;
        PopupWindow r14 = new PopupWindow(r19);     // Catch: Exception -> L60
        r14.setClippingEnabled(false);     // Catch: Exception -> L60
        r14.setWidth((r19.g * 2) + (r19.n * 2));     // Catch: Exception -> L60
        r14.setHeight((r19.g * 2) + (r19.n * 2));     // Catch: Exception -> L60
        r14.setFocusable(false);     // Catch: Exception -> L60
        r14.setOutsideTouchable(true);     // Catch: Exception -> L60
        r14.setTouchInterceptor(new h(r19));     // Catch: Exception -> L60
        r19.a = r14;     // Catch: Exception -> L60
    L37:
        if (r19.a.isShowing() == false) goto L47;
        r19.invalidate();     // Catch: Exception -> L60
        PopupWindow r2 = r19.a;     // Catch: Exception -> L60
        if ((r2 instanceof PopupWindow) == false) goto L44;
        if (LandscapeChildPopupWindowBoundsAdapter.isDirectUpdateBypassTarget(r2) == false) goto L44;
        r2.update(r12, r13, -1, -1);     // Catch: Exception -> L60
        return;
    L44:
        if (PopupWindowLancet.rewriteDirectUpdateIfNeeded(r2, r12, r13, -1, -1) == true) goto L71;
        r2.update(r12, r13, -1, -1);     // Catch: Exception -> L60
        return;
    L71:
        return;
    L47:
        PopupWindow r15 = r19.a;     // Catch: Exception -> L60
        if (PopupWindowLancet.hasSubWindowToken(r1) == false) goto L51;
        return;
    L51:
        if ((r15 instanceof PopupWindow) == true) goto L53;
    L55:
        OverlaySource r16 = PopupWindowLancet.resolveSource(r1);     // Catch: Exception -> L60
        if (PopupWindowLancet.rewriteDirectShowAtLocationIfNeeded(r15, r1, r16, 0, r12, r13) == true) goto L75;
        r15.showAtLocation(r1, 0, r12, r13);     // Catch: Exception -> L60
        PopupWindowLancet.trackAfterShow(r15, r16, r1);     // Catch: Exception -> L60
        return;
    L75:
        return;
    L53:
        if (LandscapeChildPopupWindowBoundsAdapter.isShowAtLocationBypassTarget(r15) == false) goto L55;
        r15.showAtLocation(r1, 0, r12, r13);     // Catch: Exception -> L60
        return;
    L24:
        if (r9 > r0.bottom) goto L29;
        if (this.f[1] == 0) goto L29;
        r19.setOutArea(false);
        goto L30
    L20:
        this.A = r7;
        this.B = r8;
        this.C = r9;
    L11:
        if (r20 == false) goto L13;
        int r21 = r17.getLineStart(r4);
    L63:
        r5 = r17.getPrimaryHorizontal(r21);     // Catch: Exception -> L16
    L16:
        r6 = 0;
        goto L17
    L13:
        r21 = r17.getLineEnd(r4);
        goto L63
    L76:
        return;
    L69:
        return;
    }

    public final void r(int r11, int r12, int r13, boolean r14) {
        TextView r0 = this.x;
        if (r0 != null) goto L5;
        return;
    L5:
        int r15 = j.a(r0, r11, r12);
        CharSequence r16 = h();
        if (TextUtils.isEmpty(r16) == true) goto L74;
        if (r15 >= 0) goto L10;
        return;
    L10:
        if (r15 < r16.length()) goto L12;
        r15 = r16.length() - 1;
    L12:
        String r1 = r16.toString();
        TextView r2 = this.x;
        Lazy r3 = vt8.c.a;
        Intrinsics.checkNotNullParameter(r1, "txt");
        Intrinsics.checkNotNullParameter(r2, "txtView");
        if (r1.length() != 0) goto L15;
        boolean r4 = true;
    L17:
        if (r4 == false) goto L19;
        Pair<Integer, Integer> r17 = TuplesKt.to(0, 0);
    L46:
        int r18 = vt8.c.b;
        if (r18 == 1) goto L59;
        if (r18 == 2) goto L58;
        if (r18 != 3) goto L51;
        SelectionRangeType r19 = SelectionRangeType.PARAGRAPH;
    L60:
        SelectionRangeType r5 = r19;
        this.l = ((Integer) r17.getFirst()).intValue();
        this.m = ((Integer) r17.getSecond()).intValue();
        this.x.getLocationInWindow(this.f);
        Objects.toString(this.s);
        Objects.toString(r5);
        if (this.s == null) goto L72;
        if (r5 == null) goto L72;
        Rect r8 = f();
        int r110 = this.l;
        if (r110 < 0) goto L70;
        int r111 = this.m;
        if (r111 <= r110) goto L70;
        if (r111 > r16.length()) goto L70;
        String r112 = r16.subSequence(this.l, this.m).toString();
    L71:
        this.s.b(r5, this.l, this.m, false, false, r8, r112);
    L70:
        r112 = "";
    L72:
        m();
        l();
        this.p = true;
        return;
    L51:
        if (r18 != 4) goto L53;
        r19 = SelectionRangeType.SENTENCE;
        goto L60
    L53:
        if (r18 == 5) goto L55;
        r19 = null;
        goto L60
    L55:
        r19 = SelectionRangeType.ENTIRE;
        goto L60
    L58:
        r19 = SelectionRangeType.MARK_TEXT;
        goto L60
    L59:
        r19 = SelectionRangeType.WORD;
        goto L60
    L19:
        if (r15 >= 0) goto L22;
        r15 = 0;
    L24:
        if (r14 == false) goto L29;
        if (r13 != 2) goto L29;
        if (vt8.c.a().getDoubleClickShiftStrategy() <= 0) goto L29;
        int r6 = vt8.c.a().getDoubleClickShiftStrategy();
    L42:
        vt8.d r7 = vt8.c.b(r6, r2);
        Pair<Integer, Integer> r9 = r7.a(r1, r15);
        vt8.c.b = r7.b();
        com.larus.business.markdown.api.depend.d r10 = IMarkdownLoggerKt.a();
        if (r10 == null) goto L45;
        r10.i("DefaultSelectionController", "getSelectPair, txt:" + g2a.d.b(r1) + ",index:" + r15 + ",clickCount:" + r13 + ",isReClick:" + r14 + ",latestUsedStrategyId:" + vt8.c.b + ",pair:" + r9);
    L45:
        r17 = r9;
    L29:
        if (r13 == 0) goto L39;
        if (r13 == 2) goto L35;
        if (r13 == 3) goto L33;
        r6 = vt8.c.a().getDoubleClickStrategy();
        goto L42
    L33:
        r6 = vt8.c.a().getTripleClickStrategy();
        goto L42
    L35:
        if (vt8.c.a().getEnableMarkedTextFirst() == true) goto L40;
        r6 = vt8.c.a().getDoubleClickStrategy();
    L40:
        r6 = 2;
        goto L42
    L39:
        if (vt8.c.a().getEnableMarkedTextFirst() == true) goto L40;
        r6 = vt8.c.a().getLongPressStrategy();
        goto L42
    L22:
        if (r15 < r1.length()) goto L24;
        r15 = r1.length() - 1;
        goto L24
    L15:
        r4 = false;
        goto L17
    }
}
