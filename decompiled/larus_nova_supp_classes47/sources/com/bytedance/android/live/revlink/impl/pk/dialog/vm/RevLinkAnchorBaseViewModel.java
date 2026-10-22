package com.bytedance.android.live.revlink.impl.pk.dialog.vm;

import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revenue.core.util.e;
import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.android.live.revenue.model.extension.IRoomLinkExt;
import com.bytedance.android.live.revlink.impl.control.dialog.LinkRevPanelDataContext;
import com.bytedance.android.live.revlink.impl.pk.dialog.fragment.p;
import com.bytedance.android.live.revlink.impl.pk.utils.k;
import com.bytedance.android.livesdk.link.model.IGroupRivals;
import com.bytedance.android.livesdk.link.model.m2;
import com.bytedance.android.livesdk.link.model.n2;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdk.revenue.service.room.c;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.m;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;
import p21.d;
import r11.r;
import y31.i;
import y31.l;
import y31.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bg\u0010hJ \u0010\b\u001a\u0004\u0018\u00010\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J*\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010\u0012\u001a\u00020\fH\u0004J\n\u0010\u0013\u001a\u0004\u0018\u00010\u000eH\u0004J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0004J\b\u0010\u0016\u001a\u00020\u000eH&J\b\u0010\u0018\u001a\u00020\u0017H\u0016JT\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u000eH\u0014J*\u0010 \u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J*\u0010!\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010\"\u001a\u00020\u0019H\u0016J\u0010\u0010'\u001a\u00020\u00172\u0006\u0010&\u001a\u00020%H\u0016J:\u0010(\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u001c\u001a\u00020\u000eH\u0004J*\u0010,\u001a\u00020\u00172\u0006\u0010)\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u000e2\b\b\u0002\u0010*\u001a\u00020\u000e2\b\b\u0002\u0010+\u001a\u00020\u000eJ\u001e\u00100\u001a\u00020\u00172\u0006\u0010-\u001a\u00020\n2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00170.H\u0004J\b\u00101\u001a\u00020\u0017H\u0014R\"\u00102\u001a\u00020\u00198\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b2\u00104\"\u0004\b5\u00106R\"\u00107\u001a\u00020\n8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001a\u0010>\u001a\u00020=8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR\u001d\u0010G\u001a\u0004\u0018\u00010B8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR\u001b\u0010L\u001a\u00020H8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bI\u0010D\u001a\u0004\bJ\u0010KR!\u0010R\u001a\b\u0012\u0004\u0012\u00020N0M8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bO\u0010D\u001a\u0004\bP\u0010QR\u001b\u0010W\u001a\u00020S8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bT\u0010D\u001a\u0004\bU\u0010VR\u0014\u0010Z\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bX\u0010YR\u0013\u0010^\u001a\u0004\u0018\u00010[8F¢\u0006\u0006\u001a\u0004\b\\\u0010]R\u0016\u0010b\u001a\u0004\u0018\u00010_8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b`\u0010aR\u0016\u0010f\u001a\u0004\u0018\u00010c8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\bd\u0010e¨\u0006i"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/dialog/vm/RevLinkAnchorBaseViewModel;", "Landroidx/lifecycle/ViewModel;", "", "Lcom/bytedance/android/livesdk/link/model/m2;", "battleRivals", "", "titleName", "Ly31/s$a;", "createFollowTitleItem", "battleRival", "", "inviteType", "", "skinType", "", "impId", "Ly31/k;", "createRivalViewItemData", "getCurRoomId", "getCurUserId", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "getCurRoom", "getTag", "", "toggleExpand", "", "isSupportTitle", "isSupportExpand", "source", "", "", "createFollowItemList", "createRivalFollowViewItemData", "createRivalRecViewItemData", "isCurExpand", "Ly31/i$a;", "createExpandItem", "Lcom/bytedance/android/livesdk/link/model/IGroupRivals;", "groupRivals", "findExpandPosition", "createRecItemList", "loadType", "activityId", "posStr", "fetchPiece", "flag", "Lkotlin/Function0;", "task", "lazyTask", "onCleared", "isFollowExpand", "Z", "()Z", "setFollowExpand", "(Z)V", "mExpandPosition", "I", "getMExpandPosition", "()I", "setMExpandPosition", "(I)V", "Lio/reactivex/disposables/CompositeDisposable;", "cd", "Lio/reactivex/disposables/CompositeDisposable;", "getCd", "()Lio/reactivex/disposables/CompositeDisposable;", "Lcom/bytedance/android/live/revlink/impl/pk/dialog/fragment/p;", "reporter$delegate", "Lkotlin/Lazy;", "getReporter", "()Lcom/bytedance/android/live/revlink/impl/pk/dialog/fragment/p;", "reporter", "Lp21/d;", "mPKFoldingStrategy$delegate", "getMPKFoldingStrategy", "()Lp21/d;", "mPKFoldingStrategy", "Landroid/util/SparseArray;", "Ljava/lang/Runnable;", "taskMap$delegate", "getTaskMap", "()Landroid/util/SparseArray;", "taskMap", "Landroid/os/Handler;", "mainHandler$delegate", "getMainHandler", "()Landroid/os/Handler;", "mainHandler", "getDelayTime", "()J", "delayTime", "Lcom/bytedance/android/live/revlink/impl/pk/utils/k;", "getMetricUtil", "()Lcom/bytedance/android/live/revlink/impl/pk/utils/k;", "metricUtil", "Lcom/bytedance/android/live/revlink/impl/control/dialog/b;", "getLoader", "()Lcom/bytedance/android/live/revlink/impl/control/dialog/b;", "loader", "Lcom/bytedance/android/live/revlink/impl/control/dialog/LinkRevPanelDataContext;", "getDataContext", "()Lcom/bytedance/android/live/revlink/impl/control/dialog/LinkRevPanelDataContext;", "dataContext", "<init>", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class RevLinkAnchorBaseViewModel extends ViewModel {
    private final CompositeDisposable cd;
    private boolean isFollowExpand;
    private int mExpandPosition;
    private final Lazy mPKFoldingStrategy$delegate;
    private final Lazy mainHandler$delegate;
    private final Lazy reporter$delegate;
    private final Lazy taskMap$delegate;

    public static final class a implements Runnable {
        public final /* synthetic */ Function0 a;

        public a(Function0 r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    private final d getMPKFoldingStrategy() {
        return (d) this.mPKFoldingStrategy$delegate.getValue();
    }

    private final Handler getMainHandler() {
        return (Handler) this.mainHandler$delegate.getValue();
    }

    private final SparseArray<Runnable> getTaskMap() {
        return (SparseArray) this.taskMap$delegate.getValue();
    }

    public final p getReporter() {
        return (p) this.reporter$delegate.getValue();
    }

    public abstract String getTag();

    private final long getDelayTime() {
        int r0 = com.bytedance.android.live.revlink.impl.control.dialog.b.r;
        b51.b r1 = b51.b.c0;
        if (r1.i().y2() != 2) goto L11;
        r r2 = r1.i();
        Intrinsics.checkNotNullParameter(r2, "$this$getValidListUpdateTime");
        if (r2.S5() > 0) goto L8;
        long r3 = 200;
    L10:
        return r3;
    L8:
        r3 = r2.S5();
        goto L10
    L11:
        return 0;
    }

    public final IRoom getCurRoom() {
        c r0 = (dy0.b) e.c(j.C0.a(), c.class);
        if (r0 == null) goto L9;
        com.bytedance.android.livesdk.revenue.room.a r1 = r0.getRoomContext();
        if (r1 == null) goto L9;
        m r2 = r1.getRoom();
        if (r2 == null) goto L9;
        return (IRoom) r2.getValue();
    L9:
        return null;
    }

    public final long getCurRoomId() {
        c r0 = (dy0.b) e.c(j.C0.a(), c.class);
        if (r0 == null) goto L11;
        com.bytedance.android.livesdk.revenue.room.a r1 = r0.getRoomContext();
        if (r1 == null) goto L11;
        m r2 = r1.getRoom();
        if (r2 == null) goto L11;
        IRoom r3 = (IRoom) r2.getValue();
        if (r3 == null) goto L11;
        return r3.getRoomId();
    L11:
        return 0;
    }

    public final String getCurUserId() {
        c r0 = (dy0.b) e.c(j.C0.a(), c.class);
        if (r0 == null) goto L11;
        com.bytedance.android.livesdk.revenue.room.a r1 = r0.getRoomContext();
        if (r1 == null) goto L11;
        m r2 = r1.getRoom();
        if (r2 == null) goto L11;
        IRoom r3 = (IRoom) r2.getValue();
        if (r3 == null) goto L11;
        return r3.getOwnerUserIdString();
    L11:
        return null;
    }

    public final LinkRevPanelDataContext getDataContext() {
        return LinkRevPanelDataContext.Companion.getContext();
    }

    public final com.bytedance.android.live.revlink.impl.control.dialog.b getLoader() {
        int r0 = com.bytedance.android.live.revlink.impl.control.dialog.b.r;
        return com.bytedance.android.live.revlink.impl.control.dialog.b.a.b();
    }

    public void toggleExpand() {
        this.isFollowExpand = !this.isFollowExpand;
    }

    public RevLinkAnchorBaseViewModel() {
        this.mExpandPosition = -1;
        this.cd = new CompositeDisposable();
        this.reporter$delegate = LazyKt.lazy(new RevLinkAnchorBaseViewModel$reporter$2(this));
        this.mPKFoldingStrategy$delegate = LazyKt.lazy(RevLinkAnchorBaseViewModel$mPKFoldingStrategy$2.INSTANCE);
        this.taskMap$delegate = LazyKt.lazy(RevLinkAnchorBaseViewModel$taskMap$2.INSTANCE);
        this.mainHandler$delegate = LazyKt.lazy(RevLinkAnchorBaseViewModel$mainHandler$2.INSTANCE);
    }

    public final k getMetricUtil() {
        LinkRevPanelDataContext r0 = getDataContext();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getMetricUtil();
    }

    public void onCleared() {
        super.onCleared();
        this.cd.dispose();
        int r0 = getTaskMap().size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        getMainHandler().removeCallbacks(getTaskMap().valueAt(r1));
        r1 = r1 + 1;
        goto L3
    L5:
        getTaskMap().clear();
    }

    public final CompositeDisposable getCd() {
        return this.cd;
    }

    public final int getMExpandPosition() {
        return this.mExpandPosition;
    }

    public final boolean isFollowExpand() {
        return this.isFollowExpand;
    }

    public i.a createExpandItem(boolean r2) {
        i.a r0 = new i.a();
        r0.b = r2;
        return r0;
    }

    public void findExpandPosition(IGroupRivals r12) {
        Intrinsics.checkNotNullParameter(r12, "groupRivals");
        List r0 = r12.getRivals();
        if (r0 != null) goto L5;
        return;
    L5:
        getMPKFoldingStrategy().getClass();
        Intrinsics.checkNotNullParameter(r0, "list");
        ArrayList r1 = new ArrayList();
        ArrayList r2 = new ArrayList();
        Iterator r3 = r0.iterator();
    L7:
        if (r3.hasNext() == false) goto L69;
        m2 r4 = (m2) r3.next();
        Intrinsics.checkNotNullParameter(r4, "$this$anchorFolding");
        String r5 = r4.getRecommendInfo();
        boolean r6 = false;
        if (r5 != null) goto L71;
    L16:
        boolean r7 = false;
    L18:
        if (r7 == true) goto L65;
        IRoom r8 = r4.getRoom();
        if (r8 == null) goto L66;
        b51.b r9 = b51.b.c0;
        r9.getClass();
        if (((Boolean) b51.b.X.getValue(r9, b51.b.a[48])).booleanValue() == true) goto L66;
        n2 r10 = r4.getInviteButton();
        if (r10 != null) goto L29;
    L32:
        boolean r13 = true;
    L33:
        if (r13 == false) goto L65;
        IBaseUser r14 = r8.getOwner();
        if (r14 != null) goto L38;
    L41:
        boolean r15 = true;
    L42:
        if (r15 == false) goto L65;
        if (((IRoomLinkExt) r8.castTo(IRoomLinkExt.class)).getLinkMicInfo() == null) goto L47;
        boolean r16 = true;
    L48:
        if (r16 == true) goto L65;
        if (r8.getLinkMap().containsKey(String.valueOf(7)) == true) goto L65;
        Map r17 = r8.getLinkMap();
        if (r17 != null) goto L56;
        boolean r18 = false;
    L57:
        if (r18 == false) goto L66;
        z5 r19 = ((IRoomLinkExt) r8.castTo(IRoomLinkExt.class)).getLinkerDetail();
        if (r19 == null) goto L62;
        String r20 = r19.getFunctionType2();
        if (r20 == null) goto L62;
    L64:
        if (TextUtils.equals(r20, "new_audience") == true) goto L66;
    L62:
        r20 = "";
        goto L64
    L56:
        r18 = r17.containsKey(String.valueOf(8));
        goto L57
    L47:
        r16 = false;
        goto L48
    L38:
        if (r14.getLinkMicStats() != 0) goto L41;
        r15 = false;
        goto L42
    L29:
        if (r10.getForbidden() != true) goto L32;
        r13 = false;
    L66:
        if (r6 == true) goto L67;
        r1.add(r4);
        goto L7
    L67:
        r2.add(r4);
    L65:
        r6 = true;
        goto L66
    L71:
        JsonElement r22 = ((JsonObject) l97.a.a.fromJson(r5, TypesJVMKt.getJavaType(Reflection.typeOf(JsonObject.class)))).get("anchor_folding");     // Catch: Exception -> L15
        if (r22 == null) goto L16;
        r7 = r22.getAsBoolean();     // Catch: Exception -> L15
    L69:
        List r23 = CollectionsKt.plus(r1, r2);
        int r24 = r1.size();
        Intrinsics.checkNotNullParameter(r23, "sortRivals");
        this.mExpandPosition = r24;
        r12.setSortRivals(r23);
    }

    public final void setFollowExpand(boolean r1) {
        this.isFollowExpand = r1;
    }

    public final void setMExpandPosition(int r1) {
        this.mExpandPosition = r1;
    }

    private final s.a createFollowTitleItem(List<? extends m2> r1, CharSequence r2) {
        s.a r3 = new s.a();
        r3.a = r2;
        r3.c = false;
        return r3;
    }

    public final void lazyTask(int r6, Function0<Unit> r7) {
        Intrinsics.checkNotNullParameter(r7, "task");
        if (getDelayTime() > 0) goto L5;
        r7.invoke();
    L5:
        Runnable r0 = getTaskMap().get(r6);
        if (r0 == null) goto L8;
        getMainHandler().removeCallbacks(r0);
    L8:
        Handler r1 = getMainHandler();
        a r2 = new a(r7);
        getTaskMap().put(r6, r2);
        Unit r8 = Unit.INSTANCE;
        r1.postDelayed(r2, getDelayTime());
    }

    private final y31.k createRivalViewItemData(m2 r3, int r4, long r5, String r7) {
        y31.k r6 = new y31.k();
        r6.b = r3.getRoom();
        r6.c = r3.getLinkText();
        r6.f = r3.getRivalExtraInfo();
        r6.d = false;
        r6.h = r3.getBattleRivalTagList();
        r6.a = r3;
        Intrinsics.checkNotNullParameter("", "<set-?>");
        r6.k = "";
        r6.l = null;
        r6.n = 1;
        if (r7 != null) goto L5;
        r7 = "";
    L5:
        Intrinsics.checkNotNullParameter(r7, "<set-?>");
        r6.i = r7;
        r6.g = 2;
        r6.e = r4;
        r6.s = r3.getRankSeasonInfo();
        return r6;
    }

    public final List<Object> createRecItemList(List<? extends m2> r16, String r17, long r18, String r20) {
        Intrinsics.checkNotNullParameter(r16, "battleRivals");
        Intrinsics.checkNotNullParameter(r20, "source");
        ArrayList r0 = new ArrayList();
        LinkRevPanelDataContext r2 = getDataContext();
        if (r2 == null) goto L5;
        HashSet<String> r3 = r2.getFollowListUidSet();
    L6:
        Iterator<? extends m2> r1 = r16.iterator();
        int r5 = 0;
        int r6 = 0;
    L8:
        if (r1.hasNext() == false) goto L38;
        m2 r7 = r1.next();
        IRoom r9 = r7.getRoom();
        if (r9 == null) goto L12;
        String r10 = r9.getOwnerUserIdString();
    L13:
        if (r10 == null) goto L19;
        if (r3 == null) goto L19;
        if (r3.contains(r10) == true) goto L8;
    L19:
        if (r7.getServerInviteType() != 105) goto L21;
        int r12 = 105;
    L22:
        y31.k r13 = createRivalRecViewItemData(r7, r12, r18, r17);
        r13.r = r6;
        r13.j = true;
        if (r7.getServerInviteType() != 106) goto L25;
        r13.e = r7.getServerInviteType();
    L26:
        r13.s = r7.getRankSeasonInfo();
        m2 r8 = r13.a;
        if (r8 == null) goto L32;
        n2 r14 = r8.getInviteButton();
        if (r14 == null) goto L32;
        if (r14.getForbidden() != true) goto L32;
    L34:
        if (l.a(r13, 0) == false) goto L36;
        r5 = r5 + 1;
    L36:
        r6 = r6 + 1;
    L32:
        r0.add(r13);
        goto L34
    L25:
        r13.e = 2;
        goto L26
    L21:
        r12 = 1;
        goto L22
    L12:
        r10 = null;
        goto L13
    L38:
        if ((!r0.isEmpty()) == false) goto L42;
        d31.e r4 = com.bytedance.android.live.revlink.impl.global.b.d0();
        if (r4 == null) goto L42;
        r4.g = (r5 + 0.0f) / r0.size();
    L42:
        return r0;
    L5:
        r3 = null;
        goto L6
    }

    public y31.k createRivalFollowViewItemData(m2 r2, int r3, long r4, String r6) {
        Intrinsics.checkNotNullParameter(r2, "battleRival");
        return createRivalViewItemData(r2, r3, r4, r6);
    }

    public y31.k createRivalRecViewItemData(m2 r2, int r3, long r4, String r6) {
        Intrinsics.checkNotNullParameter(r2, "battleRival");
        return createRivalViewItemData(r2, r3, r4, r6);
    }

    public final void fetchPiece(int r8, String r9, String r10, String r12) {
        Intrinsics.checkNotNullParameter(r9, "source");
        Intrinsics.checkNotNullParameter(r10, "activityId");
        Intrinsics.checkNotNullParameter(r12, "posStr");
        com.bytedance.android.live.revlink.impl.control.dialog.b r1 = getLoader();
        if (r1 == null) goto L10;
        LinkRevPanelDataContext r0 = getDataContext();
        if (r0 == null) goto L7;
        int r2 = r0.getSelectType();
    L8:
        r1.h(r2, r10, r9, r8, r12);
        return;
    L7:
        r2 = 0;
        goto L8
    }

    public static /* synthetic */ List createRecItemList$default(RevLinkAnchorBaseViewModel r6, List r7, String r8, long r9, String r12, int r13, Object r14) {
        if (r14 != null) goto L9;
        if ((r13 & 8) == 0) goto L7;
        r12 = "init";
    L7:
        return r6.createRecItemList(r7, r8, r9, r12);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createRecItemList");
    }

    public static /* synthetic */ void fetchPiece$default(RevLinkAnchorBaseViewModel r0, int r1, String r2, String r3, String r4, int r5, Object r6) {
        if (r6 != null) goto L12;
        if ((r5 & 4) == 0) goto L7;
        r3 = DataType.FALSE;
    L7:
        if ((r5 & 8) == 0) goto L9;
        r4 = "";
    L9:
        r0.fetchPiece(r1, r2, r3, r4);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fetchPiece");
    }

    public List<Object> createFollowItemList(List<? extends m2> r19, String r20, CharSequence r22, long r23, boolean r24, boolean r25, String r26) {
        Intrinsics.checkNotNullParameter(r19, "battleRivals");
        Intrinsics.checkNotNullParameter(r22, "titleName");
        Intrinsics.checkNotNullParameter(r26, "source");
        ArrayList r7 = new ArrayList();
        String r8 = String.valueOf(getCurUserId());
        if (r24 == false) goto L7;
        s.a r1 = createFollowTitleItem(r19, r22);
        if (r1 == null) goto L7;
        r7.add(r1);
    L7:
        LinkRevPanelDataContext r2 = getDataContext();
        if (r2 == null) goto L10;
        HashSet<String> r10 = r2.getFollowListUidSet();
    L11:
        if (r10 == null) goto L13;
        r10.clear();
    L13:
        int r12 = r19.size();
        Iterator<T> r13 = r19.iterator();
        int r14 = 0;
        int r15 = 0;
        boolean r16 = false;
    L15:
        if (r13.hasNext() == false) goto L42;
        m2 r17 = (m2) r13.next();
        if (r17.getRoom().getOwnerUserIdString() == null) goto L20;
        if (r10 == null) goto L20;
        r10.add(r17.getRoom().getOwnerUserIdString());
    L20:
        if (r25 == false) goto L30;
        if (this.isFollowExpand == true) goto L30;
        int r0 = this.mExpandPosition;
        if (r14 != r0) goto L30;
        if (r0 >= r12) goto L30;
        i.a r3 = createExpandItem(false);
        if (r3 == null) goto L30;
        r7.add(r3);
    L30:
        if (r17.getServerInviteType() != 105) goto L32;
        int r4 = 105;
    L33:
        y31.k r5 = createRivalFollowViewItemData(r17, r4, r23, r20);
        r5.r = r15;
        r5.j = false;
        if (r17.getServerInviteType() != 105) goto L40;
        if (((HashSet) l51.a.b0.getValue(null, l51.a.a[61])).contains(r8) == true) goto L40;
        if (r16 == true) goto L40;
        r5.q = true;
        r16 = true;
    L40:
        r7.add(r5);
        r15 = r15 + 1;
        r14 = r14 + 1;
        goto L15
    L32:
        r4 = 1;
    L42:
        if (r25 == true) goto L44;
    L48:
        return r7;
    L44:
        if (this.isFollowExpand == false) goto L48;
        i.a r6 = createExpandItem(true);
        if (r6 == null) goto L48;
        r7.add(r6);
        goto L48
    L10:
        r10 = null;
        goto L11
    }

    public static /* synthetic */ List createFollowItemList$default(RevLinkAnchorBaseViewModel r12, List r13, String r14, CharSequence r15, long r16, boolean r17, boolean r18, String r19, int r20, Object r22) {
        if (r22 != null) goto L18;
        if ((r20 & 16) == 0) goto L6;
        boolean r8 = false;
    L8:
        if ((r20 & 32) == 0) goto L10;
        boolean r9 = false;
    L12:
        if ((r20 & 64) == 0) goto L14;
        String r10 = "init";
    L16:
        return r12.createFollowItemList(r13, r14, r15, r16, r8, r9, r10);
    L14:
        r10 = r19;
        goto L16
    L10:
        r9 = r18;
        goto L12
    L6:
        r8 = r17;
        goto L8
    L18:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createFollowItemList");
    }
}
