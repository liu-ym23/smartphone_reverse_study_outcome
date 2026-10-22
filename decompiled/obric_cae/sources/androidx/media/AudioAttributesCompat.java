package androidx.media;

import android.util.SparseIntArray;
import h1.c;

/* JADX INFO: loaded from: classes.dex */
public class AudioAttributesCompat implements c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f2207b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AudioAttributesImpl f2208a;

    static {
        SparseIntArray r8 = new SparseIntArray();
        r8.put(5, 1);
        r8.put(6, 2);
        r8.put(7, 2);
        r8.put(8, 1);
        r8.put(9, 1);
        r8.put(10, 1);
    }

    public AudioAttributesCompat() {
    }

    public final boolean equals(Object r8) {
        if ((r8 instanceof AudioAttributesCompat) == true) goto L5;
        return false;
    L5:
        AudioAttributesCompat r10 = (AudioAttributesCompat) r8;
        AudioAttributesImpl r11 = this.f2208a;
        if (r11 != null) goto L12;
        if (r10.f2208a != null) goto L13;
        return true;
    L13:
        return false;
    L12:
        return r11.equals(r10.f2208a);
    }

    public final int hashCode() {
        return this.f2208a.hashCode();
    }

    public final String toString() {
        return this.f2208a.toString();
    }
}
