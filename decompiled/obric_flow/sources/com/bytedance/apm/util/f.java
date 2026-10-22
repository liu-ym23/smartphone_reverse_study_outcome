package com.bytedance.apm.util;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements SharedPreferences.Editor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f3913a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f3914b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ MultiProcessSharedPreferences f3915c;

    public f(MultiProcessSharedPreferences r5) {
        this.f3915c = r5;
        this.f3913a = false;
        this.f3914b = new HashMap();
    }

    @Override // android.content.SharedPreferences.Editor
    public final void apply() {
        boolean r5 = this.f3913a;
        HashMap r10 = this.f3914b;
        if (r5 == false) goto L5;
    L7:
        Bundle r11 = new Bundle();
        if (this.f3913a == false) goto L10;
        r11.putBoolean("clear", true);
    L10:
        ArrayList<? extends Parcelable> r12 = new ArrayList(r10.size());
        Iterator r13 = r10.entrySet().iterator();
    L12:
        if (r13.hasNext() == false) goto L14;
        Map.Entry r14 = (Map.Entry) r13.next();
        r12.add(new SpPair((String) r14.getKey(), r14.getValue()));
        goto L12
    L14:
        r11.putParcelableArrayList("edit", r12);
        MultiProcessSharedPreferences r15 = this.f3915c;     // Catch: Exception -> L17
        int r16 = MultiProcessSharedPreferences.f3900b;     // Catch: Exception -> L17
        r15.getClass();     // Catch: Exception -> L17
        throw null;     // Catch: Exception -> L17
    L17:
        e = move-exception;
        io.reactivex.exceptions.a.n("MultiProcessSharedPref", "apply exception: ", e);
        return;
    L5:
        if (r10.isEmpty() == false) goto L7;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor clear() {
        this.f3914b.clear();
        this.f3913a = true;
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final boolean commit() {
        apply();
        return true;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putBoolean(String r5, boolean r10) {
        this.f3914b.put(r5, Boolean.valueOf(r10));
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putFloat(String r5, float r10) {
        this.f3914b.put(r5, Float.valueOf(r10));
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putInt(String r5, int r10) {
        this.f3914b.put(r5, Integer.valueOf(r10));
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putLong(String r5, long r10) {
        this.f3914b.put(r5, Long.valueOf(r10));
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putString(String r5, String r10) {
        this.f3914b.put(r5, r10);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putStringSet(String r10, Set r11) {
        HashMap r5 = this.f3914b;
        String[] r12 = new String[r11.size()];
        Iterator r13 = r11.iterator();
        int r14 = 0;
    L4:
        if (r13.hasNext() == false) goto L6;
        r12[r14] = (String) r13.next();
        r14 = r14 + 1;
        goto L4
    L6:
        r5.put(r10, r12);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor remove(String r5) {
        this.f3914b.put(r5, null);
        return this;
    }
}
