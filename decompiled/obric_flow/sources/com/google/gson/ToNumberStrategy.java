package com.google.gson;

import com.google.gson.stream.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public interface ToNumberStrategy {
    Number readNumber(JsonReader r5) throws IOException;
}
