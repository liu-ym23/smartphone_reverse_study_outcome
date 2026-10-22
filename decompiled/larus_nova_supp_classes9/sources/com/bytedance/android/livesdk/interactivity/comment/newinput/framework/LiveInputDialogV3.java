package com.bytedance.android.livesdk.interactivity.comment.newinput.framework;

import am2.x;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.style.ImageSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.common.keyboard.MeasureLinearLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.DigHoleScreenUtil;
import com.bytedance.android.live.core.utils.f1;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.event.q;
import com.bytedance.android.livesdk.event.r;
import com.bytedance.android.livesdk.gift.model.CardLockInfo;
import com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService;
import com.bytedance.android.livesdk.interactivity.api.comment.data.InputDraftType;
import com.bytedance.android.livesdk.interactivity.api.comment.keyboard.HintType;
import com.bytedance.android.livesdk.interactivity.api.comment.plugin.CommentBusinessType;
import com.bytedance.android.livesdk.interactivity.api.comment.plugin.CommentContentType;
import com.bytedance.android.livesdk.interactivity.api.comment.plugin.CommentFlowContext;
import com.bytedance.android.livesdk.interactivity.api.comment.plugin.CommentInputConfig;
import com.bytedance.android.livesdk.interactivity.api.expression.MentionSpan;
import com.bytedance.android.livesdk.interactivity.api.monitor.InteractivityMonitor;
import com.bytedance.android.livesdk.interactivity.api.monitor.InteractivityTraceMonitor;
import com.bytedance.android.livesdk.interactivity.api.monitor.PublicScreenTraceMonitor;
import com.bytedance.android.livesdk.interactivity.api.monitorV2.business.InputDescNode;
import com.bytedance.android.livesdk.interactivity.api.monitorV2.business.SendFailed;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenABHelper;
import com.bytedance.android.livesdk.interactivity.comment.CommentWidget;
import com.bytedance.android.livesdk.interactivity.comment.utils.CommentUtils;
import com.bytedance.android.livesdk.log.b0;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdk.utils.r3;
import com.bytedance.android.livesdk.utils.t2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.service.IMiddlewareLiveService;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.JsonObject;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import ec2.a1;
import ec2.i0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;
import zg1.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/newinput/framework/LiveInputDialogV3;", "Landroidx/fragment/app/DialogFragment;", "Lx22/b;", "<init>", "()V", "a", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class LiveInputDialogV3 extends DialogFragment implements x22.b {
    public com.bytedance.android.livesdk.interactivity.comment.newinput.c d;
    public x22.e e;
    public MeasureLinearLayout f;
    public g g;
    public CommentFlowContext h;
    public final List<InputPanelSectionContainer> i;
    public DataCenter j;
    public boolean k;
    public boolean l;
    public boolean m;
    public long n;
    public long o;
    public long p;
    public int q;
    public final fc2.f r;
    public final int s;
    public final boolean t;

    public static final class a {
    }

    public static final class b implements DialogInterface.OnKeyListener {
        public final /* synthetic */ LiveInputDialogV3 a;

        public b(LiveInputDialogV3 r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public final boolean onKey(DialogInterface r1, int r2, KeyEvent r3) {
            if (r2 != 4) goto L7;
            this.a.q = 2;
            return false;
        L7:
            return false;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ EditText a;
        public final /* synthetic */ LiveInputDialogV3 b;
        public final /* synthetic */ long c;
        public final /* synthetic */ int d;
        public final /* synthetic */ int e;

        public c(EditText r1, LiveInputDialogV3 r2, long r3, int r5, int r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r5;
            this.e = r6;
        }

        public final void a() {
            if (this.b.isResumed() == false) goto L11;
            LiveInputDialogV3 r0 = this.b;
            if (r0.l == false) goto L11;
            if (r0.getContext() == null) goto L11;
            t2.b(this.b.getContext(), this.a);
            this.b.Z90(this.c, this.d + 1, this.e);
            return;
        L11:
            i40.h.a("V3 tryRestoreSoftKeyboard return");
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public void U90(MeasureLinearLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "layout");
    }

    public void W90(MeasureLinearLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "layout");
    }

    public int getLayoutId() {
        return 0;
    }

    public void hideSoftKeyBoard() {
    }

    public final boolean X90() {
        IRoomContextService r0 = jc1.k.f(IRoomContextService.class);
        if (r0 == null) goto L9;
        o r1 = IRoomContextService.a.a(r0, this.j, 0, 2);
        if (r1 == null) goto L9;
        Boolean r2 = r1.isAnchor();
        if (r2 == null) goto L9;
        return r2.booleanValue();
    L9:
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void Y90() {
        i40.h.c("sendComment start", true);
        this.p = System.currentTimeMillis();
        g r0 = this.g;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        TokenCert r1 = b72.a.a;
        if (b72.a.b(getActivity()) == true) goto L12;
        z32.c.a(InputDescNode.SendInterceptReason, SendFailed.NotLogin.getReason());
        com.bytedance.android.livesdk.interactivity.api.monitor.b.e("comment", "not login", null);
        return;
    L12:
        g r3 = this.g;
        if (r3 == null) goto L237;
        EditText r4 = r3.a;
        if (r4 == null) goto L238;
        Editable r5 = r4.getText();
        if (r5 == null) goto L241;
        String r10 = r5.toString();
        if (r2 == false) goto L28;
        IMiddleWareHostContext r6 = jc1.k.f(IMiddleWareHostContext.class);
        if (r6 == null) goto L28;
        if (r6.isNeedProtectUnderage() != true) goto L28;
        f2.b(2131919796, 0);
        z32.c.a(InputDescNode.SendInterceptReason, SendFailed.TeenagerProtect.getReason());
        com.bytedance.android.livesdk.interactivity.api.monitor.b.e("comment", "teenager protect", null);
        return;
    L28:
        if (this.e != null) goto L31;
        i40.h.a("V3 send click error, listener null");
        com.bytedance.android.livesdk.interactivity.api.monitor.b.e("comment", "listener null", null);
        return;
    L31:
        g r7 = this.g;
        if (r7 == null) goto L36;
        EditText r8 = r7.a;
        if (r8 == null) goto L36;
        Editable r9 = r8.getText();
    L37:
        if (r9 != null) goto L40;
        i40.h.a("V3 send click error, text null");
        com.bytedance.android.livesdk.interactivity.api.monitor.b.e("comment", "text is null", null);
        return;
    L40:
        ArrayList r11 = new ArrayList();
        com.bytedance.android.livesdk.interactivity.comment.input.a[] r13 = (com.bytedance.android.livesdk.interactivity.comment.input.a[]) r5.getSpans(0, r5.length(), com.bytedance.android.livesdk.interactivity.comment.input.a.class);
        int r14 = r13.length;
        int r15 = 0;
    L42:
        if (r15 >= r14) goto L50;
        com.bytedance.android.livesdk.interactivity.comment.input.a r16 = r13[r15];
        int r17 = r5.getSpanStart(r16);
        int r18 = r5.getSpanEnd(r16);
        int r19 = r16.getType();
        String r20 = String.valueOf(r16.f.getId());
        String r21 = r16.f.getName();
        if (r21 != null) goto L46;
        r21 = BuildConfig.FLAVOR;
    L46:
        int r110 = r18 - r17;
        py.k r111 = r16.f.getEmoji();
        if (r111 != null) goto L49;
        r111 = (py.k) vh7.f.c(py.k.class);
    L49:
        r11.add(new com.bytedance.android.livesdk.event.n(r19, r20, r21, r17, r110, r16, r111, 2.0f));
        r15 = r15 + 1;
        goto L42
    L50:
        com.bytedance.android.livesdk.interactivity.comment.input.d[] r23 = (com.bytedance.android.livesdk.interactivity.comment.input.d[]) r5.getSpans(0, r5.length(), com.bytedance.android.livesdk.interactivity.comment.input.d.class);
        int r24 = r23.length;
        int r25 = 0;
    L51:
        if (r25 >= r24) goto L60;
        com.bytedance.android.livesdk.interactivity.comment.input.d r26 = r23[r25];
        int r112 = r5.getSpanStart(r26);
        int r113 = r26.getType();
        String r114 = String.valueOf(r26.h.b());
        String r115 = r26.h.c();
        if (r115 != null) goto L55;
        String r116 = BuildConfig.FLAVOR;
    L56:
        int r117 = r112 + r26.f;
        int r118 = r26.g;
        py.k r27 = r26.h.a();
        if (r27 != null) goto L59;
        r27 = (py.k) vh7.f.c(py.k.class);
    L59:
        r11.add(new com.bytedance.android.livesdk.event.n(r113, r114, r116, r117, r118, r26, r27, 1.0f));
        r25 = r25 + 1;
        r23 = r23;
        goto L51
    L55:
        r116 = r115;
        goto L56
    L60:
        com.bytedance.android.livesdk.interactivity.comment.input.c[] r28 = (com.bytedance.android.livesdk.interactivity.comment.input.c[]) r5.getSpans(0, r5.length(), com.bytedance.android.livesdk.interactivity.comment.input.c.class);
        int r29 = r28.length;
        int r30 = 0;
    L61:
        if (r30 >= r29) goto L78;
        com.bytedance.android.livesdk.interactivity.comment.input.c r31 = r28[r30];
        int r119 = r5.getSpanStart(r31);
        int r33 = r5.getSpanEnd(r31);
        if (PublicScreenABHelper.c() == false) goto L65;
        float r120 = PublicScreenABHelper.e();
    L66:
        float r210 = r120;
        int r121 = r31.getType();
        String r122 = r31.g.c();
        if (r122 != null) goto L69;
        String r123 = BuildConfig.FLAVOR;
    L70:
        String r124 = r31.g.d();
        if (r124 != null) goto L73;
        String r125 = BuildConfig.FLAVOR;
    L74:
        int r126 = r33 - r119;
        py.k r34 = r31.g.a();
        if (r34 != null) goto L77;
        r34 = (py.k) vh7.f.c(py.k.class);
    L77:
        r11.add(new com.bytedance.android.livesdk.event.n(r121, r123, r125, r119, r126, r31, r34, r210));
        r30 = r30 + 1;
        goto L61
    L73:
        r125 = r124;
        goto L74
    L69:
        r123 = r122;
        goto L70
    L65:
        r120 = com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.h.a;
        goto L66
    L78:
        g r35 = this.g;
        if (r35 == null) goto L87;
        com.bytedance.android.livesdk.interactivity.comment.newinput.c r36 = r35.V();
        if (r36 == null) goto L87;
        com.bytedance.android.livesdk.interactivity.comment.newinput.a r37 = r36.g;
        if (r37 == null) goto L87;
        com.bytedance.android.livesdk.interactivity.comment.model.c r38 = r37.z;
        if (r38 == null) goto L87;
        long r127 = r38.b();
    L89:
        if (r127 <= 0) goto L94;
        g r39 = this.g;
        if (r39 == null) goto L94;
        r39.e = 14;
    L94:
        if (((com.bytedance.android.livesdk.interactivity.comment.input.e[]) r5.getSpans(0, r5.length(), com.bytedance.android.livesdk.interactivity.comment.input.e.class)).length <= 0) goto L99;
        g r40 = this.g;
        if (r40 == null) goto L99;
        r40.e = 15;
    L99:
        if ((!r11.isEmpty()) == false) goto L101;
        com.bytedance.android.livesdk.event.m r41 = new com.bytedance.android.livesdk.event.m(r11);
    L102:
        CommentFlowContext r43 = this.h;
        if (r43 == null) goto L108;
        CommentInputConfig r44 = r43.d;
        if (r44 == null) goto L107;
        boolean r45 = r44.s;
    L109:
        if (r45 == false) goto L123;
        ArrayList r46 = new ArrayList();
        MentionSpan[] r47 = (MentionSpan[]) r5.getSpans(0, r5.length(), MentionSpan.class);
        int r128 = r47.length;
        int r129 = 0;
    L111:
        if (r129 >= r128) goto L121;
        MentionSpan r130 = r47[r129];
        int r131 = r5.getSpanStart(r130);
        int r132 = r5.getSpanEnd(r130);
        int r133 = r130.getType();
        JSONObject r48 = new JSONObject();
        Editable r211 = r5;
        r48.put("uid", r130.b);     // Catch: JSONException -> L217
    L220:
        r48.put("webcast_uid", r130.e);     // Catch: JSONException -> L218
    L119:
        r46.add(new r(r133, r48.toString(), r131, r132 - r131, r130.a, r130.f));
        r129 = r129 + 1;
        r5 = r211;
        goto L111
    L121:
        if ((!r46.isEmpty()) == false) goto L123;
        q r49 = new q(r46);
    L125:
        if (StringsKt.isBlank(r10) == true) goto L127;
    L130:
        g r50 = this.g;
        if (r50 == null) goto L133;
        Boolean r134 = Boolean.valueOf(r50.m());
    L134:
        com.bytedance.android.livesdk.interactivity.comment.newinput.c r51 = this.d;
        if (r51 == null) goto L139;
        com.bytedance.android.livesdk.interactivity.comment.newinput.a r53 = r51.g;
        if (r53 == null) goto L139;
        com.bytedance.android.live.profit.privilege.model.danmu.b r135 = r53.d;
    L140:
        if (r2 == false) goto L212;
        if (r135 == null) goto L212;
        if (r135.getStyle() == 0) goto L212;
        if (r135.getStyle() == 21) goto L212;
        g r54 = this.g;
        if (r54 == null) goto L151;
        EditText r55 = r54.a;
        if (r55 == null) goto L151;
        Editable r56 = r55.getText();
    L152:
        int r57 = CommentUtils.a;
        if (r56 == null) goto L163;
        Integer r58 = (Integer) a1.a.getValue();
        if (r58.intValue() < 0) goto L163;
        ImageSpan[] r59 = (ImageSpan[]) r56.getSpans(0, r56.length(), ImageSpan.class);
        if (r59 == null) goto L163;
        if (r59.length <= r58.intValue()) goto L163;
        boolean r60 = true;
    L164:
        if (r60 == false) goto L167;
        f2.c(getString(2131918951, new Object[]{(Integer) a1.a.getValue()}), 0);
        z32.c.a(InputDescNode.SendInterceptReason, SendFailed.Overlength.getReason());
        com.bytedance.android.livesdk.interactivity.api.monitor.b.e("privilege", "danmaku overlength", null);
        return;
    L167:
        Boolean r61 = (Boolean) l42.a.o.getValue();
        Context r63 = getContext();
        if (r63 != null) goto L170;
        boolean r64 = true;
    L205:
        if (r64 == true) goto L239;
        int r65 = r135.getStyle();
        if (r134 == null) goto L209;
        boolean r66 = r134.booleanValue();
    L210:
        S90(r10, true, r65, r66, V90(r135), r41, r49);
        dismissInputDialog();
        return;
    L209:
        r66 = false;
        goto L210
    L239:
        return;
    L170:
        if (r61.booleanValue() == true) goto L172;
    L203:
        r64 = false;
        goto L205
    L172:
        if (r135.getDiamondCount() <= 0) goto L203;
        String r67 = r3.b();
        Object[] r68 = new Object[3];
        int r69 = r135.getStyle();
        Intrinsics.checkNotNullParameter(r135, "$this$getTabStyleName");
        if (r69 == 2) goto L178;
        if (r69 == 3) goto L177;
        String r70 = "基础弹幕";
    L179:
        r68[0] = r70;
        r68[1] = Integer.valueOf((int) r135.getDiamondCount());
        r68[2] = r67;
        String r71 = s1.C(2131918955, r68);
        String r73 = s1.B(2131918957);
        String r74 = s1.B(2131918953);
        com.bytedance.android.livesdk.interactivity.comment.input.i r136 = new com.bytedance.android.livesdk.interactivity.comment.input.i(r63);
        TextView r75 = r136.a;
        if (r75 != null) goto L182;
        Intrinsics.throwUninitializedPropertyAccessException("titleText");
    L182:
        r75.setText(r73);
        TextView r76 = r136.b;
        if (r76 != null) goto L185;
        Intrinsics.throwUninitializedPropertyAccessException("contentText");
    L185:
        r76.setText(r71);
        TextView r77 = r136.d;
        if (r77 != null) goto L188;
        Intrinsics.throwUninitializedPropertyAccessException("checkedText");
    L188:
        r77.setText(r74);
        Button r78 = r136.e;
        if (r78 != null) goto L191;
        Intrinsics.throwUninitializedPropertyAccessException("leftButton");
    L191:
        r78.setOnClickListener(new n(r136));
        Button r137 = r136.f;
        if (r137 != null) goto L194;
        Intrinsics.throwUninitializedPropertyAccessException("rightButton");
    L194:
        r137.setOnClickListener(new l(r136, this, r135, r10, r41, r49));
        r136.setOnDismissListener(new m(this, r135));
        r64 = true;
        this.k = true;
        if (DialogLancet.shouldBlockDialogShow(r136) == false) goto L224;
        DialogLancet.handleBlockedDialogShow(r136);
    L200:
        if (com.bytedance.android.livesdk.interactivity.api.monitor.b.a.monitorCostShow == false) goto L205;
        com.bytedance.android.livesdk.interactivity.api.monitor.c r79 = new com.bytedance.android.livesdk.interactivity.api.monitor.c(0, null, 0, null, 15);
        r79.a(InteractivityMonitor.Event.CostConfirmWindowShow);
        r79.b(InteractivityTraceMonitor.Event.CostConfirmWindowShow);
        goto L205
    L224:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L219
    L198:
        DialogLancet.beforeDialogShow(r136);
        r136.show();
        DialogLancet.afterDialogShow(r136);
        goto L200
    L177:
        r70 = "至尊弹幕";
        goto L179
    L178:
        r70 = "高级弹幕";
    L163:
        r60 = false;
    L151:
        r56 = null;
    L212:
        if (r134 == null) goto L214;
        boolean r80 = r134.booleanValue();
        com.bytedance.android.live.profit.privilege.model.danmu.b r81 = null;
    L215:
        S90(r10, r2, 0, r80, V90(r81), r41, r49);
        dismissInputDialog();
        return;
    L214:
        r81 = null;
        r80 = false;
    L139:
        r135 = null;
        goto L140
    L133:
        r134 = null;
        goto L134
    L127:
        if (r11.isEmpty() == false) goto L130;
        i40.h.a("send click error, invalide content ");
        com.bytedance.android.livesdk.interactivity.api.monitor.b.e("comment", "content is null", null);
        return;
    L123:
        r49 = null;
        goto L125
    L107:
        r45 = false;
        goto L109
    L108:
        r45 = true;
        goto L109
    L101:
        r41 = null;
    L87:
        r127 = 0;
    L36:
        r9 = null;
        goto L37
    L241:
        return;
    L238:
        return;
    L237:
        return;
    L5:
        if (r0.m0() != true) goto L7;
        r2 = true;
        goto L8
    }

    public final void dismissInputDialog() {
        InputDescNode r0 = InputDescNode.LastSubTab;     // Catch: Exception -> L17
        g r1 = this.g;     // Catch: Exception -> L17
        if (r1 == null) goto L8;
        InputSectionType r2 = r1.Q();     // Catch: Exception -> L17
        if (r2 == null) goto L8;
        String r3 = r2.getTypeName();     // Catch: Exception -> L17
        if (r3 == null) goto L8;
    L9:
        z32.c.a(r0, r3);     // Catch: Exception -> L17
        hideSoftKeyBoard();     // Catch: Exception -> L17
        dismissAllowingStateLoss();     // Catch: Exception -> L12
    L25:
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");     // Catch: Exception -> L17
        Throwable r4 = DialogFragmentLancet.sLastShowStack;     // Catch: Exception -> L17
        if (r4 == null) goto L24;
        com.bytedance.crash.d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Exception -> L17
        return;
    L24:
        return;
    L8:
        r3 = CardLockInfo.sUNKNOWN;
    L17:
        e = move-exception;
        i40.h.c("dismiss exception: " + e.getMessage(), true);
    }

    public LiveInputDialogV3() {
        this.i = new ArrayList();
        this.q = -1;
        fc2.f r0 = (fc2.f) i0.a.getValue();
        this.r = r0;
        this.s = r0.a();
        this.t = r0.d();
    }

    public final void T90(DialogInterface r18) {
        Intrinsics.checkNotNullParameter(r18, "dialog");
        this.o = System.currentTimeMillis();
        com.bytedance.android.livesdk.f.d().c = false;
        com.bytedance.android.livesdk.f.d().f();
        i1 r0 = new i1(0, false);
        PublicScreenTraceMonitor.m("LiveInputDialog.onDismiss.send@" + r0.hashCode());
        xs2.b.a().post(r0);
        g r1 = this.g;
        if (r1 == null) goto L7;
        com.bytedance.android.livesdk.interactivity.comment.audio.c r2 = r1.c;
        if (r2 == null) goto L7;
        r2.clear();
    L7:
        Iterator r3 = ((ArrayList) this.i).iterator();
    L9:
        if (r3.hasNext() == false) goto L14;
        Iterator<Map.Entry<InputSectionType, k<?, ?>>> r4 = ((InputPanelSectionContainer) r3.next()).getSectionProviders().entrySet().iterator();
    L12:
        if (r4.hasNext() == false) goto L9;
        r4.next().getValue().d();
        goto L12
    L14:
        ((ArrayList) this.i).clear();
        long r5 = this.o - this.n;
        HashMap r6 = new HashMap();
        r6.put("duration", String.valueOf(r5));
        IInteractivityInjectService r7 = (IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class);
        if (r7 == null) goto L17;
        r7.buildVsRoomLog(null, r6);
    L17:
        j0.l().sendLog("livesdk_comment_panel_duration", r6, new Object[]{IRoom.class, x.class});
        x22.e r8 = this.e;
        if (r8 == null) goto L48;
        g r9 = this.g;
        if (r9 == null) goto L24;
        EditText r10 = r9.a;
        if (r10 == null) goto L24;
        Editable r11 = r10.getText();
    L25:
        InputDraftType r13 = InputDraftType.Companion.getType(this.h);
        CommentFlowContext r14 = this.h;
        if (r14 == null) goto L28;
        long r15 = r14.l;
    L29:
        com.bytedance.android.livesdk.interactivity.api.comment.data.e r16 = new com.bytedance.android.livesdk.interactivity.api.comment.data.e(r11, r13, r15);
        CommentWidget.e r17 = (CommentWidget.e) r8;
        CommentWidget r19 = r17.a;
        r19.B = null;
        x22.d r20 = r19.p1;
        r20.getClass();
        Intrinsics.checkNotNullParameter(r16, "draft");
        r20.b.put(r16.d, r16);
        CommentWidget r21 = r17.a;
        r21.C.i = 0;
        r21.S = null;
        if (r21.L0 == true) goto L77;
    L47:
        i40.h.a.clear();
        i40.h.b.clear();
        goto L48
    L77:
    L39:
        e = move-exception;
        SafetyGuard.a("report keyboard log error", e, null);
    L41:
        String r23 = null;
    L42:
        if (r23 == null) goto L47;
        com.bytedance.android.livesdk.interactivity.api.settings.config.n r24 = com.bytedance.android.livesdk.interactivity.api.monitor.b.a;
        Intrinsics.checkNotNullParameter(r23, "log");
        if (com.bytedance.android.livesdk.interactivity.api.monitor.b.a.monitorKeyboard == false) goto L47;
        LinkedHashMap r110 = new LinkedHashMap();
        r110.put("log", r23);
        Unit r25 = Unit.INSTANCE;
        com.bytedance.android.livesdk.interactivity.api.monitor.c r26 = new com.bytedance.android.livesdk.interactivity.api.monitor.c(0, null, 0, r110, 7);
        r26.a(InteractivityMonitor.Event.InputPanelKeyboardLog);
        r26.b(InteractivityTraceMonitor.Event.InputPanelKeyboardLog);
        goto L47
    L32:
        if (i40.h.a.isEmpty() == true) goto L41;
        ArrayList r27 = new ArrayList();     // Catch: Exception -> L39
        StringBuilder r28 = new StringBuilder();     // Catch: Exception -> L39
        int r29 = i40.h.b.size();     // Catch: Exception -> L39
        int r111 = 0;
    L35:
        if (r111 >= r29) goto L37;
        r28.append(i40.h.c.format(ListProtector.get(i40.h.b, r111)));     // Catch: Exception -> L39
        r28.append(":");     // Catch: Exception -> L39
        r28.append((String) ListProtector.get(i40.h.a, r111));     // Catch: Exception -> L39
        r28.append("\n");     // Catch: Exception -> L39
        r27.add(r28.toString());     // Catch: Exception -> L39
        StringsKt.clear(r28);     // Catch: Exception -> L39
        r111 = r111 + 1;     // Catch: Exception -> L39
        goto L35
    L37:
        i40.h.a.clear();     // Catch: Exception -> L39
        i40.h.b.clear();     // Catch: Exception -> L39
        r23 = r27.toString();     // Catch: Exception -> L39
        goto L42
    L28:
        r15 = 0;
    L24:
        r11 = null;
    L48:
        this.m = false;
        this.l = false;
        IRoomContextService r30 = jc1.k.f(IRoomContextService.class);
        if (r30 == null) goto L57;
        o r31 = IRoomContextService.a.a(r30, this.j, 0, 2);
        if (r31 == null) goto L57;
        com.bytedance.live.datacontext.m r33 = r31.getRoom();
        if (r33 == null) goto L57;
        IRoom r34 = (IRoom) r33.getValue();
        if (r34 == null) goto L57;
        String r35 = r34.getIdStr();
    L58:
        DataCenter r36 = this.j;
        if (r36 == null) goto L61;
        r36.put("data_click_preview_comment_enter_room", Boolean.FALSE);
    L61:
        com.bytedance.android.livesdk.interactivity.comment.newinput.c r37 = this.d;
        if (r37 != null) goto L64;
    L75:
        super.onDismiss(r18);
        b0.o().getClass();
        com.bytedance.android.live.core.log.g.i("ttlive_msg", "input dialog V3 dismiss");
        this.e = null;
        return;
    L64:
        if (r37.g.w == true) goto L67;
        r37 = null;
    L67:
        if (r37 == null) goto L75;
        List<Integer> r38 = com.bytedance.android.livesdk.interactivity.api.comment.data.d.a;
        if (com.bytedance.android.livesdk.interactivity.api.comment.data.d.a.contains(Integer.valueOf(this.q)) == false) goto L71;
        jc1.k.n(IMiddlewareLiveService.class).getCurrentInteractionUiAction().excActionBySetting(r35);
        goto L75
    L71:
        DataCenter r39 = this.j;
        if (r39 == null) goto L74;
        r39.put("data_click_preview_comment_enter_room", Boolean.TRUE);
    L74:
        jc1.k.n(IMiddlewareLiveService.class).getCurrentInteractionUiAction().showInteractionAndEnterRoom(r35);
    L57:
        r35 = null;
        goto L58
    }

    public HashMap<String, Object> V90(com.bytedance.android.live.profit.privilege.model.danmu.b r19) {
        HashMap<String, Object> r1 = new HashMap();
        if (r19 == null) goto L5;
        r1.put("danmu_money", Long.valueOf(r19.getDiamondCount()));
    L5:
        g r2 = this.g;
        if (r2 == null) goto L12;
        com.bytedance.android.livesdk.interactivity.comment.newinput.c r3 = r2.V();
        if (r3 == null) goto L12;
        com.bytedance.android.livesdk.interactivity.comment.newinput.a r4 = r3.g;
        if (r4 == null) goto L12;
        boolean r5 = r4.h;
    L13:
        r1.put("is_from_comment_operate_copy", Boolean.valueOf(r5));
        long r6 = this.p;
        long r7 = 0;
        if (r6 <= 0) goto L16;
        r1.put("start_send_time", Long.valueOf(r6));
        this.p = 0;
    L16:
        g r8 = this.g;
        if (r8 == null) goto L23;
        com.bytedance.android.livesdk.interactivity.comment.newinput.c r9 = r8.V();
        if (r9 == null) goto L23;
        com.bytedance.android.livesdk.interactivity.comment.newinput.a r10 = r9.g;
        if (r10 == null) goto L23;
        String r11 = r10.a;
    L24:
        int r13 = x22.f.a;
        if (r11 != null) goto L27;
        r11 = CardLockInfo.sUNKNOWN;
    L27:
        r1.put("paste_edit_method", r11);
        r1.put("is_self_click_send", Boolean.TRUE);
        long r14 = System.currentTimeMillis();
        g r15 = this.g;
        if (r15 == null) goto L30;
        long r16 = r15.u();
    L31:
        r1.put("user_send_duration", Long.valueOf(r14 - r16));
        g r17 = this.g;
        if (r17 == null) goto L38;
        com.bytedance.android.livesdk.interactivity.comment.newinput.c r18 = r17.V();
        if (r18 == null) goto L38;
        com.bytedance.android.livesdk.interactivity.comment.newinput.a r20 = r18.g;
        if (r20 == null) goto L38;
        boolean r21 = r20.s;
    L39:
        r1.put("is_from_click_event", Boolean.valueOf(r21));
        g r23 = this.g;
        if (r23 == null) goto L51;
        com.bytedance.android.livesdk.interactivity.comment.newinput.c r24 = r23.V();
        if (r24 == null) goto L51;
        com.bytedance.android.livesdk.interactivity.comment.newinput.a r25 = r24.g;
        if (r25 == null) goto L51;
        x22.a r26 = r25.e;
        if (r26 == null) goto L51;
        HintType r27 = r26.getType();
        if (r27 == null) goto L51;
        String r28 = r27.getTypeName();
        if (r28 == null) goto L51;
    L52:
        r1.put("default_text_type", r28);
        g r29 = this.g;
        if (r29 == null) goto L65;
        com.bytedance.android.livesdk.interactivity.comment.newinput.c r30 = r29.V();
        if (r30 == null) goto L65;
        com.bytedance.android.livesdk.interactivity.comment.newinput.a r31 = r30.g;
        if (r31 == null) goto L65;
        Set<com.bytedance.android.livesdk.interactivity.comment.model.a> r33 = r31.y;
        if (r33 == null) goto L65;
        ArrayList r34 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r33, 10));
        Iterator<T> r35 = r33.iterator();
    L62:
        if (r35.hasNext() == false) goto L64;
        r34.add(Long.valueOf(((com.bytedance.android.livesdk.interactivity.comment.model.a) r35.next()).a()));
        goto L62
    L64:
        r1.put("interest_kp_id", CollectionsKt.joinToString$default(r34, "|", null, null, 0, null, null, 62, null));
        r1.put("interest_kp_text", CollectionsKt.joinToString$default(r33, "|", null, null, 0, null, LiveInputDialogV3$getSendMessageArgs$1$2.INSTANCE, 30, null));
    L65:
        g r36 = this.g;
        if (r36 == null) goto L86;
        com.bytedance.android.livesdk.interactivity.comment.newinput.c r37 = r36.V();
        if (r37 == null) goto L86;
        com.bytedance.android.livesdk.interactivity.comment.newinput.a r38 = r37.g;
        if (r38 == null) goto L86;
        com.bytedance.android.livesdk.interactivity.comment.model.c r39 = r38.z;
        if (r39 == null) goto L86;
        if (r39.b() <= 0) goto L86;
        String r40 = r39.a();
        if (r40 == null) goto L86;
        if (r40.length() <= 0) goto L80;
        boolean r41 = true;
    L81:
        if (r41 != true) goto L86;
        r1.put("truth_question_id", Long.valueOf(r39.b()));
        String r43 = r39.a();
        if (r43 != null) goto L85;
        r43 = BuildConfig.FLAVOR;
    L85:
        r1.put("truth_question_text", r43);
        goto L86
    L80:
        r41 = false;
    L86:
        g r44 = this.g;
        if (r44 == null) goto L89;
        long r45 = r44.v();
    L91:
        if (r45 <= 0) goto L96;
        long r46 = System.currentTimeMillis();
        g r47 = this.g;
        if (r47 == null) goto L95;
        r7 = r47.v();
    L95:
        r1.put("associate_show_send_duration", Long.valueOf(r46 - r7));
    L97:
        com.bytedance.android.livesdk.interactivity.comment.newinput.c r48 = this.d;
        if (r48 == null) goto L104;
        com.bytedance.android.livesdk.interactivity.comment.newinput.a r49 = r48.g;
        if (r49 == null) goto L104;
        u22.m.a r50 = r49.j;
        if (r50 == null) goto L104;
        r1.putAll(r50.h);
        r1.put("at_user_id", r50.d);
    L104:
        g r51 = this.g;
        if (r51 == null) goto L107;
        r1.put("input_comment_type", Integer.valueOf(r51.e));
    L107:
        com.bytedance.android.livesdk.interactivity.comment.newinput.c r53 = this.d;
        if (r53 == null) goto L114;
        com.bytedance.android.livesdk.interactivity.comment.newinput.a r54 = r53.g;
        if (r54 == null) goto L114;
        JsonObject r55 = r54.x;
        if (r55 == null) goto L114;
        r1.put("jsb_track_params", r55);
    L114:
        return r1;
    L96:
        r1.put("associate_show_send_duration", 0);
        goto L97
    L89:
        r45 = 0;
    L51:
        r28 = HintType.NORMAL.getTypeName();
    L38:
        r21 = false;
        goto L39
    L30:
        r16 = 0;
    L23:
        r11 = null;
    L12:
        r5 = false;
        goto L13
    }

    public final void onActivityCreated(Bundle r2) {
        super.onActivityCreated(r2);
        Dialog r3 = getDialog();
        if (r3 == null) goto L8;
        Window r4 = r3.getWindow();
        if (r4 == null) goto L8;
        r4.setLayout(-1, -1);
    L8:
        if (PadConfigUtils.c() == true) goto L10;
        return;
    L10:
        if (e5.g(getActivity()) == true) goto L18;
        Dialog r5 = getDialog();
        if (r5 == null) goto L19;
        Window r6 = r5.getWindow();
        if (r6 == null) goto L20;
        r6.clearFlags(1024);
        return;
    L20:
        return;
    L19:
        return;
    }

    public final void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r2);
        MeasureLinearLayout r3 = this.f;
        if (r3 != null) goto L5;
    L7:
        dismissInputDialog();
        return;
    L5:
        if (f1.a().booleanValue() == false) goto L7;
        r3.b++;
        goto L7
    }

    public final void onCreate(Bundle r3) {
        setStyle(1, 2131954667);
        super.onCreate(r3);
        setCancelable(true);
        this.n = System.currentTimeMillis();
    }

    public final Dialog onCreateDialog(Bundle r7) {
        Dialog r8 = super.onCreateDialog(r7);
        boolean r0 = false;
        r8.setCanceledOnTouchOutside(false);
        r8.setOnKeyListener(new b(this));
        FragmentActivity r1 = getActivity();
        if (r1 != null) goto L5;
        return r8;
    L5:
        Window r2 = r8.getWindow();
        if (r2 == null) goto L23;
        r2.setGravity(80);
        r2.setLayout(-1, -2);
        r2.setBackgroundDrawable(new ColorDrawable(0));
        r2.setSoftInputMode(19);
        boolean r3 = e5.j(r1);
        if (PadConfigUtils.c() == false) goto L11;
        r3 = e5.f(r1.getRequestedOrientation());
    L11:
        if (r1.getRequestedOrientation() != 1) goto L14;
        r0 = true;
    L14:
        if (PadConfigUtils.c() == false) goto L16;
        r0 = !e5.f(r1.getRequestedOrientation());
    L16:
        if (r3 == false) goto L18;
    L21:
        r2.addFlags(1024);
    L22:
        r2.clearFlags(2);
        goto L23
    L18:
        if (X90() == true) goto L22;
        if (DigHoleScreenUtil.isNeedStatusBarAdapt(r1, r0, X90()) == true) goto L22;
    L23:
        return r8;
    }

    public void onDismiss(DialogInterface r2) {
        T90(r2);     // Catch: Throwable -> L5
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L5:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public final void onSaveInstanceState(Bundle r2) {
        Intrinsics.checkNotNullParameter(r2, "outState");
        super.onSaveInstanceState(r2);
        this.m = this.l;
    }

    public void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r2, r3);
        Iterator r4 = ((ArrayList) this.i).iterator();
    L4:
        if (r4.hasNext() == false) goto L9;
        Iterator<Map.Entry<InputSectionType, k<?, ?>>> r5 = ((InputPanelSectionContainer) r4.next()).getSectionProviders().entrySet().iterator();
    L7:
        if (r5.hasNext() == false) goto L4;
        r5.next().getValue().f();
        goto L7
    }

    public final void show(FragmentManager r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "manager");
        com.bytedance.android.livesdk.f.d().c = true;
        com.bytedance.android.livesdk.f.d().a();
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, r4, r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, this, r0) == false) goto L10;
    L7:
        b0.o().getClass();
        com.bytedance.android.live.core.log.g.i("ttlive_msg", "input dialog v3 show");
        return;
    L10:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L6:
        super.show(r3, r4);
        goto L7
    }

    public final void showNow(FragmentManager r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "manager");
        com.bytedance.android.livesdk.f.d().c = true;
        com.bytedance.android.livesdk.f.d().a();
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_NOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, r4, r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, this, r0) == false) goto L10;
    L7:
        b0.o().getClass();
        com.bytedance.android.live.core.log.g.i("ttlive_msg", "input dialog V3 showNow");
        return;
    L10:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L6:
        super.showNow(r3, r4);
        goto L7
    }

    public final void Z90(long r10, int r13, int r14) {
        g r0 = this.g;
        if (r0 == null) goto L5;
        EditText r1 = r0.a;
    L6:
        if (r1 == null) goto L14;
        if (r13 > r14) goto L17;
        if (r0 == null) goto L15;
        EditText r2 = r0.a;
        if (r2 == null) goto L16;
        r2.postDelayed(new c(r2, this, r10, r13, r14), r10);
        return;
    L16:
        return;
    L15:
        return;
    L17:
        return;
    L14:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = LayoutInflater.from(getContext()).inflate(getLayoutId(), r3, false);
        if ((r5 instanceof MeasureLinearLayout) == true) goto L5;
        r5 = null;
    L5:
        MeasureLinearLayout r6 = (MeasureLinearLayout) r5;
        this.f = r6;
        if (r6 != null) goto L9;
        ALogger.e("InputPanelV3", "inflate root view error");
        return null;
    L9:
        U90(r6);
        W90(r6);
        return this.f;
    }

    public final void S90(String r11, boolean r13, int r14, boolean r15, HashMap<String, Object> r16, com.bytedance.android.livesdk.event.m r17, q r18) {
        CommentFlowContext r1 = this.h;
        if (r1 != null) goto L5;
        boolean r2 = false;
    L22:
        if (r2 == false) goto L25;
        com.bytedance.android.livesdk.interactivity.api.monitor.b.e("comment", "comment flow intercept", null);
        return;
    L25:
        x22.e r3 = this.e;
        if (r3 == null) goto L29;
        ((CommentWidget.e) r3).a(r11, r13, r14, r15, r16, r17, r18);
        return;
    L29:
        return;
    L5:
        if (r17 == null) goto L10;
        List r4 = r17.a;
        if (r4 == null) goto L10;
        if ((!r4.isEmpty()) != true) goto L10;
    L15:
        CommentContentType r5 = CommentContentType.RichText;
    L17:
        if (r13 == false) goto L19;
        CommentBusinessType r6 = CommentBusinessType.Danmu;
    L20:
        y22.f r7 = new y22.f();
        r7.a = r11;
        r7.b = r16;
        r7.c = r18;
        Intrinsics.checkNotNullParameter(r5, "contentType");
        Intrinsics.checkNotNullParameter(r6, "businessType");
        Intrinsics.checkNotNullParameter(r7, "content");
        r1.a = CommentFlowContext.State.Send;
        r1.e = r5;
        r1.f = r6;
        r1.g = r7;
        r2 = r1.a();
        goto L22
    L19:
        r6 = CommentBusinessType.Normal;
    L10:
        if (r18 == null) goto L16;
        List r8 = r18.a;
        if (r8 == null) goto L16;
        if ((!r8.isEmpty()) == true) goto L15;
    L16:
        r5 = CommentContentType.Text;
        goto L17
    }
}
