package org.apache.poi.hwpf.usermodel;

import com.obric.oui.calendar.ODatePickerView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Calendar;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.LocaleUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class DateAndTime {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final BitField _dom = null;
    private static final BitField _hours = null;
    private static final BitField _minutes = null;
    private static final BitField _months = null;
    private static final BitField _years = null;
    private short _info;
    private short _info2;

    static {
        _minutes = BitFieldFactory.getInstance(63);
        _hours = BitFieldFactory.getInstance(1984);
        _dom = BitFieldFactory.getInstance(63488);
        _months = BitFieldFactory.getInstance(15);
        _years = BitFieldFactory.getInstance(8176);
    }

    public DateAndTime() {
    }

    public DateAndTime(DateAndTime r2) {
        this._info = r2._info;
        this._info2 = r2._info2;
    }

    public DateAndTime(byte[] r2, int r3) {
        this._info = LittleEndian.getShort(r2, r3);
        this._info2 = LittleEndian.getShort(r2, r3 + 2);
    }

    public DateAndTime copy() {
        return new DateAndTime(this);
    }

    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, DateAndTime.class) == true) goto L5;
        return false;
    L5:
        DateAndTime r5 = (DateAndTime) ZeusTransformUtils.preCheckCast(r4, DateAndTime.class, "com.obric.memorydata.plugin");
        if (this._info == r5._info) goto L8;
        return false;
    L8:
        if (this._info2 != r5._info2) goto L12;
        return true;
    L12:
        return false;
    }

    public Calendar getDate() {
        return LocaleUtil.getLocaleCalendar(_years.getValue(this._info2) + ODatePickerView.YEAR_FROM, _months.getValue(this._info2) - 1, _dom.getValue(this._info), _hours.getValue(this._info), _minutes.getValue(this._info), 0);
    }

    public int hashCode() {
        return 42;
    }

    public boolean isEmpty() {
        if (this._info == 0) goto L5;
    L7:
        return false;
    L5:
        if (this._info2 != 0) goto L7;
        return true;
    }

    public String toString() {
        if (isEmpty() == false) goto L7;
        return "[DTTM] EMPTY";
    L7:
        return "[DTTM] " + getDate();
    }
}
