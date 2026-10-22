package com.ss.ugc.effectplatform.bridge.jsonconverter;

import com.ss.ugc.effectplatform.bridge.network.ByteReadStream;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J)\u0010\u0002\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0007H&¢\u0006\u0002\u0010\bJ)\u0010\u0002\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u00032\u0006\u0010\t\u001a\u00020\n2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0007H&¢\u0006\u0002\u0010\u000bJ\u001d\u0010\f\u001a\u0004\u0018\u00010\n\"\u0004\b\u0000\u0010\u00032\u0006\u0010\r\u001a\u0002H\u0003H&¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/ss/ugc/effectplatform/bridge/jsonconverter/IAndroidJsonConverter;", "", "convertJsonToObj", "T", "stream", "Lcom/ss/ugc/effectplatform/bridge/network/ByteReadStream;", "cls", "Ljava/lang/Class;", "(Lcom/ss/ugc/effectplatform/bridge/network/ByteReadStream;Ljava/lang/Class;)Ljava/lang/Object;", "json", "", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "convertObjToJson", "object", "(Ljava/lang/Object;)Ljava/lang/String;", "effect_bridge_release"}, k = 1, mv = {1, 1, 16})
public interface IAndroidJsonConverter {
    <T> T convertJsonToObj(ByteReadStream r1, Class<T> r2);

    <T> T convertJsonToObj(String r1, Class<T> r2);

    <T> String convertObjToJson(T r1);
}
