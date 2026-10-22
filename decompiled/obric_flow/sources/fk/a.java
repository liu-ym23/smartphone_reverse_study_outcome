package fk;

import com.bytedance.vmsdk.jsbridge.utils.ReadableArray;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMap;
import com.bytedance.vmsdk.jsbridge.utils.ReadableType;

/* JADX INFO: loaded from: classes2.dex */
public interface a {
    ReadableArray asArray();

    boolean asBoolean();

    double asDouble();

    ReadableMap asMap();

    String asString();

    ReadableType getType();
}
