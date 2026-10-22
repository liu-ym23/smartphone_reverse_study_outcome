package com.larus.avlink.env.diary.detail;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.larus.im.bean.message.block.Block;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b0 implements w88.s {
    public final DiaryDetailAdapter a;
    public final RecyclerView b;

    public static final class a {
    }

    static {
    }

    public final void clear() {
        this.a.submitList(CollectionsKt.emptyList());
    }

    public final RecyclerView getView() {
        return this.b;
    }

    public final void a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "detailJson");
        i98.a r6 = (i98.a) new Gson().fromJson(r5, i98.a.class);     // Catch: Exception -> L5
    L7:
        if (r6 != null) goto L9;
        return;
    L9:
        DiaryDetailAdapter r0 = this.a;
        ArrayList r1 = new ArrayList();
        String r2 = r6.m();
        if (r2 != null) goto L12;
    L15:
        boolean r3 = true;
    L16:
        if (r3 == true) goto L18;
        r1.add(new g.e(r6.m()));
    L18:
        List<Block> r7 = r6.c();
        if (r7 == null) goto L24;
        Iterator<T> r8 = r7.iterator();
    L22:
        if (r8.hasNext() == false) goto L24;
        r1.add(new g.a((Block) r8.next()));
    L24:
        r0.submitList(r1);
        return;
    L12:
        if (r2.length() == 0) goto L15;
        r3 = false;
    L5:
        e = move-exception;
        FLogger.a.e("DoraDiaryDetailContentView", "bindDetail parse failed: " + e.getMessage());
        r6 = null;
        goto L7
    }

    public b0(Context r3, Fragment r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "fragment");
        DiaryDetailAdapter r0 = new DiaryDetailAdapter(r3, r4, new com.larus.avlink.env.diary.detail.a());
        this.a = r0;
        RecyclerView r5 = new RecyclerView(r3);
        r5.setLayoutManager(new LinearLayoutManager(r3));
        r5.setOverScrollMode(2);
        r5.setAdapter(r0);
        this.b = r5;
    }
}
