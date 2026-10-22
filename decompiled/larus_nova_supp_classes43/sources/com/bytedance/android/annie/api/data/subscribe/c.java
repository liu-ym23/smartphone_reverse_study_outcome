package com.bytedance.android.annie.api.data.subscribe;

import com.google.gson.JsonElement;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c<T> implements g<T> {
    public final g<T> a;
    public final T b;
    public final JsonElement c;

    @Override // com.bytedance.android.annie.api.data.subscribe.g
    public final /* synthetic */ g c() {
        return f.e(this);
    }

    @Override // com.bytedance.android.annie.api.data.subscribe.g
    public final /* synthetic */ char d() {
        return '.';
    }

    @Override // com.bytedance.android.annie.api.data.subscribe.g
    public final /* synthetic */ JsonElement f(String r1, JsonElement r10) {
        return f.c(this, r1, r10);
    }

    @Override // com.bytedance.android.annie.api.data.subscribe.g
    public final /* synthetic */ JsonElement h(List r1, JsonElement r10) {
        return f.d(r1, r10);
    }

    @Override // com.bytedance.android.annie.api.data.subscribe.g
    public final String key() {
        return this.a.key();
    }

    @Override // com.bytedance.android.annie.api.data.subscribe.g
    public final T g() {
        return this.b;
    }

    @Override // com.bytedance.android.annie.api.data.subscribe.g
    public final JsonElement a(String r10) {
        Intrinsics.checkNotNullParameter(r10, "key");
        if (this.c.isJsonObject() == true) goto L7;
        return this.c;
    L7:
        return f.c(this, r10, this.c);
    }

    @Override // com.bytedance.android.annie.api.data.subscribe.g
    public final JsonElement e(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "key");
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_URL);
        return a(r10);
    }

    public c(g<T> r10, T r11, JsonElement r12) {
        Intrinsics.checkNotNullParameter(r10, "delegate");
        Intrinsics.checkNotNullParameter(r12, "jsonElement");
        this.a = r10;
        this.b = r11;
        this.c = r12;
    }
}
