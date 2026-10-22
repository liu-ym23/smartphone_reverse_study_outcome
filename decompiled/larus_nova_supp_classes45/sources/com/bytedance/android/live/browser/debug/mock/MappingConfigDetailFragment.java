package com.bytedance.android.live.browser.debug.mock;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.sharedpref.e;
import com.bytedance.android.livesdk.sharedpref.f;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import q20.j;
import r20.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/browser/debug/mock/MappingConfigDetailFragment;", "Lcom/bytedance/android/live/browser/debug/mock/BaseDialogFragment;", "<init>", "()V", "a", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MappingConfigDetailFragment extends BaseDialogFragment {
    public static final /* synthetic */ int e = 0;
    public Map<Integer, View> d;

    public static final class a {
        public static void a(FragmentActivity r3, Uri r4, Uri r5) {
            Intrinsics.checkNotNullParameter(r3, "activity");
            Intrinsics.checkNotNullParameter(r4, "originUri");
            Bundle r0 = new Bundle();
            MappingConfigDetailFragment r1 = new MappingConfigDetailFragment();
            r0.putParcelable("origin_uri", r4);
            r0.putParcelable("mapping_uri", r5);
            r1.setArguments(r0);
            LiveDialogFragment.Companion.getClass();
            LiveDialogFragment.a.a(r3, r1);
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ MappingConfigDetailFragment a;
        public final /* synthetic */ Uri b;

        public b(MappingConfigDetailFragment r1, Uri r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            EditText r6 = (EditText) this.a.S90(2131379532);
            if (r6 != null) goto L10;
            return;
        L10:
            UriProtector.parse(r6.getText().toString());     // Catch: Exception -> L7
            Map<String, String> r1 = c.a;
            int r2 = j.a;
            ((HashMap) r1).put(j.a(this.b), r6.getText().toString());
            e r7 = com.bytedance.android.livesdk.sharedpref.b.w;
            r7.getClass();
            f.d(r7, r1);
            f2.i(this.a.getActivity(), "保存成功", 0);
            return;
        L7:
            e = move-exception;
            Toast.makeText(this.a.getActivity(), "输入的正确的url,error:" + e.getMessage(), 0).show();
        }
    }

    static {
    }

    public MappingConfigDetailFragment() {
        this.d = new LinkedHashMap();
    }

    public final void onDestroyView() {
        super.onDestroyView();
        ((LinkedHashMap) this.d).clear();
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

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        Bundle r3 = getArguments();
        if (r3 == null) goto L6;
        r3.getString("param1");
        r3.getString("param2");
        return;
    }

    public final void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super.onViewCreated(r3, r4);
        Bundle r5 = getArguments();
        Object r6 = null;
        if (r5 == null) goto L5;
        Object r7 = r5.get("origin_uri");
    L6:
        if (r7 == null) goto L26;
        Uri r8 = (Uri) r7;
        Bundle r0 = getArguments();
        if (r0 == null) goto L10;
        Object r1 = r0.get("mapping_uri");
    L12:
        if ((r1 instanceof Uri) == false) goto L15;
        r6 = r1;
    L15:
        Uri r9 = (Uri) r6;
        if (r9 == null) goto L18;
        ((EditText) S90(2131379532)).setText(r9.toString());
    L18:
        TextView r11 = (TextView) S90(2131381677);
        if (r11 == null) goto L21;
        r11.setText("原URI:" + r8);
    L21:
        TextView r12 = (TextView) S90(2131371404);
        if (r12 == null) goto L27;
        r12.setOnClickListener(new b(this, r8));
        return;
    L27:
        return;
    L10:
        r1 = null;
        goto L12
    L26:
        throw new NullPointerException("null cannot be cast to non-null type android.net.Uri");
    L5:
        r7 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131561218, r3, false);
    }
}
