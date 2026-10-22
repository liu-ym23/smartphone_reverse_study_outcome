package com.bytedance.android.livesdk.feed.viewmodel;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.UserEvent;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxViewModel;
import com.bytedance.android.livesdk.feed.tab.monitor.FeedTabMonitor;
import com.bytedance.android.livesdk.model.a1;
import com.bytedance.common.utility.Lists;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class FeedTabViewModel extends RxViewModel {
    private com.bytedance.android.livesdk.feed.j feedTabRepository;
    private com.bytedance.android.livesdk.feed.k<com.bytedance.android.livesdk.feed.feed.e> mTabListDiff;
    private BehaviorSubject<List<com.bytedance.android.livesdk.feed.feed.e>> tabList;
    private PublishSubject<Integer> tabPos;

    public static /* synthetic */ boolean Mo(List r0) {
        return lambda$queryTab$3(r0);
    }

    public static /* synthetic */ boolean No(FeedTabViewModel r0, List r1) {
        return r0.lambda$queryRemoteTabAndSave$9(r1);
    }

    public static /* synthetic */ boolean Oo(List r0) {
        return lambda$queryRemoteTabAndSave$7(r0);
    }

    public static /* synthetic */ void Po(Throwable r0) {
        lambda$queryRemoteTabAndSave$11(r0);
    }

    public static /* synthetic */ void Qo(FeedTabViewModel r0, IBaseUser.Status r1) {
        r0.lambda$new$2(r1);
    }

    public static /* synthetic */ boolean So(FeedTabViewModel r0, List r1) {
        return r0.lambda$queryTab$5(r1);
    }

    public static /* synthetic */ List To(List r0) {
        return lambda$queryRemoteTabAndSave$8(r0);
    }

    public static /* synthetic */ IBaseUser.Status Wo(UserEvent r0) {
        return lambda$new$0(r0);
    }

    public static /* synthetic */ void Yo(FeedTabViewModel r0, List r1) {
        r0.lambda$queryTab$6(r1);
    }

    public static /* synthetic */ List Zo(List r0) {
        return lambda$queryTab$4(r0);
    }

    public static /* synthetic */ void ap(FeedTabViewModel r0, List r1) {
        r0.lambda$queryRemoteTabAndSave$10(r1);
    }

    public static /* synthetic */ boolean yo(IBaseUser.Status r0) {
        return lambda$new$1(r0);
    }

    private void queryRemoteTabAndSave() {
        register(this.feedTabRepository.a(FeedTabMonitor.Action.TRIGGER_ACTION_OPEN_TAB_PAGE).filter(new s()).map(new t()).filter(new i(this)).observeOn(AndroidSchedulers.mainThread()).subscribe(new j(this), new k()));
    }

    public List<com.bytedance.android.livesdk.feed.feed.e> getAllTabs() {
        return this.feedTabRepository.c();
    }

    public String getTitle() {
        if (this.feedTabRepository.getExtra() == null) goto L5;
        String r0 = this.feedTabRepository.getExtra().getTitle();
    L7:
        if (TextUtils.isEmpty(r0) == true) goto L9;
        return r0;
    L9:
        if (Lists.isEmpty(this.feedTabRepository.c()) == false) goto L11;
        return r0;
    L11:
        if (ListProtector.get(this.feedTabRepository.c(), 0) != null) goto L13;
        return r0;
    L13:
        return ((com.bytedance.android.livesdk.feed.feed.e) ListProtector.get(this.feedTabRepository.c(), 0)).i();
    L5:
        r0 = null;
        goto L7
    }

    public void queryTab() {
        register(this.feedTabRepository.e().filter(new h()).map(new l()).filter(new m(this)).observeOn(AndroidSchedulers.mainThread()).subscribe(new n(this), new o()));
    }

    public Observable<List<com.bytedance.android.livesdk.feed.feed.e>> tabList() {
        return this.tabList;
    }

    private static /* synthetic */ IBaseUser.Status lambda$new$0(UserEvent r0) throws Exception {
        return r0.getStatus();
    }

    private static /* synthetic */ boolean lambda$new$1(IBaseUser.Status r1) throws Exception {
        if (r1 != IBaseUser.Status.Login) goto L5;
    L8:
        return true;
    L5:
        if (r1 == IBaseUser.Status.Logout) goto L8;
        return false;
    }

    private /* synthetic */ void lambda$new$2(IBaseUser.Status r1) throws Exception {
        queryTab();
    }

    private /* synthetic */ void lambda$queryRemoteTabAndSave$10(List r2) throws Exception {
        this.tabList.onNext(r2);
    }

    private static /* synthetic */ void lambda$queryRemoteTabAndSave$11(Throwable r1) throws Exception {
        ALogger.e("Tab Request", r1);
    }

    private static /* synthetic */ boolean lambda$queryRemoteTabAndSave$7(List r0) throws Exception {
        return !Lists.isEmpty(r0);
    }

    private static /* synthetic */ List lambda$queryRemoteTabAndSave$8(List r3) throws Exception {
        ArrayList r0 = new ArrayList();
        Iterator r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L10;
        com.bytedance.android.livesdk.feed.feed.e r1 = (com.bytedance.android.livesdk.feed.feed.e) r4.next();
        if (r1 == null) goto L4;
        if (r1.q() == false) goto L4;
        r0.add(r1);
        goto L4
    L10:
        return r0;
    }

    private /* synthetic */ boolean lambda$queryRemoteTabAndSave$9(List r3) throws Exception {
        return !this.mTabListDiff.a(r3, (List) this.tabList.getValue());
    }

    private static /* synthetic */ boolean lambda$queryTab$3(List r0) throws Exception {
        return !Lists.isEmpty(r0);
    }

    private static /* synthetic */ List lambda$queryTab$4(List r3) throws Exception {
        ArrayList r0 = new ArrayList();
        Iterator r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L10;
        com.bytedance.android.livesdk.feed.feed.e r1 = (com.bytedance.android.livesdk.feed.feed.e) r4.next();
        if (r1 == null) goto L4;
        if (r1.q() == false) goto L4;
        r0.add(r1);
        goto L4
    L10:
        return r0;
    }

    private /* synthetic */ boolean lambda$queryTab$5(List r3) throws Exception {
        return !this.mTabListDiff.a(r3, (List) this.tabList.getValue());
    }

    private /* synthetic */ void lambda$queryTab$6(List r2) throws Exception {
        this.tabList.onNext(r2);
    }

    public com.bytedance.android.livesdk.feed.feed.e getTabById(long r2) {
        return this.feedTabRepository.d(r2);
    }

    public FeedTabViewModel(com.bytedance.android.livesdk.feed.j r2, com.bytedance.android.livesdk.feed.k<com.bytedance.android.livesdk.feed.feed.e> r3, hw1.a r4) {
        this.tabList = BehaviorSubject.create();
        this.tabPos = PublishSubject.create();
        this.feedTabRepository = r2;
        this.mTabListDiff = r3;
        register(r4.m().map(new p()).filter(new q()).subscribe(new r(this), new g60.c()));
        if (a1.a() == false) goto L5;
        queryRemoteTabAndSave();
    L5:
        a1.c = true;
    }
}
