package com.bytedance.android.live.openplatform.impl.miniappanchor.explaincardsetting;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialogFragment;
import com.bytedance.android.live.core.utils.s1;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/explaincardsetting/ExplainCardCoverActionSheetDialog;", "Landroidx/appcompat/app/AppCompatDialogFragment;", "<init>", "()V", "a", "Config", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ExplainCardCoverActionSheetDialog extends AppCompatDialogFragment {
    public Map<Integer, View> d;
    public final Lazy e;
    public final Lazy f;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/explaincardsetting/ExplainCardCoverActionSheetDialog$Config;", "Landroid/os/Parcelable;", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Config implements Parcelable {
        public static final Parcelable.Creator<Config> CREATOR = null;
        public final String a;
        public final boolean b;
        public final boolean c;

        public static class a implements Parcelable.Creator<Config> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final Config createFromParcel(Parcel r6) {
                Intrinsics.checkNotNullParameter(r6, "in");
                String r1 = r6.readString();
                boolean r3 = false;
                if (r6.readInt() == 0) goto L5;
                boolean r2 = true;
            L7:
                if (r6.readInt() == 0) goto L10;
                r3 = true;
            L10:
                return new Config(r1, r2, r3);
            L5:
                r2 = false;
                goto L7
            }

            @Override // android.os.Parcelable.Creator
            public final Config[] newArray(int r1) {
                return new Config[r1];
            }
        }

        static {
            CREATOR = new a();
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof Config) == false) goto L12;
            Config r4 = (Config) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (this.b == r4.b) goto L10;
            return false;
        L10:
            if (this.c == r4.c) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3 */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r2v0 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v2 */
        public final int hashCode() {
            String r0 = this.a;
            if (r0 == null) goto L5;
            int r1 = r0.hashCode();
        L6:
            int r2 = r1 * 31;
            boolean r3 = this.b;
            ?? r4 = 1;
            ?? r5 = r3;
            if (r3 == false) goto L9;
            r5 = 1;
        L9:
            int r6 = (r2 + r5) * 31;
            boolean r7 = this.c;
            if (r7 == true) goto L14;
            r4 = r7;
        L14:
            return r6 + r4;
        L5:
            r1 = 0;
            goto L6
        }

        public final String toString() {
            return "Config(textPosterTitle=" + this.a + ", showPresetCardAction=" + this.b + ", showScreenshotAction=" + this.c + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            r1.writeString(this.a);
            r1.writeInt(this.b ? 1 : 0);
            r1.writeInt(this.c ? 1 : 0);
        }

        public Config(String r2, boolean r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r2, "textPosterTitle");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ ExplainCardCoverActionSheetDialog a;

        public b(ExplainCardCoverActionSheetDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            ExplainCardSettingViewModel r3 = (ExplainCardSettingViewModel) this.a.e.getValue();
            if (r3 == null) goto L13;
            r3.changeCover(4);
        L13:
            this.a.dismiss();     // Catch: Exception -> L8
            return;
        L8:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r4 = DialogFragmentLancet.sLastShowStack;
            if (r4 == null) goto L15;
            com.bytedance.crash.d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ ExplainCardCoverActionSheetDialog a;

        public c(ExplainCardCoverActionSheetDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            ExplainCardSettingViewModel r3 = (ExplainCardSettingViewModel) this.a.e.getValue();
            if (r3 == null) goto L13;
            r3.changeCover(2);
        L13:
            this.a.dismiss();     // Catch: Exception -> L8
            return;
        L8:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r4 = DialogFragmentLancet.sLastShowStack;
            if (r4 == null) goto L15;
            com.bytedance.crash.d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ ExplainCardCoverActionSheetDialog a;

        public d(ExplainCardCoverActionSheetDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            ExplainCardSettingViewModel r3 = (ExplainCardSettingViewModel) this.a.e.getValue();
            if (r3 == null) goto L13;
            r3.changeCover(1);
        L13:
            this.a.dismiss();     // Catch: Exception -> L8
            return;
        L8:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r4 = DialogFragmentLancet.sLastShowStack;
            if (r4 == null) goto L15;
            com.bytedance.crash.d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ ExplainCardCoverActionSheetDialog a;

        public e(ExplainCardCoverActionSheetDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            ExplainCardSettingViewModel r3 = (ExplainCardSettingViewModel) this.a.e.getValue();
            if (r3 == null) goto L13;
            r3.changeCover(3);
        L13:
            this.a.dismiss();     // Catch: Exception -> L8
            return;
        L8:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r4 = DialogFragmentLancet.sLastShowStack;
            if (r4 == null) goto L15;
            com.bytedance.crash.d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class f implements View.OnClickListener {
        public final /* synthetic */ ExplainCardCoverActionSheetDialog a;

        public f(ExplainCardCoverActionSheetDialog r1) {
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

    static {
    }

    public ExplainCardCoverActionSheetDialog() {
        this.d = new LinkedHashMap();
        this.e = LazyKt.lazy(new ExplainCardCoverActionSheetDialog$viewModel$2(this));
        this.f = LazyKt.lazy(new ExplainCardCoverActionSheetDialog$config$2(this));
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.DialogFragment*/.onDestroyView();
        this.d.clear();
    }

    public final View S90(int r3) {
        if (this.d != null) goto L5;
        this.d = new LinkedHashMap();
    L5:
        View r0 = this.d.get(Integer.valueOf(r3));
        if (r0 != null) goto L14;
        View r1 = getView();
        if (r1 == null) goto L12;
        View r2 = r1.findViewById(r3);
        if (r2 == null) goto L12;
        this.d.put(Integer.valueOf(r3), r2);
        return r2;
    L12:
        return null;
    L14:
        return r0;
    }

    public final void onActivityCreated(Bundle r3) {
        super/*androidx.fragment.app.DialogFragment*/.onActivityCreated(r3);
        Dialog r4 = getDialog();
        if (r4 == null) goto L8;
        Window r5 = r4.getWindow();
        if (r5 == null) goto L9;
        r5.setGravity(80);
        r5.setLayout(-1, -2);
        r5.setBackgroundDrawable(new ColorDrawable(0));
        r5.getAttributes().windowAnimations = 2131954752;
        return;
    L9:
        return;
    }

    public final Dialog onCreateDialog(Bundle r2) {
        Dialog r3 = super.onCreateDialog(r2);
        r3.requestWindowFeature(1);
        r3.setCanceledOnTouchOutside(true);
        return r3;
    }

    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r4, r5);
        ((TextView) S90(2131368137)).setOnClickListener(new b(this));
        TextView r6 = (TextView) S90(2131368141);
        Object[] r0 = new Object[1];
        Config r1 = (Config) this.f.getValue();
        if (r1 == null) goto L6;
        String r2 = r1.a;
        if (r2 == null) goto L6;
    L7:
        r0[0] = r2;
        r6.setText(s1.C(2131920921, r0));
        ((LinearLayout) S90(2131368142)).setOnClickListener(new c(this));
        Config r7 = (Config) this.f.getValue();
        if (r7 != null) goto L10;
    L12:
        ((TextView) S90(2131368139)).setVisibility(8);
    L13:
        Config r8 = (Config) this.f.getValue();
        if (r8 != null) goto L16;
    L18:
        ((TextView) S90(2131368140)).setVisibility(8);
    L19:
        ((TextView) S90(2131368138)).setOnClickListener(new f(this));
        return;
    L16:
        if (r8.c != true) goto L18;
        ((TextView) S90(2131368140)).setVisibility(0);
        ((TextView) S90(2131368140)).setOnClickListener(new e(this));
        goto L19
    L10:
        if (r7.b != true) goto L12;
        ((TextView) S90(2131368139)).setVisibility(0);
        ((TextView) S90(2131368139)).setOnClickListener(new d(this));
    L6:
        r2 = "";
        goto L7
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131566949, r3, false);
    }
}
