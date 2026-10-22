package com.bytedance.android.live.browser.jsbridge.state;

import com.bytedance.android.live.browser.BrowserServiceImpl;
import com.bytedance.android.live.browser.jsbridge.i;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class a<T> implements i.c {

    @Inject
    public Gson a;
    public final char b;

    /* JADX INFO: renamed from: com.bytedance.android.live.browser.jsbridge.state.a$a, reason: collision with other inner class name */
    public static final class C0125a<T> {
        public final T a;

        public final boolean equals(Object r2) {
            if (this != r2) goto L4;
            return true;
        L4:
            if ((r2 instanceof C0125a) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.a, ((C0125a) r2).a) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            T r0 = this.a;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public final String toString() {
            return "NullableData(data=" + this.a + ")";
        }

        public C0125a(T r1) {
            this.a = r1;
        }
    }

    public abstract Object b();

    public abstract i.f<T> d();

    private a() {
        BrowserServiceImpl.Companion.getClass();
        this.a = (Gson) ((s20.b) BrowserServiceImpl.access$getDiComponent$cp()).i.get();
        this.a = (Gson) ((s20.b) BrowserServiceImpl.access$getDiComponent$cp()).a().a.i.get();
        this.b = '.';
    }

    public a<T> g() {
        Object r0 = b();
        if ((r0 instanceof JsonElement) == false) goto L5;
        JsonElement r2 = (JsonElement) r0;
    L10:
        return new e(this, r0, r2);
    L5:
        Gson r3 = this.a;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("gson");
    L8:
        r2 = GsonProtectorUtils.toJsonTree(r3, r0);
        goto L10
    }

    @Override // com.bytedance.android.live.browser.jsbridge.i.c
    public final String getKey() {
        return d().a();
    }

    public char c() {
        return this.b;
    }

    public /* synthetic */ a(int r1) {
        this();
    }

    public JsonElement e(String r4) {
        Intrinsics.checkNotNullParameter(r4, "key");
        Object r0 = b();
        if ((r0 instanceof JsonElement) == false) goto L5;
        JsonElement r1 = (JsonElement) r0;
    L10:
        if (r1.isJsonObject() == true) goto L13;
        return r1;
    L13:
        return f(r4, r1);
    L5:
        Gson r2 = this.a;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("gson");
    L8:
        r1 = GsonProtectorUtils.toJsonTree(r2, r0);
        goto L10
    }

    public final JsonElement f(String r9, JsonElement r11) {
        Intrinsics.checkNotNullParameter(r9, "keyParam");
        Intrinsics.checkNotNullParameter(r11, "element");
        int r7 = 0;
        List r12 = CollectionsKt.drop(StringsKt.split$default(r9, new char[]{c()}, false, 0, 6, null), 1);
        if (r12.isEmpty() == false) goto L5;
        return r11;
    L5:
        JsonElement r1 = new JsonObject();
        Iterator<T> r2 = r12.iterator();
        JsonElement r3 = r1;
    L7:
        if (r2.hasNext() == false) goto L20;
        T r4 = r2.next();
        int r5 = r7 + 1;
        if (r7 >= 0) goto L11;
        CollectionsKt.throwIndexOverflow();
    L11:
        String r6 = (String) r4;
        if (r11.isJsonObject() == false) goto L14;
        r11 = r11.getAsJsonObject().get(r6);
    L16:
        if (r7 != (r12.size() - 1)) goto L18;
        r3.getAsJsonObject().add(r6, r11);
    L19:
        r7 = r5;
        goto L7
    L18:
        JsonElement r8 = new JsonObject();
        r3.getAsJsonObject().add(r6, r8);
        Unit r13 = Unit.INSTANCE;
        r3 = r8;
        goto L19
    L14:
        r11 = JsonNull.INSTANCE;
        goto L16
    L20:
        return r1;
    }
}
