package com.larus.bmhome.taskskill.service;

import com.larus.im.internal.jni.bean.OmniConversationSortType;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u0017J\b\u0010\u0002\u001a\u00020\u0003H&J \u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH¦@¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H¦@¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u000e\u001a\u00020\u000fH¦@¢\u0006\u0002\u0010\rJ\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0010\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H&¨\u0006\u0018"}, d2 = {"Lcom/larus/bmhome/taskskill/service/IProjectListDataSource;", "", "getList", "Lcom/larus/bmhome/taskskill/service/ProjectListSnapshot;", "getProject", "Lkotlin/Result;", "Lcom/larus/bmhome/taskskill/service/ProjectListItem;", "projectId", "", "getProject-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadMore", "loadMore-IoAF18A", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refresh", "", "updateConversationSortType", "sortType", "Lcom/larus/im/internal/jni/bean/OmniConversationSortType;", "registerListener", "listener", "Lcom/larus/bmhome/taskskill/service/IProjectListDataSource$Listener;", "unregisterListener", "Listener", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IProjectListDataSource {

    public interface a {
        void a(i r1);
    }

    Object a(Continuation<? super Unit> r1);

    void b(a r1);

    void c(a r1);

    Object d(Continuation<? super Result<i>> r1);

    void e(OmniConversationSortType r1);

    Object f(String r1, Continuation<? super Result<h>> r2);

    i getList();
}
