package com.bytedance.android.livesdk.interactivity.quickcomment;

import am2.x;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.utils.n3;
import com.bytedance.android.livesdk.event.ISendCommentEvent;
import com.bytedance.android.livesdk.event.d0;
import com.bytedance.android.livesdk.event.z;
import com.bytedance.android.livesdk.interactivity.api.comment.event.QuickCommentTypeEnum;
import com.bytedance.android.livesdk.interactivity.api.quickcomment.IQuickCommentShowWord;
import com.bytedance.android.livesdk.interactivity.api.quickcomment.OGCFixedCommentSyncData;
import com.bytedance.android.livesdk.interactivity.api.quickcomment.QuickCommentSyncData;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jc1.k;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 I2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001JB\u0017\u0012\u0006\u0010B\u001a\u00020A\u0012\u0006\u0010E\u001a\u00020D¢\u0006\u0004\bG\u0010HJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0012\u0010\f\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u000bH\u0002J\f\u0010\u000f\u001a\u00020\u000e*\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\u0006H\u0014J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u00152\u0006\u0010\u0014\u001a\u00020\u000eH\u0016J\b\u0010\u0017\u001a\u00020\u000eH\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u001a\u001a\u00020\u000eH\u0016J\b\u0010\u001b\u001a\u00020\u000eH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010\u001e\u001a\u00020\u0006H\u0016J\u0010\u0010!\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001fH\u0016J\b\u0010\"\u001a\u00020\u0006H\u0016R\u0018\u0010#\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010%\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010'\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R \u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00150)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020,0)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010+R\u001a\u00100\u001a\u00060.j\u0002`/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u001a\u00103\u001a\u00060.j\u0002`28\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00101R\u0014\u00105\u001a\u0002048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R&\u00108\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0015078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R \u0010<\u001a\b\u0012\u0004\u0012\u00020,078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b<\u00109\u001a\u0004\b=\u0010;R \u0010>\u001a\b\u0012\u0004\u0012\u00020\u001c0)8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b>\u0010+\u001a\u0004\b?\u0010@R\u0014\u0010B\u001a\u00020A8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u0014\u0010E\u001a\u00020D8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010F¨\u0006K"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/quickcomment/QuickCommentViewModel;", "Lcom/bytedance/android/livesdk/interactivity/api/quickcomment/f;", "Landroidx/lifecycle/ViewModel;", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/event/z;", "sendCommentResult", BuildConfig.FLAVOR, "onCommentSend", "Lcom/bytedance/android/livesdk/interactivity/api/quickcomment/g;", "syncData", "onQuickCommentSyncData", "Lcom/bytedance/android/livesdk/interactivity/api/quickcomment/d;", "onFixedCommentSyncData", "Lio/reactivex/disposables/Disposable;", BuildConfig.FLAVOR, "bindModel", "onCleared", "Lcom/bytedance/android/livesdk/interactivity/api/quickcomment/IQuickCommentShowWord;", "content", "sendQuickComment", "isPortrait", BuildConfig.FLAVOR, "getCurrentQuickComment", "isFixedComment", "Lcom/bytedance/android/livesdk/interactivity/api/quickcomment/c;", "getOGCFixedChatInfo", "isOGCFixedComment", "isOGCFixedCommentEmpty", BuildConfig.FLAVOR, "getFixCommentToast", "onLoginSuccess", "Lcom/bytedance/android/livesdk/interactivity/api/quickcomment/e;", "showEvent", "showQuickComment", "hideQuickComment", "curQuickChatSyncData", "Lcom/bytedance/android/livesdk/interactivity/api/quickcomment/g;", "curOGCFixedChatSyncData", "Lcom/bytedance/android/livesdk/interactivity/api/quickcomment/d;", "curQuickCommentShowEvent", "Lcom/bytedance/android/livesdk/interactivity/api/quickcomment/e;", "Lcom/bytedance/android/live/core/arch/mvvm/PropertyOwner;", "quickCommentsOwner", "Lcom/bytedance/android/live/core/arch/mvvm/PropertyOwner;", BuildConfig.FLAVOR, "quickCommentsTypeOwner", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/utils/TimestampMs;", "lastShowTime", "J", "Lcom/bytedance/android/livesdk/utils/TimeSpanSec;", "displayDuration", "Lio/reactivex/disposables/CompositeDisposable;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "Lcom/bytedance/android/live/core/arch/mvvm/d;", "quickComment", "Lcom/bytedance/android/live/core/arch/mvvm/d;", "getQuickComment", "()Lcom/bytedance/android/live/core/arch/mvvm/d;", "quickCommentType", "getQuickCommentType", "fixedCommentTips", "getFixedCommentTips", "()Lcom/bytedance/android/live/core/arch/mvvm/PropertyOwner;", "Lcom/bytedance/android/livesdk/chatroom/MiddlewareRoomContext;", "roomContext", "Lcom/bytedance/android/livesdk/chatroom/MiddlewareRoomContext;", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "<init>", "(Lcom/bytedance/android/livesdk/chatroom/MiddlewareRoomContext;Lcom/bytedance/ies/sdk/widgets/DataCenter;)V", "Companion", "d", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class QuickCommentViewModel extends ViewModel implements com.bytedance.android.livesdk.interactivity.api.quickcomment.f {
    public static final d Companion = null;
    public static final String TAG = "QuickCommentService";
    private final CompositeDisposable compositeDisposable;
    private com.bytedance.android.livesdk.interactivity.api.quickcomment.d curOGCFixedChatSyncData;
    private com.bytedance.android.livesdk.interactivity.api.quickcomment.g curQuickChatSyncData;
    private com.bytedance.android.livesdk.interactivity.api.quickcomment.e curQuickCommentShowEvent;
    private final DataCenter dataCenter;
    private long displayDuration;
    private final PropertyOwner<String> fixedCommentTips;
    private long lastShowTime;
    private final com.bytedance.android.live.core.arch.mvvm.d<List<IQuickCommentShowWord>> quickComment;
    private final com.bytedance.android.live.core.arch.mvvm.d<Integer> quickCommentType;
    private final PropertyOwner<List<IQuickCommentShowWord>> quickCommentsOwner;
    private final PropertyOwner<Integer> quickCommentsTypeOwner;
    private final MiddlewareRoomContext roomContext;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ QuickCommentViewModel a;

        public a(QuickCommentViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            QuickCommentViewModel r0 = this.a;
            QuickCommentViewModel.access$onQuickCommentSyncData(r0, (com.bytedance.android.livesdk.interactivity.api.quickcomment.g) r2);
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ QuickCommentViewModel a;

        public b(QuickCommentViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            QuickCommentViewModel r0 = this.a;
            QuickCommentViewModel.access$onFixedCommentSyncData(r0, (com.bytedance.android.livesdk.interactivity.api.quickcomment.d) r2);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ QuickCommentViewModel a;

        public c(QuickCommentViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            QuickCommentViewModel r0 = this.a;
            QuickCommentViewModel.access$onCommentSend(r0, (z) r2);
        }
    }

    public static final class d {
        public d() {
        }
    }

    static {
        Companion = new d();
    }

    public void onCleared() {
        this.curQuickChatSyncData = null;
        this.compositeDisposable.dispose();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.quickcomment.f
    public void onLoginSuccess() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.quickcomment.f
    public String getFixCommentToast() {
        com.bytedance.android.livesdk.interactivity.api.quickcomment.g r0 = this.curQuickChatSyncData;
        if (r0 == null) goto L7;
        String r1 = r0.fixCommentToast;
        if (r1 == null) goto L7;
        return r1;
    L7:
        return s1.B(2131916657);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.quickcomment.f
    public com.bytedance.android.livesdk.interactivity.api.quickcomment.c getOGCFixedChatInfo() {
        com.bytedance.android.livesdk.interactivity.api.quickcomment.d r0 = this.curOGCFixedChatSyncData;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.fixedChatInfo;
    }

    public void hideQuickComment() {
        com.bytedance.android.livesdk.interactivity.quickcomment.b.a("hideQuickComment");
        this.quickCommentsOwner.a(new ArrayList());
        PropertyOwner<Integer> r0 = this.quickCommentsTypeOwner;
        com.bytedance.android.livesdk.interactivity.api.quickcomment.e.a.getClass();
        r0.a(0);
        this.curQuickCommentShowEvent = null;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.quickcomment.f
    public boolean isFixedComment() {
        com.bytedance.android.livesdk.interactivity.api.quickcomment.g r0 = this.curQuickChatSyncData;
        if (r0 == null) goto L6;
        int r1 = r0.commentType;
        com.bytedance.android.livesdk.interactivity.api.quickcomment.e.a.getClass();
        if (r1 != 2) goto L6;
        return true;
    L6:
        com.bytedance.android.livesdk.interactivity.api.quickcomment.d r2 = this.curOGCFixedChatSyncData;
        if (r2 == null) goto L13;
        com.bytedance.android.livesdk.interactivity.api.quickcomment.b r3 = r2.fastChatInfo;
        if (r3 == null) goto L13;
        if (r3.fastChatSwitch != true) goto L13;
        return true;
    L13:
        return false;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.quickcomment.f
    public boolean isOGCFixedComment() {
        com.bytedance.android.livesdk.interactivity.api.quickcomment.d r0 = this.curOGCFixedChatSyncData;
        if (r0 == null) goto L9;
        com.bytedance.android.livesdk.interactivity.api.quickcomment.b r1 = r0.fastChatInfo;
        if (r1 == null) goto L9;
        if (r1.fastChatSwitch != true) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.quickcomment.f
    public boolean isOGCFixedCommentEmpty() {
        com.bytedance.android.livesdk.interactivity.api.quickcomment.d r0 = this.curOGCFixedChatSyncData;
        if (r0 == null) goto L9;
        com.bytedance.android.livesdk.interactivity.api.quickcomment.c r1 = r0.fixedChatInfo;
        if (r1 == null) goto L9;
        List<String> r2 = r1.fixedChatList;
        if (r2 == null) goto L9;
        return r2.isEmpty();
    L9:
        return true;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.quickcomment.f
    /* JADX INFO: renamed from: getFixedCommentTips, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ com.bytedance.android.live.core.arch.mvvm.d mo904getFixedCommentTips() {
        return getFixedCommentTips();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.quickcomment.f
    public com.bytedance.android.live.core.arch.mvvm.d<List<IQuickCommentShowWord>> getQuickComment() {
        return this.quickComment;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.quickcomment.f
    public com.bytedance.android.live.core.arch.mvvm.d<Integer> getQuickCommentType() {
        return this.quickCommentType;
    }

    public PropertyOwner<String> getFixedCommentTips() {
        return this.fixedCommentTips;
    }

    private final boolean bindModel(Disposable r2) {
        return this.compositeDisposable.add(r2);
    }

    private final void onCommentSend(z r6) {
        IRoomContextService r0 = k.f(IRoomContextService.class);
        Object r1 = null;
        if (r0 == null) goto L11;
        o r2 = r0.getRoomDataContext(this.roomContext);
        if (r2 == null) goto L11;
        m r3 = r2.getRoom();
        if (r3 == null) goto L11;
        IRoom r4 = (IRoom) r3.getValue();
        if (r4 == null) goto L11;
        IRoomAuthStatus r5 = r4.getRoomAuthStatus();
    L13:
        if (com.bytedance.android.livesdk.interactivity.service.model.b.b(r5) == false) goto L32;
        if (r6.b == false) goto L32;
        ISendCommentEvent r7 = r6.a;
        if ((r7 instanceof d0) == true) goto L19;
        r7 = null;
    L19:
        d0 r8 = (d0) r7;
        if (r8 == null) goto L56;
        Iterator r9 = ((Iterable) this.quickCommentsOwner.a).iterator();
    L23:
        if (r9.hasNext() == false) goto L28;
        Object r10 = r9.next();
        if (Intrinsics.areEqual(((IQuickCommentShowWord) r10).getContent(), r8.a) == false) goto L23;
        r1 = r10;
    L28:
        if (((IQuickCommentShowWord) r1) == null) goto L57;
        com.bytedance.android.livesdk.interactivity.quickcomment.b.a("onCommentSend Hide Quick Comment cuz OGC FixedComment");
        hideQuickComment();
        return;
    L57:
        return;
    L56:
        return;
    L32:
        if (isFixedComment() == false) goto L34;
        return;
    L34:
        if (r6.b == false) goto L59;
        ISendCommentEvent r11 = r6.a;
        if ((r11 instanceof d0) == true) goto L38;
        r11 = null;
    L38:
        d0 r13 = (d0) r11;
        if (r13 == null) goto L60;
        Iterator r14 = ((Iterable) this.quickCommentsOwner.a).iterator();
    L42:
        if (r14.hasNext() == false) goto L47;
        Object r15 = r14.next();
        if (Intrinsics.areEqual(((IQuickCommentShowWord) r15).getContent(), r13.a) == false) goto L42;
        r1 = r15;
    L47:
        if (((IQuickCommentShowWord) r1) == null) goto L61;
        com.bytedance.android.livesdk.interactivity.quickcomment.b.a("onCommentSend Hide Quick Comment");
        hideQuickComment();
        return;
    L61:
        return;
    L60:
        return;
    L59:
        return;
    L11:
        r5 = null;
        goto L13
    }

    private final void onFixedCommentSyncData(com.bytedance.android.livesdk.interactivity.api.quickcomment.d r5) {
        StringBuilder r0 = new StringBuilder("Receive OGC FixedCommentSyncData, Switch:");
        if (r5 == null) goto L7;
        com.bytedance.android.livesdk.interactivity.api.quickcomment.b r2 = r5.fastChatInfo;
        if (r2 == null) goto L7;
        Boolean r3 = Boolean.valueOf(r2.fastChatSwitch);
    L8:
        r0.append(r3);
        com.bytedance.android.livesdk.interactivity.quickcomment.b.a(r0.toString());
        if (r5 != null) goto L11;
        return;
    L11:
        com.bytedance.android.livesdk.interactivity.quickcomment.c r1 = new com.bytedance.android.livesdk.interactivity.quickcomment.c(r5, this.dataCenter);
        if (CollectionUtils.isEmpty(r1.b) == true) goto L58;
        com.bytedance.android.livesdk.interactivity.api.quickcomment.b r4 = r5.fastChatInfo;
        if (r4 != null) goto L16;
    L18:
        int r6 = n52.a.a;
        if (r1.c >= 0) goto L21;
    L56:
        com.bytedance.android.livesdk.interactivity.quickcomment.b.a("hide OGC FixedCommentSyncData duration Error Or Words Empty");
        return;
    L21:
        if (((ArrayList) r1.b).isEmpty() == true) goto L56;
        IRoomContextService r7 = k.f(IRoomContextService.class);
        if (r7 == null) goto L37;
        o r8 = r7.getRoomDataContext(this.roomContext);
        if (r8 == null) goto L37;
        m r9 = r8.getRoom();
        if (r9 == null) goto L37;
        IRoom r10 = (IRoom) r9.getValue();
        if (r10 == null) goto L37;
        IRoomAuthStatus r11 = r10.getRoomAuthStatus();
        if (r11 == null) goto L37;
        if (r11.getEnableChat() == true) goto L37;
        com.bytedance.android.livesdk.interactivity.quickcomment.b.a("hide OGC FixedCommentSyncData cuz RoomAuth Chat disable");
        return;
    L37:
        IRoomContextService r13 = k.f(IRoomContextService.class);
        if (r13 == null) goto L46;
        o r14 = r13.getRoomDataContext(this.roomContext);
        if (r14 == null) goto L46;
        m r15 = r14.getRoom();
        if (r15 == null) goto L46;
        IRoom r16 = (IRoom) r15.getValue();
        if (r16 == null) goto L46;
        IRoomAuthStatus r17 = r16.getRoomAuthStatus();
    L48:
        if (com.bytedance.android.livesdk.interactivity.service.model.b.b(r17) == true) goto L51;
        com.bytedance.android.livesdk.interactivity.quickcomment.b.a("hide OGC FixedCommentSyncData cuz RoomAuth fixedChat disable");
        this.curOGCFixedChatSyncData = null;
        hideQuickComment();
        return;
    L51:
        this.curOGCFixedChatSyncData = r5;
        PropertyOwner<Integer> r18 = this.quickCommentsTypeOwner;
        com.bytedance.android.livesdk.interactivity.api.quickcomment.e.a.getClass();
        r18.a(3);
        PropertyOwner<String> r19 = getFixedCommentTips();
        String r20 = r5.hint;
        if (r20 != null) goto L54;
        r20 = s1.B(2131916656);
    L54:
        r19.a(r20);
        showQuickComment(r1);
        this.dataCenter.put("fixed_comment_emoji_data_loaded", Boolean.TRUE);
        return;
    L46:
        r17 = null;
        goto L48
    L16:
        if (r4.fastChatSwitch == true) goto L18;
    L58:
        com.bytedance.android.livesdk.interactivity.quickcomment.b.a("hideQuickComment cuz OGC FixedCommentSyncData Words Empty or Switch False");
        this.curOGCFixedChatSyncData = null;
        hideQuickComment();
        return;
    L7:
        r3 = null;
        goto L8
    }

    private final void onQuickCommentSyncData(com.bytedance.android.livesdk.interactivity.api.quickcomment.g r6) {
        StringBuilder r0 = new StringBuilder("Receive QuickCommentSyncData, Type:");
        if (r6 == null) goto L5;
        Integer r2 = Integer.valueOf(r6.commentType);
    L6:
        r0.append(r2);
        r0.append(" Switch:");
        if (r6 == null) goto L9;
        Boolean r3 = Boolean.valueOf(r6.fastChatSwitch);
    L10:
        r0.append(r3);
        com.bytedance.android.livesdk.interactivity.quickcomment.b.a(r0.toString());
        if (r6 != null) goto L13;
        return;
    L13:
        com.bytedance.android.livesdk.interactivity.quickcomment.d r1 = new com.bytedance.android.livesdk.interactivity.quickcomment.d(r6);
        if (CollectionUtils.isEmpty(r1.b) == true) goto L45;
        int r4 = r1.getType();
        com.bytedance.android.livesdk.interactivity.api.quickcomment.e.a.getClass();
        if (r4 != 1) goto L21;
        if (r6.fastChatSwitch == false) goto L45;
    L21:
        if (r1.getType() != 1) goto L25;
        if (n52.b.a == false) goto L25;
    L28:
        if (r1.c >= 0) goto L30;
    L41:
        com.bytedance.android.livesdk.interactivity.quickcomment.b.a("hideQuickComment duration Error Or Words Empty");
        return;
    L30:
        if (((ArrayList) r1.b).isEmpty() == true) goto L41;
        this.curQuickChatSyncData = r6;
        if (r6.commentType != 2) goto L38;
        PropertyOwner<String> r5 = getFixedCommentTips();
        String r7 = r6.commentTips;
        if (r7 != null) goto L37;
        r7 = s1.B(2131916656);
    L37:
        r5.a(r7);
    L39:
        showQuickComment(r1);
        return;
    L38:
        getFixedCommentTips().a(BuildConfig.FLAVOR);
    L25:
        if (r1.getType() != 2) goto L43;
        int r8 = n52.a.a;
        goto L28
    L43:
        com.bytedance.android.livesdk.interactivity.quickcomment.b.a("Do Not Show Quick Comment Cause By SettingKeys");
        return;
    L45:
        com.bytedance.android.livesdk.interactivity.quickcomment.b.a("hideQuickComment Words Empty or Switch False");
        this.curQuickChatSyncData = null;
        getFixedCommentTips().a(BuildConfig.FLAVOR);
        hideQuickComment();
        return;
    L9:
        r3 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.quickcomment.f
    public List<IQuickCommentShowWord> getCurrentQuickComment(boolean r3) {
        com.bytedance.android.livesdk.interactivity.quickcomment.b.a("getCurrentQuickComment, isFixed:" + isFixedComment() + ", isPortrait" + r3);
        if (isFixedComment() == true) goto L9;
        if (r3 == true) goto L9;
        return CollectionsKt.emptyList();
    L9:
        return (List) getQuickComment().getValue();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.quickcomment.f
    public void sendQuickComment(IQuickCommentShowWord r8) {
        Intrinsics.checkNotNullParameter(r8, "content");
        o42.f r0 = new o42.f(r8.getContent());
        int r1 = r8.getSource();
        com.bytedance.android.livesdk.interactivity.api.quickcomment.e.a r2 = com.bytedance.android.livesdk.interactivity.api.quickcomment.e.a;
        r2.getClass();
        boolean r3 = false;
        if (r1 != 1) goto L5;
        boolean r4 = true;
    L7:
        if (r4 == false) goto L9;
        o42.f r5 = r0;
    L10:
        if (r5 == null) goto L12;
        r5.b = QuickCommentTypeEnum.QUICK_COMMENT_MATCH;
    L12:
        int r6 = r8.getSource();
        r2.getClass();
        if (r6 != 3) goto L15;
        r3 = true;
    L15:
        if (r3 == false) goto L17;
        o42.f r7 = r0;
    L18:
        if (r7 == null) goto L20;
        r7.b = QuickCommentTypeEnum.QUICK_COMMENT_OGC_FIXED;
    L20:
        this.dataCenter.put("cmd_do_send_message", r0);
        int r9 = r8.getSource();
        r2.getClass();
        if (r9 != 1) goto L24;
        this.curQuickChatSyncData = null;
        hideQuickComment();
        return;
    L24:
        return;
    L17:
        r7 = null;
        goto L18
    L9:
        r5 = null;
        goto L10
    L5:
        r4 = false;
        goto L7
    }

    public void showQuickComment(com.bytedance.android.livesdk.interactivity.api.quickcomment.e r7) {
        Intrinsics.checkNotNullParameter(r7, "showEvent");
        com.bytedance.android.livesdk.interactivity.quickcomment.b.a("showQuickComment");
        this.curQuickCommentShowEvent = r7;
        this.displayDuration = r7.getDuration();
        this.lastShowTime = System.currentTimeMillis();
        this.quickCommentsOwner.a(r7.a());
        this.quickCommentsTypeOwner.a(Integer.valueOf(r7.getType()));
        Intrinsics.checkNotNullParameter(r7, "showEvent");
        int r0 = r7.getType();
        com.bytedance.android.livesdk.interactivity.api.quickcomment.e.a.getClass();
        if (r0 != 1) goto L5;
    L6:
        List<IQuickCommentShowWord> r8 = r7.a();
        if (r8 == null) goto L14;
        Iterator<T> r9 = r8.iterator();
    L10:
        if (r9.hasNext() == false) goto L15;
        j0.l().sendLog("livesdk_live_hot_message_sample_show", MapsKt.mapOf(TuplesKt.to("prompt", ((IQuickCommentShowWord) r9.next()).getContent())), new Object[]{IRoom.class, x.class});
        goto L10
    L15:
        return;
    L14:
        return;
    L5:
        if (r0 == 3) goto L6;
    }

    public QuickCommentViewModel(MiddlewareRoomContext r4, DataCenter r5) {
        Intrinsics.checkNotNullParameter(r4, "roomContext");
        Intrinsics.checkNotNullParameter(r5, "dataCenter");
        this.roomContext = r4;
        this.dataCenter = r5;
        PropertyOwner<List<IQuickCommentShowWord>> r6 = new PropertyOwner(new ArrayList());
        this.quickCommentsOwner = r6;
        com.bytedance.android.livesdk.interactivity.api.quickcomment.e.a.getClass();
        PropertyOwner<Integer> r0 = new PropertyOwner(0);
        this.quickCommentsTypeOwner = r0;
        this.displayDuration = n52.b.b;
        this.compositeDisposable = new CompositeDisposable();
        ylc.e r7 = n3.g(r4);
        Disposable r1 = ((QuickCommentSyncData) dc2.b.a(r7, AnonymousClass1.INSTANCE)).getQuickCommentData().d.subscribe(new a(this));
        if (r1 == null) goto L5;
        bindModel(r1);
    L5:
        Disposable r8 = ((OGCFixedCommentSyncData) dc2.b.a(r7, AnonymousClass3.INSTANCE)).getFixedCommentData().d.subscribe(new b(this));
        if (r8 == null) goto L8;
        bindModel(r8);
    L8:
        bindModel(xs2.b.a().b(z.class).subscribe(new c(this)));
        this.quickComment = r6;
        this.quickCommentType = r0;
        this.fixedCommentTips = new PropertyOwner(BuildConfig.FLAVOR);
    }

    public static final /* synthetic */ void access$onCommentSend(QuickCommentViewModel r0, z r1) {
        r0.onCommentSend(r1);
    }

    public static final /* synthetic */ void access$onFixedCommentSyncData(QuickCommentViewModel r0, com.bytedance.android.livesdk.interactivity.api.quickcomment.d r1) {
        r0.onFixedCommentSyncData(r1);
    }

    public static final /* synthetic */ void access$onQuickCommentSyncData(QuickCommentViewModel r0, com.bytedance.android.livesdk.interactivity.api.quickcomment.g r1) {
        r0.onQuickCommentSyncData(r1);
    }
}
