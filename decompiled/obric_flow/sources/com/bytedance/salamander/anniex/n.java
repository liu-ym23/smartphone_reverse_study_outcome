package com.bytedance.salamander.anniex;

import ai.j0;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f7268b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f7269c;

    public /* synthetic */ n(int r5, String r10, int r11) {
        this.f7267a = r11;
        this.f7268b = r5;
        this.f7269c = r10;
    }

    public String toString() {
        switch(this.f7267a) {
            case 3: goto L8;
            case 4: goto L6;
            default: goto L5;
        };
    L6:
        StringBuilder r5 = new StringBuilder("UrlResponse{statusCode=");
        r5.append(this.f7268b);
        r5.append(", originalData=");
        r5.append(Arrays.toString(null));
        r5.append(", errorMsg='");
        return j0.q(r5, this.f7269c, "', headers=null}");
    L8:
        StringBuilder r10 = new StringBuilder("{\"code\": ");
        r10.append(this.f7268b);
        r10.append(",\"msg\": ");
        String r11 = this.f7269c;
        if (r11 != null) goto L12;
        r11 = "";
    L12:
        return j0.q(r10, r11, ", \"templateLoadFrom\": unknown, \"templateFilePath\": ");
    L5:
        return super.toString();
    }

    public n(int r5) {
        this.f7267a = r5;
        switch(r5) {
            case 4: goto L9;
            case 5: goto L6;
            default: goto L4;
        };
    L4:
        this.f7268b = 201;
        return;
    L6:
        this.f7268b = -1;
        return;
    }

    public n(String r5, int r10) {
        this.f7267a = 3;
        this.f7269c = r5;
        this.f7268b = r10;
    }
}
