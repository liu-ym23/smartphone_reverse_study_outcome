package net.zetetic.database.sqlcipher;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public final class SQLiteCustomFunction {
    public final SQLiteDatabase.CustomFunction callback;
    public final String name;
    public final int numArgs;

    public SQLiteCustomFunction(String r3, int r4, SQLiteDatabase.CustomFunction r5) {
        SQLiteDatabase.CustomFunction r6 = (SQLiteDatabase.CustomFunction) ZeusTransformUtils.wrapperContextForParams(r5, SQLiteDatabase.CustomFunction.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L7;
        this.name = r3;
        this.numArgs = r4;
        this.callback = r6;
        return;
    L7:
        throw new IllegalArgumentException("name must not be null.");
    }

    private void dispatchCallback(String[] r1) {
        this.callback.callback(r1);
    }
}
