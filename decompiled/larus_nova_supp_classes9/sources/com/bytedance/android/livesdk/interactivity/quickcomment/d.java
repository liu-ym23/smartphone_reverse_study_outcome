package com.bytedance.android.livesdk.interactivity.quickcomment;

import com.bytedance.android.livesdk.interactivity.api.quickcomment.IQuickCommentShowWord;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d implements com.bytedance.android.livesdk.interactivity.api.quickcomment.e {
    public final List<IQuickCommentShowWord> b;
    public final int c;
    public int d;

    @Override // com.bytedance.android.livesdk.interactivity.api.quickcomment.e
    public final List<IQuickCommentShowWord> a() {
        return this.b;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.quickcomment.e
    public final int getDuration() {
        return this.c;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.quickcomment.e
    public int getType() {
        return this.d;
    }

    public d(com.bytedance.android.livesdk.interactivity.api.quickcomment.g r8) {
        Intrinsics.checkNotNullParameter(r8, "syncData");
        ArrayList r1 = new ArrayList();
        this.b = r1;
        this.c = 30;
        Intrinsics.checkNotNullParameter(r8, "syncData");
        List<String> r0 = r8.supportComments;
        if (r0 == null) goto L13;
        int r2 = r8.commentType;
        this.d = r2;
        com.bytedance.android.livesdk.interactivity.api.quickcomment.e.a.getClass();
        if (r2 == 1) goto L7;
    L9:
        Iterator<String> r3 = r0.iterator();
    L11:
        if (r3.hasNext() == false) goto L16;
        String r4 = r3.next();
        this.b.add(new QuickCommentShowWord(r4, r8.commentType, r8.backgroundColor));
        goto L11
    L16:
        return;
    L7:
        if (r0.size() <= 2) goto L9;
        ArrayList r5 = new ArrayList();
        r5.addAll(r0);
        Random.Default r6 = Random.Default;
        String r7 = (String) CollectionsKt.random(r5, r6);
        r1.add(new QuickCommentShowWord(r7, r8.commentType, r8.backgroundColor));
        r5.remove(r7);
        r1.add(new QuickCommentShowWord((String) CollectionsKt.random(r5, r6), r8.commentType, r8.backgroundColor));
        return;
    }
}
