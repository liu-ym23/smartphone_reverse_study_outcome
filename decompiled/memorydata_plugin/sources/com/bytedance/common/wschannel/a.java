package com.bytedance.common.wschannel;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f2001a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    String f2002b;
    String c;
    Map<String, String> d;
    Map<String, String> e;
    List<String> f;
    int g;
    int h;
    String i;
    int j;

    public String toString() {
        return "ChannelInfo{channelId = " + this.f2001a + ", deviceId = " + this.f2002b + ", installId = " + this.c + ", fpid = " + this.g + ", aid = " + this.h + ", updateVersionCode = " + this.j + ", appKey = " + this.i + ", header = " + this.e + ", extra = " + this.d + ", urls = " + this.f + "}";
    }
}
