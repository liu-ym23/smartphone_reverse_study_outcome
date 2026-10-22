package com.google.protobuf;

/* JADX INFO: loaded from: classes.dex */
public abstract class GeneratedFile {
    public GeneratedFile() {
    }

    public static void addOptionalExtension(ExtensionRegistry r8, String r10, String r11) {
        r8.add((GeneratedMessage.GeneratedExtension) Class.forName(r10).getField(r11).get(null));     // Catch: Throwable -> L4
        return;
    }
}
