package com.bytedance.android.livesdk.interactivity.publicscreen.plugin.featureplugin;

import androidx.lifecycle.ViewModel;
import com.bytedance.android.livesdk.gift.model.n;
import com.bytedance.android.livesdk.interactivity.api.j;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.plugin.FeaturePluginType;
import com.bytedance.bdlocation.BuildConfig;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0013B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0003H\u0014R \u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00060\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/plugin/featureplugin/PublicScreenFeaturePluginStore;", "Landroidx/lifecycle/ViewModel;", "Lcom/bytedance/android/livesdk/interactivity/api/j;", BuildConfig.FLAVOR, "load", "unload", "Lv42/a;", "plugin", "registerPlugin", "onCleared", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/plugin/FeaturePluginType;", n.KEY_PLUGINS, "Ljava/util/Map;", "Lcom/bytedance/android/livesdk/interactivity/publicscreen/plugin/featureplugin/PublicScreenFeaturePluginStore$LifecycleStatus;", "lifecycleStatus", "Lcom/bytedance/android/livesdk/interactivity/publicscreen/plugin/featureplugin/PublicScreenFeaturePluginStore$LifecycleStatus;", "<init>", "()V", "LifecycleStatus", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PublicScreenFeaturePluginStore extends ViewModel implements j {
    private LifecycleStatus lifecycleStatus;
    private final Map<FeaturePluginType, v42.a> plugins;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/plugin/featureplugin/PublicScreenFeaturePluginStore$LifecycleStatus;", BuildConfig.FLAVOR, "Init", "Loaded", "UnLoaded", "Destroy", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum LifecycleStatus extends Enum<LifecycleStatus> {
        public static final LifecycleStatus Destroy = null;
        public static final LifecycleStatus Init = null;
        public static final LifecycleStatus Loaded = null;
        public static final LifecycleStatus UnLoaded = null;
        public static final /* synthetic */ LifecycleStatus[] a = null;

        static {
            LifecycleStatus r1 = new LifecycleStatus("Init", 0);
            Init = r1;
            LifecycleStatus r2 = new LifecycleStatus("Loaded", 1);
            Loaded = r2;
            LifecycleStatus r3 = new LifecycleStatus("UnLoaded", 2);
            UnLoaded = r3;
            LifecycleStatus r4 = new LifecycleStatus("Destroy", 3);
            Destroy = r4;
            a = new LifecycleStatus[]{r1, r2, r3, r4};
        }

        public static LifecycleStatus valueOf(String r1) {
            return (LifecycleStatus) r27.a.a(LifecycleStatus.class, r1);
        }

        public static LifecycleStatus[] values() {
            return (LifecycleStatus[]) a.clone();
        }

        public LifecycleStatus(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.j
    public void load() {
        this.lifecycleStatus = LifecycleStatus.Loaded;
        Iterator<T> r0 = this.plugins.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((v42.a) r0.next()).onLoad();
        goto L4
    }

    public void onCleared() {
        this.lifecycleStatus = LifecycleStatus.Destroy;
        Iterator<T> r0 = this.plugins.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((v42.a) r0.next()).onDestroy();
        goto L4
    L6:
        this.plugins.clear();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.j
    public void unload() {
        this.lifecycleStatus = LifecycleStatus.UnLoaded;
        Iterator<T> r0 = this.plugins.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((v42.a) r0.next()).onUnload();
        goto L4
    }

    public PublicScreenFeaturePluginStore() {
        this.plugins = new LinkedHashMap();
        this.lifecycleStatus = LifecycleStatus.Init;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.j
    public void registerPlugin(v42.a r3) {
        Intrinsics.checkNotNullParameter(r3, "plugin");
        if (this.lifecycleStatus != LifecycleStatus.Destroy) goto L5;
        return;
    L5:
        this.plugins.put(r3.getType(), r3);
        r3.onInit();
        if (this.lifecycleStatus != LifecycleStatus.Loaded) goto L9;
        r3.onLoad();
        return;
    }
}
