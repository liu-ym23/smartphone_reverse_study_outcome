package com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.dialog;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.SelfDisciplineContext;
import com.bytedance.android.livesdk.chatroom.model.interact.o1;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.bytedance.live.datacontext.m;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import zg1.g1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/videotalk/selfdiscipline/dialog/SelfDisciplineManageDialog;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SelfDisciplineManageDialog extends CommonBottomDialog {
    public static final /* synthetic */ int e = 0;
    public final CompositeDisposable a;
    public final Lazy b;
    public final boolean c;
    public final Lazy d;

    public final int getLayoutId() {
        return 2131565556;
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.a.dispose();
    }

    public SelfDisciplineManageDialog(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.a = new CompositeDisposable();
        this.b = LazyKt.lazy(new SelfDisciplineManageDialog$mCloseDialog$2(this));
        this.c = SelfDisciplineContext.Companion.e();
        this.d = LazyKt.lazy(new SelfDisciplineManageDialog$mSelectTargetCallback$2(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r7) {
        super.onCreate(r7);
        TextView r8 = (TextView) findViewById(2131391606);
        SelfDisciplineContext.a r0 = SelfDisciplineContext.Companion;
        r0.getClass();
        r8.setText(SelfDisciplineContext.a.c());
        ImageView r1 = (ImageView) findViewById(2131376288);
        int r3 = 4;
        if (this.c == false) goto L5;
        int r2 = 4;
    L6:
        r1.setVisibility(r2);
        ImageView r9 = (ImageView) findViewById(2131376288);
        if (r9 == null) goto L9;
        r9.setOnClickListener(x0.a(new SelfDisciplineManageDialog$initTitleRightRegion$1(this)));
    L9:
        ImageView r4 = (ImageView) findViewById(2131376107);
        if (this.c == false) goto L12;
        r3 = 0;
    L12:
        r4.setVisibility(r3);
        ImageView r10 = (ImageView) findViewById(2131376107);
        if (r10 == null) goto L15;
        r10.setOnClickListener(x0.a(new SelfDisciplineManageDialog$initTitleRightRegion$2(this)));
    L15:
        TextView r5 = (TextView) findViewById(2131391386);
        if (r5 == null) goto L18;
        r5.setText(((o1) b6.P.getValue()).getCurrentTarget());
    L18:
        LinearLayout r6 = (LinearLayout) findViewById(2131385877);
        if (r6 == null) goto L21;
        r6.setOnClickListener(x0.a(new SelfDisciplineManageDialog$initSettingRegion$1(this)));
    L21:
        r0.getClass();
        if (Intrinsics.areEqual(SelfDisciplineContext.a.c(), s1.B(2131922430)) == false) goto L24;
        ((TextView) findViewById(2131391387)).setText(getContext().getResources().getString(2131922428));
        ((TextView) findViewById(2131391524)).setText(getContext().getResources().getString(2131922426));
    L25:
        LinearLayout r11 = (LinearLayout) findViewById(2131384787);
        if (r11 == null) goto L29;
        r11.setOnClickListener(x0.a(new SelfDisciplineManageDialog$initSettingRegion$2(this)));
    L29:
        if (this.c == false) goto L34;
        Button r12 = (Button) findViewById(2131364780);
        if (r12 == null) goto L33;
        r12.setSelected(false);
    L33:
        ((Button) findViewById(2131364780)).setText(2131922431);
    L42:
        Button r13 = (Button) findViewById(2131364780);
        if (r13 == null) goto L45;
        r13.setOnClickListener(x0.a(new SelfDisciplineManageDialog$initOperationBtn$1(this)));
    L45:
        SelfDisciplineContext r14 = r0.getContext();
        if (r14 == null) goto L54;
        m<Integer> r15 = r14.getStatus();
        if (r15 == null) goto L54;
        Observable r16 = r15.a();
        if (r16 == null) goto L54;
        Disposable r17 = RxUtilKt.n(r16, new SelfDisciplineManageDialog$init$1(this));
        if (r17 == null) goto L54;
        this.a.add(r17);
    L54:
        Disposable r18 = xs2.b.a().b(g1.class).subscribe(new d(this));
        if (r18 == null) goto L58;
        this.a.add(r18);
        return;
    L58:
        return;
    L34:
        Button r19 = (Button) findViewById(2131364780);
        if (r19 == null) goto L41;
        TextView r20 = (TextView) findViewById(2131391386);
        if (r20 == null) goto L39;
        CharSequence r21 = r20.getText();
    L40:
        r19.setSelected(!StringsKt.isBlank(r21.toString()));
        goto L41
    L39:
        r21 = null;
    L41:
        ((Button) findViewById(2131364780)).setText(2131922425);
        goto L42
    L24:
        ((TextView) findViewById(2131391387)).setText(getContext().getResources().getString(2131922429));
        ((TextView) findViewById(2131391524)).setText(getContext().getResources().getString(2131922427));
        goto L25
    L5:
        r2 = 0;
        goto L6
    }
}
