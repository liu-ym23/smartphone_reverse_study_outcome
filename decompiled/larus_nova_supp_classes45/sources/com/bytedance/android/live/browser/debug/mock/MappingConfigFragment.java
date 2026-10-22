package com.bytedance.android.live.browser.debug.mock;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import q20.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/browser/debug/mock/MappingConfigFragment;", "Lcom/bytedance/android/live/browser/debug/mock/BaseDialogFragment;", "<init>", "()V", "a", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MappingConfigFragment extends BaseDialogFragment {
    public static final /* synthetic */ int e = 0;
    public Map<Integer, View> d;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ MappingConfigFragment a;
        public final /* synthetic */ Uri b;

        public b(MappingConfigFragment r1, Uri r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            FragmentActivity r4 = this.a.getActivity();
            if (r4 == null) goto L6;
            int r0 = MappingConfigDetailFragment.e;
            MappingConfigDetailFragment.a.a(r4, this.b, null);
            return;
        }
    }

    static {
    }

    public MappingConfigFragment() {
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
        r3.getInt("column-count");
        return;
    }

    public final void onViewCreated(View r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        super.onViewCreated(r5, r6);
        Bundle r7 = getArguments();
        if (r7 == null) goto L5;
        Object r8 = r7.get("origin_uri");
    L6:
        if (r8 == null) goto L28;
        Uri r9 = (Uri) r8;
        TextView r11 = (TextView) S90(2131381678);
        if (r11 == null) goto L11;
        r11.setText("原URI:" + UriProtector.parse(UriProtector.getQueryParameter(r9, LiveSlardarConstants.EXTRA_KEY_URL)));
    L11:
        if ((S90(2131379531) instanceof RecyclerView) == false) goto L23;
        RecyclerView r12 = S90(2131379531);
        r12.setLayoutManager(new LinearLayoutManager(r12.getContext()));
        r20.b[] r0 = new r20.b[2];
        r20.b r1 = new r20.b();
        Map r2 = (Map) com.bytedance.android.livesdk.sharedpref.b.w.getValue();
        if (r2 == null) goto L17;
        String r3 = (String) r2.get(j.a(r9));
        if (r3 == null) goto L17;
    L18:
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r1.a = r3;
        Unit r4 = Unit.INSTANCE;
        r0[0] = r1;
        r0[1] = new r20.b();
        List r13 = CollectionsKt.mutableListOf(r0);
        FragmentActivity r14 = getActivity();
        if (r14 == null) goto L22;
        r12.setAdapter(new MappingConfigAdapter(r13, r14, r9));
        goto L23
    L22:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    L17:
        r3 = "";
    L23:
        TextView r15 = (TextView) S90(2131362253);
        if (r15 == null) goto L29;
        r15.setOnClickListener(new b(this, r9));
        return;
    L29:
        return;
    L28:
        throw new NullPointerException("null cannot be cast to non-null type android.net.Uri");
    L5:
        r8 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131561219, r3, false);
    }
}
