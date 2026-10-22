package com.google.protobuf;

/* JADX INFO: loaded from: classes2.dex */
public final class DiscardUnknownFieldsParser {
    private DiscardUnknownFieldsParser() {
    }

    public static final <T extends Message> Parser<T> wrap(final Parser<T> r10) {
        return new AnonymousClass1(r10);
    }
}
