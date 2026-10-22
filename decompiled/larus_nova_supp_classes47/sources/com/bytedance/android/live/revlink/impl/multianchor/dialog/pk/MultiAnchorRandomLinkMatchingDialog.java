package com.bytedance.android.live.revlink.impl.multianchor.dialog.pk;

import android.app.Dialog;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revlink.impl.multianchor.match.MultiPkMatchContext;
import com.bytedance.android.live.revlink.impl.pk.ui.LinkCommonDialogFragment;
import com.bytedance.android.livesdk.link.model.b0;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/pk/MultiAnchorRandomLinkMatchingDialog;", "Lcom/bytedance/android/live/revlink/impl/pk/ui/LinkCommonDialogFragment;", "<init>", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiAnchorRandomLinkMatchingDialog extends LinkCommonDialogFragment {
    public static final /* synthetic */ int h = 0;
    public Map<Integer, View> e;
    public final CompositeDisposable f;
    public long g;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ MultiAnchorRandomLinkMatchingDialog a;

        public a(MultiAnchorRandomLinkMatchingDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.dismiss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r3 = DialogFragmentLancet.sLastShowStack;
            if (r3 == null) goto L12;
            com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ MultiAnchorRandomLinkMatchingDialog a;

        public b(MultiAnchorRandomLinkMatchingDialog r1) {
            this.a = r1;
        }

        public final void accept(Object r12) {
            MultiAnchorRandomLinkMatchingDialog r0 = this.a;
            long r1 = ((Long) r12).longValue();
            r0.g = r1;
            StringCompanionObject r13 = StringCompanionObject.INSTANCE;
            long r5 = 60;
            ((TextView) r0.S90(2131391711)).setText(String.format(Locale.CHINA, "%01d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(r1 / r5), Long.valueOf(r0.g % r5)}, 2)));
            ((TextView) r0.S90(2131391711)).setVisibility(0);
            long r3 = r0.g;
            b0 r14 = r0.T90();
            if (r14 == null) goto L5;
            long r7 = r14.getWaitSec();
        L7:
            if (r3 < r7) goto L9;
        L11:
            ((TextView) r0.S90(2131391709)).setVisibility(4);
            ((TextView) r0.S90(2131391711)).setText(s1.B(2131921501));
            ((TextView) r0.S90(2131363607)).setText(s1.B(2131920577));
            ((LinearLayout) r0.S90(2131378886)).setVisibility(0);
        L13:
            if (r0.g <= 0) goto L15;
            r0.updateTitle();
        L20:
            if (r0.U90().b != 11) goto L23;
            ((TextView) r0.S90(2131365128)).setText(s1.B(2131920575));
            return;
        L23:
            return;
        L15:
            if (r0.U90().b != 9) goto L17;
            ((TextView) r0.S90(2131388772)).setText(s1.B(2131920582));
            goto L20
        L17:
            r0.updateTitle();
            goto L20
        L9:
            if (r0.g <= 0) goto L11;
            ((TextView) r0.S90(2131363607)).setText(s1.B(2131920576));
            ((LinearLayout) r0.S90(2131378886)).setVisibility(0);
            goto L13
        L5:
            r7 = 0;
            goto L7
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ MultiAnchorRandomLinkMatchingDialog a;

        public c(MultiAnchorRandomLinkMatchingDialog r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            com.bytedance.android.live.revlink.impl.multianchor.match.c r3 = (com.bytedance.android.live.revlink.impl.multianchor.match.c) r2;
            r3.getClass();
            if ((r3 instanceof com.bytedance.android.live.revlink.impl.multianchor.match.c.C0146c) == true) goto L14;
            if (com.bytedance.android.live.revlink.impl.multianchor.match.b.a(com.bytedance.android.live.revlink.impl.global.b.I()) == true) goto L14;
            return;
        L14:
            this.a.dismiss();     // Catch: Exception -> L9
            return;
        L9:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r4 = DialogFragmentLancet.sLastShowStack;
            if (r4 == null) goto L17;
            com.bytedance.crash.d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public MultiAnchorRandomLinkMatchingDialog() {
        this.e = new LinkedHashMap();
        this.f = new CompositeDisposable();
    }

    public final b0 T90() {
        if ((U90() instanceof com.bytedance.android.live.revlink.impl.multianchor.match.c.d) == false) goto L9;
        MultiPkMatchContext r0 = com.bytedance.android.live.revlink.impl.global.b.G();
        if (r0 == null) goto L15;
        com.bytedance.live.datacontext.n<b0> r1 = r0.getPassiveAutoMatchInfo();
        if (r1 != null) goto L17;
        return null;
    L17:
        return (b0) r1.getValue();
    L15:
        return null;
    L9:
        MultiPkMatchContext r2 = com.bytedance.android.live.revlink.impl.global.b.G();
        if (r2 == null) goto L18;
        com.bytedance.live.datacontext.n<b0> r3 = r2.getSelfAutoMatchInfo();
        if (r3 != null) goto L14;
        return null;
    L14:
        return (b0) r3.getValue();
    L18:
        return null;
    }

    public final com.bytedance.android.live.revlink.impl.multianchor.match.c U90() {
        MultiPkMatchContext r0 = com.bytedance.android.live.revlink.impl.global.b.G();
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.m<com.bytedance.android.live.revlink.impl.multianchor.match.c> r1 = r0.getMatchStatus();
        if (r1 == null) goto L9;
        com.bytedance.android.live.revlink.impl.multianchor.match.c r2 = (com.bytedance.android.live.revlink.impl.multianchor.match.c) r1.getValue();
        if (r2 == null) goto L9;
        return r2;
    L9:
        return new com.bytedance.android.live.revlink.impl.multianchor.match.c.C0146c();
    }

    public final void onDestroyView() {
        super.onDestroyView();
        ((LinkedHashMap) this.e).clear();
    }

    public final void onDetach() {
        super/*androidx.fragment.app.DialogFragment*/.onDetach();
        CompositeDisposable r0 = this.f;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    public final void updateTitle() {
        if (U90().b != 9) goto L5;
        ((TextView) S90(2131388772)).setText(s1.B(2131920581));
        return;
    L5:
        Long r7 = null;
        if (U90().b != 10) goto L12;
        StringCompanionObject r1 = StringCompanionObject.INSTANCE;
        String r2 = s1.B(2131920579);
        Object[] r10 = new Object[1];
        b0 r12 = T90();
        if (r12 == null) goto L10;
        r7 = Long.valueOf(r12.getWaitSec());
    L10:
        r10[0] = r7;
        SpannableStringBuilder r0 = new SpannableStringBuilder(String.format(r2, Arrays.copyOf(r10, 1)));
        r0.setSpan(new ForegroundColorSpan(ColorProtector.parseColor("#FE2C55")), 4, 6, 17);
        ((TextView) S90(2131388772)).setText(r0);
        return;
    L12:
        if (U90().b != 11) goto L17;
        StringCompanionObject r3 = StringCompanionObject.INSTANCE;
        String r4 = s1.B(2131920580);
        Object[] r13 = new Object[1];
        b0 r14 = T90();
        if (r14 == null) goto L16;
        r7 = Long.valueOf(r14.getWaitSec());
    L16:
        r13[0] = r7;
        SpannableStringBuilder r5 = new SpannableStringBuilder(String.format(r4, Arrays.copyOf(r13, 1)));
        r5.setSpan(new ForegroundColorSpan(ColorProtector.parseColor("#FE2C55")), 4, 6, 17);
        ((TextView) S90(2131388772)).setText(r5);
        return;
    L17:
        ((TextView) S90(2131388772)).setText(s1.B(2131920579) + ":");
    }

    public final View S90(int r3) {
        if (this.e != null) goto L5;
        this.e = new LinkedHashMap();
    L5:
        View r0 = this.e.get(Integer.valueOf(r3));
        if (r0 != null) goto L14;
        View r1 = getView();
        if (r1 == null) goto L12;
        View r2 = r1.findViewById(r3);
        if (r2 == null) goto L12;
        this.e.put(Integer.valueOf(r3), r2);
        return r2;
    L12:
        return null;
    L14:
        return r0;
    }

    public final Dialog onCreateDialog(Bundle r2) {
        Dialog r3 = super.onCreateDialog(r2);
        if (r3 == null) goto L5;
        r3.setCanceledOnTouchOutside(true);
    L5:
        return r3;
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        ((TextView) S90(2131365128)).setOnClickListener(x0.a(new AnonymousClass1(this)));
        S90(2131381758).setOnClickListener(new a(this));
        MultiPkMatchContext r4 = com.bytedance.android.live.revlink.impl.global.b.G();
        if (r4 == null) goto L11;
        com.bytedance.live.datacontext.m<Long> r5 = r4.getCountDownTime();
        if (r5 == null) goto L11;
        Observable r6 = r5.a();
        if (r6 == null) goto L11;
        Disposable r7 = r6.subscribe(new b(this));
        if (r7 == null) goto L11;
        this.f.add(r7);
    L11:
        MultiPkMatchContext r8 = com.bytedance.android.live.revlink.impl.global.b.G();
        if (r8 == null) goto L21;
        com.bytedance.live.datacontext.m<com.bytedance.android.live.revlink.impl.multianchor.match.c> r9 = r8.getMatchStatus();
        if (r9 == null) goto L22;
        Observable r10 = r9.a();
        if (r10 == null) goto L23;
        Disposable r12 = r10.subscribe(new c(this));
        if (r12 == null) goto L24;
        this.f.add(r12);
        return;
    L24:
        return;
    L23:
        return;
    L22:
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131565657, r3, false);
    }
}
