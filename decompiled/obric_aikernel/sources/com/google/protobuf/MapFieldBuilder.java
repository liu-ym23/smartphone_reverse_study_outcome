package com.google.protobuf;

import com.google.protobuf.MessageOrBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class MapFieldBuilder<KeyT, MessageOrBuilderT extends MessageOrBuilder, MessageT extends MessageOrBuilderT, BuilderT extends MessageOrBuilderT> extends MapFieldReflectionAccessor {
    Map<KeyT, MessageOrBuilderT> builderMap;
    Converter<KeyT, MessageOrBuilderT, MessageT> converter;
    List<Message> messageList;
    Map<KeyT, MessageT> messageMap;

    public interface Converter<KeyT, MessageOrBuilderT extends MessageOrBuilder, MessageT extends MessageOrBuilderT> {
        /* JADX WARN: Incorrect return type in method signature: (TMessageOrBuilderT;)TMessageT; */
        MessageOrBuilder build(MessageOrBuilder r10);

        MapEntry<KeyT, MessageT> defaultEntry();
    }

    public MapFieldBuilder(Converter<KeyT, MessageOrBuilderT, MessageT> r10) {
        this.builderMap = new LinkedHashMap();
        this.messageMap = null;
        this.messageList = null;
        this.converter = r10;
    }

    private List<MapEntry<KeyT, MessageT>> getMapEntryList() {
        ArrayList r10 = new ArrayList(this.messageList.size());
        Class<?> r11 = ((MessageOrBuilder) this.converter.defaultEntry().getValue()).getClass();
        Iterator<Message> r12 = this.messageList.iterator();
    L4:
        if (r12.hasNext() == false) goto L9;
        Message r13 = r12.next();
        MapEntry r14 = (MapEntry) r13;
        if (r11.isInstance(r14.getValue()) == true) goto L7;
        r10.add(this.converter.defaultEntry().toBuilder().mergeFrom(r13).build());
        goto L4
    L7:
        r10.add(r14);
        goto L4
    L9:
        return r10;
    }

    private Map<KeyT, MessageT> populateMutableMap() {
        Map<KeyT, MessageT> r10 = this.messageMap;
        if (r10 == null) goto L6;
        return r10;
    L6:
        if (this.builderMap == null) goto L12;
        LinkedHashMap r11 = new LinkedHashMap(this.builderMap.size());
        Iterator<Map.Entry<KeyT, MessageOrBuilderT>> r12 = this.builderMap.entrySet().iterator();
    L9:
        if (r12.hasNext() == false) goto L11;
        Map.Entry<KeyT, MessageOrBuilderT> r13 = r12.next();
        r11.put(r13.getKey(), this.converter.build(r13.getValue()));
        goto L9
    L11:
        return r11;
    L12:
        LinkedHashMap r14 = new LinkedHashMap(this.messageList.size());
        Iterator<MapEntry<KeyT, MessageT>> r15 = getMapEntryList().iterator();
    L14:
        if (r15.hasNext() == false) goto L16;
        MapEntry<KeyT, MessageT> r16 = r15.next();
        r14.put(r16.getKey(), (MessageOrBuilder) r16.getValue());
        goto L14
    L16:
        return r14;
    }

    private boolean typedEquals(MapFieldBuilder<KeyT, MessageOrBuilderT, MessageT, BuilderT> r10) {
        return MapFieldLite.equals(ensureBuilderMap(), r10.ensureBuilderMap());
    }

    public MapField<KeyT, MessageT> build(MapEntry<KeyT, MessageT> r10) {
        MapField<KeyT, MessageT> r11 = MapField.newMapField(r10);
        Map<KeyT, MessageT> r12 = r11.getMutableMap();
        Iterator<Map.Entry<KeyT, MessageOrBuilderT>> r13 = ensureBuilderMap().entrySet().iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        Map.Entry<KeyT, MessageOrBuilderT> r14 = r13.next();
        r12.put(r14.getKey(), this.converter.build(r14.getValue()));
        goto L4
    L6:
        r11.makeImmutable();
        return r11;
    }

    public void clear() {
        this.builderMap = new LinkedHashMap();
        this.messageMap = null;
        this.messageList = null;
    }

    public MapFieldBuilder<KeyT, MessageOrBuilderT, MessageT, BuilderT> copy() {
        MapFieldBuilder<KeyT, MessageOrBuilderT, MessageT, BuilderT> r10 = new MapFieldBuilder(this.converter);
        r10.ensureBuilderMap().putAll(ensureBuilderMap());
        return r10;
    }

    public Map<KeyT, MessageOrBuilderT> ensureBuilderMap() {
        Map<KeyT, MessageOrBuilderT> r10 = this.builderMap;
        if (r10 == null) goto L6;
        return r10;
    L6:
        if (this.messageMap == null) goto L14;
        this.builderMap = new LinkedHashMap(this.messageMap.size());
        Iterator<Map.Entry<KeyT, MessageT>> r11 = this.messageMap.entrySet().iterator();
    L9:
        if (r11.hasNext() == false) goto L11;
        Map.Entry<KeyT, MessageT> r12 = r11.next();
        this.builderMap.put(r12.getKey(), (MessageOrBuilderT) ((MessageOrBuilder) r12.getValue()));
        goto L9
    L11:
        this.messageMap = null;
    L13:
        return this.builderMap;
    L14:
        this.builderMap = new LinkedHashMap(this.messageList.size());
        Iterator<MapEntry<KeyT, MessageT>> r13 = getMapEntryList().iterator();
    L16:
        if (r13.hasNext() == false) goto L18;
        MapEntry<KeyT, MessageT> r14 = r13.next();
        this.builderMap.put(r14.getKey(), (MessageOrBuilderT) ((MessageOrBuilder) r14.getValue()));
        goto L16
    L18:
        this.messageList = null;
        goto L13
    }

    public List<Message> ensureMessageList() {
        List<Message> r10 = this.messageList;
        if (r10 == null) goto L6;
        return r10;
    L6:
        if (this.builderMap == null) goto L14;
        this.messageList = new ArrayList(this.builderMap.size());
        Iterator<Map.Entry<KeyT, MessageOrBuilderT>> r11 = this.builderMap.entrySet().iterator();
    L9:
        if (r11.hasNext() == false) goto L11;
        Map.Entry<KeyT, MessageOrBuilderT> r12 = r11.next();
        this.messageList.add(this.converter.defaultEntry().toBuilder().setKey(r12.getKey()).setValue(this.converter.build(r12.getValue())).build());
        goto L9
    L11:
        this.builderMap = null;
    L13:
        return this.messageList;
    L14:
        this.messageList = new ArrayList(this.messageMap.size());
        Iterator<Map.Entry<KeyT, MessageT>> r13 = this.messageMap.entrySet().iterator();
    L16:
        if (r13.hasNext() == false) goto L18;
        Map.Entry<KeyT, MessageT> r14 = r13.next();
        this.messageList.add(this.converter.defaultEntry().toBuilder().setKey(r14.getKey()).setValue((MessageOrBuilder) r14.getValue()).build());
        goto L16
    L18:
        this.messageMap = null;
        goto L13
    }

    public Map<KeyT, MessageT> ensureMessageMap() {
        Map<KeyT, MessageT> r10 = populateMutableMap();
        this.messageMap = r10;
        this.builderMap = null;
        this.messageList = null;
        return r10;
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof MapFieldBuilder) == true) goto L7;
        return false;
    L7:
        return typedEquals((MapFieldBuilder) r10);
    }

    public Map<KeyT, MessageT> getImmutableMap() {
        return new MapField.MutabilityAwareMap(MutabilityOracle.IMMUTABLE, populateMutableMap());
    }

    @Override // com.google.protobuf.MapFieldReflectionAccessor
    List<Message> getList() {
        return ensureMessageList();
    }

    @Override // com.google.protobuf.MapFieldReflectionAccessor
    Message getMapEntryMessageDefaultInstance() {
        return this.converter.defaultEntry();
    }

    @Override // com.google.protobuf.MapFieldReflectionAccessor
    List<Message> getMutableList() {
        return ensureMessageList();
    }

    public int hashCode() {
        return MapFieldLite.calculateHashCodeForMap(ensureBuilderMap());
    }

    public void mergeFrom(MapField<KeyT, MessageT> r10) {
        ensureBuilderMap().putAll(MapFieldLite.copy(r10.getMap()));
    }
}
