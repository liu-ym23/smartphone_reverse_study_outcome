package com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.dialog;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.liveinteract.revenue.common.view.ScrollToTopSnapHelper;
import com.bytedance.android.live.liveinteract.revenue.fight.dialog.SelectDurationDecoration;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/liveinteract/videotalk/selfdiscipline/dialog/SelfDisciplineDurationSelectDialog;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SelfDisciplineDurationSelectDialog extends CommonBottomDialog {
    public TextView a;
    public TextView b;
    public RecyclerView c;
    public final a d;
    public int e;

    public interface a {
        void q0(int r1);
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ SelfDisciplineDurationSelectDialog a;

        public b(SelfDisciplineDurationSelectDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            CommonBottomDialog r5 = this.a;
            Handler r0 = DialogLancet.resolveDialogHandler(r5);
            if (r0 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r5);
            r5.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r5);
            return;
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r5);
            throw th;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r1 == null) goto L16;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r0.getLooper()) goto L7;
            r0.post(DialogLancet.createDismissRunnable(r5));
        }
    }

    public final int getLayoutId() {
        return 2131565554;
    }

    public static List M0() {
        ArrayList r0 = new ArrayList();
        r0.add(60);
        int r2 = 1;
    L4:
        if (r2 > 24) goto L6;
        r0.add(Integer.valueOf((r2 * 5) * 60));
        r2 = r2 + 1;
        goto L4
    L6:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r5) {
        super.onCreate(r5);
        this.a = (TextView) findViewById(2131367647);
        this.b = (TextView) findViewById(2131365123);
        this.c = findViewById(2131388670);
        final LinearLayoutManager r6 = new LinearLayoutManager(getContext());
        RecyclerView r0 = this.c;
        if (r0 == null) goto L5;
        r0.setLayoutManager(r6);
    L5:
        RecyclerView r1 = this.c;
        if (r1 == null) goto L8;
        r1.setAdapter(new SelfDisciplineDurationAdapter(M0(), this.e));
    L8:
        RecyclerView r2 = this.c;
        if (r2 == null) goto L11;
        r2.addItemDecoration(new SelectDurationDecoration());
    L11:
        new ScrollToTopSnapHelper().attachToRecyclerView(this.c);
        RecyclerView r3 = this.c;
        if (r3 == null) goto L14;
        r3.addOnScrollListener(new AnonymousClass1(this, r6));
    L14:
        List r7 = M0();
        ArrayList r8 = (ArrayList) r7;
        int r9 = r8.indexOf(Integer.valueOf(this.e));
        RecyclerView r4 = this.c;
        if (r4 != null) goto L17;
    L20:
        TextView r10 = this.a;
        if (r10 == null) goto L23;
        r10.setOnClickListener(x0.a(new AnonymousClass2(this)));
    L23:
        TextView r11 = this.b;
        if (r11 == null) goto L27;
        r11.setOnClickListener(new b(this));
        return;
    L27:
        return;
    L17:
        if (r9 != (-1)) goto L19;
        r9 = 1;
    L19:
        r4.scrollToPosition(r9);
        goto L20
    }

    public SelfDisciplineDurationSelectDialog(Context r2, SelfDisciplineManagerDialogV2 r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "callback");
        super(r2);
        this.d = r3;
        this.e = r4;
    }
}
