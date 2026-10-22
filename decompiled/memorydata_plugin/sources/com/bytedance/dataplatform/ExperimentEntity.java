package com.bytedance.dataplatform;

import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes2.dex */
public class ExperimentEntity implements Serializable {
    private com.bytedance.dataplatform.b.a clientDataSource;
    private Object defaultValue;
    private String description;
    private String key;
    private String[] option;
    private Type type;

    public ExperimentEntity(String r3, Type r4, Object r5, String r6, String... r7) {
        Type r8 = (Type) ZeusTransformUtils.wrapperContextForParams(r4, Type.class, "com.obric.memorydata.plugin");
        this.key = r3;
        this.description = r6;
        this.option = r7;
        this.type = r8;
        this.defaultValue = r5;
    }

    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, ExperimentEntity.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (TextUtils.equals(this.key, ((ExperimentEntity) ZeusTransformUtils.preCheckCast(r3, ExperimentEntity.class, "com.obric.memorydata.plugin")).key) == false) goto L7;
        return true;
    }

    public com.bytedance.dataplatform.b.a getClientDataSource() {
        return this.clientDataSource;
    }

    public Object getDefaultValue() {
        return this.defaultValue;
    }

    public String getDescription() {
        return this.description;
    }

    public String getKey() {
        return this.key;
    }

    public String[] getOption() {
        return this.option;
    }

    public Type getType() {
        return this.type;
    }

    public int hashCode() {
        if (TextUtils.isEmpty(this.key) == false) goto L6;
        return 0;
    L6:
        return this.key.hashCode();
    }

    public ExperimentEntity withClientDataSource(com.bytedance.dataplatform.b.a r1) {
        this.clientDataSource = r1;
        return this;
    }
}
