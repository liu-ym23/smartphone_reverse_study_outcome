package idb;

import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.featuregating.interfaces.IFeatureGatingService;
import com.ss.android.lark.log.Log;
import dagger.hilt.EntryPoints;
import dagger.hilt.dwarf.spi.DwarfSPIEntryPoint;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f implements IFeatureGatingService {
    public static volatile f c;
    public final jdb.e a;
    public final Map<String, jdb.c> b;

    public static f a() {
        if (c != null) goto L15;
        monitor-enter(f.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (c != null) goto L9;
        c = new f();     // Catch: Throwable -> L11
    L9:
        monitor-exit(f.class);     // Catch: Throwable -> L11
    L15:
        return c;
    }

    @Override // com.ss.android.lark.featuregating.interfaces.IFeatureGatingService
    public final void clear() {
        this.a.U1();
    }

    @Override // com.ss.android.lark.featuregating.interfaces.IFeatureGatingService
    public final Set<String> getSettingsFGKeys() {
        return this.a.getSettingsFGKeys();
    }

    public f() {
        this.b = new ConcurrentHashMap();
        this.a = (jdb.e) ((DwarfSPIEntryPoint) EntryPoints.get(FeatureGatingModule.getDependency().getContext(), DwarfSPIEntryPoint.class)).dwarfSPI().get(jdb.e.class);
    }

    @Override // com.ss.android.lark.featuregating.interfaces.IFeatureGatingService
    public final void reload() {
        FeatureGatingModule.getDependency().N8();
    }

    @Override // com.ss.android.lark.featuregating.interfaces.IFeatureGatingService
    public final Set<String> allFg(String r2) {
        return this.a.allFg(r2);
    }

    @Override // com.ss.android.lark.featuregating.interfaces.IFeatureGatingService
    public final boolean isCrossUserEnable(String r2) {
        Log.i("FeatureGatingService", "from FeatureGatingService.");
        throw new UnsupportedOperationException("isCrossUserEnable is not supported");
    }

    @Override // com.ss.android.lark.featuregating.interfaces.IFeatureGatingService, jdb.g
    public final boolean isCurrentEnable(String r3) {
        Log.d("FeatureGatingService", "from FeatureGatingService.");
        return this.a.x(FeatureGatingModule.getDependency().getUserId(), r3);
    }

    @Override // com.ss.android.lark.featuregating.interfaces.IFeatureGatingService, jdb.g
    public final boolean isEnable(String r3) {
        Log.d("FeatureGatingService", "from FeatureGatingService.");
        return this.a.B0(FeatureGatingModule.getDependency().getUserId(), r3);
    }

    @Override // com.ss.android.lark.featuregating.interfaces.IFeatureGatingService
    public final boolean isNoUserFGEnable(String r3) {
        Log.i("FeatureGatingService", "from FeatureGatingService.");
        return this.a.isNoUserFGEnable(r3);
    }

    @Override // com.ss.android.lark.featuregating.interfaces.IFeatureGatingService
    public final boolean isUserFGEnable(String r3) {
        Log.i("FeatureGatingService", "from FeatureGatingService.");
        return this.a.tb(FeatureGatingModule.getDependency().getUserId(), r3);
    }

    @Override // com.ss.android.lark.featuregating.interfaces.IFeatureGatingService
    public final Map<String, String> getChangedKeysBySyncUpdate(String r2, Map<String, String> r3) {
        return this.a.getChangedKeysBySyncUpdate(r2, r3);
    }

    @Override // com.ss.android.lark.featuregating.interfaces.IFeatureGatingService
    public final Set<String> getRuntimeFGSPCache(String r2, String r3) {
        return this.a.getRuntimeFGSPCache(r2, r3);
    }

    @Override // com.ss.android.lark.featuregating.interfaces.IFeatureGatingService
    public final Map<String, Boolean> getUsedFGMap(String r2, String r3) {
        return this.a.getUsedFGMap(r2, r3);
    }

    @Override // com.ss.android.lark.featuregating.interfaces.IFeatureGatingService
    public final boolean isCurrentEnable(String r1, boolean r2) {
        return isCurrentEnable(r1);
    }

    @Override // com.ss.android.lark.featuregating.interfaces.IFeatureGatingService
    public final boolean isEnable(String r1, boolean r2) {
        return isEnable(r1);
    }

    @Override // com.ss.android.lark.featuregating.interfaces.IFeatureGatingService
    public final void notifySettingsFGChanged(Map<String, Boolean> r2, String r3) {
        this.a.notifySettingsFGChanged(r2, r3);
    }

    @Override // com.ss.android.lark.featuregating.interfaces.IFeatureGatingService
    public final void notifySettingsFGNoUserChanged(Map<String, Boolean> r2, String r3) {
        this.a.notifySettingsFGNoUserChanged(r2, r3);
    }

    @Override // com.ss.android.lark.featuregating.interfaces.IFeatureGatingService
    public final void removeFeatureGatingUpdateListener(jdb.c r3, String r4) {
        if (r3 != null) goto L4;
        return;
    L4:
        Map<String, jdb.c> r0 = this.b;
        ConcurrentHashMap r1 = (ConcurrentHashMap) r0;
        jdb.c r5 = (jdb.c) r1.get(r3.toString());
        if (r5 == null) goto L8;
        String r2 = FeatureGatingModule.getDependency().getUserId();
        this.a.Kb(r2, r5, r4);
        return;
    }

    @Override // com.ss.android.lark.featuregating.interfaces.IFeatureGatingService, jdb.g
    public final void addFeatureGatingUpdateListener(String r3, final jdb.c r4, String r5) {
        if (r4 != null) goto L4;
        return;
    L4:
        jdb.c r0 = new e(r4);
        Map<String, jdb.c> r1 = this.b;
        ConcurrentHashMap r2 = (ConcurrentHashMap) r1;
        r2.put(r4.toString(), r0);
        String r6 = FeatureGatingModule.getDependency().getUserId();
        this.a.T(r6, r3, r0, r5);
    }
}
