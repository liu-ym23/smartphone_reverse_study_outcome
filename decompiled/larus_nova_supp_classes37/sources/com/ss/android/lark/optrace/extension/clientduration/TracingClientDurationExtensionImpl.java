package com.ss.android.lark.optrace.extension.clientduration;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.optrace.extension.TracingExtension;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class TracingClientDurationExtensionImpl extends TracingClientDurationExtension implements Parcelable {
    public static final Parcelable.Creator<TracingClientDurationExtensionImpl> CREATOR = null;

    public class a implements Parcelable.Creator<TracingClientDurationExtensionImpl> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final TracingClientDurationExtensionImpl createFromParcel(Parcel r2) {
            return new TracingClientDurationExtensionImpl(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final TracingClientDurationExtensionImpl[] newArray(int r1) {
            return new TracingClientDurationExtensionImpl[r1];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    @Override // com.ss.android.lark.optrace.extension.clientduration.TracingClientDurationExtension
    public void endAll() {
        Map<String, TracingClientDurationEvent> r0 = this.eventStartMap;
        if (r0 != null) goto L5;
        return;
    L5:
        Iterator<String> r1 = r0.keySet().iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        String r2 = r1.next();
        Log.d("TracingClientDurationEx", "end key:" + r2);
        end(r2);
        goto L7
    }

    public TracingClientDurationExtensionImpl() {
    }

    public TracingClientDurationExtensionImpl(Parcel r3) {
        HashMap r0 = new HashMap();
        this.eventStartMap = r0;
        r3.readMap(r0, getClass().getClassLoader());
    }

    @Override // com.ss.android.lark.optrace.extension.clientduration.TracingClientDurationExtension
    public long duration(String r3) {
        TracingClientDurationEvent r0 = this.eventStartMap.get(r3);
        if (r0 != null) goto L7;
        Log.i("TracingClientDurationEx", "this key not start! key=" + r3);
        return -1;
    L7:
        return r0.duration();
    }

    @Override // com.ss.android.lark.optrace.extension.clientduration.TracingClientDurationExtension
    public long end(String r5) {
        TracingClientDurationEvent r0 = this.eventStartMap.get(r5);
        if (r0 != null) goto L7;
        Log.i("TracingClientDurationEx", "this key not start! key=" + r5);
        return -1;
    L7:
        if (r0.isFinished() == false) goto L9;
        Log.i("TracingClientDurationEx", "this key finished! key=" + r5);
    L11:
        return r0.duration();
    L9:
        r0.finish();
        goto L11
    }

    @Override // com.ss.android.lark.optrace.extension.clientduration.TracingClientDurationExtension, com.ss.android.lark.optrace.extension.TracingExtension
    public TracingExtension mergeExtension(TracingExtension r7) {
        if (r7 != null) goto L7;
        Log.e("TracingClientDurationEx", "linkExtension is Null !!!");
        return this;
    L7:
        if ((r7 instanceof TracingClientDurationExtension) == true) goto L10;
        Log.e("TracingClientDurationEx", "linkExtension is not clientDurationExtension !!!");
        return this;
    L10:
        Map<String, TracingClientDurationEvent> r8 = ((TracingClientDurationExtension) r7).eventStartMap;
        if (r8.isEmpty() == false) goto L14;
        Log.i("TracingClientDurationEx", "link client duration extension eventStartMap is empty!!");
        return this;
    L14:
        Iterator<String> r1 = r8.keySet().iterator();
    L16:
        if (r1.hasNext() == false) goto L30;
        String r2 = r1.next();
        TracingClientDurationEvent r3 = r8.get(r2);
        if (r3 == null) goto L19;
        if (r3.isFinished() == true) goto L22;
        TracingClientDurationEvent r4 = this.eventStartMap.get(r2);
        if (r4 != null) goto L26;
        this.eventStartMap.put(r2, r3);
        Log.w("TracingClientDurationEx", "add event key = " + r2 + " linkClientDurationEvent:" + r3.toString());
        goto L16
    L26:
        if (r4.isFinished() == false) goto L27;
        Log.i("TracingClientDurationEx", "duplicate key = " + r2 + " finished, not merge!");
        goto L16
    L27:
        Log.e("TracingClientDurationEx", "duplicate key =" + r2 + " not finished!");
        goto L16
    L22:
        Log.d("TracingClientDurationEx", "this key finished, key = " + r2);
        goto L16
    L19:
        Log.e("TracingClientDurationEx", "linkClientDurationEvent is null, key =" + r2);
        goto L16
    L30:
        return this;
    }

    @Override // com.ss.android.lark.optrace.extension.clientduration.TracingClientDurationExtension
    public void start(String r3) {
        if (this.eventStartMap.containsKey(r3) == false) goto L6;
        Log.w("TracingClientDurationEx", "this key has already started! key = " + r3);
        return;
    L6:
        this.eventStartMap.put(r3, new TracingClientDurationEvent());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeMap(this.eventStartMap);
    }
}
