package com.squareup.wire;

import android.util.Pair;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import java.util.HashMap;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes3.dex */
public final class WireTypeAdapterFactory implements TypeAdapterFactory {
    private final Map<Class, Pair<Message, WireDeserializeErrorListener>> defaultValue;

    public WireTypeAdapterFactory() {
        this.defaultValue = new HashMap();
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson r10, TypeToken<T> r11) {
        Class<? super T> r5 = r11.getRawType();
        if (r5.equals(ByteString.class) == true) goto L5;
        Pair<Message, WireDeserializeErrorListener> r12 = this.defaultValue.get(r5);
        if (r12 == null) goto L11;
        return new DefaultValueMessageTypeAdapter(r10, r11, "", (Message) r12.first, (WireDeserializeErrorListener) r12.second);
    L11:
        if (Message.class.isAssignableFrom(r5) == true) goto L13;
        return null;
    L13:
        return new MessageTypeAdapter(r10, r11);
    L5:
        return new ByteStringTypeAdapter();
    }

    public void registerDefaultValue(Message r5, WireDeserializeErrorListener r10) {
        this.defaultValue.put(r5.getClass(), new Pair(r5, r10));
    }
}
