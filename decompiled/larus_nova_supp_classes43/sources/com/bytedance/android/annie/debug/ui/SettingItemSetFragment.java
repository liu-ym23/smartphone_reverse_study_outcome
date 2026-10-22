package com.bytedance.android.annie.debug.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.bytedance.android.annie.Annie;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import y9.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/annie/debug/ui/SettingItemSetFragment;", "Lcom/bytedance/android/annie/debug/ui/BaseCommonDialogFragment;", "<init>", "()V", "annie-debug_release"}, k = 1, mv = {1, 4, 3})
public final class SettingItemSetFragment extends BaseCommonDialogFragment {
    public y9.i<Object> e;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ View a;
        public final /* synthetic */ SettingItemSetFragment b;
        public final /* synthetic */ TextView c;
        public final /* synthetic */ EditText d;

        public a(View r1, SettingItemSetFragment r10, TextView r11, EditText r12) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
            this.d = r12;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            o r11 = (o) Annie.getService$default(o.class, null, 2, null);
            Context r0 = this.a.getContext();
            y9.i<Object> r1 = this.b.e;
            Intrinsics.checkNotNull(r1);
            String r12 = r1.a;
            y9.i<Object> r13 = this.b.e;
            Intrinsics.checkNotNull(r13);
            if (Intrinsics.areEqual(r13.getType(), Boolean.class) == false) goto L5;
            String r14 = this.c.getText().toString();
        L6:
            y9.i<Object> r15 = this.b.e;
            Intrinsics.checkNotNull(r15);
            r11.D0(r0, r12, r14, r15.getType());
            this.b.dismissAllowingStateLoss();     // Catch: Exception -> L9
            return;
        L9:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r16 = DialogFragmentLancet.sLastShowStack;
            if (r16 == null) goto L16;
            com.bytedance.crash.d.d(r16, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        L16:
            return;
        L5:
            r14 = this.d.getText().toString();
            goto L6
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ TextView a;

        public b(TextView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            TextView r11 = this.a;
            r11.setText(String.valueOf(!Boolean.parseBoolean(r11.getText().toString())));
        }
    }

    public SettingItemSetFragment() {
    }

    public final View onCreateView(LayoutInflater r10, ViewGroup r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r10, "inflater");
        View r13 = r10.inflate(2131558550, r11, false);
        y9.i<Object> r14 = this.e;
        if (r14 == null) goto L8;
        TextView r15 = (TextView) r13.findViewById(2131390836);
        EditText r1 = (EditText) r13.findViewById(2131390826);
        ((TextView) r13.findViewById(2131390829)).setText(r14.a);
        ((TextView) r13.findViewById(2131391529)).setOnClickListener(new a(r13, this, r15, r1));
        if (Intrinsics.areEqual(r14.getType(), Boolean.class) == false) goto L7;
        r15.setText(r14.a().toString());
        r15.setVisibility(0);
        r15.setOnClickListener(new b(r15));
        goto L8
    L7:
        r1.setVisibility(0);
        r1.setHint(r14.a().toString());
    L8:
        return r13;
    }
}
