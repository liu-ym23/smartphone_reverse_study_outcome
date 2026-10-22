package com.obric.aee.utils;

import com.obric.aikernel.sdk.ext.Params;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/obric/aee/utils/PythonObject;", "", "type", "", Params.CONTENT, "(Ljava/lang/String;Ljava/lang/String;)V", "data", "Lorg/json/JSONObject;", "getData", "()Lorg/json/JSONObject;", "getType", "()Ljava/lang/String;", "Aee_cryptLiteRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PythonObject {
    private final JSONObject data;
    private final String type;

    public PythonObject(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, Params.CONTENT);
        this.type = r2;
        this.data = new JSONObject(r3);
    }

    public final JSONObject getData() {
        return this.data;
    }

    public final String getType() {
        return this.type;
    }
}
