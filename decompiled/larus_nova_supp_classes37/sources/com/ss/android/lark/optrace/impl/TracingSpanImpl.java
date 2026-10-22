package com.ss.android.lark.optrace.impl;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.optrace.api.TracingCoreSpan;
import com.ss.android.lark.optrace.core.TracingCoreTarget;
import com.ss.android.lark.optrace.core.TracingSpanMemData;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class TracingSpanImpl extends TracingCoreTarget implements Parcelable {
    public static final Parcelable.Creator<TracingSpanImpl> CREATOR = null;

    public class a implements Parcelable.Creator<TracingSpanImpl> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final TracingSpanImpl createFromParcel(Parcel r2) {
            return new TracingSpanImpl(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final TracingSpanImpl[] newArray(int r1) {
            return new TracingSpanImpl[r1];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    @Override // com.ss.android.lark.optrace.api.TracingCoreSpan
    public TracingCoreSpan generateSpan() {
        return new TracingSpanImpl(this);
    }

    @Override // com.ss.android.lark.optrace.core.TracingCoreTarget
    public void generateSpanData() {
        this.spanData = new TracingSpanMemData();
    }

    @Override // com.ss.android.lark.optrace.api.TracingCoreSpan
    public TracingCoreSpan subTrace() {
        return new TracingSpanImpl(this);
    }

    public TracingSpanImpl() {
    }

    public TracingSpanImpl(Parcel r3) {
        this.cacheTracingId = r3.readString();
        HashMap r0 = new HashMap();
        this.extensions = r0;
        r3.readMap(r0, getClass().getClassLoader());
    }

    public TracingSpanImpl(TracingCoreSpan r1) {
        super(r1);
    }

    public TracingSpanImpl(String r1) {
        super(r1);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeString(this.cacheTracingId);
        r1.writeMap(this.extensions);
    }
}
