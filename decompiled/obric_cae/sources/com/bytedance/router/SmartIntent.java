package com.bytedance.router;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import defpackage.b;

/* JADX INFO: loaded from: classes.dex */
class SmartIntent extends Intent {
    public static void t(String r8, Object r10, String r11, Object r12, RuntimeException r13) {
        StringBuilder r14 = b.i("Key ", r8, " expected ", r11, " but value was a ");
        r14.append(r10.getClass().getName());
        r14.append(".  The default value ");
        r14.append(r12);
        r14.append(" was returned.");
        Log.w("SmartIntent", r14.toString());
        if (r13 == null) goto L6;
        Log.w("SmartIntent", "Attempt to cast generated internal exception:", r13);
        return;
    }

    @Override // android.content.Intent
    public final boolean getBooleanExtra(String r8, boolean r10) {
        Bundle r11 = super.getExtras();
        if (r11 != null) goto L5;
        return r10;
    L5:
        Object r12 = r11.get(r8);
        if (r12 != null) goto L9;
        return r10;
    L9:
        if ((r12 instanceof String) == false) goto L13;
        return Boolean.parseBoolean((String) r12);
    L14:
        e = move-exception;
        t(r8, r12, "Boolean", Boolean.valueOf(r10), e);
        return r10;
    L13:
        return ((Boolean) r12).booleanValue();
    }

    @Override // android.content.Intent
    public final byte getByteExtra(String r8, byte r10) {
        Bundle r11 = super.getExtras();
        if (r11 != null) goto L5;
        return r10;
    L5:
        Object r12 = r11.get(r8);
        if (r12 != null) goto L9;
        return r10;
    L9:
        if ((r12 instanceof String) == false) goto L13;
        return Byte.parseByte((String) r12);
    L14:
        e = move-exception;
        t(r8, r12, "Byte", Byte.valueOf(r10), e);
        return r10;
    L13:
        return ((Byte) r12).byteValue();
    }

    @Override // android.content.Intent
    public final char getCharExtra(String r8, char r10) {
        Bundle r11 = super.getExtras();
        if (r11 != null) goto L5;
        return r10;
    L5:
        Object r12 = r11.get(r8);
        if (r12 != null) goto L9;
        return r10;
    L9:
        if ((r12 instanceof String) == false) goto L21;
        String r13 = (String) r12;
        if (r13.length() == 1) goto L13;
        Character r14 = Character.valueOf(r10);
        ClassCastException r15 = null;
    L19:
        t(r8, r12, "Char", r14, r15);
        return r10;
    L13:
        return r13.charAt(0);
    L21:
        return ((Character) r12).charValue();
    L17:
        e = move-exception;
        r15 = e;
        r14 = Character.valueOf(r10);
        goto L19
    }

    @Override // android.content.Intent
    public final double getDoubleExtra(String r8, double r10) {
        Bundle r11 = super.getExtras();
        if (r11 != null) goto L5;
        return r10;
    L5:
        Object r12 = r11.get(r8);
        if (r12 != null) goto L9;
        return r10;
    L9:
        if ((r12 instanceof String) == false) goto L13;
        return Double.parseDouble((String) r12);
    L14:
        e = move-exception;
        t(r8, r12, "Double", Double.valueOf(r10), e);
        return r10;
    L13:
        return ((Double) r12).doubleValue();
    }

    @Override // android.content.Intent
    public final Bundle getExtras() {
        return super.getExtras();
    }

    @Override // android.content.Intent
    public final float getFloatExtra(String r8, float r10) {
        Bundle r11 = super.getExtras();
        if (r11 != null) goto L5;
        return r10;
    L5:
        Object r12 = r11.get(r8);
        if (r12 != null) goto L9;
        return r10;
    L9:
        if ((r12 instanceof String) == false) goto L13;
        return Float.parseFloat((String) r12);
    L14:
        e = move-exception;
        t(r8, r12, "Float", Float.valueOf(r10), e);
        return r10;
    L13:
        return ((Float) r12).floatValue();
    }

    @Override // android.content.Intent
    public final int getIntExtra(String r8, int r10) {
        Bundle r11 = super.getExtras();
        if (r11 != null) goto L5;
        return r10;
    L5:
        Object r12 = r11.get(r8);
        if (r12 != null) goto L9;
        return r10;
    L9:
        if ((r12 instanceof String) == false) goto L13;
        return Integer.parseInt((String) r12);
    L14:
        e = move-exception;
        t(r8, r12, "Integer", Integer.valueOf(r10), e);
        return r10;
    L13:
        return ((Integer) r12).intValue();
    }

    @Override // android.content.Intent
    public final long getLongExtra(String r8, long r10) {
        Bundle r11 = super.getExtras();
        if (r11 != null) goto L5;
        return r10;
    L5:
        Object r12 = r11.get(r8);
        if (r12 != null) goto L9;
        return r10;
    L9:
        if ((r12 instanceof String) == false) goto L13;
        return Long.parseLong((String) r12);
    L14:
        e = move-exception;
        t(r8, r12, "Long", Long.valueOf(r10), e);
        return r10;
    L13:
        return ((Long) r12).longValue();
    }

    @Override // android.content.Intent
    public final short getShortExtra(String r8, short r10) {
        Bundle r11 = super.getExtras();
        if (r11 != null) goto L5;
        return r10;
    L5:
        Object r12 = r11.get(r8);
        if (r12 != null) goto L9;
        return r10;
    L9:
        if ((r12 instanceof String) == false) goto L13;
        return Short.valueOf(Short.parseShort((String) r12)).shortValue();
    L14:
        e = move-exception;
        t(r8, r12, "Short", Short.valueOf(r10), e);
        return r10;
    L13:
        return ((Short) r12).shortValue();
    }
}
