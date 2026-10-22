package com.larus.business.markdown.impl.markwon.custom.title;

import android.text.NoCopySpan;
import com.larus.business.markdown.api.FullScreenDetailType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c implements NoCopySpan, gw8.b {
    public final String a;
    public final String b;
    public final String c;
    public final FullScreenDetailType d;
    public final boolean e;
    public final boolean f;

    @Override // gw8.b
    public final String a() {
        return this.c;
    }

    @Override // gw8.b
    public final String getContent() {
        return this.b;
    }

    @Override // gw8.b
    public final String getInfo() {
        return this.a;
    }

    @Override // gw8.b
    public FullScreenDetailType getType() {
        return this.d;
    }

    @Override // gw8.b
    public final boolean isPreview() {
        return this.f;
    }

    public /* synthetic */ c(String r8, String r9, String r10, FullScreenDetailType r11, boolean r12) {
        this(r8, r9, r10, r11, r12, false);
    }

    public c(String r2, String r3, String r4, FullScreenDetailType r5, boolean r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r2, "info");
        Intrinsics.checkNotNullParameter(r3, "content");
        Intrinsics.checkNotNullParameter(r4, "copyContent");
        Intrinsics.checkNotNullParameter(r5, "type");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
