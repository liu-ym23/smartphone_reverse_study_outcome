package com.ss.ugc.effectplatform.model.net;

import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J)\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/Block_list;", "", "uri", "", "block_start", "", "block_end", "(Ljava/lang/String;JJ)V", "getBlock_end", "()J", "setBlock_end", "(J)V", "getBlock_start", "setBlock_start", "getUri", "()Ljava/lang/String;", "setUri", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "equals", "", INotificationHitPoint.NoticeType.OTHER, "hashCode", "", "toString", "effectplatform_release"}, k = 1, mv = {1, 1, 16})
public final class Block_list {
    private long block_end;
    private long block_start;
    private String uri;

    public Block_list() {
        this(null, 0, 0, 7, null);
    }

    public static /* synthetic */ Block_list copy$default(Block_list r2, String r3, long r4, long r6, int r8, Object r9) {
        if ((r8 & 1) == 0) goto L6;
        r3 = r2.uri;
    L6:
        if ((r8 & 2) == 0) goto L8;
        r4 = r2.block_start;
    L8:
        long r0 = r4;
        if ((r8 & 4) == 0) goto L11;
        r6 = r2.block_end;
    L11:
        String r5 = r3;
        return r2.copy(r5, r0, r6);
    }

    public final String component1() {
        return this.uri;
    }

    public final long component2() {
        return this.block_start;
    }

    public final long component3() {
        return this.block_end;
    }

    public final Block_list copy(String r8, long r9, long r11) {
        return new Block_list(r8, r9, r11);
    }

    public boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof Block_list) == false) goto L12;
        Block_list r7 = (Block_list) r6;
        if (Intrinsics.areEqual(this.uri, r7.uri) == true) goto L8;
        return false;
    L8:
        if (this.block_start == r7.block_start) goto L10;
        return false;
    L10:
        if (this.block_end == r7.block_end) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        String r0 = this.uri;
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L6:
        long r2 = this.block_start;
        int r3 = ((r1 * 31) + ((int) (r2 ^ (r2 >>> 32)))) * 31;
        long r4 = this.block_end;
        return r3 + ((int) (r4 ^ (r4 >>> 32)));
    L5:
        r1 = 0;
        goto L6
    }

    public String toString() {
        return "Block_list(uri=" + this.uri + ", block_start=" + this.block_start + ", block_end=" + this.block_end + ")";
    }

    public final long getBlock_end() {
        return this.block_end;
    }

    public final long getBlock_start() {
        return this.block_start;
    }

    public final String getUri() {
        return this.uri;
    }

    public final void setBlock_end(long r1) {
        this.block_end = r1;
    }

    public final void setBlock_start(long r1) {
        this.block_start = r1;
    }

    public final void setUri(String r1) {
        this.uri = r1;
    }

    public Block_list(String r1, long r2, long r4) {
        this.uri = r1;
        this.block_start = r2;
        this.block_end = r4;
    }

    public /* synthetic */ Block_list(String r5, long r6, long r8, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L6;
        r5 = null;
    L6:
        if ((r10 & 2) == 0) goto L8;
        long r2 = 0;
    L10:
        if ((r10 & 4) == 0) goto L12;
        long r12 = 0;
    L13:
        this(r5, r2, r12);
        return;
    L12:
        r12 = r8;
        goto L13
    L8:
        r2 = r6;
        goto L10
    }
}
