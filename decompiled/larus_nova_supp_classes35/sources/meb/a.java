package meb;

import com.google.gson.Gson;
import com.ss.android.lark.feed.molten.serializer.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public final Gson a;
    public final e b;

    public a(Gson r2, f r3) {
        Intrinsics.checkNotNullParameter(r2, "defaultGson");
        Intrinsics.checkNotNullParameter(r3, "uiFeedCardCodec");
        this.a = r2;
        this.b = r3;
    }
}
