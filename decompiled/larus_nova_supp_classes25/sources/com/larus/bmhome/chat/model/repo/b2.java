package com.larus.bmhome.chat.model.repo;

import androidx.lifecycle.MutableLiveData;
import com.larus.bmhome.chat.api.NotificationApi;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b2 implements w1 {
    public static final b2 a = null;
    public static final MutableLiveData<Integer> b = null;
    public static final MutableLiveData<Boolean> c = null;

    public b2() {
    }

    static {
        a = new b2();
        b = new MutableLiveData();
        c = new MutableLiveData();
    }

    public static NotificationApi c() {
        return (NotificationApi) NotificationApi.a.getValue();
    }

    @Override // com.larus.bmhome.chat.model.repo.w1
    public final MutableLiveData<Integer> a() {
        return b;
    }

    @Override // com.larus.bmhome.chat.model.repo.w1
    public final MutableLiveData<Boolean> b() {
        return c;
    }
}
