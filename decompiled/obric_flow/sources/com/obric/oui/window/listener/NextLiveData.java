package com.obric.oui.window.listener;

import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.lynx.tasm.ui.image.v;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class NextLiveData<T> extends MutableLiveData<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Handler f14899c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f14900a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f14901b;

    static {
        f14899c = new Handler(Looper.getMainLooper());
    }

    public NextLiveData() {
        this.f14900a = -1;
        this.f14901b = new HashMap();
    }

    @Override // androidx.lifecycle.LiveData
    public final void observe(LifecycleOwner r5, Observer r10) {
        HashMap r11 = this.f14901b;
        if (r11.containsKey(r10) == true) goto L7;
        a r12 = new a(this, this.f14900a, r10);
        r11.put(r10, r12);
        super.observe(r5, r12);
        return;
    }

    @Override // androidx.lifecycle.LiveData
    public final void observeForever(Observer r5) {
        HashMap r10 = this.f14901b;
        if (r10.containsKey(r5) == true) goto L7;
        a r11 = new a(this, this.f14900a, r5);
        r10.put(r5, r11);
        super.observeForever(r11);
        return;
    }

    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    public final void postValue(Object r5) {
        f14899c.post(new v(4, this, r5));
    }

    @Override // androidx.lifecycle.LiveData
    public final void removeObserver(Observer r5) {
        HashMap r10 = this.f14901b;
        a r11 = (a) r10.remove(r5);
        if (r11 == null) goto L7;
        super.removeObserver(r11);
        return;
    L7:
        if ((r5 instanceof a) == false) goto L21;
        Iterator r12 = r10.entrySet().iterator();
    L10:
        if (r12.hasNext() == false) goto L14;
        Map.Entry r13 = (Map.Entry) r12.next();
        if (r5.equals(r13.getValue()) == false) goto L10;
        Observer r14 = (Observer) r13.getKey();
        super.removeObserver(r5);
    L15:
        if (r14 == null) goto L22;
        r10.remove(r14);
        return;
    L22:
        return;
    L14:
        r14 = null;
        goto L15
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    public final void setValue(Object r5) {
        this.f14900a++;
        super.setValue(r5);
    }
}
