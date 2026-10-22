package df;

import com.bytedance.geckox.GeckoGlobalConfig;

/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f16653a = null;

    static {
        int[] r5 = new int[GeckoGlobalConfig.ENVType.values().length];
        f16653a = r5;
        r5[GeckoGlobalConfig.ENVType.DEV.ordinal()] = 1;
        r5[GeckoGlobalConfig.ENVType.PROD.ordinal()] = 2;
        r5[GeckoGlobalConfig.ENVType.BOE.ordinal()] = 3;
    }
}
