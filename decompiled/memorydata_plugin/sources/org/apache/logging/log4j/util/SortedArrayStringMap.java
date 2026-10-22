package org.apache.logging.log4j.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import org.apache.logging.log4j.status.StatusLogger;

/* JADX INFO: loaded from: classes6.dex */
public class SortedArrayStringMap implements IndexedStringMap {
    private static final int DEFAULT_INITIAL_CAPACITY = 4;
    private static final String[] EMPTY = null;
    private static final String FROZEN = "Frozen collection cannot be modified";
    private static final int HASHVAL = 31;
    private static final u<String, Object, StringMap> PUT_ALL = null;
    private static final Method getObjectInputFilter = null;
    private static final Method newObjectInputFilter = null;
    private static final long serialVersionUID = -5748905872274478116L;
    private static final Method setObjectInputFilter = null;
    private boolean immutable;
    private transient boolean iterating;
    private transient String[] keys;
    private transient int size;
    private int threshold;
    private transient Object[] values;

    static {
        PUT_ALL = $$Lambda$SortedArrayStringMap$c3emZVLlvVUCuKLFM2zYFgQ8y8.INSTANCE;
        EMPTY = s.f17940a;
        Method[] r0 = ObjectInputStream.class.getMethods();
        int r1 = r0.length;
        int r2 = 0;
        Method r3 = null;
        int r4 = 0;
        Method r5 = null;
        Method r6 = null;
    L3:
        if (r4 >= r1) goto L11;
        Method r7 = r0[r4];
        if (r7.getName().equals("setObjectInputFilter") == false) goto L8;
        r5 = r7;
    L10:
        r4 = r4 + 1;
        goto L3
    L8:
        if (r7.getName().equals("getObjectInputFilter") == false) goto L10;
        r6 = r7;
        goto L10
    L11:
        if (r5 != null) goto L23;
    L20:
        newObjectInputFilter = r3;
        setObjectInputFilter = r5;
        getObjectInputFilter = r6;
        return;
    L23:
        Method[] r8 = ZeusTransformUtils.forName("org.apache.logging.log4j.util.internal.DefaultObjectInputFilter", "com.obric.memorydata.plugin").getMethods();     // Catch: ClassNotFoundException -> L22
        int r9 = r8.length;     // Catch: ClassNotFoundException -> L22
    L13:
        if (r2 >= r9) goto L20;
        Method r10 = r8[r2];     // Catch: ClassNotFoundException -> L22
        if (r10.getName().equals("newInstance") == false) goto L19;
        if (Modifier.isStatic(r10.getModifiers()) == false) goto L19;
        r3 = r10;
    L19:
        r2 = r2 + 1;
        goto L13
    }

    public SortedArrayStringMap() {
        this(4);
    }

    public SortedArrayStringMap(int r3) {
        String[] r0 = EMPTY;
        this.keys = r0;
        this.values = r0;
        if (r3 < 0) goto L9;
        if (r3 != 0) goto L6;
        r3 = 1;
    L6:
        this.threshold = ceilingNextPowerOfTwo(r3);
        return;
    L9:
        throw new IllegalArgumentException("Initial capacity must be at least zero but was " + r3);
    }

    public SortedArrayStringMap(Map<String, ?> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        String[] r0 = EMPTY;
        this.keys = r0;
        this.values = r0;
        resize(ceilingNextPowerOfTwo(r6.size()));
        Iterator r7 = r6.entrySet().iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        putValue(Objects.toString(r1.getKey(), null), r1.getValue());
        goto L4
    }

    public SortedArrayStringMap(ReadOnlyStringMap r4) {
        ReadOnlyStringMap r5 = (ReadOnlyStringMap) ZeusTransformUtils.wrapperContextForParams(r4, ReadOnlyStringMap.class, "com.obric.memorydata.plugin");
        String[] r1 = EMPTY;
        this.keys = r1;
        this.values = r1;
        if (ZeusTransformUtils.instanceOf(r5, SortedArrayStringMap.class) == false) goto L5;
        initFrom0((SortedArrayStringMap) ZeusTransformUtils.preCheckCast(r5, SortedArrayStringMap.class, "com.obric.memorydata.plugin"));
        return;
    L5:
        if (r5 == null) goto L9;
        resize(ceilingNextPowerOfTwo(r5.size()));
        r5.forEach(PUT_ALL, this);
        return;
    }

