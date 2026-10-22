package jdb;

import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface e {
    boolean B0(String r1, String r2);

    void Kb(String r1, c r2, String r3);

    void T(String r1, String r2, c r3, String r4);

    void Tc(String r1, boolean r2);

    void U1();

    void Y9();

    Set<String> allFg(String r1);

    Map<String, String> getChangedKeysBySyncUpdate(String r1, Map<String, String> r2);

    Set<String> getRuntimeFGSPCache(String r1, String r2);

    Set<String> getSettingsFGKeys();

    Map<String, Boolean> getUsedFGMap(String r1, String r2);

    void init();

    boolean isNoUserFGEnable(String r1);

    void notifySettingsFGChanged(Map<String, Boolean> r1, String r2);

    void notifySettingsFGNoUserChanged(Map<String, Boolean> r1, String r2);

    boolean tb(String r1, String r2);

    boolean x(String r1, String r2);
}
