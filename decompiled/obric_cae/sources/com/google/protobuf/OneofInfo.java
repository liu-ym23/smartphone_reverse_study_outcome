package com.google.protobuf;

/* JADX INFO: loaded from: classes.dex */
@CheckReturnValue
final class OneofInfo {
    private final java.lang.reflect.Field caseField;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final int f5189id;
    private final java.lang.reflect.Field valueField;

    public OneofInfo(int r8, java.lang.reflect.Field r10, java.lang.reflect.Field r11) {
        this.f5189id = r8;
        this.caseField = r10;
        this.valueField = r11;
    }

    public java.lang.reflect.Field getCaseField() {
        return this.caseField;
    }

    public int getId() {
        return this.f5189id;
    }

    public java.lang.reflect.Field getValueField() {
        return this.valueField;
    }
}
