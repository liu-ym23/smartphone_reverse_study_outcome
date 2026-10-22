package com.bytedance.android.live.ktv.common.search.view;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.ktv.common.karaokestation.model.t;
import com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab.CommonSongListView;
import com.bytedance.android.live.ktv.common.ordersong.view.DialogLoadingView;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface q {
    String a();

    Function1<MultiTypeAdapter, Unit> b();

    void c(CommonSongListView r1);

    Function1<t, Unit> d(DialogLoadingView r1);

    com.bytedance.android.live.ktv.common.search.viewmodel.a e();

    boolean f();

    me.drakeet.multitype.b<MusicPanel, RecyclerView.ViewHolder> g();

    void onSearchEnter();

    void onSearchExit();

    void onSearchReset();
}
