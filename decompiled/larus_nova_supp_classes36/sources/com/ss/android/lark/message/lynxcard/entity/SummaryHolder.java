package com.ss.android.lark.message.lynxcard.entity;

import androidx.collection.LruCache;
import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.ss.android.lark.chat.entity.message.content.CardContent;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@ClaymoreImpl(com.ss.android.lark.chat.entity.message.content.a.class)
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0002\b\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/message/lynxcard/entity/SummaryHolder;", "Lcom/ss/android/lark/chat/entity/message/content/ISummaryAPI;", "<init>", "()V", "getSummary", "", "content", "Lcom/ss/android/lark/chat/entity/message/content/CardContent;", "Summary", "Companion", "message-card_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class SummaryHolder implements com.ss.android.lark.chat.entity.message.content.a {
    public static final a Companion = null;
    public static final String TAG = "SummaryHolder";
    private static final LruCache<String, b> dataMap = null;

    public static final class a {
        public a() {
        }
    }

    public static final class b {
        public final String a;
        public final String b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            String r1 = this.b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "Summary(digest=" + this.a + ", translateDigest=" + this.b + ')';
        }

        public b(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "digest");
            this.a = r2;
            this.b = r3;
        }
    }

    public SummaryHolder() {
    }

    static {
        Companion = new a();
        dataMap = new LruCache(20);
    }

    public static final /* synthetic */ LruCache access$getDataMap$cp() {
        return dataMap;
    }

    public String getSummary(CardContent r4) {
        Intrinsics.checkNotNullParameter(r4, "content");
        String r0 = r4.getMessageId();
        if (r0 == null) goto L5;
        b r1 = (b) dataMap.get(r0);
    L7:
        if (r1 != null) goto L9;
        return "";
    L9:
        if (Intrinsics.areEqual(r4.isTranslate(), Boolean.TRUE) == false) goto L16;
        String r5 = r1.b;
        if (r5 != null) goto L14;
        return "";
    L14:
        return r5;
    L16:
        return r1.a;
    L5:
        r1 = null;
        goto L7
    }
}