    private void assertNoConcurrentModification() {
        if (this.iterating == true) goto L6;
        return;
    L6:
        throw new ConcurrentModificationException();
    }

    private void assertNotFrozen() {
        if (this.immutable == true) goto L6;
        return;
    L6:
        throw new UnsupportedOperationException(FROZEN);
    }

    private static int ceilingNextPowerOfTwo(int r1) {
        return 1 << (32 - Integer.numberOfLeadingZeros(r1 - 1));
    }

    private void ensureCapacity() {
        int r0 = this.size;
        int r1 = this.threshold;
        if (r0 < r1) goto L6;
        resize(r1 * 2);
        return;
    }

    private void handleSerializationException(Throwable r2, int r3, String r4) {
        StatusLogger.getLogger().warn("Ignoring {} for key[{}] ('{}')", String.valueOf(r2), Integer.valueOf(r3), this.keys[r3]);
    }

    private static int hashCode(Object[] r4, int r5) {
        int r1 = 1;
        int r2 = 0;
    L3:
        if (r2 >= r5) goto L9;
        int r3 = r1 * 31;
        if (r4[r2] != null) goto L7;
        int r6 = 0;
    L8:
        r1 = r3 + r6;
        r2 = r2 + 1;
        goto L3
    L7:
        r6 = r4[r2].hashCode();
        goto L8
    L9:
        return r1;
    }

    private void inflateTable(int r2) {
        this.threshold = r2;
        this.keys = new String[r2];
        this.values = new Object[r2];
    }

    private void initFrom0(SortedArrayStringMap r5) {
        int r0 = this.keys.length;
        int r1 = r5.size;
        if (r0 >= r1) goto L5;
        int r2 = r5.threshold;
        this.keys = new String[r2];
        this.values = new Object[r2];
    L5:
        System.arraycopy(r5.keys, 0, this.keys, 0, r1);
        System.arraycopy(r5.values, 0, this.values, 0, r5.size);
        this.size = r5.size;
        this.threshold = r5.threshold;
    }

    private void insertAt(int r4, String r5, Object r6) {
        ensureCapacity();
        String[] r0 = this.keys;
        int r1 = r4 + 1;
        System.arraycopy(r0, r4, r0, r1, this.size - r4);
        Object[] r2 = this.values;
        System.arraycopy(r2, r4, r2, r1, this.size - r4);
        this.keys[r4] = r5;
        this.values[r4] = r6;
        this.size++;
    }

    static /* synthetic */ void lambda$static$0(String r2, Object r3, StringMap r4) {
        ((StringMap) ZeusTransformUtils.wrapperContextForParams(r4, StringMap.class, "com.obric.memorydata.plugin")).putValue(r2, r3);
    }

    private static byte[] marshall(Object r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        ObjectOutputStream r1 = new ObjectOutputStream(r0);
        r1.writeObject(r2);     // Catch: Throwable -> L9
        r1.flush();     // Catch: Throwable -> L9
        byte[] r3 = r0.toByteArray();     // Catch: Throwable -> L9
        r1.close();
        return r3;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        r1.close();     // Catch: Throwable -> L14
    L16:
        throw th;
    L14:
        th = move-exception;
        th.addSuppressed(th);
        goto L16
    }

    private void merge(SortedArrayStringMap r8) {
        String[] r0 = this.keys;
        Object[] r1 = this.values;
        int r2 = r8.size + this.size;
        int r3 = ceilingNextPowerOfTwo(r2);
        this.threshold = r3;
        if (this.keys.length >= r3) goto L5;
        this.keys = new String[r3];
        this.values = new Object[r3];
    L5:
        boolean r5 = false;
        if (r8.size() <= size()) goto L8;
        System.arraycopy(r0, 0, this.keys, r8.size, this.size);
        System.arraycopy(r1, 0, this.values, r8.size, this.size);
        System.arraycopy(r8.keys, 0, this.keys, 0, r8.size);
        System.arraycopy(r8.values, 0, this.values, 0, r8.size);
        this.size = r8.size;
    L9:
        int r9 = this.size;
    L10:
        if (r9 >= r2) goto L17;
        int r4 = indexOfKey(this.keys[r9]);
        if (r4 >= 0) goto L14;
        insertAt(~r4, this.keys[r9], this.values[r9]);
    L16:
        r9 = r9 + 1;
        goto L10
    L14:
        if (r5 == false) goto L16;
        String[] r6 = this.keys;
        r6[r4] = r6[r9];
        Object[] r7 = this.values;
        r7[r4] = r7[r9];
        goto L16
    L17:
        Arrays.fill(this.keys, this.size, r2, null);
        Arrays.fill(this.values, this.size, r2, null);
        return;
    L8:
        System.arraycopy(r0, 0, this.keys, 0, this.size);
        System.arraycopy(r1, 0, this.values, 0, this.size);
        System.arraycopy(r8.keys, 0, this.keys, this.size, r8.size);
        System.arraycopy(r8.values, 0, this.values, this.size, r8.size);
        r5 = true;
        goto L9
    }

