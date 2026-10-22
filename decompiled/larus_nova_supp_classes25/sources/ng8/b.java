package ng8;

import android.content.Context;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.google.gson.Gson;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.bean.d;
import com.larus.bmhome.chat.cell.BaseMessageListCell;
import com.larus.bmhome.chat.layout.item.i;
import com.larus.bmhome.chat.list.cell.text.components.bottom.riskwarning.TipsBlockType;
import com.larus.bmhome.view.MessageRiskWarningTextView;
import com.larus.bmhome.view.u3;
import com.larus.chat.common.databinding.LarusLayoutMessageRiskWarningTextBinding;
import com.larus.im.bean.message.Message;
import com.larus.network.http.HttpExtKt;
import com.larus.utils.e1;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b extends bd8.b implements tg8.a {
    public final Type l;
    public MessageRiskWarningTextView m;

    public static final class a {
    }

    static {
    }

    @Override // bd8.b
    public final void C() {
        MessageRiskWarningTextView r0 = this.m;
        if (r0 == null) goto L6;
        e1.o(r0);
        return;
    }

    public b(int r2) {
        super(true, r2);
        this.l = new c().getType();
    }

    @Override // bd8.b
    public final void w(Message r7, int r8, ec8.b r9) {
        Intrinsics.checkNotNullParameter(r7, "message");
        Intrinsics.checkNotNullParameter(r7, "message");
        Intrinsics.checkNotNullParameter(r7, "message");
        MessageRiskWarningTextView r10 = this.m;
        if (r10 == null) goto L5;
        e1.o(r10);
    L5:
        MessageRiskWarningTextView r11 = this.m;
        if (r11 == null) goto L9;
        r11.setUrlVisible(false);
        r11.setTextVisible(false);
    L9:
        if (d.Q0(r7) == true) goto L15;
        if (d.I0(r7) == true) goto L15;
        if (r7.getMessageStatusLocal() == 20) goto L15;
    L16:
        boolean r12 = true;
    L18:
        if (r12 == false) goto L130;
        String r13 = r7.getMessageId();
        if (r13 != null) goto L22;
    L25:
        boolean r14 = true;
    L26:
        if (r14 == true) goto L130;
        Map r15 = r7.getExt();
        if (r15 == null) goto L31;
        String r16 = (String) r15.get("risk_tips");
    L32:
        Gson r1 = HttpExtKt.f;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L35
        Object r17 = Result.constructor-impl((List) r1.fromJson(r16, this.l));     // Catch: Throwable -> L35
    L38:
        if (Result.isFailure-impl(r17) == false) goto L40;
        r17 = null;
    L40:
        List r18 = (List) r17;
        List r3 = r18;
        if (r3 != null) goto L43;
    L46:
        boolean r4 = true;
    L47:
        if (r4 == false) goto L51;
        MessageRiskWarningTextView r19 = this.m;
        if (r19 == null) goto L151;
        e1.o(r19);
        return;
    L151:
        return;
    L51:
        MessageRiskWarningTextView r5 = this.m;
        if (r5 == null) goto L54;
        e1.x(r5);
    L54:
        Iterator r20 = r18.iterator();
    L56:
        if (r20.hasNext() == false) goto L154;
        ng8.a r6 = (ng8.a) r20.next();
        String r21 = r6.a();
        if (r21 == null) goto L60;
        String r22 = StringsKt.trimStart(r21, new char[]{'\n'});
    L61:
        if (r22 != null) goto L63;
    L66:
        boolean r23 = true;
    L67:
        if (r23 == true) goto L56;
        int r24 = r6.getType();
        if (r24 != TipsBlockType.TIPS_BLOCK_TYPE_TEXT.getValue()) goto L78;
        MessageRiskWarningTextView r25 = this.m;
        if (r25 == null) goto L74;
        r25.setWarningText(r22);
    L74:
        MessageRiskWarningTextView r26 = this.m;
        if (r26 == null) goto L105;
        r26.setTextVisible(true);
    L105:
        MessageRiskWarningTextView r27 = this.m;
        if (r27 == null) goto L56;
        LarusLayoutMessageRiskWarningTextBinding r28 = r27.a;
        if (r28 == null) goto L114;
        TextView r29 = r28.b;
        if (r29 == null) goto L114;
        if (r29.getVisibility() != 0) goto L114;
        boolean r30 = true;
    L115:
        if (r30 == false) goto L56;
        LarusLayoutMessageRiskWarningTextBinding r31 = r27.a;
        if (r31 == null) goto L123;
        TextView r32 = r31.c;
        if (r32 == null) goto L123;
        if (r32.getVisibility() != 8) goto L123;
        boolean r33 = true;
    L124:
        if (r33 == false) goto L56;
        LarusLayoutMessageRiskWarningTextBinding r34 = r27.a;
        if (r34 == null) goto L56;
        TextView r35 = r34.b;
        if (r35 == null) goto L56;
        r35.setPaddingRelative(r35.getPaddingStart(), r35.getPaddingTop(), r35.getPaddingEnd(), r27.b);
    L123:
        r33 = false;
    L114:
        r30 = false;
        goto L115
    L78:
        if (r24 != TipsBlockType.TIPS_BLOCK_TYPE_URL.getValue()) goto L105;
        MessageRiskWarningTextView r36 = this.m;
        if (r36 == null) goto L102;
        String r37 = r6.b();
        if (r22 != null) goto L84;
    L87:
        boolean r38 = true;
    L88:
        if (r38 == true) goto L102;
        if (r37 != null) goto L91;
    L94:
        boolean r39 = true;
    L95:
        if (r39 == true) goto L102;
        SpannableString r40 = new SpannableString(r22);
        r40.setSpan(new u3(r36, r37), 0, r22.length(), 33);
        LarusLayoutMessageRiskWarningTextBinding r41 = r36.a;
        if (r41 == null) goto L102;
        TextView r42 = r41.c;
        if (r42 == null) goto L102;
        r42.setText(r40);
        r42.setMovementMethod(LinkMovementMethod.getInstance());
        goto L102
    L91:
        if (r37.length() == 0) goto L94;
        r39 = false;
        goto L95
    L84:
        if (r22.length() == 0) goto L87;
        r38 = false;
    L102:
        MessageRiskWarningTextView r43 = this.m;
        if (r43 == null) goto L105;
        r43.setUrlVisible(true);
        goto L105
    L63:
        if (r22.length() == 0) goto L66;
        r23 = false;
        goto L67
    L60:
        r22 = null;
        goto L61
    L154:
        return;
    L43:
        if (r3.isEmpty() == true) goto L46;
        r4 = false;
    L35:
        th = move-exception;
        Result.Companion r44 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L38
    L31:
        r16 = null;
        goto L32
    L22:
        if (r13.length() == 0) goto L25;
        r14 = false;
    L130:
        MessageRiskWarningTextView r45 = this.m;
        if (r45 == null) goto L153;
        e1.o(r45);
        return;
    L153:
        return;
    L15:
        if (r7.getMessageStatusLocal() == 23) goto L16;
        r12 = false;
        goto L18
    }

    @Override // bd8.b
    public final List<View> x(int r2, Context r3, BaseMessageListCell<?> r4, i r5, q0 r6, Fragment r7) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super.x(r2, r3, r4, r5, r6, r7);
        MessageRiskWarningTextView r8 = new MessageRiskWarningTextView(r3, null, 6, 0);
        this.m = r8;
        if (r5 == null) goto L6;
        r5.addView(r8, r2, new LinearLayout.LayoutParams(-2, -2));
    L6:
        return CollectionsKt.listOf(r8);
    }
}
