package pm;

import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableType;

/* JADX INFO: loaded from: classes2.dex */
public interface a {
    ReadableArray asArray();

    boolean asBoolean();

    double asDouble();

    int asInt();

    long asLong();

    ReadableMap asMap();

    String asString();

    ReadableType getType();
}
