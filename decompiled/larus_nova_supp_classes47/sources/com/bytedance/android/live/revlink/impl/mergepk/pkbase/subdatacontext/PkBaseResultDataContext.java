package com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine;
import com.bytedance.android.live.revlink.impl.multianchor.constants.PlayMode;
import com.bytedance.android.live.revlink.impl.utils.s;
import com.bytedance.android.livesdk.link.model.IBattleUserInfo;
import com.bytedance.android.livesdk.link.model.a1;
import com.bytedance.android.livesdk.link.model.y2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKt_androidKt;
import com.bytedance.live.datacontext.DataContext;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Action;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 H2\u00020\u0001:\u0001IBQ\u0012\u000e\u00103\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f02\u0012\u0016\u00105\u001a\u0012\u0012\u0004\u0012\u00020/0\u001aj\b\u0012\u0004\u0012\u00020/`\u001b\u0012\f\u00107\u001a\b\u0012\u0004\u0012\u00020602\u0012\b\u00109\u001a\u0004\u0018\u000108\u0012\b\u0010<\u001a\u0004\u0018\u00010;¢\u0006\u0004\bF\u0010GJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001e\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\"\u0010\u0011\u001a\u00020\u00062\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J\u0006\u0010\u0012\u001a\u00020\u0006R<\u0010\u0018\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u00140\u0013j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014`\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R?\u0010\u001c\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u00140\u001aj\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014`\u001b8\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR$\u0010!\u001a\u0012\u0012\u0004\u0012\u00020 0\u0013j\b\u0012\u0004\u0012\u00020 `\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\u0019R'\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020 0\u001aj\b\u0012\u0004\u0012\u00020 `\u001b8\u0006¢\u0006\f\n\u0004\b\"\u0010\u001d\u001a\u0004\b#\u0010\u001fR\u001c\u0010&\u001a\n\u0018\u00010$j\u0004\u0018\u0001`%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010*\u001a\u00060(j\u0002`)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010,\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u001a\u00100\u001a\b\u0012\u0004\u0012\u00020/0.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u001c\u00103\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R$\u00105\u001a\u0012\u0012\u0004\u0012\u00020/0\u001aj\b\u0012\u0004\u0012\u00020/`\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u0010\u001dR\u001a\u00107\u001a\b\u0012\u0004\u0012\u000206028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00104R\u0016\u00109\u001a\u0004\u0018\u0001088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010<\u001a\u0004\u0018\u00010;8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010A\u001a\u0004\u0018\u00010>8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b?\u0010@R\u0016\u0010E\u001a\u0004\u0018\u00010B8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bC\u0010D¨\u0006J"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/subdatacontext/PkBaseResultDataContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/statemachine/a;", "pkInfo", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/statemachine/PkBaseStateMachine$Source;", "source", "", "onShowPk", "onShowPenal", "", "skippedPenal", "onFinish", "", "Laf2/b;", "scoreList", "Lcom/bytedance/android/live/revlink/impl/multianchor/constants/PlayMode;", "playMode", "setPkResult", "clearIt", "Landroidx/lifecycle/MutableLiveData;", "", "", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/subdatacontext/PkBaseResult;", "Lcom/bytedance/revenue/platform/api/core/android/lifecycle/MutableLiveData;", "_pkResult", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/lifecycle/LiveData;", "Lcom/bytedance/revenue/platform/api/core/android/lifecycle/LiveData;", "pkResult", "Landroidx/lifecycle/LiveData;", "getPkResult", "()Landroidx/lifecycle/LiveData;", "", "_pkStarCount", "pkStarCount", "getPkStarCount", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomKt;", "room", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "Lio/reactivex/disposables/CompositeDisposable;", "Lcom/bytedance/revenue/platform/api/core/rx/CompositeDisposable;", "cd", "Lio/reactivex/disposables/CompositeDisposable;", "curPlayMode", "Lcom/bytedance/android/live/revlink/impl/multianchor/constants/PlayMode;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/statemachine/PkBaseStateMachine$b;", "sideEffectObserver", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lkotlin/Function0;", "getCurPkMode", "Lkotlin/jvm/functions/Function0;", "pkSideEffect", "", "scene", "Lcom/bytedance/android/livesdk/revenue/service/room/c;", "roomService", "Lcom/bytedance/android/livesdk/revenue/service/room/c;", "Lcom/bytedance/android/live/revlink/impl/global/c;", "linkFakeGlobalService", "Lcom/bytedance/android/live/revlink/impl/global/c;", "Lcom/bytedance/android/live/revlink/impl/utils/s;", "getRevLinkCommonUtil", "()Lcom/bytedance/android/live/revlink/impl/utils/s;", "revLinkCommonUtil", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/subdatacontext/e;", "getPkBaseResultDataContextObj", "()Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/subdatacontext/e;", "pkBaseResultDataContextObj", "<init>", "(Lkotlin/jvm/functions/Function0;Landroidx/lifecycle/LiveData;Lkotlin/jvm/functions/Function0;Lcom/bytedance/android/livesdk/revenue/service/room/c;Lcom/bytedance/android/live/revlink/impl/global/c;)V", "Companion", "b", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PkBaseResultDataContext extends DataContext {
    public static final b Companion = null;
    private static final int EVEN = 0;
    private static final int LOSE = 0;
    private static final int NOT_FINISH = 0;
    public static final String TAG = "ttlive_PkBaseResultDataContext";
    private static final int WIN = 0;
    private final MutableLiveData<Map<String, PkBaseResult>> _pkResult;
    private final MutableLiveData<Long> _pkStarCount;
    private final CompositeDisposable cd;
    private PlayMode curPlayMode;
    private final Function0<PlayMode> getCurPkMode;
    private final com.bytedance.android.live.revlink.impl.global.c linkFakeGlobalService;
    private final LiveData<Map<String, PkBaseResult>> pkResult;
    private final LiveData<PkBaseStateMachine.b> pkSideEffect;
    private final LiveData<Long> pkStarCount;
    private final IRoom room;
    private final com.bytedance.android.livesdk.revenue.service.room.c roomService;
    private final Function0<Integer> scene;
    private final Observer<PkBaseStateMachine.b> sideEffectObserver;

    public static final class a implements Action {
        public final /* synthetic */ PkBaseResultDataContext a;

        public a(PkBaseResultDataContext r1) {
            this.a = r1;
        }

        public final void run() {
            PkBaseResultDataContext.access$getPkSideEffect$p(this.a).removeObserver(PkBaseResultDataContext.access$getSideEffectObserver$p(this.a));
            PkBaseResultDataContext.access$getCd$p(this.a).clear();
        }
    }

    public static final class b {
        public b() {
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ PkBaseResultDataContext a;

        public c(PkBaseResultDataContext r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            PkBaseStateMachine.b r5 = (PkBaseStateMachine.b) r4;
            if ((r5 instanceof PkBaseStateMachine.b.c) == false) goto L6;
            PkBaseStateMachine.c r6 = r5.b;
            com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a r0 = r6.a;
            PkBaseResultDataContext.access$onShowPk(this.a, r0, r6.b);
            return;
        L6:
            if ((r5 instanceof PkBaseStateMachine.b.d) == false) goto L9;
            PkBaseResultDataContext r1 = this.a;
            PkBaseStateMachine.c r7 = r5.b;
            PkBaseResultDataContext.access$onShowPenal(r1, r7.a, r7.b);
            return;
        L9:
            if ((r5 instanceof PkBaseStateMachine.b.a) == false) goto L12;
            r5.a.a();
            PkBaseResultDataContext.access$onFinish(this.a, ((PkBaseStateMachine.b.a) r5).d, r5.b.a);
            return;
        L12:
            if ((r5 instanceof PkBaseStateMachine.b.C0129b) == false) goto L18;
            PkBaseResultDataContext.onFinish$default(this.a, false, null, 3, null);
            return;
        }
    }

    static {
        Companion = new b();
        WIN = 1;
        LOSE = 2;
        EVEN = 3;
    }

    private final e getPkBaseResultDataContextObj() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getPkBaseResultDataContextObj();
    }

    private final s getRevLinkCommonUtil() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getRevLinkCommonUtil();
    }

    public static final /* synthetic */ int access$getEVEN$cp() {
        return EVEN;
    }

    public static final /* synthetic */ int access$getLOSE$cp() {
        return LOSE;
    }

    public static final /* synthetic */ int access$getNOT_FINISH$cp() {
        return NOT_FINISH;
    }

    public static final /* synthetic */ int access$getWIN$cp() {
        return WIN;
    }

    public final void clearIt() {
        onCleared();
    }

    public final LiveData<Map<String, PkBaseResult>> getPkResult() {
        return this.pkResult;
    }

    public final LiveData<Long> getPkStarCount() {
        return this.pkStarCount;
    }

    public static final /* synthetic */ CompositeDisposable access$getCd$p(PkBaseResultDataContext r0) {
        return r0.cd;
    }

    public static final /* synthetic */ LiveData access$getPkSideEffect$p(PkBaseResultDataContext r0) {
        return r0.pkSideEffect;
    }

    public static final /* synthetic */ Observer access$getSideEffectObserver$p(PkBaseResultDataContext r0) {
        return r0.sideEffectObserver;
    }

    private final void onFinish(boolean r6, com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a r7) {
        if (r6 == false) goto L36;
        if (r7 == null) goto L36;
        jy0.b.c(TAG, "skip peanl " + r7.a, null, 4);
        if (((Number) this.scene.invoke()).intValue() != 1) goto L14;
        Map<String, IBattleUserInfo> r8 = r7.b;
        if (r8 == null) goto L18;
        MutableLiveData<Map<String, PkBaseResult>> r3 = this._pkResult;
        e r4 = getPkBaseResultDataContextObj();
        if (r4 == null) goto L12;
        Map<String, PkBaseResult> r9 = r4.a(r8);
    L13:
        r3.setValue(r9);
        goto L18
    L12:
        r9 = null;
    L18:
        List<a1> r10 = r7.c;
        if (r10 == null) goto L36;
        Iterator<a1> r12 = r10.iterator();
    L22:
        if (r12.hasNext() == false) goto L36;
        a1 r13 = r12.next();
        String r5 = af2.c.a(r13);
        IRoom r14 = this.room;
        if (r14 == null) goto L26;
        String r15 = IRoomKt_androidKt.getOwnerUserIdString(r14);
    L28:
        if (Intrinsics.areEqual(r5, r15) == false) goto L22;
        if (r13.getGrade() == null) goto L22;
        MutableLiveData<Long> r16 = this._pkStarCount;
        y2 r17 = r13.getGrade();
        if (r17 == null) goto L34;
        Long r18 = Long.valueOf(r17.getStarCount());
    L35:
        r16.setValue(r18);
        goto L36
    L34:
        r18 = null;
        goto L35
    L26:
        r15 = null;
        goto L28
    L14:
        List<? extends af2.b> r19 = r7.c;
        if (r19 != null) goto L17;
        r19 = new ArrayList();
    L17:
        setPkResult(r19, this.curPlayMode);
    L36:
        StringBuilder r20 = new StringBuilder("finish update pk result ");
        Map r22 = (Map) this.pkResult.getValue();
        if (r22 == null) goto L45;
        s r23 = getRevLinkCommonUtil();
        if (r23 == null) goto L41;
        String r24 = r23.c();
    L42:
        PkBaseResult r25 = (PkBaseResult) r22.get(r24);
        if (r25 == null) goto L45;
        String r26 = r25.getType();
    L46:
        r20.append(r26);
        jy0.b.c(TAG, r20.toString(), null, 4);
        return;
    L41:
        r24 = null;
    L45:
        r26 = null;
        goto L46
    }

    private final void onShowPenal(com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a r5, PkBaseStateMachine.Source r6) {
        if (((Number) this.scene.invoke()).intValue() != 1) goto L11;
        Map<String, IBattleUserInfo> r7 = r5.b;
        if (r7 == null) goto L15;
        MutableLiveData<Map<String, PkBaseResult>> r0 = this._pkResult;
        e r2 = getPkBaseResultDataContextObj();
        if (r2 == null) goto L9;
        Map<String, PkBaseResult> r8 = r2.a(r7);
    L10:
        r0.setValue(r8);
        goto L15
    L9:
        r8 = null;
    L15:
        if (r5 == null) goto L34;
        List<a1> r9 = r5.c;
        if (r9 == null) goto L34;
        Iterator<a1> r10 = r9.iterator();
    L20:
        if (r10.hasNext() == false) goto L34;
        a1 r12 = r10.next();
        String r1 = af2.c.a(r12);
        IRoom r3 = this.room;
        if (r3 == null) goto L24;
        String r4 = IRoomKt_androidKt.getOwnerUserIdString(r3);
    L26:
        if (Intrinsics.areEqual(r1, r4) == false) goto L20;
        if (r12.getGrade() == null) goto L20;
        MutableLiveData<Long> r13 = this._pkStarCount;
        y2 r14 = r12.getGrade();
        if (r14 == null) goto L32;
        Long r15 = Long.valueOf(r14.getStarCount());
    L33:
        r13.setValue(r15);
        goto L34
    L32:
        r15 = null;
        goto L33
    L24:
        r4 = null;
    L34:
        StringBuilder r16 = new StringBuilder("penal update pk result ");
        Map r17 = (Map) this.pkResult.getValue();
        if (r17 == null) goto L43;
        s r18 = getRevLinkCommonUtil();
        if (r18 == null) goto L39;
        String r19 = r18.c();
    L40:
        PkBaseResult r20 = (PkBaseResult) r17.get(r19);
        if (r20 == null) goto L43;
        String r22 = r20.getType();
    L44:
        r16.append(r22);
        jy0.b.c(TAG, r16.toString(), null, 4);
        return;
    L39:
        r19 = null;
    L43:
        r22 = null;
        goto L44
    L11:
        List r23 = r5.c;
        if (r23 != null) goto L14;
        r23 = new ArrayList();
    L14:
        setPkResult$default(this, r23, null, 2, null);
        goto L15
    }

    private final void onShowPk(com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a r1, PkBaseStateMachine.Source r2) {
        this._pkResult.setValue(new HashMap());
        this.curPlayMode = (PlayMode) this.getCurPkMode.invoke();
    }

    private final void setPkResult(List<? extends af2.b> r7, PlayMode r8) {
        if (r8 != null) goto L5;
        r8 = (PlayMode) this.getCurPkMode.invoke();
    L5:
        if (r8 != PlayMode.PERSONAL_PK) goto L8;
        MutableLiveData<Map<String, PkBaseResult>> r0 = this._pkResult;
        int r2 = com.bytedance.android.live.revlink.impl.multianchor.pk.c.a;
        Intrinsics.checkNotNullParameter(r7, "scoreList");
        r0.setValue(new com.bytedance.android.live.revlink.impl.multianchor.pk.d(PkBaseResult.WIN, PkBaseResult.LOSE, PkBaseResult.EVEN).a(r7));
    L8:
        if (r8 != PlayMode.TEAM_PK) goto L11;
        MutableLiveData<Map<String, PkBaseResult>> r9 = this._pkResult;
        int r1 = com.bytedance.android.live.revlink.impl.multianchor.pk.c.a;
        Intrinsics.checkNotNullParameter(r7, "scoreList");
        r9.setValue(new com.bytedance.android.live.revlink.impl.multianchor.pk.d(PkBaseResult.WIN, PkBaseResult.LOSE, PkBaseResult.EVEN).b(r7));
        return;
    }

    public static final /* synthetic */ void access$onFinish(PkBaseResultDataContext r0, boolean r1, com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a r2) {
        r0.onFinish(r1, r2);
    }

    public static final /* synthetic */ void access$onShowPenal(PkBaseResultDataContext r0, com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a r1, PkBaseStateMachine.Source r2) {
        r0.onShowPenal(r1, r2);
    }

    public static final /* synthetic */ void access$onShowPk(PkBaseResultDataContext r0, com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a r1, PkBaseStateMachine.Source r2) {
        r0.onShowPk(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PkBaseResultDataContext(Function0<? extends PlayMode> r2, LiveData<PkBaseStateMachine.b> r3, Function0<Integer> r4, com.bytedance.android.livesdk.revenue.service.room.c r5, com.bytedance.android.live.revlink.impl.global.c r6) {
        Intrinsics.checkNotNullParameter(r2, "getCurPkMode");
        Intrinsics.checkNotNullParameter(r3, "pkSideEffect");
        Intrinsics.checkNotNullParameter(r4, "scene");
        this.getCurPkMode = r2;
        this.pkSideEffect = r3;
        this.scene = r4;
        this.roomService = r5;
        this.linkFakeGlobalService = r6;
        MutableLiveData<Map<String, PkBaseResult>> r7 = new MutableLiveData();
        this._pkResult = r7;
        this.pkResult = r7;
        MutableLiveData<Long> r8 = new MutableLiveData();
        this._pkStarCount = r8;
        this.pkStarCount = r8;
        if (r5 == null) goto L7;
        com.bytedance.android.livesdk.revenue.room.a r9 = r5.getRoomContext();
        if (r9 == null) goto L7;
        IRoomBase r10 = r9.getCommonRoom();
    L8:
        this.room = (IRoom) r10;
        CompositeDisposable r12 = new CompositeDisposable();
        this.cd = r12;
        c r13 = new c(this);
        this.sideEffectObserver = r13;
        com.bytedance.revenue.platform.api.core.rx.f.a(getOnCleared().subscribe(new a(this)), r12);
        r3.observeForever(r13);
        return;
    L7:
        r10 = null;
        goto L8
    }

    public static /* synthetic */ void onFinish$default(PkBaseResultDataContext r0, boolean r1, com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = false;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = null;
    L8:
        r0.onFinish(r1, r2);
    }

    public static /* synthetic */ void setPkResult$default(PkBaseResultDataContext r0, List r1, PlayMode r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.setPkResult(r1, r2);
    }
}
