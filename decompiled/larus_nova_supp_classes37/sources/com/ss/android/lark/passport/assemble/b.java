package com.ss.android.lark.passport.assemble;

import com.ss.android.lark.passport.signinsdk_api.entity.EnvConst$GEO;
import com.ss.android.lark.passport.signinsdk_api.entity.EnvConst$UNIT;
import com.ss.android.lark.passport.signinsdk_api.env.EnvironmentType;
import com.ss.android.lark.utils.ApiUtils;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Singleton
public final class b implements izb.a {
    @Inject
    public b() {
    }

    @Override // izb.a
    public final Pair<EnvironmentType, String> a() {
        int r1 = ((gpb.a) ApiUtils.getApi(gpb.a.class)).envType();
        if (r1 != 1) goto L5;
        EnvironmentType r2 = EnvironmentType.RELEASE;
    L13:
        return new Pair(r2, ((gpb.a) ApiUtils.getApi(gpb.a.class)).getUserUnit());
    L5:
        if (r1 != 2) goto L7;
        r2 = EnvironmentType.STAGING;
        goto L13
    L7:
        if (r1 == 3) goto L9;
        r2 = EnvironmentType.RELEASE;
        goto L13
    L9:
        r2 = EnvironmentType.PRE_RELEASE;
        goto L13
    }

    @Override // izb.a
    public final String b(String r3) {
        Intrinsics.checkNotNullParameter(r3, "unit");
        izb.a.a.getClass();
        Intrinsics.checkNotNullParameter(r3, "unit");
        switch(r3.hashCode()) {
            case 93912099: goto L26;
            case 93912675: goto L22;
            case 96855691: goto L18;
            case 96855972: goto L14;
            case 878174793: goto L10;
            case 886218363: goto L6;
            default: goto L29;
        };
    L29:
        String r0 = null;
    L30:
        if (r0 != null) goto L33;
        return r3;
    L33:
        return r0;
    L6:
        if (r3.equals("larksgaws") == false) goto L29;
        r0 = EnvConst$GEO.SG;
        goto L30
    L10:
        if (r3.equals("larkjpaws") == false) goto L29;
        r0 = EnvConst$GEO.JP;
        goto L30
    L14:
        if (r3.equals("eu_nc") == false) goto L29;
        r0 = EnvConst$GEO.CN;
        goto L30
    L18:
        if (r3.equals("eu_ea") == false) goto L29;
        r0 = EnvConst$GEO.US;
        goto L30
    L22:
        if (r3.equals(EnvConst$UNIT.BOE_VA) == false) goto L29;
        r0 = EnvConst$GEO.BOE_US;
        goto L30
    L26:
        if (r3.equals(EnvConst$UNIT.BOE_CN) == false) goto L29;
        r0 = EnvConst$GEO.BOE_CN;
        goto L30
    }
}
