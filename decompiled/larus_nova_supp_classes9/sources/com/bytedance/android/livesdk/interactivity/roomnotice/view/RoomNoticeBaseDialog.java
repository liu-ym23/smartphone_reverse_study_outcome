package com.bytedance.android.livesdk.interactivity.roomnotice.view;

import android.app.Dialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import ya2.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/roomnotice/view/RoomNoticeBaseDialog;", "Landroidx/fragment/app/DialogFragment;", "Landroid/view/View$OnClickListener;", "<init>", "()V", "a", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class RoomNoticeBaseDialog extends DialogFragment implements View.OnClickListener {
    public static Pair<Long, String> f;
    public Map<Integer, View> d;
    public Room e;

    public static final class a {
    }

    public static final class b implements ya2.c {
        public final /* synthetic */ RoomNoticeBaseDialog a;

        @Override // ya2.c
        public final void a() {
            String r0 = rm3.c.a;
            rm3.c.g(this.a.getContext(), "请勿输入表情字符", 0, false, 28);
        }

        public b(RoomNoticeBaseDialog r1) {
            this.a = r1;
        }
    }

    public static final class c implements TextWatcher {
        public final /* synthetic */ RoomNoticeBaseDialog a;

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r1) {
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        public c(RoomNoticeBaseDialog r1) {
            this.a = r1;
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r6, int r7, int r8, int r9) {
            if (r6 == null) goto L29;
            boolean r1 = false;
            if (r6.length() <= d.a()) goto L6;
            int r2 = r7 + r9;
            ((Editable) r6).delete(r2 - (r6.length() - d.a()), r2);
            String r10 = rm3.c.a;
            rm3.c.g(this.a.getContext(), "介绍文案最多" + d.a() + 23383, 0, false, 28);
            RoomNoticeBaseDialog r11 = this.a;
            int r0 = d.a();
            Pair<Long, String> r3 = RoomNoticeBaseDialog.f;
            r11.W90(r0);
        L7:
            String r13 = ((EditText) this.a.T90(2131381021)).getText().toString();
            Intrinsics.checkNotNullParameter(r13, "content");
            int r4 = 0;
            int r5 = 0;
        L9:
            if (r4 >= r13.length()) goto L15;
            if (r13.charAt(r4) != '\n') goto L13;
            r5 = r5 + 1;
        L13:
            r4 = r4 + 1;
            goto L9
        L15:
            if (r5 < 5) goto L18;
            f2.c("换行不能超过5个", 0);
            ((Editable) r6).delete(r7, r9 + r7);
            return;
        L18:
            this.a.getClass();
            Room r14 = this.a.e;
            if (r14 == null) goto L21;
            long r15 = r14.id;
            Pair<Long, String> r16 = RoomNoticeBaseDialog.f;
            Pair<Long, String> r17 = new Pair(Long.valueOf(r15), r6.toString());
            Intrinsics.checkNotNullParameter(r17, "<set-?>");
            RoomNoticeBaseDialog.f = r17;
        L21:
            RoomNoticeBaseDialog r18 = this.a;
            if (r6.length() <= 0) goto L24;
            r1 = true;
        L24:
            r18.V90(r1);
            return;
        L6:
            RoomNoticeBaseDialog r19 = this.a;
            int r20 = r6.length();
            Pair<Long, String> r21 = RoomNoticeBaseDialog.f;
            r19.W90(r20);
            goto L7
        }
    }

    public abstract String U90();

    static {
        f = new Pair(0L, BuildConfig.FLAVOR);
    }

    public void S90() {
        this.d.clear();
    }

    public RoomNoticeBaseDialog() {
        this.d = new LinkedHashMap();
    }

    public void onDestroyView() {
        super.onDestroyView();
        S90();
    }

    public View T90(int r3) {
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

    public final void V90(boolean r3) {
        ((TextView) T90(2131381024)).setEnabled(r3);
        TextView r0 = (TextView) T90(2131381024);
        if (r3 == false) goto L5;
        String r4 = "#FFF04142";
    L6:
        r0.setTextColor(ColorProtector.parseColor(r4));
        return;
    L5:
        r4 = "#4CF04142";
        goto L6
    }

    public final void W90(int r2) {
        int r0 = d.a;
        StringBuilder r1 = new StringBuilder();
        r1.append(r2);
        r1.append('/');
        r1.append(d.a());
        String r3 = r1.toString();
        ((TextView) T90(2131381027)).setText(r3);
    }

    public void onActivityCreated(Bundle r1) {
        super.onActivityCreated(r1);
    }

    public void onCreate(Bundle r2) {
        super.onCreate(r2);
        setStyle(1, 2131954638);
    }

    public final Dialog onCreateDialog(Bundle r2) {
        Dialog r3 = super.onCreateDialog(r2);
        r3.requestWindowFeature(1);
        r3.setCanceledOnTouchOutside(true);
        return r3;
    }

    public void onViewCreated(View r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r5, r6);
        ((TextView) T90(2131381017)).setOnClickListener(this);
        ((TextView) T90(2131381024)).setOnClickListener(this);
        boolean r0 = true;
        ((EditText) T90(2131381021)).setFilters(new ya2.a[]{new ya2.a(new b(this))});
        String r7 = U90();
        ((EditText) T90(2131381021)).setText(r7);
        W90(r7.length());
        if (((EditText) T90(2131381021)).getText().toString().length() == 0) goto L6;
        r0 = false;
    L6:
        if (r0 == false) goto L8;
        V90(false);
    L8:
        ((EditText) T90(2131381021)).addTextChangedListener(new c(this));
    }

    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        if (r4 == null) goto L11;
        dismiss();     // Catch: Exception -> L6
    L6:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r5 = DialogFragmentLancet.sLastShowStack;
        if (r5 == null) goto L11;
        com.bytedance.crash.d.d(r5, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
    L11:
        return r2.inflate(2131565758, r3, false);
    }
}
