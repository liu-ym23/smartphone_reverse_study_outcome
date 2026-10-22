package com.tencent.wcdb;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public final class BulkCursorDescriptor implements Parcelable {
    public static final Parcelable.Creator<BulkCursorDescriptor> CREATOR = null;
    public String[] columnNames;
    public int count;
    public j cursor;
    public boolean wantsAllOnMoveCalls;
    public CursorWindow window;

    static {
        CREATOR = new AnonymousClass1();
    }

    public BulkCursorDescriptor() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void readFromParcel(Parcel r3) {
        this.cursor = c.a(r3.readStrongBinder());
        this.columnNames = readStringArray(r3);
        if (r3.readInt() == 0) goto L5;
        boolean r0 = true;
    L6:
        this.wantsAllOnMoveCalls = r0;
        this.count = r3.readInt();
        if (r3.readInt() == 0) goto L10;
        this.window = (CursorWindow) ZeusTransformUtils.preCheckCast(CursorWindow.CREATOR.createFromParcel(r3), CursorWindow.class, "com.obric.memorydata.plugin");
        return;
    L10:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final String[] readStringArray(Parcel r4) {
        int r3 = r4.readInt();
        if (r3 < 0) goto L7;
        String[] r0 = new String[r3];
        int r1 = 0;
    L5:
        if (r1 >= r3) goto L10;
        r0[r1] = r4.readString();
        r1 = r1 + 1;
        goto L5
    L10:
        return r0;
    L7:
        return null;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        r2.writeStrongBinder(this.cursor.asBinder());
        r2.writeStringArray(this.columnNames);
        r2.writeInt(this.wantsAllOnMoveCalls ? 1 : 0);
        r2.writeInt(this.count);
        if (this.window == null) goto L5;
        r2.writeInt(1);
        this.window.writeToParcel(r2, r3);
        return;
    L5:
        r2.writeInt(0);
    }
}
