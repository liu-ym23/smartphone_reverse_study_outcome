package com.google.protobuf;

/* JADX INFO: loaded from: classes2.dex */
@CheckReturnValue
final class OneofInfo {
    private final java.lang.reflect.Field caseField;
    private final int id;
    private final java.lang.reflect.Field valueField;

    public OneofInfo(int r10, java.lang.reflect.Field r11, java.lang.reflect.Field r12) {
        this.id = r10;
        this.caseField = r11;
        this.valueField = r12;
    }

    public java.lang.reflect.Field getCaseField() {
        return this.caseField;
    }

    public int getId() {
        return this.id;
    }

    public java.lang.reflect.Field getValueField() {
        return this.valueField;
    }
}
