package com.bytedance.android.live.revlink.link.streaminteract.biz;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.livesdk.revenue.service.livecore.IRegion;
import java.util.List;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import r41.e;
import y41.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b {
    public static final boolean a = false;
    public static final int b = 0;
    public static final MutableLiveData<String> c = null;
    public static List<? extends IRegion> d;

    static {
        f r0 = f.N;
        r0.getClass();
        ReadOnlyProperty r1 = f.L;
        KProperty[] r2 = f.a;
        a = ((e) r1.getValue(r0, r2[36])).getEnabled();
        b = ((e) r1.getValue(r0, r2[36])).H2();
        c = new MutableLiveData();
    }
}
