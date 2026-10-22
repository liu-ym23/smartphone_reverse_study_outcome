package com.larus.bmhome.double_post.fragment;

import com.larus.bmhome.video.RecommendVideoData;
import com.larus.bmhome.video.SortRequestType;
import com.larus.bmhome.video.SortScene;
import java.util.List;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public interface w {
    void a();

    Object b(SortScene r1, SortRequestType r2, int r3, List<String> r4, List<String> r5, String r6, String r7, Continuation<? super RecommendVideoData> r8);

    Object c(SortScene r1, SortRequestType r2, int r3, List<String> r4, List<String> r5, String r6, String r7, Continuation<? super RecommendVideoData> r8);
}
