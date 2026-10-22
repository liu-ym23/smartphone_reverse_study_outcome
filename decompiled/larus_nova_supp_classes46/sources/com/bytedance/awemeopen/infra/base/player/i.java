package com.bytedance.awemeopen.infra.base.player;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i {
    public final String a;
    public String b;
    public String c;
    public int d;
    public int e;
    public int f;
    public long g;
    public int h;
    public String i;
    public List<String> j;
    public String k;

    public static final class a {
    }

    static {
    }

    public final String toString() {
        return "PlayItem(vid='" + this.a + "', codecType='" + this.b + "', gearName='" + this.c + "', qualityType=" + this.d + ", width=" + this.e + ", height=" + this.f + ", dataSize=" + this.g + ", bitRate=" + this.h + ", urlKey='" + this.i + "', urlList=" + this.j + ", fileHash='" + this.k + "')";
    }

    public i(String r2) {
        Intrinsics.checkNotNullParameter(r2, "vid");
        this.a = r2;
        this.b = "";
        this.c = "";
        this.i = r2;
        this.k = "";
    }
}
