package com.bytedance.android.ec.core;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/ec/core/MainCommentLinearLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MainCommentLinearLayoutManager extends LinearLayoutManager {
    public MainCommentLinearLayoutManager(Context r10, RecyclerView r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "recyclerView");
        super(r10);
    }
}
