package com.obric.aiproactive.impl.livecard;

import com.obric.aiproactive.api.AiProactiveCardStatus;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/aiproactive/impl/livecard/AiProactiveLockScreenDbMutation;", "", "UpdateStatus", "MarkCurrentActionExecuted", "Lcom/obric/aiproactive/impl/livecard/AiProactiveLockScreenDbMutation$MarkCurrentActionExecuted;", "Lcom/obric/aiproactive/impl/livecard/AiProactiveLockScreenDbMutation$UpdateStatus;", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface c {

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/obric/aiproactive/impl/livecard/AiProactiveLockScreenDbMutation$MarkCurrentActionExecuted;", "Lcom/obric/aiproactive/impl/livecard/AiProactiveLockScreenDbMutation;", "recommendationId", "", "<init>", "(J)V", "getRecommendationId", "()J", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f6459a;

        public a(long r1) {
            this.f6459a = r1;
        }

        public final long a() {
            return this.f6459a;
        }

        public boolean equals(Object r7) {
            if (this != r7) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r7, a.class) == true) goto L8;
            return false;
        L8:
            a r8 = (a) ZeusTransformUtils.preCheckCast(r7, a.class, "com.obric.memorydata.plugin");
            if (this.f6459a == r8.f6459a) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return Long.hashCode(this.f6459a);
        }

        public String toString() {
            return "MarkCurrentActionExecuted(recommendationId=" + this.f6459a + ')';
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/obric/aiproactive/impl/livecard/AiProactiveLockScreenDbMutation$UpdateStatus;", "Lcom/obric/aiproactive/impl/livecard/AiProactiveLockScreenDbMutation;", "recommendationId", "", "cardStatus", "Lcom/obric/aiproactive/api/AiProactiveCardStatus;", "<init>", "(JLcom/obric/aiproactive/api/AiProactiveCardStatus;)V", "getRecommendationId", "()J", "getCardStatus", "()Lcom/obric/aiproactive/api/AiProactiveCardStatus;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f6460a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AiProactiveCardStatus f6461b;

        public b(long r2, AiProactiveCardStatus r4) {
            Intrinsics.checkNotNullParameter(r4, "cardStatus");
            this.f6460a = r2;
            this.f6461b = r4;
        }

        public final long a() {
            return this.f6460a;
        }

        public final AiProactiveCardStatus b() {
            return this.f6461b;
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, b.class) == true) goto L8;
            return false;
        L8:
            b r10 = (b) ZeusTransformUtils.preCheckCast(r9, b.class, "com.obric.memorydata.plugin");
            if (this.f6460a == r10.f6460a) goto L12;
            return false;
        L12:
            if (this.f6461b == r10.f6461b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Long.hashCode(this.f6460a) * 31) + this.f6461b.hashCode();
        }

        public String toString() {
            return "UpdateStatus(recommendationId=" + this.f6460a + ", cardStatus=" + this.f6461b + ')';
        }
    }
}
