package slb;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStoreOwner;
import com.ss.android.lark.inline.ai.api.LockType;
import com.ss.android.lark.inline.ai.api.MaskType;
import com.ss.android.lark.inline.ai.api.MentionType;
import com.ss.android.lark.inline.ai.api.ScenarioType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g {
    public static final /* synthetic */ int p = 0;
    public final FragmentActivity a;
    public final LifecycleOwner b;
    public final ViewModelStoreOwner c;
    public final ViewGroup d;
    public final ScenarioType e;
    public final i f;
    public final boolean g;
    public final MaskType h;
    public final LockType i;
    public final View j;
    public final c k;
    public final slb.a l;
    public final int m;
    public final boolean n;
    public final MentionType o;

    public static final class a {
    }

    static {
    }

    public final FragmentActivity getActivity() {
        return this.a;
    }

    public g(FragmentActivity r1, LifecycleOwner r2, ViewModelStoreOwner r3, ViewGroup r4, ScenarioType r5, i r6, MaskType r7, LockType r8, c r9, int r10, boolean r11, MentionType r12) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = false;
        this.h = r7;
        this.i = r8;
        this.j = null;
        this.k = r9;
        this.l = null;
        this.m = r10;
        this.n = r11;
        this.o = r12;
    }
}
