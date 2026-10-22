package com.bytedance.android.live.revlink.impl.plantform;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.revenue.common.message.CommonMessageTypeKt;
import com.bytedance.android.live.revenuelink.utils.MultiChannelOptManager;
import com.bytedance.android.livesdk.link.model.a7;
import com.bytedance.android.livesdk.link.model.b7;
import com.bytedance.android.livesdk.link.model.bridge.h1;
import com.bytedance.android.livesdk.link.model.bridge.i1;
import com.bytedance.android.livesdk.link.model.bridge.s1;
import com.bytedance.android.livesdk.link.model.c7;
import com.bytedance.android.livesdk.link.model.e6;
import com.bytedance.android.livesdk.link.model.i6;
import com.bytedance.android.livesdk.link.model.k6;
import com.bytedance.android.livesdk.link.model.q5;
import com.bytedance.android.livesdk.link.model.r5;
import com.bytedance.android.livesdk.link.model.v;
import com.bytedance.android.livesdk.link.model.v4;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.live.datacontext.DataContext;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import ey.l;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import yz0.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n*\u0002'*\u0018\u0000 <2\u00020\u00012\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004:\u0001=B\u001b\u0012\b\u00102\u001a\u0004\u0018\u000101\u0012\b\u00105\u001a\u0004\u0018\u000104¢\u0006\u0004\b:\u0010;J\u001c\u0010\t\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0014\u0010\u000e\u001a\u00020\r2\n\u0010\f\u001a\u00060\nj\u0002`\u000bH\u0002J\u0010\u0010\u0011\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ\u0006\u0010\u0012\u001a\u00020\rJ\u0018\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u0007J\u0012\u0010\u0018\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003H\u0016R$\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0019j\b\u0012\u0004\u0012\u00020\u0005`\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR'\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u001dj\b\u0012\u0004\u0012\u00020\u0005`\u001e8\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0016\u0010$\u001a\u0004\u0018\u00010#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010&R\u0014\u0010(\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010+\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010/\u001a\u00060-j\u0002`.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00102\u001a\u0004\u0018\u0001018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00105\u001a\u0004\u0018\u0001048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u00109\u001a\u0004\u0018\u00010#8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b7\u00108¨\u0006>"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/plantform/RevLinkMultiChannelDataContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/android/livesdk/link/model/a7;", "Lcom/bytedance/revenue/platform/api/core/android/lifecycle/Observer;", "Lcom/bytedance/android/livesdk/link/model/b7;", "toInfo", "", "clearMap", "updateMultiChannelInfo", "Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "_message", "", "onMessage", "Lcom/bytedance/android/live/revenuelink/utils/MultiChannelOptManager;", "optManager", "observeMultiChannelOptManager", "removeMultiChannelOptManager", "", "forwardRoomId", "isRtcForwardEmpty", "onStopForward", Constants.Keys.DATA, "onChanged", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/revenue/platform/api/core/android/lifecycle/MutableLiveData;", "_multiChannelData", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/lifecycle/LiveData;", "Lcom/bytedance/revenue/platform/api/core/android/lifecycle/LiveData;", "multiChannelData", "Landroidx/lifecycle/LiveData;", "getMultiChannelData", "()Landroidx/lifecycle/LiveData;", "Lcom/bytedance/android/live/revenuelink/connect/f;", "connectService", "Lcom/bytedance/android/live/revenuelink/connect/f;", "Lcom/bytedance/android/live/revenuelink/utils/MultiChannelOptManager;", "com/bytedance/android/live/revlink/impl/plantform/RevLinkMultiChannelDataContext$c", "linkOutListener", "Lcom/bytedance/android/live/revlink/impl/plantform/RevLinkMultiChannelDataContext$c;", "com/bytedance/android/live/revlink/impl/plantform/RevLinkMultiChannelDataContext$connectStateObserver$1", "connectStateObserver", "Lcom/bytedance/android/live/revlink/impl/plantform/RevLinkMultiChannelDataContext$connectStateObserver$1;", "Lio/reactivex/disposables/CompositeDisposable;", "Lcom/bytedance/revenue/platform/api/core/rx/CompositeDisposable;", "cd", "Lio/reactivex/disposables/CompositeDisposable;", "Lcom/bytedance/android/live/revlink/impl/global/c;", "linkFakeGlobalService", "Lcom/bytedance/android/live/revlink/impl/global/c;", "Lyz0/f;", "messageService", "Lyz0/f;", "getAnchorConnectService", "()Lcom/bytedance/android/live/revenuelink/connect/f;", "anchorConnectService", "<init>", "(Lcom/bytedance/android/live/revlink/impl/global/c;Lyz0/f;)V", "Companion", "b", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RevLinkMultiChannelDataContext extends DataContext implements Observer<a7> {
    public static final b Companion = null;
    private static final String TAG = null;
    private final MutableLiveData<b7> _multiChannelData;
    private final CompositeDisposable cd;
    private final com.bytedance.android.live.revenuelink.connect.f connectService;
    private final RevLinkMultiChannelDataContext$connectStateObserver$1 connectStateObserver;
    private final com.bytedance.android.live.revlink.impl.global.c linkFakeGlobalService;
    private final c linkOutListener;
    private final yz0.f messageService;
    private final LiveData<b7> multiChannelData;
    private MultiChannelOptManager optManager;

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.plantform.RevLinkMultiChannelDataContext$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "p1", "", "invoke", "(Lyh6/c;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<yh6.c, Unit> {
        public AnonymousClass1(RevLinkMultiChannelDataContext r8) {
            super(1, r8, RevLinkMultiChannelDataContext.class, "onMessage", "onMessage(Lcom/bytedance/live/kmp/message/KmpImMessage;)V", 0);
        }

        public final void invoke(yh6.c r2) {
            Intrinsics.checkNotNullParameter(r2, "p1");
            RevLinkMultiChannelDataContext.access$onMessage((RevLinkMultiChannelDataContext) ((CallableReference) this).receiver, r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((yh6.c) r1);
            return Unit.INSTANCE;
        }
    }

    public static final class a implements Action {
        public final /* synthetic */ RevLinkMultiChannelDataContext a;

        public a(RevLinkMultiChannelDataContext r1) {
            this.a = r1;
        }

        public final void run() {
            com.bytedance.android.live.revenuelink.connect.f r0 = RevLinkMultiChannelDataContext.access$getConnectService$p(this.a);
            if (r0 == null) goto L7;
            LiveData<ey.f> r1 = r0.connectState();
            if (r1 == null) goto L7;
            r1.removeObserver(RevLinkMultiChannelDataContext.access$getConnectStateObserver$p(this.a));
        L7:
            RevLinkMultiChannelDataContext.access$getCd$p(this.a).dispose();
        }
    }

    public static final class b {
        public b() {
        }
    }

    public static final class c extends com.bytedance.android.live.revenuelink.connect.d {
        public final /* synthetic */ RevLinkMultiChannelDataContext a;

        public c(RevLinkMultiChannelDataContext r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.revenuelink.connect.d, com.bytedance.android.live.revenuelink.connect.m
        public final void Tg(int r7, i6 r8, l r9) {
            Intrinsics.checkNotNullParameter(r8, "_linkerMessage");
            Intrinsics.checkNotNullParameter(r8, "linkerMessage");
            i6 r10 = r8.castTo(i6.class);
            int r12 = (int) i1.c(r10);
            if (r12 != 8) goto L26;
            Intrinsics.checkNotNullParameter(r10, "$this$linkerIdExt");
            long r13 = r10.getLinkerId();
            com.bytedance.android.live.revenuelink.connect.f r0 = RevLinkMultiChannelDataContext.access$getConnectService$p(this.a);
            if (r0 == null) goto L49;
            LiveData<ey.f> r1 = r0.connectState();
            if (r1 == null) goto L50;
            ey.f r2 = (ey.f) r1.getValue();
            if (r2 != null) goto L11;
            return;
        L11:
            if (r13 != r2.a) goto L52;
            k6 r14 = r10.getReply();
            if (r14 != null) goto L15;
            return;
        L15:
            if (((int) r14.getReplyStatus()) != 1) goto L54;
            MutableLiveData r15 = RevLinkMultiChannelDataContext.access$get_multiChannelData$p(this.a);
            k6 r16 = r10.getReply();
            if (r16 == null) goto L19;
            b7 r17 = r16.getMultiChannelInfo();
        L20:
            r15.setValue(r17);
            RevLinkMultiChannelDataContext.Companion.getClass();
            String r18 = RevLinkMultiChannelDataContext.access$getTAG$cp();
            StringBuilder r19 = new StringBuilder("onReceivePermit ");
            b7 r20 = (b7) this.a.getMultiChannelData().getValue();
            if (r20 == null) goto L23;
            String r22 = c7.a(r20);
        L24:
            r19.append(r22);
            jy0.b.f(r18, r19.toString(), null, 4);
            return;
        L23:
            r22 = null;
            goto L24
        L19:
            r17 = null;
            goto L20
        L54:
            return;
        L52:
            return;
        L50:
            return;
        L49:
            return;
        L26:
            if (r12 != 5) goto L56;
            Intrinsics.checkNotNullParameter(r10, "$this$linkerIdExt");
            long r23 = r10.getLinkerId();
            com.bytedance.android.live.revenuelink.connect.f r3 = RevLinkMultiChannelDataContext.access$getConnectService$p(this.a);
            if (r3 == null) goto L57;
            LiveData<ey.f> r4 = r3.connectState();
            if (r4 == null) goto L58;
            ey.f r5 = (ey.f) r4.getValue();
            if (r5 != null) goto L34;
            return;
        L34:
            if (r23 != r5.a) goto L60;
            k6 r24 = r10.getReply();
            if (r24 != null) goto L38;
            return;
        L38:
            if (((int) r24.getReplyStatus()) != 1) goto L62;
            MutableLiveData r25 = RevLinkMultiChannelDataContext.access$get_multiChannelData$p(this.a);
            RevLinkMultiChannelDataContext r26 = this.a;
            k6 r27 = r10.getReply();
            if (r27 == null) goto L42;
            b7 r28 = r27.getMultiChannelInfo();
        L43:
            r25.setValue(RevLinkMultiChannelDataContext.access$updateMultiChannelInfo(r26, r28, false));
            RevLinkMultiChannelDataContext.Companion.getClass();
            String r29 = RevLinkMultiChannelDataContext.access$getTAG$cp();
            StringBuilder r30 = new StringBuilder("onReceiveReply ");
            b7 r32 = (b7) this.a.getMultiChannelData().getValue();
            if (r32 == null) goto L46;
            String r33 = c7.a(r32);
        L47:
            r30.append(r33);
            jy0.b.f(r29, r30.toString(), null, 4);
            return;
        L46:
            r33 = null;
            goto L47
        L42:
            r28 = null;
            goto L43
        L62:
            return;
        L60:
            return;
        L58:
            return;
        L57:
            return;
        }

        @Override // com.bytedance.android.live.revenuelink.connect.d, com.bytedance.android.live.revenuelink.connect.m
        public final void ej(int r3, i6 r4, l r5) {
            Intrinsics.checkNotNullParameter(r4, "_linkerMessage");
            Intrinsics.checkNotNullParameter(r4, "linkerMessage");
            i6 r6 = r4.castTo(i6.class);
            MutableLiveData r7 = RevLinkMultiChannelDataContext.access$get_multiChannelData$p(this.a);
            RevLinkMultiChannelDataContext r8 = this.a;
            e6 r9 = r6.getInvite();
            if (r9 == null) goto L5;
            b7 r10 = r9.getMultiChannelInfo();
        L6:
            r7.setValue(RevLinkMultiChannelDataContext.access$updateMultiChannelInfo(r8, r10, false));
            RevLinkMultiChannelDataContext.Companion.getClass();
            String r12 = RevLinkMultiChannelDataContext.access$getTAG$cp();
            StringBuilder r13 = new StringBuilder("onReceiveInvite ");
            b7 r14 = (b7) this.a.getMultiChannelData().getValue();
            if (r14 == null) goto L9;
            String r15 = c7.a(r14);
        L10:
            r13.append(r15);
            jy0.b.f(r12, r13.toString(), null, 4);
            return;
        L9:
            r15 = null;
            goto L10
        L5:
            r10 = null;
            goto L6
        }

        @Override // com.bytedance.android.live.revenuelink.connect.d, com.bytedance.android.live.revenuelink.connect.m
        public final void Jd(d11.f r3, v r4, long r5, l r7) {
            Intrinsics.checkNotNullParameter(r3, "params");
            Intrinsics.checkNotNullParameter(r4, "_permitData");
            super.Jd(r3, r4, r5, r7);
            v r6 = r4.castTo(v.class);
            long r8 = r6.getChannelId();
            com.bytedance.android.live.revenuelink.connect.f r9 = RevLinkMultiChannelDataContext.access$getConnectService$p(this.a);
            if (r9 == null) goto L29;
            LiveData<ey.f> r10 = r9.connectState();
            if (r10 == null) goto L30;
            ey.f r12 = (ey.f) r10.getValue();
            if (r12 != null) goto L9;
            return;
        L9:
            if (r8 == r12.a) goto L11;
            return;
        L11:
            if (r3.c != 1) goto L33;
            b7 r13 = r6.getMultiChannelInfo();
            if (r13 != null) goto L15;
            return;
        L15:
            if (r13.getUseMultiChannel() == false) goto L23;
            Map r14 = r13.getChannelMap();
            if (r14 == null) goto L23;
            Map r15 = MapsKt.toMap(r14);
            if (r15 == null) goto L23;
            if (r15.isEmpty() == true) goto L23;
            RevLinkMultiChannelDataContext.access$get_multiChannelData$p(this.a).setValue(RevLinkMultiChannelDataContext.access$updateMultiChannelInfo(this.a, r13, false));
        L23:
            RevLinkMultiChannelDataContext.Companion.getClass();
            String r16 = RevLinkMultiChannelDataContext.access$getTAG$cp();
            StringBuilder r17 = new StringBuilder("onPermitSuccess ");
            b7 r18 = (b7) this.a.getMultiChannelData().getValue();
            if (r18 == null) goto L26;
            String r19 = c7.a(r18);
        L27:
            r17.append(r19);
            jy0.b.f(r16, r17.toString(), null, 4);
            return;
        L26:
            r19 = null;
            goto L27
        L33:
            return;
        L30:
            return;
        }

        @Override // com.bytedance.android.live.revenuelink.connect.d, com.bytedance.android.live.revenuelink.connect.m
        public final void hl(d11.d r7, long r8, v4 r10, l r12) {
            Intrinsics.checkNotNullParameter(r7, "params");
            Intrinsics.checkNotNullParameter(r10, "_inviteResult");
            v4 r13 = (v4) r10.castTo(v4.class);
            super.hl(r7, r8, r13, r12);
            RevLinkMultiChannelDataContext.access$get_multiChannelData$p(this.a).setValue(RevLinkMultiChannelDataContext.access$updateMultiChannelInfo(this.a, r13.getMultiChannelInfo(), false));
            RevLinkMultiChannelDataContext.Companion.getClass();
            String r9 = RevLinkMultiChannelDataContext.access$getTAG$cp();
            StringBuilder r14 = new StringBuilder("onInviteSuccess ");
            b7 r15 = (b7) this.a.getMultiChannelData().getValue();
            if (r15 == null) goto L5;
            String r16 = c7.a(r15);
        L6:
            r14.append(r16);
            jy0.b.f(r9, r14.toString(), null, 4);
            return;
        L5:
            r16 = null;
            goto L6
        }

        @Override // com.bytedance.android.live.revenuelink.connect.d, com.bytedance.android.live.revenuelink.connect.m
        public final void nf(d11.g r3, q5 r4, long r5, l r7) {
            Intrinsics.checkNotNullParameter(r3, "params");
            Intrinsics.checkNotNullParameter(r4, "_replyResult");
            super.nf(r3, r4, r5, r7);
            q5 r6 = r4.castTo(q5.class);
            long r8 = r3.c;
            com.bytedance.android.live.revenuelink.connect.f r9 = RevLinkMultiChannelDataContext.access$getConnectService$p(this.a);
            if (r9 == null) goto L38;
            LiveData<ey.f> r10 = r9.connectState();
            if (r10 == null) goto L39;
            ey.f r12 = (ey.f) r10.getValue();
            if (r12 != null) goto L9;
            return;
        L9:
            if (r8 != r12.a) goto L41;
            if (r6 == null) goto L42;
            boolean r13 = true;
            if (r3.e != 1) goto L43;
            MutableLiveData r14 = RevLinkMultiChannelDataContext.access$get_multiChannelData$p(this.a);
            s1 r15 = r6.getMultiChannelInfo();
            if (r15 != null) goto L16;
        L31:
            b7 r16 = (b7) RevLinkMultiChannelDataContext.access$get_multiChannelData$p(this.a).getValue();
        L32:
            r14.setValue(r16);
            RevLinkMultiChannelDataContext.Companion.getClass();
            String r17 = RevLinkMultiChannelDataContext.access$getTAG$cp();
            StringBuilder r18 = new StringBuilder("onReplySuccess ");
            b7 r19 = (b7) this.a.getMultiChannelData().getValue();
            if (r19 == null) goto L35;
            String r20 = c7.a(r19);
        L36:
            r18.append(r20);
            jy0.b.f(r17, r18.toString(), null, 4);
            return;
        L35:
            r20 = null;
            goto L36
        L16:
            if (r15.getUseMultiChannel() != true) goto L31;
            s1 r22 = r6.getMultiChannelInfo();
            if (r22 == null) goto L22;
            Map r23 = r22.getChannelMap();
            if (r23 == null) goto L22;
            Map r24 = MapsKt.toMap(r23);
        L24:
            if (r24 != null) goto L26;
        L29:
            if (r13 == true) goto L31;
            r16 = RevLinkMultiChannelDataContext.access$updateMultiChannelInfo(this.a, r5.a(r6), false);
            goto L32
        L26:
            if (r24.isEmpty() == true) goto L29;
            r13 = false;
        L22:
            r24 = null;
            goto L24
        L43:
            return;
        L42:
            return;
        L41:
            return;
        L39:
            return;
        }
    }

    static {
        Companion = new b();
        TAG = "ttlive_revlink_MultiChannelData";
    }

    private final com.bytedance.android.live.revenuelink.connect.f getAnchorConnectService() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.Z0();
    }

    public final void removeMultiChannelOptManager() {
        MultiChannelOptManager r0 = this.optManager;
        if (r0 == null) goto L7;
        MutableLiveData r1 = r0.e;
        if (r1 == null) goto L7;
        r1.removeObserver(this);
    L7:
        this.optManager = null;
    }

    public static final /* synthetic */ String access$getTAG$cp() {
        return TAG;
    }

    public final LiveData<b7> getMultiChannelData() {
        return this.multiChannelData;
    }

    public static final /* synthetic */ CompositeDisposable access$getCd$p(RevLinkMultiChannelDataContext r0) {
        return r0.cd;
    }

    public static final /* synthetic */ com.bytedance.android.live.revenuelink.connect.f access$getConnectService$p(RevLinkMultiChannelDataContext r0) {
        return r0.connectService;
    }

    public static final /* synthetic */ RevLinkMultiChannelDataContext$connectStateObserver$1 access$getConnectStateObserver$p(RevLinkMultiChannelDataContext r0) {
        return r0.connectStateObserver;
    }

    public static final /* synthetic */ MutableLiveData access$get_multiChannelData$p(RevLinkMultiChannelDataContext r0) {
        return r0._multiChannelData;
    }

    private final void onMessage(yh6.c r2) {
        if ((r2 instanceof h1) == false) goto L6;
        i1.c(((vh7.c) r2).castTo(i6.class));
        return;
    }

    public final void observeMultiChannelOptManager(MultiChannelOptManager r2) {
        if (r2 == null) goto L6;
        MutableLiveData r0 = r2.e;
        if (r0 == null) goto L6;
        r0.observeForever(this);
    L6:
        this.optManager = r2;
    }

    public void onChanged(a7 r2) {
        if (r2 == null) goto L6;
        s1 r3 = r2.getMultiChannel();
        if (r3 == null) goto L6;
        b7 r4 = (b7) r3.castToOrNull(b7.class);
    L7:
        updateMultiChannelInfo(r4, true);
        return;
    L6:
        r4 = null;
        goto L7
    }

    public /* bridge */ /* synthetic */ void onChanged(Object r1) {
        onChanged((a7) r1);
    }

    public RevLinkMultiChannelDataContext(com.bytedance.android.live.revlink.impl.global.c r5, yz0.f r6) {
        this.linkFakeGlobalService = r5;
        this.messageService = r6;
        MutableLiveData<b7> r7 = new MutableLiveData();
        this._multiChannelData = r7;
        this.multiChannelData = r7;
        com.bytedance.android.live.revenuelink.connect.f r8 = getAnchorConnectService();
        this.connectService = r8;
        c r0 = new c(this);
        this.linkOutListener = r0;
        androidx.lifecycle.Observer r1 = new RevLinkMultiChannelDataContext$connectStateObserver$1(this);
        this.connectStateObserver = r1;
        CompositeDisposable r2 = new CompositeDisposable();
        this.cd = r2;
        if (r8 == null) goto L5;
        r8.addLinkOutListener(7, r0);
    L5:
        if (r8 == null) goto L9;
        LiveData<ey.f> r9 = r8.connectState();
        if (r9 == null) goto L9;
        r9.observeForever(r1);
    L9:
        if (r6 == null) goto L15;
        Observable r10 = h.a.a(r6, CommonMessageTypeKt.a(com.bytedance.android.live.revenue.common.message.a.g), false, 6);
        if (r10 == null) goto L15;
        final AnonymousClass1 r12 = new AnonymousClass1(this);
        Disposable r13 = r10.subscribe(new d(r12));
        if (r13 == null) goto L15;
        com.bytedance.revenue.platform.api.core.rx.f.a(r13, r2);
    L15:
        com.bytedance.revenue.platform.api.core.rx.f.a(getOnCleared().subscribe(new a(this)), r2);
    }

    public static final /* synthetic */ void access$onMessage(RevLinkMultiChannelDataContext r0, yh6.c r1) {
        r0.onMessage(r1);
    }

    private final b7 updateMultiChannelInfo(b7 r6, boolean r7) {
        b7 r0 = (b7) this._multiChannelData.getValue();
        if (r6 == null) goto L22;
        if (r0 == null) goto L23;
        Map r1 = null;
        if (r7 == false) goto L11;
        y41.b r8 = y41.b.d;
        r8.getClass();
        if (((Boolean) y41.b.c.getValue(r8, y41.b.a[1])).booleanValue() == false) goto L11;
        r0.setChannelMap(new LinkedHashMap());
    L12:
        Map r9 = r0.getChannelMap();
        if (r9 == null) goto L20;
        Map r10 = MapsKt.toMutableMap(r9);
        if (r10 == null) goto L20;
        Map r12 = r6.getChannelMap();
        if (r12 != null) goto L19;
        r12 = MapsKt.emptyMap();
    L19:
        r10.putAll(r12);
        Unit r13 = Unit.INSTANCE;
        r1 = r10;
    L20:
        r0.setChannelMap(r1);
    L11:
        jy0.b.f(TAG, "incremental update current=" + c7.a(r0) + " new=" + c7.a(r6), null, 4);
        goto L12
    L23:
        return r6;
    L22:
        return r0;
    }

    public final void onStopForward(long r7, boolean r9) {
        d51.b r0 = d51.b.m;
        r0.getClass();
        if (((Boolean) d51.b.h.getValue(r0, d51.b.a[6])).booleanValue() == true) goto L5;
        return;
    L5:
        b7 r1 = (b7) this._multiChannelData.getValue();
        if (r1 == null) goto L10;
        Map r2 = r1.getChannelMap();
        if (r2 == null) goto L10;
        Map r3 = MapsKt.toMap(r2);
    L11:
        b7 r4 = (b7) this._multiChannelData.getValue();
        if (r4 == null) goto L20;
        Map r5 = r4.getChannelMap();
        if (r5 == null) goto L18;
        Map r6 = MapsKt.toMutableMap(r5);
        if (r6 == null) goto L18;
        r6.remove(Long.valueOf(r7));
        Unit r8 = Unit.INSTANCE;
    L19:
        r4.setChannelMap(r6);
    L18:
        r6 = MapsKt.emptyMap();
    L20:
        if (r9 == false) goto L23;
        if (r4 == null) goto L23;
        r4.setChannelMap(new LinkedHashMap());
    L23:
        String r10 = TAG;
        StringBuilder r12 = new StringBuilder("onStopForward ");
        r12.append(r7);
        r12.append(" rtcForwardEmpty=");
        r12.append(r9);
        r12.append(", ");
        if (r3 == null) goto L26;
        Set r13 = r3.keySet();
    L27:
        r12.append(r13);
        r12.append(" -> ");
        if (r4 == null) goto L32;
        Map r14 = r4.getChannelMap();
        if (r14 == null) goto L32;
        Set r15 = r14.keySet();
    L33:
        r12.append(r15);
        jy0.b.f(r10, r12.toString(), null, 4);
        return;
    L32:
        r15 = null;
        goto L33
    L26:
        r13 = null;
    L10:
        r3 = null;
        goto L11
    }

    public static final /* synthetic */ b7 access$updateMultiChannelInfo(RevLinkMultiChannelDataContext r0, b7 r1, boolean r2) {
        return r0.updateMultiChannelInfo(r1, r2);
    }

    public static /* synthetic */ void onStopForward$default(RevLinkMultiChannelDataContext r0, long r1, boolean r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L5;
        r3 = false;
    L5:
        r0.onStopForward(r1, r3);
    }
}
