package com.larus.chat.gallery.api;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bg\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/larus/chat/gallery/api/IFindSimilarAvailabilityChecker;", "", "checkAvailability", "Lcom/larus/chat/gallery/api/FindSimilarAvailability;", "imageUri", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Delegate", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IFindSimilarAvailabilityChecker {
    public static final Delegate a = null;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010\rR\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/larus/chat/gallery/api/IFindSimilarAvailabilityChecker$Delegate;", "Lcom/larus/chat/gallery/api/IFindSimilarAvailabilityChecker;", "<init>", "()V", "impl", "getImpl", "()Lcom/larus/chat/gallery/api/IFindSimilarAvailabilityChecker;", "impl$delegate", "Lkotlin/Lazy;", "checkAvailability", "Lcom/larus/chat/gallery/api/FindSimilarAvailability;", "imageUri", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Delegate implements IFindSimilarAvailabilityChecker {
        public static final /* synthetic */ Delegate b = null;
        public static final Lazy<IFindSimilarAvailabilityChecker> c = null;

        private Delegate() {
        }

        static {
            b = new Delegate();
            c = LazyKt.lazy(new j());
        }

        @Override // com.larus.chat.gallery.api.IFindSimilarAvailabilityChecker
        public final Object a(String r2, Continuation<? super h> r3) {
            IFindSimilarAvailabilityChecker r0 = (IFindSimilarAvailabilityChecker) c.getValue();
            if (r0 != null) goto L7;
            h r4 = h.f;
            return h.f;
        L7:
            return r0.a(r2, r3);
        }
    }

    static {
        a = Delegate.b;
    }

    Object a(String r1, Continuation<? super h> r2);
}
