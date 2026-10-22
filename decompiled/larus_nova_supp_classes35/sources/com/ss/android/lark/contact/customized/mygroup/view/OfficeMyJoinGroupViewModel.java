package com.ss.android.lark.contact.customized.mygroup.view;

import android.os.SystemClock;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000  2\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007J\u0006\u0010\u0019\u001a\u00020\u000bJ\u0006\u0010\u001a\u001a\u00020\u000bJ\u0006\u0010\u001b\u001a\u00020\tJ\u001a\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000f0\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015¨\u0006!"}, d2 = {"Lcom/ss/android/lark/contact/customized/mygroup/view/OfficeMyJoinGroupViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "repository", "Lcom/ss/android/lark/contact/customized/mygroup/repository/OfficeMyJoinGroupRepository;", "pageStartElapsed", BuildConfig.FLAVOR, "firstScreenReported", BuildConfig.FLAVOR, "onPageViewCreated", BuildConfig.FLAVOR, "startElapsed", "_groups", "Landroidx/lifecycle/MutableLiveData;", "Lcom/ss/android/lark/contact/customized/common/model/StatefulModel;", BuildConfig.FLAVOR, "Lcom/ss/android/lark/chat/entity/chat/Chat;", "groups", "Landroidx/lifecycle/LiveData;", "getGroups", "()Landroidx/lifecycle/LiveData;", "_loadMoreFinished", "loadMoreFinished", "getLoadMoreFinished", "loadInitial", "loadMore", "canLoadMore", "reportFirstScreen", "isSucceed", "err", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "Companion", "contact-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeMyJoinGroupViewModel extends ViewModel {
    public static final int $stable = 0;
    public static final a Companion = null;
    private static final String SCENE = "page_my_group";
    private static final String TAG = "Contact_MyJoinGroupVM";
    private final MutableLiveData<i9b.a<List<Chat>>> _groups;
    private final MutableLiveData<Unit> _loadMoreFinished;
    private boolean firstScreenReported;
    private final LiveData<i9b.a<List<Chat>>> groups;
    private final LiveData<Unit> loadMoreFinished;
    private long pageStartElapsed;
    private final com.ss.android.lark.contact.customized.mygroup.repository.a repository;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
        $stable = 8;
    }

    public final boolean canLoadMore() {
        return this.repository.a;
    }

    public final void loadInitial() {
        this._groups.setValue(i9b.a.b.a);
        com.ss.android.lark.contact.customized.mygroup.repository.a r0 = this.repository;
        UIGetDataCallback r1 = new UIGetDataCallback(new AnonymousClass1(this));
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "callback");
        r0.c = 0;
        r0.a = true;
        r0.a(r1);
    }

    public final void loadMore() {
        com.ss.android.lark.contact.customized.mygroup.repository.a r0 = this.repository;
        UIGetDataCallback r1 = new UIGetDataCallback(new C04391(this));
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "callback");
        r0.a(r1);
    }

    public OfficeMyJoinGroupViewModel() {
        this.repository = new com.ss.android.lark.contact.customized.mygroup.repository.a();
        MutableLiveData<i9b.a<List<Chat>>> r0 = new MutableLiveData();
        this._groups = r0;
        this.groups = r0;
        MutableLiveData<Unit> r1 = new MutableLiveData();
        this._loadMoreFinished = r1;
        this.loadMoreFinished = r1;
    }

    public final LiveData<i9b.a<List<Chat>>> getGroups() {
        return this.groups;
    }

    public final LiveData<Unit> getLoadMoreFinished() {
        return this.loadMoreFinished;
    }

    public static final /* synthetic */ MutableLiveData access$get_groups$p(OfficeMyJoinGroupViewModel r0) {
        return r0._groups;
    }

    public static final /* synthetic */ MutableLiveData access$get_loadMoreFinished$p(OfficeMyJoinGroupViewModel r0) {
        return r0._loadMoreFinished;
    }

    public final void onPageViewCreated(long r1) {
        this.pageStartElapsed = r1;
        this.firstScreenReported = false;
    }

    private final void reportFirstScreen(boolean r9, ErrorResult r10) {
        if (this.firstScreenReported == false) goto L5;
        return;
    L5:
        if (this.pageStartElapsed <= 0) goto L10;
        this.firstScreenReported = true;
        int r0 = com.ss.android.lark.contact.customized.common.a.a;
        com.ss.android.lark.contact.customized.common.a.a(SCENE, SystemClock.elapsedRealtime() - this.pageStartElapsed, r9, r10, false, true);
        return;
    }

    public static final /* synthetic */ void access$reportFirstScreen(OfficeMyJoinGroupViewModel r0, boolean r1, ErrorResult r2) {
        r0.reportFirstScreen(r1, r2);
    }
}
