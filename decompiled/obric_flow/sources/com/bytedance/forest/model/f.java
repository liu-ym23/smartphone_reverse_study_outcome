package com.bytedance.forest.model;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.forest.utils.e f4372a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d f4373b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f4374c;

    public f(int r5, com.bytedance.forest.utils.e r10) {
        this.f4374c = r5;
        this.f4372a = r10;
        this.f4373b = new d(r5, r10);
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("Meta(buffer_size=");
        d r10 = this.f4373b;
        Integer r11 = null;
        if (r10 == null) goto L7;
        byte[] r12 = r10.e();
        if (r12 == null) goto L7;
        Integer r13 = Integer.valueOf(r12.length);
    L8:
        r5.append(r13);
        r5.append(", buffer_pos=");
        d r14 = this.f4373b;
        if (r14 == null) goto L11;
        r11 = Integer.valueOf(r14.f());
    L11:
        r5.append(r11);
        r5.append(')');
        return r5.toString();
    L7:
        r13 = null;
        goto L8
    }
}
