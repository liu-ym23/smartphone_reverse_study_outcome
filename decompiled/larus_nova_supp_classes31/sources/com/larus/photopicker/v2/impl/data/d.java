package com.larus.photopicker.v2.impl.data;

import androidx.lifecycle.MutableLiveData;
import com.larus.photopicker.v2.impl.model.MediaTab;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public interface d {
    Object a(String r1, Continuation<? super mp9.c> r2);

    Object b(mp9.a r1, Continuation<? super Integer> r2);

    int c(long r1, MediaTab r3, long r4);

    Object d(mp9.a r1, Continuation<? super Boolean> r2);

    Object e(List<? extends MediaTab> r1, Continuation<? super List<mp9.b>> r2);

    Object f(int r1, int r2, List<? extends MediaTab> r3, Continuation<? super List<mp9.c>> r4);

    MutableLiveData g();

    List<mp9.b> h(mp9.c r1);

    Object i(int r1, int r2, mp9.a r3, Continuation<? super Unit> r4);
}
