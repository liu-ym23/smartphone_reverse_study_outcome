package org.apache.poi.poifs.property;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import org.apache.poi.hpsf.ClassID;
import org.apache.poi.util.ByteField;
import org.apache.poi.util.IntegerField;
import org.apache.poi.util.ShortField;

/* JADX INFO: loaded from: classes7.dex */
public abstract class Property implements Child {
    private IntegerField _child_property;
    private IntegerField _days_1;
    private IntegerField _days_2;
    private int _index;
    private String _name;
    private ShortField _name_size;
    private Child _next_child;
    private IntegerField _next_property;
    private ByteField _node_color;
    private Child _previous_child;
    private IntegerField _previous_property;
    private ByteField _property_type;
    private byte[] _raw_data;
    private IntegerField _seconds_1;
    private IntegerField _seconds_2;
    private IntegerField _size;
    private IntegerField _start_block;
    private ClassID _storage_clsid;
    private IntegerField _user_flags;

    public Property() {
        byte[] r0 = new byte[128];
        this._raw_data = r0;
        Arrays.fill(r0, (byte) 0);
        this._name_size = new ShortField(64);
        this._property_type = new ByteField(66);
        this._node_color = new ByteField(67);
        this._previous_property = new IntegerField(68, -1, this._raw_data);
        this._next_property = new IntegerField(72, -1, this._raw_data);
        this._child_property = new IntegerField(76, -1, this._raw_data);
        this._storage_clsid = new ClassID(this._raw_data, 80);
        this._user_flags = new IntegerField(96, 0, this._raw_data);
        this._seconds_1 = new IntegerField(100, 0, this._raw_data);
        this._days_1 = new IntegerField(104, 0, this._raw_data);
        this._seconds_2 = new IntegerField(108, 0, this._raw_data);
        this._days_2 = new IntegerField(112, 0, this._raw_data);
        this._start_block = new IntegerField(116);
        this._size = new IntegerField(120, 0, this._raw_data);
        this._index = -1;
        setName("");
        setNextChild(null);
        setPreviousChild(null);
    }

    public Property(int r5, byte[] r6, int r7) {
        this._raw_data = Arrays.copyOfRange(r6, r7, r7 + 128);
        this._name_size = new ShortField(64, this._raw_data);
        this._property_type = new ByteField(66, this._raw_data);
        this._node_color = new ByteField(67, this._raw_data);
        this._previous_property = new IntegerField(68, this._raw_data);
        this._next_property = new IntegerField(72, this._raw_data);
        this._child_property = new IntegerField(76, this._raw_data);
        this._storage_clsid = new ClassID(this._raw_data, 80);
        this._user_flags = new IntegerField(96, 0, this._raw_data);
        this._seconds_1 = new IntegerField(100, this._raw_data);
        this._days_1 = new IntegerField(104, this._raw_data);
        this._seconds_2 = new IntegerField(108, this._raw_data);
        this._days_2 = new IntegerField(112, this._raw_data);
        this._start_block = new IntegerField(116, this._raw_data);
        this._size = new IntegerField(120, this._raw_data);
        this._index = r5;
        int r8 = (this._name_size.get() / 2) - 1;
        if (r8 >= 1) goto L5;
        this._name = "";
    L9:
        this._next_child = null;
        this._previous_child = null;
        return;
    L5:
        char[] r9 = new char[r8];
        int r10 = 0;
        int r0 = 0;
    L6:
        if (r10 >= r8) goto L8;
        r9[r10] = (char) new ShortField(r0, this._raw_data).get();
        r0 = r0 + 2;
        r10 = r10 + 1;
        goto L6
    L8:
        this._name = new String(r9, 0, r8);
        goto L9
    }

    static boolean isValidIndex(int r1) {
        if (r1 == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public int getChildIndex() {
        return this._child_property.get();
    }

    public int getIndex() {
        return this._index;
    }

    public String getName() {
        return this._name;
    }

    int getNextChildIndex() {
        return this._next_property.get();
    }

    int getPreviousChildIndex() {
        return this._previous_property.get();
    }

    public int getSize() {
        return this._size.get();
    }

    public int getStartBlock() {
        return this._start_block.get();
    }

    public abstract boolean isDirectory();

    public void setName(String r8) {
        char[] r9 = r8.toCharArray();
        int r0 = Math.min(r9.length, 31);
        this._name = new String(r9, 0, r0);
        int r1 = 0;
        short r3 = 0;
    L3:
        if (r1 >= r0) goto L6;
        new ShortField(r3, (short) r9[r1], this._raw_data);
        r3 = (short) (r3 + 2);
        r1 = r1 + 1;
    L6:
        if (r1 >= 32) goto L8;
        new ShortField(r3, 0, this._raw_data);
        r3 = (short) (r3 + 2);
        r1 = r1 + 1;
        goto L6
    L8:
        this._name_size.set((short) ((r0 + 1) * 2), this._raw_data);
    }

    public void setNextChild(Child r4) {
        Child r5 = (Child) ZeusTransformUtils.wrapperContextForParams(r4, Child.class, "com.obric.memorydata.plugin");
        this._next_child = r5;
        IntegerField r0 = this._next_property;
        if (r5 != null) goto L5;
        int r6 = -1;
    L6:
        r0.set(r6, this._raw_data);
        return;
    L5:
        r6 = ((Property) ZeusTransformUtils.preCheckCast(r5, Property.class, "com.obric.memorydata.plugin")).getIndex();
        goto L6
    }

    public void setNodeColor(byte r2) {
        this._node_color.set(r2, this._raw_data);
    }

    public void setPreviousChild(Child r4) {
        Child r5 = (Child) ZeusTransformUtils.wrapperContextForParams(r4, Child.class, "com.obric.memorydata.plugin");
        this._previous_child = r5;
        IntegerField r0 = this._previous_property;
        if (r5 != null) goto L5;
        int r6 = -1;
    L6:
        r0.set(r6, this._raw_data);
        return;
    L5:
        r6 = ((Property) ZeusTransformUtils.preCheckCast(r5, Property.class, "com.obric.memorydata.plugin")).getIndex();
        goto L6
    }

    public void setPropertyType(byte r2) {
        this._property_type.set(r2, this._raw_data);
    }

    public void setSize(int r2) {
        this._size.set(r2, this._raw_data);
    }

    public void setStartBlock(int r2) {
        this._start_block.set(r2, this._raw_data);
    }
}
