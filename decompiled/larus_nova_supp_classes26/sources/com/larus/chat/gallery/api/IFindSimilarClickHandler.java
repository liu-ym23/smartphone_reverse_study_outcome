package com.larus.chat.gallery.api;

import android.content.Context;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 \f2\u00020\u0001:\u0001\fJ6\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\r"}, d2 = {"Lcom/larus/chat/gallery/api/IFindSimilarClickHandler;", "", "handleFindSimilarClick", "", "context", "Landroid/content/Context;", "imageUri", "", "messageId", "sendText", "sender", "Lcom/larus/chat/gallery/api/FindSimilarSender;", "Delegate", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IFindSimilarClickHandler {
    public static final Delegate a = null;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J6\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/larus/chat/gallery/api/IFindSimilarClickHandler$Delegate;", "Lcom/larus/chat/gallery/api/IFindSimilarClickHandler;", "<init>", "()V", "impl", "getImpl", "()Lcom/larus/chat/gallery/api/IFindSimilarClickHandler;", "impl$delegate", "Lkotlin/Lazy;", "handleFindSimilarClick", "", "context", "Landroid/content/Context;", "imageUri", "", "messageId", "sendText", "sender", "Lcom/larus/chat/gallery/api/FindSimilarSender;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Delegate implements IFindSimilarClickHandler {
        public static final /* synthetic */ Delegate b = null;
        public static final Lazy<IFindSimilarClickHandler> c = null;

        private Delegate() {
        }

        static {
            b = new Delegate();
            c = LazyKt.lazy(new k());
        }

        @Override // com.larus.chat.gallery.api.IFindSimilarClickHandler
        public final boolean a(Context r8, String r9, String r10, String r11, com.larus.chat.gallery.impl.providers.h r12) {
            Intrinsics.checkNotNullParameter(r8, "context");
            Intrinsics.checkNotNullParameter(r12, "sender");
            IFindSimilarClickHandler r1 = (IFindSimilarClickHandler) c.getValue();
            if (r1 != null) goto L7;
            return false;
        L7:
            return r1.a(r8, r9, r10, r11, r12);
        }
    }

    static {
        a = Delegate.b;
    }

    boolean a(Context r1, String r2, String r3, String r4, com.larus.chat.gallery.impl.providers.h r5);
}
