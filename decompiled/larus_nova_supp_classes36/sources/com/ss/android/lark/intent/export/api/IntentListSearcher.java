package com.ss.android.lark.intent.export.api;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\u00020\u0004J&\u0010\u0005\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0007\u0018\u00010\u00062\u0006\u0010\b\u001a\u00028\u0000H¦@¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/intent/export/api/IntentListSearcher;", "D", "T", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "", "searchIntentEntities", "Lkotlin/Result;", "", "searchContent", "searchIntentEntities-YNEx5aM", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public interface IntentListSearcher<D, T extends SearchBaseInfo> {
    /* JADX INFO: renamed from: searchIntentEntities-YNEx5aM, reason: not valid java name */
    Object m982searchIntentEntitiesYNEx5aM(D r1, Continuation<? super Result<? extends List<? extends T>>> r2);
}
