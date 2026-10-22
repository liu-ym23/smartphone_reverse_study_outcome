package com.bytedance.android.live.ktv.common.search.viewmodel;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.ktv.common.model.api.s;
import com.bytedance.android.live.ktv.common.model.api.u;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface a {
    void continueSearch(String r1, String r2, Function1<? super Boolean, Unit> r3);

    void doSearch(String r1, boolean r2, String r3, boolean r4);

    com.bytedance.android.live.ktv.common.ordersong.feedback.a getCurPredicateContent();

    String getCurSearchInitText();

    String getCurSearchKeyword();

    xb0.a getExtraRequestData();

    String getSearchContentType();

    List<MusicPanel> getSearchedMusicList();

    boolean hasMoreSearchResult();

    void loadSearchHistory();

    void observeGuessWordListChange(LifecycleOwner r1, Observer<List<s>> r2);

    void observeHistoryListChange(LifecycleOwner r1, Observer<List<String>> r2);

    void observeHotWordListChange(LifecycleOwner r1, Observer<List<u>> r2);

    void observeSearchedMusicListChange(LifecycleOwner r1, Observer<List<MusicPanel>> r2);

    void onHotWordClick(String r1, boolean r2);

    void removeSearchHistory(String r1);

    void syncGuessWords(String r1);

    void syncHotWords();

    void updateCurSearchKeyword(String r1);

    void updateExtraRequestData(xb0.a r1);

    void updateHistoryCountPerPage(int r1);

    void updatePredicateContent(com.bytedance.android.live.ktv.common.ordersong.feedback.a r1);

    void updateSearchInitText(String r1);

    void updateSearchedMusicList(List<MusicPanel> r1);
}
