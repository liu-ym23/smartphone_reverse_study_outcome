package com.bytedance.android.live.ktv.common.ordersong.feedback;

import android.app.Dialog;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.ordersong.theme.KtvOrderSongThemeManager;
import com.bytedance.android.live.ktv.common.view.BaseKtvDialogFragment;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/ktv/common/ordersong/feedback/KtvFeedbackDialog;", "Lcom/bytedance/android/live/ktv/common/view/BaseKtvDialogFragment;", "<init>", "()V", "a", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvFeedbackDialog extends BaseKtvDialogFragment {
    public static final /* synthetic */ int u = 0;
    public Map<Integer, View> g;
    public String h;
    public p i;
    public int j;
    public String k;
    public String l;
    public String m;
    public String n;
    public fd2.c o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public final boolean t;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.ktv.common.view.BaseKtvDialogFragment
    public final String S90() {
        return "KtvFeedbackDialog";
    }

    @Override // com.bytedance.android.live.ktv.common.view.BaseKtvDialogFragment
    public final int getLayoutId() {
        return 2131565572;
    }

    public final void Z90() {
        if (this.t == false) goto L16;
        TextView r0 = (TextView) X90(2131376939);
        if (r0 != null) goto L7;
        return;
    L7:
        if (mz.c.b(this.l) == false) goto L9;
    L13:
        String r1 = s1.B(2131918386);
    L14:
        r0.setText(r1);
        return;
    L9:
        if (mz.c.b(this.m) == true) goto L11;
    L12:
        r1 = s1.B(2131918387);
        goto L14
    L11:
        if (mz.c.b(this.n) == true) goto L13;
    }

    public final void onDestroyView() {
        p r0 = this.i;
        if (r0 == null) goto L5;
        r0.a.clear();
    L5:
        super.onDestroyView();
        ((LinkedHashMap) this.g).clear();
    }

    public KtvFeedbackDialog() {
        this.g = new LinkedHashMap();
        this.h = "";
        this.k = "ksong";
        this.n = "";
        this.t = ((Boolean) vm2.h.p6.getValue(null, vm2.h.a[378(0x17a, float:5.3E-43)])).booleanValue();
    }

    public static final void Y90(KtvFeedbackDialog r19) {
        if ((!((KtvFeedbackComponentView) r19.X90(2131372271)).getSelectedSet().isEmpty()) == false) goto L58;
        Iterator<String> r1 = ((KtvFeedbackComponentView) r19.X90(2131372271)).getSelectedSet().iterator();
        String r2 = "";
        String r6 = "";
    L6:
        if (r1.hasNext() == false) goto L9;
        r6 = r6 + r1.next() + ',';
        goto L6
    L9:
        if (StringsKt.endsWith$default(r6, ",", false, 2, null) == false) goto L11;
        r6 = r6.substring(0, r6.length() - 1);
    L11:
        String r17 = r6;
        Editable r11 = ((EditText) r19.X90(2131375667)).getText();
        if (r11 == null) goto L14;
        String r12 = r11.toString();
    L15:
        if (r12 != null) goto L17;
    L20:
        boolean r13 = true;
    L21:
        if (r13 == false) goto L29;
        Iterator<String> r7 = ((KtvFeedbackComponentView) r19.X90(2131372289)).getSelectedSet().iterator();
    L24:
        if (r7.hasNext() == false) goto L27;
        r2 = r2 + r7.next() + ',';
        goto L24
    L27:
        if (StringsKt.endsWith$default(r2, ",", false, 2, null) == false) goto L35;
        String r18 = r2.substring(0, r2.length() - 1);
    L37:
        if (r19.t == true) goto L39;
    L46:
        p r14 = r19.i;
        if (r14 == null) goto L64;
        r14.a("", r19.j, r19.k, "", "", r17, r18);
        return;
    L64:
        return;
    L39:
        if (mz.c.b(r18) == false) goto L46;
        r19.dismiss();     // Catch: Exception -> L42
        return;
    L42:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r0 = DialogFragmentLancet.sLastShowStack;
        if (r0 == null) goto L62;
        com.bytedance.crash.d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L62:
        return;
    L35:
        r18 = r2;
        goto L37
    L29:
        Editable r3 = ((EditText) r19.X90(2131375667)).getText();
        if (r3 == null) goto L35;
        String r4 = r3.toString();
        if (r4 == null) goto L35;
        r2 = r4;
        goto L35
    L17:
        if (r12.length() == 0) goto L20;
        r13 = false;
        goto L21
    L14:
        r12 = null;
        goto L15
    L58:
        r19.dismiss();     // Catch: Exception -> L51
        return;
    L51:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r5 = DialogFragmentLancet.sLastShowStack;
        if (r5 == null) goto L66;
        com.bytedance.crash.d.d(r5, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final View X90(int r3) {
        if (this.g != null) goto L5;
        this.g = new LinkedHashMap();
    L5:
        View r0 = this.g.get(Integer.valueOf(r3));
        if (r0 != null) goto L14;
        View r1 = getView();
        if (r1 == null) goto L12;
        View r2 = r1.findViewById(r3);
        if (r2 == null) goto L12;
        this.g.put(Integer.valueOf(r3), r2);
        return r2;
    L12:
        return null;
    L14:
        return r0;
    }

    public final Dialog onCreateDialog(Bundle r3) {
        Dialog r4 = super.onCreateDialog(r3);
        Window r0 = r4.getWindow();
        if (r0 == null) goto L5;
        r0.setSoftInputMode(32);
    L5:
        return r4;
    }

    public final void onViewCreated(View r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r11, "view");
        super.onViewCreated(r11, r12);
        ViewGroup.LayoutParams r4 = null;
        if (this.p == false) goto L6;
        ((TextView) X90(2131376942)).setText(2131918185);
        ((TextView) X90(2131376943)).setText(2131918186);
    L45:
        ((KtvFeedbackComponentView) X90(2131372271)).setOnIssueSelectListener(new KtvFeedbackDialog$initView$1(this));
        ((KtvFeedbackComponentView) X90(2131372289)).setOnIssueSelectListener(new KtvFeedbackDialog$initView$2(this));
        ((TextView) X90(2131376939)).setOnClickListener(x0.a(new KtvFeedbackDialog$initView$3(this)));
        ((TextView) X90(2131376936)).setOnClickListener(x0.a(new KtvFeedbackDialog$initView$4(this)));
        TextView r7 = (TextView) X90(2131376939);
        if (r7 == null) goto L57;
        TextView r13 = (TextView) X90(2131376939);
        if (r13 == null) goto L55;
        ViewGroup.LayoutParams r14 = r13.getLayoutParams();
        if (r14 == null) goto L55;
        if (com.bytedance.android.livesdk.m.c() == false) goto L54;
        r14.width = (int) (r14.width / com.bytedance.android.livesdk.m.b());
        r14.height = (int) (r14.height / com.bytedance.android.livesdk.m.b());
    L54:
        Unit r8 = Unit.INSTANCE;
    L56:
        r7.setLayoutParams(r14);
    L55:
        r14 = null;
    L57:
        TextView r15 = (TextView) X90(2131376936);
        if (r15 == null) goto L68;
        TextView r6 = (TextView) X90(2131376936);
        if (r6 == null) goto L67;
        ViewGroup.LayoutParams r9 = r6.getLayoutParams();
        if (r9 == null) goto L67;
        if (com.bytedance.android.livesdk.m.c() == false) goto L66;
        r9.width = (int) (r9.width / com.bytedance.android.livesdk.m.b());
        r9.height = (int) (r9.height / com.bytedance.android.livesdk.m.b());
    L66:
        Unit r5 = Unit.INSTANCE;
        r4 = r9;
    L67:
        r15.setLayoutParams(r4);
    L68:
        X90(2131367001).setOnClickListener(new f(this));
        ((EditText) X90(2131375667)).addTextChangedListener(new g(this));
        if (this.s == false) goto L86;
        TextView r16 = (TextView) X90(2131376942);
        if (r16 == null) goto L73;
        r16.setText(s1.B(2131918389));
    L73:
        ((TextView) X90(2131376943)).setText(2131918398);
        LinearLayout r17 = (LinearLayout) X90(2131376940);
        if (r17 == null) goto L76;
        r17.setVisibility(8);
    L76:
        Button r18 = (Button) X90(2131389780);
        if (r18 == null) goto L79;
        r18.setVisibility(0);
    L79:
        Button r0 = (Button) X90(2131389780);
        if (r0 == null) goto L82;
        r0.setAlpha(0.34f);
    L82:
        Button r1 = (Button) X90(2131389780);
        if (r1 == null) goto L88;
        r1.setOnClickListener(new c(this));
    L88:
        p r2 = new p();
        this.i = r2;
        NextLiveData<List<com.bytedance.android.livesdk.rank.model.b>> r3 = r2.b;
        if (r3 == null) goto L91;
        r3.observe(this, new d(this));
    L91:
        p r19 = this.i;
        if (r19 == null) goto L94;
        r19.b(this.j, this.k);
    L94:
        p r21 = this.i;
        if (r21 == null) goto L99;
        NextLiveData<Boolean> r22 = r21.c;
        if (r22 == null) goto L99;
        r22.observe(this, new e(this));
    L99:
        pb0.a r23 = pb0.b.a;
        boolean r24 = this.p;
        pb0.a r25 = pb0.b.a;
        if (r25 == null) goto L102;
        r25.w(r24);
    L102:
        ViewGroup r26 = (ViewGroup) r11.findViewById(2131367728);
        TextView r27 = (TextView) r11.findViewById(2131376942);
        TextView r110 = (TextView) r11.findViewById(2131376943);
        KtvOrderSongThemeManager.b(r26, 1);
        if (r27 == null) goto L105;
        KtvOrderSongThemeManager.d(r27, 10);
    L105:
        if (r110 == null) goto L107;
        KtvOrderSongThemeManager.d(r110, KtvOrderSongThemeManager.a);
    L107:
        KtvOrderSongThemeManager.c(X90(2131375667), KtvOrderSongThemeManager.d);
        ((EditText) X90(2131375667)).setHintTextColor(KtvOrderSongThemeManager.a(KtvOrderSongThemeManager.c));
        ((EditText) X90(2131375667)).setTextColor(KtvOrderSongThemeManager.a(10));
        return;
    L86:
        if (this.t == false) goto L88;
        ((TextView) X90(2131390610)).setVisibility(0);
        ((TextView) X90(2131390610)).setOnClickListener(new b(this));
        goto L88
    L6:
        if (this.r == false) goto L26;
        com.bytedance.android.livesdk.chatroom.o r111 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        if (r111 == null) goto L10;
        Boolean r112 = r111.isAnchor();
    L12:
        if (Intrinsics.areEqual(r112, Boolean.TRUE) == true) goto L14;
        ((TextView) X90(2131376942)).setText(2131921859);
        ((TextView) X90(2131376943)).setText(2131921855);
        goto L45
    L14:
        if (Intrinsics.areEqual(this.h, "scene_panel") == false) goto L16;
    L19:
        boolean r113 = true;
    L21:
        if (r113 == false) goto L23;
        ((TextView) X90(2131376942)).setText(2131921865);
        ((TextView) X90(2131376943)).setText(2131921867);
        goto L45
    L23:
        ((TextView) X90(2131376942)).setText(2131921866);
        ((TextView) X90(2131376943)).setText(2131921867);
        goto L45
    L16:
        if (Intrinsics.areEqual(this.h, "link_panel") == true) goto L19;
        r113 = false;
        goto L21
    L10:
        r112 = null;
        goto L12
    L26:
        if (this.q == false) goto L45;
        com.bytedance.android.livesdk.chatroom.o r114 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        if (r114 == null) goto L30;
        Boolean r115 = r114.isAnchor();
    L32:
        if (Intrinsics.areEqual(r115, Boolean.TRUE) == true) goto L34;
        ((TextView) X90(2131376942)).setText(2131918528);
        ((TextView) X90(2131376943)).setText(2131918398);
        goto L45
    L34:
        if (Intrinsics.areEqual(this.h, "scene_panel") == false) goto L36;
    L39:
        boolean r116 = true;
    L41:
        if (r116 == false) goto L43;
        ((TextView) X90(2131376942)).setText(2131918620);
        ((TextView) X90(2131376943)).setText(2131918635);
        goto L45
    L43:
        ((TextView) X90(2131376942)).setText(2131918634);
        ((TextView) X90(2131376943)).setText(2131918635);
        goto L45
    L36:
        if (Intrinsics.areEqual(this.h, "link_panel") == true) goto L39;
        r116 = false;
        goto L41
    L30:
        r115 = null;
        goto L32
    }
}
