package com.obric.aiproactive.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/obric/aiproactive/api/AiRuleFollowupCountDto;", "", "aiFollowupNum", "", "manualFollowupNum", "officialFollowupNum", "<init>", "(III)V", "getAiFollowupNum", "()I", "getManualFollowupNum", "getOfficialFollowupNum", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "ai_proactive_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class aa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f6240a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f6241b;
    private final int c;

    public aa() {
        this(0, 0, 0, 7, null);
    }

    public aa(int r1, int r2, int r3) {
        this.f6240a = r1;
        this.f6241b = r2;
        this.c = r3;
    }

    public /* synthetic */ aa(int r2, int r3, int r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = 0;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = 0;
    L11:
        this(r2, r3, r4);
    }

    public final int a() {
        return this.f6240a;
    }

    public final int b() {
        return this.f6241b;
    }

    public final int c() {
        return this.c;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, aa.class) == true) goto L8;
        return false;
    L8:
        aa r6 = (aa) ZeusTransformUtils.preCheckCast(r5, aa.class, "com.obric.memorydata.plugin");
        if (this.f6240a == r6.f6240a) goto L12;
        return false;
    L12:
        if (this.f6241b == r6.f6241b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.f6240a) * 31) + Integer.hashCode(this.f6241b)) * 31) + Integer.hashCode(this.c);
    }

    public String toString() {
        return "AiRuleFollowupCountDto(aiFollowupNum=" + this.f6240a + ", manualFollowupNum=" + this.f6241b + ", officialFollowupNum=" + this.c + ')';
    }
}
