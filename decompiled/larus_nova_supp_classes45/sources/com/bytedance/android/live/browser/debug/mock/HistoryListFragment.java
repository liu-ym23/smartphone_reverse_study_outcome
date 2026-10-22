package com.bytedance.android.live.browser.debug.mock;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.setting.SettingUtil;
import com.bytedance.android.livesdk.config.t8;
import com.bytedance.android.livesdk.sharedpref.b;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import r20.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/browser/debug/mock/HistoryListFragment;", "Lcom/bytedance/android/live/browser/debug/mock/BaseDialogFragment;", "<init>", "()V", "a", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HistoryListFragment extends BaseDialogFragment {
    public int d;

    public static final class a {
    }

    static {
    }

    public HistoryListFragment() {
        this.d = 1;
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        if (getArguments() == null) goto L5;
        this.d = 1;
    L5:
        SettingUtil.updateLocal(t8.a, "true");
        Map r3 = (Map) b.w.getValue();
        if (r3 == null) goto L9;
        Map<String, String> r0 = c.a;
        ((HashMap) c.a).putAll(r3);
        return;
    }

    public final View onCreateView(LayoutInflater r9, ViewGroup r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r9, "inflater");
        View r13 = r9.inflate(2131561211, r11, false);
        RecyclerView r14 = r13.findViewById(2131378057);
        if ((r14 instanceof RecyclerView) == false) goto L17;
        RecyclerView r15 = r14;
        if (this.d > 1) goto L7;
        LinearLayoutManager r16 = new LinearLayoutManager(r15.getContext());
    L8:
        r15.setLayoutManager(r16);
        ArrayList r17 = new ArrayList();
        Iterable r2 = (Iterable) b.y.getValue();
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator r4 = r2.iterator();
    L10:
        if (r4.hasNext() == false) goto L12;
        Uri r5 = UriProtector.parse(((String) r4.next()).toString());
        r3.add(new r20.a(r5, r5));
        goto L10
    L12:
        r17.addAll(r3);
        CollectionsKt.reverse(r17);
        ArrayList r6 = new ArrayList();
        Collection r7 = ((Map) b.z.getValue()).values();
        ArrayList r8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator r18 = r7.iterator();
    L14:
        if (r18.hasNext() == false) goto L16;
        String r19 = (String) r18.next();
        r20.a r21 = new r20.a(UriProtector.parse(r19), UriProtector.parse(r19));
        r21.a = true;
        r8.add(r21);
        goto L14
    L16:
        r6.addAll(0, r8);
        r15.setAdapter(new HybridHistoryListAdapter(r17, getActivity()));
        goto L17
    L7:
        r16 = new GridLayoutManager(r15.getContext(), 2);
    L17:
        return r13;
    }
}
