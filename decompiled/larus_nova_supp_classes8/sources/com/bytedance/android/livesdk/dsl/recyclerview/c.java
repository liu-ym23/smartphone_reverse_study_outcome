package com.bytedance.android.livesdk.dsl.recyclerview;

import android.app.Activity;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.profile.ui.component.descriptioncomponent.mylive.TabItemAdapter;
import com.bytedance.android.livesdk.dsl.util.DSLActionEnum;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import yt1.k;
import yt1.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c {
    public final HashMap<String, bu1.a> a;
    public Function1<? super Function0<Unit>, Unit> b;
    public final ArrayList<k> c;
    public final Activity d;
    public final n e;
    public final f f;
    public final Map<String, ? extends Object> g;

    public final Activity getActivity() {
        return this.d;
    }

    public c(Activity r2, RecyclerView r3, TabItemAdapter r4, n r5, f r6) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "recycler");
        Intrinsics.checkNotNullParameter(r4, "adapter");
        Intrinsics.checkNotNullParameter(r5, "triangleManager");
        Intrinsics.checkNotNullParameter(r6, "templateStore");
        this.d = r2;
        this.e = r5;
        this.f = r6;
        this.g = null;
        HashMap<String, bu1.a> r7 = new HashMap();
        this.a = r7;
        this.c = new ArrayList();
        bu1.b r8 = new bu1.b();
        String r9 = DSLActionEnum.ListItemRefresh.getText();
        Intrinsics.checkNotNullParameter(r9, "key");
        Intrinsics.checkNotNullParameter(r8, "action");
        r7.put(r9, r8);
    }
}
