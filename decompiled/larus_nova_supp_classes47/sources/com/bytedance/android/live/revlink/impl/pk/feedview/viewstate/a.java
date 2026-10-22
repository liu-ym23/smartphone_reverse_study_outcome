package com.bytedance.android.live.revlink.impl.pk.feedview.viewstate;

import android.widget.FrameLayout;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.revlink.impl.pk.feedview.bridge.c;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public final MutableLiveData<String> a;
    public final MutableLiveData<JSONObject> b;
    public final MutableLiveData<JSONObject> c;
    public final MutableLiveData<String> d;
    public final MutableLiveData<String> e;
    public final MutableLiveData<Boolean> f;
    public final C0170a g;
    public final b h;
    public boolean i;
    public final FrameLayout j;
    public final c k;
    public final com.bytedance.android.live.revlink.impl.pk.scopeservice.a l;
    public final Function0<Pair<Integer, Integer>> m;

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.pk.feedview.viewstate.a$a, reason: collision with other inner class name */
    public static final class C0170a<T> implements Observer {
        public final /* synthetic */ a a;

        public C0170a(a r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            MutableLiveData<String> r0 = this.a.d;
            r0.setValue((String) r2);
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ a a;

        public b(a r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            MutableLiveData<String> r0 = this.a.e;
            r0.setValue((String) r2);
        }
    }

    public a(FrameLayout r2, com.bytedance.android.live.revlink.impl.pk.feedview.viewstate.b r3, c r4, com.bytedance.android.live.revlink.impl.pk.scopeservice.a r5, Function0<Pair<Integer, Integer>> r6) {
        Intrinsics.checkNotNullParameter(r2, "lynxContainer");
        Intrinsics.checkNotNullParameter(r3, "viewState");
        Intrinsics.checkNotNullParameter(r4, "bridget");
        Intrinsics.checkNotNullParameter(r5, "service");
        Intrinsics.checkNotNullParameter(r6, "getPlayerWH");
        this.j = r2;
        this.k = r4;
        this.l = r5;
        this.m = r6;
        this.a = new MutableLiveData();
        this.b = new MutableLiveData();
        this.c = new MutableLiveData();
        this.d = new MutableLiveData();
        this.e = new MutableLiveData();
        this.f = new MutableLiveData(Boolean.FALSE);
        this.g = new C0170a(this);
        this.h = new b(this);
    }
}
