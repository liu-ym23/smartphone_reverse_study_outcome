package com.bytedance.retrofit2.mime;

/* JADX INFO: loaded from: classes.dex */
public class TypedString extends TypedByteArray {
    public TypedString(String r8) {
        super("text/plain; charset=UTF-8", convertToBytes(r8), new String[0]);
    }

    private static byte[] convertToBytes(String r8) {
        return r8.getBytes("UTF-8");
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    @Override // com.bytedance.retrofit2.mime.TypedByteArray
    public String toString() {
        return "TypedString[" + new String(getBytes(), "UTF-8") + "]";
    L6:
        throw new AssertionError("Must be able to decode UTF-8");
    }
}
