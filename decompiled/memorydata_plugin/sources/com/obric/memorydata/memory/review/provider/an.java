package com.obric.memorydata.memory.review.provider;

import com.bytedance.common.wschannel.WsConstants;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0080\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u001c\u001a\u00020\rJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÆ\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030\bHÆ\u0003J\t\u0010!\u001a\u00020\u0006HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\rHÆ\u0003J_\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\u0006HÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006+"}, d2 = {"Lcom/obric/memorydata/memory/review/provider/MemoryReviewUserFeedbackRequest;", "", "uniqId", "", AILabCheckPermissionTask.KEY_SOURCE, "module", "", "tags", "", "feedbackType", Params.CONTENT, "logId", WsConstants.KEY_EXTRA, "Lorg/json/JSONObject;", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/util/List;ILjava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)V", "getUniqId", "()Ljava/lang/String;", "getSource", "getModule", "()I", "getTags", "()Ljava/util/List;", "getFeedbackType", "getContent", "getLogId", "getExtra", "()Lorg/json/JSONObject;", "toJson", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class an {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10419a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10420b;
    private final int c;
    private final List<String> d;
    private final int e;
    private final String f;
    private final String g;
    private final JSONObject h;

    public an(String r3, String r4, int r5, List<String> r6, int r7, String r8, String r9, JSONObject r10) {
        List<String> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "uniqId");
        Intrinsics.checkNotNullParameter(r4, AILabCheckPermissionTask.KEY_SOURCE);
        Intrinsics.checkNotNullParameter(r11, "tags");
        Intrinsics.checkNotNullParameter(r8, Params.CONTENT);
        Intrinsics.checkNotNullParameter(r9, "logId");
        Intrinsics.checkNotNullParameter(r10, WsConstants.KEY_EXTRA);
        this.f10419a = r3;
        this.f10420b = r4;
        this.c = r5;
        this.d = r11;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
    }

    public final String a() {
        return this.f10419a;
    }

    public final JSONObject b() {
        JSONObject r5 = new JSONObject().put("uniq_id", this.f10419a).put(AILabCheckPermissionTask.KEY_SOURCE, this.f10420b).put("module", this.c).put("tags", new JSONArray((Collection) ZeusTransformUtils.preCheckCast(this.d, Collection.class, "com.obric.memorydata.plugin"))).put("feedback_type", this.e).put(Params.CONTENT, this.f).put("log_id", this.g).put(WsConstants.KEY_EXTRA, this.h.toString());
        Intrinsics.checkNotNullExpressionValue(r5, "put(...)");
        return r5;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, an.class) == true) goto L8;
        return false;
    L8:
        an r6 = (an) ZeusTransformUtils.preCheckCast(r5, an.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f10419a, r6.f10419a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f10420b, r6.f10420b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        return (((((((((((((this.f10419a.hashCode() * 31) + this.f10420b.hashCode()) * 31) + Integer.hashCode(this.c)) * 31) + this.d.hashCode()) * 31) + Integer.hashCode(this.e)) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode();
    }

    public String toString() {
        return "MemoryReviewUserFeedbackRequest(uniqId=" + this.f10419a + ", source=" + this.f10420b + ", module=" + this.c + ", tags=" + this.d + ", feedbackType=" + this.e + ", content=" + this.f + ", logId=" + this.g + ", extra=" + this.h + ')';
    }
}
