package com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.SelfDisciplineContext;
import com.bytedance.android.livesdk.chatroom.model.interact.o1;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/videotalk/selfdiscipline/dialog/SelfDisciplineManagerDialogV2;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", "Lcom/bytedance/android/live/liveinteract/videotalk/selfdiscipline/dialog/SelfDisciplineDurationSelectDialog$a;", "Lcom/bytedance/android/live/liveinteract/videotalk/selfdiscipline/dialog/SelfDisciplineTargetAdapterV2$a;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SelfDisciplineManagerDialogV2 extends CommonBottomDialog implements SelfDisciplineDurationSelectDialog.a, SelfDisciplineTargetAdapterV2.a {
    public static final /* synthetic */ int o = 0;
    public final Lazy a;
    public final boolean b;
    public Button c;
    public ImageView d;
    public ImageView e;
    public ViewGroup f;
    public TextView g;
    public TextView h;
    public RecyclerView i;
    public TextView j;
    public TextView k;
    public String l;
    public long m;
    public final List<String> n;

    public final int getLayoutId() {
        return 2131565547;
    }

    public SelfDisciplineManagerDialogV2(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        this.a = LazyKt.lazy(new SelfDisciplineManagerDialogV2$mCloseDialog$2(this));
        this.b = SelfDisciplineContext.Companion.e();
        com.bytedance.android.livesdk.sharedpref.e r4 = b6.P;
        String r0 = ((o1) r4.getValue()).getCurrentTarget();
        if (r0 != null) goto L5;
        r0 = "备考自习";
    L5:
        this.l = r0;
        this.m = ((o1) r4.getValue()).getPunchDuration();
        List r5 = ((o1) r4.getValue()).getTargetList();
        if (r5 == null) goto L8;
        List<String> r6 = CollectionsKt.toMutableList(r5);
    L9:
        this.n = r6;
        return;
    L8:
        r6 = null;
        goto L9
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.dialog.SelfDisciplineTargetAdapterV2.a
    public final void k0(String r8) {
        Intrinsics.checkNotNullParameter(r8, "target");
        this.l = r8;
        boolean r0 = true;
        if (this.b == false) goto L13;
        Button r9 = this.c;
        if (r9 == null) goto L18;
        com.bytedance.android.livesdk.sharedpref.e r1 = b6.P;
        if (((o1) r1.getValue()).getPunchDuration() == this.m) goto L9;
    L12:
        r9.setSelected(r0);
        return;
    L9:
        if ((!Intrinsics.areEqual(((o1) r1.getValue()).getCurrentTarget(), this.l)) == true) goto L12;
        r0 = false;
        goto L12
    L18:
        return;
    L13:
        Button r10 = this.c;
        if (r10 == null) goto L16;
        r10.setSelected(true);
    L16:
        ((o1) b6.P.getValue()).setCurrentTarget(this.l);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r6) {
        super.onCreate(r6);
        this.f = (ViewGroup) findViewById(2131385874);
        this.g = (TextView) findViewById(2131391385);
        this.h = (TextView) findViewById(2131391387);
        this.d = (ImageView) findViewById(2131376107);
        this.e = (ImageView) findViewById(2131376288);
        this.j = (TextView) findViewById(2131391606);
        this.k = (TextView) findViewById(2131391524);
        this.c = (Button) findViewById(2131364780);
        this.i = findViewById(2131385878);
        List<String> r7 = this.n;
        if (r7 != null) goto L5;
    L7:
        SelfDisciplineTargetAdapterV2 r8 = new SelfDisciplineTargetAdapterV2(getContext(), this.n, this.l, this);
        RecyclerView r2 = this.i;
        if (r2 == null) goto L10;
        r2.setAdapter(r8);
    L10:
        RecyclerView r9 = this.i;
        if (r9 == null) goto L13;
        r9.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
    L13:
        ViewGroup r10 = this.f;
        if (r10 == null) goto L16;
        r10.setOnClickListener(new g(this));
    L16:
        TextView r11 = this.g;
        if (r11 == null) goto L19;
        r11.setText(a.a((int) this.m));
    L19:
        ImageView r12 = this.e;
        int r3 = 4;
        if (r12 != null) goto L22;
    L26:
        ImageView r13 = this.e;
        if (r13 == null) goto L29;
        r13.setOnClickListener(x0.a(new SelfDisciplineManagerDialogV2$initPanelHead$1(this)));
    L29:
        ImageView r14 = this.d;
        if (r14 != null) goto L32;
    L35:
        ImageView r15 = this.d;
        if (r15 == null) goto L38;
        r15.setOnClickListener(x0.a(new SelfDisciplineManagerDialogV2$initPanelHead$2(this)));
    L38:
        TextView r16 = this.j;
        if (r16 == null) goto L41;
        SelfDisciplineContext.Companion.getClass();
        r16.setText(SelfDisciplineContext.a.c());
    L41:
        TextView r17 = this.k;
        if (r17 == null) goto L48;
        SelfDisciplineContext.Companion.getClass();
        if (Intrinsics.areEqual(SelfDisciplineContext.a.c(), s1.B(2131922430)) == false) goto L46;
        String r4 = s1.B(2131922426);
    L47:
        r17.setText(r4);
        goto L48
    L46:
        r4 = s1.B(2131922427);
    L48:
        TextView r18 = this.h;
        if (r18 == null) goto L56;
        SelfDisciplineContext.Companion.getClass();
        if (Intrinsics.areEqual(SelfDisciplineContext.a.c(), s1.B(2131922430)) == false) goto L53;
        String r5 = s1.B(2131922439);
    L54:
        r18.setText(r5);
        goto L56
    L53:
        r5 = s1.B(2131922442);
    L56:
        if (this.b == false) goto L63;
        Button r19 = this.c;
        if (r19 == null) goto L60;
        r19.setSelected(false);
    L60:
        Button r20 = this.c;
        if (r20 == null) goto L69;
        r20.setText(2131922431);
    L69:
        Button r21 = this.c;
        if (r21 == null) goto L73;
        r21.setOnClickListener(x0.a(new SelfDisciplineManagerDialogV2$initView$2(this)));
        return;
    L73:
        return;
    L63:
        Button r22 = this.c;
        if (r22 == null) goto L66;
        r22.setSelected(!StringsKt.isBlank(this.l));
    L66:
        Button r23 = this.c;
        if (r23 == null) goto L69;
        r23.setText(2131922425);
        goto L69
    L32:
        if (this.b == false) goto L34;
        r3 = 0;
    L34:
        r14.setVisibility(r3);
        goto L35
    L22:
        if (this.b == false) goto L24;
        int r24 = 4;
    L25:
        r12.setVisibility(r24);
        goto L26
    L24:
        r24 = 0;
        goto L25
    L5:
        if (r7.contains(this.l) != true) goto L7;
        List<String> r25 = this.n;
        Intrinsics.checkNotNull(r25);
        r25.remove(this.l);
        List<String> r26 = this.n;
        Intrinsics.checkNotNull(r26);
        ListProtector.add(r26, 0, this.l);
        goto L7
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.dialog.SelfDisciplineDurationSelectDialog.a
    public final void q0(int r8) {
        this.m = r8;
        boolean r0 = true;
        if (this.b == false) goto L13;
        Button r9 = this.c;
        if (r9 == null) goto L17;
        com.bytedance.android.livesdk.sharedpref.e r1 = b6.P;
        if (((o1) r1.getValue()).getPunchDuration() == this.m) goto L9;
    L12:
        r9.setSelected(r0);
        goto L17
    L9:
        if ((!Intrinsics.areEqual(((o1) r1.getValue()).getCurrentTarget(), this.l)) == true) goto L12;
        r0 = false;
    L17:
        TextView r10 = this.g;
        if (r10 == null) goto L21;
        r10.setText(a.a((int) this.m));
        return;
    L21:
        return;
    L13:
        Button r11 = this.c;
        if (r11 == null) goto L16;
        r11.setSelected(true);
    L16:
        ((o1) b6.P.getValue()).setPunchDuration(this.m);
        goto L17
    }
}
