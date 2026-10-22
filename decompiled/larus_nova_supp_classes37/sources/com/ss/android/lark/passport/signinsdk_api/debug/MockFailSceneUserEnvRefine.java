package com.ss.android.lark.passport.signinsdk_api.debug;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum MockFailSceneUserEnvRefine extends Enum<MockFailSceneUserEnvRefine> {
    public static final MockFailSceneUserEnvRefine CrossEnvSecond = null;
    public static final MockFailSceneUserEnvRefine NORMAL = null;
    public static final /* synthetic */ MockFailSceneUserEnvRefine[] a = null;

    static {
        MockFailSceneUserEnvRefine r0 = new MockFailSceneUserEnvRefine("NORMAL", 0);
        NORMAL = r0;
        MockFailSceneUserEnvRefine r1 = new MockFailSceneUserEnvRefine("CrossEnvSecond", 1);
        CrossEnvSecond = r1;
        a = new MockFailSceneUserEnvRefine[]{r0, r1};
    }

    public static MockFailSceneUserEnvRefine[] values() {
        return (MockFailSceneUserEnvRefine[]) a.clone();
    }

    public static MockFailSceneUserEnvRefine valueOf(String r1) {
        return (MockFailSceneUserEnvRefine) a.a(MockFailSceneUserEnvRefine.class, r1);
    }

    public MockFailSceneUserEnvRefine(String r1, int r2) {
        super(r1, r2);
    }
}
