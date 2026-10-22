package com.ss.android.lark.inline.ai.api.knowledgeai;

import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public abstract class e {

    public static final class a extends e {
        public final IKnowledgeAIControlInfo a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((a) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "AIControlEvent(control=" + this.a + ')';
        }

        public a(KnowledgeAIControlInfoBean r2) {
            Intrinsics.checkNotNullParameter(r2, "control");
            this.a = r2;
        }
    }

    public static final class b extends e {
        public final KnowledgeAIMessage<Serializable> a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((b) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "AIMessageEvent(message=" + this.a + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(KnowledgeAIMessage<? extends Serializable> r2) {
            Intrinsics.checkNotNullParameter(r2, INotificationHitPoint.NoticeType.MESSAGE);
            this.a = r2;
        }
    }

    public static final class c extends e {
        public final IKnowledgeAIRecommend a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((c) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "AIRecommendEvent(recommend=" + this.a + ')';
        }

        public c(IKnowledgeAIRecommend r2) {
            Intrinsics.checkNotNullParameter(r2, "recommend");
            this.a = r2;
        }
    }

    public static final class d extends e {
        public final f a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof d) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((d) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "AIScopeEvent(scope=" + this.a + ')';
        }

        public d(f r2) {
            Intrinsics.checkNotNullParameter(r2, "scope");
            this.a = r2;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.inline.ai.api.knowledgeai.e$e, reason: collision with other inner class name */
    public static final class C0099e extends e {
        public final IKnowledgeAIShow a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof C0099e) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((C0099e) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "AIShowEvent(show=" + this.a + ')';
        }

        public C0099e(IKnowledgeAIShow r2) {
            Intrinsics.checkNotNullParameter(r2, "show");
            this.a = r2;
        }
    }

    public e() {
    }
}
