package com.bytedance.android.livesdk.interactivity.api.publicscreen;

import androidx.lifecycle.ViewModel;
import com.bytedance.bdlocation.BuildConfig;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u00032\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00028\u00002\u0006\u0010\b\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\f\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00028\u00002\u0006\u0010\b\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\f\u0010\u000bJ\b\u0010\r\u001a\u00020\tH\u0014R \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/Store;", "K", "V", "Landroidx/lifecycle/ViewModel;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "map", "key", "value", BuildConfig.FLAVOR, "add", "(Ljava/lang/Object;Ljava/lang/Object;)V", "remove", "onCleared", "storeMap", "Ljava/util/Map;", BuildConfig.FLAVOR, "isCleared", "Z", "<init>", "()V", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class Store<K, V> extends ViewModel {
    private boolean isCleared;
    private final Map<K, V> storeMap;

    public void onCleared() {
        this.isCleared = true;
        this.storeMap.clear();
    }

    public Store() {
        this.storeMap = new LinkedHashMap();
    }

    public final Map<K, V> map() {
        return this.storeMap;
    }

    public void add(K r2, V r3) {
        if (this.isCleared == false) goto L6;
        return;
    L6:
        if (this.storeMap.containsKey(r2) == false) goto L8;
        return;
    L8:
        this.storeMap.put(r2, r3);
    }

    public void remove(K r1, V r2) {
        if (this.isCleared == false) goto L6;
        return;
    L6:
        if (this.storeMap.containsKey(r1) == true) goto L8;
        return;
    L8:
        this.storeMap.remove(r1);
    }
}
