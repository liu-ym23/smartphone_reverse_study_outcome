package com.larus.collection.impl;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import com.collection.profile.api.ICollectService;
import com.larus.bmhome.chat.model.repo.ConversationRepo;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.common.apphost.AppHost;
import com.larus.feedback.api.FlowFeedbackServiceDelegate;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MsgFeedbackType;
import com.larus.minor.api.IMinorService;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.y;
import com.larus.platform.api.y0;
import com.larus.platform.model.CancelCollectionResponse;
import com.larus.platform.model.CollectionType;
import com.larus.platform.model.SaveCollectionResponse;
import com.larus.platform.service.i3;
import com.larus.platform.service.z2;
import com.larus.profile.api.IProfileApi;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.j;
import org.json.JSONArray;
import org.json.JSONObject;
import t19.s;
import wc9.e;
import yc9.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u0000 -2\u00020\u0001:\u0001-B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J,\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\b\u0001\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0096@¢\u0006\u0002\u0010\u0013J\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0096@¢\u0006\u0002\u0010\u0018J\u001c\u0010\u0019\u001a\u00020\t2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0096@¢\u0006\u0002\u0010\u001bJ\u0016\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001eH\u0082@¢\u0006\u0002\u0010\u001fJ$\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00150\f2\u0006\u0010!\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010\"J\b\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0006H\u0016J\u0010\u0010(\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0006H\u0016J\n\u0010)\u001a\u0004\u0018\u00010\u0006H\u0016J\n\u0010*\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010+\u001a\u00020&H\u0016J\b\u0010,\u001a\u00020&H\u0016R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/larus/collection/impl/CollectImpl;", "Lcom/collection/profile/api/ICollectService;", "<init>", "()V", "weakCollectFragmentReference", "Ljava/lang/ref/WeakReference;", "Lcom/larus/platform/api/IMineCollectFragment;", "weakLikeRevisitFragmentReference", "collectionEnable", "", "collectionBaseConstraint", "collectMessage", "Lcom/larus/network/http/Async;", "Lcom/larus/platform/model/SaveCollectionResponse;", "collectionType", "", "messages", "", "Lcom/larus/im/bean/message/Message;", "(ILjava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelCollect", "Lcom/larus/platform/model/CancelCollectionResponse;", "collectionId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelLikeMultiMessages", "messageList", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "submitMessageFeedback", "fbRequest", "Lcom/larus/im/bean/message/FeedbackMessageRequest;", "(Lcom/larus/im/bean/message/FeedbackMessageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelMessageCollect", "message", "(Lcom/larus/im/bean/message/Message;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collectFragment", "Landroidx/fragment/app/Fragment;", "updateFragment", "", "fragment", "updateLikeRevisitFragment", "getCurrentCollectFragment", "getCurrentLikeRevisitFragment", "refreshCollectFragment", "refreshLikeRevisitFragment", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CollectImpl implements ICollectService {
    public WeakReference<y0> a;
    public WeakReference<y0> b;

    public static final class a {
    }

    static {
    }

    public CollectImpl() {
    }

    public final boolean a() {
        if (z2.a.collectEnable() == true) goto L5;
    L7:
        return false;
    L5:
        if (k() == false) goto L7;
        return true;
    }

    public final y0 b() {
        WeakReference<y0> r0 = this.a;
        if (r0 == null) goto L5;
        y0 r1 = r0.get();
    L7:
        if ((r1 instanceof Fragment) == false) goto L19;
        Fragment r2 = (Fragment) r1;
        if (r2.isAdded() == true) goto L11;
    L15:
        boolean r3 = false;
    L16:
        if (r3 == true) goto L19;
        FLogger.a.i("CollectImpl", "getCurrentCollectFragment, ignore unavailable fragment=" + r1);
        return null;
    L11:
        if (r2.isDetached() == true) goto L15;
        if (r2.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) goto L15;
        r3 = true;
    L19:
        FLogger.a.i("CollectImpl", "getCurrentCollectFragment, fragment=" + r1);
        return r1;
    L5:
        r1 = null;
        goto L7
    }

    public final y0 h() {
        WeakReference<y0> r0 = this.b;
        if (r0 == null) goto L5;
        y0 r1 = r0.get();
    L6:
        FLogger.a.i("CollectImpl", "getCurrentLikeRevisitFragment, fragment=" + r1);
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    public final void j() {
        WeakReference<y0> r0 = this.b;
        if (r0 == null) goto L8;
        y0 r1 = r0.get();
        if (r1 == null) goto L9;
        r1.w10();
        return;
    L9:
        return;
    }

    public final boolean k() {
        boolean r0 = i3.a.f();
        boolean r1 = IMinorService.a.a();
        if (r0 == true) goto L6;
        if (r1 == true) goto L6;
        return true;
    L6:
        return false;
    }

    public final void c(y0 r4) {
        Intrinsics.checkNotNullParameter(r4, "fragment");
        FLogger.a.i("CollectImpl", "updateFragment, fragment=" + r4);
        this.a = new WeakReference(r4);
    }

    public final void d(y0 r4) {
        Intrinsics.checkNotNullParameter(r4, "fragment");
        FLogger.a.i("CollectImpl", "updateLikeRevisitFragment, fragment=" + r4);
        this.b = new WeakReference(r4);
    }

    public final Object e(String r14, Continuation<? super com.larus.network.http.a<CancelCollectionResponse>> r15) {
        if ((r15 instanceof CollectImpl$cancelCollect$1) == false) goto L7;
        CollectImpl$cancelCollect$1 r0 = (CollectImpl$cancelCollect$1) r15;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        CollectImpl$cancelCollect$1 r11 = r0;
        Object r16 = r11.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r11.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r14 = (String) r11.L$0;
        ResultKt.throwOnFailure(r16);
    L17:
        com.larus.network.http.a r17 = (com.larus.network.http.a) r16;
        if ((r17 instanceof y) == false) goto L23;
        y0 r4 = b();
        if (r4 == null) goto L22;
        r4.Of(r14);
    L22:
        IProfileApi.a.j().postValue(Boxing.boxBoolean(false));
    L23:
        return r17;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r16);
        FLogger.a.i("CollectImpl", "cancelCollect, collectionId=" + r14);
        JSONObject r5 = new JSONObject();
        r5.put("collection_id", r14);
        Unit r6 = Unit.INSTANCE;
        r11.L$0 = r14;
        r11.label = 1;
        r16 = HttpExtKt.k("Social", CancelCollectionResponse.class, "/profile/collection/cancel/collection/", r5, null, null, true, null, null, null, r11, 944);
        if (r16 != r2) goto L17;
        return r2;
    L7:
        r0 = new CollectImpl$cancelCollect$1(this, r15);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x01ac -> B:61:0x01b0). Please report as a decompilation issue!!! */
    public final Object i(List<Message> r35, Continuation<? super Boolean> r36) {
        if ((r36 instanceof CollectImpl$cancelLikeMultiMessages$1) == false) goto L7;
        CollectImpl$cancelLikeMultiMessages$1 r1 = (CollectImpl$cancelLikeMultiMessages$1) r36;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r0 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        int r7 = 1;
        if (r4 == 0) goto L16;
        if (r4 == 1) goto L15;
        if (r4 != 2) goto L14;
        Message r5 = (Message) r1.L$2;
        Iterator r10 = (Iterator) r1.L$1;
        Ref.BooleanRef r11 = (Ref.BooleanRef) r1.L$0;
        ResultKt.throwOnFailure(r0);
        String r14 = "";
        String r15 = "CollectImpl";
        Iterator r6 = r10;
        Ref.BooleanRef r8 = r11;
    L61:
        boolean r9 = ((Boolean) r0).booleanValue();
        if (r9 == true) goto L65;
        FLogger.a.i(r15, "cancelLikeFromRevisit fail, messageId=" + r5.getMessageId());
    L65:
        if (r8.element == false) goto L68;
        if (r9 == false) goto L68;
        boolean r12 = true;
    L69:
        r8.element = r12;
        Iterator r13 = r6;
        Ref.BooleanRef r16 = r8;
        r7 = 1;
    L28:
        if (r13.hasNext() == false) goto L71;
        Message r17 = (Message) r13.next();
        String r18 = r17.getConversationId();
        if (r18 != null) goto L32;
        String r19 = r14;
    L33:
        RepoDispatcher.a.getClass();
        ConversationRepo r20 = RepoDispatcher.f;
        r1.L$0 = r16;
        r1.L$1 = r13;
        r1.L$2 = r17;
        r1.L$3 = r19;
        r1.label = r7;
        String r110 = r19;
        Object r21 = IConversationRepoService.a.c(r20, r19, false, null, r1, 6);
        if (r21 != r3) goto L36;
        return r3;
    L36:
        String r23 = r14;
        String r24 = r15;
        String r22 = r110;
        Ref.BooleanRef r111 = r16;
        Iterator r112 = r13;
        r0 = r21;
        r5 = r17;
    L37:
        e r25 = (e) r0;
        if (r25 == null) goto L50;
        Integer r26 = r25.j;
        if (r26 == null) goto L50;
        if (r26.intValue() != 0) goto L44;
        boolean r27 = true;
    L45:
        if (r27 == false) goto L48;
        r26 = null;
    L48:
        if (r26 == null) goto L50;
        int r28 = r26.intValue();
    L51:
        String r29 = r5.getMessageId();
        if (r29 != null) goto L54;
        String r113 = r23;
    L55:
        r8 = r111;
        r6 = r112;
        m r114 = new m(r22, r113, MsgFeedbackType.MsgFeedbackTypeDefault, 0, null, null, null, null, null, null, Boxing.boxInt(r28), true, null, 5112);
        r1.L$0 = r8;
        r1.L$1 = r6;
        r1.L$2 = r5;
        r1.L$3 = null;
        r1.label = 2;
        j r30 = new j(IntrinsicsKt.intercepted(r1), 1);
        r30.C();
        FlowFeedbackServiceDelegate.a.g(new q99.m(r114, null, null, null, null, null, null, 126), new com.larus.collection.impl.a(r114, r30));
        r0 = r30.B();
        if (r0 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L58;
        DebugProbesKt.probeCoroutineSuspended(r1);
    L58:
        if (r0 != r3) goto L60;
        return r3;
    L60:
        r14 = r23;
        r15 = r24;
        goto L61
    L54:
        r113 = r29;
        goto L55
    L44:
        r27 = false;
    L50:
        r28 = 3;
        goto L51
    L32:
        r19 = r18;
        goto L33
    L71:
        return Boxing.boxBoolean(r16.element);
    L68:
        r12 = false;
        goto L69
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        String r31 = (String) r1.L$3;
        Message r115 = (Message) r1.L$2;
        Iterator r116 = (Iterator) r1.L$1;
        Ref.BooleanRef r117 = (Ref.BooleanRef) r1.L$0;
        ResultKt.throwOnFailure(r0);
        r23 = "";
        r24 = "CollectImpl";
        r112 = r116;
        r111 = r117;
        r22 = r31;
        r5 = r115;
        goto L37
    L16:
        ResultKt.throwOnFailure(r0);
        if (r35.isEmpty() == false) goto L20;
        FLogger.a.w("CollectImpl", "cancelLikeFromRevisit, messageList is empty");
        return Boxing.boxBoolean(false);
    L20:
        r16 = new Ref.BooleanRef();
        r16.element = true;
        ArrayList r118 = new ArrayList();
        Iterator<T> r32 = r35.iterator();
    L22:
        if (r32.hasNext() == false) goto L26;
        Object r119 = r32.next();
        if (o0.d(((Message) r119).getMessageId()) == false) goto L22;
        r118.add(r119);
        goto L22
    L26:
        r13 = r118.iterator();
        r14 = "";
        r15 = "CollectImpl";
    L7:
        r1 = new CollectImpl$cancelLikeMultiMessages$1(this, r36);
        goto L8
    }

    public final Object f(@CollectionType int r18, List<Message> r19, Continuation<? super com.larus.network.http.a<SaveCollectionResponse>> r20) {
        if ((r20 instanceof CollectImpl$collectMessage$1) == false) goto L7;
        CollectImpl$collectMessage$1 r3 = (CollectImpl$collectMessage$1) r20;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        CollectImpl$collectMessage$1 r15 = r3;
        Object r2 = r15.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r15.label;
        if (r6 == 0) goto L14;
        if (r6 != 1) goto L13;
        ResultKt.throwOnFailure(r2);
        boolean r1 = true;
    L21:
        com.larus.network.http.a r7 = (com.larus.network.http.a) r2;
        if ((r7 instanceof y) == false) goto L27;
        y0 r0 = b();
        if (r0 == null) goto L26;
        r0.Of(null);
    L26:
        IProfileApi.a.j().postValue(Boxing.boxBoolean(r1));
    L27:
        return r7;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r2);
        FLogger.a.i("CollectImpl", "collectMessage, collectionType=" + r18 + ", messages=" + r19);
        JSONObject r8 = new JSONObject();
        r8.put("collection_type", r18);
        List<Message> r9 = r19;
        ArrayList r10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator<T> r11 = r9.iterator();
    L16:
        if (r11.hasNext() == false) goto L18;
        Message r12 = (Message) r11.next();
        JSONObject r13 = new JSONObject();
        r13.put(MusicAppletPage.KEY_MESSAGE_ID, r12.getMessageId());
        r10.add(r13);
        goto L16
    L18:
        r8.put("detail_list", new JSONArray(r10));
        Unit r14 = Unit.INSTANCE;
        r15.label = 1;
        r1 = true;
        r2 = HttpExtKt.k("Social", SaveCollectionResponse.class, "/profile/collection/save/collection/", r8, null, null, true, null, null, null, r15, 944);
        if (r2 != r5) goto L21;
        return r5;
    L7:
        r3 = new CollectImpl$collectMessage$1(this, r20);
        goto L8
    }

    public final Object g(Message r16, int r17, Continuation<? super com.larus.network.http.a<CancelCollectionResponse>> r18) {
        if ((r18 instanceof CollectImpl$cancelMessageCollect$1) == false) goto L7;
        CollectImpl$cancelMessageCollect$1 r1 = (CollectImpl$cancelMessageCollect$1) r18;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        CollectImpl$cancelMessageCollect$1 r13 = r1;
        Object r0 = r13.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r13.label;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        ResultKt.throwOnFailure(r0);
    L17:
        y r5 = (com.larus.network.http.a) r0;
        if ((r5 instanceof y) == false) goto L29;
        y0 r6 = b();
        if (r6 == null) goto L26;
        CancelCollectionResponse r7 = (CancelCollectionResponse) ((com.larus.network.http.a) r5).b;
        if (r7 == null) goto L24;
        String r8 = r7.getCollectionId();
    L25:
        r6.Of(r8);
        goto L26
    L24:
        r8 = null;
    L26:
        IProfileApi.a.j().postValue(Boxing.boxBoolean(false));
        Activity r9 = AppHost.a.a().getCurrentActivity();
        if (r9 == null) goto L29;
        s.a.g(r9, 2131910858, false);
    L29:
        return r5;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        FLogger.a.i("CollectImpl", "cancelMessageCollect, message");
        JSONObject r10 = new JSONObject();
        r10.put("reference_id", r16.getMessageId());
        r10.put("collection_type", r17);
        Unit r11 = Unit.INSTANCE;
        r13.label = 1;
        r0 = HttpExtKt.k("Social", CancelCollectionResponse.class, "/profile/collection/cancel/collection/", r10, null, null, true, null, null, null, r13, 944);
        if (r0 != r3) goto L17;
        return r3;
    L7:
        r1 = new CollectImpl$cancelMessageCollect$1(this, r18);
        goto L8
    }
}
