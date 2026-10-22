package com.lynx.tasm.behavior.ui;

import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.base.CalledByNative;

/* JADX INFO: loaded from: classes2.dex */
public class PropBundle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JavaOnlyMap f10382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public JavaOnlyArray f10383b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public JavaOnlyArray f10384c;

    public PropBundle() {
        this.f10382a = new JavaOnlyMap();
        this.f10383b = null;
        this.f10384c = null;
    }

    @CalledByNative
    public static PropBundle createPropBundle() {
        return new PropBundle();
    }

    @CalledByNative
    public boolean contains(String r5) {
        return this.f10382a.containsKey(r5);
    }

    @CalledByNative
    public ReadableArray getEventHandlers() {
        return this.f10383b;
    }

    @CalledByNative
    public ReadableArray getGestures() {
        return this.f10384c;
    }

    @CalledByNative
    public ReadableMap getProps() {
        return this.f10382a;
    }

    @CalledByNative
    public void putArray(String r5, JavaOnlyArray r10) {
        this.f10382a.putArray(r5, r10);
    }

    @CalledByNative
    public void putBool(String r5, boolean r10) {
        this.f10382a.putBoolean(r5, r10);
    }

    @CalledByNative
    public void putDouble(String r5, double r10) {
        this.f10382a.putDouble(r5, r10);
    }

    @CalledByNative
    public void putEventHandler(JavaOnlyMap r5) {
        if (this.f10383b != null) goto L5;
        this.f10383b = new JavaOnlyArray();
    L5:
        this.f10383b.pushMap(r5);
    }

    @CalledByNative
    public void putGesture(JavaOnlyMap r5) {
        if (this.f10384c != null) goto L5;
        this.f10384c = new JavaOnlyArray();
    L5:
        this.f10384c.pushMap(r5);
    }

    @CalledByNative
    public void putInt(String r5, int r10) {
        this.f10382a.putInt(r5, r10);
    }

    @CalledByNative
    public void putLong(String r5, long r10) {
        this.f10382a.putLong(r5, r10);
    }

    @CalledByNative
    public void putMap(String r5, JavaOnlyMap r10) {
        this.f10382a.putMap(r5, r10);
    }

    @CalledByNative
    public void putNull(String r5) {
        this.f10382a.putNull(r5);
    }

    @CalledByNative
    public void putString(String r5, String r10) {
        this.f10382a.putString(r5, r10);
    }

    @CalledByNative
    public void resetEventHandler() {
        JavaOnlyArray r5 = this.f10383b;
        if (r5 != null) goto L5;
        return;
    L5:
        r5.clear();
    }

    @CalledByNative
    public PropBundle shallowCopy() {
        PropBundle r5 = new PropBundle();
        r5.f10382a = JavaOnlyMap.a(getProps());
        if (getEventHandlers() == null) goto L6;
        r5.f10383b = JavaOnlyArray.a(getEventHandlers());
    L6:
        if (getGestures() == null) goto L8;
        r5.f10384c = JavaOnlyArray.a(getGestures());
    L8:
        return r5;
    }
}
