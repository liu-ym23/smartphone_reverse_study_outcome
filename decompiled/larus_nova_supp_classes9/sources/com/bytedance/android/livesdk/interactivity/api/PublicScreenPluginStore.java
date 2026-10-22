package com.bytedance.android.livesdk.interactivity.api;

import androidx.lifecycle.ViewModel;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.PSMessageViewHolder;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.PublicScreenConfig$InterceptorType;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.PublicScreenConfig$ViewBinderType;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.Store;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.x;
import com.bytedance.bdlocation.BuildConfig;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b*\u0010+J\u0016\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005J\u0010\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\b\u0010\n\u001a\u00020\u0007H\u0014J\u0018\u0010\u000f\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016J(\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00102\u0016\u0010\u0015\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\u0013\u0012\u0006\b\u0001\u0012\u00020\u00140\u0012H\u0016J\u0018\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u0010\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001bH\u0016R \u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010#\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u001a\u0010&\u001a\u00020%8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)¨\u0006,"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/PublicScreenPluginStore;", "Landroidx/lifecycle/ViewModel;", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/n;", BuildConfig.FLAVOR, "uniqueId", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/x;", "plugin", BuildConfig.FLAVOR, "load", "getPlugin", "onCleared", BuildConfig.FLAVOR, "messageMethod", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/i$a;", "factory", "addMessageFactory", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/PublicScreenConfig$ViewBinderType;", "type", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/j;", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/i;", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/PSMessageViewHolder;", "viewBinder", "addMessageViewBinder", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/PublicScreenConfig$InterceptorType;", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/h;", "interceptor", "addMessageInterceptor", "Ls42/b;", "listener", "addMessageListener", "removeMessageListener", BuildConfig.FLAVOR, com.bytedance.android.livesdk.gift.model.n.KEY_PLUGINS, "Ljava/util/Map;", BuildConfig.FLAVOR, "isCleared", "Z", "Lcom/bytedance/android/livesdk/interactivity/api/PublicScreenContext;", "publicScreenContext", "Lcom/bytedance/android/livesdk/interactivity/api/PublicScreenContext;", "getPublicScreenContext", "()Lcom/bytedance/android/livesdk/interactivity/api/PublicScreenContext;", "<init>", "(Lcom/bytedance/android/livesdk/interactivity/api/PublicScreenContext;)V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PublicScreenPluginStore extends ViewModel implements com.bytedance.android.livesdk.interactivity.api.publicscreen.n {
    private boolean isCleared;
    private final Map<Object, x> plugins;
    private final PublicScreenContext publicScreenContext;

    public void onCleared() {
        this.isCleared = true;
        Iterator<T> r0 = this.plugins.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        x r1 = (x) r0.next();
        r1.q();
        r1.a = null;
        goto L4
    L6:
        this.plugins.clear();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.n
    public /* bridge */ /* synthetic */ com.bytedance.android.livesdk.interactivity.api.publicscreen.l getPublicScreenContext() {
        return getPublicScreenContext();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.n
    public PublicScreenContext getPublicScreenContext() {
        return this.publicScreenContext;
    }

    public PublicScreenPluginStore(PublicScreenContext r2) {
        Intrinsics.checkNotNullParameter(r2, "publicScreenContext");
        this.publicScreenContext = r2;
        this.plugins = new LinkedHashMap();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.n
    public void addMessageListener(s42.b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        ((CopyOnWriteArrayList) getPublicScreenContext().getListeners().getValue()).add(r2);
    }

    public final x getPlugin(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "uniqueId");
        if (this.isCleared == false) goto L7;
        return null;
    L7:
        return this.plugins.get(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.n
    public void removeMessageListener(s42.b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        ((CopyOnWriteArrayList) getPublicScreenContext().getListeners().getValue()).remove(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.n
    public void addMessageFactory(String r2, com.bytedance.android.livesdk.interactivity.api.publicscreen.i.a r3) {
        Intrinsics.checkNotNullParameter(r2, "messageMethod");
        Intrinsics.checkNotNullParameter(r3, "factory");
        ((Store) getPublicScreenContext().getModelFactoryStore().getValue()).add(r2, r3);
        ((PSMessageRepositoryStore) getPublicScreenContext().getRepository().getValue()).checkAndRegisterMessageListener(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.n
    public void addMessageInterceptor(PublicScreenConfig$InterceptorType r2, com.bytedance.android.livesdk.interactivity.api.publicscreen.h r3) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "interceptor");
        ((Store) getPublicScreenContext().getInterceptorStore().getValue()).add(r2, r3);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.n
    public void addMessageViewBinder(PublicScreenConfig$ViewBinderType r2, com.bytedance.android.livesdk.interactivity.api.publicscreen.j<? extends com.bytedance.android.livesdk.interactivity.api.publicscreen.i, ? extends PSMessageViewHolder> r3) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "viewBinder");
        ((Store) getPublicScreenContext().getViewBinderStore().getValue()).add(r2, r3);
    }

    public final void load(Object r2, x r3) {
        Intrinsics.checkNotNullParameter(r2, "uniqueId");
        Intrinsics.checkNotNullParameter(r3, "plugin");
        if (this.isCleared == false) goto L6;
        return;
    L6:
        if (this.plugins.containsKey(r2) == false) goto L8;
        return;
    L8:
        this.plugins.put(r2, r3);
        r3.getClass();
        Intrinsics.checkNotNullParameter(this, "proxy");
        r3.a = this;
        r3.p(getPublicScreenContext());
    }
}
