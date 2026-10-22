package com.bytedance.android.live.openplatform.impl.miniappanchor.explaincardsetting;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.core.content.ContextCompat;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.openplatform.impl.base.OpenPlatformAnchorServiceImpl;
import com.bytedance.android.live.openplatform.impl.base.utils.LiveOpenPlatformClient;
import com.bytedance.android.live.openplatform.impl.miniappanchor.api.MiniAppExplainCardApi;
import com.bytedance.android.livesdk.utils.r2;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u0005\u0006B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/explaincardsetting/ExplainCardTitleEditorDialog;", "Landroidx/appcompat/app/AppCompatDialogFragment;", "", "<init>", "()V", "a", "b", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ExplainCardTitleEditorDialog extends AppCompatDialogFragment {
    public static final /* synthetic */ int k = 0;
    public Map<Integer, View> d;
    public final Lazy e;
    public int f;
    public String g;
    public String h;
    public so0.a i;
    public final /* synthetic */ com.bytedance.android.live.openplatform.impl.base.utils.a j;

    public static final class a {
    }

    public static final class b implements InputFilter {
        public b() {
        }

        @Override // android.text.InputFilter
        public final CharSequence filter(CharSequence r1, int r2, int r3, Spanned r4, int r5, int r6) {
            Intrinsics.checkNotNullParameter(r1, "source");
            Intrinsics.checkNotNullParameter(r4, "dest");
            if (new Regex("[\\uD83C-\\uDBFF\\uDC00-\\uDFFF]+").containsMatchIn(r1) == false) goto L5;
            return "";
        L5:
            return null;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ ExplainCardTitleEditorDialog a;

        public c(ExplainCardTitleEditorDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            ExplainCardTitleEditorDialog r3 = this.a;
            EditText r0 = (EditText) r3.S90(2131388860);
            if (r0 == null) goto L5;
            Editable r1 = r0.getText();
        L6:
            ExplainCardTitleEditorDialog.T90(r3, r1.toString());
            return;
        L5:
            r1 = null;
            goto L6
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ ExplainCardTitleEditorDialog a;

        public d(ExplainCardTitleEditorDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            EditText r3 = (EditText) this.a.S90(2131388860);
            if (r3 == null) goto L6;
            r3.setText("");
            return;
        }
    }

    static {
    }

    public ExplainCardTitleEditorDialog() {
        this.j = new com.bytedance.android.live.openplatform.impl.base.utils.a();
        this.d = new LinkedHashMap();
        OpenPlatformAnchorServiceImpl.Companion.getClass();
        so0.a r0 = (so0.a) ((po0.a.b) OpenPlatformAnchorServiceImpl.access$getDiComponent$cp()).a().a.b.get();
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        this.i = r0;
        this.e = LazyKt.lazy(new ExplainCardTitleEditorDialog$cardViewModel$2(this));
        this.f = 1;
        this.g = "";
        this.h = "";
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        this.j.b();
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

    public final void U90(boolean r3) {
        TextView r1 = (TextView) S90(2131367655);
        if (r1 == null) goto L5;
        r1.setEnabled(r3);
    L5:
        if (r3 == false) goto L9;
        TextView r4 = (TextView) S90(2131367655);
        if (r4 == null) goto L13;
        r4.setTextColor(ContextCompat.getColor(requireContext(), 2131107865));
        return;
    L13:
        return;
    L9:
        TextView r5 = (TextView) S90(2131367655);
        if (r5 == null) goto L15;
        r5.setTextColor(ContextCompat.getColor(requireContext(), 2131107864));
        return;
    }

    public final void V90(String r9) {
        int r10 = r9.length();
        TextView r1 = (TextView) S90(2131365492);
        boolean r3 = true;
        if (r1 == null) goto L5;
        r1.setText(getString(2131920941, new Object[]{Integer.valueOf(r10), 15}));
    L5:
        ImageView r5 = (ImageView) S90(2131366951);
        if (r5 == null) goto L11;
        if (r10 <= 0) goto L9;
        int r7 = 0;
    L10:
        r5.setVisibility(r7);
        goto L11
    L9:
        r7 = 4;
    L11:
        if (r10 <= 0) goto L27;
        ImageView r2 = (ImageView) S90(2131366951);
        if (r2 == null) goto L15;
        r2.setVisibility(0);
    L15:
        if (r10 < 15) goto L23;
        TextView r0 = (TextView) S90(2131365492);
        if (r0 == null) goto L19;
        r0.setTextColor(ContextCompat.getColor(requireContext(), 2131107862));
    L19:
        if (r10 == 15) goto L22;
        r3 = false;
    L22:
        U90(r3);
        return;
    L23:
        TextView r11 = (TextView) S90(2131365492);
        if (r11 == null) goto L26;
        r11.setTextColor(ContextCompat.getColor(requireContext(), 2131107863));
    L26:
        U90(true);
        return;
    L27:
        ImageView r12 = (ImageView) S90(2131366951);
        if (r12 == null) goto L30;
        r12.setVisibility(4);
    L30:
        U90(false);
    }

    public final void onActivityCreated(Bundle r9) {
        super/*androidx.fragment.app.DialogFragment*/.onActivityCreated(r9);
        Dialog r10 = getDialog();
        if (r10 == null) goto L7;
        Window r11 = r10.getWindow();
        if (r11 == null) goto L7;
        r11.setLayout(-1, -2);
    L7:
        ((TextView) S90(2131388880)).setText(this.g);
        EditText r0 = (EditText) S90(2131388860);
        String r2 = null;
        if (r0 == null) goto L16;
        String r3 = this.h;
        if (r2.a(r3) == true) goto L13;
        r3 = null;
    L13:
        if (r3 != null) goto L15;
        r3 = getString(2131920934);
    L15:
        r0.setText(r3);
    L16:
        EditText r1 = (EditText) S90(2131388860);
        if (r1 == null) goto L19;
        r1.requestFocus();
    L19:
        EditText r4 = (EditText) S90(2131388860);
        boolean r5 = false;
        if (r4 == null) goto L22;
        r4.setFilters(new InputFilter[]{new InputFilter.LengthFilter(15), new b()});
    L22:
        EditText r6 = (EditText) S90(2131388860);
        if (r6 == null) goto L25;
        r6.setOnEditorActionListener(new n(this));
    L25:
        EditText r7 = (EditText) S90(2131388860);
        if (r7 == null) goto L28;
        r7.setOnFocusChangeListener(new o(this));
    L28:
        EditText r12 = (EditText) S90(2131388860);
        if (r12 == null) goto L31;
        r12.addTextChangedListener(new p(this));
    L31:
        TextView r13 = (TextView) S90(2131367655);
        if (r13 == null) goto L35;
        r13.setOnClickListener(new c(this));
    L35:
        if (r2.a(this.h) == true) goto L37;
    L39:
        U90(r5);
        ImageView r14 = (ImageView) S90(2131366951);
        if (r14 == null) goto L42;
        r14.setOnClickListener(new d(this));
    L42:
        TextView r15 = (TextView) S90(2131385937);
        if (r15 == null) goto L45;
        r15.setVisibility(8);
    L45:
        String r16 = this.h;
        if (r2.a(r16) == false) goto L48;
        r2 = r16;
    L48:
        if (r2 != null) goto L50;
        r2 = getString(2131920934);
    L50:
        V90(r2);
        return;
    L37:
        if (this.h.length() > 15) goto L39;
        r5 = true;
        goto L39
    }

    public final void onCreate(Bundle r2) {
        super/*androidx.fragment.app.DialogFragment*/.onCreate(r2);
        Bundle r3 = getArguments();
        if (r3 == null) goto L5;
        int r4 = r3.getInt("editor_type");
    L6:
        this.f = r4;
        Bundle r5 = getArguments();
        if (r5 == null) goto L10;
        String r6 = r5.getString("editor_label_title");
        if (r6 == null) goto L10;
    L11:
        this.g = r6;
        Bundle r7 = getArguments();
        if (r7 == null) goto L15;
        String r8 = r7.getString("editor_title");
        if (r8 == null) goto L15;
    L16:
        this.h = r8;
        int r9 = qo0.a.a;
        qo0.a.c("ExplainCardTitleEditorDialog", "onCreate, type: " + this.f + ", label: " + this.g + ", title: " + this.h);
        return;
    L15:
        r8 = "";
    L10:
        r6 = getString(2131920944);
        goto L11
    L5:
        r4 = 1;
        goto L6
    }

    public final Dialog onCreateDialog(Bundle r4) {
        Dialog r5 = super.onCreateDialog(r4);
        r5.requestWindowFeature(1);
        r5.setCanceledOnTouchOutside(true);
        Window r0 = r5.getWindow();
        if (r0 == null) goto L5;
        r0.setSoftInputMode(21);
        r0.setGravity(80);
        r0.setBackgroundDrawable(new ColorDrawable(0));
        r0.getAttributes().windowAnimations = 2131954752;
    L5:
        return r5;
    }

    public static final void T90(ExplainCardTitleEditorDialog r2, String r3) {
        r2.getClass();
        int r0 = qo0.a.a;
        qo0.a.c("ExplainCardTitleEditorDialog", "start check content, title: " + r3);
        Lazy r1 = LiveOpenPlatformClient.c;
        Disposable r4 = ((MiniAppExplainCardApi) LiveOpenPlatformClient.a.a().a(MiniAppExplainCardApi.class)).checkStamp(4, r3).compose(RxUtil.rxSchedulerHelper()).subscribe(new q(r2, r3), r.a);
        Intrinsics.checkNotNullParameter(r4, "$this$autoDispose");
        r2.j.a(r4);
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131565643, r3, false);
    }
}
