package com.ss.android.lark.featuregating.interfaces;

import java.util.Map;
import java.util.Set;
import jdb.c;
import jdb.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface IFeatureGatingService extends g {
    @Override // jdb.g
    void addFeatureGatingUpdateListener(String r1, c r2, String r3);

    /* synthetic */ Set<String> allFg(String r1);

    void clear();

    Map<String, String> getChangedKeysBySyncUpdate(String r1, Map<String, String> r2);

    Set<String> getRuntimeFGSPCache(String r1, String r2);

    Set<String> getSettingsFGKeys();

    Map<String, Boolean> getUsedFGMap(String r1, String r2);

    /* synthetic */ boolean isCrossUserEnable(String r1);

    @Override // jdb.g
    boolean isCurrentEnable(String r1);

    boolean isCurrentEnable(String r1, boolean r2);

    @Override // jdb.g
    boolean isEnable(String r1);

    boolean isEnable(String r1, boolean r2);

    boolean isNoUserFGEnable(String r1);

    boolean isUserFGEnable(String r1);

    void notifySettingsFGChanged(Map<String, Boolean> r1, String r2);

    void notifySettingsFGNoUserChanged(Map<String, Boolean> r1, String r2);

    void reload();

    void removeFeatureGatingUpdateListener(c r1, String r2);
}
