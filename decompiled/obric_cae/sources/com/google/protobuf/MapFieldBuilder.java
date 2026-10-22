package com.google.protobuf;

import com.google.protobuf.MessageOrBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class MapFieldBuilder<KeyT, MessageOrBuilderT extends MessageOrBuilder, MessageT extends MessageOrBuilderT, BuilderT extends MessageOrBuilderT> extends MapFieldReflectionAccessor {
    Map<KeyT, MessageOrBuilderT> builderMap;
    Converter<KeyT, MessageOrBuilderT, MessageT> converter;
    List<Message> messageList;
    Map<KeyT, MessageT> messageMap;

    public interface Converter<KeyT, MessageOrBuilderT extends MessageOrBuilder, MessageT extends MessageOrBuilderT> {
        /* JADX WARN: Incorrect return type in method signature: (TMessageOrBuilderT;)TMessageT; */
        MessageOrBuilder build(MessageOrBuilder r8);

        MapEntry<KeyT, MessageT> defaultEntry();
    }

    public MapFieldBuilder(Converter<KeyT, MessageOrBuilderT, MessageT> r8) {
        this.builderMap = new LinkedHashMap();
        this.messageMap = null;
        this.messageList = null;
        this.converter = r8;
    }

    private List<MapEntry<KeyT, MessageT>> getMapEntryList() {
        ArrayList r8 = new ArrayList(this.messageList.size());
        Class<?> r10 = ((MessageOrBuilder) this.converter.defaultEntry().getValue()).getClass();
        Iterator<Message> r11 = this.messageList.iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        Message r12 = r11.next();
        MapEntry r13 = (MapEntry) r12;
        if (r10.isInstance(r13.getValue()) == true) goto L7;
        r8.add(this.converter.defaultEntry().toBuilder().mergeFrom(r12).build());
        goto L4
    L7:
        r8.add(r13);
        goto L4
    L9:
        return r8;
    }

    private Map<KeyT, MessageT> populateMutableMap() {
        Map<KeyT, MessageT> r8 = this.messageMap;
        if (r8 == null) goto L6;
        return r8;
    L6:
        if (this.builderMap == null) goto L12;
        LinkedHashMap r10 = new LinkedHashMap(this.builderMap.size());
        Iterator<Map.Entry<KeyT, MessageOrBuilderT>> r11 = this.builderMap.entrySet().iterator();
    L9:
        if (r11.hasNext() == false) goto L11;
        Map.Entry<KeyT, MessageOrBuilderT> r12 = r11.next();
        r10.put(r12.getKey(), this.converter.build(r12.getValue()));
        goto L9
    L11:
        return r10;
    L12:
        LinkedHashMap r13 = new LinkedHashMap(this.messageList.size());
        Iterator<MapEntry<KeyT, MessageT>> r14 = getMapEntryList().iterator();
    L14:
        if (r14.hasNext() == false) goto L16;
        MapEntry<KeyT, MessageT> r15 = r14.next();
        r13.put(r15.getKey(), (MessageOrBuilder) r15.getValue());
        goto L14
    L16:
        return r13;
    }

    private boolean typedEquals(MapFieldBuilder<KeyT, MessageOrBuilderT, MessageT, BuilderT> r8) {
        return MapFieldLite.equals(ensureBuilderMap(), r8.ensureBuilderMap());
    }

    public MapField<KeyT, MessageT> build(MapEntry<KeyT, MessageT> r8) {
        MapField<KeyT, MessageT> r10 = MapField.newMapField(r8);
        Map<KeyT, MessageT> r11 = r10.getMutableMap();
        Iterator<Map.Entry<KeyT, MessageOrBuilderT>> r12 = ensureBuilderMap().entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        Map.Entry<KeyT, MessageOrBuilderT> r13 = r12.next();
        r11.put(r13.getKey(), this.converter.build(r13.getValue()));
        goto L4
    L6:
        r10.makeImmutable();
        return r10;
    }

    public void clear() {
        this.builderMap = new LinkedHashMap();
        this.messageMap = null;
        this.messageList = null;
    }

    public MapFieldBuilder<KeyT, MessageOrBuilderT, MessageT, BuilderT> copy() {
        MapFieldBuilder<KeyT, MessageOrBuilderT, MessageT, BuilderT> r8 = new MapFieldBuilder(this.converter);
        r8.ensureBuilderMap().putAll(ensureBuilderMap());
        return r8;
    }

    public Map<KeyT, MessageOrBuilderT> ensureBuilderMap() {
        Map<KeyT, MessageOrBuilderT> r8 = this.builderMap;
        if (r8 == null) goto L6;
        return r8;
    L6:
        if (this.messageMap == null) goto L14;
        this.builderMap = new LinkedHashMap(this.messageMap.size());
        Iterator<Map.Entry<KeyT, MessageT>> r10 = this.messageMap.entrySet().iterator();
    L9:
        if (r10.hasNext() == false) goto L11;
        Map.Entry<KeyT, MessageT> r11 = r10.next();
        this.builderMap.put(r11.getKey(), (MessageOrBuilderT) ((MessageOrBuilder) r11.getValue()));
        goto L9
    L11:
        this.messageMap = null;
    L13:
        return this.builderMap;
    L14:
        this.builderMap = new LinkedHashMap(this.messageList.size());
        Iterator<MapEntry<KeyT, MessageT>> r12 = getMapEntryList().iterator();
    L16:
        if (r12.hasNext() == false) goto L18;
        MapEntry<KeyT, MessageT> r13 = r12.next();
        this.builderMap.put(r13.getKey(), (MessageOrBuilderT) ((MessageOrBuilder) r13.getValue()));
        goto L16
    L18:
        this.messageList = null;
        goto L13
    }

    public List<Message> ensureMessageList() {
        List<Message> r8 = this.messageList;
        if (r8 == null) goto L6;
        return r8;
    L6:
        if (this.builderMap == null) goto L14;
        this.messageList = new ArrayList(this.builderMap.size());
        Iterator<Map.Entry<KeyT, MessageOrBuilderT>> r10 = this.builderMap.entrySet().iterator();
    L9:
        if (r10.hasNext() == false) goto L11;
        Map.Entry<KeyT, MessageOrBuilderT> r11 = r10.next();
        this.messageList.add(this.converter.defaultEntry().toBuilder().setKey(r11.getKey()).setValue(this.converter.build(r11.getValue())).build());
        goto L9
    L11:
        this.builderMap = null;
    L13:
        return this.messageList;
    L14:
        this.messageList = new ArrayList(this.messageMap.size());
        Iterator<Map.Entry<KeyT, MessageT>> r12 = this.messageMap.entrySet().iterator();
    L16:
        if (r12.hasNext() == false) goto L18;
        Map.Entry<KeyT, MessageT> r13 = r12.next();
        this.messageList.add(this.converter.defaultEntry().toBuilder().setKey(r13.getKey()).setValue((MessageOrBuilder) r13.getValue()).build());
        goto L16
    L18:
        this.messageMap = null;
        goto L13
    }

    public Map<KeyT, MessageT> ensureMessageMap() {
        Map<KeyT, MessageT> r8 = populateMutableMap();
        this.messageMap = r8;
        this.builderMap = null;
        this.messageList = null;
        return r8;
    }

    public boolean equals(Object r8) {
        if ((r8 instanceof MapFieldBuilder) == true) goto L7;
        return false;
    L7:
        return typedEquals((MapFieldBuilder) r8);
    }

    public Map<KeyT, MessageT> getImmutableMap() {
        return new MapField.MutabilityAwareMap(MutabilityOracle.IMMUTABLE, populateMutableMap());
    }

    @Override // com.google.protobuf.MapFieldReflectionAccessor
    public List<Message> getList() {
        return ensureMessageList();
    }

    @Override // com.google.protobuf.MapFieldReflectionAccessor
    public Message getMapEntryMessageDefaultInstance() {
        return this.converter.defaultEntry();
    }

    @Override // com.google.protobuf.MapFieldReflectionAccessor
    public List<Message> getMutableList() {
        return ensureMessageList();
    }

    public int hashCode() {
        return MapFieldLite.calculateHashCodeForMap(ensureBuilderMap());
    }

    public void mergeFrom(MapField<KeyT, MessageT> r8) {
        ensureBuilderMap().putAll(MapFieldLite.copy(r8.getMap()));
    }
}
