package android.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class InfoData implements Parcelable, Cloneable {
    public static final Parcelable.Creator<InfoData> CREATOR = null;
    private static final String TAG = "InfoData";
    public static final int TYPE_BOOL = 4;
    public static final int TYPE_BOOL_SIZE = 1;
    public static final int TYPE_FLOAT = 3;
    public static final int TYPE_FLOAT_SIZE = 4;
    public static final int TYPE_INT32 = 1;
    public static final int TYPE_INT32_SIZE = 4;
    public static final int TYPE_INT64 = 2;
    public static final int TYPE_INT64_SIZE = 8;
    private Bundle mExtras;

    class a implements Parcelable.Creator<InfoData> {
        a() {
        }

        public InfoData a(Parcel r10) {
            return new InfoData(r10);
        }

        public InfoData[] b(int r10) {
            return new InfoData[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ InfoData createFromParcel(Parcel r10) {
            return a(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ InfoData[] newArray(int r10) {
            return b(r10);
        }
    }

    static {
        CREATOR = new a();
    }

    public InfoData() {
    }

    public InfoData(InfoData r10) {
        if (r10.getExtras() == null) goto L6;
        this.mExtras = new Bundle(r10.getExtras());
        return;
    }

    public InfoData(Parcel r10) {
        readFromParcel(r10);
    }

    public Object clone() {
        return new InfoData(this);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean getBooleanExtra(String r10, boolean r11) {
        Bundle r12 = this.mExtras;
        if (r12 != null) goto L6;
        return r11;
    L6:
        return r12.getBoolean(r10, r11);
    }

    @Nullable
    public Bundle getExtras() {
        if (this.mExtras != null) goto L7;
        return null;
    L7:
        return new Bundle(this.mExtras);
    }

    public float getFloatExtra(String r10, float r11) {
        Bundle r12 = this.mExtras;
        if (r12 != null) goto L6;
        return r11;
    L6:
        return r12.getFloat(r10, r11);
    }

    public int getIntExtra(String r10, int r11) {
        Bundle r12 = this.mExtras;
        if (r12 != null) goto L6;
        return r11;
    L6:
        return r12.getInt(r10, r11);
    }

    public long getLongExtra(String r10, long r11) {
        Bundle r12 = this.mExtras;
        if (r12 != null) goto L6;
        return r11;
    L6:
        return r12.getLong(r10, r11);
    }

    @Nullable
    public String getStringExtra(String r10) {
        Bundle r11 = this.mExtras;
        if (r11 != null) goto L6;
        return null;
    L6:
        return r11.getString(r10);
    }

    @Nullable
    public InfoData putExtra(String r10, float r11) {
        if (this.mExtras != null) goto L5;
        this.mExtras = new Bundle();
    L5:
        this.mExtras.putFloat(r10, r11);
        return this;
    }

    @NonNull
    public InfoData putExtra(String r10, int r11) {
        if (this.mExtras != null) goto L5;
        this.mExtras = new Bundle();
    L5:
        this.mExtras.putInt(r10, r11);
        return this;
    }

    @NonNull
    public InfoData putExtra(String r10, long r11) {
        if (this.mExtras != null) goto L5;
        this.mExtras = new Bundle();
    L5:
        this.mExtras.putLong(r10, r11);
        return this;
    }

    @NonNull
    public InfoData putExtra(String r10, @Nullable String r11) {
        if (this.mExtras != null) goto L5;
        this.mExtras = new Bundle();
    L5:
        this.mExtras.putString(r10, r11);
        return this;
    }

    @Nullable
    public InfoData putExtra(String r10, boolean r11) {
        if (this.mExtras != null) goto L5;
        this.mExtras = new Bundle();
    L5:
        this.mExtras.putBoolean(r10, r11);
        return this;
    }

    @NonNull
    public InfoData putExtras(@NonNull Bundle r10) {
        if (this.mExtras != null) goto L5;
        this.mExtras = new Bundle();
    L5:
        this.mExtras.putAll(r10);
        return this;
    }

    public void readFromParcel(Parcel r10) {
        int r11 = r10.readInt();
        int r12 = 0;
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L17;
        String r14 = r10.readString();
        int r15 = r10.readInt();
        r10.readInt();
        if (r15 != 1) goto L8;
        putExtra(r14, r10.readInt());
    L16:
        r13 = r13 + 1;
        goto L3
    L8:
        if (r15 != 2) goto L11;
        putExtra(r14, r10.readLong());
        goto L16
    L11:
        if (r15 != 3) goto L14;
        putExtra(r14, r10.readFloat());
        goto L16
    L14:
        if (r15 != 4) goto L16;
        putExtra(r14, r10.readBoolean());
        goto L16
    L17:
        int r16 = r10.readInt();
    L18:
        if (r12 >= r16) goto L20;
        putExtra(r10.readString(), r10.readString());
        r12 = r12 + 1;
        goto L18
    }

    public String toString() {
        StringBuilder r10 = new StringBuilder();
        r10.append("InfoData {");
        if (this.mExtras == null) goto L8;
        r10.append(" mExtras:");
        Iterator<String> r11 = this.mExtras.keySet().iterator();
    L6:
        if (r11.hasNext() == false) goto L8;
        String r12 = r11.next();
        r10.append(" [" + r12 + ":" + this.mExtras.get(r12) + "]");
    L8:
        r10.append("}");
        return r10.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r10, int r11) {
        Set<String> r12 = this.mExtras.keySet();
        Iterator<String> r13 = r12.iterator();
        int r14 = 0;
    L4:
        if (r13.hasNext() == false) goto L20;
        String r15 = r13.next();
        Object r16 = this.mExtras.get(r15);
        if (r16 == null) goto L7;
        if ((r16 instanceof Integer) == true) goto L10;
        if ((r16 instanceof Long) == true) goto L10;
        if ((r16 instanceof Float) == true) goto L10;
        if ((r16 instanceof Boolean) == false) goto L4;
    L10:
        r14 = r14 + 1;
        goto L4
    L7:
        return;
    L20:
        r10.writeInt(r14);
        Iterator<String> r17 = r12.iterator();
    L22:
        if (r17.hasNext() == false) goto L38;
        String r18 = r17.next();
        Object r19 = this.mExtras.get(r18);
        if (r19 == null) goto L25;
        if ((r19 instanceof Integer) == true) goto L28;
        if ((r19 instanceof Long) == true) goto L31;
        if ((r19 instanceof Float) == true) goto L34;
        if ((r19 instanceof Boolean) == false) goto L22;
        r10.writeString(r18);
        r10.writeInt(4);
        r10.writeInt(1);
        r10.writeBoolean(((Boolean) r19).booleanValue());
        goto L22
    L34:
        r10.writeString(r18);
        r10.writeInt(3);
        r10.writeInt(4);
        r10.writeFloat(((Float) r19).floatValue());
        goto L22
    L31:
        r10.writeString(r18);
        r10.writeInt(2);
        r10.writeInt(8);
        r10.writeLong(((Long) r19).longValue());
        goto L22
    L28:
        r10.writeString(r18);
        r10.writeInt(1);
        r10.writeInt(4);
        r10.writeInt(((Integer) r19).intValue());
        goto L22
    L25:
        return;
    L38:
        r10.writeInt(this.mExtras.size() - r14);
        Iterator<String> r20 = r12.iterator();
    L40:
        if (r20.hasNext() == false) goto L47;
        String r21 = r20.next();
        Object r22 = this.mExtras.get(r21);
        if (r22 == null) goto L43;
        if ((r22 instanceof String) == false) goto L40;
        r10.writeString(r21);
        r10.writeString((String) r22);
        goto L40
    L43:
        return;
    }
}