    private int nullKeyIndex() {
        if (this.size > 0) goto L5;
    L7:
        return -1;
    L5:
        if (this.keys[0] != null) goto L7;
        return 0;
    }

    private void readObject(ObjectInputStream r8) {
        if (ZeusTransformUtils.instanceOf(r8, e.class) == false) goto L5;
    L9:
        r8.defaultReadObject();
        String[] r1 = EMPTY;
        this.keys = r1;
        this.values = r1;
        int r2 = r8.readInt();
        if (r2 < 0) goto L33;
        int r3 = r8.readInt();
        if (r3 < 0) goto L31;
        if (r3 <= 0) goto L15;
        inflateTable(r2);
    L16:
        int r4 = 0;
    L17:
        if (r4 >= r3) goto L28;
        this.keys[r4] = (String) ZeusTransformUtils.preCheckCast(r8.readObject(), String.class, "com.obric.memorydata.plugin");
        byte[] r5 = (byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(r8.readObject(), byte[].class, "com.obric.memorydata.plugin"), byte[].class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25
        Object[] r6 = this.values;     // Catch: Throwable -> L25
        if (r5 != null) goto L22;
        Object r7 = null;
    L23:
        r6[r4] = r7;     // Catch: Throwable -> L25
    L27:
        r4 = r4 + 1;
        goto L17
    L22:
        r7 = unmarshall(r5, r8);     // Catch: Throwable -> L25
    L25:
        e = move-exception;
        handleSerializationException(e, r4, this.keys[r4]);
        this.values[r4] = null;
        goto L27
    L28:
        this.size = r3;
        return;
    L15:
        this.threshold = r2;
        goto L16
    L31:
        throw new InvalidObjectException("Illegal mappings count: " + r3);
    L33:
        throw new InvalidObjectException("Illegal capacity: " + r2);
    L5:
        if (setObjectInputFilter != null) goto L9;
        throw new IllegalArgumentException("readObject requires a FilteredObjectInputStream or an ObjectInputStream that accepts an ObjectInputFilter");
    }

    private void resize(int r6) {
        String[] r0 = this.keys;
        Object[] r1 = this.values;
        String[] r2 = new String[r6];
        this.keys = r2;
        this.values = new Object[r6];
        System.arraycopy(r0, 0, r2, 0, this.size);
        System.arraycopy(r1, 0, this.values, 0, this.size);
        this.threshold = r6;
    }

    private static Object unmarshall(byte[] r5, ObjectInputStream r6) {
        ByteArrayInputStream r0 = new ByteArrayInputStream(r5);
        if (ZeusTransformUtils.instanceOf(r6, e.class) == false) goto L14;
        ObjectInputStream r7 = new e(r0, ((e) ZeusTransformUtils.preCheckCast(r6, e.class, "com.obric.memorydata.plugin")).a());
    L16:
        Object r8 = r7.readObject();     // Catch: Throwable -> L9
        r7.close();
        return r8;
    L9:
        th = move-exception;
        r7.close();
        throw th;
    L14:
        Object r9 = getObjectInputFilter.invoke(r6, new Object[0]);     // Catch: Throwable -> L12
        Object r10 = newObjectInputFilter.invoke(null, new Object[]{r9});     // Catch: Throwable -> L12
        r7 = new ObjectInputStream(r0);     // Catch: Throwable -> L12
        setObjectInputFilter.invoke(r7, new Object[]{r10});     // Catch: Throwable -> L12
    L13:
        throw new StreamCorruptedException("Unable to set ObjectInputFilter on stream");
    }

    private void writeObject(ObjectOutputStream r4) {
        r4.defaultWriteObject();
        String[] r0 = this.keys;
        if (r0 != EMPTY) goto L5;
        int r1 = ceilingNextPowerOfTwo(this.threshold);
    L6:
        r4.writeInt(r1);
        r4.writeInt(this.size);
        if (this.size <= 0) goto L17;
        int r2 = 0;
    L10:
        if (r2 >= this.size) goto L23;
        r4.writeObject(this.keys[r2]);
        r4.writeObject(marshall(this.values[r2]));     // Catch: Exception -> L14
    L16:
        r2 = r2 + 1;
    L14:
        e = move-exception;
        handleSerializationException(e, r2, this.keys[r2]);
        r4.writeObject(null);
        goto L16
    L23:
        return;
    L17:
        return;
    L5:
        r1 = r0.length;
        goto L6
    }

    @Override // org.apache.logging.log4j.util.StringMap
    public void clear() {
        if (this.keys != EMPTY) goto L5;
        return;
    L5:
        assertNotFrozen();
        assertNoConcurrentModification();
        Arrays.fill(this.keys, 0, this.size, null);
        Arrays.fill(this.values, 0, this.size, null);
        this.size = 0;
    }

    @Override // org.apache.logging.log4j.util.ReadOnlyStringMap
    public boolean containsKey(String r1) {
        if (indexOfKey(r1) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.apache.logging.log4j.util.StringMap
    public boolean equals(Object r6) {
        if (r6 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r6, SortedArrayStringMap.class) == true) goto L8;
        return false;
    L8:
        SortedArrayStringMap r7 = (SortedArrayStringMap) ZeusTransformUtils.preCheckCast(r6, SortedArrayStringMap.class, "com.obric.memorydata.plugin");
        if (size() == r7.size()) goto L11;
        return false;
    L11:
        int r0 = 0;
    L13:
        if (r0 >= size()) goto L21;
        if (Objects.equals(this.keys[r0], r7.keys[r0]) == false) goto L16;
        if (Objects.equals(this.values[r0], r7.values[r0]) == false) goto L19;
        r0 = r0 + 1;
        goto L13
    L19:
        return false;
    L16:
        return false;
    L21:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.logging.log4j.util.ReadOnlyStringMap
    public <V> void forEach(a<String, ? super V> r5) {
        a r6 = (a) ZeusTransformUtils.wrapperContextForParams(r5, a.class, "com.obric.memorydata.plugin");
        this.iterating = true;
        int r1 = 0;
    L12:
    L9:
        th = move-exception;
        this.iterating = false;
        throw th;
    L4:
        if (r1 >= this.size) goto L7;
        r6.accept(this.keys[r1], this.values[r1]);     // Catch: Throwable -> L9
        r1 = r1 + 1;
        goto L12
    L7:
        this.iterating = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.logging.log4j.util.ReadOnlyStringMap
    public <V, T> void forEach(u<String, ? super V, T> r5, T r6) {
        u r7 = (u) ZeusTransformUtils.wrapperContextForParams(r5, u.class, "com.obric.memorydata.plugin");
        this.iterating = true;
        int r1 = 0;
    L12:
    L9:
        th = move-exception;
        this.iterating = false;
        throw th;
    L4:
        if (r1 >= this.size) goto L7;
        r7.accept(this.keys[r1], this.values[r1], r6);     // Catch: Throwable -> L9
        r1 = r1 + 1;
        goto L12
    L7:
        this.iterating = false;
    }

    @Override // org.apache.logging.log4j.util.StringMap
    public void freeze() {
        this.immutable = true;
    }

    @Override // org.apache.logging.log4j.util.IndexedReadOnlyStringMap
    public String getKeyAt(int r2) {
        if (r2 >= 0) goto L4;
        return null;
    L4:
        if (r2 < this.size) goto L7;
        return null;
    L7:
        return this.keys[r2];
    }

    @Override // org.apache.logging.log4j.util.ReadOnlyStringMap
    public <V> V getValue(String r1) {
        int r2 = indexOfKey(r1);
        if (r2 >= 0) goto L7;
        return null;
    L7:
        return (V) this.values[r2];
    }

    @Override // org.apache.logging.log4j.util.IndexedReadOnlyStringMap
    public <V> V getValueAt(int r2) {
        if (r2 >= 0) goto L4;
        return null;
    L4:
        if (r2 < this.size) goto L7;
        return null;
    L7:
        return (V) this.values[r2];
    }

    @Override // org.apache.logging.log4j.util.StringMap
    public int hashCode() {
        int r0 = this.size;
        return ((((1147 + r0) * 31) + hashCode(this.keys, r0)) * 31) + hashCode(this.values, this.size);
    }

    @Override // org.apache.logging.log4j.util.IndexedReadOnlyStringMap
    public int indexOfKey(String r4) {
        String[] r0 = this.keys;
        if (r0 != EMPTY) goto L6;
        return -1;
    L6:
        if (r4 == null) goto L8;
        int r3 = this.size;
        int r1 = 0;
        if (r3 <= 0) goto L15;
        if (r0[0] != null) goto L15;
        r1 = 1;
    L15:
        return Arrays.binarySearch(r0, r1, r3, r4);
    L8:
        return nullKeyIndex();
    }

    @Override // org.apache.logging.log4j.util.ReadOnlyStringMap
    public boolean isEmpty() {
        if (this.size != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.apache.logging.log4j.util.StringMap
    public boolean isFrozen() {
        return this.immutable;
    }

    @Override // org.apache.logging.log4j.util.StringMap
    public void putAll(ReadOnlyStringMap r4) {
        ReadOnlyStringMap r5 = (ReadOnlyStringMap) ZeusTransformUtils.wrapperContextForParams(r4, ReadOnlyStringMap.class, "com.obric.memorydata.plugin");
        if (r5 == this) goto L17;
        if (r5 != null) goto L6;
        return;
    L6:
        if (r5.isEmpty() == true) goto L22;
        assertNotFrozen();
        assertNoConcurrentModification();
        if (ZeusTransformUtils.instanceOf(r5, SortedArrayStringMap.class) == false) goto L14;
        int r1 = this.size;
        SortedArrayStringMap r6 = (SortedArrayStringMap) ZeusTransformUtils.preCheckCast(r5, SortedArrayStringMap.class, "com.obric.memorydata.plugin");
        if (r1 != 0) goto L13;
        initFrom0(r6);
        return;
    L13:
        merge(r6);
        return;
    L14:
        if (r5 == null) goto L21;
        r5.forEach(PUT_ALL, this);
        return;
    L21:
        return;
    L22:
        return;
    }

    @Override // org.apache.logging.log4j.util.StringMap
    public void putValue(String r3, Object r4) {
        assertNotFrozen();
        assertNoConcurrentModification();
        if (this.keys != EMPTY) goto L5;
        inflateTable(this.threshold);
    L5:
        int r0 = indexOfKey(r3);
        if (r0 < 0) goto L8;
        this.keys[r0] = r3;
        this.values[r0] = r4;
        return;
    L8:
        insertAt(~r0, r3, r4);
    }

    @Override // org.apache.logging.log4j.util.StringMap
    public void remove(String r4) {
        if (this.keys != EMPTY) goto L5;
        return;
    L5:
        int r5 = indexOfKey(r4);
        if (r5 < 0) goto L9;
        assertNotFrozen();
        assertNoConcurrentModification();
        String[] r0 = this.keys;
        int r1 = r5 + 1;
        System.arraycopy(r0, r1, r0, r5, (this.size - 1) - r5);
        Object[] r2 = this.values;
        System.arraycopy(r2, r1, r2, r5, (this.size - 1) - r5);
        String[] r6 = this.keys;
        int r3 = this.size;
        r6[r3 - 1] = null;
        this.values[r3 - 1] = null;
        this.size = r3 - 1;
        return;
    }

    @Override // org.apache.logging.log4j.util.ReadOnlyStringMap
    public int size() {
        return this.size;
    }

    @Override // org.apache.logging.log4j.util.ReadOnlyStringMap
    public Map<String, String> toMap() {
        HashMap r0 = new HashMap(size());
        int r1 = 0;
    L4:
        if (r1 >= size()) goto L10;
        Object r2 = getValueAt(r1);
        String r3 = getKeyAt(r1);
        if (r2 != null) goto L8;
        String r4 = null;
    L9:
        r0.put(r3, r4);
        r1 = r1 + 1;
        goto L4
    L8:
        r4 = String.valueOf(r2);
        goto L9
    L10:
        return r0;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder(256);
        r0.append('{');
        int r1 = 0;
    L4:
        if (r1 >= this.size) goto L12;
        if (r1 <= 0) goto L7;
        r0.append(", ");
    L7:
        r0.append(this.keys[r1]).append('=');
        Object[] r2 = this.values;
        if (r2[r1] != this) goto L10;
        Object r3 = "(this map)";
    L11:
        r0.append(r3);
        r1 = r1 + 1;
        goto L4
    L10:
        r3 = r2[r1];
        goto L11
    L12:
        r0.append('}');
        return r0.toString();
    }
}
