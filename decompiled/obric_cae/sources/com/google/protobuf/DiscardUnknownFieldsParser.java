package com.google.protobuf;

/* JADX INFO: loaded from: classes.dex */
public final class DiscardUnknownFieldsParser {
    private DiscardUnknownFieldsParser() {
    }

    public static final <T extends Message> Parser<T> wrap(final Parser<T> r8) {
        return new AnonymousClass1(r8);
    }
}
