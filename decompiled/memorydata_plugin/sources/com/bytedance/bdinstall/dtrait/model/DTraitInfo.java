package com.bytedance.bdinstall.dtrait.model;

import com.bytedance.bdinstall.dtrait.DTLog;
import com.bytedance.bdinstall.dtrait.constant.DTraitConstant;
import com.bytedance.bdinstall.dtrait.constant.DTraitRiskType;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class DTraitInfo {
    private final boolean bindDTrait;
    private final String dtraitHK;
    private final String dtraitLK;
    private final String dtraitPK1Version;
    private final String dtraitPK2Version;
    private final String dtraitToken;
    private final String dtraitVersion;
    private final Map<String, String> map;

    /* JADX INFO: renamed from: com.bytedance.bdinstall.dtrait.model.DTraitInfo$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$bdinstall$dtrait$constant$DTraitRiskType = null;

        static {
            int[] r0 = new int[DTraitRiskType.values().length];
            $SwitchMap$com$bytedance$bdinstall$dtrait$constant$DTraitRiskType = r0;
            r0[DTraitRiskType.HIGH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$bytedance$bdinstall$dtrait$constant$DTraitRiskType[DTraitRiskType.LOW.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public DTraitInfo(String r1, String r2, String r3, String r4, String r5, String r6, boolean r7) {
        this.dtraitHK = r1;
        this.dtraitLK = r2;
        this.dtraitPK1Version = r3;
        this.dtraitPK2Version = r4;
        this.dtraitToken = r5;
        this.dtraitVersion = r6;
        this.bindDTrait = r7;
        this.map = new HashMap();
        if (DTLog.debug() == false) goto L6;
        DTLog.d("[dt] DTraitInfo# " + toString());
        return;
    }

    public Map<String, String> getCacheMap() {
        this.map.put(DTraitConstant.KEY_DTRAIT_PK1, this.dtraitHK);
        this.map.put(DTraitConstant.KEY_DTRAIT_PK2, this.dtraitLK);
        this.map.put(DTraitConstant.KEY_DTRAIT_PK1_VERSION, this.dtraitPK1Version);
        this.map.put(DTraitConstant.KEY_DTRAIT_PK2_VERSION, this.dtraitPK2Version);
        this.map.put(DTraitConstant.KEY_DTRAIT_VERSION, String.valueOf(this.dtraitVersion));
        this.map.put(DTraitConstant.KEY_DTRAIT_TOKEN, this.dtraitToken);
        return this.map;
    }

    public String getDTraitHK() {
        return this.dtraitHK;
    }

    public String getDTraitLK() {
        return this.dtraitLK;
    }

    public String getDTraitToken() {
        return this.dtraitToken;
    }

    public String getDTraitVersion() {
        return String.valueOf(this.dtraitVersion);
    }

    public String getDtraitPK1Version() {
        return this.dtraitPK1Version;
    }

    public String getDtraitPK2Version() {
        return this.dtraitPK2Version;
    }

    public String getPKVersionByType(DTraitRiskType r2) {
        int r3 = AnonymousClass1.$SwitchMap$com$bytedance$bdinstall$dtrait$constant$DTraitRiskType[r2.ordinal()];
        if (r3 == 1) goto L11;
        if (r3 == 2) goto L9;
        return "";
    L9:
        return this.dtraitPK2Version;
    L11:
        return this.dtraitPK1Version;
    }

    public boolean isBindDTrait() {
        return this.bindDTrait;
    }

    public String toString() {
        return "DTraitInfo{dtraitHK='" + this.dtraitHK + "', dtraitLK='" + this.dtraitLK + "', dtraitToken='" + this.dtraitToken + "', dtraitVersion='" + this.dtraitVersion + "', dtraitPK1Version='" + this.dtraitPK1Version + "', dtraitPK2Version='" + this.dtraitPK2Version + "', bindDTrait=" + this.bindDTrait + '}';
    }
}
