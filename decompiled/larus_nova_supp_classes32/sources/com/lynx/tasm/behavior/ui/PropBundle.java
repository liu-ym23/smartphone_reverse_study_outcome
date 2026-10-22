package com.lynx.tasm.behavior.ui;

import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class PropBundle {
    public JavaOnlyMap a;
    public JavaOnlyArray b;
    public JavaOnlyArray c;

    public static PropBundle createPropBundle() {
        return new PropBundle();
    }

    public void resetEventHandler() {
        JavaOnlyArray r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.clear();
    }

    public PropBundle shallowCopy() {
        PropBundle r0 = new PropBundle();
        r0.a = JavaOnlyMap.shallowCopy(getProps());
        if (getEventHandlers() == null) goto L6;
        r0.b = JavaOnlyArray.shallowCopy(getEventHandlers());
    L6:
        if (getGestures() == null) goto L8;
        r0.c = JavaOnlyArray.shallowCopy(getGestures());
    L8:
        return r0;
    }

    public PropBundle() {
        this.a = new JavaOnlyMap();
        this.b = null;
        this.c = null;
    }

    public ReadableArray getEventHandlers() {
        return this.b;
    }

    public ReadableArray getGestures() {
        return this.c;
    }

    public ReadableMap getProps() {
        return this.a;
    }

    public boolean contains(String r2) {
        return this.a.containsKey(r2);
    }

    public void putEventHandler(JavaOnlyMap r2) {
        if (this.b != null) goto L5;
        this.b = new JavaOnlyArray();
    L5:
        this.b.pushMap(r2);
    }

    public void putGesture(JavaOnlyMap r2) {
        if (this.c != null) goto L5;
        this.c = new JavaOnlyArray();
    L5:
        this.c.pushMap(r2);
    }

    public void putNull(String r2) {
        this.a.putNull(r2);
    }

    public void putArray(String r2, JavaOnlyArray r3) {
        this.a.putArray(r2, r3);
    }

    public void putBool(String r2, boolean r3) {
        this.a.putBoolean(r2, r3);
    }

    public void putDouble(String r2, double r3) {
        this.a.putDouble(r2, r3);
    }

    public void putInt(String r2, int r3) {
        this.a.putInt(r2, r3);
    }

    public void putLong(String r2, long r3) {
        this.a.putLong(r2, r3);
    }

    public void putMap(String r2, JavaOnlyMap r3) {
        this.a.putMap(r2, r3);
    }

    public void putString(String r2, String r3) {
        this.a.putString(r2, r3);
    }
}
