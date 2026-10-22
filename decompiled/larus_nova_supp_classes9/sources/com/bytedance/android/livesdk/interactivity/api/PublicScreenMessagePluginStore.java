package com.bytedance.android.livesdk.interactivity.api;

import androidx.lifecycle.ViewModel;
import com.bytedance.android.livesdk.interactivity.api.publicscreenV2.config.MessageBinderType;
import com.bytedance.android.livesdk.interactivity.api.publicscreenV2.config.MessagePluginType;
import com.bytedance.bdlocation.BuildConfig;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001e\u0010\u001fJ$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\b\u0001\u0012\u00020\u00060\u0004J\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002J\u001e\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\b\u0001\u0012\u00020\u0006\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\u0002J\u0018\u0010\u000f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0006\u0018\u00010\u000e2\u0006\u0010\u000b\u001a\u00020\rJ\b\u0010\u0010\u001a\u00020\bH\u0014R.\u0010\u0012\u001a\u001c\u0012\u0004\u0012\u00020\u0002\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\b\u0001\u0012\u00020\u00060\u00040\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R(\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u0014\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u000e0\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001a\u001a\u00020\u00198\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/PublicScreenMessagePluginStore;", "Landroidx/lifecycle/ViewModel;", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreenV2/config/MessagePluginType;", "uniqueId", "Lh52/a;", "Lh52/d;", "Lh52/c;", "plugin", BuildConfig.FLAVOR, "register", "unregister", "type", "getPluginByType", BuildConfig.FLAVOR, "Lh52/b;", "getViewBinderByType", "onCleared", BuildConfig.FLAVOR, "pluginMap", "Ljava/util/Map;", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreenV2/config/MessageBinderType;", "viewBinderMap", BuildConfig.FLAVOR, "isCleared", "Z", "Lcom/bytedance/android/livesdk/interactivity/api/PublicScreenContext;", "publicScreenContext", "Lcom/bytedance/android/livesdk/interactivity/api/PublicScreenContext;", "getPublicScreenContext", "()Lcom/bytedance/android/livesdk/interactivity/api/PublicScreenContext;", "<init>", "(Lcom/bytedance/android/livesdk/interactivity/api/PublicScreenContext;)V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PublicScreenMessagePluginStore extends ViewModel {
    private boolean isCleared;
    private final Map<MessagePluginType, h52.a<h52.d, ? extends h52.c>> pluginMap;
    private final PublicScreenContext publicScreenContext;
    private final Map<MessageBinderType, h52.b<? extends h52.c>> viewBinderMap;

    public void onCleared() {
        this.isCleared = true;
        Iterator<T> r0 = this.pluginMap.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((h52.a) r0.next()).onUnload();
        goto L4
    L6:
        this.viewBinderMap.clear();
        this.pluginMap.clear();
    }

    public final PublicScreenContext getPublicScreenContext() {
        return this.publicScreenContext;
    }

    public PublicScreenMessagePluginStore(PublicScreenContext r2) {
        Intrinsics.checkNotNullParameter(r2, "publicScreenContext");
        this.publicScreenContext = r2;
        this.pluginMap = new LinkedHashMap();
        this.viewBinderMap = new LinkedHashMap();
    }

    public final h52.a<h52.d, ? extends h52.c> getPluginByType(MessagePluginType r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        return this.pluginMap.get(r2);
    }

    public final h52.b<? extends h52.c> getViewBinderByType(int r8) {
        MessageBinderType.Companion.getClass();
        MessageBinderType[] r0 = MessageBinderType.access$getVALUES$cp();
        int r1 = r0.length;
        int r3 = 0;
    L4:
        if (r3 >= r1) goto L12;
        MessageBinderType r5 = r0[r3];
        if (r5.getType() != r8) goto L8;
        boolean r6 = true;
    L9:
        if (r6 == true) goto L13;
        r3 = r3 + 1;
    L13:
        if (r5 != null) goto L15;
        return null;
    L15:
        return this.viewBinderMap.get(r5);
    L8:
        r6 = false;
        goto L9
    L12:
        r5 = null;
        goto L13
    }

    public final void unregister(MessagePluginType r2) {
        Intrinsics.checkNotNullParameter(r2, "uniqueId");
        if (this.isCleared == false) goto L5;
        return;
    L5:
        h52.a<h52.d, ? extends h52.c> r3 = this.pluginMap.remove(r2);
        if (r3 == null) goto L9;
        r3.onUnload();
        h52.b<? extends h52.c> r4 = this.viewBinderMap.remove(r3.c().a);
        return;
    }

    public final void register(MessagePluginType r3, h52.a<h52.d, ? extends h52.c> r4) {
        Intrinsics.checkNotNullParameter(r3, "uniqueId");
        Intrinsics.checkNotNullParameter(r4, "plugin");
        if (this.isCleared == false) goto L6;
        return;
    L6:
        if (this.pluginMap.containsKey(r3) == false) goto L8;
        return;
    L8:
        this.pluginMap.put(r3, r4);
        this.viewBinderMap.put(r4.c().a, r4.c());
        r4.onLoad();
    }
}
