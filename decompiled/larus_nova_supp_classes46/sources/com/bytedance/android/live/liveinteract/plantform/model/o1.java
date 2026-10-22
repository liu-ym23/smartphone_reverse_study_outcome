package com.bytedance.android.live.liveinteract.plantform.model;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class o1 implements am3.c<ListTag> {
    public o1() {
    }

    public final Object decode(am3.g r6) throws Exception {
        ListTag r0 = new ListTag();
        r0.setThreadSafe(false);
        long r1 = r6.c();
    L3:
        int r3 = r6.f();
        if (r3 == (-1)) goto L15;
        am3.g.a r4 = r0.decodeExtensionFields(r3, r6);
        switch(r3) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L8;
            default: goto L7;
        };
    L8:
        r0.ecomFansClubTag = (ListTag.ListTagEcomFansClubContent) vh7.f.a(r6, ListTag.ListTagEcomFansClubContent.class);
        goto L3
    L9:
        r0.ecomViewTag = (ListTag.ListTagEcomViewContent) vh7.f.a(r6, ListTag.ListTagEcomViewContent.class);
        goto L3
    L10:
        r0.listTagFansContent = (ListTag.ListTagFansContent) vh7.f.a(r6, ListTag.ListTagFansContent.class);
        goto L3
    L11:
        r0.listTagFriendContent = (ListTag.ListTagFriendContent) vh7.f.a(r6, ListTag.ListTagFriendContent.class);
        goto L3
    L12:
        r0.listTagHonorLevelContent = (ListTag.ListTagHonorLevelContent) vh7.f.a(r6, ListTag.ListTagHonorLevelContent.class);
        goto L3
    L13:
        r0.listTagFansClubContent = (ListTag.ListTagFansClubContent) vh7.f.a(r6, ListTag.ListTagFansClubContent.class);
        goto L3
    L14:
        r0.type = r6.i();
        goto L3
    L7:
        am3.h.d(r4, r6);
        goto L3
    L15:
        r6.d(r1);
        r0.setThreadSafe(true);
        return r0;
    }
}
